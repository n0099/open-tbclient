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
import com.baidu.tieba.ca3;
import com.baidu.tieba.ha2;
import com.baidu.tieba.ut2;
import com.baidu.tieba.vv2;
import com.baidu.tieba.z82;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class je3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z82 a;
        public final /* synthetic */ uc2 b;
        public final /* synthetic */ ex1 c;
        public final /* synthetic */ vv2 d;
        public final /* synthetic */ ut2.g e;

        public a(z82 z82Var, uc2 uc2Var, ex1 ex1Var, vv2 vv2Var, ut2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z82Var, uc2Var, ex1Var, vv2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z82Var;
            this.b = uc2Var;
            this.c = ex1Var;
            this.d = vv2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                z82.g(0);
                je3.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements z82.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc2 a;
        public final /* synthetic */ ex1 b;
        public final /* synthetic */ vv2 c;
        public final /* synthetic */ ut2.g d;
        public final /* synthetic */ ca3 e;

        public b(uc2 uc2Var, ex1 ex1Var, vv2 vv2Var, ut2.g gVar, ca3 ca3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc2Var, ex1Var, vv2Var, gVar, ca3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uc2Var;
            this.b = ex1Var;
            this.c = vv2Var;
            this.d = gVar;
            this.e = ca3Var;
        }

        @Override // com.baidu.tieba.z82.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                je3.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947880369, "Lcom/baidu/tieba/je3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947880369, "Lcom/baidu/tieba/je3;");
                return;
            }
        }
        a = ir1.a;
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
            b(rq3.b(e()));
        }
    }

    public static void a(uc2 uc2Var, ex1 ex1Var, vv2 vv2Var, ut2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, uc2Var, ex1Var, vv2Var, gVar) == null) {
            HybridUbcFlow o = d43.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            lw2 T2 = lw2.T();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(T2, vv2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                gg2.c().b(uc2Var, ex1Var, vv2Var, gVar.b, gVar, false);
                uc2Var.attachActivity(activity);
                ex1Var.attachActivity(activity);
                ha2 U = T2.U();
                if (U == null) {
                    return;
                }
                y03 d2 = y03.d(d, T2.z());
                dh2.o(so3.a(d2.c, d2.a, d2.b), ex1Var);
                g(U, d);
                rh3.E();
                l13.e(ex1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    d43.l(h);
                }
                rh3.F(true, vv2Var.T());
                aq3 U2 = activity.U();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + U2);
                }
                if (U2 != null) {
                    U2.F(1);
                }
                xa3 K = xa3.K();
                if (K.E() && TextUtils.equals(K.getAppId(), vv2Var.H())) {
                    K.q().J(true);
                }
                ab2.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            lw2 T2 = lw2.T();
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                ha2 U = T2.U();
                if (U == null) {
                    y72.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    y72.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(U, str);
                    tq3.a().k();
                    aq3 U2 = activity.U();
                    if (U2 != null) {
                        U2.F(1);
                    }
                    xa3 K = xa3.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    ab2.f(true);
                    return;
                }
            }
            y72.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(lw2 lw2Var, vv2 vv2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, lw2Var, vv2Var, swanAppConfigData)) == null) {
            String b2 = lw2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (vv2Var.o0()) {
                    b2 = swanAppConfigData.g(vv2Var.h0());
                } else {
                    b2 = lw2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        vv2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            ya3 q = xa3.K().q();
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

    public static boolean f(ha2 ha2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, ha2Var)) == null) {
            if (ha2Var.k() >= 1 && (ha2Var.m() instanceof la2)) {
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

    public static void g(ha2 ha2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, ha2Var, str) != null) || ha2Var == null) {
            return;
        }
        ga2.U3(null);
        lw2 T2 = lw2.T();
        ha2.b i = ha2Var.i("init");
        int i2 = ha2.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", y03.d(str, T2.z()), true).a();
    }

    public static void h(ha2 ha2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, ha2Var, str) == null) {
            if (ha2Var == null) {
                y72.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(ha2Var)) {
                y72.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                ga2.U3(null);
                ha2.b i = ha2Var.i("init");
                int i2 = ha2.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", y03.d(str, str), true).a();
                qq3.c().o(ha2Var.m());
            }
        }
    }

    public static void i(uc2 uc2Var, ex1 ex1Var, vv2 vv2Var, ut2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, uc2Var, ex1Var, vv2Var, gVar) == null) {
            if (!x63.H() && z82.e() != 2) {
                if (x63.D()) {
                    j82.k().q(uc2Var, ex1Var, vv2Var, gVar);
                    return;
                } else {
                    a(uc2Var, ex1Var, vv2Var, gVar);
                    return;
                }
            }
            y72.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            z82 z82Var = new z82(fu2.c());
            ca3.a aVar = new ca3.a(xa3.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f017c);
            aVar.v(R.string.obfuscated_res_0x7f0f016b);
            aVar.n(new gq3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f016a, new a(z82Var, uc2Var, ex1Var, vv2Var, gVar));
            ca3 X = aVar.X();
            HybridUbcFlow o = d43.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            z82Var.f(new b(uc2Var, ex1Var, vv2Var, gVar, X));
            z82Var.h();
        }
    }
}
