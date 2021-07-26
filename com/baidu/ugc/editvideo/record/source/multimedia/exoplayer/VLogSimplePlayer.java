package com.baidu.ugc.editvideo.record.source.multimedia.exoplayer;

import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceTimerManager;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import d.a.w0.i.c;
import d.a.w0.i.f.b;
/* loaded from: classes5.dex */
public class VLogSimplePlayer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_ERROR = -1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_PAUSED = 4;
    public static final int STATE_PLAYBACK_COMPLETED = 5;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_PREPARED = 2;
    public static final int STATE_PREPARING = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isCompatSeekToPlayCompletion;
    public Runnable mAudioChangeRunnable;
    public int[] mAudioChangeTypes;
    public boolean mAudioEffectPlayerNeedSeek;
    public volatile b mAudioPlayer;
    public IMediaPlayer.OnCompletionListener mCompletionListener;
    public volatile int mCurrentState;
    public IMediaPlayer.OnErrorListener mErrorListener;
    public IMediaPlayer.OnInfoListener mInfoListener;
    public volatile float mLeftVolume;
    public volatile QMExoWrapperMediaPlayer mMediaPlayer;
    public volatile IMediaPlayer.OnCompletionListener mOnCompletionListener;
    public volatile IMediaPlayer.OnErrorListener mOnErrorListener;
    public volatile IMediaPlayer.OnInfoListener mOnInfoListener;
    public volatile IMediaPlayer.OnPreparedListener mOnPreparedListener;
    public volatile IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    public volatile IMediaPlayer.OnSpeedChangeListener mOnSpeedChangeListener;
    public volatile String mPath;
    public Runnable mPauseRunnable;
    public Handler mPlayerHandler;
    public IMediaPlayer.OnPreparedListener mPreparedListener;
    public Runnable mReleaseRunnable;
    public Runnable mResetRunnable;
    public volatile float mRightVolume;
    public IMediaPlayer.OnSeekCompleteListener mSeekCompleteListener;
    public SeekRunnable mSeekRunnable;
    public volatile long mSeekWhenPrepared;
    public Runnable mSetDataSourceRunnable;
    public float mSpeed;
    public Runnable mStartRunnable;
    public volatile int mTargetState;
    public float mVolumeBackUp;
    public Runnable mVolumeRunnable;

    /* loaded from: classes5.dex */
    public class SeekRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long mSeekTime;
        public final /* synthetic */ VLogSimplePlayer this$0;

        public SeekRunnable(VLogSimplePlayer vLogSimplePlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vLogSimplePlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = vLogSimplePlayer;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.mSeekWhenPrepared = this.mSeekTime;
                this.this$0.seekToInternal(this.mSeekTime);
            }
        }

        public void setseekTime(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.mSeekTime = j;
            }
        }
    }

    public VLogSimplePlayer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
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
        this.mLeftVolume = 1.0f;
        this.mRightVolume = 1.0f;
        this.mAudioEffectPlayerNeedSeek = false;
        this.mSetDataSourceRunnable = new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VLogSimplePlayer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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
                    VLogSimplePlayer vLogSimplePlayer = this.this$0;
                    vLogSimplePlayer.setDataSourceInternal(vLogSimplePlayer.mPath);
                }
            }
        };
        this.mStartRunnable = new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VLogSimplePlayer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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
                    this.this$0.startInternal();
                }
            }
        };
        this.mPauseRunnable = new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VLogSimplePlayer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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
                    this.this$0.pauseInternal();
                }
            }
        };
        this.mSeekRunnable = new SeekRunnable(this);
        this.mResetRunnable = new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VLogSimplePlayer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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
                    this.this$0.resetInternal();
                }
            }
        };
        this.mReleaseRunnable = new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VLogSimplePlayer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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
                    this.this$0.releaseInternal();
                }
            }
        };
        this.mVolumeRunnable = new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VLogSimplePlayer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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
                    this.this$0.setVolumeInternal();
                }
            }
        };
        this.mInfoListener = new IMediaPlayer.OnInfoListener(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VLogSimplePlayer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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
        this.mCompletionListener = new IMediaPlayer.OnCompletionListener(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VLogSimplePlayer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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
                    if (this.this$0.mTargetState != 4) {
                        this.this$0.mCurrentState = 5;
                        this.this$0.mTargetState = 5;
                    }
                    this.this$0.notifyCompletion(iMediaPlayer);
                }
            }
        };
        this.mAudioChangeRunnable = new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VLogSimplePlayer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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
                    VLogSimplePlayer vLogSimplePlayer = this.this$0;
                    vLogSimplePlayer.setAudioChangeTypeInternal(vLogSimplePlayer.mAudioChangeTypes);
                }
            }
        };
        this.mErrorListener = new IMediaPlayer.OnErrorListener(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VLogSimplePlayer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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
        this.mSeekCompleteListener = new IMediaPlayer.OnSeekCompleteListener(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VLogSimplePlayer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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
                b bVar;
                b bVar2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, iMediaPlayer) == null) {
                    long currentPosition = iMediaPlayer.getCurrentPosition();
                    long duration = iMediaPlayer.getDuration();
                    if (currentPosition <= duration && currentPosition >= duration - 100 && !iMediaPlayer.isPlaying() && !this.this$0.isCompatSeekToPlayCompletion) {
                        iMediaPlayer.seekTo(iMediaPlayer.getDuration() - 110);
                        if (this.this$0.isAudioTypeChange() && (bVar2 = this.this$0.mAudioPlayer) != null) {
                            bVar2.w(iMediaPlayer.getCurrentPosition());
                        }
                        this.this$0.isCompatSeekToPlayCompletion = true;
                        return;
                    }
                    this.this$0.notifySeekComplete(iMediaPlayer);
                    this.this$0.isCompatSeekToPlayCompletion = false;
                    if (this.this$0.mTargetState == 3 && this.this$0.mCurrentState == 3) {
                        this.this$0.mMediaPlayer.start();
                        if (!this.this$0.isAudioTypeChange() || (bVar = this.this$0.mAudioPlayer) == null) {
                            return;
                        }
                        bVar.C();
                    }
                }
            }
        };
        this.mPreparedListener = new IMediaPlayer.OnPreparedListener(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VLogSimplePlayer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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
                    this.this$0.mCurrentState = 2;
                    long j = this.this$0.mSeekWhenPrepared;
                    if (j != 0) {
                        this.this$0.seekTo(j);
                    }
                    this.this$0.notifyPrepared(iMediaPlayer);
                    this.this$0.setVolumeInternal();
                    if (this.this$0.mTargetState == 3) {
                        this.this$0.start();
                    }
                }
            }
        };
        this.mPlayerHandler = new Handler(MultiMediaDataSourceTimerManager.getInstance().getPlayerLooper());
        this.mPath = str;
        schedule(this.mSetDataSourceRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAudioTypeChange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) ? this.mAudioPlayer != null && c.k(this.mAudioChangeTypes) : invokeV.booleanValue;
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
                    this.mCurrentState = 4;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (isAudioTypeChange()) {
                this.mAudioPlayer.pause();
            }
            this.mTargetState = 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.release();
            }
            if (isAudioTypeChange()) {
                b bVar = this.mAudioPlayer;
                if (bVar != null) {
                    bVar.D();
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetInternal() {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.reset();
            }
            if (isAudioTypeChange() && (bVar = this.mAudioPlayer) != null) {
                bVar.D();
            }
            this.mCurrentState = 0;
            this.mTargetState = 0;
            this.mSeekWhenPrepared = 0L;
        }
    }

    private void schedule(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65574, this, runnable) == null) {
            if (Looper.myLooper() != MultiMediaDataSourceTimerManager.getInstance().getPlayerLooper()) {
                this.mPlayerHandler.post(runnable);
            } else {
                runnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seekToInternal(long j) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65575, this, j) == null) {
            try {
                QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = this.mMediaPlayer;
                if (!isInPlaybackState() || qMExoWrapperMediaPlayer == null) {
                    this.mSeekWhenPrepared = j;
                } else {
                    qMExoWrapperMediaPlayer.seekTo(j);
                    qMExoWrapperMediaPlayer.pause();
                    this.mSeekWhenPrepared = 0L;
                }
                if (!isAudioTypeChange() || (bVar = this.mAudioPlayer) == null) {
                    return;
                }
                bVar.w(j);
                bVar.pause();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioChangeTypeInternal(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65576, this, iArr) == null) {
            if (this.mAudioPlayer != null || c.k(iArr)) {
                if (this.mMediaPlayer != null && (this.mAudioPlayer == null || !c.k(this.mAudioPlayer.d()))) {
                    this.mVolumeBackUp = this.mMediaPlayer.getVolume();
                }
                if (this.mAudioPlayer == null) {
                    try {
                        this.mAudioPlayer = new b(this.mPath, iArr);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (!c.k(iArr)) {
                    if (this.mAudioPlayer != null) {
                        this.mAudioPlayer.H(0.0f, 0.0f);
                    }
                    if (this.mMediaPlayer != null) {
                        this.mMediaPlayer.setVolume(this.mVolumeBackUp);
                    }
                } else if (this.mAudioPlayer != null && this.mMediaPlayer != null) {
                    this.mMediaPlayer.setVolume(0.0f);
                    if (this.mAudioEffectPlayerNeedSeek) {
                        this.mAudioPlayer.w(this.mMediaPlayer.getCurrentPosition());
                        this.mAudioEffectPlayerNeedSeek = false;
                    }
                    this.mAudioPlayer.H(this.mLeftVolume, this.mRightVolume);
                    this.mAudioPlayer.y(iArr);
                    if (this.mMediaPlayer.isPlaying()) {
                        this.mAudioPlayer.C();
                    }
                }
                if (this.mAudioPlayer != null) {
                    this.mAudioPlayer.A(this.mSpeed);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataSourceInternal(String str) {
        QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65577, this, str) == null) {
            QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer2 = null;
            try {
                qMExoWrapperMediaPlayer = new QMExoWrapperMediaPlayer();
            } catch (Exception unused) {
            }
            try {
                qMExoWrapperMediaPlayer.setDataSource(str);
                qMExoWrapperMediaPlayer.setOnSeekCompleteListener(this.mSeekCompleteListener);
                qMExoWrapperMediaPlayer.setOnPreparedListener(this.mPreparedListener);
                qMExoWrapperMediaPlayer.setOnErrorListener(this.mErrorListener);
                qMExoWrapperMediaPlayer.setOnCompletionListener(this.mCompletionListener);
                qMExoWrapperMediaPlayer.setOnInfoListener(this.mInfoListener);
                qMExoWrapperMediaPlayer.setOnSpeedChangeListener(this.mOnSpeedChangeListener);
                qMExoWrapperMediaPlayer.prepareAsync();
                this.mMediaPlayer = qMExoWrapperMediaPlayer;
                this.mCurrentState = 1;
            } catch (Exception unused2) {
                qMExoWrapperMediaPlayer2 = qMExoWrapperMediaPlayer;
                this.mErrorListener.onError(qMExoWrapperMediaPlayer2, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSurfaceInternal(Surface surface) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65578, this, surface) == null) || this.mMediaPlayer == null) {
            return;
        }
        this.mMediaPlayer.setSurface(surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVolumeInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            this.mVolumeBackUp = this.mLeftVolume;
            if (isAudioTypeChange()) {
                b bVar = this.mAudioPlayer;
                if (bVar != null) {
                    bVar.H(this.mLeftVolume, this.mRightVolume);
                    return;
                }
                return;
            }
            QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = this.mMediaPlayer;
            if (qMExoWrapperMediaPlayer != null) {
                qMExoWrapperMediaPlayer.setVolume(this.mLeftVolume, this.mRightVolume);
            }
        }
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
                    if (isAudioTypeChange()) {
                        b bVar = this.mAudioPlayer;
                        bVar.w(qMExoWrapperMediaPlayer.getCurrentPosition());
                        bVar.C();
                    }
                    this.mCurrentState = 3;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.mTargetState = 3;
        }
    }

    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = this.mMediaPlayer;
            long currentPosition = (!isInPlaybackState() || qMExoWrapperMediaPlayer == null) ? -1L : qMExoWrapperMediaPlayer.getCurrentPosition();
            return currentPosition != -1 ? ((float) currentPosition) / getSpeed() : currentPosition;
        }
        return invokeV.longValue;
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = this.mMediaPlayer;
            long duration = (!isInPlaybackState() || qMExoWrapperMediaPlayer == null) ? -1L : qMExoWrapperMediaPlayer.getDuration();
            return duration != -1 ? ((float) duration) / getSpeed() : duration;
        }
        return invokeV.longValue;
    }

    public IMediaPlayer.OnSeekCompleteListener getOnSeekCompleteListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mOnSeekCompleteListener : (IMediaPlayer.OnSeekCompleteListener) invokeV.objValue;
    }

    public float getSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mMediaPlayer == null) {
                return 1.0f;
            }
            return this.mMediaPlayer.getPlaybackSpeed();
        }
        return invokeV.floatValue;
    }

    public boolean isInPlaybackState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (this.mMediaPlayer == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true : invokeV.booleanValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            QMExoWrapperMediaPlayer qMExoWrapperMediaPlayer = this.mMediaPlayer;
            return isInPlaybackState() && qMExoWrapperMediaPlayer != null && qMExoWrapperMediaPlayer.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            schedule(this.mPauseRunnable);
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            schedule(this.mReleaseRunnable);
        }
    }

    public void releaseOnInvokeThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            releaseInternal();
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            schedule(this.mResetRunnable);
        }
    }

    public void seekTo(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.mSeekRunnable.setseekTime(j);
            schedule(this.mSeekRunnable);
        }
    }

    public void setAudioChangeType(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iArr) == null) {
            if (!c.k(this.mAudioChangeTypes) && c.k(iArr)) {
                this.mAudioEffectPlayerNeedSeek = true;
            }
            this.mAudioChangeTypes = iArr;
            schedule(this.mAudioChangeRunnable);
        }
    }

    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onCompletionListener) == null) {
            this.mOnCompletionListener = onCompletionListener;
        }
    }

    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onErrorListener) == null) {
            this.mOnErrorListener = onErrorListener;
        }
    }

    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onInfoListener) == null) {
            this.mOnInfoListener = onInfoListener;
        }
    }

    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onPreparedListener) == null) {
            this.mOnPreparedListener = onPreparedListener;
        }
    }

    public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onSeekCompleteListener) == null) {
            this.mOnSeekCompleteListener = onSeekCompleteListener;
        }
    }

    public void setOnSpeedChangeListener(IMediaPlayer.OnSpeedChangeListener onSpeedChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onSpeedChangeListener) == null) {
            this.mOnSpeedChangeListener = onSpeedChangeListener;
        }
    }

    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f2) == null) {
            schedule(new Runnable(this, f2) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VLogSimplePlayer this$0;
                public final /* synthetic */ float val$speed;

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
                    this.val$speed = f2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    b bVar;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mMediaPlayer == null) {
                        return;
                    }
                    this.this$0.mSpeed = this.val$speed;
                    this.this$0.mMediaPlayer.setPlaybackSpeed(this.val$speed);
                    if (!this.this$0.isAudioTypeChange() || (bVar = this.this$0.mAudioPlayer) == null) {
                        return;
                    }
                    bVar.A(this.val$speed);
                }
            });
        }
    }

    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, surface) == null) {
            schedule(new Runnable(this, surface) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VLogSimplePlayer this$0;
                public final /* synthetic */ Surface val$surface;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, surface};
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
                    this.val$surface = surface;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.setSurfaceInternal(this.val$surface);
                    }
                }
            });
        }
    }

    public void setVolume(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.mLeftVolume = f2;
            this.mRightVolume = f3;
            schedule(this.mVolumeRunnable);
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            schedule(this.mStartRunnable);
        }
    }
}
