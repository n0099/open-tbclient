package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes22.dex */
final class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f3893a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FeedbackEditActivity feedbackEditActivity) {
        this.f3893a = feedbackEditActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        com.baidu.ufosdk.e.a.a(this.f3893a.getApplicationContext());
        Context applicationContext = this.f3893a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c != null) {
            handler = this.f3893a.af;
            handler.obtainMessage(0, c).sendToTarget();
        }
    }
}
