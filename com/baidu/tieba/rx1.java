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
import com.baidu.tieba.ce2;
import com.baidu.tieba.g72;
import com.baidu.tieba.mb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class rx1 extends ox1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.aw1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kt2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ xx2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ g72 e;
        public final /* synthetic */ rx1 f;

        /* renamed from: com.baidu.tieba.rx1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0427a implements mb3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ x73 a;
            public final /* synthetic */ a b;

            public C0427a(a aVar, x73 x73Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, x73Var};
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
                this.a = x73Var;
            }

            @Override // com.baidu.tieba.mb3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    d13.d(this.b.d);
                    x42.i("RedirectToApi", "check pages success");
                    this.b.a.o();
                    ce2.e f = ce2.f(this.b.a.getActivity(), he2.c(this.b.c.a));
                    String a = f.a.a();
                    a aVar = this.b;
                    gb3.m(aVar.f, this.a, a, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.C(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.mb3.e
            public void b(int i, qj3 qj3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, qj3Var) == null) {
                    x42.c("RedirectToApi", "check pages failed");
                    this.b.a.o();
                    a aVar = this.b;
                    gb3.k(aVar.f, aVar.b);
                    le3.j(this.b.c, qj3Var);
                }
            }
        }

        public a(rx1 rx1Var, kt2 kt2Var, String str, xx2 xx2Var, String str2, g72 g72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rx1Var, kt2Var, str, xx2Var, str2, g72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = rx1Var;
            this.a = kt2Var;
            this.b = str;
            this.c = xx2Var;
            this.d = str2;
            this.e = g72Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    x73 M = x73.M();
                    if (M == null) {
                        this.f.d(this.b, new xz1(1001, "swan app is null"));
                        le3.i(this.c);
                        return;
                    }
                    this.a.a();
                    mb3.g(M, this.c, "", new C0427a(this, M), this.d);
                    return;
                }
                this.f.d(this.b, new xz1(1001, "swan activity is null"));
                le3.i(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ce2.e a;
        public final /* synthetic */ xx2 b;
        public final /* synthetic */ g72 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ rx1 e;

        public b(rx1 rx1Var, ce2.e eVar, xx2 xx2Var, g72 g72Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rx1Var, eVar, xx2Var, g72Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = rx1Var;
            this.a = eVar;
            this.b = xx2Var;
            this.c = g72Var;
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

    /* loaded from: classes6.dex */
    public class c implements ce2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ce2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ xx2 c;
        public final /* synthetic */ g72 d;

        public c(rx1 rx1Var, ce2.e eVar, String str, xx2 xx2Var, g72 g72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rx1Var, eVar, str, xx2Var, g72Var};
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
            this.c = xx2Var;
            this.d = g72Var;
        }

        @Override // com.baidu.tieba.ce2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d13.e(this.a, this.b);
                gb3.e(this.a.a, this.c, this.b);
                rx1.A(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rx1(@NonNull yv1 yv1Var) {
        super(yv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yv1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((yv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void A(g72 g72Var, xx2 xx2Var, String str, boolean z) {
        SwanAppActivity w;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{g72Var, xx2Var, str, Boolean.valueOf(z)}) == null) && !z() && (w = w73.K().w()) != null && !w.isFinishing() && !w.isDestroyed()) {
            if (z) {
                i = 8;
            } else {
                i = 2;
            }
            d13.c(i, str);
            f72.V3(rl3.n());
            g72.b i2 = g72Var.i("redirectTo");
            int i3 = 0;
            i2.n(0, 0);
            g72.b k = i2.k("normal", xx2Var);
            if (!z) {
                i3 = g72Var.k() - 2;
            }
            k.m(i3);
            k.b();
            c13.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            d13.a(str, xx2Var);
        }
    }

    public static boolean z() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            x73 b0 = x73.b0();
            if (b0 == null || (w = b0.w()) == null || w.isFinishing() || w.isDestroyed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void B(ce2.e eVar, xx2 xx2Var, g72 g72Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, xx2Var, g72Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = c13.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            ce2.q(eVar, new c(this, eVar, str, xx2Var, g72Var));
        }
    }

    public final void C(ce2.e eVar, xx2 xx2Var, g72 g72Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, xx2Var, g72Var, str) == null) {
            if (rl3.O()) {
                B(eVar, xx2Var, g72Var, str);
            } else {
                rl3.a0(new b(this, eVar, xx2Var, g72Var, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public xz1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            d13.b(uuid);
            Pair<xz1, JSONObject> s = s(str);
            xz1 xz1Var = (xz1) s.first;
            if (!xz1Var.isSuccess()) {
                return xz1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = gb3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                x42.c("RedirectToApi", "url is null");
                return new xz1(202, "url is null");
            }
            kt2 U = kt2.U();
            g72 V = U.V();
            if (V == null) {
                x42.c("RedirectToApi", "manager is null");
                return new xz1(1001, "manager is null");
            }
            xx2 d = xx2.d(p, U.z());
            d.e = "2";
            d.f = uuid;
            le3.g(d);
            if (!rl3.b(U.s(), d, false)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                x42.c("RedirectToApi", str2);
                le3.i(d);
                return new xz1(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && x73.M() != null) {
                x73.M().L0(optString, d.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = c13.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                x42.c("RedirectToApi", "cb is empty");
                le3.i(d);
                return new xz1(202, "cb is empty");
            } else if (ka3.b().a(d)) {
                ka3.b().i("redirectTo", d);
                x42.c("RedirectToApi", "access to this page is prohibited");
                return new xz1(1003, "access to this page is prohibited");
            } else {
                rl3.a0(new a(this, U, optString3, d, uuid, V));
                return xz1.f();
            }
        }
        return (xz1) invokeL.objValue;
    }
}
