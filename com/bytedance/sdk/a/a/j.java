package com.bytedance.sdk.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
/* loaded from: classes6.dex */
public final class j implements s {
    private final e pof;
    private final Inflater pog;
    private final k poh;

    /* renamed from: a  reason: collision with root package name */
    private int f5845a = 0;
    private final CRC32 poj = new CRC32();

    public j(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.pog = new Inflater(true);
        this.pof = l.c(sVar);
        this.poh = new k(this.pof, this.pog);
    }

    @Override // com.bytedance.sdk.a.a.s
    public long b(c cVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        if (this.f5845a == 0) {
            b();
            this.f5845a = 1;
        }
        if (this.f5845a == 1) {
            long j2 = cVar.f5842b;
            long b2 = this.poh.b(cVar, j);
            if (b2 != -1) {
                b(cVar, j2, b2);
                return b2;
            }
            this.f5845a = 2;
        }
        if (this.f5845a == 2) {
            c();
            this.f5845a = 3;
            if (!this.pof.e()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    private void b() throws IOException {
        this.pof.a(10L);
        byte ih = this.pof.eoz().ih(3L);
        boolean z = ((ih >> 1) & 1) == 1;
        if (z) {
            b(this.pof.eoz(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.pof.eoD());
        this.pof.h(8L);
        if (((ih >> 2) & 1) == 1) {
            this.pof.a(2L);
            if (z) {
                b(this.pof.eoz(), 0L, 2L);
            }
            short eoE = this.pof.eoz().eoE();
            this.pof.a(eoE);
            if (z) {
                b(this.pof.eoz(), 0L, eoE);
            }
            this.pof.h(eoE);
        }
        if (((ih >> 3) & 1) == 1) {
            long e = this.pof.e((byte) 0);
            if (e == -1) {
                throw new EOFException();
            }
            if (z) {
                b(this.pof.eoz(), 0L, 1 + e);
            }
            this.pof.h(1 + e);
        }
        if (((ih >> 4) & 1) == 1) {
            long e2 = this.pof.e((byte) 0);
            if (e2 == -1) {
                throw new EOFException();
            }
            if (z) {
                b(this.pof.eoz(), 0L, 1 + e2);
            }
            this.pof.h(1 + e2);
        }
        if (z) {
            a("FHCRC", this.pof.eoE(), (short) this.poj.getValue());
            this.poj.reset();
        }
    }

    private void c() throws IOException {
        a("CRC", this.pof.l(), (int) this.poj.getValue());
        a("ISIZE", this.pof.l(), (int) this.pog.getBytesWritten());
    }

    @Override // com.bytedance.sdk.a.a.s
    public t eoy() {
        return this.pof.eoy();
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.poh.close();
    }

    private void b(c cVar, long j, long j2) {
        int i;
        o oVar = cVar.poc;
        while (j >= oVar.c - oVar.f5851b) {
            j -= oVar.c - oVar.f5851b;
            oVar = oVar.poq;
        }
        while (j2 > 0) {
            int min = (int) Math.min(oVar.c - i, j2);
            this.poj.update(oVar.f5850a, (int) (oVar.f5851b + j), min);
            j2 -= min;
            oVar = oVar.poq;
            j = 0;
        }
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
