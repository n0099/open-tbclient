package com.baidu.tieba.recapp;

import android.view.View;
/* loaded from: classes.dex */
public interface r {
    void autoPlay(int i);

    long getCurrentPosition();

    int getHeight();

    void getLocationInWindow(int[] iArr);

    int getPlayStatus();

    String getPlayUrl();

    View getVideoContainer();

    boolean isPlayStarted();

    boolean isPlaying();

    void release();

    void startPlay();

    void stopPlay();
}
