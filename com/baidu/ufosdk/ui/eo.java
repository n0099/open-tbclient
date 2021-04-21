package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class eo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22919a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22920b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f22921c;

    public eo(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f22921c = ejVar;
        this.f22919a = feedbackInputActivity;
        this.f22920b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f22919a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext, this.f22919a.f22713f, this.f22920b);
    }
}
