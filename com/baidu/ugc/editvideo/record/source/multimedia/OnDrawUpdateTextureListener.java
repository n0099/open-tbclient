package com.baidu.ugc.editvideo.record.source.multimedia;

import android.graphics.SurfaceTexture;
import b.a.a0.b.a.e;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.record.processor.observer.EffectChangeObserver;
import com.baidu.ugc.editvideo.record.processor.observer.MediaTrackChangeObserver;
/* loaded from: classes10.dex */
public interface OnDrawUpdateTextureListener extends SurfaceTexture.OnFrameAvailableListener, EffectChangeObserver, MediaTrackChangeObserver {
    FullFrameRect getFullFrameRect2D();

    FullFrameRect getFullFrameRectEXT();

    e getVlogCore();

    void onDrawFrame(int i2, long j);

    void onSizeChange(int i2, int i3);

    void setUpdateTexture(int i2, float[] fArr, int i3);

    void setVideoRatio(float f2);

    void setVlogCore(e eVar);
}
