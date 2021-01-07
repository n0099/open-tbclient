package com.baidu.ufosdk.ui;

import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes8.dex */
final class cd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5769a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(FeedbackInputActivity feedbackInputActivity) {
        this.f5769a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String d;
        Handler handler;
        String str3;
        str = this.f5769a.ar;
        if (str != null) {
            str3 = this.f5769a.ar;
            if (str3.length() > 0) {
                str2 = this.f5769a.ar;
                d = com.baidu.ufosdk.e.a.d(this.f5769a.getApplicationContext(), this.f5769a.e, str2);
                if (d != null || d.length() == 0) {
                }
                handler = this.f5769a.aK;
                handler.obtainMessage(5, d).sendToTarget();
                return;
            }
        }
        str2 = UfoSDK.appid;
        d = com.baidu.ufosdk.e.a.d(this.f5769a.getApplicationContext(), this.f5769a.e, str2);
        if (d != null) {
        }
    }
}
