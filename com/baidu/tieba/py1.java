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
import com.baidu.tieba.be3;
import com.baidu.tieba.bf2;
import com.baidu.tieba.f82;
import com.baidu.tieba.lc3;
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
public class py1 extends ny1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public l82 f;

    @Override // com.baidu.tieba.zw1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ wy2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ f82 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ py1 g;

        /* loaded from: classes5.dex */
        public class a implements lc3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ w83 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, w83 w83Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, w83Var, activity};
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
                this.a = w83Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.lc3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    c23.d(this.c.d);
                    w52.i("NavigateToApi", "check pages success");
                    pf3.F(true, this.a.Y().T());
                    this.c.a.o();
                    bf2.e f = bf2.f(this.b, gf2.c(this.c.c.a));
                    List<String> g = fc3.g(this.c.e);
                    py1 py1Var = this.c.g;
                    w83 w83Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    fc3.m(py1Var, w83Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.lc3.e
            public void b(int i, pk3 pk3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, pk3Var) == null) {
                    w52.c("NavigateToApi", "check pages failed");
                    pf3.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    fc3.k(bVar.g, bVar.b);
                    kf3.j(this.c.c, pk3Var);
                }
            }
        }

        public b(py1 py1Var, ju2 ju2Var, String str, wy2 wy2Var, String str2, f82 f82Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {py1Var, ju2Var, str, wy2Var, str2, f82Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = py1Var;
            this.a = ju2Var;
            this.b = str;
            this.c = wy2Var;
            this.d = str2;
            this.e = f82Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    w83 M = w83.M();
                    if (M == null) {
                        this.g.d(this.b, new w02(1001, "swan app is null"));
                        kf3.i(this.c);
                        return;
                    }
                    this.a.a();
                    lc3.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new w02(1001, "swan activity is null"));
                kf3.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements pn3<zd3<be3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ju2 b;
        public final /* synthetic */ f82 c;
        public final /* synthetic */ wy2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ py1 g;

        public a(py1 py1Var, String str, ju2 ju2Var, f82 f82Var, wy2 wy2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {py1Var, str, ju2Var, f82Var, wy2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = py1Var;
            this.a = str;
            this.b = ju2Var;
            this.c = f82Var;
            this.d = wy2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pn3
        /* renamed from: b */
        public void a(zd3<be3.e> zd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zd3Var) == null) {
                if (!ud3.h(zd3Var)) {
                    this.g.d(this.a, new w02(10005, "system deny"));
                } else {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements bf2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bf2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ wy2 c;
        public final /* synthetic */ f82 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ py1 f;

        public c(py1 py1Var, bf2.e eVar, String str, wy2 wy2Var, f82 f82Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {py1Var, eVar, str, wy2Var, f82Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = py1Var;
            this.a = eVar;
            this.b = str;
            this.c = wy2Var;
            this.d = f82Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.bf2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c23.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cv1 a;
        public final /* synthetic */ wy2 b;
        public final /* synthetic */ f82 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ py1 f;

        public d(py1 py1Var, cv1 cv1Var, wy2 wy2Var, f82 f82Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {py1Var, cv1Var, wy2Var, f82Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = py1Var;
            this.a = cv1Var;
            this.b = wy2Var;
            this.c = f82Var;
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

    /* loaded from: classes5.dex */
    public class e extends l82 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e82 a;
        public final /* synthetic */ py1 b;

        public e(py1 py1Var, e82 e82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {py1Var, e82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = py1Var;
            this.a = e82Var;
        }

        @Override // com.baidu.tieba.l82, com.baidu.tieba.m82
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.R2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.l82, com.baidu.tieba.m82
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = s73.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                s73.h(this.a);
            }
        }

        @Override // com.baidu.tieba.l82, com.baidu.tieba.m82
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = s73.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                s73.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948078273, "Lcom/baidu/tieba/py1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948078273, "Lcom/baidu/tieba/py1;");
                return;
            }
        }
        g = ds2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public py1(@NonNull xw1 xw1Var) {
        super(xw1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xw1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((xw1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public w02 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (w02) invokeL.objValue;
    }

    public w02 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (w02) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(ju2 ju2Var, f82 f82Var, wy2 wy2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{ju2Var, f82Var, wy2Var, str, str2, str3}) == null) {
            qm3.a0(new b(this, ju2Var, str3, wy2Var, str, f82Var, str2));
        }
    }

    public final void D(cv1 cv1Var, wy2 wy2Var, f82 f82Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cv1Var, wy2Var, f82Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(cv1Var, wy2Var, f82Var, str);
            } else {
                G(cv1Var, wy2Var, f82Var, str);
            }
        }
    }

    public final void E(cv1 cv1Var, wy2 wy2Var, f82 f82Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, cv1Var, wy2Var, f82Var, str, str2) == null) {
            if (qm3.O()) {
                D(cv1Var, wy2Var, f82Var, str, str2);
            } else {
                qm3.a0(new d(this, cv1Var, wy2Var, f82Var, str, str2));
            }
        }
    }

    public final void F(cv1 cv1Var, wy2 wy2Var, f82 f82Var, String str) {
        SwanAppActivity activity;
        e82 e82Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, cv1Var, wy2Var, f82Var, str) == null) && (activity = ju2.U().getActivity()) != null && !activity.isFinishing()) {
            fc3.e(cv1Var, wy2Var, str);
            c23.c(9, str);
            e82.S3(qm3.n());
            f82.b k = f82Var.i("showModalPage").k("normal", wy2Var);
            if (!(f82Var.m() instanceof e82) || (e82Var = (e82) f82Var.m()) == null) {
                return;
            }
            e82Var.E0 = true;
            k.b();
            if (f82Var.k() > 1) {
                e82Var.x3().setBackgroundColor(0);
            } else {
                e82Var.E0 = false;
            }
            e82Var.z2(false);
            l82 l82Var = this.f;
            if (l82Var != null) {
                e82Var.R2(l82Var);
            }
            e eVar = new e(this, e82Var);
            this.f = eVar;
            e82Var.n2(eVar);
            View c2 = s73.c(e82Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            s73.h(e82Var);
            PullToRefreshBaseWebView h0 = cv1Var.h0();
            if (h0 != null) {
                h0.setIsPreventPullToRefresh(true);
            }
            b23.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            c23.a(str, wy2Var);
        }
    }

    public final void G(cv1 cv1Var, wy2 wy2Var, f82 f82Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, cv1Var, wy2Var, f82Var, str) == null) && (activity = ju2.U().getActivity()) != null && !activity.isFinishing()) {
            fc3.e(cv1Var, wy2Var, str);
            c23.c(0, str);
            if (f82Var.k() < g) {
                e82.S3(qm3.n());
                f82.b i = f82Var.i("navigateTo");
                i.n(f82.g, f82.i);
                i.k("normal", wy2Var).b();
                gl3.c(f82Var, getContext());
                b23.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                c23.a(str, wy2Var);
                return;
            }
            qy1.A(f82Var, wy2Var, str, true);
        }
    }

    public final w02 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            w83 b0 = w83.b0();
            if (b0 == null) {
                return new w02(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            c23.b(uuid);
            Pair<w02, JSONObject> s = s(str);
            w02 w02Var = (w02) s.first;
            if (!w02Var.isSuccess()) {
                return w02Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = fc3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                w52.c("NavigateToApi", "url is null");
                return new w02(202, "url is null");
            }
            ju2 U = ju2.U();
            f82 V = U.V();
            if (V == null) {
                w52.c("NavigateToApi", "manager is null");
                return new w02(1001, "manager is null");
            }
            wy2 d2 = wy2.d(p, U.z());
            d2.e = str2;
            d2.f = uuid;
            kf3.g(d2);
            if (!qm3.b(U.s(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                w52.c("NavigateToApi", str4);
                kf3.i(d2);
                return new w02(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && w83.M() != null) {
                w83.M().L0(optString, d2.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = b23.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                w52.c("NavigateToApi", "cb is empty");
                kf3.i(d2);
                return new w02(202, "cb is empty");
            } else if (jb3.b().a(d2)) {
                jb3.b().i(str3, d2);
                w52.c("NavigateToApi", "access to this page is prohibited");
                return new w02(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, d2, uuid, str2));
                } else {
                    C(U, V, d2, uuid, str2, optString3);
                }
                return w02.f();
            }
        }
        return (w02) invokeLLL.objValue;
    }

    public final void K(bf2.e eVar, wy2 wy2Var, f82 f82Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, wy2Var, f82Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = b23.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            bf2.q(eVar, new c(this, eVar, str, wy2Var, f82Var, str2));
        }
    }
}
