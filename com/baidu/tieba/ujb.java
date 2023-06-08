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
public final class ujb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final bkb c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public ujb() {
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
        this.c = new bkb();
        this.i = 0;
    }

    public static void a(ujb ujbVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, ujbVar, z) != null) || !ujbVar.e) {
            return;
        }
        int i = ((ujbVar.h << 2) + ((ujbVar.g + 7) >> 3)) - 8;
        int i2 = ujbVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(ujb ujbVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, ujbVar, inputStream) == null) {
            if (ujbVar.d == null) {
                bkb.b(ujbVar.c, ujbVar.a, ujbVar.b);
                ujbVar.d = inputStream;
                ujbVar.f = 0L;
                ujbVar.g = 64;
                ujbVar.h = 1024;
                ujbVar.e = false;
                h(ujbVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(ujb ujbVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ujbVar) == null) {
            InputStream inputStream = ujbVar.d;
            ujbVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(ujb ujbVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ujbVar) == null) && (i = ujbVar.g) >= 32) {
            int[] iArr = ujbVar.b;
            int i2 = ujbVar.h;
            ujbVar.h = i2 + 1;
            ujbVar.f = (iArr[i2] << 32) | (ujbVar.f >>> 32);
            ujbVar.g = i - 32;
        }
    }

    public static int f(ujb ujbVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, ujbVar)) == null) {
            if (ujbVar.e) {
                i = (ujbVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - ujbVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(ujb ujbVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, ujbVar) == null) && (i = (64 - ujbVar.g) & 7) != 0 && i(ujbVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(ujb ujbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, ujbVar) == null) {
            j(ujbVar);
            a(ujbVar, false);
            d(ujbVar);
            d(ujbVar);
        }
    }

    public static void k(ujb ujbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, ujbVar) == null) && ujbVar.g == 64) {
            h(ujbVar);
        }
    }

    public static void c(ujb ujbVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, ujbVar, bArr, i, i2) == null) {
            if ((ujbVar.g & 7) == 0) {
                while (true) {
                    int i3 = ujbVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (ujbVar.f >>> i3);
                    ujbVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(ujbVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(ujbVar.a, ujbVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    ujbVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(ujbVar) > 0) {
                    d(ujbVar);
                    while (i2 != 0) {
                        long j = ujbVar.f;
                        int i5 = ujbVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        ujbVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(ujbVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = ujbVar.d.read(bArr, i, i2);
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

    public static int i(ujb ujbVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, ujbVar, i)) == null) {
            d(ujbVar);
            long j = ujbVar.f;
            int i2 = ujbVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            ujbVar.g = i2 + i;
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
    public static void j(ujb ujbVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, ujbVar) != null) || (i = ujbVar.h) <= 1015) {
            return;
        }
        if (ujbVar.e) {
            if (f(ujbVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = ujbVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        ujbVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = ujbVar.d.read(ujbVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        bkb.a(ujbVar.c, i3 >> 2);
    }
}
