package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.ai2;
import com.baidu.tieba.eb2;
import com.baidu.tieba.kf3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class p12 extends m12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ v13 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ eb2 e;
        public final /* synthetic */ p12 f;

        /* renamed from: com.baidu.tieba.p12$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0431a implements kf3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ vb3 a;
            public final /* synthetic */ a b;

            public C0431a(a aVar, vb3 vb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, vb3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = vb3Var;
            }

            @Override // com.baidu.tieba.kf3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    b53.d(this.b.d);
                    v82.i("RedirectToApi", "check pages success");
                    this.b.a.o();
                    ai2.e f = ai2.f(this.b.a.getActivity(), fi2.c(this.b.c.a));
                    String a = f.a.a();
                    a aVar = this.b;
                    ef3.m(aVar.f, this.a, a, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.C(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.kf3.e
            public void b(int i, on3 on3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, on3Var) == null) {
                    v82.c("RedirectToApi", "check pages failed");
                    this.b.a.o();
                    a aVar = this.b;
                    ef3.k(aVar.f, aVar.b);
                    ji3.j(this.b.c, on3Var);
                }
            }
        }

        public a(p12 p12Var, ix2 ix2Var, String str, v13 v13Var, String str2, eb2 eb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p12Var, ix2Var, str, v13Var, str2, eb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = p12Var;
            this.a = ix2Var;
            this.b = str;
            this.c = v13Var;
            this.d = str2;
            this.e = eb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    vb3 M = vb3.M();
                    if (M == null) {
                        this.f.d(this.b, new v32(1001, "swan app is null"));
                        ji3.i(this.c);
                        return;
                    }
                    this.a.a();
                    kf3.g(M, this.c, "", new C0431a(this, M), this.d);
                    return;
                }
                this.f.d(this.b, new v32(1001, "swan activity is null"));
                ji3.i(this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ai2.e a;
        public final /* synthetic */ v13 b;
        public final /* synthetic */ eb2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ p12 e;

        public b(p12 p12Var, ai2.e eVar, v13 v13Var, eb2 eb2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p12Var, eVar, v13Var, eb2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = p12Var;
            this.a = eVar;
            this.b = v13Var;
            this.c = eb2Var;
            this.d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.e.B(this.a, this.b, this.c, this.d);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ai2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ai2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ v13 c;
        public final /* synthetic */ eb2 d;

        public c(p12 p12Var, ai2.e eVar, String str, v13 v13Var, eb2 eb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p12Var, eVar, str, v13Var, eb2Var};
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
            this.c = v13Var;
            this.d = eb2Var;
        }

        @Override // com.baidu.tieba.ai2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b53.e(this.a, this.b);
                ef3.e(this.a.a, this.c, this.b);
                p12.A(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p12(@NonNull wz1 wz1Var) {
        super(wz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void A(eb2 eb2Var, v13 v13Var, String str, boolean z) {
        SwanAppActivity w;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{eb2Var, v13Var, str, Boolean.valueOf(z)}) == null) && !z() && (w = ub3.K().w()) != null && !w.isFinishing() && !w.isDestroyed()) {
            if (z) {
                i = 8;
            } else {
                i = 2;
            }
            b53.c(i, str);
            db2.U3(pp3.n());
            eb2.b i2 = eb2Var.i("redirectTo");
            int i3 = 0;
            i2.n(0, 0);
            eb2.b k = i2.k("normal", v13Var);
            if (!z) {
                i3 = eb2Var.k() - 2;
            }
            k.m(i3);
            k.b();
            a53.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            b53.a(str, v13Var);
        }
    }

    public static boolean z() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            vb3 b0 = vb3.b0();
            if (b0 == null || (w = b0.w()) == null || w.isFinishing() || w.isDestroyed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void B(ai2.e eVar, v13 v13Var, eb2 eb2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, v13Var, eb2Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = a53.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            ai2.q(eVar, new c(this, eVar, str, v13Var, eb2Var));
        }
    }

    public final void C(ai2.e eVar, v13 v13Var, eb2 eb2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, v13Var, eb2Var, str) == null) {
            if (pp3.O()) {
                B(eVar, v13Var, eb2Var, str);
            } else {
                pp3.a0(new b(this, eVar, v13Var, eb2Var, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public v32 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            b53.b(uuid);
            Pair<v32, JSONObject> s = s(str);
            v32 v32Var = (v32) s.first;
            if (!v32Var.isSuccess()) {
                return v32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = ef3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                v82.c("RedirectToApi", "url is null");
                return new v32(202, "url is null");
            }
            ix2 T2 = ix2.T();
            eb2 U = T2.U();
            if (U == null) {
                v82.c("RedirectToApi", "manager is null");
                return new v32(1001, "manager is null");
            }
            v13 d = v13.d(p, T2.z());
            d.e = "2";
            d.f = uuid;
            ji3.g(d);
            if (!pp3.b(T2.s(), d, false)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                v82.c("RedirectToApi", str2);
                ji3.i(d);
                return new v32(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && vb3.M() != null) {
                vb3.M().L0(optString, d.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = a53.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                v82.c("RedirectToApi", "cb is empty");
                ji3.i(d);
                return new v32(202, "cb is empty");
            } else if (ie3.b().a(d)) {
                ie3.b().i("redirectTo", d);
                v82.c("RedirectToApi", "access to this page is prohibited");
                return new v32(1003, "access to this page is prohibited");
            } else {
                pp3.a0(new a(this, T2, optString3, d, uuid, U));
                return v32.f();
            }
        }
        return (v32) invokeL.objValue;
    }
}
