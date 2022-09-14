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
public final class it9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final pt9 c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public it9() {
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
        this.c = new pt9();
        this.i = 0;
    }

    public static void a(it9 it9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65537, null, it9Var, z) == null) && it9Var.e) {
            int i = ((it9Var.h << 2) + ((it9Var.g + 7) >> 3)) - 8;
            int i2 = it9Var.i;
            if (i > i2) {
                throw new BrotliRuntimeException("Read after end");
            }
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
        }
    }

    public static void b(it9 it9Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, it9Var) == null) {
            InputStream inputStream = it9Var.d;
            it9Var.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void c(it9 it9Var, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, it9Var, bArr, i, i2) == null) {
            if ((it9Var.g & 7) != 0) {
                throw new BrotliRuntimeException("Unaligned copyBytes");
            }
            while (true) {
                int i3 = it9Var.g;
                if (i3 == 64 || i2 == 0) {
                    break;
                }
                bArr[i] = (byte) (it9Var.f >>> i3);
                it9Var.g = i3 + 8;
                i2--;
                i++;
            }
            if (i2 == 0) {
                return;
            }
            int min = Math.min(f(it9Var), i2 >> 2);
            if (min > 0) {
                int i4 = min << 2;
                System.arraycopy(it9Var.a, it9Var.h << 2, bArr, i, i4);
                i += i4;
                i2 -= i4;
                it9Var.h += min;
            }
            if (i2 == 0) {
                return;
            }
            if (f(it9Var) <= 0) {
                while (i2 > 0) {
                    try {
                        int read = it9Var.d.read(bArr, i, i2);
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
            d(it9Var);
            while (i2 != 0) {
                long j = it9Var.f;
                int i5 = it9Var.g;
                bArr[i] = (byte) (j >>> i5);
                it9Var.g = i5 + 8;
                i2--;
                i++;
            }
            a(it9Var, false);
        }
    }

    public static void d(it9 it9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, it9Var) == null) || (i = it9Var.g) < 32) {
            return;
        }
        int[] iArr = it9Var.b;
        int i2 = it9Var.h;
        it9Var.h = i2 + 1;
        it9Var.f = (iArr[i2] << 32) | (it9Var.f >>> 32);
        it9Var.g = i - 32;
    }

    public static void e(it9 it9Var, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, it9Var, inputStream) == null) {
            if (it9Var.d == null) {
                pt9.b(it9Var.c, it9Var.a, it9Var.b);
                it9Var.d = inputStream;
                it9Var.f = 0L;
                it9Var.g = 64;
                it9Var.h = 1024;
                it9Var.e = false;
                h(it9Var);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static int f(it9 it9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, it9Var)) == null) {
            return (it9Var.e ? (it9Var.i + 3) >> 2 : 1024) - it9Var.h;
        }
        return invokeL.intValue;
    }

    public static void g(it9 it9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, it9Var) == null) && (i = (64 - it9Var.g) & 7) != 0 && i(it9Var, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(it9 it9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, it9Var) == null) {
            j(it9Var);
            a(it9Var, false);
            d(it9Var);
            d(it9Var);
        }
    }

    public static int i(it9 it9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, it9Var, i)) == null) {
            d(it9Var);
            long j = it9Var.f;
            int i2 = it9Var.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            it9Var.g = i2 + i;
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
    public static void j(it9 it9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, it9Var) == null) || (i = it9Var.h) <= 1015) {
            return;
        }
        if (it9Var.e) {
            if (f(it9Var) < -2) {
                throw new BrotliRuntimeException("No more input");
            }
            return;
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = it9Var.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        it9Var.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = it9Var.d.read(it9Var.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        pt9.a(it9Var.c, i3 >> 2);
    }

    public static void k(it9 it9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, it9Var) == null) && it9Var.g == 64) {
            h(it9Var);
        }
    }
}
