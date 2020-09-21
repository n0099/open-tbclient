package com.baidu.ufosdk.ui;

import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes21.dex */
final class cd implements Runnable {
    final /* synthetic */ FeedbackInputActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(FeedbackInputActivity feedbackInputActivity) {
        this.a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String d;
        Handler handler;
        String str3;
        str = this.a.ar;
        if (str != null) {
            str3 = this.a.ar;
            if (str3.length() > 0) {
                str2 = this.a.ar;
                d = com.baidu.ufosdk.e.a.d(this.a.getApplicationContext(), this.a.e, str2);
                if (d != null || d.length() == 0) {
                }
                handler = this.a.aK;
                handler.obtainMessage(5, d).sendToTarget();
                return;
            }
        }
        str2 = UfoSDK.appid;
        d = com.baidu.ufosdk.e.a.d(this.a.getApplicationContext(), this.a.e, str2);
        if (d != null) {
        }
    }
}
