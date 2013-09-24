package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.model.ce;
import com.baidu.tieba.util.av;
/* loaded from: classes.dex */
public class TiebaSyncService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private static String f1782a = null;
    private q b = null;
    private int c = 0;
    private ce d = null;
    private Handler e = new Handler();
    private Runnable f = new p(this);

    public static void a(String str) {
        f1782a = str;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.b != null) {
            this.b.cancel();
        }
        this.b = new q(this, null);
        this.b.execute(new String[0]);
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.b != null) {
            this.b.cancel();
        }
        this.c = 11;
        this.e.removeCallbacks(this.f);
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        this.c = 0;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.d != null) {
            sendBroadcast(new Intent("com.baidu.tieba.broadcast.sync"));
            av.a(getClass().getName(), "broadcastNewVersion", "sendBroadcast: " + String.format("%s", this.d.c().getNew_version()));
        }
    }
}
