package com.baidu.tieba.service;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import java.io.File;
import java.util.Date;
/* loaded from: classes.dex */
public class ClearTempService extends BdBaseService {
    private static final int DELETE_FILE_COUNT = 300;
    private static final int MAX_FILE_COUNT = 500;
    private volatile boolean interrupted = false;
    private Thread thread = null;
    private final Handler handler = new Handler() { // from class: com.baidu.tieba.service.ClearTempService.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            ClearTempService.this.stopSelf();
            ClearTempService.this.thread = null;
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.interrupted = true;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        this.interrupted = false;
        try {
            if (this.thread == null) {
                this.thread = new Thread() { // from class: com.baidu.tieba.service.ClearTempService.2
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        super.run();
                        try {
                            File file = new File(l.CH + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME);
                            File file2 = new File(l.CH + "/" + TbConfig.getTempDirName() + "/share");
                            File file3 = new File(l.CH + "/" + TbConfig.getTempDirName() + "/voice");
                            File file4 = new File(l.CH + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_ALA_IM_RECORD_DIR_NAME);
                            ClearTempService.this.deleteCache(file, false);
                            ClearTempService.this.deleteDir(file2);
                            ClearTempService.this.deleteDir(file3);
                            ClearTempService.this.deleteDir(file4);
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        }
                        ClearTempService.this.handler.sendMessage(ClearTempService.this.handler.obtainMessage());
                    }
                };
                this.thread.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            BdLog.e(e.getMessage());
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteCache(File file, boolean z) {
        try {
            File[] listFiles = file.listFiles();
            long time = new Date().getTime();
            int length = listFiles.length > 500 ? listFiles.length - 300 : 0;
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.interrupted; i++) {
                    File file2 = listFiles[i];
                    if (file2.isDirectory()) {
                        deleteCache(file2, false);
                    } else if (length > 0 && i < length) {
                        if (!file2.delete()) {
                        }
                    } else if (time - listFiles[i].lastModified() > 259200000 && !file2.delete()) {
                    }
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            if (!z) {
                deleteImageCacheByName();
            }
        }
    }

    private void deleteImageCacheByName() {
        String str = l.CH + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME;
        for (int i = 0; i < 20; i++) {
            File file = new File(str + "/" + i);
            if (file.exists() && file.isDirectory()) {
                deleteCache(file, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteDir(File file) {
        try {
            File[] listFiles = file.listFiles();
            long time = new Date().getTime();
            if (listFiles != null) {
                int i = 0;
                while (i < listFiles.length && !this.interrupted) {
                    i = (time - listFiles[i].lastModified() <= 259200000 || !listFiles[i].delete()) ? i + 1 : i + 1;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
