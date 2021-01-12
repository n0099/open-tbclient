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
/* loaded from: classes4.dex */
public final class a implements com.bytedance.sdk.a.b.a.c.c {

    /* renamed from: a  reason: collision with root package name */
    final z f5886a;
    int e = 0;
    private long f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    final com.bytedance.sdk.a.a.d pdP;
    final g peR;
    final com.bytedance.sdk.a.a.e peX;

    public a(z zVar, g gVar, com.bytedance.sdk.a.a.e eVar, com.bytedance.sdk.a.a.d dVar) {
        this.f5886a = zVar;
        this.peR = gVar;
        this.peX = eVar;
        this.pdP = dVar;
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public r a(ab abVar, long j) {
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(abVar.a("Transfer-Encoding"))) {
            return emW();
        }
        if (j != -1) {
            return in(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void d(ab abVar) throws IOException {
        a(abVar.emV(), i.a(abVar, this.peR.emL().emC().ent().type()));
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public com.bytedance.sdk.a.b.c c(com.bytedance.sdk.a.b.b bVar) throws IOException {
        this.peR.pew.f(this.peR.pev);
        String a2 = bVar.a("Content-Type");
        if (!com.bytedance.sdk.a.b.a.c.e.e(bVar)) {
            return new h(a2, 0L, l.c(io(0L)));
        }
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(bVar.a("Transfer-Encoding"))) {
            return new h(a2, -1L, l.c(d(bVar.emS().emp())));
        }
        long d2 = com.bytedance.sdk.a.b.a.c.e.d(bVar);
        if (d2 != -1) {
            return new h(a2, d2, l.c(io(d2)));
        }
        return new h(a2, -1L, l.c(emX()));
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void a() throws IOException {
        this.pdP.flush();
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void b() throws IOException {
        this.pdP.flush();
    }

    public void a(v vVar, String str) throws IOException {
        if (this.e != 0) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.pdP.Xy(str).Xy("\r\n");
        int a2 = vVar.a();
        for (int i = 0; i < a2; i++) {
            this.pdP.Xy(vVar.a(i)).Xy(": ").Xy(vVar.b(i)).Xy("\r\n");
        }
        this.pdP.Xy("\r\n");
        this.e = 1;
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public b.a AH(boolean z) throws IOException {
        if (this.e != 1 && this.e != 3) {
            throw new IllegalStateException("state: " + this.e);
        }
        try {
            k Xz = k.Xz(f());
            b.a c2 = new b.a().a(Xz.f5884a).Ok(Xz.f5885b).XA(Xz.c).c(emV());
            if (z && Xz.f5885b == 100) {
                return null;
            }
            this.e = 4;
            return c2;
        } catch (EOFException e2) {
            IOException iOException = new IOException("unexpected end of stream on " + this.peR);
            iOException.initCause(e2);
            throw iOException;
        }
    }

    private String f() throws IOException {
        String e2 = this.peX.e(this.f);
        this.f -= e2.length();
        return e2;
    }

    public v emV() throws IOException {
        v.a aVar = new v.a();
        while (true) {
            String f2 = f();
            if (f2.length() != 0) {
                com.bytedance.sdk.a.b.a.a.pdM.a(aVar, f2);
            } else {
                return aVar.enC();
            }
        }
    }

    public r emW() {
        if (this.e != 1) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 2;
        return new b();
    }

    public r in(long j) {
        if (this.e != 1) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 2;
        return new d(j);
    }

    public s io(long j) throws IOException {
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

    public s emX() throws IOException {
        if (this.e != 4) {
            throw new IllegalStateException("state: " + this.e);
        }
        if (this.peR == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.e = 5;
        this.peR.d();
        return new f();
    }

    void a(com.bytedance.sdk.a.a.i iVar) {
        t elW = iVar.elW();
        iVar.a(t.pdC);
        elW.eml();
        elW.emk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public final class d implements r {
        private boolean c;
        private long d;
        private final com.bytedance.sdk.a.a.i pfb;

        d(long j) {
            this.pfb = new com.bytedance.sdk.a.a.i(a.this.pdP.elW());
            this.d = j;
        }

        @Override // com.bytedance.sdk.a.a.r
        public t elW() {
            return this.pfb;
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
            a.this.pdP.a(cVar, j);
            this.d -= j;
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
        public void flush() throws IOException {
            if (!this.c) {
                a.this.pdP.flush();
            }
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.c) {
                this.c = true;
                if (this.d > 0) {
                    throw new ProtocolException("unexpected end of stream");
                }
                a.this.a(this.pfb);
                a.this.e = 3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public final class b implements r {
        private boolean c;
        private final com.bytedance.sdk.a.a.i pfb;

        b() {
            this.pfb = new com.bytedance.sdk.a.a.i(a.this.pdP.elW());
        }

        @Override // com.bytedance.sdk.a.a.r
        public t elW() {
            return this.pfb;
        }

        @Override // com.bytedance.sdk.a.a.r
        public void a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (this.c) {
                throw new IllegalStateException(LogConfig.TYPE_CLOSED);
            }
            if (j != 0) {
                a.this.pdP.ik(j);
                a.this.pdP.Xy("\r\n");
                a.this.pdP.a(cVar, j);
                a.this.pdP.Xy("\r\n");
            }
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (!this.c) {
                a.this.pdP.flush();
            }
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (!this.c) {
                this.c = true;
                a.this.pdP.Xy("0\r\n\r\n");
                a.this.a(this.pfb);
                a.this.e = 3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.a.b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public abstract class AbstractC0989a implements s {

        /* renamed from: b  reason: collision with root package name */
        protected boolean f5887b;
        protected long c;
        protected final com.bytedance.sdk.a.a.i peZ;

        private AbstractC0989a() {
            this.peZ = new com.bytedance.sdk.a.a.i(a.this.peX.elW());
            this.c = 0L;
        }

        @Override // com.bytedance.sdk.a.a.s
        public t elW() {
            return this.peZ;
        }

        @Override // com.bytedance.sdk.a.a.s
        public long b(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            try {
                long b2 = a.this.peX.b(cVar, j);
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
                a.this.a(this.peZ);
                a.this.e = 6;
                if (a.this.peR != null) {
                    a.this.peR.a(!z, a.this, this.c, iOException);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class e extends AbstractC0989a {
        private long f;

        e(long j) throws IOException {
            super();
            this.f = j;
            if (this.f == 0) {
                a(true, null);
            }
        }

        @Override // com.bytedance.sdk.a.b.a.d.a.AbstractC0989a, com.bytedance.sdk.a.a.s
        public long b(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f5887b) {
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
            if (!this.f5887b) {
                if (this.f != 0 && !com.bytedance.sdk.a.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                    a(false, null);
                }
                this.f5887b = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c extends AbstractC0989a {
        private long g;
        private boolean h;
        private final com.bytedance.sdk.a.b.s pfd;

        c(com.bytedance.sdk.a.b.s sVar) {
            super();
            this.g = -1L;
            this.h = true;
            this.pfd = sVar;
        }

        @Override // com.bytedance.sdk.a.b.a.d.a.AbstractC0989a, com.bytedance.sdk.a.a.s
        public long b(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f5887b) {
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
                a.this.peX.p();
            }
            try {
                this.g = a.this.peX.m();
                String trim = a.this.peX.p().trim();
                if (this.g < 0 || (!trim.isEmpty() && !trim.startsWith(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.g + trim + "\"");
                } else if (this.g == 0) {
                    this.h = false;
                    com.bytedance.sdk.a.b.a.c.e.a(a.this.f5886a.enL(), this.pfd, a.this.emV());
                    a(true, null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f5887b) {
                if (this.h && !com.bytedance.sdk.a.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                    a(false, null);
                }
                this.f5887b = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class f extends AbstractC0989a {
        private boolean f;

        f() {
            super();
        }

        @Override // com.bytedance.sdk.a.b.a.d.a.AbstractC0989a, com.bytedance.sdk.a.a.s
        public long b(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f5887b) {
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
            if (!this.f5887b) {
                if (!this.f) {
                    a(false, null);
                }
                this.f5887b = true;
            }
        }
    }
}
