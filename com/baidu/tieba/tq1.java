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
import com.baidu.tieba.f63;
import com.baidu.tieba.f72;
import com.baidu.tieba.j02;
import com.baidu.tieba.p43;
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
public class tq1 extends rq1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public p02 f;

    /* loaded from: classes6.dex */
    public class a implements tf3<d63<f63.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ nm2 b;
        public final /* synthetic */ j02 c;
        public final /* synthetic */ ar2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ tq1 g;

        public a(tq1 tq1Var, String str, nm2 nm2Var, j02 j02Var, ar2 ar2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tq1Var, str, nm2Var, j02Var, ar2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = tq1Var;
            this.a = str;
            this.b = nm2Var;
            this.c = j02Var;
            this.d = ar2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tf3
        /* renamed from: b */
        public void a(d63<f63.e> d63Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d63Var) == null) {
                if (y53.h(d63Var)) {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                } else {
                    this.g.d(this.a, new at1(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ar2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ j02 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ tq1 g;

        /* loaded from: classes6.dex */
        public class a implements p43.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a13 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, a13 a13Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, a13Var, activity};
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
                this.a = a13Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.p43.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    gu2.d(this.c.d);
                    ay1.i("NavigateToApi", "check pages success");
                    t73.F(true, this.a.Y().T());
                    this.c.a.o();
                    f72.e f = f72.f(this.b, k72.c(this.c.c.a));
                    List<String> g = j43.g(this.c.e);
                    tq1 tq1Var = this.c.g;
                    a13 a13Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    j43.m(tq1Var, a13Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.p43.e
            public void b(int i, tc3 tc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, tc3Var) == null) {
                    ay1.c("NavigateToApi", "check pages failed");
                    t73.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    j43.k(bVar.g, bVar.b);
                    o73.j(this.c.c, tc3Var);
                }
            }
        }

        public b(tq1 tq1Var, nm2 nm2Var, String str, ar2 ar2Var, String str2, j02 j02Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tq1Var, nm2Var, str, ar2Var, str2, j02Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = tq1Var;
            this.a = nm2Var;
            this.b = str;
            this.c = ar2Var;
            this.d = str2;
            this.e = j02Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    a13 M = a13.M();
                    if (M == null) {
                        this.g.d(this.b, new at1(1001, "swan app is null"));
                        o73.i(this.c);
                        return;
                    }
                    this.a.a();
                    p43.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new at1(1001, "swan activity is null"));
                o73.i(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements f72.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ar2 c;
        public final /* synthetic */ j02 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ tq1 f;

        public c(tq1 tq1Var, f72.e eVar, String str, ar2 ar2Var, j02 j02Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tq1Var, eVar, str, ar2Var, j02Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = tq1Var;
            this.a = eVar;
            this.b = str;
            this.c = ar2Var;
            this.d = j02Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.f72.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gu2.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gn1 a;
        public final /* synthetic */ ar2 b;
        public final /* synthetic */ j02 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ tq1 f;

        public d(tq1 tq1Var, gn1 gn1Var, ar2 ar2Var, j02 j02Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tq1Var, gn1Var, ar2Var, j02Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = tq1Var;
            this.a = gn1Var;
            this.b = ar2Var;
            this.c = j02Var;
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

    /* loaded from: classes6.dex */
    public class e extends p02 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i02 a;
        public final /* synthetic */ tq1 b;

        public e(tq1 tq1Var, i02 i02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tq1Var, i02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tq1Var;
            this.a = i02Var;
        }

        @Override // com.baidu.tieba.p02, com.baidu.tieba.q02
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.R2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.p02, com.baidu.tieba.q02
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = wz2.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                wz2.h(this.a);
            }
        }

        @Override // com.baidu.tieba.p02, com.baidu.tieba.q02
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = wz2.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                wz2.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948189749, "Lcom/baidu/tieba/tq1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948189749, "Lcom/baidu/tieba/tq1;");
                return;
            }
        }
        g = hk2.g0().r();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tq1(@NonNull bp1 bp1Var) {
        super(bp1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bp1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((bp1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(nm2 nm2Var, j02 j02Var, ar2 ar2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{nm2Var, j02Var, ar2Var, str, str2, str3}) == null) {
            ue3.a0(new b(this, nm2Var, str3, ar2Var, str, j02Var, str2));
        }
    }

    public final void D(gn1 gn1Var, ar2 ar2Var, j02 j02Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gn1Var, ar2Var, j02Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(gn1Var, ar2Var, j02Var, str);
            } else {
                G(gn1Var, ar2Var, j02Var, str);
            }
        }
    }

    public final void E(gn1 gn1Var, ar2 ar2Var, j02 j02Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, gn1Var, ar2Var, j02Var, str, str2) == null) {
            if (ue3.O()) {
                D(gn1Var, ar2Var, j02Var, str, str2);
            } else {
                ue3.a0(new d(this, gn1Var, ar2Var, j02Var, str, str2));
            }
        }
    }

    public final void F(gn1 gn1Var, ar2 ar2Var, j02 j02Var, String str) {
        SwanAppActivity activity;
        i02 i02Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, gn1Var, ar2Var, j02Var, str) == null) || (activity = nm2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        j43.e(gn1Var, ar2Var, str);
        gu2.c(9, str);
        i02.S3(ue3.n());
        j02.b k = j02Var.i("showModalPage").k("normal", ar2Var);
        if ((j02Var.m() instanceof i02) && (i02Var = (i02) j02Var.m()) != null) {
            i02Var.D0 = true;
            k.b();
            if (j02Var.k() > 1) {
                i02Var.x3().setBackgroundColor(0);
            } else {
                i02Var.D0 = false;
            }
            i02Var.z2(false);
            p02 p02Var = this.f;
            if (p02Var != null) {
                i02Var.R2(p02Var);
            }
            e eVar = new e(this, i02Var);
            this.f = eVar;
            i02Var.n2(eVar);
            View c2 = wz2.c(i02Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            wz2.h(i02Var);
            PullToRefreshBaseWebView h0 = gn1Var.h0();
            if (h0 != null) {
                h0.setIsPreventPullToRefresh(true);
            }
            fu2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            gu2.a(str, ar2Var);
        }
    }

    public final void G(gn1 gn1Var, ar2 ar2Var, j02 j02Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, gn1Var, ar2Var, j02Var, str) == null) || (activity = nm2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        j43.e(gn1Var, ar2Var, str);
        gu2.c(0, str);
        if (j02Var.k() < g) {
            i02.S3(ue3.n());
            j02.b i = j02Var.i("navigateTo");
            i.n(j02.g, j02.i);
            i.k("normal", ar2Var).b();
            kd3.c(j02Var, getContext());
            fu2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            gu2.a(str, ar2Var);
            return;
        }
        uq1.A(j02Var, ar2Var, str, true);
    }

    public at1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (at1) invokeL.objValue;
    }

    public final at1 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            a13 b0 = a13.b0();
            if (b0 == null) {
                return new at1(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            gu2.b(uuid);
            Pair<at1, JSONObject> s = s(str);
            at1 at1Var = (at1) s.first;
            if (at1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = j43.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    ay1.c("NavigateToApi", "url is null");
                    return new at1(202, "url is null");
                }
                nm2 U = nm2.U();
                j02 V = U.V();
                if (V == null) {
                    ay1.c("NavigateToApi", "manager is null");
                    return new at1(1001, "manager is null");
                }
                ar2 d2 = ar2.d(p, U.z());
                d2.e = str2;
                d2.f = uuid;
                o73.g(d2);
                if (!ue3.b(U.s(), d2, false)) {
                    String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                    ay1.c("NavigateToApi", str4);
                    o73.i(d2);
                    return new at1(202, str4);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && a13.M() != null) {
                    a13.M().L0(optString, d2.d);
                }
                String optString2 = jSONObject.optString(FetchLog.START_TIME);
                if (!TextUtils.isEmpty(optString2)) {
                    HybridUbcFlow q = fu2.q("route", uuid);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                    ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                    q.F(ubcFlowEvent);
                }
                String optString3 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString3)) {
                    ay1.c("NavigateToApi", "cb is empty");
                    o73.i(d2);
                    return new at1(202, "cb is empty");
                } else if (n33.b().a(d2)) {
                    n33.b().i(str3, d2);
                    ay1.c("NavigateToApi", "access to this page is prohibited");
                    return new at1(1003, "access to this page is prohibited");
                } else {
                    if (TextUtils.equals("7", str2)) {
                        b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, d2, uuid, str2));
                    } else {
                        C(U, V, d2, uuid, str2, optString3);
                    }
                    return at1.f();
                }
            }
            return at1Var;
        }
        return (at1) invokeLLL.objValue;
    }

    public at1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (at1) invokeL.objValue;
    }

    public final void K(f72.e eVar, ar2 ar2Var, j02 j02Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, ar2Var, j02Var, str, str2) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = fu2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            f72.q(eVar, new c(this, eVar, str, ar2Var, j02Var, str2));
        }
    }

    @Override // com.baidu.tieba.dp1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }
}
