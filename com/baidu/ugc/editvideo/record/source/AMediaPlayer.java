package com.baidu.ugc.editvideo.record.source;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.IPlayer;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes10.dex */
public abstract class AMediaPlayer implements IMediaPlayer {
    public static /* synthetic */ Interceptable $ic;
    public static MediaInfo sMediaInfo;
    public transient /* synthetic */ FieldHolder $fh;
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
    public int playbackState;

    public AMediaPlayer() {
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
        this.playbackState = 1;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public int getAudioSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public String getDataSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (getDataSourceUri() != null) {
                return getDataSourceUri().toString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public Uri getDataSourceUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.dataSource : (Uri) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public MediaInfo getMediaInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
        return (MediaInfo) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public int getPlaybackState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.playbackState : invokeV.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public String getUniqueID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (TextUtils.isEmpty(this.mUniqueID)) {
                this.mUniqueID = UUID.randomUUID().toString();
            }
            return this.mUniqueID;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public int getVideoSarDen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public int getVideoSarNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public boolean isLooping() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.looping : invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void notifyOnBufferingUpdate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = this.mOnBufferingUpdateListener;
            if (onBufferingUpdateListener != null) {
                onBufferingUpdateListener.onBufferingUpdate(this, i2);
            }
            IMediaPlayer.Listener listener = this.listener;
            if (listener != null) {
                listener.onBufferingUpdate(i2);
            }
        }
    }

    public final void notifyOnCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            IMediaPlayer.OnCompletionListener onCompletionListener = this.mOnCompletionListener;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(this);
            }
            IMediaPlayer.Listener listener = this.listener;
            if (listener != null) {
                listener.onCompletion();
            }
        }
    }

    public final boolean notifyOnError(int i2, int i3, Exception exc) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048588, this, i2, i3, exc)) == null) {
            IMediaPlayer.OnErrorListener onErrorListener = this.mOnErrorListener;
            boolean z = onErrorListener != null && onErrorListener.onError(this, i2, i3);
            IMediaPlayer.Listener listener = this.listener;
            return z || (listener != null && listener.onError(i2, i3, exc));
        }
        return invokeIIL.booleanValue;
    }

    public final boolean notifyOnInfo(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i2, i3)) == null) {
            IMediaPlayer.OnInfoListener onInfoListener = this.mOnInfoListener;
            boolean z = onInfoListener != null && onInfoListener.onInfo(this, i2, i3);
            IMediaPlayer.Listener listener = this.listener;
            return z || (listener != null && listener.onInfo(i2, i3));
        }
        return invokeII.booleanValue;
    }

    public final void notifyOnLooping() {
        IMediaPlayer.OnLoopingListener onLoopingListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (onLoopingListener = this.mOnLoopListener) == null) {
            return;
        }
        onLoopingListener.onLoop();
    }

    public final void notifyOnPlayStateChange(int i2) {
        IPlayer.OnPlayerPlayStateListener onPlayerPlayStateListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (onPlayerPlayStateListener = this.mOnPlayStateListener) == null) {
            return;
        }
        onPlayerPlayStateListener.onStateChange(this, i2);
    }

    public final void notifyOnPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            IMediaPlayer.OnPreparedListener onPreparedListener = this.mOnPreparedListener;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared(this);
            }
            IMediaPlayer.Listener listener = this.listener;
            if (listener != null) {
                listener.onPrepared();
            }
        }
    }

    public final void notifyOnSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener = this.mOnSeekCompleteListener;
            if (onSeekCompleteListener != null) {
                onSeekCompleteListener.onSeekComplete(this);
            }
            IMediaPlayer.Listener listener = this.listener;
            if (listener != null) {
                listener.onSeekComplete();
            }
        }
    }

    public final void notifyOnStateChanged() {
        IMediaPlayer.Listener listener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (listener = this.listener) == null) {
            return;
        }
        listener.onStateChanged(this.playbackState);
    }

    public final void notifyOnVideoSizeChanged(int i2, int i3, int i4, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)}) == null) {
            IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.mOnVideoSizeChangedListener;
            if (onVideoSizeChangedListener != null) {
                onVideoSizeChangedListener.onVideoSizeChanged(this, i2, i3, i4, (int) f2);
            }
            IMediaPlayer.Listener listener = this.listener;
            if (listener != null) {
                listener.onVideoSizeChanged(i2, i3, i4, f2);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void overMaxSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    public void releaseListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
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
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void seekToEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setAudioStreamType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            setDataSource(null, Uri.parse(str));
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setListener(IMediaPlayer.Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, listener) == null) {
            this.listener = listener;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.looping = z;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onBufferingUpdateListener) == null) {
            this.mOnBufferingUpdateListener = onBufferingUpdateListener;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onCompletionListener) == null) {
            this.mOnCompletionListener = onCompletionListener;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onErrorListener) == null) {
            this.mOnErrorListener = onErrorListener;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onInfoListener) == null) {
            this.mOnInfoListener = onInfoListener;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnLoopingListener(IMediaPlayer.OnLoopingListener onLoopingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, onLoopingListener) == null) {
            this.mOnLoopListener = onLoopingListener;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnOverMaxSizeListener(IMediaPlayer.OnOverMaxSizeListener onOverMaxSizeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onOverMaxSizeListener) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setOnPlayerCompletionListener(IPlayer.OnPlayerCompletionListener onPlayerCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, onPlayerCompletionListener) == null) {
            setOnCompletionListener(new IMediaPlayer.OnCompletionListener(this, onPlayerCompletionListener) { // from class: com.baidu.ugc.editvideo.record.source.AMediaPlayer.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AMediaPlayer this$0;
                public final /* synthetic */ IPlayer.OnPlayerCompletionListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, onPlayerCompletionListener};
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
                    this.val$listener = onPlayerCompletionListener;
                }

                @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnCompletionListener
                public void onCompletion(IMediaPlayer iMediaPlayer) {
                    IPlayer.OnPlayerCompletionListener onPlayerCompletionListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, iMediaPlayer) == null) || (onPlayerCompletionListener2 = this.val$listener) == null) {
                        return;
                    }
                    onPlayerCompletionListener2.onCompletion(this.this$0);
                }
            });
        }
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setOnPlayerErrorListener(IPlayer.OnPlayerErrorListener onPlayerErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, onPlayerErrorListener) == null) {
            setOnErrorListener(new IMediaPlayer.OnErrorListener(this, onPlayerErrorListener) { // from class: com.baidu.ugc.editvideo.record.source.AMediaPlayer.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AMediaPlayer this$0;
                public final /* synthetic */ IPlayer.OnPlayerErrorListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, onPlayerErrorListener};
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
                    this.val$listener = onPlayerErrorListener;
                }

                @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnErrorListener
                public boolean onError(IMediaPlayer iMediaPlayer, int i2, int i3) {
                    InterceptResult invokeLII;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, iMediaPlayer, i2, i3)) == null) {
                        IPlayer.OnPlayerErrorListener onPlayerErrorListener2 = this.val$listener;
                        if (onPlayerErrorListener2 == null) {
                            return false;
                        }
                        return onPlayerErrorListener2.onError(this.this$0, i2, i3, new Exception());
                    }
                    return invokeLII.booleanValue;
                }
            });
        }
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setOnPlayerInfoListener(IPlayer.OnPlayerInfoListener onPlayerInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, onPlayerInfoListener) == null) {
            setOnInfoListener(new IMediaPlayer.OnInfoListener(this, onPlayerInfoListener) { // from class: com.baidu.ugc.editvideo.record.source.AMediaPlayer.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AMediaPlayer this$0;
                public final /* synthetic */ IPlayer.OnPlayerInfoListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, onPlayerInfoListener};
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
                    this.val$listener = onPlayerInfoListener;
                }

                @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnInfoListener
                public boolean onInfo(IMediaPlayer iMediaPlayer, int i2, int i3) {
                    InterceptResult invokeLII;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, iMediaPlayer, i2, i3)) == null) {
                        IPlayer.OnPlayerInfoListener onPlayerInfoListener2 = this.val$listener;
                        if (onPlayerInfoListener2 == null) {
                            return false;
                        }
                        onPlayerInfoListener2.onInfo(this.this$0, i2, i3);
                        return false;
                    }
                    return invokeLII.booleanValue;
                }
            });
        }
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setOnPlayerPlayStateListener(IPlayer.OnPlayerPlayStateListener onPlayerPlayStateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, onPlayerPlayStateListener) == null) {
            this.mOnPlayStateListener = onPlayerPlayStateListener;
        }
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setOnPlayerPreparedListener(IPlayer.OnPlayerPreparedListener onPlayerPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, onPlayerPreparedListener) == null) {
            setOnPreparedListener(new IMediaPlayer.OnPreparedListener(this, onPlayerPreparedListener) { // from class: com.baidu.ugc.editvideo.record.source.AMediaPlayer.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AMediaPlayer this$0;
                public final /* synthetic */ IPlayer.OnPlayerPreparedListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, onPlayerPreparedListener};
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
                    this.val$listener = onPlayerPreparedListener;
                }

                @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnPreparedListener
                public void onPrepared(IMediaPlayer iMediaPlayer) {
                    IPlayer.OnPlayerPreparedListener onPlayerPreparedListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, iMediaPlayer) == null) || (onPlayerPreparedListener2 = this.val$listener) == null) {
                        return;
                    }
                    onPlayerPreparedListener2.onPrepared(this.this$0);
                }
            });
        }
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setOnPlayerVideoSizeChangedListener(IPlayer.OnPlayerVideoSizeChangedListener onPlayerVideoSizeChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, onPlayerVideoSizeChangedListener) == null) {
            setOnVideoSizeChangedListener(new IMediaPlayer.OnVideoSizeChangedListener(this, onPlayerVideoSizeChangedListener) { // from class: com.baidu.ugc.editvideo.record.source.AMediaPlayer.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AMediaPlayer this$0;
                public final /* synthetic */ IPlayer.OnPlayerVideoSizeChangedListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, onPlayerVideoSizeChangedListener};
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
                    this.val$listener = onPlayerVideoSizeChangedListener;
                }

                @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnVideoSizeChangedListener
                public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i2, int i3, int i4, int i5) {
                    IPlayer.OnPlayerVideoSizeChangedListener onPlayerVideoSizeChangedListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{iMediaPlayer, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (onPlayerVideoSizeChangedListener2 = this.val$listener) == null) {
                        return;
                    }
                    onPlayerVideoSizeChangedListener2.onVideoSizeChanged(i2, i3);
                }
            });
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, onPreparedListener) == null) {
            this.mOnPreparedListener = onPreparedListener;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, onSeekCompleteListener) == null) {
            this.mOnSeekCompleteListener = onSeekCompleteListener;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, onVideoSizeChangedListener) == null) {
            this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
        }
    }

    public void setPlaybackState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.playbackState = i2;
            notifyOnStateChanged();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setVolume(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048623, this, f2) == null) {
            setVolume(f2, f2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, context, uri) == null) {
            setDataSource(context, uri, null);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, context, uri, map) == null) {
            this.dataSource = uri;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, fileDescriptor) == null) {
            throw new UnsupportedOperationException("no support");
        }
    }
}
