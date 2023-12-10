package com.baidu.tieba.recapp.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.bja;
import com.baidu.tieba.cja;
import com.baidu.tieba.lha;
import com.baidu.tieba.recapp.lego.model.AdCard;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public interface IHomeAdVideoView extends lha {
    @Override // com.baidu.tieba.lha
    /* synthetic */ void autoPlay(int i);

    @Override // com.baidu.tieba.lha
    /* synthetic */ boolean canPlay();

    @Override // com.baidu.tieba.lha
    /* synthetic */ long getCurrentPosition();

    /* synthetic */ int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    /* synthetic */ void getLocationInWindow(int[] iArr);

    @Override // com.baidu.tieba.lha
    /* synthetic */ int getPlayStatus();

    @Override // com.baidu.tieba.lha
    /* synthetic */ String getPlayUrl();

    @Override // com.baidu.tieba.lha
    /* synthetic */ View getVideoContainer();

    @Override // com.baidu.tieba.lha
    /* synthetic */ boolean isPlayStarted();

    @Override // com.baidu.tieba.lha
    /* synthetic */ boolean isPlaying();

    int jump2DownloadDetailPage();

    @Override // com.baidu.tieba.lha
    /* synthetic */ void release();

    void setAdInfo(AdCard adCard);

    void setData(VideoInfo videoInfo, bja bjaVar, int i, int i2, int i3, int i4);

    void setMaskViewRadius(float[] fArr);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setPageContext(TbPageContext<?> tbPageContext);

    void setScheme(String str);

    void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str);

    void setVideoScalingMode(int i);

    void setVideoTailFrameData(cja cjaVar);

    @Override // com.baidu.tieba.lha
    /* synthetic */ void startPlay();

    @Override // com.baidu.tieba.lha
    /* synthetic */ void stopPlay();

    void updateTailFrameView(AdvertAppInfo advertAppInfo);
}
