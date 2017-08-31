package com.baidu.tieba.keepLive.nativekeepalive;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
/* loaded from: classes.dex */
public class NativeGuardService2 extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }
}
