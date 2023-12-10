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
public final class llc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final slc c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public llc() {
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
        this.c = new slc();
        this.i = 0;
    }

    public static void a(llc llcVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, llcVar, z) != null) || !llcVar.e) {
            return;
        }
        int i = ((llcVar.h << 2) + ((llcVar.g + 7) >> 3)) - 8;
        int i2 = llcVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(llc llcVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, llcVar, inputStream) == null) {
            if (llcVar.d == null) {
                slc.b(llcVar.c, llcVar.a, llcVar.b);
                llcVar.d = inputStream;
                llcVar.f = 0L;
                llcVar.g = 64;
                llcVar.h = 1024;
                llcVar.e = false;
                h(llcVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(llc llcVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, llcVar) == null) {
            InputStream inputStream = llcVar.d;
            llcVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(llc llcVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, llcVar) == null) && (i = llcVar.g) >= 32) {
            int[] iArr = llcVar.b;
            int i2 = llcVar.h;
            llcVar.h = i2 + 1;
            llcVar.f = (iArr[i2] << 32) | (llcVar.f >>> 32);
            llcVar.g = i - 32;
        }
    }

    public static int f(llc llcVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, llcVar)) == null) {
            if (llcVar.e) {
                i = (llcVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - llcVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(llc llcVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, llcVar) == null) && (i = (64 - llcVar.g) & 7) != 0 && i(llcVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(llc llcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, llcVar) == null) {
            j(llcVar);
            a(llcVar, false);
            d(llcVar);
            d(llcVar);
        }
    }

    public static void k(llc llcVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, llcVar) == null) && llcVar.g == 64) {
            h(llcVar);
        }
    }

    public static void c(llc llcVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, llcVar, bArr, i, i2) == null) {
            if ((llcVar.g & 7) == 0) {
                while (true) {
                    int i3 = llcVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (llcVar.f >>> i3);
                    llcVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(llcVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(llcVar.a, llcVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    llcVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(llcVar) > 0) {
                    d(llcVar);
                    while (i2 != 0) {
                        long j = llcVar.f;
                        int i5 = llcVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        llcVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(llcVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = llcVar.d.read(bArr, i, i2);
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

    public static int i(llc llcVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, llcVar, i)) == null) {
            d(llcVar);
            long j = llcVar.f;
            int i2 = llcVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            llcVar.g = i2 + i;
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
    public static void j(llc llcVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, llcVar) != null) || (i = llcVar.h) <= 1015) {
            return;
        }
        if (llcVar.e) {
            if (f(llcVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = llcVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        llcVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = llcVar.d.read(llcVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        slc.a(llcVar.c, i3 >> 2);
    }
}
