package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class lab extends InputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final kab a;
    public boolean b;
    public ByteBuffer c;
    public IOException d;

    public lab(kab kabVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kabVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = kabVar;
    }

    public void d(IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iOException) == null) {
            this.d = iOException;
            this.b = true;
            this.c = null;
        }
    }

    public final void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.b) {
                IOException iOException = this.d;
                if (iOException == null) {
                    return;
                }
                throw iOException;
            } else if (!c()) {
                if (this.c == null) {
                    this.c = ByteBuffer.allocateDirect(32768);
                }
                this.c.clear();
                this.a.v(this.c);
                IOException iOException2 = this.d;
                if (iOException2 == null) {
                    ByteBuffer byteBuffer = this.c;
                    if (byteBuffer != null) {
                        byteBuffer.flip();
                        return;
                    }
                    return;
                }
                throw iOException2;
            }
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ByteBuffer byteBuffer = this.c;
            if (byteBuffer != null && byteBuffer.hasRemaining()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            a();
            if (c()) {
                return this.c.get() & 255;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i, i2)) == null) {
            if (i >= 0 && i2 >= 0 && i + i2 <= bArr.length) {
                if (i2 == 0) {
                    return 0;
                }
                a();
                if (c()) {
                    int min = Math.min(this.c.limit() - this.c.position(), i2);
                    this.c.get(bArr, i, min);
                    return min;
                }
                return -1;
            }
            throw new IndexOutOfBoundsException();
        }
        return invokeLII.intValue;
    }
}
