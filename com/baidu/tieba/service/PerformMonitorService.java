package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class PerformMonitorService extends Service {
    private com.baidu.adp.lib.debug.a.o mSRMonitor = null;
    private com.baidu.adp.lib.debug.a.h mGCMonitor = null;
    private com.baidu.adp.lib.debug.a.e mFpsMonitor = null;
    private com.baidu.adp.lib.debug.a.j mLogcatMonitor = null;
    private boolean isSampling = false;
    private j mTask = null;
    private Handler mHandler = null;
    public Runnable sampleRunnable = new g(this);

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mSRMonitor = new com.baidu.adp.lib.debug.a.o(getApplicationContext());
        this.mGCMonitor = new com.baidu.adp.lib.debug.a.h();
        this.mFpsMonitor = new com.baidu.adp.lib.debug.a.e(getApplicationContext());
        this.mLogcatMonitor = new com.baidu.adp.lib.debug.a.j();
        this.mHandler = new Handler();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.mTask == null && !this.isSampling) {
            monitorOn();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        monitorOff();
        super.onDestroy();
    }

    public void monitorOn() {
        try {
            if (!this.mSRMonitor.a()) {
                new Thread(this.mSRMonitor).start();
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        try {
            if (!this.mGCMonitor.a()) {
                this.mGCMonitor.b();
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
        try {
            if (!this.mLogcatMonitor.a()) {
                new Thread(this.mLogcatMonitor).start();
            }
        } catch (Exception e3) {
            BdLog.e(e3.toString());
        }
        try {
            if (!this.mFpsMonitor.a()) {
                this.mFpsMonitor.b();
            }
        } catch (Exception e4) {
            BdLog.e(e4.toString());
        }
        this.isSampling = true;
        new Thread(this.sampleRunnable).start();
        new Handler().postDelayed(new i(this), 10000L);
    }

    public void monitorOff() {
        try {
            if (this.mSRMonitor.a()) {
                this.mSRMonitor.c();
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        try {
            if (this.mGCMonitor.a()) {
                this.mGCMonitor.c();
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
        try {
            if (this.mLogcatMonitor.a()) {
                this.mLogcatMonitor.c();
            }
        } catch (Exception e3) {
            BdLog.e(e3.toString());
        }
        try {
            if (this.mFpsMonitor.a()) {
                this.mFpsMonitor.c();
            }
        } catch (Exception e4) {
            BdLog.e(e4.toString());
        }
        this.isSampling = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUpLoad() {
        if (this.mTask == null) {
            this.mTask = new j(this, null);
            this.mTask.execute(new String[0]);
        }
    }
}
