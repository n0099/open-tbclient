package com.baidu.turbonet.net.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public class e extends InputStream {
    private ByteBuffer mBuffer;
    private final d opI;
    private boolean opJ;
    private IOException opK;

    public e(d dVar) {
        this.opI = dVar;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        ecX();
        if (ecY()) {
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
        ecX();
        if (ecY()) {
            int min = Math.min(this.mBuffer.limit() - this.mBuffer.position(), i2);
            this.mBuffer.get(bArr, i, min);
            return min;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(IOException iOException) {
        this.opK = iOException;
        this.opJ = true;
        this.mBuffer = null;
    }

    private void ecX() throws IOException {
        if (this.opJ) {
            if (this.opK != null) {
                throw this.opK;
            }
        } else if (!ecY()) {
            if (this.mBuffer == null) {
                this.mBuffer = ByteBuffer.allocateDirect(32768);
            }
            this.mBuffer.clear();
            this.opI.q(this.mBuffer);
            if (this.opK != null) {
                throw this.opK;
            }
            if (this.mBuffer != null) {
                this.mBuffer.flip();
            }
        }
    }

    private boolean ecY() {
        return this.mBuffer != null && this.mBuffer.hasRemaining();
    }
}
