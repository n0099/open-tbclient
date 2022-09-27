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
public final class xt9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final eu9 c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public xt9() {
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
        this.c = new eu9();
        this.i = 0;
    }

    public static void a(xt9 xt9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65537, null, xt9Var, z) == null) && xt9Var.e) {
            int i = ((xt9Var.h << 2) + ((xt9Var.g + 7) >> 3)) - 8;
            int i2 = xt9Var.i;
            if (i > i2) {
                throw new BrotliRuntimeException("Read after end");
            }
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
        }
    }

    public static void b(xt9 xt9Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, xt9Var) == null) {
            InputStream inputStream = xt9Var.d;
            xt9Var.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void c(xt9 xt9Var, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, xt9Var, bArr, i, i2) == null) {
            if ((xt9Var.g & 7) != 0) {
                throw new BrotliRuntimeException("Unaligned copyBytes");
            }
            while (true) {
                int i3 = xt9Var.g;
                if (i3 == 64 || i2 == 0) {
                    break;
                }
                bArr[i] = (byte) (xt9Var.f >>> i3);
                xt9Var.g = i3 + 8;
                i2--;
                i++;
            }
            if (i2 == 0) {
                return;
            }
            int min = Math.min(f(xt9Var), i2 >> 2);
            if (min > 0) {
                int i4 = min << 2;
                System.arraycopy(xt9Var.a, xt9Var.h << 2, bArr, i, i4);
                i += i4;
                i2 -= i4;
                xt9Var.h += min;
            }
            if (i2 == 0) {
                return;
            }
            if (f(xt9Var) <= 0) {
                while (i2 > 0) {
                    try {
                        int read = xt9Var.d.read(bArr, i, i2);
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
            d(xt9Var);
            while (i2 != 0) {
                long j = xt9Var.f;
                int i5 = xt9Var.g;
                bArr[i] = (byte) (j >>> i5);
                xt9Var.g = i5 + 8;
                i2--;
                i++;
            }
            a(xt9Var, false);
        }
    }

    public static void d(xt9 xt9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, xt9Var) == null) || (i = xt9Var.g) < 32) {
            return;
        }
        int[] iArr = xt9Var.b;
        int i2 = xt9Var.h;
        xt9Var.h = i2 + 1;
        xt9Var.f = (iArr[i2] << 32) | (xt9Var.f >>> 32);
        xt9Var.g = i - 32;
    }

    public static void e(xt9 xt9Var, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, xt9Var, inputStream) == null) {
            if (xt9Var.d == null) {
                eu9.b(xt9Var.c, xt9Var.a, xt9Var.b);
                xt9Var.d = inputStream;
                xt9Var.f = 0L;
                xt9Var.g = 64;
                xt9Var.h = 1024;
                xt9Var.e = false;
                h(xt9Var);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static int f(xt9 xt9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, xt9Var)) == null) {
            return (xt9Var.e ? (xt9Var.i + 3) >> 2 : 1024) - xt9Var.h;
        }
        return invokeL.intValue;
    }

    public static void g(xt9 xt9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, xt9Var) == null) && (i = (64 - xt9Var.g) & 7) != 0 && i(xt9Var, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(xt9 xt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, xt9Var) == null) {
            j(xt9Var);
            a(xt9Var, false);
            d(xt9Var);
            d(xt9Var);
        }
    }

    public static int i(xt9 xt9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, xt9Var, i)) == null) {
            d(xt9Var);
            long j = xt9Var.f;
            int i2 = xt9Var.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            xt9Var.g = i2 + i;
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
    public static void j(xt9 xt9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, xt9Var) == null) || (i = xt9Var.h) <= 1015) {
            return;
        }
        if (xt9Var.e) {
            if (f(xt9Var) < -2) {
                throw new BrotliRuntimeException("No more input");
            }
            return;
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = xt9Var.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        xt9Var.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = xt9Var.d.read(xt9Var.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        eu9.a(xt9Var.c, i3 >> 2);
    }

    public static void k(xt9 xt9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, xt9Var) == null) && xt9Var.g == 64) {
            h(xt9Var);
        }
    }
}
