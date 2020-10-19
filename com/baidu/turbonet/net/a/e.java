package com.baidu.turbonet.net.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public class e extends InputStream {
    private ByteBuffer mBuffer;
    private final d nEb;
    private boolean nEc;
    private IOException nEd;

    public e(d dVar) {
        this.nEb = dVar;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        dTx();
        if (dTy()) {
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
        dTx();
        if (dTy()) {
            int min = Math.min(this.mBuffer.limit() - this.mBuffer.position(), i2);
            this.mBuffer.get(bArr, i, min);
            return min;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(IOException iOException) {
        this.nEd = iOException;
        this.nEc = true;
        this.mBuffer = null;
    }

    private void dTx() throws IOException {
        if (this.nEc) {
            if (this.nEd != null) {
                throw this.nEd;
            }
        } else if (!dTy()) {
            if (this.mBuffer == null) {
                this.mBuffer = ByteBuffer.allocateDirect(32768);
            }
            this.mBuffer.clear();
            this.nEb.r(this.mBuffer);
            if (this.nEd != null) {
                throw this.nEd;
            }
            if (this.mBuffer != null) {
                this.mBuffer.flip();
            }
        }
    }

    private boolean dTy() {
        return this.mBuffer != null && this.mBuffer.hasRemaining();
    }
}
