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
    private SensorManager gcd;
    private k gce;
    private Sensor gcf;
    private p gci;
    private Activity mActivity;
    private boolean gcg = false;
    private boolean gch = false;
    private boolean gcj = false;
    private boolean gck = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.play.o.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && o.this.mActivity != null && o.this.gck) {
                switch (message.what) {
                    case 1:
                        int requestedOrientation = o.this.mActivity.getRequestedOrientation();
                        int i = message.arg1;
                        if (!o.this.gcj) {
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
                            if (!o.this.gch) {
                                if (i > 55 && i < 125) {
                                    if (requestedOrientation != 8) {
                                        o.this.mActivity.setRequestedOrientation(8);
                                    }
                                } else if (requestedOrientation != 0) {
                                    o.this.mActivity.setRequestedOrientation(0);
                                }
                            }
                            o.this.gcg = false;
                            return;
                        } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                            if (!o.this.gcg && requestedOrientation != 1) {
                                o.this.mActivity.setRequestedOrientation(1);
                            }
                            o.this.gch = false;
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
    private p.a gcl = new p.a() { // from class: com.baidu.tieba.play.o.2
        @Override // com.baidu.tieba.play.p.a
        public void onChange(boolean z) {
            o.this.gcj = z;
        }
    };

    public void aQp() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.gcg = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.gch = true;
        }
    }

    public o(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.gcd = (SensorManager) activity.getSystemService("sensor");
            this.gcf = this.gcd.getDefaultSensor(1);
            this.gce = new k(this.mHandler);
            this.mActivity.setRequestedOrientation(1);
            this.gci = new p(this.mActivity, this.mHandler);
            this.gci.a(this.gcl);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.gci);
        }
    }

    public void start() {
        if (this.gcd != null) {
            this.gcd.registerListener(this.gce, this.gcf, 2);
        }
    }

    public void stop() {
        if (this.gcd != null) {
            this.gcd.unregisterListener(this.gce);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.gci);
        }
    }

    public void lB(boolean z) {
        this.gck = z;
    }
}
