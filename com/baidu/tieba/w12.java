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
import com.baidu.tieba.hi2;
import com.baidu.tieba.lb2;
import com.baidu.tieba.rf3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class w12 extends t12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.f02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ px2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ c23 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ lb2 e;
        public final /* synthetic */ w12 f;

        /* renamed from: com.baidu.tieba.w12$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0503a implements rf3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ cc3 a;
            public final /* synthetic */ a b;

            public C0503a(a aVar, cc3 cc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, cc3Var};
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
                this.a = cc3Var;
            }

            @Override // com.baidu.tieba.rf3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    i53.d(this.b.d);
                    c92.i("RedirectToApi", "check pages success");
                    this.b.a.o();
                    hi2.e f = hi2.f(this.b.a.getActivity(), mi2.c(this.b.c.a));
                    String a = f.a.a();
                    a aVar = this.b;
                    lf3.m(aVar.f, this.a, a, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.C(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.rf3.e
            public void b(int i, vn3 vn3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, vn3Var) == null) {
                    c92.c("RedirectToApi", "check pages failed");
                    this.b.a.o();
                    a aVar = this.b;
                    lf3.k(aVar.f, aVar.b);
                    qi3.j(this.b.c, vn3Var);
                }
            }
        }

        public a(w12 w12Var, px2 px2Var, String str, c23 c23Var, String str2, lb2 lb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w12Var, px2Var, str, c23Var, str2, lb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = w12Var;
            this.a = px2Var;
            this.b = str;
            this.c = c23Var;
            this.d = str2;
            this.e = lb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    cc3 M = cc3.M();
                    if (M == null) {
                        this.f.d(this.b, new c42(1001, "swan app is null"));
                        qi3.i(this.c);
                        return;
                    }
                    this.a.a();
                    rf3.g(M, this.c, "", new C0503a(this, M), this.d);
                    return;
                }
                this.f.d(this.b, new c42(1001, "swan activity is null"));
                qi3.i(this.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hi2.e a;
        public final /* synthetic */ c23 b;
        public final /* synthetic */ lb2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ w12 e;

        public b(w12 w12Var, hi2.e eVar, c23 c23Var, lb2 lb2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w12Var, eVar, c23Var, lb2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = w12Var;
            this.a = eVar;
            this.b = c23Var;
            this.c = lb2Var;
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

    /* loaded from: classes8.dex */
    public class c implements hi2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hi2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ c23 c;
        public final /* synthetic */ lb2 d;

        public c(w12 w12Var, hi2.e eVar, String str, c23 c23Var, lb2 lb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w12Var, eVar, str, c23Var, lb2Var};
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
            this.c = c23Var;
            this.d = lb2Var;
        }

        @Override // com.baidu.tieba.hi2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i53.e(this.a, this.b);
                lf3.e(this.a.a, this.c, this.b);
                w12.A(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w12(@NonNull d02 d02Var) {
        super(d02Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d02Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d02) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void A(lb2 lb2Var, c23 c23Var, String str, boolean z) {
        SwanAppActivity w;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{lb2Var, c23Var, str, Boolean.valueOf(z)}) == null) && !z() && (w = bc3.K().w()) != null && !w.isFinishing() && !w.isDestroyed()) {
            if (z) {
                i = 8;
            } else {
                i = 2;
            }
            i53.c(i, str);
            kb2.U3(wp3.n());
            lb2.b i2 = lb2Var.i("redirectTo");
            int i3 = 0;
            i2.n(0, 0);
            lb2.b k = i2.k("normal", c23Var);
            if (!z) {
                i3 = lb2Var.k() - 2;
            }
            k.m(i3);
            k.b();
            h53.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            i53.a(str, c23Var);
        }
    }

    public static boolean z() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            cc3 b0 = cc3.b0();
            if (b0 == null || (w = b0.w()) == null || w.isFinishing() || w.isDestroyed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void B(hi2.e eVar, c23 c23Var, lb2 lb2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, c23Var, lb2Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = h53.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            hi2.q(eVar, new c(this, eVar, str, c23Var, lb2Var));
        }
    }

    public final void C(hi2.e eVar, c23 c23Var, lb2 lb2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, c23Var, lb2Var, str) == null) {
            if (wp3.O()) {
                B(eVar, c23Var, lb2Var, str);
            } else {
                wp3.a0(new b(this, eVar, c23Var, lb2Var, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public c42 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            i53.b(uuid);
            Pair<c42, JSONObject> s = s(str);
            c42 c42Var = (c42) s.first;
            if (!c42Var.isSuccess()) {
                return c42Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = lf3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                c92.c("RedirectToApi", "url is null");
                return new c42(202, "url is null");
            }
            px2 T2 = px2.T();
            lb2 U = T2.U();
            if (U == null) {
                c92.c("RedirectToApi", "manager is null");
                return new c42(1001, "manager is null");
            }
            c23 d = c23.d(p, T2.z());
            d.e = "2";
            d.f = uuid;
            qi3.g(d);
            if (!wp3.b(T2.s(), d, false)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                c92.c("RedirectToApi", str2);
                qi3.i(d);
                return new c42(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && cc3.M() != null) {
                cc3.M().L0(optString, d.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = h53.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                c92.c("RedirectToApi", "cb is empty");
                qi3.i(d);
                return new c42(202, "cb is empty");
            } else if (pe3.b().a(d)) {
                pe3.b().i("redirectTo", d);
                c92.c("RedirectToApi", "access to this page is prohibited");
                return new c42(1003, "access to this page is prohibited");
            } else {
                wp3.a0(new a(this, T2, optString3, d, uuid, U));
                return c42.f();
            }
        }
        return (c42) invokeL.objValue;
    }
}
