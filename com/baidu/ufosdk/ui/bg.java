package com.baidu.ufosdk.ui;

import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes22.dex */
final class bg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bf f3777a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bf bfVar) {
        this.f3777a = bfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String d;
        Handler handler;
        String str3;
        try {
            str = this.f3777a.f3776a.ar;
            if (str != null) {
                str3 = this.f3777a.f3776a.ar;
                if (str3.length() > 0) {
                    str2 = this.f3777a.f3776a.ar;
                    d = com.baidu.ufosdk.e.a.d(this.f3777a.f3776a.getApplicationContext(), this.f3777a.f3776a.e, str2);
                    if (d != null || d.length() == 0) {
                    }
                    handler = this.f3777a.f3776a.aK;
                    handler.obtainMessage(5, d).sendToTarget();
                    return;
                }
            }
            str2 = UfoSDK.appid;
            d = com.baidu.ufosdk.e.a.d(this.f3777a.f3776a.getApplicationContext(), this.f3777a.f3776a.e, str2);
            if (d != null) {
            }
        } catch (Exception e) {
        }
    }
}
