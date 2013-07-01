package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
/* loaded from: classes.dex */
public class ClearTempService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f1394a = false;
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
        this.f1394a = true;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        this.f1394a = false;
        if (this.b == null) {
            this.b = new b(this);
            this.b.start();
        }
    }
}
