package com.baidu.turbonet.net.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class e extends InputStream {
    private ByteBuffer mBuffer;
    private final d mLr;
    private boolean mLs;
    private IOException mLt;

    public e(d dVar) {
        this.mLr = dVar;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        dzR();
        if (dzS()) {
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
        dzR();
        if (dzS()) {
            int min = Math.min(this.mBuffer.limit() - this.mBuffer.position(), i2);
            this.mBuffer.get(bArr, i, min);
            return min;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(IOException iOException) {
        this.mLt = iOException;
        this.mLs = true;
        this.mBuffer = null;
    }

    private void dzR() throws IOException {
        if (this.mLs) {
            if (this.mLt != null) {
                throw this.mLt;
            }
        } else if (!dzS()) {
            if (this.mBuffer == null) {
                this.mBuffer = ByteBuffer.allocateDirect(32768);
            }
            this.mBuffer.clear();
            this.mLr.p(this.mBuffer);
            if (this.mLt != null) {
                throw this.mLt;
            }
            if (this.mBuffer != null) {
                this.mBuffer.flip();
            }
        }
    }

    private boolean dzS() {
        return this.mBuffer != null && this.mBuffer.hasRemaining();
    }
}
