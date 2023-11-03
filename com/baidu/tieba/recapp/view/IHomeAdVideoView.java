package com.baidu.tieba.recapp.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.dea;
import com.baidu.tieba.eea;
import com.baidu.tieba.nca;
import com.baidu.tieba.recapp.lego.model.AdCard;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public interface IHomeAdVideoView extends nca {
    @Override // com.baidu.tieba.nca
    /* synthetic */ void autoPlay(int i);

    @Override // com.baidu.tieba.nca
    /* synthetic */ boolean canPlay();

    @Override // com.baidu.tieba.nca
    /* synthetic */ long getCurrentPosition();

    /* synthetic */ int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    /* synthetic */ void getLocationInWindow(int[] iArr);

    @Override // com.baidu.tieba.nca
    /* synthetic */ int getPlayStatus();

    @Override // com.baidu.tieba.nca
    /* synthetic */ String getPlayUrl();

    @Override // com.baidu.tieba.nca
    /* synthetic */ View getVideoContainer();

    @Override // com.baidu.tieba.nca
    /* synthetic */ boolean isPlayStarted();

    @Override // com.baidu.tieba.nca
    /* synthetic */ boolean isPlaying();

    int jump2DownloadDetailPage();

    @Override // com.baidu.tieba.nca
    /* synthetic */ void release();

    void setAdInfo(AdCard adCard);

    void setData(VideoInfo videoInfo, dea deaVar, int i, int i2, int i3, int i4);

    void setMaskViewRadius(float[] fArr);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setPageContext(TbPageContext<?> tbPageContext);

    void setScheme(String str);

    void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str);

    void setVideoScalingMode(int i);

    void setVideoTailFrameData(eea eeaVar);

    @Override // com.baidu.tieba.nca
    /* synthetic */ void startPlay();

    @Override // com.baidu.tieba.nca
    /* synthetic */ void stopPlay();

    void updateTailFrameView(AdvertAppInfo advertAppInfo);
}
