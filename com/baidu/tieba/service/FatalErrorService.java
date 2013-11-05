package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
/* loaded from: classes.dex */
public class FatalErrorService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private e f2298a = null;

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
        if (this.f2298a != null) {
            this.f2298a.cancel();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.f2298a == null) {
            this.f2298a = new e(this);
            this.f2298a.execute(new String[0]);
        }
    }
}
