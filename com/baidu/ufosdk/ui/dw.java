package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class dw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f23195a;

    public dw(FeedbackReportActivity feedbackReportActivity) {
        this.f23195a = feedbackReportActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        int i;
        Handler handler2;
        com.baidu.ufosdk.e.a.a(this.f23195a.getApplicationContext());
        if (UfoSDK.clientid.length() != 0) {
            handler = this.f23195a.K;
            i = 1;
        } else {
            handler = this.f23195a.K;
            i = 4;
        }
        handler.obtainMessage(i, null).sendToTarget();
        Context applicationContext = this.f23195a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c2 = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c2 != null) {
            handler2 = this.f23195a.K;
            handler2.obtainMessage(0, c2).sendToTarget();
        }
    }
}
