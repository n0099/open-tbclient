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
public final class paa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final waa c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public paa() {
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
        this.c = new waa();
        this.i = 0;
    }

    public static void a(paa paaVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, paaVar, z) != null) || !paaVar.e) {
            return;
        }
        int i = ((paaVar.h << 2) + ((paaVar.g + 7) >> 3)) - 8;
        int i2 = paaVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(paa paaVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, paaVar, inputStream) == null) {
            if (paaVar.d == null) {
                waa.b(paaVar.c, paaVar.a, paaVar.b);
                paaVar.d = inputStream;
                paaVar.f = 0L;
                paaVar.g = 64;
                paaVar.h = 1024;
                paaVar.e = false;
                h(paaVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(paa paaVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, paaVar) == null) {
            InputStream inputStream = paaVar.d;
            paaVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(paa paaVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, paaVar) == null) && (i = paaVar.g) >= 32) {
            int[] iArr = paaVar.b;
            int i2 = paaVar.h;
            paaVar.h = i2 + 1;
            paaVar.f = (iArr[i2] << 32) | (paaVar.f >>> 32);
            paaVar.g = i - 32;
        }
    }

    public static int f(paa paaVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, paaVar)) == null) {
            if (paaVar.e) {
                i = (paaVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - paaVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(paa paaVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, paaVar) == null) && (i = (64 - paaVar.g) & 7) != 0 && i(paaVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(paa paaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, paaVar) == null) {
            j(paaVar);
            a(paaVar, false);
            d(paaVar);
            d(paaVar);
        }
    }

    public static void k(paa paaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, paaVar) == null) && paaVar.g == 64) {
            h(paaVar);
        }
    }

    public static void c(paa paaVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, paaVar, bArr, i, i2) == null) {
            if ((paaVar.g & 7) == 0) {
                while (true) {
                    int i3 = paaVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (paaVar.f >>> i3);
                    paaVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(paaVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(paaVar.a, paaVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    paaVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(paaVar) > 0) {
                    d(paaVar);
                    while (i2 != 0) {
                        long j = paaVar.f;
                        int i5 = paaVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        paaVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(paaVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = paaVar.d.read(bArr, i, i2);
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

    public static int i(paa paaVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, paaVar, i)) == null) {
            d(paaVar);
            long j = paaVar.f;
            int i2 = paaVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            paaVar.g = i2 + i;
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
    public static void j(paa paaVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, paaVar) != null) || (i = paaVar.h) <= 1015) {
            return;
        }
        if (paaVar.e) {
            if (f(paaVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = paaVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        paaVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = paaVar.d.read(paaVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        waa.a(paaVar.c, i3 >> 2);
    }
}
