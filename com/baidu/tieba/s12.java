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
import com.baidu.tieba.di2;
import com.baidu.tieba.hb2;
import com.baidu.tieba.nf3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class s12 extends p12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.b02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lx2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ y13 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ hb2 e;
        public final /* synthetic */ s12 f;

        /* renamed from: com.baidu.tieba.s12$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0450a implements nf3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ yb3 a;
            public final /* synthetic */ a b;

            public C0450a(a aVar, yb3 yb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, yb3Var};
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
                this.a = yb3Var;
            }

            @Override // com.baidu.tieba.nf3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    e53.d(this.b.d);
                    y82.i("RedirectToApi", "check pages success");
                    this.b.a.o();
                    di2.e f = di2.f(this.b.a.getActivity(), ii2.c(this.b.c.a));
                    String a = f.a.a();
                    a aVar = this.b;
                    hf3.m(aVar.f, this.a, a, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.C(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.nf3.e
            public void b(int i, rn3 rn3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, rn3Var) == null) {
                    y82.c("RedirectToApi", "check pages failed");
                    this.b.a.o();
                    a aVar = this.b;
                    hf3.k(aVar.f, aVar.b);
                    mi3.j(this.b.c, rn3Var);
                }
            }
        }

        public a(s12 s12Var, lx2 lx2Var, String str, y13 y13Var, String str2, hb2 hb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s12Var, lx2Var, str, y13Var, str2, hb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = s12Var;
            this.a = lx2Var;
            this.b = str;
            this.c = y13Var;
            this.d = str2;
            this.e = hb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    yb3 M = yb3.M();
                    if (M == null) {
                        this.f.d(this.b, new y32(1001, "swan app is null"));
                        mi3.i(this.c);
                        return;
                    }
                    this.a.a();
                    nf3.g(M, this.c, "", new C0450a(this, M), this.d);
                    return;
                }
                this.f.d(this.b, new y32(1001, "swan activity is null"));
                mi3.i(this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ di2.e a;
        public final /* synthetic */ y13 b;
        public final /* synthetic */ hb2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ s12 e;

        public b(s12 s12Var, di2.e eVar, y13 y13Var, hb2 hb2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s12Var, eVar, y13Var, hb2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = s12Var;
            this.a = eVar;
            this.b = y13Var;
            this.c = hb2Var;
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
    public class c implements di2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ di2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ y13 c;
        public final /* synthetic */ hb2 d;

        public c(s12 s12Var, di2.e eVar, String str, y13 y13Var, hb2 hb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s12Var, eVar, str, y13Var, hb2Var};
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
            this.c = y13Var;
            this.d = hb2Var;
        }

        @Override // com.baidu.tieba.di2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e53.e(this.a, this.b);
                hf3.e(this.a.a, this.c, this.b);
                s12.A(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s12(@NonNull zz1 zz1Var) {
        super(zz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void A(hb2 hb2Var, y13 y13Var, String str, boolean z) {
        SwanAppActivity w;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{hb2Var, y13Var, str, Boolean.valueOf(z)}) == null) && !z() && (w = xb3.K().w()) != null && !w.isFinishing() && !w.isDestroyed()) {
            if (z) {
                i = 8;
            } else {
                i = 2;
            }
            e53.c(i, str);
            gb2.U3(sp3.n());
            hb2.b i2 = hb2Var.i("redirectTo");
            int i3 = 0;
            i2.n(0, 0);
            hb2.b k = i2.k("normal", y13Var);
            if (!z) {
                i3 = hb2Var.k() - 2;
            }
            k.m(i3);
            k.b();
            d53.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            e53.a(str, y13Var);
        }
    }

    public static boolean z() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            yb3 b0 = yb3.b0();
            if (b0 == null || (w = b0.w()) == null || w.isFinishing() || w.isDestroyed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void B(di2.e eVar, y13 y13Var, hb2 hb2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, y13Var, hb2Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = d53.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            di2.q(eVar, new c(this, eVar, str, y13Var, hb2Var));
        }
    }

    public final void C(di2.e eVar, y13 y13Var, hb2 hb2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, y13Var, hb2Var, str) == null) {
            if (sp3.O()) {
                B(eVar, y13Var, hb2Var, str);
            } else {
                sp3.a0(new b(this, eVar, y13Var, hb2Var, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public y32 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            e53.b(uuid);
            Pair<y32, JSONObject> s = s(str);
            y32 y32Var = (y32) s.first;
            if (!y32Var.isSuccess()) {
                return y32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = hf3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                y82.c("RedirectToApi", "url is null");
                return new y32(202, "url is null");
            }
            lx2 T2 = lx2.T();
            hb2 U = T2.U();
            if (U == null) {
                y82.c("RedirectToApi", "manager is null");
                return new y32(1001, "manager is null");
            }
            y13 d = y13.d(p, T2.z());
            d.e = "2";
            d.f = uuid;
            mi3.g(d);
            if (!sp3.b(T2.s(), d, false)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                y82.c("RedirectToApi", str2);
                mi3.i(d);
                return new y32(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && yb3.M() != null) {
                yb3.M().L0(optString, d.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = d53.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                y82.c("RedirectToApi", "cb is empty");
                mi3.i(d);
                return new y32(202, "cb is empty");
            } else if (le3.b().a(d)) {
                le3.b().i("redirectTo", d);
                y82.c("RedirectToApi", "access to this page is prohibited");
                return new y32(1003, "access to this page is prohibited");
            } else {
                sp3.a0(new a(this, T2, optString3, d, uuid, U));
                return y32.f();
            }
        }
        return (y32) invokeL.objValue;
    }
}
