package com.baidu.tieba.recapp.view;

import android.view.View;
import android.view.ViewGroup;
import c.a.p0.b2.o.c;
import c.a.p0.l3.j0.b.g;
import c.a.p0.l3.j0.b.h;
import c.a.p0.l3.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public interface IHomeAdVideoView extends n {
    @Override // c.a.p0.l3.n
    /* synthetic */ void autoPlay(int i);

    @Override // c.a.p0.l3.n
    /* synthetic */ boolean canPlay();

    @Override // c.a.p0.l3.n
    /* synthetic */ long getCurrentPosition();

    /* synthetic */ int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    /* synthetic */ void getLocationInWindow(int[] iArr);

    @Override // c.a.p0.l3.n
    /* synthetic */ int getPlayStatus();

    @Override // c.a.p0.l3.n
    /* synthetic */ String getPlayUrl();

    @Override // c.a.p0.l3.n
    /* synthetic */ View getVideoContainer();

    @Override // c.a.p0.l3.n
    /* synthetic */ boolean isPlayStarted();

    @Override // c.a.p0.l3.n
    /* synthetic */ boolean isPlaying();

    int jump2DownloadDetailPage();

    @Override // c.a.p0.l3.n
    /* synthetic */ void release();

    void setAdInfo(AdCard adCard);

    void setData(VideoInfo videoInfo, g gVar, int i, int i2, int i3, int i4);

    void setDownloadCallback(c cVar);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setPageContext(TbPageContext<?> tbPageContext);

    void setScheme(String str);

    void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str);

    void setVideoScalingMode(int i);

    void setVideoTailFrameData(h hVar);

    @Override // c.a.p0.l3.n
    /* synthetic */ void startPlay();

    @Override // c.a.p0.l3.n
    /* synthetic */ void stopPlay();

    void updateTailFrameView(AdvertAppInfo advertAppInfo);
}
