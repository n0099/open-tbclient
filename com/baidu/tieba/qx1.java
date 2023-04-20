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
import com.baidu.tieba.ae2;
import com.baidu.tieba.e72;
import com.baidu.tieba.kb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class qx1 extends mx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yv1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ it2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ vx2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ e72 e;
        public final /* synthetic */ qx1 f;

        /* renamed from: com.baidu.tieba.qx1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0407a implements kb3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ v73 b;
            public final /* synthetic */ a c;

            public C0407a(a aVar, Activity activity, v73 v73Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, v73Var};
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
                this.b = v73Var;
            }

            @Override // com.baidu.tieba.kb3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    b13.d(this.c.d);
                    v42.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    ae2.e f = ae2.f(this.a, fe2.c(this.c.c.a));
                    String a = f.a.a();
                    a aVar = this.c;
                    eb3.m(aVar.f, this.b, a, aVar.c.a, null, aVar.b);
                    fe3.t(a);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.kb3.e
            public void b(int i, oj3 oj3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, oj3Var) == null) {
                    v42.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    eb3.k(aVar.f, aVar.b);
                    je3.j(this.c.c, oj3Var);
                }
            }
        }

        public a(qx1 qx1Var, it2 it2Var, String str, vx2 vx2Var, String str2, e72 e72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx1Var, it2Var, str, vx2Var, str2, e72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = qx1Var;
            this.a = it2Var;
            this.b = str;
            this.c = vx2Var;
            this.d = str2;
            this.e = e72Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    v73 M = v73.M();
                    if (M == null) {
                        this.f.d(this.b, new vz1(1001, "swan app is null"));
                        je3.i(this.c);
                        return;
                    }
                    this.a.a();
                    kb3.g(M, this.c, "", new C0407a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new vz1(1001, "swan activity is null"));
                je3.i(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ae2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ vx2 c;
        public final /* synthetic */ e72 d;

        public b(qx1 qx1Var, ae2.e eVar, String str, vx2 vx2Var, e72 e72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx1Var, eVar, str, vx2Var, e72Var};
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
            this.c = vx2Var;
            this.d = e72Var;
        }

        @Override // com.baidu.tieba.ae2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b13.e(this.a, this.b);
                eb3.e(this.a.a, this.c, this.b);
                qx1.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements e72.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.e72.a
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

        @Override // com.baidu.tieba.e72.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof d72)) {
                ((d72) fragment).T0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qx1(@NonNull wv1 wv1Var) {
        super(wv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wv1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(e72 e72Var, vx2 vx2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, e72Var, vx2Var, str) == null) {
            if (vx2Var != null) {
                v42.i("RelaunchApi", "doReLaunch page=" + vx2Var.a + " routePage=" + vx2Var.d);
            }
            SwanAppActivity w = u73.K().w();
            if (w != null && !w.isFinishing() && !w.isDestroyed()) {
                c cVar = new c();
                b13.c(3, str);
                d72.V3(pl3.n());
                e72Var.g(cVar);
                e72.b i = e72Var.i("reLaunch");
                i.n(0, 0);
                i.f();
                i.k("normal", vx2Var).b();
                e72Var.p(cVar);
                a13.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                b13.a(str, vx2Var);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public vz1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
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
                v42.c("RelaunchApi", "url is null");
                return new vz1(202, "url is null");
            }
            it2 U = it2.U();
            e72 V = U.V();
            if (V == null) {
                v42.c("RelaunchApi", "manager is null");
                return new vz1(1001, "manager is null");
            }
            vx2 d = vx2.d(p, U.z());
            d.e = "3";
            d.f = uuid;
            je3.g(d);
            if (!pl3.b(U.s(), d, true)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                v42.c("RelaunchApi", str2);
                je3.i(d);
                return new vz1(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && v73.M() != null) {
                v73.M().L0(optString, d.d);
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
                v42.c("RelaunchApi", "cb is null");
                je3.i(d);
                return new vz1(202, "cb is null");
            } else if (ia3.b().a(d)) {
                ia3.b().i("reLaunch", d);
                v42.c("RelaunchApi", "access to this page is prohibited");
                return new vz1(1003, "access to this page is prohibited");
            } else {
                pl3.a0(new a(this, U, optString3, d, uuid, V));
                return vz1.f();
            }
        }
        return (vz1) invokeL.objValue;
    }

    public final void z(ae2.e eVar, vx2 vx2Var, e72 e72Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, vx2Var, e72Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = a13.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            ae2.q(eVar, new b(this, eVar, str, vx2Var, e72Var));
        }
    }
}
