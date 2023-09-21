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
import com.baidu.tieba.lg3;
import com.baidu.tieba.lh2;
import com.baidu.tieba.pa2;
import com.baidu.tieba.ve3;
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
public class z02 extends x02 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public va2 f;

    @Override // com.baidu.tieba.jz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tw2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ g13 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ pa2 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ z02 g;

        /* loaded from: classes8.dex */
        public class a implements ve3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gb3 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, gb3 gb3Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, gb3Var, activity};
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
                this.a = gb3Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.ve3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    m43.d(this.c.d);
                    g82.i("NavigateToApi", "check pages success");
                    zh3.F(true, this.a.Y().T());
                    this.c.a.o();
                    lh2.e f = lh2.f(this.b, qh2.c(this.c.c.a));
                    List<String> g = pe3.g(this.c.e);
                    z02 z02Var = this.c.g;
                    gb3 gb3Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    pe3.m(z02Var, gb3Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.ve3.e
            public void b(int i, zm3 zm3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, zm3Var) == null) {
                    g82.c("NavigateToApi", "check pages failed");
                    zh3.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    pe3.k(bVar.g, bVar.b);
                    uh3.j(this.c.c, zm3Var);
                }
            }
        }

        public b(z02 z02Var, tw2 tw2Var, String str, g13 g13Var, String str2, pa2 pa2Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z02Var, tw2Var, str, g13Var, str2, pa2Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = z02Var;
            this.a = tw2Var;
            this.b = str;
            this.c = g13Var;
            this.d = str2;
            this.e = pa2Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    gb3 M = gb3.M();
                    if (M == null) {
                        this.g.d(this.b, new g32(1001, "swan app is null"));
                        uh3.i(this.c);
                        return;
                    }
                    this.a.a();
                    ve3.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new g32(1001, "swan activity is null"));
                uh3.i(this.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements zp3<jg3<lg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ tw2 b;
        public final /* synthetic */ pa2 c;
        public final /* synthetic */ g13 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ z02 g;

        public a(z02 z02Var, String str, tw2 tw2Var, pa2 pa2Var, g13 g13Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z02Var, str, tw2Var, pa2Var, g13Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = z02Var;
            this.a = str;
            this.b = tw2Var;
            this.c = pa2Var;
            this.d = g13Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(jg3<lg3.e> jg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jg3Var) == null) {
                if (!eg3.h(jg3Var)) {
                    this.g.d(this.a, new g32(10005, "system deny"));
                } else {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements lh2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ g13 c;
        public final /* synthetic */ pa2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ z02 f;

        public c(z02 z02Var, lh2.e eVar, String str, g13 g13Var, pa2 pa2Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z02Var, eVar, str, g13Var, pa2Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = z02Var;
            this.a = eVar;
            this.b = str;
            this.c = g13Var;
            this.d = pa2Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.lh2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m43.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx1 a;
        public final /* synthetic */ g13 b;
        public final /* synthetic */ pa2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ z02 f;

        public d(z02 z02Var, mx1 mx1Var, g13 g13Var, pa2 pa2Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z02Var, mx1Var, g13Var, pa2Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = z02Var;
            this.a = mx1Var;
            this.b = g13Var;
            this.c = pa2Var;
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
    public class e extends va2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oa2 a;
        public final /* synthetic */ z02 b;

        public e(z02 z02Var, oa2 oa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z02Var, oa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z02Var;
            this.a = oa2Var;
        }

        @Override // com.baidu.tieba.va2, com.baidu.tieba.wa2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.T2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.va2, com.baidu.tieba.wa2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = ca3.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                ca3.h(this.a);
            }
        }

        @Override // com.baidu.tieba.va2, com.baidu.tieba.wa2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = ca3.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                ca3.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948306061, "Lcom/baidu/tieba/z02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948306061, "Lcom/baidu/tieba/z02;");
                return;
            }
        }
        g = nu2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z02(@NonNull hz1 hz1Var) {
        super(hz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hz1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((hz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public g32 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (g32) invokeL.objValue;
    }

    public g32 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (g32) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(tw2 tw2Var, pa2 pa2Var, g13 g13Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tw2Var, pa2Var, g13Var, str, str2, str3}) == null) {
            ap3.a0(new b(this, tw2Var, str3, g13Var, str, pa2Var, str2));
        }
    }

    public final void D(mx1 mx1Var, g13 g13Var, pa2 pa2Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mx1Var, g13Var, pa2Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(mx1Var, g13Var, pa2Var, str);
            } else {
                G(mx1Var, g13Var, pa2Var, str);
            }
        }
    }

    public final void E(mx1 mx1Var, g13 g13Var, pa2 pa2Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, mx1Var, g13Var, pa2Var, str, str2) == null) {
            if (ap3.O()) {
                D(mx1Var, g13Var, pa2Var, str, str2);
            } else {
                ap3.a0(new d(this, mx1Var, g13Var, pa2Var, str, str2));
            }
        }
    }

    public final void F(mx1 mx1Var, g13 g13Var, pa2 pa2Var, String str) {
        SwanAppActivity activity;
        oa2 oa2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, mx1Var, g13Var, pa2Var, str) == null) && (activity = tw2.T().getActivity()) != null && !activity.isFinishing()) {
            pe3.e(mx1Var, g13Var, str);
            m43.c(9, str);
            oa2.U3(ap3.n());
            pa2.b k = pa2Var.i("showModalPage").k("normal", g13Var);
            if (!(pa2Var.m() instanceof oa2) || (oa2Var = (oa2) pa2Var.m()) == null) {
                return;
            }
            oa2Var.E0 = true;
            k.b();
            if (pa2Var.k() > 1) {
                oa2Var.z3().setBackgroundColor(0);
            } else {
                oa2Var.E0 = false;
            }
            oa2Var.B2(false);
            va2 va2Var = this.f;
            if (va2Var != null) {
                oa2Var.T2(va2Var);
            }
            e eVar = new e(this, oa2Var);
            this.f = eVar;
            oa2Var.p2(eVar);
            View c2 = ca3.c(oa2Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            ca3.h(oa2Var);
            PullToRefreshBaseWebView f0 = mx1Var.f0();
            if (f0 != null) {
                f0.setIsPreventPullToRefresh(true);
            }
            l43.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            m43.a(str, g13Var);
        }
    }

    public final void G(mx1 mx1Var, g13 g13Var, pa2 pa2Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, mx1Var, g13Var, pa2Var, str) == null) && (activity = tw2.T().getActivity()) != null && !activity.isFinishing()) {
            pe3.e(mx1Var, g13Var, str);
            m43.c(0, str);
            if (pa2Var.k() < g) {
                oa2.U3(ap3.n());
                pa2.b i = pa2Var.i("navigateTo");
                i.n(pa2.g, pa2.i);
                i.k("normal", g13Var).b();
                qn3.c(pa2Var, getContext());
                l43.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                m43.a(str, g13Var);
                return;
            }
            a12.A(pa2Var, g13Var, str, true);
        }
    }

    public final g32 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            gb3 b0 = gb3.b0();
            if (b0 == null) {
                return new g32(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            m43.b(uuid);
            Pair<g32, JSONObject> s = s(str);
            g32 g32Var = (g32) s.first;
            if (!g32Var.isSuccess()) {
                return g32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = pe3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                g82.c("NavigateToApi", "url is null");
                return new g32(202, "url is null");
            }
            tw2 T2 = tw2.T();
            pa2 U = T2.U();
            if (U == null) {
                g82.c("NavigateToApi", "manager is null");
                return new g32(1001, "manager is null");
            }
            g13 d2 = g13.d(p, T2.z());
            d2.e = str2;
            d2.f = uuid;
            uh3.g(d2);
            if (!ap3.b(T2.s(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                g82.c("NavigateToApi", str4);
                uh3.i(d2);
                return new g32(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && gb3.M() != null) {
                gb3.M().L0(optString, d2.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = l43.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                g82.c("NavigateToApi", "cb is empty");
                uh3.i(d2);
                return new g32(202, "cb is empty");
            } else if (td3.b().a(d2)) {
                td3.b().i(str3, d2);
                g82.c("NavigateToApi", "access to this page is prohibited");
                return new g32(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, T2, U, d2, uuid, str2));
                } else {
                    C(T2, U, d2, uuid, str2, optString3);
                }
                return g32.f();
            }
        }
        return (g32) invokeLLL.objValue;
    }

    public final void K(lh2.e eVar, g13 g13Var, pa2 pa2Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, g13Var, pa2Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = l43.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            lh2.q(eVar, new c(this, eVar, str, g13Var, pa2Var, str2));
        }
    }
}
