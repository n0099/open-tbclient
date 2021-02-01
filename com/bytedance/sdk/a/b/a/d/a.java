package com.bytedance.sdk.a.b.a.d;

import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.live.tbadk.log.LogConfig;
import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.a.t;
import com.bytedance.sdk.a.b.a.b.g;
import com.bytedance.sdk.a.b.a.c.h;
import com.bytedance.sdk.a.b.a.c.i;
import com.bytedance.sdk.a.b.a.c.k;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.b;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.z;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public final class a implements com.bytedance.sdk.a.b.a.c.c {

    /* renamed from: a  reason: collision with root package name */
    final z f5888a;
    int e = 0;
    private long f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    final com.bytedance.sdk.a.a.d pod;
    final g ppj;
    final com.bytedance.sdk.a.a.e ppp;

    public a(z zVar, g gVar, com.bytedance.sdk.a.a.e eVar, com.bytedance.sdk.a.a.d dVar) {
        this.f5888a = zVar;
        this.ppj = gVar;
        this.ppp = eVar;
        this.pod = dVar;
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public r a(ab abVar, long j) {
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(abVar.a("Transfer-Encoding"))) {
            return epq();
        }
        if (j != -1) {
            return iq(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void d(ab abVar) throws IOException {
        a(abVar.epp(), i.a(abVar, this.ppj.epf().eoW().epM().type()));
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public com.bytedance.sdk.a.b.c c(com.bytedance.sdk.a.b.b bVar) throws IOException {
        this.ppj.poN.f(this.ppj.poM);
        String a2 = bVar.a("Content-Type");
        if (!com.bytedance.sdk.a.b.a.c.e.e(bVar)) {
            return new h(a2, 0L, l.c(ir(0L)));
        }
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(bVar.a("Transfer-Encoding"))) {
            return new h(a2, -1L, l.c(d(bVar.epm().eoJ())));
        }
        long d2 = com.bytedance.sdk.a.b.a.c.e.d(bVar);
        if (d2 != -1) {
            return new h(a2, d2, l.c(ir(d2)));
        }
        return new h(a2, -1L, l.c(epr()));
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void a() throws IOException {
        this.pod.flush();
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void b() throws IOException {
        this.pod.flush();
    }

    public void a(v vVar, String str) throws IOException {
        if (this.e != 0) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.pod.YA(str).YA("\r\n");
        int a2 = vVar.a();
        for (int i = 0; i < a2; i++) {
            this.pod.YA(vVar.a(i)).YA(": ").YA(vVar.b(i)).YA("\r\n");
        }
        this.pod.YA("\r\n");
        this.e = 1;
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public b.a Ba(boolean z) throws IOException {
        if (this.e != 1 && this.e != 3) {
            throw new IllegalStateException("state: " + this.e);
        }
        try {
            k YB = k.YB(f());
            b.a c2 = new b.a().a(YB.f5886a).OF(YB.f5887b).YC(YB.c).c(epp());
            if (z && YB.f5887b == 100) {
                return null;
            }
            this.e = 4;
            return c2;
        } catch (EOFException e2) {
            IOException iOException = new IOException("unexpected end of stream on " + this.ppj);
            iOException.initCause(e2);
            throw iOException;
        }
    }

    private String f() throws IOException {
        String e2 = this.ppp.e(this.f);
        this.f -= e2.length();
        return e2;
    }

    public v epp() throws IOException {
        v.a aVar = new v.a();
        while (true) {
            String f2 = f();
            if (f2.length() != 0) {
                com.bytedance.sdk.a.b.a.a.poa.a(aVar, f2);
            } else {
                return aVar.epV();
            }
        }
    }

    public r epq() {
        if (this.e != 1) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 2;
        return new b();
    }

    public r iq(long j) {
        if (this.e != 1) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 2;
        return new d(j);
    }

    public s ir(long j) throws IOException {
        if (this.e != 4) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 5;
        return new e(j);
    }

    public s d(com.bytedance.sdk.a.b.s sVar) throws IOException {
        if (this.e != 4) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 5;
        return new c(sVar);
    }

    public s epr() throws IOException {
        if (this.e != 4) {
            throw new IllegalStateException("state: " + this.e);
        }
        if (this.ppj == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.e = 5;
        this.ppj.d();
        return new f();
    }

    void a(com.bytedance.sdk.a.a.i iVar) {
        t eoq = iVar.eoq();
        iVar.a(t.pnQ);
        eoq.eoF();
        eoq.eoE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class d implements r {
        private boolean c;
        private long d;
        private final com.bytedance.sdk.a.a.i ppu;

        d(long j) {
            this.ppu = new com.bytedance.sdk.a.a.i(a.this.pod.eoq());
            this.d = j;
        }

        @Override // com.bytedance.sdk.a.a.r
        public t eoq() {
            return this.ppu;
        }

        @Override // com.bytedance.sdk.a.a.r
        public void a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (this.c) {
                throw new IllegalStateException(LogConfig.TYPE_CLOSED);
            }
            com.bytedance.sdk.a.b.a.c.a(cVar.b(), 0L, j);
            if (j > this.d) {
                throw new ProtocolException("expected " + this.d + " bytes but received " + j);
            }
            a.this.pod.a(cVar, j);
            this.d -= j;
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
        public void flush() throws IOException {
            if (!this.c) {
                a.this.pod.flush();
            }
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.c) {
                this.c = true;
                if (this.d > 0) {
                    throw new ProtocolException("unexpected end of stream");
                }
                a.this.a(this.ppu);
                a.this.e = 3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class b implements r {
        private boolean c;
        private final com.bytedance.sdk.a.a.i ppu;

        b() {
            this.ppu = new com.bytedance.sdk.a.a.i(a.this.pod.eoq());
        }

        @Override // com.bytedance.sdk.a.a.r
        public t eoq() {
            return this.ppu;
        }

        @Override // com.bytedance.sdk.a.a.r
        public void a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (this.c) {
                throw new IllegalStateException(LogConfig.TYPE_CLOSED);
            }
            if (j != 0) {
                a.this.pod.in(j);
                a.this.pod.YA("\r\n");
                a.this.pod.a(cVar, j);
                a.this.pod.YA("\r\n");
            }
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (!this.c) {
                a.this.pod.flush();
            }
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (!this.c) {
                this.c = true;
                a.this.pod.YA("0\r\n\r\n");
                a.this.a(this.ppu);
                a.this.e = 3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.a.b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public abstract class AbstractC0993a implements s {

        /* renamed from: b  reason: collision with root package name */
        protected boolean f5889b;
        protected long c;
        protected final com.bytedance.sdk.a.a.i ppr;

        private AbstractC0993a() {
            this.ppr = new com.bytedance.sdk.a.a.i(a.this.ppp.eoq());
            this.c = 0L;
        }

        @Override // com.bytedance.sdk.a.a.s
        public t eoq() {
            return this.ppr;
        }

        @Override // com.bytedance.sdk.a.a.s
        public long b(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            try {
                long b2 = a.this.ppp.b(cVar, j);
                if (b2 > 0) {
                    this.c += b2;
                }
                return b2;
            } catch (IOException e) {
                a(false, e);
                throw e;
            }
        }

        protected final void a(boolean z, IOException iOException) throws IOException {
            if (a.this.e != 6) {
                if (a.this.e != 5) {
                    throw new IllegalStateException("state: " + a.this.e);
                }
                a.this.a(this.ppr);
                a.this.e = 6;
                if (a.this.ppj != null) {
                    a.this.ppj.a(!z, a.this, this.c, iOException);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class e extends AbstractC0993a {
        private long f;

        e(long j) throws IOException {
            super();
            this.f = j;
            if (this.f == 0) {
                a(true, null);
            }
        }

        @Override // com.bytedance.sdk.a.b.a.d.a.AbstractC0993a, com.bytedance.sdk.a.a.s
        public long b(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f5889b) {
                throw new IllegalStateException(LogConfig.TYPE_CLOSED);
            }
            if (this.f == 0) {
                return -1L;
            }
            long b2 = super.b(cVar, Math.min(this.f, j));
            if (b2 == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, protocolException);
                throw protocolException;
            }
            this.f -= b2;
            if (this.f == 0) {
                a(true, null);
            }
            return b2;
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f5889b) {
                if (this.f != 0 && !com.bytedance.sdk.a.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                    a(false, null);
                }
                this.f5889b = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class c extends AbstractC0993a {
        private long g;
        private boolean h;
        private final com.bytedance.sdk.a.b.s ppw;

        c(com.bytedance.sdk.a.b.s sVar) {
            super();
            this.g = -1L;
            this.h = true;
            this.ppw = sVar;
        }

        @Override // com.bytedance.sdk.a.b.a.d.a.AbstractC0993a, com.bytedance.sdk.a.a.s
        public long b(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f5889b) {
                throw new IllegalStateException(LogConfig.TYPE_CLOSED);
            }
            if (this.h) {
                if (this.g == 0 || this.g == -1) {
                    b();
                    if (!this.h) {
                        return -1L;
                    }
                }
                long b2 = super.b(cVar, Math.min(j, this.g));
                if (b2 == -1) {
                    ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                    a(false, protocolException);
                    throw protocolException;
                }
                this.g -= b2;
                return b2;
            }
            return -1L;
        }

        private void b() throws IOException {
            if (this.g != -1) {
                a.this.ppp.p();
            }
            try {
                this.g = a.this.ppp.m();
                String trim = a.this.ppp.p().trim();
                if (this.g < 0 || (!trim.isEmpty() && !trim.startsWith(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.g + trim + "\"");
                } else if (this.g == 0) {
                    this.h = false;
                    com.bytedance.sdk.a.b.a.c.e.a(a.this.f5888a.eqe(), this.ppw, a.this.epp());
                    a(true, null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f5889b) {
                if (this.h && !com.bytedance.sdk.a.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                    a(false, null);
                }
                this.f5889b = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class f extends AbstractC0993a {
        private boolean f;

        f() {
            super();
        }

        @Override // com.bytedance.sdk.a.b.a.d.a.AbstractC0993a, com.bytedance.sdk.a.a.s
        public long b(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f5889b) {
                throw new IllegalStateException(LogConfig.TYPE_CLOSED);
            }
            if (this.f) {
                return -1L;
            }
            long b2 = super.b(cVar, j);
            if (b2 == -1) {
                this.f = true;
                a(true, null);
                return -1L;
            }
            return b2;
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f5889b) {
                if (!this.f) {
                    a(false, null);
                }
                this.f5889b = true;
            }
        }
    }
}
