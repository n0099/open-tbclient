package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes21.dex */
final class cp implements Runnable {
    final /* synthetic */ co a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(co coVar) {
        this.a = coVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String str3;
        Handler handler;
        int i;
        this.a.b.a.B = false;
        FeedbackInputActivity feedbackInputActivity = this.a.b.a;
        Context applicationContext = this.a.b.a.getApplicationContext();
        String str4 = UfoSDK.clientid;
        String str5 = this.a.b.a.e;
        str = this.a.b.a.ar;
        str2 = this.a.d;
        str3 = this.a.b.a.aA;
        handler = this.a.b.a.aK;
        i = this.a.c;
        feedbackInputActivity.a(applicationContext, str4, str5, str, str2, str3, (String) null, handler, i);
    }
}
