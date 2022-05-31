package com.baidu.tieba.recapp.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.repackage.g78;
import com.repackage.s88;
import com.repackage.t88;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public interface IHomeAdVideoView extends g78 {
    @Override // com.repackage.g78
    /* synthetic */ void autoPlay(int i);

    @Override // com.repackage.g78
    /* synthetic */ boolean canPlay();

    @Override // com.repackage.g78
    /* synthetic */ long getCurrentPosition();

    /* synthetic */ int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    /* synthetic */ void getLocationInWindow(int[] iArr);

    @Override // com.repackage.g78
    /* synthetic */ int getPlayStatus();

    @Override // com.repackage.g78
    /* synthetic */ String getPlayUrl();

    @Override // com.repackage.g78
    /* synthetic */ View getVideoContainer();

    @Override // com.repackage.g78
    /* synthetic */ boolean isPlayStarted();

    @Override // com.repackage.g78
    /* synthetic */ boolean isPlaying();

    int jump2DownloadDetailPage();

    @Override // com.repackage.g78
    /* synthetic */ void release();

    void setAdInfo(AdCard adCard);

    void setData(VideoInfo videoInfo, s88 s88Var, int i, int i2, int i3, int i4);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setPageContext(TbPageContext<?> tbPageContext);

    void setScheme(String str);

    void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str);

    void setVideoScalingMode(int i);

    void setVideoTailFrameData(t88 t88Var);

    @Override // com.repackage.g78
    /* synthetic */ void startPlay();

    @Override // com.repackage.g78
    /* synthetic */ void stopPlay();

    void updateTailFrameView(AdvertAppInfo advertAppInfo);
}
