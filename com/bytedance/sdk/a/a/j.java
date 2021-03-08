package com.bytedance.sdk.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
/* loaded from: classes6.dex */
public final class j implements s {
    private final e pqp;
    private final Inflater pqq;
    private final k pqr;

    /* renamed from: a  reason: collision with root package name */
    private int f3940a = 0;
    private final CRC32 pqs = new CRC32();

    public j(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.pqq = new Inflater(true);
        this.pqp = l.c(sVar);
        this.pqr = new k(this.pqp, this.pqq);
    }

    @Override // com.bytedance.sdk.a.a.s
    public long b(c cVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        if (this.f3940a == 0) {
            b();
            this.f3940a = 1;
        }
        if (this.f3940a == 1) {
            long j2 = cVar.b;
            long b = this.pqr.b(cVar, j);
            if (b != -1) {
                b(cVar, j2, b);
                return b;
            }
            this.f3940a = 2;
        }
        if (this.f3940a == 2) {
            c();
            this.f3940a = 3;
            if (!this.pqp.e()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    private void b() throws IOException {
        this.pqp.a(10L);
        byte ih = this.pqp.eoG().ih(3L);
        boolean z = ((ih >> 1) & 1) == 1;
        if (z) {
            b(this.pqp.eoG(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.pqp.eoK());
        this.pqp.h(8L);
        if (((ih >> 2) & 1) == 1) {
            this.pqp.a(2L);
            if (z) {
                b(this.pqp.eoG(), 0L, 2L);
            }
            short eoL = this.pqp.eoG().eoL();
            this.pqp.a(eoL);
            if (z) {
                b(this.pqp.eoG(), 0L, eoL);
            }
            this.pqp.h(eoL);
        }
        if (((ih >> 3) & 1) == 1) {
            long e = this.pqp.e((byte) 0);
            if (e == -1) {
                throw new EOFException();
            }
            if (z) {
                b(this.pqp.eoG(), 0L, 1 + e);
            }
            this.pqp.h(1 + e);
        }
        if (((ih >> 4) & 1) == 1) {
            long e2 = this.pqp.e((byte) 0);
            if (e2 == -1) {
                throw new EOFException();
            }
            if (z) {
                b(this.pqp.eoG(), 0L, 1 + e2);
            }
            this.pqp.h(1 + e2);
        }
        if (z) {
            a("FHCRC", this.pqp.eoL(), (short) this.pqs.getValue());
            this.pqs.reset();
        }
    }

    private void c() throws IOException {
        a("CRC", this.pqp.l(), (int) this.pqs.getValue());
        a("ISIZE", this.pqp.l(), (int) this.pqq.getBytesWritten());
    }

    @Override // com.bytedance.sdk.a.a.s
    public t eoF() {
        return this.pqp.eoF();
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pqr.close();
    }

    private void b(c cVar, long j, long j2) {
        int i;
        o oVar = cVar.pqm;
        while (j >= oVar.c - oVar.b) {
            j -= oVar.c - oVar.b;
            oVar = oVar.pqy;
        }
        while (j2 > 0) {
            int min = (int) Math.min(oVar.c - i, j2);
            this.pqs.update(oVar.f3942a, (int) (oVar.b + j), min);
            j2 -= min;
            oVar = oVar.pqy;
            j = 0;
        }
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
