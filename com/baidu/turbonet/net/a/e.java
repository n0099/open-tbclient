package com.baidu.turbonet.net.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends InputStream {
    private ByteBuffer mBuffer;
    private final d mhp;
    private boolean mhq;
    private IOException mhr;

    public e(d dVar) {
        this.mhp = dVar;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        drV();
        if (drW()) {
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
        drV();
        if (drW()) {
            int min = Math.min(this.mBuffer.limit() - this.mBuffer.position(), i2);
            this.mBuffer.get(bArr, i, min);
            return min;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(IOException iOException) {
        this.mhr = iOException;
        this.mhq = true;
        this.mBuffer = null;
    }

    private void drV() throws IOException {
        if (this.mhq) {
            if (this.mhr != null) {
                throw this.mhr;
            }
        } else if (!drW()) {
            if (this.mBuffer == null) {
                this.mBuffer = ByteBuffer.allocateDirect(32768);
            }
            this.mBuffer.clear();
            this.mhp.p(this.mBuffer);
            if (this.mhr != null) {
                throw this.mhr;
            }
            if (this.mBuffer != null) {
                this.mBuffer.flip();
            }
        }
    }

    private boolean drW() {
        return this.mBuffer != null && this.mBuffer.hasRemaining();
    }
}
