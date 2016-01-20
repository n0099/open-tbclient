package com.baidu.tieba.write.album;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.img.ImageFileInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class h {
    private final String dSn = TbConfig.getTempDirName();
    private a dSo;
    private c dSp;
    private final Context mContext;

    /* loaded from: classes.dex */
    public interface b {
        void bZ(List<ImageFileInfo> list);
    }

    public h(Context context) {
        this.mContext = context;
    }

    public boolean a(n nVar) {
        if (nVar == null) {
            return false;
        }
        aJT();
        this.dSo = new a(nVar);
        this.dSo.setPriority(3);
        this.dSo.execute(new Object[0]);
        return true;
    }

    public boolean a(String str, ap apVar) {
        if (apVar == null) {
            return false;
        }
        aJU();
        this.dSp = new c(str, apVar);
        this.dSp.setPriority(3);
        this.dSp.execute(new Void[0]);
        return true;
    }

    public void aJT() {
        if (this.dSo != null) {
            this.dSo.cancel();
            this.dSo = null;
        }
    }

    public void aJU() {
        if (this.dSp != null) {
            this.dSp.cancel();
            this.dSp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, List<d>> {
        private final n dSq;

        public a(n nVar) {
            this.dSq = nVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public List<d> doInBackground(Object... objArr) {
            return h.this.aJV();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.dSq != null) {
                this.dSq.mZ();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public void onPostExecute(List<d> list) {
            super.onPostExecute(list);
            if (this.dSq != null) {
                this.dSq.ca(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<d> aJV() {
        HashSet<String> hashSet = new HashSet<>();
        return a(this.mContext, a(this.mContext, null, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, hashSet), MediaStore.Images.Media.INTERNAL_CONTENT_URI, hashSet);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x010e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [android.database.Cursor] */
    private List<d> a(Context context, List<d> list, Uri uri, HashSet<String> hashSet) {
        Cursor cursor;
        File[] listFiles;
        Matcher matcher;
        if (context == null) {
            return null;
        }
        Pattern compile = Pattern.compile("image\\/\\w+", 2);
        if (list == null) {
            list = new ArrayList<>();
        }
        ?? r2 = "count(*)";
        try {
            try {
                cursor = context.getContentResolver().query(uri, new String[]{"bucket_id", "bucket_display_name", "_data", "count(*)"}, "mime_type like 'image/%') GROUP BY 1,(2", null, "date_added DESC");
                try {
                    if (cursor.moveToFirst()) {
                        int columnIndex = cursor.getColumnIndex("bucket_id");
                        int columnIndex2 = cursor.getColumnIndex("bucket_display_name");
                        int columnIndex3 = cursor.getColumnIndex("_data");
                        int columnIndex4 = cursor.getColumnIndex("count(*)");
                        do {
                            String string = cursor.getString(columnIndex);
                            String string2 = cursor.getString(columnIndex2);
                            String string3 = cursor.getString(columnIndex3);
                            cursor.getString(columnIndex4);
                            int i = 0;
                            String substring = string3.substring(0, string3.lastIndexOf("/"));
                            if (hashSet != null) {
                                if (!hashSet.contains(substring)) {
                                    hashSet.add(substring);
                                }
                            }
                            File file = new File(substring);
                            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                                for (File file2 : listFiles) {
                                    String nj = nj(file2.getAbsolutePath());
                                    if (nj != null && (matcher = compile.matcher(nj)) != null && matcher.matches()) {
                                        i++;
                                    }
                                }
                            }
                            if (i != 0) {
                                String sb = new StringBuilder(String.valueOf(i)).toString();
                                d dVar = new d();
                                dVar.nh(string);
                                dVar.ni(sb);
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                imageFileInfo.setFilePath(string3);
                                dVar.d(imageFileInfo);
                                dVar.setName(string2);
                                if (string2 != null && string2.equals(this.dSn)) {
                                    list.add(0, dVar);
                                } else {
                                    list.add(dVar);
                                }
                            }
                        } while (cursor.moveToNext());
                        com.baidu.adp.lib.h.a.b(cursor);
                        return list;
                    }
                    com.baidu.adp.lib.h.a.b(cursor);
                    return list;
                } catch (Exception e) {
                    e = e;
                    BdLog.detailException(e);
                    com.baidu.adp.lib.h.a.b(cursor);
                    return list;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.h.a.b((Cursor) r2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            r2 = 0;
            com.baidu.adp.lib.h.a.b((Cursor) r2);
            throw th;
        }
    }

    public String nj(String str) {
        String fileExtensionFromUrl = getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl == null) {
            return null;
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl.toLowerCase(Locale.getDefault()));
    }

    private String getFileExtensionFromUrl(String str) {
        int lastIndexOf;
        if (!TextUtils.isEmpty(str)) {
            int lastIndexOf2 = str.lastIndexOf(35);
            if (lastIndexOf2 > 0) {
                str = str.substring(0, lastIndexOf2);
            }
            int lastIndexOf3 = str.lastIndexOf(63);
            if (lastIndexOf3 > 0) {
                str = str.substring(0, lastIndexOf3);
            }
            int lastIndexOf4 = str.lastIndexOf(47);
            if (lastIndexOf4 >= 0) {
                str = str.substring(lastIndexOf4 + 1);
            }
            if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(46)) >= 0 && lastIndexOf < str.length() - 1) {
                return str.substring(lastIndexOf + 1);
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Void, List<ImageFileInfo>, List<ImageFileInfo>> {
        private final ap dSs;
        private final String dSt;
        private String dSu;
        private List<d> dSv;
        private int dSw = 1;
        private b dSx = new i(this);

        public c(String str, ap apVar) {
            this.dSs = apVar;
            this.dSt = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public List<ImageFileInfo> doInBackground(Void... voidArr) {
            if (TextUtils.isEmpty(this.dSt)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (this.dSt.equals("-1")) {
                this.dSv = h.this.aJV();
                if (this.dSv != null) {
                    for (d dVar : this.dSv) {
                        String albumId = dVar.getAlbumId();
                        if (!TextUtils.isEmpty(albumId)) {
                            a(arrayList, this.dSx, albumId);
                        }
                    }
                }
                return arrayList;
            }
            a(arrayList, this.dSx, this.dSt);
            return arrayList;
        }

        private void a(List<ImageFileInfo> list, b bVar, String str) {
            if (list != null) {
                a(list, bVar, str, h.this.mContext, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if (list == null || list.size() <= 0) {
                    a(list, bVar, str, h.this.mContext, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (this.dSs != null) {
                this.dSs.mZ();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(List<ImageFileInfo>... listArr) {
            super.onProgressUpdate(listArr);
            if (listArr.length > 0 && this.dSs != null) {
                this.dSs.a(this.dSv, listArr[0], this.dSu);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public void onPostExecute(List<ImageFileInfo> list) {
            super.onPostExecute(list);
            if (this.dSs != null) {
                this.dSs.a(this.dSv, list, this.dSu);
            }
        }

        private void a(List<ImageFileInfo> list, b bVar) {
            if (list != null && bVar != null) {
                if (this.dSw == 1 || this.dSw == 2) {
                    if (list.size() / this.dSw > 50) {
                        if (bVar != null) {
                            bVar.bZ(list);
                        }
                        this.dSw++;
                    }
                } else if (list.size() / this.dSw > 500) {
                    if (bVar != null) {
                        bVar.bZ(list);
                    }
                    this.dSw++;
                }
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0082 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
        private void a(List<ImageFileInfo> list, b bVar, String str, Context context, Uri uri) {
            Cursor cursor;
            if (list != null) {
                ?? r1 = "bucket_display_name";
                try {
                    try {
                        cursor = context.getContentResolver().query(uri, new String[]{"bucket_id", "_data", "bucket_display_name"}, "bucket_id=?", new String[]{str}, "datetaken DESC");
                        try {
                            if (cursor.moveToFirst()) {
                                int columnIndex = cursor.getColumnIndex("_data");
                                int columnIndex2 = cursor.getColumnIndex("bucket_display_name");
                                do {
                                    String string = cursor.getString(columnIndex);
                                    this.dSu = cursor.getString(columnIndex2);
                                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                                    imageFileInfo.setAlbumnId(str);
                                    imageFileInfo.setFilePath(string);
                                    File file = new File(string);
                                    if (file.exists() && file.length() > 0) {
                                        list.add(imageFileInfo);
                                        a(list, bVar);
                                    }
                                } while (cursor.moveToNext());
                                com.baidu.adp.lib.h.a.b(cursor);
                            }
                            com.baidu.adp.lib.h.a.b(cursor);
                        } catch (Exception e) {
                            e = e;
                            BdLog.detailException(e);
                            com.baidu.adp.lib.h.a.b(cursor);
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.h.a.b((Cursor) r1);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    r1 = 0;
                    com.baidu.adp.lib.h.a.b((Cursor) r1);
                    throw th;
                }
            }
        }
    }
}
