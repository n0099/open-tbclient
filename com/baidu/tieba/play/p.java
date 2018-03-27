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
    private SensorManager gvc;
    private k gvd;
    private Sensor gve;
    private q gvh;
    private Activity mActivity;
    private boolean gvf = false;
    private boolean gvg = false;
    private boolean gvi = false;
    private boolean gvj = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.play.p.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && p.this.mActivity != null && p.this.gvj) {
                switch (message.what) {
                    case 1:
                        int requestedOrientation = p.this.mActivity.getRequestedOrientation();
                        int i = message.arg1;
                        if (!p.this.gvi) {
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
                            if (!p.this.gvg) {
                                if (i > 55 && i < 125) {
                                    if (requestedOrientation != 8) {
                                        p.this.mActivity.setRequestedOrientation(8);
                                    }
                                } else if (requestedOrientation != 0) {
                                    p.this.mActivity.setRequestedOrientation(0);
                                }
                            }
                            p.this.gvf = false;
                            return;
                        } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                            if (!p.this.gvf && requestedOrientation != 1) {
                                p.this.mActivity.setRequestedOrientation(1);
                            }
                            p.this.gvg = false;
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
    private q.a gvk = new q.a() { // from class: com.baidu.tieba.play.p.2
        @Override // com.baidu.tieba.play.q.a
        public void onChange(boolean z) {
            p.this.gvi = z;
        }
    };

    public void aQu() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.gvf = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.gvg = true;
        }
    }

    public p(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.gvc = (SensorManager) activity.getSystemService("sensor");
            this.gve = this.gvc.getDefaultSensor(1);
            this.gvd = new k(this.mHandler);
            this.mActivity.setRequestedOrientation(1);
            this.gvh = new q(this.mActivity, this.mHandler);
            this.gvh.a(this.gvk);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.gvh);
        }
    }

    public void start() {
        if (this.gvc != null) {
            this.gvc.registerListener(this.gvd, this.gve, 2);
        }
    }

    public void stop() {
        if (this.gvc != null) {
            this.gvc.unregisterListener(this.gvd);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.gvh);
        }
    }

    public void lU(boolean z) {
        this.gvj = z;
    }
}
