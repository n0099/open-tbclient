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
    private SensorManager bGk;
    private Sensor bGm;
    private Activity mActivity;
    private g mxF;
    private k mxG;
    private boolean bGn = false;
    private boolean bGo = false;
    private boolean bGq = false;
    private boolean bGr = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && j.this.mActivity != null && j.this.bGr) {
                switch (message.what) {
                    case 1:
                        int requestedOrientation = j.this.mActivity.getRequestedOrientation();
                        int i = message.arg1;
                        if (!j.this.bGq) {
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
                            if (!j.this.bGo) {
                                if (i > 55 && i < 125) {
                                    if (requestedOrientation != 8) {
                                        j.this.mActivity.setRequestedOrientation(8);
                                    }
                                } else if (requestedOrientation != 0) {
                                    j.this.mActivity.setRequestedOrientation(0);
                                }
                            }
                            j.this.bGn = false;
                            return;
                        } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                            if (!j.this.bGn && requestedOrientation != 1) {
                                j.this.mActivity.setRequestedOrientation(1);
                            }
                            j.this.bGo = false;
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
    private k.a mxH = new k.a() { // from class: com.baidu.tieba.play.j.2
        @Override // com.baidu.tieba.play.k.a
        public void onChange(boolean z) {
            j.this.bGq = z;
        }
    };

    public void Vh() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.bGn = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.bGo = true;
        }
    }

    public j(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.bGk = (SensorManager) activity.getSystemService("sensor");
            this.bGm = this.bGk.getDefaultSensor(1);
            this.mxF = new g(this.mHandler);
            if (!this.mActivity.getClass().getName().contains("SwanAppActivity")) {
                this.mActivity.setRequestedOrientation(1);
            }
            this.mxG = new k(this.mActivity, this.mHandler);
            this.mxG.a(this.mxH);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.mxG);
        }
    }

    public void start() {
        if (this.bGk != null) {
            this.bGk.registerListener(this.mxF, this.bGm, 2);
        }
    }

    public void stop() {
        if (this.bGk != null) {
            this.bGk.unregisterListener(this.mxF);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.mxG);
        }
    }

    public void da(boolean z) {
        this.bGr = z;
    }
}
