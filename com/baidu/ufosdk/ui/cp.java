package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class cp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ co f22815a;

    public cp(co coVar) {
        this.f22815a = coVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String str3;
        Handler handler;
        int i;
        FeedbackInputActivity feedbackInputActivity = this.f22815a.f22812b.f22800a;
        feedbackInputActivity.B = false;
        Context applicationContext = feedbackInputActivity.getApplicationContext();
        String str4 = UfoSDK.clientid;
        FeedbackInputActivity feedbackInputActivity2 = this.f22815a.f22812b.f22800a;
        String str5 = feedbackInputActivity2.f22704e;
        str = feedbackInputActivity2.ar;
        str2 = this.f22815a.f22814d;
        str3 = this.f22815a.f22812b.f22800a.aA;
        handler = this.f22815a.f22812b.f22800a.aK;
        i = this.f22815a.f22813c;
        feedbackInputActivity.a(applicationContext, str4, str5, str, str2, str3, (String) null, handler, i);
    }
}
