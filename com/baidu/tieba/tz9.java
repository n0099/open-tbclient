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
public final class tz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final a0a c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public tz9() {
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
        this.c = new a0a();
        this.i = 0;
    }

    public static void a(tz9 tz9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, tz9Var, z) != null) || !tz9Var.e) {
            return;
        }
        int i = ((tz9Var.h << 2) + ((tz9Var.g + 7) >> 3)) - 8;
        int i2 = tz9Var.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(tz9 tz9Var, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, tz9Var, inputStream) == null) {
            if (tz9Var.d == null) {
                a0a.b(tz9Var.c, tz9Var.a, tz9Var.b);
                tz9Var.d = inputStream;
                tz9Var.f = 0L;
                tz9Var.g = 64;
                tz9Var.h = 1024;
                tz9Var.e = false;
                h(tz9Var);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(tz9 tz9Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, tz9Var) == null) {
            InputStream inputStream = tz9Var.d;
            tz9Var.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(tz9 tz9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tz9Var) == null) && (i = tz9Var.g) >= 32) {
            int[] iArr = tz9Var.b;
            int i2 = tz9Var.h;
            tz9Var.h = i2 + 1;
            tz9Var.f = (iArr[i2] << 32) | (tz9Var.f >>> 32);
            tz9Var.g = i - 32;
        }
    }

    public static int f(tz9 tz9Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tz9Var)) == null) {
            if (tz9Var.e) {
                i = (tz9Var.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - tz9Var.h;
        }
        return invokeL.intValue;
    }

    public static void g(tz9 tz9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, tz9Var) == null) && (i = (64 - tz9Var.g) & 7) != 0 && i(tz9Var, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(tz9 tz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, tz9Var) == null) {
            j(tz9Var);
            a(tz9Var, false);
            d(tz9Var);
            d(tz9Var);
        }
    }

    public static void k(tz9 tz9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, tz9Var) == null) && tz9Var.g == 64) {
            h(tz9Var);
        }
    }

    public static void c(tz9 tz9Var, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, tz9Var, bArr, i, i2) == null) {
            if ((tz9Var.g & 7) == 0) {
                while (true) {
                    int i3 = tz9Var.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (tz9Var.f >>> i3);
                    tz9Var.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(tz9Var), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(tz9Var.a, tz9Var.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    tz9Var.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(tz9Var) > 0) {
                    d(tz9Var);
                    while (i2 != 0) {
                        long j = tz9Var.f;
                        int i5 = tz9Var.g;
                        bArr[i] = (byte) (j >>> i5);
                        tz9Var.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(tz9Var, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = tz9Var.d.read(bArr, i, i2);
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

    public static int i(tz9 tz9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, tz9Var, i)) == null) {
            d(tz9Var);
            long j = tz9Var.f;
            int i2 = tz9Var.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            tz9Var.g = i2 + i;
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
    public static void j(tz9 tz9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, tz9Var) != null) || (i = tz9Var.h) <= 1015) {
            return;
        }
        if (tz9Var.e) {
            if (f(tz9Var) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = tz9Var.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        tz9Var.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = tz9Var.d.read(tz9Var.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        a0a.a(tz9Var.c, i3 >> 2);
    }
}
