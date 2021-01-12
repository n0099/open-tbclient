package com.baidubce.internal;

import com.baidubce.BceClientException;
import com.baidubce.util.CheckUtils;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class RestartableNonResettableInputStream extends RestartableInputStream {
    private byte[] buffer;
    private boolean eof;
    private InputStream input;
    private int length;
    private int offset = 0;

    public RestartableNonResettableInputStream(InputStream inputStream, int i) {
        this.length = 0;
        this.eof = false;
        CheckUtils.isNotNull(inputStream, "input should not be null.");
        CheckUtils.checkArgument(i >= 0, "bufferSize should not be negative: " + i);
        this.buffer = new byte[i];
        this.input = inputStream;
        while (this.length < i) {
            try {
                int read = this.input.read(this.buffer, this.length, i - this.length);
                if (read < 0) {
                    this.eof = true;
                    return;
                }
                this.length = read + this.length;
            } catch (IOException e) {
                throw new BceClientException("Fail to read data from input.", e);
            }
        }
    }

    @Override // com.baidubce.internal.RestartableInputStream
    public void restart() {
        if (this.buffer == null) {
            throw new IllegalStateException("Fail to restart. Input buffer exhausted.");
        }
        this.offset = 0;
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
        if (this.offset < this.length) {
            int i3 = this.length - this.offset;
            if (i3 <= i2) {
                i2 = i3;
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

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.offset < this.length) {
            byte[] bArr = this.buffer;
            int i = this.offset;
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

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.input.close();
    }
}
