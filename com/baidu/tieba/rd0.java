package com.baidu.tieba;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
/* loaded from: classes7.dex */
public final class rd0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String d = "rd0";
    public transient /* synthetic */ FieldHolder $fh;
    public EGLDisplay a;
    public EGLContext b;
    public EGLConfig c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948117643, "Lcom/baidu/tieba/rd0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948117643, "Lcom/baidu/tieba/rd0;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public rd0(EGLContext eGLContext, int i) {
        this(eGLContext, i, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eGLContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((EGLContext) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public rd0(EGLContext eGLContext, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eGLContext, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.a = eGLDisplay;
        this.b = EGL14.EGL_NO_CONTEXT;
        this.c = null;
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.a = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    if ((i & 2) != 0) {
                        Log.d(d, "Trying GLES 3");
                        EGLConfig c = c(i, 3, z);
                        if (c != null) {
                            EGLContext eglCreateContext = EGL14.eglCreateContext(this.a, c, eGLContext, new int[]{12440, 3, 12344}, 0);
                            if (EGL14.eglGetError() == 12288) {
                                this.c = c;
                                this.b = eglCreateContext;
                            }
                        }
                    }
                    if (this.b == EGL14.EGL_NO_CONTEXT) {
                        Log.d(d, "Trying GLES 2");
                        EGLConfig c2 = c(i, 2, z);
                        if (c2 != null) {
                            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.a, c2, eGLContext, new int[]{12440, 2, 12344}, 0);
                            a("eglCreateContext");
                            this.c = c2;
                            this.b = eglCreateContext2;
                        } else {
                            throw new RuntimeException("Unable to find a suitable EGLConfig");
                        }
                    }
                    int[] iArr2 = new int[1];
                    EGL14.eglQueryContext(this.a, this.b, 12440, iArr2, 0);
                    String str = d;
                    Log.d(str, "EGLContext created, client version " + iArr2[0]);
                    return;
                }
                this.a = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }
        throw new RuntimeException("EGL already set up");
    }

    public final EGLConfig c(int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i2 >= 3) {
                i3 = 68;
            } else {
                i3 = 4;
            }
            if (z) {
                i4 = 16;
            } else {
                i4 = 0;
            }
            int[] iArr = {MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, 12322, 8, 12321, 8, 12325, i4, 12326, 0, 12352, i3, 12344, 0, 12344};
            if ((i & 1) != 0) {
                iArr[14] = 12610;
                iArr[15] = 1;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (!EGL14.eglChooseConfig(this.a, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                String str = d;
                Log.w(str, "unable to find RGB8888 / " + i2 + " EGLConfig");
                return null;
            }
            return eGLConfigArr[0];
        }
        return (EGLConfig) invokeCommon.objValue;
    }

    public final void a(String str) {
        int eglGetError;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (eglGetError = EGL14.eglGetError()) == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    public EGLSurface b(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
                throw new RuntimeException("invalid surface: " + obj);
            }
            EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.a, this.c, obj, new int[]{12344}, 0);
            a("eglCreateWindowSurface");
            if (eglCreateWindowSurface != null) {
                return eglCreateWindowSurface;
            }
            throw new RuntimeException("surface was null");
        }
        return (EGLSurface) invokeL.objValue;
    }

    public boolean d(EGLSurface eGLSurface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eGLSurface)) == null) {
            if (this.b.equals(EGL14.eglGetCurrentContext()) && eGLSurface.equals(EGL14.eglGetCurrentSurface(12377))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void e(EGLSurface eGLSurface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eGLSurface) == null) {
            if (this.a == EGL14.EGL_NO_DISPLAY) {
                Log.d(d, "NOTE: makeCurrent w/o display");
            }
            if (EGL14.eglMakeCurrent(this.a, eGLSurface, eGLSurface, this.b)) {
                return;
            }
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void g(EGLSurface eGLSurface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eGLSurface) == null) {
            EGL14.eglDestroySurface(this.a, eGLSurface);
        }
    }

    public boolean i(EGLSurface eGLSurface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, eGLSurface)) == null) {
            return EGL14.eglSwapBuffers(this.a, eGLSurface);
        }
        return invokeL.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            EGLDisplay eGLDisplay = this.a;
            if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroyContext(this.a, this.b);
                EGL14.eglReleaseThread();
                EGL14.eglTerminate(this.a);
            }
            this.a = EGL14.EGL_NO_DISPLAY;
            this.b = EGL14.EGL_NO_CONTEXT;
            this.c = null;
        }
    }

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            try {
                if (this.a != EGL14.EGL_NO_DISPLAY) {
                    Log.w(d, "WARNING: EGLCore was not explicitly released -- state may be leaked");
                    f();
                }
            } finally {
                super.finalize();
            }
        }
    }

    public void h(EGLSurface eGLSurface, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, eGLSurface, j) == null) {
            EGLExt.eglPresentationTimeANDROID(this.a, eGLSurface, j);
        }
    }
}
