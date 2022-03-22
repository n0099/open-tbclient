package com.baidu.ugc.editvideo.record.processor;

import c.a.z.b.a.e;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread;
/* loaded from: classes6.dex */
public interface IEffectProcessor extends IMediaLifeCycleIncludeGlThread {
    int getOutputTextureMode();

    int onProcessFrame(e eVar, int i, float[] fArr);

    void onSurfaceCreate(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2);

    void setGlClearColor(float f2, float f3, float f4, float f5);

    void setInputTextureMode(int i);

    void setPreviewSize(int i, int i2);
}
