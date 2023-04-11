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
import com.baidu.tieba.d72;
import com.baidu.tieba.jb3;
import com.baidu.tieba.zd2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class px1 extends lx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.xv1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ht2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ux2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ d72 e;
        public final /* synthetic */ px1 f;

        /* renamed from: com.baidu.tieba.px1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0404a implements jb3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ u73 b;
            public final /* synthetic */ a c;

            public C0404a(a aVar, Activity activity, u73 u73Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, u73Var};
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
                this.b = u73Var;
            }

            @Override // com.baidu.tieba.jb3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    a13.d(this.c.d);
                    u42.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    zd2.e f = zd2.f(this.a, ee2.c(this.c.c.a));
                    String a = f.a.a();
                    a aVar = this.c;
                    db3.m(aVar.f, this.b, a, aVar.c.a, null, aVar.b);
                    ee3.t(a);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.jb3.e
            public void b(int i, nj3 nj3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, nj3Var) == null) {
                    u42.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    db3.k(aVar.f, aVar.b);
                    ie3.j(this.c.c, nj3Var);
                }
            }
        }

        public a(px1 px1Var, ht2 ht2Var, String str, ux2 ux2Var, String str2, d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {px1Var, ht2Var, str, ux2Var, str2, d72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = px1Var;
            this.a = ht2Var;
            this.b = str;
            this.c = ux2Var;
            this.d = str2;
            this.e = d72Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    u73 M = u73.M();
                    if (M == null) {
                        this.f.d(this.b, new uz1(1001, "swan app is null"));
                        ie3.i(this.c);
                        return;
                    }
                    this.a.a();
                    jb3.g(M, this.c, "", new C0404a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new uz1(1001, "swan activity is null"));
                ie3.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements zd2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zd2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ux2 c;
        public final /* synthetic */ d72 d;

        public b(px1 px1Var, zd2.e eVar, String str, ux2 ux2Var, d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {px1Var, eVar, str, ux2Var, d72Var};
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
            this.c = ux2Var;
            this.d = d72Var;
        }

        @Override // com.baidu.tieba.zd2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a13.e(this.a, this.b);
                db3.e(this.a.a, this.c, this.b);
                px1.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements d72.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.d72.a
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

        @Override // com.baidu.tieba.d72.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof c72)) {
                ((c72) fragment).T0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public px1(@NonNull vv1 vv1Var) {
        super(vv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vv1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(d72 d72Var, ux2 ux2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, d72Var, ux2Var, str) == null) {
            if (ux2Var != null) {
                u42.i("RelaunchApi", "doReLaunch page=" + ux2Var.a + " routePage=" + ux2Var.d);
            }
            SwanAppActivity w = t73.K().w();
            if (w != null && !w.isFinishing() && !w.isDestroyed()) {
                c cVar = new c();
                a13.c(3, str);
                c72.V3(ol3.n());
                d72Var.g(cVar);
                d72.b i = d72Var.i("reLaunch");
                i.n(0, 0);
                i.f();
                i.k("normal", ux2Var).b();
                d72Var.p(cVar);
                z03.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                a13.a(str, ux2Var);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public uz1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            a13.b(uuid);
            Pair<uz1, JSONObject> s = s(str);
            uz1 uz1Var = (uz1) s.first;
            if (!uz1Var.isSuccess()) {
                return uz1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = db3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                u42.c("RelaunchApi", "url is null");
                return new uz1(202, "url is null");
            }
            ht2 U = ht2.U();
            d72 V = U.V();
            if (V == null) {
                u42.c("RelaunchApi", "manager is null");
                return new uz1(1001, "manager is null");
            }
            ux2 d = ux2.d(p, U.z());
            d.e = "3";
            d.f = uuid;
            ie3.g(d);
            if (!ol3.b(U.s(), d, true)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                u42.c("RelaunchApi", str2);
                ie3.i(d);
                return new uz1(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && u73.M() != null) {
                u73.M().L0(optString, d.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = z03.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                u42.c("RelaunchApi", "cb is null");
                ie3.i(d);
                return new uz1(202, "cb is null");
            } else if (ha3.b().a(d)) {
                ha3.b().i("reLaunch", d);
                u42.c("RelaunchApi", "access to this page is prohibited");
                return new uz1(1003, "access to this page is prohibited");
            } else {
                ol3.a0(new a(this, U, optString3, d, uuid, V));
                return uz1.f();
            }
        }
        return (uz1) invokeL.objValue;
    }

    public final void z(zd2.e eVar, ux2 ux2Var, d72 d72Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, ux2Var, d72Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = z03.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            zd2.q(eVar, new b(this, eVar, str, ux2Var, d72Var));
        }
    }
}
