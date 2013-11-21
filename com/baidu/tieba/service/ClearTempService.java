package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.util.bg;
import java.io.File;
import java.util.Date;
/* loaded from: classes.dex */
public class ClearTempService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f2314a = false;
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
        this.f2314a = true;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        this.f2314a = false;
        if (this.b == null) {
            this.b = new b(this);
            this.b.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        File[] listFiles = file.listFiles();
        long time = new Date().getTime();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length && !this.f2314a; i++) {
                if (time - listFiles[i].lastModified() > 259200000 && !listFiles[i].delete()) {
                    bg.b(getClass().getName(), "run", "list[i].delete error");
                }
            }
        }
    }
}
