package com.baidu.ugc.editvideo.record.source.multimedia.exoplayer;

import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.baidu.tieba.rtb;
import com.baidu.tieba.xtb;
import com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceTimerManager;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
/* loaded from: classes9.dex */
public class VLogSimplePlayer {
    public static final int STATE_ERROR = -1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_PAUSED = 4;
    public static final int STATE_PLAYBACK_COMPLETED = 5;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_PREPARED = 2;
    public static final int STATE_PREPARING = 1;
    public boolean isCompatSeekToPlayCompletion;
    public int[] mAudioChangeTypes;
    public volatile xtb mAudioPlayer;
    public int[] mEQParams;
    public volatile QMExoWrapperMediaPlayer mMediaPlayer;
    public volatile IMediaPlayer.OnCompletionListener mOnCompletionListener;
    public volatile IMediaPlayer.OnErrorListener mOnErrorListener;
    public volatile IMediaPlayer.OnInfoListener mOnInfoListener;
    public volatile IMediaPlayer.OnPreparedListener mOnPreparedListener;
    public volatile IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    public volatile IMediaPlayer.OnSpeedChangeListener mOnSpeedChangeListener;
    public volatile String mPath;
    public double[] mReverbParams;
    public volatile long mSeekWhenPrepared;
    public float mSpeed;
    public float mVolumeBackUp;
    public volatile int mCurrentState = 0;
    public volatile int mTargetState = 0;
    public volatile float mLeftVolume = 1.0f;
    public volatile float mRightVolume = 1.0f;
    public boolean mAudioEffectPlayerNeedSeek = false;
    public Runnable mSetDataSourceRunnable = new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.1
        @Override // java.lang.Runnable
        public void run() {
            VLogSimplePlayer vLogSimplePlayer = VLogSimplePlayer.this;
            vLogSimplePlayer.setDataSourceInternal(vLogSimplePlayer.mPath);
        }
    };
    public Runnable mStartRunnable = new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.2
        @Override // java.lang.Runnable
        public void run() {
            VLogSimplePlayer.this.startInternal();
        }
    };
    public Runnable mPauseRunnable = new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.3
        @Override // java.lang.Runnable
        public void run() {
            VLogSimplePlayer.this.pauseInternal();
        }
    };
    public SeekRunnable mSeekRunnable = new SeekRunnable();
    public Runnable mResetRunnable = new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.4
        @Override // java.lang.Runnable
        public void run() {
            VLogSimplePlayer.this.resetInternal();
        }
    };
    public Runnable mReleaseRunnable = new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.5
        @Override // java.lang.Runnable
        public void run() {
            VLogSimplePlayer.this.releaseInternal();
        }
    };
    public Runnable mVolumeRunnable = new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.6
        @Override // java.lang.Runnable
        public void run() {
            VLogSimplePlayer.this.setVolumeInternal();
        }
    };
    public IMediaPlayer.OnInfoListener mInfoListener = new IMediaPlayer.OnInfoListener() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.7
        @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnInfoListener
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            VLogSimplePlayer.this.notifyInfo(iMediaPlayer, i, i2);
            return false;
        }
    };
    public IMediaPlayer.OnCompletionListener mCompletionListener = new IMediaPlayer.OnCompletionListener() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.8
        @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnCompletionListener
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            if (VLogSimplePlayer.this.mTargetState != 4) {
                VLogSimplePlayer.this.mCurrentState = 5;
                VLogSimplePlayer.this.mTargetState = 5;
            }
            VLogSimplePlayer.this.notifyCompletion(iMediaPlayer);
        }
    };
    public Runnable mAudioChangeRunnable = new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.9
        @Override // java.lang.Runnable
        public void run() {
            VLogSimplePlayer vLogSimplePlayer = VLogSimplePlayer.this;
            vLogSimplePlayer.setAudioChangeTypeInternal(vLogSimplePlayer.mAudioChangeTypes);
        }
    };
    public IMediaPlayer.OnErrorListener mErrorListener = new IMediaPlayer.OnErrorListener() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.10
        @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnErrorListener
        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            VLogSimplePlayer.this.mCurrentState = -1;
            VLogSimplePlayer.this.mTargetState = -1;
            VLogSimplePlayer.this.notifyError(iMediaPlayer, i, i2);
            return false;
        }
    };
    public IMediaPlayer.OnSeekCompleteListener mSeekCompleteListener = new IMediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.11
        @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            xtb xtbVar;
            xtb xtbVar2;
            long currentPosition = iMediaPlayer.getCurrentPosition();
            long duration = iMediaPlayer.getDuration();
            if (currentPosition <= duration && currentPosition >= duration - 100 && !iMediaPlayer.isPlaying() && !VLogSimplePlayer.this.isCompatSeekToPlayCompletion) {
                iMediaPlayer.seekTo(iMediaPlayer.getDuration() - 110);
                if (VLogSimplePlayer.this.isAudioTypeChange() && (xtbVar2 = VLogSimplePlayer.this.mAudioPlayer) != null) {
                    xtbVar2.B(iMediaPlayer.getCurrentPosition());
                }
                VLogSimplePlayer.this.isCompatSeekToPlayCompletion = true;
                return;
            }
            VLogSimplePlayer.this.notifySeekComplete(iMediaPlayer);
            VLogSimplePlayer.this.isCompatSeekToPlayCompletion = false;
            if (VLogSimplePlayer.this.mTargetState == 3 && VLogSimplePlayer.this.mCurrentState == 3) {
                VLogSimplePlayer.this.mMediaPlayer.start();
                if (!VLogSimplePlayer.this.isAudioTypeChange() || (xtbVar = VLogSimplePlayer.this.mAudioPlayer) == null) {
                    return;
                }
                xtbVar.I();
            }
        }
    };
    public IMediaPlayer.OnPreparedListener mPreparedListener = new IMediaPlayer.OnPreparedListener() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.12
        @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnPreparedListener
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            VLogSimplePlayer.this.mCurrentState = 2;
            long j = VLogSimplePlayer.this.mSeekWhenPrepared;
            if (j != 0) {
                VLogSimplePlayer.this.seekTo(j);
            }
            VLogSimplePlayer.this.notifyPrepared(iMediaPlayer);
            VLogSimplePlayer.this.setVolumeInternal();
            if (VLogSimplePlayer.this.mTargetState == 3) {
                VLogSimplePlayer.this.start();
            }
        }
    };
    public Handler mPlayerHandler = new Handler(MultiMediaDataSourceTimerManager.getInstance().getPlayerLooper());

    /* loaded from: classes9.dex */
    public class SeekRunnable implements Runnable {
        public long mSeekTime;

        public SeekRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VLogSimplePlayer.this.mSeekWhenPrepared = this.mSeekTime;
            VLogSimplePlayer.this.seekToInternal(this.mSeekTime);
        }

        public void setseekTime(long j) {
            this.mSeekTime = j;
        }
    }

    public VLogSimplePlayer(String str) {
        this.mPath = str;
        schedule(this.mSetDataSourceRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAudioTypeChange() {
        return this.mAudioPlayer != null && rtb.o(this.mAudioChangeTypes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCompletion(IMediaPlayer iMediaPlayer) {
        if (this.mOnCompletionListener != null) {
            this.mOnCompletionListener.onCompletion(iMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyError(IMediaPlayer iMediaPlayer, int i, int i2) {
        if (this.mOnErrorListener != null) {
            this.mOnErrorListener.onError(iMediaPlayer, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
        if (this.mOnInfoListener != null) {
            this.mOnInfoListener.onInfo(iMediaPlayer, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPrepared(IMediaPlayer iMediaPlayer) {
        if (this.mOnPreparedListener != null) {
            this.mOnPreparedListener.onPrepared(iMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySeekComplete(IMediaPlayer iMediaPlayer) {
        if (this.mOnSeekCompleteListener != null) {
            this.mOnSeekCompleteListener.onSeekComplete(iMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseInternal() {
        QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = this.mMediaPlayer;
        if (isInPlaybackState() && qMExoWrapperMediaPlayer != null) {
            try {
                qMExoWrapperMediaPlayer.pause();
                this.mCurrentState = 4;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (isAudioTypeChange()) {
            this.mAudioPlayer.pause();
        }
        this.mTargetState = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseInternal() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.release();
        }
        if (isAudioTypeChange()) {
            xtb xtbVar = this.mAudioPlayer;
            if (xtbVar != null) {
                xtbVar.J();
            }
            this.mAudioPlayer = null;
        }
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mSeekWhenPrepared = 0L;
        this.mOnInfoListener = null;
        this.mOnCompletionListener = null;
        this.mOnErrorListener = null;
        this.mOnPreparedListener = null;
        this.mOnSeekCompleteListener = null;
        this.mOnSpeedChangeListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetInternal() {
        xtb xtbVar;
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
        }
        if (isAudioTypeChange() && (xtbVar = this.mAudioPlayer) != null) {
            xtbVar.J();
        }
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mSeekWhenPrepared = 0L;
    }

    private void schedule(Runnable runnable) {
        if (Looper.myLooper() != MultiMediaDataSourceTimerManager.getInstance().getPlayerLooper()) {
            this.mPlayerHandler.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seekToInternal(long j) {
        xtb xtbVar;
        try {
            QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = this.mMediaPlayer;
            if (!isInPlaybackState() || qMExoWrapperMediaPlayer == null) {
                this.mSeekWhenPrepared = j;
            } else {
                qMExoWrapperMediaPlayer.seekTo(j);
                qMExoWrapperMediaPlayer.pause();
                this.mSeekWhenPrepared = 0L;
            }
            if (!isAudioTypeChange() || (xtbVar = this.mAudioPlayer) == null) {
                return;
            }
            xtbVar.B(j);
            xtbVar.pause();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioChangeTypeInternal(int[] iArr) {
        if (this.mAudioPlayer != null || rtb.o(iArr)) {
            if (this.mMediaPlayer != null && (this.mAudioPlayer == null || !rtb.o(this.mAudioPlayer.g()))) {
                this.mVolumeBackUp = this.mMediaPlayer.getVolume();
            }
            if (this.mAudioPlayer == null) {
                try {
                    this.mAudioPlayer = new xtb(this.mPath, iArr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (!rtb.o(iArr)) {
                if (this.mAudioPlayer != null) {
                    this.mAudioPlayer.N(0.0f, 0.0f);
                }
                if (this.mMediaPlayer != null) {
                    this.mMediaPlayer.setVolume(this.mVolumeBackUp);
                }
            } else if (this.mAudioPlayer != null && this.mMediaPlayer != null) {
                this.mMediaPlayer.setVolume(0.0f);
                if (this.mAudioEffectPlayerNeedSeek) {
                    this.mAudioPlayer.B(this.mMediaPlayer.getCurrentPosition());
                    this.mAudioEffectPlayerNeedSeek = false;
                }
                this.mAudioPlayer.N(this.mLeftVolume, this.mRightVolume);
                this.mAudioPlayer.E(iArr, this.mEQParams, this.mReverbParams);
                if (this.mMediaPlayer.isPlaying()) {
                    this.mAudioPlayer.I();
                }
            }
            if (this.mAudioPlayer != null) {
                this.mAudioPlayer.G(this.mSpeed);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataSourceInternal(String str) {
        QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = null;
        try {
            QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer2 = new QMExoWrapperMediaPlayer();
            try {
                qMExoWrapperMediaPlayer2.setDataSource(str);
                qMExoWrapperMediaPlayer2.setOnSeekCompleteListener(this.mSeekCompleteListener);
                qMExoWrapperMediaPlayer2.setOnPreparedListener(this.mPreparedListener);
                qMExoWrapperMediaPlayer2.setOnErrorListener(this.mErrorListener);
                qMExoWrapperMediaPlayer2.setOnCompletionListener(this.mCompletionListener);
                qMExoWrapperMediaPlayer2.setOnInfoListener(this.mInfoListener);
                qMExoWrapperMediaPlayer2.setOnSpeedChangeListener(this.mOnSpeedChangeListener);
                qMExoWrapperMediaPlayer2.prepareAsync();
                this.mMediaPlayer = qMExoWrapperMediaPlayer2;
                this.mCurrentState = 1;
            } catch (Exception unused) {
                qMExoWrapperMediaPlayer = qMExoWrapperMediaPlayer2;
                this.mErrorListener.onError(qMExoWrapperMediaPlayer, -1, -1);
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSurfaceInternal(Surface surface) {
        if (this.mMediaPlayer == null) {
            return;
        }
        this.mMediaPlayer.setSurface(surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVolumeInternal() {
        this.mVolumeBackUp = this.mLeftVolume;
        if (isAudioTypeChange()) {
            xtb xtbVar = this.mAudioPlayer;
            if (xtbVar != null) {
                xtbVar.N(this.mLeftVolume, this.mRightVolume);
                return;
            }
            return;
        }
        QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = this.mMediaPlayer;
        if (qMExoWrapperMediaPlayer != null) {
            qMExoWrapperMediaPlayer.setVolume(this.mLeftVolume, this.mRightVolume);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInternal() {
        if (isInPlaybackState()) {
            try {
                QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = this.mMediaPlayer;
                if (!qMExoWrapperMediaPlayer.isPlaying()) {
                    qMExoWrapperMediaPlayer.start();
                }
                if (isAudioTypeChange()) {
                    xtb xtbVar = this.mAudioPlayer;
                    xtbVar.B(qMExoWrapperMediaPlayer.getCurrentPosition());
                    xtbVar.I();
                }
                this.mCurrentState = 3;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.mTargetState = 3;
    }

    public long getCurrentPosition() {
        QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = this.mMediaPlayer;
        long currentPosition = (!isInPlaybackState() || qMExoWrapperMediaPlayer == null) ? -1L : qMExoWrapperMediaPlayer.getCurrentPosition();
        return currentPosition != -1 ? ((float) currentPosition) / getSpeed() : currentPosition;
    }

    public long getDuration() {
        QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = this.mMediaPlayer;
        long duration = (!isInPlaybackState() || qMExoWrapperMediaPlayer == null) ? -1L : qMExoWrapperMediaPlayer.getDuration();
        return duration != -1 ? ((float) duration) / getSpeed() : duration;
    }

    public IMediaPlayer.OnSeekCompleteListener getOnSeekCompleteListener() {
        return this.mOnSeekCompleteListener;
    }

    public float getSpeed() {
        if (this.mMediaPlayer == null) {
            return 1.0f;
        }
        return this.mMediaPlayer.getPlaybackSpeed();
    }

    public boolean isInPlaybackState() {
        return (this.mMediaPlayer == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    public boolean isPlaying() {
        QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = this.mMediaPlayer;
        return isInPlaybackState() && qMExoWrapperMediaPlayer != null && qMExoWrapperMediaPlayer.isPlaying();
    }

    public void pause() {
        schedule(this.mPauseRunnable);
    }

    public void release() {
        schedule(this.mReleaseRunnable);
    }

    public void releaseOnInvokeThread() {
        releaseInternal();
    }

    public void reset() {
        schedule(this.mResetRunnable);
    }

    public void seekTo(long j) {
        this.mSeekRunnable.setseekTime(j);
        schedule(this.mSeekRunnable);
    }

    public void setAudioChangeType(int[] iArr) {
        if (!rtb.o(this.mAudioChangeTypes) && rtb.o(iArr)) {
            this.mAudioEffectPlayerNeedSeek = true;
        }
        this.mAudioChangeTypes = iArr;
        schedule(this.mAudioChangeRunnable);
    }

    public void setAudioChangeType(int[] iArr, double[] dArr, int[] iArr2) {
        if (!rtb.o(this.mAudioChangeTypes) && rtb.o(iArr)) {
            this.mAudioEffectPlayerNeedSeek = true;
        }
        this.mAudioChangeTypes = iArr;
        this.mEQParams = iArr2;
        this.mReverbParams = dArr;
        schedule(this.mAudioChangeRunnable);
    }

    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    public void setOnSpeedChangeListener(IMediaPlayer.OnSpeedChangeListener onSpeedChangeListener) {
        this.mOnSpeedChangeListener = onSpeedChangeListener;
    }

    public void setSpeed(final float f) {
        schedule(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.14
            @Override // java.lang.Runnable
            public void run() {
                xtb xtbVar;
                if (VLogSimplePlayer.this.mMediaPlayer == null) {
                    return;
                }
                VLogSimplePlayer.this.mSpeed = f;
                VLogSimplePlayer.this.mMediaPlayer.setPlaybackSpeed(f);
                if (!VLogSimplePlayer.this.isAudioTypeChange() || (xtbVar = VLogSimplePlayer.this.mAudioPlayer) == null) {
                    return;
                }
                xtbVar.G(f);
            }
        });
    }

    public void setSurface(final Surface surface) {
        schedule(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.13
            @Override // java.lang.Runnable
            public void run() {
                VLogSimplePlayer.this.setSurfaceInternal(surface);
            }
        });
    }

    public void setVolume(float f, float f2) {
        this.mLeftVolume = f;
        this.mRightVolume = f2;
        schedule(this.mVolumeRunnable);
    }

    public void start() {
        schedule(this.mStartRunnable);
    }
}
