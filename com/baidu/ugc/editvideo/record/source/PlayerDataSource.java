package com.baidu.ugc.editvideo.record.source;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import c.a.x0.t.c;
import c.a.x0.t.h;
import c.a.x0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.IPlayer;
import com.baidu.ugc.editvideo.player.VideoPlayData;
import com.baidu.ugc.editvideo.record.source.IDataSourceView;
import com.baidu.ugc.editvideo.record.source.IMediaDataSource;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class PlayerDataSource implements IMediaDataSource.IPlayerDataSource {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_IDLE = 0;
    public static final int STATE_PAUSED = 4;
    public static final int STATE_PLAYBACK_COMPLETED = 5;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_PREPARED = 2;
    public static final int STATE_PREPARING = 1;
    public static final int STATE_STOP = 6;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isReportError;
    public volatile int mCurrentState;
    public IPlayer mMediaPlayer;
    public String mPath;
    public List<VideoPlayData> mPathList;
    public long mSeekWhenPrepared;
    public List<IDataSourceView.IPlayerDataSourceView> mSourceViewList;
    public float mSpeed;
    public Surface mSurface;
    public volatile int mTargetState;
    public int mVideoHeight;
    public int mVideoWidth;
    public OnPlayStateListener onPlayStateListener;

    /* loaded from: classes8.dex */
    public interface OnPlayStateListener {
        void pause();

        void play();
    }

    public PlayerDataSource(IPlayer iPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iPlayer};
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
        this.mSpeed = 1.0f;
        this.isReportError = false;
        this.mMediaPlayer = iPlayer;
        this.mSourceViewList = new ArrayList();
        initPlayer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createPlayer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, this, z) == null) {
            if (w.a(this.mPath) && h.e(this.mPathList)) {
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
            } catch (Exception e2) {
                c.g(e2);
                this.mMediaPlayer = null;
                this.mPath = null;
                this.mPathList = null;
                this.mCurrentState = 0;
                this.mTargetState = 0;
                for (int i2 = 0; i2 < this.mSourceViewList.size(); i2++) {
                    this.mSourceViewList.get(i2).onError(null, -1, -1, e2);
                }
            }
        }
    }

    private VideoPlayData getCurrentPlayData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            if (h.e(this.mPathList)) {
                return null;
            }
            long currentPosition = getCurrentPosition();
            for (VideoPlayData videoPlayData : this.mPathList) {
                if (videoPlayData != null) {
                    int i2 = videoPlayData.offset;
                    if (i2 <= currentPosition && (i2 + videoPlayData.end) - videoPlayData.start >= currentPosition) {
                        return videoPlayData;
                    }
                }
            }
            return null;
        }
        return (VideoPlayData) invokeV.objValue;
    }

    private void initPlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.mMediaPlayer.setOnPlayerPreparedListener(new IPlayer.OnPlayerPreparedListener(this) { // from class: com.baidu.ugc.editvideo.record.source.PlayerDataSource.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PlayerDataSource this$0;

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

                @Override // com.baidu.ugc.editvideo.player.IPlayer.OnPlayerPreparedListener
                public void onPrepared(IPlayer iPlayer) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, iPlayer) == null) {
                        this.this$0.mMediaPlayer.setPlaybackSpeed(1.0f / this.this$0.mSpeed);
                        this.this$0.mCurrentState = 2;
                        if (this.this$0.mSeekWhenPrepared != 0) {
                            PlayerDataSource playerDataSource = this.this$0;
                            playerDataSource.seekToForce(playerDataSource.mSeekWhenPrepared);
                        }
                        this.this$0.mMediaPlayer.setSurface(this.this$0.mSurface);
                        for (int i2 = 0; i2 < this.this$0.mSourceViewList.size(); i2++) {
                            ((IDataSourceView.IPlayerDataSourceView) this.this$0.mSourceViewList.get(i2)).onPrepared(iPlayer);
                        }
                        if (this.this$0.mTargetState == 3) {
                            this.this$0.start();
                        }
                    }
                }
            });
            this.mMediaPlayer.setOnPlayerVideoSizeChangedListener(new IPlayer.OnPlayerVideoSizeChangedListener(this) { // from class: com.baidu.ugc.editvideo.record.source.PlayerDataSource.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PlayerDataSource this$0;

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

                @Override // com.baidu.ugc.editvideo.player.IPlayer.OnPlayerVideoSizeChangedListener
                public void onVideoSizeChanged(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048576, this, i2, i3) == null) {
                        this.this$0.mVideoWidth = i2;
                        this.this$0.mVideoHeight = i3;
                        for (int i4 = 0; i4 < this.this$0.mSourceViewList.size(); i4++) {
                            ((IDataSourceView.IPlayerDataSourceView) this.this$0.mSourceViewList.get(i4)).onVideoSizeChanged(i2, i3);
                        }
                    }
                }
            });
            this.mMediaPlayer.setOnPlayerCompletionListener(new IPlayer.OnPlayerCompletionListener(this) { // from class: com.baidu.ugc.editvideo.record.source.PlayerDataSource.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PlayerDataSource this$0;

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

                @Override // com.baidu.ugc.editvideo.player.IPlayer.OnPlayerCompletionListener
                public void onCompletion(IPlayer iPlayer) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, iPlayer) == null) {
                        for (int i2 = 0; i2 < this.this$0.mSourceViewList.size(); i2++) {
                            ((IDataSourceView.IPlayerDataSourceView) this.this$0.mSourceViewList.get(i2)).onCompletion(iPlayer);
                        }
                        this.this$0.mCurrentState = 5;
                    }
                }
            });
            this.mMediaPlayer.setOnPlayerPlayStateListener(new IPlayer.OnPlayerPlayStateListener(this) { // from class: com.baidu.ugc.editvideo.record.source.PlayerDataSource.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PlayerDataSource this$0;

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

                @Override // com.baidu.ugc.editvideo.player.IPlayer.OnPlayerPlayStateListener
                public void onStateChange(IPlayer iPlayer, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iPlayer, i2) == null) {
                        for (int i3 = 0; i3 < this.this$0.mSourceViewList.size(); i3++) {
                            ((IDataSourceView.IPlayerDataSourceView) this.this$0.mSourceViewList.get(i3)).onPlayStateListener(iPlayer, i2);
                        }
                    }
                }
            });
            this.mMediaPlayer.setOnPlayerInfoListener(new IPlayer.OnPlayerInfoListener(this) { // from class: com.baidu.ugc.editvideo.record.source.PlayerDataSource.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PlayerDataSource this$0;

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

                @Override // com.baidu.ugc.editvideo.player.IPlayer.OnPlayerInfoListener
                public boolean onInfo(IPlayer iPlayer, int i2, int i3) {
                    InterceptResult invokeLII;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, iPlayer, i2, i3)) == null) {
                        for (int i4 = 0; i4 < this.this$0.mSourceViewList.size(); i4++) {
                            ((IDataSourceView.IPlayerDataSourceView) this.this$0.mSourceViewList.get(i4)).onInfo(iPlayer, i2, i3);
                        }
                        return false;
                    }
                    return invokeLII.booleanValue;
                }
            });
            this.mMediaPlayer.setOnPlayerErrorListener(new IPlayer.OnPlayerErrorListener(this) { // from class: com.baidu.ugc.editvideo.record.source.PlayerDataSource.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PlayerDataSource this$0;

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

                @Override // com.baidu.ugc.editvideo.player.IPlayer.OnPlayerErrorListener
                public boolean onError(IPlayer iPlayer, int i2, int i3, Exception exc) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{iPlayer, Integer.valueOf(i2), Integer.valueOf(i3), exc})) == null) {
                        if (!this.this$0.isReportError) {
                            for (int i4 = 0; i4 < this.this$0.mSourceViewList.size(); i4++) {
                                ((IDataSourceView.IPlayerDataSourceView) this.this$0.mSourceViewList.get(i4)).onError(iPlayer, i2, i3, exc);
                            }
                            this.this$0.isReportError = true;
                        }
                        if (exc != null) {
                            this.this$0.createPlayer(false);
                            return this.this$0.mMediaPlayer != null;
                        }
                        return false;
                    }
                    return invokeCommon.booleanValue;
                }
            });
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void addIPlayerDataSourceView(IDataSourceView.IPlayerDataSourceView iPlayerDataSourceView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iPlayerDataSourceView) == null) {
            this.mSourceViewList.add(iPlayerDataSourceView);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (isInPlaybackState()) {
                return this.mMediaPlayer.getCurrentPosition();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            IPlayer iPlayer = this.mMediaPlayer;
            if (iPlayer == null) {
                return 0L;
            }
            return iPlayer.getDuration();
        }
        return invokeV.longValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mVideoHeight : invokeV.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public String getVideoPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPath : (String) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public List<VideoPlayData> getVideoPathList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPathList : (List) invokeV.objValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mVideoWidth : invokeV.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            IPlayer iPlayer = this.mMediaPlayer;
            if (iPlayer != null) {
                return iPlayer.isEnd();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public boolean isInOriginalRange() {
        InterceptResult invokeV;
        VideoPlayData currentPlayData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.mMediaPlayer == null || (currentPlayData = getCurrentPlayData()) == null) {
                return true;
            }
            return currentPlayData.isOriginal;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public boolean isInPlaybackState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (this.mMediaPlayer == null || this.mCurrentState == 0 || this.mCurrentState == 1 || this.mCurrentState == 6) ? false : true : invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? isInPlaybackState() && this.mMediaPlayer.isPlaying() : invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public boolean isSameSpeed(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048587, this, f2)) == null) {
            if (isInPlaybackState()) {
                float playbackSpeed = this.mMediaPlayer.getPlaybackSpeed();
                return playbackSpeed <= 0.0f || Math.abs((1.0f / playbackSpeed) - f2) <= 0.05f;
            }
            return false;
        }
        return invokeF.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            release();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
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
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource
    public void onSurfaceHolderCreate(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, surfaceHolder) == null) || surfaceHolder == null) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, surfaceTexture) == null) || surfaceTexture == null) {
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
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
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
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
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
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.mCurrentState == 0 && this.mTargetState == 0) {
                return;
            }
            this.mMediaPlayer.reset();
            this.mCurrentState = 0;
            this.mTargetState = 0;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void seekTo(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j2) == null) {
            if (isInPlaybackState()) {
                this.mMediaPlayer.seekTo(j2);
                this.mSeekWhenPrepared = 0L;
                return;
            }
            this.mSeekWhenPrepared = j2;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void seekToForce(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j2) == null) {
            if (isInPlaybackState()) {
                this.mMediaPlayer.seekToForce(j2);
                this.mSeekWhenPrepared = 0L;
                return;
            }
            this.mSeekWhenPrepared = j2;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void setLooping(boolean z) {
        IPlayer iPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || (iPlayer = this.mMediaPlayer) == null) {
            return;
        }
        iPlayer.setLooping(z);
    }

    public void setOnPlayStateListener(OnPlayStateListener onPlayStateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onPlayStateListener) == null) {
            this.onPlayStateListener = onPlayStateListener;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048600, this, f2) == null) {
            this.mSpeed = f2;
            if (this.mMediaPlayer == null || isSameSpeed(f2)) {
                return;
            }
            this.mMediaPlayer.setPlaybackSpeed(1.0f / this.mSpeed);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.mPath = str;
            this.mPathList = null;
            createPlayer(false);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void setVideoPathList(List<VideoPlayData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, list) == null) {
            this.mPathList = list;
            this.mPath = null;
            createPlayer(false);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void setVolume(float f2, float f3) {
        IPlayer iPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (iPlayer = this.mMediaPlayer) == null) {
            return;
        }
        iPlayer.setVolume(f2, f3);
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
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
    }

    @Override // com.baidu.ugc.editvideo.record.source.IMediaDataSource.IPlayerDataSource
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (isInPlaybackState()) {
                this.mMediaPlayer.stop();
                this.mCurrentState = 6;
            }
            this.mTargetState = 6;
        }
    }
}
