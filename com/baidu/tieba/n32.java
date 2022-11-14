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
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.ka2;
import com.baidu.tieba.m33;
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
/* loaded from: classes5.dex */
public class n32 extends l32 implements m33.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean V0;
    public static final int W0;
    public static String X0;
    public static fu2 Y0;
    public static String Z0;
    public static String a1;
    public transient /* synthetic */ FieldHolder $fh;
    public la3 F0;
    public fu2 G0;
    public fu2 H0;
    public Map<String, lq1> I0;
    public FrameLayout J0;
    public lq1 K0;
    public rf3 L0;
    public m33 M0;
    public View N0;
    public u43 O0;
    public int P0;
    public s52 Q0;
    public jp1 R0;
    public boolean S0;
    public boolean T0;
    public boolean U0;

    @Override // com.baidu.tieba.l32
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class e implements yi3<f93> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n32 a;

        /* loaded from: classes5.dex */
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

        public e(n32 n32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(f93 f93Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f93Var) == null) && f93Var != null && !f93Var.d && f93Var.j == 1) {
                zh3.e0(new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n32 a;

        public a(n32 n32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n32Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.R0 = mn2.Q();
                jp1 jp1Var = this.a.R0;
                n32 n32Var = this.a;
                jp1Var.a(n32Var.b0, n32Var.d0, n32Var.getContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements SwanAppActionBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n32 a;

        public b(n32 n32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n32Var;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String a = this.a.K0.a();
                le2 le2Var = new le2();
                le2Var.c = mj3.a(a, "scrollViewBackToTop");
                sp2.U().m(a, le2Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n32 a;

        public c(n32 n32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n32Var;
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

    /* loaded from: classes5.dex */
    public class d implements ka2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ka2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ n32 f;

        public d(n32 n32Var, ka2.e eVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n32Var, eVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = n32Var;
            this.a = eVar;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [com.baidu.tieba.mq1] */
        @Override // com.baidu.tieba.ka2.f
        public void onReady() {
            String str;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wa2 wa2Var = new wa2();
                wa2Var.i = this.a.a.K();
                if (!TextUtils.isEmpty(this.b)) {
                    lx2.e(this.a, this.b);
                }
                String b = x73.b(this.c);
                wa2Var.a = this.d;
                if (TextUtils.isEmpty(this.e)) {
                    str = this.c;
                } else {
                    str = this.c + "?" + this.e;
                }
                wa2Var.b = str;
                if (f43.b0() != null) {
                    wa2Var.c = f43.b0().d0(b);
                    wa2Var.f = f43.b0().X(b);
                }
                wa2Var.k = ta2.c(f43.M(), wa2Var.b);
                wa2Var.d = sp2.U().f(b).g;
                wa2Var.e = String.valueOf(c12.a());
                if (!n32.V0 && !sp2.U().N()) {
                    z = false;
                } else {
                    z = true;
                }
                wa2Var.g = z;
                if (e03.H()) {
                    wa2Var.j = i12.d();
                }
                if (!TextUtils.isEmpty(this.b)) {
                    String str2 = this.b;
                    wa2Var.h = str2;
                    kx2.q("route", str2).F(new UbcFlowEvent("slave_dispatch_start"));
                }
                mh3.d();
                this.a.a.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.c);
                this.a.a.R(wa2Var.b);
                sp2.U().m(this.a.a.a(), wa2.a(wa2Var));
                if (xa2.b()) {
                    xa2 xa2Var = new xa2();
                    xa2Var.a = this.a.a.a();
                    sp2.U().u(xa2.a(xa2Var));
                }
                pa3.F(this.a.a.a(), wa2Var.b);
                if (n32.V0) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + wa2Var.toString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements s52 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n32 a;

        public f(n32 n32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n32Var;
        }

        @Override // com.baidu.tieba.s52
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIIII(1048576, this, i, i2, i3, i4) != null) {
                return;
            }
            this.a.Y3(i2);
        }
    }

    /* loaded from: classes5.dex */
    public class g implements u52 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n32 a;

        public g(n32 n32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n32Var;
        }

        @Override // com.baidu.tieba.u52
        public void a(oq1 oq1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, oq1Var) == null) && oq1Var != null) {
                oq1Var.t(this.a.Q0);
                oq1Var.Y(this.a.y3());
                tu2.e().a(oq1Var);
            }
        }

        @Override // com.baidu.tieba.u52
        public void b(oq1 oq1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oq1Var) == null) && oq1Var != null) {
                oq1Var.U(this.a.Q0);
                tu2.e().b(oq1Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends q52 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n32 c;

        public h(n32 n32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n32Var;
        }

        @Override // com.baidu.tieba.q52, com.baidu.tieba.t52
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.c.v2(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-624414473, "Lcom/baidu/tieba/n32$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-624414473, "Lcom/baidu/tieba/n32$i;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (a < 0) {
                    mn2.g0().getSwitch("swan_app_fragment_destroy_switch", 1);
                    a = 1;
                }
                if (n32.V0) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947951452, "Lcom/baidu/tieba/n32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947951452, "Lcom/baidu/tieba/n32;");
                return;
            }
        }
        V0 = pk1.a;
        W0 = wh3.g(149.0f);
        X0 = "-1";
        Z0 = "-1";
    }

    public final void A3() {
        il2 F0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            lq1 o3 = o3();
            if ((o3 instanceof SwanAppWebViewManager) && (F0 = ((SwanAppWebViewManager) o3).F0()) != null) {
                F0.d();
            }
        }
    }

    @Override // com.baidu.tieba.l32, com.baidu.swan.support.v4.app.Fragment
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
            rf3 rf3Var = this.L0;
            if (rf3Var == null) {
                return false;
            }
            return rf3Var.p();
        }
        return invokeV.booleanValue;
    }

    public final boolean F3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            u43 u43Var = this.O0;
            if (u43Var != null && u43Var.h) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.l32
    public u43 G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.O0;
        }
        return (u43) invokeV.objValue;
    }

    public boolean G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            u43 u43Var = this.O0;
            if (u43Var != null) {
                return TextUtils.equals(u43Var.j, "custom");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            SwanAppConfigData s = sp2.U().s();
            if (s != null && !TextUtils.equals(s.f(), this.G0.e())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void Z3() {
        gu2 gu2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048604, this) != null) || (gu2Var = this.d0) == null) {
            return;
        }
        gu2Var.n();
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.F0 = ya3.c("805");
        }
    }

    public final void f3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            e43.K().q().e0().e("mapp_i_custom_navigation_bar", new e(this));
        }
    }

    public PullToRefreshBaseWebView h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            lq1 lq1Var = this.K0;
            if (lq1Var != null) {
                return lq1Var.h0();
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

    @NonNull
    public fu2 m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.G0;
        }
        return (fu2) invokeV.objValue;
    }

    public lq1 o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.K0;
        }
        return (lq1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l32, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            super.onPause();
            b1();
        }
    }

    @Override // com.baidu.tieba.l32, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onResume();
            e1();
            s3(false);
        }
    }

    @Override // com.baidu.tieba.l32
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

    @Nullable
    public fu2 r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.H0;
        }
        return (fu2) invokeV.objValue;
    }

    public String t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            lq1 lq1Var = this.K0;
            if (lq1Var != null) {
                return lq1Var.a();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public rf3 v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.L0;
        }
        return (rf3) invokeV.objValue;
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
                zh3.q().postAtFrontOfQueue(new c(this));
            } else {
                j3();
            }
        }
    }

    public final q52 y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return new h(this);
        }
        return (q52) invokeV.objValue;
    }

    public final u52 z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return new g(this);
        }
        return (u52) invokeV.objValue;
    }

    public n32() {
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
        this.G0 = new fu2();
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
            Map<String, lq1> map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (lq1 lq1Var : this.I0.values()) {
                    if (lq1Var != null) {
                        lq1Var.e0();
                    }
                }
            } else {
                lq1 lq1Var2 = this.K0;
                if (lq1Var2 != null) {
                    lq1Var2.e0();
                }
            }
            A3();
        }
    }

    public final boolean E3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            SwanAppConfigData s = sp2.U().s();
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
            o32 M1 = M1();
            if (M1 == null) {
                return false;
            }
            u43 u43Var = this.O0;
            if (u43Var != null && u43Var.k) {
                z = true;
            } else {
                z = false;
            }
            if (z || (s = sp2.U().s()) == null) {
                return false;
            }
            return !H3(M1, s);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.m33.a
    public m33 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.M0 == null) {
                if (this.N0 == null) {
                    return null;
                }
                this.M0 = new m33(this, (LinearLayout) this.N0.findViewById(R.id.obfuscated_res_0x7f090184), J1().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070159));
            }
            return this.M0;
        }
        return (m33) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l32
    public boolean e2() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        gu2 gu2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            sp2 U = sp2.U();
            if (U == null || (s = U.s()) == null || !s.n() || (gu2Var = this.d0) == null) {
                return false;
            }
            return s.r(gu2Var.i());
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.l32
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            lq1 lq1Var = this.K0;
            if (lq1Var != null) {
                lq1Var.T();
            }
            C3();
            q3(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(db2.n(e43.K().getAppId()));
            }
            this.g0.u(mn2.M().a(), H1(), this.h0, false);
        }
    }

    public static n32 M3(gu2 gu2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, gu2Var)) == null) {
            n32 n32Var = new n32();
            if (gu2Var != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", gu2Var.m());
                n32Var.j1(bundle);
            }
            return n32Var;
        }
        return (n32) invokeL.objValue;
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

    public void L3(jb3 jb3Var) {
        la3 la3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, jb3Var) == null) && (la3Var = this.F0) != null) {
            ya3.i(la3Var, jb3Var);
            this.F0 = null;
        }
    }

    public void R3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.U0 = z;
        }
    }

    public final void X3(lq1 lq1Var) {
        s52 s52Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048602, this, lq1Var) != null) || (s52Var = this.Q0) == null || lq1Var == null) {
            return;
        }
        lq1Var.U(s52Var);
        if (lq1Var.k() != null) {
            lq1Var.U(this.Q0);
        }
    }

    public final void d3(lq1 lq1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, lq1Var) != null) || lq1Var == null) {
            return;
        }
        s52 s52Var = this.Q0;
        if (s52Var != null) {
            lq1Var.t(s52Var);
        }
        lq1Var.a0(z3());
    }

    @Override // com.baidu.tieba.l32, com.baidu.searchbox.widget.SlideInterceptor
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

    @Override // com.baidu.tieba.l32
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

    @Override // com.baidu.tieba.l32
    public void w1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
            if (!u43.f(this.O0)) {
                super.w1(i2);
                return;
            }
            boolean z = true;
            if (!G3()) {
                z = true ^ oh3.h(this.c0);
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
                return this.I0.get(str).a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void S3(fu2 fu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, fu2Var) == null) {
            try {
                if (V0) {
                    Log.d("SwanAppFragment", "setLastPageParams =" + fu2Var);
                }
                if (fu2Var == null) {
                    Y0 = null;
                } else {
                    Y0 = (fu2) fu2Var.clone();
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
        sp2 U = sp2.U();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (U.f(str).h && this.Q0 == null) {
            this.Q0 = new f(this);
        }
    }

    @Override // com.baidu.tieba.l32, com.baidu.swan.support.v4.app.Fragment
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
        if ((interceptable == null || interceptable.invokeZ(1048631, this, z) == null) && mn2.K().k(z, 2)) {
            du2.l(getContext(), this.g0, this.f0, f43.b0().W().f0().paNumber);
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
            zg3.j(new a(this), "SwanAppPageHistory");
            jx2.a("route", "fragment create.");
        }
    }

    private void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if (U()) {
                resume();
            }
            ma4 ma4Var = this.g0;
            if (ma4Var != null && ma4Var.i()) {
                this.g0.B(mn2.M().a());
            }
            if (V0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.K0.a())));
            }
        }
    }

    @DebugTrace
    public void C3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            FragmentActivity activity = getActivity();
            if (this.h0 == null) {
                this.h0 = new SwanAppMenuHeaderView(getContext());
            }
            if (activity != null && this.g0 == null) {
                this.g0 = new ma4(activity, this.f0, p3(), mn2.K(), new oj3());
                new vt2(this.g0, this, this.h0).z();
                if (bu2.e()) {
                    this.g0.l(50);
                }
            }
        }
    }

    @Override // com.baidu.tieba.l32
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
            lq1 lq1Var = this.K0;
            if (lq1Var != null) {
                if (er2.g(lq1Var.a())) {
                    return true;
                }
                return this.K0.I();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.l32
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
            oq1 k = this.K0.k();
            if (k != null) {
                hashMap.put("webViewUrl", k.getCurrentPageUrl());
            }
            sp2.U().u(new ge2("sharebtn", hashMap));
        }
    }

    @Override // com.baidu.tieba.l32
    public void i2() {
        gu2 N1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            P1();
            ib3 ib3Var = new ib3();
            ib3Var.e = "gohome";
            ib3Var.c = "bar";
            n32 H = sp2.U().H();
            if (H == null) {
                N1 = null;
            } else {
                N1 = H.N1();
            }
            if (N1 != null && !TextUtils.isEmpty(N1.i())) {
                ib3Var.a("page", N1.i());
            }
            A1(ib3Var);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.mq1] */
    @NonNull
    public Pair<Integer, Integer> n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            lq1 lq1Var = this.K0;
            if (lq1Var == null) {
                return new Pair<>(0, 0);
            }
            View currentWebView = lq1Var.r().getCurrentWebView();
            if (currentWebView == null) {
                return new Pair<>(0, 0);
            }
            return new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
        }
        return (Pair) invokeV.objValue;
    }

    public List<String> u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, lq1> map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, lq1> entry : this.I0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(entry.getValue().a());
                    }
                }
            }
            lq1 lq1Var = this.K0;
            if (lq1Var != null) {
                String a2 = lq1Var.a();
                if (!arrayList.contains(a2)) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean H3(o32 o32Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, o32Var, swanAppConfigData)) == null) {
            l32 j = o32Var.j(0);
            if (j == null || !(j instanceof n32)) {
                return false;
            }
            String e2 = ((n32) j).m3().e();
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
    public final void N3() {
        int i2;
        u43 u43Var;
        mq1 mq1Var;
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
            lq1 lq1Var = this.K0;
            if (lq1Var != null) {
                if (lq1Var.k() != null) {
                    mq1Var = this.K0.k().r();
                } else {
                    mq1Var = this.K0.r();
                }
                if (mq1Var != null) {
                    i2 = mq1Var.getWebViewScrollY();
                    u43Var = this.O0;
                    if (u43Var != null && u43Var.i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            u43Var = this.O0;
            if (u43Var != null) {
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
            mg3.h();
            if (this.c0.getWindow() != null) {
                this.c0.getWindow().getDecorView().setSystemUiVisibility(5376);
            }
            View b2 = b33.b();
            if (b2 != null) {
                b2.setVisibility(0);
                b2.findViewById(R.id.obfuscated_res_0x7f09228b).setVisibility(8);
            }
            SwanAppActionBar K1 = K1();
            if (K1 != null) {
                K1.setRightMenuStyle();
                K1.setRightZoneImmersiveStyle();
                K1.setBackgroundColor(0);
            }
            View V = V();
            if (V != null) {
                V.findViewById(R.id.obfuscated_res_0x7f090f4a).setBackgroundColor(0);
                FrameLayout frameLayout = (FrameLayout) V.findViewById(R.id.obfuscated_res_0x7f090185);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams);
            }
        }
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            Map<String, lq1> map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (lq1 lq1Var : this.I0.values()) {
                    if (lq1Var != null) {
                        X3(lq1Var);
                        lq1Var.destroy();
                    }
                }
                this.I0.clear();
            } else {
                lq1 lq1Var2 = this.K0;
                if (lq1Var2 != null) {
                    X3(lq1Var2);
                    this.K0.destroy();
                }
            }
            this.K0 = null;
            if (V0) {
                Log.d("SwanAppFragment", "onDestroy() obj: " + this);
            }
            if (!this.S0) {
                ka2.n(sp2.U().getActivity());
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
                tu2.e().i(true);
            }
            f12.i("SwanApp", "onShow");
            er2.i(a2, true);
            if (f12.f()) {
                a32.b();
            }
            if (f43.b0() != null) {
                str = f43.b0().O();
            }
            mn2.H().e(str);
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
        gu2 g2 = gu2.g(p.getString("ai_apps_param"));
        this.d0 = g2;
        if (g2 == null) {
            fu2 fu2Var = this.G0;
            fu2Var.a = "";
            fu2Var.b = "";
            fu2Var.e = "";
            fu2Var.f = "";
        } else {
            this.G0.a = g2.i();
            this.G0.b = this.d0.j();
            this.G0.e = this.d0.l();
            this.G0.f = this.d0.k();
        }
        fu2 fu2Var2 = this.G0;
        fu2Var2.d = x73.b(fu2Var2.e());
        u43 f2 = sp2.U().f(this.G0.g());
        this.O0 = f2;
        if (f2.p) {
            this.O0 = sp2.U().j(this.G0.e());
        }
        if (this.D0) {
            u43 u43Var = this.O0;
            u43Var.f = false;
            u43Var.h = true;
            u43Var.p = true;
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
            je2 je2Var = new je2();
            je2Var.c = Z0;
            je2Var.d = this.K0.a();
            je2Var.e = a1;
            je2Var.f = this.G0.a;
            je2Var.g = String.valueOf(o);
            a1 = "";
            if (V0) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + je2Var.c + " ,toId: " + je2Var.d + " ,RouteType: " + je2Var.e + " page:" + je2Var.f + ",TabIndex: " + je2Var.g);
            }
            sp2.U().u(je2Var);
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
                tu2.e().i(false);
            }
            if (d() != null && !d().c() && (!d().f() || d().j())) {
                d().g();
            }
            f12.i("SwanApp", "onHide");
            er2.i(a2, false);
            if (!z && (h0 = this.K0.h0()) != null) {
                h0.w(false);
            }
            if (f43.b0() != null) {
                str = f43.b0().O();
            }
            mn2.H().f(str);
        }
    }

    public final void P3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.K0.a());
            he2 he2Var = new he2(hashMap);
            if (V0) {
                Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.K0.a());
            }
            sp2.U().u(he2Var);
        }
    }

    public void V3(fu2 fu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, fu2Var) == null) {
            if (V0) {
                Log.d("SwanAppFragment", "switchTab pageParam: " + fu2Var);
            }
            if (this.L0.o(m3().g()) == this.L0.o(fu2Var.g())) {
                fu2 fu2Var2 = this.G0;
                fu2Var2.e = fu2Var.e;
                fu2Var2.f = fu2Var.f;
                return;
            }
            this.L0.E(fu2Var.g());
            onPause();
            l3(fu2Var, "");
        }
    }

    public final void a4(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            int i3 = 0;
            if (z) {
                gj3 gj3Var = this.t0;
                if (gj3Var != null && gj3Var.i()) {
                    i2 = wh3.t();
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
            if (mn2.K().k(z, 1)) {
                du2.k(getContext(), this.f0, f43.b0().W().f0().paNumber);
            } else if (f43.b0() == null) {
            } else {
                du2.o(this.f0, f43.b0().U().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    @Override // com.baidu.tieba.l32
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
            if (!pa3.i()) {
                pa3.d(e43.K().q().W());
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

    public final void W3(String str, fu2 fu2Var) {
        lq1 lq1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048601, this, str, fu2Var) == null) && this.K0 != (lq1Var = this.I0.get(str)) && lq1Var != null) {
            u43 f2 = sp2.U().f(str);
            lq1Var.z(this.J0, f2);
            if (!lq1Var.c()) {
                lq1Var.O(this.J0, f2);
            }
            lq1Var.C(0);
            lq1 lq1Var2 = this.K0;
            if (lq1Var2 != null) {
                lq1Var2.C(8);
            }
            this.K0 = lq1Var;
            fu2 fu2Var2 = this.G0;
            fu2Var2.e = fu2Var.e;
            fu2Var2.f = fu2Var.f;
            lq1Var.h(fu2Var2);
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
            gj3 gj3Var = this.t0;
            if (gj3Var != null && gj3Var.i() && (e2 = this.t0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.f0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            u43 u43Var = this.O0;
            if (u43Var != null && u43Var.i && (centerTitleView = this.f0.getCenterTitleView()) != null) {
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
            jx2.a("route", "createSlaveWebView start.");
            String h2 = this.d0.h();
            String j = this.d0.j();
            String i2 = this.d0.i();
            String a2 = zh3.a(h2, i2, j);
            this.K0 = ka2.h(a2);
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
            u43 f2 = sp2.U().f(i2);
            this.K0.z(this.J0, f2);
            this.K0.O(this.J0, f2);
            B3(i2);
            d3(this.K0);
            if (e2()) {
                this.I0.put(i2, this.K0);
                this.L0.f(view2, getContext(), i2);
            }
            jx2.a("route", "createSlaveWebView end.");
            e3();
        }
    }

    public final lq1 g3(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048612, this, str, str2, str3, str4)) == null) {
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad start.");
            }
            ka2.e f2 = ka2.f(getActivity(), pa2.c(str2));
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = kx2.q("route", str4);
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
            ka2.q(f2, new d(this, f2, str4, str2, str, str3));
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad end.");
            }
            return f2.a;
        }
        return (lq1) invokeLLLL.objValue;
    }

    public final void i3(fu2 fu2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048616, this, fu2Var, str) == null) && this.I0.get(fu2Var.d) == null) {
            String a2 = zh3.a(fu2Var.c, fu2Var.a, fu2Var.b);
            lq1 h2 = ka2.h(a2);
            if (h2 != null) {
                if (V0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + a2);
                }
                this.I0.put(fu2Var.a, h2);
            } else {
                if (V0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                h2 = g3(fu2Var.c, fu2Var.a, fu2Var.b, str);
                this.I0.put(fu2Var.a, h2);
            }
            B3(fu2Var.a);
            d3(h2);
        }
    }

    public void l3(fu2 fu2Var, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, fu2Var, str) == null) {
            S3(this.G0);
            this.H0 = Y0;
            if (V0) {
                Log.d("SwanAppFragment", "doSwitchTab mPrePageParams=" + this.H0);
            }
            String str3 = fu2Var.a;
            String str4 = fu2Var.d;
            sp2 U = sp2.U();
            String str5 = "";
            if (TextUtils.isEmpty(str4)) {
                str2 = "";
            } else {
                str2 = str4;
            }
            u43 f2 = U.f(str2);
            fu2 fu2Var2 = this.G0;
            fu2Var2.a = str3;
            if (fu2Var != null) {
                str5 = fu2Var.f();
            }
            fu2Var2.b = str5;
            this.G0.d = str4;
            this.O0 = f2;
            boolean z = !K3(str4);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    lx2.c(7, str);
                } else {
                    lx2.c(6, str);
                }
            }
            if (!z) {
                W3(str4, fu2Var);
            } else {
                i3(fu2Var, str);
                W3(str3, fu2Var);
            }
            if (!TextUtils.isEmpty(str)) {
                kx2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                lx2.a(str, fu2Var);
            }
            v2(f2.b);
            C2(SwanAppConfigData.t(f2.c));
            t2(f2.a);
            N3();
            Z3();
            f12.i("SwanAppFragment", "switch tab title: " + f2.b + " page:" + str3);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048643, this, layoutInflater, viewGroup, bundle)) == null) {
            jx2.a("route", "fragment onCreateView.");
            View b2 = py2.a().b(R.layout.obfuscated_res_0x7f0d00a7, viewGroup, false);
            this.J0 = (FrameLayout) b2.findViewById(R.id.obfuscated_res_0x7f090185);
            U1(b2);
            T2(b2);
            this.L0 = new rf3(this);
            h3(b2);
            if (!bu2.e() && !bu2.f()) {
                au2.b(this.K0.a(), String.valueOf(bu2.d()), String.valueOf(bu2.a(bu2.b())));
            }
            if (T1()) {
                b2 = W1(b2);
            }
            this.N0 = D1(b2, this);
            G2(this.K0.A());
            tu2.e().m();
            return this.N0;
        }
        return (View) invokeLLL.objValue;
    }
}
