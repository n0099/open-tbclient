package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class eo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23226a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f23227b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f23228c;

    public eo(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f23228c = ejVar;
        this.f23226a = feedbackInputActivity;
        this.f23227b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f23226a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext, this.f23226a.f23020f, this.f23227b);
    }
}
