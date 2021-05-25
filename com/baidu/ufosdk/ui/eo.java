package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class eo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22804a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22805b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f22806c;

    public eo(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f22806c = ejVar;
        this.f22804a = feedbackInputActivity;
        this.f22805b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f22804a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext, this.f22804a.f22594f, this.f22805b);
    }
}
