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
public final class kza {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final rza c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public kza() {
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
        this.c = new rza();
        this.i = 0;
    }

    public static void a(kza kzaVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, kzaVar, z) != null) || !kzaVar.e) {
            return;
        }
        int i = ((kzaVar.h << 2) + ((kzaVar.g + 7) >> 3)) - 8;
        int i2 = kzaVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(kza kzaVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, kzaVar, inputStream) == null) {
            if (kzaVar.d == null) {
                rza.b(kzaVar.c, kzaVar.a, kzaVar.b);
                kzaVar.d = inputStream;
                kzaVar.f = 0L;
                kzaVar.g = 64;
                kzaVar.h = 1024;
                kzaVar.e = false;
                h(kzaVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(kza kzaVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, kzaVar) == null) {
            InputStream inputStream = kzaVar.d;
            kzaVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(kza kzaVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, kzaVar) == null) && (i = kzaVar.g) >= 32) {
            int[] iArr = kzaVar.b;
            int i2 = kzaVar.h;
            kzaVar.h = i2 + 1;
            kzaVar.f = (iArr[i2] << 32) | (kzaVar.f >>> 32);
            kzaVar.g = i - 32;
        }
    }

    public static int f(kza kzaVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, kzaVar)) == null) {
            if (kzaVar.e) {
                i = (kzaVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - kzaVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(kza kzaVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, kzaVar) == null) && (i = (64 - kzaVar.g) & 7) != 0 && i(kzaVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(kza kzaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, kzaVar) == null) {
            j(kzaVar);
            a(kzaVar, false);
            d(kzaVar);
            d(kzaVar);
        }
    }

    public static void k(kza kzaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, kzaVar) == null) && kzaVar.g == 64) {
            h(kzaVar);
        }
    }

    public static void c(kza kzaVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, kzaVar, bArr, i, i2) == null) {
            if ((kzaVar.g & 7) == 0) {
                while (true) {
                    int i3 = kzaVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (kzaVar.f >>> i3);
                    kzaVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(kzaVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(kzaVar.a, kzaVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    kzaVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(kzaVar) > 0) {
                    d(kzaVar);
                    while (i2 != 0) {
                        long j = kzaVar.f;
                        int i5 = kzaVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        kzaVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(kzaVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = kzaVar.d.read(bArr, i, i2);
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

    public static int i(kza kzaVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, kzaVar, i)) == null) {
            d(kzaVar);
            long j = kzaVar.f;
            int i2 = kzaVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            kzaVar.g = i2 + i;
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
    public static void j(kza kzaVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, kzaVar) != null) || (i = kzaVar.h) <= 1015) {
            return;
        }
        if (kzaVar.e) {
            if (f(kzaVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = kzaVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        kzaVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = kzaVar.d.read(kzaVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        rza.a(kzaVar.c, i3 >> 2);
    }
}
