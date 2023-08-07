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
import com.baidu.tieba.dh2;
import com.baidu.tieba.ha2;
import com.baidu.tieba.ne3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class t02 extends p02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.bz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lw2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ y03 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ha2 e;
        public final /* synthetic */ t02 f;

        /* renamed from: com.baidu.tieba.t02$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0481a implements ne3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ ya3 b;
            public final /* synthetic */ a c;

            public C0481a(a aVar, Activity activity, ya3 ya3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, ya3Var};
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
                this.b = ya3Var;
            }

            @Override // com.baidu.tieba.ne3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    e43.d(this.c.d);
                    y72.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    dh2.e f = dh2.f(this.a, ih2.c(this.c.c.a));
                    String a = f.a.a();
                    a aVar = this.c;
                    he3.m(aVar.f, this.b, a, aVar.c.a, null, aVar.b);
                    ih3.t(a);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.ne3.e
            public void b(int i, rm3 rm3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, rm3Var) == null) {
                    y72.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    he3.k(aVar.f, aVar.b);
                    mh3.j(this.c.c, rm3Var);
                }
            }
        }

        public a(t02 t02Var, lw2 lw2Var, String str, y03 y03Var, String str2, ha2 ha2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t02Var, lw2Var, str, y03Var, str2, ha2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = t02Var;
            this.a = lw2Var;
            this.b = str;
            this.c = y03Var;
            this.d = str2;
            this.e = ha2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    ya3 M = ya3.M();
                    if (M == null) {
                        this.f.d(this.b, new y22(1001, "swan app is null"));
                        mh3.i(this.c);
                        return;
                    }
                    this.a.a();
                    ne3.g(M, this.c, "", new C0481a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new y22(1001, "swan activity is null"));
                mh3.i(this.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements dh2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ y03 c;
        public final /* synthetic */ ha2 d;

        public b(t02 t02Var, dh2.e eVar, String str, y03 y03Var, ha2 ha2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t02Var, eVar, str, y03Var, ha2Var};
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
            this.c = y03Var;
            this.d = ha2Var;
        }

        @Override // com.baidu.tieba.dh2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e43.e(this.a, this.b);
                he3.e(this.a.a, this.c, this.b);
                t02.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements ha2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.ha2.a
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

        @Override // com.baidu.tieba.ha2.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof ga2)) {
                ((ga2) fragment).T0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t02(@NonNull zy1 zy1Var) {
        super(zy1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zy1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zy1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(ha2 ha2Var, y03 y03Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, ha2Var, y03Var, str) == null) {
            if (y03Var != null) {
                y72.i("RelaunchApi", "doReLaunch page=" + y03Var.a + " routePage=" + y03Var.d);
            }
            SwanAppActivity w = xa3.K().w();
            if (w != null && !w.isFinishing() && !w.isDestroyed()) {
                c cVar = new c();
                e43.c(3, str);
                ga2.U3(so3.n());
                ha2Var.g(cVar);
                ha2.b i = ha2Var.i("reLaunch");
                i.n(0, 0);
                i.f();
                i.k("normal", y03Var).b();
                ha2Var.p(cVar);
                d43.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                e43.a(str, y03Var);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public y22 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            e43.b(uuid);
            Pair<y22, JSONObject> s = s(str);
            y22 y22Var = (y22) s.first;
            if (!y22Var.isSuccess()) {
                return y22Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = he3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                y72.c("RelaunchApi", "url is null");
                return new y22(202, "url is null");
            }
            lw2 T2 = lw2.T();
            ha2 U = T2.U();
            if (U == null) {
                y72.c("RelaunchApi", "manager is null");
                return new y22(1001, "manager is null");
            }
            y03 d = y03.d(p, T2.z());
            d.e = "3";
            d.f = uuid;
            mh3.g(d);
            if (!so3.b(T2.s(), d, true)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                y72.c("RelaunchApi", str2);
                mh3.i(d);
                return new y22(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && ya3.M() != null) {
                ya3.M().L0(optString, d.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = d43.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                y72.c("RelaunchApi", "cb is null");
                mh3.i(d);
                return new y22(202, "cb is null");
            } else if (ld3.b().a(d)) {
                ld3.b().i("reLaunch", d);
                y72.c("RelaunchApi", "access to this page is prohibited");
                return new y22(1003, "access to this page is prohibited");
            } else {
                so3.a0(new a(this, T2, optString3, d, uuid, U));
                return y22.f();
            }
        }
        return (y22) invokeL.objValue;
    }

    public final void z(dh2.e eVar, y03 y03Var, ha2 ha2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, y03Var, ha2Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = d43.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            dh2.q(eVar, new b(this, eVar, str, y03Var, ha2Var));
        }
    }
}
