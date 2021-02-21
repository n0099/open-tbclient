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
    static final Pattern f5858a;
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
    com.bytedance.sdk.a.a.d poG;
    final com.bytedance.sdk.a.b.a.f.a poO;
    final LinkedHashMap<String, b> poP;
    private final Executor poQ;

    static {
        j = !d.class.desiredAssertionStatus();
        f5858a = Pattern.compile("[a-z0-9_-]{1,120}");
    }

    synchronized void a(a aVar, boolean z) throws IOException {
        synchronized (this) {
            b bVar = aVar.poR;
            if (bVar.poW != aVar) {
                throw new IllegalStateException();
            }
            if (z && !bVar.e) {
                for (int i = 0; i < this.c; i++) {
                    if (!aVar.poS[i]) {
                        aVar.b();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    } else if (!this.poO.b(bVar.poV[i])) {
                        aVar.b();
                        break;
                    }
                }
            }
            for (int i2 = 0; i2 < this.c; i2++) {
                File file = bVar.poV[i2];
                if (z) {
                    if (this.poO.b(file)) {
                        File file2 = bVar.poU[i2];
                        this.poO.a(file, file2);
                        long j2 = bVar.pnM[i2];
                        long aj = this.poO.aj(file2);
                        bVar.pnM[i2] = aj;
                        this.l = (this.l - j2) + aj;
                    }
                } else {
                    this.poO.a(file);
                }
            }
            this.f++;
            bVar.poW = null;
            if (bVar.e | z) {
                bVar.e = true;
                this.poG.YM("CLEAN").OB(32);
                this.poG.YM(bVar.f5859a);
                bVar.a(this.poG);
                this.poG.OB(10);
                if (z) {
                    long j3 = this.m;
                    this.m = 1 + j3;
                    bVar.g = j3;
                }
            } else {
                this.poP.remove(bVar.f5859a);
                this.poG.YM("REMOVE").OB(32);
                this.poG.YM(bVar.f5859a);
                this.poG.OB(10);
            }
            this.poG.flush();
            if (this.l > this.k || a()) {
                this.poQ.execute(this.o);
            }
        }
    }

    boolean a() {
        return this.f >= 2000 && this.f >= this.poP.size();
    }

    boolean a(b bVar) throws IOException {
        if (bVar.poW != null) {
            bVar.poW.a();
        }
        for (int i = 0; i < this.c; i++) {
            this.poO.a(bVar.poU[i]);
            this.l -= bVar.pnM[i];
            bVar.pnM[i] = 0;
        }
        this.f++;
        this.poG.YM("REMOVE").OB(32).YM(bVar.f5859a).OB(10);
        this.poP.remove(bVar.f5859a);
        if (a()) {
            this.poQ.execute(this.o);
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
            this.poG.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        b[] bVarArr;
        if (!this.g || this.h) {
            this.h = true;
        } else {
            for (b bVar : (b[]) this.poP.values().toArray(new b[this.poP.size()])) {
                if (bVar.poW != null) {
                    bVar.poW.b();
                }
            }
            c();
            this.poG.close();
            this.poG = null;
            this.h = true;
        }
    }

    void c() throws IOException {
        while (this.l > this.k) {
            a(this.poP.values().iterator().next());
        }
        this.i = false;
    }

    /* loaded from: classes6.dex */
    public final class a {
        private boolean d;
        final b poR;
        final boolean[] poS;
        final /* synthetic */ d poT;

        void a() {
            if (this.poR.poW == this) {
                for (int i = 0; i < this.poT.c; i++) {
                    try {
                        this.poT.poO.a(this.poR.poV[i]);
                    } catch (IOException e) {
                    }
                }
                this.poR.poW = null;
            }
        }

        public void b() throws IOException {
            synchronized (this.poT) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.poR.poW == this) {
                    this.poT.a(this, false);
                }
                this.d = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class b {

        /* renamed from: a  reason: collision with root package name */
        final String f5859a;
        boolean e;
        long g;
        final long[] pnM;
        final File[] poU;
        final File[] poV;
        a poW;

        void a(com.bytedance.sdk.a.a.d dVar) throws IOException {
            for (long j : this.pnM) {
                dVar.OB(32).io(j);
            }
        }
    }
}
