package com.baidu.ugc.editvideo.faceunity.gles;

import android.graphics.SurfaceTexture;
import android.view.Surface;
/* loaded from: classes8.dex */
public class WindowSurface extends EglSurfaceBase {
    public boolean mReleaseSurface;
    public Surface mSurface;

    public WindowSurface(EglCore eglCore, SurfaceTexture surfaceTexture) {
        super(eglCore);
        createWindowSurface(surfaceTexture);
    }

    public WindowSurface(EglCore eglCore, Surface surface, boolean z) {
        super(eglCore);
        createWindowSurface(surface);
        this.mSurface = surface;
        this.mReleaseSurface = z;
    }

    public void recreate(EglCore eglCore) {
        Surface surface = this.mSurface;
        if (surface != null) {
            this.mEglCore = eglCore;
            createWindowSurface(surface);
            return;
        }
        throw new RuntimeException("not yet implemented for SurfaceTexture");
    }

    public void release() {
        releaseEglSurface();
        Surface surface = this.mSurface;
        if (surface != null) {
            if (this.mReleaseSurface) {
                surface.release();
            }
            this.mSurface = null;
        }
    }
}
