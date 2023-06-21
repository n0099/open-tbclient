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
public final class nlb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final ulb c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public nlb() {
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
        this.c = new ulb();
        this.i = 0;
    }

    public static void a(nlb nlbVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, nlbVar, z) != null) || !nlbVar.e) {
            return;
        }
        int i = ((nlbVar.h << 2) + ((nlbVar.g + 7) >> 3)) - 8;
        int i2 = nlbVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(nlb nlbVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, nlbVar, inputStream) == null) {
            if (nlbVar.d == null) {
                ulb.b(nlbVar.c, nlbVar.a, nlbVar.b);
                nlbVar.d = inputStream;
                nlbVar.f = 0L;
                nlbVar.g = 64;
                nlbVar.h = 1024;
                nlbVar.e = false;
                h(nlbVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(nlb nlbVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, nlbVar) == null) {
            InputStream inputStream = nlbVar.d;
            nlbVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(nlb nlbVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, nlbVar) == null) && (i = nlbVar.g) >= 32) {
            int[] iArr = nlbVar.b;
            int i2 = nlbVar.h;
            nlbVar.h = i2 + 1;
            nlbVar.f = (iArr[i2] << 32) | (nlbVar.f >>> 32);
            nlbVar.g = i - 32;
        }
    }

    public static int f(nlb nlbVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, nlbVar)) == null) {
            if (nlbVar.e) {
                i = (nlbVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - nlbVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(nlb nlbVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, nlbVar) == null) && (i = (64 - nlbVar.g) & 7) != 0 && i(nlbVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(nlb nlbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, nlbVar) == null) {
            j(nlbVar);
            a(nlbVar, false);
            d(nlbVar);
            d(nlbVar);
        }
    }

    public static void k(nlb nlbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, nlbVar) == null) && nlbVar.g == 64) {
            h(nlbVar);
        }
    }

    public static void c(nlb nlbVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, nlbVar, bArr, i, i2) == null) {
            if ((nlbVar.g & 7) == 0) {
                while (true) {
                    int i3 = nlbVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (nlbVar.f >>> i3);
                    nlbVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(nlbVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(nlbVar.a, nlbVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    nlbVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(nlbVar) > 0) {
                    d(nlbVar);
                    while (i2 != 0) {
                        long j = nlbVar.f;
                        int i5 = nlbVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        nlbVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(nlbVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = nlbVar.d.read(bArr, i, i2);
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

    public static int i(nlb nlbVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, nlbVar, i)) == null) {
            d(nlbVar);
            long j = nlbVar.f;
            int i2 = nlbVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            nlbVar.g = i2 + i;
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
    public static void j(nlb nlbVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, nlbVar) != null) || (i = nlbVar.h) <= 1015) {
            return;
        }
        if (nlbVar.e) {
            if (f(nlbVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = nlbVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        nlbVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = nlbVar.d.read(nlbVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        ulb.a(nlbVar.c, i3 >> 2);
    }
}
