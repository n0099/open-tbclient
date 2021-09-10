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

    /* renamed from: e  reason: collision with root package name */
    public PipedInputStreamAndroid25 f59437e;

    public PipedOutputStreamAndroid25() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public synchronized void a(PipedInputStreamAndroid25 pipedInputStreamAndroid25) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pipedInputStreamAndroid25) == null) {
            synchronized (this) {
                try {
                    if (pipedInputStreamAndroid25 != null) {
                        if (this.f59437e == null && !pipedInputStreamAndroid25.f59433g) {
                            this.f59437e = pipedInputStreamAndroid25;
                            pipedInputStreamAndroid25.k = -1;
                            pipedInputStreamAndroid25.l = 0;
                            pipedInputStreamAndroid25.f59433g = true;
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

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        PipedInputStreamAndroid25 pipedInputStreamAndroid25;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (pipedInputStreamAndroid25 = this.f59437e) == null) {
            return;
        }
        pipedInputStreamAndroid25.s();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.f59437e != null) {
                    synchronized (this.f59437e) {
                        this.f59437e.notifyAll();
                    }
                }
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            PipedInputStreamAndroid25 pipedInputStreamAndroid25 = this.f59437e;
            if (pipedInputStreamAndroid25 != null) {
                pipedInputStreamAndroid25.q(i2);
                return;
            }
            throw new IOException("Pipe not connected");
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, bArr, i2, i3) == null) {
            PipedInputStreamAndroid25 pipedInputStreamAndroid25 = this.f59437e;
            if (pipedInputStreamAndroid25 == null) {
                throw new IOException("Pipe not connected");
            }
            if (bArr != null) {
                if (i2 < 0 || i2 > bArr.length || i3 < 0 || (i4 = i2 + i3) > bArr.length || i4 < 0) {
                    throw new IndexOutOfBoundsException();
                }
                if (i3 == 0) {
                    return;
                }
                pipedInputStreamAndroid25.r(bArr, i2, i3);
                return;
            }
            throw null;
        }
    }
}
