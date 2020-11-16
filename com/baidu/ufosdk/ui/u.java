package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes21.dex */
final class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f3890a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FeedbackEditActivity feedbackEditActivity) {
        this.f3890a = feedbackEditActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        com.baidu.ufosdk.e.a.a(this.f3890a.getApplicationContext());
        Context applicationContext = this.f3890a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c != null) {
            handler = this.f3890a.af;
            handler.obtainMessage(0, c).sendToTarget();
        }
    }
}
