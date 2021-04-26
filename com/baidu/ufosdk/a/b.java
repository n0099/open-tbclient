package com.baidu.ufosdk.a;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.f.c;
/* loaded from: classes5.dex */
public final class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public Context f23291a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23292b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23293c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23294d = false;

    /* renamed from: e  reason: collision with root package name */
    public final long f23295e = 300;

    /* renamed from: f  reason: collision with root package name */
    public String f23296f = "";

    public b(Context context) {
        this.f23291a = context;
    }

    public final void a() {
        this.f23292b = true;
    }

    public final void b() {
        this.f23292b = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String str = UfoSDK.clientid;
        this.f23296f = str;
        if (str.length() == 0) {
            return;
        }
        while (!this.f23292b) {
            c.b("@@@@@@@@@@@@@@@@@@@@@");
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e2) {
                c.a("Interrupted!", e2);
            }
            if (!this.f23293c) {
                com.baidu.ufosdk.e.a.c(this.f23291a);
            }
            try {
                if (!this.f23294d) {
                    Thread.sleep(com.baidu.ufosdk.b.ai * 1000);
                }
            } catch (InterruptedException unused) {
                c.d("GetChatThread Interrupted! Maybe it's time to wakeup.");
            }
        }
    }
}
