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
public class u2 implements h2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AndroidLiveWallpaperService a;
    public s2 b;
    public t2 c;
    public k2 d;
    public o2 e;
    public x2 f;
    public c1 g;
    public boolean h;
    public final b7<Runnable> i;
    public final b7<Runnable> j;
    public final h8<h1> k;
    public int l;
    public d1 m;
    public volatile l3[] n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448317168, "Lcom/baidu/tieba/u2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448317168, "Lcom/baidu/tieba/u2;");
                return;
            }
        }
        k7.a();
    }

    public u2(AndroidLiveWallpaperService androidLiveWallpaperService) {
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
        this.i = new b7<>();
        this.j = new b7<>();
        this.k = new h8<>(h1.class);
        this.l = 2;
        this.n = null;
        this.a = androidLiveWallpaperService;
    }

    public k2 a(Context context, i2 i2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, i2Var)) == null) ? new d3(context, i2Var) : (k2) invokeLL.objValue;
    }

    public o2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            e().getFilesDir();
            return new e3(e().getAssets(), e(), true);
        }
        return (o2) invokeV.objValue;
    }

    public t2 c(Application application, Context context, Object obj, i2 i2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, application, context, obj, i2Var)) == null) ? new f3(this, e(), this.b.a, i2Var) : (t2) invokeLLLL.objValue;
    }

    public d1 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m : (d1) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public void debug(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) || this.l < 3) {
            return;
        }
        d().debug(str, str2);
    }

    public AndroidLiveWallpaperService e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (AndroidLiveWallpaperService) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || this.l < 1) {
            return;
        }
        d().error(str, str2);
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? Build.VERSION.SDK_INT : invokeV.intValue;
    }

    public void g(c1 c1Var, i2 i2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, c1Var, i2Var) == null) {
            if (f() >= 14) {
                k(new j2());
                j3 j3Var = i2Var.r;
                if (j3Var == null) {
                    j3Var = new h3();
                }
                this.b = new s2(this, i2Var, j3Var);
                this.c = c(this, e(), this.b.a, i2Var);
                this.d = a(e(), i2Var);
                this.e = b();
                this.f = new x2(this, i2Var);
                this.g = c1Var;
                new l2(e());
                f1.a = this;
                f1.c = this.d;
                f1.d = this.e;
                f1.b = this.b;
                return;
            }
            throw new GdxRuntimeException("LibGDX requires Android API Level 14 or later.");
        }
    }

    @Override // com.badlogic.gdx.Application
    public c1 getApplicationListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.g : (c1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h2
    public Window getApplicationWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (Window) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h2
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h2
    public b7<Runnable> getExecutedRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.j : (b7) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Graphics getGraphics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.b : (Graphics) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h2
    public t2 getInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.c : (t2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h2
    public h8<h1> getLifecycleListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.k : (h8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h2
    public b7<Runnable> getRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.i : (b7) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Application.ApplicationType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? Application.ApplicationType.Android : (Application.ApplicationType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h2
    public WindowManager getWindowManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.a.getWindowManager() : (WindowManager) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            s2 s2Var = this.b;
            if (s2Var != null) {
                s2Var.z();
            }
            k2 k2Var = this.d;
            if (k2Var != null) {
                k2Var.dispose();
            }
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
            s2 s2Var = this.b;
            if (s2Var != null) {
                s2Var.p();
            }
            if (AndroidLiveWallpaperService.DEBUG) {
                Log.d(AndroidLiveWallpaperService.TAG, " > AndroidLiveWallpaper - onPause() done!");
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            f1.a = this;
            t2 t2Var = this.c;
            f1.c = this.d;
            f1.d = this.e;
            f1.b = this.b;
            t2Var.onResume();
            s2 s2Var = this.b;
            if (s2Var != null) {
                s2Var.q();
            }
            if (!this.h) {
                this.d.resume();
                this.b.t();
                return;
            }
            this.h = false;
        }
    }

    public void k(d1 d1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, d1Var) == null) {
            this.m = d1Var;
        }
    }

    @Override // com.badlogic.gdx.Application
    public void log(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048600, this, str, str2) == null) || this.l < 2) {
            return;
        }
        d().log(str, str2);
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

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, th) == null) || this.l < 1) {
            return;
        }
        d().error(str, str2, th);
    }
}
