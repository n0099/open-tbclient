package com.baidu.ufosdk.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.b.d;
import com.baidu.ufosdk.f.c;
/* loaded from: classes5.dex */
public final class a extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public Context f22889a;

    /* renamed from: b  reason: collision with root package name */
    public String f22890b;

    /* renamed from: c  reason: collision with root package name */
    public String f22891c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22892d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22893e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22894f = false;

    /* renamed from: g  reason: collision with root package name */
    public final long f22895g = 300;

    public a(Context context, String str, String str2) {
        this.f22890b = "";
        this.f22891c = "";
        this.f22889a = context;
        this.f22890b = str;
        this.f22891c = str2;
    }

    public final void a() {
        this.f22892d = true;
    }

    public final void a(String str) {
        this.f22890b = str;
    }

    public final void b() {
        this.f22892d = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String str;
        if (UfoSDK.clientid.length() == 0) {
            return;
        }
        while (!this.f22892d) {
            c.b("###################");
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e2) {
                c.a("Interrupted!", e2);
            }
            if (!this.f22893e && (str = this.f22890b) != null && !str.equals("newMessage")) {
                if (d.c(this.f22889a)) {
                    Context context = this.f22889a;
                    String str2 = UfoSDK.clientid;
                    com.baidu.ufosdk.e.a.a(context, this.f22890b, this.f22891c);
                } else {
                    this.f22889a.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
                    this.f22889a.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
                }
            }
            try {
                if (!this.f22894f) {
                    Thread.sleep(com.baidu.ufosdk.b.ah * 1000);
                }
            } catch (InterruptedException unused) {
                c.d("GetChatThread Interrupted! Maybe it's time to wakeup.");
            }
        }
    }
}
