package com.bytedance.sdk.a.a;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class a extends t {

    /* renamed from: b  reason: collision with root package name */
    private static final long f5839b = TimeUnit.SECONDS.toMillis(60);
    private static final long d = TimeUnit.MILLISECONDS.toNanos(f5839b);
    static a pnx;
    private boolean e;
    private long g;
    private a pny;

    public final void a() {
        if (this.e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long eoC = eoC();
        boolean c = c();
        if (eoC != 0 || c) {
            this.e = true;
            a(this, eoC, c);
        }
    }

    private static synchronized void a(a aVar, long j, boolean z) {
        synchronized (a.class) {
            if (pnx == null) {
                pnx = new a();
                new C0992a().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                aVar.g = Math.min(j, aVar.eoD() - nanoTime) + nanoTime;
            } else if (j != 0) {
                aVar.g = nanoTime + j;
            } else if (z) {
                aVar.g = aVar.eoD();
            } else {
                throw new AssertionError();
            }
            long b2 = aVar.b(nanoTime);
            a aVar2 = pnx;
            while (aVar2.pny != null && b2 >= aVar2.pny.b(nanoTime)) {
                aVar2 = aVar2.pny;
            }
            aVar.pny = aVar2.pny;
            aVar2.pny = aVar;
            if (aVar2 == pnx) {
                a.class.notify();
            }
        }
    }

    public final boolean b() {
        if (this.e) {
            this.e = false;
            return a(this);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000b, code lost:
        r0.pny = r3.pny;
        r3.pny = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized boolean a(a aVar) {
        boolean z;
        synchronized (a.class) {
            a aVar2 = pnx;
            while (true) {
                if (aVar2 != null) {
                    if (aVar2.pny == aVar) {
                        break;
                    }
                    aVar2 = aVar2.pny;
                } else {
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    private long b(long j) {
        return this.g - j;
    }

    protected void eoo() {
    }

    public final r a(final r rVar) {
        return new r() { // from class: com.bytedance.sdk.a.a.a.1
            @Override // com.bytedance.sdk.a.a.r
            public void a(c cVar, long j) throws IOException {
                u.a(cVar.f5842b, 0L, j);
                long j2 = j;
                while (j2 > 0) {
                    o oVar = cVar.pnC;
                    long j3 = 0;
                    while (true) {
                        if (j3 >= 65536) {
                            break;
                        }
                        j3 += oVar.c - oVar.f5851b;
                        if (j3 >= j2) {
                            j3 = j2;
                            break;
                        }
                        oVar = oVar.pnO;
                    }
                    a.this.a();
                    try {
                        try {
                            rVar.a(cVar, j3);
                            j2 -= j3;
                            a.this.a(true);
                        } catch (IOException e) {
                            throw a.this.e(e);
                        }
                    } catch (Throwable th) {
                        a.this.a(false);
                        throw th;
                    }
                }
            }

            @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
            public void flush() throws IOException {
                a.this.a();
                try {
                    try {
                        rVar.flush();
                        a.this.a(true);
                    } catch (IOException e) {
                        throw a.this.e(e);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                a.this.a();
                try {
                    try {
                        rVar.close();
                        a.this.a(true);
                    } catch (IOException e) {
                        throw a.this.e(e);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.a.a.r
            public t eoq() {
                return a.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + rVar + ")";
            }
        };
    }

    public final s a(final s sVar) {
        return new s() { // from class: com.bytedance.sdk.a.a.a.2
            @Override // com.bytedance.sdk.a.a.s
            public long b(c cVar, long j) throws IOException {
                a.this.a();
                try {
                    try {
                        long b2 = sVar.b(cVar, j);
                        a.this.a(true);
                        return b2;
                    } catch (IOException e) {
                        throw a.this.e(e);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                a.this.a();
                try {
                    try {
                        sVar.close();
                        a.this.a(true);
                    } catch (IOException e) {
                        throw a.this.e(e);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.a.a.s
            public t eoq() {
                return a.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + sVar + ")";
            }
        };
    }

    final void a(boolean z) throws IOException {
        if (b() && z) {
            throw f(null);
        }
    }

    final IOException e(IOException iOException) throws IOException {
        return !b() ? iOException : f(iOException);
    }

    protected IOException f(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0992a extends Thread {
        C0992a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x001a, code lost:
            r0.eoo();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            while (true) {
                synchronized (a.class) {
                    a eop = a.eop();
                    if (eop != null) {
                        if (eop == a.pnx) {
                            a.pnx = null;
                            return;
                        }
                    }
                }
            }
        }
    }

    static a eop() throws InterruptedException {
        a aVar = pnx.pny;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            a.class.wait(f5839b);
            if (pnx.pny != null || System.nanoTime() - nanoTime < d) {
                return null;
            }
            return pnx;
        }
        long b2 = aVar.b(System.nanoTime());
        if (b2 > 0) {
            long j = b2 / TimeUtils.NANOS_PER_MS;
            a.class.wait(j, (int) (b2 - (TimeUtils.NANOS_PER_MS * j)));
            return null;
        }
        pnx.pny = aVar.pny;
        aVar.pny = null;
        return aVar;
    }
}
