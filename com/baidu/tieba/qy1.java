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
public class qy1 extends ny1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.zw1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
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
        public final /* synthetic */ qy1 f;

        /* renamed from: com.baidu.tieba.qy1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0410a implements lc3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ w83 a;
            public final /* synthetic */ a b;

            public C0410a(a aVar, w83 w83Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, w83Var};
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
                this.a = w83Var;
            }

            @Override // com.baidu.tieba.lc3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    c23.d(this.b.d);
                    w52.i("RedirectToApi", "check pages success");
                    this.b.a.o();
                    bf2.e f = bf2.f(this.b.a.getActivity(), gf2.c(this.b.c.a));
                    String a = f.a.a();
                    a aVar = this.b;
                    fc3.m(aVar.f, this.a, a, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.C(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.lc3.e
            public void b(int i, pk3 pk3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, pk3Var) == null) {
                    w52.c("RedirectToApi", "check pages failed");
                    this.b.a.o();
                    a aVar = this.b;
                    fc3.k(aVar.f, aVar.b);
                    kf3.j(this.b.c, pk3Var);
                }
            }
        }

        public a(qy1 qy1Var, ju2 ju2Var, String str, wy2 wy2Var, String str2, f82 f82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qy1Var, ju2Var, str, wy2Var, str2, f82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = qy1Var;
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
                    lc3.g(M, this.c, "", new C0410a(this, M), this.d);
                    return;
                }
                this.f.d(this.b, new w02(1001, "swan activity is null"));
                kf3.i(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bf2.e a;
        public final /* synthetic */ wy2 b;
        public final /* synthetic */ f82 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ qy1 e;

        public b(qy1 qy1Var, bf2.e eVar, wy2 wy2Var, f82 f82Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qy1Var, eVar, wy2Var, f82Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = qy1Var;
            this.a = eVar;
            this.b = wy2Var;
            this.c = f82Var;
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
    public class c implements bf2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bf2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ wy2 c;
        public final /* synthetic */ f82 d;

        public c(qy1 qy1Var, bf2.e eVar, String str, wy2 wy2Var, f82 f82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qy1Var, eVar, str, wy2Var, f82Var};
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
                qy1.A(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qy1(@NonNull xw1 xw1Var) {
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

    public static void A(f82 f82Var, wy2 wy2Var, String str, boolean z) {
        SwanAppActivity w;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{f82Var, wy2Var, str, Boolean.valueOf(z)}) == null) && !z() && (w = v83.K().w()) != null && !w.isFinishing() && !w.isDestroyed()) {
            if (z) {
                i = 8;
            } else {
                i = 2;
            }
            c23.c(i, str);
            e82.S3(qm3.n());
            f82.b i2 = f82Var.i("redirectTo");
            int i3 = 0;
            i2.n(0, 0);
            f82.b k = i2.k("normal", wy2Var);
            if (!z) {
                i3 = f82Var.k() - 2;
            }
            k.m(i3);
            k.b();
            b23.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            c23.a(str, wy2Var);
        }
    }

    public static boolean z() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            w83 b0 = w83.b0();
            if (b0 == null || (w = b0.w()) == null || w.isFinishing() || w.isDestroyed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void B(bf2.e eVar, wy2 wy2Var, f82 f82Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, wy2Var, f82Var, str) == null) {
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
            bf2.q(eVar, new c(this, eVar, str, wy2Var, f82Var));
        }
    }

    public final void C(bf2.e eVar, wy2 wy2Var, f82 f82Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, wy2Var, f82Var, str) == null) {
            if (qm3.O()) {
                B(eVar, wy2Var, f82Var, str);
            } else {
                qm3.a0(new b(this, eVar, wy2Var, f82Var, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public w02 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
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
                w52.c("RedirectToApi", "url is null");
                return new w02(202, "url is null");
            }
            ju2 U = ju2.U();
            f82 V = U.V();
            if (V == null) {
                w52.c("RedirectToApi", "manager is null");
                return new w02(1001, "manager is null");
            }
            wy2 d = wy2.d(p, U.z());
            d.e = "2";
            d.f = uuid;
            kf3.g(d);
            if (!qm3.b(U.s(), d, false)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                w52.c("RedirectToApi", str2);
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
                w52.c("RedirectToApi", "cb is empty");
                kf3.i(d);
                return new w02(202, "cb is empty");
            } else if (jb3.b().a(d)) {
                jb3.b().i("redirectTo", d);
                w52.c("RedirectToApi", "access to this page is prohibited");
                return new w02(1003, "access to this page is prohibited");
            } else {
                qm3.a0(new a(this, U, optString3, d, uuid, V));
                return w02.f();
            }
        }
        return (w02) invokeL.objValue;
    }
}
