package com.baidu.tieba.play;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.provider.Settings;
import com.baidu.tieba.play.ap;
/* loaded from: classes.dex */
public class am {
    private SensorManager eJH;
    private y eJI;
    private Sensor eJJ;
    private ap eJM;
    private Activity mActivity;
    private boolean eJK = false;
    private boolean eJL = false;
    private boolean eJN = false;
    private boolean eJO = false;
    private Handler mHandler = new an(this);
    private ap.a eJP = new ao(this);

    public void aWe() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.eJK = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.eJL = true;
        }
    }

    public am(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.eJH = (SensorManager) activity.getSystemService("sensor");
            this.eJJ = this.eJH.getDefaultSensor(1);
            this.eJI = new y(this.mHandler);
            this.mActivity.setRequestedOrientation(1);
            this.eJM = new ap(this.mActivity, this.mHandler);
            this.eJM.a(this.eJP);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.eJM);
        }
    }

    public void start() {
        if (this.eJH != null) {
            this.eJH.registerListener(this.eJI, this.eJJ, 2);
        }
    }

    public void stop() {
        if (this.eJH != null) {
            this.eJH.unregisterListener(this.eJI);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.eJM);
        }
    }

    public void kj(boolean z) {
        this.eJO = z;
    }
}
