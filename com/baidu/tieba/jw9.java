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
public final class jw9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final qw9 c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public jw9() {
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
        this.c = new qw9();
        this.i = 0;
    }

    public static void a(jw9 jw9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, jw9Var, z) != null) || !jw9Var.e) {
            return;
        }
        int i = ((jw9Var.h << 2) + ((jw9Var.g + 7) >> 3)) - 8;
        int i2 = jw9Var.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(jw9 jw9Var, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, jw9Var, inputStream) == null) {
            if (jw9Var.d == null) {
                qw9.b(jw9Var.c, jw9Var.a, jw9Var.b);
                jw9Var.d = inputStream;
                jw9Var.f = 0L;
                jw9Var.g = 64;
                jw9Var.h = 1024;
                jw9Var.e = false;
                h(jw9Var);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(jw9 jw9Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, jw9Var) == null) {
            InputStream inputStream = jw9Var.d;
            jw9Var.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(jw9 jw9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jw9Var) == null) && (i = jw9Var.g) >= 32) {
            int[] iArr = jw9Var.b;
            int i2 = jw9Var.h;
            jw9Var.h = i2 + 1;
            jw9Var.f = (iArr[i2] << 32) | (jw9Var.f >>> 32);
            jw9Var.g = i - 32;
        }
    }

    public static int f(jw9 jw9Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, jw9Var)) == null) {
            if (jw9Var.e) {
                i = (jw9Var.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - jw9Var.h;
        }
        return invokeL.intValue;
    }

    public static void g(jw9 jw9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, jw9Var) == null) && (i = (64 - jw9Var.g) & 7) != 0 && i(jw9Var, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(jw9 jw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, jw9Var) == null) {
            j(jw9Var);
            a(jw9Var, false);
            d(jw9Var);
            d(jw9Var);
        }
    }

    public static void k(jw9 jw9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, jw9Var) == null) && jw9Var.g == 64) {
            h(jw9Var);
        }
    }

    public static void c(jw9 jw9Var, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, jw9Var, bArr, i, i2) == null) {
            if ((jw9Var.g & 7) == 0) {
                while (true) {
                    int i3 = jw9Var.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (jw9Var.f >>> i3);
                    jw9Var.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(jw9Var), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(jw9Var.a, jw9Var.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    jw9Var.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(jw9Var) > 0) {
                    d(jw9Var);
                    while (i2 != 0) {
                        long j = jw9Var.f;
                        int i5 = jw9Var.g;
                        bArr[i] = (byte) (j >>> i5);
                        jw9Var.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(jw9Var, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = jw9Var.d.read(bArr, i, i2);
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

    public static int i(jw9 jw9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, jw9Var, i)) == null) {
            d(jw9Var);
            long j = jw9Var.f;
            int i2 = jw9Var.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            jw9Var.g = i2 + i;
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
    public static void j(jw9 jw9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, jw9Var) != null) || (i = jw9Var.h) <= 1015) {
            return;
        }
        if (jw9Var.e) {
            if (f(jw9Var) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = jw9Var.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        jw9Var.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = jw9Var.d.read(jw9Var.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        qw9.a(jw9Var.c, i3 >> 2);
    }
}
