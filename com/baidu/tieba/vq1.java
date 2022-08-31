package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.tieba.f72;
import com.baidu.tieba.j02;
import com.baidu.tieba.p43;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class vq1 extends rq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ar2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ j02 e;
        public final /* synthetic */ vq1 f;

        /* renamed from: com.baidu.tieba.vq1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0438a implements p43.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ a13 b;
            public final /* synthetic */ a c;

            public C0438a(a aVar, Activity activity, a13 a13Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, a13Var};
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
                this.b = a13Var;
            }

            @Override // com.baidu.tieba.p43.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    gu2.d(this.c.d);
                    ay1.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    f72.e f = f72.f(this.a, k72.c(this.c.c.a));
                    String a = f.a.a();
                    a aVar = this.c;
                    j43.m(aVar.f, this.b, a, aVar.c.a, null, aVar.b);
                    k73.t(a);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.p43.e
            public void b(int i, tc3 tc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, tc3Var) == null) {
                    ay1.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    j43.k(aVar.f, aVar.b);
                    o73.j(this.c.c, tc3Var);
                }
            }
        }

        public a(vq1 vq1Var, nm2 nm2Var, String str, ar2 ar2Var, String str2, j02 j02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq1Var, nm2Var, str, ar2Var, str2, j02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = vq1Var;
            this.a = nm2Var;
            this.b = str;
            this.c = ar2Var;
            this.d = str2;
            this.e = j02Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    a13 M = a13.M();
                    if (M == null) {
                        this.f.d(this.b, new at1(1001, "swan app is null"));
                        o73.i(this.c);
                        return;
                    }
                    this.a.a();
                    p43.g(M, this.c, "", new C0438a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new at1(1001, "swan activity is null"));
                o73.i(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements f72.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ar2 c;
        public final /* synthetic */ j02 d;

        public b(vq1 vq1Var, f72.e eVar, String str, ar2 ar2Var, j02 j02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq1Var, eVar, str, ar2Var, j02Var};
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
            this.c = ar2Var;
            this.d = j02Var;
        }

        @Override // com.baidu.tieba.f72.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gu2.e(this.a, this.b);
                j43.e(this.a.a, this.c, this.b);
                vq1.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements j02.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // com.baidu.tieba.j02.a
        public void a(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fragment) == null) {
            }
        }

        @Override // com.baidu.tieba.j02.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof i02)) {
                ((i02) fragment).S0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vq1(@NonNull bp1 bp1Var) {
        super(bp1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bp1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((bp1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(j02 j02Var, ar2 ar2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, j02Var, ar2Var, str) == null) {
            if (ar2Var != null) {
                ay1.i("RelaunchApi", "doReLaunch page=" + ar2Var.a + " routePage=" + ar2Var.d);
            }
            SwanAppActivity w = z03.K().w();
            if (w == null || w.isFinishing() || w.isDestroyed()) {
                return;
            }
            c cVar = new c();
            gu2.c(3, str);
            i02.S3(ue3.n());
            j02Var.g(cVar);
            j02.b i = j02Var.i("reLaunch");
            i.n(0, 0);
            i.f();
            i.k("normal", ar2Var).b();
            j02Var.p(cVar);
            fu2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            gu2.a(str, ar2Var);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public at1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            gu2.b(uuid);
            Pair<at1, JSONObject> s = s(str);
            at1 at1Var = (at1) s.first;
            if (at1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = j43.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    ay1.c("RelaunchApi", "url is null");
                    return new at1(202, "url is null");
                }
                nm2 U = nm2.U();
                j02 V = U.V();
                if (V == null) {
                    ay1.c("RelaunchApi", "manager is null");
                    return new at1(1001, "manager is null");
                }
                ar2 d = ar2.d(p, U.z());
                d.e = "3";
                d.f = uuid;
                o73.g(d);
                if (!ue3.b(U.s(), d, true)) {
                    String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                    ay1.c("RelaunchApi", str2);
                    o73.i(d);
                    return new at1(202, str2);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && a13.M() != null) {
                    a13.M().L0(optString, d.d);
                }
                String optString2 = jSONObject.optString(FetchLog.START_TIME);
                if (!TextUtils.isEmpty(optString2)) {
                    HybridUbcFlow q = fu2.q("route", uuid);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                    ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                    q.F(ubcFlowEvent);
                }
                String optString3 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString3)) {
                    ay1.c("RelaunchApi", "cb is null");
                    o73.i(d);
                    return new at1(202, "cb is null");
                } else if (n33.b().a(d)) {
                    n33.b().i("reLaunch", d);
                    ay1.c("RelaunchApi", "access to this page is prohibited");
                    return new at1(1003, "access to this page is prohibited");
                } else {
                    ue3.a0(new a(this, U, optString3, d, uuid, V));
                    return at1.f();
                }
            }
            return at1Var;
        }
        return (at1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.dp1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    public final void z(f72.e eVar, ar2 ar2Var, j02 j02Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, ar2Var, j02Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = fu2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            f72.q(eVar, new b(this, eVar, str, ar2Var, j02Var));
        }
    }
}
