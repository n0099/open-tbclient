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
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class i {
    private final String geJ = TbConfig.getTempDirName();
    private a geK;
    private c geL;
    private final Context mContext;

    /* loaded from: classes.dex */
    public interface b {
        void dc(List<ImageFileInfo> list);
    }

    public i(Context context) {
        this.mContext = context;
    }

    public boolean a(o oVar) {
        if (oVar == null) {
            return false;
        }
        bsh();
        this.geK = new a(oVar);
        this.geK.setPriority(3);
        this.geK.execute(new Object[0]);
        return true;
    }

    public boolean a(String str, at atVar) {
        if (atVar == null) {
            return false;
        }
        bsi();
        this.geL = new c(str, atVar);
        this.geL.setPriority(3);
        this.geL.execute(new Void[0]);
        return true;
    }

    public void bsh() {
        if (this.geK != null) {
            this.geK.cancel();
            this.geK = null;
        }
    }

    public void bsi() {
        if (this.geL != null) {
            this.geL.cancel();
            this.geL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, List<e>> {
        private final o geM;

        public a(o oVar) {
            this.geM = oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public List<e> doInBackground(Object... objArr) {
            return i.this.bsj();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.geM != null) {
                this.geM.onPreLoad();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(List<e> list) {
            super.onPostExecute((a) list);
            if (this.geM != null) {
                this.geM.dd(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<e> bsj() {
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
                                    String sf = sf(file2.getAbsolutePath());
                                    if (sf != null && (matcher = compile.matcher(sf)) != null && matcher.matches()) {
                                        i++;
                                    }
                                }
                            }
                            if (i != 0) {
                                String sb = new StringBuilder(String.valueOf(i)).toString();
                                e eVar = new e();
                                eVar.sd(string);
                                eVar.se(sb);
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                File file3 = new File(string3);
                                if (file3.exists() && file3.isFile()) {
                                    imageFileInfo.setModifyTime(com.baidu.tbadk.core.util.aw.J(file3.lastModified()));
                                }
                                imageFileInfo.setFilePath(string3);
                                eVar.f(imageFileInfo);
                                eVar.setName(string2);
                                if (string2 != null && string2.equals(this.geJ)) {
                                    list.add(0, eVar);
                                } else {
                                    list.add(eVar);
                                }
                            }
                        } while (cursor.moveToNext());
                        com.baidu.adp.lib.g.a.e(cursor);
                        return list;
                    }
                    com.baidu.adp.lib.g.a.e(cursor);
                    return list;
                } catch (Exception e) {
                    e = e;
                    BdLog.detailException(e);
                    com.baidu.adp.lib.g.a.e(cursor);
                    return list;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.g.a.e(cursor);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            com.baidu.adp.lib.g.a.e(cursor);
            throw th;
        }
    }

    public String sf(String str) {
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
        private final at geO;
        private final String geP;
        private String geQ;
        private List<e> geR;
        private int geS = 1;
        private b geT = new j(this);

        public c(String str, at atVar) {
            this.geO = atVar;
            this.geP = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public List<ImageFileInfo> doInBackground(Void... voidArr) {
            if (TextUtils.isEmpty(this.geP)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (this.geP.equals("-1")) {
                this.geR = i.this.bsj();
                if (this.geR != null) {
                    for (e eVar : this.geR) {
                        String albumId = eVar.getAlbumId();
                        if (!TextUtils.isEmpty(albumId)) {
                            a(arrayList, this.geT, albumId);
                        }
                    }
                }
                return arrayList;
            }
            a(arrayList, this.geT, this.geP);
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
            if (this.geO != null) {
                this.geO.onPreLoad();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(List<ImageFileInfo>... listArr) {
            super.onProgressUpdate(listArr);
            if (listArr.length > 0 && this.geO != null) {
                this.geO.a(this.geR, listArr[0], this.geQ);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(List<ImageFileInfo> list) {
            super.onPostExecute((c) list);
            if (this.geO != null) {
                this.geO.a(this.geR, list, this.geQ);
            }
        }

        private void a(List<ImageFileInfo> list, b bVar) {
            if (list != null && bVar != null) {
                if (this.geS == 1 || this.geS == 2) {
                    if (list.size() / this.geS > 50) {
                        if (bVar != null) {
                            bVar.dc(list);
                        }
                        this.geS++;
                    }
                } else if (list.size() / this.geS > 500) {
                    if (bVar != null) {
                        bVar.dc(list);
                    }
                    this.geS++;
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [490=4] */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x00cb */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v5, types: [android.database.Cursor] */
        private void a(List<ImageFileInfo> list, b bVar, String str, Context context, Uri uri) {
            Cursor cursor;
            InputStream f;
            if (list == null) {
                return;
            }
            ?? r1 = "bucket_display_name";
            try {
                try {
                    cursor = context.getContentResolver().query(uri, new String[]{"bucket_id", "_data", "bucket_display_name"}, "bucket_id=?", new String[]{str}, "datetaken DESC");
                    try {
                        if (!cursor.moveToFirst()) {
                            com.baidu.adp.lib.g.a.e(cursor);
                        }
                        int columnIndex = cursor.getColumnIndex("_data");
                        int columnIndex2 = cursor.getColumnIndex("bucket_display_name");
                        do {
                            String string = cursor.getString(columnIndex);
                            this.geQ = cursor.getString(columnIndex2);
                            ImageFileInfo imageFileInfo = new ImageFileInfo();
                            imageFileInfo.setAlbumnId(str);
                            imageFileInfo.setFilePath(string);
                            File file = new File(string);
                            if (file.exists() && file.length() > 0) {
                                if (string.toLowerCase().endsWith(".gif") && (f = com.baidu.adp.lib.util.e.f(file)) != null) {
                                    try {
                                        byte[] bArr = new byte[7];
                                        r0 = f.read(bArr, 0, 6) == 6 ? com.baidu.adp.lib.util.k.m(bArr) : false;
                                        if (!r0 || com.baidu.adp.lib.util.e.getFileSize(file) <= 3145728) {
                                            com.baidu.adp.lib.g.a.j(f);
                                        } else {
                                            com.baidu.adp.lib.g.a.j(f);
                                        }
                                    } catch (IOException e) {
                                        com.baidu.adp.lib.g.a.j(f);
                                    } catch (Throwable th) {
                                        com.baidu.adp.lib.g.a.j(f);
                                        throw th;
                                    }
                                }
                                imageFileInfo.setIsGif(r0);
                                imageFileInfo.setModifyTime(com.baidu.tbadk.core.util.aw.J(file.lastModified()));
                                list.add(imageFileInfo);
                                a(list, bVar);
                            }
                        } while (cursor.moveToNext());
                        com.baidu.adp.lib.g.a.e(cursor);
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.detailException(e);
                        com.baidu.adp.lib.g.a.e(cursor);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.g.a.e(r1);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                r1 = 0;
                com.baidu.adp.lib.g.a.e(r1);
                throw th;
            }
        }
    }
}
