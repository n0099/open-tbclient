package com.baidu.ugc.editvideo.record.preview;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import org.webrtc.EglBase10;
/* loaded from: classes7.dex */
public class MyEGLContextFactory implements GLSurfaceView.EGLContextFactory {
    public int EGL_CONTEXT_CLIENT_VERSION = EglBase10.EGL_CONTEXT_CLIENT_VERSION;
    public int mEGLContextClientVersion;

    public MyEGLContextFactory(int i) {
        this.mEGLContextClientVersion = 2;
        this.mEGLContextClientVersion = i;
    }

    @Override // android.opengl.GLSurfaceView.EGLContextFactory
    public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
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

    @Override // android.opengl.GLSurfaceView.EGLContextFactory
    public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
            return;
        }
        int eglGetError = egl10.eglGetError();
        throw new RuntimeException("eglDestroyContex failed: " + eglGetError);
    }

    public int getEglVersion() {
        return this.mEGLContextClientVersion;
    }
}
