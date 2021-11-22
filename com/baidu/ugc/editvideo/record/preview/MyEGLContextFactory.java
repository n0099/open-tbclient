package com.baidu.ugc.editvideo.record.preview;

import android.opengl.GLSurfaceView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import org.webrtc.EglBase10;
/* loaded from: classes10.dex */
public class MyEGLContextFactory implements GLSurfaceView.EGLContextFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int EGL_CONTEXT_CLIENT_VERSION;
    public int mEGLContextClientVersion;

    public MyEGLContextFactory(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.EGL_CONTEXT_CLIENT_VERSION = EglBase10.EGL_CONTEXT_CLIENT_VERSION;
        this.mEGLContextClientVersion = 2;
        this.mEGLContextClientVersion = i2;
    }

    @Override // android.opengl.GLSurfaceView.EGLContextFactory
    public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, egl10, eGLDisplay, eGLConfig)) == null) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, this.mEGLContextClientVersion, 12344};
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, iArr);
            if (this.mEGLContextClientVersion != 2) {
                if (eglCreateContext == null || eglCreateContext == EGL10.EGL_NO_CONTEXT) {
                    this.mEGLContextClientVersion = 2;
                    iArr[1] = 2;
                    return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, iArr);
                }
                return eglCreateContext;
            }
            return eglCreateContext;
        }
        return (EGLContext) invokeLLL.objValue;
    }

    @Override // android.opengl.GLSurfaceView.EGLContextFactory
    public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, egl10, eGLDisplay, eGLContext) == null) || egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
            return;
        }
        int eglGetError = egl10.eglGetError();
        throw new RuntimeException("eglDestroyContex failed: " + eglGetError);
    }

    public int getEglVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mEGLContextClientVersion : invokeV.intValue;
    }
}
