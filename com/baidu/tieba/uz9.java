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
/* loaded from: classes6.dex */
public final class uz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final b0a c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public uz9() {
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
        this.c = new b0a();
        this.i = 0;
    }

    public static void a(uz9 uz9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, uz9Var, z) != null) || !uz9Var.e) {
            return;
        }
        int i = ((uz9Var.h << 2) + ((uz9Var.g + 7) >> 3)) - 8;
        int i2 = uz9Var.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(uz9 uz9Var, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, uz9Var, inputStream) == null) {
            if (uz9Var.d == null) {
                b0a.b(uz9Var.c, uz9Var.a, uz9Var.b);
                uz9Var.d = inputStream;
                uz9Var.f = 0L;
                uz9Var.g = 64;
                uz9Var.h = 1024;
                uz9Var.e = false;
                h(uz9Var);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(uz9 uz9Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, uz9Var) == null) {
            InputStream inputStream = uz9Var.d;
            uz9Var.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(uz9 uz9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, uz9Var) == null) && (i = uz9Var.g) >= 32) {
            int[] iArr = uz9Var.b;
            int i2 = uz9Var.h;
            uz9Var.h = i2 + 1;
            uz9Var.f = (iArr[i2] << 32) | (uz9Var.f >>> 32);
            uz9Var.g = i - 32;
        }
    }

    public static int f(uz9 uz9Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, uz9Var)) == null) {
            if (uz9Var.e) {
                i = (uz9Var.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - uz9Var.h;
        }
        return invokeL.intValue;
    }

    public static void g(uz9 uz9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, uz9Var) == null) && (i = (64 - uz9Var.g) & 7) != 0 && i(uz9Var, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(uz9 uz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, uz9Var) == null) {
            j(uz9Var);
            a(uz9Var, false);
            d(uz9Var);
            d(uz9Var);
        }
    }

    public static void k(uz9 uz9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, uz9Var) == null) && uz9Var.g == 64) {
            h(uz9Var);
        }
    }

    public static void c(uz9 uz9Var, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, uz9Var, bArr, i, i2) == null) {
            if ((uz9Var.g & 7) == 0) {
                while (true) {
                    int i3 = uz9Var.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (uz9Var.f >>> i3);
                    uz9Var.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(uz9Var), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(uz9Var.a, uz9Var.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    uz9Var.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(uz9Var) > 0) {
                    d(uz9Var);
                    while (i2 != 0) {
                        long j = uz9Var.f;
                        int i5 = uz9Var.g;
                        bArr[i] = (byte) (j >>> i5);
                        uz9Var.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(uz9Var, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = uz9Var.d.read(bArr, i, i2);
                        if (read != -1) {
                            i += read;
                            i2 -= read;
                        } else {
                            throw new BrotliRuntimeException("Unexpected end of input");
                        }
                    } catch (IOException e) {
                        throw new BrotliRuntimeException("Failed to read input", e);
                    }
                }
                return;
            }
            throw new BrotliRuntimeException("Unaligned copyBytes");
        }
    }

    public static int i(uz9 uz9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, uz9Var, i)) == null) {
            d(uz9Var);
            long j = uz9Var.f;
            int i2 = uz9Var.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            uz9Var.g = i2 + i;
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
    public static void j(uz9 uz9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, uz9Var) != null) || (i = uz9Var.h) <= 1015) {
            return;
        }
        if (uz9Var.e) {
            if (f(uz9Var) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = uz9Var.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        uz9Var.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = uz9Var.d.read(uz9Var.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        b0a.a(uz9Var.c, i3 >> 2);
    }
}
