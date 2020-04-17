package com.baidu.turbonet.net.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends InputStream {
    private final d lMM;
    private boolean lMN;
    private IOException lMO;
    private ByteBuffer mBuffer;

    public e(d dVar) {
        this.lMM = dVar;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        dkt();
        if (dku()) {
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
        dkt();
        if (dku()) {
            int min = Math.min(this.mBuffer.limit() - this.mBuffer.position(), i2);
            this.mBuffer.get(bArr, i, min);
            return min;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(IOException iOException) {
        this.lMO = iOException;
        this.lMN = true;
        this.mBuffer = null;
    }

    private void dkt() throws IOException {
        if (this.lMN) {
            if (this.lMO != null) {
                throw this.lMO;
            }
        } else if (!dku()) {
            if (this.mBuffer == null) {
                this.mBuffer = ByteBuffer.allocateDirect(32768);
            }
            this.mBuffer.clear();
            this.lMM.k(this.mBuffer);
            if (this.lMO != null) {
                throw this.lMO;
            }
            if (this.mBuffer != null) {
                this.mBuffer.flip();
            }
        }
    }

    private boolean dku() {
        return this.mBuffer != null && this.mBuffer.hasRemaining();
    }
}
