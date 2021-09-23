package com.bytedance.sdk.component.b.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.text.Typography;
/* loaded from: classes9.dex */
public final class n implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c f64745a;

    /* renamed from: b  reason: collision with root package name */
    public final s f64746b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f64747c;

    public n(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64745a = new c();
        if (sVar != null) {
            this.f64746b = sVar;
            return;
        }
        throw new NullPointerException("source == null");
    }

    @Override // com.bytedance.sdk.component.b.a.s
    public long a(c cVar, long j2) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, cVar, j2)) == null) {
            if (cVar != null) {
                if (j2 >= 0) {
                    if (!this.f64747c) {
                        c cVar2 = this.f64745a;
                        if (cVar2.f64717b == 0 && this.f64746b.a(cVar2, 8192L) == -1) {
                            return -1L;
                        }
                        return this.f64745a.a(cVar, Math.min(j2, this.f64745a.f64717b));
                    }
                    throw new IllegalStateException("closed");
                }
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
            throw new IllegalArgumentException("sink == null");
        }
        return invokeLJ.longValue;
    }

    public boolean b(long j2) throws IOException {
        InterceptResult invokeJ;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j2)) == null) {
            if (j2 >= 0) {
                if (!this.f64747c) {
                    do {
                        cVar = this.f64745a;
                        if (cVar.f64717b >= j2) {
                            return true;
                        }
                    } while (this.f64746b.a(cVar, 8192L) != -1);
                    return false;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
        return invokeJ.booleanValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f64745a : (c) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f64747c) {
            return;
        }
        this.f64747c = true;
        this.f64746b.close();
        this.f64745a.r();
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public boolean e() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f64747c) {
                throw new IllegalStateException("closed");
            }
            return this.f64745a.e() && this.f64746b.a(this.f64745a, 8192L) == -1;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public InputStream f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? new InputStream(this) { // from class: com.bytedance.sdk.component.b.a.n.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ n f64748a;

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
                this.f64748a = this;
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                    n nVar = this.f64748a;
                    if (!nVar.f64747c) {
                        return (int) Math.min(nVar.f64745a.f64717b, 2147483647L);
                    }
                    throw new IOException("closed");
                }
                return invokeV2.intValue;
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f64748a.close();
                }
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    n nVar = this.f64748a;
                    if (!nVar.f64747c) {
                        c cVar = nVar.f64745a;
                        if (cVar.f64717b == 0 && nVar.f64746b.a(cVar, 8192L) == -1) {
                            return -1;
                        }
                        return this.f64748a.f64745a.h() & 255;
                    }
                    throw new IOException("closed");
                }
                return invokeV2.intValue;
            }

            public String toString() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048580, this)) == null) {
                    return this.f64748a + ".inputStream()";
                }
                return (String) invokeV2.objValue;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i2, int i3) throws IOException {
                InterceptResult invokeLII;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048579, this, bArr, i2, i3)) == null) {
                    if (!this.f64748a.f64747c) {
                        u.a(bArr.length, i2, i3);
                        n nVar = this.f64748a;
                        c cVar = nVar.f64745a;
                        if (cVar.f64717b == 0 && nVar.f64746b.a(cVar, 8192L) == -1) {
                            return -1;
                        }
                        return this.f64748a.f64745a.a(bArr, i2, i3);
                    }
                    throw new IOException("closed");
                }
                return invokeLII.intValue;
            }
        } : (InputStream) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public byte[] g(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j2)) == null) {
            a(j2);
            return this.f64745a.g(j2);
        }
        return (byte[]) invokeJ.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public byte h() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            a(1L);
            return this.f64745a.h();
        }
        return invokeV.byteValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public short i() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            a(2L);
            return this.f64745a.i();
        }
        return invokeV.shortValue;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? !this.f64747c : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public int j() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            a(4L);
            return this.f64745a.j();
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public short k() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            a(2L);
            return this.f64745a.k();
        }
        return invokeV.shortValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public int l() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            a(4L);
            return this.f64745a.l();
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
        if (r1 == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // com.bytedance.sdk.component.b.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long m() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            a(1L);
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (!b(i3)) {
                    break;
                }
                byte b2 = this.f64745a.b(i2);
                if ((b2 < 48 || b2 > 57) && ((b2 < 97 || b2 > 102) && (b2 < 65 || b2 > 70))) {
                    break;
                }
                i2 = i3;
            }
            return this.f64745a.m();
        }
        return invokeV.longValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public String p() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? e(Long.MAX_VALUE) : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public byte[] q() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            this.f64745a.a(this.f64746b);
            return this.f64745a.q();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, byteBuffer)) == null) {
            c cVar = this.f64745a;
            if (cVar.f64717b == 0 && this.f64746b.a(cVar, 8192L) == -1) {
                return -1;
            }
            return this.f64745a.read(byteBuffer);
        }
        return invokeL.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return "buffer(" + this.f64746b + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public f c(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j2)) == null) {
            a(j2);
            return this.f64745a.c(j2);
        }
        return (f) invokeJ.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public void h(long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j2) == null) {
            if (this.f64747c) {
                throw new IllegalStateException("closed");
            }
            while (j2 > 0) {
                c cVar = this.f64745a;
                if (cVar.f64717b == 0 && this.f64746b.a(cVar, 8192L) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j2, this.f64745a.b());
                this.f64745a.h(min);
                j2 -= min;
            }
        }
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public String e(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048589, this, j2)) == null) {
            if (j2 >= 0) {
                long j3 = j2 == Long.MAX_VALUE ? Long.MAX_VALUE : j2 + 1;
                long a2 = a((byte) 10, 0L, j3);
                if (a2 != -1) {
                    return this.f64745a.f(a2);
                }
                if (j3 < Long.MAX_VALUE && b(j3) && this.f64745a.b(j3 - 1) == 13 && b(1 + j3) && this.f64745a.b(j3) == 10) {
                    return this.f64745a.f(j3);
                }
                c cVar = new c();
                c cVar2 = this.f64745a;
                cVar2.a(cVar, 0L, Math.min(32L, cVar2.b()));
                throw new EOFException("\\n not found: limit=" + Math.min(this.f64745a.b(), j2) + " content=" + cVar.n().e() + Typography.ellipsis);
            }
            throw new IllegalArgumentException("limit < 0: " + j2);
        }
        return (String) invokeJ.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public void a(long j2) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) && !b(j2)) {
            throw new EOFException();
        }
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public void a(byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048582, this, bArr) != null) {
            return;
        }
        try {
            a(bArr.length);
            this.f64745a.a(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (true) {
                c cVar = this.f64745a;
                long j2 = cVar.f64717b;
                if (j2 > 0) {
                    int a2 = cVar.a(bArr, i2, (int) j2);
                    if (a2 == -1) {
                        throw new AssertionError();
                    }
                    i2 += a2;
                } else {
                    throw e2;
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public String a(Charset charset) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, charset)) == null) {
            if (charset != null) {
                this.f64745a.a(this.f64746b);
                return this.f64745a.a(charset);
            }
            throw new IllegalArgumentException("charset == null");
        }
        return (String) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public long a(byte b2) throws IOException {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeB = interceptable.invokeB(1048576, this, b2)) == null) ? a(b2, 0L, Long.MAX_VALUE) : invokeB.longValue;
    }

    public long a(byte b2, long j2, long j3) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Byte.valueOf(b2), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (this.f64747c) {
                throw new IllegalStateException("closed");
            }
            if (j2 < 0 || j3 < j2) {
                throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j2), Long.valueOf(j3)));
            }
            while (j2 < j3) {
                long a2 = this.f64745a.a(b2, j2, j3);
                if (a2 == -1) {
                    c cVar = this.f64745a;
                    long j4 = cVar.f64717b;
                    if (j4 >= j3 || this.f64746b.a(cVar, 8192L) == -1) {
                        break;
                    }
                    j2 = Math.max(j2, j4);
                } else {
                    return a2;
                }
            }
            return -1L;
        }
        return invokeCommon.longValue;
    }

    @Override // com.bytedance.sdk.component.b.a.e
    public boolean a(long j2, f fVar) throws IOException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048583, this, j2, fVar)) == null) ? a(j2, fVar, 0, fVar.g()) : invokeJL.booleanValue;
    }

    public boolean a(long j2, f fVar, int i2, int i3) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j2), fVar, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (!this.f64747c) {
                if (j2 < 0 || i2 < 0 || i3 < 0 || fVar.g() - i2 < i3) {
                    return false;
                }
                for (int i4 = 0; i4 < i3; i4++) {
                    long j3 = i4 + j2;
                    if (!b(1 + j3) || this.f64745a.b(j3) != fVar.a(i2 + i4)) {
                        return false;
                    }
                }
                return true;
            }
            throw new IllegalStateException("closed");
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.bytedance.sdk.component.b.a.s
    public t a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64746b.a() : (t) invokeV.objValue;
    }
}
