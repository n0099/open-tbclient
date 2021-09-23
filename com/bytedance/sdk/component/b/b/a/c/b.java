package com.bytedance.sdk.component.b.b.a.c;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.a.r;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.u;
import com.bytedance.sdk.component.b.b.z;
import java.io.IOException;
import java.net.ProtocolException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes9.dex */
public final class b implements u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f64867a;

    /* loaded from: classes9.dex */
    public static final class a extends com.bytedance.sdk.component.b.a.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f64868a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(r rVar) {
            super(rVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((r) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.a.g, com.bytedance.sdk.component.b.a.r
        public void a_(com.bytedance.sdk.component.b.a.c cVar, long j2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, cVar, j2) == null) {
                super.a_(cVar, j2);
                this.f64868a += j2;
            }
        }
    }

    public b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64867a = z;
    }

    @Override // com.bytedance.sdk.component.b.b.u
    public ab intercept(u.a aVar) throws IOException {
        InterceptResult invokeL;
        ab a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            g gVar = (g) aVar;
            c g2 = gVar.g();
            com.bytedance.sdk.component.b.b.a.b.g f2 = gVar.f();
            com.bytedance.sdk.component.b.b.a.b.c cVar = (com.bytedance.sdk.component.b.b.a.b.c) gVar.e();
            z a3 = gVar.a();
            long currentTimeMillis = System.currentTimeMillis();
            gVar.i().c(gVar.h());
            g2.a(a3);
            gVar.i().a(gVar.h(), a3);
            ab.a aVar2 = null;
            if (f.c(a3.b()) && a3.d() != null) {
                if (HTTP.EXPECT_CONTINUE.equalsIgnoreCase(a3.a(HTTP.EXPECT_DIRECTIVE))) {
                    g2.a();
                    gVar.i().e(gVar.h());
                    aVar2 = g2.a(true);
                }
                if (aVar2 == null) {
                    gVar.i().d(gVar.h());
                    a aVar3 = new a(g2.a(a3, a3.d().b()));
                    com.bytedance.sdk.component.b.a.d a4 = com.bytedance.sdk.component.b.a.l.a(aVar3);
                    a3.d().a(a4);
                    a4.close();
                    gVar.i().a(gVar.h(), aVar3.f64868a);
                } else if (!cVar.e()) {
                    f2.d();
                }
            }
            g2.b();
            if (aVar2 == null) {
                gVar.i().e(gVar.h());
                aVar2 = g2.a(false);
            }
            ab a5 = aVar2.a(a3).a(f2.b().d()).a(currentTimeMillis).b(System.currentTimeMillis()).a();
            gVar.i().a(gVar.h(), a5);
            int c2 = a5.c();
            if (this.f64867a && c2 == 101) {
                a2 = a5.i().a(com.bytedance.sdk.component.b.b.a.c.f64856c).a();
            } else {
                a2 = a5.i().a(g2.a(a5)).a();
            }
            if (IntentConfig.CLOSE.equalsIgnoreCase(a2.a().a(HTTP.CONN_DIRECTIVE)) || IntentConfig.CLOSE.equalsIgnoreCase(a2.a(HTTP.CONN_DIRECTIVE))) {
                f2.d();
            }
            if ((c2 == 204 || c2 == 205) && a2.h().b() > 0) {
                throw new ProtocolException("HTTP " + c2 + " had non-zero Content-Length: " + a2.h().b());
            }
            return a2;
        }
        return (ab) invokeL.objValue;
    }
}
