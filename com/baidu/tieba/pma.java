package com.baidu.tieba;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
@TargetApi(18)
/* loaded from: classes7.dex */
public class pma {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EGLDisplay a;
    public EGLContext b;
    public EGLSurface c;
    public Surface d;

    public pma(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {surface};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (surface != null) {
            this.d = surface;
            b();
            return;
        }
        throw null;
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            boolean z = false;
            while (true) {
                int eglGetError = EGL14.eglGetError();
                if (eglGetError == 12288) {
                    break;
                }
                Log.e("InputSurface", str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
                z = true;
            }
            if (!z) {
                return;
            }
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.a = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    if (EGL14.eglChooseConfig(this.a, new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                        this.b = EGL14.eglCreateContext(this.a, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                        a("eglCreateContext");
                        if (this.b != null) {
                            this.c = EGL14.eglCreateWindowSurface(this.a, eGLConfigArr[0], this.d, new int[]{12344}, 0);
                            a("eglCreateWindowSurface");
                            if (this.c != null) {
                                return;
                            }
                            throw new RuntimeException("surface was null");
                        }
                        throw new RuntimeException("null context");
                    }
                    throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
                }
                this.a = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            EGLDisplay eGLDisplay = this.a;
            EGLSurface eGLSurface = this.c;
            if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.b)) {
                return;
            }
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return EGL14.eglSwapBuffers(this.a, this.c);
        }
        return invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (EGL14.eglGetCurrentContext().equals(this.b)) {
                EGLDisplay eGLDisplay = this.a;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGL14.eglDestroySurface(this.a, this.c);
            EGL14.eglDestroyContext(this.a, this.b);
            this.d.release();
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
        }
    }

    public void e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            EGLExt.eglPresentationTimeANDROID(this.a, this.c, j);
        }
    }
}
