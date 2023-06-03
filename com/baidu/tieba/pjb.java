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
/* loaded from: classes7.dex */
public final class pjb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final wjb c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public pjb() {
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
        this.c = new wjb();
        this.i = 0;
    }

    public static void a(pjb pjbVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, pjbVar, z) != null) || !pjbVar.e) {
            return;
        }
        int i = ((pjbVar.h << 2) + ((pjbVar.g + 7) >> 3)) - 8;
        int i2 = pjbVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(pjb pjbVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, pjbVar, inputStream) == null) {
            if (pjbVar.d == null) {
                wjb.b(pjbVar.c, pjbVar.a, pjbVar.b);
                pjbVar.d = inputStream;
                pjbVar.f = 0L;
                pjbVar.g = 64;
                pjbVar.h = 1024;
                pjbVar.e = false;
                h(pjbVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(pjb pjbVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, pjbVar) == null) {
            InputStream inputStream = pjbVar.d;
            pjbVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(pjb pjbVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pjbVar) == null) && (i = pjbVar.g) >= 32) {
            int[] iArr = pjbVar.b;
            int i2 = pjbVar.h;
            pjbVar.h = i2 + 1;
            pjbVar.f = (iArr[i2] << 32) | (pjbVar.f >>> 32);
            pjbVar.g = i - 32;
        }
    }

    public static int f(pjb pjbVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, pjbVar)) == null) {
            if (pjbVar.e) {
                i = (pjbVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - pjbVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(pjb pjbVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, pjbVar) == null) && (i = (64 - pjbVar.g) & 7) != 0 && i(pjbVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(pjb pjbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, pjbVar) == null) {
            j(pjbVar);
            a(pjbVar, false);
            d(pjbVar);
            d(pjbVar);
        }
    }

    public static void k(pjb pjbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, pjbVar) == null) && pjbVar.g == 64) {
            h(pjbVar);
        }
    }

    public static void c(pjb pjbVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, pjbVar, bArr, i, i2) == null) {
            if ((pjbVar.g & 7) == 0) {
                while (true) {
                    int i3 = pjbVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (pjbVar.f >>> i3);
                    pjbVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(pjbVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(pjbVar.a, pjbVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    pjbVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(pjbVar) > 0) {
                    d(pjbVar);
                    while (i2 != 0) {
                        long j = pjbVar.f;
                        int i5 = pjbVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        pjbVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(pjbVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = pjbVar.d.read(bArr, i, i2);
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

    public static int i(pjb pjbVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, pjbVar, i)) == null) {
            d(pjbVar);
            long j = pjbVar.f;
            int i2 = pjbVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            pjbVar.g = i2 + i;
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
    public static void j(pjb pjbVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, pjbVar) != null) || (i = pjbVar.h) <= 1015) {
            return;
        }
        if (pjbVar.e) {
            if (f(pjbVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = pjbVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        pjbVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = pjbVar.d.read(pjbVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        wjb.a(pjbVar.c, i3 >> 2);
    }
}
