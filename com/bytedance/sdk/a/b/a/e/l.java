package com.bytedance.sdk.a.b.a.e;

import java.util.concurrent.CountDownLatch;
/* loaded from: classes6.dex */
final class l {

    /* renamed from: a  reason: collision with root package name */
    private final CountDownLatch f5924a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    private long f5925b = -1;
    private long c = -1;

    l() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.f5925b != -1) {
            throw new IllegalStateException();
        }
        this.f5925b = System.nanoTime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.c != -1 || this.f5925b == -1) {
            throw new IllegalStateException();
        }
        this.c = System.nanoTime();
        this.f5924a.countDown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.c != -1 || this.f5925b == -1) {
            throw new IllegalStateException();
        }
        this.c = this.f5925b - 1;
        this.f5924a.countDown();
    }
}
