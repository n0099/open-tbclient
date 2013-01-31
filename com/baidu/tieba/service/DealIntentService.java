package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.tieba.c.af;
/* loaded from: classes.dex */
public class DealIntentService extends Service {
    private c a = null;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        af.a(getClass().getName(), "onStart", intent.getAction());
        a(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void a(Intent intent) {
        if (this.a != null) {
            this.a.a();
            this.a = null;
        }
        this.a = new c(this, intent);
        this.a.execute(new String[0]);
    }
}
