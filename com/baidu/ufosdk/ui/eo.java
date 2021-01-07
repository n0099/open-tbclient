package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes8.dex */
final class eo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5853a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5854b;
    final /* synthetic */ ej c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eo(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.c = ejVar;
        this.f5853a = feedbackInputActivity;
        this.f5854b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f5853a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext, this.f5853a.f, this.f5854b);
    }
}
