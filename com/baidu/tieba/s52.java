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
import com.baidu.tieba.pc2;
import com.baidu.tieba.r53;
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
public class s52 extends q52 implements r53.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean W0;
    public static final int X0;
    public static String Y0;
    public static kw2 Z0;
    public static String a1;
    public static String b1;
    public transient /* synthetic */ FieldHolder $fh;
    public qc3 G0;
    public kw2 H0;
    public kw2 I0;
    public Map<String, rs1> J0;
    public FrameLayout K0;
    public rs1 L0;
    public wh3 M0;
    public r53 N0;
    public View O0;
    public z63 P0;
    public int Q0;
    public x72 R0;
    public pr1 S0;
    public boolean T0;
    public boolean U0;
    public boolean V0;

    @Override // com.baidu.tieba.q52
    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class e implements dl3<kb3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s52 a;

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

        public e(s52 s52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s52Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(kb3 kb3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kb3Var) == null) && kb3Var != null && !kb3Var.d && kb3Var.j == 1) {
                ek3.e0(new a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s52 a;

        public a(s52 s52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s52Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.S0 = rp2.Q();
                pr1 pr1Var = this.a.S0;
                s52 s52Var = this.a;
                pr1Var.a(s52Var.b0, s52Var.d0, s52Var.z());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements SwanAppActionBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s52 a;

        public b(s52 s52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s52Var;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void onDoubleClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String a = this.a.L0.a();
                qg2 qg2Var = new qg2();
                qg2Var.c = rl3.a(a, "scrollViewBackToTop");
                xr2.V().n(a, qg2Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s52 a;

        public c(s52 s52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s52Var;
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
    public class d implements pc2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pc2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ s52 f;

        public d(s52 s52Var, pc2.e eVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s52Var, eVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = s52Var;
            this.a = eVar;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [com.baidu.tieba.ss1] */
        @Override // com.baidu.tieba.pc2.f
        public void onReady() {
            String str;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                bd2 bd2Var = new bd2();
                bd2Var.i = this.a.a.I();
                if (!TextUtils.isEmpty(this.b)) {
                    qz2.e(this.a, this.b);
                }
                String b = ca3.b(this.c);
                bd2Var.a = this.d;
                if (TextUtils.isEmpty(this.e)) {
                    str = this.c;
                } else {
                    str = this.c + "?" + this.e;
                }
                bd2Var.b = str;
                if (k63.c0() != null) {
                    bd2Var.c = k63.c0().e0(b);
                    bd2Var.f = k63.c0().Y(b);
                }
                bd2Var.k = yc2.c(k63.M(), bd2Var.b);
                bd2Var.d = xr2.V().f(b).g;
                bd2Var.e = String.valueOf(h32.a());
                if (!s52.W0 && !xr2.V().O()) {
                    z = false;
                } else {
                    z = true;
                }
                bd2Var.g = z;
                if (j23.H()) {
                    bd2Var.j = n32.d();
                }
                if (!TextUtils.isEmpty(this.b)) {
                    String str2 = this.b;
                    bd2Var.h = str2;
                    pz2.q("route", str2).F(new UbcFlowEvent("slave_dispatch_start"));
                }
                rj3.d();
                this.a.a.getWebView().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.c);
                this.a.a.P(bd2Var.b);
                xr2.V().n(this.a.a.a(), bd2.a(bd2Var));
                if (cd2.b()) {
                    cd2 cd2Var = new cd2();
                    cd2Var.a = this.a.a.a();
                    xr2.V().v(cd2.a(cd2Var));
                }
                uc3.F(this.a.a.a(), bd2Var.b);
                if (s52.W0) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bd2Var.toString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements x72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s52 a;

        public f(s52 s52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s52Var;
        }

        @Override // com.baidu.tieba.x72
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIIII(1048576, this, i, i2, i3, i4) != null) {
                return;
            }
            this.a.f4(i2);
        }
    }

    /* loaded from: classes8.dex */
    public class g implements z72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s52 a;

        public g(s52 s52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s52Var;
        }

        @Override // com.baidu.tieba.z72
        public void a(us1 us1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, us1Var) == null) && us1Var != null) {
                us1Var.r(this.a.R0);
                us1Var.V(this.a.F3());
                yw2.e().a(us1Var);
            }
        }

        @Override // com.baidu.tieba.z72
        public void b(us1 us1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, us1Var) == null) && us1Var != null) {
                us1Var.R(this.a.R0);
                yw2.e().b(us1Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h extends v72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s52 c;

        public h(s52 s52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s52Var;
        }

        @Override // com.baidu.tieba.v72, com.baidu.tieba.y72
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
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-479421676, "Lcom/baidu/tieba/s52$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-479421676, "Lcom/baidu/tieba/s52$i;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (a < 0) {
                    rp2.g0().getSwitch("swan_app_fragment_destroy_switch", 1);
                    a = 1;
                }
                if (s52.W0) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948102329, "Lcom/baidu/tieba/s52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948102329, "Lcom/baidu/tieba/s52;");
                return;
            }
        }
        W0 = vm1.a;
        X0 = bk3.g(149.0f);
        Y0 = "-1";
        a1 = "-1";
    }

    public String A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            rs1 rs1Var = this.L0;
            if (rs1Var != null) {
                return rs1Var.a();
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
                ek3.q().postAtFrontOfQueue(new c(this));
            } else {
                q3();
            }
        }
    }

    @Nullable
    public wh3 C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.M0;
        }
        return (wh3) invokeV.objValue;
    }

    public FrameLayout E3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.K0;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q52, com.baidu.swan.support.v4.app.Fragment
    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.F0();
        }
    }

    public final v72 F3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return new h(this);
        }
        return (v72) invokeV.objValue;
    }

    public final z72 G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return new g(this);
        }
        return (z72) invokeV.objValue;
    }

    public final void H3() {
        nn2 C0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            rs1 v3 = v3();
            if ((v3 instanceof SwanAppWebViewManager) && (C0 = ((SwanAppWebViewManager) v3).C0()) != null) {
                C0.d();
            }
        }
    }

    public boolean K3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            wh3 wh3Var = this.M0;
            if (wh3Var == null) {
                return false;
            }
            return wh3Var.p();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q52
    public z63 L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.P0;
        }
        return (z63) invokeV.objValue;
    }

    public final boolean M3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            z63 z63Var = this.P0;
            if (z63Var != null && z63Var.h) {
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
            z63 z63Var = this.P0;
            if (z63Var != null) {
                return TextUtils.equals(z63Var.j, ExceptionHandlerImpl.KEY_CUSTOM);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean Q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            SwanAppConfigData t = xr2.V().t();
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
            rs1 rs1Var = this.L0;
            if (rs1Var != null) {
                return rs1Var.e0();
            }
            return null;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    public void g4() {
        lw2 lw2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048616, this) != null) || (lw2Var = this.d0) == null) {
            return;
        }
        lw2Var.n();
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.G0 = dd3.c("805");
        }
    }

    public final void m3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            j63.K().q().f0().e("mapp_i_custom_navigation_bar", new e(this));
        }
    }

    @Override // com.baidu.tieba.q52, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onPause();
            d1();
        }
    }

    @Override // com.baidu.tieba.q52, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            super.onResume();
            g1();
            z3(false);
        }
    }

    public void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.P0.j = "default";
            z1();
            U3();
        }
    }

    @NonNull
    public kw2 t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.H0;
        }
        return (kw2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q52
    public void v2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            super.v2();
            U3();
            if (this.V0) {
                a4();
            }
        }
    }

    public rs1 v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.L0;
        }
        return (rs1) invokeV.objValue;
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
    public kw2 y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.I0;
        }
        return (kw2) invokeV.objValue;
    }

    public s52() {
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
        this.H0 = new kw2();
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
            Map<String, rs1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (rs1 rs1Var : this.J0.values()) {
                    if (rs1Var != null) {
                        rs1Var.b0();
                    }
                }
            } else {
                rs1 rs1Var2 = this.L0;
                if (rs1Var2 != null) {
                    rs1Var2.b0();
                }
            }
            H3();
        }
    }

    public final boolean L3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            SwanAppConfigData t = xr2.V().t();
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
            t52 R1 = R1();
            if (R1 == null) {
                return false;
            }
            z63 z63Var = this.P0;
            if (z63Var != null && z63Var.k) {
                z = true;
            } else {
                z = false;
            }
            if (z || (t = xr2.V().t()) == null) {
                return false;
            }
            return !O3(R1, t);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.r53.a
    public r53 getFloatLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.N0 == null) {
                if (this.O0 == null) {
                    return null;
                }
                this.N0 = new r53(this, (LinearLayout) this.O0.findViewById(R.id.obfuscated_res_0x7f09019d), O1().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070160));
            }
            return this.N0;
        }
        return (r53) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q52
    public boolean k2() {
        InterceptResult invokeV;
        SwanAppConfigData t;
        lw2 lw2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            xr2 V = xr2.V();
            if (V == null || (t = V.t()) == null || !t.n() || (lw2Var = this.d0) == null) {
                return false;
            }
            return t.r(lw2Var.i());
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q52
    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            rs1 rs1Var = this.L0;
            if (rs1Var != null) {
                rs1Var.Q();
            }
            J3();
            x3(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(id2.n(j63.K().getAppId()));
            }
            this.g0.t(rp2.M().a(), M1(), this.h0, false);
        }
    }

    public static s52 T3(lw2 lw2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, lw2Var)) == null) {
            s52 s52Var = new s52();
            if (lw2Var != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", lw2Var.m());
                s52Var.m1(bundle);
            }
            return s52Var;
        }
        return (s52) invokeL.objValue;
    }

    public static void b4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            b1 = str;
        }
    }

    @Override // com.baidu.tieba.q52
    public void A1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (!z63.f(this.P0)) {
                super.A1(i2);
                return;
            }
            boolean z = true;
            if (!N3()) {
                z = true ^ tj3.h(this.c0);
            }
            B1(i2, z);
            U3();
        }
    }

    @Override // com.baidu.tieba.q52
    public boolean A2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            boolean A2 = super.A2(i2);
            U3();
            return A2;
        }
        return invokeI.booleanValue;
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

    public void S3(od3 od3Var) {
        qc3 qc3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, od3Var) == null) && (qc3Var = this.G0) != null) {
            dd3.i(qc3Var, od3Var);
            this.G0 = null;
        }
    }

    public void Y3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.V0 = z;
        }
    }

    public final void e4(rs1 rs1Var) {
        x72 x72Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048614, this, rs1Var) != null) || (x72Var = this.R0) == null || rs1Var == null) {
            return;
        }
        rs1Var.R(x72Var);
        if (rs1Var.j() != null) {
            rs1Var.R(this.R0);
        }
    }

    @Override // com.baidu.tieba.q52, com.baidu.searchbox.widget.SlideInterceptor
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

    public final void k3(rs1 rs1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048622, this, rs1Var) != null) || rs1Var == null) {
            return;
        }
        x72 x72Var = this.R0;
        if (x72Var != null) {
            rs1Var.r(x72Var);
        }
        rs1Var.W(G3());
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

    public static void Z3(kw2 kw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, kw2Var) == null) {
            try {
                if (W0) {
                    Log.d("SwanAppFragment", "setLastPageParams =" + kw2Var);
                }
                if (kw2Var == null) {
                    Z0 = null;
                } else {
                    Z0 = (kw2) kw2Var.clone();
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
        xr2 V = xr2.V();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (V.f(str).h && this.R0 == null) {
            this.R0 = new f(this);
        }
    }

    @Override // com.baidu.tieba.q52, com.baidu.swan.support.v4.app.Fragment
    public void p1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048630, this, z) != null) || !n0()) {
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

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void x0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, bundle) == null) {
            super.x0(bundle);
            V3();
            if (W0) {
                Log.d("SwanAppFragment", "onCreate() obj: " + this);
            }
            ej3.j(new a(this), "SwanAppPageHistory");
            oz2.a("route", "fragment create.");
        }
    }

    public final void x3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048645, this, z) == null) && rp2.K().k(z, 2)) {
            iw2.l(z(), this.g0, this.f0, k63.c0().X().g0().paNumber);
        }
    }

    private void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (h0()) {
                resume();
            }
            rc4 rc4Var = this.g0;
            if (rc4Var != null && rc4Var.i()) {
                this.g0.A(rp2.M().a());
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
            Map<String, rs1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, rs1> entry : this.J0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(entry.getValue().a());
                    }
                }
            }
            rs1 rs1Var = this.L0;
            if (rs1Var != null) {
                String a2 = rs1Var.a();
                if (!arrayList.contains(a2)) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q52
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
            rs1 rs1Var = this.L0;
            if (rs1Var != null) {
                if (jt2.g(rs1Var.a())) {
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
            FragmentActivity n = n();
            if (this.h0 == null) {
                this.h0 = new SwanAppMenuHeaderView(z());
            }
            if (n != null && this.g0 == null) {
                this.g0 = new rc4(n, this.f0, w3(), rp2.K(), new tl3());
                new aw2(this.g0, this, this.h0).z();
                if (gw2.e()) {
                    this.g0.l(50);
                }
            }
        }
    }

    @Override // com.baidu.tieba.q52
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
            us1 j = this.L0.j();
            if (j != null) {
                hashMap.put("webViewUrl", j.getCurrentPageUrl());
            }
            xr2.V().v(new lg2("sharebtn", hashMap));
        }
    }

    @Override // com.baidu.tieba.q52
    public void o2() {
        lw2 S1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            V1();
            nd3 nd3Var = new nd3();
            nd3Var.e = "gohome";
            nd3Var.c = "bar";
            s52 J = xr2.V().J();
            if (J == null) {
                S1 = null;
            } else {
                S1 = J.S1();
            }
            if (S1 != null && !TextUtils.isEmpty(S1.i())) {
                nd3Var.a("page", S1.i());
            }
            E1(nd3Var);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.ss1] */
    @NonNull
    public Pair<Integer, Integer> u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            rs1 rs1Var = this.L0;
            if (rs1Var == null) {
                return new Pair<>(0, 0);
            }
            View currentWebView = rs1Var.getWebView().getCurrentWebView();
            if (currentWebView == null) {
                return new Pair<>(0, 0);
            }
            return new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View A0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            oz2.a("route", "fragment onCreateView.");
            View b2 = u03.a().b(R.layout.obfuscated_res_0x7f0d00af, viewGroup, false);
            this.K0 = (FrameLayout) b2.findViewById(R.id.obfuscated_res_0x7f09019e);
            a2(b2);
            a3(b2);
            this.M0 = new wh3(this);
            o3(b2);
            if (!gw2.e() && !gw2.f()) {
                fw2.b(this.L0.a(), String.valueOf(gw2.d()), String.valueOf(gw2.a(gw2.b())));
            }
            if (Z1()) {
                b2 = c2(b2);
            }
            this.O0 = I1(b2, this);
            N2(this.L0.y());
            yw2.e().m();
            return this.O0;
        }
        return (View) invokeLLL.objValue;
    }

    public final boolean O3(t52 t52Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, t52Var, swanAppConfigData)) == null) {
            q52 j = t52Var.j(0);
            if (j == null || !(j instanceof s52)) {
                return false;
            }
            String e2 = ((s52) j).t3().e();
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
        z63 z63Var;
        ss1 ss1Var;
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
            rs1 rs1Var = this.L0;
            if (rs1Var != null) {
                if (rs1Var.j() != null) {
                    ss1Var = this.L0.j().getWebView();
                } else {
                    ss1Var = this.L0.getWebView();
                }
                if (ss1Var != null) {
                    i2 = ss1Var.getWebViewScrollY();
                    z63Var = this.P0;
                    if (z63Var != null && z63Var.i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            z63Var = this.P0;
            if (z63Var != null) {
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
            ri3.h();
            if (this.c0.getWindow() != null) {
                this.c0.getWindow().getDecorView().setSystemUiVisibility(5376);
            }
            View b2 = g53.b();
            if (b2 != null) {
                b2.setVisibility(0);
                b2.findViewById(R.id.obfuscated_res_0x7f0926ad).setVisibility(8);
            }
            SwanAppActionBar P1 = P1();
            if (P1 != null) {
                P1.setRightMenuStyle();
                P1.setRightZoneImmersiveStyle();
                P1.setBackgroundColor(0);
            }
            View i0 = i0();
            if (i0 != null) {
                i0.findViewById(R.id.obfuscated_res_0x7f091197).setBackgroundColor(0);
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
            Map<String, rs1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (rs1 rs1Var : this.J0.values()) {
                    if (rs1Var != null) {
                        e4(rs1Var);
                        rs1Var.destroy();
                    }
                }
                this.J0.clear();
            } else {
                rs1 rs1Var2 = this.L0;
                if (rs1Var2 != null) {
                    e4(rs1Var2);
                    this.L0.destroy();
                }
            }
            this.L0 = null;
            if (W0) {
                Log.d("SwanAppFragment", "onDestroy() obj: " + this);
            }
            if (!this.T0) {
                pc2.n(xr2.V().getActivity());
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
                yw2.e().i(true);
            }
            k32.i("SwanApp", "onShow");
            jt2.i(a2, true);
            if (k32.f()) {
                f52.b();
            }
            if (k63.c0() != null) {
                str = k63.c0().P();
            }
            rp2.H().e(str);
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
        lw2 g2 = lw2.g(r.getString("ai_apps_param"));
        this.d0 = g2;
        if (g2 == null) {
            kw2 kw2Var = this.H0;
            kw2Var.a = "";
            kw2Var.b = "";
            kw2Var.e = "";
            kw2Var.f = "";
        } else {
            this.H0.a = g2.i();
            this.H0.b = this.d0.j();
            this.H0.e = this.d0.l();
            this.H0.f = this.d0.k();
        }
        kw2 kw2Var2 = this.H0;
        kw2Var2.d = ca3.b(kw2Var2.e());
        z63 f2 = xr2.V().f(this.H0.g());
        this.P0 = f2;
        if (f2.p) {
            this.P0 = xr2.V().j(this.H0.e());
        }
        if (this.E0) {
            z63 z63Var = this.P0;
            z63Var.f = false;
            z63Var.h = true;
            z63Var.p = true;
        }
        this.Q0 = O1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070160);
    }

    public final void X3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (TextUtils.equals(a1, this.L0.a()) && !TextUtils.equals(b1, "switchTab")) {
                return;
            }
            int o = this.M0.o(t3().g());
            og2 og2Var = new og2();
            og2Var.c = a1;
            og2Var.d = this.L0.a();
            og2Var.e = b1;
            og2Var.f = this.H0.a;
            og2Var.g = String.valueOf(o);
            b1 = "";
            if (W0) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + og2Var.c + " ,toId: " + og2Var.d + " ,RouteType: " + og2Var.e + " page:" + og2Var.f + ",TabIndex: " + og2Var.g);
            }
            xr2.V().v(og2Var);
            a1 = this.L0.a();
        }
    }

    public void pause() {
        boolean z;
        String a2;
        PullToRefreshBaseWebView e0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
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
                yw2.e().i(false);
            }
            if (getFloatLayer() != null && !getFloatLayer().d() && (!getFloatLayer().g() || getFloatLayer().k())) {
                getFloatLayer().h();
            }
            k32.i("SwanApp", "onHide");
            jt2.i(a2, false);
            if (!z && (e0 = this.L0.e0()) != null) {
                e0.w(false);
            }
            if (k63.c0() != null) {
                str = k63.c0().P();
            }
            rp2.H().f(str);
        }
    }

    public final void W3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.L0.a());
            mg2 mg2Var = new mg2(hashMap);
            if (W0) {
                Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.L0.a());
            }
            xr2.V().v(mg2Var);
        }
    }

    public void c4(kw2 kw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, kw2Var) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "switchTab pageParam: " + kw2Var);
            }
            if (this.M0.o(t3().g()) == this.M0.o(kw2Var.g())) {
                kw2 kw2Var2 = this.H0;
                kw2Var2.e = kw2Var.e;
                kw2Var2.f = kw2Var.f;
                return;
            }
            this.M0.E(kw2Var.g());
            onPause();
            s3(kw2Var, "");
        }
    }

    public final void h4(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            int i3 = 0;
            if (z) {
                ll3 ll3Var = this.u0;
                if (ll3Var != null && ll3Var.i()) {
                    i2 = bk3.t();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.K0.getLayoutParams();
                    layoutParams.topMargin = i3;
                    this.K0.setLayoutParams(layoutParams);
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.e0.getLayoutParams();
                    layoutParams2.topMargin = i2;
                    this.e0.setLayoutParams(layoutParams2);
                }
            } else {
                i3 = O1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070160);
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
            if (rp2.K().k(z, 1)) {
                iw2.k(z(), this.f0, k63.c0().X().g0().paNumber);
            } else if (k63.c0() == null) {
            } else {
                iw2.o(this.f0, k63.c0().V().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    @Override // com.baidu.tieba.q52
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
            if (!uc3.i()) {
                uc3.d(j63.K().q().X());
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

    public final void d4(String str, kw2 kw2Var) {
        rs1 rs1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048612, this, str, kw2Var) == null) && this.L0 != (rs1Var = this.J0.get(str)) && rs1Var != null) {
            z63 f2 = xr2.V().f(str);
            rs1Var.x(this.K0, f2);
            if (!rs1Var.c()) {
                rs1Var.M(this.K0, f2);
            }
            rs1Var.A(0);
            rs1 rs1Var2 = this.L0;
            if (rs1Var2 != null) {
                rs1Var2.A(8);
            }
            this.L0 = rs1Var;
            kw2 kw2Var2 = this.H0;
            kw2Var2.e = kw2Var.e;
            kw2Var2.f = kw2Var.f;
            rs1Var.g(kw2Var2);
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
            ll3 ll3Var = this.u0;
            if (ll3Var != null && ll3Var.i() && (e2 = this.u0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.f0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            z63 z63Var = this.P0;
            if (z63Var != null && z63Var.i && (centerTitleView = this.f0.getCenterTitleView()) != null) {
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
        if (interceptable == null || interceptable.invokeL(1048627, this, view2) == null) {
            oz2.a("route", "createSlaveWebView start.");
            String h2 = this.d0.h();
            String j = this.d0.j();
            String i2 = this.d0.i();
            String a2 = ek3.a(h2, i2, j);
            this.L0 = pc2.h(a2);
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
            z63 f2 = xr2.V().f(i2);
            this.L0.x(this.K0, f2);
            this.L0.M(this.K0, f2);
            I3(i2);
            k3(this.L0);
            if (k2()) {
                this.J0.put(i2, this.L0);
                this.M0.f(view2, z(), i2);
            }
            oz2.a("route", "createSlaveWebView end.");
            l3();
        }
    }

    public final rs1 n3(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048625, this, str, str2, str3, str4)) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad start.");
            }
            pc2.e f2 = pc2.f(n(), uc2.c(str2));
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = pz2.q("route", str4);
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
            pc2.q(f2, new d(this, f2, str4, str2, str, str3));
            if (W0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad end.");
            }
            return f2.a;
        }
        return (rs1) invokeLLLL.objValue;
    }

    public final void p3(kw2 kw2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048632, this, kw2Var, str) == null) && this.J0.get(kw2Var.d) == null) {
            String a2 = ek3.a(kw2Var.c, kw2Var.a, kw2Var.b);
            rs1 h2 = pc2.h(a2);
            if (h2 != null) {
                if (W0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + a2);
                }
                this.J0.put(kw2Var.a, h2);
            } else {
                if (W0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                h2 = n3(kw2Var.c, kw2Var.a, kw2Var.b, str);
                this.J0.put(kw2Var.a, h2);
            }
            I3(kw2Var.a);
            k3(h2);
        }
    }

    public void s3(kw2 kw2Var, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048637, this, kw2Var, str) == null) {
            Z3(this.H0);
            this.I0 = Z0;
            if (W0) {
                Log.d("SwanAppFragment", "doSwitchTab mPrePageParams=" + this.I0);
            }
            String str3 = kw2Var.a;
            String str4 = kw2Var.d;
            xr2 V = xr2.V();
            String str5 = "";
            if (TextUtils.isEmpty(str4)) {
                str2 = "";
            } else {
                str2 = str4;
            }
            z63 f2 = V.f(str2);
            kw2 kw2Var2 = this.H0;
            kw2Var2.a = str3;
            if (kw2Var != null) {
                str5 = kw2Var.f();
            }
            kw2Var2.b = str5;
            this.H0.d = str4;
            this.P0 = f2;
            boolean z = !R3(str4);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    qz2.c(7, str);
                } else {
                    qz2.c(6, str);
                }
            }
            if (!z) {
                d4(str4, kw2Var);
            } else {
                p3(kw2Var, str);
                d4(str3, kw2Var);
            }
            if (!TextUtils.isEmpty(str)) {
                pz2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                qz2.a(str, kw2Var);
            }
            C2(f2.b);
            J2(SwanAppConfigData.t(f2.c));
            A2(f2.a);
            U3();
            g4();
            k32.i("SwanAppFragment", "switch tab title: " + f2.b + " page:" + str3);
        }
    }
}
