package com.baidu.ufosdk.ui;
/* loaded from: classes7.dex */
final class cl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ck f5497a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ck ckVar) {
        this.f5497a = ckVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f5497a.f5496b.f5489a.B) {
                this.f5497a.f5496b.f5489a.a(this.f5497a.f5496b.f5489a, this.f5497a.f5496b.f5489a.f, this.f5497a.f5496b.f5489a.A);
            }
            com.baidu.ufosdk.e.a.a(this.f5497a.f5496b.f5489a.f, 9);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
