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
public class m2 implements z1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AndroidLiveWallpaperService a;
    public k2 b;
    public l2 c;
    public c2 d;
    public g2 e;
    public p2 f;
    public u0 g;
    public boolean h;
    public final t6<Runnable> i;
    public final t6<Runnable> j;
    public final z7<z0> k;
    public int l;
    public v0 m;
    public volatile d3[] n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448309480, "Lcom/baidu/tieba/m2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448309480, "Lcom/baidu/tieba/m2;");
                return;
            }
        }
        c7.a();
    }

    public g2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            e().getFilesDir();
            return new w2(e().getAssets(), e(), true);
        }
        return (g2) invokeV.objValue;
    }

    public v0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.m;
        }
        return (v0) invokeV.objValue;
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
    public u0 getApplicationListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.g;
        }
        return (u0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z1
    public Window getApplicationWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (Window) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z1
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.a;
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z1
    public t6<Runnable> getExecutedRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.j;
        }
        return (t6) invokeV.objValue;
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

    @Override // com.baidu.tieba.z1
    /* renamed from: getInput */
    public l2 mo6getInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.c;
        }
        return (l2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z1
    public z7<z0> getLifecycleListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.k;
        }
        return (z7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z1
    public t6<Runnable> getRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.i;
        }
        return (t6) invokeV.objValue;
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

    @Override // com.baidu.tieba.z1
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
            k2 k2Var = this.b;
            if (k2Var != null) {
                k2Var.z();
            }
            c2 c2Var = this.d;
            if (c2Var != null) {
                c2Var.dispose();
            }
        }
    }

    public m2(AndroidLiveWallpaperService androidLiveWallpaperService) {
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
        this.i = new t6<>();
        this.j = new t6<>();
        this.k = new z7<>(z0.class);
        this.l = 2;
        this.n = null;
        this.a = androidLiveWallpaperService;
    }

    public c2 a(Context context, a2 a2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, a2Var)) == null) {
            return new v2(context, a2Var);
        }
        return (c2) invokeLL.objValue;
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

    public l2 c(Application application, Context context, Object obj, a2 a2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, application, context, obj, a2Var)) == null) {
            return new x2(this, e(), this.b.a, a2Var);
        }
        return (l2) invokeLLLL.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, th) == null) && this.l >= 1) {
            d().error(str, str2, th);
        }
    }

    public void g(u0 u0Var, a2 a2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, u0Var, a2Var) == null) {
            if (f() >= 14) {
                k(new b2());
                b3 b3Var = a2Var.r;
                if (b3Var == null) {
                    b3Var = new z2();
                }
                this.b = new k2(this, a2Var, b3Var);
                this.c = c(this, e(), this.b.a, a2Var);
                this.d = a(e(), a2Var);
                this.e = b();
                this.f = new p2(this, a2Var);
                this.g = u0Var;
                new d2(e());
                x0.a = this;
                x0.c = this.d;
                x0.d = this.e;
                x0.b = this.b;
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
            k2 k2Var = this.b;
            if (k2Var != null) {
                k2Var.p();
            }
            if (AndroidLiveWallpaperService.DEBUG) {
                Log.d(AndroidLiveWallpaperService.TAG, " > AndroidLiveWallpaper - onPause() done!");
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            x0.a = this;
            l2 l2Var = this.c;
            x0.c = this.d;
            x0.d = this.e;
            x0.b = this.b;
            l2Var.onResume();
            k2 k2Var = this.b;
            if (k2Var != null) {
                k2Var.q();
            }
            if (!this.h) {
                this.d.resume();
                this.b.t();
                return;
            }
            this.h = false;
        }
    }

    public void k(v0 v0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, v0Var) == null) {
            this.m = v0Var;
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
