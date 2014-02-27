package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import java.io.File;
import java.util.Date;
/* loaded from: classes.dex */
public class ClearTempService extends Service {
    private volatile boolean a = false;
    private Thread b = null;
    private Handler c = new a(this);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.a = true;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        this.a = false;
        if (this.b == null) {
            this.b = new b(this);
            this.b.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        File[] listFiles = file.listFiles();
        long time = new Date().getTime();
        int length = listFiles.length > 500 ? listFiles.length - 300 : 0;
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length && !this.a; i++) {
                File file2 = listFiles[i];
                if (file2.isDirectory()) {
                    a(file2);
                } else if (length > 0 && i < length) {
                    if (!file2.delete()) {
                        com.baidu.adp.lib.util.e.b(getClass().getName(), "run", "list[i].delete error");
                    }
                } else if (time - listFiles[i].lastModified() > 259200000 && !file2.delete()) {
                    com.baidu.adp.lib.util.e.b(getClass().getName(), "run", "list[i].delete error");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(ClearTempService clearTempService, File file) {
        File[] listFiles = file.listFiles();
        long time = new Date().getTime();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length && !clearTempService.a; i++) {
                if (time - listFiles[i].lastModified() > 259200000 && !listFiles[i].delete()) {
                    com.baidu.adp.lib.util.e.b(clearTempService.getClass().getName(), "run", "list[i].delete error");
                }
            }
        }
    }
}
