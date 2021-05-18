package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class cp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ co f22778a;

    public cp(co coVar) {
        this.f22778a = coVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String str3;
        Handler handler;
        int i2;
        FeedbackInputActivity feedbackInputActivity = this.f22778a.f22775b.f22763a;
        feedbackInputActivity.B = false;
        Context applicationContext = feedbackInputActivity.getApplicationContext();
        String str4 = UfoSDK.clientid;
        FeedbackInputActivity feedbackInputActivity2 = this.f22778a.f22775b.f22763a;
        String str5 = feedbackInputActivity2.f22664e;
        str = feedbackInputActivity2.ar;
        str2 = this.f22778a.f22777d;
        str3 = this.f22778a.f22775b.f22763a.aA;
        handler = this.f22778a.f22775b.f22763a.aK;
        i2 = this.f22778a.f22776c;
        feedbackInputActivity.a(applicationContext, str4, str5, str, str2, str3, (String) null, handler, i2);
    }
}
