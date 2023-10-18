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
import com.baidu.tieba.e93;
import com.baidu.tieba.ua3;
import com.baidu.tieba.ub2;
import com.baidu.tieba.y42;
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
public class jv1 extends hv1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public e52 f;

    @Override // com.baidu.tieba.tt1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ pv2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ y42 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ jv1 g;

        /* loaded from: classes6.dex */
        public class a implements e93.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p53 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, p53 p53Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, p53Var, activity};
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
                this.a = p53Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.e93.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    vy2.d(this.c.d);
                    p22.i("NavigateToApi", "check pages success");
                    ic3.F(true, this.a.Z().U());
                    this.c.a.p();
                    ub2.e f = ub2.f(this.b, zb2.c(this.c.c.a));
                    List<String> g = y83.g(this.c.e);
                    jv1 jv1Var = this.c.g;
                    p53 p53Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    y83.m(jv1Var, p53Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.L(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.e93.e
            public void b(int i, ih3 ih3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ih3Var) == null) {
                    p22.c("NavigateToApi", "check pages failed");
                    ic3.F(false, this.a.Z().U());
                    this.c.a.p();
                    b bVar = this.c;
                    y83.k(bVar.g, bVar.b);
                    dc3.j(this.c.c, ih3Var);
                }
            }
        }

        public b(jv1 jv1Var, cr2 cr2Var, String str, pv2 pv2Var, String str2, y42 y42Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jv1Var, cr2Var, str, pv2Var, str2, y42Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = jv1Var;
            this.a = cr2Var;
            this.b = str;
            this.c = pv2Var;
            this.d = str2;
            this.e = y42Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    p53 M = p53.M();
                    if (M == null) {
                        this.g.d(this.b, new qx1(1001, "swan app is null"));
                        dc3.i(this.c);
                        return;
                    }
                    this.a.a();
                    e93.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new qx1(1001, "swan activity is null"));
                dc3.i(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements ik3<sa3<ua3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ cr2 b;
        public final /* synthetic */ y42 c;
        public final /* synthetic */ pv2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ jv1 g;

        public a(jv1 jv1Var, String str, cr2 cr2Var, y42 y42Var, pv2 pv2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jv1Var, str, cr2Var, y42Var, pv2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = jv1Var;
            this.a = str;
            this.b = cr2Var;
            this.c = y42Var;
            this.d = pv2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(sa3<ua3.e> sa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sa3Var) == null) {
                if (!na3.h(sa3Var)) {
                    this.g.d(this.a, new qx1(10005, "system deny"));
                } else {
                    this.g.D(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ub2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ pv2 c;
        public final /* synthetic */ y42 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ jv1 f;

        public c(jv1 jv1Var, ub2.e eVar, String str, pv2 pv2Var, y42 y42Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jv1Var, eVar, str, pv2Var, y42Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = jv1Var;
            this.a = eVar;
            this.b = str;
            this.c = pv2Var;
            this.d = y42Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.ub2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vy2.e(this.a, this.b);
                this.f.F(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr1 a;
        public final /* synthetic */ pv2 b;
        public final /* synthetic */ y42 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ jv1 f;

        public d(jv1 jv1Var, wr1 wr1Var, pv2 pv2Var, y42 y42Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jv1Var, wr1Var, pv2Var, y42Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = jv1Var;
            this.a = wr1Var;
            this.b = pv2Var;
            this.c = y42Var;
            this.d = str;
            this.e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.f.E(this.a, this.b, this.c, this.d, this.e);
        }
    }

    /* loaded from: classes6.dex */
    public class e extends e52 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x42 a;
        public final /* synthetic */ jv1 b;

        public e(jv1 jv1Var, x42 x42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jv1Var, x42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jv1Var;
            this.a = x42Var;
        }

        @Override // com.baidu.tieba.e52, com.baidu.tieba.f52
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.Y2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.e52, com.baidu.tieba.f52
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = l43.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                l43.h(this.a);
            }
        }

        @Override // com.baidu.tieba.e52, com.baidu.tieba.f52
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = l43.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                l43.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947896644, "Lcom/baidu/tieba/jv1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947896644, "Lcom/baidu/tieba/jv1;");
                return;
            }
        }
        g = wo2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jv1(@NonNull rt1 rt1Var) {
        super(rt1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rt1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rt1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public qx1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            r("#navigateTo params=" + str, false);
            return J(str, "0", "navigateTo");
        }
        return (qx1) invokeL.objValue;
    }

    public qx1 K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            r("#showModalPage params" + str, false);
            return J(str, "7", "showModalPage");
        }
        return (qx1) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void D(cr2 cr2Var, y42 y42Var, pv2 pv2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{cr2Var, y42Var, pv2Var, str, str2, str3}) == null) {
            jj3.a0(new b(this, cr2Var, str3, pv2Var, str, y42Var, str2));
        }
    }

    public final void E(wr1 wr1Var, pv2 pv2Var, y42 y42Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wr1Var, pv2Var, y42Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                G(wr1Var, pv2Var, y42Var, str);
            } else {
                H(wr1Var, pv2Var, y42Var, str);
            }
        }
    }

    public final void F(wr1 wr1Var, pv2 pv2Var, y42 y42Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, wr1Var, pv2Var, y42Var, str, str2) == null) {
            if (jj3.O()) {
                E(wr1Var, pv2Var, y42Var, str, str2);
            } else {
                jj3.a0(new d(this, wr1Var, pv2Var, y42Var, str, str2));
            }
        }
    }

    public final void G(wr1 wr1Var, pv2 pv2Var, y42 y42Var, String str) {
        SwanAppActivity activity;
        x42 x42Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, wr1Var, pv2Var, y42Var, str) == null) && (activity = cr2.V().getActivity()) != null && !activity.isFinishing()) {
            y83.e(wr1Var, pv2Var, str);
            vy2.c(9, str);
            x42.Z3(jj3.n());
            y42.b k = y42Var.i("showModalPage").k("normal", pv2Var);
            if (!(y42Var.m() instanceof x42) || (x42Var = (x42) y42Var.m()) == null) {
                return;
            }
            x42Var.E0 = true;
            k.b();
            if (y42Var.k() > 1) {
                x42Var.E3().setBackgroundColor(0);
            } else {
                x42Var.E0 = false;
            }
            x42Var.G2(false);
            e52 e52Var = this.f;
            if (e52Var != null) {
                x42Var.Y2(e52Var);
            }
            e eVar = new e(this, x42Var);
            this.f = eVar;
            x42Var.u2(eVar);
            View c2 = l43.c(x42Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            l43.h(x42Var);
            PullToRefreshBaseWebView e0 = wr1Var.e0();
            if (e0 != null) {
                e0.setIsPreventPullToRefresh(true);
            }
            uy2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            vy2.a(str, pv2Var);
        }
    }

    public final void H(wr1 wr1Var, pv2 pv2Var, y42 y42Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, wr1Var, pv2Var, y42Var, str) == null) && (activity = cr2.V().getActivity()) != null && !activity.isFinishing()) {
            y83.e(wr1Var, pv2Var, str);
            vy2.c(0, str);
            if (y42Var.k() < g) {
                x42.Z3(jj3.n());
                y42.b i = y42Var.i("navigateTo");
                i.n(y42.g, y42.i);
                i.k("normal", pv2Var).b();
                zh3.c(y42Var, i());
                uy2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                vy2.a(str, pv2Var);
                return;
            }
            kv1.B(y42Var, pv2Var, str, true);
        }
    }

    public final qx1 J(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            p53 c0 = p53.c0();
            if (c0 == null) {
                return new qx1(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            vy2.b(uuid);
            Pair<qx1, JSONObject> t = t(str);
            qx1 qx1Var = (qx1) t.first;
            if (!qx1Var.isSuccess()) {
                return qx1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            String p = y83.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                p22.c("NavigateToApi", "url is null");
                return new qx1(202, "url is null");
            }
            cr2 V = cr2.V();
            y42 W = V.W();
            if (W == null) {
                p22.c("NavigateToApi", "manager is null");
                return new qx1(1001, "manager is null");
            }
            pv2 d2 = pv2.d(p, V.A());
            d2.e = str2;
            d2.f = uuid;
            dc3.g(d2);
            if (!jj3.b(V.t(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                p22.c("NavigateToApi", str4);
                dc3.i(d2);
                return new qx1(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && p53.M() != null) {
                p53.M().M0(optString, d2.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = uy2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                p22.c("NavigateToApi", "cb is empty");
                dc3.i(d2);
                return new qx1(202, "cb is empty");
            } else if (c83.b().a(d2)) {
                c83.b().i(str3, d2);
                p22.c("NavigateToApi", "access to this page is prohibited");
                return new qx1(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    c0.f0().g(i(), "mapp_show_modal_page", new a(this, optString3, V, W, d2, uuid, str2));
                } else {
                    D(V, W, d2, uuid, str2, optString3);
                }
                return qx1.f();
            }
        }
        return (qx1) invokeLLL.objValue;
    }

    public final void L(ub2.e eVar, pv2 pv2Var, y42 y42Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, pv2Var, y42Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = uy2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            ub2.q(eVar, new c(this, eVar, str, pv2Var, y42Var, str2));
        }
    }
}
