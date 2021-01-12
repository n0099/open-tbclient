package com.bytedance.sdk.a.a;

import com.baidu.live.tbadk.log.LogConfig;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes4.dex */
public final class k implements s {
    private int c;
    private boolean d;
    private final e pdv;
    private final Inflater pdw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.pdv = eVar;
        this.pdw = inflater;
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
                o Ob = cVar.Ob(1);
                int inflate = this.pdw.inflate(Ob.f5848a, Ob.c, (int) Math.min(j, 8192 - Ob.c));
                if (inflate > 0) {
                    Ob.c += inflate;
                    cVar.f5840b += inflate;
                    return inflate;
                } else if (this.pdw.finished() || this.pdw.needsDictionary()) {
                    c();
                    if (Ob.f5849b == Ob.c) {
                        cVar.pdo = Ob.emn();
                        p.b(Ob);
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
        if (this.pdw.needsInput()) {
            c();
            if (this.pdw.getRemaining() != 0) {
                throw new IllegalStateException("?");
            }
            if (this.pdv.e()) {
                return true;
            }
            o oVar = this.pdv.elX().pdo;
            this.c = oVar.c - oVar.f5849b;
            this.pdw.setInput(oVar.f5848a, oVar.f5849b, this.c);
            return false;
        }
        return false;
    }

    private void c() throws IOException {
        if (this.c != 0) {
            int remaining = this.c - this.pdw.getRemaining();
            this.c -= remaining;
            this.pdv.h(remaining);
        }
    }

    @Override // com.bytedance.sdk.a.a.s
    public t elW() {
        return this.pdv.elW();
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.d) {
            this.pdw.end();
            this.d = true;
            this.pdv.close();
        }
    }
}
