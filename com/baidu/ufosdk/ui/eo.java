package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes7.dex */
final class eo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5570a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5571b;
    final /* synthetic */ ej c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eo(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.c = ejVar;
        this.f5570a = feedbackInputActivity;
        this.f5571b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f5570a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext, this.f5570a.f, this.f5571b);
    }
}
