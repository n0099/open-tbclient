package com.baidubce.internal;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.util.CheckUtils;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class RestartableMultiByteArrayInputStream extends RestartableInputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int blockSize;
    public List<byte[]> byteArrayList;
    public long length;
    public long pos;

    public RestartableMultiByteArrayInputStream(List<byte[]> list, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        long j2 = 0;
        this.pos = 0L;
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
        for (int i3 = 1; i3 < list.size() - 1; i3++) {
            int length = list.get(i3).length;
            CheckUtils.checkArgument(length == this.blockSize, "All elements in byteArrayList except the last one should have the same length. The first element's length is %s but the %sth element's length is %s.", Integer.valueOf(this.blockSize), Integer.valueOf(i3), Integer.valueOf(length));
        }
        this.byteArrayList = list;
        this.length = j;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i, i2)) == null) {
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
        return invokeLII.intValue;
    }

    @Override // com.baidubce.internal.RestartableInputStream
    public void restart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.pos = 0L;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long j = this.pos;
            if (j == this.length) {
                return -1;
            }
            int i = this.blockSize;
            this.pos = j + 1;
            return this.byteArrayList.get((int) (j / i))[(int) (j % i)] & 255;
        }
        return invokeV.intValue;
    }
}
