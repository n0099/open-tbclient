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
public class i {
    private final String fTZ = TbConfig.getTempDirName();
    private a fUa;
    private c fUb;
    private final Context mContext;

    /* loaded from: classes.dex */
    public interface b {
        void cN(List<ImageFileInfo> list);
    }

    public i(Context context) {
        this.mContext = context;
    }

    public boolean a(o oVar) {
        if (oVar == null) {
            return false;
        }
        bnK();
        this.fUa = new a(oVar);
        this.fUa.setPriority(3);
        this.fUa.execute(new Object[0]);
        return true;
    }

    public boolean a(String str, at atVar) {
        if (atVar == null) {
            return false;
        }
        bnL();
        this.fUb = new c(str, atVar);
        this.fUb.setPriority(3);
        this.fUb.execute(new Void[0]);
        return true;
    }

    public void bnK() {
        if (this.fUa != null) {
            this.fUa.cancel();
            this.fUa = null;
        }
    }

    public void bnL() {
        if (this.fUb != null) {
            this.fUb.cancel();
            this.fUb = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, List<e>> {
        private final o fUc;

        public a(o oVar) {
            this.fUc = oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public List<e> doInBackground(Object... objArr) {
            return i.this.bnM();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.fUc != null) {
                this.fUc.onPreLoad();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(List<e> list) {
            super.onPostExecute((a) list);
            if (this.fUc != null) {
                this.fUc.cO(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<e> bnM() {
        HashSet<String> hashSet = new HashSet<>();
        return a(this.mContext, a(this.mContext, null, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, hashSet), MediaStore.Images.Media.INTERNAL_CONTENT_URI, hashSet);
    }

    private List<e> a(Context context, List<e> list, Uri uri, HashSet<String> hashSet) {
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
                                    String rg = rg(file2.getAbsolutePath());
                                    if (rg != null && (matcher = compile.matcher(rg)) != null && matcher.matches()) {
                                        i++;
                                    }
                                }
                            }
                            if (i != 0) {
                                String sb = new StringBuilder(String.valueOf(i)).toString();
                                e eVar = new e();
                                eVar.re(string);
                                eVar.rf(sb);
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                File file3 = new File(string3);
                                if (file3.exists() && file3.isFile()) {
                                    imageFileInfo.setModifyTime(com.baidu.tbadk.core.util.au.I(file3.lastModified()));
                                }
                                imageFileInfo.setFilePath(string3);
                                eVar.f(imageFileInfo);
                                eVar.setName(string2);
                                if (string2 != null && string2.equals(this.fTZ)) {
                                    list.add(0, eVar);
                                } else {
                                    list.add(eVar);
                                }
                            }
                        } while (cursor.moveToNext());
                        com.baidu.adp.lib.g.a.a(cursor);
                        return list;
                    }
                    com.baidu.adp.lib.g.a.a(cursor);
                    return list;
                } catch (Exception e) {
                    e = e;
                    BdLog.detailException(e);
                    com.baidu.adp.lib.g.a.a(cursor);
                    return list;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.g.a.a(cursor);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            com.baidu.adp.lib.g.a.a(cursor);
            throw th;
        }
    }

    public String rg(String str) {
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
        private final at fUe;
        private final String fUf;
        private String fUg;
        private List<e> fUh;
        private int fUi = 1;
        private b fUj = new j(this);

        public c(String str, at atVar) {
            this.fUe = atVar;
            this.fUf = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public List<ImageFileInfo> doInBackground(Void... voidArr) {
            if (TextUtils.isEmpty(this.fUf)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (this.fUf.equals("-1")) {
                this.fUh = i.this.bnM();
                if (this.fUh != null) {
                    for (e eVar : this.fUh) {
                        String albumId = eVar.getAlbumId();
                        if (!TextUtils.isEmpty(albumId)) {
                            a(arrayList, this.fUj, albumId);
                        }
                    }
                }
                return arrayList;
            }
            a(arrayList, this.fUj, this.fUf);
            return arrayList;
        }

        private void a(List<ImageFileInfo> list, b bVar, String str) {
            if (list != null) {
                a(list, bVar, str, i.this.mContext, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if (list == null || list.size() <= 0) {
                    a(list, bVar, str, i.this.mContext, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (this.fUe != null) {
                this.fUe.onPreLoad();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(List<ImageFileInfo>... listArr) {
            super.onProgressUpdate(listArr);
            if (listArr.length > 0 && this.fUe != null) {
                this.fUe.a(this.fUh, listArr[0], this.fUg);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(List<ImageFileInfo> list) {
            super.onPostExecute((c) list);
            if (this.fUe != null) {
                this.fUe.a(this.fUh, list, this.fUg);
            }
        }

        private void a(List<ImageFileInfo> list, b bVar) {
            if (list != null && bVar != null) {
                if (this.fUi == 1 || this.fUi == 2) {
                    if (list.size() / this.fUi > 50) {
                        if (bVar != null) {
                            bVar.cN(list);
                        }
                        this.fUi++;
                    }
                } else if (list.size() / this.fUi > 500) {
                    if (bVar != null) {
                        bVar.cN(list);
                    }
                    this.fUi++;
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
                                    this.fUg = cursor.getString(columnIndex2);
                                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                                    imageFileInfo.setAlbumnId(str);
                                    imageFileInfo.setFilePath(string);
                                    File file = new File(string);
                                    if (file.exists() && file.length() > 0) {
                                        imageFileInfo.setModifyTime(com.baidu.tbadk.core.util.au.I(file.lastModified()));
                                        list.add(imageFileInfo);
                                        a(list, bVar);
                                    }
                                } while (cursor.moveToNext());
                                com.baidu.adp.lib.g.a.a(cursor);
                            }
                            com.baidu.adp.lib.g.a.a(cursor);
                        } catch (Exception e) {
                            e = e;
                            BdLog.detailException(e);
                            com.baidu.adp.lib.g.a.a(cursor);
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.g.a.a(cursor);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                    com.baidu.adp.lib.g.a.a(cursor);
                    throw th;
                }
            }
        }
    }
}
