package com.baidu.turbonet.net.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class e extends InputStream {
    private ByteBuffer mBuffer;
    private final d oUB;
    private boolean oUC;
    private IOException oUD;

    public e(d dVar) {
        this.oUB = dVar;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        ehD();
        if (ehE()) {
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
        ehD();
        if (ehE()) {
            int min = Math.min(this.mBuffer.limit() - this.mBuffer.position(), i2);
            this.mBuffer.get(bArr, i, min);
            return min;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(IOException iOException) {
        this.oUD = iOException;
        this.oUC = true;
        this.mBuffer = null;
    }

    private void ehD() throws IOException {
        if (this.oUC) {
            if (this.oUD != null) {
                throw this.oUD;
            }
        } else if (!ehE()) {
            if (this.mBuffer == null) {
                this.mBuffer = ByteBuffer.allocateDirect(32768);
            }
            this.mBuffer.clear();
            this.oUB.p(this.mBuffer);
            if (this.oUD != null) {
                throw this.oUD;
            }
            if (this.mBuffer != null) {
                this.mBuffer.flip();
            }
        }
    }

    private boolean ehE() {
        return this.mBuffer != null && this.mBuffer.hasRemaining();
    }
}
