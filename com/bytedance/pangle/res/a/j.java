package com.bytedance.pangle.res.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public abstract class j extends FilterInputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(InputStream inputStream) {
        super(inputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((InputStream) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return super.available();
            } catch (IOException e) {
                throw e;
            }
        }
        return invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                ((FilterInputStream) this).in.close();
            } catch (IOException e) {
                throw e;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            synchronized (this) {
                ((FilterInputStream) this).in.mark(i);
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ((FilterInputStream) this).in.markSupported() : invokeV.booleanValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                int read = ((FilterInputStream) this).in.read();
                a(read != -1 ? 1 : -1);
                return read;
            } catch (IOException e) {
                throw e;
            }
        }
        return invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                try {
                    ((FilterInputStream) this).in.reset();
                } catch (IOException e) {
                    throw e;
                }
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            try {
                return ((FilterInputStream) this).in.skip(j);
            } catch (IOException e) {
                throw e;
            }
        }
        return invokeJ.longValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
            try {
                int read = ((FilterInputStream) this).in.read(bArr);
                a(read);
                return read;
            } catch (IOException e) {
                throw e;
            }
        }
        return invokeL.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048583, this, bArr, i, i2)) == null) {
            try {
                int read = ((FilterInputStream) this).in.read(bArr, i, i2);
                a(read);
                return read;
            } catch (IOException e) {
                throw e;
            }
        }
        return invokeLII.intValue;
    }
}
