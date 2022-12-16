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
import com.baidu.tieba.j93;
import com.baidu.tieba.ja2;
import com.baidu.tieba.n32;
import com.baidu.tieba.t73;
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
public class xt1 extends vt1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public t32 f;

    @Override // com.baidu.tieba.hs1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ eu2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ n32 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ xt1 g;

        /* loaded from: classes6.dex */
        public class a implements t73.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e43 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, e43 e43Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, e43Var, activity};
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
                this.a = e43Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.t73.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    kx2.d(this.c.d);
                    e12.i("NavigateToApi", "check pages success");
                    xa3.F(true, this.a.Y().T());
                    this.c.a.o();
                    ja2.e f = ja2.f(this.b, oa2.c(this.c.c.a));
                    List<String> g = n73.g(this.c.e);
                    xt1 xt1Var = this.c.g;
                    e43 e43Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    n73.m(xt1Var, e43Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.t73.e
            public void b(int i, xf3 xf3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, xf3Var) == null) {
                    e12.c("NavigateToApi", "check pages failed");
                    xa3.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    n73.k(bVar.g, bVar.b);
                    sa3.j(this.c.c, xf3Var);
                }
            }
        }

        public b(xt1 xt1Var, rp2 rp2Var, String str, eu2 eu2Var, String str2, n32 n32Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xt1Var, rp2Var, str, eu2Var, str2, n32Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = xt1Var;
            this.a = rp2Var;
            this.b = str;
            this.c = eu2Var;
            this.d = str2;
            this.e = n32Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    e43 M = e43.M();
                    if (M == null) {
                        this.g.d(this.b, new ew1(1001, "swan app is null"));
                        sa3.i(this.c);
                        return;
                    }
                    this.a.a();
                    t73.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new ew1(1001, "swan activity is null"));
                sa3.i(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements xi3<h93<j93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ rp2 b;
        public final /* synthetic */ n32 c;
        public final /* synthetic */ eu2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ xt1 g;

        public a(xt1 xt1Var, String str, rp2 rp2Var, n32 n32Var, eu2 eu2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xt1Var, str, rp2Var, n32Var, eu2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = xt1Var;
            this.a = str;
            this.b = rp2Var;
            this.c = n32Var;
            this.d = eu2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(h93<j93.e> h93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h93Var) == null) {
                if (!c93.h(h93Var)) {
                    this.g.d(this.a, new ew1(10005, "system deny"));
                } else {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ja2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ja2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ eu2 c;
        public final /* synthetic */ n32 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ xt1 f;

        public c(xt1 xt1Var, ja2.e eVar, String str, eu2 eu2Var, n32 n32Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xt1Var, eVar, str, eu2Var, n32Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = xt1Var;
            this.a = eVar;
            this.b = str;
            this.c = eu2Var;
            this.d = n32Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.ja2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kx2.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kq1 a;
        public final /* synthetic */ eu2 b;
        public final /* synthetic */ n32 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ xt1 f;

        public d(xt1 xt1Var, kq1 kq1Var, eu2 eu2Var, n32 n32Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xt1Var, kq1Var, eu2Var, n32Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = xt1Var;
            this.a = kq1Var;
            this.b = eu2Var;
            this.c = n32Var;
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
    public class e extends t32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m32 a;
        public final /* synthetic */ xt1 b;

        public e(xt1 xt1Var, m32 m32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xt1Var, m32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xt1Var;
            this.a = m32Var;
        }

        @Override // com.baidu.tieba.t32, com.baidu.tieba.u32
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.R2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.t32, com.baidu.tieba.u32
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = a33.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                a33.h(this.a);
            }
        }

        @Override // com.baidu.tieba.t32, com.baidu.tieba.u32
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = a33.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                a33.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948311796, "Lcom/baidu/tieba/xt1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948311796, "Lcom/baidu/tieba/xt1;");
                return;
            }
        }
        g = ln2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xt1(@NonNull fs1 fs1Var) {
        super(fs1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fs1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((fs1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public ew1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (ew1) invokeL.objValue;
    }

    public ew1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (ew1) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(rp2 rp2Var, n32 n32Var, eu2 eu2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{rp2Var, n32Var, eu2Var, str, str2, str3}) == null) {
            yh3.a0(new b(this, rp2Var, str3, eu2Var, str, n32Var, str2));
        }
    }

    public final void D(kq1 kq1Var, eu2 eu2Var, n32 n32Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kq1Var, eu2Var, n32Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(kq1Var, eu2Var, n32Var, str);
            } else {
                G(kq1Var, eu2Var, n32Var, str);
            }
        }
    }

    public final void E(kq1 kq1Var, eu2 eu2Var, n32 n32Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, kq1Var, eu2Var, n32Var, str, str2) == null) {
            if (yh3.O()) {
                D(kq1Var, eu2Var, n32Var, str, str2);
            } else {
                yh3.a0(new d(this, kq1Var, eu2Var, n32Var, str, str2));
            }
        }
    }

    public final void F(kq1 kq1Var, eu2 eu2Var, n32 n32Var, String str) {
        SwanAppActivity activity;
        m32 m32Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, kq1Var, eu2Var, n32Var, str) == null) && (activity = rp2.U().getActivity()) != null && !activity.isFinishing()) {
            n73.e(kq1Var, eu2Var, str);
            kx2.c(9, str);
            m32.S3(yh3.n());
            n32.b k = n32Var.i("showModalPage").k("normal", eu2Var);
            if (!(n32Var.m() instanceof m32) || (m32Var = (m32) n32Var.m()) == null) {
                return;
            }
            m32Var.D0 = true;
            k.b();
            if (n32Var.k() > 1) {
                m32Var.x3().setBackgroundColor(0);
            } else {
                m32Var.D0 = false;
            }
            m32Var.z2(false);
            t32 t32Var = this.f;
            if (t32Var != null) {
                m32Var.R2(t32Var);
            }
            e eVar = new e(this, m32Var);
            this.f = eVar;
            m32Var.n2(eVar);
            View c2 = a33.c(m32Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            a33.h(m32Var);
            PullToRefreshBaseWebView h0 = kq1Var.h0();
            if (h0 != null) {
                h0.setIsPreventPullToRefresh(true);
            }
            jx2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            kx2.a(str, eu2Var);
        }
    }

    public final void G(kq1 kq1Var, eu2 eu2Var, n32 n32Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, kq1Var, eu2Var, n32Var, str) == null) && (activity = rp2.U().getActivity()) != null && !activity.isFinishing()) {
            n73.e(kq1Var, eu2Var, str);
            kx2.c(0, str);
            if (n32Var.k() < g) {
                m32.S3(yh3.n());
                n32.b i = n32Var.i("navigateTo");
                i.n(n32.g, n32.i);
                i.k("normal", eu2Var).b();
                og3.c(n32Var, getContext());
                jx2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                kx2.a(str, eu2Var);
                return;
            }
            yt1.A(n32Var, eu2Var, str, true);
        }
    }

    public final ew1 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            e43 b0 = e43.b0();
            if (b0 == null) {
                return new ew1(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            kx2.b(uuid);
            Pair<ew1, JSONObject> s = s(str);
            ew1 ew1Var = (ew1) s.first;
            if (!ew1Var.isSuccess()) {
                return ew1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = n73.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                e12.c("NavigateToApi", "url is null");
                return new ew1(202, "url is null");
            }
            rp2 U = rp2.U();
            n32 V = U.V();
            if (V == null) {
                e12.c("NavigateToApi", "manager is null");
                return new ew1(1001, "manager is null");
            }
            eu2 d2 = eu2.d(p, U.z());
            d2.e = str2;
            d2.f = uuid;
            sa3.g(d2);
            if (!yh3.b(U.s(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                e12.c("NavigateToApi", str4);
                sa3.i(d2);
                return new ew1(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && e43.M() != null) {
                e43.M().L0(optString, d2.d);
            }
            String optString2 = jSONObject.optString(FetchLog.START_TIME);
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = jx2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                e12.c("NavigateToApi", "cb is empty");
                sa3.i(d2);
                return new ew1(202, "cb is empty");
            } else if (r63.b().a(d2)) {
                r63.b().i(str3, d2);
                e12.c("NavigateToApi", "access to this page is prohibited");
                return new ew1(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, d2, uuid, str2));
                } else {
                    C(U, V, d2, uuid, str2, optString3);
                }
                return ew1.f();
            }
        }
        return (ew1) invokeLLL.objValue;
    }

    public final void K(ja2.e eVar, eu2 eu2Var, n32 n32Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, eu2Var, n32Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = jx2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            ja2.q(eVar, new c(this, eVar, str, eu2Var, n32Var, str2));
        }
    }
}
