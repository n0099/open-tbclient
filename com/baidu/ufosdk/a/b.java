package com.baidu.ufosdk.a;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.f.c;
/* loaded from: classes5.dex */
public final class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public Context f22650a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f22651b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22652c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22653d = false;

    /* renamed from: e  reason: collision with root package name */
    public final long f22654e = 300;

    /* renamed from: f  reason: collision with root package name */
    public String f22655f = "";

    public b(Context context) {
        this.f22650a = context;
    }

    public final void a() {
        this.f22651b = true;
    }

    public final void b() {
        this.f22651b = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String str = UfoSDK.clientid;
        this.f22655f = str;
        if (str.length() == 0) {
            return;
        }
        while (!this.f22651b) {
            c.b("@@@@@@@@@@@@@@@@@@@@@");
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e2) {
                c.a("Interrupted!", e2);
            }
            if (!this.f22652c) {
                com.baidu.ufosdk.e.a.c(this.f22650a);
            }
            try {
                if (!this.f22653d) {
                    Thread.sleep(com.baidu.ufosdk.b.ai * 1000);
                }
            } catch (InterruptedException unused) {
                c.d("GetChatThread Interrupted! Maybe it's time to wakeup.");
            }
        }
    }
}
