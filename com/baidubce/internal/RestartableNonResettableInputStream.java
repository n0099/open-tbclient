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

    public RestartableNonResettableInputStream(InputStream inputStream, int i2) {
        this.eof = false;
        CheckUtils.isNotNull(inputStream, "input should not be null.");
        CheckUtils.checkArgument(i2 >= 0, "bufferSize should not be negative: " + i2);
        this.buffer = new byte[i2];
        this.input = inputStream;
        while (true) {
            int i3 = this.length;
            if (i3 >= i2) {
                return;
            }
            try {
                int read = this.input.read(this.buffer, i3, i2 - i3);
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
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        CheckUtils.isNotNull(bArr, "b should not be null.");
        if (i2 < 0 || i3 < 0 || i3 > bArr.length - i2) {
            throw new IndexOutOfBoundsException();
        }
        if (i3 == 0) {
            return 0;
        }
        int i4 = this.offset;
        int i5 = this.length;
        if (i4 < i5) {
            int i6 = i5 - i4;
            if (i6 <= i3) {
                i3 = i6;
            }
            System.arraycopy(this.buffer, this.offset, bArr, i2, i3);
            this.offset += i3;
            return i3;
        } else if (this.eof) {
            return -1;
        } else {
            int read = this.input.read(bArr, i2, i3);
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
        int i2 = this.offset;
        if (i2 < this.length) {
            byte[] bArr = this.buffer;
            this.offset = i2 + 1;
            return bArr[i2] & 255;
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
