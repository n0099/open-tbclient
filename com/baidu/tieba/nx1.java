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
public class nx1 extends kx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.wv1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
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
        public final /* synthetic */ nx1 f;

        /* renamed from: com.baidu.tieba.nx1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0360a implements ib3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ t73 a;
            public final /* synthetic */ a b;

            public C0360a(a aVar, t73 t73Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, t73Var};
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
                this.a = t73Var;
            }

            @Override // com.baidu.tieba.ib3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    z03.d(this.b.d);
                    t42.i("RedirectToApi", "check pages success");
                    this.b.a.o();
                    yd2.e f = yd2.f(this.b.a.getActivity(), de2.c(this.b.c.a));
                    String a = f.a.a();
                    a aVar = this.b;
                    cb3.m(aVar.f, this.a, a, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.C(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.ib3.e
            public void b(int i, mj3 mj3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, mj3Var) == null) {
                    t42.c("RedirectToApi", "check pages failed");
                    this.b.a.o();
                    a aVar = this.b;
                    cb3.k(aVar.f, aVar.b);
                    he3.j(this.b.c, mj3Var);
                }
            }
        }

        public a(nx1 nx1Var, gt2 gt2Var, String str, tx2 tx2Var, String str2, c72 c72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx1Var, gt2Var, str, tx2Var, str2, c72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = nx1Var;
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
                    ib3.g(M, this.c, "", new C0360a(this, M), this.d);
                    return;
                }
                this.f.d(this.b, new tz1(1001, "swan activity is null"));
                he3.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd2.e a;
        public final /* synthetic */ tx2 b;
        public final /* synthetic */ c72 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ nx1 e;

        public b(nx1 nx1Var, yd2.e eVar, tx2 tx2Var, c72 c72Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx1Var, eVar, tx2Var, c72Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = nx1Var;
            this.a = eVar;
            this.b = tx2Var;
            this.c = c72Var;
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

    /* loaded from: classes5.dex */
    public class c implements yd2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ tx2 c;
        public final /* synthetic */ c72 d;

        public c(nx1 nx1Var, yd2.e eVar, String str, tx2 tx2Var, c72 c72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx1Var, eVar, str, tx2Var, c72Var};
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
                nx1.A(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nx1(@NonNull uv1 uv1Var) {
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

    public static void A(c72 c72Var, tx2 tx2Var, String str, boolean z) {
        SwanAppActivity w;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{c72Var, tx2Var, str, Boolean.valueOf(z)}) == null) && !z() && (w = s73.K().w()) != null && !w.isFinishing() && !w.isDestroyed()) {
            if (z) {
                i = 8;
            } else {
                i = 2;
            }
            z03.c(i, str);
            b72.V3(nl3.n());
            c72.b i2 = c72Var.i("redirectTo");
            int i3 = 0;
            i2.n(0, 0);
            c72.b k = i2.k("normal", tx2Var);
            if (!z) {
                i3 = c72Var.k() - 2;
            }
            k.m(i3);
            k.b();
            y03.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            z03.a(str, tx2Var);
        }
    }

    public static boolean z() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            t73 b0 = t73.b0();
            if (b0 == null || (w = b0.w()) == null || w.isFinishing() || w.isDestroyed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void B(yd2.e eVar, tx2 tx2Var, c72 c72Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, tx2Var, c72Var, str) == null) {
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
            yd2.q(eVar, new c(this, eVar, str, tx2Var, c72Var));
        }
    }

    public final void C(yd2.e eVar, tx2 tx2Var, c72 c72Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, tx2Var, c72Var, str) == null) {
            if (nl3.O()) {
                B(eVar, tx2Var, c72Var, str);
            } else {
                nl3.a0(new b(this, eVar, tx2Var, c72Var, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public tz1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
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
                t42.c("RedirectToApi", "url is null");
                return new tz1(202, "url is null");
            }
            gt2 U = gt2.U();
            c72 V = U.V();
            if (V == null) {
                t42.c("RedirectToApi", "manager is null");
                return new tz1(1001, "manager is null");
            }
            tx2 d = tx2.d(p, U.z());
            d.e = "2";
            d.f = uuid;
            he3.g(d);
            if (!nl3.b(U.s(), d, false)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                t42.c("RedirectToApi", str2);
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
                t42.c("RedirectToApi", "cb is empty");
                he3.i(d);
                return new tz1(202, "cb is empty");
            } else if (ga3.b().a(d)) {
                ga3.b().i("redirectTo", d);
                t42.c("RedirectToApi", "access to this page is prohibited");
                return new tz1(1003, "access to this page is prohibited");
            } else {
                nl3.a0(new a(this, U, optString3, d, uuid, V));
                return tz1.f();
            }
        }
        return (tz1) invokeL.objValue;
    }
}
