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
    private SensorManager aXy;
    private k izI;
    private Sensor izJ;
    private p izM;
    private Activity mActivity;
    private boolean izK = false;
    private boolean izL = false;
    private boolean izN = false;
    private boolean izO = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.play.o.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && o.this.mActivity != null && o.this.izO) {
                switch (message.what) {
                    case 1:
                        int requestedOrientation = o.this.mActivity.getRequestedOrientation();
                        int i = message.arg1;
                        if (!o.this.izN) {
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
                            if (!o.this.izL) {
                                if (i > 55 && i < 125) {
                                    if (requestedOrientation != 8) {
                                        o.this.mActivity.setRequestedOrientation(8);
                                    }
                                } else if (requestedOrientation != 0) {
                                    o.this.mActivity.setRequestedOrientation(0);
                                }
                            }
                            o.this.izK = false;
                            return;
                        } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                            if (!o.this.izK && requestedOrientation != 1) {
                                o.this.mActivity.setRequestedOrientation(1);
                            }
                            o.this.izL = false;
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
    private p.a izP = new p.a() { // from class: com.baidu.tieba.play.o.2
        @Override // com.baidu.tieba.play.p.a
        public void onChange(boolean z) {
            o.this.izN = z;
        }
    };

    public void bLU() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.izK = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.izL = true;
        }
    }

    public o(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.aXy = (SensorManager) activity.getSystemService("sensor");
            this.izJ = this.aXy.getDefaultSensor(1);
            this.izI = new k(this.mHandler);
            if (!this.mActivity.getClass().getName().contains("SwanAppActivity")) {
                this.mActivity.setRequestedOrientation(1);
            }
            this.izM = new p(this.mActivity, this.mHandler);
            this.izM.a(this.izP);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.izM);
        }
    }

    public void start() {
        if (this.aXy != null) {
            this.aXy.registerListener(this.izI, this.izJ, 2);
        }
    }

    public void stop() {
        if (this.aXy != null) {
            this.aXy.unregisterListener(this.izI);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.izM);
        }
    }

    public void qj(boolean z) {
        this.izO = z;
    }
}
