package com.baidubce.internal;

import com.baidubce.util.CheckUtils;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class RestartableMultiByteArrayInputStream extends RestartableInputStream {
    public int blockSize;
    public List<byte[]> byteArrayList;
    public long length;
    public long pos = 0;

    public RestartableMultiByteArrayInputStream(List<byte[]> list, long j) {
        long j2 = 0;
        CheckUtils.isNotNull(list, "byteArrayList should not be null.");
        CheckUtils.checkArgument(!list.isEmpty(), "byteArrayList should not be empty.");
        Iterator<byte[]> it = list.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            byte[] next = it.next();
            CheckUtils.isNotNull(next, "byteArrayList should not contain null element.");
            if (next.length > 0) {
                z = true;
            }
            CheckUtils.checkArgument(z, "byteArrayList should not contain empty byte array.");
            j2 += next.length;
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

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        CheckUtils.isNotNull(bArr, "b should not be null.");
        if (i >= 0 && i2 >= 0 && i2 <= bArr.length - i) {
            if (this.pos == this.length) {
                return -1;
            }
            int i3 = 0;
            while (i2 > 0) {
                long j = this.pos;
                if (j >= this.length) {
                    break;
                }
                int i4 = this.blockSize;
                int i5 = (int) (j % i4);
                byte[] bArr2 = this.byteArrayList.get((int) (j / i4));
                int length = bArr2.length - i5;
                if (length > i2) {
                    length = i2;
                }
                System.arraycopy(bArr2, i5, bArr, i, length);
                this.pos += length;
                i += length;
                i2 -= length;
                i3 += length;
            }
            return i3;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // com.baidubce.internal.RestartableInputStream
    public void restart() {
        this.pos = 0L;
    }

    @Override // java.io.InputStream
    public int read() {
        long j = this.pos;
        if (j == this.length) {
            return -1;
        }
        int i = this.blockSize;
        this.pos = j + 1;
        return this.byteArrayList.get((int) (j / i))[(int) (j % i)] & 255;
    }
}
