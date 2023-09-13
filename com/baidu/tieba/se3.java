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
import com.baidu.tieba.du2;
import com.baidu.tieba.ew2;
import com.baidu.tieba.i92;
import com.baidu.tieba.la3;
import com.baidu.tieba.qa2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class se3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i92 a;
        public final /* synthetic */ dd2 b;
        public final /* synthetic */ nx1 c;
        public final /* synthetic */ ew2 d;
        public final /* synthetic */ du2.g e;

        public a(i92 i92Var, dd2 dd2Var, nx1 nx1Var, ew2 ew2Var, du2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i92Var, dd2Var, nx1Var, ew2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i92Var;
            this.b = dd2Var;
            this.c = nx1Var;
            this.d = ew2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                i92.g(0);
                se3.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements i92.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dd2 a;
        public final /* synthetic */ nx1 b;
        public final /* synthetic */ ew2 c;
        public final /* synthetic */ du2.g d;
        public final /* synthetic */ la3 e;

        public b(dd2 dd2Var, nx1 nx1Var, ew2 ew2Var, du2.g gVar, la3 la3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dd2Var, nx1Var, ew2Var, gVar, la3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dd2Var;
            this.b = nx1Var;
            this.c = ew2Var;
            this.d = gVar;
            this.e = la3Var;
        }

        @Override // com.baidu.tieba.i92.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                se3.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948148488, "Lcom/baidu/tieba/se3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948148488, "Lcom/baidu/tieba/se3;");
                return;
            }
        }
        a = rr1.a;
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
            b(ar3.b(e()));
        }
    }

    public static void a(dd2 dd2Var, nx1 nx1Var, ew2 ew2Var, du2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, dd2Var, nx1Var, ew2Var, gVar) == null) {
            HybridUbcFlow o = m43.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            uw2 T2 = uw2.T();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(T2, ew2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                pg2.c().b(dd2Var, nx1Var, ew2Var, gVar.b, gVar, false);
                dd2Var.attachActivity(activity);
                nx1Var.attachActivity(activity);
                qa2 U = T2.U();
                if (U == null) {
                    return;
                }
                h13 d2 = h13.d(d, T2.z());
                mh2.o(bp3.a(d2.c, d2.a, d2.b), nx1Var);
                g(U, d);
                ai3.E();
                u13.e(nx1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    m43.l(h);
                }
                ai3.F(true, ew2Var.T());
                jq3 T3 = activity.T();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + T3);
                }
                if (T3 != null) {
                    T3.F(1);
                }
                gb3 K = gb3.K();
                if (K.E() && TextUtils.equals(K.getAppId(), ew2Var.H())) {
                    K.q().J(true);
                }
                jb2.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            uw2 T2 = uw2.T();
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                qa2 U = T2.U();
                if (U == null) {
                    h82.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    h82.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(U, str);
                    cr3.a().k();
                    jq3 T3 = activity.T();
                    if (T3 != null) {
                        T3.F(1);
                    }
                    gb3 K = gb3.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    jb2.f(true);
                    return;
                }
            }
            h82.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(uw2 uw2Var, ew2 ew2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, uw2Var, ew2Var, swanAppConfigData)) == null) {
            String b2 = uw2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (ew2Var.o0()) {
                    b2 = swanAppConfigData.g(ew2Var.h0());
                } else {
                    b2 = uw2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        ew2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            hb3 q = gb3.K().q();
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

    public static boolean f(qa2 qa2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, qa2Var)) == null) {
            if (qa2Var.k() >= 1 && (qa2Var.m() instanceof ua2)) {
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

    public static void g(qa2 qa2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, qa2Var, str) != null) || qa2Var == null) {
            return;
        }
        pa2.U3(null);
        uw2 T2 = uw2.T();
        qa2.b i = qa2Var.i("init");
        int i2 = qa2.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", h13.d(str, T2.z()), true).a();
    }

    public static void h(qa2 qa2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, qa2Var, str) == null) {
            if (qa2Var == null) {
                h82.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(qa2Var)) {
                h82.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                pa2.U3(null);
                qa2.b i = qa2Var.i("init");
                int i2 = qa2.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", h13.d(str, str), true).a();
                zq3.c().o(qa2Var.m());
            }
        }
    }

    public static void i(dd2 dd2Var, nx1 nx1Var, ew2 ew2Var, du2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, dd2Var, nx1Var, ew2Var, gVar) == null) {
            if (!g73.H() && i92.e() != 2) {
                if (g73.D()) {
                    s82.k().q(dd2Var, nx1Var, ew2Var, gVar);
                    return;
                } else {
                    a(dd2Var, nx1Var, ew2Var, gVar);
                    return;
                }
            }
            h82.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            i92 i92Var = new i92(ou2.c());
            la3.a aVar = new la3.a(gb3.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f017d);
            aVar.v(R.string.obfuscated_res_0x7f0f016c);
            aVar.n(new pq3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f016b, new a(i92Var, dd2Var, nx1Var, ew2Var, gVar));
            la3 X = aVar.X();
            HybridUbcFlow o = m43.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            i92Var.f(new b(dd2Var, nx1Var, ew2Var, gVar, X));
            i92Var.h();
        }
    }
}
