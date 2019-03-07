package com.baidu.tieba.play;

import android.view.View;
/* loaded from: classes.dex */
public interface f {
    int getCurrentPosition();

    String getPlayUrl();

    View getVideoContainer();

    boolean isFullScreen();

    boolean isPlayStarted();

    boolean isPlaying();

    void startPlay();

    void stopPlay();
}
