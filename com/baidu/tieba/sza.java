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
public final class sza {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final zza c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public sza() {
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
        this.c = new zza();
        this.i = 0;
    }

    public static void a(sza szaVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, szaVar, z) != null) || !szaVar.e) {
            return;
        }
        int i = ((szaVar.h << 2) + ((szaVar.g + 7) >> 3)) - 8;
        int i2 = szaVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(sza szaVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, szaVar, inputStream) == null) {
            if (szaVar.d == null) {
                zza.b(szaVar.c, szaVar.a, szaVar.b);
                szaVar.d = inputStream;
                szaVar.f = 0L;
                szaVar.g = 64;
                szaVar.h = 1024;
                szaVar.e = false;
                h(szaVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(sza szaVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, szaVar) == null) {
            InputStream inputStream = szaVar.d;
            szaVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(sza szaVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, szaVar) == null) && (i = szaVar.g) >= 32) {
            int[] iArr = szaVar.b;
            int i2 = szaVar.h;
            szaVar.h = i2 + 1;
            szaVar.f = (iArr[i2] << 32) | (szaVar.f >>> 32);
            szaVar.g = i - 32;
        }
    }

    public static int f(sza szaVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, szaVar)) == null) {
            if (szaVar.e) {
                i = (szaVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - szaVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(sza szaVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, szaVar) == null) && (i = (64 - szaVar.g) & 7) != 0 && i(szaVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(sza szaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, szaVar) == null) {
            j(szaVar);
            a(szaVar, false);
            d(szaVar);
            d(szaVar);
        }
    }

    public static void k(sza szaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, szaVar) == null) && szaVar.g == 64) {
            h(szaVar);
        }
    }

    public static void c(sza szaVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, szaVar, bArr, i, i2) == null) {
            if ((szaVar.g & 7) == 0) {
                while (true) {
                    int i3 = szaVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (szaVar.f >>> i3);
                    szaVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(szaVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(szaVar.a, szaVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    szaVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(szaVar) > 0) {
                    d(szaVar);
                    while (i2 != 0) {
                        long j = szaVar.f;
                        int i5 = szaVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        szaVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(szaVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = szaVar.d.read(bArr, i, i2);
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

    public static int i(sza szaVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, szaVar, i)) == null) {
            d(szaVar);
            long j = szaVar.f;
            int i2 = szaVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            szaVar.g = i2 + i;
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
    public static void j(sza szaVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, szaVar) != null) || (i = szaVar.h) <= 1015) {
            return;
        }
        if (szaVar.e) {
            if (f(szaVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = szaVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        szaVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = szaVar.d.read(szaVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        zza.a(szaVar.c, i3 >> 2);
    }
}
