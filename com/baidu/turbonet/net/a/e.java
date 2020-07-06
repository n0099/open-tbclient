package com.baidu.turbonet.net.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends InputStream {
    private ByteBuffer mBuffer;
    private final d mDl;
    private boolean mDm;
    private IOException mDn;

    public e(d dVar) {
        this.mDl = dVar;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        dwE();
        if (dwF()) {
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
        dwE();
        if (dwF()) {
            int min = Math.min(this.mBuffer.limit() - this.mBuffer.position(), i2);
            this.mBuffer.get(bArr, i, min);
            return min;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(IOException iOException) {
        this.mDn = iOException;
        this.mDm = true;
        this.mBuffer = null;
    }

    private void dwE() throws IOException {
        if (this.mDm) {
            if (this.mDn != null) {
                throw this.mDn;
            }
        } else if (!dwF()) {
            if (this.mBuffer == null) {
                this.mBuffer = ByteBuffer.allocateDirect(32768);
            }
            this.mBuffer.clear();
            this.mDl.p(this.mBuffer);
            if (this.mDn != null) {
                throw this.mDn;
            }
            if (this.mBuffer != null) {
                this.mBuffer.flip();
            }
        }
    }

    private boolean dwF() {
        return this.mBuffer != null && this.mBuffer.hasRemaining();
    }
}
