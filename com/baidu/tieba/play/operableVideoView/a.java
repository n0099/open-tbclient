package com.baidu.tieba.play.operableVideoView;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.o;
/* loaded from: classes.dex */
public interface a extends View.OnClickListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnPreparedListener, TbCyberVideoView.a {
    void IG(int i);

    void ae(View.OnClickListener onClickListener);

    void b(o oVar);

    void bZk();

    View dBy();

    boolean dCk();

    boolean dwU();

    int getCurrentPosition();

    boolean isFullScreen();

    boolean isPlaying();

    void setAfterClickListener(View.OnClickListener onClickListener);

    void setData(bz bzVar);

    void setFrom(String str);

    void setStageType(String str);

    void setUniqueId(BdUniqueId bdUniqueId);

    boolean sg(boolean z);

    void startPlay();

    void stopPlay();
}
