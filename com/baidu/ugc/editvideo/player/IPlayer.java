package com.baidu.ugc.editvideo.player;

import android.view.Surface;
import java.io.IOException;
import java.util.List;
/* loaded from: classes8.dex */
public interface IPlayer {

    /* loaded from: classes8.dex */
    public interface OnPlayerCompletionListener {
        void onCompletion(IPlayer iPlayer);
    }

    /* loaded from: classes8.dex */
    public interface OnPlayerErrorListener {
        boolean onError(IPlayer iPlayer, int i, int i2, Exception exc);
    }

    /* loaded from: classes8.dex */
    public interface OnPlayerInfoListener {
        boolean onInfo(IPlayer iPlayer, int i, int i2);
    }

    /* loaded from: classes8.dex */
    public interface OnPlayerPlayStateListener {
        public static final int STATE_PAUSE = 2;
        public static final int STATE_PLAY = 1;

        void onStateChange(IPlayer iPlayer, int i);
    }

    /* loaded from: classes8.dex */
    public interface OnPlayerPreparedListener {
        void onPrepared(IPlayer iPlayer);
    }

    /* loaded from: classes8.dex */
    public interface OnPlayerVideoSizeChangedListener {
        void onVideoSizeChanged(int i, int i2);
    }

    long getCurrentPosition();

    long getDuration();

    float getPlaybackSpeed();

    boolean isEnd();

    boolean isPlaying();

    void pause();

    void prepareAsync();

    void release();

    void reset();

    void seekTo(long j);

    void seekToEnd();

    void seekToForce(long j);

    void setAudioDataSource(List<AudioPlayData> list);

    void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    void setDataSource(List<VideoPlayData> list);

    void setLooping(boolean z);

    void setOnPlayerCompletionListener(OnPlayerCompletionListener onPlayerCompletionListener);

    void setOnPlayerErrorListener(OnPlayerErrorListener onPlayerErrorListener);

    void setOnPlayerInfoListener(OnPlayerInfoListener onPlayerInfoListener);

    void setOnPlayerPlayStateListener(OnPlayerPlayStateListener onPlayerPlayStateListener);

    void setOnPlayerPreparedListener(OnPlayerPreparedListener onPlayerPreparedListener);

    void setOnPlayerVideoSizeChangedListener(OnPlayerVideoSizeChangedListener onPlayerVideoSizeChangedListener);

    boolean setPlaybackSpeed(float f);

    void setSurface(Surface surface);

    void setVolume(float f, float f2);

    void start();

    void stop();
}
