package com.baidu.turbonet.net.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends InputStream {
    private ByteBuffer mBuffer;
    private final d mDi;
    private boolean mDj;
    private IOException mDk;

    public e(d dVar) {
        this.mDi = dVar;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        dwA();
        if (dwB()) {
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
        dwA();
        if (dwB()) {
            int min = Math.min(this.mBuffer.limit() - this.mBuffer.position(), i2);
            this.mBuffer.get(bArr, i, min);
            return min;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(IOException iOException) {
        this.mDk = iOException;
        this.mDj = true;
        this.mBuffer = null;
    }

    private void dwA() throws IOException {
        if (this.mDj) {
            if (this.mDk != null) {
                throw this.mDk;
            }
        } else if (!dwB()) {
            if (this.mBuffer == null) {
                this.mBuffer = ByteBuffer.allocateDirect(32768);
            }
            this.mBuffer.clear();
            this.mDi.p(this.mBuffer);
            if (this.mDk != null) {
                throw this.mDk;
            }
            if (this.mBuffer != null) {
                this.mBuffer.flip();
            }
        }
    }

    private boolean dwB() {
        return this.mBuffer != null && this.mBuffer.hasRemaining();
    }
}
