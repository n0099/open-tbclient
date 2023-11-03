package com.baidu.ugc.editvideo.record.processor;

import com.baidu.tieba.gc0;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread;
/* loaded from: classes9.dex */
public interface IEffectProcessor extends IMediaLifeCycleIncludeGlThread {
    int getOutputTextureMode();

    int onProcessFrame(gc0 gc0Var, int i, float[] fArr);

    void onSurfaceCreate(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2);

    void setGlClearColor(float f, float f2, float f3, float f4);

    void setInputTextureMode(int i);

    void setPreviewSize(int i, int i2);
}
