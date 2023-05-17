package com.baidu.ugc.editvideo.editvideo.clip;

import android.os.Handler;
import com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
/* loaded from: classes8.dex */
public class OutputSurfaceWithoutFilter extends BaseOutputSurface {
    public OutputSurfaceWithoutFilter() {
        this(0, 0);
    }

    public OutputSurfaceWithoutFilter(int i, int i2) {
        this(i, i2, true);
    }

    public OutputSurfaceWithoutFilter(int i, int i2, boolean z) {
        if (z) {
            init(i, i2, false, null);
        }
    }

    public OutputSurfaceWithoutFilter(int i, int i2, boolean z, Handler handler) {
        init(i, i2, z, handler);
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface
    public void drawImage(int i) {
        super.drawImage(i);
        FullFrameRect fullFrameRect = this.mFullScreenEXT;
        if (fullFrameRect == null) {
            return;
        }
        fullFrameRect.drawFrame(this.mTextureId, this.mSTMatrix, this.mIsOffscreenRenderer);
    }

    public void setAngle(float f) {
        FullFrameRect fullFrameRect = this.mFullScreenEXT;
        if (fullFrameRect == null) {
            return;
        }
        fullFrameRect.setAngle(f);
    }

    public void setMirror(boolean z) {
        FullFrameRect fullFrameRect = this.mFullScreenEXT;
        if (fullFrameRect == null) {
            return;
        }
        fullFrameRect.setMirror(z);
    }

    public void setScale(float f, float f2) {
        FullFrameRect fullFrameRect = this.mFullScreenEXT;
        if (fullFrameRect == null) {
            return;
        }
        fullFrameRect.setScale(f, f2);
    }
}
