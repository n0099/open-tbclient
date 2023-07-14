package com.baidu.ugc.editvideo.record.source.multimedia.exoplayer;

import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.tieba.fab;
import com.baidu.tieba.jab;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceTimerManager;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes9.dex */
public class VLogAudioPlayer {
    public static final int STATE_ERROR = -1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_INITIALIZED = 1;
    public static final int STATE_PAUSED = 5;
    public static final int STATE_PLAYBACK_COMPLETED = 6;
    public static final int STATE_PLAYING = 4;
    public static final int STATE_PREPARED = 3;
    public static final int STATE_PREPARING = 2;
    public static final String TAG = "VLogAudioPlayerTag";
    public List<AudioPlayData> handledAudioList;
    public boolean isMute;
    public volatile QMExoWrapperMediaPlayer mMediaPlayer;
    public volatile IMediaPlayer.OnCompletionListener mOnCompletionListener;
    public volatile IMediaPlayer.OnErrorListener mOnErrorListener;
    public volatile IMediaPlayer.OnInfoListener mOnInfoListener;
    public volatile IMediaPlayer.OnPreparedListener mOnPreparedListener;
    public volatile OnProgressListener mOnProgressListener;
    public volatile IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    public ProgressTimerTask mProgressTimerTask;
    public volatile long mSeekWhenPrepared;
    public Timer mUpdateProgressTimer;
    public volatile int mCurrentState = 0;
    public volatile int mTargetState = 0;
    public IMediaPlayer.OnInfoListener mInfoListener = new IMediaPlayer.OnInfoListener() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.11
        @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnInfoListener
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            VLogAudioPlayer.this.notifyInfo(iMediaPlayer, i, i2);
            return false;
        }
    };
    public IMediaPlayer.OnCompletionListener mCompletionListener = new IMediaPlayer.OnCompletionListener() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.12
        @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnCompletionListener
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            if (VLogAudioPlayer.this.mTargetState != 5) {
                VLogAudioPlayer.this.mCurrentState = 6;
                VLogAudioPlayer.this.mTargetState = 6;
            }
            VLogAudioPlayer.this.notifyCompletion(iMediaPlayer);
        }
    };
    public IMediaPlayer.OnErrorListener mErrorListener = new IMediaPlayer.OnErrorListener() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.13
        @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnErrorListener
        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            VLogAudioPlayer.this.mCurrentState = -1;
            VLogAudioPlayer.this.mTargetState = -1;
            VLogAudioPlayer.this.notifyError(iMediaPlayer, i, i2);
            return false;
        }
    };
    public IMediaPlayer.OnSeekCompleteListener mSeekCompleteListener = new IMediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.14
        @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            VLogAudioPlayer.this.notifySeekComplete(iMediaPlayer);
        }
    };
    public IMediaPlayer.OnPreparedListener mPreparedListener = new IMediaPlayer.OnPreparedListener() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.15
        @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnPreparedListener
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            VLogAudioPlayer.this.mCurrentState = 3;
            long j = VLogAudioPlayer.this.mSeekWhenPrepared;
            if (j != 0) {
                VLogAudioPlayer.this.seekTo(j);
            }
            VLogAudioPlayer.this.notifyPrepared(iMediaPlayer);
            if (VLogAudioPlayer.this.mTargetState == 4) {
                VLogAudioPlayer.this.start();
            }
        }
    };
    public Handler mPlayerHandler = new Handler(MultiMediaDataSourceTimerManager.getInstance().getPlayerLooper());

    /* loaded from: classes9.dex */
    public interface OnProgressListener {
        void getCurrentDuration(long j);
    }

    /* loaded from: classes9.dex */
    public class ProgressTimerTask extends TimerTask {
        public ProgressTimerTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            OnProgressListener onProgressListener;
            long j = 0;
            if (VLogAudioPlayer.this.mCurrentState == -1 || VLogAudioPlayer.this.mCurrentState == 0 || VLogAudioPlayer.this.mCurrentState == 1 || VLogAudioPlayer.this.mCurrentState == 2 || VLogAudioPlayer.this.mCurrentState == 3) {
                if (VLogAudioPlayer.this.mOnProgressListener == null) {
                    return;
                }
            } else if (VLogAudioPlayer.this.mMediaPlayer != null) {
                fab.e(VLogAudioPlayer.TAG, "是否静音：" + VLogAudioPlayer.this.isMute);
                if (!VLogAudioPlayer.this.isMute) {
                    try {
                        VLogAudioPlayer.this.updateVolume(VLogAudioPlayer.this.mMediaPlayer.getCurrentPosition());
                    } catch (Exception unused) {
                    }
                } else if (VLogAudioPlayer.this.mMediaPlayer.getVolume() != 0.0f) {
                    VLogAudioPlayer.this.mMediaPlayer.setVolume(0.0f);
                }
                if (VLogAudioPlayer.this.mOnProgressListener != null) {
                    onProgressListener = VLogAudioPlayer.this.mOnProgressListener;
                    j = VLogAudioPlayer.this.mMediaPlayer.getCurrentPosition();
                    onProgressListener.getCurrentDuration(j);
                }
                return;
            } else if (VLogAudioPlayer.this.mOnProgressListener == null) {
                return;
            }
            onProgressListener = VLogAudioPlayer.this.mOnProgressListener;
            onProgressListener.getCurrentDuration(j);
        }
    }

    public VLogAudioPlayer() {
        schedule(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.1
            @Override // java.lang.Runnable
            public void run() {
                VLogAudioPlayer.this.createAudioPlayer();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAudioPlayer() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.release();
        }
        this.mMediaPlayer = new QMExoWrapperMediaPlayer();
    }

    private boolean isInPlaybackState() {
        return (this.mMediaPlayer == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1 || this.mCurrentState == 2) ? false : true;
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
                this.mCurrentState = 5;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.mTargetState = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareAsyncInternal() {
        this.mMediaPlayer.prepareAsync();
        this.mCurrentState = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseInternal() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.release();
        }
        this.mOnInfoListener = null;
        this.mOnCompletionListener = null;
        this.mOnErrorListener = null;
        this.mOnPreparedListener = null;
        this.mOnSeekCompleteListener = null;
        this.mOnProgressListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetInternal() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
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
        this.mSeekWhenPrepared = j;
        try {
            QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = this.mMediaPlayer;
            if (!isInPlaybackState() || qMExoWrapperMediaPlayer == null) {
                this.mSeekWhenPrepared = j;
            } else {
                qMExoWrapperMediaPlayer.seekTo(j);
                this.mSeekWhenPrepared = 0L;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataSourceInternal(String str) throws IOException {
        resetInternal();
        this.mMediaPlayer.setDataSource(str);
        this.mMediaPlayer.setOnSeekCompleteListener(this.mSeekCompleteListener);
        this.mMediaPlayer.setOnPreparedListener(this.mPreparedListener);
        this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
        this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
        this.mMediaPlayer.setOnInfoListener(this.mInfoListener);
        this.mCurrentState = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataSourceInternal(List<AudioPlayData> list) {
        resetInternal();
        try {
            if (!structureRealData(list)) {
                IMediaPlayer.OnErrorListener onErrorListener = this.mErrorListener;
                if (onErrorListener != null) {
                    onErrorListener.onError(null, -1, -1);
                    return;
                }
                return;
            }
            AudioPlayData audioPlayData = list.get(0);
            if (audioPlayData != null) {
                this.mMediaPlayer.setVolume(audioPlayData.volume);
            }
            this.mMediaPlayer.setAudioDataSource(list);
            this.mMediaPlayer.setOnSeekCompleteListener(this.mSeekCompleteListener);
            this.mMediaPlayer.setOnPreparedListener(this.mPreparedListener);
            this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
            this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
            this.mMediaPlayer.setOnInfoListener(this.mInfoListener);
            this.mCurrentState = 1;
        } catch (Exception unused) {
            IMediaPlayer.OnErrorListener onErrorListener2 = this.mErrorListener;
            if (onErrorListener2 != null) {
                onErrorListener2.onError(null, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVolumeInternal(float f) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setVolume(f);
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
                this.mCurrentState = 4;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.mTargetState = 4;
    }

    private boolean structureRealData(List<AudioPlayData> list) throws Exception {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        AudioPlayData audioPlayData = null;
        for (int i = 0; i < list.size(); i++) {
            AudioPlayData audioPlayData2 = list.get(i);
            if (!TextUtils.isEmpty(audioPlayData2.audioPath)) {
                mediaMetadataRetriever.setDataSource(audioPlayData2.audioPath);
                int b = jab.b(mediaMetadataRetriever.extractMetadata(9), 0);
                audioPlayData2.realDuration = b;
                if (audioPlayData == null) {
                    if (b <= 0) {
                    }
                    audioPlayData = audioPlayData2;
                } else {
                    if (b <= audioPlayData.realDuration) {
                    }
                    audioPlayData = audioPlayData2;
                }
            }
        }
        mediaMetadataRetriever.release();
        if (audioPlayData == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            AudioPlayData audioPlayData3 = list.get(i3);
            int i4 = audioPlayData3.end - audioPlayData3.start;
            if (i4 < 0) {
                return false;
            }
            if (i4 != 0) {
                if (TextUtils.isEmpty(audioPlayData3.audioPath)) {
                    int i5 = audioPlayData.realDuration;
                    int i6 = i4 / i5;
                    int i7 = i4 % i5;
                    for (int i8 = 0; i8 < i6; i8++) {
                        AudioPlayData audioPlayData4 = new AudioPlayData(audioPlayData.audioPath, 0, audioPlayData.end, 0.0f);
                        audioPlayData4.realDuration = audioPlayData.realDuration;
                        i2 += audioPlayData.end;
                        audioPlayData4.relativeMaxDuration = i2;
                        arrayList.add(audioPlayData4);
                    }
                    if (i7 > 0) {
                        audioPlayData3 = new AudioPlayData(audioPlayData.audioPath, 0, i7, 0.0f);
                        audioPlayData3.realDuration = audioPlayData.realDuration;
                        i2 += i7;
                    }
                } else {
                    i2 = (i2 + audioPlayData3.end) - audioPlayData3.start;
                }
                audioPlayData3.relativeMaxDuration = i2;
                arrayList.add(audioPlayData3);
            }
        }
        list.clear();
        list.addAll(arrayList);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVolume(long j) {
        if (j <= 0 || this.handledAudioList == null) {
            return;
        }
        for (int i = 0; i < this.handledAudioList.size(); i++) {
            AudioPlayData audioPlayData = this.handledAudioList.get(i);
            if (audioPlayData.relativeMaxDuration >= j) {
                float volume = this.mMediaPlayer.getVolume();
                float f = audioPlayData.volume;
                if (volume != f) {
                    setVolume(f);
                    return;
                }
                return;
            }
        }
    }

    public void cancelProgressTimer() {
        Timer timer = this.mUpdateProgressTimer;
        if (timer != null) {
            timer.cancel();
        }
        ProgressTimerTask progressTimerTask = this.mProgressTimerTask;
        if (progressTimerTask != null) {
            progressTimerTask.cancel();
        }
    }

    public long getCurrentPosition() {
        QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = this.mMediaPlayer;
        if (!isInPlaybackState() || qMExoWrapperMediaPlayer == null) {
            return -1L;
        }
        return qMExoWrapperMediaPlayer.getCurrentPosition();
    }

    public long getDuration() {
        QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = this.mMediaPlayer;
        if (!isInPlaybackState() || qMExoWrapperMediaPlayer == null) {
            return -1L;
        }
        return qMExoWrapperMediaPlayer.getDuration();
    }

    public IMediaPlayer.OnSeekCompleteListener getOnSeekCompleteListener() {
        return this.mOnSeekCompleteListener;
    }

    public float getVolume() {
        if (this.mMediaPlayer != null) {
            return this.mMediaPlayer.getVolume();
        }
        return -1.0f;
    }

    public boolean isMute() {
        return this.isMute;
    }

    public boolean isPlaying() {
        QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = this.mMediaPlayer;
        return isInPlaybackState() && qMExoWrapperMediaPlayer != null && qMExoWrapperMediaPlayer.isPlaying();
    }

    public void pause() {
        schedule(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.6
            @Override // java.lang.Runnable
            public void run() {
                VLogAudioPlayer.this.pauseInternal();
            }
        });
        cancelProgressTimer();
    }

    public void prepareAsync() {
        if (this.mMediaPlayer == null) {
            this.mErrorListener.onError(null, -1, -1);
        } else {
            schedule(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.4
                @Override // java.lang.Runnable
                public void run() {
                    VLogAudioPlayer.this.prepareAsyncInternal();
                }
            });
        }
    }

    public void release() {
        schedule(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.9
            @Override // java.lang.Runnable
            public void run() {
                VLogAudioPlayer.this.releaseInternal();
            }
        });
        cancelProgressTimer();
    }

    public void reset() {
        schedule(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.8
            @Override // java.lang.Runnable
            public void run() {
                VLogAudioPlayer.this.resetInternal();
            }
        });
        cancelProgressTimer();
    }

    public void seekTo(final long j) {
        this.mSeekWhenPrepared = j;
        schedule(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.7
            @Override // java.lang.Runnable
            public void run() {
                VLogAudioPlayer.this.seekToInternal(j);
            }
        });
    }

    public void setDataSource(final String str) {
        schedule(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    VLogAudioPlayer.this.setDataSourceInternal(str);
                } catch (IOException unused) {
                    if (VLogAudioPlayer.this.mErrorListener != null) {
                        VLogAudioPlayer.this.mErrorListener.onError(null, -1, -1);
                    }
                }
            }
        });
    }

    public void setDataSource(final List<AudioPlayData> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        schedule(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.3
            @Override // java.lang.Runnable
            public void run() {
                if (VLogAudioPlayer.this.handledAudioList == null) {
                    VLogAudioPlayer.this.handledAudioList = new ArrayList();
                }
                VLogAudioPlayer.this.handledAudioList.clear();
                for (int i = 0; i < list.size(); i++) {
                    AudioPlayData audioPlayData = (AudioPlayData) list.get(i);
                    if (audioPlayData != null) {
                        VLogAudioPlayer.this.handledAudioList.add(audioPlayData.m155clone());
                    }
                }
                VLogAudioPlayer vLogAudioPlayer = VLogAudioPlayer.this;
                vLogAudioPlayer.setDataSourceInternal(vLogAudioPlayer.handledAudioList);
            }
        });
    }

    public void setMute(boolean z) {
        fab.e(TAG, "设置静音");
        this.isMute = z;
        setVolume(0.0f);
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

    public void setOnProgressListener(OnProgressListener onProgressListener) {
        this.mOnProgressListener = onProgressListener;
    }

    public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    public void setVolume(final float f) {
        schedule(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.10
            @Override // java.lang.Runnable
            public void run() {
                fab.e(VLogAudioPlayer.TAG, "设置音量为 = " + f);
                VLogAudioPlayer.this.setVolumeInternal(f);
            }
        });
    }

    public void setVolume(int i, float f) {
        AudioPlayData audioPlayData;
        List<AudioPlayData> list = this.handledAudioList;
        if (list == null || i < 0 || f < 0.0f || list.size() <= i || (audioPlayData = this.handledAudioList.get(i)) == null) {
            return;
        }
        audioPlayData.volume = f;
    }

    public void start() {
        if (this.mMediaPlayer == null) {
            this.mErrorListener.onError(null, -1, -1);
            return;
        }
        schedule(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.5
            @Override // java.lang.Runnable
            public void run() {
                VLogAudioPlayer.this.startInternal();
            }
        });
        startProgressTimer();
    }

    public void startProgressTimer() {
        cancelProgressTimer();
        this.mUpdateProgressTimer = new Timer();
        ProgressTimerTask progressTimerTask = new ProgressTimerTask();
        this.mProgressTimerTask = progressTimerTask;
        this.mUpdateProgressTimer.schedule(progressTimerTask, 0L, 50L);
    }
}
