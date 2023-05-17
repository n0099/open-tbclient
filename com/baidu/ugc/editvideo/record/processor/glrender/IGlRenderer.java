package com.baidu.ugc.editvideo.record.processor.glrender;

import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
/* loaded from: classes8.dex */
public interface IGlRenderer {
    void initProgram();

    void initProgram(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2);

    void onPreProcess();

    void onSizeChange(int i, int i2);

    void releaseProgram();
}
