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
    private final e pnJ;
    private final Inflater pnK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.pnJ = eVar;
        this.pnK = inflater;
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
                o Ow = cVar.Ow(1);
                int inflate = this.pnK.inflate(Ow.f5850a, Ow.c, (int) Math.min(j, 8192 - Ow.c));
                if (inflate > 0) {
                    Ow.c += inflate;
                    cVar.f5842b += inflate;
                    return inflate;
                } else if (this.pnK.finished() || this.pnK.needsDictionary()) {
                    c();
                    if (Ow.f5851b == Ow.c) {
                        cVar.pnC = Ow.eoH();
                        p.b(Ow);
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
        if (this.pnK.needsInput()) {
            c();
            if (this.pnK.getRemaining() != 0) {
                throw new IllegalStateException("?");
            }
            if (this.pnJ.e()) {
                return true;
            }
            o oVar = this.pnJ.eor().pnC;
            this.c = oVar.c - oVar.f5851b;
            this.pnK.setInput(oVar.f5850a, oVar.f5851b, this.c);
            return false;
        }
        return false;
    }

    private void c() throws IOException {
        if (this.c != 0) {
            int remaining = this.c - this.pnK.getRemaining();
            this.c -= remaining;
            this.pnJ.h(remaining);
        }
    }

    @Override // com.bytedance.sdk.a.a.s
    public t eoq() {
        return this.pnJ.eoq();
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.d) {
            this.pnK.end();
            this.d = true;
            this.pnJ.close();
        }
    }
}
