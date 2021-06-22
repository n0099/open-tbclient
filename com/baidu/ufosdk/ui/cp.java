package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class cp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ co f22892a;

    public cp(co coVar) {
        this.f22892a = coVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String str3;
        Handler handler;
        int i2;
        FeedbackInputActivity feedbackInputActivity = this.f22892a.f22889b.f22877a;
        feedbackInputActivity.B = false;
        Context applicationContext = feedbackInputActivity.getApplicationContext();
        String str4 = UfoSDK.clientid;
        FeedbackInputActivity feedbackInputActivity2 = this.f22892a.f22889b.f22877a;
        String str5 = feedbackInputActivity2.f22778e;
        str = feedbackInputActivity2.ar;
        str2 = this.f22892a.f22891d;
        str3 = this.f22892a.f22889b.f22877a.aA;
        handler = this.f22892a.f22889b.f22877a.aK;
        i2 = this.f22892a.f22890c;
        feedbackInputActivity.a(applicationContext, str4, str5, str, str2, str3, (String) null, handler, i2);
    }
}
