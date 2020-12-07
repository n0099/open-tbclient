package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes22.dex */
final class ba implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackHotActivity f3771a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(FeedbackHotActivity feedbackHotActivity) {
        this.f3771a = feedbackHotActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        com.baidu.ufosdk.e.a.a(this.f3771a.getApplicationContext());
        Context applicationContext = this.f3771a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c != null) {
            handler = this.f3771a.r;
            handler.obtainMessage(0, c).sendToTarget();
        }
        this.f3771a.a();
    }
}
