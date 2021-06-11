package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class cl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ck f22803a;

    public cl(ck ckVar) {
        this.f22803a = ckVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f22803a.f22802b.f22795a.B) {
                this.f22803a.f22802b.f22795a.a(this.f22803a.f22802b.f22795a, this.f22803a.f22802b.f22795a.f22697f, this.f22803a.f22802b.f22795a.A);
            }
            com.baidu.ufosdk.e.a.a(this.f22803a.f22802b.f22795a.f22697f, 9);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
