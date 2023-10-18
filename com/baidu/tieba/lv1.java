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
import com.baidu.tieba.e93;
import com.baidu.tieba.ub2;
import com.baidu.tieba.y42;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class lv1 extends hv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.tt1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ pv2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ y42 e;
        public final /* synthetic */ lv1 f;

        /* renamed from: com.baidu.tieba.lv1$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0377a implements e93.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ p53 b;
            public final /* synthetic */ a c;

            public C0377a(a aVar, Activity activity, p53 p53Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, p53Var};
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
                this.b = p53Var;
            }

            @Override // com.baidu.tieba.e93.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    vy2.d(this.c.d);
                    p22.i("RelaunchApi", "check pages success");
                    this.c.a.p();
                    ub2.e f = ub2.f(this.a, zb2.c(this.c.c.a));
                    String a = f.a.a();
                    a aVar = this.c;
                    y83.m(aVar.f, this.b, a, aVar.c.a, null, aVar.b);
                    zb3.t(a);
                    a aVar2 = this.c;
                    aVar2.f.A(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.e93.e
            public void b(int i, ih3 ih3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ih3Var) == null) {
                    p22.c("RelaunchApi", "check pages failed");
                    this.c.a.p();
                    a aVar = this.c;
                    y83.k(aVar.f, aVar.b);
                    dc3.j(this.c.c, ih3Var);
                }
            }
        }

        public a(lv1 lv1Var, cr2 cr2Var, String str, pv2 pv2Var, String str2, y42 y42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv1Var, cr2Var, str, pv2Var, str2, y42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = lv1Var;
            this.a = cr2Var;
            this.b = str;
            this.c = pv2Var;
            this.d = str2;
            this.e = y42Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    p53 M = p53.M();
                    if (M == null) {
                        this.f.d(this.b, new qx1(1001, "swan app is null"));
                        dc3.i(this.c);
                        return;
                    }
                    this.a.a();
                    e93.g(M, this.c, "", new C0377a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new qx1(1001, "swan activity is null"));
                dc3.i(this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ub2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ pv2 c;
        public final /* synthetic */ y42 d;

        public b(lv1 lv1Var, ub2.e eVar, String str, pv2 pv2Var, y42 y42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv1Var, eVar, str, pv2Var, y42Var};
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
            this.c = pv2Var;
            this.d = y42Var;
        }

        @Override // com.baidu.tieba.ub2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vy2.e(this.a, this.b);
                y83.e(this.a.a, this.c, this.b);
                lv1.z(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements y42.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.y42.a
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

        @Override // com.baidu.tieba.y42.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof x42)) {
                ((x42) fragment).T0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lv1(@NonNull rt1 rt1Var) {
        super(rt1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rt1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rt1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void z(y42 y42Var, pv2 pv2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, y42Var, pv2Var, str) == null) {
            if (pv2Var != null) {
                p22.i("RelaunchApi", "doReLaunch page=" + pv2Var.a + " routePage=" + pv2Var.d);
            }
            SwanAppActivity w = o53.K().w();
            if (w != null && !w.isFinishing() && !w.isDestroyed()) {
                c cVar = new c();
                vy2.c(3, str);
                x42.Z3(jj3.n());
                y42Var.g(cVar);
                y42.b i = y42Var.i("reLaunch");
                i.n(0, 0);
                i.f();
                i.k("normal", pv2Var).b();
                y42Var.p(cVar);
                uy2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                vy2.a(str, pv2Var);
            }
        }
    }

    public final void A(ub2.e eVar, pv2 pv2Var, y42 y42Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, pv2Var, y42Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = uy2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            ub2.q(eVar, new b(this, eVar, str, pv2Var, y42Var));
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public qx1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            r("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            vy2.b(uuid);
            Pair<qx1, JSONObject> t = t(str);
            qx1 qx1Var = (qx1) t.first;
            if (!qx1Var.isSuccess()) {
                return qx1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            String p = y83.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                p22.c("RelaunchApi", "url is null");
                return new qx1(202, "url is null");
            }
            cr2 V = cr2.V();
            y42 W = V.W();
            if (W == null) {
                p22.c("RelaunchApi", "manager is null");
                return new qx1(1001, "manager is null");
            }
            pv2 d = pv2.d(p, V.A());
            d.e = "3";
            d.f = uuid;
            dc3.g(d);
            if (!jj3.b(V.t(), d, true)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                p22.c("RelaunchApi", str2);
                dc3.i(d);
                return new qx1(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && p53.M() != null) {
                p53.M().M0(optString, d.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = uy2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                p22.c("RelaunchApi", "cb is null");
                dc3.i(d);
                return new qx1(202, "cb is null");
            } else if (c83.b().a(d)) {
                c83.b().i("reLaunch", d);
                p22.c("RelaunchApi", "access to this page is prohibited");
                return new qx1(1003, "access to this page is prohibited");
            } else {
                jj3.a0(new a(this, V, optString3, d, uuid, W));
                return qx1.f();
            }
        }
        return (qx1) invokeL.objValue;
    }
}
