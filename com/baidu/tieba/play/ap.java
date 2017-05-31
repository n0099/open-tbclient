package com.baidu.tieba.play;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.provider.Settings;
import com.baidu.tieba.play.as;
/* loaded from: classes.dex */
public class ap {
    private SensorManager fbK;
    private aa fbL;
    private Sensor fbM;
    private as fbP;
    private Activity mActivity;
    private boolean fbN = false;
    private boolean fbO = false;
    private boolean fbQ = false;
    private boolean fbR = false;
    private Handler mHandler = new aq(this);
    private as.a fbS = new ar(this);

    public void axh() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.fbN = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.fbO = true;
        }
    }

    public ap(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.fbK = (SensorManager) activity.getSystemService("sensor");
            this.fbM = this.fbK.getDefaultSensor(1);
            this.fbL = new aa(this.mHandler);
            this.mActivity.setRequestedOrientation(1);
            this.fbP = new as(this.mActivity, this.mHandler);
            this.fbP.a(this.fbS);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.fbP);
        }
    }

    public void start() {
        if (this.fbK != null) {
            this.fbK.registerListener(this.fbL, this.fbM, 2);
        }
    }

    public void stop() {
        if (this.fbK != null) {
            this.fbK.unregisterListener(this.fbL);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.fbP);
        }
    }

    public void kA(boolean z) {
        this.fbR = z;
    }
}
