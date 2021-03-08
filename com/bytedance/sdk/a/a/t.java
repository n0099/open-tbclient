package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class t {
    public static final t pqA = new t() { // from class: com.bytedance.sdk.a.a.t.1
        @Override // com.bytedance.sdk.a.a.t
        public t b(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // com.bytedance.sdk.a.a.t
        public t ip(long j) {
            return this;
        }

        @Override // com.bytedance.sdk.a.a.t
        public void g() throws IOException {
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private boolean f3943a;
    private long b;
    private long d;

    public t b(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.d = timeUnit.toNanos(j);
        return this;
    }

    public long eoR() {
        return this.d;
    }

    public boolean c() {
        return this.f3943a;
    }

    public long eoS() {
        if (this.f3943a) {
            return this.b;
        }
        throw new IllegalStateException("No deadline");
    }

    public t ip(long j) {
        this.f3943a = true;
        this.b = j;
        return this;
    }

    public t eoT() {
        this.d = 0L;
        return this;
    }

    public t eoU() {
        this.f3943a = false;
        return this;
    }

    public void g() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        } else if (this.f3943a && this.b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
