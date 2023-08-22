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
/* loaded from: classes8.dex */
public final class u4c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final b5c c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public u4c() {
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
        this.c = new b5c();
        this.i = 0;
    }

    public static void a(u4c u4cVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, u4cVar, z) != null) || !u4cVar.e) {
            return;
        }
        int i = ((u4cVar.h << 2) + ((u4cVar.g + 7) >> 3)) - 8;
        int i2 = u4cVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(u4c u4cVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, u4cVar, inputStream) == null) {
            if (u4cVar.d == null) {
                b5c.b(u4cVar.c, u4cVar.a, u4cVar.b);
                u4cVar.d = inputStream;
                u4cVar.f = 0L;
                u4cVar.g = 64;
                u4cVar.h = 1024;
                u4cVar.e = false;
                h(u4cVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(u4c u4cVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, u4cVar) == null) {
            InputStream inputStream = u4cVar.d;
            u4cVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(u4c u4cVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, u4cVar) == null) && (i = u4cVar.g) >= 32) {
            int[] iArr = u4cVar.b;
            int i2 = u4cVar.h;
            u4cVar.h = i2 + 1;
            u4cVar.f = (iArr[i2] << 32) | (u4cVar.f >>> 32);
            u4cVar.g = i - 32;
        }
    }

    public static int f(u4c u4cVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, u4cVar)) == null) {
            if (u4cVar.e) {
                i = (u4cVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - u4cVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(u4c u4cVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, u4cVar) == null) && (i = (64 - u4cVar.g) & 7) != 0 && i(u4cVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(u4c u4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, u4cVar) == null) {
            j(u4cVar);
            a(u4cVar, false);
            d(u4cVar);
            d(u4cVar);
        }
    }

    public static void k(u4c u4cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, u4cVar) == null) && u4cVar.g == 64) {
            h(u4cVar);
        }
    }

    public static void c(u4c u4cVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, u4cVar, bArr, i, i2) == null) {
            if ((u4cVar.g & 7) == 0) {
                while (true) {
                    int i3 = u4cVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (u4cVar.f >>> i3);
                    u4cVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(u4cVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(u4cVar.a, u4cVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    u4cVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(u4cVar) > 0) {
                    d(u4cVar);
                    while (i2 != 0) {
                        long j = u4cVar.f;
                        int i5 = u4cVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        u4cVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(u4cVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = u4cVar.d.read(bArr, i, i2);
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

    public static int i(u4c u4cVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, u4cVar, i)) == null) {
            d(u4cVar);
            long j = u4cVar.f;
            int i2 = u4cVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            u4cVar.g = i2 + i;
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
    public static void j(u4c u4cVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, u4cVar) != null) || (i = u4cVar.h) <= 1015) {
            return;
        }
        if (u4cVar.e) {
            if (f(u4cVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = u4cVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        u4cVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = u4cVar.d.read(u4cVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        b5c.a(u4cVar.c, i3 >> 2);
    }
}
