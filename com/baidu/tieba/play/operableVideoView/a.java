package com.baidu.tieba.play.operableVideoView;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.u;
import com.baidu.tieba.play.y;
/* loaded from: classes.dex */
public interface a extends View.OnClickListener, QuickVideoView.b, g.a, g.b, g.e, g.f {
    void aa(View.OnClickListener onClickListener);

    void bdd();

    void c(y yVar);

    boolean crr();

    View cvN();

    u cwu();

    int getCurrentPosition();

    boolean isFullScreen();

    boolean isPlaying();

    boolean my(boolean z);

    boolean onBackPress();

    void setAfterClickListener(View.OnClickListener onClickListener);

    void setData(bj bjVar);

    void setFrom(String str);

    void setUniqueId(BdUniqueId bdUniqueId);

    void startPlay();

    void stopPlay();
}
