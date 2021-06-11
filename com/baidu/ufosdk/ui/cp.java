package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class cp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ co f22810a;

    public cp(co coVar) {
        this.f22810a = coVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String str3;
        Handler handler;
        int i2;
        FeedbackInputActivity feedbackInputActivity = this.f22810a.f22807b.f22795a;
        feedbackInputActivity.B = false;
        Context applicationContext = feedbackInputActivity.getApplicationContext();
        String str4 = UfoSDK.clientid;
        FeedbackInputActivity feedbackInputActivity2 = this.f22810a.f22807b.f22795a;
        String str5 = feedbackInputActivity2.f22696e;
        str = feedbackInputActivity2.ar;
        str2 = this.f22810a.f22809d;
        str3 = this.f22810a.f22807b.f22795a.aA;
        handler = this.f22810a.f22807b.f22795a.aK;
        i2 = this.f22810a.f22808c;
        feedbackInputActivity.a(applicationContext, str4, str5, str, str2, str3, (String) null, handler, i2);
    }
}
