package com.baidu.tieba.play;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import com.baidu.tieba.play.p;
/* loaded from: classes.dex */
public class o {
    private k gHN;
    private Sensor gHO;
    private p gHR;
    private Activity mActivity;
    private SensorManager mSensorManager;
    private boolean gHP = false;
    private boolean gHQ = false;
    private boolean gHS = false;
    private boolean gHT = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.play.o.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && o.this.mActivity != null && o.this.gHT) {
                switch (message.what) {
                    case 1:
                        int requestedOrientation = o.this.mActivity.getRequestedOrientation();
                        int i = message.arg1;
                        if (!o.this.gHS) {
                            if (i > 225 && i < 315) {
                                if (requestedOrientation == 8) {
                                    o.this.mActivity.setRequestedOrientation(0);
                                    return;
                                }
                                return;
                            } else if (i > 45 && i < 135 && requestedOrientation == 0) {
                                o.this.mActivity.setRequestedOrientation(8);
                                return;
                            } else {
                                return;
                            }
                        } else if ((i > 235 && i < 305) || (i > 55 && i < 125)) {
                            if (!o.this.gHQ) {
                                if (i > 55 && i < 125) {
                                    if (requestedOrientation != 8) {
                                        o.this.mActivity.setRequestedOrientation(8);
                                    }
                                } else if (requestedOrientation != 0) {
                                    o.this.mActivity.setRequestedOrientation(0);
                                }
                            }
                            o.this.gHP = false;
                            return;
                        } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                            if (!o.this.gHP && requestedOrientation != 1) {
                                o.this.mActivity.setRequestedOrientation(1);
                            }
                            o.this.gHQ = false;
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
    private p.a gHU = new p.a() { // from class: com.baidu.tieba.play.o.2
        @Override // com.baidu.tieba.play.p.a
        public void onChange(boolean z) {
            o.this.gHS = z;
        }
    };

    public void aZX() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.gHP = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.gHQ = true;
        }
    }

    public o(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.mSensorManager = (SensorManager) activity.getSystemService("sensor");
            this.gHO = this.mSensorManager.getDefaultSensor(1);
            this.gHN = new k(this.mHandler);
            this.mActivity.setRequestedOrientation(1);
            this.gHR = new p(this.mActivity, this.mHandler);
            this.gHR.a(this.gHU);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.gHR);
        }
    }

    public void start() {
        if (this.mSensorManager != null) {
            this.mSensorManager.registerListener(this.gHN, this.gHO, 2);
        }
    }

    public void stop() {
        if (this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.gHN);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.gHR);
        }
    }

    public void mE(boolean z) {
        this.gHT = z;
    }
}
