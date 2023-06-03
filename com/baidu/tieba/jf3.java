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
import com.baidu.tieba.cb3;
import com.baidu.tieba.hb2;
import com.baidu.tieba.uu2;
import com.baidu.tieba.vw2;
import com.baidu.tieba.z92;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jf3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z92 a;
        public final /* synthetic */ ud2 b;
        public final /* synthetic */ ey1 c;
        public final /* synthetic */ vw2 d;
        public final /* synthetic */ uu2.g e;

        public a(z92 z92Var, ud2 ud2Var, ey1 ey1Var, vw2 vw2Var, uu2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z92Var, ud2Var, ey1Var, vw2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z92Var;
            this.b = ud2Var;
            this.c = ey1Var;
            this.d = vw2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                z92.g(0);
                jf3.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements z92.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ud2 a;
        public final /* synthetic */ ey1 b;
        public final /* synthetic */ vw2 c;
        public final /* synthetic */ uu2.g d;
        public final /* synthetic */ cb3 e;

        public b(ud2 ud2Var, ey1 ey1Var, vw2 vw2Var, uu2.g gVar, cb3 cb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ud2Var, ey1Var, vw2Var, gVar, cb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ud2Var;
            this.b = ey1Var;
            this.c = vw2Var;
            this.d = gVar;
            this.e = cb3Var;
        }

        @Override // com.baidu.tieba.z92.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jf3.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947881330, "Lcom/baidu/tieba/jf3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947881330, "Lcom/baidu/tieba/jf3;");
                return;
            }
        }
        a = is1.a;
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
            b(rr3.b(e()));
        }
    }

    public static void a(ud2 ud2Var, ey1 ey1Var, vw2 vw2Var, uu2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, ud2Var, ey1Var, vw2Var, gVar) == null) {
            HybridUbcFlow o = d53.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            lx2 T2 = lx2.T();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(T2, vw2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                gh2.c().b(ud2Var, ey1Var, vw2Var, gVar.b, gVar, false);
                ud2Var.attachActivity(activity);
                ey1Var.attachActivity(activity);
                hb2 U = T2.U();
                if (U == null) {
                    return;
                }
                y13 d2 = y13.d(d, T2.z());
                di2.o(sp3.a(d2.c, d2.a, d2.b), ey1Var);
                g(U, d);
                ri3.E();
                l23.e(ey1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    d53.l(h);
                }
                ri3.F(true, vw2Var.T());
                ar3 U2 = activity.U();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + U2);
                }
                if (U2 != null) {
                    U2.F(1);
                }
                xb3 K = xb3.K();
                if (K.E() && TextUtils.equals(K.getAppId(), vw2Var.H())) {
                    K.q().J(true);
                }
                ac2.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            lx2 T2 = lx2.T();
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                hb2 U = T2.U();
                if (U == null) {
                    y82.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    y82.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(U, str);
                    tr3.a().k();
                    ar3 U2 = activity.U();
                    if (U2 != null) {
                        U2.F(1);
                    }
                    xb3 K = xb3.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    ac2.f(true);
                    return;
                }
            }
            y82.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(lx2 lx2Var, vw2 vw2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, lx2Var, vw2Var, swanAppConfigData)) == null) {
            String b2 = lx2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (vw2Var.o0()) {
                    b2 = swanAppConfigData.g(vw2Var.h0());
                } else {
                    b2 = lx2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        vw2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            yb3 q = xb3.K().q();
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

    public static boolean f(hb2 hb2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, hb2Var)) == null) {
            if (hb2Var.k() >= 1 && (hb2Var.m() instanceof lb2)) {
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

    public static void g(hb2 hb2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, hb2Var, str) != null) || hb2Var == null) {
            return;
        }
        gb2.U3(null);
        lx2 T2 = lx2.T();
        hb2.b i = hb2Var.i("init");
        int i2 = hb2.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", y13.d(str, T2.z()), true).a();
    }

    public static void h(hb2 hb2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, hb2Var, str) == null) {
            if (hb2Var == null) {
                y82.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(hb2Var)) {
                y82.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                gb2.U3(null);
                hb2.b i = hb2Var.i("init");
                int i2 = hb2.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", y13.d(str, str), true).a();
                qr3.c().o(hb2Var.m());
            }
        }
    }

    public static void i(ud2 ud2Var, ey1 ey1Var, vw2 vw2Var, uu2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, ud2Var, ey1Var, vw2Var, gVar) == null) {
            if (!x73.H() && z92.e() != 2) {
                if (x73.D()) {
                    j92.k().q(ud2Var, ey1Var, vw2Var, gVar);
                    return;
                } else {
                    a(ud2Var, ey1Var, vw2Var, gVar);
                    return;
                }
            }
            y82.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            z92 z92Var = new z92(fv2.c());
            cb3.a aVar = new cb3.a(xb3.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f017a);
            aVar.v(R.string.obfuscated_res_0x7f0f0169);
            aVar.n(new gr3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0168, new a(z92Var, ud2Var, ey1Var, vw2Var, gVar));
            cb3 X = aVar.X();
            HybridUbcFlow o = d53.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            z92Var.f(new b(ud2Var, ey1Var, vw2Var, gVar, X));
            z92Var.h();
        }
    }
}
