package com.baidu.turbonet.net.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class e extends InputStream {
    private ByteBuffer mBuffer;
    private final d mLt;
    private boolean mLu;
    private IOException mLv;

    public e(d dVar) {
        this.mLt = dVar;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        dzS();
        if (dzT()) {
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
        dzS();
        if (dzT()) {
            int min = Math.min(this.mBuffer.limit() - this.mBuffer.position(), i2);
            this.mBuffer.get(bArr, i, min);
            return min;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(IOException iOException) {
        this.mLv = iOException;
        this.mLu = true;
        this.mBuffer = null;
    }

    private void dzS() throws IOException {
        if (this.mLu) {
            if (this.mLv != null) {
                throw this.mLv;
            }
        } else if (!dzT()) {
            if (this.mBuffer == null) {
                this.mBuffer = ByteBuffer.allocateDirect(32768);
            }
            this.mBuffer.clear();
            this.mLt.p(this.mBuffer);
            if (this.mLv != null) {
                throw this.mLv;
            }
            if (this.mBuffer != null) {
                this.mBuffer.flip();
            }
        }
    }

    private boolean dzT() {
        return this.mBuffer != null && this.mBuffer.hasRemaining();
    }
}
