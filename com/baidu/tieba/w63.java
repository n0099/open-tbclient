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
import com.baidu.tieba.hm2;
import com.baidu.tieba.io2;
import com.baidu.tieba.m12;
import com.baidu.tieba.p23;
import com.baidu.tieba.u22;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class w63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m12 a;
        public final /* synthetic */ h52 b;
        public final /* synthetic */ rp1 c;
        public final /* synthetic */ io2 d;
        public final /* synthetic */ hm2.g e;

        public a(m12 m12Var, h52 h52Var, rp1 rp1Var, io2 io2Var, hm2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m12Var, h52Var, rp1Var, io2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m12Var;
            this.b = h52Var;
            this.c = rp1Var;
            this.d = io2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                m12.g(0);
                w63.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements m12.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h52 a;
        public final /* synthetic */ rp1 b;
        public final /* synthetic */ io2 c;
        public final /* synthetic */ hm2.g d;
        public final /* synthetic */ p23 e;

        public b(h52 h52Var, rp1 rp1Var, io2 io2Var, hm2.g gVar, p23 p23Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h52Var, rp1Var, io2Var, gVar, p23Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h52Var;
            this.b = rp1Var;
            this.c = io2Var;
            this.d = gVar;
            this.e = p23Var;
        }

        @Override // com.baidu.tieba.m12.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                w63.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948222485, "Lcom/baidu/tieba/w63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948222485, "Lcom/baidu/tieba/w63;");
                return;
            }
        }
        a = vj1.a;
    }

    public static void a(h52 h52Var, rp1 rp1Var, io2 io2Var, hm2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, h52Var, rp1Var, io2Var, gVar) == null) {
            HybridUbcFlow o = qw2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            yo2 U = yo2.U();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(U, io2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                t82.c().b(h52Var, rp1Var, io2Var, gVar.b, gVar, false);
                h52Var.attachActivity(activity);
                rp1Var.attachActivity(activity);
                u22 V = U.V();
                if (V == null) {
                    return;
                }
                lt2 d2 = lt2.d(d, U.z());
                q92.o(fh3.a(d2.c, d2.a, d2.b), rp1Var);
                g(V, d);
                ea3.E();
                yt2.e(rp1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    qw2.l(h);
                }
                ea3.F(true, io2Var.T());
                ni3 T = activity.T();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + T);
                }
                if (T != null) {
                    T.F(1);
                }
                k33 K = k33.K();
                if (K.E() && TextUtils.equals(K.getAppId(), io2Var.H())) {
                    K.q().J(true);
                }
                n32.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            yo2 U = yo2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                u22 V = U.V();
                if (V == null) {
                    l02.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    l02.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    gj3.a().k();
                    ni3 T = activity.T();
                    if (T != null) {
                        T.F(1);
                    }
                    k33 K = k33.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    n32.f(true);
                    return;
                }
            }
            l02.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b : (String) invokeV.objValue;
    }

    public static String d(yo2 yo2Var, io2 io2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, yo2Var, io2Var, swanAppConfigData)) == null) {
            String b2 = yo2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (io2Var.o0()) {
                    b2 = swanAppConfigData.g(io2Var.h0());
                } else {
                    b2 = yo2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        io2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            l33 q = k33.K().q();
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

    public static boolean f(u22 u22Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, u22Var)) == null) ? u22Var.k() >= 1 && (u22Var.m() instanceof y22) : invokeL.booleanValue;
    }

    public static void g(u22 u22Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, u22Var, str) == null) || u22Var == null) {
            return;
        }
        t22.S3(null);
        yo2 U = yo2.U();
        u22.b i = u22Var.i("init");
        int i2 = u22.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", lt2.d(str, U.z()), true).a();
    }

    public static void h(u22 u22Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, u22Var, str) == null) {
            if (u22Var == null) {
                l02.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(u22Var)) {
                l02.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                t22.S3(null);
                u22.b i = u22Var.i("init");
                int i2 = u22.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", lt2.d(str, str), true).a();
                dj3.c().o(u22Var.m());
            }
        }
    }

    public static void i(h52 h52Var, rp1 rp1Var, io2 io2Var, hm2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, h52Var, rp1Var, io2Var, gVar) == null) {
            if (!kz2.H() && m12.e() != 2) {
                if (kz2.D()) {
                    w02.k().q(h52Var, rp1Var, io2Var, gVar);
                    return;
                } else {
                    a(h52Var, rp1Var, io2Var, gVar);
                    return;
                }
            }
            l02.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            m12 m12Var = new m12(sm2.c());
            p23.a aVar = new p23.a(k33.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f0150);
            aVar.v(R.string.obfuscated_res_0x7f0f013f);
            aVar.n(new ti3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f013e, new a(m12Var, h52Var, rp1Var, io2Var, gVar));
            p23 X = aVar.X();
            HybridUbcFlow o = qw2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            m12Var.f(new b(h52Var, rp1Var, io2Var, gVar, X));
            m12Var.h();
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            b(ej3.b(e()));
        }
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            b(str);
        }
    }
}
