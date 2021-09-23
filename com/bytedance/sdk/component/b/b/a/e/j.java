package com.bytedance.sdk.component.b.b.a.e;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.a.e.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes9.dex */
public final class j implements Closeable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f65058b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.b f65059a;

    /* renamed from: c  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.a.d f65060c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f65061d;

    /* renamed from: e  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.a.c f65062e;

    /* renamed from: f  reason: collision with root package name */
    public int f65063f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f65064g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-952269624, "Lcom/bytedance/sdk/component/b/b/a/e/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-952269624, "Lcom/bytedance/sdk/component/b/b/a/e/j;");
                return;
            }
        }
        f65058b = Logger.getLogger(e.class.getName());
    }

    public j(com.bytedance.sdk.component.b.a.d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f65060c = dVar;
        this.f65061d = z;
        com.bytedance.sdk.component.b.a.c cVar = new com.bytedance.sdk.component.b.a.c();
        this.f65062e = cVar;
        this.f65059a = new d.b(cVar);
        this.f65063f = 16384;
    }

    public synchronized void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (!this.f65064g) {
                    if (this.f65061d) {
                        if (f65058b.isLoggable(Level.FINE)) {
                            f65058b.fine(com.bytedance.sdk.component.b.b.a.c.a(">> CONNECTION %s", e.f64956a.e()));
                        }
                        this.f65060c.c(e.f64956a.h());
                        this.f65060c.flush();
                        return;
                    }
                    return;
                }
                throw new IOException("closed");
            }
        }
    }

    public synchronized void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                if (!this.f65064g) {
                    this.f65060c.flush();
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f65063f : invokeV.intValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this) {
                this.f65064g = true;
                this.f65060c.close();
            }
        }
    }

    public synchronized void b(n nVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, nVar) == null) {
            synchronized (this) {
                if (!this.f65064g) {
                    int i2 = 0;
                    a(0, nVar.b() * 6, (byte) 4, (byte) 0);
                    while (i2 < 10) {
                        if (nVar.a(i2)) {
                            this.f65060c.h(i2 == 4 ? 3 : i2 == 7 ? 4 : i2);
                            this.f65060c.g(nVar.b(i2));
                        }
                        i2++;
                    }
                    this.f65060c.flush();
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void a(n nVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, nVar) == null) {
            synchronized (this) {
                if (!this.f65064g) {
                    this.f65063f = nVar.d(this.f65063f);
                    if (nVar.c() != -1) {
                        this.f65059a.a(nVar.c());
                    }
                    a(0, 0, (byte) 4, (byte) 1);
                    this.f65060c.flush();
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    private void b(int i2, long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            while (j2 > 0) {
                int min = (int) Math.min(this.f65063f, j2);
                long j3 = min;
                j2 -= j3;
                a(i2, min, (byte) 9, j2 == 0 ? (byte) 4 : (byte) 0);
                this.f65060c.a_(this.f65062e, j3);
            }
        }
    }

    public synchronized void a(int i2, int i3, List<c> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, list) == null) {
            synchronized (this) {
                if (!this.f65064g) {
                    this.f65059a.a(list);
                    long b2 = this.f65062e.b();
                    int min = (int) Math.min(this.f65063f - 4, b2);
                    long j2 = min;
                    int i4 = (b2 > j2 ? 1 : (b2 == j2 ? 0 : -1));
                    a(i2, min + 4, (byte) 5, i4 == 0 ? (byte) 4 : (byte) 0);
                    this.f65060c.g(i3 & Integer.MAX_VALUE);
                    this.f65060c.a_(this.f65062e, j2);
                    if (i4 > 0) {
                        b(i2, b2 - j2);
                    }
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void a(boolean z, int i2, int i3, List<c> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), list}) == null) {
            synchronized (this) {
                if (!this.f65064g) {
                    a(z, i2, list);
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void a(int i2, b bVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, bVar) == null) {
            synchronized (this) {
                if (!this.f65064g) {
                    if (bVar.f64926g != -1) {
                        a(i2, 4, (byte) 3, (byte) 0);
                        this.f65060c.g(bVar.f64926g);
                        this.f65060c.flush();
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void a(boolean z, int i2, com.bytedance.sdk.component.b.a.c cVar, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), cVar, Integer.valueOf(i3)}) == null) {
            synchronized (this) {
                if (!this.f65064g) {
                    a(i2, z ? (byte) 1 : (byte) 0, cVar, i3);
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public void a(int i2, byte b2, com.bytedance.sdk.component.b.a.c cVar, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Byte.valueOf(b2), cVar, Integer.valueOf(i3)}) == null) {
            a(i2, i3, (byte) 0, b2);
            if (i3 > 0) {
                this.f65060c.a_(cVar, i3);
            }
        }
    }

    public synchronized void a(boolean z, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            synchronized (this) {
                if (!this.f65064g) {
                    a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
                    this.f65060c.g(i2);
                    this.f65060c.g(i3);
                    this.f65060c.flush();
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void a(int i2, b bVar, byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i2, bVar, bArr) == null) {
            synchronized (this) {
                if (!this.f65064g) {
                    if (bVar.f64926g != -1) {
                        a(0, bArr.length + 8, (byte) 7, (byte) 0);
                        this.f65060c.g(i2);
                        this.f65060c.g(bVar.f64926g);
                        if (bArr.length > 0) {
                            this.f65060c.c(bArr);
                        }
                        this.f65060c.flush();
                    } else {
                        throw e.a("errorCode.httpCode == -1", new Object[0]);
                    }
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void a(int i2, long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            synchronized (this) {
                if (this.f65064g) {
                    throw new IOException("closed");
                }
                if (j2 != 0 && j2 <= 2147483647L) {
                    a(i2, 4, (byte) 8, (byte) 0);
                    this.f65060c.g((int) j2);
                    this.f65060c.flush();
                } else {
                    throw e.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j2));
                }
            }
        }
    }

    public void a(int i2, int i3, byte b2, byte b3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Byte.valueOf(b2), Byte.valueOf(b3)}) == null) {
            if (f65058b.isLoggable(Level.FINE)) {
                f65058b.fine(e.a(false, i2, i3, b2, b3));
            }
            int i4 = this.f65063f;
            if (i3 > i4) {
                throw e.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i4), Integer.valueOf(i3));
            }
            if ((Integer.MIN_VALUE & i2) != 0) {
                throw e.a("reserved bit set: %s", Integer.valueOf(i2));
            }
            a(this.f65060c, i3);
            this.f65060c.i(b2 & 255);
            this.f65060c.i(b3 & 255);
            this.f65060c.g(i2 & Integer.MAX_VALUE);
        }
    }

    public static void a(com.bytedance.sdk.component.b.a.d dVar, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, dVar, i2) == null) {
            dVar.i((i2 >>> 16) & 255);
            dVar.i((i2 >>> 8) & 255);
            dVar.i(i2 & 255);
        }
    }

    public void a(boolean z, int i2, List<c> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), list}) == null) {
            if (!this.f65064g) {
                this.f65059a.a(list);
                long b2 = this.f65062e.b();
                int min = (int) Math.min(this.f65063f, b2);
                long j2 = min;
                int i3 = (b2 > j2 ? 1 : (b2 == j2 ? 0 : -1));
                byte b3 = i3 == 0 ? (byte) 4 : (byte) 0;
                if (z) {
                    b3 = (byte) (b3 | 1);
                }
                a(i2, min, (byte) 1, b3);
                this.f65060c.a_(this.f65062e, j2);
                if (i3 > 0) {
                    b(i2, b2 - j2);
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }
    }
}
