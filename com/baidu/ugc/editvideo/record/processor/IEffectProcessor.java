package com.baidu.ugc.editvideo.record.processor;

import com.baidu.tieba.nf0;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread;
/* loaded from: classes7.dex */
public interface IEffectProcessor extends IMediaLifeCycleIncludeGlThread {
    int getOutputTextureMode();

    int onProcessFrame(nf0 nf0Var, int i, float[] fArr);

    void onSurfaceCreate(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2);

    void setGlClearColor(float f, float f2, float f3, float f4);

    void setInputTextureMode(int i);

    void setPreviewSize(int i, int i2);
}
