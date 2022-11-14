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
import com.baidu.tieba.k93;
import com.baidu.tieba.ka2;
import com.baidu.tieba.o32;
import com.baidu.tieba.u73;
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
public class yt1 extends wt1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public u32 f;

    @Override // com.baidu.tieba.is1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sp2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ fu2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ o32 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ yt1 g;

        /* loaded from: classes6.dex */
        public class a implements u73.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f43 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, f43 f43Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, f43Var, activity};
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
                this.a = f43Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.u73.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    lx2.d(this.c.d);
                    f12.i("NavigateToApi", "check pages success");
                    ya3.F(true, this.a.Y().T());
                    this.c.a.o();
                    ka2.e f = ka2.f(this.b, pa2.c(this.c.c.a));
                    List<String> g = o73.g(this.c.e);
                    yt1 yt1Var = this.c.g;
                    f43 f43Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    o73.m(yt1Var, f43Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.u73.e
            public void b(int i, yf3 yf3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, yf3Var) == null) {
                    f12.c("NavigateToApi", "check pages failed");
                    ya3.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    o73.k(bVar.g, bVar.b);
                    ta3.j(this.c.c, yf3Var);
                }
            }
        }

        public b(yt1 yt1Var, sp2 sp2Var, String str, fu2 fu2Var, String str2, o32 o32Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yt1Var, sp2Var, str, fu2Var, str2, o32Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = yt1Var;
            this.a = sp2Var;
            this.b = str;
            this.c = fu2Var;
            this.d = str2;
            this.e = o32Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    f43 M = f43.M();
                    if (M == null) {
                        this.g.d(this.b, new fw1(1001, "swan app is null"));
                        ta3.i(this.c);
                        return;
                    }
                    this.a.a();
                    u73.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new fw1(1001, "swan activity is null"));
                ta3.i(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements yi3<i93<k93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ sp2 b;
        public final /* synthetic */ o32 c;
        public final /* synthetic */ fu2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ yt1 g;

        public a(yt1 yt1Var, String str, sp2 sp2Var, o32 o32Var, fu2 fu2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yt1Var, str, sp2Var, o32Var, fu2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = yt1Var;
            this.a = str;
            this.b = sp2Var;
            this.c = o32Var;
            this.d = fu2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(i93<k93.e> i93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i93Var) == null) {
                if (!d93.h(i93Var)) {
                    this.g.d(this.a, new fw1(10005, "system deny"));
                } else {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ka2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ka2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ fu2 c;
        public final /* synthetic */ o32 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ yt1 f;

        public c(yt1 yt1Var, ka2.e eVar, String str, fu2 fu2Var, o32 o32Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yt1Var, eVar, str, fu2Var, o32Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = yt1Var;
            this.a = eVar;
            this.b = str;
            this.c = fu2Var;
            this.d = o32Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.ka2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lx2.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lq1 a;
        public final /* synthetic */ fu2 b;
        public final /* synthetic */ o32 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ yt1 f;

        public d(yt1 yt1Var, lq1 lq1Var, fu2 fu2Var, o32 o32Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yt1Var, lq1Var, fu2Var, o32Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = yt1Var;
            this.a = lq1Var;
            this.b = fu2Var;
            this.c = o32Var;
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
    public class e extends u32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n32 a;
        public final /* synthetic */ yt1 b;

        public e(yt1 yt1Var, n32 n32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yt1Var, n32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yt1Var;
            this.a = n32Var;
        }

        @Override // com.baidu.tieba.u32, com.baidu.tieba.v32
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.R2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.u32, com.baidu.tieba.v32
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = b33.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                b33.h(this.a);
            }
        }

        @Override // com.baidu.tieba.u32, com.baidu.tieba.v32
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = b33.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                b33.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948341587, "Lcom/baidu/tieba/yt1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948341587, "Lcom/baidu/tieba/yt1;");
                return;
            }
        }
        g = mn2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yt1(@NonNull gs1 gs1Var) {
        super(gs1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gs1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((gs1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public fw1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (fw1) invokeL.objValue;
    }

    public fw1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (fw1) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(sp2 sp2Var, o32 o32Var, fu2 fu2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{sp2Var, o32Var, fu2Var, str, str2, str3}) == null) {
            zh3.a0(new b(this, sp2Var, str3, fu2Var, str, o32Var, str2));
        }
    }

    public final void D(lq1 lq1Var, fu2 fu2Var, o32 o32Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lq1Var, fu2Var, o32Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(lq1Var, fu2Var, o32Var, str);
            } else {
                G(lq1Var, fu2Var, o32Var, str);
            }
        }
    }

    public final void E(lq1 lq1Var, fu2 fu2Var, o32 o32Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, lq1Var, fu2Var, o32Var, str, str2) == null) {
            if (zh3.O()) {
                D(lq1Var, fu2Var, o32Var, str, str2);
            } else {
                zh3.a0(new d(this, lq1Var, fu2Var, o32Var, str, str2));
            }
        }
    }

    public final void F(lq1 lq1Var, fu2 fu2Var, o32 o32Var, String str) {
        SwanAppActivity activity;
        n32 n32Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, lq1Var, fu2Var, o32Var, str) == null) && (activity = sp2.U().getActivity()) != null && !activity.isFinishing()) {
            o73.e(lq1Var, fu2Var, str);
            lx2.c(9, str);
            n32.S3(zh3.n());
            o32.b k = o32Var.i("showModalPage").k("normal", fu2Var);
            if (!(o32Var.m() instanceof n32) || (n32Var = (n32) o32Var.m()) == null) {
                return;
            }
            n32Var.D0 = true;
            k.b();
            if (o32Var.k() > 1) {
                n32Var.x3().setBackgroundColor(0);
            } else {
                n32Var.D0 = false;
            }
            n32Var.z2(false);
            u32 u32Var = this.f;
            if (u32Var != null) {
                n32Var.R2(u32Var);
            }
            e eVar = new e(this, n32Var);
            this.f = eVar;
            n32Var.n2(eVar);
            View c2 = b33.c(n32Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            b33.h(n32Var);
            PullToRefreshBaseWebView h0 = lq1Var.h0();
            if (h0 != null) {
                h0.setIsPreventPullToRefresh(true);
            }
            kx2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            lx2.a(str, fu2Var);
        }
    }

    public final void G(lq1 lq1Var, fu2 fu2Var, o32 o32Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, lq1Var, fu2Var, o32Var, str) == null) && (activity = sp2.U().getActivity()) != null && !activity.isFinishing()) {
            o73.e(lq1Var, fu2Var, str);
            lx2.c(0, str);
            if (o32Var.k() < g) {
                n32.S3(zh3.n());
                o32.b i = o32Var.i("navigateTo");
                i.n(o32.g, o32.i);
                i.k("normal", fu2Var).b();
                pg3.c(o32Var, getContext());
                kx2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                lx2.a(str, fu2Var);
                return;
            }
            zt1.A(o32Var, fu2Var, str, true);
        }
    }

    public final fw1 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            f43 b0 = f43.b0();
            if (b0 == null) {
                return new fw1(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            lx2.b(uuid);
            Pair<fw1, JSONObject> s = s(str);
            fw1 fw1Var = (fw1) s.first;
            if (!fw1Var.isSuccess()) {
                return fw1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = o73.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                f12.c("NavigateToApi", "url is null");
                return new fw1(202, "url is null");
            }
            sp2 U = sp2.U();
            o32 V = U.V();
            if (V == null) {
                f12.c("NavigateToApi", "manager is null");
                return new fw1(1001, "manager is null");
            }
            fu2 d2 = fu2.d(p, U.z());
            d2.e = str2;
            d2.f = uuid;
            ta3.g(d2);
            if (!zh3.b(U.s(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                f12.c("NavigateToApi", str4);
                ta3.i(d2);
                return new fw1(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && f43.M() != null) {
                f43.M().L0(optString, d2.d);
            }
            String optString2 = jSONObject.optString(FetchLog.START_TIME);
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = kx2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                f12.c("NavigateToApi", "cb is empty");
                ta3.i(d2);
                return new fw1(202, "cb is empty");
            } else if (s63.b().a(d2)) {
                s63.b().i(str3, d2);
                f12.c("NavigateToApi", "access to this page is prohibited");
                return new fw1(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, d2, uuid, str2));
                } else {
                    C(U, V, d2, uuid, str2, optString3);
                }
                return fw1.f();
            }
        }
        return (fw1) invokeLLL.objValue;
    }

    public final void K(ka2.e eVar, fu2 fu2Var, o32 o32Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, fu2Var, o32Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = kx2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            ka2.q(eVar, new c(this, eVar, str, fu2Var, o32Var, str2));
        }
    }
}
