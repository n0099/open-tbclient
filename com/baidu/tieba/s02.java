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
import com.baidu.tieba.dh2;
import com.baidu.tieba.ha2;
import com.baidu.tieba.ne3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class s02 extends p02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.bz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lw2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ y03 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ha2 e;
        public final /* synthetic */ s02 f;

        /* renamed from: com.baidu.tieba.s02$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0469a implements ne3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ya3 a;
            public final /* synthetic */ a b;

            public C0469a(a aVar, ya3 ya3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ya3Var};
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
                this.a = ya3Var;
            }

            @Override // com.baidu.tieba.ne3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    e43.d(this.b.d);
                    y72.i("RedirectToApi", "check pages success");
                    this.b.a.o();
                    dh2.e f = dh2.f(this.b.a.getActivity(), ih2.c(this.b.c.a));
                    String a = f.a.a();
                    a aVar = this.b;
                    he3.m(aVar.f, this.a, a, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.C(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.ne3.e
            public void b(int i, rm3 rm3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, rm3Var) == null) {
                    y72.c("RedirectToApi", "check pages failed");
                    this.b.a.o();
                    a aVar = this.b;
                    he3.k(aVar.f, aVar.b);
                    mh3.j(this.b.c, rm3Var);
                }
            }
        }

        public a(s02 s02Var, lw2 lw2Var, String str, y03 y03Var, String str2, ha2 ha2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s02Var, lw2Var, str, y03Var, str2, ha2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = s02Var;
            this.a = lw2Var;
            this.b = str;
            this.c = y03Var;
            this.d = str2;
            this.e = ha2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    ya3 M = ya3.M();
                    if (M == null) {
                        this.f.d(this.b, new y22(1001, "swan app is null"));
                        mh3.i(this.c);
                        return;
                    }
                    this.a.a();
                    ne3.g(M, this.c, "", new C0469a(this, M), this.d);
                    return;
                }
                this.f.d(this.b, new y22(1001, "swan activity is null"));
                mh3.i(this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh2.e a;
        public final /* synthetic */ y03 b;
        public final /* synthetic */ ha2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ s02 e;

        public b(s02 s02Var, dh2.e eVar, y03 y03Var, ha2 ha2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s02Var, eVar, y03Var, ha2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = s02Var;
            this.a = eVar;
            this.b = y03Var;
            this.c = ha2Var;
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
    public class c implements dh2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ y03 c;
        public final /* synthetic */ ha2 d;

        public c(s02 s02Var, dh2.e eVar, String str, y03 y03Var, ha2 ha2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s02Var, eVar, str, y03Var, ha2Var};
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
            this.c = y03Var;
            this.d = ha2Var;
        }

        @Override // com.baidu.tieba.dh2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e43.e(this.a, this.b);
                he3.e(this.a.a, this.c, this.b);
                s02.A(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s02(@NonNull zy1 zy1Var) {
        super(zy1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zy1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zy1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void A(ha2 ha2Var, y03 y03Var, String str, boolean z) {
        SwanAppActivity w;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{ha2Var, y03Var, str, Boolean.valueOf(z)}) == null) && !z() && (w = xa3.K().w()) != null && !w.isFinishing() && !w.isDestroyed()) {
            if (z) {
                i = 8;
            } else {
                i = 2;
            }
            e43.c(i, str);
            ga2.U3(so3.n());
            ha2.b i2 = ha2Var.i("redirectTo");
            int i3 = 0;
            i2.n(0, 0);
            ha2.b k = i2.k("normal", y03Var);
            if (!z) {
                i3 = ha2Var.k() - 2;
            }
            k.m(i3);
            k.b();
            d43.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            e43.a(str, y03Var);
        }
    }

    public static boolean z() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            ya3 b0 = ya3.b0();
            if (b0 == null || (w = b0.w()) == null || w.isFinishing() || w.isDestroyed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void B(dh2.e eVar, y03 y03Var, ha2 ha2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, y03Var, ha2Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = d43.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            dh2.q(eVar, new c(this, eVar, str, y03Var, ha2Var));
        }
    }

    public final void C(dh2.e eVar, y03 y03Var, ha2 ha2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, y03Var, ha2Var, str) == null) {
            if (so3.O()) {
                B(eVar, y03Var, ha2Var, str);
            } else {
                so3.a0(new b(this, eVar, y03Var, ha2Var, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public y22 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            e43.b(uuid);
            Pair<y22, JSONObject> s = s(str);
            y22 y22Var = (y22) s.first;
            if (!y22Var.isSuccess()) {
                return y22Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = he3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                y72.c("RedirectToApi", "url is null");
                return new y22(202, "url is null");
            }
            lw2 T2 = lw2.T();
            ha2 U = T2.U();
            if (U == null) {
                y72.c("RedirectToApi", "manager is null");
                return new y22(1001, "manager is null");
            }
            y03 d = y03.d(p, T2.z());
            d.e = "2";
            d.f = uuid;
            mh3.g(d);
            if (!so3.b(T2.s(), d, false)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                y72.c("RedirectToApi", str2);
                mh3.i(d);
                return new y22(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && ya3.M() != null) {
                ya3.M().L0(optString, d.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = d43.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                y72.c("RedirectToApi", "cb is empty");
                mh3.i(d);
                return new y22(202, "cb is empty");
            } else if (ld3.b().a(d)) {
                ld3.b().i("redirectTo", d);
                y72.c("RedirectToApi", "access to this page is prohibited");
                return new y22(1003, "access to this page is prohibited");
            } else {
                so3.a0(new a(this, T2, optString3, d, uuid, U));
                return y22.f();
            }
        }
        return (y22) invokeL.objValue;
    }
}
