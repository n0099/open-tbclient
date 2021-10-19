package com.bytedance.sdk.component.b.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes9.dex */
public abstract class ac implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ac() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static ac a(v vVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, vVar, bArr)) == null) ? a(vVar, bArr.length, new com.bytedance.sdk.component.b.a.c().c(bArr)) : (ac) invokeLL.objValue;
    }

    private Charset g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            v a2 = a();
            return a2 != null ? a2.a(com.bytedance.sdk.component.b.b.a.c.f64893e) : com.bytedance.sdk.component.b.b.a.c.f64893e;
        }
        return (Charset) invokeV.objValue;
    }

    public abstract v a();

    public abstract long b();

    public final InputStream c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d().f() : (InputStream) invokeV.objValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            com.bytedance.sdk.component.b.b.a.c.a(d());
        }
    }

    public abstract com.bytedance.sdk.component.b.a.e d();

    public final byte[] e() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            long b2 = b();
            if (b2 <= 2147483647L) {
                com.bytedance.sdk.component.b.a.e d2 = d();
                try {
                    byte[] q = d2.q();
                    com.bytedance.sdk.component.b.b.a.c.a(d2);
                    if (b2 == -1 || b2 == q.length) {
                        return q;
                    }
                    throw new IOException("Content-Length (" + b2 + ") and stream length (" + q.length + ") disagree");
                } catch (Throwable th) {
                    com.bytedance.sdk.component.b.b.a.c.a(d2);
                    throw th;
                }
            }
            throw new IOException("Cannot buffer entire body for content length: " + b2);
        }
        return (byte[]) invokeV.objValue;
    }

    public final String f() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            com.bytedance.sdk.component.b.a.e d2 = d();
            try {
                return d2.a(com.bytedance.sdk.component.b.b.a.c.a(d2, g()));
            } finally {
                com.bytedance.sdk.component.b.b.a.c.a(d2);
            }
        }
        return (String) invokeV.objValue;
    }

    public static ac a(v vVar, long j2, com.bytedance.sdk.component.b.a.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{vVar, Long.valueOf(j2), eVar})) == null) {
            if (eVar != null) {
                return new ac(vVar, j2, eVar) { // from class: com.bytedance.sdk.component.b.b.ac.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ v f65185a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ long f65186b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.component.b.a.e f65187c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {vVar, Long.valueOf(j2), eVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f65185a = vVar;
                        this.f65186b = j2;
                        this.f65187c = eVar;
                    }

                    @Override // com.bytedance.sdk.component.b.b.ac
                    public v a() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f65185a : (v) invokeV.objValue;
                    }

                    @Override // com.bytedance.sdk.component.b.b.ac
                    public long b() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f65186b : invokeV.longValue;
                    }

                    @Override // com.bytedance.sdk.component.b.b.ac
                    public com.bytedance.sdk.component.b.a.e d() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f65187c : (com.bytedance.sdk.component.b.a.e) invokeV.objValue;
                    }
                };
            }
            throw new NullPointerException("source == null");
        }
        return (ac) invokeCommon.objValue;
    }
}
