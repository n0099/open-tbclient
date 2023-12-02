package com.baidu.tieba;

import android.view.View;
/* loaded from: classes7.dex */
public interface kha {
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
