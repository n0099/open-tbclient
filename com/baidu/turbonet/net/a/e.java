package com.baidu.turbonet.net.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class e extends InputStream {
    private ByteBuffer mBuffer;
    private final d oGj;
    private boolean oGk;
    private IOException oGl;

    public e(d dVar) {
        this.oGj = dVar;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        eiC();
        if (eiD()) {
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
        eiC();
        if (eiD()) {
            int min = Math.min(this.mBuffer.limit() - this.mBuffer.position(), i2);
            this.mBuffer.get(bArr, i, min);
            return min;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(IOException iOException) {
        this.oGl = iOException;
        this.oGk = true;
        this.mBuffer = null;
    }

    private void eiC() throws IOException {
        if (this.oGk) {
            if (this.oGl != null) {
                throw this.oGl;
            }
        } else if (!eiD()) {
            if (this.mBuffer == null) {
                this.mBuffer = ByteBuffer.allocateDirect(32768);
            }
            this.mBuffer.clear();
            this.oGj.q(this.mBuffer);
            if (this.oGl != null) {
                throw this.oGl;
            }
            if (this.mBuffer != null) {
                this.mBuffer.flip();
            }
        }
    }

    private boolean eiD() {
        return this.mBuffer != null && this.mBuffer.hasRemaining();
    }
}
