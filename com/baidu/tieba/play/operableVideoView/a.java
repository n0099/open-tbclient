package com.baidu.tieba.play.operableVideoView;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.v;
import com.baidu.tieba.play.z;
/* loaded from: classes.dex */
public interface a extends View.OnClickListener, QuickVideoView.b, g.a, g.b, g.e, g.f {
    void b(z zVar);

    View bSX();

    void bTX();

    void bTY();

    v bTx();

    int getCurrentPosition();

    boolean isFullScreen();

    boolean isPlaying();

    boolean kr(boolean z);

    boolean onBackPress();

    void setAfterClickListener(View.OnClickListener onClickListener);

    void setData(bg bgVar);

    void setFrom(String str);

    void setUniqueId(BdUniqueId bdUniqueId);

    void startPlay();

    void stopPlay();
}
