package com.baidu.tieba.recapp.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.repackage.aa8;
import com.repackage.mc8;
import com.repackage.nc8;
import com.repackage.xc7;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public interface IHomeAdVideoView extends aa8 {
    @Override // com.repackage.aa8
    /* synthetic */ void autoPlay(int i);

    @Override // com.repackage.aa8
    /* synthetic */ boolean canPlay();

    @Override // com.repackage.aa8
    /* synthetic */ long getCurrentPosition();

    /* synthetic */ int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    /* synthetic */ void getLocationInWindow(int[] iArr);

    @Override // com.repackage.aa8
    /* synthetic */ int getPlayStatus();

    @Override // com.repackage.aa8
    /* synthetic */ String getPlayUrl();

    @Override // com.repackage.aa8
    /* synthetic */ View getVideoContainer();

    @Override // com.repackage.aa8
    /* synthetic */ boolean isPlayStarted();

    @Override // com.repackage.aa8
    /* synthetic */ boolean isPlaying();

    int jump2DownloadDetailPage();

    @Override // com.repackage.aa8
    /* synthetic */ void release();

    void setAdInfo(AdCard adCard);

    void setData(VideoInfo videoInfo, mc8 mc8Var, int i, int i2, int i3, int i4);

    void setDownloadCallback(xc7 xc7Var);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setPageContext(TbPageContext<?> tbPageContext);

    void setScheme(String str);

    void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str);

    void setVideoScalingMode(int i);

    void setVideoTailFrameData(nc8 nc8Var);

    @Override // com.repackage.aa8
    /* synthetic */ void startPlay();

    @Override // com.repackage.aa8
    /* synthetic */ void stopPlay();

    void updateTailFrameView(AdvertAppInfo advertAppInfo);
}
