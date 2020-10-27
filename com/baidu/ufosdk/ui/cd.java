package com.baidu.ufosdk.ui;

import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes22.dex */
final class cd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3796a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(FeedbackInputActivity feedbackInputActivity) {
        this.f3796a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String d;
        Handler handler;
        String str3;
        str = this.f3796a.ar;
        if (str != null) {
            str3 = this.f3796a.ar;
            if (str3.length() > 0) {
                str2 = this.f3796a.ar;
                d = com.baidu.ufosdk.e.a.d(this.f3796a.getApplicationContext(), this.f3796a.e, str2);
                if (d != null || d.length() == 0) {
                }
                handler = this.f3796a.aK;
                handler.obtainMessage(5, d).sendToTarget();
                return;
            }
        }
        str2 = UfoSDK.appid;
        d = com.baidu.ufosdk.e.a.d(this.f3796a.getApplicationContext(), this.f3796a.e, str2);
        if (d != null) {
        }
    }
}
