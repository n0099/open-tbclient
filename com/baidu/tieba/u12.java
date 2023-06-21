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
import com.baidu.tieba.ei2;
import com.baidu.tieba.ib2;
import com.baidu.tieba.of3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class u12 extends q12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.c02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ z13 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ib2 e;
        public final /* synthetic */ u12 f;

        /* renamed from: com.baidu.tieba.u12$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0467a implements of3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ zb3 b;
            public final /* synthetic */ a c;

            public C0467a(a aVar, Activity activity, zb3 zb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, zb3Var};
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
                this.b = zb3Var;
            }

            @Override // com.baidu.tieba.of3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    f53.d(this.c.d);
                    z82.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    ei2.e f = ei2.f(this.a, ji2.c(this.c.c.a));
                    String a = f.a.a();
                    a aVar = this.c;
                    if3.m(aVar.f, this.b, a, aVar.c.a, null, aVar.b);
                    ji3.t(a);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.of3.e
            public void b(int i, sn3 sn3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, sn3Var) == null) {
                    z82.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    if3.k(aVar.f, aVar.b);
                    ni3.j(this.c.c, sn3Var);
                }
            }
        }

        public a(u12 u12Var, mx2 mx2Var, String str, z13 z13Var, String str2, ib2 ib2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u12Var, mx2Var, str, z13Var, str2, ib2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = u12Var;
            this.a = mx2Var;
            this.b = str;
            this.c = z13Var;
            this.d = str2;
            this.e = ib2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    zb3 M = zb3.M();
                    if (M == null) {
                        this.f.d(this.b, new z32(1001, "swan app is null"));
                        ni3.i(this.c);
                        return;
                    }
                    this.a.a();
                    of3.g(M, this.c, "", new C0467a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new z32(1001, "swan activity is null"));
                ni3.i(this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ei2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ei2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ z13 c;
        public final /* synthetic */ ib2 d;

        public b(u12 u12Var, ei2.e eVar, String str, z13 z13Var, ib2 ib2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u12Var, eVar, str, z13Var, ib2Var};
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
            this.c = z13Var;
            this.d = ib2Var;
        }

        @Override // com.baidu.tieba.ei2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f53.e(this.a, this.b);
                if3.e(this.a.a, this.c, this.b);
                u12.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements ib2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.ib2.a
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

        @Override // com.baidu.tieba.ib2.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof hb2)) {
                ((hb2) fragment).T0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u12(@NonNull a02 a02Var) {
        super(a02Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a02Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a02) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(ib2 ib2Var, z13 z13Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, ib2Var, z13Var, str) == null) {
            if (z13Var != null) {
                z82.i("RelaunchApi", "doReLaunch page=" + z13Var.a + " routePage=" + z13Var.d);
            }
            SwanAppActivity w = yb3.K().w();
            if (w != null && !w.isFinishing() && !w.isDestroyed()) {
                c cVar = new c();
                f53.c(3, str);
                hb2.U3(tp3.n());
                ib2Var.g(cVar);
                ib2.b i = ib2Var.i("reLaunch");
                i.n(0, 0);
                i.f();
                i.k("normal", z13Var).b();
                ib2Var.p(cVar);
                e53.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                f53.a(str, z13Var);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public z32 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            f53.b(uuid);
            Pair<z32, JSONObject> s = s(str);
            z32 z32Var = (z32) s.first;
            if (!z32Var.isSuccess()) {
                return z32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = if3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                z82.c("RelaunchApi", "url is null");
                return new z32(202, "url is null");
            }
            mx2 T2 = mx2.T();
            ib2 U = T2.U();
            if (U == null) {
                z82.c("RelaunchApi", "manager is null");
                return new z32(1001, "manager is null");
            }
            z13 d = z13.d(p, T2.z());
            d.e = "3";
            d.f = uuid;
            ni3.g(d);
            if (!tp3.b(T2.s(), d, true)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                z82.c("RelaunchApi", str2);
                ni3.i(d);
                return new z32(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && zb3.M() != null) {
                zb3.M().L0(optString, d.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = e53.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                z82.c("RelaunchApi", "cb is null");
                ni3.i(d);
                return new z32(202, "cb is null");
            } else if (me3.b().a(d)) {
                me3.b().i("reLaunch", d);
                z82.c("RelaunchApi", "access to this page is prohibited");
                return new z32(1003, "access to this page is prohibited");
            } else {
                tp3.a0(new a(this, T2, optString3, d, uuid, U));
                return z32.f();
            }
        }
        return (z32) invokeL.objValue;
    }

    public final void z(ei2.e eVar, z13 z13Var, ib2 ib2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, z13Var, ib2Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = e53.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            ei2.q(eVar, new b(this, eVar, str, z13Var, ib2Var));
        }
    }
}
