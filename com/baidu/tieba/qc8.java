package com.baidu.tieba;

import android.view.View;
/* loaded from: classes5.dex */
public interface qc8 {
    int getCurrentPosition();

    String getPlayUrl();

    View getVideoContainer();

    boolean isFullScreen();

    boolean isPlayStarted();

    boolean isPlaying();

    void startPlay();

    void stopPlay();
}
