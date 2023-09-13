package com.baidu.tieba;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.play.TbVideoViewContainer;
/* loaded from: classes8.dex */
public interface uz9 extends View.OnClickListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnSeekCompleteListener, TbVideoViewContainer.a {
    void changeRenderViewMode(int i);

    int getCurrentPosition();

    View getMainView();

    boolean isFullScreen();

    boolean isPlaying();

    boolean onBackPress();

    boolean onBackground(boolean z);

    void onScroll();

    boolean onVolumeUp();

    void setAfterClickListener(View.OnClickListener onClickListener);

    void setData(ThreadData threadData);

    void setFrom(String str);

    void setJumpToPbClickListener(View.OnClickListener onClickListener);

    void setStageType(String str);

    void setStatistic(pz9 pz9Var);

    void setUniqueId(BdUniqueId bdUniqueId);

    void startPlay();

    void stopPlay();
}
