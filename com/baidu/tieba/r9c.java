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
public final class r9c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final y9c c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public r9c() {
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
        this.c = new y9c();
        this.i = 0;
    }

    public static void a(r9c r9cVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, r9cVar, z) != null) || !r9cVar.e) {
            return;
        }
        int i = ((r9cVar.h << 2) + ((r9cVar.g + 7) >> 3)) - 8;
        int i2 = r9cVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(r9c r9cVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, r9cVar, inputStream) == null) {
            if (r9cVar.d == null) {
                y9c.b(r9cVar.c, r9cVar.a, r9cVar.b);
                r9cVar.d = inputStream;
                r9cVar.f = 0L;
                r9cVar.g = 64;
                r9cVar.h = 1024;
                r9cVar.e = false;
                h(r9cVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(r9c r9cVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, r9cVar) == null) {
            InputStream inputStream = r9cVar.d;
            r9cVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(r9c r9cVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, r9cVar) == null) && (i = r9cVar.g) >= 32) {
            int[] iArr = r9cVar.b;
            int i2 = r9cVar.h;
            r9cVar.h = i2 + 1;
            r9cVar.f = (iArr[i2] << 32) | (r9cVar.f >>> 32);
            r9cVar.g = i - 32;
        }
    }

    public static int f(r9c r9cVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, r9cVar)) == null) {
            if (r9cVar.e) {
                i = (r9cVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - r9cVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(r9c r9cVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, r9cVar) == null) && (i = (64 - r9cVar.g) & 7) != 0 && i(r9cVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(r9c r9cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, r9cVar) == null) {
            j(r9cVar);
            a(r9cVar, false);
            d(r9cVar);
            d(r9cVar);
        }
    }

    public static void k(r9c r9cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, r9cVar) == null) && r9cVar.g == 64) {
            h(r9cVar);
        }
    }

    public static void c(r9c r9cVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, r9cVar, bArr, i, i2) == null) {
            if ((r9cVar.g & 7) == 0) {
                while (true) {
                    int i3 = r9cVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (r9cVar.f >>> i3);
                    r9cVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(r9cVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(r9cVar.a, r9cVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    r9cVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(r9cVar) > 0) {
                    d(r9cVar);
                    while (i2 != 0) {
                        long j = r9cVar.f;
                        int i5 = r9cVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        r9cVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(r9cVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = r9cVar.d.read(bArr, i, i2);
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

    public static int i(r9c r9cVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, r9cVar, i)) == null) {
            d(r9cVar);
            long j = r9cVar.f;
            int i2 = r9cVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            r9cVar.g = i2 + i;
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
    public static void j(r9c r9cVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, r9cVar) != null) || (i = r9cVar.h) <= 1015) {
            return;
        }
        if (r9cVar.e) {
            if (f(r9cVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = r9cVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        r9cVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = r9cVar.d.read(r9cVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        y9c.a(r9cVar.c, i3 >> 2);
    }
}
