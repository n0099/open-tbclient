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
public final class m5b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final t5b c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public m5b() {
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
        this.c = new t5b();
        this.i = 0;
    }

    public static void a(m5b m5bVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, m5bVar, z) != null) || !m5bVar.e) {
            return;
        }
        int i = ((m5bVar.h << 2) + ((m5bVar.g + 7) >> 3)) - 8;
        int i2 = m5bVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(m5b m5bVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, m5bVar, inputStream) == null) {
            if (m5bVar.d == null) {
                t5b.b(m5bVar.c, m5bVar.a, m5bVar.b);
                m5bVar.d = inputStream;
                m5bVar.f = 0L;
                m5bVar.g = 64;
                m5bVar.h = 1024;
                m5bVar.e = false;
                h(m5bVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(m5b m5bVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, m5bVar) == null) {
            InputStream inputStream = m5bVar.d;
            m5bVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(m5b m5bVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, m5bVar) == null) && (i = m5bVar.g) >= 32) {
            int[] iArr = m5bVar.b;
            int i2 = m5bVar.h;
            m5bVar.h = i2 + 1;
            m5bVar.f = (iArr[i2] << 32) | (m5bVar.f >>> 32);
            m5bVar.g = i - 32;
        }
    }

    public static int f(m5b m5bVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, m5bVar)) == null) {
            if (m5bVar.e) {
                i = (m5bVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - m5bVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(m5b m5bVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, m5bVar) == null) && (i = (64 - m5bVar.g) & 7) != 0 && i(m5bVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(m5b m5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, m5bVar) == null) {
            j(m5bVar);
            a(m5bVar, false);
            d(m5bVar);
            d(m5bVar);
        }
    }

    public static void k(m5b m5bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, m5bVar) == null) && m5bVar.g == 64) {
            h(m5bVar);
        }
    }

    public static void c(m5b m5bVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, m5bVar, bArr, i, i2) == null) {
            if ((m5bVar.g & 7) == 0) {
                while (true) {
                    int i3 = m5bVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (m5bVar.f >>> i3);
                    m5bVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(m5bVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(m5bVar.a, m5bVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    m5bVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(m5bVar) > 0) {
                    d(m5bVar);
                    while (i2 != 0) {
                        long j = m5bVar.f;
                        int i5 = m5bVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        m5bVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(m5bVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = m5bVar.d.read(bArr, i, i2);
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

    public static int i(m5b m5bVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, m5bVar, i)) == null) {
            d(m5bVar);
            long j = m5bVar.f;
            int i2 = m5bVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            m5bVar.g = i2 + i;
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
    public static void j(m5b m5bVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, m5bVar) != null) || (i = m5bVar.h) <= 1015) {
            return;
        }
        if (m5bVar.e) {
            if (f(m5bVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = m5bVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        m5bVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = m5bVar.d.read(m5bVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        t5b.a(m5bVar.c, i3 >> 2);
    }
}
