package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes7.dex */
final class ar implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackFacePageActivity f3664a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f3664a = feedbackFacePageActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        com.baidu.ufosdk.e.a.a(this.f3664a.getApplicationContext());
        if (UfoSDK.clientid.length() != 0) {
            handler3 = this.f3664a.v;
            handler3.obtainMessage(1, null).sendToTarget();
        } else {
            handler = this.f3664a.v;
            handler.obtainMessage(4, null).sendToTarget();
        }
        Context applicationContext = this.f3664a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c != null) {
            handler2 = this.f3664a.v;
            handler2.obtainMessage(0, c).sendToTarget();
        }
    }
}
