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
import com.baidu.tieba.im2;
import com.baidu.tieba.jo2;
import com.baidu.tieba.n12;
import com.baidu.tieba.q23;
import com.baidu.tieba.v22;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class x63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public final class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n12 a;
        public final /* synthetic */ i52 b;
        public final /* synthetic */ sp1 c;
        public final /* synthetic */ jo2 d;
        public final /* synthetic */ im2.g e;

        public a(n12 n12Var, i52 i52Var, sp1 sp1Var, jo2 jo2Var, im2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n12Var, i52Var, sp1Var, jo2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n12Var;
            this.b = i52Var;
            this.c = sp1Var;
            this.d = jo2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                n12.g(0);
                x63.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class b implements n12.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i52 a;
        public final /* synthetic */ sp1 b;
        public final /* synthetic */ jo2 c;
        public final /* synthetic */ im2.g d;
        public final /* synthetic */ q23 e;

        public b(i52 i52Var, sp1 sp1Var, jo2 jo2Var, im2.g gVar, q23 q23Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i52Var, sp1Var, jo2Var, gVar, q23Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i52Var;
            this.b = sp1Var;
            this.c = jo2Var;
            this.d = gVar;
            this.e = q23Var;
        }

        @Override // com.baidu.tieba.n12.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                x63.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948252276, "Lcom/baidu/tieba/x63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948252276, "Lcom/baidu/tieba/x63;");
                return;
            }
        }
        a = wj1.a;
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
            b(fj3.b(e()));
        }
    }

    public static void a(i52 i52Var, sp1 sp1Var, jo2 jo2Var, im2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, i52Var, sp1Var, jo2Var, gVar) == null) {
            HybridUbcFlow o = rw2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            zo2 U = zo2.U();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(U, jo2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                u82.c().b(i52Var, sp1Var, jo2Var, gVar.b, gVar, false);
                i52Var.attachActivity(activity);
                sp1Var.attachActivity(activity);
                v22 V = U.V();
                if (V == null) {
                    return;
                }
                mt2 d2 = mt2.d(d, U.z());
                r92.o(gh3.a(d2.c, d2.a, d2.b), sp1Var);
                g(V, d);
                fa3.E();
                zt2.e(sp1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    rw2.l(h);
                }
                fa3.F(true, jo2Var.T());
                oi3 T = activity.T();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + T);
                }
                if (T != null) {
                    T.F(1);
                }
                l33 K = l33.K();
                if (K.E() && TextUtils.equals(K.getAppId(), jo2Var.H())) {
                    K.q().J(true);
                }
                o32.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            zo2 U = zo2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                v22 V = U.V();
                if (V == null) {
                    m02.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    m02.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    hj3.a().k();
                    oi3 T = activity.T();
                    if (T != null) {
                        T.F(1);
                    }
                    l33 K = l33.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    o32.f(true);
                    return;
                }
            }
            m02.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(zo2 zo2Var, jo2 jo2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, zo2Var, jo2Var, swanAppConfigData)) == null) {
            String b2 = zo2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (jo2Var.o0()) {
                    b2 = swanAppConfigData.g(jo2Var.h0());
                } else {
                    b2 = zo2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        jo2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            m33 q = l33.K().q();
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

    public static boolean f(v22 v22Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, v22Var)) == null) {
            if (v22Var.k() >= 1 && (v22Var.m() instanceof z22)) {
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

    public static void g(v22 v22Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, v22Var, str) != null) || v22Var == null) {
            return;
        }
        u22.S3(null);
        zo2 U = zo2.U();
        v22.b i = v22Var.i("init");
        int i2 = v22.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", mt2.d(str, U.z()), true).a();
    }

    public static void h(v22 v22Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, v22Var, str) == null) {
            if (v22Var == null) {
                m02.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(v22Var)) {
                m02.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                u22.S3(null);
                v22.b i = v22Var.i("init");
                int i2 = v22.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", mt2.d(str, str), true).a();
                ej3.c().o(v22Var.m());
            }
        }
    }

    public static void i(i52 i52Var, sp1 sp1Var, jo2 jo2Var, im2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, i52Var, sp1Var, jo2Var, gVar) == null) {
            if (!lz2.H() && n12.e() != 2) {
                if (lz2.D()) {
                    x02.k().q(i52Var, sp1Var, jo2Var, gVar);
                    return;
                } else {
                    a(i52Var, sp1Var, jo2Var, gVar);
                    return;
                }
            }
            m02.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            n12 n12Var = new n12(tm2.c());
            q23.a aVar = new q23.a(l33.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f0150);
            aVar.v(R.string.obfuscated_res_0x7f0f013f);
            aVar.n(new ui3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f013e, new a(n12Var, i52Var, sp1Var, jo2Var, gVar));
            q23 X = aVar.X();
            HybridUbcFlow o = rw2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            n12Var.f(new b(i52Var, sp1Var, jo2Var, gVar, X));
            n12Var.h();
        }
    }
}
