package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.d83;
import com.baidu.tieba.d92;
import com.baidu.tieba.h22;
import com.baidu.tieba.n63;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class rs1 extends ps1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public n22 f;

    /* loaded from: classes5.dex */
    public class a implements rh3<b83<d83.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ lo2 b;
        public final /* synthetic */ h22 c;
        public final /* synthetic */ ys2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ rs1 g;

        public a(rs1 rs1Var, String str, lo2 lo2Var, h22 h22Var, ys2 ys2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rs1Var, str, lo2Var, h22Var, ys2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = rs1Var;
            this.a = str;
            this.b = lo2Var;
            this.c = h22Var;
            this.d = ys2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(b83<d83.e> b83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b83Var) == null) {
                if (w73.h(b83Var)) {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                } else {
                    this.g.d(this.a, new yu1(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lo2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ys2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ h22 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ rs1 g;

        /* loaded from: classes5.dex */
        public class a implements n63.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ y23 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, y23 y23Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, y23Var, activity};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = y23Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.n63.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    ew2.d(this.c.d);
                    yz1.i("NavigateToApi", "check pages success");
                    r93.F(true, this.a.Y().T());
                    this.c.a.o();
                    d92.e f = d92.f(this.b, i92.c(this.c.c.a));
                    List<String> g = h63.g(this.c.e);
                    rs1 rs1Var = this.c.g;
                    y23 y23Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    h63.m(rs1Var, y23Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.n63.e
            public void b(int i, re3 re3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, re3Var) == null) {
                    yz1.c("NavigateToApi", "check pages failed");
                    r93.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    h63.k(bVar.g, bVar.b);
                    m93.j(this.c.c, re3Var);
                }
            }
        }

        public b(rs1 rs1Var, lo2 lo2Var, String str, ys2 ys2Var, String str2, h22 h22Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rs1Var, lo2Var, str, ys2Var, str2, h22Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = rs1Var;
            this.a = lo2Var;
            this.b = str;
            this.c = ys2Var;
            this.d = str2;
            this.e = h22Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    y23 M = y23.M();
                    if (M == null) {
                        this.g.d(this.b, new yu1(1001, "swan app is null"));
                        m93.i(this.c);
                        return;
                    }
                    this.a.a();
                    n63.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new yu1(1001, "swan activity is null"));
                m93.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements d92.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d92.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ys2 c;
        public final /* synthetic */ h22 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ rs1 f;

        public c(rs1 rs1Var, d92.e eVar, String str, ys2 ys2Var, h22 h22Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rs1Var, eVar, str, ys2Var, h22Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = rs1Var;
            this.a = eVar;
            this.b = str;
            this.c = ys2Var;
            this.d = h22Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.d92.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ew2.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ep1 a;
        public final /* synthetic */ ys2 b;
        public final /* synthetic */ h22 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ rs1 f;

        public d(rs1 rs1Var, ep1 ep1Var, ys2 ys2Var, h22 h22Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rs1Var, ep1Var, ys2Var, h22Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = rs1Var;
            this.a = ep1Var;
            this.b = ys2Var;
            this.c = h22Var;
            this.d = str;
            this.e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.D(this.a, this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends n22 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g22 a;
        public final /* synthetic */ rs1 b;

        public e(rs1 rs1Var, g22 g22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rs1Var, g22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rs1Var;
            this.a = g22Var;
        }

        @Override // com.baidu.tieba.n22, com.baidu.tieba.o22
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.R2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.n22, com.baidu.tieba.o22
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = u13.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                u13.h(this.a);
            }
        }

        @Override // com.baidu.tieba.n22, com.baidu.tieba.o22
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = u13.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                u13.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948132089, "Lcom/baidu/tieba/rs1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948132089, "Lcom/baidu/tieba/rs1;");
                return;
            }
        }
        g = fm2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rs1(@NonNull zq1 zq1Var) {
        super(zq1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zq1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zq1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(lo2 lo2Var, h22 h22Var, ys2 ys2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{lo2Var, h22Var, ys2Var, str, str2, str3}) == null) {
            sg3.a0(new b(this, lo2Var, str3, ys2Var, str, h22Var, str2));
        }
    }

    public final void D(ep1 ep1Var, ys2 ys2Var, h22 h22Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ep1Var, ys2Var, h22Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(ep1Var, ys2Var, h22Var, str);
            } else {
                G(ep1Var, ys2Var, h22Var, str);
            }
        }
    }

    public final void E(ep1 ep1Var, ys2 ys2Var, h22 h22Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, ep1Var, ys2Var, h22Var, str, str2) == null) {
            if (sg3.O()) {
                D(ep1Var, ys2Var, h22Var, str, str2);
            } else {
                sg3.a0(new d(this, ep1Var, ys2Var, h22Var, str, str2));
            }
        }
    }

    public final void F(ep1 ep1Var, ys2 ys2Var, h22 h22Var, String str) {
        SwanAppActivity activity;
        g22 g22Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, ep1Var, ys2Var, h22Var, str) == null) || (activity = lo2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        h63.e(ep1Var, ys2Var, str);
        ew2.c(9, str);
        g22.S3(sg3.n());
        h22.b k = h22Var.i("showModalPage").k("normal", ys2Var);
        if ((h22Var.m() instanceof g22) && (g22Var = (g22) h22Var.m()) != null) {
            g22Var.D0 = true;
            k.b();
            if (h22Var.k() > 1) {
                g22Var.x3().setBackgroundColor(0);
            } else {
                g22Var.D0 = false;
            }
            g22Var.z2(false);
            n22 n22Var = this.f;
            if (n22Var != null) {
                g22Var.R2(n22Var);
            }
            e eVar = new e(this, g22Var);
            this.f = eVar;
            g22Var.n2(eVar);
            View c2 = u13.c(g22Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            u13.h(g22Var);
            PullToRefreshBaseWebView h0 = ep1Var.h0();
            if (h0 != null) {
                h0.setIsPreventPullToRefresh(true);
            }
            dw2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            ew2.a(str, ys2Var);
        }
    }

    public final void G(ep1 ep1Var, ys2 ys2Var, h22 h22Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, ep1Var, ys2Var, h22Var, str) == null) || (activity = lo2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        h63.e(ep1Var, ys2Var, str);
        ew2.c(0, str);
        if (h22Var.k() < g) {
            g22.S3(sg3.n());
            h22.b i = h22Var.i("navigateTo");
            i.n(h22.g, h22.i);
            i.k("normal", ys2Var).b();
            if3.c(h22Var, getContext());
            dw2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            ew2.a(str, ys2Var);
            return;
        }
        ss1.A(h22Var, ys2Var, str, true);
    }

    public yu1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (yu1) invokeL.objValue;
    }

    public final yu1 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            y23 b0 = y23.b0();
            if (b0 == null) {
                return new yu1(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            ew2.b(uuid);
            Pair<yu1, JSONObject> s = s(str);
            yu1 yu1Var = (yu1) s.first;
            if (yu1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = h63.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    yz1.c("NavigateToApi", "url is null");
                    return new yu1(202, "url is null");
                }
                lo2 U = lo2.U();
                h22 V = U.V();
                if (V == null) {
                    yz1.c("NavigateToApi", "manager is null");
                    return new yu1(1001, "manager is null");
                }
                ys2 d2 = ys2.d(p, U.z());
                d2.e = str2;
                d2.f = uuid;
                m93.g(d2);
                if (!sg3.b(U.s(), d2, false)) {
                    String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                    yz1.c("NavigateToApi", str4);
                    m93.i(d2);
                    return new yu1(202, str4);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && y23.M() != null) {
                    y23.M().L0(optString, d2.d);
                }
                String optString2 = jSONObject.optString(FetchLog.START_TIME);
                if (!TextUtils.isEmpty(optString2)) {
                    HybridUbcFlow q = dw2.q("route", uuid);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                    ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                    q.F(ubcFlowEvent);
                }
                String optString3 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString3)) {
                    yz1.c("NavigateToApi", "cb is empty");
                    m93.i(d2);
                    return new yu1(202, "cb is empty");
                } else if (l53.b().a(d2)) {
                    l53.b().i(str3, d2);
                    yz1.c("NavigateToApi", "access to this page is prohibited");
                    return new yu1(1003, "access to this page is prohibited");
                } else {
                    if (TextUtils.equals("7", str2)) {
                        b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, d2, uuid, str2));
                    } else {
                        C(U, V, d2, uuid, str2, optString3);
                    }
                    return yu1.f();
                }
            }
            return yu1Var;
        }
        return (yu1) invokeLLL.objValue;
    }

    public yu1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (yu1) invokeL.objValue;
    }

    public final void K(d92.e eVar, ys2 ys2Var, h22 h22Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, ys2Var, h22Var, str, str2) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = dw2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            d92.q(eVar, new c(this, eVar, str, ys2Var, h22Var, str2));
        }
    }

    @Override // com.baidu.tieba.br1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }
}
