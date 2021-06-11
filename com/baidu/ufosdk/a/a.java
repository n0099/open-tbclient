package com.baidu.ufosdk.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.b.d;
import com.baidu.ufosdk.f.c;
/* loaded from: classes5.dex */
public final class a extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public Context f22561a;

    /* renamed from: b  reason: collision with root package name */
    public String f22562b;

    /* renamed from: c  reason: collision with root package name */
    public String f22563c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22564d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22565e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22566f = false;

    /* renamed from: g  reason: collision with root package name */
    public final long f22567g = 300;

    public a(Context context, String str, String str2) {
        this.f22562b = "";
        this.f22563c = "";
        this.f22561a = context;
        this.f22562b = str;
        this.f22563c = str2;
    }

    public final void a() {
        this.f22564d = true;
    }

    public final void a(String str) {
        this.f22562b = str;
    }

    public final void b() {
        this.f22564d = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String str;
        if (UfoSDK.clientid.length() == 0) {
            return;
        }
        while (!this.f22564d) {
            c.b("###################");
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e2) {
                c.a("Interrupted!", e2);
            }
            if (!this.f22565e && (str = this.f22562b) != null && !str.equals("newMessage")) {
                if (d.c(this.f22561a)) {
                    Context context = this.f22561a;
                    String str2 = UfoSDK.clientid;
                    com.baidu.ufosdk.e.a.a(context, this.f22562b, this.f22563c);
                } else {
                    this.f22561a.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
                    this.f22561a.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
                }
            }
            try {
                if (!this.f22566f) {
                    Thread.sleep(com.baidu.ufosdk.b.ah * 1000);
                }
            } catch (InterruptedException unused) {
                c.d("GetChatThread Interrupted! Maybe it's time to wakeup.");
            }
        }
    }
}
