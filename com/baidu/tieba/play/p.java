package com.baidu.tieba.play;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import com.baidu.tieba.play.q;
/* loaded from: classes.dex */
public class p {
    private SensorManager fQN;
    private k fQO;
    private Sensor fQP;
    private q fQS;
    private Activity mActivity;
    private boolean fQQ = false;
    private boolean fQR = false;
    private boolean fQT = false;
    private boolean fQU = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.play.p.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && p.this.mActivity != null && p.this.fQU) {
                switch (message.what) {
                    case 1:
                        int requestedOrientation = p.this.mActivity.getRequestedOrientation();
                        int i = message.arg1;
                        if (!p.this.fQT) {
                            if (i > 225 && i < 315) {
                                if (requestedOrientation == 8) {
                                    p.this.mActivity.setRequestedOrientation(0);
                                    return;
                                }
                                return;
                            } else if (i > 45 && i < 135 && requestedOrientation == 0) {
                                p.this.mActivity.setRequestedOrientation(8);
                                return;
                            } else {
                                return;
                            }
                        } else if ((i > 235 && i < 305) || (i > 55 && i < 125)) {
                            if (!p.this.fQR) {
                                if (i > 55 && i < 125) {
                                    if (requestedOrientation != 8) {
                                        p.this.mActivity.setRequestedOrientation(8);
                                    }
                                } else if (requestedOrientation != 0) {
                                    p.this.mActivity.setRequestedOrientation(0);
                                }
                            }
                            p.this.fQQ = false;
                            return;
                        } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                            if (!p.this.fQQ && requestedOrientation != 1) {
                                p.this.mActivity.setRequestedOrientation(1);
                            }
                            p.this.fQR = false;
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
    private q.a fQV = new q.a() { // from class: com.baidu.tieba.play.p.2
        @Override // com.baidu.tieba.play.q.a
        public void onChange(boolean z) {
            p.this.fQT = z;
        }
    };

    public void aHw() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.fQQ = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.fQR = true;
        }
    }

    public p(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.fQN = (SensorManager) activity.getSystemService("sensor");
            this.fQP = this.fQN.getDefaultSensor(1);
            this.fQO = new k(this.mHandler);
            this.mActivity.setRequestedOrientation(1);
            this.fQS = new q(this.mActivity, this.mHandler);
            this.fQS.a(this.fQV);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.fQS);
        }
    }

    public void start() {
        if (this.fQN != null) {
            this.fQN.registerListener(this.fQO, this.fQP, 2);
        }
    }

    public void stop() {
        if (this.fQN != null) {
            this.fQN.unregisterListener(this.fQO);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.fQS);
        }
    }

    public void lZ(boolean z) {
        this.fQU = z;
    }
}
