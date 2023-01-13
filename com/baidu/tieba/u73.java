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
import com.baidu.tieba.fn2;
import com.baidu.tieba.gp2;
import com.baidu.tieba.k22;
import com.baidu.tieba.n33;
import com.baidu.tieba.s32;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class u73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k22 a;
        public final /* synthetic */ f62 b;
        public final /* synthetic */ pq1 c;
        public final /* synthetic */ gp2 d;
        public final /* synthetic */ fn2.g e;

        public a(k22 k22Var, f62 f62Var, pq1 pq1Var, gp2 gp2Var, fn2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k22Var, f62Var, pq1Var, gp2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k22Var;
            this.b = f62Var;
            this.c = pq1Var;
            this.d = gp2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                k22.g(0);
                u73.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements k22.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f62 a;
        public final /* synthetic */ pq1 b;
        public final /* synthetic */ gp2 c;
        public final /* synthetic */ fn2.g d;
        public final /* synthetic */ n33 e;

        public b(f62 f62Var, pq1 pq1Var, gp2 gp2Var, fn2.g gVar, n33 n33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f62Var, pq1Var, gp2Var, gVar, n33Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f62Var;
            this.b = pq1Var;
            this.c = gp2Var;
            this.d = gVar;
            this.e = n33Var;
        }

        @Override // com.baidu.tieba.k22.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                u73.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948163864, "Lcom/baidu/tieba/u73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948163864, "Lcom/baidu/tieba/u73;");
                return;
            }
        }
        a = tk1.a;
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
            b(ck3.b(e()));
        }
    }

    public static void a(f62 f62Var, pq1 pq1Var, gp2 gp2Var, fn2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, f62Var, pq1Var, gp2Var, gVar) == null) {
            HybridUbcFlow o = ox2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            wp2 U = wp2.U();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(U, gp2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                r92.c().b(f62Var, pq1Var, gp2Var, gVar.b, gVar, false);
                f62Var.attachActivity(activity);
                pq1Var.attachActivity(activity);
                s32 V = U.V();
                if (V == null) {
                    return;
                }
                ju2 d2 = ju2.d(d, U.z());
                oa2.o(di3.a(d2.c, d2.a, d2.b), pq1Var);
                g(V, d);
                cb3.E();
                wu2.e(pq1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    ox2.l(h);
                }
                cb3.F(true, gp2Var.T());
                lj3 T = activity.T();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + T);
                }
                if (T != null) {
                    T.F(1);
                }
                i43 K = i43.K();
                if (K.E() && TextUtils.equals(K.getAppId(), gp2Var.H())) {
                    K.q().J(true);
                }
                l42.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            wp2 U = wp2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                s32 V = U.V();
                if (V == null) {
                    j12.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    j12.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    ek3.a().k();
                    lj3 T = activity.T();
                    if (T != null) {
                        T.F(1);
                    }
                    i43 K = i43.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    l42.f(true);
                    return;
                }
            }
            j12.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(wp2 wp2Var, gp2 gp2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, wp2Var, gp2Var, swanAppConfigData)) == null) {
            String b2 = wp2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (gp2Var.o0()) {
                    b2 = swanAppConfigData.g(gp2Var.h0());
                } else {
                    b2 = wp2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        gp2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            j43 q = i43.K().q();
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

    public static boolean f(s32 s32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, s32Var)) == null) {
            if (s32Var.k() >= 1 && (s32Var.m() instanceof w32)) {
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

    public static void g(s32 s32Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, s32Var, str) != null) || s32Var == null) {
            return;
        }
        r32.S3(null);
        wp2 U = wp2.U();
        s32.b i = s32Var.i("init");
        int i2 = s32.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", ju2.d(str, U.z()), true).a();
    }

    public static void h(s32 s32Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, s32Var, str) == null) {
            if (s32Var == null) {
                j12.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(s32Var)) {
                j12.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                r32.S3(null);
                s32.b i = s32Var.i("init");
                int i2 = s32.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", ju2.d(str, str), true).a();
                bk3.c().o(s32Var.m());
            }
        }
    }

    public static void i(f62 f62Var, pq1 pq1Var, gp2 gp2Var, fn2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, f62Var, pq1Var, gp2Var, gVar) == null) {
            if (!i03.H() && k22.e() != 2) {
                if (i03.D()) {
                    u12.k().q(f62Var, pq1Var, gp2Var, gVar);
                    return;
                } else {
                    a(f62Var, pq1Var, gp2Var, gVar);
                    return;
                }
            }
            j12.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            k22 k22Var = new k22(qn2.c());
            n33.a aVar = new n33.a(i43.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f0152);
            aVar.v(R.string.obfuscated_res_0x7f0f0141);
            aVar.n(new rj3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0140, new a(k22Var, f62Var, pq1Var, gp2Var, gVar));
            n33 X = aVar.X();
            HybridUbcFlow o = ox2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            k22Var.f(new b(f62Var, pq1Var, gp2Var, gVar, X));
            k22Var.h();
        }
    }
}
