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
    private final e pqt;
    private final Inflater pqu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.pqt = eVar;
        this.pqu = inflater;
    }

    @Override // com.bytedance.sdk.a.a.s
    public long b(c cVar, long j) throws IOException {
        boolean b;
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
            b = b();
            try {
                o OB = cVar.OB(1);
                int inflate = this.pqu.inflate(OB.f3942a, OB.c, (int) Math.min(j, 8192 - OB.c));
                if (inflate > 0) {
                    OB.c += inflate;
                    cVar.b += inflate;
                    return inflate;
                } else if (this.pqu.finished() || this.pqu.needsDictionary()) {
                    c();
                    if (OB.b == OB.c) {
                        cVar.pqm = OB.eoW();
                        p.b(OB);
                    }
                    return -1L;
                }
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } while (!b);
        throw new EOFException("source exhausted prematurely");
    }

    public final boolean b() throws IOException {
        if (this.pqu.needsInput()) {
            c();
            if (this.pqu.getRemaining() != 0) {
                throw new IllegalStateException("?");
            }
            if (this.pqt.e()) {
                return true;
            }
            o oVar = this.pqt.eoG().pqm;
            this.c = oVar.c - oVar.b;
            this.pqu.setInput(oVar.f3942a, oVar.b, this.c);
            return false;
        }
        return false;
    }

    private void c() throws IOException {
        if (this.c != 0) {
            int remaining = this.c - this.pqu.getRemaining();
            this.c -= remaining;
            this.pqt.h(remaining);
        }
    }

    @Override // com.bytedance.sdk.a.a.s
    public t eoF() {
        return this.pqt.eoF();
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.d) {
            this.pqu.end();
            this.d = true;
            this.pqt.close();
        }
    }
}
