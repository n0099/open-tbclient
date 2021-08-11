package com.baidu.ugc.editvideo.record.source.multimedia;

import android.graphics.SurfaceTexture;
/* loaded from: classes8.dex */
public interface IVLogCommunicateProtocol {
    void setMultiMediaStateEventListener(MultiMediaStateEventListener multiMediaStateEventListener);

    void setMultiMediaTimelineUpdateListener(MultiMediaTimelineUpdateListener multiMediaTimelineUpdateListener, boolean z);

    void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener);

    void setPreRunnableTask(OnPreRunnableTask onPreRunnableTask);
}
