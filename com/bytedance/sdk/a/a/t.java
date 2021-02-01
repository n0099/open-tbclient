package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class t {
    public static final t pnQ = new t() { // from class: com.bytedance.sdk.a.a.t.1
        @Override // com.bytedance.sdk.a.a.t
        public t c(long j, TimeUnit timeUnit) {
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
    private boolean f5853a;

    /* renamed from: b  reason: collision with root package name */
    private long f5854b;
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

    public long eoC() {
        return this.d;
    }

    public boolean c() {
        return this.f5853a;
    }

    public long eoD() {
        if (this.f5853a) {
            return this.f5854b;
        }
        throw new IllegalStateException("No deadline");
    }

    public t ip(long j) {
        this.f5853a = true;
        this.f5854b = j;
        return this;
    }

    public t eoE() {
        this.d = 0L;
        return this;
    }

    public t eoF() {
        this.f5853a = false;
        return this;
    }

    public void g() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        } else if (this.f5853a && this.f5854b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
