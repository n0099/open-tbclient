package com.baidu.tieba.play;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import com.baidu.tieba.play.k;
/* loaded from: classes2.dex */
public class j {
    private SensorManager bnK;
    private Sensor bnM;
    private g lst;
    private k lsu;
    private Activity mActivity;
    private boolean bnN = false;
    private boolean bnO = false;
    private boolean bnQ = false;
    private boolean bnR = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && j.this.mActivity != null && j.this.bnR) {
                switch (message.what) {
                    case 1:
                        int requestedOrientation = j.this.mActivity.getRequestedOrientation();
                        int i = message.arg1;
                        if (!j.this.bnQ) {
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
                            if (!j.this.bnO) {
                                if (i > 55 && i < 125) {
                                    if (requestedOrientation != 8) {
                                        j.this.mActivity.setRequestedOrientation(8);
                                    }
                                } else if (requestedOrientation != 0) {
                                    j.this.mActivity.setRequestedOrientation(0);
                                }
                            }
                            j.this.bnN = false;
                            return;
                        } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                            if (!j.this.bnN && requestedOrientation != 1) {
                                j.this.mActivity.setRequestedOrientation(1);
                            }
                            j.this.bnO = false;
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
    private k.a lsv = new k.a() { // from class: com.baidu.tieba.play.j.2
        @Override // com.baidu.tieba.play.k.a
        public void onChange(boolean z) {
            j.this.bnQ = z;
        }
    };

    public void Oh() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.bnN = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.bnO = true;
        }
    }

    public j(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.bnK = (SensorManager) activity.getSystemService("sensor");
            this.bnM = this.bnK.getDefaultSensor(1);
            this.lst = new g(this.mHandler);
            if (!this.mActivity.getClass().getName().contains("SwanAppActivity")) {
                this.mActivity.setRequestedOrientation(1);
            }
            this.lsu = new k(this.mActivity, this.mHandler);
            this.lsu.a(this.lsv);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.lsu);
        }
    }

    public void start() {
        if (this.bnK != null) {
            this.bnK.registerListener(this.lst, this.bnM, 2);
        }
    }

    public void stop() {
        if (this.bnK != null) {
            this.bnK.unregisterListener(this.lst);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.lsu);
        }
    }

    public void cs(boolean z) {
        this.bnR = z;
    }
}
