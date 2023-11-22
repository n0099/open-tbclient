package com.baidu.tieba.recapp.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.eea;
import com.baidu.tieba.fea;
import com.baidu.tieba.oca;
import com.baidu.tieba.recapp.lego.model.AdCard;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public interface IHomeAdVideoView extends oca {
    @Override // com.baidu.tieba.oca
    /* synthetic */ void autoPlay(int i);

    @Override // com.baidu.tieba.oca
    /* synthetic */ boolean canPlay();

    @Override // com.baidu.tieba.oca
    /* synthetic */ long getCurrentPosition();

    /* synthetic */ int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    /* synthetic */ void getLocationInWindow(int[] iArr);

    @Override // com.baidu.tieba.oca
    /* synthetic */ int getPlayStatus();

    @Override // com.baidu.tieba.oca
    /* synthetic */ String getPlayUrl();

    @Override // com.baidu.tieba.oca
    /* synthetic */ View getVideoContainer();

    @Override // com.baidu.tieba.oca
    /* synthetic */ boolean isPlayStarted();

    @Override // com.baidu.tieba.oca
    /* synthetic */ boolean isPlaying();

    int jump2DownloadDetailPage();

    @Override // com.baidu.tieba.oca
    /* synthetic */ void release();

    void setAdInfo(AdCard adCard);

    void setData(VideoInfo videoInfo, eea eeaVar, int i, int i2, int i3, int i4);

    void setMaskViewRadius(float[] fArr);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setPageContext(TbPageContext<?> tbPageContext);

    void setScheme(String str);

    void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str);

    void setVideoScalingMode(int i);

    void setVideoTailFrameData(fea feaVar);

    @Override // com.baidu.tieba.oca
    /* synthetic */ void startPlay();

    @Override // com.baidu.tieba.oca
    /* synthetic */ void stopPlay();

    void updateTailFrameView(AdvertAppInfo advertAppInfo);
}
