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
import com.baidu.tieba.aw2;
import com.baidu.tieba.e92;
import com.baidu.tieba.ha3;
import com.baidu.tieba.ma2;
import com.baidu.tieba.zt2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class oe3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e92 a;
        public final /* synthetic */ zc2 b;
        public final /* synthetic */ jx1 c;
        public final /* synthetic */ aw2 d;
        public final /* synthetic */ zt2.g e;

        public a(e92 e92Var, zc2 zc2Var, jx1 jx1Var, aw2 aw2Var, zt2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e92Var, zc2Var, jx1Var, aw2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e92Var;
            this.b = zc2Var;
            this.c = jx1Var;
            this.d = aw2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                e92.g(0);
                oe3.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements e92.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zc2 a;
        public final /* synthetic */ jx1 b;
        public final /* synthetic */ aw2 c;
        public final /* synthetic */ zt2.g d;
        public final /* synthetic */ ha3 e;

        public b(zc2 zc2Var, jx1 jx1Var, aw2 aw2Var, zt2.g gVar, ha3 ha3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zc2Var, jx1Var, aw2Var, gVar, ha3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zc2Var;
            this.b = jx1Var;
            this.c = aw2Var;
            this.d = gVar;
            this.e = ha3Var;
        }

        @Override // com.baidu.tieba.e92.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oe3.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948029324, "Lcom/baidu/tieba/oe3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948029324, "Lcom/baidu/tieba/oe3;");
                return;
            }
        }
        a = nr1.a;
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
            b(wq3.b(e()));
        }
    }

    public static void a(zc2 zc2Var, jx1 jx1Var, aw2 aw2Var, zt2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, zc2Var, jx1Var, aw2Var, gVar) == null) {
            HybridUbcFlow o = i43.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            qw2 T2 = qw2.T();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(T2, aw2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                lg2.c().b(zc2Var, jx1Var, aw2Var, gVar.b, gVar, false);
                zc2Var.attachActivity(activity);
                jx1Var.attachActivity(activity);
                ma2 U = T2.U();
                if (U == null) {
                    return;
                }
                d13 d2 = d13.d(d, T2.z());
                ih2.o(xo3.a(d2.c, d2.a, d2.b), jx1Var);
                g(U, d);
                wh3.E();
                q13.e(jx1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    i43.l(h);
                }
                wh3.F(true, aw2Var.T());
                fq3 T3 = activity.T();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + T3);
                }
                if (T3 != null) {
                    T3.F(1);
                }
                cb3 K = cb3.K();
                if (K.E() && TextUtils.equals(K.getAppId(), aw2Var.H())) {
                    K.q().J(true);
                }
                fb2.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            qw2 T2 = qw2.T();
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                ma2 U = T2.U();
                if (U == null) {
                    d82.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    d82.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(U, str);
                    yq3.a().k();
                    fq3 T3 = activity.T();
                    if (T3 != null) {
                        T3.F(1);
                    }
                    cb3 K = cb3.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    fb2.f(true);
                    return;
                }
            }
            d82.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(qw2 qw2Var, aw2 aw2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, qw2Var, aw2Var, swanAppConfigData)) == null) {
            String b2 = qw2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (aw2Var.o0()) {
                    b2 = swanAppConfigData.g(aw2Var.h0());
                } else {
                    b2 = qw2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        aw2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            db3 q = cb3.K().q();
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

    public static boolean f(ma2 ma2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, ma2Var)) == null) {
            if (ma2Var.k() >= 1 && (ma2Var.m() instanceof qa2)) {
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

    public static void g(ma2 ma2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, ma2Var, str) != null) || ma2Var == null) {
            return;
        }
        la2.U3(null);
        qw2 T2 = qw2.T();
        ma2.b i = ma2Var.i("init");
        int i2 = ma2.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", d13.d(str, T2.z()), true).a();
    }

    public static void h(ma2 ma2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, ma2Var, str) == null) {
            if (ma2Var == null) {
                d82.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(ma2Var)) {
                d82.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                la2.U3(null);
                ma2.b i = ma2Var.i("init");
                int i2 = ma2.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", d13.d(str, str), true).a();
                vq3.c().o(ma2Var.m());
            }
        }
    }

    public static void i(zc2 zc2Var, jx1 jx1Var, aw2 aw2Var, zt2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, zc2Var, jx1Var, aw2Var, gVar) == null) {
            if (!c73.H() && e92.e() != 2) {
                if (c73.D()) {
                    o82.k().q(zc2Var, jx1Var, aw2Var, gVar);
                    return;
                } else {
                    a(zc2Var, jx1Var, aw2Var, gVar);
                    return;
                }
            }
            d82.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            e92 e92Var = new e92(ku2.c());
            ha3.a aVar = new ha3.a(cb3.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f017d);
            aVar.v(R.string.obfuscated_res_0x7f0f016c);
            aVar.n(new lq3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f016b, new a(e92Var, zc2Var, jx1Var, aw2Var, gVar));
            ha3 X = aVar.X();
            HybridUbcFlow o = i43.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            e92Var.f(new b(zc2Var, jx1Var, aw2Var, gVar, X));
            e92Var.h();
        }
    }
}
