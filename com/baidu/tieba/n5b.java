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
public final class n5b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final u5b c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public n5b() {
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
        this.c = new u5b();
        this.i = 0;
    }

    public static void a(n5b n5bVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, n5bVar, z) != null) || !n5bVar.e) {
            return;
        }
        int i = ((n5bVar.h << 2) + ((n5bVar.g + 7) >> 3)) - 8;
        int i2 = n5bVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(n5b n5bVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, n5bVar, inputStream) == null) {
            if (n5bVar.d == null) {
                u5b.b(n5bVar.c, n5bVar.a, n5bVar.b);
                n5bVar.d = inputStream;
                n5bVar.f = 0L;
                n5bVar.g = 64;
                n5bVar.h = 1024;
                n5bVar.e = false;
                h(n5bVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(n5b n5bVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, n5bVar) == null) {
            InputStream inputStream = n5bVar.d;
            n5bVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(n5b n5bVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, n5bVar) == null) && (i = n5bVar.g) >= 32) {
            int[] iArr = n5bVar.b;
            int i2 = n5bVar.h;
            n5bVar.h = i2 + 1;
            n5bVar.f = (iArr[i2] << 32) | (n5bVar.f >>> 32);
            n5bVar.g = i - 32;
        }
    }

    public static int f(n5b n5bVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, n5bVar)) == null) {
            if (n5bVar.e) {
                i = (n5bVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - n5bVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(n5b n5bVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, n5bVar) == null) && (i = (64 - n5bVar.g) & 7) != 0 && i(n5bVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(n5b n5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, n5bVar) == null) {
            j(n5bVar);
            a(n5bVar, false);
            d(n5bVar);
            d(n5bVar);
        }
    }

    public static void k(n5b n5bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, n5bVar) == null) && n5bVar.g == 64) {
            h(n5bVar);
        }
    }

    public static void c(n5b n5bVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, n5bVar, bArr, i, i2) == null) {
            if ((n5bVar.g & 7) == 0) {
                while (true) {
                    int i3 = n5bVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (n5bVar.f >>> i3);
                    n5bVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(n5bVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(n5bVar.a, n5bVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    n5bVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(n5bVar) > 0) {
                    d(n5bVar);
                    while (i2 != 0) {
                        long j = n5bVar.f;
                        int i5 = n5bVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        n5bVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(n5bVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = n5bVar.d.read(bArr, i, i2);
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

    public static int i(n5b n5bVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, n5bVar, i)) == null) {
            d(n5bVar);
            long j = n5bVar.f;
            int i2 = n5bVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            n5bVar.g = i2 + i;
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
    public static void j(n5b n5bVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, n5bVar) != null) || (i = n5bVar.h) <= 1015) {
            return;
        }
        if (n5bVar.e) {
            if (f(n5bVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = n5bVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        n5bVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = n5bVar.d.read(n5bVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        u5b.a(n5bVar.c, i3 >> 2);
    }
}
