package com.baidu.tieba.play;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.provider.Settings;
import com.baidu.tieba.play.ap;
/* loaded from: classes.dex */
public class am {
    private SensorManager fgp;
    private y fgq;
    private Sensor fgr;
    private ap fgu;
    private Activity mActivity;
    private boolean fgs = false;
    private boolean fgt = false;
    private boolean fgv = false;
    private boolean fgw = false;
    private Handler mHandler = new an(this);
    private ap.a fgx = new ao(this);

    public void bct() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.fgs = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.fgt = true;
        }
    }

    public am(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.fgp = (SensorManager) activity.getSystemService("sensor");
            this.fgr = this.fgp.getDefaultSensor(1);
            this.fgq = new y(this.mHandler);
            this.mActivity.setRequestedOrientation(1);
            this.fgu = new ap(this.mActivity, this.mHandler);
            this.fgu.a(this.fgx);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.fgu);
        }
    }

    public void start() {
        if (this.fgp != null) {
            this.fgp.registerListener(this.fgq, this.fgr, 2);
        }
    }

    public void stop() {
        if (this.fgp != null) {
            this.fgp.unregisterListener(this.fgq);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.fgu);
        }
    }

    public void kz(boolean z) {
        this.fgw = z;
    }
}
