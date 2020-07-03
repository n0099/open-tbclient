package com.baidu.tieba.play.a;

import android.view.View;
import android.view.ViewParent;
import android.widget.MediaController;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.play.d;
import com.baidu.tieba.play.g;
/* loaded from: classes.dex */
public interface a extends MediaController.MediaPlayerControl {
    void a(TbVideoViewSet.a aVar);

    void b(TbVideoViewSet.a aVar);

    void cVp();

    void cVq();

    boolean cVr();

    void cVu();

    int getCurrentPositionSync();

    String getOriginUrl();

    ViewParent getParent();

    int getPcdnState();

    View getView();

    void h(long j, long j2, long j3);

    @Override // com.baidu.tieba.play.a.a
    boolean isPlaying();

    void setBusiness(d dVar);

    void setContinuePlayEnable(boolean z);

    void setFullScreenToDestroySurface();

    void setOnCompletionListener(g.a aVar);

    void setOnErrorListener(g.b bVar);

    void setOnOutInfoListener(g.e eVar);

    void setOnPreparedListener(g.f fVar);

    void setOnSeekCompleteListener(g.InterfaceC0721g interfaceC0721g);

    void setOnSurfaceDestroyedListener(QuickVideoView.b bVar);

    void setTryUseViewInSet(boolean z);

    void setVideoDuration(int i);

    void setVideoPath(String str, String str2);

    void setVolume(float f, float f2);

    void stop();

    void stopPlayback();
}
