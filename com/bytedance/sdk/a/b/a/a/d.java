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
    com.bytedance.sdk.a.a.d pdP;
    final com.bytedance.sdk.a.b.a.f.a pdX;
    final LinkedHashMap<String, b> pdY;
    private final Executor pdZ;

    static {
        j = !d.class.desiredAssertionStatus();
        f5856a = Pattern.compile("[a-z0-9_-]{1,120}");
    }

    synchronized void a(a aVar, boolean z) throws IOException {
        synchronized (this) {
            b bVar = aVar.pea;
            if (bVar.pef != aVar) {
                throw new IllegalStateException();
            }
            if (z && !bVar.e) {
                for (int i = 0; i < this.c; i++) {
                    if (!aVar.peb[i]) {
                        aVar.b();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    } else if (!this.pdX.b(bVar.pee[i])) {
                        aVar.b();
                        break;
                    }
                }
            }
            for (int i2 = 0; i2 < this.c; i2++) {
                File file = bVar.pee[i2];
                if (z) {
                    if (this.pdX.b(file)) {
                        File file2 = bVar.ped[i2];
                        this.pdX.a(file, file2);
                        long j2 = bVar.pcY[i2];
                        long al = this.pdX.al(file2);
                        bVar.pcY[i2] = al;
                        this.l = (this.l - j2) + al;
                    }
                } else {
                    this.pdX.a(file);
                }
            }
            this.f++;
            bVar.pef = null;
            if (bVar.e | z) {
                bVar.e = true;
                this.pdP.Xy("CLEAN").Of(32);
                this.pdP.Xy(bVar.f5857a);
                bVar.a(this.pdP);
                this.pdP.Of(10);
                if (z) {
                    long j3 = this.m;
                    this.m = 1 + j3;
                    bVar.g = j3;
                }
            } else {
                this.pdY.remove(bVar.f5857a);
                this.pdP.Xy("REMOVE").Of(32);
                this.pdP.Xy(bVar.f5857a);
                this.pdP.Of(10);
            }
            this.pdP.flush();
            if (this.l > this.k || a()) {
                this.pdZ.execute(this.o);
            }
        }
    }

    boolean a() {
        return this.f >= 2000 && this.f >= this.pdY.size();
    }

    boolean a(b bVar) throws IOException {
        if (bVar.pef != null) {
            bVar.pef.a();
        }
        for (int i = 0; i < this.c; i++) {
            this.pdX.a(bVar.ped[i]);
            this.l -= bVar.pcY[i];
            bVar.pcY[i] = 0;
        }
        this.f++;
        this.pdP.Xy("REMOVE").Of(32).Xy(bVar.f5857a).Of(10);
        this.pdY.remove(bVar.f5857a);
        if (a()) {
            this.pdZ.execute(this.o);
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
            this.pdP.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        b[] bVarArr;
        if (!this.g || this.h) {
            this.h = true;
        } else {
            for (b bVar : (b[]) this.pdY.values().toArray(new b[this.pdY.size()])) {
                if (bVar.pef != null) {
                    bVar.pef.b();
                }
            }
            c();
            this.pdP.close();
            this.pdP = null;
            this.h = true;
        }
    }

    void c() throws IOException {
        while (this.l > this.k) {
            a(this.pdY.values().iterator().next());
        }
        this.i = false;
    }

    /* loaded from: classes4.dex */
    public final class a {
        private boolean d;
        final b pea;
        final boolean[] peb;
        final /* synthetic */ d pec;

        void a() {
            if (this.pea.pef == this) {
                for (int i = 0; i < this.pec.c; i++) {
                    try {
                        this.pec.pdX.a(this.pea.pee[i]);
                    } catch (IOException e) {
                    }
                }
                this.pea.pef = null;
            }
        }

        public void b() throws IOException {
            synchronized (this.pec) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.pea.pef == this) {
                    this.pec.a(this, false);
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
        final long[] pcY;
        final File[] ped;
        final File[] pee;
        a pef;

        void a(com.bytedance.sdk.a.a.d dVar) throws IOException {
            for (long j : this.pcY) {
                dVar.Of(32).il(j);
            }
        }
    }
}
