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
import com.baidu.tieba.ih2;
import com.baidu.tieba.ka3;
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
/* loaded from: classes7.dex */
public class la2 extends ja2 implements ka3.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean W0;
    public static final int X0;
    public static String Y0;
    public static d13 Z0;
    public static String a1;
    public static String b1;
    public transient /* synthetic */ FieldHolder $fh;
    public jh3 G0;
    public d13 H0;
    public d13 I0;
    public Map<String, jx1> J0;
    public FrameLayout K0;
    public jx1 L0;
    public pm3 M0;
    public ka3 N0;
    public View O0;
    public sb3 P0;
    public int Q0;
    public qc2 R0;
    public hw1 S0;
    public boolean T0;
    public boolean U0;
    public boolean V0;

    @Override // com.baidu.tieba.ja2
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class e implements wp3<dg3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ la2 a;

        /* loaded from: classes7.dex */
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
                this.a.a.D2(true, false);
            }
        }

        public e(la2 la2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = la2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(dg3 dg3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dg3Var) == null) && dg3Var != null && !dg3Var.d && dg3Var.j == 1) {
                xo3.e0(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ la2 a;

        public a(la2 la2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = la2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.S0 = ku2.Q();
                hw1 hw1Var = this.a.S0;
                la2 la2Var = this.a;
                hw1Var.a(la2Var.b0, la2Var.d0, la2Var.getContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements SwanAppActionBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ la2 a;

        public b(la2 la2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = la2Var;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void onDoubleClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String a = this.a.L0.a();
                jl2 jl2Var = new jl2();
                jl2Var.c = kq3.a(a, "scrollViewBackToTop");
                qw2.T().m(a, jl2Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ la2 a;

        public c(la2 la2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = la2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.l3();
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ih2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ih2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ la2 f;

        public d(la2 la2Var, ih2.e eVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la2Var, eVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = la2Var;
            this.a = eVar;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [com.baidu.tieba.kx1] */
        @Override // com.baidu.tieba.ih2.f
        public void onReady() {
            String str;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                uh2 uh2Var = new uh2();
                uh2Var.i = this.a.a.I();
                if (!TextUtils.isEmpty(this.b)) {
                    j43.e(this.a, this.b);
                }
                String b = ve3.b(this.c);
                uh2Var.a = this.d;
                if (TextUtils.isEmpty(this.e)) {
                    str = this.c;
                } else {
                    str = this.c + "?" + this.e;
                }
                uh2Var.b = str;
                if (db3.b0() != null) {
                    uh2Var.c = db3.b0().d0(b);
                    uh2Var.f = db3.b0().X(b);
                }
                uh2Var.k = rh2.c(db3.M(), uh2Var.b);
                uh2Var.d = qw2.T().f(b).g;
                uh2Var.e = String.valueOf(a82.a());
                if (!la2.W0 && !qw2.T().M()) {
                    z = false;
                } else {
                    z = true;
                }
                uh2Var.g = z;
                if (c73.H()) {
                    uh2Var.j = g82.d();
                }
                if (!TextUtils.isEmpty(this.b)) {
                    String str2 = this.b;
                    uh2Var.h = str2;
                    i43.q("route", str2).F(new UbcFlowEvent("slave_dispatch_start"));
                }
                ko3.d();
                this.a.a.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.c);
                this.a.a.Q(uh2Var.b);
                qw2.T().m(this.a.a.a(), uh2.a(uh2Var));
                if (vh2.b()) {
                    vh2 vh2Var = new vh2();
                    vh2Var.a = this.a.a.a();
                    qw2.T().u(vh2.a(vh2Var));
                }
                nh3.F(this.a.a.a(), uh2Var.b);
                if (la2.W0) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + uh2Var.toString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements qc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ la2 a;

        public f(la2 la2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = la2Var;
        }

        @Override // com.baidu.tieba.qc2
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIIII(1048576, this, i, i2, i3, i4) != null) {
                return;
            }
            this.a.a4(i2);
        }
    }

    /* loaded from: classes7.dex */
    public class g implements sc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ la2 a;

        public g(la2 la2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = la2Var;
        }

        @Override // com.baidu.tieba.sc2
        public void a(mx1 mx1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, mx1Var) == null) && mx1Var != null) {
                mx1Var.s(this.a.R0);
                mx1Var.X(this.a.A3());
                r13.e().a(mx1Var);
            }
        }

        @Override // com.baidu.tieba.sc2
        public void b(mx1 mx1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mx1Var) == null) && mx1Var != null) {
                mx1Var.S(this.a.R0);
                r13.e().b(mx1Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends oc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ la2 c;

        public h(la2 la2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = la2Var;
        }

        @Override // com.baidu.tieba.oc2, com.baidu.tieba.rc2
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.c.x2(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-639190809, "Lcom/baidu/tieba/la2$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-639190809, "Lcom/baidu/tieba/la2$i;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (a < 0) {
                    ku2.g0().getSwitch("swan_app_fragment_destroy_switch", 1);
                    a = 1;
                }
                if (la2.W0) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947936076, "Lcom/baidu/tieba/la2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947936076, "Lcom/baidu/tieba/la2;");
                return;
            }
        }
        W0 = nr1.a;
        X0 = uo3.g(149.0f);
        Y0 = "-1";
        a1 = "-1";
    }

    public final oc2 A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new h(this);
        }
        return (oc2) invokeV.objValue;
    }

    public final sc2 B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new g(this);
        }
        return (sc2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ja2, com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.C0();
        }
    }

    public final void C3() {
        gs2 D0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            jx1 q3 = q3();
            if ((q3 instanceof SwanAppWebViewManager) && (D0 = ((SwanAppWebViewManager) q3).D0()) != null) {
                D0.d();
            }
        }
    }

    public boolean F3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            pm3 pm3Var = this.M0;
            if (pm3Var == null) {
                return false;
            }
            return pm3Var.p();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ja2
    public sb3 H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.P0;
        }
        return (sb3) invokeV.objValue;
    }

    public final boolean H3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            sb3 sb3Var = this.P0;
            if (sb3Var != null && sb3Var.h) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            sb3 sb3Var = this.P0;
            if (sb3Var != null) {
                return TextUtils.equals(sb3Var.j, ExceptionHandlerImpl.KEY_CUSTOM);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean L3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SwanAppConfigData s = qw2.T().s();
            if (s != null && !TextUtils.equals(s.f(), this.H0.e())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void b4() {
        e13 e13Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048606, this) != null) || (e13Var = this.d0) == null) {
            return;
        }
        e13Var.n();
    }

    public PullToRefreshBaseWebView f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            jx1 jx1Var = this.L0;
            if (jx1Var != null) {
                return jx1Var.f0();
            }
            return null;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.G0 = wh3.c("805");
        }
    }

    public final void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            cb3.K().q().e0().e("mapp_i_custom_navigation_bar", new e(this));
        }
    }

    public void m3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.P0.j = "default";
            w1();
            P3();
        }
    }

    @NonNull
    public d13 o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.H0;
        }
        return (d13) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ja2, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            super.onPause();
            a1();
        }
    }

    @Override // com.baidu.tieba.ja2, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onResume();
            e1();
            u3(false);
        }
    }

    public jx1 q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.L0;
        }
        return (jx1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ja2
    public void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            super.r2();
            P3();
            if (this.V0) {
                V3();
            }
        }
    }

    public final int r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            if (f2()) {
                if (L3()) {
                    return 18;
                }
                return 17;
            } else if (L3()) {
                return 12;
            } else {
                return 15;
            }
        }
        return invokeV.intValue;
    }

    @Nullable
    public d13 t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.I0;
        }
        return (d13) invokeV.objValue;
    }

    public String v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            jx1 jx1Var = this.L0;
            if (jx1Var != null) {
                return jx1Var.a();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public pm3 x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.M0;
        }
        return (pm3) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            super.z0();
            this.C0.a();
            if (i.b()) {
                xo3.q().postAtFrontOfQueue(new c(this));
            } else {
                l3();
            }
        }
    }

    public FrameLayout z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return this.K0;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public la2() {
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
        this.H0 = new d13();
        this.J0 = new TreeMap();
        this.Q0 = 0;
        this.T0 = false;
        this.U0 = false;
        this.V0 = false;
    }

    private void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            if (Z()) {
                pause();
            }
            if (W0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.L0.a())));
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.B0();
            Map<String, jx1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (jx1 jx1Var : this.J0.values()) {
                    if (jx1Var != null) {
                        jx1Var.c0();
                    }
                }
            } else {
                jx1 jx1Var2 = this.L0;
                if (jx1Var2 != null) {
                    jx1Var2.c0();
                }
            }
            C3();
        }
    }

    public final boolean G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SwanAppConfigData s = qw2.T().s();
            boolean z = false;
            if (s == null) {
                return false;
            }
            return !((TextUtils.equals(s.f(), this.H0.a) || s.r(this.H0.a)) ? true : true);
        }
        return invokeV.booleanValue;
    }

    public final boolean K3() {
        InterceptResult invokeV;
        boolean z;
        SwanAppConfigData s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ma2 N1 = N1();
            if (N1 == null) {
                return false;
            }
            sb3 sb3Var = this.P0;
            if (sb3Var != null && sb3Var.k) {
                z = true;
            } else {
                z = false;
            }
            if (z || (s = qw2.T().s()) == null) {
                return false;
            }
            return !J3(N1, s);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ja2
    public boolean g2() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        e13 e13Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            qw2 T2 = qw2.T();
            if (T2 == null || (s = T2.s()) == null || !s.n() || (e13Var = this.d0) == null) {
                return false;
            }
            return s.r(e13Var.i());
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ka3.a
    public ka3 getFloatLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.N0 == null) {
                if (this.O0 == null) {
                    return null;
                }
                this.N0 = new ka3(this, (LinearLayout) this.O0.findViewById(R.id.obfuscated_res_0x7f09018d), K1().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070160));
            }
            return this.N0;
        }
        return (ka3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ja2
    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            jx1 jx1Var = this.L0;
            if (jx1Var != null) {
                jx1Var.R();
            }
            E3();
            s3(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(bi2.n(cb3.K().getAppId()));
            }
            this.g0.u(ku2.M().a(), I1(), this.h0, false);
        }
    }

    public static la2 O3(e13 e13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, e13Var)) == null) {
            la2 la2Var = new la2();
            if (e13Var != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", e13Var.m());
                la2Var.j1(bundle);
            }
            return la2Var;
        }
        return (la2) invokeL.objValue;
    }

    public static void W3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            b1 = str;
        }
    }

    public final boolean M3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (this.J0.isEmpty() || this.J0.get(str) == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void N3(hi3 hi3Var) {
        jh3 jh3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, hi3Var) == null) && (jh3Var = this.G0) != null) {
            wh3.i(jh3Var, hi3Var);
            this.G0 = null;
        }
    }

    public void T3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.V0 = z;
        }
    }

    public final void Z3(jx1 jx1Var) {
        qc2 qc2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, jx1Var) != null) || (qc2Var = this.R0) == null || jx1Var == null) {
            return;
        }
        jx1Var.S(qc2Var);
        if (jx1Var.j() != null) {
            jx1Var.S(this.R0);
        }
    }

    public final void f3(jx1 jx1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048610, this, jx1Var) != null) || jx1Var == null) {
            return;
        }
        qc2 qc2Var = this.R0;
        if (qc2Var != null) {
            jx1Var.s(qc2Var);
        }
        jx1Var.Y(B3());
    }

    @Override // com.baidu.tieba.ja2, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, motionEvent)) == null) {
            if (b2() && this.L0.isSlidable(motionEvent)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void s0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, activity) == null) {
            super.s0(activity);
            if (W0) {
                Log.d("SwanAppFragment", "onAttach() obj: " + this);
            }
        }
    }

    @Override // com.baidu.tieba.ja2
    public boolean v2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048639, this, i2)) == null) {
            boolean v2 = super.v2(i2);
            P3();
            return v2;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.ja2
    public void x1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i2) == null) {
            if (!sb3.f(this.P0)) {
                super.x1(i2);
                return;
            }
            boolean z = true;
            if (!I3()) {
                z = true ^ mo3.h(this.c0);
            }
            y1(i2, z);
            P3();
        }
    }

    public String y3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, str)) == null) {
            if (this.J0.containsKey(str)) {
                return this.J0.get(str).a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void U3(d13 d13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, d13Var) == null) {
            try {
                if (W0) {
                    Log.d("SwanAppFragment", "setLastPageParams =" + d13Var);
                }
                if (d13Var == null) {
                    Z0 = null;
                } else {
                    Z0 = (d13) d13Var.clone();
                }
            } catch (Exception e2) {
                if (W0) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void D3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || I3()) {
            return;
        }
        qw2 T2 = qw2.T();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (T2.f(str).h && this.R0 == null) {
            this.R0 = new f(this);
        }
    }

    @Override // com.baidu.tieba.ja2, com.baidu.swan.support.v4.app.Fragment
    public void m1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048622, this, z) != null) || !l0()) {
            return;
        }
        super.m1(z);
        if (W0) {
            Log.d("SwanAppFragment", "setUserVisibleHint isVisibleToUser: " + z);
        }
        if (z) {
            resume();
            u3(false);
            return;
        }
        pause();
    }

    public final void s3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048635, this, z) == null) && ku2.K().k(z, 2)) {
            b13.l(getContext(), this.g0, this.f0, db3.b0().W().f0().paNumber);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, bundle) == null) {
            super.v0(bundle);
            Q3();
            if (W0) {
                Log.d("SwanAppFragment", "onCreate() obj: " + this);
            }
            xn3.j(new a(this), "SwanAppPageHistory");
            h43.a("route", "fragment create.");
        }
    }

    private void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            if (Z()) {
                resume();
            }
            kh4 kh4Var = this.g0;
            if (kh4Var != null && kh4Var.i()) {
                this.g0.B(ku2.M().a());
            }
            if (W0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.L0.a())));
            }
        }
    }

    @DebugTrace
    public void E3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            FragmentActivity activity = getActivity();
            if (this.h0 == null) {
                this.h0 = new SwanAppMenuHeaderView(getContext());
            }
            if (activity != null && this.g0 == null) {
                this.g0 = new kh4(activity, this.f0, r3(), ku2.K(), new mq3());
                new t03(this.g0, this, this.h0).z();
                if (z03.e()) {
                    this.g0.l(50);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ja2
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (getFloatLayer() != null && getFloatLayer().e() && getFloatLayer().f()) {
                return true;
            }
            if ((getFloatLayer() != null && getFloatLayer().c()) || PaymentManager.k()) {
                return true;
            }
            jx1 jx1Var = this.L0;
            if (jx1Var != null) {
                if (cy2.g(jx1Var.a())) {
                    return true;
                }
                return this.L0.H();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ja2
    public void O2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.L0 == null) {
                if (W0) {
                    Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.L0.a());
            mx1 j = this.L0.j();
            if (j != null) {
                hashMap.put("webViewUrl", j.getCurrentPageUrl());
            }
            qw2.T().u(new el2("sharebtn", hashMap));
        }
    }

    @Override // com.baidu.tieba.ja2
    public void k2() {
        e13 P1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            R1();
            gi3 gi3Var = new gi3();
            gi3Var.e = "gohome";
            gi3Var.c = "bar";
            la2 H = qw2.T().H();
            if (H == null) {
                P1 = null;
            } else {
                P1 = H.P1();
            }
            if (P1 != null && !TextUtils.isEmpty(P1.i())) {
                gi3Var.a("page", P1.i());
            }
            B1(gi3Var);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.kx1] */
    @NonNull
    public Pair<Integer, Integer> p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            jx1 jx1Var = this.L0;
            if (jx1Var == null) {
                return new Pair<>(0, 0);
            }
            View currentWebView = jx1Var.r().getCurrentWebView();
            if (currentWebView == null) {
                return new Pair<>(0, 0);
            }
            return new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
        }
        return (Pair) invokeV.objValue;
    }

    public List<String> w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, jx1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, jx1> entry : this.J0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(entry.getValue().a());
                    }
                }
            }
            jx1 jx1Var = this.L0;
            if (jx1Var != null) {
                String a2 = jx1Var.a();
                if (!arrayList.contains(a2)) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean J3(ma2 ma2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, ma2Var, swanAppConfigData)) == null) {
            ja2 j = ma2Var.j(0);
            if (j == null || !(j instanceof la2)) {
                return false;
            }
            String e2 = ((la2) j).o3().e();
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
    public final void P3() {
        int i2;
        sb3 sb3Var;
        kx1 kx1Var;
        TextView centerTitleView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || this.f0 == null) {
            return;
        }
        int i3 = 1;
        boolean z = false;
        if (I3()) {
            D2(true, this.U0);
            i2 = 0;
        } else if (H3()) {
            D2(false, false);
            jx1 jx1Var = this.L0;
            if (jx1Var != null) {
                if (jx1Var.j() != null) {
                    kx1Var = this.L0.j().r();
                } else {
                    kx1Var = this.L0.r();
                }
                if (kx1Var != null) {
                    i2 = kx1Var.getWebViewScrollY();
                    sb3Var = this.P0;
                    if (sb3Var != null && sb3Var.i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            sb3Var = this.P0;
            if (sb3Var != null) {
                i3 = 0;
            }
        } else {
            D2(false, false);
            i2 = X0 + this.Q0;
            centerTitleView = this.f0.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i3);
            }
            a4(i2);
            c4(z);
        }
        z = true;
        centerTitleView = this.f0.getCenterTitleView();
        if (centerTitleView != null) {
        }
        a4(i2);
        c4(z);
    }

    public final void V3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "setting immersive portrait fullscreen video");
            }
            kn3.h();
            if (this.c0.getWindow() != null) {
                this.c0.getWindow().getDecorView().setSystemUiVisibility(5376);
            }
            View b2 = z93.b();
            if (b2 != null) {
                b2.setVisibility(0);
                b2.findViewById(R.id.obfuscated_res_0x7f0925b7).setVisibility(8);
            }
            SwanAppActionBar L1 = L1();
            if (L1 != null) {
                L1.setRightMenuStyle();
                L1.setRightZoneImmersiveStyle();
                L1.setBackgroundColor(0);
            }
            View b0 = b0();
            if (b0 != null) {
                b0.findViewById(R.id.obfuscated_res_0x7f091126).setBackgroundColor(0);
                FrameLayout frameLayout = (FrameLayout) b0.findViewById(R.id.obfuscated_res_0x7f09018e);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams);
            }
        }
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            Map<String, jx1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (jx1 jx1Var : this.J0.values()) {
                    if (jx1Var != null) {
                        Z3(jx1Var);
                        jx1Var.destroy();
                    }
                }
                this.J0.clear();
            } else {
                jx1 jx1Var2 = this.L0;
                if (jx1Var2 != null) {
                    Z3(jx1Var2);
                    this.L0.destroy();
                }
            }
            this.L0 = null;
            if (W0) {
                Log.d("SwanAppFragment", "onDestroy() obj: " + this);
            }
            if (!this.T0) {
                ih2.n(qw2.T().getActivity());
            }
        }
    }

    public void resume() {
        boolean z;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
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
                z2((b2() || G3()) ? true : true);
                this.L0.onResume();
                S3();
                R3("onShow");
                r13.e().i(true);
            }
            d82.i("SwanApp", "onShow");
            cy2.i(a2, true);
            if (d82.f()) {
                y92.b();
            }
            if (db3.b0() != null) {
                str = db3.b0().O();
            }
            ku2.H().e(str);
        }
    }

    public final void Q3() {
        Bundle o;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || (o = o()) == null) {
            return;
        }
        this.I0 = Z0;
        if (W0) {
            Log.d("SwanAppFragment", "restoreArguments sPrePageParams=" + this.I0);
        }
        e13 g2 = e13.g(o.getString("ai_apps_param"));
        this.d0 = g2;
        if (g2 == null) {
            d13 d13Var = this.H0;
            d13Var.a = "";
            d13Var.b = "";
            d13Var.e = "";
            d13Var.f = "";
        } else {
            this.H0.a = g2.i();
            this.H0.b = this.d0.j();
            this.H0.e = this.d0.l();
            this.H0.f = this.d0.k();
        }
        d13 d13Var2 = this.H0;
        d13Var2.d = ve3.b(d13Var2.e());
        sb3 f2 = qw2.T().f(this.H0.g());
        this.P0 = f2;
        if (f2.p) {
            this.P0 = qw2.T().j(this.H0.e());
        }
        if (this.E0) {
            sb3 sb3Var = this.P0;
            sb3Var.f = false;
            sb3Var.h = true;
            sb3Var.p = true;
        }
        this.Q0 = K1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070160);
    }

    public final void S3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (TextUtils.equals(a1, this.L0.a()) && !TextUtils.equals(b1, "switchTab")) {
                return;
            }
            int o = this.M0.o(o3().g());
            hl2 hl2Var = new hl2();
            hl2Var.c = a1;
            hl2Var.d = this.L0.a();
            hl2Var.e = b1;
            hl2Var.f = this.H0.a;
            hl2Var.g = String.valueOf(o);
            b1 = "";
            if (W0) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + hl2Var.c + " ,toId: " + hl2Var.d + " ,RouteType: " + hl2Var.e + " page:" + hl2Var.f + ",TabIndex: " + hl2Var.g);
            }
            qw2.T().u(hl2Var);
            a1 = this.L0.a();
        }
    }

    public void pause() {
        boolean z;
        String a2;
        PullToRefreshBaseWebView f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
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
                R3("onHide");
                r13.e().i(false);
            }
            if (getFloatLayer() != null && !getFloatLayer().c() && (!getFloatLayer().f() || getFloatLayer().j())) {
                getFloatLayer().g();
            }
            d82.i("SwanApp", "onHide");
            cy2.i(a2, false);
            if (!z && (f0 = this.L0.f0()) != null) {
                f0.w(false);
            }
            if (db3.b0() != null) {
                str = db3.b0().O();
            }
            ku2.H().f(str);
        }
    }

    public final void R3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.L0.a());
            fl2 fl2Var = new fl2(hashMap);
            if (W0) {
                Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.L0.a());
            }
            qw2.T().u(fl2Var);
        }
    }

    public void X3(d13 d13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, d13Var) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "switchTab pageParam: " + d13Var);
            }
            if (this.M0.o(o3().g()) == this.M0.o(d13Var.g())) {
                d13 d13Var2 = this.H0;
                d13Var2.e = d13Var.e;
                d13Var2.f = d13Var.f;
                return;
            }
            this.M0.E(d13Var.g());
            onPause();
            n3(d13Var, "");
        }
    }

    public final void c4(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            int i3 = 0;
            if (z) {
                eq3 eq3Var = this.u0;
                if (eq3Var != null && eq3Var.i()) {
                    i2 = uo3.t();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.K0.getLayoutParams();
                    layoutParams.topMargin = i3;
                    this.K0.setLayoutParams(layoutParams);
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.e0.getLayoutParams();
                    layoutParams2.topMargin = i2;
                    this.e0.setLayoutParams(layoutParams2);
                }
            } else {
                i3 = K1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070160);
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

    public final void u3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            if (ku2.K().k(z, 1)) {
                b13.k(getContext(), this.f0, db3.b0().W().f0().paNumber);
            } else if (db3.b0() == null) {
            } else {
                b13.o(this.f0, db3.b0().U().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    @Override // com.baidu.tieba.ja2
    public void W1(View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view2) == null) {
            super.W1(view2);
            boolean z2 = false;
            if (!b2() && !G3()) {
                z = false;
            } else {
                z = true;
            }
            z2(z);
            if (K3()) {
                h2();
            }
            P3();
            this.f0.setOnDoubleClickListener(new b(this));
            if (!nh3.i()) {
                nh3.d(cb3.K().q().W());
            }
            if (I3() && G3()) {
                z2 = true;
            }
            this.U0 = z2;
            if (z2) {
                h3();
            }
        }
    }

    public final void Y3(String str, d13 d13Var) {
        jx1 jx1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048603, this, str, d13Var) == null) && this.L0 != (jx1Var = this.J0.get(str)) && jx1Var != null) {
            sb3 f2 = qw2.T().f(str);
            jx1Var.y(this.K0, f2);
            if (!jx1Var.c()) {
                jx1Var.N(this.K0, f2);
            }
            jx1Var.B(0);
            jx1 jx1Var2 = this.L0;
            if (jx1Var2 != null) {
                jx1Var2.B(8);
            }
            this.L0 = jx1Var;
            d13 d13Var2 = this.H0;
            d13Var2.e = d13Var.e;
            d13Var2.f = d13Var.f;
            jx1Var.g(d13Var2);
        }
    }

    public final void a4(int i2) {
        TextView centerTitleView;
        View e2;
        Drawable background;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
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
            eq3 eq3Var = this.u0;
            if (eq3Var != null && eq3Var.i() && (e2 = this.u0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.f0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            sb3 sb3Var = this.P0;
            if (sb3Var != null && sb3Var.i && (centerTitleView = this.f0.getCenterTitleView()) != null) {
                centerTitleView.setAlpha(f2);
            }
            Drawable background3 = this.i0.getBackground();
            if (background3 != null) {
                background3.setAlpha(i4);
            }
        }
    }

    public final void j3(View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, view2) == null) {
            h43.a("route", "createSlaveWebView start.");
            String h2 = this.d0.h();
            String j = this.d0.j();
            String i2 = this.d0.i();
            String a2 = xo3.a(h2, i2, j);
            this.L0 = ih2.h(a2);
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
                this.L0 = i3(h2, i2, j, "");
            }
            this.L0.g(this.H0);
            sb3 f2 = qw2.T().f(i2);
            this.L0.y(this.K0, f2);
            this.L0.N(this.K0, f2);
            D3(i2);
            f3(this.L0);
            if (g2()) {
                this.J0.put(i2, this.L0);
                this.M0.f(view2, getContext(), i2);
            }
            h43.a("route", "createSlaveWebView end.");
            g3();
        }
    }

    public final jx1 i3(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048615, this, str, str2, str3, str4)) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad start.");
            }
            ih2.e f2 = ih2.f(getActivity(), nh2.c(str2));
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = i43.q("route", str4);
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
            ih2.q(f2, new d(this, f2, str4, str2, str, str3));
            if (W0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad end.");
            }
            return f2.a;
        }
        return (jx1) invokeLLLL.objValue;
    }

    public final void k3(d13 d13Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048619, this, d13Var, str) == null) && this.J0.get(d13Var.d) == null) {
            String a2 = xo3.a(d13Var.c, d13Var.a, d13Var.b);
            jx1 h2 = ih2.h(a2);
            if (h2 != null) {
                if (W0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + a2);
                }
                this.J0.put(d13Var.a, h2);
            } else {
                if (W0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                h2 = i3(d13Var.c, d13Var.a, d13Var.b, str);
                this.J0.put(d13Var.a, h2);
            }
            D3(d13Var.a);
            f3(h2);
        }
    }

    public void n3(d13 d13Var, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, d13Var, str) == null) {
            U3(this.H0);
            this.I0 = Z0;
            if (W0) {
                Log.d("SwanAppFragment", "doSwitchTab mPrePageParams=" + this.I0);
            }
            String str3 = d13Var.a;
            String str4 = d13Var.d;
            qw2 T2 = qw2.T();
            String str5 = "";
            if (TextUtils.isEmpty(str4)) {
                str2 = "";
            } else {
                str2 = str4;
            }
            sb3 f2 = T2.f(str2);
            d13 d13Var2 = this.H0;
            d13Var2.a = str3;
            if (d13Var != null) {
                str5 = d13Var.f();
            }
            d13Var2.b = str5;
            this.H0.d = str4;
            this.P0 = f2;
            boolean z = !M3(str4);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    j43.c(7, str);
                } else {
                    j43.c(6, str);
                }
            }
            if (!z) {
                Y3(str4, d13Var);
            } else {
                k3(d13Var, str);
                Y3(str3, d13Var);
            }
            if (!TextUtils.isEmpty(str)) {
                i43.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                j43.a(str, d13Var);
            }
            x2(f2.b);
            E2(SwanAppConfigData.t(f2.c));
            v2(f2.a);
            P3();
            b4();
            d82.i("SwanAppFragment", "switch tab title: " + f2.b + " page:" + str3);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048644, this, layoutInflater, viewGroup, bundle)) == null) {
            h43.a("route", "fragment onCreateView.");
            View b2 = n53.a().b(R.layout.obfuscated_res_0x7f0d00ac, viewGroup, false);
            this.K0 = (FrameLayout) b2.findViewById(R.id.obfuscated_res_0x7f09018e);
            W1(b2);
            V2(b2);
            this.M0 = new pm3(this);
            j3(b2);
            if (!z03.e() && !z03.f()) {
                y03.b(this.L0.a(), String.valueOf(z03.d()), String.valueOf(z03.a(z03.b())));
            }
            if (V1()) {
                b2 = Y1(b2);
            }
            this.O0 = E1(b2, this);
            I2(this.L0.z());
            r13.e().m();
            return this.O0;
        }
        return (View) invokeLLL.objValue;
    }
}
