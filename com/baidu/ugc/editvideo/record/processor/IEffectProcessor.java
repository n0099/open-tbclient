package com.baidu.ugc.editvideo.record.processor;

import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread;
import d.a.a0.b.a.e;
/* loaded from: classes5.dex */
public interface IEffectProcessor extends IMediaLifeCycleIncludeGlThread {
    int getOutputTextureMode();

    int onProcessFrame(e eVar, int i2, float[] fArr);

    void onSurfaceCreate(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2);

    void setGlClearColor(float f2, float f3, float f4, float f5);

    void setInputTextureMode(int i2);

    void setPreviewSize(int i2, int i3);
}
