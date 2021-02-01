package com.baidu.turbonet.net.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class e extends InputStream {
    private ByteBuffer mBuffer;
    private final d oRW;
    private boolean oRX;
    private IOException oRY;

    public e(d dVar) {
        this.oRW = dVar;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        ehn();
        if (eho()) {
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
        ehn();
        if (eho()) {
            int min = Math.min(this.mBuffer.limit() - this.mBuffer.position(), i2);
            this.mBuffer.get(bArr, i, min);
            return min;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(IOException iOException) {
        this.oRY = iOException;
        this.oRX = true;
        this.mBuffer = null;
    }

    private void ehn() throws IOException {
        if (this.oRX) {
            if (this.oRY != null) {
                throw this.oRY;
            }
        } else if (!eho()) {
            if (this.mBuffer == null) {
                this.mBuffer = ByteBuffer.allocateDirect(32768);
            }
            this.mBuffer.clear();
            this.oRW.p(this.mBuffer);
            if (this.oRY != null) {
                throw this.oRY;
            }
            if (this.mBuffer != null) {
                this.mBuffer.flip();
            }
        }
    }

    private boolean eho() {
        return this.mBuffer != null && this.mBuffer.hasRemaining();
    }
}
