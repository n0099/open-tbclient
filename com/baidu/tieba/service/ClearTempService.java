package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import java.io.File;
import java.util.Date;
/* loaded from: classes.dex */
public class ClearTempService extends Service {
    private static final int DELETE_FILE_COUNT = 300;
    private static final int MAX_FILE_COUNT = 500;
    private volatile boolean interrupted = false;
    private Thread thread = null;
    private final Handler handler = new c(this);

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
        if (this.thread == null) {
            this.thread = new d(this);
            this.thread.start();
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
            if (!z) {
                deleteImageCacheByName();
            }
        }
    }

    private void deleteImageCacheByName() {
        String str = com.baidu.tbadk.core.util.s.mI + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME;
        for (int i = 0; i < 20; i++) {
            File file = new File(String.valueOf(str) + "/" + i);
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
}
