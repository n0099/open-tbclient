package com.baidu.ufosdk.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.b.d;
import com.baidu.ufosdk.f.c;
/* loaded from: classes5.dex */
public final class a extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public Context f22529a;

    /* renamed from: b  reason: collision with root package name */
    public String f22530b;

    /* renamed from: c  reason: collision with root package name */
    public String f22531c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22532d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22533e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22534f = false;

    /* renamed from: g  reason: collision with root package name */
    public final long f22535g = 300;

    public a(Context context, String str, String str2) {
        this.f22530b = "";
        this.f22531c = "";
        this.f22529a = context;
        this.f22530b = str;
        this.f22531c = str2;
    }

    public final void a() {
        this.f22532d = true;
    }

    public final void a(String str) {
        this.f22530b = str;
    }

    public final void b() {
        this.f22532d = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String str;
        if (UfoSDK.clientid.length() == 0) {
            return;
        }
        while (!this.f22532d) {
            c.b("###################");
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e2) {
                c.a("Interrupted!", e2);
            }
            if (!this.f22533e && (str = this.f22530b) != null && !str.equals("newMessage")) {
                if (d.c(this.f22529a)) {
                    Context context = this.f22529a;
                    String str2 = UfoSDK.clientid;
                    com.baidu.ufosdk.e.a.a(context, this.f22530b, this.f22531c);
                } else {
                    this.f22529a.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
                    this.f22529a.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
                }
            }
            try {
                if (!this.f22534f) {
                    Thread.sleep(com.baidu.ufosdk.b.ah * 1000);
                }
            } catch (InterruptedException unused) {
                c.d("GetChatThread Interrupted! Maybe it's time to wakeup.");
            }
        }
    }
}
