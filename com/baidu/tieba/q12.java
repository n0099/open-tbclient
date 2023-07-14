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
import com.baidu.tieba.ai2;
import com.baidu.tieba.eb2;
import com.baidu.tieba.kf3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class q12 extends m12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ v13 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ eb2 e;
        public final /* synthetic */ q12 f;

        /* renamed from: com.baidu.tieba.q12$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0464a implements kf3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ vb3 b;
            public final /* synthetic */ a c;

            public C0464a(a aVar, Activity activity, vb3 vb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, vb3Var};
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
                this.b = vb3Var;
            }

            @Override // com.baidu.tieba.kf3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    b53.d(this.c.d);
                    v82.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    ai2.e f = ai2.f(this.a, fi2.c(this.c.c.a));
                    String a = f.a.a();
                    a aVar = this.c;
                    ef3.m(aVar.f, this.b, a, aVar.c.a, null, aVar.b);
                    fi3.t(a);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.kf3.e
            public void b(int i, on3 on3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, on3Var) == null) {
                    v82.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    ef3.k(aVar.f, aVar.b);
                    ji3.j(this.c.c, on3Var);
                }
            }
        }

        public a(q12 q12Var, ix2 ix2Var, String str, v13 v13Var, String str2, eb2 eb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q12Var, ix2Var, str, v13Var, str2, eb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = q12Var;
            this.a = ix2Var;
            this.b = str;
            this.c = v13Var;
            this.d = str2;
            this.e = eb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    vb3 M = vb3.M();
                    if (M == null) {
                        this.f.d(this.b, new v32(1001, "swan app is null"));
                        ji3.i(this.c);
                        return;
                    }
                    this.a.a();
                    kf3.g(M, this.c, "", new C0464a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new v32(1001, "swan activity is null"));
                ji3.i(this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ai2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ai2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ v13 c;
        public final /* synthetic */ eb2 d;

        public b(q12 q12Var, ai2.e eVar, String str, v13 v13Var, eb2 eb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q12Var, eVar, str, v13Var, eb2Var};
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
            this.c = v13Var;
            this.d = eb2Var;
        }

        @Override // com.baidu.tieba.ai2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b53.e(this.a, this.b);
                ef3.e(this.a.a, this.c, this.b);
                q12.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements eb2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.eb2.a
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

        @Override // com.baidu.tieba.eb2.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof db2)) {
                ((db2) fragment).T0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q12(@NonNull wz1 wz1Var) {
        super(wz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(eb2 eb2Var, v13 v13Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, eb2Var, v13Var, str) == null) {
            if (v13Var != null) {
                v82.i("RelaunchApi", "doReLaunch page=" + v13Var.a + " routePage=" + v13Var.d);
            }
            SwanAppActivity w = ub3.K().w();
            if (w != null && !w.isFinishing() && !w.isDestroyed()) {
                c cVar = new c();
                b53.c(3, str);
                db2.U3(pp3.n());
                eb2Var.g(cVar);
                eb2.b i = eb2Var.i("reLaunch");
                i.n(0, 0);
                i.f();
                i.k("normal", v13Var).b();
                eb2Var.p(cVar);
                a53.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                b53.a(str, v13Var);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public v32 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
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
                v82.c("RelaunchApi", "url is null");
                return new v32(202, "url is null");
            }
            ix2 T2 = ix2.T();
            eb2 U = T2.U();
            if (U == null) {
                v82.c("RelaunchApi", "manager is null");
                return new v32(1001, "manager is null");
            }
            v13 d = v13.d(p, T2.z());
            d.e = "3";
            d.f = uuid;
            ji3.g(d);
            if (!pp3.b(T2.s(), d, true)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                v82.c("RelaunchApi", str2);
                ji3.i(d);
                return new v32(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && vb3.M() != null) {
                vb3.M().L0(optString, d.d);
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
                v82.c("RelaunchApi", "cb is null");
                ji3.i(d);
                return new v32(202, "cb is null");
            } else if (ie3.b().a(d)) {
                ie3.b().i("reLaunch", d);
                v82.c("RelaunchApi", "access to this page is prohibited");
                return new v32(1003, "access to this page is prohibited");
            } else {
                pp3.a0(new a(this, T2, optString3, d, uuid, U));
                return v32.f();
            }
        }
        return (v32) invokeL.objValue;
    }

    public final void z(ai2.e eVar, v13 v13Var, eb2 eb2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, v13Var, eb2Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = a53.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            ai2.q(eVar, new b(this, eVar, str, v13Var, eb2Var));
        }
    }
}
