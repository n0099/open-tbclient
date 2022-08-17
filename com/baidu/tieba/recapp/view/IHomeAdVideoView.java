package com.baidu.tieba.recapp.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.repackage.ad8;
import com.repackage.bd8;
import com.repackage.ob8;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public interface IHomeAdVideoView extends ob8 {
    @Override // com.repackage.ob8
    /* synthetic */ void autoPlay(int i);

    @Override // com.repackage.ob8
    /* synthetic */ boolean canPlay();

    @Override // com.repackage.ob8
    /* synthetic */ long getCurrentPosition();

    /* synthetic */ int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    /* synthetic */ void getLocationInWindow(int[] iArr);

    @Override // com.repackage.ob8
    /* synthetic */ int getPlayStatus();

    @Override // com.repackage.ob8
    /* synthetic */ String getPlayUrl();

    @Override // com.repackage.ob8
    /* synthetic */ View getVideoContainer();

    @Override // com.repackage.ob8
    /* synthetic */ boolean isPlayStarted();

    @Override // com.repackage.ob8
    /* synthetic */ boolean isPlaying();

    int jump2DownloadDetailPage();

    @Override // com.repackage.ob8
    /* synthetic */ void release();

    void setAdInfo(AdCard adCard);

    void setData(VideoInfo videoInfo, ad8 ad8Var, int i, int i2, int i3, int i4);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setPageContext(TbPageContext<?> tbPageContext);

    void setScheme(String str);

    void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str);

    void setVideoScalingMode(int i);

    void setVideoTailFrameData(bd8 bd8Var);

    @Override // com.repackage.ob8
    /* synthetic */ void startPlay();

    @Override // com.repackage.ob8
    /* synthetic */ void stopPlay();

    void updateTailFrameView(AdvertAppInfo advertAppInfo);
}
