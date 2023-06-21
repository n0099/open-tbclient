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
import com.baidu.tieba.aa2;
import com.baidu.tieba.db3;
import com.baidu.tieba.ib2;
import com.baidu.tieba.vu2;
import com.baidu.tieba.ww2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kf3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa2 a;
        public final /* synthetic */ vd2 b;
        public final /* synthetic */ fy1 c;
        public final /* synthetic */ ww2 d;
        public final /* synthetic */ vu2.g e;

        public a(aa2 aa2Var, vd2 vd2Var, fy1 fy1Var, ww2 ww2Var, vu2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa2Var, vd2Var, fy1Var, ww2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa2Var;
            this.b = vd2Var;
            this.c = fy1Var;
            this.d = ww2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                aa2.g(0);
                kf3.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements aa2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vd2 a;
        public final /* synthetic */ fy1 b;
        public final /* synthetic */ ww2 c;
        public final /* synthetic */ vu2.g d;
        public final /* synthetic */ db3 e;

        public b(vd2 vd2Var, fy1 fy1Var, ww2 ww2Var, vu2.g gVar, db3 db3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vd2Var, fy1Var, ww2Var, gVar, db3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vd2Var;
            this.b = fy1Var;
            this.c = ww2Var;
            this.d = gVar;
            this.e = db3Var;
        }

        @Override // com.baidu.tieba.aa2.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kf3.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947911121, "Lcom/baidu/tieba/kf3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947911121, "Lcom/baidu/tieba/kf3;");
                return;
            }
        }
        a = js1.a;
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
            b(sr3.b(e()));
        }
    }

    public static void a(vd2 vd2Var, fy1 fy1Var, ww2 ww2Var, vu2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, vd2Var, fy1Var, ww2Var, gVar) == null) {
            HybridUbcFlow o = e53.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            mx2 T2 = mx2.T();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(T2, ww2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                hh2.c().b(vd2Var, fy1Var, ww2Var, gVar.b, gVar, false);
                vd2Var.attachActivity(activity);
                fy1Var.attachActivity(activity);
                ib2 U = T2.U();
                if (U == null) {
                    return;
                }
                z13 d2 = z13.d(d, T2.z());
                ei2.o(tp3.a(d2.c, d2.a, d2.b), fy1Var);
                g(U, d);
                si3.E();
                m23.e(fy1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    e53.l(h);
                }
                si3.F(true, ww2Var.T());
                br3 U2 = activity.U();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + U2);
                }
                if (U2 != null) {
                    U2.F(1);
                }
                yb3 K = yb3.K();
                if (K.E() && TextUtils.equals(K.getAppId(), ww2Var.H())) {
                    K.q().J(true);
                }
                bc2.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            mx2 T2 = mx2.T();
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                ib2 U = T2.U();
                if (U == null) {
                    z82.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    z82.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(U, str);
                    ur3.a().k();
                    br3 U2 = activity.U();
                    if (U2 != null) {
                        U2.F(1);
                    }
                    yb3 K = yb3.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    bc2.f(true);
                    return;
                }
            }
            z82.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(mx2 mx2Var, ww2 ww2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, mx2Var, ww2Var, swanAppConfigData)) == null) {
            String b2 = mx2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (ww2Var.o0()) {
                    b2 = swanAppConfigData.g(ww2Var.h0());
                } else {
                    b2 = mx2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        ww2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            zb3 q = yb3.K().q();
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

    public static boolean f(ib2 ib2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, ib2Var)) == null) {
            if (ib2Var.k() >= 1 && (ib2Var.m() instanceof mb2)) {
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

    public static void g(ib2 ib2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, ib2Var, str) != null) || ib2Var == null) {
            return;
        }
        hb2.U3(null);
        mx2 T2 = mx2.T();
        ib2.b i = ib2Var.i("init");
        int i2 = ib2.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", z13.d(str, T2.z()), true).a();
    }

    public static void h(ib2 ib2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, ib2Var, str) == null) {
            if (ib2Var == null) {
                z82.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(ib2Var)) {
                z82.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                hb2.U3(null);
                ib2.b i = ib2Var.i("init");
                int i2 = ib2.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", z13.d(str, str), true).a();
                rr3.c().o(ib2Var.m());
            }
        }
    }

    public static void i(vd2 vd2Var, fy1 fy1Var, ww2 ww2Var, vu2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, vd2Var, fy1Var, ww2Var, gVar) == null) {
            if (!y73.H() && aa2.e() != 2) {
                if (y73.D()) {
                    k92.k().q(vd2Var, fy1Var, ww2Var, gVar);
                    return;
                } else {
                    a(vd2Var, fy1Var, ww2Var, gVar);
                    return;
                }
            }
            z82.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            aa2 aa2Var = new aa2(gv2.c());
            db3.a aVar = new db3.a(yb3.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f017a);
            aVar.v(R.string.obfuscated_res_0x7f0f0169);
            aVar.n(new hr3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0168, new a(aa2Var, vd2Var, fy1Var, ww2Var, gVar));
            db3 X = aVar.X();
            HybridUbcFlow o = e53.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            aa2Var.f(new b(vd2Var, fy1Var, ww2Var, gVar, X));
            aa2Var.h();
        }
    }
}
