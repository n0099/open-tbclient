package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes7.dex */
public class qgc extends InputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;
    public int b;
    public int c;
    public final ygc d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public qgc(InputStream inputStream) throws IOException {
        this(inputStream, 16384, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((InputStream) objArr2[0], ((Integer) objArr2[1]).intValue(), (byte[]) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public qgc(InputStream inputStream, int i, byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i), bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ygc ygcVar = new ygc();
        this.d = ygcVar;
        if (i > 0) {
            if (inputStream != null) {
                this.a = new byte[i];
                this.b = 0;
                this.c = 0;
                try {
                    ygc.c(ygcVar, inputStream);
                    if (bArr != null) {
                        sgc.s(this.d, bArr);
                        return;
                    }
                    return;
                } catch (BrotliRuntimeException e) {
                    throw new IOException("Brotli decoder initialization failed", e);
                }
            }
            throw new IllegalArgumentException("source is null");
        }
        throw new IllegalArgumentException("Bad buffer size:" + i);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ygc.a(this.d);
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.c >= this.b) {
                byte[] bArr = this.a;
                int read = read(bArr, 0, bArr.length);
                this.b = read;
                this.c = 0;
                if (read == -1) {
                    return -1;
                }
            }
            byte[] bArr2 = this.a;
            int i = this.c;
            this.c = i + 1;
            return bArr2[i] & 255;
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i, i2)) == null) {
            if (i >= 0) {
                if (i2 >= 0) {
                    int i3 = i + i2;
                    if (i3 <= bArr.length) {
                        if (i2 == 0) {
                            return 0;
                        }
                        int max = Math.max(this.b - this.c, 0);
                        if (max != 0) {
                            max = Math.min(max, i2);
                            System.arraycopy(this.a, this.c, bArr, i, max);
                            this.c += max;
                            i += max;
                            i2 -= max;
                            if (i2 == 0) {
                                return max;
                            }
                        }
                        try {
                            this.d.Z = bArr;
                            this.d.U = i;
                            this.d.V = i2;
                            this.d.W = 0;
                            sgc.i(this.d);
                            if (this.d.W == 0) {
                                return -1;
                            }
                            return this.d.W + max;
                        } catch (BrotliRuntimeException e) {
                            throw new IOException("Brotli stream decoding failed", e);
                        }
                    }
                    throw new IllegalArgumentException("Buffer overflow: " + i3 + " > " + bArr.length);
                }
                throw new IllegalArgumentException("Bad length: " + i2);
            }
            throw new IllegalArgumentException("Bad offset: " + i);
        }
        return invokeLII.intValue;
    }
}
