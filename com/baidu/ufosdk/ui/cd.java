package com.baidu.ufosdk.ui;

import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class cd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23111a;

    public cd(FeedbackInputActivity feedbackInputActivity) {
        this.f23111a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String d2;
        Handler handler;
        String str3;
        str = this.f23111a.ar;
        if (str != null) {
            str3 = this.f23111a.ar;
            if (str3.length() > 0) {
                str2 = this.f23111a.ar;
                d2 = com.baidu.ufosdk.e.a.d(this.f23111a.getApplicationContext(), this.f23111a.f23018e, str2);
                if (d2 != null || d2.length() == 0) {
                }
                handler = this.f23111a.aK;
                handler.obtainMessage(5, d2).sendToTarget();
                return;
            }
        }
        str2 = UfoSDK.appid;
        d2 = com.baidu.ufosdk.e.a.d(this.f23111a.getApplicationContext(), this.f23111a.f23018e, str2);
        if (d2 != null) {
        }
    }
}
