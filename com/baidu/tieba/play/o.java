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
    private SensorManager awS;
    private Sensor awU;
    private k juU;
    private p juV;
    private Activity mActivity;
    private boolean awV = false;
    private boolean awW = false;
    private boolean awY = false;
    private boolean awZ = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.play.o.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && o.this.mActivity != null && o.this.awZ) {
                switch (message.what) {
                    case 1:
                        int requestedOrientation = o.this.mActivity.getRequestedOrientation();
                        int i = message.arg1;
                        if (!o.this.awY) {
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
                            if (!o.this.awW) {
                                if (i > 55 && i < 125) {
                                    if (requestedOrientation != 8) {
                                        o.this.mActivity.setRequestedOrientation(8);
                                    }
                                } else if (requestedOrientation != 0) {
                                    o.this.mActivity.setRequestedOrientation(0);
                                }
                            }
                            o.this.awV = false;
                            return;
                        } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                            if (!o.this.awV && requestedOrientation != 1) {
                                o.this.mActivity.setRequestedOrientation(1);
                            }
                            o.this.awW = false;
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
    private p.a juW = new p.a() { // from class: com.baidu.tieba.play.o.2
        @Override // com.baidu.tieba.play.p.a
        public void onChange(boolean z) {
            o.this.awY = z;
        }
    };

    public void xH() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.awV = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.awW = true;
        }
    }

    public o(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.awS = (SensorManager) activity.getSystemService("sensor");
            this.awU = this.awS.getDefaultSensor(1);
            this.juU = new k(this.mHandler);
            if (!this.mActivity.getClass().getName().contains("SwanAppActivity")) {
                this.mActivity.setRequestedOrientation(1);
            }
            this.juV = new p(this.mActivity, this.mHandler);
            this.juV.a(this.juW);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.juV);
        }
    }

    public void start() {
        if (this.awS != null) {
            this.awS.registerListener(this.juU, this.awU, 2);
        }
    }

    public void stop() {
        if (this.awS != null) {
            this.awS.unregisterListener(this.juU);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.juV);
        }
    }

    public void bf(boolean z) {
        this.awZ = z;
    }
}
