package com.bytedance.sdk.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
/* loaded from: classes4.dex */
public final class j implements s {
    private final e phT;
    private final Inflater phU;
    private final k phV;

    /* renamed from: a  reason: collision with root package name */
    private int f6143a = 0;
    private final CRC32 phW = new CRC32();

    public j(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.phU = new Inflater(true);
        this.phT = l.c(sVar);
        this.phV = new k(this.phT, this.phU);
    }

    @Override // com.bytedance.sdk.a.a.s
    public long b(c cVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        if (this.f6143a == 0) {
            b();
            this.f6143a = 1;
        }
        if (this.f6143a == 1) {
            long j2 = cVar.f6140b;
            long b2 = this.phV.b(cVar, j);
            if (b2 != -1) {
                b(cVar, j2, b2);
                return b2;
            }
            this.f6143a = 2;
        }
        if (this.f6143a == 2) {
            c();
            this.f6143a = 3;
            if (!this.phT.e()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    private void b() throws IOException {
        this.phT.a(10L);
        byte ie = this.phT.epT().ie(3L);
        boolean z = ((ie >> 1) & 1) == 1;
        if (z) {
            b(this.phT.epT(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.phT.epX());
        this.phT.h(8L);
        if (((ie >> 2) & 1) == 1) {
            this.phT.a(2L);
            if (z) {
                b(this.phT.epT(), 0L, 2L);
            }
            short epY = this.phT.epT().epY();
            this.phT.a(epY);
            if (z) {
                b(this.phT.epT(), 0L, epY);
            }
            this.phT.h(epY);
        }
        if (((ie >> 3) & 1) == 1) {
            long e = this.phT.e((byte) 0);
            if (e == -1) {
                throw new EOFException();
            }
            if (z) {
                b(this.phT.epT(), 0L, 1 + e);
            }
            this.phT.h(1 + e);
        }
        if (((ie >> 4) & 1) == 1) {
            long e2 = this.phT.e((byte) 0);
            if (e2 == -1) {
                throw new EOFException();
            }
            if (z) {
                b(this.phT.epT(), 0L, 1 + e2);
            }
            this.phT.h(1 + e2);
        }
        if (z) {
            a("FHCRC", this.phT.epY(), (short) this.phW.getValue());
            this.phW.reset();
        }
    }

    private void c() throws IOException {
        a("CRC", this.phT.l(), (int) this.phW.getValue());
        a("ISIZE", this.phT.l(), (int) this.phU.getBytesWritten());
    }

    @Override // com.bytedance.sdk.a.a.s
    public t epS() {
        return this.phT.epS();
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.phV.close();
    }

    private void b(c cVar, long j, long j2) {
        int i;
        o oVar = cVar.phQ;
        while (j >= oVar.c - oVar.f6149b) {
            j -= oVar.c - oVar.f6149b;
            oVar = oVar.pie;
        }
        while (j2 > 0) {
            int min = (int) Math.min(oVar.c - i, j2);
            this.phW.update(oVar.f6148a, (int) (oVar.f6149b + j), min);
            j2 -= min;
            oVar = oVar.pie;
            j = 0;
        }
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
