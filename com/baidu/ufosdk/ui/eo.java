package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class eo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23630a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f23631b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f23632c;

    public eo(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f23632c = ejVar;
        this.f23630a = feedbackInputActivity;
        this.f23631b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f23630a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext, this.f23630a.f23420f, this.f23631b);
    }
}
