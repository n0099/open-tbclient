package com.bytedance.sdk.component.b.b.a.e;

import android.net.http.Headers;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.a.r;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.ac;
import com.bytedance.sdk.component.b.b.s;
import com.bytedance.sdk.component.b.b.u;
import com.bytedance.sdk.component.b.b.w;
import com.bytedance.sdk.component.b.b.x;
import com.bytedance.sdk.component.b.b.z;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public final class f implements com.bytedance.sdk.component.b.b.a.c.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f64269b;

    /* renamed from: c  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f64270c;

    /* renamed from: d  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f64271d;

    /* renamed from: e  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f64272e;

    /* renamed from: f  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f64273f;

    /* renamed from: g  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f64274g;

    /* renamed from: h  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f64275h;

    /* renamed from: i  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f64276i;

    /* renamed from: j  reason: collision with root package name */
    public static final List<com.bytedance.sdk.component.b.a.f> f64277j;
    public static final List<com.bytedance.sdk.component.b.a.f> k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.b.a.b.g f64278a;
    public final w l;
    public final u.a m;
    public final g n;
    public i o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-952269748, "Lcom/bytedance/sdk/component/b/b/a/e/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-952269748, "Lcom/bytedance/sdk/component/b/b/a/e/f;");
                return;
            }
        }
        f64269b = com.bytedance.sdk.component.b.a.f.a("connection");
        f64270c = com.bytedance.sdk.component.b.a.f.a("host");
        f64271d = com.bytedance.sdk.component.b.a.f.a("keep-alive");
        f64272e = com.bytedance.sdk.component.b.a.f.a(Headers.PROXY_CONNECTION);
        f64273f = com.bytedance.sdk.component.b.a.f.a(Headers.TRANSFER_ENCODING);
        f64274g = com.bytedance.sdk.component.b.a.f.a("te");
        f64275h = com.bytedance.sdk.component.b.a.f.a("encoding");
        com.bytedance.sdk.component.b.a.f a2 = com.bytedance.sdk.component.b.a.f.a("upgrade");
        f64276i = a2;
        f64277j = com.bytedance.sdk.component.b.b.a.c.a(f64269b, f64270c, f64271d, f64272e, f64274g, f64273f, f64275h, a2, c.f64238c, c.f64239d, c.f64240e, c.f64241f);
        k = com.bytedance.sdk.component.b.b.a.c.a(f64269b, f64270c, f64271d, f64272e, f64274g, f64273f, f64275h, f64276i);
    }

    public f(w wVar, u.a aVar, com.bytedance.sdk.component.b.b.a.b.g gVar, g gVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wVar, aVar, gVar, gVar2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = wVar;
        this.m = aVar;
        this.f64278a = gVar;
        this.n = gVar2;
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public r a(z zVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, zVar, j2)) == null) ? this.o.h() : (r) invokeLJ.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.o.h().close();
        }
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public void c() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (iVar = this.o) == null) {
            return;
        }
        iVar.b(b.f64233f);
    }

    public static List<c> b(z zVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, zVar)) == null) {
            s c2 = zVar.c();
            ArrayList arrayList = new ArrayList(c2.a() + 4);
            arrayList.add(new c(c.f64238c, zVar.b()));
            arrayList.add(new c(c.f64239d, com.bytedance.sdk.component.b.b.a.c.i.a(zVar.a())));
            String a2 = zVar.a("Host");
            if (a2 != null) {
                arrayList.add(new c(c.f64241f, a2));
            }
            arrayList.add(new c(c.f64240e, zVar.a().c()));
            int a3 = c2.a();
            for (int i2 = 0; i2 < a3; i2++) {
                com.bytedance.sdk.component.b.a.f a4 = com.bytedance.sdk.component.b.a.f.a(c2.a(i2).toLowerCase(Locale.US));
                if (!f64277j.contains(a4)) {
                    arrayList.add(new c(a4, c2.b(i2)));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public void a(z zVar) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, zVar) == null) && this.o == null) {
            i a2 = this.n.a(b(zVar), zVar.d() != null);
            this.o = a2;
            a2.e().a(this.m.c(), TimeUnit.MILLISECONDS);
            this.o.f().a(this.m.d(), TimeUnit.MILLISECONDS);
        }
    }

    /* loaded from: classes9.dex */
    public class a extends com.bytedance.sdk.component.b.a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f64279a;

        /* renamed from: b  reason: collision with root package name */
        public long f64280b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f64281c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, com.bytedance.sdk.component.b.a.s sVar) {
            super(sVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((com.bytedance.sdk.component.b.a.s) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64281c = fVar;
            this.f64279a = false;
            this.f64280b = 0L;
        }

        @Override // com.bytedance.sdk.component.b.a.h, com.bytedance.sdk.component.b.a.s
        public long a(com.bytedance.sdk.component.b.a.c cVar, long j2) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, cVar, j2)) == null) {
                try {
                    long a2 = b().a(cVar, j2);
                    if (a2 > 0) {
                        this.f64280b += a2;
                    }
                    return a2;
                } catch (IOException e2) {
                    a(e2);
                    throw e2;
                }
            }
            return invokeLJ.longValue;
        }

        @Override // com.bytedance.sdk.component.b.a.h, com.bytedance.sdk.component.b.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.close();
                a(null);
            }
        }

        private void a(IOException iOException) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, this, iOException) == null) || this.f64279a) {
                return;
            }
            this.f64279a = true;
            f fVar = this.f64281c;
            fVar.f64278a.a(false, (com.bytedance.sdk.component.b.b.a.c.c) fVar, this.f64280b, iOException);
        }
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.n.b();
        }
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public ab.a a(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            ab.a a2 = a(this.o.d());
            if (z && com.bytedance.sdk.component.b.b.a.a.f64084a.a(a2) == 100) {
                return null;
            }
            return a2;
        }
        return (ab.a) invokeZ.objValue;
    }

    public static ab.a a(List<c> list) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            s.a aVar = new s.a();
            int size = list.size();
            com.bytedance.sdk.component.b.b.a.c.k kVar = null;
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = list.get(i2);
                if (cVar == null) {
                    if (kVar != null && kVar.f64201b == 100) {
                        aVar = new s.a();
                        kVar = null;
                    }
                } else {
                    com.bytedance.sdk.component.b.a.f fVar = cVar.f64242g;
                    String a2 = cVar.f64243h.a();
                    if (fVar.equals(c.f64237b)) {
                        kVar = com.bytedance.sdk.component.b.b.a.c.k.a("HTTP/1.1 " + a2);
                    } else if (!k.contains(fVar)) {
                        com.bytedance.sdk.component.b.b.a.a.f64084a.a(aVar, fVar.a(), a2);
                    }
                }
            }
            if (kVar != null) {
                return new ab.a().a(x.f64618d).a(kVar.f64201b).a(kVar.f64202c).a(aVar.a());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }
        return (ab.a) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public ac a(ab abVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, abVar)) == null) {
            com.bytedance.sdk.component.b.b.a.b.g gVar = this.f64278a;
            gVar.f64155c.f(gVar.f64154b);
            return new com.bytedance.sdk.component.b.b.a.c.h(abVar.a("Content-Type"), com.bytedance.sdk.component.b.b.a.c.e.a(abVar), com.bytedance.sdk.component.b.a.l.a(new a(this, this.o.g())));
        }
        return (ac) invokeL.objValue;
    }
}
