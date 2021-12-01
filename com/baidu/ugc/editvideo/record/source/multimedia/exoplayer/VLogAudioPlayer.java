package com.baidu.ugc.editvideo.record.source.multimedia.exoplayer;

import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.x0.t.c;
import c.a.x0.t.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceTimerManager;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes11.dex */
public class VLogAudioPlayer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_ERROR = -1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_INITIALIZED = 1;
    public static final int STATE_PAUSED = 5;
    public static final int STATE_PLAYBACK_COMPLETED = 6;
    public static final int STATE_PLAYING = 4;
    public static final int STATE_PREPARED = 3;
    public static final int STATE_PREPARING = 2;
    public static final String TAG = "VLogAudioPlayerTag";
    public transient /* synthetic */ FieldHolder $fh;
    public List<AudioPlayData> handledAudioList;
    public boolean isMute;
    public IMediaPlayer.OnCompletionListener mCompletionListener;
    public volatile int mCurrentState;
    public IMediaPlayer.OnErrorListener mErrorListener;
    public IMediaPlayer.OnInfoListener mInfoListener;
    public volatile QMExoWrapperMediaPlayer mMediaPlayer;
    public volatile IMediaPlayer.OnCompletionListener mOnCompletionListener;
    public volatile IMediaPlayer.OnErrorListener mOnErrorListener;
    public volatile IMediaPlayer.OnInfoListener mOnInfoListener;
    public volatile IMediaPlayer.OnPreparedListener mOnPreparedListener;
    public volatile OnProgressListener mOnProgressListener;
    public volatile IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    public Handler mPlayerHandler;
    public IMediaPlayer.OnPreparedListener mPreparedListener;
    public ProgressTimerTask mProgressTimerTask;
    public IMediaPlayer.OnSeekCompleteListener mSeekCompleteListener;
    public volatile long mSeekWhenPrepared;
    public volatile int mTargetState;
    public Timer mUpdateProgressTimer;

    /* loaded from: classes11.dex */
    public interface OnProgressListener {
        void getCurrentDuration(long j2);
    }

    /* loaded from: classes11.dex */
    public class ProgressTimerTask extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VLogAudioPlayer this$0;

        public ProgressTimerTask(VLogAudioPlayer vLogAudioPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vLogAudioPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = vLogAudioPlayer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            OnProgressListener onProgressListener;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long j2 = 0;
                if (this.this$0.mCurrentState == -1 || this.this$0.mCurrentState == 0 || this.this$0.mCurrentState == 1 || this.this$0.mCurrentState == 2 || this.this$0.mCurrentState == 3) {
                    if (this.this$0.mOnProgressListener == null) {
                        return;
                    }
                } else if (this.this$0.mMediaPlayer != null) {
                    c.e(VLogAudioPlayer.TAG, "是否静音：" + this.this$0.isMute);
                    if (!this.this$0.isMute) {
                        try {
                            this.this$0.updateVolume(this.this$0.mMediaPlayer.getCurrentPosition());
                        } catch (Exception unused) {
                        }
                    } else if (this.this$0.mMediaPlayer.getVolume() != 0.0f) {
                        this.this$0.mMediaPlayer.setVolume(0.0f);
                    }
                    if (this.this$0.mOnProgressListener != null) {
                        onProgressListener = this.this$0.mOnProgressListener;
                        j2 = this.this$0.mMediaPlayer.getCurrentPosition();
                        onProgressListener.getCurrentDuration(j2);
                    }
                    return;
                } else if (this.this$0.mOnProgressListener == null) {
                    return;
                }
                onProgressListener = this.this$0.mOnProgressListener;
                onProgressListener.getCurrentDuration(j2);
            }
        }
    }

    public VLogAudioPlayer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mInfoListener = new IMediaPlayer.OnInfoListener(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VLogAudioPlayer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnInfoListener
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i4, int i5) {
                InterceptResult invokeLII;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, iMediaPlayer, i4, i5)) == null) {
                    this.this$0.notifyInfo(iMediaPlayer, i4, i5);
                    return false;
                }
                return invokeLII.booleanValue;
            }
        };
        this.mCompletionListener = new IMediaPlayer.OnCompletionListener(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VLogAudioPlayer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnCompletionListener
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, iMediaPlayer) == null) {
                    if (this.this$0.mTargetState != 5) {
                        this.this$0.mCurrentState = 6;
                        this.this$0.mTargetState = 6;
                    }
                    this.this$0.notifyCompletion(iMediaPlayer);
                }
            }
        };
        this.mErrorListener = new IMediaPlayer.OnErrorListener(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VLogAudioPlayer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnErrorListener
            public boolean onError(IMediaPlayer iMediaPlayer, int i4, int i5) {
                InterceptResult invokeLII;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, iMediaPlayer, i4, i5)) == null) {
                    this.this$0.mCurrentState = -1;
                    this.this$0.mTargetState = -1;
                    this.this$0.notifyError(iMediaPlayer, i4, i5);
                    return false;
                }
                return invokeLII.booleanValue;
            }
        };
        this.mSeekCompleteListener = new IMediaPlayer.OnSeekCompleteListener(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VLogAudioPlayer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(IMediaPlayer iMediaPlayer) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, iMediaPlayer) == null) {
                    this.this$0.notifySeekComplete(iMediaPlayer);
                }
            }
        };
        this.mPreparedListener = new IMediaPlayer.OnPreparedListener(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VLogAudioPlayer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnPreparedListener
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, iMediaPlayer) == null) {
                    this.this$0.mCurrentState = 3;
                    long j2 = this.this$0.mSeekWhenPrepared;
                    if (j2 != 0) {
                        this.this$0.seekTo(j2);
                    }
                    this.this$0.notifyPrepared(iMediaPlayer);
                    if (this.this$0.mTargetState == 4) {
                        this.this$0.start();
                    }
                }
            }
        };
        this.mPlayerHandler = new Handler(MultiMediaDataSourceTimerManager.getInstance().getPlayerLooper());
        schedule(new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VLogAudioPlayer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.createAudioPlayer();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAudioPlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.release();
            }
            this.mMediaPlayer = new QMExoWrapperMediaPlayer();
        }
    }

    private boolean isInPlaybackState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) ? (this.mMediaPlayer == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1 || this.mCurrentState == 2) ? false : true : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCompletion(IMediaPlayer iMediaPlayer) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65566, this, iMediaPlayer) == null) || this.mOnCompletionListener == null) {
            return;
        }
        this.mOnCompletionListener.onCompletion(iMediaPlayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyError(IMediaPlayer iMediaPlayer, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65567, this, iMediaPlayer, i2, i3) == null) || this.mOnErrorListener == null) {
            return;
        }
        this.mOnErrorListener.onError(iMediaPlayer, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyInfo(IMediaPlayer iMediaPlayer, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65568, this, iMediaPlayer, i2, i3) == null) || this.mOnInfoListener == null) {
            return;
        }
        this.mOnInfoListener.onInfo(iMediaPlayer, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPrepared(IMediaPlayer iMediaPlayer) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65569, this, iMediaPlayer) == null) || this.mOnPreparedListener == null) {
            return;
        }
        this.mOnPreparedListener.onPrepared(iMediaPlayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySeekComplete(IMediaPlayer iMediaPlayer) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65570, this, iMediaPlayer) == null) || this.mOnSeekCompleteListener == null) {
            return;
        }
        this.mOnSeekCompleteListener.onSeekComplete(iMediaPlayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = this.mMediaPlayer;
            if (isInPlaybackState() && qMExoWrapperMediaPlayer != null) {
                try {
                    qMExoWrapperMediaPlayer.pause();
                    this.mCurrentState = 5;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.mTargetState = 5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareAsyncInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            this.mMediaPlayer.prepareAsync();
            this.mCurrentState = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.reset();
            }
            this.mCurrentState = 0;
            this.mTargetState = 0;
            this.mSeekWhenPrepared = 0L;
        }
    }

    private void schedule(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65575, this, runnable) == null) {
            if (Looper.myLooper() != MultiMediaDataSourceTimerManager.getInstance().getPlayerLooper()) {
                this.mPlayerHandler.post(runnable);
            } else {
                runnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seekToInternal(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65576, this, j2) == null) {
            this.mSeekWhenPrepared = j2;
            try {
                QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = this.mMediaPlayer;
                if (!isInPlaybackState() || qMExoWrapperMediaPlayer == null) {
                    this.mSeekWhenPrepared = j2;
                } else {
                    qMExoWrapperMediaPlayer.seekTo(j2);
                    this.mSeekWhenPrepared = 0L;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataSourceInternal(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65577, this, str) == null) {
            resetInternal();
            this.mMediaPlayer.setDataSource(str);
            this.mMediaPlayer.setOnSeekCompleteListener(this.mSeekCompleteListener);
            this.mMediaPlayer.setOnPreparedListener(this.mPreparedListener);
            this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
            this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
            this.mMediaPlayer.setOnInfoListener(this.mInfoListener);
            this.mCurrentState = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataSourceInternal(List<AudioPlayData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65578, this, list) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVolumeInternal(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(65579, this, f2) == null) || this.mMediaPlayer == null) {
            return;
        }
        this.mMediaPlayer.setVolume(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, this) == null) {
            if (isInPlaybackState()) {
                try {
                    QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = this.mMediaPlayer;
                    if (!qMExoWrapperMediaPlayer.isPlaying()) {
                        qMExoWrapperMediaPlayer.start();
                    }
                    this.mCurrentState = 4;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.mTargetState = 4;
        }
    }

    private boolean structureRealData(List<AudioPlayData> list) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, this, list)) == null) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            AudioPlayData audioPlayData = null;
            for (int i2 = 0; i2 < list.size(); i2++) {
                AudioPlayData audioPlayData2 = list.get(i2);
                if (!TextUtils.isEmpty(audioPlayData2.audioPath)) {
                    mediaMetadataRetriever.setDataSource(audioPlayData2.audioPath);
                    int b2 = g.b(mediaMetadataRetriever.extractMetadata(9), 0);
                    audioPlayData2.realDuration = b2;
                    if (audioPlayData == null) {
                        if (b2 <= 0) {
                        }
                        audioPlayData = audioPlayData2;
                    } else {
                        if (b2 <= audioPlayData.realDuration) {
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
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                AudioPlayData audioPlayData3 = list.get(i4);
                int i5 = audioPlayData3.end - audioPlayData3.start;
                if (i5 < 0) {
                    return false;
                }
                if (i5 != 0) {
                    if (TextUtils.isEmpty(audioPlayData3.audioPath)) {
                        int i6 = audioPlayData.realDuration;
                        int i7 = i5 / i6;
                        int i8 = i5 % i6;
                        for (int i9 = 0; i9 < i7; i9++) {
                            AudioPlayData audioPlayData4 = new AudioPlayData(audioPlayData.audioPath, 0, audioPlayData.end, 0.0f);
                            audioPlayData4.realDuration = audioPlayData.realDuration;
                            i3 += audioPlayData.end;
                            audioPlayData4.relativeMaxDuration = i3;
                            arrayList.add(audioPlayData4);
                        }
                        if (i8 > 0) {
                            audioPlayData3 = new AudioPlayData(audioPlayData.audioPath, 0, i8, 0.0f);
                            audioPlayData3.realDuration = audioPlayData.realDuration;
                            i3 += i8;
                        }
                    } else {
                        i3 = (i3 + audioPlayData3.end) - audioPlayData3.start;
                    }
                    audioPlayData3.relativeMaxDuration = i3;
                    arrayList.add(audioPlayData3);
                }
            }
            list.clear();
            list.addAll(arrayList);
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVolume(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65582, this, j2) == null) || j2 <= 0 || this.handledAudioList == null) {
            return;
        }
        for (int i2 = 0; i2 < this.handledAudioList.size(); i2++) {
            AudioPlayData audioPlayData = this.handledAudioList.get(i2);
            if (audioPlayData.relativeMaxDuration >= j2) {
                float volume = this.mMediaPlayer.getVolume();
                float f2 = audioPlayData.volume;
                if (volume != f2) {
                    setVolume(f2);
                    return;
                }
                return;
            }
        }
    }

    public void cancelProgressTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Timer timer = this.mUpdateProgressTimer;
            if (timer != null) {
                timer.cancel();
            }
            ProgressTimerTask progressTimerTask = this.mProgressTimerTask;
            if (progressTimerTask != null) {
                progressTimerTask.cancel();
            }
        }
    }

    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = this.mMediaPlayer;
            if (!isInPlaybackState() || qMExoWrapperMediaPlayer == null) {
                return -1L;
            }
            return qMExoWrapperMediaPlayer.getCurrentPosition();
        }
        return invokeV.longValue;
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = this.mMediaPlayer;
            if (!isInPlaybackState() || qMExoWrapperMediaPlayer == null) {
                return -1L;
            }
            return qMExoWrapperMediaPlayer.getDuration();
        }
        return invokeV.longValue;
    }

    public IMediaPlayer.OnSeekCompleteListener getOnSeekCompleteListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mOnSeekCompleteListener : (IMediaPlayer.OnSeekCompleteListener) invokeV.objValue;
    }

    public float getVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mMediaPlayer != null) {
                return this.mMediaPlayer.getVolume();
            }
            return -1.0f;
        }
        return invokeV.floatValue;
    }

    public boolean isMute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.isMute : invokeV.booleanValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = this.mMediaPlayer;
            return isInPlaybackState() && qMExoWrapperMediaPlayer != null && qMExoWrapperMediaPlayer.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            schedule(new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VLogAudioPlayer this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.pauseInternal();
                    }
                }
            });
            cancelProgressTimer();
        }
    }

    public void prepareAsync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.mMediaPlayer == null) {
                this.mErrorListener.onError(null, -1, -1);
            } else {
                schedule(new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ VLogAudioPlayer this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.prepareAsyncInternal();
                        }
                    }
                });
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            schedule(new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VLogAudioPlayer this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.releaseInternal();
                    }
                }
            });
            cancelProgressTimer();
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            schedule(new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VLogAudioPlayer this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.resetInternal();
                    }
                }
            });
            cancelProgressTimer();
        }
    }

    public void seekTo(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) {
            this.mSeekWhenPrepared = j2;
            schedule(new Runnable(this, j2) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VLogAudioPlayer this$0;
                public final /* synthetic */ long val$pos;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$pos = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.seekToInternal(this.val$pos);
                    }
                }
            });
        }
    }

    public void setDataSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            schedule(new Runnable(this, str) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VLogAudioPlayer this$0;
                public final /* synthetic */ String val$path;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$path = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.this$0.setDataSourceInternal(this.val$path);
                        } catch (IOException unused) {
                            if (this.this$0.mErrorListener != null) {
                                this.this$0.mErrorListener.onError(null, -1, -1);
                            }
                        }
                    }
                }
            });
        }
    }

    public void setDataSource(List<AudioPlayData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        schedule(new Runnable(this, list) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VLogAudioPlayer this$0;
            public final /* synthetic */ List val$playDataList;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, list};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$playDataList = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.this$0.handledAudioList == null) {
                        this.this$0.handledAudioList = new ArrayList();
                    }
                    this.this$0.handledAudioList.clear();
                    for (int i2 = 0; i2 < this.val$playDataList.size(); i2++) {
                        AudioPlayData audioPlayData = (AudioPlayData) this.val$playDataList.get(i2);
                        if (audioPlayData != null) {
                            this.this$0.handledAudioList.add(audioPlayData.m92clone());
                        }
                    }
                    VLogAudioPlayer vLogAudioPlayer = this.this$0;
                    vLogAudioPlayer.setDataSourceInternal(vLogAudioPlayer.handledAudioList);
                }
            }
        });
    }

    public void setMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            c.e(TAG, "设置静音");
            this.isMute = z;
            setVolume(0.0f);
        }
    }

    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onCompletionListener) == null) {
            this.mOnCompletionListener = onCompletionListener;
        }
    }

    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onErrorListener) == null) {
            this.mOnErrorListener = onErrorListener;
        }
    }

    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onInfoListener) == null) {
            this.mOnInfoListener = onInfoListener;
        }
    }

    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onPreparedListener) == null) {
            this.mOnPreparedListener = onPreparedListener;
        }
    }

    public void setOnProgressListener(OnProgressListener onProgressListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onProgressListener) == null) {
            this.mOnProgressListener = onProgressListener;
        }
    }

    public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onSeekCompleteListener) == null) {
            this.mOnSeekCompleteListener = onSeekCompleteListener;
        }
    }

    public void setVolume(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f2) == null) {
            schedule(new Runnable(this, f2) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VLogAudioPlayer this$0;
                public final /* synthetic */ float val$volume;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Float.valueOf(f2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$volume = f2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        c.e(VLogAudioPlayer.TAG, "设置音量为 = " + this.val$volume);
                        this.this$0.setVolumeInternal(this.val$volume);
                    }
                }
            });
        }
    }

    public void setVolume(int i2, float f2) {
        List<AudioPlayData> list;
        AudioPlayData audioPlayData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || (list = this.handledAudioList) == null || i2 < 0 || f2 < 0.0f || list.size() <= i2 || (audioPlayData = this.handledAudioList.get(i2)) == null) {
            return;
        }
        audioPlayData.volume = f2;
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.mMediaPlayer == null) {
                this.mErrorListener.onError(null, -1, -1);
                return;
            }
            schedule(new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogAudioPlayer.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VLogAudioPlayer this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.startInternal();
                    }
                }
            });
            startProgressTimer();
        }
    }

    public void startProgressTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            cancelProgressTimer();
            this.mUpdateProgressTimer = new Timer();
            ProgressTimerTask progressTimerTask = new ProgressTimerTask(this);
            this.mProgressTimerTask = progressTimerTask;
            this.mUpdateProgressTimer.schedule(progressTimerTask, 0L, 50L);
        }
    }
}
