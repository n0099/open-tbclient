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
public final class yv9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final fw9 c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public yv9() {
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
        this.c = new fw9();
        this.i = 0;
    }

    public static void a(yv9 yv9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, yv9Var, z) != null) || !yv9Var.e) {
            return;
        }
        int i = ((yv9Var.h << 2) + ((yv9Var.g + 7) >> 3)) - 8;
        int i2 = yv9Var.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(yv9 yv9Var, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, yv9Var, inputStream) == null) {
            if (yv9Var.d == null) {
                fw9.b(yv9Var.c, yv9Var.a, yv9Var.b);
                yv9Var.d = inputStream;
                yv9Var.f = 0L;
                yv9Var.g = 64;
                yv9Var.h = 1024;
                yv9Var.e = false;
                h(yv9Var);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(yv9 yv9Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, yv9Var) == null) {
            InputStream inputStream = yv9Var.d;
            yv9Var.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(yv9 yv9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, yv9Var) == null) && (i = yv9Var.g) >= 32) {
            int[] iArr = yv9Var.b;
            int i2 = yv9Var.h;
            yv9Var.h = i2 + 1;
            yv9Var.f = (iArr[i2] << 32) | (yv9Var.f >>> 32);
            yv9Var.g = i - 32;
        }
    }

    public static int f(yv9 yv9Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, yv9Var)) == null) {
            if (yv9Var.e) {
                i = (yv9Var.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - yv9Var.h;
        }
        return invokeL.intValue;
    }

    public static void g(yv9 yv9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, yv9Var) == null) && (i = (64 - yv9Var.g) & 7) != 0 && i(yv9Var, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(yv9 yv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, yv9Var) == null) {
            j(yv9Var);
            a(yv9Var, false);
            d(yv9Var);
            d(yv9Var);
        }
    }

    public static void k(yv9 yv9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, yv9Var) == null) && yv9Var.g == 64) {
            h(yv9Var);
        }
    }

    public static void c(yv9 yv9Var, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, yv9Var, bArr, i, i2) == null) {
            if ((yv9Var.g & 7) == 0) {
                while (true) {
                    int i3 = yv9Var.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (yv9Var.f >>> i3);
                    yv9Var.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(yv9Var), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(yv9Var.a, yv9Var.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    yv9Var.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(yv9Var) > 0) {
                    d(yv9Var);
                    while (i2 != 0) {
                        long j = yv9Var.f;
                        int i5 = yv9Var.g;
                        bArr[i] = (byte) (j >>> i5);
                        yv9Var.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(yv9Var, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = yv9Var.d.read(bArr, i, i2);
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

    public static int i(yv9 yv9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, yv9Var, i)) == null) {
            d(yv9Var);
            long j = yv9Var.f;
            int i2 = yv9Var.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            yv9Var.g = i2 + i;
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
    public static void j(yv9 yv9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, yv9Var) != null) || (i = yv9Var.h) <= 1015) {
            return;
        }
        if (yv9Var.e) {
            if (f(yv9Var) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = yv9Var.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        yv9Var.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = yv9Var.d.read(yv9Var.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        fw9.a(yv9Var.c, i3 >> 2);
    }
}
