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
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.b04;
import com.baidu.tieba.io2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
@Service
/* loaded from: classes4.dex */
public class k14 extends uo2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;
    public a04 l;
    public Runnable m;
    public p14 n;

    /* loaded from: classes4.dex */
    public class a implements fm2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm2 a;
        public final /* synthetic */ io2 b;
        public final /* synthetic */ k14 c;

        /* renamed from: com.baidu.tieba.k14$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0312a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ em2 a;
            public final /* synthetic */ int b;
            public final /* synthetic */ a c;

            public RunnableC0312a(a aVar, em2 em2Var, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, em2Var, Integer.valueOf(i)};
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
                this.a = em2Var;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c.c.i) {
                    return;
                }
                b04.c cVar = (b04.c) this.a;
                if (this.b != 0 || cVar == null) {
                    return;
                }
                a aVar = this.c;
                if (aVar.a == null) {
                    return;
                }
                if (aVar.b.m0()) {
                    if (!cy3.m().n()) {
                        j02.c(false);
                        this.c.b.z0(false);
                    } else {
                        k14 k14Var = this.c.c;
                        k14Var.n(k14Var.d).setVisibility(0);
                        this.c.c.q().G(this.c.c.f);
                        i02.b(true);
                        l02.i("GamesControllerImpl", "init sConsole for devHook");
                    }
                }
                this.c.c.l.c(cVar, this.c.c.d);
                this.c.c.k = cVar.a;
                this.c.a.a(0, cVar);
                this.c.c.e0(cVar.c);
                y44.b().e(cVar.c);
            }
        }

        public a(k14 k14Var, fm2 fm2Var, io2 io2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k14Var, fm2Var, io2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = k14Var;
            this.a = fm2Var;
            this.b = io2Var;
        }

        @Override // com.baidu.tieba.fm2
        public void a(int i, em2 em2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, em2Var) == null) {
                fh3.d0(this.c.m);
                this.c.m = new RunnableC0312a(this, em2Var, i);
                fh3.g0(this.c.m);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947860219, "Lcom/baidu/tieba/k14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947860219, "Lcom/baidu/tieba/k14;");
                return;
            }
        }
        o = vj1.a;
    }

    public k14() {
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
        this.l = new a04();
        this.n = new p14();
    }

    @Override // com.baidu.tieba.uo2, com.baidu.tieba.wo2
    public void E(io2 io2Var, fm2 fm2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, io2Var, fm2Var) == null) {
            super.E(io2Var, fm2Var);
            if (o) {
                Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + io2Var.j0());
            }
            b04.c(io2Var, new a(this, fm2Var, io2Var));
            lz3.m().I(io2Var);
            lz3.m().G(io2Var);
            if (o) {
                Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
            }
            lz3.m().z(null);
        }
    }

    @Override // com.baidu.tieba.uo2, com.baidu.tieba.wo2
    public zk1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : (zk1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uo2, com.baidu.tieba.wo2
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
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

    @Override // com.baidu.tieba.uo2, com.baidu.tieba.wo2
    public cl1 L() {
        InterceptResult invokeV;
        iz3 iz3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            u22 T = T();
            if (T == null || (iz3Var = (iz3) T.n(iz3.class)) == null) {
                return null;
            }
            return iz3Var.y3();
        }
        return (cl1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uo2, com.baidu.tieba.wo2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? lz3.m().s() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uo2, com.baidu.tieba.wo2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.O();
            lz3.C();
            b34.a.a().d(new JsObject());
            pj4.k(vf2.p() + File.separator + "tmp");
        }
    }

    @Override // com.baidu.tieba.uo2, com.baidu.tieba.wo2
    public cl1 P() {
        InterceptResult invokeV;
        iz3 iz3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            u22 T = T();
            if (T == null || (iz3Var = (iz3) T.n(iz3.class)) == null) {
                return null;
            }
            return iz3Var.w3();
        }
        return (cl1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uo2
    @NonNull
    public Pair<Integer, Integer> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? r() : (Pair) invokeV.objValue;
    }

    public final void e0(f34 f34Var) {
        l33 D;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, f34Var) == null) || (D = D()) == null) {
            return;
        }
        D.H0(f34Var);
    }

    @Override // com.baidu.tieba.wo2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.h : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.uo2, com.baidu.tieba.wo2
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

    @Override // com.baidu.tieba.uo2, com.baidu.tieba.wo2
    public qp1 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.a == null) {
                this.a = new gy3(AppRuntime.getAppContext());
                hy3.h(true);
            }
            this.a.F((ViewGroup) this.d.findViewById(16908290));
            return this.a;
        }
        return (qp1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uo2, com.baidu.tieba.wo2
    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? x() : (Pair) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uo2, com.baidu.tieba.wo2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.v();
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.S() != null) {
                io2.a S = this.d.S();
                oa3 oa3Var = new oa3();
                oa3Var.a = ea3.n(1);
                oa3Var.f = S.H();
                oa3Var.c = S.T();
                oa3Var.b = "show";
                oa3Var.d(S.s0().getString(UBCCloudControlProcessor.UBC_KEY));
                oa3Var.b(ea3.k(S.W()));
                ea3.onEvent(oa3Var);
            }
            kq2.h(true);
            b34.a.a().j();
        }
    }

    @Override // com.baidu.tieba.uo2, com.baidu.tieba.wo2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.w();
            kq2.h(false);
            b34.a.a().f();
        }
    }

    @Override // com.baidu.tieba.uo2, com.baidu.tieba.wo2
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
            if (window == null || (decorView = window.getDecorView()) == null) {
                i = 0;
                i2 = 0;
            } else {
                i2 = decorView.getWidth();
                i = decorView.getHeight();
            }
            Display defaultDisplay = this.d.getWindowManager().getDefaultDisplay();
            if (i2 == 0 || i == 0) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getRealMetrics(displayMetrics);
                i2 = displayMetrics.widthPixels;
                i = displayMetrics.heightPixels;
            }
            if (this.d.i0() == ((defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) ? true : true)) {
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

    @Override // com.baidu.tieba.uo2, com.baidu.tieba.wo2
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? TextUtils.isEmpty(this.k) ? "" : this.k : (String) invokeV.objValue;
    }
}
