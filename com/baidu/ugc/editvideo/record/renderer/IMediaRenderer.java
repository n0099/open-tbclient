package com.baidu.ugc.editvideo.record.renderer;

import c.a.a0.b.a.e;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes8.dex */
public interface IMediaRenderer extends IMediaLifeCycleIncludeGlThread {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes8.dex */
    public @interface TextureMode {
        public static final int TEXTURE_MODE_2D = 1;
        public static final int TEXTURE_MODE_EXT = 0;
    }

    void onDrawFrame(e eVar, int i2, float[] fArr);

    void onGLLocation(GLViewPortLocation gLViewPortLocation);

    void onSurfaceChanged(GL10 gl10, int i2, int i3);

    void onSurfaceCreate(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2);

    void setEnable(boolean z);

    void setGlClearColor(float f2, float f3, float f4, float f5);

    void setPreviewSize(int i2, int i3);

    void setResolutionRatio(float f2);

    void setScaleAndTranslate(float f2, float f3, float f4, float f5);

    void setTextureMode(int i2);
}
