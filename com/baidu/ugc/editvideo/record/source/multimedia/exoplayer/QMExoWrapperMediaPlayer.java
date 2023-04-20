package com.baidu.ugc.editvideo.record.source.multimedia.exoplayer;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.tieba.oda;
import com.baidu.tieba.pda;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.editvideo.player.IPlayer;
import com.baidu.ugc.editvideo.player.VideoPlayData;
import com.baidu.ugc.editvideo.record.source.DefaultAMediaPlayer;
import com.baidu.ugc.editvideo.record.source.MediaInfo;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class QMExoWrapperMediaPlayer implements IMediaPlayer, IMediaPlayer.OnSeekCompleteListener {
    public IMediaPlayer mInnerMediaPlayer;
    public boolean mIsSeeking;
    public boolean mNeedStartAfterSeek;
    public long mSeekToEndPosition;

    public QMExoWrapperMediaPlayer() {
        pda d = oda.c().d();
        if (d != null) {
            this.mInnerMediaPlayer = d.a();
        }
        if (this.mInnerMediaPlayer == null) {
            this.mInnerMediaPlayer = new DefaultAMediaPlayer();
        }
        setOnSeekCompleteListener(this);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public int getAudioSessionId() {
        return this.mInnerMediaPlayer.getAudioSessionId();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public long getCurrentPosition() {
        return this.mInnerMediaPlayer.getCurrentPosition();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public String getDataSource() {
        return this.mInnerMediaPlayer.getDataSource();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public Uri getDataSourceUri() {
        return this.mInnerMediaPlayer.getDataSourceUri();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public long getDuration() {
        return this.mInnerMediaPlayer.getDuration();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public MediaInfo getMediaInfo() {
        return this.mInnerMediaPlayer.getMediaInfo();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public float getPlaybackSpeed() {
        return this.mInnerMediaPlayer.getPlaybackSpeed();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public int getPlaybackState() {
        return this.mInnerMediaPlayer.getPlaybackState();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public String getUniqueID() {
        return this.mInnerMediaPlayer.getUniqueID();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public int getVideoSarDen() {
        return this.mInnerMediaPlayer.getVideoSarDen();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public int getVideoSarNum() {
        return this.mInnerMediaPlayer.getVideoSarNum();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public float getVolume() {
        return this.mInnerMediaPlayer.getVolume();
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public boolean isEnd() {
        return this.mInnerMediaPlayer.isEnd();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public boolean isLooping() {
        return this.mInnerMediaPlayer.isLooping();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public boolean isPlayable() {
        return this.mInnerMediaPlayer.isPlayable();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public boolean isPlaying() {
        return this.mInnerMediaPlayer.isPlaying();
    }

    public boolean isSeeking() {
        return this.mIsSeeking;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public boolean isValid() {
        return this.mInnerMediaPlayer.isValid();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void overMaxSize() {
        this.mInnerMediaPlayer.overMaxSize();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void pause() {
        this.mNeedStartAfterSeek = false;
        this.mInnerMediaPlayer.pause();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void prepareAsync() {
        this.mInnerMediaPlayer.prepareAsync();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void release() {
        this.mInnerMediaPlayer.release();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void reset() {
        this.mIsSeeking = false;
        this.mNeedStartAfterSeek = false;
        this.mInnerMediaPlayer.reset();
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void seekToEnd() {
        long currentPosition = getCurrentPosition();
        double duration = getDuration();
        double d = duration - (0.01d * duration);
        if (currentPosition >= d) {
            this.mSeekToEndPosition = currentPosition;
            currentPosition = (long) d;
        }
        seekToForce(currentPosition);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void start() {
        if (this.mIsSeeking && this.mInnerMediaPlayer.getPlaybackState() != 3) {
            this.mNeedStartAfterSeek = true;
        } else {
            this.mInnerMediaPlayer.start();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void stop() throws IllegalStateException {
        this.mIsSeeking = false;
        this.mNeedStartAfterSeek = false;
        this.mInnerMediaPlayer.stop();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(IMediaPlayer iMediaPlayer) {
        this.mIsSeeking = false;
        if (this.mNeedStartAfterSeek) {
            this.mInnerMediaPlayer.start();
        }
        long j = this.mSeekToEndPosition;
        if (j != 0) {
            seekToForce(j);
            this.mSeekToEndPosition = 0L;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void seekTo(long j) {
        if (j < 0) {
            j = 0;
        }
        if (j > getDuration()) {
            j = getDuration();
        }
        this.mIsSeeking = true;
        this.mInnerMediaPlayer.seekTo(j);
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void seekToForce(long j) {
        if (j < 0) {
            j = 0;
        }
        if (j > getDuration()) {
            j = getDuration();
        }
        this.mIsSeeking = true;
        this.mInnerMediaPlayer.seekTo(j);
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setAudioDataSource(List<AudioPlayData> list) {
        this.mInnerMediaPlayer.setAudioDataSource(list);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setAudioStreamType(int i) {
        this.mInnerMediaPlayer.setAudioStreamType(i);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        this.mInnerMediaPlayer.setDataSource(fileDescriptor);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mInnerMediaPlayer.setDisplay(surfaceHolder);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setListener(IMediaPlayer.Listener listener) {
        this.mInnerMediaPlayer.setListener(listener);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setLooping(boolean z) {
        this.mInnerMediaPlayer.setLooping(z);
    }

    public void setNeedStartAfterSeek(boolean z) {
        this.mNeedStartAfterSeek = z;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mInnerMediaPlayer.setOnBufferingUpdateListener(onBufferingUpdateListener);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mInnerMediaPlayer.setOnCompletionListener(onCompletionListener);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.mInnerMediaPlayer.setOnErrorListener(onErrorListener);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.mInnerMediaPlayer.setOnInfoListener(onInfoListener);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnLoopingListener(IMediaPlayer.OnLoopingListener onLoopingListener) {
        this.mInnerMediaPlayer.setOnLoopingListener(onLoopingListener);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnOverMaxSizeListener(IMediaPlayer.OnOverMaxSizeListener onOverMaxSizeListener) {
        this.mInnerMediaPlayer.setOnOverMaxSizeListener(onOverMaxSizeListener);
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setOnPlayerCompletionListener(IPlayer.OnPlayerCompletionListener onPlayerCompletionListener) {
        this.mInnerMediaPlayer.setOnPlayerCompletionListener(onPlayerCompletionListener);
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setOnPlayerErrorListener(IPlayer.OnPlayerErrorListener onPlayerErrorListener) {
        this.mInnerMediaPlayer.setOnPlayerErrorListener(onPlayerErrorListener);
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setOnPlayerInfoListener(IPlayer.OnPlayerInfoListener onPlayerInfoListener) {
        this.mInnerMediaPlayer.setOnPlayerInfoListener(onPlayerInfoListener);
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setOnPlayerPlayStateListener(IPlayer.OnPlayerPlayStateListener onPlayerPlayStateListener) {
        this.mInnerMediaPlayer.setOnPlayerPlayStateListener(onPlayerPlayStateListener);
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setOnPlayerPreparedListener(IPlayer.OnPlayerPreparedListener onPlayerPreparedListener) {
        this.mInnerMediaPlayer.setOnPlayerPreparedListener(onPlayerPreparedListener);
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setOnPlayerVideoSizeChangedListener(IPlayer.OnPlayerVideoSizeChangedListener onPlayerVideoSizeChangedListener) {
        this.mInnerMediaPlayer.setOnPlayerVideoSizeChangedListener(onPlayerVideoSizeChangedListener);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.mInnerMediaPlayer.setOnPreparedListener(onPreparedListener);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public final void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mInnerMediaPlayer.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnSpeedChangeListener(IMediaPlayer.OnSpeedChangeListener onSpeedChangeListener) {
        this.mInnerMediaPlayer.setOnSpeedChangeListener(onSpeedChangeListener);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mInnerMediaPlayer.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public boolean setPlaybackSpeed(float f) {
        return this.mInnerMediaPlayer.setPlaybackSpeed(f);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        this.mInnerMediaPlayer.setScreenOnWhilePlaying(z);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setSurface(Surface surface) {
        this.mInnerMediaPlayer.setSurface(surface);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setVolume(float f) {
        this.mInnerMediaPlayer.setVolume(f);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(context, uri, null);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setVolume(float f, float f2) {
        this.mInnerMediaPlayer.setVolume(f, f2);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mInnerMediaPlayer.setDataSource(context, uri, map);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(null, Uri.parse(Uri.encode(str)), null);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setDataSource(List<VideoPlayData> list) {
        this.mInnerMediaPlayer.setDataSource(list);
    }
}
