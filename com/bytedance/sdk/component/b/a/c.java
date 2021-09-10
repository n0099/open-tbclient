package com.bytedance.sdk.component.b.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.google.android.material.slider.BasicLabelFormatter;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.text.Typography;
/* loaded from: classes9.dex */
public final class c implements d, e, Cloneable, ByteChannel {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f64404c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public o f64405a;

    /* renamed from: b  reason: collision with root package name */
    public long f64406b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(731338808, "Lcom/bytedance/sdk/component/b/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(731338808, "Lcom/bytedance/sdk/component/b/a/c;");
                return;
            }
        }
        f64404c = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102};
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public void a(long j2) throws EOFException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048590, this, j2) == null) && this.f64406b < j2) {
            throw new EOFException();
        }
    }

    @Override // com.bytedance.sdk.component.b.a.r
    public void a_(c cVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048594, this, cVar, j2) == null) {
            if (cVar == null) {
                throw new IllegalArgumentException("source == null");
            }
            if (cVar != this) {
                u.a(cVar.f64406b, 0L, j2);
                while (j2 > 0) {
                    o oVar = cVar.f64405a;
                    if (j2 < oVar.f64440c - oVar.f64439b) {
                        o oVar2 = this.f64405a;
                        o oVar3 = oVar2 != null ? oVar2.f64444g : null;
                        if (oVar3 != null && oVar3.f64442e) {
                            if ((oVar3.f64440c + j2) - (oVar3.f64441d ? 0 : oVar3.f64439b) <= 8192) {
                                cVar.f64405a.a(oVar3, (int) j2);
                                cVar.f64406b -= j2;
                                this.f64406b += j2;
                                return;
                            }
                        }
                        cVar.f64405a = cVar.f64405a.a((int) j2);
                    }
                    o oVar4 = cVar.f64405a;
                    long j3 = oVar4.f64440c - oVar4.f64439b;
                    cVar.f64405a = oVar4.b();
                    o oVar5 = this.f64405a;
                    if (oVar5 == null) {
                        this.f64405a = oVar4;
                        oVar4.f64444g = oVar4;
                        oVar4.f64443f = oVar4;
                    } else {
                        oVar5.f64444g.a(oVar4).c();
                    }
                    cVar.f64406b -= j3;
                    this.f64406b += j3;
                    j2 -= j3;
                }
                return;
            }
            throw new IllegalArgumentException("source == this");
        }
    }

    @Override // com.bytedance.sdk.component.b.a.d, com.bytedance.sdk.component.b.a.e
    public c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this : (c) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.b.a.d
    /* renamed from: d */
    public c u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this : (c) invokeV.objValue;
    }

    public String d(long j2) throws EOFException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048610, this, j2)) == null) ? a(j2, u.f64453a) : (String) invokeJ.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f64406b == 0 : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                long j2 = this.f64406b;
                if (j2 != cVar.f64406b) {
                    return false;
                }
                long j3 = 0;
                if (j2 == 0) {
                    return true;
                }
                o oVar = this.f64405a;
                o oVar2 = cVar.f64405a;
                int i2 = oVar.f64439b;
                int i3 = oVar2.f64439b;
                while (j3 < this.f64406b) {
                    long min = Math.min(oVar.f64440c - i2, oVar2.f64440c - i3);
                    int i4 = 0;
                    while (i4 < min) {
                        int i5 = i2 + 1;
                        int i6 = i3 + 1;
                        if (oVar.f64438a[i2] != oVar2.f64438a[i3]) {
                            return false;
                        }
                        i4++;
                        i2 = i5;
                        i3 = i6;
                    }
                    if (i2 == oVar.f64440c) {
                        oVar = oVar.f64443f;
                        i2 = oVar.f64439b;
                    }
                    if (i3 == oVar2.f64440c) {
                        oVar2 = oVar2.f64443f;
                        i3 = oVar2.f64439b;
                    }
                    j3 += min;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public InputStream f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? new InputStream(this) { // from class: com.bytedance.sdk.component.b.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f64407a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64407a = this;
            }

            @Override // java.io.InputStream
            public int available() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? (int) Math.min(this.f64407a.f64406b, 2147483647L) : invokeV2.intValue;
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // java.io.InputStream
            public int read() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    c cVar = this.f64407a;
                    if (cVar.f64406b > 0) {
                        return cVar.h() & 255;
                    }
                    return -1;
                }
                return invokeV2.intValue;
            }

            public String toString() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048580, this)) == null) {
                    return this.f64407a + ".inputStream()";
                }
                return (String) invokeV2.objValue;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048579, this, bArr, i2, i3)) == null) ? this.f64407a.a(bArr, i2, i3) : invokeLII.intValue;
            }
        } : (InputStream) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.d, com.bytedance.sdk.component.b.a.r, java.io.Flushable
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            o oVar = this.f64405a;
            if (oVar == null) {
                return 0;
            }
            int i2 = 1;
            do {
                int i3 = oVar.f64440c;
                for (int i4 = oVar.f64439b; i4 < i3; i4++) {
                    i2 = (i2 * 31) + oVar.f64438a[i4];
                }
                oVar = oVar.f64443f;
            } while (oVar != this.f64405a);
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            long j2 = this.f64406b;
            if (j2 >= 4) {
                o oVar = this.f64405a;
                int i2 = oVar.f64439b;
                int i3 = oVar.f64440c;
                if (i3 - i2 < 4) {
                    return ((h() & 255) << 24) | ((h() & 255) << 16) | ((h() & 255) << 8) | (h() & 255);
                }
                byte[] bArr = oVar.f64438a;
                int i4 = i2 + 1;
                int i5 = i4 + 1;
                int i6 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16);
                int i7 = i5 + 1;
                int i8 = i6 | ((bArr[i5] & 255) << 8);
                int i9 = i7 + 1;
                int i10 = i8 | (bArr[i7] & 255);
                this.f64406b = j2 - 4;
                if (i9 == i3) {
                    this.f64405a = oVar.b();
                    p.a(oVar);
                } else {
                    oVar.f64439b = i9;
                }
                return i10;
            }
            throw new IllegalStateException("size < 4: " + this.f64406b);
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a9 A[EDGE_INSN: B:49:0x00a9->B:40:0x00a9 ?: BREAK  , SYNTHETIC] */
    @Override // com.bytedance.sdk.component.b.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long m() {
        InterceptResult invokeV;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (this.f64406b != 0) {
                int i4 = 0;
                long j2 = 0;
                boolean z = false;
                do {
                    o oVar = this.f64405a;
                    byte[] bArr = oVar.f64438a;
                    int i5 = oVar.f64439b;
                    int i6 = oVar.f64440c;
                    while (i5 < i6) {
                        byte b2 = bArr[i5];
                        if (b2 < 48 || b2 > 57) {
                            if (b2 >= 97 && b2 <= 102) {
                                i2 = b2 - 97;
                            } else if (b2 >= 65 && b2 <= 70) {
                                i2 = b2 - 65;
                            } else if (i4 == 0) {
                                throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b2));
                            } else {
                                z = true;
                                if (i5 != i6) {
                                    this.f64405a = oVar.b();
                                    p.a(oVar);
                                } else {
                                    oVar.f64439b = i5;
                                }
                                if (!z) {
                                    break;
                                }
                            }
                            i3 = i2 + 10;
                        } else {
                            i3 = b2 - 48;
                        }
                        if (((-1152921504606846976L) & j2) != 0) {
                            c i7 = new c().k(j2).i((int) b2);
                            throw new NumberFormatException("Number too large: " + i7.o());
                        }
                        j2 = (j2 << 4) | i3;
                        i5++;
                        i4++;
                    }
                    if (i5 != i6) {
                    }
                    if (!z) {
                    }
                } while (this.f64405a != null);
                this.f64406b -= i4;
                return j2;
            }
            throw new IllegalStateException("size == 0");
        }
        return invokeV.longValue;
    }

    public f n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? new f(q()) : (f) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            try {
                return a(this.f64406b, u.f64453a);
            } catch (EOFException e2) {
                throw new AssertionError(e2);
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public String p() throws EOFException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? e(Long.MAX_VALUE) : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public byte[] q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            try {
                return g(this.f64406b);
            } catch (EOFException e2) {
                throw new AssertionError(e2);
            }
        }
        return (byte[]) invokeV.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            try {
                h(this.f64406b);
            } catch (EOFException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, byteBuffer)) == null) {
            o oVar = this.f64405a;
            if (oVar == null) {
                return -1;
            }
            int min = Math.min(byteBuffer.remaining(), oVar.f64440c - oVar.f64439b);
            byteBuffer.put(oVar.f64438a, oVar.f64439b, min);
            int i2 = oVar.f64439b + min;
            oVar.f64439b = i2;
            this.f64406b -= min;
            if (i2 == oVar.f64440c) {
                this.f64405a = oVar.b();
                p.a(oVar);
            }
            return min;
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: s */
    public c clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048643, this)) != null) {
            return (c) invokeV.objValue;
        }
        c cVar = new c();
        if (this.f64406b == 0) {
            return cVar;
        }
        o a2 = this.f64405a.a();
        cVar.f64405a = a2;
        a2.f64444g = a2;
        a2.f64443f = a2;
        o oVar = this.f64405a;
        while (true) {
            oVar = oVar.f64443f;
            if (oVar != this.f64405a) {
                cVar.f64405a.f64444g.a(oVar.a());
            } else {
                cVar.f64406b = this.f64406b;
                return cVar;
            }
        }
    }

    public final f t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            long j2 = this.f64406b;
            if (j2 <= 2147483647L) {
                return f((int) j2);
            }
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f64406b);
        }
        return (f) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? t().toString() : (String) invokeV.objValue;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, byteBuffer)) == null) {
            if (byteBuffer != null) {
                int remaining = byteBuffer.remaining();
                int i2 = remaining;
                while (i2 > 0) {
                    o e2 = e(1);
                    int min = Math.min(i2, 8192 - e2.f64440c);
                    byteBuffer.get(e2.f64438a, e2.f64440c, min);
                    i2 -= min;
                    e2.f64440c += min;
                }
                this.f64406b += remaining;
                return remaining;
            }
            throw new IllegalArgumentException("source == null");
        }
        return invokeL.intValue;
    }

    public final c a(c cVar, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{cVar, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (cVar != null) {
                u.a(this.f64406b, j2, j3);
                if (j3 == 0) {
                    return this;
                }
                cVar.f64406b += j3;
                o oVar = this.f64405a;
                while (true) {
                    int i2 = oVar.f64440c;
                    int i3 = oVar.f64439b;
                    if (j2 < i2 - i3) {
                        break;
                    }
                    j2 -= i2 - i3;
                    oVar = oVar.f64443f;
                }
                while (j3 > 0) {
                    o a2 = oVar.a();
                    int i4 = (int) (a2.f64439b + j2);
                    a2.f64439b = i4;
                    a2.f64440c = Math.min(i4 + ((int) j3), a2.f64440c);
                    o oVar2 = cVar.f64405a;
                    if (oVar2 == null) {
                        a2.f64444g = a2;
                        a2.f64443f = a2;
                        cVar.f64405a = a2;
                    } else {
                        oVar2.f64444g.a(a2);
                    }
                    j3 -= a2.f64440c - a2.f64439b;
                    oVar = oVar.f64443f;
                    j2 = 0;
                }
                return this;
            }
            throw new IllegalArgumentException("out == null");
        }
        return (c) invokeCommon.objValue;
    }

    public final long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f64406b : invokeV.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.b.a.d
    /* renamed from: d */
    public c g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            o e2 = e(4);
            byte[] bArr = e2.f64438a;
            int i3 = e2.f64440c;
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((i2 >>> 24) & 255);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((i2 >>> 16) & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((i2 >>> 8) & 255);
            bArr[i6] = (byte) (i2 & 255);
            e2.f64440c = i6 + 1;
            this.f64406b += 4;
            return this;
        }
        return (c) invokeI.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public String e(long j2) throws EOFException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048612, this, j2)) == null) {
            if (j2 >= 0) {
                long j3 = j2 != Long.MAX_VALUE ? j2 + 1 : Long.MAX_VALUE;
                long a2 = a((byte) 10, 0L, j3);
                if (a2 != -1) {
                    return f(a2);
                }
                if (j3 < b() && b(j3 - 1) == 13 && b(j3) == 10) {
                    return f(j3);
                }
                c cVar = new c();
                a(cVar, 0L, Math.min(32L, b()));
                throw new EOFException("\\n not found: limit=" + Math.min(b(), j2) + " content=" + cVar.n().e() + Typography.ellipsis);
            }
            throw new IllegalArgumentException("limit < 0: " + j2);
        }
        return (String) invokeJ.objValue;
    }

    public String f(long j2) throws EOFException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048617, this, j2)) == null) {
            if (j2 > 0) {
                long j3 = j2 - 1;
                if (b(j3) == 13) {
                    String d2 = d(j3);
                    h(2L);
                    return d2;
                }
            }
            String d3 = d(j2);
            h(1L);
            return d3;
        }
        return (String) invokeJ.objValue;
    }

    public final long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            long j2 = this.f64406b;
            if (j2 == 0) {
                return 0L;
            }
            o oVar = this.f64405a.f64444g;
            int i2 = oVar.f64440c;
            return (i2 >= 8192 || !oVar.f64442e) ? j2 : j2 - (i2 - oVar.f64439b);
        }
        return invokeV.longValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public byte h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            long j2 = this.f64406b;
            if (j2 != 0) {
                o oVar = this.f64405a;
                int i2 = oVar.f64439b;
                int i3 = oVar.f64440c;
                int i4 = i2 + 1;
                byte b2 = oVar.f64438a[i2];
                this.f64406b = j2 - 1;
                if (i4 == i3) {
                    this.f64405a = oVar.b();
                    p.a(oVar);
                } else {
                    oVar.f64439b = i4;
                }
                return b2;
            }
            throw new IllegalStateException("size == 0");
        }
        return invokeV.byteValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public short i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            long j2 = this.f64406b;
            if (j2 >= 2) {
                o oVar = this.f64405a;
                int i2 = oVar.f64439b;
                int i3 = oVar.f64440c;
                if (i3 - i2 < 2) {
                    return (short) (((h() & 255) << 8) | (h() & 255));
                }
                byte[] bArr = oVar.f64438a;
                int i4 = i2 + 1;
                int i5 = i4 + 1;
                int i6 = ((bArr[i2] & 255) << 8) | (bArr[i4] & 255);
                this.f64406b = j2 - 2;
                if (i5 == i3) {
                    this.f64405a = oVar.b();
                    p.a(oVar);
                } else {
                    oVar.f64439b = i5;
                }
                return (short) i6;
            }
            throw new IllegalStateException("size < 2: " + this.f64406b);
        }
        return invokeV.shortValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public short k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? u.a(i()) : invokeV.shortValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? u.a(j()) : invokeV.intValue;
    }

    public final byte b(long j2) {
        InterceptResult invokeJ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(1048595, this, j2)) != null) {
            return invokeJ.byteValue;
        }
        u.a(this.f64406b, j2, 1L);
        long j3 = this.f64406b;
        if (j3 - j2 > j2) {
            o oVar = this.f64405a;
            while (true) {
                int i3 = oVar.f64440c;
                int i4 = oVar.f64439b;
                long j4 = i3 - i4;
                if (j2 < j4) {
                    return oVar.f64438a[i4 + ((int) j2)];
                }
                j2 -= j4;
                oVar = oVar.f64443f;
            }
        } else {
            long j5 = j2 - j3;
            o oVar2 = this.f64405a;
            do {
                oVar2 = oVar2.f64444g;
                int i5 = oVar2.f64440c;
                i2 = oVar2.f64439b;
                j5 += i5 - i2;
            } while (j5 < 0);
            return oVar2.f64438a[i2 + ((int) j5)];
        }
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public f c(long j2) throws EOFException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048605, this, j2)) == null) ? new f(g(j2)) : (f) invokeJ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.b.a.d
    /* renamed from: c */
    public c h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            o e2 = e(2);
            byte[] bArr = e2.f64438a;
            int i3 = e2.f64440c;
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((i2 >>> 8) & 255);
            bArr[i4] = (byte) (i2 & 255);
            e2.f64440c = i4 + 1;
            this.f64406b += 2;
            return this;
        }
        return (c) invokeI.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public byte[] g(long j2) throws EOFException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048621, this, j2)) == null) {
            u.a(this.f64406b, 0L, j2);
            if (j2 <= 2147483647L) {
                byte[] bArr = new byte[(int) j2];
                a(bArr);
                return bArr;
            }
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
        }
        return (byte[]) invokeJ.objValue;
    }

    public final f f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i2)) == null) {
            if (i2 == 0) {
                return f.f64409b;
            }
            return new q(this, i2);
        }
        return (f) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.b.a.d
    /* renamed from: b */
    public c c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, bArr)) == null) {
            if (bArr != null) {
                return c(bArr, 0, bArr.length);
            }
            throw new IllegalArgumentException("source == null");
        }
        return (c) invokeL.objValue;
    }

    public o e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            if (i2 >= 1 && i2 <= 8192) {
                o oVar = this.f64405a;
                if (oVar == null) {
                    o a2 = p.a();
                    this.f64405a = a2;
                    a2.f64444g = a2;
                    a2.f64443f = a2;
                    return a2;
                }
                o oVar2 = oVar.f64444g;
                return (oVar2.f64440c + i2 > 8192 || !oVar2.f64442e) ? oVar2.a(p.a()) : oVar2;
            }
            throw new IllegalArgumentException();
        }
        return (o) invokeI.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public void h(long j2) throws EOFException {
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048624, this, j2) == null) {
            while (j2 > 0) {
                if (this.f64405a != null) {
                    int min = (int) Math.min(j2, oVar.f64440c - oVar.f64439b);
                    long j3 = min;
                    this.f64406b -= j3;
                    j2 -= j3;
                    o oVar2 = this.f64405a;
                    int i2 = oVar2.f64439b + min;
                    oVar2.f64439b = i2;
                    if (i2 == oVar2.f64440c) {
                        this.f64405a = oVar2.b();
                        p.a(oVar2);
                    }
                } else {
                    throw new EOFException();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.b.a.d
    /* renamed from: b */
    public c c(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048599, this, bArr, i2, i3)) == null) {
            if (bArr != null) {
                long j2 = i3;
                u.a(bArr.length, i2, j2);
                int i4 = i3 + i2;
                while (i2 < i4) {
                    o e2 = e(1);
                    int min = Math.min(i4 - i2, 8192 - e2.f64440c);
                    System.arraycopy(bArr, i2, e2.f64438a, e2.f64440c, min);
                    i2 += min;
                    e2.f64440c += min;
                }
                this.f64406b += j2;
                return this;
            }
            throw new IllegalArgumentException("source == null");
        }
        return (c) invokeLII.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public String a(Charset charset) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, charset)) == null) {
            try {
                return a(this.f64406b, charset);
            } catch (EOFException e2) {
                throw new AssertionError(e2);
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.b.a.d
    /* renamed from: i */
    public c l(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048626, this, j2)) == null) {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 == 0) {
                return i(48);
            }
            boolean z = false;
            int i3 = 1;
            if (i2 < 0) {
                j2 = -j2;
                if (j2 < 0) {
                    return b("-9223372036854775808");
                }
                z = true;
            }
            if (j2 >= 100000000) {
                i3 = j2 < BasicLabelFormatter.TRILLION ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
            } else if (j2 >= 10000) {
                i3 = j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
            } else if (j2 >= 100) {
                i3 = j2 < 1000 ? 3 : 4;
            } else if (j2 >= 10) {
                i3 = 2;
            }
            if (z) {
                i3++;
            }
            o e2 = e(i3);
            byte[] bArr = e2.f64438a;
            int i4 = e2.f64440c + i3;
            while (j2 != 0) {
                i4--;
                bArr[i4] = f64404c[(int) (j2 % 10)];
                j2 /= 10;
            }
            if (z) {
                bArr[i4 - 1] = UtilsBlink.VER_TYPE_SEPARATOR;
            }
            e2.f64440c += i3;
            this.f64406b += i3;
            return this;
        }
        return (c) invokeJ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.b.a.d
    /* renamed from: j */
    public c k(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048631, this, j2)) == null) {
            if (j2 == 0) {
                return i(48);
            }
            int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j2)) / 4) + 1;
            o e2 = e(numberOfTrailingZeros);
            byte[] bArr = e2.f64438a;
            int i2 = e2.f64440c;
            for (int i3 = (i2 + numberOfTrailingZeros) - 1; i3 >= i2; i3--) {
                bArr[i3] = f64404c[(int) (15 & j2)];
                j2 >>>= 4;
            }
            e2.f64440c += numberOfTrailingZeros;
            this.f64406b += numberOfTrailingZeros;
            return this;
        }
        return (c) invokeJ.objValue;
    }

    public String a(long j2, Charset charset) throws EOFException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048588, this, j2, charset)) == null) {
            u.a(this.f64406b, 0L, j2);
            if (charset != null) {
                if (j2 > 2147483647L) {
                    throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
                } else if (j2 == 0) {
                    return "";
                } else {
                    o oVar = this.f64405a;
                    if (oVar.f64439b + j2 > oVar.f64440c) {
                        return new String(g(j2), charset);
                    }
                    String str = new String(oVar.f64438a, oVar.f64439b, (int) j2, charset);
                    int i2 = (int) (oVar.f64439b + j2);
                    oVar.f64439b = i2;
                    this.f64406b -= j2;
                    if (i2 == oVar.f64440c) {
                        this.f64405a = oVar.b();
                        p.a(oVar);
                    }
                    return str;
                }
            }
            throw new IllegalArgumentException("charset == null");
        }
        return (String) invokeJL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.b.a.d
    /* renamed from: b */
    public c i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            o e2 = e(1);
            byte[] bArr = e2.f64438a;
            int i3 = e2.f64440c;
            e2.f64440c = i3 + 1;
            bArr[i3] = (byte) i2;
            this.f64406b++;
            return this;
        }
        return (c) invokeI.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public void a(byte[] bArr) throws EOFException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bArr) == null) {
            int i2 = 0;
            while (i2 < bArr.length) {
                int a2 = a(bArr, i2, bArr.length - i2);
                if (a2 == -1) {
                    throw new EOFException();
                }
                i2 += a2;
            }
        }
    }

    public int a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
            u.a(bArr.length, i2, i3);
            o oVar = this.f64405a;
            if (oVar == null) {
                return -1;
            }
            int min = Math.min(i3, oVar.f64440c - oVar.f64439b);
            System.arraycopy(oVar.f64438a, oVar.f64439b, bArr, i2, min);
            int i4 = oVar.f64439b + min;
            oVar.f64439b = i4;
            this.f64406b -= min;
            if (i4 == oVar.f64440c) {
                this.f64405a = oVar.b();
                p.a(oVar);
            }
            return min;
        }
        return invokeLII.intValue;
    }

    public c a(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fVar)) == null) {
            if (fVar != null) {
                fVar.a(this);
                return this;
            }
            throw new IllegalArgumentException("byteString == null");
        }
        return (c) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.b.a.d
    /* renamed from: a */
    public c b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? a(str, 0, str.length()) : (c) invokeL.objValue;
    }

    public c a(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048585, this, str, i2, i3)) == null) {
            if (str != null) {
                if (i2 < 0) {
                    throw new IllegalArgumentException("beginIndex < 0: " + i2);
                } else if (i3 >= i2) {
                    if (i3 > str.length()) {
                        throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
                    }
                    while (i2 < i3) {
                        char charAt = str.charAt(i2);
                        if (charAt < 128) {
                            o e2 = e(1);
                            byte[] bArr = e2.f64438a;
                            int i4 = e2.f64440c - i2;
                            int min = Math.min(i3, 8192 - i4);
                            int i5 = i2 + 1;
                            bArr[i2 + i4] = (byte) charAt;
                            while (i5 < min) {
                                char charAt2 = str.charAt(i5);
                                if (charAt2 >= 128) {
                                    break;
                                }
                                bArr[i5 + i4] = (byte) charAt2;
                                i5++;
                            }
                            int i6 = e2.f64440c;
                            int i7 = (i4 + i5) - i6;
                            e2.f64440c = i6 + i7;
                            this.f64406b += i7;
                            i2 = i5;
                        } else {
                            if (charAt < 2048) {
                                i((charAt >> 6) | 192);
                                i((charAt & '?') | 128);
                            } else if (charAt >= 55296 && charAt <= 57343) {
                                int i8 = i2 + 1;
                                char charAt3 = i8 < i3 ? str.charAt(i8) : (char) 0;
                                if (charAt <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                                    int i9 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                                    i((i9 >> 18) | 240);
                                    i(((i9 >> 12) & 63) | 128);
                                    i(((i9 >> 6) & 63) | 128);
                                    i((i9 & 63) | 128);
                                    i2 += 2;
                                } else {
                                    i(63);
                                    i2 = i8;
                                }
                            } else {
                                i((charAt >> '\f') | 224);
                                i(((charAt >> 6) & 63) | 128);
                                i((charAt & '?') | 128);
                            }
                            i2++;
                        }
                    }
                    return this;
                } else {
                    throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
                }
            }
            throw new IllegalArgumentException("string == null");
        }
        return (c) invokeLII.objValue;
    }

    public c a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 < 128) {
                i(i2);
            } else if (i2 < 2048) {
                i((i2 >> 6) | 192);
                i((i2 & 63) | 128);
            } else if (i2 < 65536) {
                if (i2 >= 55296 && i2 <= 57343) {
                    i(63);
                } else {
                    i((i2 >> 12) | 224);
                    i(((i2 >> 6) & 63) | 128);
                    i((i2 & 63) | 128);
                }
            } else if (i2 <= 1114111) {
                i((i2 >> 18) | 240);
                i(((i2 >> 12) & 63) | 128);
                i(((i2 >> 6) & 63) | 128);
                i((i2 & 63) | 128);
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
            }
            return this;
        }
        return (c) invokeI.objValue;
    }

    public c a(String str, int i2, int i3, Charset charset) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), charset})) == null) {
            if (str != null) {
                if (i2 < 0) {
                    throw new IllegalAccessError("beginIndex < 0: " + i2);
                } else if (i3 >= i2) {
                    if (i3 <= str.length()) {
                        if (charset != null) {
                            if (charset.equals(u.f64453a)) {
                                return a(str, i2, i3);
                            }
                            byte[] bytes = str.substring(i2, i3).getBytes(charset);
                            return c(bytes, 0, bytes.length);
                        }
                        throw new IllegalArgumentException("charset == null");
                    }
                    throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
                } else {
                    throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
                }
            }
            throw new IllegalArgumentException("string == null");
        }
        return (c) invokeCommon.objValue;
    }

    public long a(s sVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, sVar)) != null) {
            return invokeL.longValue;
        }
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j2 = 0;
        while (true) {
            long a2 = sVar.a(this, 8192L);
            if (a2 == -1) {
                return j2;
            }
            j2 += a2;
        }
    }

    @Override // com.bytedance.sdk.component.b.a.s
    public long a(c cVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, cVar, j2)) == null) {
            if (cVar != null) {
                if (j2 >= 0) {
                    long j3 = this.f64406b;
                    if (j3 == 0) {
                        return -1L;
                    }
                    if (j2 > j3) {
                        j2 = j3;
                    }
                    cVar.a_(this, j2);
                    return j2;
                }
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
            throw new IllegalArgumentException("sink == null");
        }
        return invokeLJ.longValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public long a(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeB = interceptable.invokeB(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2)) == null) ? a(b2, 0L, Long.MAX_VALUE) : invokeB.longValue;
    }

    public long a(byte b2, long j2, long j3) {
        InterceptResult invokeCommon;
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Byte.valueOf(b2), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            long j4 = 0;
            if (j2 >= 0 && j3 >= j2) {
                long j5 = this.f64406b;
                if (j3 <= j5) {
                    j5 = j3;
                }
                if (j2 == j5 || (oVar = this.f64405a) == null) {
                    return -1L;
                }
                long j6 = this.f64406b;
                if (j6 - j2 < j2) {
                    while (j6 > j2) {
                        oVar = oVar.f64444g;
                        j6 -= oVar.f64440c - oVar.f64439b;
                    }
                } else {
                    while (true) {
                        long j7 = (oVar.f64440c - oVar.f64439b) + j4;
                        if (j7 >= j2) {
                            break;
                        }
                        oVar = oVar.f64443f;
                        j4 = j7;
                    }
                    j6 = j4;
                }
                long j8 = j2;
                while (j6 < j5) {
                    byte[] bArr = oVar.f64438a;
                    int min = (int) Math.min(oVar.f64440c, (oVar.f64439b + j5) - j6);
                    for (int i2 = (int) ((oVar.f64439b + j8) - j6); i2 < min; i2++) {
                        if (bArr[i2] == b2) {
                            return (i2 - oVar.f64439b) + j6;
                        }
                    }
                    j6 += oVar.f64440c - oVar.f64439b;
                    oVar = oVar.f64443f;
                    j8 = j6;
                }
                return -1L;
            }
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f64406b), Long.valueOf(j2), Long.valueOf(j3)));
        }
        return invokeCommon.longValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public boolean a(long j2, f fVar) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048592, this, j2, fVar)) == null) ? a(j2, fVar, 0, fVar.g()) : invokeJL.booleanValue;
    }

    public boolean a(long j2, f fVar, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Long.valueOf(j2), fVar, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (j2 < 0 || i2 < 0 || i3 < 0 || this.f64406b - j2 < i3 || fVar.g() - i2 < i3) {
                return false;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (b(i4 + j2) != fVar.a(i2 + i4)) {
                    return false;
                }
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.bytedance.sdk.component.b.a.r
    public t a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? t.f64449c : (t) invokeV.objValue;
    }
}
