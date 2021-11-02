package com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.ugc.editvideo.player.IPlayer;
import com.baidu.ugc.editvideo.player.VideoPlayData;
import com.baidu.ugc.editvideo.record.source.MediaInfo;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public interface IMediaPlayer extends IPlayer {
    public static final int MEDIA_ERROR_IO = -1004;
    public static final int MEDIA_ERROR_MALFORMED = -1007;
    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    public static final int MEDIA_ERROR_SERVER_DIED = 100;
    public static final int MEDIA_ERROR_TIMED_OUT = -110;
    public static final int MEDIA_ERROR_UNKNOWN = 1;
    public static final int MEDIA_ERROR_UNSUPPORTED = -1010;
    public static final int MEDIA_INFO_AUDIO_DECODED_START = 10003;
    public static final int MEDIA_INFO_AUDIO_RENDERING_START = 10002;
    public static final int MEDIA_INFO_AUDIO_SEEK_RENDERING_START = 10009;
    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_COMPONENT_OPEN = 10007;
    public static final int MEDIA_INFO_FIND_STREAM_INFO = 10006;
    public static final int MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE = 10100;
    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
    public static final int MEDIA_INFO_NETWORK_BANDWIDTH = 703;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_OPEN_INPUT = 10005;
    public static final int MEDIA_INFO_STARTED_AS_NEXT = 2;
    public static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902;
    public static final int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
    public static final int MEDIA_INFO_UNKNOWN = 1;
    public static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901;
    public static final int MEDIA_INFO_VIDEO_DECODED_START = 10004;
    public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    public static final int MEDIA_INFO_VIDEO_ROTATION_CHANGED = 10001;
    public static final int MEDIA_INFO_VIDEO_SEEK_RENDERING_START = 10008;
    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
    public static final int SHARED_PLAYER_ON_INFO_EXTRA = -666;
    public static final int STATE_BUFFERING = 2;
    public static final int STATE_ENDED = 4;
    public static final int STATE_GOT_SOURCE = 9161;
    public static final int STATE_IDLE = 1;
    public static final int STATE_READY = 3;

    /* loaded from: classes10.dex */
    public interface Listener {
        void onBufferingUpdate(int i2);

        int onCompletion();

        boolean onError(int i2, int i3, Exception exc);

        boolean onInfo(int i2, int i3);

        void onPrepared();

        void onSeekComplete();

        void onStateChanged(int i2);

        void onVideoSizeChanged(int i2, int i3, int i4, float f2);
    }

    /* loaded from: classes10.dex */
    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i2);
    }

    /* loaded from: classes10.dex */
    public interface OnCompletionListener {
        void onCompletion(IMediaPlayer iMediaPlayer);
    }

    /* loaded from: classes10.dex */
    public interface OnErrorListener {
        boolean onError(IMediaPlayer iMediaPlayer, int i2, int i3);
    }

    /* loaded from: classes10.dex */
    public interface OnInfoListener {
        boolean onInfo(IMediaPlayer iMediaPlayer, int i2, int i3);
    }

    /* loaded from: classes10.dex */
    public interface OnLoopingListener {
        void onLoop();
    }

    /* loaded from: classes10.dex */
    public interface OnOverMaxSizeListener {
        void overMaxSize();
    }

    /* loaded from: classes10.dex */
    public interface OnPreparedListener {
        void onPrepared(IMediaPlayer iMediaPlayer);
    }

    /* loaded from: classes10.dex */
    public interface OnSeekCompleteListener {
        void onSeekComplete(IMediaPlayer iMediaPlayer);
    }

    /* loaded from: classes10.dex */
    public interface OnSpeedChangeListener {
        void onSpeedChange(float f2);
    }

    /* loaded from: classes10.dex */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i2, int i3, int i4, int i5);
    }

    int getAudioSessionId();

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    long getCurrentPosition();

    String getDataSource();

    Uri getDataSourceUri();

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    long getDuration();

    MediaInfo getMediaInfo();

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    float getPlaybackSpeed();

    int getPlaybackState();

    String getUniqueID();

    int getVideoSarDen();

    int getVideoSarNum();

    float getVolume();

    boolean isLooping();

    @Deprecated
    boolean isPlayable();

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    boolean isPlaying();

    boolean isValid();

    void overMaxSize();

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    void pause() throws IllegalStateException;

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    void prepareAsync() throws IllegalStateException;

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    void release();

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    void reset();

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    void seekTo(long j) throws IllegalStateException;

    void setAudioStreamType(int i2);

    void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    @TargetApi(14)
    void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException;

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    void setDataSource(List<VideoPlayData> list);

    void setDisplay(SurfaceHolder surfaceHolder);

    void setListener(Listener listener);

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    void setLooping(boolean z);

    void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnLoopingListener(OnLoopingListener onLoopingListener);

    void setOnOverMaxSizeListener(OnOverMaxSizeListener onOverMaxSizeListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setOnSpeedChangeListener(OnSpeedChangeListener onSpeedChangeListener);

    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    boolean setPlaybackSpeed(float f2);

    void setScreenOnWhilePlaying(boolean z);

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    void setSurface(Surface surface);

    void setVolume(float f2);

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    void setVolume(float f2, float f3);

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    void start() throws IllegalStateException;

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    void stop() throws IllegalStateException;
}
