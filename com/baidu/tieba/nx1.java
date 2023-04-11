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
import com.baidu.tieba.d72;
import com.baidu.tieba.jb3;
import com.baidu.tieba.zc3;
import com.baidu.tieba.zd2;
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
public class nx1 extends lx1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public j72 f;

    @Override // com.baidu.tieba.xv1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ht2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ux2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ d72 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ nx1 g;

        /* loaded from: classes5.dex */
        public class a implements jb3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ u73 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, u73 u73Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, u73Var, activity};
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
                this.a = u73Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.jb3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    a13.d(this.c.d);
                    u42.i("NavigateToApi", "check pages success");
                    ne3.F(true, this.a.Y().T());
                    this.c.a.o();
                    zd2.e f = zd2.f(this.b, ee2.c(this.c.c.a));
                    List<String> g = db3.g(this.c.e);
                    nx1 nx1Var = this.c.g;
                    u73 u73Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    db3.m(nx1Var, u73Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.jb3.e
            public void b(int i, nj3 nj3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, nj3Var) == null) {
                    u42.c("NavigateToApi", "check pages failed");
                    ne3.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    db3.k(bVar.g, bVar.b);
                    ie3.j(this.c.c, nj3Var);
                }
            }
        }

        public b(nx1 nx1Var, ht2 ht2Var, String str, ux2 ux2Var, String str2, d72 d72Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx1Var, ht2Var, str, ux2Var, str2, d72Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = nx1Var;
            this.a = ht2Var;
            this.b = str;
            this.c = ux2Var;
            this.d = str2;
            this.e = d72Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    u73 M = u73.M();
                    if (M == null) {
                        this.g.d(this.b, new uz1(1001, "swan app is null"));
                        ie3.i(this.c);
                        return;
                    }
                    this.a.a();
                    jb3.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new uz1(1001, "swan activity is null"));
                ie3.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements nm3<xc3<zc3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ht2 b;
        public final /* synthetic */ d72 c;
        public final /* synthetic */ ux2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ nx1 g;

        public a(nx1 nx1Var, String str, ht2 ht2Var, d72 d72Var, ux2 ux2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx1Var, str, ht2Var, d72Var, ux2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = nx1Var;
            this.a = str;
            this.b = ht2Var;
            this.c = d72Var;
            this.d = ux2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nm3
        /* renamed from: b */
        public void a(xc3<zc3.e> xc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xc3Var) == null) {
                if (!sc3.h(xc3Var)) {
                    this.g.d(this.a, new uz1(10005, "system deny"));
                } else {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements zd2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zd2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ux2 c;
        public final /* synthetic */ d72 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ nx1 f;

        public c(nx1 nx1Var, zd2.e eVar, String str, ux2 ux2Var, d72 d72Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx1Var, eVar, str, ux2Var, d72Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = nx1Var;
            this.a = eVar;
            this.b = str;
            this.c = ux2Var;
            this.d = d72Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.zd2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a13.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au1 a;
        public final /* synthetic */ ux2 b;
        public final /* synthetic */ d72 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ nx1 f;

        public d(nx1 nx1Var, au1 au1Var, ux2 ux2Var, d72 d72Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx1Var, au1Var, ux2Var, d72Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = nx1Var;
            this.a = au1Var;
            this.b = ux2Var;
            this.c = d72Var;
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
    public class e extends j72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c72 a;
        public final /* synthetic */ nx1 b;

        public e(nx1 nx1Var, c72 c72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx1Var, c72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nx1Var;
            this.a = c72Var;
        }

        @Override // com.baidu.tieba.j72, com.baidu.tieba.k72
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.U2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.j72, com.baidu.tieba.k72
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = q63.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                q63.h(this.a);
            }
        }

        @Override // com.baidu.tieba.j72, com.baidu.tieba.k72
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = q63.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                q63.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948017730, "Lcom/baidu/tieba/nx1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948017730, "Lcom/baidu/tieba/nx1;");
                return;
            }
        }
        g = br2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nx1(@NonNull vv1 vv1Var) {
        super(vv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vv1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public uz1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (uz1) invokeL.objValue;
    }

    public uz1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (uz1) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(ht2 ht2Var, d72 d72Var, ux2 ux2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{ht2Var, d72Var, ux2Var, str, str2, str3}) == null) {
            ol3.a0(new b(this, ht2Var, str3, ux2Var, str, d72Var, str2));
        }
    }

    public final void D(au1 au1Var, ux2 ux2Var, d72 d72Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, au1Var, ux2Var, d72Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(au1Var, ux2Var, d72Var, str);
            } else {
                G(au1Var, ux2Var, d72Var, str);
            }
        }
    }

    public final void E(au1 au1Var, ux2 ux2Var, d72 d72Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, au1Var, ux2Var, d72Var, str, str2) == null) {
            if (ol3.O()) {
                D(au1Var, ux2Var, d72Var, str, str2);
            } else {
                ol3.a0(new d(this, au1Var, ux2Var, d72Var, str, str2));
            }
        }
    }

    public final void F(au1 au1Var, ux2 ux2Var, d72 d72Var, String str) {
        SwanAppActivity activity;
        c72 c72Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, au1Var, ux2Var, d72Var, str) == null) && (activity = ht2.U().getActivity()) != null && !activity.isFinishing()) {
            db3.e(au1Var, ux2Var, str);
            a13.c(9, str);
            c72.V3(ol3.n());
            d72.b k = d72Var.i("showModalPage").k("normal", ux2Var);
            if (!(d72Var.m() instanceof c72) || (c72Var = (c72) d72Var.m()) == null) {
                return;
            }
            c72Var.E0 = true;
            k.b();
            if (d72Var.k() > 1) {
                c72Var.A3().setBackgroundColor(0);
            } else {
                c72Var.E0 = false;
            }
            c72Var.C2(false);
            j72 j72Var = this.f;
            if (j72Var != null) {
                c72Var.U2(j72Var);
            }
            e eVar = new e(this, c72Var);
            this.f = eVar;
            c72Var.q2(eVar);
            View c2 = q63.c(c72Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            q63.h(c72Var);
            PullToRefreshBaseWebView h0 = au1Var.h0();
            if (h0 != null) {
                h0.setIsPreventPullToRefresh(true);
            }
            z03.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            a13.a(str, ux2Var);
        }
    }

    public final void G(au1 au1Var, ux2 ux2Var, d72 d72Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, au1Var, ux2Var, d72Var, str) == null) && (activity = ht2.U().getActivity()) != null && !activity.isFinishing()) {
            db3.e(au1Var, ux2Var, str);
            a13.c(0, str);
            if (d72Var.k() < g) {
                c72.V3(ol3.n());
                d72.b i = d72Var.i("navigateTo");
                i.n(d72.g, d72.i);
                i.k("normal", ux2Var).b();
                ek3.c(d72Var, getContext());
                z03.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                a13.a(str, ux2Var);
                return;
            }
            ox1.A(d72Var, ux2Var, str, true);
        }
    }

    public final uz1 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            u73 b0 = u73.b0();
            if (b0 == null) {
                return new uz1(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            a13.b(uuid);
            Pair<uz1, JSONObject> s = s(str);
            uz1 uz1Var = (uz1) s.first;
            if (!uz1Var.isSuccess()) {
                return uz1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = db3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                u42.c("NavigateToApi", "url is null");
                return new uz1(202, "url is null");
            }
            ht2 U = ht2.U();
            d72 V = U.V();
            if (V == null) {
                u42.c("NavigateToApi", "manager is null");
                return new uz1(1001, "manager is null");
            }
            ux2 d2 = ux2.d(p, U.z());
            d2.e = str2;
            d2.f = uuid;
            ie3.g(d2);
            if (!ol3.b(U.s(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                u42.c("NavigateToApi", str4);
                ie3.i(d2);
                return new uz1(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && u73.M() != null) {
                u73.M().L0(optString, d2.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = z03.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                u42.c("NavigateToApi", "cb is empty");
                ie3.i(d2);
                return new uz1(202, "cb is empty");
            } else if (ha3.b().a(d2)) {
                ha3.b().i(str3, d2);
                u42.c("NavigateToApi", "access to this page is prohibited");
                return new uz1(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, d2, uuid, str2));
                } else {
                    C(U, V, d2, uuid, str2, optString3);
                }
                return uz1.f();
            }
        }
        return (uz1) invokeLLL.objValue;
    }

    public final void K(zd2.e eVar, ux2 ux2Var, d72 d72Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, ux2Var, d72Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = z03.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            zd2.q(eVar, new c(this, eVar, str, ux2Var, d72Var, str2));
        }
    }
}
