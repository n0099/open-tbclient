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
    private SensorManager aTw;
    private k hXQ;
    private Sensor hXR;
    private p hXU;
    private Activity mActivity;
    private boolean hXS = false;
    private boolean hXT = false;
    private boolean hXV = false;
    private boolean hXW = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.play.o.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && o.this.mActivity != null && o.this.hXW) {
                switch (message.what) {
                    case 1:
                        int requestedOrientation = o.this.mActivity.getRequestedOrientation();
                        int i = message.arg1;
                        if (!o.this.hXV) {
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
                            if (!o.this.hXT) {
                                if (i > 55 && i < 125) {
                                    if (requestedOrientation != 8) {
                                        o.this.mActivity.setRequestedOrientation(8);
                                    }
                                } else if (requestedOrientation != 0) {
                                    o.this.mActivity.setRequestedOrientation(0);
                                }
                            }
                            o.this.hXS = false;
                            return;
                        } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                            if (!o.this.hXS && requestedOrientation != 1) {
                                o.this.mActivity.setRequestedOrientation(1);
                            }
                            o.this.hXT = false;
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
    private p.a hXX = new p.a() { // from class: com.baidu.tieba.play.o.2
        @Override // com.baidu.tieba.play.p.a
        public void onChange(boolean z) {
            o.this.hXV = z;
        }
    };

    public void bAB() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.hXS = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.hXT = true;
        }
    }

    public o(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.aTw = (SensorManager) activity.getSystemService("sensor");
            this.hXR = this.aTw.getDefaultSensor(1);
            this.hXQ = new k(this.mHandler);
            this.mActivity.setRequestedOrientation(1);
            this.hXU = new p(this.mActivity, this.mHandler);
            this.hXU.a(this.hXX);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.hXU);
        }
    }

    public void start() {
        if (this.aTw != null) {
            this.aTw.registerListener(this.hXQ, this.hXR, 2);
        }
    }

    public void stop() {
        if (this.aTw != null) {
            this.aTw.unregisterListener(this.hXQ);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.hXU);
        }
    }

    public void pc(boolean z) {
        this.hXW = z;
    }
}
