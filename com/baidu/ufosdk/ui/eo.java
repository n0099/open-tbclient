package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes22.dex */
final class eo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3865a;
    final /* synthetic */ String b;
    final /* synthetic */ ej c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eo(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        this.c = ejVar;
        this.f3865a = feedbackInputActivity;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f3865a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext, this.f3865a.f, this.b);
    }
}
