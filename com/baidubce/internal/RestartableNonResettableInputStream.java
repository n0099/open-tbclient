package com.baidubce.internal;

import com.baidubce.BceClientException;
import com.baidubce.util.CheckUtils;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class RestartableNonResettableInputStream extends RestartableInputStream {
    public byte[] buffer;
    public boolean eof;
    public InputStream input;
    public int offset = 0;
    public int length = 0;

    public RestartableNonResettableInputStream(InputStream inputStream, int i) {
        this.eof = false;
        CheckUtils.isNotNull(inputStream, "input should not be null.");
        CheckUtils.checkArgument(i >= 0, "bufferSize should not be negative: " + i);
        this.buffer = new byte[i];
        this.input = inputStream;
        while (true) {
            int i2 = this.length;
            if (i2 >= i) {
                return;
            }
            try {
                int read = this.input.read(this.buffer, i2, i - i2);
                if (read < 0) {
                    this.eof = true;
                    return;
                }
                this.length += read;
            } catch (IOException e2) {
                throw new BceClientException("Fail to read data from input.", e2);
            }
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.input.close();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        CheckUtils.isNotNull(bArr, "b should not be null.");
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.offset;
        int i4 = this.length;
        if (i3 < i4) {
            int i5 = i4 - i3;
            if (i5 <= i2) {
                i2 = i5;
            }
            System.arraycopy(this.buffer, this.offset, bArr, i, i2);
            this.offset += i2;
            return i2;
        } else if (this.eof) {
            return -1;
        } else {
            int read = this.input.read(bArr, i, i2);
            if (read < 0) {
                this.eof = true;
                return -1;
            }
            this.buffer = null;
            return read;
        }
    }

    @Override // com.baidubce.internal.RestartableInputStream
    public void restart() {
        if (this.buffer != null) {
            this.offset = 0;
            return;
        }
        throw new IllegalStateException("Fail to restart. Input buffer exhausted.");
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.offset;
        if (i < this.length) {
            byte[] bArr = this.buffer;
            this.offset = i + 1;
            return bArr[i] & 255;
        } else if (this.eof) {
            return -1;
        } else {
            int read = this.input.read();
            if (read < 0) {
                this.eof = true;
                return -1;
            }
            this.buffer = null;
            return read;
        }
    }
}
