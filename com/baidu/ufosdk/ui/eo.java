package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class eo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22875a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22876b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f22877c;

    public eo(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f22877c = ejVar;
        this.f22875a = feedbackInputActivity;
        this.f22876b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f22875a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext, this.f22875a.f22665f, this.f22876b);
    }
}
