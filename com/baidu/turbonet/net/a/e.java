package com.baidu.turbonet.net.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class e extends InputStream {
    private ByteBuffer mBuffer;
    private final d neH;
    private boolean neI;
    private IOException neJ;

    public e(d dVar) {
        this.neH = dVar;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        dLO();
        if (dLP()) {
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
        dLO();
        if (dLP()) {
            int min = Math.min(this.mBuffer.limit() - this.mBuffer.position(), i2);
            this.mBuffer.get(bArr, i, min);
            return min;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(IOException iOException) {
        this.neJ = iOException;
        this.neI = true;
        this.mBuffer = null;
    }

    private void dLO() throws IOException {
        if (this.neI) {
            if (this.neJ != null) {
                throw this.neJ;
            }
        } else if (!dLP()) {
            if (this.mBuffer == null) {
                this.mBuffer = ByteBuffer.allocateDirect(32768);
            }
            this.mBuffer.clear();
            this.neH.p(this.mBuffer);
            if (this.neJ != null) {
                throw this.neJ;
            }
            if (this.mBuffer != null) {
                this.mBuffer.flip();
            }
        }
    }

    private boolean dLP() {
        return this.mBuffer != null && this.mBuffer.hasRemaining();
    }
}
