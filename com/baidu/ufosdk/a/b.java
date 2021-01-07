package com.baidu.ufosdk.a;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.f.c;
/* loaded from: classes8.dex */
public final class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private Context f5636a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5637b = false;
    private boolean c = false;
    private boolean d = false;
    private final long e = 300;
    private String f = "";

    public b(Context context) {
        this.f5636a = context;
    }

    public final void a() {
        this.f5637b = true;
    }

    public final void b() {
        this.f5637b = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        this.f = UfoSDK.clientid;
        if (this.f.length() == 0) {
            return;
        }
        while (!this.f5637b) {
            c.b("@@@@@@@@@@@@@@@@@@@@@");
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e) {
                c.a("Interrupted!", e);
            }
            if (!this.c) {
                com.baidu.ufosdk.e.a.c(this.f5636a);
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
