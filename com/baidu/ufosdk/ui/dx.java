package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes22.dex */
final class dx implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackReportActivity f3847a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dx(FeedbackReportActivity feedbackReportActivity) {
        this.f3847a = feedbackReportActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context applicationContext = this.f3847a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c != null) {
            handler = this.f3847a.K;
            handler.obtainMessage(0, c).sendToTarget();
        }
    }
}
