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
import com.baidu.tieba.cs2;
import com.baidu.tieba.du2;
import com.baidu.tieba.h72;
import com.baidu.tieba.k83;
import com.baidu.tieba.p82;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h72 a;
        public final /* synthetic */ cb2 b;
        public final /* synthetic */ mv1 c;
        public final /* synthetic */ du2 d;
        public final /* synthetic */ cs2.g e;

        public a(h72 h72Var, cb2 cb2Var, mv1 mv1Var, du2 du2Var, cs2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h72Var, cb2Var, mv1Var, du2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h72Var;
            this.b = cb2Var;
            this.c = mv1Var;
            this.d = du2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                h72.g(0);
                rc3.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements h72.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cb2 a;
        public final /* synthetic */ mv1 b;
        public final /* synthetic */ du2 c;
        public final /* synthetic */ cs2.g d;
        public final /* synthetic */ k83 e;

        public b(cb2 cb2Var, mv1 mv1Var, du2 du2Var, cs2.g gVar, k83 k83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb2Var, mv1Var, du2Var, gVar, k83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cb2Var;
            this.b = mv1Var;
            this.c = du2Var;
            this.d = gVar;
            this.e = k83Var;
        }

        @Override // com.baidu.tieba.h72.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rc3.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948116775, "Lcom/baidu/tieba/rc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948116775, "Lcom/baidu/tieba/rc3;");
                return;
            }
        }
        a = qp1.a;
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
            b(zo3.b(e()));
        }
    }

    public static void a(cb2 cb2Var, mv1 mv1Var, du2 du2Var, cs2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, cb2Var, mv1Var, du2Var, gVar) == null) {
            HybridUbcFlow o = l23.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            tu2 U = tu2.U();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(U, du2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                oe2.c().b(cb2Var, mv1Var, du2Var, gVar.b, gVar, false);
                cb2Var.attachActivity(activity);
                mv1Var.attachActivity(activity);
                p82 V = U.V();
                if (V == null) {
                    return;
                }
                gz2 d2 = gz2.d(d, U.z());
                lf2.o(an3.a(d2.c, d2.a, d2.b), mv1Var);
                g(V, d);
                zf3.E();
                tz2.e(mv1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    l23.l(h);
                }
                zf3.F(true, du2Var.T());
                io3 V2 = activity.V();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + V2);
                }
                if (V2 != null) {
                    V2.F(1);
                }
                f93 K = f93.K();
                if (K.E() && TextUtils.equals(K.getAppId(), du2Var.H())) {
                    K.q().J(true);
                }
                i92.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            tu2 U = tu2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                p82 V = U.V();
                if (V == null) {
                    g62.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    g62.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    bp3.a().k();
                    io3 V2 = activity.V();
                    if (V2 != null) {
                        V2.F(1);
                    }
                    f93 K = f93.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    i92.f(true);
                    return;
                }
            }
            g62.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(tu2 tu2Var, du2 du2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tu2Var, du2Var, swanAppConfigData)) == null) {
            String b2 = tu2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (du2Var.o0()) {
                    b2 = swanAppConfigData.g(du2Var.h0());
                } else {
                    b2 = tu2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        du2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            g93 q = f93.K().q();
            if (q == null || (W = q.W()) == null || (f0 = W.f0()) == null) {
                return null;
            }
            String str = f0.webUrl;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static boolean f(p82 p82Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, p82Var)) == null) {
            if (p82Var.k() >= 1 && (p82Var.m() instanceof t82)) {
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

    public static void g(p82 p82Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, p82Var, str) != null) || p82Var == null) {
            return;
        }
        o82.V3(null);
        tu2 U = tu2.U();
        p82.b i = p82Var.i("init");
        int i2 = p82.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", gz2.d(str, U.z()), true).a();
    }

    public static void h(p82 p82Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, p82Var, str) == null) {
            if (p82Var == null) {
                g62.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(p82Var)) {
                g62.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                o82.V3(null);
                p82.b i = p82Var.i("init");
                int i2 = p82.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", gz2.d(str, str), true).a();
                yo3.c().o(p82Var.m());
            }
        }
    }

    public static void i(cb2 cb2Var, mv1 mv1Var, du2 du2Var, cs2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, cb2Var, mv1Var, du2Var, gVar) == null) {
            if (!f53.H() && h72.e() != 2) {
                if (f53.D()) {
                    r62.k().q(cb2Var, mv1Var, du2Var, gVar);
                    return;
                } else {
                    a(cb2Var, mv1Var, du2Var, gVar);
                    return;
                }
            }
            g62.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            h72 h72Var = new h72(ns2.c());
            k83.a aVar = new k83.a(f93.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f017a);
            aVar.v(R.string.obfuscated_res_0x7f0f0169);
            aVar.n(new oo3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0168, new a(h72Var, cb2Var, mv1Var, du2Var, gVar));
            k83 X = aVar.X();
            HybridUbcFlow o = l23.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            h72Var.f(new b(cb2Var, mv1Var, du2Var, gVar, X));
            h72Var.h();
        }
    }
}
