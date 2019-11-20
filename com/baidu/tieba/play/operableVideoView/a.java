package com.baidu.tieba.play.operableVideoView;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.v;
import com.baidu.tieba.play.z;
/* loaded from: classes.dex */
public interface a extends View.OnClickListener, QuickVideoView.b, g.a, g.b, g.e, g.f {
    void aLU();

    void c(z zVar);

    View cbV();

    void ccV();

    v ccw();

    int getCurrentPosition();

    boolean isFullScreen();

    boolean isPlaying();

    boolean ll(boolean z);

    boolean onBackPress();

    void setAfterClickListener(View.OnClickListener onClickListener);

    void setData(bh bhVar);

    void setFrom(String str);

    void setUniqueId(BdUniqueId bdUniqueId);

    void startPlay();

    void stopPlay();
}
