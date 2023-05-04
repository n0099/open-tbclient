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
public final class o3b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final v3b c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public o3b() {
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
        this.c = new v3b();
        this.i = 0;
    }

    public static void a(o3b o3bVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, o3bVar, z) != null) || !o3bVar.e) {
            return;
        }
        int i = ((o3bVar.h << 2) + ((o3bVar.g + 7) >> 3)) - 8;
        int i2 = o3bVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(o3b o3bVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, o3bVar, inputStream) == null) {
            if (o3bVar.d == null) {
                v3b.b(o3bVar.c, o3bVar.a, o3bVar.b);
                o3bVar.d = inputStream;
                o3bVar.f = 0L;
                o3bVar.g = 64;
                o3bVar.h = 1024;
                o3bVar.e = false;
                h(o3bVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(o3b o3bVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, o3bVar) == null) {
            InputStream inputStream = o3bVar.d;
            o3bVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(o3b o3bVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, o3bVar) == null) && (i = o3bVar.g) >= 32) {
            int[] iArr = o3bVar.b;
            int i2 = o3bVar.h;
            o3bVar.h = i2 + 1;
            o3bVar.f = (iArr[i2] << 32) | (o3bVar.f >>> 32);
            o3bVar.g = i - 32;
        }
    }

    public static int f(o3b o3bVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, o3bVar)) == null) {
            if (o3bVar.e) {
                i = (o3bVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - o3bVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(o3b o3bVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, o3bVar) == null) && (i = (64 - o3bVar.g) & 7) != 0 && i(o3bVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(o3b o3bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, o3bVar) == null) {
            j(o3bVar);
            a(o3bVar, false);
            d(o3bVar);
            d(o3bVar);
        }
    }

    public static void k(o3b o3bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, o3bVar) == null) && o3bVar.g == 64) {
            h(o3bVar);
        }
    }

    public static void c(o3b o3bVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, o3bVar, bArr, i, i2) == null) {
            if ((o3bVar.g & 7) == 0) {
                while (true) {
                    int i3 = o3bVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (o3bVar.f >>> i3);
                    o3bVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(o3bVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(o3bVar.a, o3bVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    o3bVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(o3bVar) > 0) {
                    d(o3bVar);
                    while (i2 != 0) {
                        long j = o3bVar.f;
                        int i5 = o3bVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        o3bVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(o3bVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = o3bVar.d.read(bArr, i, i2);
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

    public static int i(o3b o3bVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, o3bVar, i)) == null) {
            d(o3bVar);
            long j = o3bVar.f;
            int i2 = o3bVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            o3bVar.g = i2 + i;
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
    public static void j(o3b o3bVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, o3bVar) != null) || (i = o3bVar.h) <= 1015) {
            return;
        }
        if (o3bVar.e) {
            if (f(o3bVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = o3bVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        o3bVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = o3bVar.d.read(o3bVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        v3b.a(o3bVar.c, i3 >> 2);
    }
}
