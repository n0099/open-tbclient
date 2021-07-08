package com.baidu.webkit.internal.brotli;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.INoProGuard;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
/* loaded from: classes5.dex */
public class BrotliInputStream extends InputStream implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_BUFFER_SIZE = 16384;
    public transient /* synthetic */ FieldHolder $fh;
    public final Decoder decoder;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BrotliInputStream(InputStream inputStream) throws IOException {
        this(inputStream, 16384);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((InputStream) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public BrotliInputStream(InputStream inputStream, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.decoder = new Decoder(Channels.newChannel(inputStream), i2);
    }

    @Override // java.io.InputStream
    public int available() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ByteBuffer byteBuffer = this.decoder.buffer;
            if (byteBuffer != null) {
                return byteBuffer.remaining();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.decoder.close();
        }
    }

    public void enableEagerOutput() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.decoder.enableEagerOutput();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InterceptResult invokeV;
        int decode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.decoder.closed) {
                throw new IOException("read after close");
            }
            do {
                decode = this.decoder.decode();
            } while (decode == 0);
            if (decode == -1) {
                return -1;
            }
            return this.decoder.buffer.get() & 255;
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bArr)) == null) ? read(bArr, 0, bArr.length) : invokeL.intValue;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, bArr, i2, i3)) == null) {
            Decoder decoder = this.decoder;
            if (decoder.closed) {
                throw new IOException("read after close");
            }
            if (decoder.decode() == -1) {
                return -1;
            }
            int i4 = 0;
            while (i3 > 0) {
                int min = Math.min(i3, this.decoder.buffer.remaining());
                this.decoder.buffer.get(bArr, i2, min);
                i2 += min;
                i3 -= min;
                i4 += min;
                if (!this.decoder.buffer.hasRemaining()) {
                    break;
                } else if (this.decoder.decode() == -1) {
                    break;
                }
            }
            return i4;
        }
        return invokeLII.intValue;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            if (this.decoder.closed) {
                throw new IOException("read after close");
            }
            long j2 = 0;
            while (j > 0 && this.decoder.decode() != -1) {
                int min = (int) Math.min(j, this.decoder.buffer.remaining());
                this.decoder.discard(min);
                long j3 = min;
                j2 += j3;
                j -= j3;
            }
            return j2;
        }
        return invokeJ.longValue;
    }
}
