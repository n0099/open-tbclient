package com.baidu.vi;

import android.media.MediaPlayer;
/* loaded from: classes26.dex */
public class AudioFilePlayer {

    /* renamed from: a  reason: collision with root package name */
    private MediaPlayer f3901a = new MediaPlayer();

    private AudioFilePlayer() {
    }

    private native boolean onErrorOccured(long j, int i);

    private native void onPlayCompleted(long j);
}
