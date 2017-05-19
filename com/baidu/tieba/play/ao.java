package com.baidu.tieba.play;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.provider.Settings;
import com.baidu.tieba.play.ar;
/* loaded from: classes.dex */
public class ao {
    private SensorManager eSX;
    private aa eSY;
    private Sensor eSZ;
    private ar eTc;
    private Activity mActivity;
    private boolean eTa = false;
    private boolean eTb = false;
    private boolean eTd = false;
    private boolean eTe = false;
    private Handler mHandler = new ap(this);
    private ar.a eTf = new aq(this);

    public void awo() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.eTa = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.eTb = true;
        }
    }

    public ao(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.eSX = (SensorManager) activity.getSystemService("sensor");
            this.eSZ = this.eSX.getDefaultSensor(1);
            this.eSY = new aa(this.mHandler);
            this.mActivity.setRequestedOrientation(1);
            this.eTc = new ar(this.mActivity, this.mHandler);
            this.eTc.a(this.eTf);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.eTc);
        }
    }

    public void start() {
        if (this.eSX != null) {
            this.eSX.registerListener(this.eSY, this.eSZ, 2);
        }
    }

    public void stop() {
        if (this.eSX != null) {
            this.eSX.unregisterListener(this.eSY);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.eTc);
        }
    }

    public void kg(boolean z) {
        this.eTe = z;
    }
}
