package com.bytedance.sdk.a.b.a.a;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public final class d implements Closeable, Flushable {

    /* renamed from: a  reason: collision with root package name */
    static final Pattern f5856a;
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
    com.bytedance.sdk.a.a.d pdQ;
    final com.bytedance.sdk.a.b.a.f.a pdY;
    final LinkedHashMap<String, b> pdZ;
    private final Executor pea;

    static {
        j = !d.class.desiredAssertionStatus();
        f5856a = Pattern.compile("[a-z0-9_-]{1,120}");
    }

    synchronized void a(a aVar, boolean z) throws IOException {
        synchronized (this) {
            b bVar = aVar.peb;
            if (bVar.peg != aVar) {
                throw new IllegalStateException();
            }
            if (z && !bVar.e) {
                for (int i = 0; i < this.c; i++) {
                    if (!aVar.pec[i]) {
                        aVar.b();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    } else if (!this.pdY.b(bVar.pef[i])) {
                        aVar.b();
                        break;
                    }
                }
            }
            for (int i2 = 0; i2 < this.c; i2++) {
                File file = bVar.pef[i2];
                if (z) {
                    if (this.pdY.b(file)) {
                        File file2 = bVar.pee[i2];
                        this.pdY.a(file, file2);
                        long j2 = bVar.pcZ[i2];
                        long al = this.pdY.al(file2);
                        bVar.pcZ[i2] = al;
                        this.l = (this.l - j2) + al;
                    }
                } else {
                    this.pdY.a(file);
                }
            }
            this.f++;
            bVar.peg = null;
            if (bVar.e | z) {
                bVar.e = true;
                this.pdQ.Xz("CLEAN").Of(32);
                this.pdQ.Xz(bVar.f5857a);
                bVar.a(this.pdQ);
                this.pdQ.Of(10);
                if (z) {
                    long j3 = this.m;
                    this.m = 1 + j3;
                    bVar.g = j3;
                }
            } else {
                this.pdZ.remove(bVar.f5857a);
                this.pdQ.Xz("REMOVE").Of(32);
                this.pdQ.Xz(bVar.f5857a);
                this.pdQ.Of(10);
            }
            this.pdQ.flush();
            if (this.l > this.k || a()) {
                this.pea.execute(this.o);
            }
        }
    }

    boolean a() {
        return this.f >= 2000 && this.f >= this.pdZ.size();
    }

    boolean a(b bVar) throws IOException {
        if (bVar.peg != null) {
            bVar.peg.a();
        }
        for (int i = 0; i < this.c; i++) {
            this.pdY.a(bVar.pee[i]);
            this.l -= bVar.pcZ[i];
            bVar.pcZ[i] = 0;
        }
        this.f++;
        this.pdQ.Xz("REMOVE").Of(32).Xz(bVar.f5857a).Of(10);
        this.pdZ.remove(bVar.f5857a);
        if (a()) {
            this.pea.execute(this.o);
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
            this.pdQ.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        b[] bVarArr;
        if (!this.g || this.h) {
            this.h = true;
        } else {
            for (b bVar : (b[]) this.pdZ.values().toArray(new b[this.pdZ.size()])) {
                if (bVar.peg != null) {
                    bVar.peg.b();
                }
            }
            c();
            this.pdQ.close();
            this.pdQ = null;
            this.h = true;
        }
    }

    void c() throws IOException {
        while (this.l > this.k) {
            a(this.pdZ.values().iterator().next());
        }
        this.i = false;
    }

    /* loaded from: classes4.dex */
    public final class a {
        private boolean d;
        final b peb;
        final boolean[] pec;
        final /* synthetic */ d ped;

        void a() {
            if (this.peb.peg == this) {
                for (int i = 0; i < this.ped.c; i++) {
                    try {
                        this.ped.pdY.a(this.peb.pef[i]);
                    } catch (IOException e) {
                    }
                }
                this.peb.peg = null;
            }
        }

        public void b() throws IOException {
            synchronized (this.ped) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.peb.peg == this) {
                    this.ped.a(this, false);
                }
                this.d = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public final class b {

        /* renamed from: a  reason: collision with root package name */
        final String f5857a;
        boolean e;
        long g;
        final long[] pcZ;
        final File[] pee;
        final File[] pef;
        a peg;

        void a(com.bytedance.sdk.a.a.d dVar) throws IOException {
            for (long j : this.pcZ) {
                dVar.Of(32).il(j);
            }
        }
    }
}
