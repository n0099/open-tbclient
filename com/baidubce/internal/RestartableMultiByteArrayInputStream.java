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
/* loaded from: classes7.dex */
public class RestartableMultiByteArrayInputStream extends RestartableInputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int blockSize;
    public List<byte[]> byteArrayList;
    public long length;
    public long pos;

    public RestartableMultiByteArrayInputStream(List<byte[]> list, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        long j3 = 0;
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
            j3 += next.length;
        }
        CheckUtils.checkArgument(j3 >= j2, "The specified length(%s) is greater than the total length(%s) of elements in byteArrayList.", Long.valueOf(j2), Long.valueOf(j3));
        this.blockSize = list.get(0).length;
        for (int i4 = 1; i4 < list.size() - 1; i4++) {
            int length = list.get(i4).length;
            CheckUtils.checkArgument(length == this.blockSize, "All elements in byteArrayList except the last one should have the same length. The first element's length is %s but the %sth element's length is %s.", Integer.valueOf(this.blockSize), Integer.valueOf(i4), Integer.valueOf(length));
        }
        this.byteArrayList = list;
        this.length = j2;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2, i3)) == null) {
            CheckUtils.isNotNull(bArr, "b should not be null.");
            if (i2 >= 0 && i3 >= 0 && i3 <= bArr.length - i2) {
                if (this.pos == this.length) {
                    return -1;
                }
                int i4 = 0;
                while (i3 > 0) {
                    long j2 = this.pos;
                    if (j2 >= this.length) {
                        break;
                    }
                    int i5 = this.blockSize;
                    int i6 = (int) (j2 % i5);
                    byte[] bArr2 = this.byteArrayList.get((int) (j2 / i5));
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
            long j2 = this.pos;
            if (j2 == this.length) {
                return -1;
            }
            int i2 = this.blockSize;
            this.pos = j2 + 1;
            return this.byteArrayList.get((int) (j2 / i2))[(int) (j2 % i2)] & 255;
        }
        return invokeV.intValue;
    }
}
