package com.baidu.turbonet.net.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class e extends InputStream {
    private ByteBuffer mBuffer;
    private final d neo;
    private boolean nep;
    private IOException neq;

    public e(d dVar) {
        this.neo = dVar;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        dLF();
        if (dLG()) {
            return this.mBuffer.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        dLF();
        if (dLG()) {
            int min = Math.min(this.mBuffer.limit() - this.mBuffer.position(), i2);
            this.mBuffer.get(bArr, i, min);
            return min;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(IOException iOException) {
        this.neq = iOException;
        this.nep = true;
        this.mBuffer = null;
    }

    private void dLF() throws IOException {
        if (this.nep) {
            if (this.neq != null) {
                throw this.neq;
            }
        } else if (!dLG()) {
            if (this.mBuffer == null) {
                this.mBuffer = ByteBuffer.allocateDirect(32768);
            }
            this.mBuffer.clear();
            this.neo.p(this.mBuffer);
            if (this.neq != null) {
                throw this.neq;
            }
            if (this.mBuffer != null) {
                this.mBuffer.flip();
            }
        }
    }

    private boolean dLG() {
        return this.mBuffer != null && this.mBuffer.hasRemaining();
    }
}
