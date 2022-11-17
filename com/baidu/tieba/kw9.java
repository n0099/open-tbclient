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
/* loaded from: classes4.dex */
public final class kw9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final rw9 c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public kw9() {
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
        this.c = new rw9();
        this.i = 0;
    }

    public static void a(kw9 kw9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, kw9Var, z) != null) || !kw9Var.e) {
            return;
        }
        int i = ((kw9Var.h << 2) + ((kw9Var.g + 7) >> 3)) - 8;
        int i2 = kw9Var.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(kw9 kw9Var, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, kw9Var, inputStream) == null) {
            if (kw9Var.d == null) {
                rw9.b(kw9Var.c, kw9Var.a, kw9Var.b);
                kw9Var.d = inputStream;
                kw9Var.f = 0L;
                kw9Var.g = 64;
                kw9Var.h = 1024;
                kw9Var.e = false;
                h(kw9Var);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(kw9 kw9Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, kw9Var) == null) {
            InputStream inputStream = kw9Var.d;
            kw9Var.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(kw9 kw9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, kw9Var) == null) && (i = kw9Var.g) >= 32) {
            int[] iArr = kw9Var.b;
            int i2 = kw9Var.h;
            kw9Var.h = i2 + 1;
            kw9Var.f = (iArr[i2] << 32) | (kw9Var.f >>> 32);
            kw9Var.g = i - 32;
        }
    }

    public static int f(kw9 kw9Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, kw9Var)) == null) {
            if (kw9Var.e) {
                i = (kw9Var.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - kw9Var.h;
        }
        return invokeL.intValue;
    }

    public static void g(kw9 kw9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, kw9Var) == null) && (i = (64 - kw9Var.g) & 7) != 0 && i(kw9Var, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(kw9 kw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, kw9Var) == null) {
            j(kw9Var);
            a(kw9Var, false);
            d(kw9Var);
            d(kw9Var);
        }
    }

    public static void k(kw9 kw9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, kw9Var) == null) && kw9Var.g == 64) {
            h(kw9Var);
        }
    }

    public static void c(kw9 kw9Var, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, kw9Var, bArr, i, i2) == null) {
            if ((kw9Var.g & 7) == 0) {
                while (true) {
                    int i3 = kw9Var.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (kw9Var.f >>> i3);
                    kw9Var.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(kw9Var), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(kw9Var.a, kw9Var.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    kw9Var.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(kw9Var) > 0) {
                    d(kw9Var);
                    while (i2 != 0) {
                        long j = kw9Var.f;
                        int i5 = kw9Var.g;
                        bArr[i] = (byte) (j >>> i5);
                        kw9Var.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(kw9Var, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = kw9Var.d.read(bArr, i, i2);
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

    public static int i(kw9 kw9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, kw9Var, i)) == null) {
            d(kw9Var);
            long j = kw9Var.f;
            int i2 = kw9Var.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            kw9Var.g = i2 + i;
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
    public static void j(kw9 kw9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, kw9Var) != null) || (i = kw9Var.h) <= 1015) {
            return;
        }
        if (kw9Var.e) {
            if (f(kw9Var) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = kw9Var.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        kw9Var.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = kw9Var.d.read(kw9Var.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        rw9.a(kw9Var.c, i3 >> 2);
    }
}
