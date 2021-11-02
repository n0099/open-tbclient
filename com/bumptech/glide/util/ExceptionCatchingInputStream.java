package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
/* loaded from: classes11.dex */
public class ExceptionCatchingInputStream extends InputStream {
    public static /* synthetic */ Interceptable $ic;
    public static final Queue<ExceptionCatchingInputStream> QUEUE;
    public transient /* synthetic */ FieldHolder $fh;
    public IOException exception;
    public InputStream wrapped;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1848655533, "Lcom/bumptech/glide/util/ExceptionCatchingInputStream;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1848655533, "Lcom/bumptech/glide/util/ExceptionCatchingInputStream;");
                return;
            }
        }
        QUEUE = Util.createQueue(0);
    }

    public ExceptionCatchingInputStream() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void clearQueue() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            while (!QUEUE.isEmpty()) {
                QUEUE.remove();
            }
        }
    }

    @NonNull
    public static ExceptionCatchingInputStream obtain(@NonNull InputStream inputStream) {
        InterceptResult invokeL;
        ExceptionCatchingInputStream poll;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, inputStream)) == null) {
            synchronized (QUEUE) {
                poll = QUEUE.poll();
            }
            if (poll == null) {
                poll = new ExceptionCatchingInputStream();
            }
            poll.setInputStream(inputStream);
            return poll;
        }
        return (ExceptionCatchingInputStream) invokeL.objValue;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.wrapped.available() : invokeV.intValue;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.wrapped.close();
        }
    }

    @Nullable
    public IOException getException() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.exception : (IOException) invokeV.objValue;
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.wrapped.mark(i2);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.wrapped.markSupported() : invokeV.booleanValue;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
            try {
                return this.wrapped.read(bArr);
            } catch (IOException e2) {
                this.exception = e2;
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.exception = null;
            this.wrapped = null;
            synchronized (QUEUE) {
                QUEUE.offer(this);
            }
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this) {
                this.wrapped.reset();
            }
        }
    }

    public void setInputStream(@NonNull InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, inputStream) == null) {
            this.wrapped = inputStream;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            try {
                return this.wrapped.skip(j);
            } catch (IOException e2) {
                this.exception = e2;
                return 0L;
            }
        }
        return invokeJ.longValue;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048583, this, bArr, i2, i3)) == null) {
            try {
                return this.wrapped.read(bArr, i2, i3);
            } catch (IOException e2) {
                this.exception = e2;
                return -1;
            }
        }
        return invokeLII.intValue;
    }

    @Override // java.io.InputStream
    public int read() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                return this.wrapped.read();
            } catch (IOException e2) {
                this.exception = e2;
                return -1;
            }
        }
        return invokeV.intValue;
    }
}
