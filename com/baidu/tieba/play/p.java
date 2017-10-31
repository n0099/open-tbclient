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
    private SensorManager fGj;
    private k fGk;
    private Sensor fGl;
    private q fGo;
    private Activity mActivity;
    private boolean fGm = false;
    private boolean fGn = false;
    private boolean fGp = false;
    private boolean fGq = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.play.p.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && p.this.mActivity != null && p.this.fGq) {
                switch (message.what) {
                    case 1:
                        int requestedOrientation = p.this.mActivity.getRequestedOrientation();
                        int i = message.arg1;
                        if (!p.this.fGp) {
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
                            if (!p.this.fGn) {
                                if (i > 55 && i < 125) {
                                    if (requestedOrientation != 8) {
                                        p.this.mActivity.setRequestedOrientation(8);
                                    }
                                } else if (requestedOrientation != 0) {
                                    p.this.mActivity.setRequestedOrientation(0);
                                }
                            }
                            p.this.fGm = false;
                            return;
                        } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                            if (!p.this.fGm && requestedOrientation != 1) {
                                p.this.mActivity.setRequestedOrientation(1);
                            }
                            p.this.fGn = false;
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
    private q.a fGr = new q.a() { // from class: com.baidu.tieba.play.p.2
        @Override // com.baidu.tieba.play.q.a
        public void onChange(boolean z) {
            p.this.fGp = z;
        }
    };

    public void aGC() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.fGm = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.fGn = true;
        }
    }

    public p(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.fGj = (SensorManager) activity.getSystemService("sensor");
            this.fGl = this.fGj.getDefaultSensor(1);
            this.fGk = new k(this.mHandler);
            this.mActivity.setRequestedOrientation(1);
            this.fGo = new q(this.mActivity, this.mHandler);
            this.fGo.a(this.fGr);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.fGo);
        }
    }

    public void start() {
        if (this.fGj != null) {
            this.fGj.registerListener(this.fGk, this.fGl, 2);
        }
    }

    public void stop() {
        if (this.fGj != null) {
            this.fGj.unregisterListener(this.fGk);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.fGo);
        }
    }

    public void lq(boolean z) {
        this.fGq = z;
    }
}
