package com.baidu.turbonet.net;

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
import java.io.InterruptedIOException;
/* loaded from: classes6.dex */
public class PipedInputStreamAndroid25 extends InputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public volatile boolean b;
    public boolean c;
    public Thread d;
    public Thread e;
    public byte[] f;
    public int g;
    public int h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-592226159, "Lcom/baidu/turbonet/net/PipedInputStreamAndroid25;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-592226159, "Lcom/baidu/turbonet/net/PipedInputStreamAndroid25;");
            }
        }
    }

    public PipedInputStreamAndroid25(PipedOutputStreamAndroid25 pipedOutputStreamAndroid25, int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pipedOutputStreamAndroid25, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = false;
        this.c = false;
        this.g = -1;
        this.h = 0;
        e(i);
        d(pipedOutputStreamAndroid25);
    }

    public final void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            while (this.g == this.h) {
                c();
                notifyAll();
                try {
                    wait(1000L);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException();
                }
            }
        }
    }

    @Override // java.io.InputStream
    public synchronized int available() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                if (this.g < 0) {
                    return 0;
                }
                if (this.g == this.h) {
                    return this.f.length;
                }
                if (this.g > this.h) {
                    return this.g - this.h;
                }
                return (this.g + this.f.length) - this.h;
            }
        }
        return invokeV.intValue;
    }

    public final void c() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.c) {
                if (!this.a && !this.b) {
                    Thread thread = this.d;
                    if (thread != null && !thread.isAlive()) {
                        throw new IOException("Read end dead");
                    }
                    return;
                }
                throw new IOException("Pipe closed");
            }
            throw new IOException("Pipe not connected");
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b = true;
            synchronized (this) {
                this.g = -1;
            }
        }
    }

    public void d(PipedOutputStreamAndroid25 pipedOutputStreamAndroid25) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pipedOutputStreamAndroid25) == null) {
            pipedOutputStreamAndroid25.a(this);
        }
    }

    public final void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            if (i > 0) {
                this.f = new byte[i];
                return;
            }
            throw new IllegalArgumentException("Pipe Size <= 0");
        }
    }

    public synchronized void f(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            synchronized (this) {
                c();
                this.e = Thread.currentThread();
                if (this.g == this.h) {
                    a();
                }
                if (this.g < 0) {
                    this.g = 0;
                    this.h = 0;
                }
                byte[] bArr = this.f;
                int i2 = this.g;
                int i3 = i2 + 1;
                this.g = i3;
                bArr[i2] = (byte) (i & 255);
                if (i3 >= this.f.length) {
                    this.g = 0;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0057 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x000e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048583, this, bArr, i, i2) == null) {
            synchronized (this) {
                c();
                this.e = Thread.currentThread();
                while (i2 > 0) {
                    if (this.g == this.h) {
                        a();
                    }
                    if (this.h < this.g) {
                        i4 = this.f.length;
                        i5 = this.g;
                    } else {
                        if (this.g >= this.h) {
                            i3 = 0;
                        } else if (this.g == -1) {
                            this.h = 0;
                            this.g = 0;
                            i3 = this.f.length - 0;
                        } else {
                            i4 = this.h;
                            i5 = this.g;
                        }
                        if (i3 > i2) {
                            i3 = i2;
                        }
                        System.arraycopy(bArr, i, this.f, this.g, i3);
                        i2 -= i3;
                        i += i3;
                        i6 = this.g + i3;
                        this.g = i6;
                        if (i6 < this.f.length) {
                            this.g = 0;
                        }
                    }
                    i3 = i4 - i5;
                    if (i3 > i2) {
                    }
                    System.arraycopy(bArr, i, this.f, this.g, i3);
                    i2 -= i3;
                    i += i3;
                    i6 = this.g + i3;
                    this.g = i6;
                    if (i6 < this.f.length) {
                    }
                }
            }
        }
    }

    public synchronized void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                this.a = true;
                notifyAll();
            }
        }
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                if (this.c) {
                    if (!this.b) {
                        if (this.e != null && !this.e.isAlive() && !this.a && this.g < 0) {
                            throw new IOException("Write end dead");
                        }
                        this.d = Thread.currentThread();
                        int i = 2;
                        while (this.g < 0) {
                            if (this.a) {
                                return -1;
                            }
                            if (this.e != null && !this.e.isAlive() && i - 1 < 0) {
                                throw new IOException("Pipe broken");
                            }
                            notifyAll();
                            try {
                                wait(1000L);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                throw new InterruptedIOException();
                            }
                        }
                        byte[] bArr = this.f;
                        int i2 = this.h;
                        int i3 = i2 + 1;
                        this.h = i3;
                        int i4 = bArr[i2] & 255;
                        if (i3 >= this.f.length) {
                            this.h = 0;
                        }
                        if (this.g == this.h) {
                            this.g = -1;
                        }
                        return i4;
                    }
                    throw new IOException("Pipe closed");
                }
                throw new IOException("Pipe not connected");
            }
        }
        return invokeV.intValue;
    }

    public PipedInputStreamAndroid25() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = false;
        this.c = false;
        this.g = -1;
        this.h = 0;
        e(1024);
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        InterceptResult invokeLII;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048586, this, bArr, i, i2)) == null) {
            synchronized (this) {
                if (bArr != null) {
                    if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
                        throw new IndexOutOfBoundsException();
                    }
                    if (i2 == 0) {
                        return 0;
                    }
                    int read = read();
                    if (read < 0) {
                        return -1;
                    }
                    bArr[i] = (byte) read;
                    int i3 = 1;
                    while (this.g >= 0 && i2 > 1) {
                        if (this.g > this.h) {
                            length = Math.min(this.f.length - this.h, this.g - this.h);
                        } else {
                            length = this.f.length - this.h;
                        }
                        int i4 = i2 - 1;
                        if (length > i4) {
                            length = i4;
                        }
                        System.arraycopy(this.f, this.h, bArr, i + i3, length);
                        int i5 = this.h + length;
                        this.h = i5;
                        i3 += length;
                        i2 -= length;
                        if (i5 >= this.f.length) {
                            this.h = 0;
                        }
                        if (this.g == this.h) {
                            this.g = -1;
                        }
                    }
                    return i3;
                }
                throw new NullPointerException();
            }
        }
        return invokeLII.intValue;
    }
}
