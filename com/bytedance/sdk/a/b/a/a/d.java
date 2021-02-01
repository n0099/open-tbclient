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
    com.bytedance.sdk.a.a.d pod;
    final com.bytedance.sdk.a.b.a.f.a pom;
    final LinkedHashMap<String, b> pon;
    private final Executor poo;

    static {
        j = !d.class.desiredAssertionStatus();
        f5858a = Pattern.compile("[a-z0-9_-]{1,120}");
    }

    synchronized void a(a aVar, boolean z) throws IOException {
        synchronized (this) {
            b bVar = aVar.poq;
            if (bVar.pow != aVar) {
                throw new IllegalStateException();
            }
            if (z && !bVar.e) {
                for (int i = 0; i < this.c; i++) {
                    if (!aVar.por[i]) {
                        aVar.b();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    } else if (!this.pom.b(bVar.pov[i])) {
                        aVar.b();
                        break;
                    }
                }
            }
            for (int i2 = 0; i2 < this.c; i2++) {
                File file = bVar.pov[i2];
                if (z) {
                    if (this.pom.b(file)) {
                        File file2 = bVar.pou[i2];
                        this.pom.a(file, file2);
                        long j2 = bVar.pnm[i2];
                        long ai = this.pom.ai(file2);
                        bVar.pnm[i2] = ai;
                        this.l = (this.l - j2) + ai;
                    }
                } else {
                    this.pom.a(file);
                }
            }
            this.f++;
            bVar.pow = null;
            if (bVar.e | z) {
                bVar.e = true;
                this.pod.YA("CLEAN").OA(32);
                this.pod.YA(bVar.f5859a);
                bVar.a(this.pod);
                this.pod.OA(10);
                if (z) {
                    long j3 = this.m;
                    this.m = 1 + j3;
                    bVar.g = j3;
                }
            } else {
                this.pon.remove(bVar.f5859a);
                this.pod.YA("REMOVE").OA(32);
                this.pod.YA(bVar.f5859a);
                this.pod.OA(10);
            }
            this.pod.flush();
            if (this.l > this.k || a()) {
                this.poo.execute(this.o);
            }
        }
    }

    boolean a() {
        return this.f >= 2000 && this.f >= this.pon.size();
    }

    boolean a(b bVar) throws IOException {
        if (bVar.pow != null) {
            bVar.pow.a();
        }
        for (int i = 0; i < this.c; i++) {
            this.pom.a(bVar.pou[i]);
            this.l -= bVar.pnm[i];
            bVar.pnm[i] = 0;
        }
        this.f++;
        this.pod.YA("REMOVE").OA(32).YA(bVar.f5859a).OA(10);
        this.pon.remove(bVar.f5859a);
        if (a()) {
            this.poo.execute(this.o);
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
            this.pod.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        b[] bVarArr;
        if (!this.g || this.h) {
            this.h = true;
        } else {
            for (b bVar : (b[]) this.pon.values().toArray(new b[this.pon.size()])) {
                if (bVar.pow != null) {
                    bVar.pow.b();
                }
            }
            c();
            this.pod.close();
            this.pod = null;
            this.h = true;
        }
    }

    void c() throws IOException {
        while (this.l > this.k) {
            a(this.pon.values().iterator().next());
        }
        this.i = false;
    }

    /* loaded from: classes6.dex */
    public final class a {
        private boolean d;
        final b poq;
        final boolean[] por;
        final /* synthetic */ d pot;

        void a() {
            if (this.poq.pow == this) {
                for (int i = 0; i < this.pot.c; i++) {
                    try {
                        this.pot.pom.a(this.poq.pov[i]);
                    } catch (IOException e) {
                    }
                }
                this.poq.pow = null;
            }
        }

        public void b() throws IOException {
            synchronized (this.pot) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.poq.pow == this) {
                    this.pot.a(this, false);
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
        final long[] pnm;
        final File[] pou;
        final File[] pov;
        a pow;

        void a(com.bytedance.sdk.a.a.d dVar) throws IOException {
            for (long j : this.pnm) {
                dVar.OA(32).io(j);
            }
        }
    }
}
