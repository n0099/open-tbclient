package com.baidu.tieba;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.SurfaceHolder;
import com.badlogic.gdx.backends.android.AndroidLiveWallpaperService;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes6.dex */
public final class l2 extends k2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends GLSurfaceView20 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l2 l2Var, Context context, c3 c3Var) {
            super(context, c3Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l2Var, context, c3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (c3) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = l2Var;
        }

        @Override // android.view.SurfaceView
        public SurfaceHolder getHolder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.e.y();
            }
            return (SurfaceHolder) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l2(n2 n2Var, b2 b2Var, c3 c3Var) {
        super(n2Var, b2Var, c3Var, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n2Var, b2Var, c3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((a2) objArr2[0], (b2) objArr2[1], (c3) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.k2
    public GLSurfaceView20 i(a2 a2Var, c3 c3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, a2Var, c3Var)) == null) {
            if (g()) {
                GLSurfaceView.EGLConfigChooser l = l();
                a aVar = new a(this, a2Var.getContext(), c3Var);
                if (l != null) {
                    aVar.setEGLConfigChooser(l);
                } else {
                    b2 b2Var = this.s;
                    aVar.setEGLConfigChooser(b2Var.a, b2Var.b, b2Var.c, b2Var.d, b2Var.e, b2Var.f);
                }
                aVar.setRenderer(this);
                return aVar;
            }
            throw new GdxRuntimeException("Libgdx requires OpenGL ES 2.0");
        }
        return (GLSurfaceView20) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.k2
    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && AndroidLiveWallpaperService.DEBUG) {
            super.o();
        }
    }

    public SurfaceHolder y() {
        InterceptResult invokeV;
        SurfaceHolder surfaceHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (((n2) this.d).a.sync) {
                surfaceHolder = ((n2) this.d).a.getSurfaceHolder();
            }
            return surfaceHolder;
        }
        return (SurfaceHolder) invokeV.objValue;
    }

    public void z() {
        GLSurfaceView20 gLSurfaceView20;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (gLSurfaceView20 = this.a) != null) {
            try {
                gLSurfaceView20.onDetachedFromWindow();
                if (AndroidLiveWallpaperService.DEBUG) {
                    Log.d(AndroidLiveWallpaperService.TAG, " > AndroidLiveWallpaper - onDestroy() stopped GLThread managed by GLSurfaceView");
                }
            } catch (Throwable th) {
                Log.e(AndroidLiveWallpaperService.TAG, "failed to destroy GLSurfaceView's thread! GLSurfaceView.onDetachedFromWindow impl changed since API lvl 16!");
                th.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.k2, android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gl10) == null) {
            long nanoTime = System.nanoTime();
            if (!this.q) {
                this.j = ((float) (nanoTime - this.i)) / 1.0E9f;
            } else {
                this.j = 0.0f;
            }
            this.i = nanoTime;
            synchronized (this.v) {
                z = this.o;
                z2 = this.p;
                z3 = this.r;
                z4 = this.q;
                if (this.q) {
                    this.q = false;
                    this.v.notifyAll();
                }
                if (this.p) {
                    this.p = false;
                    this.v.notifyAll();
                }
                if (this.r) {
                    this.r = false;
                    this.v.notifyAll();
                }
            }
            if (z4) {
                this.d.getApplicationListener().resume();
                y0.a.log("AndroidGraphics", "resumed");
            }
            if (z) {
                synchronized (this.d.getRunnables()) {
                    this.d.getExecutedRunnables().clear();
                    this.d.getExecutedRunnables().b(this.d.getRunnables());
                    this.d.getRunnables().clear();
                    for (int i = 0; i < this.d.getExecutedRunnables().b; i++) {
                        this.d.getExecutedRunnables().get(i).run();
                    }
                }
                this.d.mo6getInput().q1();
                this.l++;
                this.d.getApplicationListener().render();
            }
            if (z2) {
                this.d.getApplicationListener().pause();
                y0.a.log("AndroidGraphics", "paused");
            }
            if (z3) {
                this.d.getApplicationListener().dispose();
                y0.a.log("AndroidGraphics", "destroyed");
            }
            if (nanoTime - this.k > 1000000000) {
                this.m = 0;
                this.k = nanoTime;
            }
            this.m++;
        }
    }

    @Override // com.baidu.tieba.k2
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this.v) {
                this.o = true;
                this.q = true;
                while (this.q) {
                    try {
                        c();
                        this.v.wait();
                    } catch (InterruptedException unused) {
                        y0.a.log("AndroidGraphics", "waiting for resume synchronization failed!");
                    }
                }
            }
        }
    }
}
