package com.bytedance.sdk.component.b.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
/* loaded from: classes9.dex */
public final class j implements s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f64727a;

    /* renamed from: b  reason: collision with root package name */
    public final e f64728b;

    /* renamed from: c  reason: collision with root package name */
    public final Inflater f64729c;

    /* renamed from: d  reason: collision with root package name */
    public final k f64730d;

    /* renamed from: e  reason: collision with root package name */
    public final CRC32 f64731e;

    public j(s sVar) {
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
        this.f64727a = 0;
        this.f64731e = new CRC32();
        if (sVar != null) {
            this.f64729c = new Inflater(true);
            e a2 = l.a(sVar);
            this.f64728b = a2;
            this.f64730d = new k(a2, this.f64729c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f64728b.a(10L);
            byte b2 = this.f64728b.c().b(3L);
            boolean z = ((b2 >> 1) & 1) == 1;
            if (z) {
                a(this.f64728b.c(), 0L, 10L);
            }
            a("ID1ID2", 8075, this.f64728b.i());
            this.f64728b.h(8L);
            if (((b2 >> 2) & 1) == 1) {
                this.f64728b.a(2L);
                if (z) {
                    a(this.f64728b.c(), 0L, 2L);
                }
                long k = this.f64728b.c().k();
                this.f64728b.a(k);
                if (z) {
                    a(this.f64728b.c(), 0L, k);
                }
                this.f64728b.h(k);
            }
            if (((b2 >> 3) & 1) == 1) {
                long a2 = this.f64728b.a((byte) 0);
                if (a2 != -1) {
                    if (z) {
                        a(this.f64728b.c(), 0L, a2 + 1);
                    }
                    this.f64728b.h(a2 + 1);
                } else {
                    throw new EOFException();
                }
            }
            if (((b2 >> 4) & 1) == 1) {
                long a3 = this.f64728b.a((byte) 0);
                if (a3 != -1) {
                    if (z) {
                        a(this.f64728b.c(), 0L, a3 + 1);
                    }
                    this.f64728b.h(a3 + 1);
                } else {
                    throw new EOFException();
                }
            }
            if (z) {
                a("FHCRC", this.f64728b.k(), (short) this.f64731e.getValue());
                this.f64731e.reset();
            }
        }
    }

    private void c() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            a("CRC", this.f64728b.l(), (int) this.f64731e.getValue());
            a("ISIZE", this.f64728b.l(), (int) this.f64729c.getBytesWritten());
        }
    }

    @Override // com.bytedance.sdk.component.b.a.s
    public long a(c cVar, long j2) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, cVar, j2)) == null) {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            } else if (i2 == 0) {
                return 0L;
            } else {
                if (this.f64727a == 0) {
                    b();
                    this.f64727a = 1;
                }
                if (this.f64727a == 1) {
                    long j3 = cVar.f64717b;
                    long a2 = this.f64730d.a(cVar, j2);
                    if (a2 != -1) {
                        a(cVar, j3, a2);
                        return a2;
                    }
                    this.f64727a = 2;
                }
                if (this.f64727a == 2) {
                    c();
                    this.f64727a = 3;
                    if (!this.f64728b.e()) {
                        throw new IOException("gzip finished without exhausting source");
                    }
                }
                return -1L;
            }
        }
        return invokeLJ.longValue;
    }

    @Override // com.bytedance.sdk.component.b.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f64730d.close();
        }
    }

    @Override // com.bytedance.sdk.component.b.a.s
    public t a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64728b.a() : (t) invokeV.objValue;
    }

    private void a(c cVar, long j2, long j3) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{cVar, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            o oVar = cVar.f64716a;
            while (true) {
                int i3 = oVar.f64751c;
                int i4 = oVar.f64750b;
                if (j2 < i3 - i4) {
                    break;
                }
                j2 -= i3 - i4;
                oVar = oVar.f64754f;
            }
            while (j3 > 0) {
                int min = (int) Math.min(oVar.f64751c - i2, j3);
                this.f64731e.update(oVar.f64749a, (int) (oVar.f64750b + j2), min);
                j3 -= min;
                oVar = oVar.f64754f;
                j2 = 0;
            }
        }
    }

    private void a(String str, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65538, this, str, i2, i3) == null) && i3 != i2) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i3), Integer.valueOf(i2)));
        }
    }
}
