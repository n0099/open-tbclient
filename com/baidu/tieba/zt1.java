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
import com.baidu.tieba.ja2;
import com.baidu.tieba.n32;
import com.baidu.tieba.t73;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class zt1 extends vt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.hs1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ eu2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ n32 e;
        public final /* synthetic */ zt1 f;

        /* renamed from: com.baidu.tieba.zt1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0488a implements t73.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ e43 b;
            public final /* synthetic */ a c;

            public C0488a(a aVar, Activity activity, e43 e43Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, e43Var};
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
                this.b = e43Var;
            }

            @Override // com.baidu.tieba.t73.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    kx2.d(this.c.d);
                    e12.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    ja2.e f = ja2.f(this.a, oa2.c(this.c.c.a));
                    String a = f.a.a();
                    a aVar = this.c;
                    n73.m(aVar.f, this.b, a, aVar.c.a, null, aVar.b);
                    oa3.t(a);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.t73.e
            public void b(int i, xf3 xf3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, xf3Var) == null) {
                    e12.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    n73.k(aVar.f, aVar.b);
                    sa3.j(this.c.c, xf3Var);
                }
            }
        }

        public a(zt1 zt1Var, rp2 rp2Var, String str, eu2 eu2Var, String str2, n32 n32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt1Var, rp2Var, str, eu2Var, str2, n32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = zt1Var;
            this.a = rp2Var;
            this.b = str;
            this.c = eu2Var;
            this.d = str2;
            this.e = n32Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    e43 M = e43.M();
                    if (M == null) {
                        this.f.d(this.b, new ew1(1001, "swan app is null"));
                        sa3.i(this.c);
                        return;
                    }
                    this.a.a();
                    t73.g(M, this.c, "", new C0488a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new ew1(1001, "swan activity is null"));
                sa3.i(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ja2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ja2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ eu2 c;
        public final /* synthetic */ n32 d;

        public b(zt1 zt1Var, ja2.e eVar, String str, eu2 eu2Var, n32 n32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt1Var, eVar, str, eu2Var, n32Var};
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
            this.c = eu2Var;
            this.d = n32Var;
        }

        @Override // com.baidu.tieba.ja2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kx2.e(this.a, this.b);
                n73.e(this.a.a, this.c, this.b);
                zt1.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements n32.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.n32.a
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

        @Override // com.baidu.tieba.n32.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof m32)) {
                ((m32) fragment).S0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zt1(@NonNull fs1 fs1Var) {
        super(fs1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fs1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((fs1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(n32 n32Var, eu2 eu2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, n32Var, eu2Var, str) == null) {
            if (eu2Var != null) {
                e12.i("RelaunchApi", "doReLaunch page=" + eu2Var.a + " routePage=" + eu2Var.d);
            }
            SwanAppActivity w = d43.K().w();
            if (w != null && !w.isFinishing() && !w.isDestroyed()) {
                c cVar = new c();
                kx2.c(3, str);
                m32.S3(yh3.n());
                n32Var.g(cVar);
                n32.b i = n32Var.i("reLaunch");
                i.n(0, 0);
                i.f();
                i.k("normal", eu2Var).b();
                n32Var.p(cVar);
                jx2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                kx2.a(str, eu2Var);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public ew1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            kx2.b(uuid);
            Pair<ew1, JSONObject> s = s(str);
            ew1 ew1Var = (ew1) s.first;
            if (!ew1Var.isSuccess()) {
                return ew1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = n73.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                e12.c("RelaunchApi", "url is null");
                return new ew1(202, "url is null");
            }
            rp2 U = rp2.U();
            n32 V = U.V();
            if (V == null) {
                e12.c("RelaunchApi", "manager is null");
                return new ew1(1001, "manager is null");
            }
            eu2 d = eu2.d(p, U.z());
            d.e = "3";
            d.f = uuid;
            sa3.g(d);
            if (!yh3.b(U.s(), d, true)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                e12.c("RelaunchApi", str2);
                sa3.i(d);
                return new ew1(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && e43.M() != null) {
                e43.M().L0(optString, d.d);
            }
            String optString2 = jSONObject.optString(FetchLog.START_TIME);
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = jx2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                e12.c("RelaunchApi", "cb is null");
                sa3.i(d);
                return new ew1(202, "cb is null");
            } else if (r63.b().a(d)) {
                r63.b().i("reLaunch", d);
                e12.c("RelaunchApi", "access to this page is prohibited");
                return new ew1(1003, "access to this page is prohibited");
            } else {
                yh3.a0(new a(this, U, optString3, d, uuid, V));
                return ew1.f();
            }
        }
        return (ew1) invokeL.objValue;
    }

    public final void z(ja2.e eVar, eu2 eu2Var, n32 n32Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, eu2Var, n32Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = jx2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            ja2.q(eVar, new b(this, eVar, str, eu2Var, n32Var));
        }
    }
}
