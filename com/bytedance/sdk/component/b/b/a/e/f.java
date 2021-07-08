package com.bytedance.sdk.component.b.b.a.e;

import android.net.http.Headers;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
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
/* loaded from: classes5.dex */
public final class f implements com.bytedance.sdk.component.b.b.a.c.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f28324b;

    /* renamed from: c  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f28325c;

    /* renamed from: d  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f28326d;

    /* renamed from: e  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f28327e;

    /* renamed from: f  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f28328f;

    /* renamed from: g  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f28329g;

    /* renamed from: h  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f28330h;

    /* renamed from: i  reason: collision with root package name */
    public static final com.bytedance.sdk.component.b.a.f f28331i;
    public static final List<com.bytedance.sdk.component.b.a.f> j;
    public static final List<com.bytedance.sdk.component.b.a.f> k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.b.a.b.g f28332a;
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
        f28324b = com.bytedance.sdk.component.b.a.f.a("connection");
        f28325c = com.bytedance.sdk.component.b.a.f.a("host");
        f28326d = com.bytedance.sdk.component.b.a.f.a("keep-alive");
        f28327e = com.bytedance.sdk.component.b.a.f.a(Headers.PROXY_CONNECTION);
        f28328f = com.bytedance.sdk.component.b.a.f.a(Headers.TRANSFER_ENCODING);
        f28329g = com.bytedance.sdk.component.b.a.f.a("te");
        f28330h = com.bytedance.sdk.component.b.a.f.a("encoding");
        com.bytedance.sdk.component.b.a.f a2 = com.bytedance.sdk.component.b.a.f.a(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
        f28331i = a2;
        j = com.bytedance.sdk.component.b.b.a.c.a(f28324b, f28325c, f28326d, f28327e, f28329g, f28328f, f28330h, a2, c.f28294c, c.f28295d, c.f28296e, c.f28297f);
        k = com.bytedance.sdk.component.b.b.a.c.a(f28324b, f28325c, f28326d, f28327e, f28329g, f28328f, f28330h, f28331i);
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
        this.f28332a = gVar;
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
        iVar.b(b.f28289f);
    }

    public static List<c> b(z zVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, zVar)) == null) {
            s c2 = zVar.c();
            ArrayList arrayList = new ArrayList(c2.a() + 4);
            arrayList.add(new c(c.f28294c, zVar.b()));
            arrayList.add(new c(c.f28295d, com.bytedance.sdk.component.b.b.a.c.i.a(zVar.a())));
            String a2 = zVar.a("Host");
            if (a2 != null) {
                arrayList.add(new c(c.f28297f, a2));
            }
            arrayList.add(new c(c.f28296e, zVar.a().c()));
            int a3 = c2.a();
            for (int i2 = 0; i2 < a3; i2++) {
                com.bytedance.sdk.component.b.a.f a4 = com.bytedance.sdk.component.b.a.f.a(c2.a(i2).toLowerCase(Locale.US));
                if (!j.contains(a4)) {
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

    /* loaded from: classes5.dex */
    public class a extends com.bytedance.sdk.component.b.a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f28333a;

        /* renamed from: b  reason: collision with root package name */
        public long f28334b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f28335c;

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
            this.f28335c = fVar;
            this.f28333a = false;
            this.f28334b = 0L;
        }

        @Override // com.bytedance.sdk.component.b.a.h, com.bytedance.sdk.component.b.a.s
        public long a(com.bytedance.sdk.component.b.a.c cVar, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, cVar, j)) == null) {
                try {
                    long a2 = b().a(cVar, j);
                    if (a2 > 0) {
                        this.f28334b += a2;
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
            if (!(interceptable == null || interceptable.invokeL(65537, this, iOException) == null) || this.f28333a) {
                return;
            }
            this.f28333a = true;
            f fVar = this.f28335c;
            fVar.f28332a.a(false, (com.bytedance.sdk.component.b.b.a.c.c) fVar, this.f28334b, iOException);
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
            if (z && com.bytedance.sdk.component.b.b.a.a.f28146a.a(a2) == 100) {
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
                    if (kVar != null && kVar.f28257b == 100) {
                        aVar = new s.a();
                        kVar = null;
                    }
                } else {
                    com.bytedance.sdk.component.b.a.f fVar = cVar.f28298g;
                    String a2 = cVar.f28299h.a();
                    if (fVar.equals(c.f28293b)) {
                        kVar = com.bytedance.sdk.component.b.b.a.c.k.a("HTTP/1.1 " + a2);
                    } else if (!k.contains(fVar)) {
                        com.bytedance.sdk.component.b.b.a.a.f28146a.a(aVar, fVar.a(), a2);
                    }
                }
            }
            if (kVar != null) {
                return new ab.a().a(x.f28662d).a(kVar.f28257b).a(kVar.f28258c).a(aVar.a());
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
            com.bytedance.sdk.component.b.b.a.b.g gVar = this.f28332a;
            gVar.f28214c.f(gVar.f28213b);
            return new com.bytedance.sdk.component.b.b.a.c.h(abVar.a("Content-Type"), com.bytedance.sdk.component.b.b.a.c.e.a(abVar), com.bytedance.sdk.component.b.a.l.a(new a(this, this.o.g())));
        }
        return (ac) invokeL.objValue;
    }
}
