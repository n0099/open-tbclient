package com.baidu.tieba;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20;
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.GLVersion;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes6.dex */
public class j2 extends s0 implements GLSurfaceView.Renderer {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean w;
    public transient /* synthetic */ FieldHolder $fh;
    public final GLSurfaceView20 a;
    public int b;
    public int c;
    public z1 d;
    public f3 e;
    public g3 f;
    public GLVersion g;
    public String h;
    public long i;
    public float j;
    public long k;
    public long l;
    public int m;
    public volatile boolean n;
    public volatile boolean o;
    public volatile boolean p;
    public volatile boolean q;
    public volatile boolean r;
    public final a2 s;
    public boolean t;
    public int[] u;
    public Object v;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448306597, "Lcom/baidu/tieba/j2;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448306597, "Lcom/baidu/tieba/j2;");
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j2 a;

        public a(j2 j2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.p) {
                return;
            }
            this.a.onDrawFrame(null);
        }
    }

    /* loaded from: classes6.dex */
    public class b extends Graphics.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j2 j2Var, int i, int i2, int i3, int i4) {
            super(i, i2, i3, i4);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j2Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j2(z1 z1Var, a2 a2Var, b3 b3Var) {
        this(z1Var, a2Var, b3Var, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z1Var, a2Var, b3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((z1) objArr2[0], (a2) objArr2[1], (b3) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public j2(z1 z1Var, a2 a2Var, b3 b3Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z1Var, a2Var, b3Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.i = System.nanoTime();
        this.j = 0.0f;
        this.k = System.nanoTime();
        this.l = -1L;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.t = true;
        this.u = new int[1];
        this.v = new Object();
        this.s = a2Var;
        this.d = z1Var;
        this.a = i(z1Var, b3Var);
        s();
        if (z) {
            this.a.setFocusable(true);
            this.a.setFocusableInTouchMode(true);
        }
    }

    @Override // com.badlogic.gdx.Graphics
    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.h == null) {
                this.h = x0.e.o(7939);
            }
            return this.h.contains(str);
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    public void u(boolean z) {
        ?? r5;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048600, this, z) == null) && this.a != null) {
            if (!w && !z) {
                r5 = 0;
            } else {
                r5 = 1;
            }
            this.t = r5;
            this.a.setRenderMode(r5);
        }
    }

    @Override // com.badlogic.gdx.Graphics
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.badlogic.gdx.Graphics
    public void c() {
        GLSurfaceView20 gLSurfaceView20;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (gLSurfaceView20 = this.a) != null) {
            gLSurfaceView20.requestRender();
        }
    }

    @Override // com.badlogic.gdx.Graphics
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.t;
        }
        return invokeV.booleanValue;
    }

    @Override // com.badlogic.gdx.Graphics
    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.j;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.s0
    public Graphics.GraphicsType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return Graphics.GraphicsType.AndroidGL;
        }
        return (Graphics.GraphicsType) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Mesh.g(this.d);
            Texture.t(this.d);
            Cubemap.t(this.d);
            j3.s(this.d);
            q5.g(this.d);
            k5.i(this.d);
            o();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this.v) {
                this.o = false;
                this.r = true;
                while (this.r) {
                    try {
                        this.v.wait();
                    } catch (InterruptedException unused) {
                        x0.a.log("AndroidGraphics", "waiting for destroy synchronization failed!");
                    }
                }
            }
        }
    }

    public GLSurfaceView.EGLConfigChooser l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            a2 a2Var = this.s;
            return new a3(a2Var.a, a2Var.b, a2Var.c, a2Var.d, a2Var.e, a2Var.f, a2Var.g);
        }
        return (GLSurfaceView.EGLConfigChooser) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public void p() {
        GLSurfaceView20 gLSurfaceView20;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (gLSurfaceView20 = this.a) != null) {
            gLSurfaceView20.onPause();
        }
    }

    public void q() {
        GLSurfaceView20 gLSurfaceView20;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (gLSurfaceView20 = this.a) != null) {
            gLSurfaceView20.onResume();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.a.setPreserveEGLContextOnPause(true);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            synchronized (this.v) {
                this.o = true;
                this.q = true;
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.d.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        }
    }

    @Override // com.badlogic.gdx.Graphics
    public Graphics.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.d.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return new b(this, displayMetrics.widthPixels, displayMetrics.heightPixels, 0, 0);
        }
        return (Graphics.a) invokeV.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            x0.a.log("AndroidGraphics", Mesh.k());
            x0.a.log("AndroidGraphics", Texture.v());
            x0.a.log("AndroidGraphics", Cubemap.v());
            x0.a.log("AndroidGraphics", q5.m());
            x0.a.log("AndroidGraphics", k5.l());
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && Build.VERSION.SDK_INT >= 28) {
            try {
                DisplayCutout displayCutout = this.d.getApplicationWindow().getDecorView().getRootWindowInsets().getDisplayCutout();
                if (displayCutout != null) {
                    displayCutout.getSafeInsetRight();
                    displayCutout.getSafeInsetBottom();
                    displayCutout.getSafeInsetTop();
                    displayCutout.getSafeInsetLeft();
                }
            } catch (UnsupportedOperationException unused) {
                x0.a.log("AndroidGraphics", "Unable to get safe area insets");
            }
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eglGetDisplay, new int[2]);
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eglGetDisplay, new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 4, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 4, 12322, 4, 12352, 4, 12344}, new EGLConfig[10], 10, iArr);
            egl10.eglTerminate(eglGetDisplay);
            if (iArr[0] > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            synchronized (this.v) {
                if (!this.o) {
                    return;
                }
                this.o = false;
                this.p = true;
                this.a.queueEvent(new a(this));
                while (this.p) {
                    try {
                        this.v.wait(4000L);
                        if (this.p) {
                            x0.a.error("AndroidGraphics", "waiting for pause synchronization took too long; assuming deadlock and killing");
                            Process.killProcess(Process.myPid());
                        }
                    } catch (InterruptedException unused) {
                        x0.a.log("AndroidGraphics", "waiting for pause synchronization failed!");
                    }
                }
            }
        }
    }

    public GLSurfaceView20 i(z1 z1Var, b3 b3Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, z1Var, b3Var)) == null) {
            if (g()) {
                GLSurfaceView.EGLConfigChooser l = l();
                Context context = z1Var.getContext();
                if (this.s.t) {
                    i = 3;
                } else {
                    i = 2;
                }
                GLSurfaceView20 gLSurfaceView20 = new GLSurfaceView20(context, b3Var, i);
                if (l != null) {
                    gLSurfaceView20.setEGLConfigChooser(l);
                } else {
                    a2 a2Var = this.s;
                    gLSurfaceView20.setEGLConfigChooser(a2Var.a, a2Var.b, a2Var.c, a2Var.d, a2Var.e, a2Var.f);
                }
                gLSurfaceView20.setRenderer(this);
                return gLSurfaceView20;
            }
            throw new GdxRuntimeException("Libgdx requires OpenGL ES 2.0");
        }
        return (GLSurfaceView20) invokeLL.objValue;
    }

    public final int k(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{egl10, eGLDisplay, eGLConfig, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.u)) {
                return this.u[0];
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public void n(EGLConfig eGLConfig) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eGLConfig) == null) {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            int k = k(egl10, eglGetDisplay, eGLConfig, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 0);
            int k2 = k(egl10, eglGetDisplay, eGLConfig, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 0);
            int k3 = k(egl10, eglGetDisplay, eGLConfig, 12322, 0);
            int k4 = k(egl10, eglGetDisplay, eGLConfig, 12321, 0);
            int k5 = k(egl10, eglGetDisplay, eGLConfig, 12325, 0);
            int k6 = k(egl10, eglGetDisplay, eGLConfig, 12326, 0);
            int max = Math.max(k(egl10, eglGetDisplay, eGLConfig, 12337, 0), k(egl10, eglGetDisplay, eGLConfig, 12513, 0));
            if (k(egl10, eglGetDisplay, eGLConfig, 12513, 0) != 0) {
                z = true;
            } else {
                z = false;
            }
            Application application = x0.a;
            application.log("AndroidGraphics", "framebuffer: (" + k + StringUtil.ARRAY_ELEMENT_SEPARATOR + k2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + k3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + k4 + SmallTailInfo.EMOTION_SUFFIX);
            Application application2 = x0.a;
            StringBuilder sb = new StringBuilder();
            sb.append("depthbuffer: (");
            sb.append(k5);
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            application2.log("AndroidGraphics", sb.toString());
            Application application3 = x0.a;
            application3.log("AndroidGraphics", "stencilbuffer: (" + k6 + SmallTailInfo.EMOTION_SUFFIX);
            Application application4 = x0.a;
            application4.log("AndroidGraphics", "samples: (" + max + SmallTailInfo.EMOTION_SUFFIX);
            Application application5 = x0.a;
            application5.log("AndroidGraphics", "coverage sampling: (" + z + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public void v(GL10 gl10) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, gl10) == null) {
            GLVersion gLVersion = new GLVersion(Application.ApplicationType.Android, gl10.glGetString(7938), gl10.glGetString(7936), gl10.glGetString(7937));
            this.g = gLVersion;
            if (this.s.t && gLVersion.b() > 2) {
                if (this.f != null) {
                    return;
                }
                i2 i2Var = new i2();
                this.f = i2Var;
                this.e = i2Var;
                x0.e = i2Var;
                x0.f = i2Var;
                x0.g = i2Var;
            } else if (this.e != null) {
                return;
            } else {
                h2 h2Var = new h2();
                this.e = h2Var;
                x0.e = h2Var;
                x0.f = h2Var;
            }
            Application application = x0.a;
            application.log("AndroidGraphics", "OGL renderer: " + gl10.glGetString(7937));
            Application application2 = x0.a;
            application2.log("AndroidGraphics", "OGL vendor: " + gl10.glGetString(7936));
            Application application3 = x0.a;
            application3.log("AndroidGraphics", "OGL version: " + gl10.glGetString(7938));
            Application application4 = x0.a;
            application4.log("AndroidGraphics", "OGL extensions: " + gl10.glGetString(7939));
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, gl10) == null) {
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
                z7<z0> lifecycleListeners = this.d.getLifecycleListeners();
                synchronized (lifecycleListeners) {
                    z0[] o = lifecycleListeners.o();
                    int i = lifecycleListeners.b;
                    for (int i2 = 0; i2 < i; i2++) {
                        o[i2].resume();
                    }
                    lifecycleListeners.p();
                }
                this.d.getApplicationListener().resume();
                x0.a.log("AndroidGraphics", "resumed");
            }
            if (z) {
                synchronized (this.d.getRunnables()) {
                    this.d.getExecutedRunnables().clear();
                    this.d.getExecutedRunnables().b(this.d.getRunnables());
                    this.d.getRunnables().clear();
                }
                for (int i3 = 0; i3 < this.d.getExecutedRunnables().b; i3++) {
                    try {
                        this.d.getExecutedRunnables().get(i3).run();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                this.d.mo6getInput().f1();
                this.l++;
                this.d.getApplicationListener().render();
            }
            if (z2) {
                z7<z0> lifecycleListeners2 = this.d.getLifecycleListeners();
                synchronized (lifecycleListeners2) {
                    z0[] o2 = lifecycleListeners2.o();
                    int i4 = lifecycleListeners2.b;
                    for (int i5 = 0; i5 < i4; i5++) {
                        o2[i5].pause();
                    }
                }
                this.d.getApplicationListener().pause();
                x0.a.log("AndroidGraphics", "paused");
            }
            if (z3) {
                z7<z0> lifecycleListeners3 = this.d.getLifecycleListeners();
                synchronized (lifecycleListeners3) {
                    z0[] o3 = lifecycleListeners3.o();
                    int i6 = lifecycleListeners3.b;
                    for (int i7 = 0; i7 < i6; i7++) {
                        o3[i7].dispose();
                    }
                }
                this.d.getApplicationListener().dispose();
                x0.a.log("AndroidGraphics", "destroyed");
            }
            if (nanoTime - this.k > 1000000000) {
                this.m = 0;
                this.k = nanoTime;
            }
            this.m++;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048593, this, gl10, i, i2) == null) {
            this.b = i;
            this.c = i2;
            w();
            x();
            gl10.glViewport(0, 0, this.b, this.c);
            if (!this.n) {
                this.d.getApplicationListener().create();
                this.n = true;
                synchronized (this) {
                    this.o = true;
                }
            }
            this.d.getApplicationListener().a(i, i2);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, gl10, eGLConfig) == null) {
            ((EGL10) EGLContext.getEGL()).eglGetCurrentContext();
            v(gl10);
            n(eGLConfig);
            w();
            x();
            Mesh.n(this.d);
            Texture.y(this.d);
            Cubemap.w(this.d);
            j3.t(this.d);
            q5.n(this.d);
            k5.n(this.d);
            o();
            Display defaultDisplay = this.d.getWindowManager().getDefaultDisplay();
            this.b = defaultDisplay.getWidth();
            this.c = defaultDisplay.getHeight();
            this.i = System.nanoTime();
            gl10.glViewport(0, 0, this.b, this.c);
        }
    }
}
