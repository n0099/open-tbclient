package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class eo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22907a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22908b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f22909c;

    public eo(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f22909c = ejVar;
        this.f22907a = feedbackInputActivity;
        this.f22908b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f22907a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext, this.f22907a.f22697f, this.f22908b);
    }
}
