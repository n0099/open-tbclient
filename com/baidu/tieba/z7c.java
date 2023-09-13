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
/* loaded from: classes9.dex */
public final class z7c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final g8c c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public z7c() {
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
        this.c = new g8c();
        this.i = 0;
    }

    public static void a(z7c z7cVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, z7cVar, z) != null) || !z7cVar.e) {
            return;
        }
        int i = ((z7cVar.h << 2) + ((z7cVar.g + 7) >> 3)) - 8;
        int i2 = z7cVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(z7c z7cVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, z7cVar, inputStream) == null) {
            if (z7cVar.d == null) {
                g8c.b(z7cVar.c, z7cVar.a, z7cVar.b);
                z7cVar.d = inputStream;
                z7cVar.f = 0L;
                z7cVar.g = 64;
                z7cVar.h = 1024;
                z7cVar.e = false;
                h(z7cVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(z7c z7cVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, z7cVar) == null) {
            InputStream inputStream = z7cVar.d;
            z7cVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(z7c z7cVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, z7cVar) == null) && (i = z7cVar.g) >= 32) {
            int[] iArr = z7cVar.b;
            int i2 = z7cVar.h;
            z7cVar.h = i2 + 1;
            z7cVar.f = (iArr[i2] << 32) | (z7cVar.f >>> 32);
            z7cVar.g = i - 32;
        }
    }

    public static int f(z7c z7cVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, z7cVar)) == null) {
            if (z7cVar.e) {
                i = (z7cVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - z7cVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(z7c z7cVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, z7cVar) == null) && (i = (64 - z7cVar.g) & 7) != 0 && i(z7cVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(z7c z7cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, z7cVar) == null) {
            j(z7cVar);
            a(z7cVar, false);
            d(z7cVar);
            d(z7cVar);
        }
    }

    public static void k(z7c z7cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, z7cVar) == null) && z7cVar.g == 64) {
            h(z7cVar);
        }
    }

    public static void c(z7c z7cVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, z7cVar, bArr, i, i2) == null) {
            if ((z7cVar.g & 7) == 0) {
                while (true) {
                    int i3 = z7cVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (z7cVar.f >>> i3);
                    z7cVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(z7cVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(z7cVar.a, z7cVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    z7cVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(z7cVar) > 0) {
                    d(z7cVar);
                    while (i2 != 0) {
                        long j = z7cVar.f;
                        int i5 = z7cVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        z7cVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(z7cVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = z7cVar.d.read(bArr, i, i2);
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

    public static int i(z7c z7cVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, z7cVar, i)) == null) {
            d(z7cVar);
            long j = z7cVar.f;
            int i2 = z7cVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            z7cVar.g = i2 + i;
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
    public static void j(z7c z7cVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, z7cVar) != null) || (i = z7cVar.h) <= 1015) {
            return;
        }
        if (z7cVar.e) {
            if (f(z7cVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = z7cVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        z7cVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = z7cVar.d.read(z7cVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        g8c.a(z7cVar.c, i3 >> 2);
    }
}
