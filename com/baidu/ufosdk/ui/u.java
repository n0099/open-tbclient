package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes8.dex */
final class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f5895a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FeedbackEditActivity feedbackEditActivity) {
        this.f5895a = feedbackEditActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        com.baidu.ufosdk.e.a.a(this.f5895a.getApplicationContext());
        Context applicationContext = this.f5895a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c != null) {
            handler = this.f5895a.af;
            handler.obtainMessage(0, c).sendToTarget();
        }
    }
}
