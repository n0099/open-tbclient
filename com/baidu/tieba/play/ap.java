package com.baidu.tieba.play;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.provider.Settings;
import com.baidu.tieba.play.as;
/* loaded from: classes.dex */
public class ap {
    private SensorManager fma;
    private aa fmb;
    private Sensor fmc;
    private as fmf;
    private Activity mActivity;
    private boolean fmd = false;
    private boolean fme = false;
    private boolean fmg = false;
    private boolean fmh = false;
    private Handler mHandler = new aq(this);
    private as.a fmi = new ar(this);

    public void aBg() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.fmd = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.fme = true;
        }
    }

    public ap(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.fma = (SensorManager) activity.getSystemService("sensor");
            this.fmc = this.fma.getDefaultSensor(1);
            this.fmb = new aa(this.mHandler);
            this.mActivity.setRequestedOrientation(1);
            this.fmf = new as(this.mActivity, this.mHandler);
            this.fmf.a(this.fmi);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.fmf);
        }
    }

    public void start() {
        if (this.fma != null) {
            this.fma.registerListener(this.fmb, this.fmc, 2);
        }
    }

    public void stop() {
        if (this.fma != null) {
            this.fma.unregisterListener(this.fmb);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.fmf);
        }
    }

    public void la(boolean z) {
        this.fmh = z;
    }
}
