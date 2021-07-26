package com.bytedance.sdk.component.b.b.a.c;

import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.aa;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.m;
import com.bytedance.sdk.component.b.b.u;
import com.bytedance.sdk.component.b.b.v;
import com.bytedance.sdk.component.b.b.z;
import java.io.IOException;
import java.util.List;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public final class a implements u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final m f28326a;

    public a(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28326a = mVar;
    }

    private String a(List<com.bytedance.sdk.component.b.b.l> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, list)) == null) {
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 > 0) {
                    sb.append("; ");
                }
                com.bytedance.sdk.component.b.b.l lVar = list.get(i2);
                sb.append(lVar.a());
                sb.append(com.alipay.sdk.encrypt.a.f1923h);
                sb.append(lVar.b());
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.u
    public ab intercept(u.a aVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            z a2 = aVar.a();
            z.a f2 = a2.f();
            aa d2 = a2.d();
            if (d2 != null) {
                v a3 = d2.a();
                if (a3 != null) {
                    f2.a("Content-Type", a3.toString());
                }
                long b2 = d2.b();
                if (b2 != -1) {
                    f2.a("Content-Length", Long.toString(b2));
                    f2.b("Transfer-Encoding");
                } else {
                    f2.a("Transfer-Encoding", "chunked");
                    f2.b("Content-Length");
                }
            }
            boolean z = false;
            if (a2.a("Host") == null) {
                f2.a("Host", com.bytedance.sdk.component.b.b.a.c.a(a2.a(), false));
            }
            if (a2.a(HTTP.CONN_DIRECTIVE) == null) {
                f2.a(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            }
            if (a2.a("Accept-Encoding") == null && a2.a("Range") == null) {
                z = true;
                f2.a("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            }
            List<com.bytedance.sdk.component.b.b.l> a4 = this.f28326a.a(a2.a());
            if (!a4.isEmpty()) {
                f2.a("Cookie", a(a4));
            }
            if (a2.a("User-Agent") == null) {
                f2.a("User-Agent", com.bytedance.sdk.component.b.b.a.d.a());
            }
            ab a5 = aVar.a(f2.d());
            e.a(this.f28326a, a2.a(), a5.g());
            ab.a a6 = a5.i().a(a2);
            if (z && AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(a5.a("Content-Encoding")) && e.b(a5)) {
                com.bytedance.sdk.component.b.a.j jVar = new com.bytedance.sdk.component.b.a.j(a5.h().d());
                a6.a(a5.g().c().b("Content-Encoding").b("Content-Length").a());
                a6.a(new h(a5.a("Content-Type"), -1L, com.bytedance.sdk.component.b.a.l.a(jVar)));
            }
            return a6.a();
        }
        return (ab) invokeL.objValue;
    }
}
