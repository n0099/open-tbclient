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
    static a pnX;
    private boolean e;
    private long g;
    private a pnY;

    public final void a() {
        if (this.e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long eoK = eoK();
        boolean c = c();
        if (eoK != 0 || c) {
            this.e = true;
            a(this, eoK, c);
        }
    }

    private static synchronized void a(a aVar, long j, boolean z) {
        synchronized (a.class) {
            if (pnX == null) {
                pnX = new a();
                new C0994a().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                aVar.g = Math.min(j, aVar.eoL() - nanoTime) + nanoTime;
            } else if (j != 0) {
                aVar.g = nanoTime + j;
            } else if (z) {
                aVar.g = aVar.eoL();
            } else {
                throw new AssertionError();
            }
            long b2 = aVar.b(nanoTime);
            a aVar2 = pnX;
            while (aVar2.pnY != null && b2 >= aVar2.pnY.b(nanoTime)) {
                aVar2 = aVar2.pnY;
            }
            aVar.pnY = aVar2.pnY;
            aVar2.pnY = aVar;
            if (aVar2 == pnX) {
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
        r0.pnY = r3.pnY;
        r3.pnY = null;
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
            a aVar2 = pnX;
            while (true) {
                if (aVar2 != null) {
                    if (aVar2.pnY == aVar) {
                        break;
                    }
                    aVar2 = aVar2.pnY;
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

    protected void eow() {
    }

    public final r a(final r rVar) {
        return new r() { // from class: com.bytedance.sdk.a.a.a.1
            @Override // com.bytedance.sdk.a.a.r
            public void a(c cVar, long j) throws IOException {
                u.a(cVar.f5842b, 0L, j);
                long j2 = j;
                while (j2 > 0) {
                    o oVar = cVar.poc;
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
                        oVar = oVar.poq;
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
            public t eoy() {
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
            public t eoy() {
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
    public static final class C0994a extends Thread {
        C0994a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x001a, code lost:
            r0.eow();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            while (true) {
                synchronized (a.class) {
                    a eox = a.eox();
                    if (eox != null) {
                        if (eox == a.pnX) {
                            a.pnX = null;
                            return;
                        }
                    }
                }
            }
        }
    }

    static a eox() throws InterruptedException {
        a aVar = pnX.pnY;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            a.class.wait(f5839b);
            if (pnX.pnY != null || System.nanoTime() - nanoTime < d) {
                return null;
            }
            return pnX;
        }
        long b2 = aVar.b(System.nanoTime());
        if (b2 > 0) {
            long j = b2 / TimeUtils.NANOS_PER_MS;
            a.class.wait(j, (int) (b2 - (TimeUtils.NANOS_PER_MS * j)));
            return null;
        }
        pnX.pnY = aVar.pnY;
        aVar.pnY = null;
        return aVar;
    }
}
