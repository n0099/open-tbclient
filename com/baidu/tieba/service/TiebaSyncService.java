package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.model.cc;
import com.baidu.tieba.util.aq;
/* loaded from: classes.dex */
public class TiebaSyncService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private static String f1708a = null;
    private s b = null;
    private int c = 0;
    private cc d = null;
    private Handler e = new Handler();
    private Runnable f = new r(this);

    public static void a(String str) {
        f1708a = str;
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
        this.b = new s(this, null);
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
            aq.a(getClass().getName(), "broadcastNewVersion", "sendBroadcast: " + String.format("%s", this.d.c().getNew_version()));
        }
    }
}
