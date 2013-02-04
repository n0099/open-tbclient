package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.b.t;
/* loaded from: classes.dex */
public class TiebaSyncService extends Service {
    private n a = null;
    private int b = 0;
    private t c = null;
    private Handler d = new Handler();
    private Runnable e = new m(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.a != null) {
            this.a.a();
        }
        this.a = new n(this, null);
        this.a.execute(new String[0]);
    }

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
        if (this.a != null) {
            this.a.a();
        }
        this.b = 11;
        this.d.removeCallbacks(this.e);
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        this.b = 0;
        a();
    }
}
