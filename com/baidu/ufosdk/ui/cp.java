package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes8.dex */
final class cp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ co f5784a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(co coVar) {
        this.f5784a = coVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String str3;
        Handler handler;
        int i;
        this.f5784a.f5783b.f5771a.B = false;
        FeedbackInputActivity feedbackInputActivity = this.f5784a.f5783b.f5771a;
        Context applicationContext = this.f5784a.f5783b.f5771a.getApplicationContext();
        String str4 = UfoSDK.clientid;
        String str5 = this.f5784a.f5783b.f5771a.e;
        str = this.f5784a.f5783b.f5771a.ar;
        str2 = this.f5784a.d;
        str3 = this.f5784a.f5783b.f5771a.aA;
        handler = this.f5784a.f5783b.f5771a.aK;
        i = this.f5784a.c;
        feedbackInputActivity.a(applicationContext, str4, str5, str, str2, str3, (String) null, handler, i);
    }
}
