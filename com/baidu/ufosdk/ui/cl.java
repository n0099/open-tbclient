package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class cl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ck f23123a;

    public cl(ck ckVar) {
        this.f23123a = ckVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f23123a.f23122b.f23115a.B) {
                this.f23123a.f23122b.f23115a.a(this.f23123a.f23122b.f23115a, this.f23123a.f23122b.f23115a.f23020f, this.f23123a.f23122b.f23115a.A);
            }
            com.baidu.ufosdk.e.a.a(this.f23123a.f23122b.f23115a.f23020f, 9);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
