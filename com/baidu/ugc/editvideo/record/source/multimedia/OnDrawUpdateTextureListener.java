package com.baidu.ugc.editvideo.record.source.multimedia;

import android.graphics.SurfaceTexture;
import com.baidu.tieba.nf0;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.record.processor.observer.EffectChangeObserver;
import com.baidu.ugc.editvideo.record.processor.observer.MediaTrackChangeObserver;
/* loaded from: classes7.dex */
public interface OnDrawUpdateTextureListener extends SurfaceTexture.OnFrameAvailableListener, EffectChangeObserver, MediaTrackChangeObserver {
    FullFrameRect getFullFrameRect2D();

    FullFrameRect getFullFrameRectEXT();

    nf0 getVlogCore();

    void onDrawFrame(int i, long j);

    void onSizeChange(int i, int i2);

    void setUpdateTexture(int i, float[] fArr, int i2);

    void setVideoRatio(float f);

    void setVlogCore(nf0 nf0Var);
}
