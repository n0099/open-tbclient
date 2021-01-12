package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes7.dex */
final class cp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ co f5502a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(co coVar) {
        this.f5502a = coVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String str3;
        Handler handler;
        int i;
        this.f5502a.f5501b.f5489a.B = false;
        FeedbackInputActivity feedbackInputActivity = this.f5502a.f5501b.f5489a;
        Context applicationContext = this.f5502a.f5501b.f5489a.getApplicationContext();
        String str4 = UfoSDK.clientid;
        String str5 = this.f5502a.f5501b.f5489a.e;
        str = this.f5502a.f5501b.f5489a.ar;
        str2 = this.f5502a.d;
        str3 = this.f5502a.f5501b.f5489a.aA;
        handler = this.f5502a.f5501b.f5489a.aK;
        i = this.f5502a.c;
        feedbackInputActivity.a(applicationContext, str4, str5, str, str2, str3, (String) null, handler, i);
    }
}
