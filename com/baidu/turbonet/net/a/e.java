package com.baidu.turbonet.net.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class e extends InputStream {
    private ByteBuffer mBuffer;
    private final d oMs;
    private boolean oMt;
    private IOException oMu;

    public e(d dVar) {
        this.oMs = dVar;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        eiN();
        if (eiO()) {
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
        eiN();
        if (eiO()) {
            int min = Math.min(this.mBuffer.limit() - this.mBuffer.position(), i2);
            this.mBuffer.get(bArr, i, min);
            return min;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(IOException iOException) {
        this.oMu = iOException;
        this.oMt = true;
        this.mBuffer = null;
    }

    private void eiN() throws IOException {
        if (this.oMt) {
            if (this.oMu != null) {
                throw this.oMu;
            }
        } else if (!eiO()) {
            if (this.mBuffer == null) {
                this.mBuffer = ByteBuffer.allocateDirect(32768);
            }
            this.mBuffer.clear();
            this.oMs.p(this.mBuffer);
            if (this.oMu != null) {
                throw this.oMu;
            }
            if (this.mBuffer != null) {
                this.mBuffer.flip();
            }
        }
    }

    private boolean eiO() {
        return this.mBuffer != null && this.mBuffer.hasRemaining();
    }
}
