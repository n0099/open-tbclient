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
public final class sr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final zr9 c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public sr9() {
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
        this.c = new zr9();
        this.i = 0;
    }

    public static void a(sr9 sr9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65537, null, sr9Var, z) == null) && sr9Var.e) {
            int i = ((sr9Var.h << 2) + ((sr9Var.g + 7) >> 3)) - 8;
            int i2 = sr9Var.i;
            if (i > i2) {
                throw new BrotliRuntimeException("Read after end");
            }
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
        }
    }

    public static void b(sr9 sr9Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, sr9Var) == null) {
            InputStream inputStream = sr9Var.d;
            sr9Var.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void c(sr9 sr9Var, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, sr9Var, bArr, i, i2) == null) {
            if ((sr9Var.g & 7) != 0) {
                throw new BrotliRuntimeException("Unaligned copyBytes");
            }
            while (true) {
                int i3 = sr9Var.g;
                if (i3 == 64 || i2 == 0) {
                    break;
                }
                bArr[i] = (byte) (sr9Var.f >>> i3);
                sr9Var.g = i3 + 8;
                i2--;
                i++;
            }
            if (i2 == 0) {
                return;
            }
            int min = Math.min(f(sr9Var), i2 >> 2);
            if (min > 0) {
                int i4 = min << 2;
                System.arraycopy(sr9Var.a, sr9Var.h << 2, bArr, i, i4);
                i += i4;
                i2 -= i4;
                sr9Var.h += min;
            }
            if (i2 == 0) {
                return;
            }
            if (f(sr9Var) <= 0) {
                while (i2 > 0) {
                    try {
                        int read = sr9Var.d.read(bArr, i, i2);
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
            d(sr9Var);
            while (i2 != 0) {
                long j = sr9Var.f;
                int i5 = sr9Var.g;
                bArr[i] = (byte) (j >>> i5);
                sr9Var.g = i5 + 8;
                i2--;
                i++;
            }
            a(sr9Var, false);
        }
    }

    public static void d(sr9 sr9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, sr9Var) == null) || (i = sr9Var.g) < 32) {
            return;
        }
        int[] iArr = sr9Var.b;
        int i2 = sr9Var.h;
        sr9Var.h = i2 + 1;
        sr9Var.f = (iArr[i2] << 32) | (sr9Var.f >>> 32);
        sr9Var.g = i - 32;
    }

    public static void e(sr9 sr9Var, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, sr9Var, inputStream) == null) {
            if (sr9Var.d == null) {
                zr9.b(sr9Var.c, sr9Var.a, sr9Var.b);
                sr9Var.d = inputStream;
                sr9Var.f = 0L;
                sr9Var.g = 64;
                sr9Var.h = 1024;
                sr9Var.e = false;
                h(sr9Var);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static int f(sr9 sr9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, sr9Var)) == null) {
            return (sr9Var.e ? (sr9Var.i + 3) >> 2 : 1024) - sr9Var.h;
        }
        return invokeL.intValue;
    }

    public static void g(sr9 sr9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, sr9Var) == null) && (i = (64 - sr9Var.g) & 7) != 0 && i(sr9Var, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(sr9 sr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, sr9Var) == null) {
            j(sr9Var);
            a(sr9Var, false);
            d(sr9Var);
            d(sr9Var);
        }
    }

    public static int i(sr9 sr9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, sr9Var, i)) == null) {
            d(sr9Var);
            long j = sr9Var.f;
            int i2 = sr9Var.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            sr9Var.g = i2 + i;
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
    public static void j(sr9 sr9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, sr9Var) == null) || (i = sr9Var.h) <= 1015) {
            return;
        }
        if (sr9Var.e) {
            if (f(sr9Var) < -2) {
                throw new BrotliRuntimeException("No more input");
            }
            return;
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = sr9Var.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        sr9Var.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = sr9Var.d.read(sr9Var.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        zr9.a(sr9Var.c, i3 >> 2);
    }

    public static void k(sr9 sr9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, sr9Var) == null) && sr9Var.g == 64) {
            h(sr9Var);
        }
    }
}
