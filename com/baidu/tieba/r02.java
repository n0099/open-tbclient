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
import com.baidu.tieba.dg3;
import com.baidu.tieba.dh2;
import com.baidu.tieba.ha2;
import com.baidu.tieba.ne3;
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
/* loaded from: classes7.dex */
public class r02 extends p02 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public na2 f;

    @Override // com.baidu.tieba.bz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lw2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ y03 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ha2 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ r02 g;

        /* loaded from: classes7.dex */
        public class a implements ne3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ya3 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, ya3 ya3Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, ya3Var, activity};
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
                this.a = ya3Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.ne3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    e43.d(this.c.d);
                    y72.i("NavigateToApi", "check pages success");
                    rh3.F(true, this.a.Y().T());
                    this.c.a.o();
                    dh2.e f = dh2.f(this.b, ih2.c(this.c.c.a));
                    List<String> g = he3.g(this.c.e);
                    r02 r02Var = this.c.g;
                    ya3 ya3Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    he3.m(r02Var, ya3Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.ne3.e
            public void b(int i, rm3 rm3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, rm3Var) == null) {
                    y72.c("NavigateToApi", "check pages failed");
                    rh3.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    he3.k(bVar.g, bVar.b);
                    mh3.j(this.c.c, rm3Var);
                }
            }
        }

        public b(r02 r02Var, lw2 lw2Var, String str, y03 y03Var, String str2, ha2 ha2Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r02Var, lw2Var, str, y03Var, str2, ha2Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = r02Var;
            this.a = lw2Var;
            this.b = str;
            this.c = y03Var;
            this.d = str2;
            this.e = ha2Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    ya3 M = ya3.M();
                    if (M == null) {
                        this.g.d(this.b, new y22(1001, "swan app is null"));
                        mh3.i(this.c);
                        return;
                    }
                    this.a.a();
                    ne3.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new y22(1001, "swan activity is null"));
                mh3.i(this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements rp3<bg3<dg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ lw2 b;
        public final /* synthetic */ ha2 c;
        public final /* synthetic */ y03 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ r02 g;

        public a(r02 r02Var, String str, lw2 lw2Var, ha2 ha2Var, y03 y03Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r02Var, str, lw2Var, ha2Var, y03Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = r02Var;
            this.a = str;
            this.b = lw2Var;
            this.c = ha2Var;
            this.d = y03Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(bg3<dg3.e> bg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bg3Var) == null) {
                if (!wf3.h(bg3Var)) {
                    this.g.d(this.a, new y22(10005, "system deny"));
                } else {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements dh2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ y03 c;
        public final /* synthetic */ ha2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ r02 f;

        public c(r02 r02Var, dh2.e eVar, String str, y03 y03Var, ha2 ha2Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r02Var, eVar, str, y03Var, ha2Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = r02Var;
            this.a = eVar;
            this.b = str;
            this.c = y03Var;
            this.d = ha2Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.dh2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e43.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex1 a;
        public final /* synthetic */ y03 b;
        public final /* synthetic */ ha2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ r02 f;

        public d(r02 r02Var, ex1 ex1Var, y03 y03Var, ha2 ha2Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r02Var, ex1Var, y03Var, ha2Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = r02Var;
            this.a = ex1Var;
            this.b = y03Var;
            this.c = ha2Var;
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

    /* loaded from: classes7.dex */
    public class e extends na2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga2 a;
        public final /* synthetic */ r02 b;

        public e(r02 r02Var, ga2 ga2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r02Var, ga2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r02Var;
            this.a = ga2Var;
        }

        @Override // com.baidu.tieba.na2, com.baidu.tieba.oa2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.T2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.na2, com.baidu.tieba.oa2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = u93.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                u93.h(this.a);
            }
        }

        @Override // com.baidu.tieba.na2, com.baidu.tieba.oa2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = u93.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                u93.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948067733, "Lcom/baidu/tieba/r02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948067733, "Lcom/baidu/tieba/r02;");
                return;
            }
        }
        g = fu2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r02(@NonNull zy1 zy1Var) {
        super(zy1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zy1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zy1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public y22 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (y22) invokeL.objValue;
    }

    public y22 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (y22) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(lw2 lw2Var, ha2 ha2Var, y03 y03Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{lw2Var, ha2Var, y03Var, str, str2, str3}) == null) {
            so3.a0(new b(this, lw2Var, str3, y03Var, str, ha2Var, str2));
        }
    }

    public final void D(ex1 ex1Var, y03 y03Var, ha2 ha2Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ex1Var, y03Var, ha2Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(ex1Var, y03Var, ha2Var, str);
            } else {
                G(ex1Var, y03Var, ha2Var, str);
            }
        }
    }

    public final void E(ex1 ex1Var, y03 y03Var, ha2 ha2Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, ex1Var, y03Var, ha2Var, str, str2) == null) {
            if (so3.O()) {
                D(ex1Var, y03Var, ha2Var, str, str2);
            } else {
                so3.a0(new d(this, ex1Var, y03Var, ha2Var, str, str2));
            }
        }
    }

    public final void F(ex1 ex1Var, y03 y03Var, ha2 ha2Var, String str) {
        SwanAppActivity activity;
        ga2 ga2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, ex1Var, y03Var, ha2Var, str) == null) && (activity = lw2.T().getActivity()) != null && !activity.isFinishing()) {
            he3.e(ex1Var, y03Var, str);
            e43.c(9, str);
            ga2.U3(so3.n());
            ha2.b k = ha2Var.i("showModalPage").k("normal", y03Var);
            if (!(ha2Var.m() instanceof ga2) || (ga2Var = (ga2) ha2Var.m()) == null) {
                return;
            }
            ga2Var.E0 = true;
            k.b();
            if (ha2Var.k() > 1) {
                ga2Var.z3().setBackgroundColor(0);
            } else {
                ga2Var.E0 = false;
            }
            ga2Var.B2(false);
            na2 na2Var = this.f;
            if (na2Var != null) {
                ga2Var.T2(na2Var);
            }
            e eVar = new e(this, ga2Var);
            this.f = eVar;
            ga2Var.p2(eVar);
            View c2 = u93.c(ga2Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            u93.h(ga2Var);
            PullToRefreshBaseWebView f0 = ex1Var.f0();
            if (f0 != null) {
                f0.setIsPreventPullToRefresh(true);
            }
            d43.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            e43.a(str, y03Var);
        }
    }

    public final void G(ex1 ex1Var, y03 y03Var, ha2 ha2Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, ex1Var, y03Var, ha2Var, str) == null) && (activity = lw2.T().getActivity()) != null && !activity.isFinishing()) {
            he3.e(ex1Var, y03Var, str);
            e43.c(0, str);
            if (ha2Var.k() < g) {
                ga2.U3(so3.n());
                ha2.b i = ha2Var.i("navigateTo");
                i.n(ha2.g, ha2.i);
                i.k("normal", y03Var).b();
                in3.c(ha2Var, getContext());
                d43.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                e43.a(str, y03Var);
                return;
            }
            s02.A(ha2Var, y03Var, str, true);
        }
    }

    public final y22 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            ya3 b0 = ya3.b0();
            if (b0 == null) {
                return new y22(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            e43.b(uuid);
            Pair<y22, JSONObject> s = s(str);
            y22 y22Var = (y22) s.first;
            if (!y22Var.isSuccess()) {
                return y22Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = he3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                y72.c("NavigateToApi", "url is null");
                return new y22(202, "url is null");
            }
            lw2 T2 = lw2.T();
            ha2 U = T2.U();
            if (U == null) {
                y72.c("NavigateToApi", "manager is null");
                return new y22(1001, "manager is null");
            }
            y03 d2 = y03.d(p, T2.z());
            d2.e = str2;
            d2.f = uuid;
            mh3.g(d2);
            if (!so3.b(T2.s(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                y72.c("NavigateToApi", str4);
                mh3.i(d2);
                return new y22(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && ya3.M() != null) {
                ya3.M().L0(optString, d2.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = d43.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                y72.c("NavigateToApi", "cb is empty");
                mh3.i(d2);
                return new y22(202, "cb is empty");
            } else if (ld3.b().a(d2)) {
                ld3.b().i(str3, d2);
                y72.c("NavigateToApi", "access to this page is prohibited");
                return new y22(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, T2, U, d2, uuid, str2));
                } else {
                    C(T2, U, d2, uuid, str2, optString3);
                }
                return y22.f();
            }
        }
        return (y22) invokeLLL.objValue;
    }

    public final void K(dh2.e eVar, y03 y03Var, ha2 ha2Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, y03Var, ha2Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = d43.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            dh2.q(eVar, new c(this, eVar, str, y03Var, ha2Var, str2));
        }
    }
}
