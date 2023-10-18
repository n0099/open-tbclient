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
import com.baidu.tieba.mq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public abstract class yq2 implements ar2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public vr1 a;
    public z53 b;
    public String c;
    @Deprecated
    public SwanAppActivity d;
    public br2 e;
    public FullScreenFloatView f;
    public SwanAppPropertyWindow g;
    public boolean h;
    public boolean i;

    @Override // com.baidu.tieba.ar2
    public en1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (en1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ar2
    public hn1 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return null;
        }
        return (hn1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ar2
    public hn1 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return null;
        }
        return (hn1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ar2
    public SwanCoreVersion getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return null;
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ yq2 b;

        public a(yq2 yq2Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yq2Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yq2Var;
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
                vh3.m().l(taskId);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yq2 a;

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onDrag() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(yq2 yq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yq2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948338735, "Lcom/baidu/tieba/yq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948338735, "Lcom/baidu/tieba/yq2;");
                return;
            }
        }
        j = am1.a;
    }

    @Override // com.baidu.tieba.ar2
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

    @Override // com.baidu.tieba.ar2
    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            x42 J = J();
            if (J != null) {
                return J.A3();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ar2
    @Nullable
    public p53 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return p53.M();
        }
        return (p53) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ar2
    @NonNull
    public final sd3 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            p53 c0 = p53.c0();
            if (c0 == null) {
                return new qd3();
            }
            return c0.i0();
        }
        return (sd3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ar2
    public x42 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            y42 U = U();
            if (U == null) {
                return null;
            }
            return U.o();
        }
        return (x42) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ar2
    public void K() {
        br2 br2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && k() && (br2Var = this.e) != null) {
            br2Var.i();
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
            x42 J = J();
            if (J == null) {
                return new Pair<>(0, 0);
            }
            return J.u3();
        }
        return (Pair) invokeV.objValue;
    }

    public y42 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity == null) {
                return null;
            }
            return swanAppActivity.Y();
        }
        return (y42) invokeV.objValue;
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
            vr1 vr1Var = this.a;
            if (vr1Var != null) {
                vr1Var.C();
            }
            o22.e();
        }
    }

    @Override // com.baidu.tieba.ar2
    public void a() {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (w = o53.K().w()) != null && !w.isFinishing()) {
            w.A0();
        }
    }

    @Override // com.baidu.tieba.ar2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            p53 c0 = p53.c0();
            if (c0 != null && c0.Z() != null) {
                return mq2.n1(c0.Z(), cr2.V().t());
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ar2
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.h = true;
        }
    }

    @Override // com.baidu.tieba.ar2
    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            S(true);
        }
    }

    @Override // com.baidu.tieba.ar2
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

    @Override // com.baidu.tieba.ar2
    public SwanAppActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return o53.K().w();
        }
        return (SwanAppActivity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ar2
    public xr1 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            yr1 B = B(D());
            if (B == null) {
                return null;
            }
            return B.getWebView();
        }
        return (xr1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ar2
    public void p() {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && (w = o53.K().w()) != null && !w.isFinishing()) {
            w.w0();
        }
    }

    @Override // com.baidu.tieba.ar2
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.h = false;
        }
    }

    @Override // com.baidu.tieba.ar2
    @DebugTrace
    public vr1 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            vr1 b2 = o22.b();
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null) {
                b2.D((ViewGroup) swanAppActivity.findViewById(R.id.obfuscated_res_0x7f090180));
            }
            return b2;
        }
        return (vr1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ar2
    public SwanAppConfigData t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            o53 K = o53.K();
            if (K.E()) {
                return K.q().R();
            }
            return null;
        }
        return (SwanAppConfigData) invokeV.objValue;
    }

    public yq2() {
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
        this.b = new z53();
        jc2.V();
        br2 br2Var = new br2();
        this.e = br2Var;
        br2Var.h(this);
    }

    @Override // com.baidu.tieba.ar2
    public boolean O() {
        InterceptResult invokeV;
        mq2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            R();
            p53 M = p53.M();
            if (M != null) {
                aVar = M.Z();
            } else {
                aVar = null;
            }
            if (aVar != null && ((j && aVar.o0()) || sx1.g(aVar) || sx1.d(aVar))) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ar2
    @CallSuper
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.i = true;
            br2 br2Var = this.e;
            if (br2Var != null) {
                br2Var.j();
                this.e = null;
            }
            t13.b().d();
            V();
            sz2.e().g(o53.K().getAppId());
            le3.u(true);
            this.d = null;
        }
    }

    @Override // com.baidu.tieba.ar2
    public yr1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return jc2.V().f0(str);
        }
        return (yr1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ar2
    public View C(String str) {
        InterceptResult invokeL;
        xr1 webView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            yr1 B = B(str);
            if (B == null || (webView = B.getWebView()) == null) {
                return null;
            }
            return webView.getCurrentWebView();
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ar2
    public void E(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, context) != null) || this.e == null) {
            return;
        }
        R();
        this.e.c(context);
    }

    @Override // com.baidu.tieba.ar2
    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.c = str;
        }
    }

    public final void S(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z) == null) && this.d != null) {
            jj3.e0(new a(this, z));
        }
    }

    @Override // com.baidu.tieba.br2.b
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            R();
            vh3.m().x(this.d);
            S(false);
        }
    }

    @Override // com.baidu.tieba.ar2
    public void l(Context context) {
        br2 br2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048611, this, context) != null) || (br2Var = this.e) == null) {
            return;
        }
        br2Var.f(context);
    }

    @Override // com.baidu.tieba.ar2
    public void m(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, swanAppActivity) == null) {
            this.d = swanAppActivity;
        }
    }

    @Override // com.baidu.tieba.ar2
    public void u(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, intent) == null) {
            jc2.V().A0(intent);
        }
    }

    @Override // com.baidu.tieba.ar2
    @CallSuper
    public void G(mq2 mq2Var, jo2 jo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, mq2Var, jo2Var) == null) {
            R();
        }
    }

    @Override // com.baidu.tieba.ar2
    @CallSuper
    public void d(mq2 mq2Var, jo2 jo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, mq2Var, jo2Var) == null) {
            R();
        }
    }

    @Override // com.baidu.tieba.ar2
    public void n(String str, pf2 pf2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, pf2Var) == null) {
            jc2.V().W0(str, pf2Var);
        }
    }

    @Override // com.baidu.tieba.ar2
    public SwanAppPropertyWindow L(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, activity)) == null) {
            R();
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

    @Override // com.baidu.tieba.ar2
    public void v(pf2 pf2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, pf2Var) == null) {
            if (!o53.K().q().z0()) {
                jc2.V().V0(pf2Var);
                return;
            }
            jc2.V().W0(hl3.c().h(), pf2Var);
        }
    }

    @Override // com.baidu.tieba.ar2
    @NonNull
    public e63 e(String str, SwanAppConfigData swanAppConfigData, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048602, this, str, swanAppConfigData, str2)) == null) {
            if (swanAppConfigData != null && !TextUtils.isEmpty(str2)) {
                return this.b.b(str2, str, swanAppConfigData.e);
            }
            return f(str);
        }
        return (e63) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ar2
    @NonNull
    public e63 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            SwanAppConfigData t = t();
            if (t == null) {
                if (j) {
                    Log.w("AiBaseController", "#getPageWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception()));
                }
                return e63.d();
            }
            return this.b.b(A(), str, t.e);
        }
        return (e63) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ar2
    public e63 j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            SwanAppConfigData t = t();
            if (t == null) {
                if (j) {
                    Log.w("AiBaseController", "#obtainNewWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception()));
                }
                return e63.d();
            }
            return this.b.a(A(), str, t.e);
        }
        return (e63) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ar2
    public FullScreenFloatView o(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, activity)) == null) {
            R();
            if (activity == null) {
                return null;
            }
            if (this.f == null) {
                FullScreenFloatView a2 = y33.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
                this.f = a2;
                a2.setFloatButtonText(activity.getString(R.string.obfuscated_res_0x7f0f01ec));
                this.f.setFloatImageBackground(R.drawable.obfuscated_res_0x7f080178);
                this.f.setVisibility(8);
                this.f.setDragImageListener(new b(this));
            }
            return this.f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ar2
    @NonNull
    public Pair<Integer, Integer> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            Pair<Integer, Integer> T2 = T();
            int intValue = ((Integer) T2.first).intValue();
            int intValue2 = ((Integer) T2.second).intValue();
            if (intValue == 0) {
                intValue = gj3.o(AppRuntime.getAppContext());
            }
            if (intValue2 == 0) {
                intValue2 = gj3.u(AppRuntime.getAppContext());
            }
            return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ar2
    @CallSuper
    public void w() {
        String P;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            R();
            String h0 = p53.h0();
            if (TextUtils.isEmpty(h0)) {
                return;
            }
            this.h = true;
            this.e.j();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", h0);
            bundle.putInt("task_id", getActivity().getTaskId());
            f23.e().h(new h23(9, bundle));
            if (p53.c0() == null) {
                P = "";
            } else {
                P = p53.c0().P();
            }
            wo2.H().c(P);
        }
    }

    @Override // com.baidu.tieba.ar2
    @CallSuper
    public void x() {
        String P;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            String h0 = p53.h0();
            if (TextUtils.isEmpty(h0)) {
                return;
            }
            K();
            p53 c0 = p53.c0();
            if (c0 != null) {
                c0.B().I(c0.getAppId());
            }
            Bundle bundle = new Bundle();
            bundle.putString("app_id", h0);
            bundle.putInt("task_id", rj3.b().a());
            f23.e().h(new h23(10, bundle));
            if (p53.c0() == null) {
                P = "";
            } else {
                P = p53.c0().P();
            }
            wo2.H().a(P);
            wo2.d().d(AppRuntime.getAppContext(), null, DownloadParams.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // com.baidu.tieba.ar2
    @NonNull
    public Pair<Integer, Integer> y() {
        InterceptResult invokeV;
        int i;
        Window window;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            Context appContext = AppRuntime.getAppContext();
            int n = gj3.n(appContext);
            if (o53.K().w() != null && (window = o53.K().w().getWindow()) != null && (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) != null && viewGroup.isLaidOut()) {
                i = viewGroup.getMeasuredHeight();
            } else {
                i = 0;
            }
            if (i >= n) {
                return new Pair<>(Integer.valueOf(gj3.o(appContext)), Integer.valueOf(i));
            }
            if (Build.VERSION.SDK_INT >= 28) {
                n += yi3.e(appContext);
            }
            return new Pair<>(Integer.valueOf(gj3.o(appContext)), Integer.valueOf(n));
        }
        return (Pair) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
    @Override // com.baidu.tieba.ar2
    public void z(sf2 sf2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048625, this, sf2Var, z) == null) {
            ty2.a("postMessage", "handleNativeMessage start.");
            if (sf2Var == null) {
                return;
            }
            vf2 vf2Var = new vf2();
            vf2Var.c = sf2Var.b;
            vf2Var.d = z;
            if (j) {
                Log.d("AiBaseController", "handleNativeMessage data: " + sf2Var.b + " ; needEncode = " + z);
            }
            n(sf2Var.a, vf2Var);
            ty2.a("postMessage", "handleNativeMessage end.");
        }
    }
}
