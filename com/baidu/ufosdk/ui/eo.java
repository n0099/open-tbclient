package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class eo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23225a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f23226b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f23227c;

    public eo(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f23227c = ejVar;
        this.f23225a = feedbackInputActivity;
        this.f23226b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f23225a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext, this.f23225a.f23019f, this.f23226b);
    }
}
