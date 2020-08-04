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
    private SensorManager bic;
    private Sensor bif;
    private g lcd;
    private k lce;
    private Activity mActivity;
    private boolean bih = false;
    private boolean bii = false;
    private boolean bik = false;
    private boolean bil = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && j.this.mActivity != null && j.this.bil) {
                switch (message.what) {
                    case 1:
                        int requestedOrientation = j.this.mActivity.getRequestedOrientation();
                        int i = message.arg1;
                        if (!j.this.bik) {
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
                            if (!j.this.bii) {
                                if (i > 55 && i < 125) {
                                    if (requestedOrientation != 8) {
                                        j.this.mActivity.setRequestedOrientation(8);
                                    }
                                } else if (requestedOrientation != 0) {
                                    j.this.mActivity.setRequestedOrientation(0);
                                }
                            }
                            j.this.bih = false;
                            return;
                        } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                            if (!j.this.bih && requestedOrientation != 1) {
                                j.this.mActivity.setRequestedOrientation(1);
                            }
                            j.this.bii = false;
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
    private k.a lcf = new k.a() { // from class: com.baidu.tieba.play.j.2
        @Override // com.baidu.tieba.play.k.a
        public void onChange(boolean z) {
            j.this.bik = z;
        }
    };

    public void Io() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.bih = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.bii = true;
        }
    }

    public j(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.bic = (SensorManager) activity.getSystemService("sensor");
            this.bif = this.bic.getDefaultSensor(1);
            this.lcd = new g(this.mHandler);
            if (!this.mActivity.getClass().getName().contains("SwanAppActivity")) {
                this.mActivity.setRequestedOrientation(1);
            }
            this.lce = new k(this.mActivity, this.mHandler);
            this.lce.a(this.lcf);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.lce);
        }
    }

    public void start() {
        if (this.bic != null) {
            this.bic.registerListener(this.lcd, this.bif, 2);
        }
    }

    public void stop() {
        if (this.bic != null) {
            this.bic.unregisterListener(this.lcd);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.lce);
        }
    }

    public void cj(boolean z) {
        this.bil = z;
    }
}
