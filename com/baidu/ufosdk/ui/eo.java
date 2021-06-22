package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class eo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22989a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22990b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f22991c;

    public eo(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f22991c = ejVar;
        this.f22989a = feedbackInputActivity;
        this.f22990b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f22989a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext, this.f22989a.f22779f, this.f22990b);
    }
}
