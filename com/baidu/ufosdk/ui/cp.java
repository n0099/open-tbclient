package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes22.dex */
final class cp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ co f3808a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(co coVar) {
        this.f3808a = coVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String str3;
        Handler handler;
        int i;
        this.f3808a.b.f3799a.B = false;
        FeedbackInputActivity feedbackInputActivity = this.f3808a.b.f3799a;
        Context applicationContext = this.f3808a.b.f3799a.getApplicationContext();
        String str4 = UfoSDK.clientid;
        String str5 = this.f3808a.b.f3799a.e;
        str = this.f3808a.b.f3799a.ar;
        str2 = this.f3808a.d;
        str3 = this.f3808a.b.f3799a.aA;
        handler = this.f3808a.b.f3799a.aK;
        i = this.f3808a.c;
        feedbackInputActivity.a(applicationContext, str4, str5, str, str2, str3, (String) null, handler, i);
    }
}
