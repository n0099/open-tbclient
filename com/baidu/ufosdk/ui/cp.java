package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class cp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ co f23129a;

    public cp(co coVar) {
        this.f23129a = coVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String str3;
        Handler handler;
        int i;
        FeedbackInputActivity feedbackInputActivity = this.f23129a.f23126b.f23114a;
        feedbackInputActivity.B = false;
        Context applicationContext = feedbackInputActivity.getApplicationContext();
        String str4 = UfoSDK.clientid;
        FeedbackInputActivity feedbackInputActivity2 = this.f23129a.f23126b.f23114a;
        String str5 = feedbackInputActivity2.f23018e;
        str = feedbackInputActivity2.ar;
        str2 = this.f23129a.f23128d;
        str3 = this.f23129a.f23126b.f23114a.aA;
        handler = this.f23129a.f23126b.f23114a.aK;
        i = this.f23129a.f23127c;
        feedbackInputActivity.a(applicationContext, str4, str5, str, str2, str3, (String) null, handler, i);
    }
}
