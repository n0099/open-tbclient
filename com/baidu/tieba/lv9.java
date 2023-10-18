package com.baidu.tieba;

import android.widget.MediaController;
import com.baidu.tieba.play.TbVideoViewContainer;
/* loaded from: classes7.dex */
public interface lv9 extends MediaController.MediaPlayerControl {
    void a(long j, long j2, long j3);

    int getCurrentPositionSync();

    int getPcdnState();

    void setLooping(boolean z);

    void setOnSurfaceDestroyedListener(TbVideoViewContainer.a aVar);

    void setOperableVideoContainer(fw9 fw9Var);

    void setPlayMode(String str);

    void setStageType(String str);

    void setVideoPath(String str, String str2);

    void setVideoStatData(aw9 aw9Var);

    void setVolume(float f, float f2);

    void stopPlayback();
}
