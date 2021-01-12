package com.bytedance.sdk.a.b.a.e;

import androidx.appcompat.widget.ActivityChooserView;
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
/* loaded from: classes4.dex */
public final class g implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    static final ExecutorService f5899a;
    static final /* synthetic */ boolean s;

    /* renamed from: b  reason: collision with root package name */
    final boolean f5900b;
    private Map<Integer, l> ceD;
    final String e;
    int f;
    int g;
    boolean h;
    long k;
    final Socket pfB;
    final j pfC;
    final c pfD;
    final b pfw;
    private final ExecutorService pfx;
    final m pfy;
    private int v;
    final Map<Integer, i> d = new LinkedHashMap();
    long j = 0;
    n pfz = new n();
    final n pfA = new n();
    boolean n = false;
    final Set<Integer> pfE = new LinkedHashSet();

    static {
        s = !g.class.desiredAssertionStatus();
        f5899a = new ThreadPoolExecutor(0, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.a.b.a.c.bm("OkHttp Http2Connection", true));
    }

    g(a aVar) {
        this.pfy = aVar.pfL;
        this.f5900b = aVar.g;
        this.pfw = aVar.pfK;
        this.g = aVar.g ? 1 : 2;
        if (aVar.g) {
            this.g += 2;
        }
        this.v = aVar.g ? 1 : 2;
        if (aVar.g) {
            this.pfz.dX(7, 16777216);
        }
        this.e = aVar.f5909b;
        this.pfx = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.bytedance.sdk.a.b.a.c.bm(com.bytedance.sdk.a.b.a.c.a("OkHttp %s Push Observer", this.e), true));
        this.pfA.dX(7, SupportMenu.USER_MASK);
        this.pfA.dX(5, 16384);
        this.k = this.pfA.d();
        this.pfB = aVar.f5908a;
        this.pfC = new j(aVar.pdP, this.f5900b);
        this.pfD = new c(new h(aVar.peX, this.f5900b));
    }

    synchronized i Oh(int i) {
        return this.d.get(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized i Oi(int i) {
        i remove;
        remove = this.d.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    public synchronized int a() {
        return this.pfA.c(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public i A(List<com.bytedance.sdk.a.b.a.e.c> list, boolean z) throws IOException {
        return a(0, list, z);
    }

    private i a(int i, List<com.bytedance.sdk.a.b.a.e.c> list, boolean z) throws IOException {
        int i2;
        i iVar;
        boolean z2 = false;
        boolean z3 = !z;
        synchronized (this.pfC) {
            synchronized (this) {
                if (this.h) {
                    throw new com.bytedance.sdk.a.b.a.e.a();
                }
                i2 = this.g;
                this.g += 2;
                iVar = new i(i2, this, z3, false, list);
                if (!z || this.k == 0 || iVar.f5914b == 0) {
                    z2 = true;
                }
                if (iVar.b()) {
                    this.d.put(Integer.valueOf(i2), iVar);
                }
            }
            if (i == 0) {
                this.pfC.a(z3, i2, i, list);
            } else if (this.f5900b) {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            } else {
                this.pfC.b(i, i2, list);
            }
        }
        if (z2) {
            this.pfC.b();
        }
        return iVar;
    }

    public void a(int i, boolean z, com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
        int min;
        if (j == 0) {
            this.pfC.a(z, i, cVar, 0);
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
                min = Math.min((int) Math.min(j, this.k), this.pfC.c());
                this.k -= min;
            }
            j -= min;
            this.pfC.a(z && j == 0, i, cVar, min);
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
        f5899a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s stream %d", new Object[]{this.e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.1
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
        this.pfC.a(i, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final int i, final long j) {
        f5899a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp Window Update %s stream %d", new Object[]{this.e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.2
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                try {
                    g.this.pfC.a(i, j);
                } catch (IOException e) {
                }
            }
        });
    }

    void a(final boolean z, final int i, final int i2, final l lVar) {
        f5899a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s ping %08x%08x", new Object[]{this.e, Integer.valueOf(i), Integer.valueOf(i2)}) { // from class: com.bytedance.sdk.a.b.a.e.g.3
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
        synchronized (this.pfC) {
            if (lVar != null) {
                lVar.a();
            }
            this.pfC.b(z, i, i2);
        }
    }

    synchronized l Oj(int i) {
        return this.ceD != null ? this.ceD.remove(Integer.valueOf(i)) : null;
    }

    public void b() throws IOException {
        this.pfC.b();
    }

    public void a(com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        synchronized (this.pfC) {
            synchronized (this) {
                if (!this.h) {
                    this.h = true;
                    this.pfC.a(this.f, bVar, com.bytedance.sdk.a.b.a.c.f5870a);
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
            if (this.ceD != null) {
                this.ceD = null;
                lVarArr = (l[]) this.ceD.values().toArray(new l[this.ceD.size()]);
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
            this.pfC.close();
            e = iOException;
        } catch (IOException e3) {
            e = e3;
            if (iOException != null) {
                e = iOException;
            }
        }
        try {
            this.pfB.close();
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
            this.pfC.a();
            this.pfC.b(this.pfz);
            int d = this.pfz.d();
            if (d != 65535) {
                this.pfC.a(0, d - SupportMenu.USER_MASK);
            }
        }
        new Thread(this.pfD).start();
    }

    public synchronized boolean d() {
        return this.h;
    }

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        Socket f5908a;

        /* renamed from: b  reason: collision with root package name */
        String f5909b;
        boolean g;
        com.bytedance.sdk.a.a.d pdP;
        com.bytedance.sdk.a.a.e peX;
        b pfK = b.pfM;
        m pfL = m.pgl;

        public a(boolean z) {
            this.g = z;
        }

        public a a(Socket socket, String str, com.bytedance.sdk.a.a.e eVar, com.bytedance.sdk.a.a.d dVar) {
            this.f5908a = socket;
            this.f5909b = str;
            this.peX = eVar;
            this.pdP = dVar;
            return this;
        }

        public a a(b bVar) {
            this.pfK = bVar;
            return this;
        }

        public g emY() {
            return new g(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends com.bytedance.sdk.a.b.a.b implements h.b {
        final h pfN;

        c(h hVar) {
            super("OkHttp %s", g.this.e);
            this.pfN = hVar;
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
                    this.pfN.a(this);
                    do {
                    } while (this.pfN.a(false, (h.b) this));
                    r0 = com.bytedance.sdk.a.b.a.e.b.NO_ERROR;
                    try {
                        g.this.a(r0, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                    } catch (IOException e) {
                    }
                    r0 = this.pfN;
                    com.bytedance.sdk.a.b.a.c.a((Closeable) r0);
                } catch (Throwable th2) {
                    th = th2;
                    bVar = r0;
                    try {
                        g.this.a(bVar, bVar2);
                    } catch (IOException e2) {
                    }
                    com.bytedance.sdk.a.b.a.c.a(this.pfN);
                    throw th;
                }
            } catch (IOException e3) {
                bVar = com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR;
                try {
                    try {
                        g.this.a(bVar, com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                    } catch (IOException e4) {
                    }
                    com.bytedance.sdk.a.b.a.c.a(this.pfN);
                } catch (Throwable th3) {
                    th = th3;
                    g.this.a(bVar, bVar2);
                    com.bytedance.sdk.a.b.a.c.a(this.pfN);
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
            i Oh = g.this.Oh(i);
            if (Oh == null) {
                g.this.a(i, com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                eVar.h(i2);
                return;
            }
            Oh.a(eVar, i2);
            if (z) {
                Oh.i();
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(boolean z, int i, int i2, List<com.bytedance.sdk.a.b.a.e.c> list) {
            if (g.this.d(i)) {
                g.this.b(i, list, z);
                return;
            }
            synchronized (g.this) {
                i Oh = g.this.Oh(i);
                if (Oh == null) {
                    if (!g.this.h) {
                        if (i > g.this.f) {
                            if (i % 2 != g.this.g % 2) {
                                final i iVar = new i(i, g.this, false, z, list);
                                g.this.f = i;
                                g.this.d.put(Integer.valueOf(i), iVar);
                                g.f5899a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s stream %d", new Object[]{g.this.e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.c.1
                                    @Override // com.bytedance.sdk.a.b.a.b
                                    public void b() {
                                        try {
                                            g.this.pfw.a(iVar);
                                        } catch (IOException e) {
                                            com.bytedance.sdk.a.b.a.g.e.eng().a(4, "Http2Connection.Listener failure for " + g.this.e, e);
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
                    Oh.a(list);
                    if (z) {
                        Oh.i();
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
            i Oi = g.this.Oi(i);
            if (Oi != null) {
                Oi.d(bVar);
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(boolean z, n nVar) {
            i[] iVarArr;
            long j;
            synchronized (g.this) {
                int d = g.this.pfA.d();
                if (z) {
                    g.this.pfA.a();
                }
                g.this.pfA.a(nVar);
                a(nVar);
                int d2 = g.this.pfA.d();
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
                g.f5899a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s settings", g.this.e) { // from class: com.bytedance.sdk.a.b.a.e.g.c.2
                    @Override // com.bytedance.sdk.a.b.a.b
                    public void b() {
                        g.this.pfw.a(g.this);
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
            g.f5899a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s ACK Settings", new Object[]{g.this.e}) { // from class: com.bytedance.sdk.a.b.a.e.g.c.3
                @Override // com.bytedance.sdk.a.b.a.b
                public void b() {
                    try {
                        g.this.pfC.a(nVar);
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
                l Oj = g.this.Oj(i);
                if (Oj != null) {
                    Oj.b();
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
                    g.this.Oi(iVar.a());
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
            i Oh = g.this.Oh(i);
            if (Oh != null) {
                synchronized (Oh) {
                    Oh.a(j);
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
            if (this.pfE.contains(Integer.valueOf(i))) {
                a(i, com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                return;
            }
            this.pfE.add(Integer.valueOf(i));
            this.pfx.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Request[%s]", new Object[]{this.e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.4
                @Override // com.bytedance.sdk.a.b.a.b
                public void b() {
                    if (g.this.pfy.q(i, list)) {
                        try {
                            g.this.pfC.a(i, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                            synchronized (g.this) {
                                g.this.pfE.remove(Integer.valueOf(i));
                            }
                        } catch (IOException e) {
                        }
                    }
                }
            });
        }
    }

    void b(final int i, final List<com.bytedance.sdk.a.b.a.e.c> list, final boolean z) {
        this.pfx.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Headers[%s]", new Object[]{this.e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.5
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                boolean c2 = g.this.pfy.c(i, list, z);
                if (c2) {
                    try {
                        g.this.pfC.a(i, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                    } catch (IOException e) {
                        return;
                    }
                }
                if (c2 || z) {
                    synchronized (g.this) {
                        g.this.pfE.remove(Integer.valueOf(i));
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
        this.pfx.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Data[%s]", new Object[]{this.e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.6
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                try {
                    boolean b2 = g.this.pfy.b(i, cVar, i2, z);
                    if (b2) {
                        g.this.pfC.a(i, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                    }
                    if (b2 || z) {
                        synchronized (g.this) {
                            g.this.pfE.remove(Integer.valueOf(i));
                        }
                    }
                } catch (IOException e) {
                }
            }
        });
    }

    void c(final int i, final com.bytedance.sdk.a.b.a.e.b bVar) {
        this.pfx.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Reset[%s]", new Object[]{this.e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.7
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                g.this.pfy.a(i, bVar);
                synchronized (g.this) {
                    g.this.pfE.remove(Integer.valueOf(i));
                }
            }
        });
    }

    /* loaded from: classes4.dex */
    public static abstract class b {
        public static final b pfM = new b() { // from class: com.bytedance.sdk.a.b.a.e.g.b.1
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
