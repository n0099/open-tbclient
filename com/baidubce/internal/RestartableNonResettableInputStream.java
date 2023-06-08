package com.baidubce.internal;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.BceClientException;
import com.baidubce.util.CheckUtils;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes9.dex */
public class RestartableNonResettableInputStream extends RestartableInputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] buffer;
    public boolean eof;
    public InputStream input;
    public int length;
    public int offset;

    public RestartableNonResettableInputStream(InputStream inputStream, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.offset = 0;
        this.length = 0;
        this.eof = false;
        CheckUtils.isNotNull(inputStream, "input should not be null.");
        CheckUtils.checkArgument(i >= 0, "bufferSize should not be negative: " + i);
        this.buffer = new byte[i];
        this.input = inputStream;
        while (true) {
            int i4 = this.length;
            if (i4 < i) {
                try {
                    int read = this.input.read(this.buffer, i4, i - i4);
                    if (read < 0) {
                        this.eof = true;
                        return;
                    }
                    this.length += read;
                } catch (IOException e) {
                    throw new BceClientException("Fail to read data from input.", e);
                }
            } else {
                return;
            }
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.input.close();
        }
    }

    @Override // com.baidubce.internal.RestartableInputStream
    public void restart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.buffer != null) {
                this.offset = 0;
                return;
            }
            throw new IllegalStateException("Fail to restart. Input buffer exhausted.");
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
        return invokeV.intValue;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i, i2)) == null) {
            CheckUtils.isNotNull(bArr, "b should not be null.");
            if (i >= 0 && i2 >= 0 && i2 <= bArr.length - i) {
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
            throw new IndexOutOfBoundsException();
        }
        return invokeLII.intValue;
    }
}
