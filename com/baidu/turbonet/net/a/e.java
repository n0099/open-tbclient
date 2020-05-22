package com.baidu.turbonet.net.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends InputStream {
    private ByteBuffer mBuffer;
    private final d mgf;
    private boolean mgg;
    private IOException mgh;

    public e(d dVar) {
        this.mgf = dVar;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        drH();
        if (drI()) {
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
        drH();
        if (drI()) {
            int min = Math.min(this.mBuffer.limit() - this.mBuffer.position(), i2);
            this.mBuffer.get(bArr, i, min);
            return min;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(IOException iOException) {
        this.mgh = iOException;
        this.mgg = true;
        this.mBuffer = null;
    }

    private void drH() throws IOException {
        if (this.mgg) {
            if (this.mgh != null) {
                throw this.mgh;
            }
        } else if (!drI()) {
            if (this.mBuffer == null) {
                this.mBuffer = ByteBuffer.allocateDirect(32768);
            }
            this.mBuffer.clear();
            this.mgf.p(this.mBuffer);
            if (this.mgh != null) {
                throw this.mgh;
            }
            if (this.mBuffer != null) {
                this.mBuffer.flip();
            }
        }
    }

    private boolean drI() {
        return this.mBuffer != null && this.mBuffer.hasRemaining();
    }
}
