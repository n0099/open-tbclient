package com.baidu.turbonet.net;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes8.dex */
public class PipedOutputStreamAndroid25 extends OutputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PipedInputStreamAndroid25 a;

    public PipedOutputStreamAndroid25() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        PipedInputStreamAndroid25 pipedInputStreamAndroid25;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (pipedInputStreamAndroid25 = this.a) != null) {
            pipedInputStreamAndroid25.j();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.a != null) {
                    synchronized (this.a) {
                        this.a.notifyAll();
                    }
                }
            }
        }
    }

    public synchronized void a(PipedInputStreamAndroid25 pipedInputStreamAndroid25) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pipedInputStreamAndroid25) == null) {
            synchronized (this) {
                try {
                    if (pipedInputStreamAndroid25 != null) {
                        if (this.a == null && !pipedInputStreamAndroid25.c) {
                            this.a = pipedInputStreamAndroid25;
                            pipedInputStreamAndroid25.g = -1;
                            pipedInputStreamAndroid25.h = 0;
                            pipedInputStreamAndroid25.c = true;
                        } else {
                            throw new IOException("Already connected");
                        }
                    } else {
                        throw new NullPointerException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            PipedInputStreamAndroid25 pipedInputStreamAndroid25 = this.a;
            if (pipedInputStreamAndroid25 != null) {
                pipedInputStreamAndroid25.f(i);
                return;
            }
            throw new IOException("Pipe not connected");
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, bArr, i, i2) == null) {
            PipedInputStreamAndroid25 pipedInputStreamAndroid25 = this.a;
            if (pipedInputStreamAndroid25 != null) {
                if (bArr != null) {
                    if (i >= 0 && i <= bArr.length && i2 >= 0 && (i3 = i + i2) <= bArr.length && i3 >= 0) {
                        if (i2 == 0) {
                            return;
                        }
                        pipedInputStreamAndroid25.g(bArr, i, i2);
                        return;
                    }
                    throw new IndexOutOfBoundsException();
                }
                throw null;
            }
            throw new IOException("Pipe not connected");
        }
    }
}
