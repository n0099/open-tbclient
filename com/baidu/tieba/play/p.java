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
    private SensorManager fGO;
    private k fGP;
    private Sensor fGQ;
    private q fGT;
    private Activity mActivity;
    private boolean fGR = false;
    private boolean fGS = false;
    private boolean fGU = false;
    private boolean fGV = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.play.p.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && p.this.mActivity != null && p.this.fGV) {
                switch (message.what) {
                    case 1:
                        int requestedOrientation = p.this.mActivity.getRequestedOrientation();
                        int i = message.arg1;
                        if (!p.this.fGU) {
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
                            if (!p.this.fGS) {
                                if (i > 55 && i < 125) {
                                    if (requestedOrientation != 8) {
                                        p.this.mActivity.setRequestedOrientation(8);
                                    }
                                } else if (requestedOrientation != 0) {
                                    p.this.mActivity.setRequestedOrientation(0);
                                }
                            }
                            p.this.fGR = false;
                            return;
                        } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                            if (!p.this.fGR && requestedOrientation != 1) {
                                p.this.mActivity.setRequestedOrientation(1);
                            }
                            p.this.fGS = false;
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
    private q.a fGW = new q.a() { // from class: com.baidu.tieba.play.p.2
        @Override // com.baidu.tieba.play.q.a
        public void onChange(boolean z) {
            p.this.fGU = z;
        }
    };

    public void aGG() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.fGR = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.fGS = true;
        }
    }

    public p(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.fGO = (SensorManager) activity.getSystemService("sensor");
            this.fGQ = this.fGO.getDefaultSensor(1);
            this.fGP = new k(this.mHandler);
            this.mActivity.setRequestedOrientation(1);
            this.fGT = new q(this.mActivity, this.mHandler);
            this.fGT.a(this.fGW);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.fGT);
        }
    }

    public void start() {
        if (this.fGO != null) {
            this.fGO.registerListener(this.fGP, this.fGQ, 2);
        }
    }

    public void stop() {
        if (this.fGO != null) {
            this.fGO.unregisterListener(this.fGP);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.fGT);
        }
    }

    public void lw(boolean z) {
        this.fGV = z;
    }
}
