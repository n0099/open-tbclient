package com.baidu.tieba;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.payment.PaymentManager;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerImpl;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.ub2;
import com.baidu.tieba.w43;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public class x42 extends v42 implements w43.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean W0;
    public static final int X0;
    public static String Y0;
    public static pv2 Z0;
    public static String a1;
    public static String b1;
    public transient /* synthetic */ FieldHolder $fh;
    public vb3 G0;
    public pv2 H0;
    public pv2 I0;
    public Map<String, wr1> J0;
    public FrameLayout K0;
    public wr1 L0;
    public bh3 M0;
    public w43 N0;
    public View O0;
    public e63 P0;
    public int Q0;
    public c72 R0;
    public uq1 S0;
    public boolean T0;
    public boolean U0;
    public boolean V0;

    @Override // com.baidu.tieba.v42
    public boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class e implements ik3<pa3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x42 a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.a.U0 = false;
                this.a.a.I2(true, false);
            }
        }

        public e(x42 x42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(pa3 pa3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pa3Var) == null) && pa3Var != null && !pa3Var.d && pa3Var.j == 1) {
                jj3.e0(new a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x42 a;

        public a(x42 x42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x42Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.S0 = wo2.Q();
                uq1 uq1Var = this.a.S0;
                x42 x42Var = this.a;
                uq1Var.a(x42Var.b0, x42Var.d0, x42Var.s());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements SwanAppActionBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x42 a;

        public b(x42 x42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x42Var;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void onDoubleClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String a = this.a.L0.a();
                vf2 vf2Var = new vf2();
                vf2Var.c = wk3.a(a, "scrollViewBackToTop");
                cr2.V().n(a, vf2Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x42 a;

        public c(x42 x42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x42Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.q3();
        }
    }

    /* loaded from: classes8.dex */
    public class d implements ub2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ x42 f;

        public d(x42 x42Var, ub2.e eVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x42Var, eVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = x42Var;
            this.a = eVar;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [com.baidu.tieba.xr1] */
        @Override // com.baidu.tieba.ub2.f
        public void onReady() {
            String str;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gc2 gc2Var = new gc2();
                gc2Var.i = this.a.a.H();
                if (!TextUtils.isEmpty(this.b)) {
                    vy2.e(this.a, this.b);
                }
                String b = h93.b(this.c);
                gc2Var.a = this.d;
                if (TextUtils.isEmpty(this.e)) {
                    str = this.c;
                } else {
                    str = this.c + "?" + this.e;
                }
                gc2Var.b = str;
                if (p53.c0() != null) {
                    gc2Var.c = p53.c0().e0(b);
                    gc2Var.f = p53.c0().Y(b);
                }
                gc2Var.k = dc2.c(p53.M(), gc2Var.b);
                gc2Var.d = cr2.V().f(b).g;
                gc2Var.e = String.valueOf(m22.a());
                if (!x42.W0 && !cr2.V().O()) {
                    z = false;
                } else {
                    z = true;
                }
                gc2Var.g = z;
                if (o13.H()) {
                    gc2Var.j = s22.d();
                }
                if (!TextUtils.isEmpty(this.b)) {
                    String str2 = this.b;
                    gc2Var.h = str2;
                    uy2.q("route", str2).F(new UbcFlowEvent("slave_dispatch_start"));
                }
                wi3.d();
                this.a.a.getWebView().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.c);
                this.a.a.P(gc2Var.b);
                cr2.V().n(this.a.a.a(), gc2.a(gc2Var));
                if (hc2.b()) {
                    hc2 hc2Var = new hc2();
                    hc2Var.a = this.a.a.a();
                    cr2.V().v(hc2.a(hc2Var));
                }
                zb3.F(this.a.a.a(), gc2Var.b);
                if (x42.W0) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + gc2Var.toString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements c72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x42 a;

        public f(x42 x42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x42Var;
        }

        @Override // com.baidu.tieba.c72
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIIII(1048576, this, i, i2, i3, i4) != null) {
                return;
            }
            this.a.f4(i2);
        }
    }

    /* loaded from: classes8.dex */
    public class g implements e72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x42 a;

        public g(x42 x42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x42Var;
        }

        @Override // com.baidu.tieba.e72
        public void a(zr1 zr1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, zr1Var) == null) && zr1Var != null) {
                zr1Var.r(this.a.R0);
                zr1Var.V(this.a.F3());
                dw2.e().a(zr1Var);
            }
        }

        @Override // com.baidu.tieba.e72
        public void b(zr1 zr1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zr1Var) == null) && zr1Var != null) {
                zr1Var.R(this.a.R0);
                dw2.e().b(zr1Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h extends a72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x42 c;

        public h(x42 x42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = x42Var;
        }

        @Override // com.baidu.tieba.a72, com.baidu.tieba.d72
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.c.C2(str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-337199442, "Lcom/baidu/tieba/x42$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-337199442, "Lcom/baidu/tieba/x42$i;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (a < 0) {
                    wo2.g0().getSwitch("swan_app_fragment_destroy_switch", 1);
                    a = 1;
                }
                if (x42.W0) {
                    Log.d("SwanAppFragment", "getFragmentDestroySwitch:" + a);
                }
                return a;
            }
            return invokeV.intValue;
        }

        public static boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (a() > 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948250323, "Lcom/baidu/tieba/x42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948250323, "Lcom/baidu/tieba/x42;");
                return;
            }
        }
        W0 = am1.a;
        X0 = gj3.g(149.0f);
        Y0 = "-1";
        a1 = "-1";
    }

    public String A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            wr1 wr1Var = this.L0;
            if (wr1Var != null) {
                return wr1Var.a();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.C0();
            this.C0.a();
            if (i.b()) {
                jj3.q().postAtFrontOfQueue(new c(this));
            } else {
                q3();
            }
        }
    }

    @Nullable
    public bh3 C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.M0;
        }
        return (bh3) invokeV.objValue;
    }

    public FrameLayout E3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.K0;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v42, com.baidu.swan.support.v4.app.Fragment
    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.F0();
        }
    }

    public final a72 F3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return new h(this);
        }
        return (a72) invokeV.objValue;
    }

    public final e72 G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return new g(this);
        }
        return (e72) invokeV.objValue;
    }

    public final void H3() {
        sm2 C0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            wr1 v3 = v3();
            if ((v3 instanceof SwanAppWebViewManager) && (C0 = ((SwanAppWebViewManager) v3).C0()) != null) {
                C0.d();
            }
        }
    }

    public boolean K3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            bh3 bh3Var = this.M0;
            if (bh3Var == null) {
                return false;
            }
            return bh3Var.p();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.v42
    public e63 M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.P0;
        }
        return (e63) invokeV.objValue;
    }

    public final boolean M3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            e63 e63Var = this.P0;
            if (e63Var != null && e63Var.h) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean N3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            e63 e63Var = this.P0;
            if (e63Var != null) {
                return TextUtils.equals(e63Var.j, ExceptionHandlerImpl.KEY_CUSTOM);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean Q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            SwanAppConfigData t = cr2.V().t();
            if (t != null && !TextUtils.equals(t.f(), this.H0.e())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public PullToRefreshBaseWebView e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            wr1 wr1Var = this.L0;
            if (wr1Var != null) {
                return wr1Var.e0();
            }
            return null;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    public void g4() {
        qv2 qv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048616, this) != null) || (qv2Var = this.d0) == null) {
            return;
        }
        qv2Var.n();
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.G0 = ic3.c("805");
        }
    }

    public final void m3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            o53.K().q().f0().e("mapp_i_custom_navigation_bar", new e(this));
        }
    }

    @Override // com.baidu.tieba.v42, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onPause();
            d1();
        }
    }

    @Override // com.baidu.tieba.v42, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onResume();
            g1();
            z3(false);
        }
    }

    public void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.P0.j = "default";
            B1();
            U3();
        }
    }

    @NonNull
    public pv2 t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.H0;
        }
        return (pv2) invokeV.objValue;
    }

    public wr1 v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.L0;
        }
        return (wr1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v42
    public void w2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            super.w2();
            U3();
            if (this.V0) {
                a4();
            }
        }
    }

    public final int w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            if (k2()) {
                if (Q3()) {
                    return 18;
                }
                return 17;
            } else if (Q3()) {
                return 12;
            } else {
                return 15;
            }
        }
        return invokeV.intValue;
    }

    @Nullable
    public pv2 y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.I0;
        }
        return (pv2) invokeV.objValue;
    }

    public x42() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.H0 = new pv2();
        this.J0 = new TreeMap();
        this.Q0 = 0;
        this.T0 = false;
        this.U0 = false;
        this.V0 = false;
    }

    private void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (h0()) {
                pause();
            }
            if (W0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.L0.a())));
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.E0();
            Map<String, wr1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (wr1 wr1Var : this.J0.values()) {
                    if (wr1Var != null) {
                        wr1Var.b0();
                    }
                }
            } else {
                wr1 wr1Var2 = this.L0;
                if (wr1Var2 != null) {
                    wr1Var2.b0();
                }
            }
            H3();
        }
    }

    public final boolean L3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            SwanAppConfigData t = cr2.V().t();
            boolean z = false;
            if (t == null) {
                return false;
            }
            return !((TextUtils.equals(t.f(), this.H0.a) || t.r(this.H0.a)) ? true : true);
        }
        return invokeV.booleanValue;
    }

    public final boolean P3() {
        InterceptResult invokeV;
        boolean z;
        SwanAppConfigData t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            y42 S1 = S1();
            if (S1 == null) {
                return false;
            }
            e63 e63Var = this.P0;
            if (e63Var != null && e63Var.k) {
                z = true;
            } else {
                z = false;
            }
            if (z || (t = cr2.V().t()) == null) {
                return false;
            }
            return !O3(S1, t);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.w43.a
    public w43 getFloatLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.N0 == null) {
                if (this.O0 == null) {
                    return null;
                }
                this.N0 = new w43(this, (LinearLayout) this.O0.findViewById(R.id.obfuscated_res_0x7f09018a), P1().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070160));
            }
            return this.N0;
        }
        return (w43) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v42
    public boolean l2() {
        InterceptResult invokeV;
        SwanAppConfigData t;
        qv2 qv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            cr2 V = cr2.V();
            if (V == null || (t = V.t()) == null || !t.n() || (qv2Var = this.d0) == null) {
                return false;
            }
            return t.r(qv2Var.i());
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.v42
    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            wr1 wr1Var = this.L0;
            if (wr1Var != null) {
                wr1Var.Q();
            }
            J3();
            x3(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(nc2.n(o53.K().getAppId()));
            }
            this.g0.t(wo2.M().a(), N1(), this.h0, false);
        }
    }

    public static x42 T3(qv2 qv2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, qv2Var)) == null) {
            x42 x42Var = new x42();
            if (qv2Var != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", qv2Var.m());
                x42Var.n1(bundle);
            }
            return x42Var;
        }
        return (x42) invokeL.objValue;
    }

    public static void b4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            b1 = str;
        }
    }

    @Override // com.baidu.tieba.v42
    public boolean A2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            boolean A2 = super.A2(i2);
            U3();
            return A2;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.v42
    public void C1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (!e63.f(this.P0)) {
                super.C1(i2);
                return;
            }
            boolean z = true;
            if (!N3()) {
                z = true ^ yi3.h(this.c0);
            }
            D1(i2, z);
            U3();
        }
    }

    public String D3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (this.J0.containsKey(str)) {
                return this.J0.get(str).a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final boolean R3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            if (this.J0.isEmpty() || this.J0.get(str) == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void S3(tc3 tc3Var) {
        vb3 vb3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, tc3Var) == null) && (vb3Var = this.G0) != null) {
            ic3.i(vb3Var, tc3Var);
            this.G0 = null;
        }
    }

    public void Y3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.V0 = z;
        }
    }

    public final void e4(wr1 wr1Var) {
        c72 c72Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048614, this, wr1Var) != null) || (c72Var = this.R0) == null || wr1Var == null) {
            return;
        }
        wr1Var.R(c72Var);
        if (wr1Var.j() != null) {
            wr1Var.R(this.R0);
        }
    }

    @Override // com.baidu.tieba.v42, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, motionEvent)) == null) {
            if (g2() && this.L0.isSlidable(motionEvent)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void k3(wr1 wr1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048621, this, wr1Var) != null) || wr1Var == null) {
            return;
        }
        c72 c72Var = this.R0;
        if (c72Var != null) {
            wr1Var.r(c72Var);
        }
        wr1Var.W(G3());
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, activity) == null) {
            super.v0(activity);
            if (W0) {
                Log.d("SwanAppFragment", "onAttach() obj: " + this);
            }
        }
    }

    public static void Z3(pv2 pv2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, pv2Var) == null) {
            try {
                if (W0) {
                    Log.d("SwanAppFragment", "setLastPageParams =" + pv2Var);
                }
                if (pv2Var == null) {
                    Z0 = null;
                } else {
                    Z0 = (pv2) pv2Var.clone();
                }
            } catch (Exception e2) {
                if (W0) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void I3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, str) != null) || N3()) {
            return;
        }
        cr2 V = cr2.V();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (V.f(str).h && this.R0 == null) {
            this.R0 = new f(this);
        }
    }

    @Override // com.baidu.tieba.v42, com.baidu.swan.support.v4.app.Fragment
    public void q1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048632, this, z) != null) || !n0()) {
            return;
        }
        super.q1(z);
        if (W0) {
            Log.d("SwanAppFragment", "setUserVisibleHint isVisibleToUser: " + z);
        }
        if (z) {
            resume();
            z3(false);
            return;
        }
        pause();
    }

    public final void x3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048644, this, z) == null) && wo2.K().k(z, 2)) {
            nv2.l(s(), this.g0, this.f0, p53.c0().X().g0().paNumber);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, bundle) == null) {
            super.y0(bundle);
            V3();
            if (W0) {
                Log.d("SwanAppFragment", "onCreate() obj: " + this);
            }
            ji3.j(new a(this), "SwanAppPageHistory");
            ty2.a("route", "fragment create.");
        }
    }

    private void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (h0()) {
                resume();
            }
            wb4 wb4Var = this.g0;
            if (wb4Var != null && wb4Var.i()) {
                this.g0.A(wo2.M().a());
            }
            if (W0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.L0.a())));
            }
        }
    }

    public List<String> B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, wr1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, wr1> entry : this.J0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(entry.getValue().a());
                    }
                }
            }
            wr1 wr1Var = this.L0;
            if (wr1Var != null) {
                String a2 = wr1Var.a();
                if (!arrayList.contains(a2)) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v42
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (getFloatLayer() != null && getFloatLayer().f() && getFloatLayer().g()) {
                return true;
            }
            if ((getFloatLayer() != null && getFloatLayer().d()) || PaymentManager.k()) {
                return true;
            }
            wr1 wr1Var = this.L0;
            if (wr1Var != null) {
                if (os2.g(wr1Var.a())) {
                    return true;
                }
                return this.L0.G();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @DebugTrace
    public void J3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            FragmentActivity m = m();
            if (this.h0 == null) {
                this.h0 = new SwanAppMenuHeaderView(s());
            }
            if (m != null && this.g0 == null) {
                this.g0 = new wb4(m, this.f0, w3(), wo2.K(), new yk3());
                new fv2(this.g0, this, this.h0).z();
                if (lv2.e()) {
                    this.g0.l(50);
                }
            }
        }
    }

    @Override // com.baidu.tieba.v42
    public void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (this.L0 == null) {
                if (W0) {
                    Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.L0.a());
            zr1 j = this.L0.j();
            if (j != null) {
                hashMap.put("webViewUrl", j.getCurrentPageUrl());
            }
            cr2.V().v(new qf2("sharebtn", hashMap));
        }
    }

    @Override // com.baidu.tieba.v42
    public void p2() {
        qv2 T1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            W1();
            sc3 sc3Var = new sc3();
            sc3Var.e = "gohome";
            sc3Var.c = "bar";
            x42 J = cr2.V().J();
            if (J == null) {
                T1 = null;
            } else {
                T1 = J.T1();
            }
            if (T1 != null && !TextUtils.isEmpty(T1.i())) {
                sc3Var.a("page", T1.i());
            }
            G1(sc3Var);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.xr1] */
    @NonNull
    public Pair<Integer, Integer> u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            wr1 wr1Var = this.L0;
            if (wr1Var == null) {
                return new Pair<>(0, 0);
            }
            View currentWebView = wr1Var.getWebView().getCurrentWebView();
            if (currentWebView == null) {
                return new Pair<>(0, 0);
            }
            return new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater, viewGroup, bundle)) == null) {
            ty2.a("route", "fragment onCreateView.");
            View b2 = zz2.a().b(R.layout.obfuscated_res_0x7f0d00ac, viewGroup, false);
            this.K0 = (FrameLayout) b2.findViewById(R.id.obfuscated_res_0x7f09018b);
            b2(b2);
            a3(b2);
            this.M0 = new bh3(this);
            o3(b2);
            if (!lv2.e() && !lv2.f()) {
                kv2.b(this.L0.a(), String.valueOf(lv2.d()), String.valueOf(lv2.a(lv2.b())));
            }
            if (a2()) {
                b2 = d2(b2);
            }
            this.O0 = J1(b2, this);
            N2(this.L0.y());
            dw2.e().m();
            return this.O0;
        }
        return (View) invokeLLL.objValue;
    }

    public final boolean O3(y42 y42Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, y42Var, swanAppConfigData)) == null) {
            v42 j = y42Var.j(0);
            if (j == null || !(j instanceof x42)) {
                return false;
            }
            String e2 = ((x42) j).t3().e();
            if (!swanAppConfigData.r(e2) && !TextUtils.equals(swanAppConfigData.f(), e2)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void U3() {
        int i2;
        e63 e63Var;
        xr1 xr1Var;
        TextView centerTitleView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048604, this) != null) || this.f0 == null) {
            return;
        }
        int i3 = 1;
        boolean z = false;
        if (N3()) {
            I2(true, this.U0);
            i2 = 0;
        } else if (M3()) {
            I2(false, false);
            wr1 wr1Var = this.L0;
            if (wr1Var != null) {
                if (wr1Var.j() != null) {
                    xr1Var = this.L0.j().getWebView();
                } else {
                    xr1Var = this.L0.getWebView();
                }
                if (xr1Var != null) {
                    i2 = xr1Var.getWebViewScrollY();
                    e63Var = this.P0;
                    if (e63Var != null && e63Var.i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            e63Var = this.P0;
            if (e63Var != null) {
                i3 = 0;
            }
        } else {
            I2(false, false);
            i2 = X0 + this.Q0;
            centerTitleView = this.f0.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i3);
            }
            f4(i2);
            h4(z);
        }
        z = true;
        centerTitleView = this.f0.getCenterTitleView();
        if (centerTitleView != null) {
        }
        f4(i2);
        h4(z);
    }

    public final void a4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "setting immersive portrait fullscreen video");
            }
            wh3.h();
            if (this.c0.getWindow() != null) {
                this.c0.getWindow().getDecorView().setSystemUiVisibility(5376);
            }
            View b2 = l43.b();
            if (b2 != null) {
                b2.setVisibility(0);
                b2.findViewById(R.id.obfuscated_res_0x7f0925cf).setVisibility(8);
            }
            SwanAppActionBar Q1 = Q1();
            if (Q1 != null) {
                Q1.setRightMenuStyle();
                Q1.setRightZoneImmersiveStyle();
                Q1.setBackgroundColor(0);
            }
            View i0 = i0();
            if (i0 != null) {
                i0.findViewById(R.id.obfuscated_res_0x7f091131).setBackgroundColor(0);
                FrameLayout frameLayout = (FrameLayout) i0.findViewById(R.id.obfuscated_res_0x7f09018b);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams);
            }
        }
    }

    public final void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            Map<String, wr1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (wr1 wr1Var : this.J0.values()) {
                    if (wr1Var != null) {
                        e4(wr1Var);
                        wr1Var.destroy();
                    }
                }
                this.J0.clear();
            } else {
                wr1 wr1Var2 = this.L0;
                if (wr1Var2 != null) {
                    e4(wr1Var2);
                    this.L0.destroy();
                }
            }
            this.L0 = null;
            if (W0) {
                Log.d("SwanAppFragment", "onDestroy() obj: " + this);
            }
            if (!this.T0) {
                ub2.n(cr2.V().getActivity());
            }
        }
    }

    public void resume() {
        boolean z;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            boolean z2 = false;
            if (this.L0 == null) {
                z = true;
            } else {
                z = false;
            }
            String str = "";
            if (z) {
                a2 = "";
            } else {
                a2 = this.L0.a();
            }
            if (W0) {
                Log.d("SwanAppFragment", "resume() wvID: " + a2);
            }
            if (!z) {
                E2((g2() || L3()) ? true : true);
                this.L0.onResume();
                X3();
                W3("onShow");
                dw2.e().i(true);
            }
            p22.i("SwanApp", "onShow");
            os2.i(a2, true);
            if (p22.f()) {
                k42.b();
            }
            if (p53.c0() != null) {
                str = p53.c0().P();
            }
            wo2.H().e(str);
        }
    }

    public final void V3() {
        Bundle p;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048605, this) != null) || (p = p()) == null) {
            return;
        }
        this.I0 = Z0;
        if (W0) {
            Log.d("SwanAppFragment", "restoreArguments sPrePageParams=" + this.I0);
        }
        qv2 g2 = qv2.g(p.getString("ai_apps_param"));
        this.d0 = g2;
        if (g2 == null) {
            pv2 pv2Var = this.H0;
            pv2Var.a = "";
            pv2Var.b = "";
            pv2Var.e = "";
            pv2Var.f = "";
        } else {
            this.H0.a = g2.i();
            this.H0.b = this.d0.j();
            this.H0.e = this.d0.l();
            this.H0.f = this.d0.k();
        }
        pv2 pv2Var2 = this.H0;
        pv2Var2.d = h93.b(pv2Var2.e());
        e63 f2 = cr2.V().f(this.H0.g());
        this.P0 = f2;
        if (f2.p) {
            this.P0 = cr2.V().j(this.H0.e());
        }
        if (this.E0) {
            e63 e63Var = this.P0;
            e63Var.f = false;
            e63Var.h = true;
            e63Var.p = true;
        }
        this.Q0 = P1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070160);
    }

    public final void X3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (TextUtils.equals(a1, this.L0.a()) && !TextUtils.equals(b1, "switchTab")) {
                return;
            }
            int o = this.M0.o(t3().g());
            tf2 tf2Var = new tf2();
            tf2Var.c = a1;
            tf2Var.d = this.L0.a();
            tf2Var.e = b1;
            tf2Var.f = this.H0.a;
            tf2Var.g = String.valueOf(o);
            b1 = "";
            if (W0) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + tf2Var.c + " ,toId: " + tf2Var.d + " ,RouteType: " + tf2Var.e + " page:" + tf2Var.f + ",TabIndex: " + tf2Var.g);
            }
            cr2.V().v(tf2Var);
            a1 = this.L0.a();
        }
    }

    public void pause() {
        boolean z;
        String a2;
        PullToRefreshBaseWebView e0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            if (this.L0 == null) {
                z = true;
            } else {
                z = false;
            }
            String str = "";
            if (z) {
                a2 = "";
            } else {
                a2 = this.L0.a();
            }
            if (W0) {
                Log.d("SwanAppFragment", "pause() wvID: " + a2);
            }
            if (!z) {
                this.L0.onPause();
                W3("onHide");
                dw2.e().i(false);
            }
            if (getFloatLayer() != null && !getFloatLayer().d() && (!getFloatLayer().g() || getFloatLayer().k())) {
                getFloatLayer().h();
            }
            p22.i("SwanApp", "onHide");
            os2.i(a2, false);
            if (!z && (e0 = this.L0.e0()) != null) {
                e0.w(false);
            }
            if (p53.c0() != null) {
                str = p53.c0().P();
            }
            wo2.H().f(str);
        }
    }

    public final void W3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.L0.a());
            rf2 rf2Var = new rf2(hashMap);
            if (W0) {
                Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.L0.a());
            }
            cr2.V().v(rf2Var);
        }
    }

    public void c4(pv2 pv2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, pv2Var) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "switchTab pageParam: " + pv2Var);
            }
            if (this.M0.o(t3().g()) == this.M0.o(pv2Var.g())) {
                pv2 pv2Var2 = this.H0;
                pv2Var2.e = pv2Var.e;
                pv2Var2.f = pv2Var.f;
                return;
            }
            this.M0.E(pv2Var.g());
            onPause();
            s3(pv2Var, "");
        }
    }

    public final void h4(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            int i3 = 0;
            if (z) {
                qk3 qk3Var = this.u0;
                if (qk3Var != null && qk3Var.i()) {
                    i2 = gj3.t();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.K0.getLayoutParams();
                    layoutParams.topMargin = i3;
                    this.K0.setLayoutParams(layoutParams);
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.e0.getLayoutParams();
                    layoutParams2.topMargin = i2;
                    this.e0.setLayoutParams(layoutParams2);
                }
            } else {
                i3 = P1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070160);
            }
            i2 = 0;
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.K0.getLayoutParams();
            layoutParams3.topMargin = i3;
            this.K0.setLayoutParams(layoutParams3);
            FrameLayout.LayoutParams layoutParams22 = (FrameLayout.LayoutParams) this.e0.getLayoutParams();
            layoutParams22.topMargin = i2;
            this.e0.setLayoutParams(layoutParams22);
        }
    }

    public final void z3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            if (wo2.K().k(z, 1)) {
                nv2.k(s(), this.f0, p53.c0().X().g0().paNumber);
            } else if (p53.c0() == null) {
            } else {
                nv2.o(this.f0, p53.c0().V().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    @Override // com.baidu.tieba.v42
    public void b2(View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, view2) == null) {
            super.b2(view2);
            boolean z2 = false;
            if (!g2() && !L3()) {
                z = false;
            } else {
                z = true;
            }
            E2(z);
            if (P3()) {
                m2();
            }
            U3();
            this.f0.setOnDoubleClickListener(new b(this));
            if (!zb3.i()) {
                zb3.d(o53.K().q().X());
            }
            if (N3() && L3()) {
                z2 = true;
            }
            this.U0 = z2;
            if (z2) {
                m3();
            }
        }
    }

    public final void d4(String str, pv2 pv2Var) {
        wr1 wr1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048612, this, str, pv2Var) == null) && this.L0 != (wr1Var = this.J0.get(str)) && wr1Var != null) {
            e63 f2 = cr2.V().f(str);
            wr1Var.x(this.K0, f2);
            if (!wr1Var.c()) {
                wr1Var.M(this.K0, f2);
            }
            wr1Var.A(0);
            wr1 wr1Var2 = this.L0;
            if (wr1Var2 != null) {
                wr1Var2.A(8);
            }
            this.L0 = wr1Var;
            pv2 pv2Var2 = this.H0;
            pv2Var2.e = pv2Var.e;
            pv2Var2.f = pv2Var.f;
            wr1Var.g(pv2Var2);
        }
    }

    public final void f4(int i2) {
        TextView centerTitleView;
        View e2;
        Drawable background;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            float f2 = 1.0f;
            float f3 = (i2 - X0) * 1.0f;
            int i3 = this.Q0;
            if (i3 == 0) {
                i3 = 1;
            }
            float f4 = f3 / i3;
            if (f4 <= 0.0f) {
                f2 = 0.0f;
            } else if (f4 < 1.0f) {
                f2 = f4;
            }
            int i4 = (int) (255.0f * f2);
            if (W0 && i4 != 0 && i4 != 255) {
                Log.d("SwanAppFragment", "update bar transparent degree: " + f2 + ZeusCrashHandler.NAME_SEPERATOR + i4);
            }
            qk3 qk3Var = this.u0;
            if (qk3Var != null && qk3Var.i() && (e2 = this.u0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.f0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            e63 e63Var = this.P0;
            if (e63Var != null && e63Var.i && (centerTitleView = this.f0.getCenterTitleView()) != null) {
                centerTitleView.setAlpha(f2);
            }
            Drawable background3 = this.i0.getBackground();
            if (background3 != null) {
                background3.setAlpha(i4);
            }
        }
    }

    public final void o3(View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, view2) == null) {
            ty2.a("route", "createSlaveWebView start.");
            String h2 = this.d0.h();
            String j = this.d0.j();
            String i2 = this.d0.i();
            String a2 = jj3.a(h2, i2, j);
            this.L0 = ub2.h(a2);
            if (W0) {
                StringBuilder sb = new StringBuilder();
                sb.append("pageUrl: ");
                sb.append(a2);
                sb.append(" is load: ");
                if (this.L0 != null) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                Log.d("SwanAppFragment", sb.toString());
            }
            if (this.L0 == null) {
                if (W0) {
                    Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
                }
                this.L0 = n3(h2, i2, j, "");
            }
            this.L0.g(this.H0);
            e63 f2 = cr2.V().f(i2);
            this.L0.x(this.K0, f2);
            this.L0.M(this.K0, f2);
            I3(i2);
            k3(this.L0);
            if (l2()) {
                this.J0.put(i2, this.L0);
                this.M0.f(view2, s(), i2);
            }
            ty2.a("route", "createSlaveWebView end.");
            l3();
        }
    }

    public final wr1 n3(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048625, this, str, str2, str3, str4)) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad start.");
            }
            ub2.e f2 = ub2.f(m(), zb2.c(str2));
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = uy2.q("route", str4);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                if (f2.b) {
                    str5 = "1";
                } else {
                    str5 = "0";
                }
                q.D("preload", str5);
            }
            if (W0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + f2);
            }
            ub2.q(f2, new d(this, f2, str4, str2, str, str3));
            if (W0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad end.");
            }
            return f2.a;
        }
        return (wr1) invokeLLLL.objValue;
    }

    public final void p3(pv2 pv2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048630, this, pv2Var, str) == null) && this.J0.get(pv2Var.d) == null) {
            String a2 = jj3.a(pv2Var.c, pv2Var.a, pv2Var.b);
            wr1 h2 = ub2.h(a2);
            if (h2 != null) {
                if (W0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + a2);
                }
                this.J0.put(pv2Var.a, h2);
            } else {
                if (W0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                h2 = n3(pv2Var.c, pv2Var.a, pv2Var.b, str);
                this.J0.put(pv2Var.a, h2);
            }
            I3(pv2Var.a);
            k3(h2);
        }
    }

    public void s3(pv2 pv2Var, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048637, this, pv2Var, str) == null) {
            Z3(this.H0);
            this.I0 = Z0;
            if (W0) {
                Log.d("SwanAppFragment", "doSwitchTab mPrePageParams=" + this.I0);
            }
            String str3 = pv2Var.a;
            String str4 = pv2Var.d;
            cr2 V = cr2.V();
            String str5 = "";
            if (TextUtils.isEmpty(str4)) {
                str2 = "";
            } else {
                str2 = str4;
            }
            e63 f2 = V.f(str2);
            pv2 pv2Var2 = this.H0;
            pv2Var2.a = str3;
            if (pv2Var != null) {
                str5 = pv2Var.f();
            }
            pv2Var2.b = str5;
            this.H0.d = str4;
            this.P0 = f2;
            boolean z = !R3(str4);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    vy2.c(7, str);
                } else {
                    vy2.c(6, str);
                }
            }
            if (!z) {
                d4(str4, pv2Var);
            } else {
                p3(pv2Var, str);
                d4(str3, pv2Var);
            }
            if (!TextUtils.isEmpty(str)) {
                uy2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                vy2.a(str, pv2Var);
            }
            C2(f2.b);
            J2(SwanAppConfigData.t(f2.c));
            A2(f2.a);
            U3();
            g4();
            p22.i("SwanAppFragment", "switch tab title: " + f2.b + " page:" + str3);
        }
    }
}
