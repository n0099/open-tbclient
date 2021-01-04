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
    static final Pattern f6155a;
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
    final com.bytedance.sdk.a.b.a.f.a piC;
    final LinkedHashMap<String, b> piD;
    private final Executor piE;
    com.bytedance.sdk.a.a.d piu;

    static {
        j = !d.class.desiredAssertionStatus();
        f6155a = Pattern.compile("[a-z0-9_-]{1,120}");
    }

    synchronized void a(a aVar, boolean z) throws IOException {
        synchronized (this) {
            b bVar = aVar.piF;
            if (bVar.piK != aVar) {
                throw new IllegalStateException();
            }
            if (z && !bVar.e) {
                for (int i = 0; i < this.c; i++) {
                    if (!aVar.piG[i]) {
                        aVar.b();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    } else if (!this.piC.b(bVar.piJ[i])) {
                        aVar.b();
                        break;
                    }
                }
            }
            for (int i2 = 0; i2 < this.c; i2++) {
                File file = bVar.piJ[i2];
                if (z) {
                    if (this.piC.b(file)) {
                        File file2 = bVar.piI[i2];
                        this.piC.a(file, file2);
                        long j2 = bVar.phA[i2];
                        long am = this.piC.am(file2);
                        bVar.phA[i2] = am;
                        this.l = (this.l - j2) + am;
                    }
                } else {
                    this.piC.a(file);
                }
            }
            this.f++;
            bVar.piK = null;
            if (bVar.e | z) {
                bVar.e = true;
                this.piu.YH("CLEAN").PM(32);
                this.piu.YH(bVar.f6156a);
                bVar.a(this.piu);
                this.piu.PM(10);
                if (z) {
                    long j3 = this.m;
                    this.m = 1 + j3;
                    bVar.g = j3;
                }
            } else {
                this.piD.remove(bVar.f6156a);
                this.piu.YH("REMOVE").PM(32);
                this.piu.YH(bVar.f6156a);
                this.piu.PM(10);
            }
            this.piu.flush();
            if (this.l > this.k || a()) {
                this.piE.execute(this.o);
            }
        }
    }

    boolean a() {
        return this.f >= 2000 && this.f >= this.piD.size();
    }

    boolean a(b bVar) throws IOException {
        if (bVar.piK != null) {
            bVar.piK.a();
        }
        for (int i = 0; i < this.c; i++) {
            this.piC.a(bVar.piI[i]);
            this.l -= bVar.phA[i];
            bVar.phA[i] = 0;
        }
        this.f++;
        this.piu.YH("REMOVE").PM(32).YH(bVar.f6156a).PM(10);
        this.piD.remove(bVar.f6156a);
        if (a()) {
            this.piE.execute(this.o);
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
            this.piu.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        b[] bVarArr;
        if (!this.g || this.h) {
            this.h = true;
        } else {
            for (b bVar : (b[]) this.piD.values().toArray(new b[this.piD.size()])) {
                if (bVar.piK != null) {
                    bVar.piK.b();
                }
            }
            c();
            this.piu.close();
            this.piu = null;
            this.h = true;
        }
    }

    void c() throws IOException {
        while (this.l > this.k) {
            a(this.piD.values().iterator().next());
        }
        this.i = false;
    }

    /* loaded from: classes4.dex */
    public final class a {
        private boolean d;
        final b piF;
        final boolean[] piG;
        final /* synthetic */ d piH;

        void a() {
            if (this.piF.piK == this) {
                for (int i = 0; i < this.piH.c; i++) {
                    try {
                        this.piH.piC.a(this.piF.piJ[i]);
                    } catch (IOException e) {
                    }
                }
                this.piF.piK = null;
            }
        }

        public void b() throws IOException {
            synchronized (this.piH) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.piF.piK == this) {
                    this.piH.a(this, false);
                }
                this.d = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public final class b {

        /* renamed from: a  reason: collision with root package name */
        final String f6156a;
        boolean e;
        long g;
        final long[] phA;
        final File[] piI;
        final File[] piJ;
        a piK;

        void a(com.bytedance.sdk.a.a.d dVar) throws IOException {
            for (long j : this.phA) {
                dVar.PM(32).il(j);
            }
        }
    }
}
