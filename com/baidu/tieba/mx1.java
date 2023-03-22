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
import com.baidu.tieba.c72;
import com.baidu.tieba.ib3;
import com.baidu.tieba.yc3;
import com.baidu.tieba.yd2;
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
public class mx1 extends kx1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public i72 f;

    @Override // com.baidu.tieba.wv1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gt2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ tx2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ c72 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ mx1 g;

        /* loaded from: classes5.dex */
        public class a implements ib3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ t73 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, t73 t73Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, t73Var, activity};
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
                this.a = t73Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.ib3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    z03.d(this.c.d);
                    t42.i("NavigateToApi", "check pages success");
                    me3.F(true, this.a.Y().T());
                    this.c.a.o();
                    yd2.e f = yd2.f(this.b, de2.c(this.c.c.a));
                    List<String> g = cb3.g(this.c.e);
                    mx1 mx1Var = this.c.g;
                    t73 t73Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    cb3.m(mx1Var, t73Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.ib3.e
            public void b(int i, mj3 mj3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, mj3Var) == null) {
                    t42.c("NavigateToApi", "check pages failed");
                    me3.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    cb3.k(bVar.g, bVar.b);
                    he3.j(this.c.c, mj3Var);
                }
            }
        }

        public b(mx1 mx1Var, gt2 gt2Var, String str, tx2 tx2Var, String str2, c72 c72Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx1Var, gt2Var, str, tx2Var, str2, c72Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = mx1Var;
            this.a = gt2Var;
            this.b = str;
            this.c = tx2Var;
            this.d = str2;
            this.e = c72Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    t73 M = t73.M();
                    if (M == null) {
                        this.g.d(this.b, new tz1(1001, "swan app is null"));
                        he3.i(this.c);
                        return;
                    }
                    this.a.a();
                    ib3.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new tz1(1001, "swan activity is null"));
                he3.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements mm3<wc3<yc3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ gt2 b;
        public final /* synthetic */ c72 c;
        public final /* synthetic */ tx2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ mx1 g;

        public a(mx1 mx1Var, String str, gt2 gt2Var, c72 c72Var, tx2 tx2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx1Var, str, gt2Var, c72Var, tx2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = mx1Var;
            this.a = str;
            this.b = gt2Var;
            this.c = c72Var;
            this.d = tx2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(wc3<yc3.e> wc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wc3Var) == null) {
                if (!rc3.h(wc3Var)) {
                    this.g.d(this.a, new tz1(10005, "system deny"));
                } else {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements yd2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ tx2 c;
        public final /* synthetic */ c72 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ mx1 f;

        public c(mx1 mx1Var, yd2.e eVar, String str, tx2 tx2Var, c72 c72Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx1Var, eVar, str, tx2Var, c72Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = mx1Var;
            this.a = eVar;
            this.b = str;
            this.c = tx2Var;
            this.d = c72Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.yd2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                z03.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zt1 a;
        public final /* synthetic */ tx2 b;
        public final /* synthetic */ c72 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ mx1 f;

        public d(mx1 mx1Var, zt1 zt1Var, tx2 tx2Var, c72 c72Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx1Var, zt1Var, tx2Var, c72Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = mx1Var;
            this.a = zt1Var;
            this.b = tx2Var;
            this.c = c72Var;
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
    public class e extends i72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b72 a;
        public final /* synthetic */ mx1 b;

        public e(mx1 mx1Var, b72 b72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx1Var, b72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mx1Var;
            this.a = b72Var;
        }

        @Override // com.baidu.tieba.i72, com.baidu.tieba.j72
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.U2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.i72, com.baidu.tieba.j72
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = p63.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                p63.h(this.a);
            }
        }

        @Override // com.baidu.tieba.i72, com.baidu.tieba.j72
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = p63.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                p63.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947987939, "Lcom/baidu/tieba/mx1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947987939, "Lcom/baidu/tieba/mx1;");
                return;
            }
        }
        g = ar2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mx1(@NonNull uv1 uv1Var) {
        super(uv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uv1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((uv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public tz1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (tz1) invokeL.objValue;
    }

    public tz1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (tz1) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(gt2 gt2Var, c72 c72Var, tx2 tx2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{gt2Var, c72Var, tx2Var, str, str2, str3}) == null) {
            nl3.a0(new b(this, gt2Var, str3, tx2Var, str, c72Var, str2));
        }
    }

    public final void D(zt1 zt1Var, tx2 tx2Var, c72 c72Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zt1Var, tx2Var, c72Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(zt1Var, tx2Var, c72Var, str);
            } else {
                G(zt1Var, tx2Var, c72Var, str);
            }
        }
    }

    public final void E(zt1 zt1Var, tx2 tx2Var, c72 c72Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, zt1Var, tx2Var, c72Var, str, str2) == null) {
            if (nl3.O()) {
                D(zt1Var, tx2Var, c72Var, str, str2);
            } else {
                nl3.a0(new d(this, zt1Var, tx2Var, c72Var, str, str2));
            }
        }
    }

    public final void F(zt1 zt1Var, tx2 tx2Var, c72 c72Var, String str) {
        SwanAppActivity activity;
        b72 b72Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, zt1Var, tx2Var, c72Var, str) == null) && (activity = gt2.U().getActivity()) != null && !activity.isFinishing()) {
            cb3.e(zt1Var, tx2Var, str);
            z03.c(9, str);
            b72.V3(nl3.n());
            c72.b k = c72Var.i("showModalPage").k("normal", tx2Var);
            if (!(c72Var.m() instanceof b72) || (b72Var = (b72) c72Var.m()) == null) {
                return;
            }
            b72Var.E0 = true;
            k.b();
            if (c72Var.k() > 1) {
                b72Var.A3().setBackgroundColor(0);
            } else {
                b72Var.E0 = false;
            }
            b72Var.C2(false);
            i72 i72Var = this.f;
            if (i72Var != null) {
                b72Var.U2(i72Var);
            }
            e eVar = new e(this, b72Var);
            this.f = eVar;
            b72Var.q2(eVar);
            View c2 = p63.c(b72Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            p63.h(b72Var);
            PullToRefreshBaseWebView h0 = zt1Var.h0();
            if (h0 != null) {
                h0.setIsPreventPullToRefresh(true);
            }
            y03.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            z03.a(str, tx2Var);
        }
    }

    public final void G(zt1 zt1Var, tx2 tx2Var, c72 c72Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, zt1Var, tx2Var, c72Var, str) == null) && (activity = gt2.U().getActivity()) != null && !activity.isFinishing()) {
            cb3.e(zt1Var, tx2Var, str);
            z03.c(0, str);
            if (c72Var.k() < g) {
                b72.V3(nl3.n());
                c72.b i = c72Var.i("navigateTo");
                i.n(c72.g, c72.i);
                i.k("normal", tx2Var).b();
                dk3.c(c72Var, getContext());
                y03.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                z03.a(str, tx2Var);
                return;
            }
            nx1.A(c72Var, tx2Var, str, true);
        }
    }

    public final tz1 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            t73 b0 = t73.b0();
            if (b0 == null) {
                return new tz1(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            z03.b(uuid);
            Pair<tz1, JSONObject> s = s(str);
            tz1 tz1Var = (tz1) s.first;
            if (!tz1Var.isSuccess()) {
                return tz1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = cb3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                t42.c("NavigateToApi", "url is null");
                return new tz1(202, "url is null");
            }
            gt2 U = gt2.U();
            c72 V = U.V();
            if (V == null) {
                t42.c("NavigateToApi", "manager is null");
                return new tz1(1001, "manager is null");
            }
            tx2 d2 = tx2.d(p, U.z());
            d2.e = str2;
            d2.f = uuid;
            he3.g(d2);
            if (!nl3.b(U.s(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                t42.c("NavigateToApi", str4);
                he3.i(d2);
                return new tz1(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && t73.M() != null) {
                t73.M().L0(optString, d2.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = y03.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                t42.c("NavigateToApi", "cb is empty");
                he3.i(d2);
                return new tz1(202, "cb is empty");
            } else if (ga3.b().a(d2)) {
                ga3.b().i(str3, d2);
                t42.c("NavigateToApi", "access to this page is prohibited");
                return new tz1(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, d2, uuid, str2));
                } else {
                    C(U, V, d2, uuid, str2, optString3);
                }
                return tz1.f();
            }
        }
        return (tz1) invokeLLL.objValue;
    }

    public final void K(yd2.e eVar, tx2 tx2Var, c72 c72Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, tx2Var, c72Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = y03.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            yd2.q(eVar, new c(this, eVar, str, tx2Var, c72Var, str2));
        }
    }
}
