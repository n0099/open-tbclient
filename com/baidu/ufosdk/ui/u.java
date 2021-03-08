package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes7.dex */
final class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f3796a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FeedbackEditActivity feedbackEditActivity) {
        this.f3796a = feedbackEditActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        com.baidu.ufosdk.e.a.a(this.f3796a.getApplicationContext());
        Context applicationContext = this.f3796a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c != null) {
            handler = this.f3796a.af;
            handler.obtainMessage(0, c).sendToTarget();
        }
    }
}
