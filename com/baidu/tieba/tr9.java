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
/* loaded from: classes6.dex */
public class tr9 extends InputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;
    public int b;
    public int c;
    public final bs9 d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public tr9(InputStream inputStream) throws IOException {
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

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            bs9.a(this.d);
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

    public tr9(InputStream inputStream, int i, byte[] bArr) throws IOException {
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
        bs9 bs9Var = new bs9();
        this.d = bs9Var;
        if (i <= 0) {
            throw new IllegalArgumentException("Bad buffer size:" + i);
        } else if (inputStream != null) {
            this.a = new byte[i];
            this.b = 0;
            this.c = 0;
            try {
                bs9.c(bs9Var, inputStream);
                if (bArr != null) {
                    vr9.s(this.d, bArr);
                }
            } catch (BrotliRuntimeException e) {
                throw new IOException("Brotli decoder initialization failed", e);
            }
        } else {
            throw new IllegalArgumentException("source is null");
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i, i2)) == null) {
            if (i < 0) {
                throw new IllegalArgumentException("Bad offset: " + i);
            } else if (i2 >= 0) {
                int i3 = i + i2;
                if (i3 > bArr.length) {
                    throw new IllegalArgumentException("Buffer overflow: " + i3 + " > " + bArr.length);
                } else if (i2 == 0) {
                    return 0;
                } else {
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
                        vr9.i(this.d);
                        if (this.d.W == 0) {
                            return -1;
                        }
                        return this.d.W + max;
                    } catch (BrotliRuntimeException e) {
                        throw new IOException("Brotli stream decoding failed", e);
                    }
                }
            } else {
                throw new IllegalArgumentException("Bad length: " + i2);
            }
        }
        return invokeLII.intValue;
    }
}
