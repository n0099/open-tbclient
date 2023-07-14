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
import com.baidu.tieba.ah3;
import com.baidu.tieba.ai2;
import com.baidu.tieba.eb2;
import com.baidu.tieba.kf3;
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
public class o12 extends m12 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public kb2 f;

    @Override // com.baidu.tieba.yz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ v13 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ eb2 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ o12 g;

        /* loaded from: classes7.dex */
        public class a implements kf3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ vb3 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, vb3 vb3Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, vb3Var, activity};
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
                this.a = vb3Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.kf3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    b53.d(this.c.d);
                    v82.i("NavigateToApi", "check pages success");
                    oi3.F(true, this.a.Y().T());
                    this.c.a.o();
                    ai2.e f = ai2.f(this.b, fi2.c(this.c.c.a));
                    List<String> g = ef3.g(this.c.e);
                    o12 o12Var = this.c.g;
                    vb3 vb3Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    ef3.m(o12Var, vb3Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.kf3.e
            public void b(int i, on3 on3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, on3Var) == null) {
                    v82.c("NavigateToApi", "check pages failed");
                    oi3.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    ef3.k(bVar.g, bVar.b);
                    ji3.j(this.c.c, on3Var);
                }
            }
        }

        public b(o12 o12Var, ix2 ix2Var, String str, v13 v13Var, String str2, eb2 eb2Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o12Var, ix2Var, str, v13Var, str2, eb2Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = o12Var;
            this.a = ix2Var;
            this.b = str;
            this.c = v13Var;
            this.d = str2;
            this.e = eb2Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    vb3 M = vb3.M();
                    if (M == null) {
                        this.g.d(this.b, new v32(1001, "swan app is null"));
                        ji3.i(this.c);
                        return;
                    }
                    this.a.a();
                    kf3.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new v32(1001, "swan activity is null"));
                ji3.i(this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements oq3<yg3<ah3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ix2 b;
        public final /* synthetic */ eb2 c;
        public final /* synthetic */ v13 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ o12 g;

        public a(o12 o12Var, String str, ix2 ix2Var, eb2 eb2Var, v13 v13Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o12Var, str, ix2Var, eb2Var, v13Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = o12Var;
            this.a = str;
            this.b = ix2Var;
            this.c = eb2Var;
            this.d = v13Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(yg3<ah3.e> yg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yg3Var) == null) {
                if (!tg3.h(yg3Var)) {
                    this.g.d(this.a, new v32(10005, "system deny"));
                } else {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ai2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ai2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ v13 c;
        public final /* synthetic */ eb2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ o12 f;

        public c(o12 o12Var, ai2.e eVar, String str, v13 v13Var, eb2 eb2Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o12Var, eVar, str, v13Var, eb2Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = o12Var;
            this.a = eVar;
            this.b = str;
            this.c = v13Var;
            this.d = eb2Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.ai2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b53.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ by1 a;
        public final /* synthetic */ v13 b;
        public final /* synthetic */ eb2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ o12 f;

        public d(o12 o12Var, by1 by1Var, v13 v13Var, eb2 eb2Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o12Var, by1Var, v13Var, eb2Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = o12Var;
            this.a = by1Var;
            this.b = v13Var;
            this.c = eb2Var;
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
    public class e extends kb2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db2 a;
        public final /* synthetic */ o12 b;

        public e(o12 o12Var, db2 db2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o12Var, db2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o12Var;
            this.a = db2Var;
        }

        @Override // com.baidu.tieba.kb2, com.baidu.tieba.lb2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.T2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.kb2, com.baidu.tieba.lb2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = ra3.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                ra3.h(this.a);
            }
        }

        @Override // com.baidu.tieba.kb2, com.baidu.tieba.lb2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = ra3.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                ra3.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947979321, "Lcom/baidu/tieba/o12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947979321, "Lcom/baidu/tieba/o12;");
                return;
            }
        }
        g = cv2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o12(@NonNull wz1 wz1Var) {
        super(wz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wz1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public v32 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (v32) invokeL.objValue;
    }

    public v32 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (v32) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(ix2 ix2Var, eb2 eb2Var, v13 v13Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{ix2Var, eb2Var, v13Var, str, str2, str3}) == null) {
            pp3.a0(new b(this, ix2Var, str3, v13Var, str, eb2Var, str2));
        }
    }

    public final void D(by1 by1Var, v13 v13Var, eb2 eb2Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, by1Var, v13Var, eb2Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(by1Var, v13Var, eb2Var, str);
            } else {
                G(by1Var, v13Var, eb2Var, str);
            }
        }
    }

    public final void E(by1 by1Var, v13 v13Var, eb2 eb2Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, by1Var, v13Var, eb2Var, str, str2) == null) {
            if (pp3.O()) {
                D(by1Var, v13Var, eb2Var, str, str2);
            } else {
                pp3.a0(new d(this, by1Var, v13Var, eb2Var, str, str2));
            }
        }
    }

    public final void F(by1 by1Var, v13 v13Var, eb2 eb2Var, String str) {
        SwanAppActivity activity;
        db2 db2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, by1Var, v13Var, eb2Var, str) == null) && (activity = ix2.T().getActivity()) != null && !activity.isFinishing()) {
            ef3.e(by1Var, v13Var, str);
            b53.c(9, str);
            db2.U3(pp3.n());
            eb2.b k = eb2Var.i("showModalPage").k("normal", v13Var);
            if (!(eb2Var.m() instanceof db2) || (db2Var = (db2) eb2Var.m()) == null) {
                return;
            }
            db2Var.E0 = true;
            k.b();
            if (eb2Var.k() > 1) {
                db2Var.z3().setBackgroundColor(0);
            } else {
                db2Var.E0 = false;
            }
            db2Var.B2(false);
            kb2 kb2Var = this.f;
            if (kb2Var != null) {
                db2Var.T2(kb2Var);
            }
            e eVar = new e(this, db2Var);
            this.f = eVar;
            db2Var.p2(eVar);
            View c2 = ra3.c(db2Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            ra3.h(db2Var);
            PullToRefreshBaseWebView f0 = by1Var.f0();
            if (f0 != null) {
                f0.setIsPreventPullToRefresh(true);
            }
            a53.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            b53.a(str, v13Var);
        }
    }

    public final void G(by1 by1Var, v13 v13Var, eb2 eb2Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, by1Var, v13Var, eb2Var, str) == null) && (activity = ix2.T().getActivity()) != null && !activity.isFinishing()) {
            ef3.e(by1Var, v13Var, str);
            b53.c(0, str);
            if (eb2Var.k() < g) {
                db2.U3(pp3.n());
                eb2.b i = eb2Var.i("navigateTo");
                i.n(eb2.g, eb2.i);
                i.k("normal", v13Var).b();
                fo3.c(eb2Var, getContext());
                a53.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                b53.a(str, v13Var);
                return;
            }
            p12.A(eb2Var, v13Var, str, true);
        }
    }

    public final v32 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            vb3 b0 = vb3.b0();
            if (b0 == null) {
                return new v32(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            b53.b(uuid);
            Pair<v32, JSONObject> s = s(str);
            v32 v32Var = (v32) s.first;
            if (!v32Var.isSuccess()) {
                return v32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = ef3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                v82.c("NavigateToApi", "url is null");
                return new v32(202, "url is null");
            }
            ix2 T2 = ix2.T();
            eb2 U = T2.U();
            if (U == null) {
                v82.c("NavigateToApi", "manager is null");
                return new v32(1001, "manager is null");
            }
            v13 d2 = v13.d(p, T2.z());
            d2.e = str2;
            d2.f = uuid;
            ji3.g(d2);
            if (!pp3.b(T2.s(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                v82.c("NavigateToApi", str4);
                ji3.i(d2);
                return new v32(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && vb3.M() != null) {
                vb3.M().L0(optString, d2.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = a53.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                v82.c("NavigateToApi", "cb is empty");
                ji3.i(d2);
                return new v32(202, "cb is empty");
            } else if (ie3.b().a(d2)) {
                ie3.b().i(str3, d2);
                v82.c("NavigateToApi", "access to this page is prohibited");
                return new v32(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, T2, U, d2, uuid, str2));
                } else {
                    C(T2, U, d2, uuid, str2, optString3);
                }
                return v32.f();
            }
        }
        return (v32) invokeLLL.objValue;
    }

    public final void K(ai2.e eVar, v13 v13Var, eb2 eb2Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, v13Var, eb2Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = a53.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            ai2.q(eVar, new c(this, eVar, str, v13Var, eb2Var, str2));
        }
    }
}
