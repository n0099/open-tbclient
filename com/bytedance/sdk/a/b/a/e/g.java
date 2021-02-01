package com.bytedance.sdk.a.b.a.e;

import androidx.core.internal.view.SupportMenu;
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
    static final ExecutorService f5901a;
    static final /* synthetic */ boolean s;

    /* renamed from: b  reason: collision with root package name */
    final boolean f5902b;
    private Map<Integer, l> ciM;
    final String e;
    int f;
    int g;
    boolean h;
    long k;
    final b ppP;
    private final ExecutorService ppQ;
    final m ppR;
    final Socket ppU;
    final j ppV;
    final c ppW;
    private int v;
    final Map<Integer, i> d = new LinkedHashMap();
    long j = 0;
    n ppS = new n();
    final n ppT = new n();
    boolean n = false;
    final Set<Integer> ppX = new LinkedHashSet();

    static {
        s = !g.class.desiredAssertionStatus();
        f5901a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.a.b.a.c.bm("OkHttp Http2Connection", true));
    }

    g(a aVar) {
        this.ppR = aVar.pqe;
        this.f5902b = aVar.g;
        this.ppP = aVar.pqd;
        this.g = aVar.g ? 1 : 2;
        if (aVar.g) {
            this.g += 2;
        }
        this.v = aVar.g ? 1 : 2;
        if (aVar.g) {
            this.ppS.dU(7, 16777216);
        }
        this.e = aVar.f5911b;
        this.ppQ = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.bytedance.sdk.a.b.a.c.bm(com.bytedance.sdk.a.b.a.c.a("OkHttp %s Push Observer", this.e), true));
        this.ppT.dU(7, SupportMenu.USER_MASK);
        this.ppT.dU(5, 16384);
        this.k = this.ppT.d();
        this.ppU = aVar.f5910a;
        this.ppV = new j(aVar.pod, this.f5902b);
        this.ppW = new c(new h(aVar.ppp, this.f5902b));
    }

    synchronized i OC(int i) {
        return this.d.get(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized i OD(int i) {
        i remove;
        remove = this.d.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    public synchronized int a() {
        return this.ppT.c(Integer.MAX_VALUE);
    }

    public i C(List<com.bytedance.sdk.a.b.a.e.c> list, boolean z) throws IOException {
        return a(0, list, z);
    }

    private i a(int i, List<com.bytedance.sdk.a.b.a.e.c> list, boolean z) throws IOException {
        int i2;
        i iVar;
        boolean z2 = false;
        boolean z3 = !z;
        synchronized (this.ppV) {
            synchronized (this) {
                if (this.h) {
                    throw new com.bytedance.sdk.a.b.a.e.a();
                }
                i2 = this.g;
                this.g += 2;
                iVar = new i(i2, this, z3, false, list);
                if (!z || this.k == 0 || iVar.f5916b == 0) {
                    z2 = true;
                }
                if (iVar.b()) {
                    this.d.put(Integer.valueOf(i2), iVar);
                }
            }
            if (i == 0) {
                this.ppV.a(z3, i2, i, list);
            } else if (this.f5902b) {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            } else {
                this.ppV.b(i, i2, list);
            }
        }
        if (z2) {
            this.ppV.b();
        }
        return iVar;
    }

    public void a(int i, boolean z, com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
        int min;
        if (j == 0) {
            this.ppV.a(z, i, cVar, 0);
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
                min = Math.min((int) Math.min(j, this.k), this.ppV.c());
                this.k -= min;
            }
            j -= min;
            this.ppV.a(z && j == 0, i, cVar, min);
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
        f5901a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s stream %d", new Object[]{this.e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.1
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
        this.ppV.a(i, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final int i, final long j) {
        f5901a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp Window Update %s stream %d", new Object[]{this.e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.2
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                try {
                    g.this.ppV.a(i, j);
                } catch (IOException e) {
                }
            }
        });
    }

    void a(final boolean z, final int i, final int i2, final l lVar) {
        f5901a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s ping %08x%08x", new Object[]{this.e, Integer.valueOf(i), Integer.valueOf(i2)}) { // from class: com.bytedance.sdk.a.b.a.e.g.3
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
        synchronized (this.ppV) {
            if (lVar != null) {
                lVar.a();
            }
            this.ppV.b(z, i, i2);
        }
    }

    synchronized l OE(int i) {
        return this.ciM != null ? this.ciM.remove(Integer.valueOf(i)) : null;
    }

    public void b() throws IOException {
        this.ppV.b();
    }

    public void a(com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        synchronized (this.ppV) {
            synchronized (this) {
                if (!this.h) {
                    this.h = true;
                    this.ppV.a(this.f, bVar, com.bytedance.sdk.a.b.a.c.f5872a);
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
            if (this.ciM != null) {
                this.ciM = null;
                lVarArr = (l[]) this.ciM.values().toArray(new l[this.ciM.size()]);
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
            this.ppV.close();
            e = iOException;
        } catch (IOException e3) {
            e = e3;
            if (iOException != null) {
                e = iOException;
            }
        }
        try {
            this.ppU.close();
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
            this.ppV.a();
            this.ppV.b(this.ppS);
            int d = this.ppS.d();
            if (d != 65535) {
                this.ppV.a(0, d - SupportMenu.USER_MASK);
            }
        }
        new Thread(this.ppW).start();
    }

    public synchronized boolean d() {
        return this.h;
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        Socket f5910a;

        /* renamed from: b  reason: collision with root package name */
        String f5911b;
        boolean g;
        com.bytedance.sdk.a.a.d pod;
        com.bytedance.sdk.a.a.e ppp;
        b pqd = b.pqf;
        m pqe = m.pqE;

        public a(boolean z) {
            this.g = z;
        }

        public a a(Socket socket, String str, com.bytedance.sdk.a.a.e eVar, com.bytedance.sdk.a.a.d dVar) {
            this.f5910a = socket;
            this.f5911b = str;
            this.ppp = eVar;
            this.pod = dVar;
            return this;
        }

        public a a(b bVar) {
            this.pqd = bVar;
            return this;
        }

        public g eps() {
            return new g(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c extends com.bytedance.sdk.a.b.a.b implements h.b {
        final h pqg;

        c(h hVar) {
            super("OkHttp %s", g.this.e);
            this.pqg = hVar;
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
                    this.pqg.a(this);
                    do {
                    } while (this.pqg.a(false, (h.b) this));
                    r0 = com.bytedance.sdk.a.b.a.e.b.NO_ERROR;
                    try {
                        g.this.a(r0, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                    } catch (IOException e) {
                    }
                    r0 = this.pqg;
                    com.bytedance.sdk.a.b.a.c.a((Closeable) r0);
                } catch (Throwable th2) {
                    th = th2;
                    bVar = r0;
                    try {
                        g.this.a(bVar, bVar2);
                    } catch (IOException e2) {
                    }
                    com.bytedance.sdk.a.b.a.c.a(this.pqg);
                    throw th;
                }
            } catch (IOException e3) {
                bVar = com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR;
                try {
                    try {
                        g.this.a(bVar, com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                    } catch (IOException e4) {
                    }
                    com.bytedance.sdk.a.b.a.c.a(this.pqg);
                } catch (Throwable th3) {
                    th = th3;
                    g.this.a(bVar, bVar2);
                    com.bytedance.sdk.a.b.a.c.a(this.pqg);
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
            i OC = g.this.OC(i);
            if (OC == null) {
                g.this.a(i, com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                eVar.h(i2);
                return;
            }
            OC.a(eVar, i2);
            if (z) {
                OC.i();
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(boolean z, int i, int i2, List<com.bytedance.sdk.a.b.a.e.c> list) {
            if (g.this.d(i)) {
                g.this.b(i, list, z);
                return;
            }
            synchronized (g.this) {
                i OC = g.this.OC(i);
                if (OC == null) {
                    if (!g.this.h) {
                        if (i > g.this.f) {
                            if (i % 2 != g.this.g % 2) {
                                final i iVar = new i(i, g.this, false, z, list);
                                g.this.f = i;
                                g.this.d.put(Integer.valueOf(i), iVar);
                                g.f5901a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s stream %d", new Object[]{g.this.e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.c.1
                                    @Override // com.bytedance.sdk.a.b.a.b
                                    public void b() {
                                        try {
                                            g.this.ppP.a(iVar);
                                        } catch (IOException e) {
                                            com.bytedance.sdk.a.b.a.g.e.epz().a(4, "Http2Connection.Listener failure for " + g.this.e, e);
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
                    OC.a(list);
                    if (z) {
                        OC.i();
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
            i OD = g.this.OD(i);
            if (OD != null) {
                OD.d(bVar);
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(boolean z, n nVar) {
            i[] iVarArr;
            long j;
            synchronized (g.this) {
                int d = g.this.ppT.d();
                if (z) {
                    g.this.ppT.a();
                }
                g.this.ppT.a(nVar);
                a(nVar);
                int d2 = g.this.ppT.d();
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
                g.f5901a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s settings", g.this.e) { // from class: com.bytedance.sdk.a.b.a.e.g.c.2
                    @Override // com.bytedance.sdk.a.b.a.b
                    public void b() {
                        g.this.ppP.a(g.this);
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
            g.f5901a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s ACK Settings", new Object[]{g.this.e}) { // from class: com.bytedance.sdk.a.b.a.e.g.c.3
                @Override // com.bytedance.sdk.a.b.a.b
                public void b() {
                    try {
                        g.this.ppV.a(nVar);
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
                l OE = g.this.OE(i);
                if (OE != null) {
                    OE.b();
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
                    g.this.OD(iVar.a());
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
            i OC = g.this.OC(i);
            if (OC != null) {
                synchronized (OC) {
                    OC.a(j);
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
            if (this.ppX.contains(Integer.valueOf(i))) {
                a(i, com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                return;
            }
            this.ppX.add(Integer.valueOf(i));
            this.ppQ.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Request[%s]", new Object[]{this.e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.4
                @Override // com.bytedance.sdk.a.b.a.b
                public void b() {
                    if (g.this.ppR.r(i, list)) {
                        try {
                            g.this.ppV.a(i, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                            synchronized (g.this) {
                                g.this.ppX.remove(Integer.valueOf(i));
                            }
                        } catch (IOException e) {
                        }
                    }
                }
            });
        }
    }

    void b(final int i, final List<com.bytedance.sdk.a.b.a.e.c> list, final boolean z) {
        this.ppQ.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Headers[%s]", new Object[]{this.e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.5
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                boolean c2 = g.this.ppR.c(i, list, z);
                if (c2) {
                    try {
                        g.this.ppV.a(i, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                    } catch (IOException e) {
                        return;
                    }
                }
                if (c2 || z) {
                    synchronized (g.this) {
                        g.this.ppX.remove(Integer.valueOf(i));
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
        this.ppQ.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Data[%s]", new Object[]{this.e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.6
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                try {
                    boolean b2 = g.this.ppR.b(i, cVar, i2, z);
                    if (b2) {
                        g.this.ppV.a(i, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                    }
                    if (b2 || z) {
                        synchronized (g.this) {
                            g.this.ppX.remove(Integer.valueOf(i));
                        }
                    }
                } catch (IOException e) {
                }
            }
        });
    }

    void c(final int i, final com.bytedance.sdk.a.b.a.e.b bVar) {
        this.ppQ.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Reset[%s]", new Object[]{this.e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.7
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                g.this.ppR.a(i, bVar);
                synchronized (g.this) {
                    g.this.ppX.remove(Integer.valueOf(i));
                }
            }
        });
    }

    /* loaded from: classes6.dex */
    public static abstract class b {
        public static final b pqf = new b() { // from class: com.bytedance.sdk.a.b.a.e.g.b.1
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
