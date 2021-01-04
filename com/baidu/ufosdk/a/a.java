package com.baidu.ufosdk.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.b.d;
import com.baidu.ufosdk.f.c;
/* loaded from: classes8.dex */
public final class a extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private Context f5633a;

    /* renamed from: b  reason: collision with root package name */
    private String f5634b;
    private String c;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private final long g = 300;

    public a(Context context, String str, String str2) {
        this.f5634b = "";
        this.c = "";
        this.f5633a = context;
        this.f5634b = str;
        this.c = str2;
    }

    public final void a() {
        this.d = true;
    }

    public final void a(String str) {
        this.f5634b = str;
    }

    public final void b() {
        this.d = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (UfoSDK.clientid.length() == 0) {
            return;
        }
        while (!this.d) {
            c.b("###################");
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e) {
                c.a("Interrupted!", e);
            }
            if (!this.e && this.f5634b != null && !this.f5634b.equals("newMessage")) {
                if (d.c(this.f5633a)) {
                    Context context = this.f5633a;
                    String str = UfoSDK.clientid;
                    com.baidu.ufosdk.e.a.a(context, this.f5634b, this.c);
                } else {
                    this.f5633a.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
                    this.f5633a.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
                }
            }
            try {
                if (!this.f) {
                    Thread.sleep(com.baidu.ufosdk.b.ah * 1000);
                }
            } catch (InterruptedException e2) {
                c.d("GetChatThread Interrupted! Maybe it's time to wakeup.");
            }
        }
    }
}
