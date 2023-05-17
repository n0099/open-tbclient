package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.le3;
import com.baidu.tieba.lf2;
import com.baidu.tieba.p82;
import com.baidu.tieba.vc3;
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
/* loaded from: classes8.dex */
public class zy1 extends xy1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public v82 f;

    @Override // com.baidu.tieba.jx1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tu2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ gz2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ p82 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ zy1 g;

        /* loaded from: classes8.dex */
        public class a implements vc3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g93 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, g93 g93Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, g93Var, activity};
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
                this.a = g93Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.vc3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    m23.d(this.c.d);
                    g62.i("NavigateToApi", "check pages success");
                    zf3.F(true, this.a.Y().T());
                    this.c.a.o();
                    lf2.e f = lf2.f(this.b, qf2.c(this.c.c.a));
                    List<String> g = pc3.g(this.c.e);
                    zy1 zy1Var = this.c.g;
                    g93 g93Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    pc3.m(zy1Var, g93Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.vc3.e
            public void b(int i, zk3 zk3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, zk3Var) == null) {
                    g62.c("NavigateToApi", "check pages failed");
                    zf3.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    pc3.k(bVar.g, bVar.b);
                    uf3.j(this.c.c, zk3Var);
                }
            }
        }

        public b(zy1 zy1Var, tu2 tu2Var, String str, gz2 gz2Var, String str2, p82 p82Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy1Var, tu2Var, str, gz2Var, str2, p82Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = zy1Var;
            this.a = tu2Var;
            this.b = str;
            this.c = gz2Var;
            this.d = str2;
            this.e = p82Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    g93 M = g93.M();
                    if (M == null) {
                        this.g.d(this.b, new g12(1001, "swan app is null"));
                        uf3.i(this.c);
                        return;
                    }
                    this.a.a();
                    vc3.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new g12(1001, "swan activity is null"));
                uf3.i(this.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements zn3<je3<le3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ tu2 b;
        public final /* synthetic */ p82 c;
        public final /* synthetic */ gz2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ zy1 g;

        public a(zy1 zy1Var, String str, tu2 tu2Var, p82 p82Var, gz2 gz2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy1Var, str, tu2Var, p82Var, gz2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = zy1Var;
            this.a = str;
            this.b = tu2Var;
            this.c = p82Var;
            this.d = gz2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(je3<le3.e> je3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, je3Var) == null) {
                if (!ee3.h(je3Var)) {
                    this.g.d(this.a, new g12(10005, "system deny"));
                } else {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements lf2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ gz2 c;
        public final /* synthetic */ p82 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ zy1 f;

        public c(zy1 zy1Var, lf2.e eVar, String str, gz2 gz2Var, p82 p82Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy1Var, eVar, str, gz2Var, p82Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = zy1Var;
            this.a = eVar;
            this.b = str;
            this.c = gz2Var;
            this.d = p82Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.lf2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m23.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mv1 a;
        public final /* synthetic */ gz2 b;
        public final /* synthetic */ p82 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ zy1 f;

        public d(zy1 zy1Var, mv1 mv1Var, gz2 gz2Var, p82 p82Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy1Var, mv1Var, gz2Var, p82Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = zy1Var;
            this.a = mv1Var;
            this.b = gz2Var;
            this.c = p82Var;
            this.d = str;
            this.e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.f.D(this.a, this.b, this.c, this.d, this.e);
        }
    }

    /* loaded from: classes8.dex */
    public class e extends v82 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o82 a;
        public final /* synthetic */ zy1 b;

        public e(zy1 zy1Var, o82 o82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy1Var, o82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zy1Var;
            this.a = o82Var;
        }

        @Override // com.baidu.tieba.v82, com.baidu.tieba.w82
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.U2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.v82, com.baidu.tieba.w82
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = c83.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                c83.h(this.a);
            }
        }

        @Override // com.baidu.tieba.v82, com.baidu.tieba.w82
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = c83.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                c83.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948376183, "Lcom/baidu/tieba/zy1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948376183, "Lcom/baidu/tieba/zy1;");
                return;
            }
        }
        g = ns2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zy1(@NonNull hx1 hx1Var) {
        super(hx1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hx1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((hx1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public g12 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (g12) invokeL.objValue;
    }

    public g12 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (g12) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(tu2 tu2Var, p82 p82Var, gz2 gz2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tu2Var, p82Var, gz2Var, str, str2, str3}) == null) {
            an3.a0(new b(this, tu2Var, str3, gz2Var, str, p82Var, str2));
        }
    }

    public final void D(mv1 mv1Var, gz2 gz2Var, p82 p82Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mv1Var, gz2Var, p82Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(mv1Var, gz2Var, p82Var, str);
            } else {
                G(mv1Var, gz2Var, p82Var, str);
            }
        }
    }

    public final void E(mv1 mv1Var, gz2 gz2Var, p82 p82Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, mv1Var, gz2Var, p82Var, str, str2) == null) {
            if (an3.O()) {
                D(mv1Var, gz2Var, p82Var, str, str2);
            } else {
                an3.a0(new d(this, mv1Var, gz2Var, p82Var, str, str2));
            }
        }
    }

    public final void F(mv1 mv1Var, gz2 gz2Var, p82 p82Var, String str) {
        SwanAppActivity activity;
        o82 o82Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, mv1Var, gz2Var, p82Var, str) == null) && (activity = tu2.U().getActivity()) != null && !activity.isFinishing()) {
            pc3.e(mv1Var, gz2Var, str);
            m23.c(9, str);
            o82.V3(an3.n());
            p82.b k = p82Var.i("showModalPage").k("normal", gz2Var);
            if (!(p82Var.m() instanceof o82) || (o82Var = (o82) p82Var.m()) == null) {
                return;
            }
            o82Var.E0 = true;
            k.b();
            if (p82Var.k() > 1) {
                o82Var.A3().setBackgroundColor(0);
            } else {
                o82Var.E0 = false;
            }
            o82Var.C2(false);
            v82 v82Var = this.f;
            if (v82Var != null) {
                o82Var.U2(v82Var);
            }
            e eVar = new e(this, o82Var);
            this.f = eVar;
            o82Var.q2(eVar);
            View c2 = c83.c(o82Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            c83.h(o82Var);
            PullToRefreshBaseWebView h0 = mv1Var.h0();
            if (h0 != null) {
                h0.setIsPreventPullToRefresh(true);
            }
            l23.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            m23.a(str, gz2Var);
        }
    }

    public final void G(mv1 mv1Var, gz2 gz2Var, p82 p82Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, mv1Var, gz2Var, p82Var, str) == null) && (activity = tu2.U().getActivity()) != null && !activity.isFinishing()) {
            pc3.e(mv1Var, gz2Var, str);
            m23.c(0, str);
            if (p82Var.k() < g) {
                o82.V3(an3.n());
                p82.b i = p82Var.i("navigateTo");
                i.n(p82.g, p82.i);
                i.k("normal", gz2Var).b();
                ql3.c(p82Var, getContext());
                l23.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                m23.a(str, gz2Var);
                return;
            }
            az1.A(p82Var, gz2Var, str, true);
        }
    }

    public final g12 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            g93 b0 = g93.b0();
            if (b0 == null) {
                return new g12(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            m23.b(uuid);
            Pair<g12, JSONObject> s = s(str);
            g12 g12Var = (g12) s.first;
            if (!g12Var.isSuccess()) {
                return g12Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = pc3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                g62.c("NavigateToApi", "url is null");
                return new g12(202, "url is null");
            }
            tu2 U = tu2.U();
            p82 V = U.V();
            if (V == null) {
                g62.c("NavigateToApi", "manager is null");
                return new g12(1001, "manager is null");
            }
            gz2 d2 = gz2.d(p, U.z());
            d2.e = str2;
            d2.f = uuid;
            uf3.g(d2);
            if (!an3.b(U.s(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                g62.c("NavigateToApi", str4);
                uf3.i(d2);
                return new g12(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && g93.M() != null) {
                g93.M().L0(optString, d2.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = l23.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                g62.c("NavigateToApi", "cb is empty");
                uf3.i(d2);
                return new g12(202, "cb is empty");
            } else if (tb3.b().a(d2)) {
                tb3.b().i(str3, d2);
                g62.c("NavigateToApi", "access to this page is prohibited");
                return new g12(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, d2, uuid, str2));
                } else {
                    C(U, V, d2, uuid, str2, optString3);
                }
                return g12.f();
            }
        }
        return (g12) invokeLLL.objValue;
    }

    public final void K(lf2.e eVar, gz2 gz2Var, p82 p82Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, gz2Var, p82Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = l23.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            lf2.q(eVar, new c(this, eVar, str, gz2Var, p82Var, str2));
        }
    }
}
