package com.baidu.ugc.editvideo.record.processor.glrender;

import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
/* loaded from: classes6.dex */
public interface IGlRenderer {
    void initProgram();

    void initProgram(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2);

    void onPreProcess();

    void onSizeChange(int i2, int i3);

    void releaseProgram();
}
