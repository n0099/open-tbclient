package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.tieba.ce2;
import com.baidu.tieba.g72;
import com.baidu.tieba.mb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class sx1 extends ox1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.aw1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kt2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ xx2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ g72 e;
        public final /* synthetic */ sx1 f;

        /* renamed from: com.baidu.tieba.sx1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0434a implements mb3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ x73 b;
            public final /* synthetic */ a c;

            public C0434a(a aVar, Activity activity, x73 x73Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, x73Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = activity;
                this.b = x73Var;
            }

            @Override // com.baidu.tieba.mb3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    d13.d(this.c.d);
                    x42.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    ce2.e f = ce2.f(this.a, he2.c(this.c.c.a));
                    String a = f.a.a();
                    a aVar = this.c;
                    gb3.m(aVar.f, this.b, a, aVar.c.a, null, aVar.b);
                    he3.t(a);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.mb3.e
            public void b(int i, qj3 qj3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, qj3Var) == null) {
                    x42.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    gb3.k(aVar.f, aVar.b);
                    le3.j(this.c.c, qj3Var);
                }
            }
        }

        public a(sx1 sx1Var, kt2 kt2Var, String str, xx2 xx2Var, String str2, g72 g72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx1Var, kt2Var, str, xx2Var, str2, g72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = sx1Var;
            this.a = kt2Var;
            this.b = str;
            this.c = xx2Var;
            this.d = str2;
            this.e = g72Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    x73 M = x73.M();
                    if (M == null) {
                        this.f.d(this.b, new xz1(1001, "swan app is null"));
                        le3.i(this.c);
                        return;
                    }
                    this.a.a();
                    mb3.g(M, this.c, "", new C0434a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new xz1(1001, "swan activity is null"));
                le3.i(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ce2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ce2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ xx2 c;
        public final /* synthetic */ g72 d;

        public b(sx1 sx1Var, ce2.e eVar, String str, xx2 xx2Var, g72 g72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx1Var, eVar, str, xx2Var, g72Var};
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
            this.c = xx2Var;
            this.d = g72Var;
        }

        @Override // com.baidu.tieba.ce2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d13.e(this.a, this.b);
                gb3.e(this.a.a, this.c, this.b);
                sx1.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements g72.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.g72.a
        public void a(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fragment) == null) {
            }
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.g72.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof f72)) {
                ((f72) fragment).T0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sx1(@NonNull yv1 yv1Var) {
        super(yv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yv1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((yv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(g72 g72Var, xx2 xx2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, g72Var, xx2Var, str) == null) {
            if (xx2Var != null) {
                x42.i("RelaunchApi", "doReLaunch page=" + xx2Var.a + " routePage=" + xx2Var.d);
            }
            SwanAppActivity w = w73.K().w();
            if (w != null && !w.isFinishing() && !w.isDestroyed()) {
                c cVar = new c();
                d13.c(3, str);
                f72.V3(rl3.n());
                g72Var.g(cVar);
                g72.b i = g72Var.i("reLaunch");
                i.n(0, 0);
                i.f();
                i.k("normal", xx2Var).b();
                g72Var.p(cVar);
                c13.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                d13.a(str, xx2Var);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public xz1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            d13.b(uuid);
            Pair<xz1, JSONObject> s = s(str);
            xz1 xz1Var = (xz1) s.first;
            if (!xz1Var.isSuccess()) {
                return xz1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = gb3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                x42.c("RelaunchApi", "url is null");
                return new xz1(202, "url is null");
            }
            kt2 U = kt2.U();
            g72 V = U.V();
            if (V == null) {
                x42.c("RelaunchApi", "manager is null");
                return new xz1(1001, "manager is null");
            }
            xx2 d = xx2.d(p, U.z());
            d.e = "3";
            d.f = uuid;
            le3.g(d);
            if (!rl3.b(U.s(), d, true)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                x42.c("RelaunchApi", str2);
                le3.i(d);
                return new xz1(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && x73.M() != null) {
                x73.M().L0(optString, d.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = c13.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                x42.c("RelaunchApi", "cb is null");
                le3.i(d);
                return new xz1(202, "cb is null");
            } else if (ka3.b().a(d)) {
                ka3.b().i("reLaunch", d);
                x42.c("RelaunchApi", "access to this page is prohibited");
                return new xz1(1003, "access to this page is prohibited");
            } else {
                rl3.a0(new a(this, U, optString3, d, uuid, V));
                return xz1.f();
            }
        }
        return (xz1) invokeL.objValue;
    }

    public final void z(ce2.e eVar, xx2 xx2Var, g72 g72Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, xx2Var, g72Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = c13.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            ce2.q(eVar, new b(this, eVar, str, xx2Var, g72Var));
        }
    }
}
