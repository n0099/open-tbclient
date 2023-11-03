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
public final class pgc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final wgc c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public pgc() {
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
        this.c = new wgc();
        this.i = 0;
    }

    public static void a(pgc pgcVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, pgcVar, z) != null) || !pgcVar.e) {
            return;
        }
        int i = ((pgcVar.h << 2) + ((pgcVar.g + 7) >> 3)) - 8;
        int i2 = pgcVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(pgc pgcVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, pgcVar, inputStream) == null) {
            if (pgcVar.d == null) {
                wgc.b(pgcVar.c, pgcVar.a, pgcVar.b);
                pgcVar.d = inputStream;
                pgcVar.f = 0L;
                pgcVar.g = 64;
                pgcVar.h = 1024;
                pgcVar.e = false;
                h(pgcVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(pgc pgcVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, pgcVar) == null) {
            InputStream inputStream = pgcVar.d;
            pgcVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(pgc pgcVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pgcVar) == null) && (i = pgcVar.g) >= 32) {
            int[] iArr = pgcVar.b;
            int i2 = pgcVar.h;
            pgcVar.h = i2 + 1;
            pgcVar.f = (iArr[i2] << 32) | (pgcVar.f >>> 32);
            pgcVar.g = i - 32;
        }
    }

    public static int f(pgc pgcVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, pgcVar)) == null) {
            if (pgcVar.e) {
                i = (pgcVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - pgcVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(pgc pgcVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, pgcVar) == null) && (i = (64 - pgcVar.g) & 7) != 0 && i(pgcVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(pgc pgcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, pgcVar) == null) {
            j(pgcVar);
            a(pgcVar, false);
            d(pgcVar);
            d(pgcVar);
        }
    }

    public static void k(pgc pgcVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, pgcVar) == null) && pgcVar.g == 64) {
            h(pgcVar);
        }
    }

    public static void c(pgc pgcVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, pgcVar, bArr, i, i2) == null) {
            if ((pgcVar.g & 7) == 0) {
                while (true) {
                    int i3 = pgcVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (pgcVar.f >>> i3);
                    pgcVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(pgcVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(pgcVar.a, pgcVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    pgcVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(pgcVar) > 0) {
                    d(pgcVar);
                    while (i2 != 0) {
                        long j = pgcVar.f;
                        int i5 = pgcVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        pgcVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(pgcVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = pgcVar.d.read(bArr, i, i2);
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

    public static int i(pgc pgcVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, pgcVar, i)) == null) {
            d(pgcVar);
            long j = pgcVar.f;
            int i2 = pgcVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            pgcVar.g = i2 + i;
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
    public static void j(pgc pgcVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, pgcVar) != null) || (i = pgcVar.h) <= 1015) {
            return;
        }
        if (pgcVar.e) {
            if (f(pgcVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = pgcVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        pgcVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = pgcVar.d.read(pgcVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        wgc.a(pgcVar.c, i3 >> 2);
    }
}
