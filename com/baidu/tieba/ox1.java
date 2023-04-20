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
import com.baidu.tieba.ad3;
import com.baidu.tieba.ae2;
import com.baidu.tieba.e72;
import com.baidu.tieba.kb3;
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
public class ox1 extends mx1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public k72 f;

    @Override // com.baidu.tieba.yv1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ it2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ vx2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ e72 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ ox1 g;

        /* loaded from: classes5.dex */
        public class a implements kb3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ v73 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, v73 v73Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, v73Var, activity};
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
                this.a = v73Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.kb3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    b13.d(this.c.d);
                    v42.i("NavigateToApi", "check pages success");
                    oe3.F(true, this.a.Y().T());
                    this.c.a.o();
                    ae2.e f = ae2.f(this.b, fe2.c(this.c.c.a));
                    List<String> g = eb3.g(this.c.e);
                    ox1 ox1Var = this.c.g;
                    v73 v73Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    eb3.m(ox1Var, v73Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.kb3.e
            public void b(int i, oj3 oj3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, oj3Var) == null) {
                    v42.c("NavigateToApi", "check pages failed");
                    oe3.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    eb3.k(bVar.g, bVar.b);
                    je3.j(this.c.c, oj3Var);
                }
            }
        }

        public b(ox1 ox1Var, it2 it2Var, String str, vx2 vx2Var, String str2, e72 e72Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ox1Var, it2Var, str, vx2Var, str2, e72Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ox1Var;
            this.a = it2Var;
            this.b = str;
            this.c = vx2Var;
            this.d = str2;
            this.e = e72Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    v73 M = v73.M();
                    if (M == null) {
                        this.g.d(this.b, new vz1(1001, "swan app is null"));
                        je3.i(this.c);
                        return;
                    }
                    this.a.a();
                    kb3.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new vz1(1001, "swan activity is null"));
                je3.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements om3<yc3<ad3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ it2 b;
        public final /* synthetic */ e72 c;
        public final /* synthetic */ vx2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ ox1 g;

        public a(ox1 ox1Var, String str, it2 it2Var, e72 e72Var, vx2 vx2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ox1Var, str, it2Var, e72Var, vx2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ox1Var;
            this.a = str;
            this.b = it2Var;
            this.c = e72Var;
            this.d = vx2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(yc3<ad3.e> yc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yc3Var) == null) {
                if (!tc3.h(yc3Var)) {
                    this.g.d(this.a, new vz1(10005, "system deny"));
                } else {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ae2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ vx2 c;
        public final /* synthetic */ e72 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ ox1 f;

        public c(ox1 ox1Var, ae2.e eVar, String str, vx2 vx2Var, e72 e72Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ox1Var, eVar, str, vx2Var, e72Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ox1Var;
            this.a = eVar;
            this.b = str;
            this.c = vx2Var;
            this.d = e72Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.ae2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b13.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bu1 a;
        public final /* synthetic */ vx2 b;
        public final /* synthetic */ e72 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ ox1 f;

        public d(ox1 ox1Var, bu1 bu1Var, vx2 vx2Var, e72 e72Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ox1Var, bu1Var, vx2Var, e72Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ox1Var;
            this.a = bu1Var;
            this.b = vx2Var;
            this.c = e72Var;
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
    public class e extends k72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d72 a;
        public final /* synthetic */ ox1 b;

        public e(ox1 ox1Var, d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ox1Var, d72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ox1Var;
            this.a = d72Var;
        }

        @Override // com.baidu.tieba.k72, com.baidu.tieba.l72
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.U2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.k72, com.baidu.tieba.l72
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = r63.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                r63.h(this.a);
            }
        }

        @Override // com.baidu.tieba.k72, com.baidu.tieba.l72
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = r63.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                r63.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948047521, "Lcom/baidu/tieba/ox1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948047521, "Lcom/baidu/tieba/ox1;");
                return;
            }
        }
        g = cr2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ox1(@NonNull wv1 wv1Var) {
        super(wv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wv1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public vz1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (vz1) invokeL.objValue;
    }

    public vz1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (vz1) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(it2 it2Var, e72 e72Var, vx2 vx2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{it2Var, e72Var, vx2Var, str, str2, str3}) == null) {
            pl3.a0(new b(this, it2Var, str3, vx2Var, str, e72Var, str2));
        }
    }

    public final void D(bu1 bu1Var, vx2 vx2Var, e72 e72Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bu1Var, vx2Var, e72Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(bu1Var, vx2Var, e72Var, str);
            } else {
                G(bu1Var, vx2Var, e72Var, str);
            }
        }
    }

    public final void E(bu1 bu1Var, vx2 vx2Var, e72 e72Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, bu1Var, vx2Var, e72Var, str, str2) == null) {
            if (pl3.O()) {
                D(bu1Var, vx2Var, e72Var, str, str2);
            } else {
                pl3.a0(new d(this, bu1Var, vx2Var, e72Var, str, str2));
            }
        }
    }

    public final void F(bu1 bu1Var, vx2 vx2Var, e72 e72Var, String str) {
        SwanAppActivity activity;
        d72 d72Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, bu1Var, vx2Var, e72Var, str) == null) && (activity = it2.U().getActivity()) != null && !activity.isFinishing()) {
            eb3.e(bu1Var, vx2Var, str);
            b13.c(9, str);
            d72.V3(pl3.n());
            e72.b k = e72Var.i("showModalPage").k("normal", vx2Var);
            if (!(e72Var.m() instanceof d72) || (d72Var = (d72) e72Var.m()) == null) {
                return;
            }
            d72Var.E0 = true;
            k.b();
            if (e72Var.k() > 1) {
                d72Var.A3().setBackgroundColor(0);
            } else {
                d72Var.E0 = false;
            }
            d72Var.C2(false);
            k72 k72Var = this.f;
            if (k72Var != null) {
                d72Var.U2(k72Var);
            }
            e eVar = new e(this, d72Var);
            this.f = eVar;
            d72Var.q2(eVar);
            View c2 = r63.c(d72Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            r63.h(d72Var);
            PullToRefreshBaseWebView h0 = bu1Var.h0();
            if (h0 != null) {
                h0.setIsPreventPullToRefresh(true);
            }
            a13.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            b13.a(str, vx2Var);
        }
    }

    public final void G(bu1 bu1Var, vx2 vx2Var, e72 e72Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, bu1Var, vx2Var, e72Var, str) == null) && (activity = it2.U().getActivity()) != null && !activity.isFinishing()) {
            eb3.e(bu1Var, vx2Var, str);
            b13.c(0, str);
            if (e72Var.k() < g) {
                d72.V3(pl3.n());
                e72.b i = e72Var.i("navigateTo");
                i.n(e72.g, e72.i);
                i.k("normal", vx2Var).b();
                fk3.c(e72Var, getContext());
                a13.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                b13.a(str, vx2Var);
                return;
            }
            px1.A(e72Var, vx2Var, str, true);
        }
    }

    public final vz1 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            v73 b0 = v73.b0();
            if (b0 == null) {
                return new vz1(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            b13.b(uuid);
            Pair<vz1, JSONObject> s = s(str);
            vz1 vz1Var = (vz1) s.first;
            if (!vz1Var.isSuccess()) {
                return vz1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = eb3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                v42.c("NavigateToApi", "url is null");
                return new vz1(202, "url is null");
            }
            it2 U = it2.U();
            e72 V = U.V();
            if (V == null) {
                v42.c("NavigateToApi", "manager is null");
                return new vz1(1001, "manager is null");
            }
            vx2 d2 = vx2.d(p, U.z());
            d2.e = str2;
            d2.f = uuid;
            je3.g(d2);
            if (!pl3.b(U.s(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                v42.c("NavigateToApi", str4);
                je3.i(d2);
                return new vz1(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && v73.M() != null) {
                v73.M().L0(optString, d2.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = a13.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                v42.c("NavigateToApi", "cb is empty");
                je3.i(d2);
                return new vz1(202, "cb is empty");
            } else if (ia3.b().a(d2)) {
                ia3.b().i(str3, d2);
                v42.c("NavigateToApi", "access to this page is prohibited");
                return new vz1(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, d2, uuid, str2));
                } else {
                    C(U, V, d2, uuid, str2, optString3);
                }
                return vz1.f();
            }
        }
        return (vz1) invokeLLL.objValue;
    }

    public final void K(ae2.e eVar, vx2 vx2Var, e72 e72Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, vx2Var, e72Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = a13.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            ae2.q(eVar, new c(this, eVar, str, vx2Var, e72Var, str2));
        }
    }
}
