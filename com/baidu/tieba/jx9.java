package com.baidu.tieba;

import android.widget.MediaController;
import com.baidu.tieba.play.TbVideoViewContainer;
/* loaded from: classes6.dex */
public interface jx9 extends MediaController.MediaPlayerControl {
    void a(long j, long j2, long j3);

    int getCurrentPositionSync();

    int getPcdnState();

    void setLooping(boolean z);

    void setOnSurfaceDestroyedListener(TbVideoViewContainer.a aVar);

    void setOperableVideoContainer(dy9 dy9Var);

    void setPlayMode(String str);

    void setStageType(String str);

    void setVideoPath(String str, String str2);

    void setVideoStatData(yx9 yx9Var);

    void setVolume(float f, float f2);

    void stopPlayback();
}
