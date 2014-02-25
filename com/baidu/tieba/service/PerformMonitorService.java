package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
/* loaded from: classes.dex */
public class PerformMonitorService extends Service {
    private com.baidu.adp.lib.debug.a.o b = null;
    private com.baidu.adp.lib.debug.a.h c = null;
    private com.baidu.adp.lib.debug.a.e d = null;
    private com.baidu.adp.lib.debug.a.j e = null;
    private boolean f = false;
    private i g = null;
    private Handler h = null;
    public Runnable a = new f(this);

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.b = new com.baidu.adp.lib.debug.a.o(getApplicationContext());
        this.c = new com.baidu.adp.lib.debug.a.h();
        this.d = new com.baidu.adp.lib.debug.a.e(getApplicationContext());
        this.e = new com.baidu.adp.lib.debug.a.j();
        this.h = new Handler();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.g == null && !this.f) {
            a();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        b();
        super.onDestroy();
    }

    public void a() {
        try {
            if (!this.b.a()) {
                new Thread(this.b).start();
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "monitorOn", e.toString());
        }
        try {
            if (!this.c.a()) {
                this.c.b();
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "monitorOn", e2.toString());
        }
        try {
            if (!this.e.a()) {
                new Thread(this.e).start();
            }
        } catch (Exception e3) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "monitorOn", e3.toString());
        }
        try {
            if (!this.d.a()) {
                this.d.b();
            }
        } catch (Exception e4) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "monitorOn", e4.toString());
        }
        this.f = true;
        new Thread(this.a).start();
        new Handler().postDelayed(new h(this), 10000L);
    }

    public void b() {
        try {
            if (this.b.a()) {
                this.b.c();
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "monitorOff", e.toString());
        }
        try {
            if (this.c.a()) {
                this.c.c();
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "monitorOff", e2.toString());
        }
        try {
            if (this.e.a()) {
                this.e.c();
            }
        } catch (Exception e3) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "monitorOff", e3.toString());
        }
        try {
            if (this.d.a()) {
                this.d.c();
            }
        } catch (Exception e4) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "monitorOff", e4.toString());
        }
        this.f = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.g == null) {
            this.g = new i(this, null);
            this.g.execute(new String[0]);
        }
    }
}
