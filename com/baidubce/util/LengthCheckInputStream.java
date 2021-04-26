package com.baidubce.util;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidubce.BceClientException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class LengthCheckInputStream extends FilterInputStream {
    public static final boolean EXCLUDE_SKIPPED_BYTES = false;
    public static final boolean INCLUDE_SKIPPED_BYTES = true;
    public long dataLength;
    public final long expectedLength;
    public final boolean includeSkipped;
    public long marked;

    public LengthCheckInputStream(InputStream inputStream, long j, boolean z) {
        super(inputStream);
        if (j >= 0) {
            this.expectedLength = j;
            this.includeSkipped = z;
            return;
        }
        throw new IllegalArgumentException();
    }

    private void checkLength(boolean z) {
        if (z) {
            if (this.dataLength == this.expectedLength) {
                return;
            }
            throw new BceClientException("Data read (" + this.dataLength + ") has a different length than the expected (" + this.expectedLength + SmallTailInfo.EMOTION_SUFFIX);
        } else if (this.dataLength <= this.expectedLength) {
        } else {
            throw new BceClientException("More data read (" + this.dataLength + ") than expected (" + this.expectedLength + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i2) {
        super.mark(i2);
        this.marked = this.dataLength;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = super.read();
        if (read >= 0) {
            this.dataLength++;
        }
        checkLength(read == -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        if (super.markSupported()) {
            this.dataLength = this.marked;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = super.skip(j);
        if (this.includeSkipped && skip > 0) {
            this.dataLength += skip;
            checkLength(false);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = super.read(bArr, i2, i3);
        this.dataLength += read >= 0 ? read : 0L;
        checkLength(read == -1);
        return read;
    }
}
