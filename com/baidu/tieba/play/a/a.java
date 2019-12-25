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

    void a(String str, long j, long j2, long j3, long j4, long j5, String str2, int i);

    void b(TbVideoViewSet.a aVar);

    void cwi();

    boolean cwj();

    void cwm();

    int getCurrentPositionSync();

    String getOriginUrl();

    ViewParent getParent();

    View getView();

    @Override // com.baidu.tieba.play.a.a
    boolean isPlaying();

    void setBusiness(d dVar);

    void setContinuePlayEnable(boolean z);

    void setFullScreenToDestroySurface();

    void setOnCompletionListener(g.a aVar);

    void setOnErrorListener(g.b bVar);

    void setOnOutInfoListener(g.e eVar);

    void setOnPreparedListener(g.f fVar);

    void setOnSeekCompleteListener(g.InterfaceC0577g interfaceC0577g);

    void setOnSurfaceDestroyedListener(QuickVideoView.b bVar);

    void setPageTypeForPerfStat(String str);

    void setTryUseViewInSet(boolean z);

    void setVideoPath(String str, String str2);

    void setVolume(float f, float f2);

    void stop();

    void stopPlayback();
}
