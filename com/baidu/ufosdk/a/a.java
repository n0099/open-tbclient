package com.baidu.ufosdk.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.b.d;
import com.baidu.ufosdk.f.c;
/* loaded from: classes5.dex */
public final class a extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public Context f22458a;

    /* renamed from: b  reason: collision with root package name */
    public String f22459b;

    /* renamed from: c  reason: collision with root package name */
    public String f22460c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22461d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22462e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22463f = false;

    /* renamed from: g  reason: collision with root package name */
    public final long f22464g = 300;

    public a(Context context, String str, String str2) {
        this.f22459b = "";
        this.f22460c = "";
        this.f22458a = context;
        this.f22459b = str;
        this.f22460c = str2;
    }

    public final void a() {
        this.f22461d = true;
    }

    public final void a(String str) {
        this.f22459b = str;
    }

    public final void b() {
        this.f22461d = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String str;
        if (UfoSDK.clientid.length() == 0) {
            return;
        }
        while (!this.f22461d) {
            c.b("###################");
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e2) {
                c.a("Interrupted!", e2);
            }
            if (!this.f22462e && (str = this.f22459b) != null && !str.equals("newMessage")) {
                if (d.c(this.f22458a)) {
                    Context context = this.f22458a;
                    String str2 = UfoSDK.clientid;
                    com.baidu.ufosdk.e.a.a(context, this.f22459b, this.f22460c);
                } else {
                    this.f22458a.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
                    this.f22458a.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
                }
            }
            try {
                if (!this.f22463f) {
                    Thread.sleep(com.baidu.ufosdk.b.ah * 1000);
                }
            } catch (InterruptedException unused) {
                c.d("GetChatThread Interrupted! Maybe it's time to wakeup.");
            }
        }
    }
}
