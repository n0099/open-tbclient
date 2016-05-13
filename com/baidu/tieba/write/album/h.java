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
import com.baidu.tbadk.core.util.ay;
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
    private final String eXP = TbConfig.getTempDirName();
    private a eXQ;
    private c eXR;
    private final Context mContext;

    /* loaded from: classes.dex */
    public interface b {
        void cL(List<ImageFileInfo> list);
    }

    public h(Context context) {
        this.mContext = context;
    }

    public boolean a(n nVar) {
        if (nVar == null) {
            return false;
        }
        aYL();
        this.eXQ = new a(nVar);
        this.eXQ.setPriority(3);
        this.eXQ.execute(new Object[0]);
        return true;
    }

    public boolean a(String str, ap apVar) {
        if (apVar == null) {
            return false;
        }
        aYM();
        this.eXR = new c(str, apVar);
        this.eXR.setPriority(3);
        this.eXR.execute(new Void[0]);
        return true;
    }

    public void aYL() {
        if (this.eXQ != null) {
            this.eXQ.cancel();
            this.eXQ = null;
        }
    }

    public void aYM() {
        if (this.eXR != null) {
            this.eXR.cancel();
            this.eXR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, List<d>> {
        private final n eXS;

        public a(n nVar) {
            this.eXS = nVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public List<d> doInBackground(Object... objArr) {
            return h.this.aYO();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.eXS != null) {
                this.eXS.jv();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: w */
        public void onPostExecute(List<d> list) {
            super.onPostExecute(list);
            if (this.eXS != null) {
                this.eXS.cK(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<d> aYO() {
        HashSet<String> hashSet = new HashSet<>();
        return c(this.mContext, c(this.mContext, null, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, hashSet), MediaStore.Images.Media.INTERNAL_CONTENT_URI, hashSet);
    }

    private List<d> c(Context context, List<d> list, Uri uri, HashSet<String> hashSet) {
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
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"bucket_id", "bucket_display_name", "_data", "count(*)"}, "mime_type like 'image/%') GROUP BY 1,(2", null, "date_added DESC");
            try {
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
                                    String oF = oF(file2.getAbsolutePath());
                                    if (oF != null && (matcher = compile.matcher(oF)) != null && matcher.matches()) {
                                        i++;
                                    }
                                }
                            }
                            if (i != 0) {
                                String sb = new StringBuilder(String.valueOf(i)).toString();
                                d dVar = new d();
                                dVar.setAlbumId(string);
                                dVar.pa(sb);
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                File file3 = new File(string3);
                                if (file3.exists() && file3.isFile()) {
                                    imageFileInfo.setModifyTime(ay.K(file3.lastModified()));
                                }
                                imageFileInfo.setFilePath(string3);
                                dVar.f(imageFileInfo);
                                dVar.setName(string2);
                                if (string2 != null && string2.equals(this.eXP)) {
                                    list.add(0, dVar);
                                } else {
                                    list.add(dVar);
                                }
                            }
                        } while (cursor.moveToNext());
                        com.baidu.adp.lib.h.a.a(cursor);
                        return list;
                    }
                    com.baidu.adp.lib.h.a.a(cursor);
                    return list;
                } catch (Exception e) {
                    e = e;
                    BdLog.detailException(e);
                    com.baidu.adp.lib.h.a.a(cursor);
                    return list;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.h.a.a(cursor);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            com.baidu.adp.lib.h.a.a(cursor);
            throw th;
        }
    }

    public String oF(String str) {
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
        private List<d> eFm;
        private final String eMl;
        private String eMm;
        private final ap eXU;
        private int eMn = 1;
        private b eXV = new i(this);

        public c(String str, ap apVar) {
            this.eXU = apVar;
            this.eMl = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public List<ImageFileInfo> doInBackground(Void... voidArr) {
            if (TextUtils.isEmpty(this.eMl)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (this.eMl.equals("-1")) {
                this.eFm = h.this.aYO();
                if (this.eFm != null) {
                    for (d dVar : this.eFm) {
                        String albumId = dVar.getAlbumId();
                        if (!TextUtils.isEmpty(albumId)) {
                            a(arrayList, this.eXV, albumId);
                        }
                    }
                }
                return arrayList;
            }
            a(arrayList, this.eXV, this.eMl);
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
            if (this.eXU != null) {
                this.eXU.jv();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(List<ImageFileInfo>... listArr) {
            super.onProgressUpdate(listArr);
            if (listArr.length > 0 && this.eXU != null) {
                this.eXU.a(this.eFm, listArr[0], this.eMm);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: w */
        public void onPostExecute(List<ImageFileInfo> list) {
            super.onPostExecute(list);
            if (this.eXU != null) {
                this.eXU.a(this.eFm, list, this.eMm);
            }
        }

        private void a(List<ImageFileInfo> list, b bVar) {
            if (list != null && bVar != null) {
                if (this.eMn == 1 || this.eMn == 2) {
                    if (list.size() / this.eMn > 50) {
                        if (bVar != null) {
                            bVar.cL(list);
                        }
                        this.eMn++;
                    }
                } else if (list.size() / this.eMn > 500) {
                    if (bVar != null) {
                        bVar.cL(list);
                    }
                    this.eMn++;
                }
            }
        }

        private void a(List<ImageFileInfo> list, b bVar, String str, Context context, Uri uri) {
            Cursor cursor;
            if (list != null) {
                try {
                    cursor = context.getContentResolver().query(uri, new String[]{"bucket_id", "_data", "bucket_display_name"}, "bucket_id=?", new String[]{str}, "datetaken DESC");
                    try {
                        try {
                            if (cursor.moveToFirst()) {
                                int columnIndex = cursor.getColumnIndex("_data");
                                int columnIndex2 = cursor.getColumnIndex("bucket_display_name");
                                do {
                                    String string = cursor.getString(columnIndex);
                                    this.eMm = cursor.getString(columnIndex2);
                                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                                    imageFileInfo.setAlbumnId(str);
                                    imageFileInfo.setFilePath(string);
                                    File file = new File(string);
                                    if (file.exists() && file.length() > 0) {
                                        imageFileInfo.setModifyTime(ay.K(file.lastModified()));
                                        list.add(imageFileInfo);
                                        a(list, bVar);
                                    }
                                } while (cursor.moveToNext());
                                com.baidu.adp.lib.h.a.a(cursor);
                            }
                            com.baidu.adp.lib.h.a.a(cursor);
                        } catch (Exception e) {
                            e = e;
                            BdLog.detailException(e);
                            com.baidu.adp.lib.h.a.a(cursor);
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.h.a.a(cursor);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                    com.baidu.adp.lib.h.a.a(cursor);
                    throw th;
                }
            }
        }
    }
}
