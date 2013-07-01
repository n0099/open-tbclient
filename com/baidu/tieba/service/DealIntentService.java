package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
/* loaded from: classes.dex */
public class DealIntentService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private c f1395a = null;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (intent != null) {
            a(intent);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void a(Intent intent) {
        if (this.f1395a != null) {
            this.f1395a.cancel();
            this.f1395a = null;
        }
        this.f1395a = new c(this, intent);
        this.f1395a.execute(new String[0]);
    }
}
