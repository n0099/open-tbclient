package com.bytedance.sdk.openadsdk.downloadnew.a.b;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.h;
import d.l.a.b.a.a.a;
import d.l.a.b.a.a.b;
import d.l.a.b.a.a.c;
import d.l.a.e.b.f.v;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c.a a(String str, String str2, m mVar, JSONObject jSONObject) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, str, str2, mVar, jSONObject)) == null) {
            if (mVar == null) {
                return new c.a();
            }
            if (TextUtils.isEmpty(str)) {
                return new c.a();
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("open_ad_sdk_download_extra", a.a().a(str2).b(jSONObject).a(mVar).b());
            } catch (Exception unused) {
            }
            c.a aVar = new c.a();
            aVar.b(Long.valueOf(mVar.ak()).longValue());
            aVar.n(mVar.Y() == null ? null : mVar.Y().a());
            aVar.l(h.d().o());
            aVar.q(!h.d().o());
            aVar.e(mVar.ao());
            aVar.f(jSONObject2);
            aVar.p(str);
            aVar.g(true);
            aVar.d(new v() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.b.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // d.l.a.e.b.f.v
                public Uri a(String str3, String str4) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str3, str4)) == null) ? com.bytedance.sdk.openadsdk.n.a.a(str3, str4) : (Uri) invokeLL.objValue;
                }
            });
            com.bytedance.sdk.openadsdk.n.a.a(aVar);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                aVar.o(true);
            }
            if (mVar.an() != null) {
                d.l.a.a.a.f.b bVar = new d.l.a.a.a.f.b();
                bVar.b(Long.valueOf(mVar.ak()).longValue());
                bVar.e(mVar.an().a());
                bVar.f(mVar.ah());
                if (mVar.an().c() != 2 || m.b(mVar)) {
                    if (mVar.an().c() == 1) {
                        bVar.c(mVar.an().b());
                    } else {
                        bVar.c(mVar.Z());
                    }
                }
                aVar.c(bVar);
            }
            return aVar;
        }
        return (c.a) invokeLLLL.objValue;
    }

    public static c.a a(String str, m mVar, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, mVar, jSONObject)) == null) {
            if (mVar == null) {
                return new c.a();
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("open_ad_sdk_download_extra", a.a().a(str).b(jSONObject).a(mVar).b());
            } catch (Exception unused) {
            }
            c.a aVar = new c.a();
            aVar.b(Double.valueOf(mVar.ak()).longValue());
            aVar.n(mVar.Y() == null ? null : mVar.Y().a());
            aVar.l(h.d().o());
            aVar.q(!h.d().o());
            aVar.e(mVar.ao());
            aVar.f(jSONObject2);
            aVar.g(true);
            aVar.d(new v() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.b.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // d.l.a.e.b.f.v
                public Uri a(String str2, String str3) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str2, str3)) == null) ? com.bytedance.sdk.openadsdk.n.a.a(str2, str3) : (Uri) invokeLL.objValue;
                }
            });
            com.bytedance.sdk.openadsdk.n.a.a(aVar);
            com.bytedance.sdk.openadsdk.core.e.b al = mVar.al();
            if (al != null) {
                aVar.p(al.b());
                aVar.r(al.c());
                aVar.k(al.d());
            }
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                aVar.o(true);
            }
            if (mVar.an() != null) {
                d.l.a.a.a.f.b bVar = new d.l.a.a.a.f.b();
                bVar.b(Long.valueOf(mVar.ak()).longValue());
                bVar.e(mVar.an().a());
                bVar.f(mVar.ah());
                if (mVar.an().c() != 2 || m.b(mVar)) {
                    if (mVar.an().c() == 1) {
                        bVar.c(mVar.an().b());
                    } else {
                        bVar.c(mVar.Z());
                    }
                }
                aVar.c(bVar);
            }
            return aVar;
        }
        return (c.a) invokeLLL.objValue;
    }

    public static a.C2045a a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, mVar)) == null) {
            int y = mVar == null ? 1 : mVar.y();
            int z = mVar == null ? 0 : mVar.z();
            if (mVar != null && !TextUtils.isEmpty(mVar.ax())) {
                z = 2;
            }
            a.C2045a c2045a = new a.C2045a();
            c2045a.a(y);
            c2045a.e(z);
            c2045a.c(true);
            c2045a.f(false);
            c2045a.b(mVar);
            if (mVar != null && mVar.am() != null) {
                c2045a.j(mVar.am().a());
                c2045a.k(mVar.am().b());
            }
            return c2045a;
        }
        return (a.C2045a) invokeL.objValue;
    }

    public static b.a a(m mVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, mVar, str)) == null) {
            b.a aVar = new b.a();
            aVar.b(str);
            aVar.e(str);
            aVar.g("click_start");
            aVar.j("click_continue");
            aVar.i("click_pause");
            aVar.m("download_failed");
            aVar.k("click_install");
            aVar.c(true);
            aVar.h(false);
            return aVar;
        }
        return (b.a) invokeLL.objValue;
    }
}
