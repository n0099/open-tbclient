package com.baidu.tieba;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
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
import com.yy.transvod.player.log.TLog;
import java.util.concurrent.atomic.AtomicBoolean;
@TargetApi(17)
/* loaded from: classes8.dex */
public final class xjb implements ekb {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] g;
    public static final int[] h;
    public static final int[] i;
    public static final int[] j;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicBoolean a;
    public EGLDisplay b;
    public EGLContext c;
    public EGLSurface d;
    public EGLSurface e;
    public EGLConfig f;

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948303705, "Lcom/baidu/tieba/xjb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948303705, "Lcom/baidu/tieba/xjb;");
                return;
            }
        }
        g = new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, 12322, 8, 12321, 8, 12352, 4, 12344};
        h = new int[]{12440, 2, 12344};
        i = new int[]{12375, 1, 12374, 1, 12417, 12380, 12416, 12380, 12344};
        j = new int[]{12344};
    }

    @Override // com.baidu.tieba.ekb
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            TLog.g(this, "EglCore.release enter.");
            b(0, false);
            EGLDisplay eGLDisplay = this.b;
            if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
                EGLContext eGLContext = this.c;
                if (eGLContext != EGL14.EGL_NO_CONTEXT) {
                    EGL14.eglDestroyContext(eGLDisplay, eGLContext);
                }
                EGLSurface eGLSurface = this.d;
                if (eGLSurface != EGL14.EGL_NO_SURFACE) {
                    EGL14.eglDestroySurface(this.b, eGLSurface);
                }
                EGLSurface eGLSurface2 = this.e;
                if (eGLSurface2 != EGL14.EGL_NO_SURFACE) {
                    EGL14.eglDestroySurface(this.b, eGLSurface2);
                    TLog.g(this, "EglCore.release offscreen surface.");
                }
                if (i()) {
                    EGL14.eglReleaseThread();
                }
                EGL14.eglTerminate(this.b);
            }
            this.f = null;
            this.b = EGL14.EGL_NO_DISPLAY;
            this.c = EGL14.EGL_NO_CONTEXT;
            EGLSurface eGLSurface3 = EGL14.EGL_NO_SURFACE;
            this.d = eGLSurface3;
            this.e = eGLSurface3;
            this.a.set(false);
            TLog.g(this, "EglCore.release leave.");
        }
    }

    public xjb() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new AtomicBoolean(false);
        this.b = EGL14.EGL_NO_DISPLAY;
        this.c = EGL14.EGL_NO_CONTEXT;
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        this.d = eGLSurface;
        this.e = eGLSurface;
        this.f = null;
    }

    @Override // com.baidu.tieba.ekb
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.b != EGL14.EGL_NO_DISPLAY && this.c != EGL14.EGL_NO_CONTEXT) {
                TLog.g(this, "already created.");
                return;
            }
            TLog.g(this, "EglCore.setup enter.");
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.b = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                TLog.g(this, "EGL14.eglGetDisplay() = " + this.b);
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(this.b, iArr, 0, iArr, 1)) {
                    TLog.g(this, String.format("EGLDisplay.majoy:%d, EGLDisplay.minor:%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1])));
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    EGL14.eglChooseConfig(this.b, g, 0, eGLConfigArr, 0, 1, new int[1], 0);
                    EGLConfig eGLConfig = eGLConfigArr[0];
                    this.f = eGLConfig;
                    EGLContext eglCreateContext = EGL14.eglCreateContext(this.b, eGLConfig, EGL14.eglGetCurrentContext(), h, 0);
                    this.c = eglCreateContext;
                    if (eglCreateContext != EGL14.EGL_NO_CONTEXT) {
                        TLog.g(this, "EGL14.eglCreateContext() = " + this.c);
                        EGL14.eglQueryContext(this.b, this.c, 12440, iArr, 0);
                        TLog.g(this, String.format("EGLContext.version:%d", Integer.valueOf(iArr[0])));
                        TLog.g(this, "EglCore.setup leave.");
                        return;
                    }
                    throw new RuntimeException(String.format("EGL14.eglCreateContext() failed. eglGetError() = 0x%04x", Integer.valueOf(EGL14.eglGetError())));
                }
                this.b = EGL14.EGL_NO_DISPLAY;
                throw new RuntimeException(String.format("EGL14.eglInitialize() failed. eglGetError() = 0x%04x", Integer.valueOf(EGL14.eglGetError())));
            }
            throw new RuntimeException(String.format("EGL14.eglGetDisplay() failed. eglGetError() = 0x%04x", Integer.valueOf(EGL14.eglGetError())));
        }
    }

    @Override // com.baidu.tieba.ekb
    public boolean available() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a.get();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ekb
    public int c() {
        InterceptResult invokeV;
        EGLSurface eGLSurface;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int[] iArr = new int[1];
            EGLDisplay eGLDisplay = this.b;
            if (eGLDisplay == EGL14.EGL_NO_DISPLAY || (eGLSurface = this.d) == EGL14.EGL_NO_SURFACE || !EGL14.eglQuerySurface(eGLDisplay, eGLSurface, 12374, iArr, 0)) {
                return 0;
            }
            return iArr[0];
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ekb
    public int f() {
        InterceptResult invokeV;
        EGLSurface eGLSurface;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int[] iArr = new int[1];
            EGLDisplay eGLDisplay = this.b;
            if (eGLDisplay == EGL14.EGL_NO_DISPLAY || (eGLSurface = this.d) == EGL14.EGL_NO_SURFACE || !EGL14.eglQuerySurface(eGLDisplay, eGLSurface, 12375, iArr, 0)) {
                return 0;
            }
            return iArr[0];
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ekb
    public boolean swapBuffer() {
        InterceptResult invokeV;
        EGLSurface eGLSurface;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            EGLDisplay eGLDisplay = this.b;
            if (eGLDisplay != EGL14.EGL_NO_DISPLAY && (eGLSurface = this.d) != EGL14.EGL_NO_SURFACE) {
                return EGL14.eglSwapBuffers(eGLDisplay, eGLSurface);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ekb
    public boolean b(int i2, boolean z) {
        InterceptResult invokeCommon;
        EGLContext eGLContext;
        int eglGetError;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (this.b == EGL14.EGL_NO_DISPLAY) {
                return false;
            }
            EGLSurface g2 = g(i2);
            if (z) {
                eGLContext = this.c;
            } else {
                eGLContext = EGL14.EGL_NO_CONTEXT;
            }
            if (g2 == EGL14.EGL_NO_SURFACE && eGLContext != EGL14.EGL_NO_CONTEXT) {
                return true;
            }
            boolean eglMakeCurrent = EGL14.eglMakeCurrent(this.b, g2, g2, eGLContext);
            if (!eglMakeCurrent && (eglGetError = EGL14.eglGetError()) != 12288) {
                TLog.c(this, String.format("EGL14.eglMakeCurrent() failed. eglGetError() = 0x%04x", Integer.valueOf(eglGetError)) + " bindSurfaceType=" + i2);
            }
            return eglMakeCurrent;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tieba.ekb
    public void d(boolean z) {
        EGLSurface eGLSurface;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            TLog.g(this, "EglCore.destroySurface enter, windowSurface: " + z);
            if (z) {
                eGLSurface = this.d;
            } else {
                eGLSurface = this.e;
            }
            if (z) {
                this.a.set(false);
            }
            b(0, true);
            EGLDisplay eGLDisplay = this.b;
            if (eGLDisplay != EGL14.EGL_NO_DISPLAY && eGLSurface != EGL14.EGL_NO_SURFACE) {
                EGL14.eglDestroySurface(eGLDisplay, eGLSurface);
                if (z) {
                    this.d = EGL14.EGL_NO_SURFACE;
                } else {
                    this.e = EGL14.EGL_NO_SURFACE;
                }
            }
            TLog.g(this, "EglCore.destroySurface  leave.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x007d, code lost:
        if (r6.d != android.opengl.EGL14.EGL_NO_SURFACE) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007f, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c4, code lost:
        if (r6.e != android.opengl.EGL14.EGL_NO_SURFACE) goto L17;
     */
    @Override // com.baidu.tieba.ekb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(Object obj) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("EglCore.createSurface enter: ");
            boolean z = false;
            if (obj != null) {
                i2 = obj.hashCode();
            } else {
                i2 = 0;
            }
            sb.append(i2);
            TLog.g(this, sb.toString());
            if (this.b != EGL14.EGL_NO_DISPLAY && this.f != null) {
                if (obj != null) {
                    try {
                        if (h(obj)) {
                            EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.b, this.f, obj, j, 0);
                            this.d = eglCreateWindowSurface;
                            if (eglCreateWindowSurface == EGL14.EGL_NO_SURFACE) {
                                TLog.c(this, String.format("EGL14.eglCreateWindowSurface() failed. eglGetError() = 0x%04x", Integer.valueOf(EGL14.eglGetError())));
                            }
                            TLog.g(this, "EGL14.eglCreateWindowSurface() = " + this.d);
                            this.a.set(b(1, true));
                        }
                    } catch (Exception e) {
                        TLog.g(this, "EGL14.eglCreateWindowSurface() = " + e.toString());
                    }
                }
                EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.b, this.f, i, 0);
                this.e = eglCreatePbufferSurface;
                if (eglCreatePbufferSurface == EGL14.EGL_NO_SURFACE) {
                    TLog.c(this, String.format("EGL14.eglCreatePbufferSurface() failed. eglGetError() = 0x%04x", Integer.valueOf(EGL14.eglGetError())));
                }
                b(2, true);
                TLog.g(this, "EGL14.eglCreatePbufferSurface() = " + this.e);
            }
            TLog.g(this, "EglCore.createSurface leave.");
            return z;
        }
        return invokeL.booleanValue;
    }

    public final EGLSurface g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            if (i2 == 1) {
                return this.d;
            }
            if (i2 == 2) {
                return this.e;
            }
            return eGLSurface;
        }
        return (EGLSurface) invokeI.objValue;
    }

    public boolean h(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj instanceof SurfaceHolder) {
                return ((SurfaceHolder) obj).getSurface().isValid();
            }
            if (obj instanceof SurfaceView) {
                return ((SurfaceView) obj).getHolder().getSurface().isValid();
            }
            if (obj instanceof Surface) {
                return ((Surface) obj).isValid();
            }
            TLog.c(this, "param surface is invalid.");
            return false;
        }
        return invokeL.booleanValue;
    }
}
