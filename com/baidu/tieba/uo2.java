package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.tieba.io2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class uo2 implements wo2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public qp1 a;
    public v33 b;
    public String c;
    @Deprecated
    public SwanAppActivity d;
    public xo2 e;
    public FullScreenFloatView f;
    public SwanAppPropertyWindow g;
    public boolean h;
    public boolean i;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ uo2 b;

        public a(uo2 uo2Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uo2Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uo2Var;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity swanAppActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (swanAppActivity = this.b.d) == null) {
                return;
            }
            int taskId = swanAppActivity.getTaskId();
            this.b.d.finish();
            if (this.a) {
                this.b.d.overridePendingTransition(0, R.anim.obfuscated_res_0x7f010026);
            }
            rf3.m().l(taskId);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uo2 a;

        public b(uo2 uo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uo2Var;
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.q().V();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948217649, "Lcom/baidu/tieba/uo2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948217649, "Lcom/baidu/tieba/uo2;");
                return;
            }
        }
        j = vj1.a;
    }

    public uo2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new v33();
        fa2.U();
        xo2 xo2Var = new xo2();
        this.e = xo2Var;
        xo2Var.h(this);
    }

    @Override // com.baidu.tieba.wo2
    public tp1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? fa2.U().e0(str) : (tp1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.wo2
    public View B(String str) {
        InterceptResult invokeL;
        sp1 r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            tp1 A = A(str);
            if (A == null || (r = A.r()) == null) {
                return null;
            }
            return r.getCurrentWebView();
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.wo2
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            t22 H = H();
            return H != null ? H.t3() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wo2
    @Nullable
    public l33 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? l33.M() : (l33) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wo2
    @CallSuper
    public void E(io2 io2Var, fm2 fm2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, io2Var, fm2Var) == null) {
            Q();
        }
    }

    @Override // com.baidu.tieba.wo2
    public zk1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (zk1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wo2
    @NonNull
    public final ob3 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            l33 b0 = l33.b0();
            if (b0 == null) {
                return new mb3();
            }
            return b0.h0();
        }
        return (ob3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wo2
    public t22 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            u22 T = T();
            if (T == null) {
                return null;
            }
            return T.o();
        }
        return (t22) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wo2
    public void I() {
        xo2 xo2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && k() && (xo2Var = this.e) != null) {
            xo2Var.i();
        }
    }

    @Override // com.baidu.tieba.wo2
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, activity)) == null) {
            Q();
            if (activity == null) {
                return null;
            }
            if (this.g == null && (viewGroup = (ViewGroup) activity.findViewById(R.id.obfuscated_res_0x7f090172)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.g);
            }
            return this.g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // com.baidu.tieba.wo2
    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.c = str;
        }
    }

    @Override // com.baidu.tieba.wo2
    public cl1 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (cl1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wo2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wo2
    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Q();
            l33 M = l33.M();
            io2.a Y = M != null ? M.Y() : null;
            return Y != null && ((j && Y.n0()) || nv1.g(Y) || nv1.d(Y));
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.wo2
    @CallSuper
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.i = true;
            xo2 xo2Var = this.e;
            if (xo2Var != null) {
                xo2Var.j();
                this.e = null;
            }
            pz2.b().d();
            U();
            ox2.e().g(k33.K().getAppId());
            hc3.u(true);
            this.d = null;
        }
    }

    @Override // com.baidu.tieba.wo2
    public cl1 P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return null;
        }
        return (cl1) invokeV.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public void Q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && getActivity() == null && j) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    public final void R(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.d == null) {
            return;
        }
        fh3.e0(new a(this, z));
    }

    @NonNull
    public Pair<Integer, Integer> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            t22 H = H();
            if (H == null) {
                return new Pair<>(0, 0);
            }
            return H.n3();
        }
        return (Pair) invokeV.objValue;
    }

    public u22 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity == null) {
                return null;
            }
            return swanAppActivity.X();
        }
        return (u22) invokeV.objValue;
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            FullScreenFloatView fullScreenFloatView = this.f;
            if (fullScreenFloatView != null) {
                ViewParent parent = fullScreenFloatView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f);
                }
            }
            qp1 qp1Var = this.a;
            if (qp1Var != null) {
                qp1Var.E();
            }
            k02.e();
        }
    }

    @Override // com.baidu.tieba.wo2
    public void a() {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (w = k33.K().w()) == null || w.isFinishing()) {
            return;
        }
        w.z0();
    }

    @Override // com.baidu.tieba.wo2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            l33 b0 = l33.b0();
            if (b0 == null || b0.Y() == null) {
                return null;
            }
            return io2.m1(b0.Y(), yo2.U().s());
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wo2
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.h = true;
        }
    }

    @Override // com.baidu.tieba.wo2
    @CallSuper
    public void d(io2 io2Var, fm2 fm2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, io2Var, fm2Var) == null) {
            Q();
        }
    }

    @Override // com.baidu.tieba.wo2
    @NonNull
    public a43 e(String str, SwanAppConfigData swanAppConfigData, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, str, swanAppConfigData, str2)) == null) {
            if (swanAppConfigData != null && !TextUtils.isEmpty(str2)) {
                return this.b.b(str2, str, swanAppConfigData.e);
            }
            return f(str);
        }
        return (a43) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.wo2
    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            R(true);
        }
    }

    @Override // com.baidu.tieba.wo2
    @NonNull
    public a43 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            SwanAppConfigData s = s();
            if (s == null) {
                if (j) {
                    Log.w("AiBaseController", "#getPageWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception()));
                }
                return a43.d();
            }
            return this.b.b(z(), str, s.e);
        }
        return (a43) invokeL.objValue;
    }

    @Override // com.baidu.tieba.wo2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            SwanAppConfigData s = s();
            return s == null ? "" : s.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wo2
    public SwanAppActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? k33.K().w() : (SwanAppActivity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xo2.b
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            Q();
            rf3.m().x(this.d);
            R(false);
        }
    }

    @Override // com.baidu.tieba.wo2
    public sp1 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            tp1 A = A(C());
            if (A == null) {
                return null;
            }
            return A.r();
        }
        return (sp1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wo2
    public a43 j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            SwanAppConfigData s = s();
            if (s == null) {
                if (j) {
                    Log.w("AiBaseController", "#obtainNewWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception()));
                }
                return a43.d();
            }
            return this.b.a(z(), str, s.e);
        }
        return (a43) invokeL.objValue;
    }

    @Override // com.baidu.tieba.wo2
    public void l(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, swanAppActivity) == null) {
            this.d = swanAppActivity;
        }
    }

    @Override // com.baidu.tieba.wo2
    public void m(String str, ld2 ld2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, str, ld2Var) == null) {
            fa2.U().V0(str, ld2Var);
        }
    }

    @Override // com.baidu.tieba.wo2
    public FullScreenFloatView n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, activity)) == null) {
            Q();
            if (activity == null) {
                return null;
            }
            if (this.f == null) {
                FullScreenFloatView a2 = u13.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
                this.f = a2;
                a2.setFloatButtonText(activity.getString(R.string.obfuscated_res_0x7f0f01bd));
                this.f.setFloatImageBackground(R.drawable.obfuscated_res_0x7f08015d);
                this.f.setVisibility(8);
                this.f.setDragImageListener(new b(this));
            }
            return this.f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.wo2
    public void o() {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (w = k33.K().w()) == null || w.isFinishing()) {
            return;
        }
        w.v0();
    }

    @Override // com.baidu.tieba.wo2
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.h = false;
        }
    }

    @Override // com.baidu.tieba.wo2
    @DebugTrace
    public qp1 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            qp1 b2 = k02.b();
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null) {
                b2.F((ViewGroup) swanAppActivity.findViewById(R.id.obfuscated_res_0x7f090172));
            }
            return b2;
        }
        return (qp1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wo2
    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            Pair<Integer, Integer> S = S();
            int intValue = ((Integer) S.first).intValue();
            int intValue2 = ((Integer) S.second).intValue();
            if (intValue == 0) {
                intValue = ch3.o(AppRuntime.getAppContext());
            }
            if (intValue2 == 0) {
                intValue2 = ch3.u(AppRuntime.getAppContext());
            }
            return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wo2
    public void registerReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, context) == null) || this.e == null) {
            return;
        }
        Q();
        this.e.c(context);
    }

    @Override // com.baidu.tieba.wo2
    public SwanAppConfigData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            k33 K = k33.K();
            if (K.E()) {
                return K.q().Q();
            }
            return null;
        }
        return (SwanAppConfigData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wo2
    public void t(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, intent) == null) {
            fa2.U().z0(intent);
        }
    }

    @Override // com.baidu.tieba.wo2
    public void u(ld2 ld2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, ld2Var) == null) {
            if (!k33.K().q().y0()) {
                fa2.U().U0(ld2Var);
                return;
            }
            fa2.U().V0(dj3.c().h(), ld2Var);
        }
    }

    @Override // com.baidu.tieba.wo2
    public void unregisterReceiver(Context context) {
        xo2 xo2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, context) == null) || (xo2Var = this.e) == null) {
            return;
        }
        xo2Var.f(context);
    }

    @Override // com.baidu.tieba.wo2
    @CallSuper
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            Q();
            String g0 = l33.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            this.h = true;
            this.e.j();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", g0);
            bundle.putInt("task_id", getActivity().getTaskId());
            b03.e().h(new d03(9, bundle));
            sm2.H().c(l33.b0() == null ? "" : l33.b0().O());
        }
    }

    @Override // com.baidu.tieba.wo2
    @CallSuper
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            String g0 = l33.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            I();
            l33 b0 = l33.b0();
            if (b0 != null) {
                b0.B().I(b0.getAppId());
            }
            Bundle bundle = new Bundle();
            bundle.putString("app_id", g0);
            bundle.putInt("task_id", nh3.b().a());
            b03.e().h(new d03(10, bundle));
            sm2.H().a(l33.b0() == null ? "" : l33.b0().O());
            sm2.d().d(AppRuntime.getAppContext(), null, DownloadParams.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // com.baidu.tieba.wo2
    @NonNull
    public Pair<Integer, Integer> x() {
        InterceptResult invokeV;
        Window window;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            Context appContext = AppRuntime.getAppContext();
            int n = ch3.n(appContext);
            int measuredHeight = (k33.K().w() == null || (window = k33.K().w().getWindow()) == null || (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) == null || !viewGroup.isLaidOut()) ? 0 : viewGroup.getMeasuredHeight();
            if (measuredHeight >= n) {
                return new Pair<>(Integer.valueOf(ch3.o(appContext)), Integer.valueOf(measuredHeight));
            }
            if (Build.VERSION.SDK_INT >= 28) {
                n += ug3.e(appContext);
            }
            return new Pair<>(Integer.valueOf(ch3.o(appContext)), Integer.valueOf(n));
        }
        return (Pair) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
    @Override // com.baidu.tieba.wo2
    public void y(od2 od2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048624, this, od2Var, z) == null) {
            pw2.a("postMessage", "handleNativeMessage start.");
            if (od2Var == null) {
                return;
            }
            rd2 rd2Var = new rd2();
            rd2Var.c = od2Var.b;
            rd2Var.d = z;
            if (j) {
                Log.d("AiBaseController", "handleNativeMessage data: " + od2Var.b + " ; needEncode = " + z);
            }
            m(od2Var.a, rd2Var);
            pw2.a("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.tieba.wo2
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? TextUtils.isEmpty(this.c) ? "" : this.c : (String) invokeV.objValue;
    }
}
