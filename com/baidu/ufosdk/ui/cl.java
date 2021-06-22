package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class cl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ck f22885a;

    public cl(ck ckVar) {
        this.f22885a = ckVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f22885a.f22884b.f22877a.B) {
                this.f22885a.f22884b.f22877a.a(this.f22885a.f22884b.f22877a, this.f22885a.f22884b.f22877a.f22779f, this.f22885a.f22884b.f22877a.A);
            }
            com.baidu.ufosdk.e.a.a(this.f22885a.f22884b.f22877a.f22779f, 9);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
