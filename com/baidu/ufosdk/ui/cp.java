package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes21.dex */
final class cp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ co f3810a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(co coVar) {
        this.f3810a = coVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String str3;
        Handler handler;
        int i;
        this.f3810a.b.f3801a.B = false;
        FeedbackInputActivity feedbackInputActivity = this.f3810a.b.f3801a;
        Context applicationContext = this.f3810a.b.f3801a.getApplicationContext();
        String str4 = UfoSDK.clientid;
        String str5 = this.f3810a.b.f3801a.e;
        str = this.f3810a.b.f3801a.ar;
        str2 = this.f3810a.d;
        str3 = this.f3810a.b.f3801a.aA;
        handler = this.f3810a.b.f3801a.aK;
        i = this.f3810a.c;
        feedbackInputActivity.a(applicationContext, str4, str5, str, str2, str3, (String) null, handler, i);
    }
}
