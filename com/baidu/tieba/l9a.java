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
public final class l9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final s9a c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public l9a() {
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
        this.c = new s9a();
        this.i = 0;
    }

    public static void a(l9a l9aVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, l9aVar, z) != null) || !l9aVar.e) {
            return;
        }
        int i = ((l9aVar.h << 2) + ((l9aVar.g + 7) >> 3)) - 8;
        int i2 = l9aVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(l9a l9aVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, l9aVar, inputStream) == null) {
            if (l9aVar.d == null) {
                s9a.b(l9aVar.c, l9aVar.a, l9aVar.b);
                l9aVar.d = inputStream;
                l9aVar.f = 0L;
                l9aVar.g = 64;
                l9aVar.h = 1024;
                l9aVar.e = false;
                h(l9aVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(l9a l9aVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, l9aVar) == null) {
            InputStream inputStream = l9aVar.d;
            l9aVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(l9a l9aVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, l9aVar) == null) && (i = l9aVar.g) >= 32) {
            int[] iArr = l9aVar.b;
            int i2 = l9aVar.h;
            l9aVar.h = i2 + 1;
            l9aVar.f = (iArr[i2] << 32) | (l9aVar.f >>> 32);
            l9aVar.g = i - 32;
        }
    }

    public static int f(l9a l9aVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, l9aVar)) == null) {
            if (l9aVar.e) {
                i = (l9aVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - l9aVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(l9a l9aVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, l9aVar) == null) && (i = (64 - l9aVar.g) & 7) != 0 && i(l9aVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(l9a l9aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, l9aVar) == null) {
            j(l9aVar);
            a(l9aVar, false);
            d(l9aVar);
            d(l9aVar);
        }
    }

    public static void k(l9a l9aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, l9aVar) == null) && l9aVar.g == 64) {
            h(l9aVar);
        }
    }

    public static void c(l9a l9aVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, l9aVar, bArr, i, i2) == null) {
            if ((l9aVar.g & 7) == 0) {
                while (true) {
                    int i3 = l9aVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (l9aVar.f >>> i3);
                    l9aVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(l9aVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(l9aVar.a, l9aVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    l9aVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(l9aVar) > 0) {
                    d(l9aVar);
                    while (i2 != 0) {
                        long j = l9aVar.f;
                        int i5 = l9aVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        l9aVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(l9aVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = l9aVar.d.read(bArr, i, i2);
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

    public static int i(l9a l9aVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, l9aVar, i)) == null) {
            d(l9aVar);
            long j = l9aVar.f;
            int i2 = l9aVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            l9aVar.g = i2 + i;
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
    public static void j(l9a l9aVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, l9aVar) != null) || (i = l9aVar.h) <= 1015) {
            return;
        }
        if (l9aVar.e) {
            if (f(l9aVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = l9aVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        l9aVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = l9aVar.d.read(l9aVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        s9a.a(l9aVar.c, i3 >> 2);
    }
}
