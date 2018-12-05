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
    private k gDS;
    private Sensor gDT;
    private p gDW;
    private Activity mActivity;
    private SensorManager mSensorManager;
    private boolean gDU = false;
    private boolean gDV = false;
    private boolean gDX = false;
    private boolean gDY = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.play.o.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && o.this.mActivity != null && o.this.gDY) {
                switch (message.what) {
                    case 1:
                        int requestedOrientation = o.this.mActivity.getRequestedOrientation();
                        int i = message.arg1;
                        if (!o.this.gDX) {
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
                            if (!o.this.gDV) {
                                if (i > 55 && i < 125) {
                                    if (requestedOrientation != 8) {
                                        o.this.mActivity.setRequestedOrientation(8);
                                    }
                                } else if (requestedOrientation != 0) {
                                    o.this.mActivity.setRequestedOrientation(0);
                                }
                            }
                            o.this.gDU = false;
                            return;
                        } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                            if (!o.this.gDU && requestedOrientation != 1) {
                                o.this.mActivity.setRequestedOrientation(1);
                            }
                            o.this.gDV = false;
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
    private p.a gDZ = new p.a() { // from class: com.baidu.tieba.play.o.2
        @Override // com.baidu.tieba.play.p.a
        public void onChange(boolean z) {
            o.this.gDX = z;
        }
    };

    public void aYK() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.gDU = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.gDV = true;
        }
    }

    public o(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.mSensorManager = (SensorManager) activity.getSystemService("sensor");
            this.gDT = this.mSensorManager.getDefaultSensor(1);
            this.gDS = new k(this.mHandler);
            this.mActivity.setRequestedOrientation(1);
            this.gDW = new p(this.mActivity, this.mHandler);
            this.gDW.a(this.gDZ);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.gDW);
        }
    }

    public void start() {
        if (this.mSensorManager != null) {
            this.mSensorManager.registerListener(this.gDS, this.gDT, 2);
        }
    }

    public void stop() {
        if (this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.gDS);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.gDW);
        }
    }

    public void mB(boolean z) {
        this.gDY = z;
    }
}
