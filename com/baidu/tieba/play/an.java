package com.baidu.tieba.play;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends Handler {
    final /* synthetic */ am eJQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.eJQ = amVar;
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
            activity = this.eJQ.mActivity;
            if (activity != null) {
                z = this.eJQ.eJO;
                if (z) {
                    switch (message.what) {
                        case 1:
                            activity2 = this.eJQ.mActivity;
                            int requestedOrientation = activity2.getRequestedOrientation();
                            int i = message.arg1;
                            z2 = this.eJQ.eJN;
                            if (!z2) {
                                if (i > 225 && i < 315) {
                                    if (requestedOrientation == 8) {
                                        activity7 = this.eJQ.mActivity;
                                        activity7.setRequestedOrientation(0);
                                        return;
                                    }
                                    return;
                                } else if (i > 45 && i < 135 && requestedOrientation == 0) {
                                    activity6 = this.eJQ.mActivity;
                                    activity6.setRequestedOrientation(8);
                                    return;
                                } else {
                                    return;
                                }
                            } else if ((i > 235 && i < 305) || (i > 55 && i < 125)) {
                                z4 = this.eJQ.eJL;
                                if (!z4) {
                                    if (i > 55 && i < 125) {
                                        if (requestedOrientation != 8) {
                                            activity5 = this.eJQ.mActivity;
                                            activity5.setRequestedOrientation(8);
                                        }
                                    } else if (requestedOrientation != 0) {
                                        activity4 = this.eJQ.mActivity;
                                        activity4.setRequestedOrientation(0);
                                    }
                                }
                                this.eJQ.eJK = false;
                                return;
                            } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                                z3 = this.eJQ.eJK;
                                if (!z3 && requestedOrientation != 1) {
                                    activity3 = this.eJQ.mActivity;
                                    activity3.setRequestedOrientation(1);
                                }
                                this.eJQ.eJL = false;
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
