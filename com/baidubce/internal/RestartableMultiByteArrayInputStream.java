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
        for (int i2 = 1; i2 < list.size() - 1; i2++) {
            int length = list.get(i2).length;
            CheckUtils.checkArgument(length == this.blockSize, "All elements in byteArrayList except the last one should have the same length. The first element's length is %s but the %sth element's length is %s.", Integer.valueOf(this.blockSize), Integer.valueOf(i2), Integer.valueOf(length));
        }
        this.byteArrayList = list;
        this.length = j;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        CheckUtils.isNotNull(bArr, "b should not be null.");
        if (i2 >= 0 && i3 >= 0 && i3 <= bArr.length - i2) {
            if (this.pos == this.length) {
                return -1;
            }
            int i4 = 0;
            while (i3 > 0) {
                long j = this.pos;
                if (j >= this.length) {
                    break;
                }
                int i5 = this.blockSize;
                int i6 = (int) (j % i5);
                byte[] bArr2 = this.byteArrayList.get((int) (j / i5));
                int length = bArr2.length - i6;
                if (length > i3) {
                    length = i3;
                }
                System.arraycopy(bArr2, i6, bArr, i2, length);
                this.pos += length;
                i2 += length;
                i3 -= length;
                i4 += length;
            }
            return i4;
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
        int i2 = this.blockSize;
        this.pos = j + 1;
        return this.byteArrayList.get((int) (j / i2))[(int) (j % i2)] & 255;
    }
}
