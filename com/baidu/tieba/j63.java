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
import com.baidu.tieba.c23;
import com.baidu.tieba.h22;
import com.baidu.tieba.ul2;
import com.baidu.tieba.vn2;
import com.baidu.tieba.z02;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class j63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z02 a;
        public final /* synthetic */ u42 b;
        public final /* synthetic */ ep1 c;
        public final /* synthetic */ vn2 d;
        public final /* synthetic */ ul2.g e;

        public a(z02 z02Var, u42 u42Var, ep1 ep1Var, vn2 vn2Var, ul2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z02Var, u42Var, ep1Var, vn2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z02Var;
            this.b = u42Var;
            this.c = ep1Var;
            this.d = vn2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                z02.g(0);
                j63.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements z02.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u42 a;
        public final /* synthetic */ ep1 b;
        public final /* synthetic */ vn2 c;
        public final /* synthetic */ ul2.g d;
        public final /* synthetic */ c23 e;

        public b(u42 u42Var, ep1 ep1Var, vn2 vn2Var, ul2.g gVar, c23 c23Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u42Var, ep1Var, vn2Var, gVar, c23Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u42Var;
            this.b = ep1Var;
            this.c = vn2Var;
            this.d = gVar;
            this.e = c23Var;
        }

        @Override // com.baidu.tieba.z02.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                j63.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947835202, "Lcom/baidu/tieba/j63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947835202, "Lcom/baidu/tieba/j63;");
                return;
            }
        }
        a = ij1.a;
    }

    public static void a(u42 u42Var, ep1 ep1Var, vn2 vn2Var, ul2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, u42Var, ep1Var, vn2Var, gVar) == null) {
            HybridUbcFlow o = dw2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            lo2 U = lo2.U();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(U, vn2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                g82.c().b(u42Var, ep1Var, vn2Var, gVar.b, gVar, false);
                u42Var.attachActivity(activity);
                ep1Var.attachActivity(activity);
                h22 V = U.V();
                if (V == null) {
                    return;
                }
                ys2 d2 = ys2.d(d, U.z());
                d92.o(sg3.a(d2.c, d2.a, d2.b), ep1Var);
                g(V, d);
                r93.E();
                lt2.e(ep1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    dw2.l(h);
                }
                r93.F(true, vn2Var.T());
                ai3 T = activity.T();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + T);
                }
                if (T != null) {
                    T.F(1);
                }
                x23 K = x23.K();
                if (K.E() && TextUtils.equals(K.getAppId(), vn2Var.H())) {
                    K.q().J(true);
                }
                a32.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            lo2 U = lo2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                h22 V = U.V();
                if (V == null) {
                    yz1.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    yz1.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    ti3.a().k();
                    ai3 T = activity.T();
                    if (T != null) {
                        T.F(1);
                    }
                    x23 K = x23.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    a32.f(true);
                    return;
                }
            }
            yz1.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b : (String) invokeV.objValue;
    }

    public static String d(lo2 lo2Var, vn2 vn2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, lo2Var, vn2Var, swanAppConfigData)) == null) {
            String b2 = lo2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (vn2Var.o0()) {
                    b2 = swanAppConfigData.g(vn2Var.h0());
                } else {
                    b2 = lo2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        vn2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            y23 q = x23.K().q();
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

    public static boolean f(h22 h22Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, h22Var)) == null) ? h22Var.k() >= 1 && (h22Var.m() instanceof l22) : invokeL.booleanValue;
    }

    public static void g(h22 h22Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, h22Var, str) == null) || h22Var == null) {
            return;
        }
        g22.S3(null);
        lo2 U = lo2.U();
        h22.b i = h22Var.i("init");
        int i2 = h22.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", ys2.d(str, U.z()), true).a();
    }

    public static void h(h22 h22Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, h22Var, str) == null) {
            if (h22Var == null) {
                yz1.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(h22Var)) {
                yz1.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                g22.S3(null);
                h22.b i = h22Var.i("init");
                int i2 = h22.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", ys2.d(str, str), true).a();
                qi3.c().o(h22Var.m());
            }
        }
    }

    public static void i(u42 u42Var, ep1 ep1Var, vn2 vn2Var, ul2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, u42Var, ep1Var, vn2Var, gVar) == null) {
            if (!xy2.H() && z02.e() != 2) {
                if (xy2.D()) {
                    j02.k().q(u42Var, ep1Var, vn2Var, gVar);
                    return;
                } else {
                    a(u42Var, ep1Var, vn2Var, gVar);
                    return;
                }
            }
            yz1.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            z02 z02Var = new z02(fm2.c());
            c23.a aVar = new c23.a(x23.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f0150);
            aVar.v(R.string.obfuscated_res_0x7f0f013f);
            aVar.n(new gi3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f013e, new a(z02Var, u42Var, ep1Var, vn2Var, gVar));
            c23 X = aVar.X();
            HybridUbcFlow o = dw2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            z02Var.f(new b(u42Var, ep1Var, vn2Var, gVar, X));
            z02Var.h();
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            b(ri3.b(e()));
        }
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            b(str);
        }
    }
}
