package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes8.dex */
final class cp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ co f5785a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(co coVar) {
        this.f5785a = coVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String str3;
        Handler handler;
        int i;
        this.f5785a.f5784b.f5772a.B = false;
        FeedbackInputActivity feedbackInputActivity = this.f5785a.f5784b.f5772a;
        Context applicationContext = this.f5785a.f5784b.f5772a.getApplicationContext();
        String str4 = UfoSDK.clientid;
        String str5 = this.f5785a.f5784b.f5772a.e;
        str = this.f5785a.f5784b.f5772a.ar;
        str2 = this.f5785a.d;
        str3 = this.f5785a.f5784b.f5772a.aA;
        handler = this.f5785a.f5784b.f5772a.aK;
        i = this.f5785a.c;
        feedbackInputActivity.a(applicationContext, str4, str5, str, str2, str3, (String) null, handler, i);
    }
}
