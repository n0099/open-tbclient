package com.baidu.tieba.play.operableVideoView;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.u;
import com.baidu.tieba.play.y;
/* loaded from: classes.dex */
public interface a extends View.OnClickListener, QuickVideoView.b, g.a, g.b, g.e, g.f {
    void aa(View.OnClickListener onClickListener);

    void buU();

    void c(y yVar);

    boolean cLS();

    u cQV();

    View cQn();

    boolean cRz();

    int getCurrentPosition();

    boolean isFullScreen();

    boolean isPlaying();

    boolean or(boolean z);

    void setAfterClickListener(View.OnClickListener onClickListener);

    void setData(bk bkVar);

    void setFrom(String str);

    void setUniqueId(BdUniqueId bdUniqueId);

    void startPlay();

    void stopPlay();
}
