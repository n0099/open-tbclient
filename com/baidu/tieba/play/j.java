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
    private SensorManager bCN;
    private Sensor bCP;
    private Activity mActivity;
    private g mji;
    private k mjj;
    private boolean bCQ = false;
    private boolean bCR = false;
    private boolean bCT = false;
    private boolean bCU = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && j.this.mActivity != null && j.this.bCU) {
                switch (message.what) {
                    case 1:
                        int requestedOrientation = j.this.mActivity.getRequestedOrientation();
                        int i = message.arg1;
                        if (!j.this.bCT) {
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
                            if (!j.this.bCR) {
                                if (i > 55 && i < 125) {
                                    if (requestedOrientation != 8) {
                                        j.this.mActivity.setRequestedOrientation(8);
                                    }
                                } else if (requestedOrientation != 0) {
                                    j.this.mActivity.setRequestedOrientation(0);
                                }
                            }
                            j.this.bCQ = false;
                            return;
                        } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                            if (!j.this.bCQ && requestedOrientation != 1) {
                                j.this.mActivity.setRequestedOrientation(1);
                            }
                            j.this.bCR = false;
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
    private k.a mjk = new k.a() { // from class: com.baidu.tieba.play.j.2
        @Override // com.baidu.tieba.play.k.a
        public void onChange(boolean z) {
            j.this.bCT = z;
        }
    };

    public void Tq() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.bCQ = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.bCR = true;
        }
    }

    public j(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.bCN = (SensorManager) activity.getSystemService("sensor");
            this.bCP = this.bCN.getDefaultSensor(1);
            this.mji = new g(this.mHandler);
            if (!this.mActivity.getClass().getName().contains("SwanAppActivity")) {
                this.mActivity.setRequestedOrientation(1);
            }
            this.mjj = new k(this.mActivity, this.mHandler);
            this.mjj.a(this.mjk);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.mjj);
        }
    }

    public void start() {
        if (this.bCN != null) {
            this.bCN.registerListener(this.mji, this.bCP, 2);
        }
    }

    public void stop() {
        if (this.bCN != null) {
            this.bCN.unregisterListener(this.mji);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.mjj);
        }
    }

    public void cK(boolean z) {
        this.bCU = z;
    }
}
