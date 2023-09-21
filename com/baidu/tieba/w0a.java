package com.baidu.tieba;

import android.view.View;
/* loaded from: classes8.dex */
public interface w0a {
    int getCurrentPosition();

    String getPlayUrl();

    View getVideoContainer();

    boolean isFullScreen();

    boolean isPlayStarted();

    boolean isPlaying();

    void startPlay();

    void stopPlay();
}
