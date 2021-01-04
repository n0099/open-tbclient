package com.bytedance.sdk.a.b.a.e;

import java.util.concurrent.CountDownLatch;
/* loaded from: classes4.dex */
final class l {

    /* renamed from: a  reason: collision with root package name */
    private final CountDownLatch f6221a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    private long f6222b = -1;
    private long c = -1;

    l() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.f6222b != -1) {
            throw new IllegalStateException();
        }
        this.f6222b = System.nanoTime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.c != -1 || this.f6222b == -1) {
            throw new IllegalStateException();
        }
        this.c = System.nanoTime();
        this.f6221a.countDown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.c != -1 || this.f6222b == -1) {
            throw new IllegalStateException();
        }
        this.c = this.f6222b - 1;
        this.f6221a.countDown();
    }
}
