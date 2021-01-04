package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class t {
    public static final t pig = new t() { // from class: com.bytedance.sdk.a.a.t.1
        @Override // com.bytedance.sdk.a.a.t
        public t c(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // com.bytedance.sdk.a.a.t
        public t im(long j) {
            return this;
        }

        @Override // com.bytedance.sdk.a.a.t
        public void g() throws IOException {
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private boolean f6150a;

    /* renamed from: b  reason: collision with root package name */
    private long f6151b;
    private long d;

    public t c(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.d = timeUnit.toNanos(j);
        return this;
    }

    public long eqd() {
        return this.d;
    }

    public boolean c() {
        return this.f6150a;
    }

    public long eqe() {
        if (this.f6150a) {
            return this.f6151b;
        }
        throw new IllegalStateException("No deadline");
    }

    public t im(long j) {
        this.f6150a = true;
        this.f6151b = j;
        return this;
    }

    public t eqf() {
        this.d = 0L;
        return this;
    }

    public t eqg() {
        this.f6150a = false;
        return this;
    }

    public void g() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        } else if (this.f6150a && this.f6151b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
