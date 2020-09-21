package com.baidu.vi;

import android.media.MediaPlayer;
/* loaded from: classes3.dex */
public class AudioFilePlayer {
    private MediaPlayer a = new MediaPlayer();

    private AudioFilePlayer() {
    }

    private native boolean onErrorOccured(long j, int i);

    private native void onPlayCompleted(long j);
}
