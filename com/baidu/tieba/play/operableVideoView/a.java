package com.baidu.tieba.play.operableVideoView;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.o;
/* loaded from: classes.dex */
public interface a extends View.OnClickListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnPreparedListener, TbCyberVideoView.a {
    void Gl(int i);

    void ac(View.OnClickListener onClickListener);

    void b(o oVar);

    void bLM();

    boolean diS();

    View dnv();

    boolean doh();

    int getCurrentPosition();

    boolean isFullScreen();

    boolean isPlaying();

    boolean pX(boolean z);

    void setAfterClickListener(View.OnClickListener onClickListener);

    void setData(bw bwVar);

    void setFrom(String str);

    void setStageType(String str);

    void setUniqueId(BdUniqueId bdUniqueId);

    void startPlay();

    void stopPlay();
}
