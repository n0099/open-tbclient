package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class ar implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackFacePageActivity f23066a;

    public ar(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f23066a = feedbackFacePageActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        int i;
        Handler handler2;
        com.baidu.ufosdk.e.a.a(this.f23066a.getApplicationContext());
        if (UfoSDK.clientid.length() != 0) {
            handler = this.f23066a.v;
            i = 1;
        } else {
            handler = this.f23066a.v;
            i = 4;
        }
        handler.obtainMessage(i, null).sendToTarget();
        Context applicationContext = this.f23066a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c2 = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c2 != null) {
            handler2 = this.f23066a.v;
            handler2.obtainMessage(0, c2).sendToTarget();
        }
    }
}
