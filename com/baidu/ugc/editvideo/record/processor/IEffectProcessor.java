package com.baidu.ugc.editvideo.record.processor;

import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread;
import com.repackage.je0;
/* loaded from: classes4.dex */
public interface IEffectProcessor extends IMediaLifeCycleIncludeGlThread {
    int getOutputTextureMode();

    int onProcessFrame(je0 je0Var, int i, float[] fArr);

    void onSurfaceCreate(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2);

    void setGlClearColor(float f, float f2, float f3, float f4);

    void setInputTextureMode(int i);

    void setPreviewSize(int i, int i2);
}
