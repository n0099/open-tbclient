package com.baidu.tieba;

import android.widget.MediaController;
import com.baidu.tieba.play.TbVideoViewContainer;
/* loaded from: classes5.dex */
public interface q88 extends MediaController.MediaPlayerControl {
    void a(long j, long j2, long j3);

    int getCurrentPositionSync();

    r88 getMediaProgressObserver();

    int getPcdnState();

    int getPlayerHeight();

    int getPlayerWidth();

    void setLooping(boolean z);

    void setOnSurfaceDestroyedListener(TbVideoViewContainer.a aVar);

    void setOperableVideoContainer(j98 j98Var);

    void setPlayMode(String str);

    void setStageType(String str);

    void setVideoPath(String str);

    void setVideoPath(String str, String str2);

    void setVideoStatData(e98 e98Var);

    void setVolume(float f, float f2);

    void stopPlayback();
}
