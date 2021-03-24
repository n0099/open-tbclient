package com.baidu.tieba.service;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.FileHelper;
import java.io.File;
import java.util.Date;
/* loaded from: classes.dex */
public class ClearTempService extends BdBaseService {
    public static final int DELETE_FILE_COUNT = 300;
    public static final int MAX_FILE_COUNT = 500;
    public volatile boolean interrupted = false;
    public Thread thread = null;
    public final Handler handler = new a();

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            ClearTempService.this.stopSelf();
            ClearTempService.this.thread = null;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends Thread {
        public b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            try {
                File file = new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/image");
                File file2 = new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/share");
                File file3 = new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/voice");
                File file4 = new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_ALA_IM_RECORD_DIR_NAME);
                ClearTempService.this.deleteCache(file, false);
                ClearTempService.this.deleteDir(file2);
                ClearTempService.this.deleteDir(file3);
                ClearTempService.this.deleteDir(file4);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            ClearTempService.this.handler.sendMessage(ClearTempService.this.handler.obtainMessage());
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
                        file2.delete();
                    } else if (time - listFiles[i].lastModified() > 259200000) {
                        file2.delete();
                    }
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            if (z) {
                return;
            }
            deleteImageCacheByName();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteDir(File file) {
        try {
            File[] listFiles = file.listFiles();
            long time = new Date().getTime();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.interrupted; i++) {
                    if (time - listFiles[i].lastModified() > 259200000) {
                        listFiles[i].delete();
                    }
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    private void deleteImageCacheByName() {
        String str = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/image";
        for (int i = 0; i < 20; i++) {
            File file = new File(str + "/" + i);
            if (file.exists() && file.isDirectory()) {
                deleteCache(file, true);
            }
        }
    }

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
                b bVar = new b();
                this.thread = bVar;
                bVar.start();
            }
        } catch (OutOfMemoryError e2) {
            System.gc();
            BdLog.e(e2.getMessage());
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
