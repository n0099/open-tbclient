package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class eo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22911a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22912b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f22913c;

    public eo(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.f22913c = ejVar;
        this.f22911a = feedbackInputActivity;
        this.f22912b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f22911a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext, this.f22911a.f22705f, this.f22912b);
    }
}
