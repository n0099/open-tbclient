package com.bytedance.sdk.a.b.a.a;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public final class d implements Closeable, Flushable {

    /* renamed from: a  reason: collision with root package name */
    static final Pattern f3947a;
    static final /* synthetic */ boolean j;
    final int c;
    int f;
    boolean g;
    boolean h;
    boolean i;
    private long k;
    private long l;
    private long m;
    private final Runnable o;
    com.bytedance.sdk.a.a.d pqN;
    final com.bytedance.sdk.a.b.a.f.a pqV;
    final LinkedHashMap<String, b> pqW;
    private final Executor pqX;

    static {
        j = !d.class.desiredAssertionStatus();
        f3947a = Pattern.compile("[a-z0-9_-]{1,120}");
    }

    synchronized void a(a aVar, boolean z) throws IOException {
        synchronized (this) {
            b bVar = aVar.pqY;
            if (bVar.prd != aVar) {
                throw new IllegalStateException();
            }
            if (z && !bVar.e) {
                for (int i = 0; i < this.c; i++) {
                    if (!aVar.pqZ[i]) {
                        aVar.b();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    } else if (!this.pqV.b(bVar.prc[i])) {
                        aVar.b();
                        break;
                    }
                }
            }
            for (int i2 = 0; i2 < this.c; i2++) {
                File file = bVar.prc[i2];
                if (z) {
                    if (this.pqV.b(file)) {
                        File file2 = bVar.prb[i2];
                        this.pqV.a(file, file2);
                        long j2 = bVar.ppW[i2];
                        long aj = this.pqV.aj(file2);
                        bVar.ppW[i2] = aj;
                        this.l = (this.l - j2) + aj;
                    }
                } else {
                    this.pqV.a(file);
                }
            }
            this.f++;
            bVar.prd = null;
            if (bVar.e | z) {
                bVar.e = true;
                this.pqN.YT("CLEAN").OF(32);
                this.pqN.YT(bVar.f3948a);
                bVar.a(this.pqN);
                this.pqN.OF(10);
                if (z) {
                    long j3 = this.m;
                    this.m = 1 + j3;
                    bVar.g = j3;
                }
            } else {
                this.pqW.remove(bVar.f3948a);
                this.pqN.YT("REMOVE").OF(32);
                this.pqN.YT(bVar.f3948a);
                this.pqN.OF(10);
            }
            this.pqN.flush();
            if (this.l > this.k || a()) {
                this.pqX.execute(this.o);
            }
        }
    }

    boolean a() {
        return this.f >= 2000 && this.f >= this.pqW.size();
    }

    boolean a(b bVar) throws IOException {
        if (bVar.prd != null) {
            bVar.prd.a();
        }
        for (int i = 0; i < this.c; i++) {
            this.pqV.a(bVar.prb[i]);
            this.l -= bVar.ppW[i];
            bVar.ppW[i] = 0;
        }
        this.f++;
        this.pqN.YT("REMOVE").OF(32).YT(bVar.f3948a).OF(10);
        this.pqW.remove(bVar.f3948a);
        if (a()) {
            this.pqX.execute(this.o);
            return true;
        }
        return true;
    }

    public synchronized boolean b() {
        return this.h;
    }

    private synchronized void d() {
        if (b()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.g) {
            d();
            c();
            this.pqN.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        b[] bVarArr;
        if (!this.g || this.h) {
            this.h = true;
        } else {
            for (b bVar : (b[]) this.pqW.values().toArray(new b[this.pqW.size()])) {
                if (bVar.prd != null) {
                    bVar.prd.b();
                }
            }
            c();
            this.pqN.close();
            this.pqN = null;
            this.h = true;
        }
    }

    void c() throws IOException {
        while (this.l > this.k) {
            a(this.pqW.values().iterator().next());
        }
        this.i = false;
    }

    /* loaded from: classes6.dex */
    public final class a {
        private boolean d;
        final b pqY;
        final boolean[] pqZ;
        final /* synthetic */ d pra;

        void a() {
            if (this.pqY.prd == this) {
                for (int i = 0; i < this.pra.c; i++) {
                    try {
                        this.pra.pqV.a(this.pqY.prc[i]);
                    } catch (IOException e) {
                    }
                }
                this.pqY.prd = null;
            }
        }

        public void b() throws IOException {
            synchronized (this.pra) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.pqY.prd == this) {
                    this.pra.a(this, false);
                }
                this.d = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class b {

        /* renamed from: a  reason: collision with root package name */
        final String f3948a;
        boolean e;
        long g;
        final long[] ppW;
        final File[] prb;
        final File[] prc;
        a prd;

        void a(com.bytedance.sdk.a.a.d dVar) throws IOException {
            for (long j : this.ppW) {
                dVar.OF(32).io(j);
            }
        }
    }
}
