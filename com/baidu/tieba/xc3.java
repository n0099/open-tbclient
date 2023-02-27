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
import com.baidu.tieba.is2;
import com.baidu.tieba.ju2;
import com.baidu.tieba.n72;
import com.baidu.tieba.q83;
import com.baidu.tieba.v82;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n72 a;
        public final /* synthetic */ ib2 b;
        public final /* synthetic */ sv1 c;
        public final /* synthetic */ ju2 d;
        public final /* synthetic */ is2.g e;

        public a(n72 n72Var, ib2 ib2Var, sv1 sv1Var, ju2 ju2Var, is2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n72Var, ib2Var, sv1Var, ju2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n72Var;
            this.b = ib2Var;
            this.c = sv1Var;
            this.d = ju2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                n72.g(0);
                xc3.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements n72.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ib2 a;
        public final /* synthetic */ sv1 b;
        public final /* synthetic */ ju2 c;
        public final /* synthetic */ is2.g d;
        public final /* synthetic */ q83 e;

        public b(ib2 ib2Var, sv1 sv1Var, ju2 ju2Var, is2.g gVar, q83 q83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib2Var, sv1Var, ju2Var, gVar, q83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ib2Var;
            this.b = sv1Var;
            this.c = ju2Var;
            this.d = gVar;
            this.e = q83Var;
        }

        @Override // com.baidu.tieba.n72.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xc3.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948295521, "Lcom/baidu/tieba/xc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948295521, "Lcom/baidu/tieba/xc3;");
                return;
            }
        }
        a = wp1.a;
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
            b(fp3.b(e()));
        }
    }

    public static void a(ib2 ib2Var, sv1 sv1Var, ju2 ju2Var, is2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, ib2Var, sv1Var, ju2Var, gVar) == null) {
            HybridUbcFlow o = r23.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            zu2 U = zu2.U();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(U, ju2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                ue2.c().b(ib2Var, sv1Var, ju2Var, gVar.b, gVar, false);
                ib2Var.attachActivity(activity);
                sv1Var.attachActivity(activity);
                v82 V = U.V();
                if (V == null) {
                    return;
                }
                mz2 d2 = mz2.d(d, U.z());
                rf2.o(gn3.a(d2.c, d2.a, d2.b), sv1Var);
                g(V, d);
                fg3.E();
                zz2.e(sv1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    r23.l(h);
                }
                fg3.F(true, ju2Var.T());
                oo3 T = activity.T();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + T);
                }
                if (T != null) {
                    T.F(1);
                }
                l93 K = l93.K();
                if (K.E() && TextUtils.equals(K.getAppId(), ju2Var.H())) {
                    K.q().J(true);
                }
                o92.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            zu2 U = zu2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                v82 V = U.V();
                if (V == null) {
                    m62.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    m62.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    hp3.a().k();
                    oo3 T = activity.T();
                    if (T != null) {
                        T.F(1);
                    }
                    l93 K = l93.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    o92.f(true);
                    return;
                }
            }
            m62.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(zu2 zu2Var, ju2 ju2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, zu2Var, ju2Var, swanAppConfigData)) == null) {
            String b2 = zu2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (ju2Var.o0()) {
                    b2 = swanAppConfigData.g(ju2Var.h0());
                } else {
                    b2 = zu2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        ju2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            m93 q = l93.K().q();
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

    public static boolean f(v82 v82Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, v82Var)) == null) {
            if (v82Var.k() >= 1 && (v82Var.m() instanceof z82)) {
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

    public static void g(v82 v82Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, v82Var, str) != null) || v82Var == null) {
            return;
        }
        u82.S3(null);
        zu2 U = zu2.U();
        v82.b i = v82Var.i("init");
        int i2 = v82.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", mz2.d(str, U.z()), true).a();
    }

    public static void h(v82 v82Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, v82Var, str) == null) {
            if (v82Var == null) {
                m62.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(v82Var)) {
                m62.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                u82.S3(null);
                v82.b i = v82Var.i("init");
                int i2 = v82.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", mz2.d(str, str), true).a();
                ep3.c().o(v82Var.m());
            }
        }
    }

    public static void i(ib2 ib2Var, sv1 sv1Var, ju2 ju2Var, is2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, ib2Var, sv1Var, ju2Var, gVar) == null) {
            if (!l53.H() && n72.e() != 2) {
                if (l53.D()) {
                    x62.k().q(ib2Var, sv1Var, ju2Var, gVar);
                    return;
                } else {
                    a(ib2Var, sv1Var, ju2Var, gVar);
                    return;
                }
            }
            m62.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            n72 n72Var = new n72(ts2.c());
            q83.a aVar = new q83.a(l93.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f0152);
            aVar.v(R.string.obfuscated_res_0x7f0f0141);
            aVar.n(new uo3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0140, new a(n72Var, ib2Var, sv1Var, ju2Var, gVar));
            q83 X = aVar.X();
            HybridUbcFlow o = r23.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            n72Var.f(new b(ib2Var, sv1Var, ju2Var, gVar, X));
            n72Var.h();
        }
    }
}
