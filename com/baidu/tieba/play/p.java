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
    private SensorManager fxs;
    private k fxt;
    private Sensor fxu;
    private q fxx;
    private Activity mActivity;
    private boolean fxv = false;
    private boolean fxw = false;
    private boolean fxy = false;
    private boolean fxz = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.play.p.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && p.this.mActivity != null && p.this.fxz) {
                switch (message.what) {
                    case 1:
                        int requestedOrientation = p.this.mActivity.getRequestedOrientation();
                        int i = message.arg1;
                        if (!p.this.fxy) {
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
                            if (!p.this.fxw) {
                                if (i > 55 && i < 125) {
                                    if (requestedOrientation != 8) {
                                        p.this.mActivity.setRequestedOrientation(8);
                                    }
                                } else if (requestedOrientation != 0) {
                                    p.this.mActivity.setRequestedOrientation(0);
                                }
                            }
                            p.this.fxv = false;
                            return;
                        } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                            if (!p.this.fxv && requestedOrientation != 1) {
                                p.this.mActivity.setRequestedOrientation(1);
                            }
                            p.this.fxw = false;
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
    private q.a fxA = new q.a() { // from class: com.baidu.tieba.play.p.2
        @Override // com.baidu.tieba.play.q.a
        public void onChange(boolean z) {
            p.this.fxy = z;
        }
    };

    public void aEh() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.fxv = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.fxw = true;
        }
    }

    public p(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.fxs = (SensorManager) activity.getSystemService("sensor");
            this.fxu = this.fxs.getDefaultSensor(1);
            this.fxt = new k(this.mHandler);
            this.mActivity.setRequestedOrientation(1);
            this.fxx = new q(this.mActivity, this.mHandler);
            this.fxx.a(this.fxA);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.fxx);
        }
    }

    public void start() {
        if (this.fxs != null) {
            this.fxs.registerListener(this.fxt, this.fxu, 2);
        }
    }

    public void stop() {
        if (this.fxs != null) {
            this.fxs.unregisterListener(this.fxt);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.fxx);
        }
    }

    public void lv(boolean z) {
        this.fxz = z;
    }
}
