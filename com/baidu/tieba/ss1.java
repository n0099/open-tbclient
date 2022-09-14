package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.d92;
import com.baidu.tieba.h22;
import com.baidu.tieba.n63;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ss1 extends ps1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lo2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ys2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ h22 e;
        public final /* synthetic */ ss1 f;

        /* renamed from: com.baidu.tieba.ss1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0414a implements n63.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ y23 a;
            public final /* synthetic */ a b;

            public C0414a(a aVar, y23 y23Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, y23Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = y23Var;
            }

            @Override // com.baidu.tieba.n63.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    ew2.d(this.b.d);
                    yz1.i("RedirectToApi", "check pages success");
                    this.b.a.o();
                    d92.e f = d92.f(this.b.a.getActivity(), i92.c(this.b.c.a));
                    String a = f.a.a();
                    a aVar = this.b;
                    h63.m(aVar.f, this.a, a, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.C(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.n63.e
            public void b(int i, re3 re3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, re3Var) == null) {
                    yz1.c("RedirectToApi", "check pages failed");
                    this.b.a.o();
                    a aVar = this.b;
                    h63.k(aVar.f, aVar.b);
                    m93.j(this.b.c, re3Var);
                }
            }
        }

        public a(ss1 ss1Var, lo2 lo2Var, String str, ys2 ys2Var, String str2, h22 h22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ss1Var, lo2Var, str, ys2Var, str2, h22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ss1Var;
            this.a = lo2Var;
            this.b = str;
            this.c = ys2Var;
            this.d = str2;
            this.e = h22Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    y23 M = y23.M();
                    if (M == null) {
                        this.f.d(this.b, new yu1(1001, "swan app is null"));
                        m93.i(this.c);
                        return;
                    }
                    this.a.a();
                    n63.g(M, this.c, "", new C0414a(this, M), this.d);
                    return;
                }
                this.f.d(this.b, new yu1(1001, "swan activity is null"));
                m93.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d92.e a;
        public final /* synthetic */ ys2 b;
        public final /* synthetic */ h22 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ss1 e;

        public b(ss1 ss1Var, d92.e eVar, ys2 ys2Var, h22 h22Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ss1Var, eVar, ys2Var, h22Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ss1Var;
            this.a = eVar;
            this.b = ys2Var;
            this.c = h22Var;
            this.d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.B(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements d92.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d92.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ys2 c;
        public final /* synthetic */ h22 d;

        public c(ss1 ss1Var, d92.e eVar, String str, ys2 ys2Var, h22 h22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ss1Var, eVar, str, ys2Var, h22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.b = str;
            this.c = ys2Var;
            this.d = h22Var;
        }

        @Override // com.baidu.tieba.d92.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ew2.e(this.a, this.b);
                h63.e(this.a.a, this.c, this.b);
                ss1.A(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ss1(@NonNull zq1 zq1Var) {
        super(zq1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zq1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zq1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void A(h22 h22Var, ys2 ys2Var, String str, boolean z) {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{h22Var, ys2Var, str, Boolean.valueOf(z)}) == null) || z() || (w = x23.K().w()) == null || w.isFinishing() || w.isDestroyed()) {
            return;
        }
        ew2.c(z ? 8 : 2, str);
        g22.S3(sg3.n());
        h22.b i = h22Var.i("redirectTo");
        i.n(0, 0);
        h22.b k = i.k("normal", ys2Var);
        k.m(z ? 0 : h22Var.k() - 2);
        k.b();
        dw2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
        ew2.a(str, ys2Var);
    }

    public static boolean z() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            y23 b0 = y23.b0();
            return b0 == null || (w = b0.w()) == null || w.isFinishing() || w.isDestroyed();
        }
        return invokeV.booleanValue;
    }

    public final void B(d92.e eVar, ys2 ys2Var, h22 h22Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, ys2Var, h22Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = dw2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            d92.q(eVar, new c(this, eVar, str, ys2Var, h22Var));
        }
    }

    public final void C(d92.e eVar, ys2 ys2Var, h22 h22Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, ys2Var, h22Var, str) == null) {
            if (sg3.O()) {
                B(eVar, ys2Var, h22Var, str);
            } else {
                sg3.a0(new b(this, eVar, ys2Var, h22Var, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public yu1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            ew2.b(uuid);
            Pair<yu1, JSONObject> s = s(str);
            yu1 yu1Var = (yu1) s.first;
            if (yu1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = h63.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    yz1.c("RedirectToApi", "url is null");
                    return new yu1(202, "url is null");
                }
                lo2 U = lo2.U();
                h22 V = U.V();
                if (V == null) {
                    yz1.c("RedirectToApi", "manager is null");
                    return new yu1(1001, "manager is null");
                }
                ys2 d = ys2.d(p, U.z());
                d.e = "2";
                d.f = uuid;
                m93.g(d);
                if (!sg3.b(U.s(), d, false)) {
                    String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                    yz1.c("RedirectToApi", str2);
                    m93.i(d);
                    return new yu1(202, str2);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && y23.M() != null) {
                    y23.M().L0(optString, d.d);
                }
                String optString2 = jSONObject.optString(FetchLog.START_TIME);
                if (!TextUtils.isEmpty(optString2)) {
                    HybridUbcFlow q = dw2.q("route", uuid);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                    ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                    q.F(ubcFlowEvent);
                }
                String optString3 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString3)) {
                    yz1.c("RedirectToApi", "cb is empty");
                    m93.i(d);
                    return new yu1(202, "cb is empty");
                } else if (l53.b().a(d)) {
                    l53.b().i("redirectTo", d);
                    yz1.c("RedirectToApi", "access to this page is prohibited");
                    return new yu1(1003, "access to this page is prohibited");
                } else {
                    sg3.a0(new a(this, U, optString3, d, uuid, V));
                    return yu1.f();
                }
            }
            return yu1Var;
        }
        return (yu1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.br1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }
}
