package com.baidu.ugc.editvideo.faceunity.gles;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.Build;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.mm9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
import org.webrtc.EglBase10;
@TargetApi(18)
/* loaded from: classes7.dex */
public final class EglCore {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final int FLAG_RECORDABLE = 1;
    public static final int FLAG_TRY_GLES3 = 2;
    public static final String TAG = "Grafika";
    public transient /* synthetic */ FieldHolder $fh;
    public EGLConfig mEGLConfig;
    public EGLContext mEGLContext;
    public EGLDisplay mEGLDisplay;
    public int mGlVersion;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EglCore() {
        this(null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((EGLContext) objArr[0], ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            EGLDisplay eGLDisplay = this.mEGLDisplay;
            if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
                EGL14.eglReleaseThread();
                EGL14.eglTerminate(this.mEGLDisplay);
            }
            this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
            this.mEGLContext = EGL14.EGL_NO_CONTEXT;
            this.mEGLConfig = null;
        }
    }

    public EglCore(EGLContext eGLContext, int i) {
        EGLConfig config;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eGLContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLDisplay = eGLDisplay;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
        this.mGlVersion = -1;
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.mEGLDisplay = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    if ((i & 2) != 0 && Build.VERSION.SDK_INT >= 23 && (config = getConfig(i, 3)) != null) {
                        EGLContext eglCreateContext = EGL14.eglCreateContext(this.mEGLDisplay, config, eGLContext, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 3, 12344}, 0);
                        if (EGL14.eglGetError() == 12288) {
                            this.mEGLConfig = config;
                            this.mEGLContext = eglCreateContext;
                            this.mGlVersion = 3;
                        }
                    }
                    if (this.mEGLContext == EGL14.EGL_NO_CONTEXT) {
                        EGLConfig config2 = getConfig(i, 2);
                        if (config2 != null) {
                            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.mEGLDisplay, config2, eGLContext, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
                            checkEglError("eglCreateContext");
                            this.mEGLConfig = config2;
                            this.mEGLContext = eglCreateContext2;
                            this.mGlVersion = 2;
                        } else {
                            throw new RuntimeException("Unable to find a suitable EGLConfig");
                        }
                    }
                    int[] iArr2 = new int[1];
                    EGL14.eglQueryContext(this.mEGLDisplay, this.mEGLContext, EglBase10.EGL_CONTEXT_CLIENT_VERSION, iArr2, 0);
                    mm9.c("Grafika", "EGLContext created, client version " + iArr2[0]);
                    return;
                }
                this.mEGLDisplay = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }
        throw new RuntimeException("EGL already set up");
    }

    private void checkEglError(String str) {
        int eglGetError;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, this, str) != null) || (eglGetError = EGL14.eglGetError()) == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    private EGLConfig getConfig(int i, int i2) {
        InterceptResult invokeII;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, this, i, i2)) == null) {
            if (i2 >= 3) {
                i3 = 68;
            } else {
                i3 = 4;
            }
            int[] iArr = {MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, 12322, 8, 12321, 8, 12352, i3, 12344, 0, 12344};
            if ((i & 1) != 0) {
                iArr[10] = 12610;
                iArr[11] = 1;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (!EGL14.eglChooseConfig(this.mEGLDisplay, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                mm9.l("Grafika", "unable to find RGB8888 / " + i2 + " EGLConfig");
                return null;
            }
            return eGLConfigArr[0];
        }
        return (EGLConfig) invokeII.objValue;
    }

    public static void logCurrent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            EGLDisplay eglGetCurrentDisplay = EGL14.eglGetCurrentDisplay();
            EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
            EGLSurface eglGetCurrentSurface = EGL14.eglGetCurrentSurface(12377);
            mm9.j("Grafika", "Current EGL (" + str + "): display=" + eglGetCurrentDisplay + ", context=" + eglGetCurrentContext + ", surface=" + eglGetCurrentSurface);
        }
    }

    public EGLSurface createWindowSurface(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
                throw new RuntimeException("invalid surface: " + obj);
            }
            EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, obj, new int[]{12344}, 0);
            checkEglError("eglCreateWindowSurface");
            if (eglCreateWindowSurface != null) {
                return eglCreateWindowSurface;
            }
            throw new RuntimeException("surface was null");
        }
        return (EGLSurface) invokeL.objValue;
    }

    public EGLSurface createOffscreenSurface(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[]{12375, i, 12374, i2, 12344}, 0);
            checkEglError("eglCreatePbufferSurface");
            if (eglCreatePbufferSurface != null) {
                return eglCreatePbufferSurface;
            }
            throw new RuntimeException("surface was null");
        }
        return (EGLSurface) invokeII.objValue;
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY) {
                    mm9.l("Grafika", "WARNING: EglCore was not explicitly released -- state may be leaked");
                    release();
                }
            } finally {
                super.finalize();
            }
        }
    }

    public int getGlVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mGlVersion;
        }
        return invokeV.intValue;
    }

    public void makeNothingCurrent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            EGLDisplay eGLDisplay = this.mEGLDisplay;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT)) {
                return;
            }
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public boolean isCurrent(EGLSurface eGLSurface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eGLSurface)) == null) {
            if (this.mEGLContext.equals(EGL14.eglGetCurrentContext()) && eGLSurface.equals(EGL14.eglGetCurrentSurface(12377))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void makeCurrent(EGLSurface eGLSurface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eGLSurface) == null) {
            if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
                mm9.c("Grafika", "NOTE: makeCurrent w/o display");
            }
            if (EGL14.eglMakeCurrent(this.mEGLDisplay, eGLSurface, eGLSurface, this.mEGLContext)) {
                return;
            }
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public String queryString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return EGL14.eglQueryString(this.mEGLDisplay, i);
        }
        return (String) invokeI.objValue;
    }

    public void releaseSurface(EGLSurface eGLSurface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eGLSurface) == null) {
            EGL14.eglDestroySurface(this.mEGLDisplay, eGLSurface);
        }
    }

    public boolean swapBuffers(EGLSurface eGLSurface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, eGLSurface)) == null) {
            return EGL14.eglSwapBuffers(this.mEGLDisplay, eGLSurface);
        }
        return invokeL.booleanValue;
    }

    public void makeCurrent(EGLSurface eGLSurface, EGLSurface eGLSurface2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, eGLSurface, eGLSurface2) == null) {
            if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
                mm9.c("Grafika", "NOTE: makeCurrent w/o display");
            }
            if (EGL14.eglMakeCurrent(this.mEGLDisplay, eGLSurface, eGLSurface2, this.mEGLContext)) {
                return;
            }
            throw new RuntimeException("eglMakeCurrent(draw,read) failed");
        }
    }

    public int querySurface(EGLSurface eGLSurface, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, eGLSurface, i)) == null) {
            int[] iArr = new int[1];
            EGL14.eglQuerySurface(this.mEGLDisplay, eGLSurface, i, iArr, 0);
            return iArr[0];
        }
        return invokeLI.intValue;
    }

    public void setPresentationTime(EGLSurface eGLSurface, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048588, this, eGLSurface, j) == null) {
            EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, eGLSurface, j);
        }
    }
}
