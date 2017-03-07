package com.baidu.tieba.play;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.provider.Settings;
import com.baidu.tieba.play.ar;
/* loaded from: classes.dex */
public class ao {
    private SensorManager eWI;
    private aa eWJ;
    private Sensor eWK;
    private ar eWN;
    private Activity mActivity;
    private boolean eWL = false;
    private boolean eWM = false;
    private boolean eWO = false;
    private boolean eWP = false;
    private Handler mHandler = new ap(this);
    private ar.a eWQ = new aq(this);

    public void ayM() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.eWL = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.eWM = true;
        }
    }

    public ao(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.eWI = (SensorManager) activity.getSystemService("sensor");
            this.eWK = this.eWI.getDefaultSensor(1);
            this.eWJ = new aa(this.mHandler);
            this.mActivity.setRequestedOrientation(1);
            this.eWN = new ar(this.mActivity, this.mHandler);
            this.eWN.a(this.eWQ);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.eWN);
        }
    }

    public void start() {
        if (this.eWI != null) {
            this.eWI.registerListener(this.eWJ, this.eWK, 2);
        }
    }

    public void stop() {
        if (this.eWI != null) {
            this.eWI.unregisterListener(this.eWJ);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.eWN);
        }
    }

    public void kq(boolean z) {
        this.eWP = z;
    }
}
