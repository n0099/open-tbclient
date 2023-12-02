package com.baidu.tieba.recapp.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.aja;
import com.baidu.tieba.bja;
import com.baidu.tieba.kha;
import com.baidu.tieba.recapp.lego.model.AdCard;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public interface IHomeAdVideoView extends kha {
    @Override // com.baidu.tieba.kha
    /* synthetic */ void autoPlay(int i);

    @Override // com.baidu.tieba.kha
    /* synthetic */ boolean canPlay();

    @Override // com.baidu.tieba.kha
    /* synthetic */ long getCurrentPosition();

    /* synthetic */ int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    /* synthetic */ void getLocationInWindow(int[] iArr);

    @Override // com.baidu.tieba.kha
    /* synthetic */ int getPlayStatus();

    @Override // com.baidu.tieba.kha
    /* synthetic */ String getPlayUrl();

    @Override // com.baidu.tieba.kha
    /* synthetic */ View getVideoContainer();

    @Override // com.baidu.tieba.kha
    /* synthetic */ boolean isPlayStarted();

    @Override // com.baidu.tieba.kha
    /* synthetic */ boolean isPlaying();

    int jump2DownloadDetailPage();

    @Override // com.baidu.tieba.kha
    /* synthetic */ void release();

    void setAdInfo(AdCard adCard);

    void setData(VideoInfo videoInfo, aja ajaVar, int i, int i2, int i3, int i4);

    void setMaskViewRadius(float[] fArr);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setPageContext(TbPageContext<?> tbPageContext);

    void setScheme(String str);

    void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str);

    void setVideoScalingMode(int i);

    void setVideoTailFrameData(bja bjaVar);

    @Override // com.baidu.tieba.kha
    /* synthetic */ void startPlay();

    @Override // com.baidu.tieba.kha
    /* synthetic */ void stopPlay();

    void updateTailFrameView(AdvertAppInfo advertAppInfo);
}
