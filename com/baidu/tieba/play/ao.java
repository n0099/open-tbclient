package com.baidu.tieba.play;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.provider.Settings;
import com.baidu.tieba.play.ar;
/* loaded from: classes.dex */
public class ao {
    private SensorManager eTb;
    private aa eTc;
    private Sensor eTd;
    private ar eTg;
    private Activity mActivity;
    private boolean eTe = false;
    private boolean eTf = false;
    private boolean eTh = false;
    private boolean eTi = false;
    private Handler mHandler = new ap(this);
    private ar.a eTj = new aq(this);

    public void azp() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.eTe = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.eTf = true;
        }
    }

    public ao(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.eTb = (SensorManager) activity.getSystemService("sensor");
            this.eTd = this.eTb.getDefaultSensor(1);
            this.eTc = new aa(this.mHandler);
            this.mActivity.setRequestedOrientation(1);
            this.eTg = new ar(this.mActivity, this.mHandler);
            this.eTg.a(this.eTj);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.eTg);
        }
    }

    public void start() {
        if (this.eTb != null) {
            this.eTb.registerListener(this.eTc, this.eTd, 2);
        }
    }

    public void stop() {
        if (this.eTb != null) {
            this.eTb.unregisterListener(this.eTc);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.eTg);
        }
    }

    public void kt(boolean z) {
        this.eTi = z;
    }
}
