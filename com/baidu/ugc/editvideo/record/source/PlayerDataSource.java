package com.baidu.ugc.editvideo.record.source;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.tieba.fab;
import com.baidu.tieba.kab;
import com.baidu.tieba.zab;
import com.baidu.ugc.editvideo.player.IPlayer;
import com.baidu.ugc.editvideo.player.VideoPlayData;
import com.baidu.ugc.editvideo.record.source.IDataSourceView;
import com.baidu.ugc.editvideo.record.source.IMediaDataSource;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class PlayerDataSource implements IMediaDataSource.IPlayerDataSource {
    public static final int STATE_IDLE = 0;
    public static final int STATE_PAUSED = 4;
    public static final int STATE_PLAYBACK_COMPLETED = 5;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_PREPARED = 2;
    public static final int STATE_PREPARING = 1;
    public static final int STATE_STOP = 6;
    public IPlayer mMediaPlayer;
    public String mPath;
    public List<VideoPlayData> mPathList;
    public long mSeekWhenPrepared;
    public Surface mSurface;
    public int mVideoHeight;
    public int mVideoWidth;
    public OnPlayStateListener onPlayStateListener;
    public volatile int mCurrentState = 0;
    public volatile int mTargetState = 0;
    public float mSpeed = 1.0f;
    public boolean isReportError = false;
    public List<IDataSourceView.IPlayerDataSourceView> mSourceViewList = new ArrayList();

    /* loaded from: classes9.dex */
    public interface OnPlayStateListener {
        void pause();

        void play();
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
    }

    public PlayerDataSource(IPlayer iPlayer) {
        this.mMediaPlayer = iPlayer;
        initPlayer();
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void addIPlayerDataSourceView(IDataSourceView.IPlayerDataSourceView iPlayerDataSourceView) {
        this.mSourceViewList.add(iPlayerDataSourceView);
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public boolean isSameSpeed(float f) {
        if (!isInPlaybackState()) {
            return false;
        }
        float playbackSpeed = this.mMediaPlayer.getPlaybackSpeed();
        if (playbackSpeed > 0.0f && Math.abs((1.0f / playbackSpeed) - f) > 0.05f) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource
    public void onSurfaceHolderCreate(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            return;
        }
        Surface surface = surfaceHolder.getSurface();
        this.mSurface = surface;
        IPlayer iPlayer = this.mMediaPlayer;
        if (iPlayer != null) {
            iPlayer.setSurface(surface);
            this.mMediaPlayer.prepareAsync();
            this.mMediaPlayer.seekToEnd();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource
    public void onSurfaceTextureCreate(SurfaceTexture surfaceTexture) {
        if (surfaceTexture == null) {
            return;
        }
        Surface surface = new Surface(surfaceTexture);
        this.mSurface = surface;
        IPlayer iPlayer = this.mMediaPlayer;
        if (iPlayer != null) {
            iPlayer.setSurface(surface);
            this.mMediaPlayer.prepareAsync();
            this.mMediaPlayer.seekToEnd();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void seekTo(long j) {
        if (isInPlaybackState()) {
            this.mMediaPlayer.seekTo(j);
            this.mSeekWhenPrepared = 0L;
            return;
        }
        this.mSeekWhenPrepared = j;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void seekToForce(long j) {
        if (isInPlaybackState()) {
            this.mMediaPlayer.seekToForce(j);
            this.mSeekWhenPrepared = 0L;
            return;
        }
        this.mSeekWhenPrepared = j;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void setLooping(boolean z) {
        IPlayer iPlayer = this.mMediaPlayer;
        if (iPlayer != null) {
            iPlayer.setLooping(z);
        }
    }

    public void setOnPlayStateListener(OnPlayStateListener onPlayStateListener) {
        this.onPlayStateListener = onPlayStateListener;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void setSpeed(float f) {
        this.mSpeed = f;
        if (this.mMediaPlayer != null && !isSameSpeed(f)) {
            this.mMediaPlayer.setPlaybackSpeed(1.0f / this.mSpeed);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void setVideoPath(String str) {
        this.mPath = str;
        this.mPathList = null;
        createPlayer(false);
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void setVideoPathList(List<VideoPlayData> list) {
        this.mPathList = list;
        this.mPath = null;
        createPlayer(false);
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void setVolume(float f, float f2) {
        IPlayer iPlayer = this.mMediaPlayer;
        if (iPlayer != null) {
            iPlayer.setVolume(f, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createPlayer(boolean z) {
        if (zab.a(this.mPath) && kab.e(this.mPathList)) {
            return;
        }
        pause();
        stop();
        reset();
        try {
            if (!TextUtils.isEmpty(this.mPath)) {
                this.mMediaPlayer.setDataSource(this.mPath);
            } else {
                this.mMediaPlayer.setDataSource(this.mPathList.get(0).videoPath);
            }
            this.mMediaPlayer.setPlaybackSpeed(1.0f / this.mSpeed);
            if (z || this.mSurface != null) {
                this.mMediaPlayer.setSurface(this.mSurface);
                this.mMediaPlayer.prepareAsync();
            }
            this.mCurrentState = 1;
        } catch (Exception e) {
            fab.g(e);
            this.mMediaPlayer = null;
            this.mPath = null;
            this.mPathList = null;
            this.mCurrentState = 0;
            this.mTargetState = 0;
            for (int i = 0; i < this.mSourceViewList.size(); i++) {
                this.mSourceViewList.get(i).onError(null, -1, -1, e);
            }
        }
    }

    private VideoPlayData getCurrentPlayData() {
        if (kab.e(this.mPathList)) {
            return null;
        }
        long currentPosition = getCurrentPosition();
        for (VideoPlayData videoPlayData : this.mPathList) {
            if (videoPlayData != null) {
                int i = videoPlayData.offset;
                if (i <= currentPosition && (i + videoPlayData.end) - videoPlayData.start >= currentPosition) {
                    return videoPlayData;
                }
            }
        }
        return null;
    }

    private void initPlayer() {
        this.mMediaPlayer.setOnPlayerPreparedListener(new IPlayer.OnPlayerPreparedListener() { // from class: com.baidu.ugc.editvideo.record.source.PlayerDataSource.1
            @Override // com.baidu.ugc.editvideo.player.IPlayer.OnPlayerPreparedListener
            public void onPrepared(IPlayer iPlayer) {
                PlayerDataSource.this.mMediaPlayer.setPlaybackSpeed(1.0f / PlayerDataSource.this.mSpeed);
                PlayerDataSource.this.mCurrentState = 2;
                if (PlayerDataSource.this.mSeekWhenPrepared != 0) {
                    PlayerDataSource playerDataSource = PlayerDataSource.this;
                    playerDataSource.seekToForce(playerDataSource.mSeekWhenPrepared);
                }
                PlayerDataSource.this.mMediaPlayer.setSurface(PlayerDataSource.this.mSurface);
                for (int i = 0; i < PlayerDataSource.this.mSourceViewList.size(); i++) {
                    ((IDataSourceView.IPlayerDataSourceView) PlayerDataSource.this.mSourceViewList.get(i)).onPrepared(iPlayer);
                }
                if (PlayerDataSource.this.mTargetState == 3) {
                    PlayerDataSource.this.start();
                }
            }
        });
        this.mMediaPlayer.setOnPlayerVideoSizeChangedListener(new IPlayer.OnPlayerVideoSizeChangedListener() { // from class: com.baidu.ugc.editvideo.record.source.PlayerDataSource.2
            @Override // com.baidu.ugc.editvideo.player.IPlayer.OnPlayerVideoSizeChangedListener
            public void onVideoSizeChanged(int i, int i2) {
                PlayerDataSource.this.mVideoWidth = i;
                PlayerDataSource.this.mVideoHeight = i2;
                for (int i3 = 0; i3 < PlayerDataSource.this.mSourceViewList.size(); i3++) {
                    ((IDataSourceView.IPlayerDataSourceView) PlayerDataSource.this.mSourceViewList.get(i3)).onVideoSizeChanged(i, i2);
                }
            }
        });
        this.mMediaPlayer.setOnPlayerCompletionListener(new IPlayer.OnPlayerCompletionListener() { // from class: com.baidu.ugc.editvideo.record.source.PlayerDataSource.3
            @Override // com.baidu.ugc.editvideo.player.IPlayer.OnPlayerCompletionListener
            public void onCompletion(IPlayer iPlayer) {
                for (int i = 0; i < PlayerDataSource.this.mSourceViewList.size(); i++) {
                    ((IDataSourceView.IPlayerDataSourceView) PlayerDataSource.this.mSourceViewList.get(i)).onCompletion(iPlayer);
                }
                PlayerDataSource.this.mCurrentState = 5;
            }
        });
        this.mMediaPlayer.setOnPlayerPlayStateListener(new IPlayer.OnPlayerPlayStateListener() { // from class: com.baidu.ugc.editvideo.record.source.PlayerDataSource.4
            @Override // com.baidu.ugc.editvideo.player.IPlayer.OnPlayerPlayStateListener
            public void onStateChange(IPlayer iPlayer, int i) {
                for (int i2 = 0; i2 < PlayerDataSource.this.mSourceViewList.size(); i2++) {
                    ((IDataSourceView.IPlayerDataSourceView) PlayerDataSource.this.mSourceViewList.get(i2)).onPlayStateListener(iPlayer, i);
                }
            }
        });
        this.mMediaPlayer.setOnPlayerInfoListener(new IPlayer.OnPlayerInfoListener() { // from class: com.baidu.ugc.editvideo.record.source.PlayerDataSource.5
            @Override // com.baidu.ugc.editvideo.player.IPlayer.OnPlayerInfoListener
            public boolean onInfo(IPlayer iPlayer, int i, int i2) {
                for (int i3 = 0; i3 < PlayerDataSource.this.mSourceViewList.size(); i3++) {
                    ((IDataSourceView.IPlayerDataSourceView) PlayerDataSource.this.mSourceViewList.get(i3)).onInfo(iPlayer, i, i2);
                }
                return false;
            }
        });
        this.mMediaPlayer.setOnPlayerErrorListener(new IPlayer.OnPlayerErrorListener() { // from class: com.baidu.ugc.editvideo.record.source.PlayerDataSource.6
            @Override // com.baidu.ugc.editvideo.player.IPlayer.OnPlayerErrorListener
            public boolean onError(IPlayer iPlayer, int i, int i2, Exception exc) {
                if (!PlayerDataSource.this.isReportError) {
                    for (int i3 = 0; i3 < PlayerDataSource.this.mSourceViewList.size(); i3++) {
                        ((IDataSourceView.IPlayerDataSourceView) PlayerDataSource.this.mSourceViewList.get(i3)).onError(iPlayer, i, i2, exc);
                    }
                    PlayerDataSource.this.isReportError = true;
                }
                if (exc != null) {
                    PlayerDataSource.this.createPlayer(false);
                    if (PlayerDataSource.this.mMediaPlayer != null) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public long getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public long getDuration() {
        IPlayer iPlayer = this.mMediaPlayer;
        if (iPlayer == null) {
            return 0L;
        }
        return iPlayer.getDuration();
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public String getVideoPath() {
        return this.mPath;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public List<VideoPlayData> getVideoPathList() {
        return this.mPathList;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public boolean isEnd() {
        IPlayer iPlayer = this.mMediaPlayer;
        if (iPlayer != null) {
            return iPlayer.isEnd();
        }
        return false;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public boolean isInOriginalRange() {
        VideoPlayData currentPlayData;
        if (this.mMediaPlayer == null || (currentPlayData = getCurrentPlayData()) == null) {
            return true;
        }
        return currentPlayData.isOriginal;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public boolean isInPlaybackState() {
        if (this.mMediaPlayer != null && this.mCurrentState != 0 && this.mCurrentState != 1 && this.mCurrentState != 6) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public boolean isPlaying() {
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onDestroy() {
        release();
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onPause() {
        pause();
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        IPlayer iPlayer = this.mMediaPlayer;
        if (iPlayer != null) {
            iPlayer.setSurface(null);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void pause() {
        if (isInPlaybackState()) {
            this.mMediaPlayer.pause();
            this.mCurrentState = 4;
        }
        this.mTargetState = 4;
        OnPlayStateListener onPlayStateListener = this.onPlayStateListener;
        if (onPlayStateListener != null) {
            onPlayStateListener.pause();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void release() {
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        if (this.mMediaPlayer != null) {
            pause();
            stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
        this.mCurrentState = 0;
        this.mTargetState = 0;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void reset() {
        if (this.mCurrentState == 0 && this.mTargetState == 0) {
            return;
        }
        this.mMediaPlayer.reset();
        this.mCurrentState = 0;
        this.mTargetState = 0;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void start() {
        if (isInPlaybackState()) {
            this.mMediaPlayer.start();
            this.mCurrentState = 3;
        }
        this.mTargetState = 3;
        OnPlayStateListener onPlayStateListener = this.onPlayStateListener;
        if (onPlayStateListener != null) {
            onPlayStateListener.play();
        }
        this.isReportError = false;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void stop() {
        if (isInPlaybackState()) {
            this.mMediaPlayer.stop();
            this.mCurrentState = 6;
        }
        this.mTargetState = 6;
    }
}
