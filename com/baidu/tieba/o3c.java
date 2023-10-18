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
public final class o3c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final v3c c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public o3c() {
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
        this.c = new v3c();
        this.i = 0;
    }

    public static void a(o3c o3cVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, o3cVar, z) != null) || !o3cVar.e) {
            return;
        }
        int i = ((o3cVar.h << 2) + ((o3cVar.g + 7) >> 3)) - 8;
        int i2 = o3cVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(o3c o3cVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, o3cVar, inputStream) == null) {
            if (o3cVar.d == null) {
                v3c.b(o3cVar.c, o3cVar.a, o3cVar.b);
                o3cVar.d = inputStream;
                o3cVar.f = 0L;
                o3cVar.g = 64;
                o3cVar.h = 1024;
                o3cVar.e = false;
                h(o3cVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(o3c o3cVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, o3cVar) == null) {
            InputStream inputStream = o3cVar.d;
            o3cVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(o3c o3cVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, o3cVar) == null) && (i = o3cVar.g) >= 32) {
            int[] iArr = o3cVar.b;
            int i2 = o3cVar.h;
            o3cVar.h = i2 + 1;
            o3cVar.f = (iArr[i2] << 32) | (o3cVar.f >>> 32);
            o3cVar.g = i - 32;
        }
    }

    public static int f(o3c o3cVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, o3cVar)) == null) {
            if (o3cVar.e) {
                i = (o3cVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - o3cVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(o3c o3cVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, o3cVar) == null) && (i = (64 - o3cVar.g) & 7) != 0 && i(o3cVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(o3c o3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, o3cVar) == null) {
            j(o3cVar);
            a(o3cVar, false);
            d(o3cVar);
            d(o3cVar);
        }
    }

    public static void k(o3c o3cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, o3cVar) == null) && o3cVar.g == 64) {
            h(o3cVar);
        }
    }

    public static void c(o3c o3cVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, o3cVar, bArr, i, i2) == null) {
            if ((o3cVar.g & 7) == 0) {
                while (true) {
                    int i3 = o3cVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (o3cVar.f >>> i3);
                    o3cVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(o3cVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(o3cVar.a, o3cVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    o3cVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(o3cVar) > 0) {
                    d(o3cVar);
                    while (i2 != 0) {
                        long j = o3cVar.f;
                        int i5 = o3cVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        o3cVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(o3cVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = o3cVar.d.read(bArr, i, i2);
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

    public static int i(o3c o3cVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, o3cVar, i)) == null) {
            d(o3cVar);
            long j = o3cVar.f;
            int i2 = o3cVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            o3cVar.g = i2 + i;
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
    public static void j(o3c o3cVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, o3cVar) != null) || (i = o3cVar.h) <= 1015) {
            return;
        }
        if (o3cVar.e) {
            if (f(o3cVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = o3cVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        o3cVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = o3cVar.d.read(o3cVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        v3c.a(o3cVar.c, i3 >> 2);
    }
}
