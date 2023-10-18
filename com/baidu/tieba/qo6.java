package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class qo6 extends InputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ro6<byte[]> a;
    public ByteArrayInputStream b;

    public qo6(ro6<byte[]> future) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {future};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(future, "future");
        this.a = future;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b == null) {
            byte[] a = this.a.a();
            if (a == null) {
                a = new byte[0];
            }
            this.b = new ByteArrayInputStream(a);
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a();
            ByteArrayInputStream byteArrayInputStream = this.b;
            Intrinsics.checkNotNull(byteArrayInputStream);
            return byteArrayInputStream.available();
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            ByteArrayInputStream byteArrayInputStream = this.b;
            Intrinsics.checkNotNull(byteArrayInputStream);
            byteArrayInputStream.close();
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ByteArrayInputStream byteArrayInputStream = this.b;
            if (byteArrayInputStream != null) {
                return byteArrayInputStream.markSupported();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            a();
            ByteArrayInputStream byteArrayInputStream = this.b;
            Intrinsics.checkNotNull(byteArrayInputStream);
            return byteArrayInputStream.read();
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                a();
                ByteArrayInputStream byteArrayInputStream = this.b;
                Intrinsics.checkNotNull(byteArrayInputStream);
                byteArrayInputStream.reset();
            }
        }
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            synchronized (this) {
                ByteArrayInputStream byteArrayInputStream = this.b;
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.mark(i);
                }
            }
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] b) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, b)) == null) {
            Intrinsics.checkNotNullParameter(b, "b");
            a();
            ByteArrayInputStream byteArrayInputStream = this.b;
            Intrinsics.checkNotNull(byteArrayInputStream);
            return byteArrayInputStream.read(b);
        }
        return invokeL.intValue;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            a();
            ByteArrayInputStream byteArrayInputStream = this.b;
            Intrinsics.checkNotNull(byteArrayInputStream);
            return byteArrayInputStream.skip(j);
        }
        return invokeJ.longValue;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int i, int i2) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048583, this, b, i, i2)) == null) {
            Intrinsics.checkNotNullParameter(b, "b");
            a();
            ByteArrayInputStream byteArrayInputStream = this.b;
            Intrinsics.checkNotNull(byteArrayInputStream);
            return byteArrayInputStream.read(b, i, i2);
        }
        return invokeLII.intValue;
    }
}
