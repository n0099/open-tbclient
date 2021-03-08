package com.baidu.yuyinala.background.c;

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
/* loaded from: classes10.dex */
public class a {

    /* renamed from: com.baidu.yuyinala.background.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0964a {
        void An(boolean z);
    }

    public static void a(String str, final String str2, final InterfaceC0964a interfaceC0964a) {
        if (TextUtils.isEmpty(str2)) {
            BdLog.w("warning!! download illegal dir");
        } else if (TextUtils.isEmpty(str)) {
            BdLog.w("warning!! download illegal name");
        } else {
            final String str3 = com.baidu.live.storage.b.hL(str2) + "/" + str2 + ".zip";
            final String hN = com.baidu.live.storage.b.hN(str2);
            if (!str3.startsWith(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath())) {
                BdLog.w("warning!! download illegal dir=" + str3 + " name=" + str2);
                return;
            }
            final DownloadData downloadData = new DownloadData();
            downloadData.setId(str2);
            downloadData.setName(str2);
            downloadData.setUrl(str);
            downloadData.setType(24);
            downloadData.setPath(str3);
            if (interfaceC0964a != null) {
                downloadData.setPriority(160);
                downloadData.setForceDownload(true);
            }
            downloadData.setCallback(new FileDownloadCallBack() { // from class: com.baidu.yuyinala.background.c.a.1
                @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                public void onFileUpdateProgress(DownloadData downloadData2) {
                }

                @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                public boolean onPreDownload(DownloadData downloadData2) {
                    return com.baidu.live.storage.opt.b.Rj().I(downloadData2);
                }

                @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    a.a(str3, hN, str2, interfaceC0964a);
                }

                @Override // com.baidu.live.tbadk.download.FileDownloadCallBack
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str4) {
                    if (interfaceC0964a != null) {
                        interfaceC0964a.An(false);
                    }
                }
            });
            new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.yuyinala.background.c.a.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                public Boolean doInBackground(Void... voidArr) {
                    FileHelper.deleteFileOrDir(new File(com.baidu.live.storage.b.hL(str2)));
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
    public static void a(final String str, final String str2, final String str3, final InterfaceC0964a interfaceC0964a) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            new BdAsyncTask<Void, Void, Boolean>() { // from class: com.baidu.yuyinala.background.c.a.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                public Boolean doInBackground(Void... voidArr) {
                    boolean unZip = a.unZip(str, str2);
                    if (unZip) {
                        b.gZ(str3, str2);
                    }
                    return Boolean.valueOf(unZip);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass3) bool);
                    if (interfaceC0964a != null) {
                        interfaceC0964a.An(bool.booleanValue());
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
            boolean r1 = com.baidu.live.h.a.existFile(r5)
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
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L9a
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L9a
            java.util.zip.ZipInputStream r2 = new java.util.zip.ZipInputStream     // Catch: java.lang.Throwable -> L9e
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L9e
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L9e
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L9e
        L2f:
            java.util.zip.ZipEntry r1 = r2.getNextEntry()     // Catch: java.lang.Throwable -> L48
            if (r1 == 0) goto L70
            boolean r3 = r1.isDirectory()     // Catch: java.lang.Throwable -> L48
            if (r3 == 0) goto L5c
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L48
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L48
            r3.<init>(r6, r1)     // Catch: java.lang.Throwable -> L48
            r3.mkdirs()     // Catch: java.lang.Throwable -> L48
            goto L2f
        L48:
            r1 = move-exception
        L49:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L64
            if (r2 == 0) goto L51
            r2.close()     // Catch: java.io.IOException -> L57
        L51:
            if (r4 == 0) goto L8
            r4.close()     // Catch: java.io.IOException -> L57
            goto L8
        L57:
            r1 = move-exception
            r1.printStackTrace()
            goto L8
        L5c:
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L48
            b(r2, r6, r1)     // Catch: java.lang.Throwable -> L48
            goto L2f
        L64:
            r0 = move-exception
        L65:
            if (r2 == 0) goto L6a
            r2.close()     // Catch: java.io.IOException -> L8e
        L6a:
            if (r4 == 0) goto L6f
            r4.close()     // Catch: java.io.IOException -> L8e
        L6f:
            throw r0
        L70:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L48
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L48
            java.io.File r1 = r1.getParentFile()     // Catch: java.lang.Throwable -> L48
            com.baidu.live.tbadk.core.util.FileHelper.deleteFileOrDir(r1)     // Catch: java.lang.Throwable -> L48
            r0 = 1
            if (r2 == 0) goto L82
            r2.close()     // Catch: java.io.IOException -> L88
        L82:
            if (r4 == 0) goto L8
            r4.close()     // Catch: java.io.IOException -> L88
            goto L8
        L88:
            r1 = move-exception
            r1.printStackTrace()
            goto L8
        L8e:
            r1 = move-exception
            r1.printStackTrace()
            goto L6f
        L93:
            r0 = move-exception
            r2 = r3
            r4 = r3
            goto L65
        L97:
            r0 = move-exception
            r2 = r3
            goto L65
        L9a:
            r1 = move-exception
            r2 = r3
            r4 = r3
            goto L49
        L9e:
            r1 = move-exception
            r2 = r3
            goto L49
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.yuyinala.background.c.a.unZip(java.lang.String, java.lang.String):boolean");
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [228=5, 229=5, 230=5, 232=5, 233=5] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static File b(InputStream inputStream, String str, String str2) {
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
            } catch (Throwable th) {
                th = th;
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
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = null;
            if (fileOutputStream2 != null) {
            }
            throw th;
        }
    }
}
