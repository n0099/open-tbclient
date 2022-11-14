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
import com.baidu.tieba.bn2;
import com.baidu.tieba.cp2;
import com.baidu.tieba.g22;
import com.baidu.tieba.j33;
import com.baidu.tieba.o32;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class q73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g22 a;
        public final /* synthetic */ b62 b;
        public final /* synthetic */ lq1 c;
        public final /* synthetic */ cp2 d;
        public final /* synthetic */ bn2.g e;

        public a(g22 g22Var, b62 b62Var, lq1 lq1Var, cp2 cp2Var, bn2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g22Var, b62Var, lq1Var, cp2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g22Var;
            this.b = b62Var;
            this.c = lq1Var;
            this.d = cp2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                g22.g(0);
                q73.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements g22.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b62 a;
        public final /* synthetic */ lq1 b;
        public final /* synthetic */ cp2 c;
        public final /* synthetic */ bn2.g d;
        public final /* synthetic */ j33 e;

        public b(b62 b62Var, lq1 lq1Var, cp2 cp2Var, bn2.g gVar, j33 j33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b62Var, lq1Var, cp2Var, gVar, j33Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b62Var;
            this.b = lq1Var;
            this.c = cp2Var;
            this.d = gVar;
            this.e = j33Var;
        }

        @Override // com.baidu.tieba.g22.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q73.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948044700, "Lcom/baidu/tieba/q73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948044700, "Lcom/baidu/tieba/q73;");
                return;
            }
        }
        a = pk1.a;
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
            b(yj3.b(e()));
        }
    }

    public static void a(b62 b62Var, lq1 lq1Var, cp2 cp2Var, bn2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, b62Var, lq1Var, cp2Var, gVar) == null) {
            HybridUbcFlow o = kx2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            sp2 U = sp2.U();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(U, cp2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                n92.c().b(b62Var, lq1Var, cp2Var, gVar.b, gVar, false);
                b62Var.attachActivity(activity);
                lq1Var.attachActivity(activity);
                o32 V = U.V();
                if (V == null) {
                    return;
                }
                fu2 d2 = fu2.d(d, U.z());
                ka2.o(zh3.a(d2.c, d2.a, d2.b), lq1Var);
                g(V, d);
                ya3.E();
                su2.e(lq1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    kx2.l(h);
                }
                ya3.F(true, cp2Var.T());
                hj3 T = activity.T();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + T);
                }
                if (T != null) {
                    T.F(1);
                }
                e43 K = e43.K();
                if (K.E() && TextUtils.equals(K.getAppId(), cp2Var.H())) {
                    K.q().J(true);
                }
                h42.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            sp2 U = sp2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                o32 V = U.V();
                if (V == null) {
                    f12.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    f12.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    ak3.a().k();
                    hj3 T = activity.T();
                    if (T != null) {
                        T.F(1);
                    }
                    e43 K = e43.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    h42.f(true);
                    return;
                }
            }
            f12.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(sp2 sp2Var, cp2 cp2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, sp2Var, cp2Var, swanAppConfigData)) == null) {
            String b2 = sp2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (cp2Var.o0()) {
                    b2 = swanAppConfigData.g(cp2Var.h0());
                } else {
                    b2 = sp2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        cp2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            f43 q = e43.K().q();
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

    public static boolean f(o32 o32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, o32Var)) == null) {
            if (o32Var.k() >= 1 && (o32Var.m() instanceof s32)) {
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

    public static void g(o32 o32Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, o32Var, str) != null) || o32Var == null) {
            return;
        }
        n32.S3(null);
        sp2 U = sp2.U();
        o32.b i = o32Var.i("init");
        int i2 = o32.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", fu2.d(str, U.z()), true).a();
    }

    public static void h(o32 o32Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, o32Var, str) == null) {
            if (o32Var == null) {
                f12.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(o32Var)) {
                f12.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                n32.S3(null);
                o32.b i = o32Var.i("init");
                int i2 = o32.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", fu2.d(str, str), true).a();
                xj3.c().o(o32Var.m());
            }
        }
    }

    public static void i(b62 b62Var, lq1 lq1Var, cp2 cp2Var, bn2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, b62Var, lq1Var, cp2Var, gVar) == null) {
            if (!e03.H() && g22.e() != 2) {
                if (e03.D()) {
                    q12.k().q(b62Var, lq1Var, cp2Var, gVar);
                    return;
                } else {
                    a(b62Var, lq1Var, cp2Var, gVar);
                    return;
                }
            }
            f12.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            g22 g22Var = new g22(mn2.c());
            j33.a aVar = new j33.a(e43.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f0150);
            aVar.v(R.string.obfuscated_res_0x7f0f013f);
            aVar.n(new nj3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f013e, new a(g22Var, b62Var, lq1Var, cp2Var, gVar));
            j33 X = aVar.X();
            HybridUbcFlow o = kx2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            g22Var.f(new b(b62Var, lq1Var, cp2Var, gVar, X));
            g22Var.h();
        }
    }
}
