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
import com.baidu.tieba.hi2;
import com.baidu.tieba.lb2;
import com.baidu.tieba.rf3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class x12 extends t12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.f02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ px2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ c23 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ lb2 e;
        public final /* synthetic */ x12 f;

        /* renamed from: com.baidu.tieba.x12$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0523a implements rf3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ cc3 b;
            public final /* synthetic */ a c;

            public C0523a(a aVar, Activity activity, cc3 cc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, cc3Var};
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
                this.b = cc3Var;
            }

            @Override // com.baidu.tieba.rf3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i53.d(this.c.d);
                    c92.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    hi2.e f = hi2.f(this.a, mi2.c(this.c.c.a));
                    String a = f.a.a();
                    a aVar = this.c;
                    lf3.m(aVar.f, this.b, a, aVar.c.a, null, aVar.b);
                    mi3.t(a);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.rf3.e
            public void b(int i, vn3 vn3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, vn3Var) == null) {
                    c92.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    lf3.k(aVar.f, aVar.b);
                    qi3.j(this.c.c, vn3Var);
                }
            }
        }

        public a(x12 x12Var, px2 px2Var, String str, c23 c23Var, String str2, lb2 lb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x12Var, px2Var, str, c23Var, str2, lb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = x12Var;
            this.a = px2Var;
            this.b = str;
            this.c = c23Var;
            this.d = str2;
            this.e = lb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    cc3 M = cc3.M();
                    if (M == null) {
                        this.f.d(this.b, new c42(1001, "swan app is null"));
                        qi3.i(this.c);
                        return;
                    }
                    this.a.a();
                    rf3.g(M, this.c, "", new C0523a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new c42(1001, "swan activity is null"));
                qi3.i(this.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements hi2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hi2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ c23 c;
        public final /* synthetic */ lb2 d;

        public b(x12 x12Var, hi2.e eVar, String str, c23 c23Var, lb2 lb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x12Var, eVar, str, c23Var, lb2Var};
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
            this.c = c23Var;
            this.d = lb2Var;
        }

        @Override // com.baidu.tieba.hi2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i53.e(this.a, this.b);
                lf3.e(this.a.a, this.c, this.b);
                x12.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements lb2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.lb2.a
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

        @Override // com.baidu.tieba.lb2.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof kb2)) {
                ((kb2) fragment).T0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x12(@NonNull d02 d02Var) {
        super(d02Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d02Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d02) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(lb2 lb2Var, c23 c23Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, lb2Var, c23Var, str) == null) {
            if (c23Var != null) {
                c92.i("RelaunchApi", "doReLaunch page=" + c23Var.a + " routePage=" + c23Var.d);
            }
            SwanAppActivity w = bc3.K().w();
            if (w != null && !w.isFinishing() && !w.isDestroyed()) {
                c cVar = new c();
                i53.c(3, str);
                kb2.U3(wp3.n());
                lb2Var.g(cVar);
                lb2.b i = lb2Var.i("reLaunch");
                i.n(0, 0);
                i.f();
                i.k("normal", c23Var).b();
                lb2Var.p(cVar);
                h53.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                i53.a(str, c23Var);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public c42 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            i53.b(uuid);
            Pair<c42, JSONObject> s = s(str);
            c42 c42Var = (c42) s.first;
            if (!c42Var.isSuccess()) {
                return c42Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = lf3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                c92.c("RelaunchApi", "url is null");
                return new c42(202, "url is null");
            }
            px2 T2 = px2.T();
            lb2 U = T2.U();
            if (U == null) {
                c92.c("RelaunchApi", "manager is null");
                return new c42(1001, "manager is null");
            }
            c23 d = c23.d(p, T2.z());
            d.e = "3";
            d.f = uuid;
            qi3.g(d);
            if (!wp3.b(T2.s(), d, true)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                c92.c("RelaunchApi", str2);
                qi3.i(d);
                return new c42(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && cc3.M() != null) {
                cc3.M().L0(optString, d.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = h53.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                c92.c("RelaunchApi", "cb is null");
                qi3.i(d);
                return new c42(202, "cb is null");
            } else if (pe3.b().a(d)) {
                pe3.b().i("reLaunch", d);
                c92.c("RelaunchApi", "access to this page is prohibited");
                return new c42(1003, "access to this page is prohibited");
            } else {
                wp3.a0(new a(this, T2, optString3, d, uuid, U));
                return c42.f();
            }
        }
        return (c42) invokeL.objValue;
    }

    public final void z(hi2.e eVar, c23 c23Var, lb2 lb2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, c23Var, lb2Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = h53.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            hi2.q(eVar, new b(this, eVar, str, c23Var, lb2Var));
        }
    }
}
