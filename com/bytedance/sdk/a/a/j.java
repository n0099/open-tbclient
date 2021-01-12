package com.bytedance.sdk.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
/* loaded from: classes4.dex */
public final class j implements s {
    private final e pdr;
    private final Inflater pds;
    private final k pdt;

    /* renamed from: a  reason: collision with root package name */
    private int f5843a = 0;
    private final CRC32 pdu = new CRC32();

    public j(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.pds = new Inflater(true);
        this.pdr = l.c(sVar);
        this.pdt = new k(this.pdr, this.pds);
    }

    @Override // com.bytedance.sdk.a.a.s
    public long b(c cVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        if (this.f5843a == 0) {
            b();
            this.f5843a = 1;
        }
        if (this.f5843a == 1) {
            long j2 = cVar.f5840b;
            long b2 = this.pdt.b(cVar, j);
            if (b2 != -1) {
                b(cVar, j2, b2);
                return b2;
            }
            this.f5843a = 2;
        }
        if (this.f5843a == 2) {
            c();
            this.f5843a = 3;
            if (!this.pdr.e()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    private void b() throws IOException {
        this.pdr.a(10L);
        byte ie = this.pdr.elX().ie(3L);
        boolean z = ((ie >> 1) & 1) == 1;
        if (z) {
            b(this.pdr.elX(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.pdr.emb());
        this.pdr.h(8L);
        if (((ie >> 2) & 1) == 1) {
            this.pdr.a(2L);
            if (z) {
                b(this.pdr.elX(), 0L, 2L);
            }
            short emc = this.pdr.elX().emc();
            this.pdr.a(emc);
            if (z) {
                b(this.pdr.elX(), 0L, emc);
            }
            this.pdr.h(emc);
        }
        if (((ie >> 3) & 1) == 1) {
            long e = this.pdr.e((byte) 0);
            if (e == -1) {
                throw new EOFException();
            }
            if (z) {
                b(this.pdr.elX(), 0L, 1 + e);
            }
            this.pdr.h(1 + e);
        }
        if (((ie >> 4) & 1) == 1) {
            long e2 = this.pdr.e((byte) 0);
            if (e2 == -1) {
                throw new EOFException();
            }
            if (z) {
                b(this.pdr.elX(), 0L, 1 + e2);
            }
            this.pdr.h(1 + e2);
        }
        if (z) {
            a("FHCRC", this.pdr.emc(), (short) this.pdu.getValue());
            this.pdu.reset();
        }
    }

    private void c() throws IOException {
        a("CRC", this.pdr.l(), (int) this.pdu.getValue());
        a("ISIZE", this.pdr.l(), (int) this.pds.getBytesWritten());
    }

    @Override // com.bytedance.sdk.a.a.s
    public t elW() {
        return this.pdr.elW();
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pdt.close();
    }

    private void b(c cVar, long j, long j2) {
        int i;
        o oVar = cVar.pdo;
        while (j >= oVar.c - oVar.f5849b) {
            j -= oVar.c - oVar.f5849b;
            oVar = oVar.pdA;
        }
        while (j2 > 0) {
            int min = (int) Math.min(oVar.c - i, j2);
            this.pdu.update(oVar.f5848a, (int) (oVar.f5849b + j), min);
            j2 -= min;
            oVar = oVar.pdA;
            j = 0;
        }
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
