package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.b.ar;
import com.baidu.tieba.model.bb;
/* loaded from: classes.dex */
public class TiebaSyncService extends Service {
    private static String a = null;
    private o b = null;
    private int c = 0;
    private bb d = null;
    private Handler e = new Handler();
    private Runnable f = new n(this);

    static {
        TbadkApplication.j().a(ar.class, TiebaSyncService.class);
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
        this.b = new o(this, (byte) 0);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(TiebaSyncService tiebaSyncService) {
        if (tiebaSyncService.d != null) {
            tiebaSyncService.sendBroadcast(new Intent(com.baidu.tieba.data.d.d()));
            com.baidu.adp.lib.util.f.a(tiebaSyncService.getClass().getName(), "broadcastNewVersion", "sendBroadcast: " + String.format("%s", tiebaSyncService.d.c().getNew_version()));
        }
    }
}
