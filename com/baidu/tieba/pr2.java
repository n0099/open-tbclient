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
import com.baidu.tieba.dr2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class pr2 implements rr2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public ms1 a;
    public q63 b;
    public String c;
    @Deprecated
    public SwanAppActivity d;
    public sr2 e;
    public FullScreenFloatView f;
    public SwanAppPropertyWindow g;
    public boolean h;
    public boolean i;

    @Override // com.baidu.tieba.rr2
    public vn1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (vn1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rr2
    public yn1 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return null;
        }
        return (yn1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rr2
    public yn1 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return null;
        }
        return (yn1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rr2
    public SwanCoreVersion getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return null;
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ pr2 b;

        public a(pr2 pr2Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pr2Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pr2Var;
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
                mi3.m().l(taskId);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pr2 a;

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onDrag() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(pr2 pr2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pr2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pr2Var;
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r().S();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948071577, "Lcom/baidu/tieba/pr2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948071577, "Lcom/baidu/tieba/pr2;");
                return;
            }
        }
        j = rm1.a;
    }

    @Override // com.baidu.tieba.rr2
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.c)) {
                return "";
            }
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rr2
    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            o52 J = J();
            if (J != null) {
                return J.A3();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rr2
    @Nullable
    public g63 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return g63.M();
        }
        return (g63) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rr2
    @NonNull
    public final je3 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            g63 c0 = g63.c0();
            if (c0 == null) {
                return new he3();
            }
            return c0.i0();
        }
        return (je3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rr2
    public o52 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            p52 U = U();
            if (U == null) {
                return null;
            }
            return U.o();
        }
        return (o52) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rr2
    public void K() {
        sr2 sr2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && k() && (sr2Var = this.e) != null) {
            sr2Var.i();
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && getActivity() == null && j) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    @NonNull
    public Pair<Integer, Integer> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            o52 J = J();
            if (J == null) {
                return new Pair<>(0, 0);
            }
            return J.u3();
        }
        return (Pair) invokeV.objValue;
    }

    public p52 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity == null) {
                return null;
            }
            return swanAppActivity.Y();
        }
        return (p52) invokeV.objValue;
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            FullScreenFloatView fullScreenFloatView = this.f;
            if (fullScreenFloatView != null) {
                ViewParent parent = fullScreenFloatView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f);
                }
            }
            ms1 ms1Var = this.a;
            if (ms1Var != null) {
                ms1Var.C();
            }
            f32.e();
        }
    }

    @Override // com.baidu.tieba.rr2
    public void a() {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (w = f63.K().w()) != null && !w.isFinishing()) {
            w.A0();
        }
    }

    @Override // com.baidu.tieba.rr2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            g63 c0 = g63.c0();
            if (c0 != null && c0.Z() != null) {
                return dr2.n1(c0.Z(), tr2.V().t());
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rr2
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.h = true;
        }
    }

    @Override // com.baidu.tieba.rr2
    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            S(true);
        }
    }

    @Override // com.baidu.tieba.rr2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            SwanAppConfigData t = t();
            if (t == null) {
                return "";
            }
            return t.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rr2
    public SwanAppActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return f63.K().w();
        }
        return (SwanAppActivity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rr2
    public os1 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            ps1 B = B(D());
            if (B == null) {
                return null;
            }
            return B.getWebView();
        }
        return (os1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rr2
    public void p() {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && (w = f63.K().w()) != null && !w.isFinishing()) {
            w.w0();
        }
    }

    @Override // com.baidu.tieba.rr2
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.h = false;
        }
    }

    @Override // com.baidu.tieba.rr2
    @DebugTrace
    public ms1 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            ms1 b2 = f32.b();
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null) {
                b2.D((ViewGroup) swanAppActivity.findViewById(R.id.obfuscated_res_0x7f090193));
            }
            return b2;
        }
        return (ms1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rr2
    public SwanAppConfigData t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            f63 K = f63.K();
            if (K.E()) {
                return K.q().R();
            }
            return null;
        }
        return (SwanAppConfigData) invokeV.objValue;
    }

    public pr2() {
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
        this.b = new q63();
        ad2.V();
        sr2 sr2Var = new sr2();
        this.e = sr2Var;
        sr2Var.h(this);
    }

    @Override // com.baidu.tieba.rr2
    public boolean O() {
        InterceptResult invokeV;
        dr2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            R();
            g63 M = g63.M();
            if (M != null) {
                aVar = M.Z();
            } else {
                aVar = null;
            }
            if (aVar != null && ((j && aVar.o0()) || jy1.g(aVar) || jy1.d(aVar))) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.rr2
    @CallSuper
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.i = true;
            sr2 sr2Var = this.e;
            if (sr2Var != null) {
                sr2Var.j();
                this.e = null;
            }
            k23.b().d();
            V();
            j03.e().g(f63.K().getAppId());
            cf3.u(true);
            this.d = null;
        }
    }

    @Override // com.baidu.tieba.rr2
    public ps1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return ad2.V().f0(str);
        }
        return (ps1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.rr2
    public View C(String str) {
        InterceptResult invokeL;
        os1 webView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            ps1 B = B(str);
            if (B == null || (webView = B.getWebView()) == null) {
                return null;
            }
            return webView.getCurrentWebView();
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.rr2
    public void E(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, context) != null) || this.e == null) {
            return;
        }
        R();
        this.e.c(context);
    }

    @Override // com.baidu.tieba.rr2
    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.c = str;
        }
    }

    public final void S(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z) == null) && this.d != null) {
            ak3.e0(new a(this, z));
        }
    }

    @Override // com.baidu.tieba.sr2.b
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            R();
            mi3.m().x(this.d);
            S(false);
        }
    }

    @Override // com.baidu.tieba.rr2
    public void l(Context context) {
        sr2 sr2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048611, this, context) != null) || (sr2Var = this.e) == null) {
            return;
        }
        sr2Var.f(context);
    }

    @Override // com.baidu.tieba.rr2
    public void m(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, swanAppActivity) == null) {
            this.d = swanAppActivity;
        }
    }

    @Override // com.baidu.tieba.rr2
    public void u(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, intent) == null) {
            ad2.V().A0(intent);
        }
    }

    @Override // com.baidu.tieba.rr2
    @CallSuper
    public void G(dr2 dr2Var, ap2 ap2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, dr2Var, ap2Var) == null) {
            R();
        }
    }

    @Override // com.baidu.tieba.rr2
    @CallSuper
    public void d(dr2 dr2Var, ap2 ap2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, dr2Var, ap2Var) == null) {
            R();
        }
    }

    @Override // com.baidu.tieba.rr2
    public void n(String str, gg2 gg2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, gg2Var) == null) {
            ad2.V().W0(str, gg2Var);
        }
    }

    @Override // com.baidu.tieba.rr2
    public SwanAppPropertyWindow L(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, activity)) == null) {
            R();
            if (activity == null) {
                return null;
            }
            if (this.g == null && (viewGroup = (ViewGroup) activity.findViewById(R.id.obfuscated_res_0x7f090193)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.g);
            }
            return this.g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // com.baidu.tieba.rr2
    public void v(gg2 gg2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, gg2Var) == null) {
            if (!f63.K().q().z0()) {
                ad2.V().V0(gg2Var);
                return;
            }
            ad2.V().W0(yl3.c().h(), gg2Var);
        }
    }

    @Override // com.baidu.tieba.rr2
    @NonNull
    public v63 e(String str, SwanAppConfigData swanAppConfigData, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048602, this, str, swanAppConfigData, str2)) == null) {
            if (swanAppConfigData != null && !TextUtils.isEmpty(str2)) {
                return this.b.b(str2, str, swanAppConfigData.e);
            }
            return f(str);
        }
        return (v63) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.rr2
    @NonNull
    public v63 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            SwanAppConfigData t = t();
            if (t == null) {
                if (j) {
                    Log.w("AiBaseController", "#getPageWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception()));
                }
                return v63.d();
            }
            return this.b.b(A(), str, t.e);
        }
        return (v63) invokeL.objValue;
    }

    @Override // com.baidu.tieba.rr2
    public v63 j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            SwanAppConfigData t = t();
            if (t == null) {
                if (j) {
                    Log.w("AiBaseController", "#obtainNewWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception()));
                }
                return v63.d();
            }
            return this.b.a(A(), str, t.e);
        }
        return (v63) invokeL.objValue;
    }

    @Override // com.baidu.tieba.rr2
    public FullScreenFloatView o(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, activity)) == null) {
            R();
            if (activity == null) {
                return null;
            }
            if (this.f == null) {
                FullScreenFloatView a2 = p43.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
                this.f = a2;
                a2.setFloatButtonText(activity.getString(R.string.obfuscated_res_0x7f0f01ec));
                this.f.setFloatImageBackground(R.drawable.obfuscated_res_0x7f08017b);
                this.f.setVisibility(8);
                this.f.setDragImageListener(new b(this));
            }
            return this.f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.rr2
    @NonNull
    public Pair<Integer, Integer> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            Pair<Integer, Integer> T2 = T();
            int intValue = ((Integer) T2.first).intValue();
            int intValue2 = ((Integer) T2.second).intValue();
            if (intValue == 0) {
                intValue = xj3.o(AppRuntime.getAppContext());
            }
            if (intValue2 == 0) {
                intValue2 = xj3.u(AppRuntime.getAppContext());
            }
            return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rr2
    @CallSuper
    public void w() {
        String P;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            R();
            String h0 = g63.h0();
            if (TextUtils.isEmpty(h0)) {
                return;
            }
            this.h = true;
            this.e.j();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", h0);
            bundle.putInt("task_id", getActivity().getTaskId());
            w23.e().h(new y23(9, bundle));
            if (g63.c0() == null) {
                P = "";
            } else {
                P = g63.c0().P();
            }
            np2.H().c(P);
        }
    }

    @Override // com.baidu.tieba.rr2
    @CallSuper
    public void x() {
        String P;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            String h0 = g63.h0();
            if (TextUtils.isEmpty(h0)) {
                return;
            }
            K();
            g63 c0 = g63.c0();
            if (c0 != null) {
                c0.B().I(c0.getAppId());
            }
            Bundle bundle = new Bundle();
            bundle.putString("app_id", h0);
            bundle.putInt("task_id", ik3.b().a());
            w23.e().h(new y23(10, bundle));
            if (g63.c0() == null) {
                P = "";
            } else {
                P = g63.c0().P();
            }
            np2.H().a(P);
            np2.d().d(AppRuntime.getAppContext(), null, DownloadParams.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // com.baidu.tieba.rr2
    @NonNull
    public Pair<Integer, Integer> y() {
        InterceptResult invokeV;
        int i;
        Window window;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            Context appContext = AppRuntime.getAppContext();
            int n = xj3.n(appContext);
            if (f63.K().w() != null && (window = f63.K().w().getWindow()) != null && (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) != null && viewGroup.isLaidOut()) {
                i = viewGroup.getMeasuredHeight();
            } else {
                i = 0;
            }
            if (i >= n) {
                return new Pair<>(Integer.valueOf(xj3.o(appContext)), Integer.valueOf(i));
            }
            if (Build.VERSION.SDK_INT >= 28) {
                n += pj3.e(appContext);
            }
            return new Pair<>(Integer.valueOf(xj3.o(appContext)), Integer.valueOf(n));
        }
        return (Pair) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
    @Override // com.baidu.tieba.rr2
    public void z(jg2 jg2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048625, this, jg2Var, z) == null) {
            kz2.a("postMessage", "handleNativeMessage start.");
            if (jg2Var == null) {
                return;
            }
            mg2 mg2Var = new mg2();
            mg2Var.c = jg2Var.b;
            mg2Var.d = z;
            if (j) {
                Log.d("AiBaseController", "handleNativeMessage data: " + jg2Var.b + " ; needEncode = " + z);
            }
            n(jg2Var.a, mg2Var);
            kz2.a("postMessage", "handleNativeMessage end.");
        }
    }
}
