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
public final class kja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final rja c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public kja() {
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
        this.c = new rja();
        this.i = 0;
    }

    public static void a(kja kjaVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, kjaVar, z) != null) || !kjaVar.e) {
            return;
        }
        int i = ((kjaVar.h << 2) + ((kjaVar.g + 7) >> 3)) - 8;
        int i2 = kjaVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(kja kjaVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, kjaVar, inputStream) == null) {
            if (kjaVar.d == null) {
                rja.b(kjaVar.c, kjaVar.a, kjaVar.b);
                kjaVar.d = inputStream;
                kjaVar.f = 0L;
                kjaVar.g = 64;
                kjaVar.h = 1024;
                kjaVar.e = false;
                h(kjaVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(kja kjaVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, kjaVar) == null) {
            InputStream inputStream = kjaVar.d;
            kjaVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(kja kjaVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, kjaVar) == null) && (i = kjaVar.g) >= 32) {
            int[] iArr = kjaVar.b;
            int i2 = kjaVar.h;
            kjaVar.h = i2 + 1;
            kjaVar.f = (iArr[i2] << 32) | (kjaVar.f >>> 32);
            kjaVar.g = i - 32;
        }
    }

    public static int f(kja kjaVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, kjaVar)) == null) {
            if (kjaVar.e) {
                i = (kjaVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - kjaVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(kja kjaVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, kjaVar) == null) && (i = (64 - kjaVar.g) & 7) != 0 && i(kjaVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(kja kjaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, kjaVar) == null) {
            j(kjaVar);
            a(kjaVar, false);
            d(kjaVar);
            d(kjaVar);
        }
    }

    public static void k(kja kjaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, kjaVar) == null) && kjaVar.g == 64) {
            h(kjaVar);
        }
    }

    public static void c(kja kjaVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, kjaVar, bArr, i, i2) == null) {
            if ((kjaVar.g & 7) == 0) {
                while (true) {
                    int i3 = kjaVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (kjaVar.f >>> i3);
                    kjaVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(kjaVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(kjaVar.a, kjaVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    kjaVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(kjaVar) > 0) {
                    d(kjaVar);
                    while (i2 != 0) {
                        long j = kjaVar.f;
                        int i5 = kjaVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        kjaVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(kjaVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = kjaVar.d.read(bArr, i, i2);
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

    public static int i(kja kjaVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, kjaVar, i)) == null) {
            d(kjaVar);
            long j = kjaVar.f;
            int i2 = kjaVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            kjaVar.g = i2 + i;
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
    public static void j(kja kjaVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, kjaVar) != null) || (i = kjaVar.h) <= 1015) {
            return;
        }
        if (kjaVar.e) {
            if (f(kjaVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = kjaVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        kjaVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = kjaVar.d.read(kjaVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        rja.a(kjaVar.c, i3 >> 2);
    }
}
