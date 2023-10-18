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
import com.baidu.tieba.f24;
import com.baidu.tieba.mq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
@Service
/* loaded from: classes7.dex */
public class o34 extends yq2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;
    public e24 l;
    public Runnable m;
    public t34 n;

    /* loaded from: classes7.dex */
    public class a implements jo2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo2 a;
        public final /* synthetic */ mq2 b;
        public final /* synthetic */ o34 c;

        /* renamed from: com.baidu.tieba.o34$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0411a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ io2 a;
            public final /* synthetic */ int b;
            public final /* synthetic */ a c;

            public RunnableC0411a(a aVar, io2 io2Var, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, io2Var, Integer.valueOf(i)};
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
                this.a = io2Var;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.c.c.i) {
                    return;
                }
                f24.c cVar = (f24.c) this.a;
                if (this.b == 0 && cVar != null) {
                    a aVar = this.c;
                    if (aVar.a != null) {
                        if (aVar.b.n0()) {
                            if (!g04.m().n()) {
                                n22.c(false);
                                this.c.b.A0(false);
                            } else {
                                o34 o34Var = this.c.c;
                                o34Var.o(o34Var.d).setVisibility(0);
                                this.c.c.r().E(this.c.c.f);
                                m22.b(true);
                                p22.i("GamesControllerImpl", "init sConsole for devHook");
                            }
                        }
                        this.c.c.l.c(cVar, this.c.c.d);
                        this.c.c.k = cVar.a;
                        this.c.a.a(0, cVar);
                        this.c.c.f0(cVar.c);
                        c74.b().e(cVar.c);
                    }
                }
            }
        }

        public a(o34 o34Var, jo2 jo2Var, mq2 mq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o34Var, jo2Var, mq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o34Var;
            this.a = jo2Var;
            this.b = mq2Var;
        }

        @Override // com.baidu.tieba.jo2
        public void a(int i, io2 io2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, io2Var) == null) {
                jj3.d0(this.c.m);
                this.c.m = new RunnableC0411a(this, io2Var, i);
                jj3.g0(this.c.m);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947981305, "Lcom/baidu/tieba/o34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947981305, "Lcom/baidu/tieba/o34;");
                return;
            }
        }
        o = am1.a;
    }

    public o34() {
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
        this.l = new e24();
        this.n = new t34();
    }

    @Override // com.baidu.tieba.yq2, com.baidu.tieba.ar2
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

    @Override // com.baidu.tieba.yq2, com.baidu.tieba.ar2
    public en1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.n;
        }
        return (en1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yq2, com.baidu.tieba.ar2
    public hn1 N() {
        InterceptResult invokeV;
        m14 m14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            y42 U = U();
            if (U == null || (m14Var = (m14) U.n(m14.class)) == null) {
                return null;
            }
            return m14Var.F3();
        }
        return (hn1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yq2, com.baidu.tieba.ar2
    public hn1 Q() {
        InterceptResult invokeV;
        m14 m14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            y42 U = U();
            if (U == null || (m14Var = (m14) U.n(m14.class)) == null) {
                return null;
            }
            return m14Var.D3();
        }
        return (hn1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yq2
    @NonNull
    public Pair<Integer, Integer> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return s();
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yq2, com.baidu.tieba.ar2
    public SwanCoreVersion getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return p14.m().s();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ar2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yq2, com.baidu.tieba.ar2
    @NonNull
    public Pair<Integer, Integer> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return y();
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yq2, com.baidu.tieba.ar2
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.x();
            os2.h(false);
            f54.a.a().f();
        }
    }

    public final void f0(j54 j54Var) {
        p53 F;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j54Var) == null) && (F = F()) != null) {
            F.I0(j54Var);
        }
    }

    @Override // com.baidu.tieba.yq2, com.baidu.tieba.ar2
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

    @Override // com.baidu.tieba.yq2, com.baidu.tieba.ar2
    public void G(mq2 mq2Var, jo2 jo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mq2Var, jo2Var) == null) {
            super.G(mq2Var, jo2Var);
            if (o) {
                Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + mq2Var.k0());
            }
            f24.c(mq2Var, new a(this, jo2Var, mq2Var));
            p14.m().I(mq2Var);
            p14.m().G(mq2Var);
            if (o) {
                Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
            }
            p14.m().z(null);
        }
    }

    @Override // com.baidu.tieba.yq2, com.baidu.tieba.ar2
    public SwanAppPropertyWindow L(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
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

    @Override // com.baidu.tieba.yq2, com.baidu.tieba.ar2
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.P();
            p14.C();
            f54.a.a().d(new JsObject());
            sl4.k(zh2.p() + File.separator + "tmp");
        }
    }

    @Override // com.baidu.tieba.yq2, com.baidu.tieba.ar2
    public vr1 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.a == null) {
                this.a = new k04(AppRuntime.getAppContext());
                l04.h(true);
            }
            this.a.D((ViewGroup) this.d.findViewById(16908290));
            return this.a;
        }
        return (vr1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yq2, com.baidu.tieba.ar2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.w();
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.S() != null) {
                mq2.a S = this.d.S();
                sc3 sc3Var = new sc3();
                sc3Var.a = ic3.n(1);
                sc3Var.f = S.I();
                sc3Var.c = S.U();
                sc3Var.b = "show";
                sc3Var.d(S.t0().getString("ubc"));
                sc3Var.b(ic3.k(S.X()));
                ic3.onEvent(sc3Var);
            }
            os2.h(true);
            f54.a.a().j();
        }
    }

    @Override // com.baidu.tieba.yq2, com.baidu.tieba.ar2
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
