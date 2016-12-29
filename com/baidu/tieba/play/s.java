package com.baidu.tieba.play;

import android.view.View;
/* loaded from: classes.dex */
public interface s {
    int getCurrentPosition();

    String getPlayUrl();

    View getVideoContainer();

    boolean isPlayStarted();

    boolean isPlaying();

    void startPlay();

    void stopPlay();
}
