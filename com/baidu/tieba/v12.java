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
import com.baidu.tieba.hh3;
import com.baidu.tieba.hi2;
import com.baidu.tieba.lb2;
import com.baidu.tieba.rf3;
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
public class v12 extends t12 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public rb2 f;

    @Override // com.baidu.tieba.f02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ px2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ c23 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ lb2 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ v12 g;

        /* loaded from: classes8.dex */
        public class a implements rf3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ cc3 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, cc3 cc3Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, cc3Var, activity};
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
                this.a = cc3Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.rf3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i53.d(this.c.d);
                    c92.i("NavigateToApi", "check pages success");
                    vi3.F(true, this.a.Y().T());
                    this.c.a.o();
                    hi2.e f = hi2.f(this.b, mi2.c(this.c.c.a));
                    List<String> g = lf3.g(this.c.e);
                    v12 v12Var = this.c.g;
                    cc3 cc3Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    lf3.m(v12Var, cc3Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.rf3.e
            public void b(int i, vn3 vn3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, vn3Var) == null) {
                    c92.c("NavigateToApi", "check pages failed");
                    vi3.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    lf3.k(bVar.g, bVar.b);
                    qi3.j(this.c.c, vn3Var);
                }
            }
        }

        public b(v12 v12Var, px2 px2Var, String str, c23 c23Var, String str2, lb2 lb2Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v12Var, px2Var, str, c23Var, str2, lb2Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = v12Var;
            this.a = px2Var;
            this.b = str;
            this.c = c23Var;
            this.d = str2;
            this.e = lb2Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    cc3 M = cc3.M();
                    if (M == null) {
                        this.g.d(this.b, new c42(1001, "swan app is null"));
                        qi3.i(this.c);
                        return;
                    }
                    this.a.a();
                    rf3.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new c42(1001, "swan activity is null"));
                qi3.i(this.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements vq3<fh3<hh3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ px2 b;
        public final /* synthetic */ lb2 c;
        public final /* synthetic */ c23 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ v12 g;

        public a(v12 v12Var, String str, px2 px2Var, lb2 lb2Var, c23 c23Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v12Var, str, px2Var, lb2Var, c23Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = v12Var;
            this.a = str;
            this.b = px2Var;
            this.c = lb2Var;
            this.d = c23Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(fh3<hh3.e> fh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fh3Var) == null) {
                if (!ah3.h(fh3Var)) {
                    this.g.d(this.a, new c42(10005, "system deny"));
                } else {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements hi2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hi2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ c23 c;
        public final /* synthetic */ lb2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ v12 f;

        public c(v12 v12Var, hi2.e eVar, String str, c23 c23Var, lb2 lb2Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v12Var, eVar, str, c23Var, lb2Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = v12Var;
            this.a = eVar;
            this.b = str;
            this.c = c23Var;
            this.d = lb2Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.hi2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i53.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy1 a;
        public final /* synthetic */ c23 b;
        public final /* synthetic */ lb2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ v12 f;

        public d(v12 v12Var, iy1 iy1Var, c23 c23Var, lb2 lb2Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v12Var, iy1Var, c23Var, lb2Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = v12Var;
            this.a = iy1Var;
            this.b = c23Var;
            this.c = lb2Var;
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
    public class e extends rb2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kb2 a;
        public final /* synthetic */ v12 b;

        public e(v12 v12Var, kb2 kb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v12Var, kb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v12Var;
            this.a = kb2Var;
        }

        @Override // com.baidu.tieba.rb2, com.baidu.tieba.sb2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.T2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.rb2, com.baidu.tieba.sb2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = ya3.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                ya3.h(this.a);
            }
        }

        @Override // com.baidu.tieba.rb2, com.baidu.tieba.sb2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = ya3.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                ya3.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948187858, "Lcom/baidu/tieba/v12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948187858, "Lcom/baidu/tieba/v12;");
                return;
            }
        }
        g = jv2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v12(@NonNull d02 d02Var) {
        super(d02Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d02Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d02) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public c42 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (c42) invokeL.objValue;
    }

    public c42 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (c42) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(px2 px2Var, lb2 lb2Var, c23 c23Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{px2Var, lb2Var, c23Var, str, str2, str3}) == null) {
            wp3.a0(new b(this, px2Var, str3, c23Var, str, lb2Var, str2));
        }
    }

    public final void D(iy1 iy1Var, c23 c23Var, lb2 lb2Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iy1Var, c23Var, lb2Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(iy1Var, c23Var, lb2Var, str);
            } else {
                G(iy1Var, c23Var, lb2Var, str);
            }
        }
    }

    public final void E(iy1 iy1Var, c23 c23Var, lb2 lb2Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, iy1Var, c23Var, lb2Var, str, str2) == null) {
            if (wp3.O()) {
                D(iy1Var, c23Var, lb2Var, str, str2);
            } else {
                wp3.a0(new d(this, iy1Var, c23Var, lb2Var, str, str2));
            }
        }
    }

    public final void F(iy1 iy1Var, c23 c23Var, lb2 lb2Var, String str) {
        SwanAppActivity activity;
        kb2 kb2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, iy1Var, c23Var, lb2Var, str) == null) && (activity = px2.T().getActivity()) != null && !activity.isFinishing()) {
            lf3.e(iy1Var, c23Var, str);
            i53.c(9, str);
            kb2.U3(wp3.n());
            lb2.b k = lb2Var.i("showModalPage").k("normal", c23Var);
            if (!(lb2Var.m() instanceof kb2) || (kb2Var = (kb2) lb2Var.m()) == null) {
                return;
            }
            kb2Var.E0 = true;
            k.b();
            if (lb2Var.k() > 1) {
                kb2Var.z3().setBackgroundColor(0);
            } else {
                kb2Var.E0 = false;
            }
            kb2Var.B2(false);
            rb2 rb2Var = this.f;
            if (rb2Var != null) {
                kb2Var.T2(rb2Var);
            }
            e eVar = new e(this, kb2Var);
            this.f = eVar;
            kb2Var.p2(eVar);
            View c2 = ya3.c(kb2Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            ya3.h(kb2Var);
            PullToRefreshBaseWebView f0 = iy1Var.f0();
            if (f0 != null) {
                f0.setIsPreventPullToRefresh(true);
            }
            h53.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            i53.a(str, c23Var);
        }
    }

    public final void G(iy1 iy1Var, c23 c23Var, lb2 lb2Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, iy1Var, c23Var, lb2Var, str) == null) && (activity = px2.T().getActivity()) != null && !activity.isFinishing()) {
            lf3.e(iy1Var, c23Var, str);
            i53.c(0, str);
            if (lb2Var.k() < g) {
                kb2.U3(wp3.n());
                lb2.b i = lb2Var.i("navigateTo");
                i.n(lb2.g, lb2.i);
                i.k("normal", c23Var).b();
                mo3.c(lb2Var, getContext());
                h53.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                i53.a(str, c23Var);
                return;
            }
            w12.A(lb2Var, c23Var, str, true);
        }
    }

    public final c42 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            cc3 b0 = cc3.b0();
            if (b0 == null) {
                return new c42(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            i53.b(uuid);
            Pair<c42, JSONObject> s = s(str);
            c42 c42Var = (c42) s.first;
            if (!c42Var.isSuccess()) {
                return c42Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = lf3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                c92.c("NavigateToApi", "url is null");
                return new c42(202, "url is null");
            }
            px2 T2 = px2.T();
            lb2 U = T2.U();
            if (U == null) {
                c92.c("NavigateToApi", "manager is null");
                return new c42(1001, "manager is null");
            }
            c23 d2 = c23.d(p, T2.z());
            d2.e = str2;
            d2.f = uuid;
            qi3.g(d2);
            if (!wp3.b(T2.s(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                c92.c("NavigateToApi", str4);
                qi3.i(d2);
                return new c42(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && cc3.M() != null) {
                cc3.M().L0(optString, d2.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = h53.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                c92.c("NavigateToApi", "cb is empty");
                qi3.i(d2);
                return new c42(202, "cb is empty");
            } else if (pe3.b().a(d2)) {
                pe3.b().i(str3, d2);
                c92.c("NavigateToApi", "access to this page is prohibited");
                return new c42(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, T2, U, d2, uuid, str2));
                } else {
                    C(T2, U, d2, uuid, str2, optString3);
                }
                return c42.f();
            }
        }
        return (c42) invokeLLL.objValue;
    }

    public final void K(hi2.e eVar, c23 c23Var, lb2 lb2Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, c23Var, lb2Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = h53.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            hi2.q(eVar, new c(this, eVar, str, c23Var, lb2Var, str2));
        }
    }
}
