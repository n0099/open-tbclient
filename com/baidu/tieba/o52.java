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
import com.baidu.tieba.lc2;
import com.baidu.tieba.n53;
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
public class o52 extends m52 implements n53.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean W0;
    public static final int X0;
    public static String Y0;
    public static gw2 Z0;
    public static String a1;
    public static String b1;
    public transient /* synthetic */ FieldHolder $fh;
    public mc3 G0;
    public gw2 H0;
    public gw2 I0;
    public Map<String, ns1> J0;
    public FrameLayout K0;
    public ns1 L0;
    public sh3 M0;
    public n53 N0;
    public View O0;
    public v63 P0;
    public int Q0;
    public t72 R0;
    public lr1 S0;
    public boolean T0;
    public boolean U0;
    public boolean V0;

    @Override // com.baidu.tieba.m52
    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class e implements zk3<gb3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o52 a;

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
                this.a.a.I2(true, false);
            }
        }

        public e(o52 o52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o52Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(gb3 gb3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gb3Var) == null) && gb3Var != null && !gb3Var.d && gb3Var.j == 1) {
                ak3.e0(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o52 a;

        public a(o52 o52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o52Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.S0 = np2.Q();
                lr1 lr1Var = this.a.S0;
                o52 o52Var = this.a;
                lr1Var.a(o52Var.b0, o52Var.d0, o52Var.z());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements SwanAppActionBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o52 a;

        public b(o52 o52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o52Var;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void onDoubleClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String a = this.a.L0.a();
                mg2 mg2Var = new mg2();
                mg2Var.c = nl3.a(a, "scrollViewBackToTop");
                tr2.V().n(a, mg2Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o52 a;

        public c(o52 o52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o52Var;
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

    /* loaded from: classes7.dex */
    public class d implements lc2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lc2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ o52 f;

        public d(o52 o52Var, lc2.e eVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o52Var, eVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = o52Var;
            this.a = eVar;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [com.baidu.tieba.os1] */
        @Override // com.baidu.tieba.lc2.f
        public void onReady() {
            String str;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xc2 xc2Var = new xc2();
                xc2Var.i = this.a.a.I();
                if (!TextUtils.isEmpty(this.b)) {
                    mz2.e(this.a, this.b);
                }
                String b = y93.b(this.c);
                xc2Var.a = this.d;
                if (TextUtils.isEmpty(this.e)) {
                    str = this.c;
                } else {
                    str = this.c + "?" + this.e;
                }
                xc2Var.b = str;
                if (g63.c0() != null) {
                    xc2Var.c = g63.c0().e0(b);
                    xc2Var.f = g63.c0().Y(b);
                }
                xc2Var.k = uc2.c(g63.M(), xc2Var.b);
                xc2Var.d = tr2.V().f(b).g;
                xc2Var.e = String.valueOf(d32.a());
                if (!o52.W0 && !tr2.V().O()) {
                    z = false;
                } else {
                    z = true;
                }
                xc2Var.g = z;
                if (f23.H()) {
                    xc2Var.j = j32.d();
                }
                if (!TextUtils.isEmpty(this.b)) {
                    String str2 = this.b;
                    xc2Var.h = str2;
                    lz2.q("route", str2).F(new UbcFlowEvent("slave_dispatch_start"));
                }
                nj3.d();
                this.a.a.getWebView().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.c);
                this.a.a.P(xc2Var.b);
                tr2.V().n(this.a.a.a(), xc2.a(xc2Var));
                if (yc2.b()) {
                    yc2 yc2Var = new yc2();
                    yc2Var.a = this.a.a.a();
                    tr2.V().v(yc2.a(yc2Var));
                }
                qc3.F(this.a.a.a(), xc2Var.b);
                if (o52.W0) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + xc2Var.toString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements t72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o52 a;

        public f(o52 o52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o52Var;
        }

        @Override // com.baidu.tieba.t72
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIIII(1048576, this, i, i2, i3, i4) != null) {
                return;
            }
            this.a.f4(i2);
        }
    }

    /* loaded from: classes7.dex */
    public class g implements v72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o52 a;

        public g(o52 o52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o52Var;
        }

        @Override // com.baidu.tieba.v72
        public void a(qs1 qs1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, qs1Var) == null) && qs1Var != null) {
                qs1Var.r(this.a.R0);
                qs1Var.V(this.a.F3());
                uw2.e().a(qs1Var);
            }
        }

        @Override // com.baidu.tieba.v72
        public void b(qs1 qs1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qs1Var) == null) && qs1Var != null) {
                qs1Var.R(this.a.R0);
                uw2.e().b(qs1Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends r72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o52 c;

        public h(o52 o52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o52Var;
        }

        @Override // com.baidu.tieba.r72, com.baidu.tieba.u72
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.c.C2(str);
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
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-593938280, "Lcom/baidu/tieba/o52$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-593938280, "Lcom/baidu/tieba/o52$i;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (a < 0) {
                    np2.g0().getSwitch("swan_app_fragment_destroy_switch", 1);
                    a = 1;
                }
                if (o52.W0) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947983165, "Lcom/baidu/tieba/o52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947983165, "Lcom/baidu/tieba/o52;");
                return;
            }
        }
        W0 = rm1.a;
        X0 = xj3.g(149.0f);
        Y0 = "-1";
        a1 = "-1";
    }

    public String A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ns1 ns1Var = this.L0;
            if (ns1Var != null) {
                return ns1Var.a();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.C0();
            this.C0.a();
            if (i.b()) {
                ak3.q().postAtFrontOfQueue(new c(this));
            } else {
                q3();
            }
        }
    }

    @Nullable
    public sh3 C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.M0;
        }
        return (sh3) invokeV.objValue;
    }

    public FrameLayout E3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.K0;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m52, com.baidu.swan.support.v4.app.Fragment
    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.F0();
        }
    }

    public final r72 F3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return new h(this);
        }
        return (r72) invokeV.objValue;
    }

    public final v72 G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return new g(this);
        }
        return (v72) invokeV.objValue;
    }

    public final void H3() {
        jn2 C0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ns1 v3 = v3();
            if ((v3 instanceof SwanAppWebViewManager) && (C0 = ((SwanAppWebViewManager) v3).C0()) != null) {
                C0.d();
            }
        }
    }

    public boolean K3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            sh3 sh3Var = this.M0;
            if (sh3Var == null) {
                return false;
            }
            return sh3Var.p();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.m52
    public v63 M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.P0;
        }
        return (v63) invokeV.objValue;
    }

    public final boolean M3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            v63 v63Var = this.P0;
            if (v63Var != null && v63Var.h) {
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
            v63 v63Var = this.P0;
            if (v63Var != null) {
                return TextUtils.equals(v63Var.j, ExceptionHandlerImpl.KEY_CUSTOM);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean Q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            SwanAppConfigData t = tr2.V().t();
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
            ns1 ns1Var = this.L0;
            if (ns1Var != null) {
                return ns1Var.e0();
            }
            return null;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    public void g4() {
        hw2 hw2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048616, this) != null) || (hw2Var = this.d0) == null) {
            return;
        }
        hw2Var.n();
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.G0 = zc3.c("805");
        }
    }

    public final void m3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            f63.K().q().f0().e("mapp_i_custom_navigation_bar", new e(this));
        }
    }

    @Override // com.baidu.tieba.m52, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onPause();
            d1();
        }
    }

    @Override // com.baidu.tieba.m52, com.baidu.swan.support.v4.app.Fragment
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
            A1();
            U3();
        }
    }

    @NonNull
    public gw2 t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.H0;
        }
        return (gw2) invokeV.objValue;
    }

    public ns1 v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.L0;
        }
        return (ns1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m52
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
            if (j2()) {
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
    public gw2 y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.I0;
        }
        return (gw2) invokeV.objValue;
    }

    public o52() {
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
        this.H0 = new gw2();
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
            Map<String, ns1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (ns1 ns1Var : this.J0.values()) {
                    if (ns1Var != null) {
                        ns1Var.b0();
                    }
                }
            } else {
                ns1 ns1Var2 = this.L0;
                if (ns1Var2 != null) {
                    ns1Var2.b0();
                }
            }
            H3();
        }
    }

    public final boolean L3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            SwanAppConfigData t = tr2.V().t();
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
            p52 S1 = S1();
            if (S1 == null) {
                return false;
            }
            v63 v63Var = this.P0;
            if (v63Var != null && v63Var.k) {
                z = true;
            } else {
                z = false;
            }
            if (z || (t = tr2.V().t()) == null) {
                return false;
            }
            return !O3(S1, t);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.n53.a
    public n53 getFloatLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.N0 == null) {
                if (this.O0 == null) {
                    return null;
                }
                this.N0 = new n53(this, (LinearLayout) this.O0.findViewById(R.id.obfuscated_res_0x7f09019d), P1().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070160));
            }
            return this.N0;
        }
        return (n53) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m52
    public boolean k2() {
        InterceptResult invokeV;
        SwanAppConfigData t;
        hw2 hw2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            tr2 V = tr2.V();
            if (V == null || (t = V.t()) == null || !t.n() || (hw2Var = this.d0) == null) {
                return false;
            }
            return t.r(hw2Var.i());
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.m52
    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            ns1 ns1Var = this.L0;
            if (ns1Var != null) {
                ns1Var.Q();
            }
            J3();
            x3(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(ed2.n(f63.K().getAppId()));
            }
            this.g0.t(np2.M().a(), N1(), this.h0, false);
        }
    }

    public static o52 T3(hw2 hw2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hw2Var)) == null) {
            o52 o52Var = new o52();
            if (hw2Var != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", hw2Var.m());
                o52Var.m1(bundle);
            }
            return o52Var;
        }
        return (o52) invokeL.objValue;
    }

    public static void b4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            b1 = str;
        }
    }

    @Override // com.baidu.tieba.m52
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

    @Override // com.baidu.tieba.m52
    public void B1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (!v63.f(this.P0)) {
                super.B1(i2);
                return;
            }
            boolean z = true;
            if (!N3()) {
                z = true ^ pj3.h(this.c0);
            }
            C1(i2, z);
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

    public void S3(kd3 kd3Var) {
        mc3 mc3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, kd3Var) == null) && (mc3Var = this.G0) != null) {
            zc3.i(mc3Var, kd3Var);
            this.G0 = null;
        }
    }

    public void Y3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.V0 = z;
        }
    }

    public final void e4(ns1 ns1Var) {
        t72 t72Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048614, this, ns1Var) != null) || (t72Var = this.R0) == null || ns1Var == null) {
            return;
        }
        ns1Var.R(t72Var);
        if (ns1Var.k() != null) {
            ns1Var.R(this.R0);
        }
    }

    @Override // com.baidu.tieba.m52, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, motionEvent)) == null) {
            if (f2() && this.L0.isSlidable(motionEvent)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void k3(ns1 ns1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048622, this, ns1Var) != null) || ns1Var == null) {
            return;
        }
        t72 t72Var = this.R0;
        if (t72Var != null) {
            ns1Var.r(t72Var);
        }
        ns1Var.W(G3());
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void u0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, activity) == null) {
            super.u0(activity);
            if (W0) {
                Log.d("SwanAppFragment", "onAttach() obj: " + this);
            }
        }
    }

    public static void Z3(gw2 gw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, gw2Var) == null) {
            try {
                if (W0) {
                    Log.d("SwanAppFragment", "setLastPageParams =" + gw2Var);
                }
                if (gw2Var == null) {
                    Z0 = null;
                } else {
                    Z0 = (gw2) gw2Var.clone();
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
        tr2 V = tr2.V();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (V.f(str).h && this.R0 == null) {
            this.R0 = new f(this);
        }
    }

    @Override // com.baidu.tieba.m52, com.baidu.swan.support.v4.app.Fragment
    public void p1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048629, this, z) != null) || !n0()) {
            return;
        }
        super.p1(z);
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
        if ((interceptable == null || interceptable.invokeZ(1048644, this, z) == null) && np2.K().k(z, 2)) {
            ew2.l(z(), this.g0, this.f0, g63.c0().X().g0().paNumber);
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
            aj3.j(new a(this), "SwanAppPageHistory");
            kz2.a("route", "fragment create.");
        }
    }

    private void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (h0()) {
                resume();
            }
            nc4 nc4Var = this.g0;
            if (nc4Var != null && nc4Var.i()) {
                this.g0.A(np2.M().a());
            }
            if (W0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.L0.a())));
            }
        }
    }

    public List<String> B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, ns1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, ns1> entry : this.J0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(entry.getValue().a());
                    }
                }
            }
            ns1 ns1Var = this.L0;
            if (ns1Var != null) {
                String a2 = ns1Var.a();
                if (!arrayList.contains(a2)) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m52
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (getFloatLayer() != null && getFloatLayer().f() && getFloatLayer().g()) {
                return true;
            }
            if ((getFloatLayer() != null && getFloatLayer().d()) || PaymentManager.k()) {
                return true;
            }
            ns1 ns1Var = this.L0;
            if (ns1Var != null) {
                if (ft2.g(ns1Var.a())) {
                    return true;
                }
                return this.L0.H();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @DebugTrace
    public void J3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            FragmentActivity n = n();
            if (this.h0 == null) {
                this.h0 = new SwanAppMenuHeaderView(z());
            }
            if (n != null && this.g0 == null) {
                this.g0 = new nc4(n, this.f0, w3(), np2.K(), new pl3());
                new wv2(this.g0, this, this.h0).z();
                if (cw2.e()) {
                    this.g0.l(50);
                }
            }
        }
    }

    @Override // com.baidu.tieba.m52
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
            qs1 k = this.L0.k();
            if (k != null) {
                hashMap.put("webViewUrl", k.getCurrentPageUrl());
            }
            tr2.V().v(new hg2("sharebtn", hashMap));
        }
    }

    @Override // com.baidu.tieba.m52
    public void p2() {
        hw2 T1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            V1();
            jd3 jd3Var = new jd3();
            jd3Var.e = "gohome";
            jd3Var.c = "bar";
            o52 J = tr2.V().J();
            if (J == null) {
                T1 = null;
            } else {
                T1 = J.T1();
            }
            if (T1 != null && !TextUtils.isEmpty(T1.i())) {
                jd3Var.a("page", T1.i());
            }
            F1(jd3Var);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.os1] */
    @NonNull
    public Pair<Integer, Integer> u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            ns1 ns1Var = this.L0;
            if (ns1Var == null) {
                return new Pair<>(0, 0);
            }
            View currentWebView = ns1Var.getWebView().getCurrentWebView();
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
            kz2.a("route", "fragment onCreateView.");
            View b2 = q03.a().b(R.layout.obfuscated_res_0x7f0d00ae, viewGroup, false);
            this.K0 = (FrameLayout) b2.findViewById(R.id.obfuscated_res_0x7f09019e);
            a2(b2);
            a3(b2);
            this.M0 = new sh3(this);
            o3(b2);
            if (!cw2.e() && !cw2.f()) {
                bw2.b(this.L0.a(), String.valueOf(cw2.d()), String.valueOf(cw2.a(cw2.b())));
            }
            if (Z1()) {
                b2 = c2(b2);
            }
            this.O0 = J1(b2, this);
            N2(this.L0.y());
            uw2.e().m();
            return this.O0;
        }
        return (View) invokeLLL.objValue;
    }

    public final boolean O3(p52 p52Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, p52Var, swanAppConfigData)) == null) {
            m52 j = p52Var.j(0);
            if (j == null || !(j instanceof o52)) {
                return false;
            }
            String e2 = ((o52) j).t3().e();
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
        v63 v63Var;
        os1 os1Var;
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
            ns1 ns1Var = this.L0;
            if (ns1Var != null) {
                if (ns1Var.k() != null) {
                    os1Var = this.L0.k().getWebView();
                } else {
                    os1Var = this.L0.getWebView();
                }
                if (os1Var != null) {
                    i2 = os1Var.getWebViewScrollY();
                    v63Var = this.P0;
                    if (v63Var != null && v63Var.i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            v63Var = this.P0;
            if (v63Var != null) {
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
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "setting immersive portrait fullscreen video");
            }
            ni3.h();
            if (this.c0.getWindow() != null) {
                this.c0.getWindow().getDecorView().setSystemUiVisibility(5376);
            }
            View b2 = c53.b();
            if (b2 != null) {
                b2.setVisibility(0);
                b2.findViewById(R.id.obfuscated_res_0x7f092626).setVisibility(8);
            }
            SwanAppActionBar Q1 = Q1();
            if (Q1 != null) {
                Q1.setRightMenuStyle();
                Q1.setRightZoneImmersiveStyle();
                Q1.setBackgroundColor(0);
            }
            View i0 = i0();
            if (i0 != null) {
                i0.findViewById(R.id.obfuscated_res_0x7f09116e).setBackgroundColor(0);
                FrameLayout frameLayout = (FrameLayout) i0.findViewById(R.id.obfuscated_res_0x7f09019e);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams);
            }
        }
    }

    public final void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            Map<String, ns1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (ns1 ns1Var : this.J0.values()) {
                    if (ns1Var != null) {
                        e4(ns1Var);
                        ns1Var.destroy();
                    }
                }
                this.J0.clear();
            } else {
                ns1 ns1Var2 = this.L0;
                if (ns1Var2 != null) {
                    e4(ns1Var2);
                    this.L0.destroy();
                }
            }
            this.L0 = null;
            if (W0) {
                Log.d("SwanAppFragment", "onDestroy() obj: " + this);
            }
            if (!this.T0) {
                lc2.n(tr2.V().getActivity());
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
                E2((f2() || L3()) ? true : true);
                this.L0.onResume();
                X3();
                W3("onShow");
                uw2.e().i(true);
            }
            g32.i("SwanApp", "onShow");
            ft2.i(a2, true);
            if (g32.f()) {
                b52.b();
            }
            if (g63.c0() != null) {
                str = g63.c0().P();
            }
            np2.H().e(str);
        }
    }

    public final void V3() {
        Bundle r;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048605, this) != null) || (r = r()) == null) {
            return;
        }
        this.I0 = Z0;
        if (W0) {
            Log.d("SwanAppFragment", "restoreArguments sPrePageParams=" + this.I0);
        }
        hw2 g2 = hw2.g(r.getString("ai_apps_param"));
        this.d0 = g2;
        if (g2 == null) {
            gw2 gw2Var = this.H0;
            gw2Var.a = "";
            gw2Var.b = "";
            gw2Var.e = "";
            gw2Var.f = "";
        } else {
            this.H0.a = g2.i();
            this.H0.b = this.d0.j();
            this.H0.e = this.d0.l();
            this.H0.f = this.d0.k();
        }
        gw2 gw2Var2 = this.H0;
        gw2Var2.d = y93.b(gw2Var2.e());
        v63 f2 = tr2.V().f(this.H0.g());
        this.P0 = f2;
        if (f2.p) {
            this.P0 = tr2.V().j(this.H0.e());
        }
        if (this.E0) {
            v63 v63Var = this.P0;
            v63Var.f = false;
            v63Var.h = true;
            v63Var.p = true;
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
            kg2 kg2Var = new kg2();
            kg2Var.c = a1;
            kg2Var.d = this.L0.a();
            kg2Var.e = b1;
            kg2Var.f = this.H0.a;
            kg2Var.g = String.valueOf(o);
            b1 = "";
            if (W0) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + kg2Var.c + " ,toId: " + kg2Var.d + " ,RouteType: " + kg2Var.e + " page:" + kg2Var.f + ",TabIndex: " + kg2Var.g);
            }
            tr2.V().v(kg2Var);
            a1 = this.L0.a();
        }
    }

    public void pause() {
        boolean z;
        String a2;
        PullToRefreshBaseWebView e0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
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
                uw2.e().i(false);
            }
            if (getFloatLayer() != null && !getFloatLayer().d() && (!getFloatLayer().g() || getFloatLayer().k())) {
                getFloatLayer().h();
            }
            g32.i("SwanApp", "onHide");
            ft2.i(a2, false);
            if (!z && (e0 = this.L0.e0()) != null) {
                e0.w(false);
            }
            if (g63.c0() != null) {
                str = g63.c0().P();
            }
            np2.H().f(str);
        }
    }

    public final void W3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.L0.a());
            ig2 ig2Var = new ig2(hashMap);
            if (W0) {
                Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.L0.a());
            }
            tr2.V().v(ig2Var);
        }
    }

    public void c4(gw2 gw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, gw2Var) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "switchTab pageParam: " + gw2Var);
            }
            if (this.M0.o(t3().g()) == this.M0.o(gw2Var.g())) {
                gw2 gw2Var2 = this.H0;
                gw2Var2.e = gw2Var.e;
                gw2Var2.f = gw2Var.f;
                return;
            }
            this.M0.E(gw2Var.g());
            onPause();
            s3(gw2Var, "");
        }
    }

    public final void h4(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            int i3 = 0;
            if (z) {
                hl3 hl3Var = this.u0;
                if (hl3Var != null && hl3Var.i()) {
                    i2 = xj3.t();
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
            if (np2.K().k(z, 1)) {
                ew2.k(z(), this.f0, g63.c0().X().g0().paNumber);
            } else if (g63.c0() == null) {
            } else {
                ew2.o(this.f0, g63.c0().V().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    @Override // com.baidu.tieba.m52
    public void a2(View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, view2) == null) {
            super.a2(view2);
            boolean z2 = false;
            if (!f2() && !L3()) {
                z = false;
            } else {
                z = true;
            }
            E2(z);
            if (P3()) {
                l2();
            }
            U3();
            this.f0.setOnDoubleClickListener(new b(this));
            if (!qc3.i()) {
                qc3.d(f63.K().q().X());
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

    public final void d4(String str, gw2 gw2Var) {
        ns1 ns1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048612, this, str, gw2Var) == null) && this.L0 != (ns1Var = this.J0.get(str)) && ns1Var != null) {
            v63 f2 = tr2.V().f(str);
            ns1Var.x(this.K0, f2);
            if (!ns1Var.c()) {
                ns1Var.M(this.K0, f2);
            }
            ns1Var.A(0);
            ns1 ns1Var2 = this.L0;
            if (ns1Var2 != null) {
                ns1Var2.A(8);
            }
            this.L0 = ns1Var;
            gw2 gw2Var2 = this.H0;
            gw2Var2.e = gw2Var.e;
            gw2Var2.f = gw2Var.f;
            ns1Var.g(gw2Var2);
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
            hl3 hl3Var = this.u0;
            if (hl3Var != null && hl3Var.i() && (e2 = this.u0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.f0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            v63 v63Var = this.P0;
            if (v63Var != null && v63Var.i && (centerTitleView = this.f0.getCenterTitleView()) != null) {
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
            kz2.a("route", "createSlaveWebView start.");
            String h2 = this.d0.h();
            String j = this.d0.j();
            String i2 = this.d0.i();
            String a2 = ak3.a(h2, i2, j);
            this.L0 = lc2.h(a2);
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
            v63 f2 = tr2.V().f(i2);
            this.L0.x(this.K0, f2);
            this.L0.M(this.K0, f2);
            I3(i2);
            k3(this.L0);
            if (k2()) {
                this.J0.put(i2, this.L0);
                this.M0.f(view2, z(), i2);
            }
            kz2.a("route", "createSlaveWebView end.");
            l3();
        }
    }

    public final ns1 n3(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048625, this, str, str2, str3, str4)) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad start.");
            }
            lc2.e f2 = lc2.f(n(), qc2.c(str2));
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = lz2.q("route", str4);
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
            lc2.q(f2, new d(this, f2, str4, str2, str, str3));
            if (W0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad end.");
            }
            return f2.a;
        }
        return (ns1) invokeLLLL.objValue;
    }

    public final void p3(gw2 gw2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048631, this, gw2Var, str) == null) && this.J0.get(gw2Var.d) == null) {
            String a2 = ak3.a(gw2Var.c, gw2Var.a, gw2Var.b);
            ns1 h2 = lc2.h(a2);
            if (h2 != null) {
                if (W0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + a2);
                }
                this.J0.put(gw2Var.a, h2);
            } else {
                if (W0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                h2 = n3(gw2Var.c, gw2Var.a, gw2Var.b, str);
                this.J0.put(gw2Var.a, h2);
            }
            I3(gw2Var.a);
            k3(h2);
        }
    }

    public void s3(gw2 gw2Var, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048637, this, gw2Var, str) == null) {
            Z3(this.H0);
            this.I0 = Z0;
            if (W0) {
                Log.d("SwanAppFragment", "doSwitchTab mPrePageParams=" + this.I0);
            }
            String str3 = gw2Var.a;
            String str4 = gw2Var.d;
            tr2 V = tr2.V();
            String str5 = "";
            if (TextUtils.isEmpty(str4)) {
                str2 = "";
            } else {
                str2 = str4;
            }
            v63 f2 = V.f(str2);
            gw2 gw2Var2 = this.H0;
            gw2Var2.a = str3;
            if (gw2Var != null) {
                str5 = gw2Var.f();
            }
            gw2Var2.b = str5;
            this.H0.d = str4;
            this.P0 = f2;
            boolean z = !R3(str4);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    mz2.c(7, str);
                } else {
                    mz2.c(6, str);
                }
            }
            if (!z) {
                d4(str4, gw2Var);
            } else {
                p3(gw2Var, str);
                d4(str3, gw2Var);
            }
            if (!TextUtils.isEmpty(str)) {
                lz2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                mz2.a(str, gw2Var);
            }
            C2(f2.b);
            J2(SwanAppConfigData.t(f2.c));
            A2(f2.a);
            U3();
            g4();
            g32.i("SwanAppFragment", "switch tab title: " + f2.b + " page:" + str3);
        }
    }
}
