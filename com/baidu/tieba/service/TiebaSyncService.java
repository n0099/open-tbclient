package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.model.br;
import com.baidu.tieba.util.z;
/* loaded from: classes.dex */
public class TiebaSyncService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private s f1402a = null;
    private int b = 0;
    private br c = null;
    private Handler d = new Handler();
    private Runnable e = new r(this);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f1402a != null) {
            this.f1402a.cancel();
        }
        this.f1402a = new s(this, null);
        this.f1402a.execute(new String[0]);
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.f1402a != null) {
            this.f1402a.cancel();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.c != null) {
            sendBroadcast(new Intent("com.baidu.tieba.broadcast.sync"));
            z.a(getClass().getName(), "broadcastNewVersion", "sendBroadcast: " + String.format("%s", this.c.c().getNew_version()));
        }
    }
}
