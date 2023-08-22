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
import com.baidu.tieba.ih2;
import com.baidu.tieba.ma2;
import com.baidu.tieba.se3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class y02 extends u02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.gz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qw2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ d13 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ma2 e;
        public final /* synthetic */ y02 f;

        /* renamed from: com.baidu.tieba.y02$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0532a implements se3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ db3 b;
            public final /* synthetic */ a c;

            public C0532a(a aVar, Activity activity, db3 db3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, db3Var};
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
                this.b = db3Var;
            }

            @Override // com.baidu.tieba.se3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    j43.d(this.c.d);
                    d82.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    ih2.e f = ih2.f(this.a, nh2.c(this.c.c.a));
                    String a = f.a.a();
                    a aVar = this.c;
                    me3.m(aVar.f, this.b, a, aVar.c.a, null, aVar.b);
                    nh3.t(a);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.se3.e
            public void b(int i, wm3 wm3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, wm3Var) == null) {
                    d82.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    me3.k(aVar.f, aVar.b);
                    rh3.j(this.c.c, wm3Var);
                }
            }
        }

        public a(y02 y02Var, qw2 qw2Var, String str, d13 d13Var, String str2, ma2 ma2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y02Var, qw2Var, str, d13Var, str2, ma2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = y02Var;
            this.a = qw2Var;
            this.b = str;
            this.c = d13Var;
            this.d = str2;
            this.e = ma2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    db3 M = db3.M();
                    if (M == null) {
                        this.f.d(this.b, new d32(1001, "swan app is null"));
                        rh3.i(this.c);
                        return;
                    }
                    this.a.a();
                    se3.g(M, this.c, "", new C0532a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new d32(1001, "swan activity is null"));
                rh3.i(this.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ih2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ih2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ d13 c;
        public final /* synthetic */ ma2 d;

        public b(y02 y02Var, ih2.e eVar, String str, d13 d13Var, ma2 ma2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y02Var, eVar, str, d13Var, ma2Var};
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
            this.c = d13Var;
            this.d = ma2Var;
        }

        @Override // com.baidu.tieba.ih2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                j43.e(this.a, this.b);
                me3.e(this.a.a, this.c, this.b);
                y02.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements ma2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.ma2.a
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

        @Override // com.baidu.tieba.ma2.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof la2)) {
                ((la2) fragment).T0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y02(@NonNull ez1 ez1Var) {
        super(ez1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ez1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ez1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(ma2 ma2Var, d13 d13Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, ma2Var, d13Var, str) == null) {
            if (d13Var != null) {
                d82.i("RelaunchApi", "doReLaunch page=" + d13Var.a + " routePage=" + d13Var.d);
            }
            SwanAppActivity w = cb3.K().w();
            if (w != null && !w.isFinishing() && !w.isDestroyed()) {
                c cVar = new c();
                j43.c(3, str);
                la2.U3(xo3.n());
                ma2Var.g(cVar);
                ma2.b i = ma2Var.i("reLaunch");
                i.n(0, 0);
                i.f();
                i.k("normal", d13Var).b();
                ma2Var.p(cVar);
                i43.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                j43.a(str, d13Var);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public d32 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            j43.b(uuid);
            Pair<d32, JSONObject> s = s(str);
            d32 d32Var = (d32) s.first;
            if (!d32Var.isSuccess()) {
                return d32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = me3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                d82.c("RelaunchApi", "url is null");
                return new d32(202, "url is null");
            }
            qw2 T2 = qw2.T();
            ma2 U = T2.U();
            if (U == null) {
                d82.c("RelaunchApi", "manager is null");
                return new d32(1001, "manager is null");
            }
            d13 d = d13.d(p, T2.z());
            d.e = "3";
            d.f = uuid;
            rh3.g(d);
            if (!xo3.b(T2.s(), d, true)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                d82.c("RelaunchApi", str2);
                rh3.i(d);
                return new d32(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && db3.M() != null) {
                db3.M().L0(optString, d.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = i43.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                d82.c("RelaunchApi", "cb is null");
                rh3.i(d);
                return new d32(202, "cb is null");
            } else if (qd3.b().a(d)) {
                qd3.b().i("reLaunch", d);
                d82.c("RelaunchApi", "access to this page is prohibited");
                return new d32(1003, "access to this page is prohibited");
            } else {
                xo3.a0(new a(this, T2, optString3, d, uuid, U));
                return d32.f();
            }
        }
        return (d32) invokeL.objValue;
    }

    public final void z(ih2.e eVar, d13 d13Var, ma2 ma2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, d13Var, ma2Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = i43.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            ih2.q(eVar, new b(this, eVar, str, d13Var, ma2Var));
        }
    }
}
