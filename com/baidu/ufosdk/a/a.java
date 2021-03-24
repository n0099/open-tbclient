package com.baidu.ufosdk.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.b.d;
import com.baidu.ufosdk.f.c;
/* loaded from: classes5.dex */
public final class a extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public Context f22888a;

    /* renamed from: b  reason: collision with root package name */
    public String f22889b;

    /* renamed from: c  reason: collision with root package name */
    public String f22890c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22891d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22892e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22893f = false;

    /* renamed from: g  reason: collision with root package name */
    public final long f22894g = 300;

    public a(Context context, String str, String str2) {
        this.f22889b = "";
        this.f22890c = "";
        this.f22888a = context;
        this.f22889b = str;
        this.f22890c = str2;
    }

    public final void a() {
        this.f22891d = true;
    }

    public final void a(String str) {
        this.f22889b = str;
    }

    public final void b() {
        this.f22891d = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String str;
        if (UfoSDK.clientid.length() == 0) {
            return;
        }
        while (!this.f22891d) {
            c.b("###################");
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e2) {
                c.a("Interrupted!", e2);
            }
            if (!this.f22892e && (str = this.f22889b) != null && !str.equals("newMessage")) {
                if (d.c(this.f22888a)) {
                    Context context = this.f22888a;
                    String str2 = UfoSDK.clientid;
                    com.baidu.ufosdk.e.a.a(context, this.f22889b, this.f22890c);
                } else {
                    this.f22888a.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
                    this.f22888a.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
                }
            }
            try {
                if (!this.f22893f) {
                    Thread.sleep(com.baidu.ufosdk.b.ah * 1000);
                }
            } catch (InterruptedException unused) {
                c.d("GetChatThread Interrupted! Maybe it's time to wakeup.");
            }
        }
    }
}
