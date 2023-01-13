package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
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
/* loaded from: classes6.dex */
public class v2 implements i2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AndroidLiveWallpaperService a;
    public t2 b;
    public u2 c;
    public l2 d;
    public p2 e;
    public y2 f;
    public d1 g;
    public boolean h;
    public final c7<Runnable> i;
    public final c7<Runnable> j;
    public final i8<i1> k;
    public int l;
    public e1 m;
    public volatile m3[] n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448318129, "Lcom/baidu/tieba/v2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448318129, "Lcom/baidu/tieba/v2;");
                return;
            }
        }
        l7.a();
    }

    public p2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            e().getFilesDir();
            return new f3(e().getAssets(), e(), true);
        }
        return (p2) invokeV.objValue;
    }

    public e1 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.m;
        }
        return (e1) invokeV.objValue;
    }

    public AndroidLiveWallpaperService e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (AndroidLiveWallpaperService) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return Build.VERSION.SDK_INT;
        }
        return invokeV.intValue;
    }

    @Override // com.badlogic.gdx.Application
    public d1 getApplicationListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.g;
        }
        return (d1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i2
    public Window getApplicationWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (Window) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i2
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.a;
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i2
    public c7<Runnable> getExecutedRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.j;
        }
        return (c7) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Graphics getGraphics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.b;
        }
        return (Graphics) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i2
    /* renamed from: getInput */
    public u2 mo6getInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.c;
        }
        return (u2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i2
    public i8<i1> getLifecycleListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.k;
        }
        return (i8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i2
    public c7<Runnable> getRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.i;
        }
        return (c7) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Application.ApplicationType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return Application.ApplicationType.Android;
        }
        return (Application.ApplicationType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i2
    public WindowManager getWindowManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.a.getWindowManager();
        }
        return (WindowManager) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            t2 t2Var = this.b;
            if (t2Var != null) {
                t2Var.z();
            }
            l2 l2Var = this.d;
            if (l2Var != null) {
                l2Var.dispose();
            }
        }
    }

    public v2(AndroidLiveWallpaperService androidLiveWallpaperService) {
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
        this.i = new c7<>();
        this.j = new c7<>();
        this.k = new i8<>(i1.class);
        this.l = 2;
        this.n = null;
        this.a = androidLiveWallpaperService;
    }

    public l2 a(Context context, j2 j2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, j2Var)) == null) {
            return new e3(context, j2Var);
        }
        return (l2) invokeLL.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public void debug(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) && this.l >= 3) {
            d().debug(str, str2);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) && this.l >= 1) {
            d().error(str, str2);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void log(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048600, this, str, str2) == null) && this.l >= 2) {
            d().log(str, str2);
        }
    }

    public u2 c(Application application, Context context, Object obj, j2 j2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, application, context, obj, j2Var)) == null) {
            return new g3(this, e(), this.b.a, j2Var);
        }
        return (u2) invokeLLLL.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, th) == null) && this.l >= 1) {
            d().error(str, str2, th);
        }
    }

    public void g(d1 d1Var, j2 j2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, d1Var, j2Var) == null) {
            if (f() >= 14) {
                k(new k2());
                k3 k3Var = j2Var.r;
                if (k3Var == null) {
                    k3Var = new i3();
                }
                this.b = new t2(this, j2Var, k3Var);
                this.c = c(this, e(), this.b.a, j2Var);
                this.d = a(e(), j2Var);
                this.e = b();
                this.f = new y2(this, j2Var);
                this.g = d1Var;
                new m2(e());
                g1.a = this;
                g1.c = this.d;
                g1.d = this.e;
                g1.b = this.b;
                return;
            }
            throw new GdxRuntimeException("LibGDX requires Android API Level 14 or later.");
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (AndroidLiveWallpaperService.DEBUG) {
                Log.d(AndroidLiveWallpaperService.TAG, " > AndroidLiveWallpaper - onPause()");
            }
            this.d.pause();
            this.c.onPause();
            t2 t2Var = this.b;
            if (t2Var != null) {
                t2Var.p();
            }
            if (AndroidLiveWallpaperService.DEBUG) {
                Log.d(AndroidLiveWallpaperService.TAG, " > AndroidLiveWallpaper - onPause() done!");
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            g1.a = this;
            u2 u2Var = this.c;
            g1.c = this.d;
            g1.d = this.e;
            g1.b = this.b;
            u2Var.onResume();
            t2 t2Var = this.b;
            if (t2Var != null) {
                t2Var.q();
            }
            if (!this.h) {
                this.d.resume();
                this.b.t();
                return;
            }
            this.h = false;
        }
    }

    public void k(e1 e1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, e1Var) == null) {
            this.m = e1Var;
        }
    }

    @Override // com.badlogic.gdx.Application
    public void postRunnable(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, runnable) == null) {
            synchronized (this.i) {
                this.i.a(runnable);
            }
        }
    }

    public void startActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, intent) == null) {
            this.a.startActivity(intent);
        }
    }
}
