package com.baidubce.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.BceClientException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes9.dex */
public class LengthCheckInputStream extends FilterInputStream {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean EXCLUDE_SKIPPED_BYTES = false;
    public static final boolean INCLUDE_SKIPPED_BYTES = true;
    public transient /* synthetic */ FieldHolder $fh;
    public long dataLength;
    public final long expectedLength;
    public final boolean includeSkipped;
    public long marked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LengthCheckInputStream(InputStream inputStream, long j2, boolean z) {
        super(inputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Long.valueOf(j2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((InputStream) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (j2 >= 0) {
            this.expectedLength = j2;
            this.includeSkipped = z;
            return;
        }
        throw new IllegalArgumentException();
    }

    private void checkLength(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, this, z) == null) {
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
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.mark(i2);
            this.marked = this.dataLength;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int read = super.read();
            if (read >= 0) {
                this.dataLength++;
            }
            checkLength(read == -1);
            return read;
        }
        return invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.reset();
            if (super.markSupported()) {
                this.dataLength = this.marked;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
            long skip = super.skip(j2);
            if (this.includeSkipped && skip > 0) {
                this.dataLength += skip;
                checkLength(false);
            }
            return skip;
        }
        return invokeJ.longValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i2, i3)) == null) {
            int read = super.read(bArr, i2, i3);
            this.dataLength += read >= 0 ? read : 0L;
            checkLength(read == -1);
            return read;
        }
        return invokeLII.intValue;
    }
}
