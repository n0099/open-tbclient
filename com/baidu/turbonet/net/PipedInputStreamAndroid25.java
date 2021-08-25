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
/* loaded from: classes8.dex */
public class PipedInputStreamAndroid25 extends InputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59251e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f59252f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59253g;

    /* renamed from: h  reason: collision with root package name */
    public Thread f59254h;

    /* renamed from: i  reason: collision with root package name */
    public Thread f59255i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f59256j;
    public int k;
    public int l;

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

    public PipedInputStreamAndroid25(PipedOutputStreamAndroid25 pipedOutputStreamAndroid25, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pipedOutputStreamAndroid25, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f59251e = false;
        this.f59252f = false;
        this.f59253g = false;
        this.k = -1;
        this.l = 0;
        p(i2);
        o(pipedOutputStreamAndroid25);
    }

    @Override // java.io.InputStream
    public synchronized int available() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.k < 0) {
                    return 0;
                }
                if (this.k == this.l) {
                    return this.f59256j.length;
                }
                if (this.k > this.l) {
                    return this.k - this.l;
                }
                return (this.k + this.f59256j.length) - this.l;
            }
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f59252f = true;
            synchronized (this) {
                this.k = -1;
            }
        }
    }

    public final void g() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            while (this.k == this.l) {
                n();
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

    public final void n() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f59253g) {
                if (!this.f59251e && !this.f59252f) {
                    Thread thread = this.f59254h;
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

    public void o(PipedOutputStreamAndroid25 pipedOutputStreamAndroid25) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pipedOutputStreamAndroid25) == null) {
            pipedOutputStreamAndroid25.a(this);
        }
    }

    public final void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (i2 > 0) {
                this.f59256j = new byte[i2];
                return;
            }
            throw new IllegalArgumentException("Pipe Size <= 0");
        }
    }

    public synchronized void q(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            synchronized (this) {
                n();
                this.f59255i = Thread.currentThread();
                if (this.k == this.l) {
                    g();
                }
                if (this.k < 0) {
                    this.k = 0;
                    this.l = 0;
                }
                byte[] bArr = this.f59256j;
                int i3 = this.k;
                int i4 = i3 + 1;
                this.k = i4;
                bArr[i3] = (byte) (i2 & 255);
                if (i4 >= this.f59256j.length) {
                    this.k = 0;
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
    public synchronized void r(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048583, this, bArr, i2, i3) == null) {
            synchronized (this) {
                n();
                this.f59255i = Thread.currentThread();
                while (i3 > 0) {
                    if (this.k == this.l) {
                        g();
                    }
                    if (this.l < this.k) {
                        i5 = this.f59256j.length;
                        i6 = this.k;
                    } else {
                        if (this.k >= this.l) {
                            i4 = 0;
                        } else if (this.k == -1) {
                            this.l = 0;
                            this.k = 0;
                            i4 = this.f59256j.length - 0;
                        } else {
                            i5 = this.l;
                            i6 = this.k;
                        }
                        if (i4 > i3) {
                            i4 = i3;
                        }
                        System.arraycopy(bArr, i2, this.f59256j, this.k, i4);
                        i3 -= i4;
                        i2 += i4;
                        i7 = this.k + i4;
                        this.k = i7;
                        if (i7 < this.f59256j.length) {
                            this.k = 0;
                        }
                    }
                    i4 = i5 - i6;
                    if (i4 > i3) {
                    }
                    System.arraycopy(bArr, i2, this.f59256j, this.k, i4);
                    i3 -= i4;
                    i2 += i4;
                    i7 = this.k + i4;
                    this.k = i7;
                    if (i7 < this.f59256j.length) {
                    }
                }
            }
        }
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                if (this.f59253g) {
                    if (!this.f59252f) {
                        if (this.f59255i != null && !this.f59255i.isAlive() && !this.f59251e && this.k < 0) {
                            throw new IOException("Write end dead");
                        }
                        this.f59254h = Thread.currentThread();
                        int i2 = 2;
                        while (this.k < 0) {
                            if (this.f59251e) {
                                return -1;
                            }
                            if (this.f59255i != null && !this.f59255i.isAlive() && i2 - 1 < 0) {
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
                        byte[] bArr = this.f59256j;
                        int i3 = this.l;
                        int i4 = i3 + 1;
                        this.l = i4;
                        int i5 = bArr[i3] & 255;
                        if (i4 >= this.f59256j.length) {
                            this.l = 0;
                        }
                        if (this.k == this.l) {
                            this.k = -1;
                        }
                        return i5;
                    }
                    throw new IOException("Pipe closed");
                }
                throw new IOException("Pipe not connected");
            }
        }
        return invokeV.intValue;
    }

    public synchronized void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                this.f59251e = true;
                notifyAll();
            }
        }
    }

    public PipedInputStreamAndroid25() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f59251e = false;
        this.f59252f = false;
        this.f59253g = false;
        this.k = -1;
        this.l = 0;
        p(1024);
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048585, this, bArr, i2, i3)) == null) {
            synchronized (this) {
                if (bArr != null) {
                    if (i2 < 0 || i3 < 0 || i3 > bArr.length - i2) {
                        throw new IndexOutOfBoundsException();
                    }
                    if (i3 == 0) {
                        return 0;
                    }
                    int read = read();
                    if (read < 0) {
                        return -1;
                    }
                    bArr[i2] = (byte) read;
                    int i4 = 1;
                    while (this.k >= 0 && i3 > 1) {
                        if (this.k > this.l) {
                            length = Math.min(this.f59256j.length - this.l, this.k - this.l);
                        } else {
                            length = this.f59256j.length - this.l;
                        }
                        int i5 = i3 - 1;
                        if (length > i5) {
                            length = i5;
                        }
                        System.arraycopy(this.f59256j, this.l, bArr, i2 + i4, length);
                        int i6 = this.l + length;
                        this.l = i6;
                        i4 += length;
                        i3 -= length;
                        if (i6 >= this.f59256j.length) {
                            this.l = 0;
                        }
                        if (this.k == this.l) {
                            this.k = -1;
                        }
                    }
                    return i4;
                }
                throw new NullPointerException();
            }
        }
        return invokeLII.intValue;
    }
}
