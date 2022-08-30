package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.f72;
import com.baidu.tieba.j02;
import com.baidu.tieba.p43;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class uq1 extends rq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ar2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ j02 e;
        public final /* synthetic */ uq1 f;

        /* renamed from: com.baidu.tieba.uq1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0417a implements p43.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a13 a;
            public final /* synthetic */ a b;

            public C0417a(a aVar, a13 a13Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, a13Var};
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
                this.a = a13Var;
            }

            @Override // com.baidu.tieba.p43.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    gu2.d(this.b.d);
                    ay1.i("RedirectToApi", "check pages success");
                    this.b.a.o();
                    f72.e f = f72.f(this.b.a.getActivity(), k72.c(this.b.c.a));
                    String a = f.a.a();
                    a aVar = this.b;
                    j43.m(aVar.f, this.a, a, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.C(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.p43.e
            public void b(int i, tc3 tc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, tc3Var) == null) {
                    ay1.c("RedirectToApi", "check pages failed");
                    this.b.a.o();
                    a aVar = this.b;
                    j43.k(aVar.f, aVar.b);
                    o73.j(this.b.c, tc3Var);
                }
            }
        }

        public a(uq1 uq1Var, nm2 nm2Var, String str, ar2 ar2Var, String str2, j02 j02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uq1Var, nm2Var, str, ar2Var, str2, j02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = uq1Var;
            this.a = nm2Var;
            this.b = str;
            this.c = ar2Var;
            this.d = str2;
            this.e = j02Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    a13 M = a13.M();
                    if (M == null) {
                        this.f.d(this.b, new at1(1001, "swan app is null"));
                        o73.i(this.c);
                        return;
                    }
                    this.a.a();
                    p43.g(M, this.c, "", new C0417a(this, M), this.d);
                    return;
                }
                this.f.d(this.b, new at1(1001, "swan activity is null"));
                o73.i(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72.e a;
        public final /* synthetic */ ar2 b;
        public final /* synthetic */ j02 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ uq1 e;

        public b(uq1 uq1Var, f72.e eVar, ar2 ar2Var, j02 j02Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uq1Var, eVar, ar2Var, j02Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = uq1Var;
            this.a = eVar;
            this.b = ar2Var;
            this.c = j02Var;
            this.d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.B(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements f72.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ar2 c;
        public final /* synthetic */ j02 d;

        public c(uq1 uq1Var, f72.e eVar, String str, ar2 ar2Var, j02 j02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uq1Var, eVar, str, ar2Var, j02Var};
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
            this.c = ar2Var;
            this.d = j02Var;
        }

        @Override // com.baidu.tieba.f72.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gu2.e(this.a, this.b);
                j43.e(this.a.a, this.c, this.b);
                uq1.A(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uq1(@NonNull bp1 bp1Var) {
        super(bp1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bp1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((bp1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void A(j02 j02Var, ar2 ar2Var, String str, boolean z) {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{j02Var, ar2Var, str, Boolean.valueOf(z)}) == null) || z() || (w = z03.K().w()) == null || w.isFinishing() || w.isDestroyed()) {
            return;
        }
        gu2.c(z ? 8 : 2, str);
        i02.S3(ue3.n());
        j02.b i = j02Var.i("redirectTo");
        i.n(0, 0);
        j02.b k = i.k("normal", ar2Var);
        k.m(z ? 0 : j02Var.k() - 2);
        k.b();
        fu2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
        gu2.a(str, ar2Var);
    }

    public static boolean z() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            a13 b0 = a13.b0();
            return b0 == null || (w = b0.w()) == null || w.isFinishing() || w.isDestroyed();
        }
        return invokeV.booleanValue;
    }

    public final void B(f72.e eVar, ar2 ar2Var, j02 j02Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, ar2Var, j02Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = fu2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            f72.q(eVar, new c(this, eVar, str, ar2Var, j02Var));
        }
    }

    public final void C(f72.e eVar, ar2 ar2Var, j02 j02Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, ar2Var, j02Var, str) == null) {
            if (ue3.O()) {
                B(eVar, ar2Var, j02Var, str);
            } else {
                ue3.a0(new b(this, eVar, ar2Var, j02Var, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public at1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            gu2.b(uuid);
            Pair<at1, JSONObject> s = s(str);
            at1 at1Var = (at1) s.first;
            if (at1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = j43.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    ay1.c("RedirectToApi", "url is null");
                    return new at1(202, "url is null");
                }
                nm2 U = nm2.U();
                j02 V = U.V();
                if (V == null) {
                    ay1.c("RedirectToApi", "manager is null");
                    return new at1(1001, "manager is null");
                }
                ar2 d = ar2.d(p, U.z());
                d.e = "2";
                d.f = uuid;
                o73.g(d);
                if (!ue3.b(U.s(), d, false)) {
                    String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                    ay1.c("RedirectToApi", str2);
                    o73.i(d);
                    return new at1(202, str2);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && a13.M() != null) {
                    a13.M().L0(optString, d.d);
                }
                String optString2 = jSONObject.optString(FetchLog.START_TIME);
                if (!TextUtils.isEmpty(optString2)) {
                    HybridUbcFlow q = fu2.q("route", uuid);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                    ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                    q.F(ubcFlowEvent);
                }
                String optString3 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString3)) {
                    ay1.c("RedirectToApi", "cb is empty");
                    o73.i(d);
                    return new at1(202, "cb is empty");
                } else if (n33.b().a(d)) {
                    n33.b().i("redirectTo", d);
                    ay1.c("RedirectToApi", "access to this page is prohibited");
                    return new at1(1003, "access to this page is prohibited");
                } else {
                    ue3.a0(new a(this, U, optString3, d, uuid, V));
                    return at1.f();
                }
            }
            return at1Var;
        }
        return (at1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.dp1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }
}
