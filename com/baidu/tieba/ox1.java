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
import com.baidu.tieba.c72;
import com.baidu.tieba.ib3;
import com.baidu.tieba.yd2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ox1 extends kx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.wv1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gt2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ tx2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ c72 e;
        public final /* synthetic */ ox1 f;

        /* renamed from: com.baidu.tieba.ox1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0370a implements ib3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ t73 b;
            public final /* synthetic */ a c;

            public C0370a(a aVar, Activity activity, t73 t73Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, t73Var};
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
                this.b = t73Var;
            }

            @Override // com.baidu.tieba.ib3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    z03.d(this.c.d);
                    t42.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    yd2.e f = yd2.f(this.a, de2.c(this.c.c.a));
                    String a = f.a.a();
                    a aVar = this.c;
                    cb3.m(aVar.f, this.b, a, aVar.c.a, null, aVar.b);
                    de3.t(a);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.ib3.e
            public void b(int i, mj3 mj3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, mj3Var) == null) {
                    t42.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    cb3.k(aVar.f, aVar.b);
                    he3.j(this.c.c, mj3Var);
                }
            }
        }

        public a(ox1 ox1Var, gt2 gt2Var, String str, tx2 tx2Var, String str2, c72 c72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ox1Var, gt2Var, str, tx2Var, str2, c72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ox1Var;
            this.a = gt2Var;
            this.b = str;
            this.c = tx2Var;
            this.d = str2;
            this.e = c72Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    t73 M = t73.M();
                    if (M == null) {
                        this.f.d(this.b, new tz1(1001, "swan app is null"));
                        he3.i(this.c);
                        return;
                    }
                    this.a.a();
                    ib3.g(M, this.c, "", new C0370a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new tz1(1001, "swan activity is null"));
                he3.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements yd2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ tx2 c;
        public final /* synthetic */ c72 d;

        public b(ox1 ox1Var, yd2.e eVar, String str, tx2 tx2Var, c72 c72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ox1Var, eVar, str, tx2Var, c72Var};
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
            this.c = tx2Var;
            this.d = c72Var;
        }

        @Override // com.baidu.tieba.yd2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                z03.e(this.a, this.b);
                cb3.e(this.a.a, this.c, this.b);
                ox1.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements c72.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.c72.a
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

        @Override // com.baidu.tieba.c72.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof b72)) {
                ((b72) fragment).T0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ox1(@NonNull uv1 uv1Var) {
        super(uv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uv1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((uv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(c72 c72Var, tx2 tx2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, c72Var, tx2Var, str) == null) {
            if (tx2Var != null) {
                t42.i("RelaunchApi", "doReLaunch page=" + tx2Var.a + " routePage=" + tx2Var.d);
            }
            SwanAppActivity w = s73.K().w();
            if (w != null && !w.isFinishing() && !w.isDestroyed()) {
                c cVar = new c();
                z03.c(3, str);
                b72.V3(nl3.n());
                c72Var.g(cVar);
                c72.b i = c72Var.i("reLaunch");
                i.n(0, 0);
                i.f();
                i.k("normal", tx2Var).b();
                c72Var.p(cVar);
                y03.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                z03.a(str, tx2Var);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public tz1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            z03.b(uuid);
            Pair<tz1, JSONObject> s = s(str);
            tz1 tz1Var = (tz1) s.first;
            if (!tz1Var.isSuccess()) {
                return tz1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = cb3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                t42.c("RelaunchApi", "url is null");
                return new tz1(202, "url is null");
            }
            gt2 U = gt2.U();
            c72 V = U.V();
            if (V == null) {
                t42.c("RelaunchApi", "manager is null");
                return new tz1(1001, "manager is null");
            }
            tx2 d = tx2.d(p, U.z());
            d.e = "3";
            d.f = uuid;
            he3.g(d);
            if (!nl3.b(U.s(), d, true)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                t42.c("RelaunchApi", str2);
                he3.i(d);
                return new tz1(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && t73.M() != null) {
                t73.M().L0(optString, d.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = y03.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                t42.c("RelaunchApi", "cb is null");
                he3.i(d);
                return new tz1(202, "cb is null");
            } else if (ga3.b().a(d)) {
                ga3.b().i("reLaunch", d);
                t42.c("RelaunchApi", "access to this page is prohibited");
                return new tz1(1003, "access to this page is prohibited");
            } else {
                nl3.a0(new a(this, U, optString3, d, uuid, V));
                return tz1.f();
            }
        }
        return (tz1) invokeL.objValue;
    }

    public final void z(yd2.e eVar, tx2 tx2Var, c72 c72Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, tx2Var, c72Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = y03.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            yd2.q(eVar, new b(this, eVar, str, tx2Var, c72Var));
        }
    }
}
