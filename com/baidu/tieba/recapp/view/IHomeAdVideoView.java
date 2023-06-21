package com.baidu.tieba.recapp.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.ep9;
import com.baidu.tieba.fp9;
import com.baidu.tieba.qn9;
import com.baidu.tieba.recapp.lego.model.AdCard;
import tbclient.VideoInfo;
/* loaded from: classes7.dex */
public interface IHomeAdVideoView extends qn9 {
    @Override // com.baidu.tieba.qn9
    /* synthetic */ void autoPlay(int i);

    @Override // com.baidu.tieba.qn9
    /* synthetic */ boolean canPlay();

    @Override // com.baidu.tieba.qn9
    /* synthetic */ long getCurrentPosition();

    /* synthetic */ int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    /* synthetic */ void getLocationInWindow(int[] iArr);

    @Override // com.baidu.tieba.qn9
    /* synthetic */ int getPlayStatus();

    @Override // com.baidu.tieba.qn9
    /* synthetic */ String getPlayUrl();

    @Override // com.baidu.tieba.qn9
    /* synthetic */ View getVideoContainer();

    @Override // com.baidu.tieba.qn9
    /* synthetic */ boolean isPlayStarted();

    @Override // com.baidu.tieba.qn9
    /* synthetic */ boolean isPlaying();

    int jump2DownloadDetailPage();

    @Override // com.baidu.tieba.qn9
    /* synthetic */ void release();

    void setAdInfo(AdCard adCard);

    void setData(VideoInfo videoInfo, ep9 ep9Var, int i, int i2, int i3, int i4);

    void setMaskViewRadius(float[] fArr);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setPageContext(TbPageContext<?> tbPageContext);

    void setScheme(String str);

    void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str);

    void setVideoScalingMode(int i);

    void setVideoTailFrameData(fp9 fp9Var);

    @Override // com.baidu.tieba.qn9
    /* synthetic */ void startPlay();

    @Override // com.baidu.tieba.qn9
    /* synthetic */ void stopPlay();

    void updateTailFrameView(AdvertAppInfo advertAppInfo);
}
