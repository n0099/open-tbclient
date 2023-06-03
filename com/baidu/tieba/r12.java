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
import com.baidu.tieba.dh3;
import com.baidu.tieba.di2;
import com.baidu.tieba.hb2;
import com.baidu.tieba.nf3;
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
public class r12 extends p12 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public nb2 f;

    @Override // com.baidu.tieba.b02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lx2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ y13 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ hb2 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ r12 g;

        /* loaded from: classes7.dex */
        public class a implements nf3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ yb3 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, yb3 yb3Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, yb3Var, activity};
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
                this.a = yb3Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.nf3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    e53.d(this.c.d);
                    y82.i("NavigateToApi", "check pages success");
                    ri3.F(true, this.a.Y().T());
                    this.c.a.o();
                    di2.e f = di2.f(this.b, ii2.c(this.c.c.a));
                    List<String> g = hf3.g(this.c.e);
                    r12 r12Var = this.c.g;
                    yb3 yb3Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    hf3.m(r12Var, yb3Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.nf3.e
            public void b(int i, rn3 rn3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, rn3Var) == null) {
                    y82.c("NavigateToApi", "check pages failed");
                    ri3.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    hf3.k(bVar.g, bVar.b);
                    mi3.j(this.c.c, rn3Var);
                }
            }
        }

        public b(r12 r12Var, lx2 lx2Var, String str, y13 y13Var, String str2, hb2 hb2Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r12Var, lx2Var, str, y13Var, str2, hb2Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = r12Var;
            this.a = lx2Var;
            this.b = str;
            this.c = y13Var;
            this.d = str2;
            this.e = hb2Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    yb3 M = yb3.M();
                    if (M == null) {
                        this.g.d(this.b, new y32(1001, "swan app is null"));
                        mi3.i(this.c);
                        return;
                    }
                    this.a.a();
                    nf3.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new y32(1001, "swan activity is null"));
                mi3.i(this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements rq3<bh3<dh3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ lx2 b;
        public final /* synthetic */ hb2 c;
        public final /* synthetic */ y13 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ r12 g;

        public a(r12 r12Var, String str, lx2 lx2Var, hb2 hb2Var, y13 y13Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r12Var, str, lx2Var, hb2Var, y13Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = r12Var;
            this.a = str;
            this.b = lx2Var;
            this.c = hb2Var;
            this.d = y13Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(bh3<dh3.e> bh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bh3Var) == null) {
                if (!wg3.h(bh3Var)) {
                    this.g.d(this.a, new y32(10005, "system deny"));
                } else {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements di2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ di2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ y13 c;
        public final /* synthetic */ hb2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ r12 f;

        public c(r12 r12Var, di2.e eVar, String str, y13 y13Var, hb2 hb2Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r12Var, eVar, str, y13Var, hb2Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = r12Var;
            this.a = eVar;
            this.b = str;
            this.c = y13Var;
            this.d = hb2Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.di2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e53.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ey1 a;
        public final /* synthetic */ y13 b;
        public final /* synthetic */ hb2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ r12 f;

        public d(r12 r12Var, ey1 ey1Var, y13 y13Var, hb2 hb2Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r12Var, ey1Var, y13Var, hb2Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = r12Var;
            this.a = ey1Var;
            this.b = y13Var;
            this.c = hb2Var;
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
    public class e extends nb2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gb2 a;
        public final /* synthetic */ r12 b;

        public e(r12 r12Var, gb2 gb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r12Var, gb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r12Var;
            this.a = gb2Var;
        }

        @Override // com.baidu.tieba.nb2, com.baidu.tieba.ob2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.T2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.nb2, com.baidu.tieba.ob2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = ua3.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                ua3.h(this.a);
            }
        }

        @Override // com.baidu.tieba.nb2, com.baidu.tieba.ob2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = ua3.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                ua3.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948068694, "Lcom/baidu/tieba/r12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948068694, "Lcom/baidu/tieba/r12;");
                return;
            }
        }
        g = fv2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r12(@NonNull zz1 zz1Var) {
        super(zz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zz1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public y32 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (y32) invokeL.objValue;
    }

    public y32 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (y32) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(lx2 lx2Var, hb2 hb2Var, y13 y13Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{lx2Var, hb2Var, y13Var, str, str2, str3}) == null) {
            sp3.a0(new b(this, lx2Var, str3, y13Var, str, hb2Var, str2));
        }
    }

    public final void D(ey1 ey1Var, y13 y13Var, hb2 hb2Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ey1Var, y13Var, hb2Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(ey1Var, y13Var, hb2Var, str);
            } else {
                G(ey1Var, y13Var, hb2Var, str);
            }
        }
    }

    public final void E(ey1 ey1Var, y13 y13Var, hb2 hb2Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, ey1Var, y13Var, hb2Var, str, str2) == null) {
            if (sp3.O()) {
                D(ey1Var, y13Var, hb2Var, str, str2);
            } else {
                sp3.a0(new d(this, ey1Var, y13Var, hb2Var, str, str2));
            }
        }
    }

    public final void F(ey1 ey1Var, y13 y13Var, hb2 hb2Var, String str) {
        SwanAppActivity activity;
        gb2 gb2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, ey1Var, y13Var, hb2Var, str) == null) && (activity = lx2.T().getActivity()) != null && !activity.isFinishing()) {
            hf3.e(ey1Var, y13Var, str);
            e53.c(9, str);
            gb2.U3(sp3.n());
            hb2.b k = hb2Var.i("showModalPage").k("normal", y13Var);
            if (!(hb2Var.m() instanceof gb2) || (gb2Var = (gb2) hb2Var.m()) == null) {
                return;
            }
            gb2Var.E0 = true;
            k.b();
            if (hb2Var.k() > 1) {
                gb2Var.z3().setBackgroundColor(0);
            } else {
                gb2Var.E0 = false;
            }
            gb2Var.B2(false);
            nb2 nb2Var = this.f;
            if (nb2Var != null) {
                gb2Var.T2(nb2Var);
            }
            e eVar = new e(this, gb2Var);
            this.f = eVar;
            gb2Var.p2(eVar);
            View c2 = ua3.c(gb2Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            ua3.h(gb2Var);
            PullToRefreshBaseWebView f0 = ey1Var.f0();
            if (f0 != null) {
                f0.setIsPreventPullToRefresh(true);
            }
            d53.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            e53.a(str, y13Var);
        }
    }

    public final void G(ey1 ey1Var, y13 y13Var, hb2 hb2Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, ey1Var, y13Var, hb2Var, str) == null) && (activity = lx2.T().getActivity()) != null && !activity.isFinishing()) {
            hf3.e(ey1Var, y13Var, str);
            e53.c(0, str);
            if (hb2Var.k() < g) {
                gb2.U3(sp3.n());
                hb2.b i = hb2Var.i("navigateTo");
                i.n(hb2.g, hb2.i);
                i.k("normal", y13Var).b();
                io3.c(hb2Var, getContext());
                d53.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                e53.a(str, y13Var);
                return;
            }
            s12.A(hb2Var, y13Var, str, true);
        }
    }

    public final y32 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            yb3 b0 = yb3.b0();
            if (b0 == null) {
                return new y32(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            e53.b(uuid);
            Pair<y32, JSONObject> s = s(str);
            y32 y32Var = (y32) s.first;
            if (!y32Var.isSuccess()) {
                return y32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = hf3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                y82.c("NavigateToApi", "url is null");
                return new y32(202, "url is null");
            }
            lx2 T2 = lx2.T();
            hb2 U = T2.U();
            if (U == null) {
                y82.c("NavigateToApi", "manager is null");
                return new y32(1001, "manager is null");
            }
            y13 d2 = y13.d(p, T2.z());
            d2.e = str2;
            d2.f = uuid;
            mi3.g(d2);
            if (!sp3.b(T2.s(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                y82.c("NavigateToApi", str4);
                mi3.i(d2);
                return new y32(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && yb3.M() != null) {
                yb3.M().L0(optString, d2.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = d53.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                y82.c("NavigateToApi", "cb is empty");
                mi3.i(d2);
                return new y32(202, "cb is empty");
            } else if (le3.b().a(d2)) {
                le3.b().i(str3, d2);
                y82.c("NavigateToApi", "access to this page is prohibited");
                return new y32(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, T2, U, d2, uuid, str2));
                } else {
                    C(T2, U, d2, uuid, str2, optString3);
                }
                return y32.f();
            }
        }
        return (y32) invokeLLL.objValue;
    }

    public final void K(di2.e eVar, y13 y13Var, hb2 hb2Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, y13Var, hb2Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = d53.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            di2.q(eVar, new c(this, eVar, str, y13Var, hb2Var, str2));
        }
    }
}
