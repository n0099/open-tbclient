package com.bytedance.sdk.a.b.a.e;

import java.util.concurrent.CountDownLatch;
/* loaded from: classes6.dex */
final class l {

    /* renamed from: a  reason: collision with root package name */
    private final CountDownLatch f3985a = new CountDownLatch(1);
    private long b = -1;
    private long c = -1;

    l() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.b != -1) {
            throw new IllegalStateException();
        }
        this.b = System.nanoTime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.c != -1 || this.b == -1) {
            throw new IllegalStateException();
        }
        this.c = System.nanoTime();
        this.f3985a.countDown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.c != -1 || this.b == -1) {
            throw new IllegalStateException();
        }
        this.c = this.b - 1;
        this.f3985a.countDown();
    }
}
