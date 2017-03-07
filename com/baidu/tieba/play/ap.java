package com.baidu.tieba.play;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends Handler {
    final /* synthetic */ ao eWR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.eWR = aoVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Activity activity;
        boolean z;
        Activity activity2;
        boolean z2;
        boolean z3;
        Activity activity3;
        boolean z4;
        Activity activity4;
        Activity activity5;
        Activity activity6;
        Activity activity7;
        if (message != null) {
            activity = this.eWR.mActivity;
            if (activity != null) {
                z = this.eWR.eWP;
                if (z) {
                    switch (message.what) {
                        case 1:
                            activity2 = this.eWR.mActivity;
                            int requestedOrientation = activity2.getRequestedOrientation();
                            int i = message.arg1;
                            z2 = this.eWR.eWO;
                            if (!z2) {
                                if (i > 225 && i < 315) {
                                    if (requestedOrientation == 8) {
                                        activity7 = this.eWR.mActivity;
                                        activity7.setRequestedOrientation(0);
                                        return;
                                    }
                                    return;
                                } else if (i > 45 && i < 135 && requestedOrientation == 0) {
                                    activity6 = this.eWR.mActivity;
                                    activity6.setRequestedOrientation(8);
                                    return;
                                } else {
                                    return;
                                }
                            } else if ((i > 235 && i < 305) || (i > 55 && i < 125)) {
                                z4 = this.eWR.eWM;
                                if (!z4) {
                                    if (i > 55 && i < 125) {
                                        if (requestedOrientation != 8) {
                                            activity5 = this.eWR.mActivity;
                                            activity5.setRequestedOrientation(8);
                                        }
                                    } else if (requestedOrientation != 0) {
                                        activity4 = this.eWR.mActivity;
                                        activity4.setRequestedOrientation(0);
                                    }
                                }
                                this.eWR.eWL = false;
                                return;
                            } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                                z3 = this.eWR.eWL;
                                if (!z3 && requestedOrientation != 1) {
                                    activity3 = this.eWR.mActivity;
                                    activity3.setRequestedOrientation(1);
                                }
                                this.eWR.eWM = false;
                                return;
                            } else {
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        }
    }
}
