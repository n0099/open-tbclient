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
    private k gxc;
    private Sensor gxd;
    private p gxg;
    private Activity mActivity;
    private SensorManager mSensorManager;
    private boolean gxe = false;
    private boolean gxf = false;
    private boolean gxh = false;
    private boolean gxi = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.play.o.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && o.this.mActivity != null && o.this.gxi) {
                switch (message.what) {
                    case 1:
                        int requestedOrientation = o.this.mActivity.getRequestedOrientation();
                        int i = message.arg1;
                        if (!o.this.gxh) {
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
                            if (!o.this.gxf) {
                                if (i > 55 && i < 125) {
                                    if (requestedOrientation != 8) {
                                        o.this.mActivity.setRequestedOrientation(8);
                                    }
                                } else if (requestedOrientation != 0) {
                                    o.this.mActivity.setRequestedOrientation(0);
                                }
                            }
                            o.this.gxe = false;
                            return;
                        } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                            if (!o.this.gxe && requestedOrientation != 1) {
                                o.this.mActivity.setRequestedOrientation(1);
                            }
                            o.this.gxf = false;
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
    private p.a gxj = new p.a() { // from class: com.baidu.tieba.play.o.2
        @Override // com.baidu.tieba.play.p.a
        public void onChange(boolean z) {
            o.this.gxh = z;
        }
    };

    public void aWS() {
        if (this.mActivity != null) {
            if (this.mActivity.getRequestedOrientation() == 1) {
                this.mActivity.setRequestedOrientation(0);
                this.gxe = true;
                return;
            }
            this.mActivity.setRequestedOrientation(1);
            this.gxf = true;
        }
    }

    public o(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
            this.mSensorManager = (SensorManager) activity.getSystemService("sensor");
            this.gxd = this.mSensorManager.getDefaultSensor(1);
            this.gxc = new k(this.mHandler);
            this.mActivity.setRequestedOrientation(1);
            this.gxg = new p(this.mActivity, this.mHandler);
            this.gxg.a(this.gxj);
            this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.gxg);
        }
    }

    public void start() {
        if (this.mSensorManager != null) {
            this.mSensorManager.registerListener(this.gxc, this.gxd, 2);
        }
    }

    public void stop() {
        if (this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.gxc);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mActivity != null) {
            this.mActivity.getContentResolver().unregisterContentObserver(this.gxg);
        }
    }

    public void my(boolean z) {
        this.gxi = z;
    }
}
