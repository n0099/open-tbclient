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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.payment.PaymentManager;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.r92;
import com.baidu.tieba.t23;
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
/* loaded from: classes6.dex */
public class u22 extends s22 implements t23.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean V0;
    public static final int W0;
    public static String X0;
    public static mt2 Y0;
    public static String Z0;
    public static String a1;
    public transient /* synthetic */ FieldHolder $fh;
    public s93 F0;
    public mt2 G0;
    public mt2 H0;
    public Map I0;
    public FrameLayout J0;
    public sp1 K0;
    public ye3 L0;
    public t23 M0;
    public View N0;
    public b43 O0;
    public int P0;
    public z42 Q0;
    public qo1 R0;
    public boolean S0;
    public boolean T0;
    public boolean U0;

    @Override // com.baidu.tieba.s22
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class e implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u22 a;

        /* loaded from: classes6.dex */
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
                this.a.a.T0 = false;
                this.a.a.B2(true, false);
            }
        }

        public e(u22 u22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(m83 m83Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m83Var) == null) && m83Var != null && !m83Var.d && m83Var.j == 1) {
                gh3.e0(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u22 a;

        public a(u22 u22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u22Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.R0 = tm2.Q();
                qo1 qo1Var = this.a.R0;
                u22 u22Var = this.a;
                qo1Var.a(u22Var.b0, u22Var.d0, u22Var.getContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements SwanAppActionBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u22 a;

        public b(u22 u22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u22Var;
        }

        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String a = this.a.K0.a();
                sd2 sd2Var = new sd2();
                sd2Var.c = ti3.a(a, "scrollViewBackToTop");
                zo2.U().m(a, sd2Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u22 a;

        public c(u22 u22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u22Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.j3();
        }
    }

    /* loaded from: classes6.dex */
    public class d implements r92.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r92.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ u22 f;

        public d(u22 u22Var, r92.e eVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u22Var, eVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = u22Var;
            this.a = eVar;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        @Override // com.baidu.tieba.r92.f
        public void onReady() {
            String str;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                da2 da2Var = new da2();
                da2Var.i = this.a.a.K();
                if (!TextUtils.isEmpty(this.b)) {
                    sw2.e(this.a, this.b);
                }
                String b = e73.b(this.c);
                da2Var.a = this.d;
                if (TextUtils.isEmpty(this.e)) {
                    str = this.c;
                } else {
                    str = this.c + "?" + this.e;
                }
                da2Var.b = str;
                if (m33.b0() != null) {
                    da2Var.c = m33.b0().d0(b);
                    da2Var.f = m33.b0().X(b);
                }
                da2Var.k = aa2.c(m33.M(), da2Var.b);
                da2Var.d = zo2.U().f(b).g;
                da2Var.e = String.valueOf(j02.a());
                if (!u22.V0 && !zo2.U().N()) {
                    z = false;
                } else {
                    z = true;
                }
                da2Var.g = z;
                if (lz2.H()) {
                    da2Var.j = p02.d();
                }
                if (!TextUtils.isEmpty(this.b)) {
                    String str2 = this.b;
                    da2Var.h = str2;
                    rw2.q("route", str2).F(new UbcFlowEvent("slave_dispatch_start"));
                }
                tg3.d();
                this.a.a.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.c);
                this.a.a.R(da2Var.b);
                zo2.U().m(this.a.a.a(), da2.a(da2Var));
                if (ea2.b()) {
                    ea2 ea2Var = new ea2();
                    ea2Var.a = this.a.a.a();
                    zo2.U().u(ea2.a(ea2Var));
                }
                w93.F(this.a.a.a(), da2Var.b);
                if (u22.V0) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + da2Var.toString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements z42 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u22 a;

        public f(u22 u22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u22Var;
        }

        @Override // com.baidu.tieba.z42
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIIII(1048576, this, i, i2, i3, i4) != null) {
                return;
            }
            this.a.Y3(i2);
        }
    }

    /* loaded from: classes6.dex */
    public class g implements b52 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u22 a;

        public g(u22 u22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u22Var;
        }

        @Override // com.baidu.tieba.b52
        public void a(vp1 vp1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, vp1Var) == null) && vp1Var != null) {
                vp1Var.t(this.a.Q0);
                vp1Var.Y(this.a.y3());
                au2.e().a(vp1Var);
            }
        }

        @Override // com.baidu.tieba.b52
        public void b(vp1 vp1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vp1Var) == null) && vp1Var != null) {
                vp1Var.U(this.a.Q0);
                au2.e().b(vp1Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends x42 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u22 c;

        public h(u22 u22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u22Var;
        }

        @Override // com.baidu.tieba.x42, com.baidu.tieba.a52
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.c.v2(str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-424933937, "Lcom/baidu/tieba/u22$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-424933937, "Lcom/baidu/tieba/u22$i;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (a < 0) {
                    tm2.g0().getSwitch("swan_app_fragment_destroy_switch", 1);
                    a = 1;
                }
                if (u22.V0) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948159028, "Lcom/baidu/tieba/u22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948159028, "Lcom/baidu/tieba/u22;");
                return;
            }
        }
        V0 = wj1.a;
        W0 = dh3.g(149.0f);
        X0 = "-1";
        Z0 = "-1";
    }

    public final void A3() {
        pk2 F0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            sp1 o3 = o3();
            if ((o3 instanceof SwanAppWebViewManager) && (F0 = ((SwanAppWebViewManager) o3).F0()) != null) {
                F0.d();
            }
        }
    }

    @Override // com.baidu.tieba.s22, com.baidu.swan.support.v4.app.Fragment
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.B0();
        }
    }

    public boolean D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ye3 ye3Var = this.L0;
            if (ye3Var == null) {
                return false;
            }
            return ye3Var.p();
        }
        return invokeV.booleanValue;
    }

    public final boolean F3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            b43 b43Var = this.O0;
            if (b43Var != null && b43Var.h) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.s22
    public b43 G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.O0;
        }
        return (b43) invokeV.objValue;
    }

    public boolean G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            b43 b43Var = this.O0;
            if (b43Var != null) {
                return TextUtils.equals(b43Var.j, "custom");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            SwanAppConfigData s = zo2.U().s();
            if (s != null && !TextUtils.equals(s.f(), this.G0.e())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void Z3() {
        nt2 nt2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048604, this) != null) || (nt2Var = this.d0) == null) {
            return;
        }
        nt2Var.n();
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.F0 = fa3.c("805");
        }
    }

    public final void f3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            l33.K().q().e0().e("mapp_i_custom_navigation_bar", new e(this));
        }
    }

    public PullToRefreshBaseWebView h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            sp1 sp1Var = this.K0;
            if (sp1Var != null) {
                return sp1Var.h0();
            }
            return null;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    public void k3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.O0.j = "default";
            v1();
            N3();
        }
    }

    public mt2 m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.G0;
        }
        return (mt2) invokeV.objValue;
    }

    public sp1 o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.K0;
        }
        return (sp1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s22, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            super.onPause();
            b1();
        }
    }

    @Override // com.baidu.tieba.s22, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onResume();
            e1();
            s3(false);
        }
    }

    @Override // com.baidu.tieba.s22
    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.p2();
            N3();
            if (this.U0) {
                T3();
            }
        }
    }

    public final int p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            if (d2()) {
                if (J3()) {
                    return 18;
                }
                return 17;
            } else if (J3()) {
                return 12;
            } else {
                return 15;
            }
        }
        return invokeV.intValue;
    }

    public mt2 r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.H0;
        }
        return (mt2) invokeV.objValue;
    }

    public String t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            sp1 sp1Var = this.K0;
            if (sp1Var != null) {
                return sp1Var.a();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public ye3 v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.L0;
        }
        return (ye3) invokeV.objValue;
    }

    public FrameLayout x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.J0;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            super.y0();
            this.B0.a();
            if (i.b()) {
                gh3.q().postAtFrontOfQueue(new c(this));
            } else {
                j3();
            }
        }
    }

    public final x42 y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return new h(this);
        }
        return (x42) invokeV.objValue;
    }

    public final b52 z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return new g(this);
        }
        return (b52) invokeV.objValue;
    }

    public u22() {
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
        this.G0 = new mt2();
        this.I0 = new TreeMap();
        this.P0 = 0;
        this.S0 = false;
        this.T0 = false;
        this.U0 = false;
    }

    private void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if (U()) {
                pause();
            }
            if (V0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.K0.a())));
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.A0();
            Map map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (sp1 sp1Var : this.I0.values()) {
                    if (sp1Var != null) {
                        sp1Var.e0();
                    }
                }
            } else {
                sp1 sp1Var2 = this.K0;
                if (sp1Var2 != null) {
                    sp1Var2.e0();
                }
            }
            A3();
        }
    }

    public final boolean E3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            SwanAppConfigData s = zo2.U().s();
            boolean z = false;
            if (s == null) {
                return false;
            }
            return !((TextUtils.equals(s.f(), this.G0.a) || s.r(this.G0.a)) ? true : true);
        }
        return invokeV.booleanValue;
    }

    public final boolean I3() {
        InterceptResult invokeV;
        boolean z;
        SwanAppConfigData s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            v22 M1 = M1();
            if (M1 == null) {
                return false;
            }
            b43 b43Var = this.O0;
            if (b43Var != null && b43Var.k) {
                z = true;
            } else {
                z = false;
            }
            if (z || (s = zo2.U().s()) == null) {
                return false;
            }
            return !H3(M1, s);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.t23.a
    public t23 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.M0 == null) {
                if (this.N0 == null) {
                    return null;
                }
                this.M0 = new t23(this, (LinearLayout) this.N0.findViewById(R.id.obfuscated_res_0x7f09017c), J1().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070159));
            }
            return this.M0;
        }
        return (t23) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s22
    public boolean e2() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        nt2 nt2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            zo2 U = zo2.U();
            if (U == null || (s = U.s()) == null || !s.n() || (nt2Var = this.d0) == null) {
                return false;
            }
            return s.r(nt2Var.i());
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.s22
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            sp1 sp1Var = this.K0;
            if (sp1Var != null) {
                sp1Var.T();
            }
            C3();
            q3(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(ka2.n(l33.K().getAppId()));
            }
            this.g0.u(tm2.M().a(), H1(), this.h0, false);
        }
    }

    public static u22 M3(nt2 nt2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, nt2Var)) == null) {
            u22 u22Var = new u22();
            if (nt2Var != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", nt2Var.m());
                u22Var.j1(bundle);
            }
            return u22Var;
        }
        return (u22) invokeL.objValue;
    }

    public static void U3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            a1 = str;
        }
    }

    public final boolean K3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (this.I0.isEmpty() || this.I0.get(str) == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void L3(qa3 qa3Var) {
        s93 s93Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, qa3Var) == null) && (s93Var = this.F0) != null) {
            fa3.i(s93Var, qa3Var);
            this.F0 = null;
        }
    }

    public void R3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.U0 = z;
        }
    }

    public final void X3(sp1 sp1Var) {
        z42 z42Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048602, this, sp1Var) != null) || (z42Var = this.Q0) == null || sp1Var == null) {
            return;
        }
        sp1Var.U(z42Var);
        if (sp1Var.k() != null) {
            sp1Var.U(this.Q0);
        }
    }

    public final void d3(sp1 sp1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, sp1Var) != null) || sp1Var == null) {
            return;
        }
        z42 z42Var = this.Q0;
        if (z42Var != null) {
            sp1Var.t(z42Var);
        }
        sp1Var.a0(z3());
    }

    @Override // com.baidu.tieba.s22, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, motionEvent)) == null) {
            if (Z1() && this.K0.isSlidable(motionEvent)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void r0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, activity) == null) {
            super.r0(activity);
            if (V0) {
                Log.d("SwanAppFragment", "onAttach() obj: " + this);
            }
        }
    }

    @Override // com.baidu.tieba.s22
    public boolean t2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i2)) == null) {
            boolean t2 = super.t2(i2);
            N3();
            return t2;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.s22
    public void w1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
            if (!b43.f(this.O0)) {
                super.w1(i2);
                return;
            }
            boolean z = true;
            if (!G3()) {
                z = true ^ vg3.h(this.c0);
            }
            x1(i2, z);
            N3();
        }
    }

    public String w3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, str)) == null) {
            if (this.I0.containsKey(str)) {
                return ((sp1) this.I0.get(str)).a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void S3(mt2 mt2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, mt2Var) == null) {
            try {
                if (V0) {
                    Log.d("SwanAppFragment", "setLastPageParams =" + mt2Var);
                }
                if (mt2Var == null) {
                    Y0 = null;
                } else {
                    Y0 = (mt2) mt2Var.clone();
                }
            } catch (Exception e2) {
                if (V0) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void B3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, str) != null) || G3()) {
            return;
        }
        zo2 U = zo2.U();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (U.f(str).h && this.Q0 == null) {
            this.Q0 = new f(this);
        }
    }

    @Override // com.baidu.tieba.s22, com.baidu.swan.support.v4.app.Fragment
    public void m1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048622, this, z) != null) || !k0()) {
            return;
        }
        super.m1(z);
        if (V0) {
            Log.d("SwanAppFragment", "setUserVisibleHint isVisibleToUser: " + z);
        }
        if (z) {
            resume();
            s3(false);
            return;
        }
        pause();
    }

    public final void q3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048631, this, z) == null) && tm2.K().k(z, 2)) {
            kt2.l(getContext(), this.g0, this.f0, m33.b0().W().f0().paNumber);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void u0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, bundle) == null) {
            super.u0(bundle);
            O3();
            if (V0) {
                Log.d("SwanAppFragment", "onCreate() obj: " + this);
            }
            gg3.j(new a(this), "SwanAppPageHistory");
            qw2.a("route", "fragment create.");
        }
    }

    private void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if (U()) {
                resume();
            }
            t94 t94Var = this.g0;
            if (t94Var != null && t94Var.i()) {
                this.g0.B(tm2.M().a());
            }
            if (V0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.K0.a())));
            }
        }
    }

    public void C3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            FragmentActivity activity = getActivity();
            if (this.h0 == null) {
                this.h0 = new SwanAppMenuHeaderView(getContext());
            }
            if (activity != null && this.g0 == null) {
                this.g0 = new t94(activity, this.f0, p3(), tm2.K(), new vi3());
                new ct2(this.g0, this, this.h0).z();
                if (it2.e()) {
                    this.g0.l(50);
                }
            }
        }
    }

    @Override // com.baidu.tieba.s22
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (d() != null && d().e() && d().f()) {
                return true;
            }
            if ((d() != null && d().c()) || PaymentManager.k()) {
                return true;
            }
            sp1 sp1Var = this.K0;
            if (sp1Var != null) {
                if (lq2.g(sp1Var.a())) {
                    return true;
                }
                return this.K0.I();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.s22
    public void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.K0 == null) {
                if (V0) {
                    Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.K0.a());
            vp1 k = this.K0.k();
            if (k != null) {
                hashMap.put("webViewUrl", k.getCurrentPageUrl());
            }
            zo2.U().u(new nd2("sharebtn", hashMap));
        }
    }

    @Override // com.baidu.tieba.s22
    public void i2() {
        nt2 N1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            P1();
            pa3 pa3Var = new pa3();
            pa3Var.e = "gohome";
            pa3Var.c = "bar";
            u22 H = zo2.U().H();
            if (H == null) {
                N1 = null;
            } else {
                N1 = H.N1();
            }
            if (N1 != null && !TextUtils.isEmpty(N1.i())) {
                pa3Var.a("page", N1.i());
            }
            A1(pa3Var);
        }
    }

    public Pair n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            sp1 sp1Var = this.K0;
            if (sp1Var == null) {
                return new Pair(0, 0);
            }
            View currentWebView = sp1Var.r().getCurrentWebView();
            if (currentWebView == null) {
                return new Pair(0, 0);
            }
            return new Pair(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
        }
        return (Pair) invokeV.objValue;
    }

    public List u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Map map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : this.I0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(((sp1) entry.getValue()).a());
                    }
                }
            }
            sp1 sp1Var = this.K0;
            if (sp1Var != null) {
                String a2 = sp1Var.a();
                if (!arrayList.contains(a2)) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean H3(v22 v22Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, v22Var, swanAppConfigData)) == null) {
            s22 j = v22Var.j(0);
            if (j == null || !(j instanceof u22)) {
                return false;
            }
            String e2 = ((u22) j).m3().e();
            if (!swanAppConfigData.r(e2) && !TextUtils.equals(swanAppConfigData.f(), e2)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void N3() {
        int i2;
        b43 b43Var;
        tp1 r;
        TextView centerTitleView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || this.f0 == null) {
            return;
        }
        int i3 = 1;
        boolean z = false;
        if (G3()) {
            B2(true, this.T0);
            i2 = 0;
        } else if (F3()) {
            B2(false, false);
            sp1 sp1Var = this.K0;
            if (sp1Var != null) {
                if (sp1Var.k() != null) {
                    r = this.K0.k().r();
                } else {
                    r = this.K0.r();
                }
                if (r != null) {
                    i2 = r.getWebViewScrollY();
                    b43Var = this.O0;
                    if (b43Var != null && b43Var.i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            b43Var = this.O0;
            if (b43Var != null) {
                i3 = 0;
            }
        } else {
            B2(false, false);
            i2 = W0 + this.P0;
            centerTitleView = this.f0.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i3);
            }
            Y3(i2);
            a4(z);
        }
        z = true;
        centerTitleView = this.f0.getCenterTitleView();
        if (centerTitleView != null) {
        }
        Y3(i2);
        a4(z);
    }

    public final void T3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (V0) {
                Log.d("SwanAppFragment", "setting immersive portrait fullscreen video");
            }
            tf3.h();
            if (this.c0.getWindow() != null) {
                this.c0.getWindow().getDecorView().setSystemUiVisibility(5376);
            }
            View b2 = i23.b();
            if (b2 != null) {
                b2.setVisibility(0);
                b2.findViewById(R.id.obfuscated_res_0x7f09222b).setVisibility(8);
            }
            SwanAppActionBar K1 = K1();
            if (K1 != null) {
                K1.setRightMenuStyle();
                K1.setRightZoneImmersiveStyle();
                K1.setBackgroundColor(0);
            }
            View V = V();
            if (V != null) {
                V.findViewById(R.id.obfuscated_res_0x7f090f0d).setBackgroundColor(0);
                FrameLayout frameLayout = (FrameLayout) V.findViewById(R.id.obfuscated_res_0x7f09017d);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams);
            }
        }
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            Map map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (sp1 sp1Var : this.I0.values()) {
                    if (sp1Var != null) {
                        X3(sp1Var);
                        sp1Var.destroy();
                    }
                }
                this.I0.clear();
            } else {
                sp1 sp1Var2 = this.K0;
                if (sp1Var2 != null) {
                    X3(sp1Var2);
                    this.K0.destroy();
                }
            }
            this.K0 = null;
            if (V0) {
                Log.d("SwanAppFragment", "onDestroy() obj: " + this);
            }
            if (!this.S0) {
                r92.n(zo2.U().getActivity());
            }
        }
    }

    public void resume() {
        boolean z;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            boolean z2 = false;
            if (this.K0 == null) {
                z = true;
            } else {
                z = false;
            }
            String str = "";
            if (z) {
                a2 = "";
            } else {
                a2 = this.K0.a();
            }
            if (V0) {
                Log.d("SwanAppFragment", "resume() wvID: " + a2);
            }
            if (!z) {
                x2((Z1() || E3()) ? true : true);
                this.K0.onResume();
                Q3();
                P3("onShow");
                au2.e().i(true);
            }
            m02.i("SwanApp", "onShow");
            lq2.i(a2, true);
            if (m02.f()) {
                h22.b();
            }
            if (m33.b0() != null) {
                str = m33.b0().O();
            }
            tm2.H().e(str);
        }
    }

    public final void O3() {
        Bundle p;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || (p = p()) == null) {
            return;
        }
        this.H0 = Y0;
        if (V0) {
            Log.d("SwanAppFragment", "restoreArguments sPrePageParams=" + this.H0);
        }
        nt2 g2 = nt2.g(p.getString("ai_apps_param"));
        this.d0 = g2;
        if (g2 == null) {
            mt2 mt2Var = this.G0;
            mt2Var.a = "";
            mt2Var.b = "";
            mt2Var.e = "";
            mt2Var.f = "";
        } else {
            this.G0.a = g2.i();
            this.G0.b = this.d0.j();
            this.G0.e = this.d0.l();
            this.G0.f = this.d0.k();
        }
        mt2 mt2Var2 = this.G0;
        mt2Var2.d = e73.b(mt2Var2.e());
        b43 f2 = zo2.U().f(this.G0.g());
        this.O0 = f2;
        if (f2.p) {
            this.O0 = zo2.U().j(this.G0.e());
        }
        if (this.D0) {
            b43 b43Var = this.O0;
            b43Var.f = false;
            b43Var.h = true;
            b43Var.p = true;
        }
        this.P0 = J1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070159);
    }

    public final void Q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (TextUtils.equals(Z0, this.K0.a()) && !TextUtils.equals(a1, "switchTab")) {
                return;
            }
            int o = this.L0.o(m3().g());
            qd2 qd2Var = new qd2();
            qd2Var.c = Z0;
            qd2Var.d = this.K0.a();
            qd2Var.e = a1;
            qd2Var.f = this.G0.a;
            qd2Var.g = String.valueOf(o);
            a1 = "";
            if (V0) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + qd2Var.c + " ,toId: " + qd2Var.d + " ,RouteType: " + qd2Var.e + " page:" + qd2Var.f + ",TabIndex: " + qd2Var.g);
            }
            zo2.U().u(qd2Var);
            Z0 = this.K0.a();
        }
    }

    public void pause() {
        boolean z;
        String a2;
        PullToRefreshBaseWebView h0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            if (this.K0 == null) {
                z = true;
            } else {
                z = false;
            }
            String str = "";
            if (z) {
                a2 = "";
            } else {
                a2 = this.K0.a();
            }
            if (V0) {
                Log.d("SwanAppFragment", "pause() wvID: " + a2);
            }
            if (!z) {
                this.K0.onPause();
                P3("onHide");
                au2.e().i(false);
            }
            if (d() != null && !d().c() && (!d().f() || d().j())) {
                d().g();
            }
            m02.i("SwanApp", "onHide");
            lq2.i(a2, false);
            if (!z && (h0 = this.K0.h0()) != null) {
                h0.w(false);
            }
            if (m33.b0() != null) {
                str = m33.b0().O();
            }
            tm2.H().f(str);
        }
    }

    public final void P3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.K0.a());
            od2 od2Var = new od2(hashMap);
            if (V0) {
                Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.K0.a());
            }
            zo2.U().u(od2Var);
        }
    }

    public void V3(mt2 mt2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, mt2Var) == null) {
            if (V0) {
                Log.d("SwanAppFragment", "switchTab pageParam: " + mt2Var);
            }
            if (this.L0.o(m3().g()) == this.L0.o(mt2Var.g())) {
                mt2 mt2Var2 = this.G0;
                mt2Var2.e = mt2Var.e;
                mt2Var2.f = mt2Var.f;
                return;
            }
            this.L0.E(mt2Var.g());
            onPause();
            l3(mt2Var, "");
        }
    }

    public final void a4(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            int i3 = 0;
            if (z) {
                ni3 ni3Var = this.t0;
                if (ni3Var != null && ni3Var.i()) {
                    i2 = dh3.t();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.J0.getLayoutParams();
                    layoutParams.topMargin = i3;
                    this.J0.setLayoutParams(layoutParams);
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.e0.getLayoutParams();
                    layoutParams2.topMargin = i2;
                    this.e0.setLayoutParams(layoutParams2);
                }
            } else {
                i3 = J1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070159);
            }
            i2 = 0;
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.J0.getLayoutParams();
            layoutParams3.topMargin = i3;
            this.J0.setLayoutParams(layoutParams3);
            FrameLayout.LayoutParams layoutParams22 = (FrameLayout.LayoutParams) this.e0.getLayoutParams();
            layoutParams22.topMargin = i2;
            this.e0.setLayoutParams(layoutParams22);
        }
    }

    public final void s3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            if (tm2.K().k(z, 1)) {
                kt2.k(getContext(), this.f0, m33.b0().W().f0().paNumber);
            } else if (m33.b0() == null) {
            } else {
                kt2.o(this.f0, m33.b0().U().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    @Override // com.baidu.tieba.s22
    public void U1(View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            super.U1(view2);
            boolean z2 = false;
            if (!Z1() && !E3()) {
                z = false;
            } else {
                z = true;
            }
            x2(z);
            if (I3()) {
                f2();
            }
            N3();
            this.f0.setOnDoubleClickListener(new b(this));
            if (!w93.i()) {
                w93.d(l33.K().q().W());
            }
            if (G3() && E3()) {
                z2 = true;
            }
            this.T0 = z2;
            if (z2) {
                f3();
            }
        }
    }

    public final void W3(String str, mt2 mt2Var) {
        sp1 sp1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048601, this, str, mt2Var) == null) && this.K0 != (sp1Var = (sp1) this.I0.get(str)) && sp1Var != null) {
            b43 f2 = zo2.U().f(str);
            sp1Var.z(this.J0, f2);
            if (!sp1Var.c()) {
                sp1Var.O(this.J0, f2);
            }
            sp1Var.C(0);
            sp1 sp1Var2 = this.K0;
            if (sp1Var2 != null) {
                sp1Var2.C(8);
            }
            this.K0 = sp1Var;
            mt2 mt2Var2 = this.G0;
            mt2Var2.e = mt2Var.e;
            mt2Var2.f = mt2Var.f;
            sp1Var.h(mt2Var2);
        }
    }

    public final void Y3(int i2) {
        TextView centerTitleView;
        View e2;
        Drawable background;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            float f2 = 1.0f;
            float f3 = (i2 - W0) * 1.0f;
            int i3 = this.P0;
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
            if (V0 && i4 != 0 && i4 != 255) {
                Log.d("SwanAppFragment", "update bar transparent degree: " + f2 + ZeusCrashHandler.NAME_SEPERATOR + i4);
            }
            ni3 ni3Var = this.t0;
            if (ni3Var != null && ni3Var.i() && (e2 = this.t0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.f0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            b43 b43Var = this.O0;
            if (b43Var != null && b43Var.i && (centerTitleView = this.f0.getCenterTitleView()) != null) {
                centerTitleView.setAlpha(f2);
            }
            Drawable background3 = this.i0.getBackground();
            if (background3 != null) {
                background3.setAlpha(i4);
            }
        }
    }

    public final void h3(View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, view2) == null) {
            qw2.a("route", "createSlaveWebView start.");
            String h2 = this.d0.h();
            String j = this.d0.j();
            String i2 = this.d0.i();
            String a2 = gh3.a(h2, i2, j);
            this.K0 = r92.h(a2);
            if (V0) {
                StringBuilder sb = new StringBuilder();
                sb.append("pageUrl: ");
                sb.append(a2);
                sb.append(" is load: ");
                if (this.K0 != null) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                Log.d("SwanAppFragment", sb.toString());
            }
            if (this.K0 == null) {
                if (V0) {
                    Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
                }
                this.K0 = g3(h2, i2, j, "");
            }
            this.K0.h(this.G0);
            b43 f2 = zo2.U().f(i2);
            this.K0.z(this.J0, f2);
            this.K0.O(this.J0, f2);
            B3(i2);
            d3(this.K0);
            if (e2()) {
                this.I0.put(i2, this.K0);
                this.L0.f(view2, getContext(), i2);
            }
            qw2.a("route", "createSlaveWebView end.");
            e3();
        }
    }

    public final sp1 g3(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048612, this, str, str2, str3, str4)) == null) {
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad start.");
            }
            r92.e f2 = r92.f(getActivity(), w92.c(str2));
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = rw2.q("route", str4);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                if (f2.b) {
                    str5 = "1";
                } else {
                    str5 = "0";
                }
                q.D("preload", str5);
            }
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + f2);
            }
            r92.q(f2, new d(this, f2, str4, str2, str, str3));
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad end.");
            }
            return f2.a;
        }
        return (sp1) invokeLLLL.objValue;
    }

    public final void i3(mt2 mt2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048616, this, mt2Var, str) == null) && this.I0.get(mt2Var.d) == null) {
            String a2 = gh3.a(mt2Var.c, mt2Var.a, mt2Var.b);
            sp1 h2 = r92.h(a2);
            if (h2 != null) {
                if (V0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + a2);
                }
                this.I0.put(mt2Var.a, h2);
            } else {
                if (V0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                h2 = g3(mt2Var.c, mt2Var.a, mt2Var.b, str);
                this.I0.put(mt2Var.a, h2);
            }
            B3(mt2Var.a);
            d3(h2);
        }
    }

    public void l3(mt2 mt2Var, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, mt2Var, str) == null) {
            S3(this.G0);
            this.H0 = Y0;
            if (V0) {
                Log.d("SwanAppFragment", "doSwitchTab mPrePageParams=" + this.H0);
            }
            String str3 = mt2Var.a;
            String str4 = mt2Var.d;
            zo2 U = zo2.U();
            String str5 = "";
            if (TextUtils.isEmpty(str4)) {
                str2 = "";
            } else {
                str2 = str4;
            }
            b43 f2 = U.f(str2);
            mt2 mt2Var2 = this.G0;
            mt2Var2.a = str3;
            if (mt2Var != null) {
                str5 = mt2Var.f();
            }
            mt2Var2.b = str5;
            this.G0.d = str4;
            this.O0 = f2;
            boolean z = !K3(str4);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    sw2.c(7, str);
                } else {
                    sw2.c(6, str);
                }
            }
            if (!z) {
                W3(str4, mt2Var);
            } else {
                i3(mt2Var, str);
                W3(str3, mt2Var);
            }
            if (!TextUtils.isEmpty(str)) {
                rw2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                sw2.a(str, mt2Var);
            }
            v2(f2.b);
            C2(SwanAppConfigData.t(f2.c));
            t2(f2.a);
            N3();
            Z3();
            m02.i("SwanAppFragment", "switch tab title: " + f2.b + " page:" + str3);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048643, this, layoutInflater, viewGroup, bundle)) == null) {
            qw2.a("route", "fragment onCreateView.");
            View b2 = wx2.a().b(R.layout.obfuscated_res_0x7f0d00a6, viewGroup, false);
            this.J0 = (FrameLayout) b2.findViewById(R.id.obfuscated_res_0x7f09017d);
            U1(b2);
            T2(b2);
            this.L0 = new ye3(this);
            h3(b2);
            if (!it2.e() && !it2.f()) {
                ht2.b(this.K0.a(), String.valueOf(it2.d()), String.valueOf(it2.a(it2.b())));
            }
            if (T1()) {
                b2 = W1(b2);
            }
            this.N0 = D1(b2, this);
            G2(this.K0.A());
            au2.e().m();
            return this.N0;
        }
        return (View) invokeLLL.objValue;
    }
}
