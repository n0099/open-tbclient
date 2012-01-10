package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.util.FileHelper;
import com.baidu.tieba.util.TiebaLog;
import java.io.File;
import java.util.Date;
/* loaded from: classes.dex */
public class ClearTempService extends Service {
    private volatile boolean interrupted = false;
    private Thread thread = null;
    private Handler handler = new Handler() { // from class: com.baidu.tieba.service.ClearTempService.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ClearTempService.this.stopSelf();
            ClearTempService.this.thread = null;
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.interrupted = true;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        this.interrupted = false;
        if (this.thread == null) {
            this.thread = new Thread() { // from class: com.baidu.tieba.service.ClearTempService.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    super.run();
                    try {
                        ClearTempService.this.deleteAllfile(ClearTempService.this.getCacheDir());
                        File file = new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + Config.TMP_PIC_DIR_NAME + "/");
                        File[] list = file.listFiles();
                        long current_time = new Date().getTime();
                        if (list != null) {
                            for (int i = 0; i < list.length && !ClearTempService.this.interrupted; i++) {
                                long temp = current_time - list[i].lastModified();
                                if (temp > 86400000) {
                                    list[i].delete();
                                }
                            }
                        }
                    } catch (Exception ex) {
                        TiebaLog.e(getClass().getName(), "run", ex.getMessage());
                    }
                    ClearTempService.this.handler.sendMessage(ClearTempService.this.handler.obtainMessage());
                }
            };
            this.thread.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteAllfile(File file) {
        if (file != null) {
            try {
                if (file.isDirectory()) {
                    File[] list = file.listFiles();
                    if (list != null) {
                        for (int i = 0; i < list.length && !this.interrupted; i++) {
                            if (list[i].isDirectory()) {
                                deleteAllfile(list[i]);
                            } else {
                                list[i].delete();
                            }
                        }
                        return;
                    }
                    return;
                }
                file.delete();
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "deleteAllfile", ex.getMessage());
            }
        }
    }
}
