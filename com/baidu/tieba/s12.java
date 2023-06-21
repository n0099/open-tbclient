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
import com.baidu.tieba.eh3;
import com.baidu.tieba.ei2;
import com.baidu.tieba.ib2;
import com.baidu.tieba.of3;
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
public class s12 extends q12 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public ob2 f;

    @Override // com.baidu.tieba.c02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ z13 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ib2 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ s12 g;

        /* loaded from: classes7.dex */
        public class a implements of3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ zb3 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, zb3 zb3Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, zb3Var, activity};
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
                this.a = zb3Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.of3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    f53.d(this.c.d);
                    z82.i("NavigateToApi", "check pages success");
                    si3.F(true, this.a.Y().T());
                    this.c.a.o();
                    ei2.e f = ei2.f(this.b, ji2.c(this.c.c.a));
                    List<String> g = if3.g(this.c.e);
                    s12 s12Var = this.c.g;
                    zb3 zb3Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    if3.m(s12Var, zb3Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.of3.e
            public void b(int i, sn3 sn3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, sn3Var) == null) {
                    z82.c("NavigateToApi", "check pages failed");
                    si3.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    if3.k(bVar.g, bVar.b);
                    ni3.j(this.c.c, sn3Var);
                }
            }
        }

        public b(s12 s12Var, mx2 mx2Var, String str, z13 z13Var, String str2, ib2 ib2Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s12Var, mx2Var, str, z13Var, str2, ib2Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = s12Var;
            this.a = mx2Var;
            this.b = str;
            this.c = z13Var;
            this.d = str2;
            this.e = ib2Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    zb3 M = zb3.M();
                    if (M == null) {
                        this.g.d(this.b, new z32(1001, "swan app is null"));
                        ni3.i(this.c);
                        return;
                    }
                    this.a.a();
                    of3.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new z32(1001, "swan activity is null"));
                ni3.i(this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements sq3<ch3<eh3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ mx2 b;
        public final /* synthetic */ ib2 c;
        public final /* synthetic */ z13 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ s12 g;

        public a(s12 s12Var, String str, mx2 mx2Var, ib2 ib2Var, z13 z13Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s12Var, str, mx2Var, ib2Var, z13Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = s12Var;
            this.a = str;
            this.b = mx2Var;
            this.c = ib2Var;
            this.d = z13Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(ch3<eh3.e> ch3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ch3Var) == null) {
                if (!xg3.h(ch3Var)) {
                    this.g.d(this.a, new z32(10005, "system deny"));
                } else {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ei2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ei2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ z13 c;
        public final /* synthetic */ ib2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ s12 f;

        public c(s12 s12Var, ei2.e eVar, String str, z13 z13Var, ib2 ib2Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s12Var, eVar, str, z13Var, ib2Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = s12Var;
            this.a = eVar;
            this.b = str;
            this.c = z13Var;
            this.d = ib2Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.ei2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f53.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy1 a;
        public final /* synthetic */ z13 b;
        public final /* synthetic */ ib2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ s12 f;

        public d(s12 s12Var, fy1 fy1Var, z13 z13Var, ib2 ib2Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s12Var, fy1Var, z13Var, ib2Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = s12Var;
            this.a = fy1Var;
            this.b = z13Var;
            this.c = ib2Var;
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
    public class e extends ob2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hb2 a;
        public final /* synthetic */ s12 b;

        public e(s12 s12Var, hb2 hb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s12Var, hb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s12Var;
            this.a = hb2Var;
        }

        @Override // com.baidu.tieba.ob2, com.baidu.tieba.pb2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.T2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.ob2, com.baidu.tieba.pb2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = va3.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                va3.h(this.a);
            }
        }

        @Override // com.baidu.tieba.ob2, com.baidu.tieba.pb2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = va3.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                va3.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948098485, "Lcom/baidu/tieba/s12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948098485, "Lcom/baidu/tieba/s12;");
                return;
            }
        }
        g = gv2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s12(@NonNull a02 a02Var) {
        super(a02Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a02Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a02) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public z32 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (z32) invokeL.objValue;
    }

    public z32 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (z32) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(mx2 mx2Var, ib2 ib2Var, z13 z13Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{mx2Var, ib2Var, z13Var, str, str2, str3}) == null) {
            tp3.a0(new b(this, mx2Var, str3, z13Var, str, ib2Var, str2));
        }
    }

    public final void D(fy1 fy1Var, z13 z13Var, ib2 ib2Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fy1Var, z13Var, ib2Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(fy1Var, z13Var, ib2Var, str);
            } else {
                G(fy1Var, z13Var, ib2Var, str);
            }
        }
    }

    public final void E(fy1 fy1Var, z13 z13Var, ib2 ib2Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, fy1Var, z13Var, ib2Var, str, str2) == null) {
            if (tp3.O()) {
                D(fy1Var, z13Var, ib2Var, str, str2);
            } else {
                tp3.a0(new d(this, fy1Var, z13Var, ib2Var, str, str2));
            }
        }
    }

    public final void F(fy1 fy1Var, z13 z13Var, ib2 ib2Var, String str) {
        SwanAppActivity activity;
        hb2 hb2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, fy1Var, z13Var, ib2Var, str) == null) && (activity = mx2.T().getActivity()) != null && !activity.isFinishing()) {
            if3.e(fy1Var, z13Var, str);
            f53.c(9, str);
            hb2.U3(tp3.n());
            ib2.b k = ib2Var.i("showModalPage").k("normal", z13Var);
            if (!(ib2Var.m() instanceof hb2) || (hb2Var = (hb2) ib2Var.m()) == null) {
                return;
            }
            hb2Var.E0 = true;
            k.b();
            if (ib2Var.k() > 1) {
                hb2Var.z3().setBackgroundColor(0);
            } else {
                hb2Var.E0 = false;
            }
            hb2Var.B2(false);
            ob2 ob2Var = this.f;
            if (ob2Var != null) {
                hb2Var.T2(ob2Var);
            }
            e eVar = new e(this, hb2Var);
            this.f = eVar;
            hb2Var.p2(eVar);
            View c2 = va3.c(hb2Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            va3.h(hb2Var);
            PullToRefreshBaseWebView f0 = fy1Var.f0();
            if (f0 != null) {
                f0.setIsPreventPullToRefresh(true);
            }
            e53.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            f53.a(str, z13Var);
        }
    }

    public final void G(fy1 fy1Var, z13 z13Var, ib2 ib2Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, fy1Var, z13Var, ib2Var, str) == null) && (activity = mx2.T().getActivity()) != null && !activity.isFinishing()) {
            if3.e(fy1Var, z13Var, str);
            f53.c(0, str);
            if (ib2Var.k() < g) {
                hb2.U3(tp3.n());
                ib2.b i = ib2Var.i("navigateTo");
                i.n(ib2.g, ib2.i);
                i.k("normal", z13Var).b();
                jo3.c(ib2Var, getContext());
                e53.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                f53.a(str, z13Var);
                return;
            }
            t12.A(ib2Var, z13Var, str, true);
        }
    }

    public final z32 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            zb3 b0 = zb3.b0();
            if (b0 == null) {
                return new z32(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            f53.b(uuid);
            Pair<z32, JSONObject> s = s(str);
            z32 z32Var = (z32) s.first;
            if (!z32Var.isSuccess()) {
                return z32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = if3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                z82.c("NavigateToApi", "url is null");
                return new z32(202, "url is null");
            }
            mx2 T2 = mx2.T();
            ib2 U = T2.U();
            if (U == null) {
                z82.c("NavigateToApi", "manager is null");
                return new z32(1001, "manager is null");
            }
            z13 d2 = z13.d(p, T2.z());
            d2.e = str2;
            d2.f = uuid;
            ni3.g(d2);
            if (!tp3.b(T2.s(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                z82.c("NavigateToApi", str4);
                ni3.i(d2);
                return new z32(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && zb3.M() != null) {
                zb3.M().L0(optString, d2.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = e53.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                z82.c("NavigateToApi", "cb is empty");
                ni3.i(d2);
                return new z32(202, "cb is empty");
            } else if (me3.b().a(d2)) {
                me3.b().i(str3, d2);
                z82.c("NavigateToApi", "access to this page is prohibited");
                return new z32(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, T2, U, d2, uuid, str2));
                } else {
                    C(T2, U, d2, uuid, str2, optString3);
                }
                return z32.f();
            }
        }
        return (z32) invokeLLL.objValue;
    }

    public final void K(ei2.e eVar, z13 z13Var, ib2 ib2Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, z13Var, ib2Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = e53.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            ei2.q(eVar, new c(this, eVar, str, z13Var, ib2Var, str2));
        }
    }
}
