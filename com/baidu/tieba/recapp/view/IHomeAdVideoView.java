package com.baidu.tieba.recapp.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.repackage.lb8;
import com.repackage.mb8;
import com.repackage.z98;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public interface IHomeAdVideoView extends z98 {
    @Override // com.repackage.z98
    /* synthetic */ void autoPlay(int i);

    @Override // com.repackage.z98
    /* synthetic */ boolean canPlay();

    @Override // com.repackage.z98
    /* synthetic */ long getCurrentPosition();

    /* synthetic */ int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    /* synthetic */ void getLocationInWindow(int[] iArr);

    @Override // com.repackage.z98
    /* synthetic */ int getPlayStatus();

    @Override // com.repackage.z98
    /* synthetic */ String getPlayUrl();

    @Override // com.repackage.z98
    /* synthetic */ View getVideoContainer();

    @Override // com.repackage.z98
    /* synthetic */ boolean isPlayStarted();

    @Override // com.repackage.z98
    /* synthetic */ boolean isPlaying();

    int jump2DownloadDetailPage();

    @Override // com.repackage.z98
    /* synthetic */ void release();

    void setAdInfo(AdCard adCard);

    void setData(VideoInfo videoInfo, lb8 lb8Var, int i, int i2, int i3, int i4);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setPageContext(TbPageContext<?> tbPageContext);

    void setScheme(String str);

    void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str);

    void setVideoScalingMode(int i);

    void setVideoTailFrameData(mb8 mb8Var);

    @Override // com.repackage.z98
    /* synthetic */ void startPlay();

    @Override // com.repackage.z98
    /* synthetic */ void stopPlay();

    void updateTailFrameView(AdvertAppInfo advertAppInfo);
}
