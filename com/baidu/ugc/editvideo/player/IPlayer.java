package com.baidu.ugc.editvideo.player;

import android.view.Surface;
import java.io.IOException;
import java.util.List;
/* loaded from: classes13.dex */
public interface IPlayer {

    /* loaded from: classes13.dex */
    public interface OnPlayerCompletionListener {
        void onCompletion(IPlayer iPlayer);
    }

    /* loaded from: classes13.dex */
    public interface OnPlayerErrorListener {
        boolean onError(IPlayer iPlayer, int i2, int i3, Exception exc);
    }

    /* loaded from: classes13.dex */
    public interface OnPlayerInfoListener {
        boolean onInfo(IPlayer iPlayer, int i2, int i3);
    }

    /* loaded from: classes13.dex */
    public interface OnPlayerPlayStateListener {
        public static final int STATE_PAUSE = 2;
        public static final int STATE_PLAY = 1;

        void onStateChange(IPlayer iPlayer, int i2);
    }

    /* loaded from: classes13.dex */
    public interface OnPlayerPreparedListener {
        void onPrepared(IPlayer iPlayer);
    }

    /* loaded from: classes13.dex */
    public interface OnPlayerVideoSizeChangedListener {
        void onVideoSizeChanged(int i2, int i3);
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

    void seekTo(long j2);

    void seekToEnd();

    void seekToForce(long j2);

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

    boolean setPlaybackSpeed(float f2);

    void setSurface(Surface surface);

    void setVolume(float f2, float f3);

    void start();

    void stop();
}
