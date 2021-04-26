package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class cl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ck f23526a;

    public cl(ck ckVar) {
        this.f23526a = ckVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f23526a.f23525b.f23518a.B) {
                this.f23526a.f23525b.f23518a.a(this.f23526a.f23525b.f23518a, this.f23526a.f23525b.f23518a.f23420f, this.f23526a.f23525b.f23518a.A);
            }
            com.baidu.ufosdk.e.a.a(this.f23526a.f23525b.f23518a.f23420f, 9);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
