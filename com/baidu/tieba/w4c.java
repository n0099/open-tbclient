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
public final class w4c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final d5c c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public w4c() {
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
        this.c = new d5c();
        this.i = 0;
    }

    public static void a(w4c w4cVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, w4cVar, z) != null) || !w4cVar.e) {
            return;
        }
        int i = ((w4cVar.h << 2) + ((w4cVar.g + 7) >> 3)) - 8;
        int i2 = w4cVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(w4c w4cVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, w4cVar, inputStream) == null) {
            if (w4cVar.d == null) {
                d5c.b(w4cVar.c, w4cVar.a, w4cVar.b);
                w4cVar.d = inputStream;
                w4cVar.f = 0L;
                w4cVar.g = 64;
                w4cVar.h = 1024;
                w4cVar.e = false;
                h(w4cVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(w4c w4cVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, w4cVar) == null) {
            InputStream inputStream = w4cVar.d;
            w4cVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(w4c w4cVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, w4cVar) == null) && (i = w4cVar.g) >= 32) {
            int[] iArr = w4cVar.b;
            int i2 = w4cVar.h;
            w4cVar.h = i2 + 1;
            w4cVar.f = (iArr[i2] << 32) | (w4cVar.f >>> 32);
            w4cVar.g = i - 32;
        }
    }

    public static int f(w4c w4cVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, w4cVar)) == null) {
            if (w4cVar.e) {
                i = (w4cVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - w4cVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(w4c w4cVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, w4cVar) == null) && (i = (64 - w4cVar.g) & 7) != 0 && i(w4cVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(w4c w4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, w4cVar) == null) {
            j(w4cVar);
            a(w4cVar, false);
            d(w4cVar);
            d(w4cVar);
        }
    }

    public static void k(w4c w4cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, w4cVar) == null) && w4cVar.g == 64) {
            h(w4cVar);
        }
    }

    public static void c(w4c w4cVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, w4cVar, bArr, i, i2) == null) {
            if ((w4cVar.g & 7) == 0) {
                while (true) {
                    int i3 = w4cVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (w4cVar.f >>> i3);
                    w4cVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(w4cVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(w4cVar.a, w4cVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    w4cVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(w4cVar) > 0) {
                    d(w4cVar);
                    while (i2 != 0) {
                        long j = w4cVar.f;
                        int i5 = w4cVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        w4cVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(w4cVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = w4cVar.d.read(bArr, i, i2);
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

    public static int i(w4c w4cVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, w4cVar, i)) == null) {
            d(w4cVar);
            long j = w4cVar.f;
            int i2 = w4cVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            w4cVar.g = i2 + i;
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
    public static void j(w4c w4cVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, w4cVar) != null) || (i = w4cVar.h) <= 1015) {
            return;
        }
        if (w4cVar.e) {
            if (f(w4cVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = w4cVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        w4cVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = w4cVar.d.read(w4cVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        d5c.a(w4cVar.c, i3 >> 2);
    }
}
