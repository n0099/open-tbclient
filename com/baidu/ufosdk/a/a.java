package com.baidu.ufosdk.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.b.d;
import com.baidu.ufosdk.f.c;
/* loaded from: classes5.dex */
public final class a extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public Context f23284a;

    /* renamed from: b  reason: collision with root package name */
    public String f23285b;

    /* renamed from: c  reason: collision with root package name */
    public String f23286c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23287d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23288e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23289f = false;

    /* renamed from: g  reason: collision with root package name */
    public final long f23290g = 300;

    public a(Context context, String str, String str2) {
        this.f23285b = "";
        this.f23286c = "";
        this.f23284a = context;
        this.f23285b = str;
        this.f23286c = str2;
    }

    public final void a() {
        this.f23287d = true;
    }

    public final void a(String str) {
        this.f23285b = str;
    }

    public final void b() {
        this.f23287d = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String str;
        if (UfoSDK.clientid.length() == 0) {
            return;
        }
        while (!this.f23287d) {
            c.b("###################");
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e2) {
                c.a("Interrupted!", e2);
            }
            if (!this.f23288e && (str = this.f23285b) != null && !str.equals("newMessage")) {
                if (d.c(this.f23284a)) {
                    Context context = this.f23284a;
                    String str2 = UfoSDK.clientid;
                    com.baidu.ufosdk.e.a.a(context, this.f23285b, this.f23286c);
                } else {
                    this.f23284a.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
                    this.f23284a.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
                }
            }
            try {
                if (!this.f23289f) {
                    Thread.sleep(com.baidu.ufosdk.b.ah * 1000);
                }
            } catch (InterruptedException unused) {
                c.d("GetChatThread Interrupted! Maybe it's time to wakeup.");
            }
        }
    }
}
