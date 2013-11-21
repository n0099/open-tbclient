package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.model.ci;
import com.baidu.tieba.util.bg;
/* loaded from: classes.dex */
public class TiebaSyncService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private static String f2321a = null;
    private r b = null;
    private int c = 0;
    private ci d = null;
    private Handler e = new Handler();
    private Runnable f = new q(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int d(TiebaSyncService tiebaSyncService) {
        int i = tiebaSyncService.c;
        tiebaSyncService.c = i + 1;
        return i;
    }

    public static void a(String str) {
        f2321a = str;
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
        this.b = new r(this, null);
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
            bg.a(getClass().getName(), "broadcastNewVersion", "sendBroadcast: " + String.format("%s", this.d.c().getNew_version()));
        }
    }
}
