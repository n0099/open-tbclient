package com.baidu.ufosdk.a;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.f.c;
/* loaded from: classes5.dex */
public final class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public Context f22568a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f22569b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22570c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22571d = false;

    /* renamed from: e  reason: collision with root package name */
    public final long f22572e = 300;

    /* renamed from: f  reason: collision with root package name */
    public String f22573f = "";

    public b(Context context) {
        this.f22568a = context;
    }

    public final void a() {
        this.f22569b = true;
    }

    public final void b() {
        this.f22569b = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String str = UfoSDK.clientid;
        this.f22573f = str;
        if (str.length() == 0) {
            return;
        }
        while (!this.f22569b) {
            c.b("@@@@@@@@@@@@@@@@@@@@@");
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e2) {
                c.a("Interrupted!", e2);
            }
            if (!this.f22570c) {
                com.baidu.ufosdk.e.a.c(this.f22568a);
            }
            try {
                if (!this.f22571d) {
                    Thread.sleep(com.baidu.ufosdk.b.ai * 1000);
                }
            } catch (InterruptedException unused) {
                c.d("GetChatThread Interrupted! Maybe it's time to wakeup.");
            }
        }
    }
}
