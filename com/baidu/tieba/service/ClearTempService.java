package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.x;
import java.io.File;
import java.util.Date;
/* loaded from: classes.dex */
public class ClearTempService extends Service {
    private volatile boolean a = false;
    private Thread b = null;
    private final Handler c = new a(this);

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
    public void a(File file, boolean z) {
        try {
            File[] listFiles = file.listFiles();
            long time = new Date().getTime();
            int length = listFiles.length > 500 ? listFiles.length - 300 : 0;
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.a; i++) {
                    File file2 = listFiles[i];
                    if (file2.isDirectory()) {
                        a(file2, false);
                    } else if (length > 0 && i < length) {
                        if (!file2.delete()) {
                            BdLog.e(getClass().getName(), "run", "list[i].delete error");
                        }
                    } else if (time - listFiles[i].lastModified() > 259200000 && !file2.delete()) {
                        BdLog.e(getClass().getName(), "run", "list[i].delete error");
                    }
                }
            }
        } catch (Throwable th) {
            BdLog.e(ClearTempService.class, "deleteCache", th);
            if (!z) {
                a();
            }
        }
    }

    private void a() {
        String str = x.a + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME;
        for (int i = 0; i < 20; i++) {
            File file = new File(String.valueOf(str) + "/" + i);
            if (file.exists() && file.isDirectory()) {
                a(file, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        try {
            File[] listFiles = file.listFiles();
            long time = new Date().getTime();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.a; i++) {
                    if (time - listFiles[i].lastModified() > 259200000 && !listFiles[i].delete()) {
                        BdLog.e(getClass().getName(), "run", "list[i].delete error");
                    }
                }
            }
        } catch (Throwable th) {
            BdLog.e(ClearTempService.class, "deleteCache", th);
        }
    }
}
