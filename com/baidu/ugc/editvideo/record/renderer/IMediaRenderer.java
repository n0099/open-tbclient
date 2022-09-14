package com.baidu.ugc.editvideo.record.renderer;

import com.baidu.tieba.rf0;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes6.dex */
public interface IMediaRenderer extends IMediaLifeCycleIncludeGlThread {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface TextureMode {
        public static final int TEXTURE_MODE_2D = 1;
        public static final int TEXTURE_MODE_EXT = 0;
    }

    void onDrawFrame(rf0 rf0Var, int i, float[] fArr);

    void onGLLocation(GLViewPortLocation gLViewPortLocation);

    void onSurfaceChanged(GL10 gl10, int i, int i2);

    void onSurfaceCreate(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2);

    void setEnable(boolean z);

    void setGlClearColor(float f, float f2, float f3, float f4);

    void setPreviewSize(int i, int i2);

    void setResolutionRatio(float f);

    void setScaleAndTranslate(float f, float f2, float f3, float f4);

    void setTextureMode(int i);
}
