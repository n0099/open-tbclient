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
import com.baidu.tieba.ka2;
import com.baidu.tieba.o32;
import com.baidu.tieba.u73;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class zt1 extends wt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.is1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sp2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ fu2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ o32 e;
        public final /* synthetic */ zt1 f;

        /* renamed from: com.baidu.tieba.zt1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0488a implements u73.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f43 a;
            public final /* synthetic */ a b;

            public C0488a(a aVar, f43 f43Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, f43Var};
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
                this.a = f43Var;
            }

            @Override // com.baidu.tieba.u73.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    lx2.d(this.b.d);
                    f12.i("RedirectToApi", "check pages success");
                    this.b.a.o();
                    ka2.e f = ka2.f(this.b.a.getActivity(), pa2.c(this.b.c.a));
                    String a = f.a.a();
                    a aVar = this.b;
                    o73.m(aVar.f, this.a, a, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.C(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.u73.e
            public void b(int i, yf3 yf3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, yf3Var) == null) {
                    f12.c("RedirectToApi", "check pages failed");
                    this.b.a.o();
                    a aVar = this.b;
                    o73.k(aVar.f, aVar.b);
                    ta3.j(this.b.c, yf3Var);
                }
            }
        }

        public a(zt1 zt1Var, sp2 sp2Var, String str, fu2 fu2Var, String str2, o32 o32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt1Var, sp2Var, str, fu2Var, str2, o32Var};
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
            this.a = sp2Var;
            this.b = str;
            this.c = fu2Var;
            this.d = str2;
            this.e = o32Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    f43 M = f43.M();
                    if (M == null) {
                        this.f.d(this.b, new fw1(1001, "swan app is null"));
                        ta3.i(this.c);
                        return;
                    }
                    this.a.a();
                    u73.g(M, this.c, "", new C0488a(this, M), this.d);
                    return;
                }
                this.f.d(this.b, new fw1(1001, "swan activity is null"));
                ta3.i(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ka2.e a;
        public final /* synthetic */ fu2 b;
        public final /* synthetic */ o32 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ zt1 e;

        public b(zt1 zt1Var, ka2.e eVar, fu2 fu2Var, o32 o32Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt1Var, eVar, fu2Var, o32Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zt1Var;
            this.a = eVar;
            this.b = fu2Var;
            this.c = o32Var;
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
    public class c implements ka2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ka2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ fu2 c;
        public final /* synthetic */ o32 d;

        public c(zt1 zt1Var, ka2.e eVar, String str, fu2 fu2Var, o32 o32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt1Var, eVar, str, fu2Var, o32Var};
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
            this.c = fu2Var;
            this.d = o32Var;
        }

        @Override // com.baidu.tieba.ka2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lx2.e(this.a, this.b);
                o73.e(this.a.a, this.c, this.b);
                zt1.A(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zt1(@NonNull gs1 gs1Var) {
        super(gs1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gs1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((gs1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void A(o32 o32Var, fu2 fu2Var, String str, boolean z) {
        SwanAppActivity w;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{o32Var, fu2Var, str, Boolean.valueOf(z)}) == null) && !z() && (w = e43.K().w()) != null && !w.isFinishing() && !w.isDestroyed()) {
            if (z) {
                i = 8;
            } else {
                i = 2;
            }
            lx2.c(i, str);
            n32.S3(zh3.n());
            o32.b i2 = o32Var.i("redirectTo");
            int i3 = 0;
            i2.n(0, 0);
            o32.b k = i2.k("normal", fu2Var);
            if (!z) {
                i3 = o32Var.k() - 2;
            }
            k.m(i3);
            k.b();
            kx2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            lx2.a(str, fu2Var);
        }
    }

    public static boolean z() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            f43 b0 = f43.b0();
            if (b0 == null || (w = b0.w()) == null || w.isFinishing() || w.isDestroyed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void B(ka2.e eVar, fu2 fu2Var, o32 o32Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, fu2Var, o32Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = kx2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            ka2.q(eVar, new c(this, eVar, str, fu2Var, o32Var));
        }
    }

    public final void C(ka2.e eVar, fu2 fu2Var, o32 o32Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, fu2Var, o32Var, str) == null) {
            if (zh3.O()) {
                B(eVar, fu2Var, o32Var, str);
            } else {
                zh3.a0(new b(this, eVar, fu2Var, o32Var, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public fw1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            lx2.b(uuid);
            Pair<fw1, JSONObject> s = s(str);
            fw1 fw1Var = (fw1) s.first;
            if (!fw1Var.isSuccess()) {
                return fw1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = o73.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                f12.c("RedirectToApi", "url is null");
                return new fw1(202, "url is null");
            }
            sp2 U = sp2.U();
            o32 V = U.V();
            if (V == null) {
                f12.c("RedirectToApi", "manager is null");
                return new fw1(1001, "manager is null");
            }
            fu2 d = fu2.d(p, U.z());
            d.e = "2";
            d.f = uuid;
            ta3.g(d);
            if (!zh3.b(U.s(), d, false)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                f12.c("RedirectToApi", str2);
                ta3.i(d);
                return new fw1(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && f43.M() != null) {
                f43.M().L0(optString, d.d);
            }
            String optString2 = jSONObject.optString(FetchLog.START_TIME);
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = kx2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                f12.c("RedirectToApi", "cb is empty");
                ta3.i(d);
                return new fw1(202, "cb is empty");
            } else if (s63.b().a(d)) {
                s63.b().i("redirectTo", d);
                f12.c("RedirectToApi", "access to this page is prohibited");
                return new fw1(1003, "access to this page is prohibited");
            } else {
                zh3.a0(new a(this, U, optString3, d, uuid, V));
                return fw1.f();
            }
        }
        return (fw1) invokeL.objValue;
    }
}
