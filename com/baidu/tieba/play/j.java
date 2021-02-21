package com.baidu.tieba.play;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import com.baidu.tieba.play.k;
/* loaded from: classes.dex */
public class j {
    private Activity mActivity;
    private g mHK;
    private k mHL;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private boolean bJY = false;
    private boolean bJZ = false;
    private boolean bKb = false;
    private boolean bKc = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && j.this.mActivity != null && j.this.bKc) {
                switch (message.what) {
                    case 1:
                        int requestedOrientation = j.this.mActivity.getRequestedOrientation();
                        int i = message.arg1;
                        if (!j.this.bKb) {
                            if (i > 225 && i < 315) {
                                if (requestedOrientation == 8) {
                                    j.this.mActivity.setRequestedOrientation(0);
                                    return;
                                }
                                return;
                            } else if (i > 45 && i < 135 && requestedOrientation == 0) {
                                j.this.mActivity.setRequestedOrientation(8);
                                return;
                            } else {
                                return;
                            }
                        } else if ((i > 235 && i < 305) || (i > 55 && i < 125)) {
                            if (!j.this.bJZ) {
                                if (i > 55 && i < 125) {
                                    if (requestedOrientation != 8) {
                                        j.this.mActivity.setRequestedOrientation(8);
                                    }
                                } else if (requestedOrientation != 0) {
                                    j.this.mActivity.setRequestedOrientation(0);
                                }
                            }
                            j.this.bJY = false;
                            return;
                        } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                            if (!j.this.bJY && requestedOrientation != 1) {
                                j.this.mActivity.setRequestedOrientation(1);
                            }
                            j.this.bJZ = false;
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };
    private k.a mHM = new k.a() { // from class: com.baidu.tieba.play.j.2
        @Override // com.baidu.tieba.play.k.a
        public void onChange(boolean z) {
            j.this.bKb = z;
        }
    };

    public void TZ() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.bJY = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.bJZ = true;
        }
    }

    public j(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.mSensorManager = (SensorManager) activity.getSystemService("sensor");
            this.mSensor = this.mSensorManager.getDefaultSensor(1);
            this.mHK = new g(this.mHandler);
            if (!this.mActivity.getClass().getName().contains("SwanAppActivity")) {
                this.mActivity.setRequestedOrientation(1);
            }
            this.mHL = new k(this.mActivity, this.mHandler);
            this.mHL.a(this.mHM);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.mHL);
        }
    }

    public void start() {
        if (this.mSensorManager != null) {
            this.mSensorManager.registerListener(this.mHK, this.mSensor, 2);
        }
    }

    public void stop() {
        if (this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.mHK);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.mHL);
        }
    }

    public void dh(boolean z) {
        this.bKc = z;
    }
}
