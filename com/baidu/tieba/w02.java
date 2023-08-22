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
import com.baidu.tieba.ig3;
import com.baidu.tieba.ih2;
import com.baidu.tieba.ma2;
import com.baidu.tieba.se3;
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
public class w02 extends u02 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public sa2 f;

    @Override // com.baidu.tieba.gz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qw2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ d13 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ma2 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ w02 g;

        /* loaded from: classes8.dex */
        public class a implements se3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ db3 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, db3 db3Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, db3Var, activity};
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
                this.a = db3Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.se3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    j43.d(this.c.d);
                    d82.i("NavigateToApi", "check pages success");
                    wh3.F(true, this.a.Y().T());
                    this.c.a.o();
                    ih2.e f = ih2.f(this.b, nh2.c(this.c.c.a));
                    List<String> g = me3.g(this.c.e);
                    w02 w02Var = this.c.g;
                    db3 db3Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    me3.m(w02Var, db3Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.se3.e
            public void b(int i, wm3 wm3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, wm3Var) == null) {
                    d82.c("NavigateToApi", "check pages failed");
                    wh3.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    me3.k(bVar.g, bVar.b);
                    rh3.j(this.c.c, wm3Var);
                }
            }
        }

        public b(w02 w02Var, qw2 qw2Var, String str, d13 d13Var, String str2, ma2 ma2Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w02Var, qw2Var, str, d13Var, str2, ma2Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = w02Var;
            this.a = qw2Var;
            this.b = str;
            this.c = d13Var;
            this.d = str2;
            this.e = ma2Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    db3 M = db3.M();
                    if (M == null) {
                        this.g.d(this.b, new d32(1001, "swan app is null"));
                        rh3.i(this.c);
                        return;
                    }
                    this.a.a();
                    se3.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new d32(1001, "swan activity is null"));
                rh3.i(this.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ qw2 b;
        public final /* synthetic */ ma2 c;
        public final /* synthetic */ d13 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ w02 g;

        public a(w02 w02Var, String str, qw2 qw2Var, ma2 ma2Var, d13 d13Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w02Var, str, qw2Var, ma2Var, d13Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = w02Var;
            this.a = str;
            this.b = qw2Var;
            this.c = ma2Var;
            this.d = d13Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<ig3.e> gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                if (!bg3.h(gg3Var)) {
                    this.g.d(this.a, new d32(10005, "system deny"));
                } else {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ih2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ih2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ d13 c;
        public final /* synthetic */ ma2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ w02 f;

        public c(w02 w02Var, ih2.e eVar, String str, d13 d13Var, ma2 ma2Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w02Var, eVar, str, d13Var, ma2Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = w02Var;
            this.a = eVar;
            this.b = str;
            this.c = d13Var;
            this.d = ma2Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.ih2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                j43.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx1 a;
        public final /* synthetic */ d13 b;
        public final /* synthetic */ ma2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ w02 f;

        public d(w02 w02Var, jx1 jx1Var, d13 d13Var, ma2 ma2Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w02Var, jx1Var, d13Var, ma2Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = w02Var;
            this.a = jx1Var;
            this.b = d13Var;
            this.c = ma2Var;
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
    public class e extends sa2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ la2 a;
        public final /* synthetic */ w02 b;

        public e(w02 w02Var, la2 la2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w02Var, la2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w02Var;
            this.a = la2Var;
        }

        @Override // com.baidu.tieba.sa2, com.baidu.tieba.ta2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.T2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.sa2, com.baidu.tieba.ta2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = z93.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                z93.h(this.a);
            }
        }

        @Override // com.baidu.tieba.sa2, com.baidu.tieba.ta2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = z93.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                z93.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948216688, "Lcom/baidu/tieba/w02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948216688, "Lcom/baidu/tieba/w02;");
                return;
            }
        }
        g = ku2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w02(@NonNull ez1 ez1Var) {
        super(ez1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ez1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ez1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public d32 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (d32) invokeL.objValue;
    }

    public d32 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (d32) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(qw2 qw2Var, ma2 ma2Var, d13 d13Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{qw2Var, ma2Var, d13Var, str, str2, str3}) == null) {
            xo3.a0(new b(this, qw2Var, str3, d13Var, str, ma2Var, str2));
        }
    }

    public final void D(jx1 jx1Var, d13 d13Var, ma2 ma2Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jx1Var, d13Var, ma2Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(jx1Var, d13Var, ma2Var, str);
            } else {
                G(jx1Var, d13Var, ma2Var, str);
            }
        }
    }

    public final void E(jx1 jx1Var, d13 d13Var, ma2 ma2Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, jx1Var, d13Var, ma2Var, str, str2) == null) {
            if (xo3.O()) {
                D(jx1Var, d13Var, ma2Var, str, str2);
            } else {
                xo3.a0(new d(this, jx1Var, d13Var, ma2Var, str, str2));
            }
        }
    }

    public final void F(jx1 jx1Var, d13 d13Var, ma2 ma2Var, String str) {
        SwanAppActivity activity;
        la2 la2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, jx1Var, d13Var, ma2Var, str) == null) && (activity = qw2.T().getActivity()) != null && !activity.isFinishing()) {
            me3.e(jx1Var, d13Var, str);
            j43.c(9, str);
            la2.U3(xo3.n());
            ma2.b k = ma2Var.i("showModalPage").k("normal", d13Var);
            if (!(ma2Var.m() instanceof la2) || (la2Var = (la2) ma2Var.m()) == null) {
                return;
            }
            la2Var.E0 = true;
            k.b();
            if (ma2Var.k() > 1) {
                la2Var.z3().setBackgroundColor(0);
            } else {
                la2Var.E0 = false;
            }
            la2Var.B2(false);
            sa2 sa2Var = this.f;
            if (sa2Var != null) {
                la2Var.T2(sa2Var);
            }
            e eVar = new e(this, la2Var);
            this.f = eVar;
            la2Var.p2(eVar);
            View c2 = z93.c(la2Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            z93.h(la2Var);
            PullToRefreshBaseWebView f0 = jx1Var.f0();
            if (f0 != null) {
                f0.setIsPreventPullToRefresh(true);
            }
            i43.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            j43.a(str, d13Var);
        }
    }

    public final void G(jx1 jx1Var, d13 d13Var, ma2 ma2Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, jx1Var, d13Var, ma2Var, str) == null) && (activity = qw2.T().getActivity()) != null && !activity.isFinishing()) {
            me3.e(jx1Var, d13Var, str);
            j43.c(0, str);
            if (ma2Var.k() < g) {
                la2.U3(xo3.n());
                ma2.b i = ma2Var.i("navigateTo");
                i.n(ma2.g, ma2.i);
                i.k("normal", d13Var).b();
                nn3.c(ma2Var, getContext());
                i43.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                j43.a(str, d13Var);
                return;
            }
            x02.A(ma2Var, d13Var, str, true);
        }
    }

    public final d32 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            db3 b0 = db3.b0();
            if (b0 == null) {
                return new d32(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            j43.b(uuid);
            Pair<d32, JSONObject> s = s(str);
            d32 d32Var = (d32) s.first;
            if (!d32Var.isSuccess()) {
                return d32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = me3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                d82.c("NavigateToApi", "url is null");
                return new d32(202, "url is null");
            }
            qw2 T2 = qw2.T();
            ma2 U = T2.U();
            if (U == null) {
                d82.c("NavigateToApi", "manager is null");
                return new d32(1001, "manager is null");
            }
            d13 d2 = d13.d(p, T2.z());
            d2.e = str2;
            d2.f = uuid;
            rh3.g(d2);
            if (!xo3.b(T2.s(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                d82.c("NavigateToApi", str4);
                rh3.i(d2);
                return new d32(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && db3.M() != null) {
                db3.M().L0(optString, d2.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = i43.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                d82.c("NavigateToApi", "cb is empty");
                rh3.i(d2);
                return new d32(202, "cb is empty");
            } else if (qd3.b().a(d2)) {
                qd3.b().i(str3, d2);
                d82.c("NavigateToApi", "access to this page is prohibited");
                return new d32(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, T2, U, d2, uuid, str2));
                } else {
                    C(T2, U, d2, uuid, str2, optString3);
                }
                return d32.f();
            }
        }
        return (d32) invokeLLL.objValue;
    }

    public final void K(ih2.e eVar, d13 d13Var, ma2 ma2Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, d13Var, ma2Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = i43.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            ih2.q(eVar, new c(this, eVar, str, d13Var, ma2Var, str2));
        }
    }
}
