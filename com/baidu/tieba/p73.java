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
import com.baidu.tieba.an2;
import com.baidu.tieba.bp2;
import com.baidu.tieba.f22;
import com.baidu.tieba.i33;
import com.baidu.tieba.n32;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class p73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f22 a;
        public final /* synthetic */ a62 b;
        public final /* synthetic */ kq1 c;
        public final /* synthetic */ bp2 d;
        public final /* synthetic */ an2.g e;

        public a(f22 f22Var, a62 a62Var, kq1 kq1Var, bp2 bp2Var, an2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f22Var, a62Var, kq1Var, bp2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f22Var;
            this.b = a62Var;
            this.c = kq1Var;
            this.d = bp2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                f22.g(0);
                p73.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements f22.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a62 a;
        public final /* synthetic */ kq1 b;
        public final /* synthetic */ bp2 c;
        public final /* synthetic */ an2.g d;
        public final /* synthetic */ i33 e;

        public b(a62 a62Var, kq1 kq1Var, bp2 bp2Var, an2.g gVar, i33 i33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a62Var, kq1Var, bp2Var, gVar, i33Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a62Var;
            this.b = kq1Var;
            this.c = bp2Var;
            this.d = gVar;
            this.e = i33Var;
        }

        @Override // com.baidu.tieba.f22.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p73.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948014909, "Lcom/baidu/tieba/p73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948014909, "Lcom/baidu/tieba/p73;");
                return;
            }
        }
        a = ok1.a;
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
            b(xj3.b(e()));
        }
    }

    public static void a(a62 a62Var, kq1 kq1Var, bp2 bp2Var, an2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, a62Var, kq1Var, bp2Var, gVar) == null) {
            HybridUbcFlow o = jx2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            rp2 U = rp2.U();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(U, bp2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                m92.c().b(a62Var, kq1Var, bp2Var, gVar.b, gVar, false);
                a62Var.attachActivity(activity);
                kq1Var.attachActivity(activity);
                n32 V = U.V();
                if (V == null) {
                    return;
                }
                eu2 d2 = eu2.d(d, U.z());
                ja2.o(yh3.a(d2.c, d2.a, d2.b), kq1Var);
                g(V, d);
                xa3.E();
                ru2.e(kq1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    jx2.l(h);
                }
                xa3.F(true, bp2Var.T());
                gj3 T = activity.T();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + T);
                }
                if (T != null) {
                    T.F(1);
                }
                d43 K = d43.K();
                if (K.E() && TextUtils.equals(K.getAppId(), bp2Var.H())) {
                    K.q().J(true);
                }
                g42.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            rp2 U = rp2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                n32 V = U.V();
                if (V == null) {
                    e12.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    e12.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    zj3.a().k();
                    gj3 T = activity.T();
                    if (T != null) {
                        T.F(1);
                    }
                    d43 K = d43.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    g42.f(true);
                    return;
                }
            }
            e12.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(rp2 rp2Var, bp2 bp2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, rp2Var, bp2Var, swanAppConfigData)) == null) {
            String b2 = rp2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (bp2Var.o0()) {
                    b2 = swanAppConfigData.g(bp2Var.h0());
                } else {
                    b2 = rp2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        bp2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            e43 q = d43.K().q();
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

    public static boolean f(n32 n32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, n32Var)) == null) {
            if (n32Var.k() >= 1 && (n32Var.m() instanceof r32)) {
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

    public static void g(n32 n32Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, n32Var, str) != null) || n32Var == null) {
            return;
        }
        m32.S3(null);
        rp2 U = rp2.U();
        n32.b i = n32Var.i("init");
        int i2 = n32.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", eu2.d(str, U.z()), true).a();
    }

    public static void h(n32 n32Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, n32Var, str) == null) {
            if (n32Var == null) {
                e12.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(n32Var)) {
                e12.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                m32.S3(null);
                n32.b i = n32Var.i("init");
                int i2 = n32.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", eu2.d(str, str), true).a();
                wj3.c().o(n32Var.m());
            }
        }
    }

    public static void i(a62 a62Var, kq1 kq1Var, bp2 bp2Var, an2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, a62Var, kq1Var, bp2Var, gVar) == null) {
            if (!d03.H() && f22.e() != 2) {
                if (d03.D()) {
                    p12.k().q(a62Var, kq1Var, bp2Var, gVar);
                    return;
                } else {
                    a(a62Var, kq1Var, bp2Var, gVar);
                    return;
                }
            }
            e12.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            f22 f22Var = new f22(ln2.c());
            i33.a aVar = new i33.a(d43.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f0153);
            aVar.v(R.string.obfuscated_res_0x7f0f0142);
            aVar.n(new mj3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0141, new a(f22Var, a62Var, kq1Var, bp2Var, gVar));
            i33 X = aVar.X();
            HybridUbcFlow o = jx2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            f22Var.f(new b(a62Var, kq1Var, bp2Var, gVar, X));
            f22Var.h();
        }
    }
}
