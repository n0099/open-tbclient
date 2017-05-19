package com.baidu.tieba.recapp;

import android.view.View;
/* loaded from: classes.dex */
public interface q {
    long getCurrentPosition();

    String getPlayUrl();

    View getVideoContainer();

    boolean isPlayStarted();

    boolean isPlaying();

    void release();

    void startPlay();

    void stopPlay();
}
