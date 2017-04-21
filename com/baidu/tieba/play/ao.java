package com.baidu.tieba.play;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.provider.Settings;
import com.baidu.tieba.play.ar;
/* loaded from: classes.dex */
public class ao {
    private SensorManager eWX;
    private aa eWY;
    private Sensor eWZ;
    private ar eXc;
    private Activity mActivity;
    private boolean eXa = false;
    private boolean eXb = false;
    private boolean eXd = false;
    private boolean eXe = false;
    private Handler mHandler = new ap(this);
    private ar.a eXf = new aq(this);

    public void azr() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.eXa = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.eXb = true;
        }
    }

    public ao(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.eWX = (SensorManager) activity.getSystemService("sensor");
            this.eWZ = this.eWX.getDefaultSensor(1);
            this.eWY = new aa(this.mHandler);
            this.mActivity.setRequestedOrientation(1);
            this.eXc = new ar(this.mActivity, this.mHandler);
            this.eXc.a(this.eXf);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.eXc);
        }
    }

    public void start() {
        if (this.eWX != null) {
            this.eWX.registerListener(this.eWY, this.eWZ, 2);
        }
    }

    public void stop() {
        if (this.eWX != null) {
            this.eWX.unregisterListener(this.eWY);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.eXc);
        }
    }

    public void kz(boolean z) {
        this.eXe = z;
    }
}
