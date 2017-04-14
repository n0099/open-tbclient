package com.baidu.tieba.play;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.provider.Settings;
import com.baidu.tieba.play.ar;
/* loaded from: classes.dex */
public class ao {
    private SensorManager eUH;
    private aa eUI;
    private Sensor eUJ;
    private ar eUM;
    private Activity mActivity;
    private boolean eUK = false;
    private boolean eUL = false;
    private boolean eUN = false;
    private boolean eUO = false;
    private Handler mHandler = new ap(this);
    private ar.a eUP = new aq(this);

    public void ayq() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.eUK = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.eUL = true;
        }
    }

    public ao(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.eUH = (SensorManager) activity.getSystemService("sensor");
            this.eUJ = this.eUH.getDefaultSensor(1);
            this.eUI = new aa(this.mHandler);
            this.mActivity.setRequestedOrientation(1);
            this.eUM = new ar(this.mActivity, this.mHandler);
            this.eUM.a(this.eUP);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.eUM);
        }
    }

    public void start() {
        if (this.eUH != null) {
            this.eUH.registerListener(this.eUI, this.eUJ, 2);
        }
    }

    public void stop() {
        if (this.eUH != null) {
            this.eUH.unregisterListener(this.eUI);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.eUM);
        }
    }

    public void kp(boolean z) {
        this.eUO = z;
    }
}
