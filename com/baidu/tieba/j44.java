package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.a34;
import com.baidu.tieba.hr2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
@Service
/* loaded from: classes6.dex */
public class j44 extends tr2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;
    public z24 l;
    public Runnable m;
    public o44 n;

    /* loaded from: classes6.dex */
    public class a implements ep2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ep2 a;
        public final /* synthetic */ hr2 b;
        public final /* synthetic */ j44 c;

        /* renamed from: com.baidu.tieba.j44$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0362a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ dp2 a;
            public final /* synthetic */ int b;
            public final /* synthetic */ a c;

            public RunnableC0362a(a aVar, dp2 dp2Var, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, dp2Var, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = dp2Var;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.c.c.i) {
                    return;
                }
                a34.c cVar = (a34.c) this.a;
                if (this.b == 0 && cVar != null) {
                    a aVar = this.c;
                    if (aVar.a != null) {
                        if (aVar.b.n0()) {
                            if (!b14.m().n()) {
                                i32.c(false);
                                this.c.b.A0(false);
                            } else {
                                j44 j44Var = this.c.c;
                                j44Var.o(j44Var.d).setVisibility(0);
                                this.c.c.r().E(this.c.c.f);
                                h32.b(true);
                                k32.i("GamesControllerImpl", "init sConsole for devHook");
                            }
                        }
                        this.c.c.l.c(cVar, this.c.c.d);
                        this.c.c.k = cVar.a;
                        this.c.a.a(0, cVar);
                        this.c.c.f0(cVar.c);
                        x74.b().e(cVar.c);
                    }
                }
            }
        }

        public a(j44 j44Var, ep2 ep2Var, hr2 hr2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j44Var, ep2Var, hr2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j44Var;
            this.a = ep2Var;
            this.b = hr2Var;
        }

        @Override // com.baidu.tieba.ep2
        public void a(int i, dp2 dp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, dp2Var) == null) {
                ek3.d0(this.c.m);
                this.c.m = new RunnableC0362a(this, dp2Var, i);
                ek3.g0(this.c.m);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947833311, "Lcom/baidu/tieba/j44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947833311, "Lcom/baidu/tieba/j44;");
                return;
            }
        }
        o = vm1.a;
    }

    public j44() {
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
        this.l = new z24();
        this.n = new o44();
    }

    @Override // com.baidu.tieba.tr2, com.baidu.tieba.vr2
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.k)) {
                return "";
            }
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tr2, com.baidu.tieba.vr2
    public zn1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.n;
        }
        return (zn1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tr2, com.baidu.tieba.vr2
    public co1 N() {
        InterceptResult invokeV;
        h24 h24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            t52 U = U();
            if (U == null || (h24Var = (h24) U.n(h24.class)) == null) {
                return null;
            }
            return h24Var.F3();
        }
        return (co1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tr2, com.baidu.tieba.vr2
    public co1 Q() {
        InterceptResult invokeV;
        h24 h24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            t52 U = U();
            if (U == null || (h24Var = (h24) U.n(h24.class)) == null) {
                return null;
            }
            return h24Var.D3();
        }
        return (co1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tr2
    @NonNull
    public Pair<Integer, Integer> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return s();
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tr2, com.baidu.tieba.vr2
    public SwanCoreVersion getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return k24.m().s();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vr2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tr2, com.baidu.tieba.vr2
    @NonNull
    public Pair<Integer, Integer> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return y();
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tr2, com.baidu.tieba.vr2
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.x();
            jt2.h(false);
            a64.a.a().f();
        }
    }

    public final void f0(e64 e64Var) {
        k63 F;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, e64Var) == null) && (F = F()) != null) {
            F.I0(e64Var);
        }
    }

    @Override // com.baidu.tieba.tr2, com.baidu.tieba.vr2
    public FullScreenFloatView o(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, activity)) == null) {
            super.o(activity);
            this.f.setAutoAttachEnable(false);
            return this.f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tr2, com.baidu.tieba.vr2
    public void G(hr2 hr2Var, ep2 ep2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hr2Var, ep2Var) == null) {
            super.G(hr2Var, ep2Var);
            if (o) {
                Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + hr2Var.k0());
            }
            a34.c(hr2Var, new a(this, ep2Var, hr2Var));
            k24.m().I(hr2Var);
            k24.m().G(hr2Var);
            if (o) {
                Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
            }
            k24.m().z(null);
        }
    }

    @Override // com.baidu.tieba.tr2, com.baidu.tieba.vr2
    public SwanAppPropertyWindow L(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
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

    @Override // com.baidu.tieba.tr2, com.baidu.tieba.vr2
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.P();
            k24.C();
            a64.a.a().d(new JsObject());
            nm4.k(ui2.p() + File.separator + "tmp");
        }
    }

    @Override // com.baidu.tieba.tr2, com.baidu.tieba.vr2
    public qs1 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.a == null) {
                this.a = new f14(AppRuntime.getAppContext());
                g14.h(true);
            }
            this.a.D((ViewGroup) this.d.findViewById(16908290));
            return this.a;
        }
        return (qs1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tr2, com.baidu.tieba.vr2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.w();
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.T() != null) {
                hr2.a T2 = this.d.T();
                nd3 nd3Var = new nd3();
                nd3Var.a = dd3.n(1);
                nd3Var.f = T2.I();
                nd3Var.c = T2.U();
                nd3Var.b = "show";
                nd3Var.d(T2.t0().getString("ubc"));
                nd3Var.b(dd3.k(T2.X()));
                dd3.onEvent(nd3Var);
            }
            jt2.h(true);
            a64.a.a().j();
        }
    }

    @Override // com.baidu.tieba.tr2, com.baidu.tieba.vr2
    @NonNull
    public Pair<Integer, Integer> y() {
        InterceptResult invokeV;
        int i;
        int i2;
        View decorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity == null) {
                return super.y();
            }
            Window window = swanAppActivity.getWindow();
            boolean z = false;
            if (window != null && (decorView = window.getDecorView()) != null) {
                i2 = decorView.getWidth();
                i = decorView.getHeight();
            } else {
                i = 0;
                i2 = 0;
            }
            Display defaultDisplay = this.d.getWindowManager().getDefaultDisplay();
            if (i2 == 0 || i == 0) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getRealMetrics(displayMetrics);
                i2 = displayMetrics.widthPixels;
                i = displayMetrics.heightPixels;
            }
            if (this.d.j0() == ((defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) ? true : true)) {
                int i3 = i2;
                i2 = i;
                i = i3;
            }
            if (o) {
                Log.d("GamesControllerImpl", "getCurScreenSize width:" + i + ",height:" + i2);
            }
            return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
        }
        return (Pair) invokeV.objValue;
    }
}
