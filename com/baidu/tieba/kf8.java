package com.baidu.tieba;

import android.widget.MediaController;
import com.baidu.tieba.play.TbVideoViewContainer;
/* loaded from: classes5.dex */
public interface kf8 extends MediaController.MediaPlayerControl {
    void a(long j, long j2, long j3);

    int getCurrentPositionSync();

    lf8 getMediaProgressObserver();

    int getPcdnState();

    void setLooping(boolean z);

    void setOnSurfaceDestroyedListener(TbVideoViewContainer.a aVar);

    void setOperableVideoContainer(dg8 dg8Var);

    void setPlayMode(String str);

    void setStageType(String str);

    void setVideoPath(String str, String str2);

    void setVideoStatData(yf8 yf8Var);

    void setVolume(float f, float f2);

    void stopPlayback();
}
