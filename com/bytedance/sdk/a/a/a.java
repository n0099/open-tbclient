package com.bytedance.sdk.a.a;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class a extends t {

    /* renamed from: b  reason: collision with root package name */
    private static final long f6136b = TimeUnit.SECONDS.toMillis(60);
    private static final long d = TimeUnit.MILLISECONDS.toNanos(f6136b);
    static a phL;
    private boolean e;
    private long g;
    private a phM;

    public final void a() {
        if (this.e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long eqd = eqd();
        boolean c = c();
        if (eqd != 0 || c) {
            this.e = true;
            a(this, eqd, c);
        }
    }

    private static synchronized void a(a aVar, long j, boolean z) {
        synchronized (a.class) {
            if (phL == null) {
                phL = new a();
                new C0967a().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                aVar.g = Math.min(j, aVar.eqe() - nanoTime) + nanoTime;
            } else if (j != 0) {
                aVar.g = nanoTime + j;
            } else if (z) {
                aVar.g = aVar.eqe();
            } else {
                throw new AssertionError();
            }
            long b2 = aVar.b(nanoTime);
            a aVar2 = phL;
            while (aVar2.phM != null && b2 >= aVar2.phM.b(nanoTime)) {
                aVar2 = aVar2.phM;
            }
            aVar.phM = aVar2.phM;
            aVar2.phM = aVar;
            if (aVar2 == phL) {
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
        r0.phM = r3.phM;
        r3.phM = null;
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
            a aVar2 = phL;
            while (true) {
                if (aVar2 != null) {
                    if (aVar2.phM == aVar) {
                        break;
                    }
                    aVar2 = aVar2.phM;
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

    protected void epP() {
    }

    public final r a(final r rVar) {
        return new r() { // from class: com.bytedance.sdk.a.a.a.1
            @Override // com.bytedance.sdk.a.a.r
            public void a(c cVar, long j) throws IOException {
                u.a(cVar.f6139b, 0L, j);
                long j2 = j;
                while (j2 > 0) {
                    o oVar = cVar.phQ;
                    long j3 = 0;
                    while (true) {
                        if (j3 >= 65536) {
                            break;
                        }
                        j3 += oVar.c - oVar.f6148b;
                        if (j3 >= j2) {
                            j3 = j2;
                            break;
                        }
                        oVar = oVar.pie;
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
            public t epR() {
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
            public t epR() {
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
    /* loaded from: classes4.dex */
    public static final class C0967a extends Thread {
        C0967a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x001a, code lost:
            r0.epP();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            while (true) {
                synchronized (a.class) {
                    a epQ = a.epQ();
                    if (epQ != null) {
                        if (epQ == a.phL) {
                            a.phL = null;
                            return;
                        }
                    }
                }
            }
        }
    }

    static a epQ() throws InterruptedException {
        a aVar = phL.phM;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            a.class.wait(f6136b);
            if (phL.phM != null || System.nanoTime() - nanoTime < d) {
                return null;
            }
            return phL;
        }
        long b2 = aVar.b(System.nanoTime());
        if (b2 > 0) {
            long j = b2 / TimeUtils.NANOS_PER_MS;
            a.class.wait(j, (int) (b2 - (TimeUtils.NANOS_PER_MS * j)));
            return null;
        }
        phL.phM = aVar.phM;
        aVar.phM = null;
        return aVar;
    }
}
