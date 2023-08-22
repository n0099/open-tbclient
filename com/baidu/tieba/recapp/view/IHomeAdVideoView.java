package com.baidu.tieba.recapp.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.g1a;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.w2a;
import com.baidu.tieba.x2a;
import tbclient.VideoInfo;
/* loaded from: classes7.dex */
public interface IHomeAdVideoView extends g1a {
    @Override // com.baidu.tieba.g1a
    /* synthetic */ void autoPlay(int i);

    @Override // com.baidu.tieba.g1a
    /* synthetic */ boolean canPlay();

    @Override // com.baidu.tieba.g1a
    /* synthetic */ long getCurrentPosition();

    /* synthetic */ int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    /* synthetic */ void getLocationInWindow(int[] iArr);

    @Override // com.baidu.tieba.g1a
    /* synthetic */ int getPlayStatus();

    @Override // com.baidu.tieba.g1a
    /* synthetic */ String getPlayUrl();

    @Override // com.baidu.tieba.g1a
    /* synthetic */ View getVideoContainer();

    @Override // com.baidu.tieba.g1a
    /* synthetic */ boolean isPlayStarted();

    @Override // com.baidu.tieba.g1a
    /* synthetic */ boolean isPlaying();

    int jump2DownloadDetailPage();

    @Override // com.baidu.tieba.g1a
    /* synthetic */ void release();

    void setAdInfo(AdCard adCard);

    void setData(VideoInfo videoInfo, w2a w2aVar, int i, int i2, int i3, int i4);

    void setMaskViewRadius(float[] fArr);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setPageContext(TbPageContext<?> tbPageContext);

    void setScheme(String str);

    void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str);

    void setVideoScalingMode(int i);

    void setVideoTailFrameData(x2a x2aVar);

    @Override // com.baidu.tieba.g1a
    /* synthetic */ void startPlay();

    @Override // com.baidu.tieba.g1a
    /* synthetic */ void stopPlay();

    void updateTailFrameView(AdvertAppInfo advertAppInfo);
}
