package com.baidu.ugc.editvideo.record.source;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.editvideo.player.VideoPlayData;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class DefaultAMediaPlayer extends AMediaPlayer {
    public MediaPlayer internalPlayer;
    public final DefaultAMediaPlayerListenerHolder mInternalListenerAdapter;

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public float getPlaybackSpeed() {
        return 1.0f;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public float getVolume() {
        return 1.0f;
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public boolean isEnd() {
        return false;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public boolean isPlayable() {
        return false;
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setAudioDataSource(List<AudioPlayData> list) {
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setDataSource(List<VideoPlayData> list) {
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnSpeedChangeListener(IMediaPlayer.OnSpeedChangeListener onSpeedChangeListener) {
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public boolean setPlaybackSpeed(float f) {
        return false;
    }

    /* loaded from: classes9.dex */
    public class DefaultAMediaPlayerListenerHolder implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener {
        public boolean isErrorHappened;
        public final WeakReference<DefaultAMediaPlayer> mWeakMediaPlayer;

        public DefaultAMediaPlayerListenerHolder(DefaultAMediaPlayer defaultAMediaPlayer) {
            this.mWeakMediaPlayer = new WeakReference<>(defaultAMediaPlayer);
            clearState();
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (this.mWeakMediaPlayer.get() == null) {
                return;
            }
            DefaultAMediaPlayer.this.notifyOnBufferingUpdate(i);
        }

        private void clearState() {
            this.isErrorHappened = false;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (this.mWeakMediaPlayer.get() == null) {
                return;
            }
            if (DefaultAMediaPlayer.this.isLooping()) {
                DefaultAMediaPlayer.this.seekTo(0L);
                DefaultAMediaPlayer.this.start();
                DefaultAMediaPlayer.this.notifyOnLooping();
                return;
            }
            DefaultAMediaPlayer.this.notifyOnPlayStateChange(2);
            DefaultAMediaPlayer.this.notifyOnCompletion();
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            clearState();
            if (this.mWeakMediaPlayer.get() == null) {
                return;
            }
            DefaultAMediaPlayer.this.notifyOnPrepared();
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (this.mWeakMediaPlayer.get() == null) {
                return;
            }
            DefaultAMediaPlayer.this.notifyOnSeekComplete();
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (this.isErrorHappened) {
                return false;
            }
            this.isErrorHappened = true;
            if (this.mWeakMediaPlayer.get() == null || !DefaultAMediaPlayer.this.notifyOnError(i, i2, null)) {
                return false;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (this.mWeakMediaPlayer.get() != null && DefaultAMediaPlayer.this.notifyOnInfo(i, i2)) {
                return true;
            }
            return false;
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (this.mWeakMediaPlayer.get() == null) {
                return;
            }
            DefaultAMediaPlayer.this.notifyOnVideoSizeChanged(i, i2, 1, 1.0f);
        }
    }

    public DefaultAMediaPlayer() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.internalPlayer = mediaPlayer;
        mediaPlayer.setAudioStreamType(3);
        this.mInternalListenerAdapter = new DefaultAMediaPlayerListenerHolder(this);
        attachInternalListeners();
    }

    private void attachInternalListeners() {
        this.internalPlayer.setOnPreparedListener(this.mInternalListenerAdapter);
        this.internalPlayer.setOnBufferingUpdateListener(this.mInternalListenerAdapter);
        this.internalPlayer.setOnCompletionListener(this.mInternalListenerAdapter);
        this.internalPlayer.setOnSeekCompleteListener(this.mInternalListenerAdapter);
        this.internalPlayer.setOnVideoSizeChangedListener(this.mInternalListenerAdapter);
        this.internalPlayer.setOnErrorListener(this.mInternalListenerAdapter);
        this.internalPlayer.setOnInfoListener(this.mInternalListenerAdapter);
    }

    private void detachInternalListeners() {
        this.internalPlayer.setOnPreparedListener(null);
        this.internalPlayer.setOnBufferingUpdateListener(null);
        this.internalPlayer.setOnCompletionListener(null);
        this.internalPlayer.setOnSeekCompleteListener(null);
        this.internalPlayer.setOnVideoSizeChangedListener(null);
        this.internalPlayer.setOnErrorListener(null);
        this.internalPlayer.setOnInfoListener(null);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public long getCurrentPosition() {
        return this.internalPlayer.getCurrentPosition();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public long getDuration() {
        return this.internalPlayer.getDuration();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public boolean isPlaying() {
        return this.internalPlayer.isPlaying();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void pause() throws IllegalStateException {
        this.internalPlayer.pause();
        notifyOnPlayStateChange(2);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void prepareAsync() throws IllegalStateException {
        this.internalPlayer.prepareAsync();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void release() {
        this.internalPlayer.release();
        detachInternalListeners();
        releaseListeners();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void reset() {
        this.internalPlayer.reset();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void start() throws IllegalStateException {
        this.internalPlayer.start();
        notifyOnPlayStateChange(1);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void stop() throws IllegalStateException {
        this.internalPlayer.stop();
        notifyOnPlayStateChange(2);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void seekTo(long j) throws IllegalStateException {
        this.internalPlayer.seekTo((int) j);
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void seekToForce(long j) {
        seekTo(j);
    }

    @Override // com.baidu.ugc.editvideo.record.source.AMediaPlayer, com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(null, Uri.parse(Uri.encode(str)), null);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.internalPlayer.setDisplay(surfaceHolder);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setSurface(Surface surface) {
        this.internalPlayer.setSurface(surface);
    }

    @Override // com.baidu.ugc.editvideo.record.source.AMediaPlayer, com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        super.setDataSource(context, uri, map);
        this.internalPlayer.setDataSource(uri.getPath());
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setVolume(float f, float f2) {
        this.internalPlayer.setVolume(f, f2);
    }
}
