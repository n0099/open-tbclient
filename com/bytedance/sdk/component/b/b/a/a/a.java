package com.bytedance.sdk.component.b.b.a.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.a.l;
import com.bytedance.sdk.component.b.a.r;
import com.bytedance.sdk.component.b.a.s;
import com.bytedance.sdk.component.b.a.t;
import com.bytedance.sdk.component.b.b.a.a.c;
import com.bytedance.sdk.component.b.b.a.c.f;
import com.bytedance.sdk.component.b.b.a.c.h;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.ac;
import com.bytedance.sdk.component.b.b.s;
import com.bytedance.sdk.component.b.b.u;
import com.bytedance.sdk.component.b.b.x;
import com.bytedance.sdk.component.b.b.z;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.http.auth.AUTH;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public final class a implements u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final e f28241a;

    public a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28241a = eVar;
    }

    public static ab a(ab abVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, abVar)) == null) ? (abVar == null || abVar.h() == null) ? abVar : abVar.i().a((ac) null).a() : (ab) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.u
    public ab intercept(u.a aVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            e eVar = this.f28241a;
            ab a2 = eVar != null ? eVar.a(aVar.a()) : null;
            c a3 = new c.a(System.currentTimeMillis(), aVar.a(), a2).a();
            z zVar = a3.f28247a;
            ab abVar = a3.f28248b;
            e eVar2 = this.f28241a;
            if (eVar2 != null) {
                eVar2.a(a3);
            }
            if (a2 != null && abVar == null) {
                com.bytedance.sdk.component.b.b.a.c.a(a2.h());
            }
            if (zVar == null && abVar == null) {
                return new ab.a().a(aVar.a()).a(x.f28754b).a(504).a("Unsatisfiable Request (only-if-cached)").a(com.bytedance.sdk.component.b.b.a.c.f28317c).a(-1L).b(System.currentTimeMillis()).a();
            }
            if (zVar == null) {
                return abVar.i().b(a(abVar)).a();
            }
            try {
                ab a4 = aVar.a(zVar);
                if (a4 == null && a2 != null) {
                }
                if (abVar != null) {
                    if (a4.c() == 304) {
                        ab a5 = abVar.i().a(a(abVar.g(), a4.g())).a(a4.l()).b(a4.m()).b(a(abVar)).a(a(a4)).a();
                        a4.h().close();
                        this.f28241a.a();
                        this.f28241a.a(abVar, a5);
                        return a5;
                    }
                    com.bytedance.sdk.component.b.b.a.c.a(abVar.h());
                }
                ab a6 = a4.i().b(a(abVar)).a(a(a4)).a();
                if (this.f28241a != null) {
                    if (com.bytedance.sdk.component.b.b.a.c.e.b(a6) && c.a(a6, zVar)) {
                        return a(this.f28241a.a(a6), a6);
                    }
                    if (f.a(zVar.b())) {
                        try {
                            this.f28241a.b(zVar);
                        } catch (IOException unused) {
                        }
                    }
                }
                return a6;
            } finally {
                if (a2 != null) {
                    com.bytedance.sdk.component.b.b.a.c.a(a2.h());
                }
            }
        }
        return (ab) invokeL.objValue;
    }

    private ab a(b bVar, ab abVar) throws IOException {
        InterceptResult invokeLL;
        r a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, bVar, abVar)) == null) {
            if (bVar == null || (a2 = bVar.a()) == null) {
                return abVar;
            }
            return abVar.i().a(new h(abVar.a("Content-Type"), abVar.h().b(), l.a(new s(this, abVar.h().d(), bVar, l.a(a2)) { // from class: com.bytedance.sdk.component.b.b.a.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public boolean f28242a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.component.b.a.e f28243b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f28244c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.component.b.a.d f28245d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f28246e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, bVar, r9};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f28246e = this;
                    this.f28243b = r7;
                    this.f28244c = bVar;
                    this.f28245d = r9;
                }

                @Override // com.bytedance.sdk.component.b.a.s
                public long a(com.bytedance.sdk.component.b.a.c cVar, long j) throws IOException {
                    InterceptResult invokeLJ;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLJ = interceptable2.invokeLJ(1048576, this, cVar, j)) == null) {
                        try {
                            long a3 = this.f28243b.a(cVar, j);
                            if (a3 == -1) {
                                if (!this.f28242a) {
                                    this.f28242a = true;
                                    this.f28245d.close();
                                }
                                return -1L;
                            }
                            cVar.a(this.f28245d.c(), cVar.b() - a3, a3);
                            this.f28245d.u();
                            return a3;
                        } catch (IOException e2) {
                            if (!this.f28242a) {
                                this.f28242a = true;
                                this.f28244c.b();
                            }
                            throw e2;
                        }
                    }
                    return invokeLJ.longValue;
                }

                @Override // com.bytedance.sdk.component.b.a.s, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        if (!this.f28242a && !com.bytedance.sdk.component.b.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                            this.f28242a = true;
                            this.f28244c.b();
                        }
                        this.f28243b.close();
                    }
                }

                @Override // com.bytedance.sdk.component.b.a.s
                public t a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28243b.a() : (t) invokeV.objValue;
                }
            }))).a();
        }
        return (ab) invokeLL.objValue;
    }

    public static com.bytedance.sdk.component.b.b.s a(com.bytedance.sdk.component.b.b.s sVar, com.bytedance.sdk.component.b.b.s sVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, sVar, sVar2)) == null) {
            s.a aVar = new s.a();
            int a2 = sVar.a();
            for (int i2 = 0; i2 < a2; i2++) {
                String a3 = sVar.a(i2);
                String b2 = sVar.b(i2);
                if ((!"Warning".equalsIgnoreCase(a3) || !b2.startsWith("1")) && (!a(a3) || sVar2.a(a3) == null)) {
                    com.bytedance.sdk.component.b.b.a.a.f28240a.a(aVar, a3, b2);
                }
            }
            int a4 = sVar2.a();
            for (int i3 = 0; i3 < a4; i3++) {
                String a5 = sVar2.a(i3);
                if (!"Content-Length".equalsIgnoreCase(a5) && a(a5)) {
                    com.bytedance.sdk.component.b.b.a.a.f28240a.a(aVar, a5, sVar2.b(i3));
                }
            }
            return aVar.a();
        }
        return (com.bytedance.sdk.component.b.b.s) invokeLL.objValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (HTTP.CONN_DIRECTIVE.equalsIgnoreCase(str) || HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(str) || AUTH.PROXY_AUTH.equalsIgnoreCase(str) || AUTH.PROXY_AUTH_RESP.equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true : invokeL.booleanValue;
    }
}
