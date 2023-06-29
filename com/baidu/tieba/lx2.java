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
import com.baidu.tieba.zw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class lx2 implements nx2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public hy1 a;
    public mc3 b;
    public String c;
    @Deprecated
    public SwanAppActivity d;
    public ox2 e;
    public FullScreenFloatView f;
    public SwanAppPropertyWindow g;
    public boolean h;
    public boolean i;

    @Override // com.baidu.tieba.nx2
    public qt1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (qt1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nx2
    public tt1 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (tt1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nx2
    public tt1 O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (tt1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nx2
    public SwanCoreVersion getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return null;
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ lx2 b;

        public a(lx2 lx2Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lx2Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lx2Var;
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
                io3.m().l(taskId);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lx2 a;

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onDrag() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(lx2 lx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lx2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947958179, "Lcom/baidu/tieba/lx2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947958179, "Lcom/baidu/tieba/lx2;");
                return;
            }
        }
        j = ms1.a;
    }

    @Override // com.baidu.tieba.nx2
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            kb2 H = H();
            if (H != null) {
                return H.v3();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nx2
    @Nullable
    public cc3 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return cc3.M();
        }
        return (cc3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nx2
    @NonNull
    public final fk3 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            cc3 b0 = cc3.b0();
            if (b0 == null) {
                return new dk3();
            }
            return b0.h0();
        }
        return (fk3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nx2
    public kb2 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            lb2 S = S();
            if (S == null) {
                return null;
            }
            return S.o();
        }
        return (kb2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nx2
    public void I() {
        ox2 ox2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && k() && (ox2Var = this.e) != null) {
            ox2Var.i();
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
            kb2 H = H();
            if (H == null) {
                return new Pair<>(0, 0);
            }
            return H.p3();
        }
        return (Pair) invokeV.objValue;
    }

    public lb2 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity == null) {
                return null;
            }
            return swanAppActivity.Y();
        }
        return (lb2) invokeV.objValue;
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
            hy1 hy1Var = this.a;
            if (hy1Var != null) {
                hy1Var.D();
            }
            b92.e();
        }
    }

    @Override // com.baidu.tieba.nx2
    public void a() {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (w = bc3.K().w()) != null && !w.isFinishing()) {
            w.A0();
        }
    }

    @Override // com.baidu.tieba.nx2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            cc3 b0 = cc3.b0();
            if (b0 != null && b0.Y() != null) {
                return zw2.m1(b0.Y(), px2.T().s());
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nx2
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.h = true;
        }
    }

    @Override // com.baidu.tieba.nx2
    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            Q(true);
        }
    }

    @Override // com.baidu.tieba.nx2
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

    @Override // com.baidu.tieba.nx2
    public SwanAppActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return bc3.K().w();
        }
        return (SwanAppActivity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nx2
    public jy1 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            ky1 A = A(C());
            if (A == null) {
                return null;
            }
            return A.r();
        }
        return (jy1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nx2
    public void o() {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (w = bc3.K().w()) != null && !w.isFinishing()) {
            w.w0();
        }
    }

    @Override // com.baidu.tieba.nx2
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.h = false;
        }
    }

    @Override // com.baidu.tieba.nx2
    @DebugTrace
    public hy1 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            hy1 b2 = b92.b();
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null) {
                b2.E((ViewGroup) swanAppActivity.findViewById(R.id.obfuscated_res_0x7f090180));
            }
            return b2;
        }
        return (hy1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nx2
    public SwanAppConfigData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            bc3 K = bc3.K();
            if (K.E()) {
                return K.q().Q();
            }
            return null;
        }
        return (SwanAppConfigData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nx2
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

    public lx2() {
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
        this.b = new mc3();
        wi2.U();
        ox2 ox2Var = new ox2();
        this.e = ox2Var;
        ox2Var.h(this);
    }

    @Override // com.baidu.tieba.nx2
    public boolean M() {
        InterceptResult invokeV;
        zw2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            P();
            cc3 M = cc3.M();
            if (M != null) {
                aVar = M.Y();
            } else {
                aVar = null;
            }
            if (aVar != null && ((j && aVar.n0()) || e42.g(aVar) || e42.d(aVar))) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.nx2
    @CallSuper
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.i = true;
            ox2 ox2Var = this.e;
            if (ox2Var != null) {
                ox2Var.j();
                this.e = null;
            }
            g83.b().d();
            T();
            f63.e().g(bc3.K().getAppId());
            yk3.u(true);
            this.d = null;
        }
    }

    @Override // com.baidu.tieba.nx2
    public ky1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return wi2.U().e0(str);
        }
        return (ky1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.nx2
    public View B(String str) {
        InterceptResult invokeL;
        jy1 r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            ky1 A = A(str);
            if (A == null || (r = A.r()) == null) {
                return null;
            }
            return r.getCurrentWebView();
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.nx2
    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.c = str;
        }
    }

    public final void Q(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && this.d != null) {
            wp3.e0(new a(this, z));
        }
    }

    @Override // com.baidu.tieba.ox2.b
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            P();
            io3.m().x(this.d);
            Q(false);
        }
    }

    @Override // com.baidu.tieba.nx2
    public void l(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, swanAppActivity) == null) {
            this.d = swanAppActivity;
        }
    }

    @Override // com.baidu.tieba.nx2
    public void registerReceiver(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048616, this, context) != null) || this.e == null) {
            return;
        }
        P();
        this.e.c(context);
    }

    @Override // com.baidu.tieba.nx2
    public void t(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, intent) == null) {
            wi2.U().z0(intent);
        }
    }

    @Override // com.baidu.tieba.nx2
    public void unregisterReceiver(Context context) {
        ox2 ox2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, context) != null) || (ox2Var = this.e) == null) {
            return;
        }
        ox2Var.f(context);
    }

    @Override // com.baidu.tieba.nx2
    @CallSuper
    public void E(zw2 zw2Var, wu2 wu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, zw2Var, wu2Var) == null) {
            P();
        }
    }

    @Override // com.baidu.tieba.nx2
    @CallSuper
    public void d(zw2 zw2Var, wu2 wu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, zw2Var, wu2Var) == null) {
            P();
        }
    }

    @Override // com.baidu.tieba.nx2
    public void m(String str, cm2 cm2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, str, cm2Var) == null) {
            wi2.U().V0(str, cm2Var);
        }
    }

    @Override // com.baidu.tieba.nx2
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, activity)) == null) {
            P();
            if (activity == null) {
                return null;
            }
            if (this.g == null && (viewGroup = (ViewGroup) activity.findViewById(R.id.obfuscated_res_0x7f090180)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.g);
            }
            return this.g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // com.baidu.tieba.nx2
    public void u(cm2 cm2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, cm2Var) == null) {
            if (!bc3.K().q().y0()) {
                wi2.U().U0(cm2Var);
                return;
            }
            wi2.U().V0(ur3.c().h(), cm2Var);
        }
    }

    @Override // com.baidu.tieba.nx2
    @NonNull
    public rc3 e(String str, SwanAppConfigData swanAppConfigData, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048600, this, str, swanAppConfigData, str2)) == null) {
            if (swanAppConfigData != null && !TextUtils.isEmpty(str2)) {
                return this.b.b(str2, str, swanAppConfigData.e);
            }
            return f(str);
        }
        return (rc3) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.nx2
    @NonNull
    public rc3 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            SwanAppConfigData s = s();
            if (s == null) {
                if (j) {
                    Log.w("AiBaseController", "#getPageWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception()));
                }
                return rc3.d();
            }
            return this.b.b(z(), str, s.e);
        }
        return (rc3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.nx2
    public rc3 j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            SwanAppConfigData s = s();
            if (s == null) {
                if (j) {
                    Log.w("AiBaseController", "#obtainNewWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception()));
                }
                return rc3.d();
            }
            return this.b.a(z(), str, s.e);
        }
        return (rc3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.nx2
    public FullScreenFloatView n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, activity)) == null) {
            P();
            if (activity == null) {
                return null;
            }
            if (this.f == null) {
                FullScreenFloatView a2 = la3.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
                this.f = a2;
                a2.setFloatButtonText(activity.getString(R.string.obfuscated_res_0x7f0f01e9));
                this.f.setFloatImageBackground(R.drawable.obfuscated_res_0x7f080177);
                this.f.setVisibility(8);
                this.f.setDragImageListener(new b(this));
            }
            return this.f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.nx2
    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            Pair<Integer, Integer> R = R();
            int intValue = ((Integer) R.first).intValue();
            int intValue2 = ((Integer) R.second).intValue();
            if (intValue == 0) {
                intValue = tp3.o(AppRuntime.getAppContext());
            }
            if (intValue2 == 0) {
                intValue2 = tp3.u(AppRuntime.getAppContext());
            }
            return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nx2
    @CallSuper
    public void v() {
        String O;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            P();
            String g0 = cc3.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            this.h = true;
            this.e.j();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", g0);
            bundle.putInt("task_id", getActivity().getTaskId());
            s83.e().h(new u83(9, bundle));
            if (cc3.b0() == null) {
                O = "";
            } else {
                O = cc3.b0().O();
            }
            jv2.H().c(O);
        }
    }

    @Override // com.baidu.tieba.nx2
    @CallSuper
    public void w() {
        String O;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            String g0 = cc3.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            I();
            cc3 b0 = cc3.b0();
            if (b0 != null) {
                b0.B().I(b0.getAppId());
            }
            Bundle bundle = new Bundle();
            bundle.putString("app_id", g0);
            bundle.putInt("task_id", eq3.b().a());
            s83.e().h(new u83(10, bundle));
            if (cc3.b0() == null) {
                O = "";
            } else {
                O = cc3.b0().O();
            }
            jv2.H().a(O);
            jv2.d().d(AppRuntime.getAppContext(), null, DownloadParams.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // com.baidu.tieba.nx2
    @NonNull
    public Pair<Integer, Integer> x() {
        InterceptResult invokeV;
        int i;
        Window window;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            Context appContext = AppRuntime.getAppContext();
            int n = tp3.n(appContext);
            if (bc3.K().w() != null && (window = bc3.K().w().getWindow()) != null && (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) != null && viewGroup.isLaidOut()) {
                i = viewGroup.getMeasuredHeight();
            } else {
                i = 0;
            }
            if (i >= n) {
                return new Pair<>(Integer.valueOf(tp3.o(appContext)), Integer.valueOf(i));
            }
            if (Build.VERSION.SDK_INT >= 28) {
                n += lp3.e(appContext);
            }
            return new Pair<>(Integer.valueOf(tp3.o(appContext)), Integer.valueOf(n));
        }
        return (Pair) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
    @Override // com.baidu.tieba.nx2
    public void y(fm2 fm2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048624, this, fm2Var, z) == null) {
            g53.a("postMessage", "handleNativeMessage start.");
            if (fm2Var == null) {
                return;
            }
            im2 im2Var = new im2();
            im2Var.c = fm2Var.b;
            im2Var.d = z;
            if (j) {
                Log.d("AiBaseController", "handleNativeMessage data: " + fm2Var.b + " ; needEncode = " + z);
            }
            m(fm2Var.a, im2Var);
            g53.a("postMessage", "handleNativeMessage end.");
        }
    }
}
