package com.bytedance.sdk.a.a;

import com.baidu.live.tbadk.log.LogConfig;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes6.dex */
public final class k implements s {
    private int c;
    private boolean d;
    private final e pok;
    private final Inflater pol;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.pok = eVar;
        this.pol = inflater;
    }

    @Override // com.bytedance.sdk.a.a.s
    public long b(c cVar, long j) throws IOException {
        boolean b2;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.d) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        if (j == 0) {
            return 0L;
        }
        do {
            b2 = b();
            try {
                o Ox = cVar.Ox(1);
                int inflate = this.pol.inflate(Ox.f5850a, Ox.c, (int) Math.min(j, 8192 - Ox.c));
                if (inflate > 0) {
                    Ox.c += inflate;
                    cVar.f5842b += inflate;
                    return inflate;
                } else if (this.pol.finished() || this.pol.needsDictionary()) {
                    c();
                    if (Ox.f5851b == Ox.c) {
                        cVar.poc = Ox.eoP();
                        p.b(Ox);
                    }
                    return -1L;
                }
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } while (!b2);
        throw new EOFException("source exhausted prematurely");
    }

    public final boolean b() throws IOException {
        if (this.pol.needsInput()) {
            c();
            if (this.pol.getRemaining() != 0) {
                throw new IllegalStateException("?");
            }
            if (this.pok.e()) {
                return true;
            }
            o oVar = this.pok.eoz().poc;
            this.c = oVar.c - oVar.f5851b;
            this.pol.setInput(oVar.f5850a, oVar.f5851b, this.c);
            return false;
        }
        return false;
    }

    private void c() throws IOException {
        if (this.c != 0) {
            int remaining = this.c - this.pol.getRemaining();
            this.c -= remaining;
            this.pok.h(remaining);
        }
    }

    @Override // com.bytedance.sdk.a.a.s
    public t eoy() {
        return this.pok.eoy();
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.d) {
            this.pol.end();
            this.d = true;
            this.pok.close();
        }
    }
}
