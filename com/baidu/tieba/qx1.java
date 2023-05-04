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
import com.baidu.tieba.cd3;
import com.baidu.tieba.ce2;
import com.baidu.tieba.g72;
import com.baidu.tieba.mb3;
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
/* loaded from: classes6.dex */
public class qx1 extends ox1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public m72 f;

    @Override // com.baidu.tieba.aw1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kt2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ xx2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ g72 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ qx1 g;

        /* loaded from: classes6.dex */
        public class a implements mb3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ x73 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, x73 x73Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, x73Var, activity};
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
                this.a = x73Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.mb3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    d13.d(this.c.d);
                    x42.i("NavigateToApi", "check pages success");
                    qe3.F(true, this.a.Y().T());
                    this.c.a.o();
                    ce2.e f = ce2.f(this.b, he2.c(this.c.c.a));
                    List<String> g = gb3.g(this.c.e);
                    qx1 qx1Var = this.c.g;
                    x73 x73Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    gb3.m(qx1Var, x73Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.mb3.e
            public void b(int i, qj3 qj3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, qj3Var) == null) {
                    x42.c("NavigateToApi", "check pages failed");
                    qe3.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    gb3.k(bVar.g, bVar.b);
                    le3.j(this.c.c, qj3Var);
                }
            }
        }

        public b(qx1 qx1Var, kt2 kt2Var, String str, xx2 xx2Var, String str2, g72 g72Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx1Var, kt2Var, str, xx2Var, str2, g72Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = qx1Var;
            this.a = kt2Var;
            this.b = str;
            this.c = xx2Var;
            this.d = str2;
            this.e = g72Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    x73 M = x73.M();
                    if (M == null) {
                        this.g.d(this.b, new xz1(1001, "swan app is null"));
                        le3.i(this.c);
                        return;
                    }
                    this.a.a();
                    mb3.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new xz1(1001, "swan activity is null"));
                le3.i(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements qm3<ad3<cd3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ kt2 b;
        public final /* synthetic */ g72 c;
        public final /* synthetic */ xx2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ qx1 g;

        public a(qx1 qx1Var, String str, kt2 kt2Var, g72 g72Var, xx2 xx2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx1Var, str, kt2Var, g72Var, xx2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = qx1Var;
            this.a = str;
            this.b = kt2Var;
            this.c = g72Var;
            this.d = xx2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(ad3<cd3.e> ad3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ad3Var) == null) {
                if (!vc3.h(ad3Var)) {
                    this.g.d(this.a, new xz1(10005, "system deny"));
                } else {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ce2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ce2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ xx2 c;
        public final /* synthetic */ g72 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ qx1 f;

        public c(qx1 qx1Var, ce2.e eVar, String str, xx2 xx2Var, g72 g72Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx1Var, eVar, str, xx2Var, g72Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = qx1Var;
            this.a = eVar;
            this.b = str;
            this.c = xx2Var;
            this.d = g72Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.ce2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d13.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ du1 a;
        public final /* synthetic */ xx2 b;
        public final /* synthetic */ g72 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ qx1 f;

        public d(qx1 qx1Var, du1 du1Var, xx2 xx2Var, g72 g72Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx1Var, du1Var, xx2Var, g72Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = qx1Var;
            this.a = du1Var;
            this.b = xx2Var;
            this.c = g72Var;
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

    /* loaded from: classes6.dex */
    public class e extends m72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72 a;
        public final /* synthetic */ qx1 b;

        public e(qx1 qx1Var, f72 f72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx1Var, f72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qx1Var;
            this.a = f72Var;
        }

        @Override // com.baidu.tieba.m72, com.baidu.tieba.n72
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.U2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.m72, com.baidu.tieba.n72
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = t63.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                t63.h(this.a);
            }
        }

        @Override // com.baidu.tieba.m72, com.baidu.tieba.n72
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = t63.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                t63.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948107103, "Lcom/baidu/tieba/qx1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948107103, "Lcom/baidu/tieba/qx1;");
                return;
            }
        }
        g = er2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qx1(@NonNull yv1 yv1Var) {
        super(yv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yv1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((yv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public xz1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (xz1) invokeL.objValue;
    }

    public xz1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (xz1) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(kt2 kt2Var, g72 g72Var, xx2 xx2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{kt2Var, g72Var, xx2Var, str, str2, str3}) == null) {
            rl3.a0(new b(this, kt2Var, str3, xx2Var, str, g72Var, str2));
        }
    }

    public final void D(du1 du1Var, xx2 xx2Var, g72 g72Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, du1Var, xx2Var, g72Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(du1Var, xx2Var, g72Var, str);
            } else {
                G(du1Var, xx2Var, g72Var, str);
            }
        }
    }

    public final void E(du1 du1Var, xx2 xx2Var, g72 g72Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, du1Var, xx2Var, g72Var, str, str2) == null) {
            if (rl3.O()) {
                D(du1Var, xx2Var, g72Var, str, str2);
            } else {
                rl3.a0(new d(this, du1Var, xx2Var, g72Var, str, str2));
            }
        }
    }

    public final void F(du1 du1Var, xx2 xx2Var, g72 g72Var, String str) {
        SwanAppActivity activity;
        f72 f72Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, du1Var, xx2Var, g72Var, str) == null) && (activity = kt2.U().getActivity()) != null && !activity.isFinishing()) {
            gb3.e(du1Var, xx2Var, str);
            d13.c(9, str);
            f72.V3(rl3.n());
            g72.b k = g72Var.i("showModalPage").k("normal", xx2Var);
            if (!(g72Var.m() instanceof f72) || (f72Var = (f72) g72Var.m()) == null) {
                return;
            }
            f72Var.E0 = true;
            k.b();
            if (g72Var.k() > 1) {
                f72Var.A3().setBackgroundColor(0);
            } else {
                f72Var.E0 = false;
            }
            f72Var.C2(false);
            m72 m72Var = this.f;
            if (m72Var != null) {
                f72Var.U2(m72Var);
            }
            e eVar = new e(this, f72Var);
            this.f = eVar;
            f72Var.q2(eVar);
            View c2 = t63.c(f72Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            t63.h(f72Var);
            PullToRefreshBaseWebView h0 = du1Var.h0();
            if (h0 != null) {
                h0.setIsPreventPullToRefresh(true);
            }
            c13.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            d13.a(str, xx2Var);
        }
    }

    public final void G(du1 du1Var, xx2 xx2Var, g72 g72Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, du1Var, xx2Var, g72Var, str) == null) && (activity = kt2.U().getActivity()) != null && !activity.isFinishing()) {
            gb3.e(du1Var, xx2Var, str);
            d13.c(0, str);
            if (g72Var.k() < g) {
                f72.V3(rl3.n());
                g72.b i = g72Var.i("navigateTo");
                i.n(g72.g, g72.i);
                i.k("normal", xx2Var).b();
                hk3.c(g72Var, getContext());
                c13.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                d13.a(str, xx2Var);
                return;
            }
            rx1.A(g72Var, xx2Var, str, true);
        }
    }

    public final xz1 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            x73 b0 = x73.b0();
            if (b0 == null) {
                return new xz1(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            d13.b(uuid);
            Pair<xz1, JSONObject> s = s(str);
            xz1 xz1Var = (xz1) s.first;
            if (!xz1Var.isSuccess()) {
                return xz1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = gb3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                x42.c("NavigateToApi", "url is null");
                return new xz1(202, "url is null");
            }
            kt2 U = kt2.U();
            g72 V = U.V();
            if (V == null) {
                x42.c("NavigateToApi", "manager is null");
                return new xz1(1001, "manager is null");
            }
            xx2 d2 = xx2.d(p, U.z());
            d2.e = str2;
            d2.f = uuid;
            le3.g(d2);
            if (!rl3.b(U.s(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                x42.c("NavigateToApi", str4);
                le3.i(d2);
                return new xz1(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && x73.M() != null) {
                x73.M().L0(optString, d2.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = c13.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                x42.c("NavigateToApi", "cb is empty");
                le3.i(d2);
                return new xz1(202, "cb is empty");
            } else if (ka3.b().a(d2)) {
                ka3.b().i(str3, d2);
                x42.c("NavigateToApi", "access to this page is prohibited");
                return new xz1(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, d2, uuid, str2));
                } else {
                    C(U, V, d2, uuid, str2, optString3);
                }
                return xz1.f();
            }
        }
        return (xz1) invokeLLL.objValue;
    }

    public final void K(ce2.e eVar, xx2 xx2Var, g72 g72Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, xx2Var, g72Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = c13.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            ce2.q(eVar, new c(this, eVar, str, xx2Var, g72Var, str2));
        }
    }
}
