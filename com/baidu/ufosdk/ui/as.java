package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes22.dex */
final class as implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackFacePageActivity f3759a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f3759a = feedbackFacePageActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context applicationContext = this.f3759a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c != null) {
            handler = this.f3759a.v;
            handler.obtainMessage(0, c).sendToTarget();
        }
    }
}
