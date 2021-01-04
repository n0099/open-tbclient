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
    private final e phX;
    private final Inflater phY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.phX = eVar;
        this.phY = inflater;
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
                o PI = cVar.PI(1);
                int inflate = this.phY.inflate(PI.f6147a, PI.c, (int) Math.min(j, 8192 - PI.c));
                if (inflate > 0) {
                    PI.c += inflate;
                    cVar.f6139b += inflate;
                    return inflate;
                } else if (this.phY.finished() || this.phY.needsDictionary()) {
                    c();
                    if (PI.f6148b == PI.c) {
                        cVar.phQ = PI.eqi();
                        p.b(PI);
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
        if (this.phY.needsInput()) {
            c();
            if (this.phY.getRemaining() != 0) {
                throw new IllegalStateException("?");
            }
            if (this.phX.e()) {
                return true;
            }
            o oVar = this.phX.epS().phQ;
            this.c = oVar.c - oVar.f6148b;
            this.phY.setInput(oVar.f6147a, oVar.f6148b, this.c);
            return false;
        }
        return false;
    }

    private void c() throws IOException {
        if (this.c != 0) {
            int remaining = this.c - this.phY.getRemaining();
            this.c -= remaining;
            this.phX.h(remaining);
        }
    }

    @Override // com.bytedance.sdk.a.a.s
    public t epR() {
        return this.phX.epR();
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.d) {
            this.phY.end();
            this.d = true;
            this.phX.close();
        }
    }
}
