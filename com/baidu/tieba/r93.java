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
import com.baidu.tieba.cp2;
import com.baidu.tieba.dr2;
import com.baidu.tieba.h42;
import com.baidu.tieba.k53;
import com.baidu.tieba.p52;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class r93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h42 a;
        public final /* synthetic */ c82 b;
        public final /* synthetic */ ns1 c;
        public final /* synthetic */ dr2 d;
        public final /* synthetic */ cp2.g e;

        public a(h42 h42Var, c82 c82Var, ns1 ns1Var, dr2 dr2Var, cp2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h42Var, c82Var, ns1Var, dr2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h42Var;
            this.b = c82Var;
            this.c = ns1Var;
            this.d = dr2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                h42.g(0);
                r93.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements h42.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c82 a;
        public final /* synthetic */ ns1 b;
        public final /* synthetic */ dr2 c;
        public final /* synthetic */ cp2.g d;
        public final /* synthetic */ k53 e;

        public b(c82 c82Var, ns1 ns1Var, dr2 dr2Var, cp2.g gVar, k53 k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c82Var, ns1Var, dr2Var, gVar, k53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c82Var;
            this.b = ns1Var;
            this.c = dr2Var;
            this.d = gVar;
            this.e = k53Var;
        }

        @Override // com.baidu.tieba.h42.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r93.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948076413, "Lcom/baidu/tieba/r93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948076413, "Lcom/baidu/tieba/r93;");
                return;
            }
        }
        a = rm1.a;
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
            b(zl3.b(e()));
        }
    }

    public static void a(c82 c82Var, ns1 ns1Var, dr2 dr2Var, cp2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, c82Var, ns1Var, dr2Var, gVar) == null) {
            HybridUbcFlow o = lz2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            tr2 V = tr2.V();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(V, dr2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = V.getActivity();
            if (activity != null && !activity.isFinishing()) {
                ob2.c().b(c82Var, ns1Var, dr2Var, gVar.b, gVar, false);
                c82Var.attachActivity(activity);
                ns1Var.attachActivity(activity);
                p52 W = V.W();
                if (W == null) {
                    return;
                }
                gw2 d2 = gw2.d(d, V.A());
                lc2.o(ak3.a(d2.c, d2.a, d2.b), ns1Var);
                g(W, d);
                zc3.E();
                tw2.e(ns1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    lz2.l(h);
                }
                zc3.F(true, dr2Var.U());
                il3 U = activity.U();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + U);
                }
                if (U != null) {
                    U.F(1);
                }
                f63 K = f63.K();
                if (K.E() && TextUtils.equals(K.getAppId(), dr2Var.I())) {
                    K.q().J(true);
                }
                i62.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            tr2 V = tr2.V();
            SwanAppActivity activity = V.getActivity();
            if (activity != null && !activity.isFinishing()) {
                p52 W = V.W();
                if (W == null) {
                    g32.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    g32.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(W, str);
                    bm3.a().k();
                    il3 U = activity.U();
                    if (U != null) {
                        U.F(1);
                    }
                    f63 K = f63.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    i62.f(true);
                    return;
                }
            }
            g32.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(tr2 tr2Var, dr2 dr2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tr2Var, dr2Var, swanAppConfigData)) == null) {
            String b2 = tr2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (dr2Var.p0()) {
                    b2 = swanAppConfigData.g(dr2Var.i0());
                } else {
                    b2 = tr2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        dr2.a X;
        PMSAppInfo g0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            g63 q = f63.K().q();
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

    public static boolean f(p52 p52Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, p52Var)) == null) {
            if (p52Var.k() >= 1 && (p52Var.m() instanceof t52)) {
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

    public static void g(p52 p52Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, p52Var, str) != null) || p52Var == null) {
            return;
        }
        o52.Z3(null);
        tr2 V = tr2.V();
        p52.b i = p52Var.i("init");
        int i2 = p52.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", gw2.d(str, V.A()), true).a();
    }

    public static void h(p52 p52Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, p52Var, str) == null) {
            if (p52Var == null) {
                g32.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(p52Var)) {
                g32.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                o52.Z3(null);
                p52.b i = p52Var.i("init");
                int i2 = p52.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", gw2.d(str, str), true).a();
                yl3.c().o(p52Var.m());
            }
        }
    }

    public static void i(c82 c82Var, ns1 ns1Var, dr2 dr2Var, cp2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, c82Var, ns1Var, dr2Var, gVar) == null) {
            if (!f23.H() && h42.e() != 2) {
                if (f23.D()) {
                    r32.k().q(c82Var, ns1Var, dr2Var, gVar);
                    return;
                } else {
                    a(c82Var, ns1Var, dr2Var, gVar);
                    return;
                }
            }
            g32.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            h42 h42Var = new h42(np2.c());
            k53.a aVar = new k53.a(f63.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f017f);
            aVar.v(R.string.obfuscated_res_0x7f0f016e);
            aVar.n(new ol3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f016d, new a(h42Var, c82Var, ns1Var, dr2Var, gVar));
            k53 X = aVar.X();
            HybridUbcFlow o = lz2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            h42Var.f(new b(c82Var, ns1Var, dr2Var, gVar, X));
            h42Var.h();
        }
    }
}
