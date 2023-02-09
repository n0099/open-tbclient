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
import com.baidu.tieba.bf2;
import com.baidu.tieba.f82;
import com.baidu.tieba.lc3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ry1 extends ny1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.zw1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ wy2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ f82 e;
        public final /* synthetic */ ry1 f;

        /* renamed from: com.baidu.tieba.ry1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0422a implements lc3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ w83 b;
            public final /* synthetic */ a c;

            public C0422a(a aVar, Activity activity, w83 w83Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, w83Var};
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
                this.b = w83Var;
            }

            @Override // com.baidu.tieba.lc3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    c23.d(this.c.d);
                    w52.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    bf2.e f = bf2.f(this.a, gf2.c(this.c.c.a));
                    String a = f.a.a();
                    a aVar = this.c;
                    fc3.m(aVar.f, this.b, a, aVar.c.a, null, aVar.b);
                    gf3.t(a);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.lc3.e
            public void b(int i, pk3 pk3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, pk3Var) == null) {
                    w52.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    fc3.k(aVar.f, aVar.b);
                    kf3.j(this.c.c, pk3Var);
                }
            }
        }

        public a(ry1 ry1Var, ju2 ju2Var, String str, wy2 wy2Var, String str2, f82 f82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry1Var, ju2Var, str, wy2Var, str2, f82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ry1Var;
            this.a = ju2Var;
            this.b = str;
            this.c = wy2Var;
            this.d = str2;
            this.e = f82Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    w83 M = w83.M();
                    if (M == null) {
                        this.f.d(this.b, new w02(1001, "swan app is null"));
                        kf3.i(this.c);
                        return;
                    }
                    this.a.a();
                    lc3.g(M, this.c, "", new C0422a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new w02(1001, "swan activity is null"));
                kf3.i(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements bf2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bf2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ wy2 c;
        public final /* synthetic */ f82 d;

        public b(ry1 ry1Var, bf2.e eVar, String str, wy2 wy2Var, f82 f82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry1Var, eVar, str, wy2Var, f82Var};
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
            this.c = wy2Var;
            this.d = f82Var;
        }

        @Override // com.baidu.tieba.bf2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c23.e(this.a, this.b);
                fc3.e(this.a.a, this.c, this.b);
                ry1.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements f82.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.f82.a
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

        @Override // com.baidu.tieba.f82.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof e82)) {
                ((e82) fragment).T0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ry1(@NonNull xw1 xw1Var) {
        super(xw1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xw1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((xw1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(f82 f82Var, wy2 wy2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, f82Var, wy2Var, str) == null) {
            if (wy2Var != null) {
                w52.i("RelaunchApi", "doReLaunch page=" + wy2Var.a + " routePage=" + wy2Var.d);
            }
            SwanAppActivity w = v83.K().w();
            if (w != null && !w.isFinishing() && !w.isDestroyed()) {
                c cVar = new c();
                c23.c(3, str);
                e82.S3(qm3.n());
                f82Var.g(cVar);
                f82.b i = f82Var.i("reLaunch");
                i.n(0, 0);
                i.f();
                i.k("normal", wy2Var).b();
                f82Var.p(cVar);
                b23.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                c23.a(str, wy2Var);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public w02 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            c23.b(uuid);
            Pair<w02, JSONObject> s = s(str);
            w02 w02Var = (w02) s.first;
            if (!w02Var.isSuccess()) {
                return w02Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = fc3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                w52.c("RelaunchApi", "url is null");
                return new w02(202, "url is null");
            }
            ju2 U = ju2.U();
            f82 V = U.V();
            if (V == null) {
                w52.c("RelaunchApi", "manager is null");
                return new w02(1001, "manager is null");
            }
            wy2 d = wy2.d(p, U.z());
            d.e = "3";
            d.f = uuid;
            kf3.g(d);
            if (!qm3.b(U.s(), d, true)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                w52.c("RelaunchApi", str2);
                kf3.i(d);
                return new w02(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && w83.M() != null) {
                w83.M().L0(optString, d.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = b23.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                w52.c("RelaunchApi", "cb is null");
                kf3.i(d);
                return new w02(202, "cb is null");
            } else if (jb3.b().a(d)) {
                jb3.b().i("reLaunch", d);
                w52.c("RelaunchApi", "access to this page is prohibited");
                return new w02(1003, "access to this page is prohibited");
            } else {
                qm3.a0(new a(this, U, optString3, d, uuid, V));
                return w02.f();
            }
        }
        return (w02) invokeL.objValue;
    }

    public final void z(bf2.e eVar, wy2 wy2Var, f82 f82Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, wy2Var, f82Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = b23.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            bf2.q(eVar, new b(this, eVar, str, wy2Var, f82Var));
        }
    }
}
