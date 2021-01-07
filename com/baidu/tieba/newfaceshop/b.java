package com.baidu.tieba.newfaceshop;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.download.DownloadData;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes9.dex */
public class b {
    public static void a(final com.baidu.tieba.newfaceshop.b.a aVar, final com.baidu.tieba.newfaceshop.a.b bVar) {
        if (aVar == null || aVar.pics == null || aVar.pics.size() == 0 || TextUtils.isEmpty(aVar.url)) {
            if (bVar != null) {
                bVar.onFail("group data null");
                return;
            }
            return;
        }
        final String str = c.lwG + aVar.id + "/";
        com.baidu.tbadk.download.c cVar = new com.baidu.tbadk.download.c() { // from class: com.baidu.tieba.newfaceshop.b.1
            @Override // com.baidu.tbadk.download.c
            public void onFileUpdateProgress(DownloadData downloadData) {
                if (com.baidu.tieba.newfaceshop.a.b.this != null) {
                    com.baidu.tieba.newfaceshop.a.b.this.onProgress(downloadData.getProcess());
                }
            }

            @Override // com.baidu.tbadk.download.c
            public boolean onPreDownload(DownloadData downloadData) {
                return true;
            }

            @Override // com.baidu.tbadk.download.c
            public boolean onFileDownloaded(DownloadData downloadData) {
                return true;
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadSucceed(final DownloadData downloadData) {
                new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.newfaceshop.b.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public Boolean doInBackground(Void... voidArr) {
                        n.deleteFileOrDir(new File(str));
                        if (b.a(downloadData.getPath(), aVar)) {
                            return Boolean.valueOf(b.a(aVar, str));
                        }
                        return false;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    public void onPostExecute(Boolean bool) {
                        if (bool.booleanValue()) {
                            com.baidu.tieba.newfaceshop.a.b.this.onSuccess(str);
                        } else {
                            com.baidu.tieba.newfaceshop.a.b.this.onFail("fail to download");
                        }
                    }
                }.execute(new Void[0]);
            }

            @Override // com.baidu.tbadk.download.c
            public void onFileDownloadFailed(DownloadData downloadData, int i, String str2) {
                if (com.baidu.tieba.newfaceshop.a.b.this != null) {
                    String str3 = "faile to download:";
                    if (downloadData != null && !TextUtils.isEmpty(downloadData.getUrl())) {
                        str3 = "faile to download:" + downloadData.getUrl();
                    }
                    com.baidu.tieba.newfaceshop.a.b.this.onFail(str3);
                }
            }
        };
        new File(c.lwG).mkdirs();
        a(aVar, c.lwG, cVar);
    }

    public static void a(com.baidu.tieba.newfaceshop.b.a aVar, String str, com.baidu.tbadk.download.c cVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.url)) {
            if (cVar != null) {
                cVar.onFileDownloadFailed(null, 0, "data is null");
                return;
            }
            return;
        }
        String str2 = aVar.id + ".zip";
        DownloadData downloadData = new DownloadData(aVar.id, str2, Uri.encode(aVar.url, "-![.:/,%?&=]"), cVar);
        downloadData.setPath(str + str2);
        com.baidu.tbadk.download.d.bEF().f(downloadData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(com.baidu.tieba.newfaceshop.b.a aVar, String str) {
        Bitmap bitmap;
        File file = new File(str + "panel.png");
        File file2 = new File(str + "panel_momo.png");
        if (file.exists() && file2.exists()) {
            return true;
        }
        if (new File(str + aVar.covername).exists()) {
            try {
                bitmap = BitmapFactory.decodeFile(str + aVar.covername);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                bitmap = null;
            }
            if (bitmap == null) {
                return false;
            }
            if (file.exists() || !TextUtils.isEmpty(saveFileAsPNG(str, "panel.png", bitmap, 60))) {
                return file2.exists() || !TextUtils.isEmpty(saveFileAsPNG(str, "panel_momo.png", bitmap, 60));
            }
            return false;
        }
        return false;
    }

    public static String saveFileAsPNG(String str, String str2, Bitmap bitmap, int i) {
        if (bitmap == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str + str2);
        try {
            if ((!file.exists() || file.delete()) && file.createNewFile()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG, i, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return file.getPath();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(String str, com.baidu.tieba.newfaceshop.b.a aVar) {
        ZipInputStream zipInputStream;
        try {
            try {
                zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry != null) {
                            if (!nextEntry.isDirectory()) {
                                n.saveFile(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + (".emotions/" + aVar.id) + "/" + nextEntry.getName(), zipInputStream);
                            }
                        } else {
                            zipInputStream.close();
                            n.deleteFile(new File(str));
                            com.baidu.adp.lib.util.n.close((InputStream) zipInputStream);
                            return true;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.n.close((InputStream) zipInputStream);
                        return false;
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        com.baidu.adp.lib.util.n.close((InputStream) zipInputStream);
                        return false;
                    }
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.util.n.close((InputStream) null);
                throw th;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            zipInputStream = null;
        } catch (IOException e4) {
            e = e4;
            zipInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.adp.lib.util.n.close((InputStream) null);
            throw th;
        }
    }
}
