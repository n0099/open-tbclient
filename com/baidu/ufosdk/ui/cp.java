package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes7.dex */
final class cp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ co f3716a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(co coVar) {
        this.f3716a = coVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String str3;
        Handler handler;
        int i;
        this.f3716a.b.f3707a.B = false;
        FeedbackInputActivity feedbackInputActivity = this.f3716a.b.f3707a;
        Context applicationContext = this.f3716a.b.f3707a.getApplicationContext();
        String str4 = UfoSDK.clientid;
        String str5 = this.f3716a.b.f3707a.e;
        str = this.f3716a.b.f3707a.ar;
        str2 = this.f3716a.d;
        str3 = this.f3716a.b.f3707a.aA;
        handler = this.f3716a.b.f3707a.aK;
        i = this.f3716a.c;
        feedbackInputActivity.a(applicationContext, str4, str5, str, str2, str3, (String) null, handler, i);
    }
}
