package com.baidu.tieba;

import android.view.View;
/* loaded from: classes8.dex */
public interface x2a {
    void autoPlay(int i);

    boolean canPlay();

    long getCurrentPosition();

    int getPlayStatus();

    String getPlayUrl();

    View getVideoContainer();

    boolean isPlayStarted();

    boolean isPlaying();

    void release();

    void startPlay();

    void stopPlay();
}
