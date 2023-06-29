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
import com.baidu.tieba.da2;
import com.baidu.tieba.gb3;
import com.baidu.tieba.lb2;
import com.baidu.tieba.yu2;
import com.baidu.tieba.zw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nf3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ da2 a;
        public final /* synthetic */ yd2 b;
        public final /* synthetic */ iy1 c;
        public final /* synthetic */ zw2 d;
        public final /* synthetic */ yu2.g e;

        public a(da2 da2Var, yd2 yd2Var, iy1 iy1Var, zw2 zw2Var, yu2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {da2Var, yd2Var, iy1Var, zw2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = da2Var;
            this.b = yd2Var;
            this.c = iy1Var;
            this.d = zw2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                da2.g(0);
                nf3.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements da2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd2 a;
        public final /* synthetic */ iy1 b;
        public final /* synthetic */ zw2 c;
        public final /* synthetic */ yu2.g d;
        public final /* synthetic */ gb3 e;

        public b(yd2 yd2Var, iy1 iy1Var, zw2 zw2Var, yu2.g gVar, gb3 gb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var, iy1Var, zw2Var, gVar, gb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yd2Var;
            this.b = iy1Var;
            this.c = zw2Var;
            this.d = gVar;
            this.e = gb3Var;
        }

        @Override // com.baidu.tieba.da2.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nf3.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948000494, "Lcom/baidu/tieba/nf3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948000494, "Lcom/baidu/tieba/nf3;");
                return;
            }
        }
        a = ms1.a;
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
            b(vr3.b(e()));
        }
    }

    public static void a(yd2 yd2Var, iy1 iy1Var, zw2 zw2Var, yu2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, yd2Var, iy1Var, zw2Var, gVar) == null) {
            HybridUbcFlow o = h53.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            px2 T2 = px2.T();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(T2, zw2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                kh2.c().b(yd2Var, iy1Var, zw2Var, gVar.b, gVar, false);
                yd2Var.attachActivity(activity);
                iy1Var.attachActivity(activity);
                lb2 U = T2.U();
                if (U == null) {
                    return;
                }
                c23 d2 = c23.d(d, T2.z());
                hi2.o(wp3.a(d2.c, d2.a, d2.b), iy1Var);
                g(U, d);
                vi3.E();
                p23.e(iy1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    h53.l(h);
                }
                vi3.F(true, zw2Var.T());
                er3 U2 = activity.U();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + U2);
                }
                if (U2 != null) {
                    U2.F(1);
                }
                bc3 K = bc3.K();
                if (K.E() && TextUtils.equals(K.getAppId(), zw2Var.H())) {
                    K.q().J(true);
                }
                ec2.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            px2 T2 = px2.T();
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                lb2 U = T2.U();
                if (U == null) {
                    c92.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    c92.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(U, str);
                    xr3.a().k();
                    er3 U2 = activity.U();
                    if (U2 != null) {
                        U2.F(1);
                    }
                    bc3 K = bc3.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    ec2.f(true);
                    return;
                }
            }
            c92.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(px2 px2Var, zw2 zw2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, px2Var, zw2Var, swanAppConfigData)) == null) {
            String b2 = px2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (zw2Var.o0()) {
                    b2 = swanAppConfigData.g(zw2Var.h0());
                } else {
                    b2 = px2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        zw2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            cc3 q = bc3.K().q();
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

    public static boolean f(lb2 lb2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, lb2Var)) == null) {
            if (lb2Var.k() >= 1 && (lb2Var.m() instanceof pb2)) {
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

    public static void g(lb2 lb2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, lb2Var, str) != null) || lb2Var == null) {
            return;
        }
        kb2.U3(null);
        px2 T2 = px2.T();
        lb2.b i = lb2Var.i("init");
        int i2 = lb2.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", c23.d(str, T2.z()), true).a();
    }

    public static void h(lb2 lb2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, lb2Var, str) == null) {
            if (lb2Var == null) {
                c92.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(lb2Var)) {
                c92.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                kb2.U3(null);
                lb2.b i = lb2Var.i("init");
                int i2 = lb2.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", c23.d(str, str), true).a();
                ur3.c().o(lb2Var.m());
            }
        }
    }

    public static void i(yd2 yd2Var, iy1 iy1Var, zw2 zw2Var, yu2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, yd2Var, iy1Var, zw2Var, gVar) == null) {
            if (!b83.H() && da2.e() != 2) {
                if (b83.D()) {
                    n92.k().q(yd2Var, iy1Var, zw2Var, gVar);
                    return;
                } else {
                    a(yd2Var, iy1Var, zw2Var, gVar);
                    return;
                }
            }
            c92.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            da2 da2Var = new da2(jv2.c());
            gb3.a aVar = new gb3.a(bc3.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f017c);
            aVar.v(R.string.obfuscated_res_0x7f0f016b);
            aVar.n(new kr3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f016a, new a(da2Var, yd2Var, iy1Var, zw2Var, gVar));
            gb3 X = aVar.X();
            HybridUbcFlow o = h53.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            da2Var.f(new b(yd2Var, iy1Var, zw2Var, gVar, X));
            da2Var.h();
        }
    }
}
