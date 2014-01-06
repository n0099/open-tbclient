package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.model.ch;
import com.baidu.tieba.util.bo;
/* loaded from: classes.dex */
public class TiebaSyncService extends Service {
    private static String a = null;
    private r b = null;
    private int c = 0;
    private ch d = null;
    private Handler e = new Handler();
    private Runnable f = new q(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int d(TiebaSyncService tiebaSyncService) {
        int i = tiebaSyncService.c;
        tiebaSyncService.c = i + 1;
        return i;
    }

    public static void a(String str) {
        a = str;
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
            bo.a(getClass().getName(), "broadcastNewVersion", "sendBroadcast: " + String.format("%s", this.d.c().getNew_version()));
        }
    }
}
