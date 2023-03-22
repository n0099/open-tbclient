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
public final class tpa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final aqa c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public tpa() {
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
        this.c = new aqa();
        this.i = 0;
    }

    public static void a(tpa tpaVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, tpaVar, z) != null) || !tpaVar.e) {
            return;
        }
        int i = ((tpaVar.h << 2) + ((tpaVar.g + 7) >> 3)) - 8;
        int i2 = tpaVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(tpa tpaVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, tpaVar, inputStream) == null) {
            if (tpaVar.d == null) {
                aqa.b(tpaVar.c, tpaVar.a, tpaVar.b);
                tpaVar.d = inputStream;
                tpaVar.f = 0L;
                tpaVar.g = 64;
                tpaVar.h = 1024;
                tpaVar.e = false;
                h(tpaVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(tpa tpaVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, tpaVar) == null) {
            InputStream inputStream = tpaVar.d;
            tpaVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(tpa tpaVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tpaVar) == null) && (i = tpaVar.g) >= 32) {
            int[] iArr = tpaVar.b;
            int i2 = tpaVar.h;
            tpaVar.h = i2 + 1;
            tpaVar.f = (iArr[i2] << 32) | (tpaVar.f >>> 32);
            tpaVar.g = i - 32;
        }
    }

    public static int f(tpa tpaVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tpaVar)) == null) {
            if (tpaVar.e) {
                i = (tpaVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - tpaVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(tpa tpaVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, tpaVar) == null) && (i = (64 - tpaVar.g) & 7) != 0 && i(tpaVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(tpa tpaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, tpaVar) == null) {
            j(tpaVar);
            a(tpaVar, false);
            d(tpaVar);
            d(tpaVar);
        }
    }

    public static void k(tpa tpaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, tpaVar) == null) && tpaVar.g == 64) {
            h(tpaVar);
        }
    }

    public static void c(tpa tpaVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, tpaVar, bArr, i, i2) == null) {
            if ((tpaVar.g & 7) == 0) {
                while (true) {
                    int i3 = tpaVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (tpaVar.f >>> i3);
                    tpaVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(tpaVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(tpaVar.a, tpaVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    tpaVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(tpaVar) > 0) {
                    d(tpaVar);
                    while (i2 != 0) {
                        long j = tpaVar.f;
                        int i5 = tpaVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        tpaVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(tpaVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = tpaVar.d.read(bArr, i, i2);
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

    public static int i(tpa tpaVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, tpaVar, i)) == null) {
            d(tpaVar);
            long j = tpaVar.f;
            int i2 = tpaVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            tpaVar.g = i2 + i;
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
    public static void j(tpa tpaVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, tpaVar) != null) || (i = tpaVar.h) <= 1015) {
            return;
        }
        if (tpaVar.e) {
            if (f(tpaVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = tpaVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        tpaVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = tpaVar.d.read(tpaVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        aqa.a(tpaVar.c, i3 >> 2);
    }
}
