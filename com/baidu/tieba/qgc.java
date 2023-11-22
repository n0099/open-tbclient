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
public final class qgc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final xgc c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public qgc() {
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
        this.c = new xgc();
        this.i = 0;
    }

    public static void a(qgc qgcVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, qgcVar, z) != null) || !qgcVar.e) {
            return;
        }
        int i = ((qgcVar.h << 2) + ((qgcVar.g + 7) >> 3)) - 8;
        int i2 = qgcVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(qgc qgcVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, qgcVar, inputStream) == null) {
            if (qgcVar.d == null) {
                xgc.b(qgcVar.c, qgcVar.a, qgcVar.b);
                qgcVar.d = inputStream;
                qgcVar.f = 0L;
                qgcVar.g = 64;
                qgcVar.h = 1024;
                qgcVar.e = false;
                h(qgcVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(qgc qgcVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, qgcVar) == null) {
            InputStream inputStream = qgcVar.d;
            qgcVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(qgc qgcVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, qgcVar) == null) && (i = qgcVar.g) >= 32) {
            int[] iArr = qgcVar.b;
            int i2 = qgcVar.h;
            qgcVar.h = i2 + 1;
            qgcVar.f = (iArr[i2] << 32) | (qgcVar.f >>> 32);
            qgcVar.g = i - 32;
        }
    }

    public static int f(qgc qgcVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, qgcVar)) == null) {
            if (qgcVar.e) {
                i = (qgcVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - qgcVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(qgc qgcVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, qgcVar) == null) && (i = (64 - qgcVar.g) & 7) != 0 && i(qgcVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(qgc qgcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, qgcVar) == null) {
            j(qgcVar);
            a(qgcVar, false);
            d(qgcVar);
            d(qgcVar);
        }
    }

    public static void k(qgc qgcVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, qgcVar) == null) && qgcVar.g == 64) {
            h(qgcVar);
        }
    }

    public static void c(qgc qgcVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, qgcVar, bArr, i, i2) == null) {
            if ((qgcVar.g & 7) == 0) {
                while (true) {
                    int i3 = qgcVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (qgcVar.f >>> i3);
                    qgcVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(qgcVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(qgcVar.a, qgcVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    qgcVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(qgcVar) > 0) {
                    d(qgcVar);
                    while (i2 != 0) {
                        long j = qgcVar.f;
                        int i5 = qgcVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        qgcVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(qgcVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = qgcVar.d.read(bArr, i, i2);
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

    public static int i(qgc qgcVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, qgcVar, i)) == null) {
            d(qgcVar);
            long j = qgcVar.f;
            int i2 = qgcVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            qgcVar.g = i2 + i;
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
    public static void j(qgc qgcVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, qgcVar) != null) || (i = qgcVar.h) <= 1015) {
            return;
        }
        if (qgcVar.e) {
            if (f(qgcVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = qgcVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        qgcVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = qgcVar.d.read(qgcVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        xgc.a(qgcVar.c, i3 >> 2);
    }
}
