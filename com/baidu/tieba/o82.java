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
import com.baidu.tieba.lf2;
import com.baidu.tieba.n83;
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
public class o82 extends m82 implements n83.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean W0;
    public static final int X0;
    public static String Y0;
    public static gz2 Z0;
    public static String a1;
    public static String b1;
    public transient /* synthetic */ FieldHolder $fh;
    public mf3 G0;
    public gz2 H0;
    public gz2 I0;
    public Map<String, mv1> J0;
    public FrameLayout K0;
    public mv1 L0;
    public sk3 M0;
    public n83 N0;
    public View O0;
    public v93 P0;
    public int Q0;
    public ta2 R0;
    public ku1 S0;
    public boolean T0;
    public boolean U0;
    public boolean V0;

    @Override // com.baidu.tieba.m82
    public boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class e implements zn3<ge3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o82 a;

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
                this.a.a.U0 = false;
                this.a.a.E2(true, false);
            }
        }

        public e(o82 o82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(ge3 ge3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ge3Var) == null) && ge3Var != null && !ge3Var.d && ge3Var.j == 1) {
                an3.e0(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o82 a;

        public a(o82 o82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o82Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.S0 = ns2.Q();
                ku1 ku1Var = this.a.S0;
                o82 o82Var = this.a;
                ku1Var.a(o82Var.b0, o82Var.d0, o82Var.getContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements SwanAppActionBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o82 a;

        public b(o82 o82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o82Var;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void onDoubleClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String a = this.a.L0.a();
                mj2 mj2Var = new mj2();
                mj2Var.c = no3.a(a, "scrollViewBackToTop");
                tu2.U().m(a, mj2Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o82 a;

        public c(o82 o82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o82Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.m3();
        }
    }

    /* loaded from: classes6.dex */
    public class d implements lf2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ o82 f;

        public d(o82 o82Var, lf2.e eVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o82Var, eVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = o82Var;
            this.a = eVar;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [com.baidu.tieba.nv1] */
        @Override // com.baidu.tieba.lf2.f
        public void onReady() {
            String str;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xf2 xf2Var = new xf2();
                xf2Var.i = this.a.a.J();
                if (!TextUtils.isEmpty(this.b)) {
                    m23.e(this.a, this.b);
                }
                String b = yc3.b(this.c);
                xf2Var.a = this.d;
                if (TextUtils.isEmpty(this.e)) {
                    str = this.c;
                } else {
                    str = this.c + "?" + this.e;
                }
                xf2Var.b = str;
                if (g93.b0() != null) {
                    xf2Var.c = g93.b0().d0(b);
                    xf2Var.f = g93.b0().X(b);
                }
                xf2Var.k = uf2.c(g93.M(), xf2Var.b);
                xf2Var.d = tu2.U().f(b).g;
                xf2Var.e = String.valueOf(d62.a());
                if (!o82.W0 && !tu2.U().N()) {
                    z = false;
                } else {
                    z = true;
                }
                xf2Var.g = z;
                if (f53.H()) {
                    xf2Var.j = j62.d();
                }
                if (!TextUtils.isEmpty(this.b)) {
                    String str2 = this.b;
                    xf2Var.h = str2;
                    l23.q("route", str2).F(new UbcFlowEvent("slave_dispatch_start"));
                }
                nm3.d();
                this.a.a.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.c);
                this.a.a.R(xf2Var.b);
                tu2.U().m(this.a.a.a(), xf2.a(xf2Var));
                if (yf2.b()) {
                    yf2 yf2Var = new yf2();
                    yf2Var.a = this.a.a.a();
                    tu2.U().u(yf2.a(yf2Var));
                }
                qf3.F(this.a.a.a(), xf2Var.b);
                if (o82.W0) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + xf2Var.toString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ta2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o82 a;

        public f(o82 o82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o82Var;
        }

        @Override // com.baidu.tieba.ta2
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIIII(1048576, this, i, i2, i3, i4) != null) {
                return;
            }
            this.a.b4(i2);
        }
    }

    /* loaded from: classes6.dex */
    public class g implements va2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o82 a;

        public g(o82 o82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o82Var;
        }

        @Override // com.baidu.tieba.va2
        public void a(pv1 pv1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, pv1Var) == null) && pv1Var != null) {
                pv1Var.t(this.a.R0);
                pv1Var.Y(this.a.B3());
                uz2.e().a(pv1Var);
            }
        }

        @Override // com.baidu.tieba.va2
        public void b(pv1 pv1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pv1Var) == null) && pv1Var != null) {
                pv1Var.U(this.a.R0);
                uz2.e().b(pv1Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends ra2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o82 c;

        public h(o82 o82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o82Var;
        }

        @Override // com.baidu.tieba.ra2, com.baidu.tieba.ua2
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.c.y2(str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-591167717, "Lcom/baidu/tieba/o82$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-591167717, "Lcom/baidu/tieba/o82$i;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (a < 0) {
                    ns2.g0().getSwitch("swan_app_fragment_destroy_switch", 1);
                    a = 1;
                }
                if (o82.W0) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947986048, "Lcom/baidu/tieba/o82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947986048, "Lcom/baidu/tieba/o82;");
                return;
            }
        }
        W0 = qp1.a;
        X0 = xm3.g(149.0f);
        Y0 = "-1";
        a1 = "-1";
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.A0();
            this.C0.a();
            if (i.b()) {
                an3.q().postAtFrontOfQueue(new c(this));
            } else {
                m3();
            }
        }
    }

    public FrameLayout A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.K0;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public final ra2 B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new h(this);
        }
        return (ra2) invokeV.objValue;
    }

    public final va2 C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new g(this);
        }
        return (va2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m82, com.baidu.swan.support.v4.app.Fragment
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.D0();
        }
    }

    public final void D3() {
        jq2 F0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            mv1 r3 = r3();
            if ((r3 instanceof SwanAppWebViewManager) && (F0 = ((SwanAppWebViewManager) r3).F0()) != null) {
                F0.d();
            }
        }
    }

    public boolean G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            sk3 sk3Var = this.M0;
            if (sk3Var == null) {
                return false;
            }
            return sk3Var.p();
        }
        return invokeV.booleanValue;
    }

    public final boolean I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            v93 v93Var = this.P0;
            if (v93Var != null && v93Var.h) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.m82
    public v93 J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.P0;
        }
        return (v93) invokeV.objValue;
    }

    public boolean J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            v93 v93Var = this.P0;
            if (v93Var != null) {
                return TextUtils.equals(v93Var.j, ExceptionHandlerImpl.KEY_CUSTOM);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean M3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            SwanAppConfigData s = tu2.U().s();
            if (s != null && !TextUtils.equals(s.f(), this.H0.e())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c4() {
        hz2 hz2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048608, this) != null) || (hz2Var = this.d0) == null) {
            return;
        }
        hz2Var.n();
    }

    public PullToRefreshBaseWebView h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            mv1 mv1Var = this.L0;
            if (mv1Var != null) {
                return mv1Var.h0();
            }
            return null;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    public final void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.G0 = zf3.c("805");
        }
    }

    public final void i3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            f93.K().q().e0().e("mapp_i_custom_navigation_bar", new e(this));
        }
    }

    public void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.P0.j = "default";
            x1();
            Q3();
        }
    }

    @Override // com.baidu.tieba.m82, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onPause();
            c1();
        }
    }

    @Override // com.baidu.tieba.m82, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onResume();
            g1();
            v3(false);
        }
    }

    @NonNull
    public gz2 p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.H0;
        }
        return (gz2) invokeV.objValue;
    }

    public mv1 r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.L0;
        }
        return (mv1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m82
    public void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            super.s2();
            Q3();
            if (this.V0) {
                W3();
            }
        }
    }

    public final int s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            if (g2()) {
                if (M3()) {
                    return 18;
                }
                return 17;
            } else if (M3()) {
                return 12;
            } else {
                return 15;
            }
        }
        return invokeV.intValue;
    }

    @Nullable
    public gz2 u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.I0;
        }
        return (gz2) invokeV.objValue;
    }

    public String w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            mv1 mv1Var = this.L0;
            if (mv1Var != null) {
                return mv1Var.a();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public sk3 y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.M0;
        }
        return (sk3) invokeV.objValue;
    }

    public o82() {
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
        this.H0 = new gz2();
        this.J0 = new TreeMap();
        this.Q0 = 0;
        this.T0 = false;
        this.U0 = false;
        this.V0 = false;
    }

    private void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            if (a0()) {
                pause();
            }
            if (W0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.L0.a())));
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.C0();
            Map<String, mv1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (mv1 mv1Var : this.J0.values()) {
                    if (mv1Var != null) {
                        mv1Var.e0();
                    }
                }
            } else {
                mv1 mv1Var2 = this.L0;
                if (mv1Var2 != null) {
                    mv1Var2.e0();
                }
            }
            D3();
        }
    }

    public final boolean H3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            SwanAppConfigData s = tu2.U().s();
            boolean z = false;
            if (s == null) {
                return false;
            }
            return !((TextUtils.equals(s.f(), this.H0.a) || s.r(this.H0.a)) ? true : true);
        }
        return invokeV.booleanValue;
    }

    public final boolean L3() {
        InterceptResult invokeV;
        boolean z;
        SwanAppConfigData s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            p82 P1 = P1();
            if (P1 == null) {
                return false;
            }
            v93 v93Var = this.P0;
            if (v93Var != null && v93Var.k) {
                z = true;
            } else {
                z = false;
            }
            if (z || (s = tu2.U().s()) == null) {
                return false;
            }
            return !K3(P1, s);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.n83.a
    public n83 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.N0 == null) {
                if (this.O0 == null) {
                    return null;
                }
                this.N0 = new n83(this, (LinearLayout) this.O0.findViewById(R.id.obfuscated_res_0x7f09018a), M1().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070160));
            }
            return this.N0;
        }
        return (n83) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m82
    public boolean h2() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        hz2 hz2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            tu2 U = tu2.U();
            if (U == null || (s = U.s()) == null || !s.n() || (hz2Var = this.d0) == null) {
                return false;
            }
            return s.r(hz2Var.i());
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.m82
    public void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            mv1 mv1Var = this.L0;
            if (mv1Var != null) {
                mv1Var.T();
            }
            F3();
            t3(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(eg2.n(f93.K().getAppId()));
            }
            this.g0.u(ns2.M().a(), K1(), this.h0, false);
        }
    }

    public static o82 P3(hz2 hz2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hz2Var)) == null) {
            o82 o82Var = new o82();
            if (hz2Var != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", hz2Var.m());
                o82Var.l1(bundle);
            }
            return o82Var;
        }
        return (o82) invokeL.objValue;
    }

    public static void X3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            b1 = str;
        }
    }

    public final boolean N3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            if (this.J0.isEmpty() || this.J0.get(str) == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void O3(kg3 kg3Var) {
        mf3 mf3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, kg3Var) == null) && (mf3Var = this.G0) != null) {
            zf3.i(mf3Var, kg3Var);
            this.G0 = null;
        }
    }

    public void U3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.V0 = z;
        }
    }

    public final void a4(mv1 mv1Var) {
        ta2 ta2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048606, this, mv1Var) != null) || (ta2Var = this.R0) == null || mv1Var == null) {
            return;
        }
        mv1Var.U(ta2Var);
        if (mv1Var.k() != null) {
            mv1Var.U(this.R0);
        }
    }

    public final void g3(mv1 mv1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048612, this, mv1Var) != null) || mv1Var == null) {
            return;
        }
        ta2 ta2Var = this.R0;
        if (ta2Var != null) {
            mv1Var.t(ta2Var);
        }
        mv1Var.Z(C3());
    }

    @Override // com.baidu.tieba.m82, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, motionEvent)) == null) {
            if (c2() && this.L0.isSlidable(motionEvent)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void t0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, activity) == null) {
            super.t0(activity);
            if (W0) {
                Log.d("SwanAppFragment", "onAttach() obj: " + this);
            }
        }
    }

    @Override // com.baidu.tieba.m82
    public boolean w2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048641, this, i2)) == null) {
            boolean w2 = super.w2(i2);
            Q3();
            return w2;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.m82
    public void y1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
            if (!v93.f(this.P0)) {
                super.y1(i2);
                return;
            }
            boolean z = true;
            if (!J3()) {
                z = true ^ pm3.h(this.c0);
            }
            z1(i2, z);
            Q3();
        }
    }

    public String z3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, str)) == null) {
            if (this.J0.containsKey(str)) {
                return this.J0.get(str).a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void V3(gz2 gz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, gz2Var) == null) {
            try {
                if (W0) {
                    Log.d("SwanAppFragment", "setLastPageParams =" + gz2Var);
                }
                if (gz2Var == null) {
                    Z0 = null;
                } else {
                    Z0 = (gz2) gz2Var.clone();
                }
            } catch (Exception e2) {
                if (W0) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void E3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, str) != null) || J3()) {
            return;
        }
        tu2 U = tu2.U();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (U.f(str).h && this.R0 == null) {
            this.R0 = new f(this);
        }
    }

    @Override // com.baidu.tieba.m82, com.baidu.swan.support.v4.app.Fragment
    public void o1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048625, this, z) != null) || !m0()) {
            return;
        }
        super.o1(z);
        if (W0) {
            Log.d("SwanAppFragment", "setUserVisibleHint isVisibleToUser: " + z);
        }
        if (z) {
            resume();
            v3(false);
            return;
        }
        pause();
    }

    public final void t3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048637, this, z) == null) && ns2.K().k(z, 2)) {
            ez2.l(getContext(), this.g0, this.f0, g93.b0().W().f0().paNumber);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void w0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, bundle) == null) {
            super.w0(bundle);
            R3();
            if (W0) {
                Log.d("SwanAppFragment", "onCreate() obj: " + this);
            }
            am3.j(new a(this), "SwanAppPageHistory");
            k23.a("route", "fragment create.");
        }
    }

    private void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if (a0()) {
                resume();
            }
            nf4 nf4Var = this.g0;
            if (nf4Var != null && nf4Var.i()) {
                this.g0.B(ns2.M().a());
            }
            if (W0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.L0.a())));
            }
        }
    }

    @DebugTrace
    public void F3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            FragmentActivity activity = getActivity();
            if (this.h0 == null) {
                this.h0 = new SwanAppMenuHeaderView(getContext());
            }
            if (activity != null && this.g0 == null) {
                this.g0 = new nf4(activity, this.f0, s3(), ns2.K(), new po3());
                new wy2(this.g0, this, this.h0).z();
                if (cz2.e()) {
                    this.g0.l(50);
                }
            }
        }
    }

    @Override // com.baidu.tieba.m82
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
            mv1 mv1Var = this.L0;
            if (mv1Var != null) {
                if (fw2.g(mv1Var.a())) {
                    return true;
                }
                return this.L0.I();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.m82
    public void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.L0 == null) {
                if (W0) {
                    Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.L0.a());
            pv1 k = this.L0.k();
            if (k != null) {
                hashMap.put("webViewUrl", k.getCurrentPageUrl());
            }
            tu2.U().u(new hj2("sharebtn", hashMap));
        }
    }

    @Override // com.baidu.tieba.m82
    public void l2() {
        hz2 Q1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            S1();
            jg3 jg3Var = new jg3();
            jg3Var.e = "gohome";
            jg3Var.c = "bar";
            o82 H = tu2.U().H();
            if (H == null) {
                Q1 = null;
            } else {
                Q1 = H.Q1();
            }
            if (Q1 != null && !TextUtils.isEmpty(Q1.i())) {
                jg3Var.a("page", Q1.i());
            }
            D1(jg3Var);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.nv1] */
    @NonNull
    public Pair<Integer, Integer> q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            mv1 mv1Var = this.L0;
            if (mv1Var == null) {
                return new Pair<>(0, 0);
            }
            View currentWebView = mv1Var.r().getCurrentWebView();
            if (currentWebView == null) {
                return new Pair<>(0, 0);
            }
            return new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
        }
        return (Pair) invokeV.objValue;
    }

    public List<String> x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, mv1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, mv1> entry : this.J0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(entry.getValue().a());
                    }
                }
            }
            mv1 mv1Var = this.L0;
            if (mv1Var != null) {
                String a2 = mv1Var.a();
                if (!arrayList.contains(a2)) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean K3(p82 p82Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, p82Var, swanAppConfigData)) == null) {
            m82 j = p82Var.j(0);
            if (j == null || !(j instanceof o82)) {
                return false;
            }
            String e2 = ((o82) j).p3().e();
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
    public final void Q3() {
        int i2;
        v93 v93Var;
        nv1 nv1Var;
        TextView centerTitleView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || this.f0 == null) {
            return;
        }
        int i3 = 1;
        boolean z = false;
        if (J3()) {
            E2(true, this.U0);
            i2 = 0;
        } else if (I3()) {
            E2(false, false);
            mv1 mv1Var = this.L0;
            if (mv1Var != null) {
                if (mv1Var.k() != null) {
                    nv1Var = this.L0.k().r();
                } else {
                    nv1Var = this.L0.r();
                }
                if (nv1Var != null) {
                    i2 = nv1Var.getWebViewScrollY();
                    v93Var = this.P0;
                    if (v93Var != null && v93Var.i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            v93Var = this.P0;
            if (v93Var != null) {
                i3 = 0;
            }
        } else {
            E2(false, false);
            i2 = X0 + this.Q0;
            centerTitleView = this.f0.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i3);
            }
            b4(i2);
            d4(z);
        }
        z = true;
        centerTitleView = this.f0.getCenterTitleView();
        if (centerTitleView != null) {
        }
        b4(i2);
        d4(z);
    }

    public final void W3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "setting immersive portrait fullscreen video");
            }
            nl3.h();
            if (this.c0.getWindow() != null) {
                this.c0.getWindow().getDecorView().setSystemUiVisibility(5376);
            }
            View b2 = c83.b();
            if (b2 != null) {
                b2.setVisibility(0);
                b2.findViewById(R.id.obfuscated_res_0x7f092496).setVisibility(8);
            }
            SwanAppActionBar N1 = N1();
            if (N1 != null) {
                N1.setRightMenuStyle();
                N1.setRightZoneImmersiveStyle();
                N1.setBackgroundColor(0);
            }
            View b0 = b0();
            if (b0 != null) {
                b0.findViewById(R.id.obfuscated_res_0x7f0910c7).setBackgroundColor(0);
                FrameLayout frameLayout = (FrameLayout) b0.findViewById(R.id.obfuscated_res_0x7f09018b);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams);
            }
        }
    }

    public final void m3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            Map<String, mv1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (mv1 mv1Var : this.J0.values()) {
                    if (mv1Var != null) {
                        a4(mv1Var);
                        mv1Var.destroy();
                    }
                }
                this.J0.clear();
            } else {
                mv1 mv1Var2 = this.L0;
                if (mv1Var2 != null) {
                    a4(mv1Var2);
                    this.L0.destroy();
                }
            }
            this.L0 = null;
            if (W0) {
                Log.d("SwanAppFragment", "onDestroy() obj: " + this);
            }
            if (!this.T0) {
                lf2.n(tu2.U().getActivity());
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
                A2((c2() || H3()) ? true : true);
                this.L0.onResume();
                T3();
                S3("onShow");
                uz2.e().i(true);
            }
            g62.i("SwanApp", "onShow");
            fw2.i(a2, true);
            if (g62.f()) {
                b82.b();
            }
            if (g93.b0() != null) {
                str = g93.b0().O();
            }
            ns2.H().e(str);
        }
    }

    public final void R3() {
        Bundle p;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || (p = p()) == null) {
            return;
        }
        this.I0 = Z0;
        if (W0) {
            Log.d("SwanAppFragment", "restoreArguments sPrePageParams=" + this.I0);
        }
        hz2 g2 = hz2.g(p.getString("ai_apps_param"));
        this.d0 = g2;
        if (g2 == null) {
            gz2 gz2Var = this.H0;
            gz2Var.a = "";
            gz2Var.b = "";
            gz2Var.e = "";
            gz2Var.f = "";
        } else {
            this.H0.a = g2.i();
            this.H0.b = this.d0.j();
            this.H0.e = this.d0.l();
            this.H0.f = this.d0.k();
        }
        gz2 gz2Var2 = this.H0;
        gz2Var2.d = yc3.b(gz2Var2.e());
        v93 f2 = tu2.U().f(this.H0.g());
        this.P0 = f2;
        if (f2.p) {
            this.P0 = tu2.U().j(this.H0.e());
        }
        if (this.E0) {
            v93 v93Var = this.P0;
            v93Var.f = false;
            v93Var.h = true;
            v93Var.p = true;
        }
        this.Q0 = M1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070160);
    }

    public final void T3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (TextUtils.equals(a1, this.L0.a()) && !TextUtils.equals(b1, "switchTab")) {
                return;
            }
            int o = this.M0.o(p3().g());
            kj2 kj2Var = new kj2();
            kj2Var.c = a1;
            kj2Var.d = this.L0.a();
            kj2Var.e = b1;
            kj2Var.f = this.H0.a;
            kj2Var.g = String.valueOf(o);
            b1 = "";
            if (W0) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + kj2Var.c + " ,toId: " + kj2Var.d + " ,RouteType: " + kj2Var.e + " page:" + kj2Var.f + ",TabIndex: " + kj2Var.g);
            }
            tu2.U().u(kj2Var);
            a1 = this.L0.a();
        }
    }

    public void pause() {
        boolean z;
        String a2;
        PullToRefreshBaseWebView h0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
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
                S3("onHide");
                uz2.e().i(false);
            }
            if (d() != null && !d().c() && (!d().f() || d().j())) {
                d().g();
            }
            g62.i("SwanApp", "onHide");
            fw2.i(a2, false);
            if (!z && (h0 = this.L0.h0()) != null) {
                h0.w(false);
            }
            if (g93.b0() != null) {
                str = g93.b0().O();
            }
            ns2.H().f(str);
        }
    }

    public final void S3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.L0.a());
            ij2 ij2Var = new ij2(hashMap);
            if (W0) {
                Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.L0.a());
            }
            tu2.U().u(ij2Var);
        }
    }

    public void Y3(gz2 gz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, gz2Var) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "switchTab pageParam: " + gz2Var);
            }
            if (this.M0.o(p3().g()) == this.M0.o(gz2Var.g())) {
                gz2 gz2Var2 = this.H0;
                gz2Var2.e = gz2Var.e;
                gz2Var2.f = gz2Var.f;
                return;
            }
            this.M0.E(gz2Var.g());
            onPause();
            o3(gz2Var, "");
        }
    }

    public final void d4(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            int i3 = 0;
            if (z) {
                ho3 ho3Var = this.u0;
                if (ho3Var != null && ho3Var.i()) {
                    i2 = xm3.t();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.K0.getLayoutParams();
                    layoutParams.topMargin = i3;
                    this.K0.setLayoutParams(layoutParams);
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.e0.getLayoutParams();
                    layoutParams2.topMargin = i2;
                    this.e0.setLayoutParams(layoutParams2);
                }
            } else {
                i3 = M1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070160);
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

    public final void v3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
            if (ns2.K().k(z, 1)) {
                ez2.k(getContext(), this.f0, g93.b0().W().f0().paNumber);
            } else if (g93.b0() == null) {
            } else {
                ez2.o(this.f0, g93.b0().U().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    @Override // com.baidu.tieba.m82
    public void X1(View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, view2) == null) {
            super.X1(view2);
            boolean z2 = false;
            if (!c2() && !H3()) {
                z = false;
            } else {
                z = true;
            }
            A2(z);
            if (L3()) {
                i2();
            }
            Q3();
            this.f0.setOnDoubleClickListener(new b(this));
            if (!qf3.i()) {
                qf3.d(f93.K().q().W());
            }
            if (J3() && H3()) {
                z2 = true;
            }
            this.U0 = z2;
            if (z2) {
                i3();
            }
        }
    }

    public final void Z3(String str, gz2 gz2Var) {
        mv1 mv1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048605, this, str, gz2Var) == null) && this.L0 != (mv1Var = this.J0.get(str)) && mv1Var != null) {
            v93 f2 = tu2.U().f(str);
            mv1Var.z(this.K0, f2);
            if (!mv1Var.c()) {
                mv1Var.O(this.K0, f2);
            }
            mv1Var.C(0);
            mv1 mv1Var2 = this.L0;
            if (mv1Var2 != null) {
                mv1Var2.C(8);
            }
            this.L0 = mv1Var;
            gz2 gz2Var2 = this.H0;
            gz2Var2.e = gz2Var.e;
            gz2Var2.f = gz2Var.f;
            mv1Var.h(gz2Var2);
        }
    }

    public final void b4(int i2) {
        TextView centerTitleView;
        View e2;
        Drawable background;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
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
            ho3 ho3Var = this.u0;
            if (ho3Var != null && ho3Var.i() && (e2 = this.u0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.f0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            v93 v93Var = this.P0;
            if (v93Var != null && v93Var.i && (centerTitleView = this.f0.getCenterTitleView()) != null) {
                centerTitleView.setAlpha(f2);
            }
            Drawable background3 = this.i0.getBackground();
            if (background3 != null) {
                background3.setAlpha(i4);
            }
        }
    }

    public final void k3(View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, view2) == null) {
            k23.a("route", "createSlaveWebView start.");
            String h2 = this.d0.h();
            String j = this.d0.j();
            String i2 = this.d0.i();
            String a2 = an3.a(h2, i2, j);
            this.L0 = lf2.h(a2);
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
                this.L0 = j3(h2, i2, j, "");
            }
            this.L0.h(this.H0);
            v93 f2 = tu2.U().f(i2);
            this.L0.z(this.K0, f2);
            this.L0.O(this.K0, f2);
            E3(i2);
            g3(this.L0);
            if (h2()) {
                this.J0.put(i2, this.L0);
                this.M0.f(view2, getContext(), i2);
            }
            k23.a("route", "createSlaveWebView end.");
            h3();
        }
    }

    public final mv1 j3(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048618, this, str, str2, str3, str4)) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad start.");
            }
            lf2.e f2 = lf2.f(getActivity(), qf2.c(str2));
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = l23.q("route", str4);
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
            lf2.q(f2, new d(this, f2, str4, str2, str, str3));
            if (W0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad end.");
            }
            return f2.a;
        }
        return (mv1) invokeLLLL.objValue;
    }

    public final void l3(gz2 gz2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048621, this, gz2Var, str) == null) && this.J0.get(gz2Var.d) == null) {
            String a2 = an3.a(gz2Var.c, gz2Var.a, gz2Var.b);
            mv1 h2 = lf2.h(a2);
            if (h2 != null) {
                if (W0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + a2);
                }
                this.J0.put(gz2Var.a, h2);
            } else {
                if (W0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                h2 = j3(gz2Var.c, gz2Var.a, gz2Var.b, str);
                this.J0.put(gz2Var.a, h2);
            }
            E3(gz2Var.a);
            g3(h2);
        }
    }

    public void o3(gz2 gz2Var, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048626, this, gz2Var, str) == null) {
            V3(this.H0);
            this.I0 = Z0;
            if (W0) {
                Log.d("SwanAppFragment", "doSwitchTab mPrePageParams=" + this.I0);
            }
            String str3 = gz2Var.a;
            String str4 = gz2Var.d;
            tu2 U = tu2.U();
            String str5 = "";
            if (TextUtils.isEmpty(str4)) {
                str2 = "";
            } else {
                str2 = str4;
            }
            v93 f2 = U.f(str2);
            gz2 gz2Var2 = this.H0;
            gz2Var2.a = str3;
            if (gz2Var != null) {
                str5 = gz2Var.f();
            }
            gz2Var2.b = str5;
            this.H0.d = str4;
            this.P0 = f2;
            boolean z = !N3(str4);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    m23.c(7, str);
                } else {
                    m23.c(6, str);
                }
            }
            if (!z) {
                Z3(str4, gz2Var);
            } else {
                l3(gz2Var, str);
                Z3(str3, gz2Var);
            }
            if (!TextUtils.isEmpty(str)) {
                l23.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                m23.a(str, gz2Var);
            }
            y2(f2.b);
            F2(SwanAppConfigData.t(f2.c));
            w2(f2.a);
            Q3();
            c4();
            g62.i("SwanAppFragment", "switch tab title: " + f2.b + " page:" + str3);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048646, this, layoutInflater, viewGroup, bundle)) == null) {
            k23.a("route", "fragment onCreateView.");
            View b2 = q33.a().b(R.layout.obfuscated_res_0x7f0d00ab, viewGroup, false);
            this.K0 = (FrameLayout) b2.findViewById(R.id.obfuscated_res_0x7f09018b);
            X1(b2);
            W2(b2);
            this.M0 = new sk3(this);
            k3(b2);
            if (!cz2.e() && !cz2.f()) {
                bz2.b(this.L0.a(), String.valueOf(cz2.d()), String.valueOf(cz2.a(cz2.b())));
            }
            if (W1()) {
                b2 = Z1(b2);
            }
            this.O0 = G1(b2, this);
            J2(this.L0.A());
            uz2.e().m();
            return this.O0;
        }
        return (View) invokeLLL.objValue;
    }
}
