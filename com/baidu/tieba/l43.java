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
import com.baidu.tieba.bz1;
import com.baidu.tieba.e03;
import com.baidu.tieba.j02;
import com.baidu.tieba.wj2;
import com.baidu.tieba.xl2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class l43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bz1 a;
        public final /* synthetic */ w22 b;
        public final /* synthetic */ gn1 c;
        public final /* synthetic */ xl2 d;
        public final /* synthetic */ wj2.g e;

        public a(bz1 bz1Var, w22 w22Var, gn1 gn1Var, xl2 xl2Var, wj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz1Var, w22Var, gn1Var, xl2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bz1Var;
            this.b = w22Var;
            this.c = gn1Var;
            this.d = xl2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                bz1.g(0);
                l43.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements bz1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w22 a;
        public final /* synthetic */ gn1 b;
        public final /* synthetic */ xl2 c;
        public final /* synthetic */ wj2.g d;
        public final /* synthetic */ e03 e;

        public b(w22 w22Var, gn1 gn1Var, xl2 xl2Var, wj2.g gVar, e03 e03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w22Var, gn1Var, xl2Var, gVar, e03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w22Var;
            this.b = gn1Var;
            this.c = xl2Var;
            this.d = gVar;
            this.e = e03Var;
        }

        @Override // com.baidu.tieba.bz1.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l43.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947892862, "Lcom/baidu/tieba/l43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947892862, "Lcom/baidu/tieba/l43;");
                return;
            }
        }
        a = kh1.a;
    }

    public static void a(w22 w22Var, gn1 gn1Var, xl2 xl2Var, wj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, w22Var, gn1Var, xl2Var, gVar) == null) {
            HybridUbcFlow o = fu2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            nm2 U = nm2.U();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(U, xl2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                i62.c().b(w22Var, gn1Var, xl2Var, gVar.b, gVar, false);
                w22Var.attachActivity(activity);
                gn1Var.attachActivity(activity);
                j02 V = U.V();
                if (V == null) {
                    return;
                }
                ar2 d2 = ar2.d(d, U.z());
                f72.o(ue3.a(d2.c, d2.a, d2.b), gn1Var);
                g(V, d);
                t73.E();
                nr2.e(gn1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    fu2.l(h);
                }
                t73.F(true, xl2Var.T());
                cg3 T = activity.T();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + T);
                }
                if (T != null) {
                    T.F(1);
                }
                z03 K = z03.K();
                if (K.E() && TextUtils.equals(K.getAppId(), xl2Var.H())) {
                    K.q().J(true);
                }
                c12.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            nm2 U = nm2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                j02 V = U.V();
                if (V == null) {
                    ay1.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    ay1.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    vg3.a().k();
                    cg3 T = activity.T();
                    if (T != null) {
                        T.F(1);
                    }
                    z03 K = z03.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    c12.f(true);
                    return;
                }
            }
            ay1.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b : (String) invokeV.objValue;
    }

    public static String d(nm2 nm2Var, xl2 xl2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, nm2Var, xl2Var, swanAppConfigData)) == null) {
            String b2 = nm2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (xl2Var.o0()) {
                    b2 = swanAppConfigData.g(xl2Var.h0());
                } else {
                    b2 = nm2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        xl2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            a13 q = z03.K().q();
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

    public static boolean f(j02 j02Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, j02Var)) == null) ? j02Var.k() >= 1 && (j02Var.m() instanceof n02) : invokeL.booleanValue;
    }

    public static void g(j02 j02Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, j02Var, str) == null) || j02Var == null) {
            return;
        }
        i02.S3(null);
        nm2 U = nm2.U();
        j02.b i = j02Var.i("init");
        int i2 = j02.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", ar2.d(str, U.z()), true).a();
    }

    public static void h(j02 j02Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, j02Var, str) == null) {
            if (j02Var == null) {
                ay1.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(j02Var)) {
                ay1.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                i02.S3(null);
                j02.b i = j02Var.i("init");
                int i2 = j02.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", ar2.d(str, str), true).a();
                sg3.c().o(j02Var.m());
            }
        }
    }

    public static void i(w22 w22Var, gn1 gn1Var, xl2 xl2Var, wj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, w22Var, gn1Var, xl2Var, gVar) == null) {
            if (!zw2.H() && bz1.e() != 2) {
                if (zw2.D()) {
                    ly1.k().q(w22Var, gn1Var, xl2Var, gVar);
                    return;
                } else {
                    a(w22Var, gn1Var, xl2Var, gVar);
                    return;
                }
            }
            ay1.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            bz1 bz1Var = new bz1(hk2.c());
            e03.a aVar = new e03.a(z03.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f014e);
            aVar.v(R.string.obfuscated_res_0x7f0f013d);
            aVar.n(new ig3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f013c, new a(bz1Var, w22Var, gn1Var, xl2Var, gVar));
            e03 X = aVar.X();
            HybridUbcFlow o = fu2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            bz1Var.f(new b(w22Var, gn1Var, xl2Var, gVar, X));
            bz1Var.h();
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            b(tg3.b(e()));
        }
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            b(str);
        }
    }
}
