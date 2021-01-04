package com.baidu.ufosdk.ui;

import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes8.dex */
final class bg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bf f5740a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bf bfVar) {
        this.f5740a = bfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String d;
        Handler handler;
        String str3;
        try {
            str = this.f5740a.f5739a.ar;
            if (str != null) {
                str3 = this.f5740a.f5739a.ar;
                if (str3.length() > 0) {
                    str2 = this.f5740a.f5739a.ar;
                    d = com.baidu.ufosdk.e.a.d(this.f5740a.f5739a.getApplicationContext(), this.f5740a.f5739a.e, str2);
                    if (d != null || d.length() == 0) {
                    }
                    handler = this.f5740a.f5739a.aK;
                    handler.obtainMessage(5, d).sendToTarget();
                    return;
                }
            }
            str2 = UfoSDK.appid;
            d = com.baidu.ufosdk.e.a.d(this.f5740a.f5739a.getApplicationContext(), this.f5740a.f5739a.e, str2);
            if (d != null) {
            }
        } catch (Exception e) {
        }
    }
}
