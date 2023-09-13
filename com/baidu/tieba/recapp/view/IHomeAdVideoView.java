package com.baidu.tieba.recapp.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.n4a;
import com.baidu.tieba.o4a;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.x2a;
import tbclient.VideoInfo;
/* loaded from: classes7.dex */
public interface IHomeAdVideoView extends x2a {
    @Override // com.baidu.tieba.x2a
    /* synthetic */ void autoPlay(int i);

    @Override // com.baidu.tieba.x2a
    /* synthetic */ boolean canPlay();

    @Override // com.baidu.tieba.x2a
    /* synthetic */ long getCurrentPosition();

    /* synthetic */ int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    /* synthetic */ void getLocationInWindow(int[] iArr);

    @Override // com.baidu.tieba.x2a
    /* synthetic */ int getPlayStatus();

    @Override // com.baidu.tieba.x2a
    /* synthetic */ String getPlayUrl();

    @Override // com.baidu.tieba.x2a
    /* synthetic */ View getVideoContainer();

    @Override // com.baidu.tieba.x2a
    /* synthetic */ boolean isPlayStarted();

    @Override // com.baidu.tieba.x2a
    /* synthetic */ boolean isPlaying();

    int jump2DownloadDetailPage();

    @Override // com.baidu.tieba.x2a
    /* synthetic */ void release();

    void setAdInfo(AdCard adCard);

    void setData(VideoInfo videoInfo, n4a n4aVar, int i, int i2, int i3, int i4);

    void setMaskViewRadius(float[] fArr);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setPageContext(TbPageContext<?> tbPageContext);

    void setScheme(String str);

    void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str);

    void setVideoScalingMode(int i);

    void setVideoTailFrameData(o4a o4aVar);

    @Override // com.baidu.tieba.x2a
    /* synthetic */ void startPlay();

    @Override // com.baidu.tieba.x2a
    /* synthetic */ void stopPlay();

    void updateTailFrameView(AdvertAppInfo advertAppInfo);
}
