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
import com.baidu.tieba.mh2;
import com.baidu.tieba.oa3;
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
public class pa2 extends na2 implements oa3.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean W0;
    public static final int X0;
    public static String Y0;
    public static h13 Z0;
    public static String a1;
    public static String b1;
    public transient /* synthetic */ FieldHolder $fh;
    public nh3 G0;
    public h13 H0;
    public h13 I0;
    public Map<String, nx1> J0;
    public FrameLayout K0;
    public nx1 L0;
    public tm3 M0;
    public oa3 N0;
    public View O0;
    public wb3 P0;
    public int Q0;
    public uc2 R0;
    public lw1 S0;
    public boolean T0;
    public boolean U0;
    public boolean V0;

    @Override // com.baidu.tieba.na2
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class e implements aq3<hg3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pa2 a;

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

        public e(pa2 pa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(hg3 hg3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hg3Var) == null) && hg3Var != null && !hg3Var.d && hg3Var.j == 1) {
                bp3.e0(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pa2 a;

        public a(pa2 pa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pa2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.S0 = ou2.Q();
                lw1 lw1Var = this.a.S0;
                pa2 pa2Var = this.a;
                lw1Var.a(pa2Var.b0, pa2Var.d0, pa2Var.getContext());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements SwanAppActionBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pa2 a;

        public b(pa2 pa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pa2Var;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void onDoubleClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String a = this.a.L0.a();
                nl2 nl2Var = new nl2();
                nl2Var.c = oq3.a(a, "scrollViewBackToTop");
                uw2.T().m(a, nl2Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pa2 a;

        public c(pa2 pa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pa2Var;
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

    /* loaded from: classes7.dex */
    public class d implements mh2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ pa2 f;

        public d(pa2 pa2Var, mh2.e eVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa2Var, eVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = pa2Var;
            this.a = eVar;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [com.baidu.tieba.ox1] */
        @Override // com.baidu.tieba.mh2.f
        public void onReady() {
            String str;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                yh2 yh2Var = new yh2();
                yh2Var.i = this.a.a.I();
                if (!TextUtils.isEmpty(this.b)) {
                    n43.e(this.a, this.b);
                }
                String b = ze3.b(this.c);
                yh2Var.a = this.d;
                if (TextUtils.isEmpty(this.e)) {
                    str = this.c;
                } else {
                    str = this.c + "?" + this.e;
                }
                yh2Var.b = str;
                if (hb3.b0() != null) {
                    yh2Var.c = hb3.b0().d0(b);
                    yh2Var.f = hb3.b0().X(b);
                }
                yh2Var.k = vh2.c(hb3.M(), yh2Var.b);
                yh2Var.d = uw2.T().f(b).g;
                yh2Var.e = String.valueOf(e82.a());
                if (!pa2.W0 && !uw2.T().M()) {
                    z = false;
                } else {
                    z = true;
                }
                yh2Var.g = z;
                if (g73.H()) {
                    yh2Var.j = k82.d();
                }
                if (!TextUtils.isEmpty(this.b)) {
                    String str2 = this.b;
                    yh2Var.h = str2;
                    m43.q("route", str2).F(new UbcFlowEvent("slave_dispatch_start"));
                }
                oo3.d();
                this.a.a.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.c);
                this.a.a.Q(yh2Var.b);
                uw2.T().m(this.a.a.a(), yh2.a(yh2Var));
                if (zh2.b()) {
                    zh2 zh2Var = new zh2();
                    zh2Var.a = this.a.a.a();
                    uw2.T().u(zh2.a(zh2Var));
                }
                rh3.F(this.a.a.a(), yh2Var.b);
                if (pa2.W0) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + yh2Var.toString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements uc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pa2 a;

        public f(pa2 pa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pa2Var;
        }

        @Override // com.baidu.tieba.uc2
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIIII(1048576, this, i, i2, i3, i4) != null) {
                return;
            }
            this.a.a4(i2);
        }
    }

    /* loaded from: classes7.dex */
    public class g implements wc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pa2 a;

        public g(pa2 pa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pa2Var;
        }

        @Override // com.baidu.tieba.wc2
        public void a(qx1 qx1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, qx1Var) == null) && qx1Var != null) {
                qx1Var.s(this.a.R0);
                qx1Var.X(this.a.A3());
                v13.e().a(qx1Var);
            }
        }

        @Override // com.baidu.tieba.wc2
        public void b(qx1 qx1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qx1Var) == null) && qx1Var != null) {
                qx1Var.S(this.a.R0);
                v13.e().b(qx1Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends sc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pa2 c;

        public h(pa2 pa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pa2Var;
        }

        @Override // com.baidu.tieba.sc2, com.baidu.tieba.vc2
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
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-524674205, "Lcom/baidu/tieba/pa2$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-524674205, "Lcom/baidu/tieba/pa2$i;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (a < 0) {
                    ou2.g0().getSwitch("swan_app_fragment_destroy_switch", 1);
                    a = 1;
                }
                if (pa2.W0) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948055240, "Lcom/baidu/tieba/pa2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948055240, "Lcom/baidu/tieba/pa2;");
                return;
            }
        }
        W0 = rr1.a;
        X0 = yo3.g(149.0f);
        Y0 = "-1";
        a1 = "-1";
    }

    public final sc2 A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new h(this);
        }
        return (sc2) invokeV.objValue;
    }

    public final wc2 B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new g(this);
        }
        return (wc2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.na2, com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.C0();
        }
    }

    public final void C3() {
        ks2 D0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            nx1 q3 = q3();
            if ((q3 instanceof SwanAppWebViewManager) && (D0 = ((SwanAppWebViewManager) q3).D0()) != null) {
                D0.d();
            }
        }
    }

    public boolean F3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            tm3 tm3Var = this.M0;
            if (tm3Var == null) {
                return false;
            }
            return tm3Var.p();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.na2
    public wb3 H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.P0;
        }
        return (wb3) invokeV.objValue;
    }

    public final boolean H3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            wb3 wb3Var = this.P0;
            if (wb3Var != null && wb3Var.h) {
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
            wb3 wb3Var = this.P0;
            if (wb3Var != null) {
                return TextUtils.equals(wb3Var.j, ExceptionHandlerImpl.KEY_CUSTOM);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean L3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SwanAppConfigData s = uw2.T().s();
            if (s != null && !TextUtils.equals(s.f(), this.H0.e())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void b4() {
        i13 i13Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048606, this) != null) || (i13Var = this.d0) == null) {
            return;
        }
        i13Var.n();
    }

    public PullToRefreshBaseWebView f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            nx1 nx1Var = this.L0;
            if (nx1Var != null) {
                return nx1Var.f0();
            }
            return null;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.G0 = ai3.c("805");
        }
    }

    public final void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            gb3.K().q().e0().e("mapp_i_custom_navigation_bar", new e(this));
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
    public h13 o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.H0;
        }
        return (h13) invokeV.objValue;
    }

    @Override // com.baidu.tieba.na2, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            super.onPause();
            a1();
        }
    }

    @Override // com.baidu.tieba.na2, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onResume();
            e1();
            u3(false);
        }
    }

    public nx1 q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.L0;
        }
        return (nx1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.na2
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
    public h13 t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.I0;
        }
        return (h13) invokeV.objValue;
    }

    public String v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            nx1 nx1Var = this.L0;
            if (nx1Var != null) {
                return nx1Var.a();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public tm3 x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.M0;
        }
        return (tm3) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            super.z0();
            this.C0.a();
            if (i.b()) {
                bp3.q().postAtFrontOfQueue(new c(this));
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

    public pa2() {
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
        this.H0 = new h13();
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
            Map<String, nx1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (nx1 nx1Var : this.J0.values()) {
                    if (nx1Var != null) {
                        nx1Var.c0();
                    }
                }
            } else {
                nx1 nx1Var2 = this.L0;
                if (nx1Var2 != null) {
                    nx1Var2.c0();
                }
            }
            C3();
        }
    }

    public final boolean G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SwanAppConfigData s = uw2.T().s();
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
            qa2 N1 = N1();
            if (N1 == null) {
                return false;
            }
            wb3 wb3Var = this.P0;
            if (wb3Var != null && wb3Var.k) {
                z = true;
            } else {
                z = false;
            }
            if (z || (s = uw2.T().s()) == null) {
                return false;
            }
            return !J3(N1, s);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.na2
    public boolean g2() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        i13 i13Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            uw2 T2 = uw2.T();
            if (T2 == null || (s = T2.s()) == null || !s.n() || (i13Var = this.d0) == null) {
                return false;
            }
            return s.r(i13Var.i());
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.oa3.a
    public oa3 getFloatLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.N0 == null) {
                if (this.O0 == null) {
                    return null;
                }
                this.N0 = new oa3(this, (LinearLayout) this.O0.findViewById(R.id.obfuscated_res_0x7f090189), K1().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070162));
            }
            return this.N0;
        }
        return (oa3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.na2
    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            nx1 nx1Var = this.L0;
            if (nx1Var != null) {
                nx1Var.R();
            }
            E3();
            s3(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(fi2.n(gb3.K().getAppId()));
            }
            this.g0.u(ou2.M().a(), I1(), this.h0, false);
        }
    }

    public static pa2 O3(i13 i13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, i13Var)) == null) {
            pa2 pa2Var = new pa2();
            if (i13Var != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", i13Var.m());
                pa2Var.j1(bundle);
            }
            return pa2Var;
        }
        return (pa2) invokeL.objValue;
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

    public void N3(li3 li3Var) {
        nh3 nh3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, li3Var) == null) && (nh3Var = this.G0) != null) {
            ai3.i(nh3Var, li3Var);
            this.G0 = null;
        }
    }

    public void T3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.V0 = z;
        }
    }

    public final void Z3(nx1 nx1Var) {
        uc2 uc2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, nx1Var) != null) || (uc2Var = this.R0) == null || nx1Var == null) {
            return;
        }
        nx1Var.S(uc2Var);
        if (nx1Var.j() != null) {
            nx1Var.S(this.R0);
        }
    }

    public final void f3(nx1 nx1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048610, this, nx1Var) != null) || nx1Var == null) {
            return;
        }
        uc2 uc2Var = this.R0;
        if (uc2Var != null) {
            nx1Var.s(uc2Var);
        }
        nx1Var.Y(B3());
    }

    @Override // com.baidu.tieba.na2, com.baidu.searchbox.widget.SlideInterceptor
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

    @Override // com.baidu.tieba.na2
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

    @Override // com.baidu.tieba.na2
    public void x1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i2) == null) {
            if (!wb3.f(this.P0)) {
                super.x1(i2);
                return;
            }
            boolean z = true;
            if (!I3()) {
                z = true ^ qo3.h(this.c0);
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

    public static void U3(h13 h13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, h13Var) == null) {
            try {
                if (W0) {
                    Log.d("SwanAppFragment", "setLastPageParams =" + h13Var);
                }
                if (h13Var == null) {
                    Z0 = null;
                } else {
                    Z0 = (h13) h13Var.clone();
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
        uw2 T2 = uw2.T();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (T2.f(str).h && this.R0 == null) {
            this.R0 = new f(this);
        }
    }

    @Override // com.baidu.tieba.na2, com.baidu.swan.support.v4.app.Fragment
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
        if ((interceptable == null || interceptable.invokeZ(1048635, this, z) == null) && ou2.K().k(z, 2)) {
            f13.l(getContext(), this.g0, this.f0, hb3.b0().W().f0().paNumber);
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
            bo3.j(new a(this), "SwanAppPageHistory");
            l43.a("route", "fragment create.");
        }
    }

    private void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            if (Z()) {
                resume();
            }
            oh4 oh4Var = this.g0;
            if (oh4Var != null && oh4Var.i()) {
                this.g0.B(ou2.M().a());
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
                this.g0 = new oh4(activity, this.f0, r3(), ou2.K(), new qq3());
                new x03(this.g0, this, this.h0).z();
                if (d13.e()) {
                    this.g0.l(50);
                }
            }
        }
    }

    @Override // com.baidu.tieba.na2
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
            nx1 nx1Var = this.L0;
            if (nx1Var != null) {
                if (gy2.g(nx1Var.a())) {
                    return true;
                }
                return this.L0.H();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.na2
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
            qx1 j = this.L0.j();
            if (j != null) {
                hashMap.put("webViewUrl", j.getCurrentPageUrl());
            }
            uw2.T().u(new il2("sharebtn", hashMap));
        }
    }

    @Override // com.baidu.tieba.na2
    public void k2() {
        i13 O1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            R1();
            ki3 ki3Var = new ki3();
            ki3Var.e = "gohome";
            ki3Var.c = "bar";
            pa2 H = uw2.T().H();
            if (H == null) {
                O1 = null;
            } else {
                O1 = H.O1();
            }
            if (O1 != null && !TextUtils.isEmpty(O1.i())) {
                ki3Var.a("page", O1.i());
            }
            B1(ki3Var);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.ox1] */
    @NonNull
    public Pair<Integer, Integer> p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            nx1 nx1Var = this.L0;
            if (nx1Var == null) {
                return new Pair<>(0, 0);
            }
            View currentWebView = nx1Var.r().getCurrentWebView();
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
            Map<String, nx1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, nx1> entry : this.J0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(entry.getValue().a());
                    }
                }
            }
            nx1 nx1Var = this.L0;
            if (nx1Var != null) {
                String a2 = nx1Var.a();
                if (!arrayList.contains(a2)) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean J3(qa2 qa2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, qa2Var, swanAppConfigData)) == null) {
            na2 j = qa2Var.j(0);
            if (j == null || !(j instanceof pa2)) {
                return false;
            }
            String e2 = ((pa2) j).o3().e();
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
        wb3 wb3Var;
        ox1 ox1Var;
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
            nx1 nx1Var = this.L0;
            if (nx1Var != null) {
                if (nx1Var.j() != null) {
                    ox1Var = this.L0.j().r();
                } else {
                    ox1Var = this.L0.r();
                }
                if (ox1Var != null) {
                    i2 = ox1Var.getWebViewScrollY();
                    wb3Var = this.P0;
                    if (wb3Var != null && wb3Var.i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            wb3Var = this.P0;
            if (wb3Var != null) {
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
            on3.h();
            if (this.c0.getWindow() != null) {
                this.c0.getWindow().getDecorView().setSystemUiVisibility(5376);
            }
            View b2 = da3.b();
            if (b2 != null) {
                b2.setVisibility(0);
                b2.findViewById(R.id.obfuscated_res_0x7f0925f9).setVisibility(8);
            }
            SwanAppActionBar L1 = L1();
            if (L1 != null) {
                L1.setRightMenuStyle();
                L1.setRightZoneImmersiveStyle();
                L1.setBackgroundColor(0);
            }
            View b0 = b0();
            if (b0 != null) {
                b0.findViewById(R.id.obfuscated_res_0x7f091128).setBackgroundColor(0);
                FrameLayout frameLayout = (FrameLayout) b0.findViewById(R.id.obfuscated_res_0x7f09018a);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams);
            }
        }
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            Map<String, nx1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (nx1 nx1Var : this.J0.values()) {
                    if (nx1Var != null) {
                        Z3(nx1Var);
                        nx1Var.destroy();
                    }
                }
                this.J0.clear();
            } else {
                nx1 nx1Var2 = this.L0;
                if (nx1Var2 != null) {
                    Z3(nx1Var2);
                    this.L0.destroy();
                }
            }
            this.L0 = null;
            if (W0) {
                Log.d("SwanAppFragment", "onDestroy() obj: " + this);
            }
            if (!this.T0) {
                mh2.n(uw2.T().getActivity());
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
                v13.e().i(true);
            }
            h82.i("SwanApp", "onShow");
            gy2.i(a2, true);
            if (h82.f()) {
                ca2.b();
            }
            if (hb3.b0() != null) {
                str = hb3.b0().O();
            }
            ou2.H().e(str);
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
        i13 g2 = i13.g(o.getString("ai_apps_param"));
        this.d0 = g2;
        if (g2 == null) {
            h13 h13Var = this.H0;
            h13Var.a = "";
            h13Var.b = "";
            h13Var.e = "";
            h13Var.f = "";
        } else {
            this.H0.a = g2.i();
            this.H0.b = this.d0.j();
            this.H0.e = this.d0.l();
            this.H0.f = this.d0.k();
        }
        h13 h13Var2 = this.H0;
        h13Var2.d = ze3.b(h13Var2.e());
        wb3 f2 = uw2.T().f(this.H0.g());
        this.P0 = f2;
        if (f2.p) {
            this.P0 = uw2.T().j(this.H0.e());
        }
        if (this.E0) {
            wb3 wb3Var = this.P0;
            wb3Var.f = false;
            wb3Var.h = true;
            wb3Var.p = true;
        }
        this.Q0 = K1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070162);
    }

    public final void S3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (TextUtils.equals(a1, this.L0.a()) && !TextUtils.equals(b1, "switchTab")) {
                return;
            }
            int o = this.M0.o(o3().g());
            ll2 ll2Var = new ll2();
            ll2Var.c = a1;
            ll2Var.d = this.L0.a();
            ll2Var.e = b1;
            ll2Var.f = this.H0.a;
            ll2Var.g = String.valueOf(o);
            b1 = "";
            if (W0) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + ll2Var.c + " ,toId: " + ll2Var.d + " ,RouteType: " + ll2Var.e + " page:" + ll2Var.f + ",TabIndex: " + ll2Var.g);
            }
            uw2.T().u(ll2Var);
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
                v13.e().i(false);
            }
            if (getFloatLayer() != null && !getFloatLayer().c() && (!getFloatLayer().f() || getFloatLayer().j())) {
                getFloatLayer().g();
            }
            h82.i("SwanApp", "onHide");
            gy2.i(a2, false);
            if (!z && (f0 = this.L0.f0()) != null) {
                f0.w(false);
            }
            if (hb3.b0() != null) {
                str = hb3.b0().O();
            }
            ou2.H().f(str);
        }
    }

    public final void R3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.L0.a());
            jl2 jl2Var = new jl2(hashMap);
            if (W0) {
                Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.L0.a());
            }
            uw2.T().u(jl2Var);
        }
    }

    public void X3(h13 h13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, h13Var) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "switchTab pageParam: " + h13Var);
            }
            if (this.M0.o(o3().g()) == this.M0.o(h13Var.g())) {
                h13 h13Var2 = this.H0;
                h13Var2.e = h13Var.e;
                h13Var2.f = h13Var.f;
                return;
            }
            this.M0.E(h13Var.g());
            onPause();
            n3(h13Var, "");
        }
    }

    public final void c4(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            int i3 = 0;
            if (z) {
                iq3 iq3Var = this.u0;
                if (iq3Var != null && iq3Var.i()) {
                    i2 = yo3.t();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.K0.getLayoutParams();
                    layoutParams.topMargin = i3;
                    this.K0.setLayoutParams(layoutParams);
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.e0.getLayoutParams();
                    layoutParams2.topMargin = i2;
                    this.e0.setLayoutParams(layoutParams2);
                }
            } else {
                i3 = K1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070162);
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
            if (ou2.K().k(z, 1)) {
                f13.k(getContext(), this.f0, hb3.b0().W().f0().paNumber);
            } else if (hb3.b0() == null) {
            } else {
                f13.o(this.f0, hb3.b0().U().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    @Override // com.baidu.tieba.na2
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
            if (!rh3.i()) {
                rh3.d(gb3.K().q().W());
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

    public final void Y3(String str, h13 h13Var) {
        nx1 nx1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048603, this, str, h13Var) == null) && this.L0 != (nx1Var = this.J0.get(str)) && nx1Var != null) {
            wb3 f2 = uw2.T().f(str);
            nx1Var.y(this.K0, f2);
            if (!nx1Var.c()) {
                nx1Var.N(this.K0, f2);
            }
            nx1Var.B(0);
            nx1 nx1Var2 = this.L0;
            if (nx1Var2 != null) {
                nx1Var2.B(8);
            }
            this.L0 = nx1Var;
            h13 h13Var2 = this.H0;
            h13Var2.e = h13Var.e;
            h13Var2.f = h13Var.f;
            nx1Var.g(h13Var2);
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
            iq3 iq3Var = this.u0;
            if (iq3Var != null && iq3Var.i() && (e2 = this.u0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.f0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            wb3 wb3Var = this.P0;
            if (wb3Var != null && wb3Var.i && (centerTitleView = this.f0.getCenterTitleView()) != null) {
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
            l43.a("route", "createSlaveWebView start.");
            String h2 = this.d0.h();
            String j = this.d0.j();
            String i2 = this.d0.i();
            String a2 = bp3.a(h2, i2, j);
            this.L0 = mh2.h(a2);
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
            wb3 f2 = uw2.T().f(i2);
            this.L0.y(this.K0, f2);
            this.L0.N(this.K0, f2);
            D3(i2);
            f3(this.L0);
            if (g2()) {
                this.J0.put(i2, this.L0);
                this.M0.f(view2, getContext(), i2);
            }
            l43.a("route", "createSlaveWebView end.");
            g3();
        }
    }

    public final nx1 i3(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048615, this, str, str2, str3, str4)) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad start.");
            }
            mh2.e f2 = mh2.f(getActivity(), rh2.c(str2));
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = m43.q("route", str4);
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
            mh2.q(f2, new d(this, f2, str4, str2, str, str3));
            if (W0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad end.");
            }
            return f2.a;
        }
        return (nx1) invokeLLLL.objValue;
    }

    public final void k3(h13 h13Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048619, this, h13Var, str) == null) && this.J0.get(h13Var.d) == null) {
            String a2 = bp3.a(h13Var.c, h13Var.a, h13Var.b);
            nx1 h2 = mh2.h(a2);
            if (h2 != null) {
                if (W0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + a2);
                }
                this.J0.put(h13Var.a, h2);
            } else {
                if (W0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                h2 = i3(h13Var.c, h13Var.a, h13Var.b, str);
                this.J0.put(h13Var.a, h2);
            }
            D3(h13Var.a);
            f3(h2);
        }
    }

    public void n3(h13 h13Var, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, h13Var, str) == null) {
            U3(this.H0);
            this.I0 = Z0;
            if (W0) {
                Log.d("SwanAppFragment", "doSwitchTab mPrePageParams=" + this.I0);
            }
            String str3 = h13Var.a;
            String str4 = h13Var.d;
            uw2 T2 = uw2.T();
            String str5 = "";
            if (TextUtils.isEmpty(str4)) {
                str2 = "";
            } else {
                str2 = str4;
            }
            wb3 f2 = T2.f(str2);
            h13 h13Var2 = this.H0;
            h13Var2.a = str3;
            if (h13Var != null) {
                str5 = h13Var.f();
            }
            h13Var2.b = str5;
            this.H0.d = str4;
            this.P0 = f2;
            boolean z = !M3(str4);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    n43.c(7, str);
                } else {
                    n43.c(6, str);
                }
            }
            if (!z) {
                Y3(str4, h13Var);
            } else {
                k3(h13Var, str);
                Y3(str3, h13Var);
            }
            if (!TextUtils.isEmpty(str)) {
                m43.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                n43.a(str, h13Var);
            }
            x2(f2.b);
            E2(SwanAppConfigData.t(f2.c));
            v2(f2.a);
            P3();
            b4();
            h82.i("SwanAppFragment", "switch tab title: " + f2.b + " page:" + str3);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048644, this, layoutInflater, viewGroup, bundle)) == null) {
            l43.a("route", "fragment onCreateView.");
            View b2 = r53.a().b(R.layout.obfuscated_res_0x7f0d00af, viewGroup, false);
            this.K0 = (FrameLayout) b2.findViewById(R.id.obfuscated_res_0x7f09018a);
            W1(b2);
            V2(b2);
            this.M0 = new tm3(this);
            j3(b2);
            if (!d13.e() && !d13.f()) {
                c13.b(this.L0.a(), String.valueOf(d13.d()), String.valueOf(d13.a(d13.b())));
            }
            if (V1()) {
                b2 = Y1(b2);
            }
            this.O0 = E1(b2, this);
            I2(this.L0.z());
            v13.e().m();
            return this.O0;
        }
        return (View) invokeLLL.objValue;
    }
}
