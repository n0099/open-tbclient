package com.baidubce.internal;

import com.baidubce.util.CheckUtils;
import java.io.IOException;
import java.util.List;
/* loaded from: classes5.dex */
public class RestartableMultiByteArrayInputStream extends RestartableInputStream {
    private int blockSize;
    private List<byte[]> byteArrayList;
    private long length;
    private long pos = 0;

    public RestartableMultiByteArrayInputStream(List<byte[]> list, long j) {
        long j2 = 0;
        CheckUtils.isNotNull(list, "byteArrayList should not be null.");
        CheckUtils.checkArgument(!list.isEmpty(), "byteArrayList should not be empty.");
        for (byte[] bArr : list) {
            CheckUtils.isNotNull(bArr, "byteArrayList should not contain null element.");
            CheckUtils.checkArgument(bArr.length > 0, "byteArrayList should not contain empty byte array.");
            j2 += bArr.length;
        }
        CheckUtils.checkArgument(j2 >= j, "The specified length(%s) is greater than the total length(%s) of elements in byteArrayList.", Long.valueOf(j), Long.valueOf(j2));
        this.blockSize = list.get(0).length;
        for (int i = 1; i < list.size() - 1; i++) {
            int length = list.get(i).length;
            CheckUtils.checkArgument(length == this.blockSize, "All elements in byteArrayList except the last one should have the same length. The first element's length is %s but the %sth element's length is %s.", Integer.valueOf(this.blockSize), Integer.valueOf(i), Integer.valueOf(length));
        }
        this.byteArrayList = list;
        this.length = j;
    }

    @Override // com.baidubce.internal.RestartableInputStream
    public void restart() {
        this.pos = 0L;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        CheckUtils.isNotNull(bArr, "b should not be null.");
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        if (this.pos == this.length) {
            return -1;
        }
        int i3 = 0;
        int i4 = i2;
        while (i4 > 0 && this.pos < this.length) {
            int i5 = (int) (this.pos % this.blockSize);
            byte[] bArr2 = this.byteArrayList.get((int) (this.pos / this.blockSize));
            int length = bArr2.length - i5;
            if (length > i4) {
                length = i4;
            }
            System.arraycopy(bArr2, i5, bArr, i, length);
            this.pos += length;
            i += length;
            i4 -= length;
            i3 += length;
        }
        return i3;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.pos == this.length) {
            return -1;
        }
        int i = (int) (this.pos % this.blockSize);
        this.pos++;
        return this.byteArrayList.get((int) (this.pos / this.blockSize))[i] & 255;
    }
}
