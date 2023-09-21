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
import com.baidu.tieba.cu2;
import com.baidu.tieba.dw2;
import com.baidu.tieba.h92;
import com.baidu.tieba.ka3;
import com.baidu.tieba.pa2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class re3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h92 a;
        public final /* synthetic */ cd2 b;
        public final /* synthetic */ mx1 c;
        public final /* synthetic */ dw2 d;
        public final /* synthetic */ cu2.g e;

        public a(h92 h92Var, cd2 cd2Var, mx1 mx1Var, dw2 dw2Var, cu2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var, cd2Var, mx1Var, dw2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h92Var;
            this.b = cd2Var;
            this.c = mx1Var;
            this.d = dw2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                h92.g(0);
                re3.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements h92.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cd2 a;
        public final /* synthetic */ mx1 b;
        public final /* synthetic */ dw2 c;
        public final /* synthetic */ cu2.g d;
        public final /* synthetic */ ka3 e;

        public b(cd2 cd2Var, mx1 mx1Var, dw2 dw2Var, cu2.g gVar, ka3 ka3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cd2Var, mx1Var, dw2Var, gVar, ka3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cd2Var;
            this.b = mx1Var;
            this.c = dw2Var;
            this.d = gVar;
            this.e = ka3Var;
        }

        @Override // com.baidu.tieba.h92.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                re3.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948118697, "Lcom/baidu/tieba/re3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948118697, "Lcom/baidu/tieba/re3;");
                return;
            }
        }
        a = qr1.a;
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
            b(zq3.b(e()));
        }
    }

    public static void a(cd2 cd2Var, mx1 mx1Var, dw2 dw2Var, cu2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, cd2Var, mx1Var, dw2Var, gVar) == null) {
            HybridUbcFlow o = l43.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            tw2 T2 = tw2.T();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(T2, dw2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                og2.c().b(cd2Var, mx1Var, dw2Var, gVar.b, gVar, false);
                cd2Var.attachActivity(activity);
                mx1Var.attachActivity(activity);
                pa2 U = T2.U();
                if (U == null) {
                    return;
                }
                g13 d2 = g13.d(d, T2.z());
                lh2.o(ap3.a(d2.c, d2.a, d2.b), mx1Var);
                g(U, d);
                zh3.E();
                t13.e(mx1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    l43.l(h);
                }
                zh3.F(true, dw2Var.T());
                iq3 T3 = activity.T();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + T3);
                }
                if (T3 != null) {
                    T3.F(1);
                }
                fb3 K = fb3.K();
                if (K.E() && TextUtils.equals(K.getAppId(), dw2Var.H())) {
                    K.q().J(true);
                }
                ib2.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            tw2 T2 = tw2.T();
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                pa2 U = T2.U();
                if (U == null) {
                    g82.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    g82.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(U, str);
                    br3.a().k();
                    iq3 T3 = activity.T();
                    if (T3 != null) {
                        T3.F(1);
                    }
                    fb3 K = fb3.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    ib2.f(true);
                    return;
                }
            }
            g82.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(tw2 tw2Var, dw2 dw2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tw2Var, dw2Var, swanAppConfigData)) == null) {
            String b2 = tw2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (dw2Var.o0()) {
                    b2 = swanAppConfigData.g(dw2Var.h0());
                } else {
                    b2 = tw2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        dw2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            gb3 q = fb3.K().q();
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

    public static boolean f(pa2 pa2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, pa2Var)) == null) {
            if (pa2Var.k() >= 1 && (pa2Var.m() instanceof ta2)) {
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

    public static void g(pa2 pa2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, pa2Var, str) != null) || pa2Var == null) {
            return;
        }
        oa2.U3(null);
        tw2 T2 = tw2.T();
        pa2.b i = pa2Var.i("init");
        int i2 = pa2.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", g13.d(str, T2.z()), true).a();
    }

    public static void h(pa2 pa2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, pa2Var, str) == null) {
            if (pa2Var == null) {
                g82.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(pa2Var)) {
                g82.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                oa2.U3(null);
                pa2.b i = pa2Var.i("init");
                int i2 = pa2.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", g13.d(str, str), true).a();
                yq3.c().o(pa2Var.m());
            }
        }
    }

    public static void i(cd2 cd2Var, mx1 mx1Var, dw2 dw2Var, cu2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, cd2Var, mx1Var, dw2Var, gVar) == null) {
            if (!f73.H() && h92.e() != 2) {
                if (f73.D()) {
                    r82.k().q(cd2Var, mx1Var, dw2Var, gVar);
                    return;
                } else {
                    a(cd2Var, mx1Var, dw2Var, gVar);
                    return;
                }
            }
            g82.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            h92 h92Var = new h92(nu2.c());
            ka3.a aVar = new ka3.a(fb3.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f017d);
            aVar.v(R.string.obfuscated_res_0x7f0f016c);
            aVar.n(new oq3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f016b, new a(h92Var, cd2Var, mx1Var, dw2Var, gVar));
            ka3 X = aVar.X();
            HybridUbcFlow o = l43.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            h92Var.f(new b(cd2Var, mx1Var, dw2Var, gVar, X));
            h92Var.h();
        }
    }
}
