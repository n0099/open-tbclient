package com.baidu.tieba;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.dp2;
import com.baidu.tieba.er2;
import com.baidu.tieba.i42;
import com.baidu.tieba.l53;
import com.baidu.tieba.q52;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class s93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i42 a;
        public final /* synthetic */ d82 b;
        public final /* synthetic */ os1 c;
        public final /* synthetic */ er2 d;
        public final /* synthetic */ dp2.g e;

        public a(i42 i42Var, d82 d82Var, os1 os1Var, er2 er2Var, dp2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i42Var, d82Var, os1Var, er2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i42Var;
            this.b = d82Var;
            this.c = os1Var;
            this.d = er2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                i42.g(0);
                s93.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements i42.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d82 a;
        public final /* synthetic */ os1 b;
        public final /* synthetic */ er2 c;
        public final /* synthetic */ dp2.g d;
        public final /* synthetic */ l53 e;

        public b(d82 d82Var, os1 os1Var, er2 er2Var, dp2.g gVar, l53 l53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d82Var, os1Var, er2Var, gVar, l53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d82Var;
            this.b = os1Var;
            this.c = er2Var;
            this.d = gVar;
            this.e = l53Var;
        }

        @Override // com.baidu.tieba.i42.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s93.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948106204, "Lcom/baidu/tieba/s93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948106204, "Lcom/baidu/tieba/s93;");
                return;
            }
        }
        a = sm1.a;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b;
        }
        return (String) invokeV.objValue;
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            b(am3.b(e()));
        }
    }

    public static void a(d82 d82Var, os1 os1Var, er2 er2Var, dp2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, d82Var, os1Var, er2Var, gVar) == null) {
            HybridUbcFlow o = mz2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            ur2 V = ur2.V();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(V, er2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = V.getActivity();
            if (activity != null && !activity.isFinishing()) {
                pb2.c().b(d82Var, os1Var, er2Var, gVar.b, gVar, false);
                d82Var.attachActivity(activity);
                os1Var.attachActivity(activity);
                q52 W = V.W();
                if (W == null) {
                    return;
                }
                hw2 d2 = hw2.d(d, V.A());
                mc2.o(bk3.a(d2.c, d2.a, d2.b), os1Var);
                g(W, d);
                ad3.E();
                uw2.e(os1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    mz2.l(h);
                }
                ad3.F(true, er2Var.U());
                jl3 U = activity.U();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + U);
                }
                if (U != null) {
                    U.F(1);
                }
                g63 K = g63.K();
                if (K.E() && TextUtils.equals(K.getAppId(), er2Var.I())) {
                    K.q().J(true);
                }
                j62.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            ur2 V = ur2.V();
            SwanAppActivity activity = V.getActivity();
            if (activity != null && !activity.isFinishing()) {
                q52 W = V.W();
                if (W == null) {
                    h32.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    h32.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(W, str);
                    cm3.a().k();
                    jl3 U = activity.U();
                    if (U != null) {
                        U.F(1);
                    }
                    g63 K = g63.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    j62.f(true);
                    return;
                }
            }
            h32.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(ur2 ur2Var, er2 er2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ur2Var, er2Var, swanAppConfigData)) == null) {
            String b2 = ur2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (er2Var.p0()) {
                    b2 = swanAppConfigData.g(er2Var.i0());
                } else {
                    b2 = ur2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        er2.a X;
        PMSAppInfo g0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            h63 q = g63.K().q();
            if (q == null || (X = q.X()) == null || (g0 = X.g0()) == null) {
                return null;
            }
            String str = g0.webUrl;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static boolean f(q52 q52Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, q52Var)) == null) {
            if (q52Var.k() >= 1 && (q52Var.m() instanceof u52)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            b(str);
        }
    }

    public static void g(q52 q52Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, q52Var, str) != null) || q52Var == null) {
            return;
        }
        p52.Z3(null);
        ur2 V = ur2.V();
        q52.b i = q52Var.i("init");
        int i2 = q52.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", hw2.d(str, V.A()), true).a();
    }

    public static void h(q52 q52Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, q52Var, str) == null) {
            if (q52Var == null) {
                h32.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(q52Var)) {
                h32.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                p52.Z3(null);
                q52.b i = q52Var.i("init");
                int i2 = q52.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", hw2.d(str, str), true).a();
                zl3.c().o(q52Var.m());
            }
        }
    }

    public static void i(d82 d82Var, os1 os1Var, er2 er2Var, dp2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, d82Var, os1Var, er2Var, gVar) == null) {
            if (!g23.H() && i42.e() != 2) {
                if (g23.D()) {
                    s32.k().q(d82Var, os1Var, er2Var, gVar);
                    return;
                } else {
                    a(d82Var, os1Var, er2Var, gVar);
                    return;
                }
            }
            h32.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            i42 i42Var = new i42(op2.c());
            l53.a aVar = new l53.a(g63.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f0187);
            aVar.v(R.string.obfuscated_res_0x7f0f0176);
            aVar.n(new pl3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0175, new a(i42Var, d82Var, os1Var, er2Var, gVar));
            l53 X = aVar.X();
            HybridUbcFlow o = mz2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            i42Var.f(new b(d82Var, os1Var, er2Var, gVar, X));
            i42Var.h();
        }
    }
}
