package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.android.AndroidLiveWallpaperService;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class q1 implements e1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AndroidLiveWallpaperService a;
    public o1 b;
    public p1 c;
    public h1 d;
    public k1 e;
    public t1 f;
    public v0 g;
    public boolean h;
    public final r2<Runnable> i;
    public final r2<Runnable> j;
    public final g3<a1> k;
    public int l;
    public w0 m;
    public volatile d2[] n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448313293, "Lcom/baidu/tieba/q1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448313293, "Lcom/baidu/tieba/q1;");
                return;
            }
        }
        w2.a();
    }

    public k1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            e().getFilesDir();
            return new y1(e().getAssets(), e(), true);
        }
        return (k1) invokeV.objValue;
    }

    public w0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.m;
        }
        return (w0) invokeV.objValue;
    }

    public AndroidLiveWallpaperService e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (AndroidLiveWallpaperService) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return Build.VERSION.SDK_INT;
        }
        return invokeV.intValue;
    }

    @Override // com.badlogic.gdx.Application
    public v0 getApplicationListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.g;
        }
        return (v0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e1
    public Window getApplicationWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (Window) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e1
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a;
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e1
    public r2<Runnable> getExecutedRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.j;
        }
        return (r2) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Graphics getGraphics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b;
        }
        return (Graphics) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e1
    /* renamed from: getInput */
    public p1 mo6getInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.c;
        }
        return (p1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e1
    public g3<a1> getLifecycleListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.k;
        }
        return (g3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e1
    public r2<Runnable> getRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.i;
        }
        return (r2) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Application.ApplicationType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return Application.ApplicationType.Android;
        }
        return (Application.ApplicationType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e1
    public WindowManager getWindowManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.a.getWindowManager();
        }
        return (WindowManager) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            o1 o1Var = this.b;
            if (o1Var != null) {
                o1Var.y();
            }
            h1 h1Var = this.d;
            if (h1Var != null) {
                h1Var.dispose();
            }
        }
    }

    public q1(AndroidLiveWallpaperService androidLiveWallpaperService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {androidLiveWallpaperService};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = true;
        this.i = new r2<>();
        this.j = new r2<>();
        this.k = new g3<>(a1.class);
        this.l = 2;
        this.n = null;
        this.a = androidLiveWallpaperService;
    }

    public h1 a(Context context, f1 f1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, f1Var)) == null) {
            return new x1(context, f1Var);
        }
        return (h1) invokeLL.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) && this.l >= 1) {
            d().error(str, str2);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void log(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && this.l >= 2) {
            d().log(str, str2);
        }
    }

    public p1 c(Application application, Context context, Object obj, f1 f1Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, application, context, obj, f1Var)) == null) {
            return new z1(this, e(), this.b.a, f1Var);
        }
        return (p1) invokeLLLL.objValue;
    }

    public void g(v0 v0Var, f1 f1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, v0Var, f1Var) == null) {
            if (f() >= 14) {
                k(new g1());
                c2 c2Var = f1Var.r;
                if (c2Var == null) {
                    c2Var = new a2();
                }
                this.b = new o1(this, f1Var, c2Var);
                this.c = c(this, e(), this.b.a, f1Var);
                this.d = a(e(), f1Var);
                this.e = b();
                this.f = new t1(this, f1Var);
                this.g = v0Var;
                new i1(e());
                y0.a = this;
                y0.b = this.b;
                return;
            }
            throw new GdxRuntimeException("LibGDX requires Android API Level 14 or later.");
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (AndroidLiveWallpaperService.DEBUG) {
                Log.d(AndroidLiveWallpaperService.TAG, " > AndroidLiveWallpaper - onPause()");
            }
            this.d.pause();
            this.c.onPause();
            o1 o1Var = this.b;
            if (o1Var != null) {
                o1Var.o();
            }
            if (AndroidLiveWallpaperService.DEBUG) {
                Log.d(AndroidLiveWallpaperService.TAG, " > AndroidLiveWallpaper - onPause() done!");
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            y0.a = this;
            p1 p1Var = this.c;
            y0.b = this.b;
            p1Var.onResume();
            o1 o1Var = this.b;
            if (o1Var != null) {
                o1Var.p();
            }
            if (!this.h) {
                this.d.resume();
                this.b.s();
                return;
            }
            this.h = false;
        }
    }

    public void k(w0 w0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, w0Var) == null) {
            this.m = w0Var;
        }
    }

    @Override // com.badlogic.gdx.Application
    public void postRunnable(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, runnable) == null) {
            synchronized (this.i) {
                this.i.a(runnable);
            }
        }
    }
}
