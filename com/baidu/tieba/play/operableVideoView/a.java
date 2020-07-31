package com.baidu.tieba.play.operableVideoView;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.o;
/* loaded from: classes.dex */
public interface a extends View.OnClickListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnPreparedListener, TbCyberVideoView.a {
    void Dp(int i);

    void ab(View.OnClickListener onClickListener);

    void b(o oVar);

    void bBh();

    boolean cUq();

    View cYJ();

    boolean cZt();

    int getCurrentPosition();

    boolean isFullScreen();

    boolean isPlaying();

    boolean ph(boolean z);

    void setAfterClickListener(View.OnClickListener onClickListener);

    void setData(bv bvVar);

    void setFrom(String str);

    void setUniqueId(BdUniqueId bdUniqueId);

    void startPlay();

    void stopPlay();
}
