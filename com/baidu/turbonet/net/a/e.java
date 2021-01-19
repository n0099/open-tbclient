package com.baidu.turbonet.net.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class e extends InputStream {
    private ByteBuffer mBuffer;
    private final d oHO;
    private boolean oHP;
    private IOException oHQ;

    public e(d dVar) {
        this.oHO = dVar;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        eeV();
        if (eeW()) {
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
        eeV();
        if (eeW()) {
            int min = Math.min(this.mBuffer.limit() - this.mBuffer.position(), i2);
            this.mBuffer.get(bArr, i, min);
            return min;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(IOException iOException) {
        this.oHQ = iOException;
        this.oHP = true;
        this.mBuffer = null;
    }

    private void eeV() throws IOException {
        if (this.oHP) {
            if (this.oHQ != null) {
                throw this.oHQ;
            }
        } else if (!eeW()) {
            if (this.mBuffer == null) {
                this.mBuffer = ByteBuffer.allocateDirect(32768);
            }
            this.mBuffer.clear();
            this.oHO.p(this.mBuffer);
            if (this.oHQ != null) {
                throw this.oHQ;
            }
            if (this.mBuffer != null) {
                this.mBuffer.flip();
            }
        }
    }

    private boolean eeW() {
        return this.mBuffer != null && this.mBuffer.hasRemaining();
    }
}
