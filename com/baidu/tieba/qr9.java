package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes5.dex */
public final class qr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final xr9 c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public qr9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new byte[4160];
        this.b = new int[1040];
        this.c = new xr9();
        this.i = 0;
    }

    public static void a(qr9 qr9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65537, null, qr9Var, z) == null) && qr9Var.e) {
            int i = ((qr9Var.h << 2) + ((qr9Var.g + 7) >> 3)) - 8;
            int i2 = qr9Var.i;
            if (i > i2) {
                throw new BrotliRuntimeException("Read after end");
            }
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
        }
    }

    public static void b(qr9 qr9Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, qr9Var) == null) {
            InputStream inputStream = qr9Var.d;
            qr9Var.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void c(qr9 qr9Var, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, qr9Var, bArr, i, i2) == null) {
            if ((qr9Var.g & 7) != 0) {
                throw new BrotliRuntimeException("Unaligned copyBytes");
            }
            while (true) {
                int i3 = qr9Var.g;
                if (i3 == 64 || i2 == 0) {
                    break;
                }
                bArr[i] = (byte) (qr9Var.f >>> i3);
                qr9Var.g = i3 + 8;
                i2--;
                i++;
            }
            if (i2 == 0) {
                return;
            }
            int min = Math.min(f(qr9Var), i2 >> 2);
            if (min > 0) {
                int i4 = min << 2;
                System.arraycopy(qr9Var.a, qr9Var.h << 2, bArr, i, i4);
                i += i4;
                i2 -= i4;
                qr9Var.h += min;
            }
            if (i2 == 0) {
                return;
            }
            if (f(qr9Var) <= 0) {
                while (i2 > 0) {
                    try {
                        int read = qr9Var.d.read(bArr, i, i2);
                        if (read == -1) {
                            throw new BrotliRuntimeException("Unexpected end of input");
                        }
                        i += read;
                        i2 -= read;
                    } catch (IOException e) {
                        throw new BrotliRuntimeException("Failed to read input", e);
                    }
                }
                return;
            }
            d(qr9Var);
            while (i2 != 0) {
                long j = qr9Var.f;
                int i5 = qr9Var.g;
                bArr[i] = (byte) (j >>> i5);
                qr9Var.g = i5 + 8;
                i2--;
                i++;
            }
            a(qr9Var, false);
        }
    }

    public static void d(qr9 qr9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, qr9Var) == null) || (i = qr9Var.g) < 32) {
            return;
        }
        int[] iArr = qr9Var.b;
        int i2 = qr9Var.h;
        qr9Var.h = i2 + 1;
        qr9Var.f = (iArr[i2] << 32) | (qr9Var.f >>> 32);
        qr9Var.g = i - 32;
    }

    public static void e(qr9 qr9Var, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, qr9Var, inputStream) == null) {
            if (qr9Var.d == null) {
                xr9.b(qr9Var.c, qr9Var.a, qr9Var.b);
                qr9Var.d = inputStream;
                qr9Var.f = 0L;
                qr9Var.g = 64;
                qr9Var.h = 1024;
                qr9Var.e = false;
                h(qr9Var);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static int f(qr9 qr9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, qr9Var)) == null) {
            return (qr9Var.e ? (qr9Var.i + 3) >> 2 : 1024) - qr9Var.h;
        }
        return invokeL.intValue;
    }

    public static void g(qr9 qr9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, qr9Var) == null) && (i = (64 - qr9Var.g) & 7) != 0 && i(qr9Var, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(qr9 qr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, qr9Var) == null) {
            j(qr9Var);
            a(qr9Var, false);
            d(qr9Var);
            d(qr9Var);
        }
    }

    public static int i(qr9 qr9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, qr9Var, i)) == null) {
            d(qr9Var);
            long j = qr9Var.f;
            int i2 = qr9Var.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            qr9Var.g = i2 + i;
            return i3;
        }
        return invokeLI.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
        r4.e = true;
        r4.i = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:
        r1 = r1 + 3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void j(qr9 qr9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, qr9Var) == null) || (i = qr9Var.h) <= 1015) {
            return;
        }
        if (qr9Var.e) {
            if (f(qr9Var) < -2) {
                throw new BrotliRuntimeException("No more input");
            }
            return;
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = qr9Var.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        qr9Var.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = qr9Var.d.read(qr9Var.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        xr9.a(qr9Var.c, i3 >> 2);
    }

    public static void k(qr9 qr9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, qr9Var) == null) && qr9Var.g == 64) {
            h(qr9Var);
        }
    }
}
