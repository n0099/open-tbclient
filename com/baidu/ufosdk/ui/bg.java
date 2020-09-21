package com.baidu.ufosdk.ui;

import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes21.dex */
final class bg implements Runnable {
    final /* synthetic */ bf a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bf bfVar) {
        this.a = bfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String d;
        Handler handler;
        String str3;
        try {
            str = this.a.a.ar;
            if (str != null) {
                str3 = this.a.a.ar;
                if (str3.length() > 0) {
                    str2 = this.a.a.ar;
                    d = com.baidu.ufosdk.e.a.d(this.a.a.getApplicationContext(), this.a.a.e, str2);
                    if (d != null || d.length() == 0) {
                    }
                    handler = this.a.a.aK;
                    handler.obtainMessage(5, d).sendToTarget();
                    return;
                }
            }
            str2 = UfoSDK.appid;
            d = com.baidu.ufosdk.e.a.d(this.a.a.getApplicationContext(), this.a.a.e, str2);
            if (d != null) {
            }
        } catch (Exception e) {
        }
    }
}
