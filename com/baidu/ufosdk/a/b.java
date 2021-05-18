package com.baidu.ufosdk.a;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.f.c;
/* loaded from: classes5.dex */
public final class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public Context f22536a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f22537b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22538c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22539d = false;

    /* renamed from: e  reason: collision with root package name */
    public final long f22540e = 300;

    /* renamed from: f  reason: collision with root package name */
    public String f22541f = "";

    public b(Context context) {
        this.f22536a = context;
    }

    public final void a() {
        this.f22537b = true;
    }

    public final void b() {
        this.f22537b = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String str = UfoSDK.clientid;
        this.f22541f = str;
        if (str.length() == 0) {
            return;
        }
        while (!this.f22537b) {
            c.b("@@@@@@@@@@@@@@@@@@@@@");
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e2) {
                c.a("Interrupted!", e2);
            }
            if (!this.f22538c) {
                com.baidu.ufosdk.e.a.c(this.f22536a);
            }
            try {
                if (!this.f22539d) {
                    Thread.sleep(com.baidu.ufosdk.b.ai * 1000);
                }
            } catch (InterruptedException unused) {
                c.d("GetChatThread Interrupted! Maybe it's time to wakeup.");
            }
        }
    }
}
