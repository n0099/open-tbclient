package com.baidu.ufosdk.ui;

import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class bg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bf f22660a;

    public bg(bf bfVar) {
        this.f22660a = bfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String d2;
        Handler handler;
        String str3;
        try {
            str = this.f22660a.f22659a.ar;
            if (str != null) {
                str3 = this.f22660a.f22659a.ar;
                if (str3.length() > 0) {
                    str2 = this.f22660a.f22659a.ar;
                    d2 = com.baidu.ufosdk.e.a.d(this.f22660a.f22659a.getApplicationContext(), this.f22660a.f22659a.f22593e, str2);
                    if (d2 != null || d2.length() == 0) {
                    }
                    handler = this.f22660a.f22659a.aK;
                    handler.obtainMessage(5, d2).sendToTarget();
                    return;
                }
            }
            str2 = UfoSDK.appid;
            d2 = com.baidu.ufosdk.e.a.d(this.f22660a.f22659a.getApplicationContext(), this.f22660a.f22659a.f22593e, str2);
            if (d2 != null) {
            }
        } catch (Exception unused) {
        }
    }
}
