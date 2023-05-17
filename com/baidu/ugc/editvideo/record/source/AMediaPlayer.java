package com.baidu.ugc.editvideo.record.source;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.ugc.editvideo.player.IPlayer;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes8.dex */
public abstract class AMediaPlayer implements IMediaPlayer {
    public static MediaInfo sMediaInfo;
    public Uri dataSource;
    public IMediaPlayer.Listener listener;
    public boolean looping;
    public IMediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener;
    public IMediaPlayer.OnCompletionListener mOnCompletionListener;
    public IMediaPlayer.OnErrorListener mOnErrorListener;
    public IMediaPlayer.OnInfoListener mOnInfoListener;
    public IMediaPlayer.OnLoopingListener mOnLoopListener;
    public IPlayer.OnPlayerPlayStateListener mOnPlayStateListener;
    public IMediaPlayer.OnPreparedListener mOnPreparedListener;
    public IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    public IMediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    public String mUniqueID;
    public int playbackState = 1;

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public int getAudioSessionId() {
        return 0;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public int getVideoSarDen() {
        return 1;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public int getVideoSarNum() {
        return 1;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public boolean isValid() {
        return false;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void overMaxSize() {
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void seekToEnd() {
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setAudioStreamType(int i) {
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnOverMaxSizeListener(IMediaPlayer.OnOverMaxSizeListener onOverMaxSizeListener) {
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public String getDataSource() {
        if (getDataSourceUri() != null) {
            return getDataSourceUri().toString();
        }
        return null;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public Uri getDataSourceUri() {
        return this.dataSource;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public MediaInfo getMediaInfo() {
        if (sMediaInfo == null) {
            MediaInfo mediaInfo = new MediaInfo();
            mediaInfo.mVideoDecoder = "android";
            mediaInfo.mVideoDecoderImpl = "HW";
            mediaInfo.mAudioDecoder = "android";
            mediaInfo.mAudioDecoderImpl = "HW";
            sMediaInfo = mediaInfo;
        }
        return sMediaInfo;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public int getPlaybackState() {
        return this.playbackState;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public String getUniqueID() {
        if (TextUtils.isEmpty(this.mUniqueID)) {
            this.mUniqueID = UUID.randomUUID().toString();
        }
        return this.mUniqueID;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public boolean isLooping() {
        return this.looping;
    }

    public final void notifyOnCompletion() {
        IMediaPlayer.OnCompletionListener onCompletionListener = this.mOnCompletionListener;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion(this);
        }
        IMediaPlayer.Listener listener = this.listener;
        if (listener != null) {
            listener.onCompletion();
        }
    }

    public final void notifyOnLooping() {
        IMediaPlayer.OnLoopingListener onLoopingListener = this.mOnLoopListener;
        if (onLoopingListener != null) {
            onLoopingListener.onLoop();
        }
    }

    public final void notifyOnPrepared() {
        IMediaPlayer.OnPreparedListener onPreparedListener = this.mOnPreparedListener;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared(this);
        }
        IMediaPlayer.Listener listener = this.listener;
        if (listener != null) {
            listener.onPrepared();
        }
    }

    public final void notifyOnSeekComplete() {
        IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener = this.mOnSeekCompleteListener;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete(this);
        }
        IMediaPlayer.Listener listener = this.listener;
        if (listener != null) {
            listener.onSeekComplete();
        }
    }

    public final void notifyOnStateChanged() {
        IMediaPlayer.Listener listener = this.listener;
        if (listener != null) {
            listener.onStateChanged(this.playbackState);
        }
    }

    public void releaseListeners() {
        this.mOnPreparedListener = null;
        this.mOnBufferingUpdateListener = null;
        this.mOnCompletionListener = null;
        this.mOnSeekCompleteListener = null;
        this.mOnVideoSizeChangedListener = null;
        this.mOnErrorListener = null;
        this.mOnInfoListener = null;
        this.mOnPlayStateListener = null;
        this.mOnLoopListener = null;
        this.listener = null;
    }

    public final void notifyOnBufferingUpdate(int i) {
        IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = this.mOnBufferingUpdateListener;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(this, i);
        }
        IMediaPlayer.Listener listener = this.listener;
        if (listener != null) {
            listener.onBufferingUpdate(i);
        }
    }

    public final void notifyOnPlayStateChange(int i) {
        IPlayer.OnPlayerPlayStateListener onPlayerPlayStateListener = this.mOnPlayStateListener;
        if (onPlayerPlayStateListener != null) {
            onPlayerPlayStateListener.onStateChange(this, i);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException("no support");
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setListener(IMediaPlayer.Listener listener) {
        this.listener = listener;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setLooping(boolean z) {
        this.looping = z;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mOnBufferingUpdateListener = onBufferingUpdateListener;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnLoopingListener(IMediaPlayer.OnLoopingListener onLoopingListener) {
        this.mOnLoopListener = onLoopingListener;
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setOnPlayerCompletionListener(final IPlayer.OnPlayerCompletionListener onPlayerCompletionListener) {
        setOnCompletionListener(new IMediaPlayer.OnCompletionListener() { // from class: com.baidu.ugc.editvideo.record.source.AMediaPlayer.4
            @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnCompletionListener
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                IPlayer.OnPlayerCompletionListener onPlayerCompletionListener2 = onPlayerCompletionListener;
                if (onPlayerCompletionListener2 == null) {
                    return;
                }
                onPlayerCompletionListener2.onCompletion(AMediaPlayer.this);
            }
        });
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setOnPlayerErrorListener(final IPlayer.OnPlayerErrorListener onPlayerErrorListener) {
        setOnErrorListener(new IMediaPlayer.OnErrorListener() { // from class: com.baidu.ugc.editvideo.record.source.AMediaPlayer.1
            @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnErrorListener
            public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
                IPlayer.OnPlayerErrorListener onPlayerErrorListener2 = onPlayerErrorListener;
                if (onPlayerErrorListener2 == null) {
                    return false;
                }
                return onPlayerErrorListener2.onError(AMediaPlayer.this, i, i2, new Exception());
            }
        });
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setOnPlayerInfoListener(final IPlayer.OnPlayerInfoListener onPlayerInfoListener) {
        setOnInfoListener(new IMediaPlayer.OnInfoListener() { // from class: com.baidu.ugc.editvideo.record.source.AMediaPlayer.5
            @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnInfoListener
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
                IPlayer.OnPlayerInfoListener onPlayerInfoListener2 = onPlayerInfoListener;
                if (onPlayerInfoListener2 == null) {
                    return false;
                }
                onPlayerInfoListener2.onInfo(AMediaPlayer.this, i, i2);
                return false;
            }
        });
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setOnPlayerPlayStateListener(IPlayer.OnPlayerPlayStateListener onPlayerPlayStateListener) {
        this.mOnPlayStateListener = onPlayerPlayStateListener;
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setOnPlayerPreparedListener(final IPlayer.OnPlayerPreparedListener onPlayerPreparedListener) {
        setOnPreparedListener(new IMediaPlayer.OnPreparedListener() { // from class: com.baidu.ugc.editvideo.record.source.AMediaPlayer.2
            @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnPreparedListener
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                IPlayer.OnPlayerPreparedListener onPlayerPreparedListener2 = onPlayerPreparedListener;
                if (onPlayerPreparedListener2 == null) {
                    return;
                }
                onPlayerPreparedListener2.onPrepared(AMediaPlayer.this);
            }
        });
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setOnPlayerVideoSizeChangedListener(final IPlayer.OnPlayerVideoSizeChangedListener onPlayerVideoSizeChangedListener) {
        setOnVideoSizeChangedListener(new IMediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.ugc.editvideo.record.source.AMediaPlayer.3
            @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
                IPlayer.OnPlayerVideoSizeChangedListener onPlayerVideoSizeChangedListener2 = onPlayerVideoSizeChangedListener;
                if (onPlayerVideoSizeChangedListener2 == null) {
                    return;
                }
                onPlayerVideoSizeChangedListener2.onVideoSizeChanged(i, i2);
            }
        });
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    public void setPlaybackState(int i) {
        this.playbackState = i;
        notifyOnStateChanged();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setVolume(float f) {
        setVolume(f, f);
    }

    public final boolean notifyOnError(int i, int i2, Exception exc) {
        boolean z;
        boolean z2;
        IMediaPlayer.OnErrorListener onErrorListener = this.mOnErrorListener;
        if (onErrorListener != null && onErrorListener.onError(this, i, i2)) {
            z = true;
        } else {
            z = false;
        }
        IMediaPlayer.Listener listener = this.listener;
        if (listener != null && listener.onError(i, i2, exc)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z || z2) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.dataSource = uri;
    }

    public final boolean notifyOnInfo(int i, int i2) {
        boolean z;
        boolean z2;
        IMediaPlayer.OnInfoListener onInfoListener = this.mOnInfoListener;
        if (onInfoListener != null && onInfoListener.onInfo(this, i, i2)) {
            z = true;
        } else {
            z = false;
        }
        IMediaPlayer.Listener listener = this.listener;
        if (listener != null && listener.onInfo(i, i2)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z || z2) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(context, uri, null);
    }

    public final void notifyOnVideoSizeChanged(int i, int i2, int i3, float f) {
        IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.mOnVideoSizeChangedListener;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(this, i, i2, i3, (int) f);
        }
        IMediaPlayer.Listener listener = this.listener;
        if (listener != null) {
            listener.onVideoSizeChanged(i, i2, i3, f);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(null, Uri.parse(str));
    }
}
