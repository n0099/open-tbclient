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
import com.baidu.tieba.l84;
import com.baidu.tieba.sw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
@Service
/* loaded from: classes8.dex */
public class u94 extends ex2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;
    public k84 l;
    public Runnable m;
    public z94 n;

    /* loaded from: classes8.dex */
    public class a implements pu2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu2 a;
        public final /* synthetic */ sw2 b;
        public final /* synthetic */ u94 c;

        /* renamed from: com.baidu.tieba.u94$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0501a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ou2 a;
            public final /* synthetic */ int b;
            public final /* synthetic */ a c;

            public RunnableC0501a(a aVar, ou2 ou2Var, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ou2Var, Integer.valueOf(i)};
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
                this.a = ou2Var;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.c.c.i) {
                    return;
                }
                l84.c cVar = (l84.c) this.a;
                if (this.b == 0 && cVar != null) {
                    a aVar = this.c;
                    if (aVar.a != null) {
                        if (aVar.b.m0()) {
                            if (!m64.m().n()) {
                                t82.c(false);
                                this.c.b.z0(false);
                            } else {
                                u94 u94Var = this.c.c;
                                u94Var.n(u94Var.d).setVisibility(0);
                                this.c.c.q().F(this.c.c.f);
                                s82.b(true);
                                v82.i("GamesControllerImpl", "init sConsole for devHook");
                            }
                        }
                        this.c.c.l.c(cVar, this.c.c.d);
                        this.c.c.k = cVar.a;
                        this.c.a.a(0, cVar);
                        this.c.c.d0(cVar.c);
                        id4.b().e(cVar.c);
                    }
                }
            }
        }

        public a(u94 u94Var, pu2 pu2Var, sw2 sw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u94Var, pu2Var, sw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u94Var;
            this.a = pu2Var;
            this.b = sw2Var;
        }

        @Override // com.baidu.tieba.pu2
        public void a(int i, ou2 ou2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, ou2Var) == null) {
                pp3.d0(this.c.m);
                this.c.m = new RunnableC0501a(this, ou2Var, i);
                pp3.g0(this.c.m);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948165817, "Lcom/baidu/tieba/u94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948165817, "Lcom/baidu/tieba/u94;");
                return;
            }
        }
        o = fs1.a;
    }

    public u94() {
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
        this.l = new k84();
        this.n = new z94();
    }

    @Override // com.baidu.tieba.ex2, com.baidu.tieba.gx2
    public jt1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.n;
        }
        return (jt1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ex2, com.baidu.tieba.gx2
    public mt1 L() {
        InterceptResult invokeV;
        s74 s74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            eb2 S = S();
            if (S == null || (s74Var = (s74) S.n(s74.class)) == null) {
                return null;
            }
            return s74Var.A3();
        }
        return (mt1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ex2, com.baidu.tieba.gx2
    public mt1 O() {
        InterceptResult invokeV;
        s74 s74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            eb2 S = S();
            if (S == null || (s74Var = (s74) S.n(s74.class)) == null) {
                return null;
            }
            return s74Var.y3();
        }
        return (mt1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ex2
    @NonNull
    public Pair<Integer, Integer> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return r();
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ex2, com.baidu.tieba.gx2
    public SwanCoreVersion getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return v74.m().s();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gx2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ex2, com.baidu.tieba.gx2
    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return x();
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ex2, com.baidu.tieba.gx2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.w();
            uy2.h(false);
            lb4.a.a().f();
        }
    }

    @Override // com.baidu.tieba.ex2, com.baidu.tieba.gx2
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (TextUtils.isEmpty(this.k)) {
                return "";
            }
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public final void d0(pb4 pb4Var) {
        vb3 D;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, pb4Var) == null) && (D = D()) != null) {
            D.H0(pb4Var);
        }
    }

    @Override // com.baidu.tieba.ex2, com.baidu.tieba.gx2
    public FullScreenFloatView n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, activity)) == null) {
            super.n(activity);
            this.f.setAutoAttachEnable(false);
            return this.f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ex2, com.baidu.tieba.gx2
    public void E(sw2 sw2Var, pu2 pu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, sw2Var, pu2Var) == null) {
            super.E(sw2Var, pu2Var);
            if (o) {
                Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + sw2Var.j0());
            }
            l84.c(sw2Var, new a(this, pu2Var, sw2Var));
            v74.m().I(sw2Var);
            v74.m().G(sw2Var);
            if (o) {
                Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
            }
            v74.m().z(null);
        }
    }

    @Override // com.baidu.tieba.ex2, com.baidu.tieba.gx2
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
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

    @Override // com.baidu.tieba.ex2, com.baidu.tieba.gx2
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.N();
            v74.C();
            lb4.a.a().d(new JsObject());
            zr4.k(fo2.p() + File.separator + "tmp");
        }
    }

    @Override // com.baidu.tieba.ex2, com.baidu.tieba.gx2
    public ay1 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.a == null) {
                this.a = new q64(AppRuntime.getAppContext());
                r64.h(true);
            }
            this.a.E((ViewGroup) this.d.findViewById(16908290));
            return this.a;
        }
        return (ay1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ex2, com.baidu.tieba.gx2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.v();
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.T() != null) {
                sw2.a T2 = this.d.T();
                yi3 yi3Var = new yi3();
                yi3Var.a = oi3.n(1);
                yi3Var.f = T2.H();
                yi3Var.c = T2.T();
                yi3Var.b = "show";
                yi3Var.d(T2.s0().getString("ubc"));
                yi3Var.b(oi3.k(T2.W()));
                oi3.onEvent(yi3Var);
            }
            uy2.h(true);
            lb4.a.a().j();
        }
    }

    @Override // com.baidu.tieba.ex2, com.baidu.tieba.gx2
    @NonNull
    public Pair<Integer, Integer> x() {
        InterceptResult invokeV;
        int i;
        int i2;
        View decorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity == null) {
                return super.x();
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
