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
import com.baidu.tieba.ew2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class qw2 implements sw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public mx1 a;
    public rb3 b;
    public String c;
    @Deprecated
    public SwanAppActivity d;
    public tw2 e;
    public FullScreenFloatView f;
    public SwanAppPropertyWindow g;
    public boolean h;
    public boolean i;

    @Override // com.baidu.tieba.sw2
    public vs1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (vs1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sw2
    public ys1 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (ys1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sw2
    public ys1 O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (ys1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sw2
    public SwanCoreVersion getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return null;
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ qw2 b;

        public a(qw2 qw2Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw2Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qw2Var;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity swanAppActivity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (swanAppActivity = this.b.d) != null) {
                int taskId = swanAppActivity.getTaskId();
                this.b.d.finish();
                if (this.a) {
                    this.b.d.overridePendingTransition(0, R.anim.obfuscated_res_0x7f010027);
                }
                nn3.m().l(taskId);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qw2 a;

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onDrag() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(qw2 qw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qw2Var;
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.q().T();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948106173, "Lcom/baidu/tieba/qw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948106173, "Lcom/baidu/tieba/qw2;");
                return;
            }
        }
        j = rr1.a;
    }

    @Override // com.baidu.tieba.sw2
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            pa2 H = H();
            if (H != null) {
                return H.v3();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sw2
    @Nullable
    public hb3 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return hb3.M();
        }
        return (hb3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sw2
    @NonNull
    public final kj3 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            hb3 b0 = hb3.b0();
            if (b0 == null) {
                return new ij3();
            }
            return b0.h0();
        }
        return (kj3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sw2
    public pa2 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            qa2 S = S();
            if (S == null) {
                return null;
            }
            return S.o();
        }
        return (pa2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sw2
    public void I() {
        tw2 tw2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && k() && (tw2Var = this.e) != null) {
            tw2Var.i();
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void P() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && getActivity() == null && j) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    @NonNull
    public Pair<Integer, Integer> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            pa2 H = H();
            if (H == null) {
                return new Pair<>(0, 0);
            }
            return H.p3();
        }
        return (Pair) invokeV.objValue;
    }

    public qa2 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity == null) {
                return null;
            }
            return swanAppActivity.Y();
        }
        return (qa2) invokeV.objValue;
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            FullScreenFloatView fullScreenFloatView = this.f;
            if (fullScreenFloatView != null) {
                ViewParent parent = fullScreenFloatView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f);
                }
            }
            mx1 mx1Var = this.a;
            if (mx1Var != null) {
                mx1Var.D();
            }
            g82.e();
        }
    }

    @Override // com.baidu.tieba.sw2
    public void a() {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (w = gb3.K().w()) != null && !w.isFinishing()) {
            w.A0();
        }
    }

    @Override // com.baidu.tieba.sw2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            hb3 b0 = hb3.b0();
            if (b0 != null && b0.Y() != null) {
                return ew2.m1(b0.Y(), uw2.T().s());
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sw2
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.h = true;
        }
    }

    @Override // com.baidu.tieba.sw2
    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            Q(true);
        }
    }

    @Override // com.baidu.tieba.sw2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            SwanAppConfigData s = s();
            if (s == null) {
                return "";
            }
            return s.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sw2
    public SwanAppActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return gb3.K().w();
        }
        return (SwanAppActivity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sw2
    public ox1 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            px1 A = A(C());
            if (A == null) {
                return null;
            }
            return A.r();
        }
        return (ox1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sw2
    public void o() {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (w = gb3.K().w()) != null && !w.isFinishing()) {
            w.w0();
        }
    }

    @Override // com.baidu.tieba.sw2
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.h = false;
        }
    }

    @Override // com.baidu.tieba.sw2
    @DebugTrace
    public mx1 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            mx1 b2 = g82.b();
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null) {
                b2.E((ViewGroup) swanAppActivity.findViewById(R.id.obfuscated_res_0x7f09017f));
            }
            return b2;
        }
        return (mx1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sw2
    public SwanAppConfigData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            gb3 K = gb3.K();
            if (K.E()) {
                return K.q().Q();
            }
            return null;
        }
        return (SwanAppConfigData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sw2
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (TextUtils.isEmpty(this.c)) {
                return "";
            }
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public qw2() {
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
        this.b = new rb3();
        bi2.U();
        tw2 tw2Var = new tw2();
        this.e = tw2Var;
        tw2Var.h(this);
    }

    @Override // com.baidu.tieba.sw2
    public boolean M() {
        InterceptResult invokeV;
        ew2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            P();
            hb3 M = hb3.M();
            if (M != null) {
                aVar = M.Y();
            } else {
                aVar = null;
            }
            if (aVar != null && ((j && aVar.n0()) || j32.g(aVar) || j32.d(aVar))) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.sw2
    @CallSuper
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.i = true;
            tw2 tw2Var = this.e;
            if (tw2Var != null) {
                tw2Var.j();
                this.e = null;
            }
            l73.b().d();
            T();
            k53.e().g(gb3.K().getAppId());
            dk3.u(true);
            this.d = null;
        }
    }

    @Override // com.baidu.tieba.sw2
    public px1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return bi2.U().e0(str);
        }
        return (px1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sw2
    public View B(String str) {
        InterceptResult invokeL;
        ox1 r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            px1 A = A(str);
            if (A == null || (r = A.r()) == null) {
                return null;
            }
            return r.getCurrentWebView();
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sw2
    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.c = str;
        }
    }

    public final void Q(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && this.d != null) {
            bp3.e0(new a(this, z));
        }
    }

    @Override // com.baidu.tieba.tw2.b
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            P();
            nn3.m().x(this.d);
            Q(false);
        }
    }

    @Override // com.baidu.tieba.sw2
    public void l(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, swanAppActivity) == null) {
            this.d = swanAppActivity;
        }
    }

    @Override // com.baidu.tieba.sw2
    public void registerReceiver(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048616, this, context) != null) || this.e == null) {
            return;
        }
        P();
        this.e.c(context);
    }

    @Override // com.baidu.tieba.sw2
    public void t(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, intent) == null) {
            bi2.U().z0(intent);
        }
    }

    @Override // com.baidu.tieba.sw2
    public void unregisterReceiver(Context context) {
        tw2 tw2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, context) != null) || (tw2Var = this.e) == null) {
            return;
        }
        tw2Var.f(context);
    }

    @Override // com.baidu.tieba.sw2
    @CallSuper
    public void E(ew2 ew2Var, bu2 bu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, ew2Var, bu2Var) == null) {
            P();
        }
    }

    @Override // com.baidu.tieba.sw2
    @CallSuper
    public void d(ew2 ew2Var, bu2 bu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, ew2Var, bu2Var) == null) {
            P();
        }
    }

    @Override // com.baidu.tieba.sw2
    public void m(String str, hl2 hl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, str, hl2Var) == null) {
            bi2.U().V0(str, hl2Var);
        }
    }

    @Override // com.baidu.tieba.sw2
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, activity)) == null) {
            P();
            if (activity == null) {
                return null;
            }
            if (this.g == null && (viewGroup = (ViewGroup) activity.findViewById(R.id.obfuscated_res_0x7f09017f)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.g);
            }
            return this.g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sw2
    public void u(hl2 hl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, hl2Var) == null) {
            if (!gb3.K().q().y0()) {
                bi2.U().U0(hl2Var);
                return;
            }
            bi2.U().V0(zq3.c().h(), hl2Var);
        }
    }

    @Override // com.baidu.tieba.sw2
    @NonNull
    public wb3 e(String str, SwanAppConfigData swanAppConfigData, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048600, this, str, swanAppConfigData, str2)) == null) {
            if (swanAppConfigData != null && !TextUtils.isEmpty(str2)) {
                return this.b.b(str2, str, swanAppConfigData.e);
            }
            return f(str);
        }
        return (wb3) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.sw2
    @NonNull
    public wb3 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            SwanAppConfigData s = s();
            if (s == null) {
                if (j) {
                    Log.w("AiBaseController", "#getPageWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception()));
                }
                return wb3.d();
            }
            return this.b.b(z(), str, s.e);
        }
        return (wb3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sw2
    public wb3 j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            SwanAppConfigData s = s();
            if (s == null) {
                if (j) {
                    Log.w("AiBaseController", "#obtainNewWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception()));
                }
                return wb3.d();
            }
            return this.b.a(z(), str, s.e);
        }
        return (wb3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sw2
    public FullScreenFloatView n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, activity)) == null) {
            P();
            if (activity == null) {
                return null;
            }
            if (this.f == null) {
                FullScreenFloatView a2 = q93.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
                this.f = a2;
                a2.setFloatButtonText(activity.getString(R.string.obfuscated_res_0x7f0f01ea));
                this.f.setFloatImageBackground(R.drawable.obfuscated_res_0x7f080178);
                this.f.setVisibility(8);
                this.f.setDragImageListener(new b(this));
            }
            return this.f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sw2
    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            Pair<Integer, Integer> R = R();
            int intValue = ((Integer) R.first).intValue();
            int intValue2 = ((Integer) R.second).intValue();
            if (intValue == 0) {
                intValue = yo3.o(AppRuntime.getAppContext());
            }
            if (intValue2 == 0) {
                intValue2 = yo3.u(AppRuntime.getAppContext());
            }
            return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sw2
    @CallSuper
    public void v() {
        String O;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            P();
            String g0 = hb3.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            this.h = true;
            this.e.j();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", g0);
            bundle.putInt("task_id", getActivity().getTaskId());
            x73.e().h(new z73(9, bundle));
            if (hb3.b0() == null) {
                O = "";
            } else {
                O = hb3.b0().O();
            }
            ou2.H().c(O);
        }
    }

    @Override // com.baidu.tieba.sw2
    @CallSuper
    public void w() {
        String O;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            String g0 = hb3.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            I();
            hb3 b0 = hb3.b0();
            if (b0 != null) {
                b0.B().I(b0.getAppId());
            }
            Bundle bundle = new Bundle();
            bundle.putString("app_id", g0);
            bundle.putInt("task_id", jp3.b().a());
            x73.e().h(new z73(10, bundle));
            if (hb3.b0() == null) {
                O = "";
            } else {
                O = hb3.b0().O();
            }
            ou2.H().a(O);
            ou2.d().d(AppRuntime.getAppContext(), null, DownloadParams.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // com.baidu.tieba.sw2
    @NonNull
    public Pair<Integer, Integer> x() {
        InterceptResult invokeV;
        int i;
        Window window;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            Context appContext = AppRuntime.getAppContext();
            int n = yo3.n(appContext);
            if (gb3.K().w() != null && (window = gb3.K().w().getWindow()) != null && (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) != null && viewGroup.isLaidOut()) {
                i = viewGroup.getMeasuredHeight();
            } else {
                i = 0;
            }
            if (i >= n) {
                return new Pair<>(Integer.valueOf(yo3.o(appContext)), Integer.valueOf(i));
            }
            if (Build.VERSION.SDK_INT >= 28) {
                n += qo3.e(appContext);
            }
            return new Pair<>(Integer.valueOf(yo3.o(appContext)), Integer.valueOf(n));
        }
        return (Pair) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
    @Override // com.baidu.tieba.sw2
    public void y(kl2 kl2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048624, this, kl2Var, z) == null) {
            l43.a("postMessage", "handleNativeMessage start.");
            if (kl2Var == null) {
                return;
            }
            nl2 nl2Var = new nl2();
            nl2Var.c = kl2Var.b;
            nl2Var.d = z;
            if (j) {
                Log.d("AiBaseController", "handleNativeMessage data: " + kl2Var.b + " ; needEncode = " + z);
            }
            m(kl2Var.a, nl2Var);
            l43.a("postMessage", "handleNativeMessage end.");
        }
    }
}
