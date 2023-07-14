package com.baidu.tieba;

import android.view.View;
/* loaded from: classes6.dex */
public interface iu9 {
    int getCurrentPosition();

    String getPlayUrl();

    View getVideoContainer();

    boolean isFullScreen();

    boolean isPlayStarted();

    boolean isPlaying();

    void startPlay();

    void stopPlay();
}
