package com.baidu.tieba.play.operableVideoView;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.o;
/* loaded from: classes.dex */
public interface a extends View.OnClickListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnPreparedListener, TbCyberVideoView.a {
    void Hr(int i);

    void ae(View.OnClickListener onClickListener);

    void b(o oVar);

    boolean dAA();

    boolean dvp();

    View dzP();

    int getCurrentPosition();

    boolean isFullScreen();

    boolean isPlaying();

    void onScroll();

    void setAfterClickListener(View.OnClickListener onClickListener);

    void setData(cb cbVar);

    void setFrom(String str);

    void setStageType(String str);

    void setUniqueId(BdUniqueId bdUniqueId);

    boolean sp(boolean z);

    void startPlay();

    void stopPlay();
}
