package com.bytedance.sdk.a.b.a.e;

import android.os.SystemClock;
import com.bytedance.sdk.a.b.a.e.h;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class g implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    static final ExecutorService f3970a;
    static final /* synthetic */ boolean s;
    final boolean b;
    private Map<Integer, l> ckm;
    final String e;
    int f;
    int g;
    boolean h;
    long k;
    final j psA;
    final c psB;
    final b psu;
    private final ExecutorService psv;
    final m psw;
    final Socket psz;
    private int v;
    final Map<Integer, i> d = new LinkedHashMap();
    long j = 0;
    n psx = new n();
    final n psy = new n();
    boolean n = false;
    final Set<Integer> psC = new LinkedHashSet();

    static {
        s = !g.class.desiredAssertionStatus();
        f3970a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.a.b.a.c.bm("OkHttp Http2Connection", true));
    }

    g(a aVar) {
        this.psw = aVar.psJ;
        this.b = aVar.g;
        this.psu = aVar.psI;
        this.g = aVar.g ? 1 : 2;
        if (aVar.g) {
            this.g += 2;
        }
        this.v = aVar.g ? 1 : 2;
        if (aVar.g) {
            this.psx.dV(7, 16777216);
        }
        this.e = aVar.b;
        this.psv = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.bytedance.sdk.a.b.a.c.bm(com.bytedance.sdk.a.b.a.c.a("OkHttp %s Push Observer", this.e), true));
        this.psy.dV(7, 65535);
        this.psy.dV(5, 16384);
        this.k = this.psy.d();
        this.psz = aVar.f3978a;
        this.psA = new j(aVar.pqN, this.b);
        this.psB = new c(new h(aVar.prV, this.b));
    }

    synchronized i OH(int i) {
        return this.d.get(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized i OI(int i) {
        i remove;
        remove = this.d.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    public synchronized int a() {
        return this.psy.c(Integer.MAX_VALUE);
    }

    public i C(List<com.bytedance.sdk.a.b.a.e.c> list, boolean z) throws IOException {
        return a(0, list, z);
    }

    private i a(int i, List<com.bytedance.sdk.a.b.a.e.c> list, boolean z) throws IOException {
        int i2;
        i iVar;
        boolean z2 = false;
        boolean z3 = !z;
        synchronized (this.psA) {
            synchronized (this) {
                if (this.h) {
                    throw new com.bytedance.sdk.a.b.a.e.a();
                }
                i2 = this.g;
                this.g += 2;
                iVar = new i(i2, this, z3, false, list);
                if (!z || this.k == 0 || iVar.b == 0) {
                    z2 = true;
                }
                if (iVar.b()) {
                    this.d.put(Integer.valueOf(i2), iVar);
                }
            }
            if (i == 0) {
                this.psA.a(z3, i2, i, list);
            } else if (this.b) {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            } else {
                this.psA.b(i, i2, list);
            }
        }
        if (z2) {
            this.psA.b();
        }
        return iVar;
    }

    public void a(int i, boolean z, com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
        int min;
        if (j == 0) {
            this.psA.a(z, i, cVar, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (this.k <= 0) {
                    try {
                        if (!this.d.containsKey(Integer.valueOf(i))) {
                            throw new IOException("stream closed");
                        }
                        wait();
                    } catch (InterruptedException e) {
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j, this.k), this.psA.c());
                this.k -= min;
            }
            j -= min;
            this.psA.a(z && j == 0, i, cVar, min);
        }
    }

    void a(long j) {
        this.k += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final int i, final com.bytedance.sdk.a.b.a.e.b bVar) {
        f3970a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s stream %d", new Object[]{this.e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.1
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                try {
                    g.this.b(i, bVar);
                } catch (IOException e) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i, com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        this.psA.a(i, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final int i, final long j) {
        f3970a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp Window Update %s stream %d", new Object[]{this.e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.2
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                try {
                    g.this.psA.a(i, j);
                } catch (IOException e) {
                }
            }
        });
    }

    void a(final boolean z, final int i, final int i2, final l lVar) {
        f3970a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s ping %08x%08x", new Object[]{this.e, Integer.valueOf(i), Integer.valueOf(i2)}) { // from class: com.bytedance.sdk.a.b.a.e.g.3
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                try {
                    g.this.b(z, i, i2, lVar);
                } catch (IOException e) {
                }
            }
        });
    }

    void b(boolean z, int i, int i2, l lVar) throws IOException {
        synchronized (this.psA) {
            if (lVar != null) {
                lVar.a();
            }
            this.psA.b(z, i, i2);
        }
    }

    synchronized l OJ(int i) {
        return this.ckm != null ? this.ckm.remove(Integer.valueOf(i)) : null;
    }

    public void b() throws IOException {
        this.psA.b();
    }

    public void a(com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        synchronized (this.psA) {
            synchronized (this) {
                if (!this.h) {
                    this.h = true;
                    this.psA.a(this.f, bVar, com.bytedance.sdk.a.b.a.c.f3956a);
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a(com.bytedance.sdk.a.b.a.e.b.NO_ERROR, com.bytedance.sdk.a.b.a.e.b.CANCEL);
    }

    void a(com.bytedance.sdk.a.b.a.e.b bVar, com.bytedance.sdk.a.b.a.e.b bVar2) throws IOException {
        IOException iOException;
        i[] iVarArr;
        l[] lVarArr;
        if (!s && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        try {
            a(bVar);
            iOException = null;
        } catch (IOException e) {
            iOException = e;
        }
        synchronized (this) {
            if (this.d.isEmpty()) {
                iVarArr = null;
            } else {
                this.d.clear();
                iVarArr = (i[]) this.d.values().toArray(new i[this.d.size()]);
            }
            if (this.ckm != null) {
                this.ckm = null;
                lVarArr = (l[]) this.ckm.values().toArray(new l[this.ckm.size()]);
            } else {
                lVarArr = null;
            }
        }
        if (iVarArr != null) {
            IOException iOException2 = iOException;
            for (i iVar : iVarArr) {
                try {
                    iVar.a(bVar2);
                } catch (IOException e2) {
                    if (iOException2 != null) {
                        iOException2 = e2;
                    }
                }
            }
            iOException = iOException2;
        }
        if (lVarArr != null) {
            for (l lVar : lVarArr) {
                lVar.c();
            }
        }
        try {
            this.psA.close();
            e = iOException;
        } catch (IOException e3) {
            e = e3;
            if (iOException != null) {
                e = iOException;
            }
        }
        try {
            this.psz.close();
        } catch (IOException e4) {
            e = e4;
        }
        if (e != null) {
            throw e;
        }
    }

    public void c() throws IOException {
        a(true);
    }

    void a(boolean z) throws IOException {
        if (z) {
            this.psA.a();
            this.psA.b(this.psx);
            int d = this.psx.d();
            if (d != 65535) {
                this.psA.a(0, d - 65535);
            }
        }
        Thread thread = new Thread(this.psB);
        thread.setName("tt_pangle_thread_http2_connection" + SystemClock.uptimeMillis());
        thread.start();
    }

    public synchronized boolean d() {
        return this.h;
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        Socket f3978a;
        String b;
        boolean g;
        com.bytedance.sdk.a.a.d pqN;
        com.bytedance.sdk.a.a.e prV;
        b psI = b.psK;
        m psJ = m.ptj;

        public a(boolean z) {
            this.g = z;
        }

        public a a(Socket socket, String str, com.bytedance.sdk.a.a.e eVar, com.bytedance.sdk.a.a.d dVar) {
            this.f3978a = socket;
            this.b = str;
            this.prV = eVar;
            this.pqN = dVar;
            return this;
        }

        public a a(b bVar) {
            this.psI = bVar;
            return this;
        }

        public g epH() {
            return new g(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c extends com.bytedance.sdk.a.b.a.b implements h.b {
        final h psL;

        c(h hVar) {
            super("OkHttp %s", g.this.e);
            this.psL = hVar;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0004 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.sdk.a.b.a.e.b] */
        /* JADX WARN: Type inference failed for: r0v11, types: [java.io.Closeable, com.bytedance.sdk.a.b.a.e.h] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9, types: [com.bytedance.sdk.a.b.a.e.b] */
        /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.sdk.a.b.a.e.g] */
        @Override // com.bytedance.sdk.a.b.a.b
        protected void b() {
            com.bytedance.sdk.a.b.a.e.b bVar;
            Throwable th;
            ?? r0 = com.bytedance.sdk.a.b.a.e.b.INTERNAL_ERROR;
            com.bytedance.sdk.a.b.a.e.b bVar2 = com.bytedance.sdk.a.b.a.e.b.INTERNAL_ERROR;
            try {
                try {
                    this.psL.a(this);
                    do {
                    } while (this.psL.a(false, (h.b) this));
                    r0 = com.bytedance.sdk.a.b.a.e.b.NO_ERROR;
                    try {
                        g.this.a(r0, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                    } catch (IOException e) {
                    }
                    r0 = this.psL;
                    com.bytedance.sdk.a.b.a.c.a((Closeable) r0);
                } catch (Throwable th2) {
                    th = th2;
                    bVar = r0;
                    try {
                        g.this.a(bVar, bVar2);
                    } catch (IOException e2) {
                    }
                    com.bytedance.sdk.a.b.a.c.a(this.psL);
                    throw th;
                }
            } catch (IOException e3) {
                bVar = com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR;
                try {
                    try {
                        g.this.a(bVar, com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                    } catch (IOException e4) {
                    }
                    com.bytedance.sdk.a.b.a.c.a(this.psL);
                } catch (Throwable th3) {
                    th = th3;
                    g.this.a(bVar, bVar2);
                    com.bytedance.sdk.a.b.a.c.a(this.psL);
                    throw th;
                }
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(boolean z, int i, com.bytedance.sdk.a.a.e eVar, int i2) throws IOException {
            if (g.this.d(i)) {
                g.this.a(i, eVar, i2, z);
                return;
            }
            i OH = g.this.OH(i);
            if (OH == null) {
                g.this.a(i, com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                eVar.h(i2);
                return;
            }
            OH.a(eVar, i2);
            if (z) {
                OH.i();
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(boolean z, int i, int i2, List<com.bytedance.sdk.a.b.a.e.c> list) {
            if (g.this.d(i)) {
                g.this.b(i, list, z);
                return;
            }
            synchronized (g.this) {
                i OH = g.this.OH(i);
                if (OH == null) {
                    if (!g.this.h) {
                        if (i > g.this.f) {
                            if (i % 2 != g.this.g % 2) {
                                final i iVar = new i(i, g.this, false, z, list);
                                g.this.f = i;
                                g.this.d.put(Integer.valueOf(i), iVar);
                                g.f3970a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s stream %d", new Object[]{g.this.e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.c.1
                                    @Override // com.bytedance.sdk.a.b.a.b
                                    public void b() {
                                        try {
                                            g.this.psu.a(iVar);
                                        } catch (IOException e) {
                                            com.bytedance.sdk.a.b.a.g.e.epO().a(4, "Http2Connection.Listener failure for " + g.this.e, e);
                                            try {
                                                iVar.a(com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                                            } catch (IOException e2) {
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }
                } else {
                    OH.a(list);
                    if (z) {
                        OH.i();
                    }
                }
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(int i, com.bytedance.sdk.a.b.a.e.b bVar) {
            if (g.this.d(i)) {
                g.this.c(i, bVar);
                return;
            }
            i OI = g.this.OI(i);
            if (OI != null) {
                OI.d(bVar);
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(boolean z, n nVar) {
            i[] iVarArr;
            long j;
            synchronized (g.this) {
                int d = g.this.psy.d();
                if (z) {
                    g.this.psy.a();
                }
                g.this.psy.a(nVar);
                a(nVar);
                int d2 = g.this.psy.d();
                if (d2 == -1 || d2 == d) {
                    iVarArr = null;
                    j = 0;
                } else {
                    j = d2 - d;
                    if (!g.this.n) {
                        g.this.a(j);
                        g.this.n = true;
                    }
                    iVarArr = !g.this.d.isEmpty() ? (i[]) g.this.d.values().toArray(new i[g.this.d.size()]) : null;
                }
                g.f3970a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s settings", g.this.e) { // from class: com.bytedance.sdk.a.b.a.e.g.c.2
                    @Override // com.bytedance.sdk.a.b.a.b
                    public void b() {
                        g.this.psu.a(g.this);
                    }
                });
            }
            if (iVarArr != null && j != 0) {
                for (i iVar : iVarArr) {
                    synchronized (iVar) {
                        iVar.a(j);
                    }
                }
            }
        }

        private void a(final n nVar) {
            g.f3970a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s ACK Settings", new Object[]{g.this.e}) { // from class: com.bytedance.sdk.a.b.a.e.g.c.3
                @Override // com.bytedance.sdk.a.b.a.b
                public void b() {
                    try {
                        g.this.psA.a(nVar);
                    } catch (IOException e) {
                    }
                }
            });
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a() {
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void b(boolean z, int i, int i2) {
            if (z) {
                l OJ = g.this.OJ(i);
                if (OJ != null) {
                    OJ.b();
                    return;
                }
                return;
            }
            g.this.a(true, i, i2, (l) null);
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(int i, com.bytedance.sdk.a.b.a.e.b bVar, com.bytedance.sdk.a.a.f fVar) {
            i[] iVarArr;
            if (fVar.g() > 0) {
            }
            synchronized (g.this) {
                iVarArr = (i[]) g.this.d.values().toArray(new i[g.this.d.size()]);
                g.this.h = true;
            }
            for (i iVar : iVarArr) {
                if (iVar.a() > i && iVar.c()) {
                    iVar.d(com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM);
                    g.this.OI(iVar.a());
                }
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(int i, long j) {
            if (i == 0) {
                synchronized (g.this) {
                    g.this.k += j;
                    g.this.notifyAll();
                }
                return;
            }
            i OH = g.this.OH(i);
            if (OH != null) {
                synchronized (OH) {
                    OH.a(j);
                }
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(int i, int i2, int i3, boolean z) {
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void b(int i, int i2, List<com.bytedance.sdk.a.b.a.e.c> list) {
            g.this.a(i2, list);
        }
    }

    boolean d(int i) {
        return i != 0 && (i & 1) == 0;
    }

    void a(final int i, final List<com.bytedance.sdk.a.b.a.e.c> list) {
        synchronized (this) {
            if (this.psC.contains(Integer.valueOf(i))) {
                a(i, com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                return;
            }
            this.psC.add(Integer.valueOf(i));
            this.psv.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Request[%s]", new Object[]{this.e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.4
                @Override // com.bytedance.sdk.a.b.a.b
                public void b() {
                    if (g.this.psw.r(i, list)) {
                        try {
                            g.this.psA.a(i, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                            synchronized (g.this) {
                                g.this.psC.remove(Integer.valueOf(i));
                            }
                        } catch (IOException e) {
                        }
                    }
                }
            });
        }
    }

    void b(final int i, final List<com.bytedance.sdk.a.b.a.e.c> list, final boolean z) {
        this.psv.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Headers[%s]", new Object[]{this.e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.5
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                boolean c2 = g.this.psw.c(i, list, z);
                if (c2) {
                    try {
                        g.this.psA.a(i, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                    } catch (IOException e) {
                        return;
                    }
                }
                if (c2 || z) {
                    synchronized (g.this) {
                        g.this.psC.remove(Integer.valueOf(i));
                    }
                }
            }
        });
    }

    void a(final int i, com.bytedance.sdk.a.a.e eVar, final int i2, final boolean z) throws IOException {
        final com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
        eVar.a(i2);
        eVar.b(cVar, i2);
        if (cVar.b() != i2) {
            throw new IOException(cVar.b() + " != " + i2);
        }
        this.psv.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Data[%s]", new Object[]{this.e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.6
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                try {
                    boolean b2 = g.this.psw.b(i, cVar, i2, z);
                    if (b2) {
                        g.this.psA.a(i, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                    }
                    if (b2 || z) {
                        synchronized (g.this) {
                            g.this.psC.remove(Integer.valueOf(i));
                        }
                    }
                } catch (IOException e) {
                }
            }
        });
    }

    void c(final int i, final com.bytedance.sdk.a.b.a.e.b bVar) {
        this.psv.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Reset[%s]", new Object[]{this.e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.7
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                g.this.psw.a(i, bVar);
                synchronized (g.this) {
                    g.this.psC.remove(Integer.valueOf(i));
                }
            }
        });
    }

    /* loaded from: classes6.dex */
    public static abstract class b {
        public static final b psK = new b() { // from class: com.bytedance.sdk.a.b.a.e.g.b.1
            @Override // com.bytedance.sdk.a.b.a.e.g.b
            public void a(i iVar) throws IOException {
                iVar.a(com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM);
            }
        };

        public abstract void a(i iVar) throws IOException;

        public void a(g gVar) {
        }
    }
}
