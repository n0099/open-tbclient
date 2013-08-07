package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
/* loaded from: classes.dex */
public class FatalErrorService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private d f1685a = null;

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
        if (this.f1685a != null) {
            this.f1685a.cancel();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.f1685a == null) {
            this.f1685a = new d(this, null);
            this.f1685a.execute(new String[0]);
        }
    }
}
