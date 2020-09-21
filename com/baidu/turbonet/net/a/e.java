package com.baidu.turbonet.net.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class e extends InputStream {
    private ByteBuffer mBuffer;
    private final d noH;
    private boolean noI;
    private IOException noJ;

    public e(d dVar) {
        this.noH = dVar;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        dPM();
        if (dPN()) {
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
        dPM();
        if (dPN()) {
            int min = Math.min(this.mBuffer.limit() - this.mBuffer.position(), i2);
            this.mBuffer.get(bArr, i, min);
            return min;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(IOException iOException) {
        this.noJ = iOException;
        this.noI = true;
        this.mBuffer = null;
    }

    private void dPM() throws IOException {
        if (this.noI) {
            if (this.noJ != null) {
                throw this.noJ;
            }
        } else if (!dPN()) {
            if (this.mBuffer == null) {
                this.mBuffer = ByteBuffer.allocateDirect(32768);
            }
            this.mBuffer.clear();
            this.noH.p(this.mBuffer);
            if (this.noJ != null) {
                throw this.noJ;
            }
            if (this.mBuffer != null) {
                this.mBuffer.flip();
            }
        }
    }

    private boolean dPN() {
        return this.mBuffer != null && this.mBuffer.hasRemaining();
    }
}
