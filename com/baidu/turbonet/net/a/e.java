package com.baidu.turbonet.net.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends InputStream {
    private final d lMQ;
    private boolean lMR;
    private IOException lMS;
    private ByteBuffer mBuffer;

    public e(d dVar) {
        this.lMQ = dVar;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        dkr();
        if (dks()) {
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
        dkr();
        if (dks()) {
            int min = Math.min(this.mBuffer.limit() - this.mBuffer.position(), i2);
            this.mBuffer.get(bArr, i, min);
            return min;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(IOException iOException) {
        this.lMS = iOException;
        this.lMR = true;
        this.mBuffer = null;
    }

    private void dkr() throws IOException {
        if (this.lMR) {
            if (this.lMS != null) {
                throw this.lMS;
            }
        } else if (!dks()) {
            if (this.mBuffer == null) {
                this.mBuffer = ByteBuffer.allocateDirect(32768);
            }
            this.mBuffer.clear();
            this.lMQ.k(this.mBuffer);
            if (this.lMS != null) {
                throw this.lMS;
            }
            if (this.mBuffer != null) {
                this.mBuffer.flip();
            }
        }
    }

    private boolean dks() {
        return this.mBuffer != null && this.mBuffer.hasRemaining();
    }
}
