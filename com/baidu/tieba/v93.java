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
import com.baidu.tieba.gp2;
import com.baidu.tieba.hr2;
import com.baidu.tieba.l42;
import com.baidu.tieba.o53;
import com.baidu.tieba.t52;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class v93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l42 a;
        public final /* synthetic */ g82 b;
        public final /* synthetic */ rs1 c;
        public final /* synthetic */ hr2 d;
        public final /* synthetic */ gp2.g e;

        public a(l42 l42Var, g82 g82Var, rs1 rs1Var, hr2 hr2Var, gp2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l42Var, g82Var, rs1Var, hr2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l42Var;
            this.b = g82Var;
            this.c = rs1Var;
            this.d = hr2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                l42.g(0);
                v93.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements l42.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g82 a;
        public final /* synthetic */ rs1 b;
        public final /* synthetic */ hr2 c;
        public final /* synthetic */ gp2.g d;
        public final /* synthetic */ o53 e;

        public b(g82 g82Var, rs1 rs1Var, hr2 hr2Var, gp2.g gVar, o53 o53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g82Var, rs1Var, hr2Var, gVar, o53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g82Var;
            this.b = rs1Var;
            this.c = hr2Var;
            this.d = gVar;
            this.e = o53Var;
        }

        @Override // com.baidu.tieba.l42.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v93.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948195577, "Lcom/baidu/tieba/v93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948195577, "Lcom/baidu/tieba/v93;");
                return;
            }
        }
        a = vm1.a;
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
            b(dm3.b(e()));
        }
    }

    public static void a(g82 g82Var, rs1 rs1Var, hr2 hr2Var, gp2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, g82Var, rs1Var, hr2Var, gVar) == null) {
            HybridUbcFlow o = pz2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            xr2 V = xr2.V();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(V, hr2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = V.getActivity();
            if (activity != null && !activity.isFinishing()) {
                sb2.c().b(g82Var, rs1Var, hr2Var, gVar.b, gVar, false);
                g82Var.attachActivity(activity);
                rs1Var.attachActivity(activity);
                t52 W = V.W();
                if (W == null) {
                    return;
                }
                kw2 d2 = kw2.d(d, V.A());
                pc2.o(ek3.a(d2.c, d2.a, d2.b), rs1Var);
                g(W, d);
                dd3.E();
                xw2.e(rs1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    pz2.l(h);
                }
                dd3.F(true, hr2Var.U());
                ml3 U = activity.U();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + U);
                }
                if (U != null) {
                    U.F(1);
                }
                j63 K = j63.K();
                if (K.E() && TextUtils.equals(K.getAppId(), hr2Var.I())) {
                    K.q().J(true);
                }
                m62.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            xr2 V = xr2.V();
            SwanAppActivity activity = V.getActivity();
            if (activity != null && !activity.isFinishing()) {
                t52 W = V.W();
                if (W == null) {
                    k32.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    k32.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(W, str);
                    fm3.a().k();
                    ml3 U = activity.U();
                    if (U != null) {
                        U.F(1);
                    }
                    j63 K = j63.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    m62.f(true);
                    return;
                }
            }
            k32.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(xr2 xr2Var, hr2 hr2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, xr2Var, hr2Var, swanAppConfigData)) == null) {
            String b2 = xr2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (hr2Var.p0()) {
                    b2 = swanAppConfigData.g(hr2Var.i0());
                } else {
                    b2 = xr2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        hr2.a X;
        PMSAppInfo g0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            k63 q = j63.K().q();
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

    public static boolean f(t52 t52Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, t52Var)) == null) {
            if (t52Var.k() >= 1 && (t52Var.m() instanceof x52)) {
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

    public static void g(t52 t52Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, t52Var, str) != null) || t52Var == null) {
            return;
        }
        s52.Z3(null);
        xr2 V = xr2.V();
        t52.b i = t52Var.i("init");
        int i2 = t52.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", kw2.d(str, V.A()), true).a();
    }

    public static void h(t52 t52Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, t52Var, str) == null) {
            if (t52Var == null) {
                k32.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(t52Var)) {
                k32.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                s52.Z3(null);
                t52.b i = t52Var.i("init");
                int i2 = t52.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", kw2.d(str, str), true).a();
                cm3.c().o(t52Var.m());
            }
        }
    }

    public static void i(g82 g82Var, rs1 rs1Var, hr2 hr2Var, gp2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, g82Var, rs1Var, hr2Var, gVar) == null) {
            if (!j23.H() && l42.e() != 2) {
                if (j23.D()) {
                    v32.k().q(g82Var, rs1Var, hr2Var, gVar);
                    return;
                } else {
                    a(g82Var, rs1Var, hr2Var, gVar);
                    return;
                }
            }
            k32.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            l42 l42Var = new l42(rp2.c());
            o53.a aVar = new o53.a(j63.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f0187);
            aVar.v(R.string.obfuscated_res_0x7f0f0176);
            aVar.n(new sl3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0175, new a(l42Var, g82Var, rs1Var, hr2Var, gVar));
            o53 X = aVar.X();
            HybridUbcFlow o = pz2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            l42Var.f(new b(g82Var, rs1Var, hr2Var, gVar, X));
            l42Var.h();
        }
    }
}
