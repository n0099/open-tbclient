package com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a;

import android.text.TextUtils;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileDownloadCallBack;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class b {

    /* loaded from: classes4.dex */
    public interface a {
        void zm(boolean z);
    }

    public static void a(String str, final String str2, final a aVar) {
        if (TextUtils.isEmpty(str2)) {
            BdLog.w("warning!! download illegal dir");
        } else if (TextUtils.isEmpty(str)) {
            BdLog.w("warning!! download illegal name");
        } else {
            final String str3 = com.baidu.live.ac.b.ii(str2) + "/" + str2 + ".zip";
            final String ij = com.baidu.live.ac.b.ij(str2);
            if (!str3.startsWith(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath())) {
                BdLog.w("warning!! download illegal dir=" + str3 + " name=" + str2);
                return;
            }
            final DownloadData downloadData = new DownloadData();
            downloadData.setId(str2);
            downloadData.setName(str2);
            downloadData.setUrl(str);
            downloadData.setCheck(str2);
            downloadData.setType(22);
            downloadData.setPath(str3);
            downloadData.setCallback(new FileDownloadCallBack() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.b.1
                @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                public void onFileUpdateProgress(DownloadData downloadData2) {
                }

                @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                public boolean onPreDownload(DownloadData downloadData2) {
                    return com.baidu.live.ac.a.b.Qx().K(downloadData2);
                }

                @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    b.a(str3, ij, str2, aVar);
                }

                @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str4) {
                    if (aVar != null) {
                        aVar.zm(false);
                    }
                }
            });
            new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.b.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                public Boolean doInBackground(Void... voidArr) {
                    FileHelper.deleteFileOrDir(new File(com.baidu.live.ac.b.ii(str2)));
                    return true;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    FileSerialDownLoader.getInstance().startDownLoadWithoutMax(downloadData);
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final String str, final String str2, final String str3, final a aVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.b.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                public Boolean doInBackground(Void... voidArr) {
                    boolean unZip = b.unZip(str, str2);
                    if (unZip) {
                        c.gO(str3, str2);
                    }
                    return Boolean.valueOf(unZip);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass3) bool);
                    if (aVar != null) {
                        aVar.zm(bool.booleanValue());
                    }
                }
            }.execute(new Void[0]);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public static boolean unZip(java.lang.String r5, java.lang.String r6) {
        /*
            r3 = 0
            r0 = 0
            boolean r1 = com.baidu.live.f.a.existFile(r5)
            if (r1 != 0) goto L9
        L8:
            return r0
        L9:
            boolean r1 = com.baidu.live.adp.lib.util.StringUtils.isNull(r6)
            if (r1 != 0) goto L8
            java.io.File r1 = new java.io.File
            r1.<init>(r6)
            boolean r2 = r1.exists()
            if (r2 != 0) goto L20
            boolean r1 = r1.mkdirs()
            if (r1 == 0) goto L8
        L20:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L9e
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L9e
            java.util.zip.ZipInputStream r2 = new java.util.zip.ZipInputStream     // Catch: java.lang.Throwable -> La1
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> La1
            r1.<init>(r4)     // Catch: java.lang.Throwable -> La1
            r2.<init>(r1)     // Catch: java.lang.Throwable -> La1
        L2f:
            java.util.zip.ZipEntry r1 = r2.getNextEntry()     // Catch: java.lang.Throwable -> L48
            if (r1 == 0) goto L71
            boolean r3 = r1.isDirectory()     // Catch: java.lang.Throwable -> L48
            if (r3 == 0) goto L5d
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L48
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L48
            r3.<init>(r6, r1)     // Catch: java.lang.Throwable -> L48
            r3.mkdirs()     // Catch: java.lang.Throwable -> L48
            goto L2f
        L48:
            r1 = move-exception
            r3 = r4
        L4a:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L9b
            if (r2 == 0) goto L52
            r2.close()     // Catch: java.io.IOException -> L58
        L52:
            if (r3 == 0) goto L8
            r3.close()     // Catch: java.io.IOException -> L58
            goto L8
        L58:
            r1 = move-exception
            r1.printStackTrace()
            goto L8
        L5d:
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L48
            a(r2, r6, r1)     // Catch: java.lang.Throwable -> L48
            goto L2f
        L65:
            r0 = move-exception
        L66:
            if (r2 == 0) goto L6b
            r2.close()     // Catch: java.io.IOException -> L8f
        L6b:
            if (r4 == 0) goto L70
            r4.close()     // Catch: java.io.IOException -> L8f
        L70:
            throw r0
        L71:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L48
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L48
            java.io.File r1 = r1.getParentFile()     // Catch: java.lang.Throwable -> L48
            com.baidu.live.tbadk.core.util.FileHelper.deleteFileOrDir(r1)     // Catch: java.lang.Throwable -> L48
            r0 = 1
            if (r2 == 0) goto L83
            r2.close()     // Catch: java.io.IOException -> L89
        L83:
            if (r4 == 0) goto L8
            r4.close()     // Catch: java.io.IOException -> L89
            goto L8
        L89:
            r1 = move-exception
            r1.printStackTrace()
            goto L8
        L8f:
            r1 = move-exception
            r1.printStackTrace()
            goto L70
        L94:
            r0 = move-exception
            r2 = r3
            r4 = r3
            goto L66
        L98:
            r0 = move-exception
            r2 = r3
            goto L66
        L9b:
            r0 = move-exception
            r4 = r3
            goto L66
        L9e:
            r1 = move-exception
            r2 = r3
            goto L4a
        La1:
            r1 = move-exception
            r2 = r3
            r3 = r4
            goto L4a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.b.unZip(java.lang.String, java.lang.String):boolean");
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [224=5, 225=5, 226=5, 228=5, 229=5] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static File a(InputStream inputStream, String str, String str2) {
        Throwable th;
        FileOutputStream fileOutputStream;
        if (inputStream == null || TextUtils.isEmpty(str) || str2.contains("/.")) {
            return null;
        }
        File file = new File(str + "/" + str2);
        String parent = file.getParent();
        if (!TextUtils.isEmpty(parent)) {
            File file2 = new File(parent);
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (file.exists() && !file.delete()) {
                    if (0 != 0) {
                        try {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                            return null;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                    return null;
                } else if (!file.createNewFile()) {
                    if (0 != 0) {
                        try {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                            return null;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return null;
                        }
                    }
                    return null;
                } else {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return file;
                    } catch (IOException e4) {
                        e = e4;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                                return null;
                            } catch (IOException e5) {
                                e5.printStackTrace();
                                return null;
                            }
                        }
                        return null;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            fileOutputStream = null;
        } catch (Throwable th3) {
            fileOutputStream2 = null;
            th = th3;
            if (fileOutputStream2 != null) {
            }
            throw th;
        }
    }
}
