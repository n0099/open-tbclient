package com.baidu.turbonet.net.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public class e extends InputStream {
    private ByteBuffer mBuffer;
    private final d ogD;
    private boolean ogE;
    private IOException ogF;

    public e(d dVar) {
        this.ogD = dVar;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        dZp();
        if (dZq()) {
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
        dZp();
        if (dZq()) {
            int min = Math.min(this.mBuffer.limit() - this.mBuffer.position(), i2);
            this.mBuffer.get(bArr, i, min);
            return min;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(IOException iOException) {
        this.ogF = iOException;
        this.ogE = true;
        this.mBuffer = null;
    }

    private void dZp() throws IOException {
        if (this.ogE) {
            if (this.ogF != null) {
                throw this.ogF;
            }
        } else if (!dZq()) {
            if (this.mBuffer == null) {
                this.mBuffer = ByteBuffer.allocateDirect(32768);
            }
            this.mBuffer.clear();
            this.ogD.q(this.mBuffer);
            if (this.ogF != null) {
                throw this.ogF;
            }
            if (this.mBuffer != null) {
                this.mBuffer.flip();
            }
        }
    }

    private boolean dZq() {
        return this.mBuffer != null && this.mBuffer.hasRemaining();
    }
}
