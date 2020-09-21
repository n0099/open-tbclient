package com.baidu.ufosdk.a;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.f.c;
/* loaded from: classes21.dex */
public final class b extends Thread {
    private Context a;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private final long e = 300;
    private String f = "";

    public b(Context context) {
        this.a = context;
    }

    public final void a() {
        this.b = true;
    }

    public final void b() {
        this.b = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        this.f = UfoSDK.clientid;
        if (this.f.length() == 0) {
            return;
        }
        while (!this.b) {
            c.b("@@@@@@@@@@@@@@@@@@@@@");
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e) {
                c.a("Interrupted!", e);
            }
            if (!this.c) {
                com.baidu.ufosdk.e.a.c(this.a);
            }
            try {
                if (!this.d) {
                    Thread.sleep(com.baidu.ufosdk.b.ai * 1000);
                }
            } catch (InterruptedException e2) {
                c.d("GetChatThread Interrupted! Maybe it's time to wakeup.");
            }
        }
    }
}
