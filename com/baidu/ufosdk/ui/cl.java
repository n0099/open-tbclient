package com.baidu.ufosdk.ui;
/* loaded from: classes5.dex */
public final class cl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ck f23122a;

    public cl(ck ckVar) {
        this.f23122a = ckVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f23122a.f23121b.f23114a.B) {
                this.f23122a.f23121b.f23114a.a(this.f23122a.f23121b.f23114a, this.f23122a.f23121b.f23114a.f23019f, this.f23122a.f23121b.f23114a.A);
            }
            com.baidu.ufosdk.e.a.a(this.f23122a.f23121b.f23114a.f23019f, 9);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
