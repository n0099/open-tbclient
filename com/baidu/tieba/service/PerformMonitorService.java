package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class PerformMonitorService extends Service {
    private com.baidu.adp.lib.debug.a.p mSRMonitor = null;
    private com.baidu.adp.lib.debug.a.i mGCMonitor = null;
    private com.baidu.adp.lib.debug.a.e mFpsMonitor = null;
    private com.baidu.adp.lib.debug.a.k mLogcatMonitor = null;
    private boolean isSampling = false;
    private m mTask = null;
    private Handler mHandler = null;
    public Runnable sampleRunnable = new j(this);

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mSRMonitor = new com.baidu.adp.lib.debug.a.p(getApplicationContext());
        this.mGCMonitor = new com.baidu.adp.lib.debug.a.i();
        this.mFpsMonitor = new com.baidu.adp.lib.debug.a.e(getApplicationContext());
        this.mLogcatMonitor = new com.baidu.adp.lib.debug.a.k();
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
            if (!this.mSRMonitor.cJ()) {
                new Thread(this.mSRMonitor).start();
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        try {
            if (!this.mGCMonitor.cJ()) {
                this.mGCMonitor.start();
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
        try {
            if (!this.mLogcatMonitor.cJ()) {
                new Thread(this.mLogcatMonitor).start();
            }
        } catch (Exception e3) {
            BdLog.e(e3.toString());
        }
        try {
            if (!this.mFpsMonitor.cJ()) {
                this.mFpsMonitor.start();
            }
        } catch (Exception e4) {
            BdLog.e(e4.toString());
        }
        this.isSampling = true;
        new Thread(this.sampleRunnable).start();
        new Handler().postDelayed(new l(this), 10000L);
    }

    public void monitorOff() {
        try {
            if (this.mSRMonitor.cJ()) {
                this.mSRMonitor.stop();
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        try {
            if (this.mGCMonitor.cJ()) {
                this.mGCMonitor.stop();
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
        try {
            if (this.mLogcatMonitor.cJ()) {
                this.mLogcatMonitor.stop();
            }
        } catch (Exception e3) {
            BdLog.e(e3.toString());
        }
        try {
            if (this.mFpsMonitor.cJ()) {
                this.mFpsMonitor.stop();
            }
        } catch (Exception e4) {
            BdLog.e(e4.toString());
        }
        this.isSampling = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUpLoad() {
        if (this.mTask == null) {
            this.mTask = new m(this, null);
            this.mTask.execute(new String[0]);
        }
    }
}
