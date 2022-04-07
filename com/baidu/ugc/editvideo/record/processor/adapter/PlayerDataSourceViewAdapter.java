package com.baidu.ugc.editvideo.record.processor.adapter;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.IPlayer;
import com.baidu.ugc.editvideo.record.preview.GLMediaPreviewView;
import com.baidu.ugc.editvideo.record.source.IDataSourceView;
/* loaded from: classes4.dex */
public class PlayerDataSourceViewAdapter implements IDataSourceView.IPlayerDataSourceView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IPlayer.OnPlayerCompletionListener mOnCompleteListener;
    public IPlayer.OnPlayerErrorListener mOnErrorListener;
    public IPlayer.OnPlayerInfoListener mOnInfoListener;
    public IPlayer.OnPlayerPlayStateListener mOnPlayStateListener;
    public IPlayer.OnPlayerPreparedListener mOnPreparedListener;
    public GLMediaPreviewView mVideoView;

    public PlayerDataSourceViewAdapter(GLMediaPreviewView gLMediaPreviewView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gLMediaPreviewView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mVideoView = gLMediaPreviewView;
    }

    private void removeListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.mOnPreparedListener = null;
            this.mOnCompleteListener = null;
            this.mOnPlayStateListener = null;
            this.mOnInfoListener = null;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onCompletion(IPlayer iPlayer) {
        IPlayer.OnPlayerCompletionListener onPlayerCompletionListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iPlayer) == null) || (onPlayerCompletionListener = this.mOnCompleteListener) == null) {
            return;
        }
        onPlayerCompletionListener.onCompletion(iPlayer);
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            removeListeners();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onError(IPlayer iPlayer, int i, int i2, Exception exc) {
        IPlayer.OnPlayerErrorListener onPlayerErrorListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{iPlayer, Integer.valueOf(i), Integer.valueOf(i2), exc}) == null) || (onPlayerErrorListener = this.mOnErrorListener) == null) {
            return;
        }
        onPlayerErrorListener.onError(iPlayer, i, i2, exc);
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onInfo(IPlayer iPlayer, int i, int i2) {
        IPlayer.OnPlayerInfoListener onPlayerInfoListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048579, this, iPlayer, i, i2) == null) || (onPlayerInfoListener = this.mOnInfoListener) == null) {
            return;
        }
        onPlayerInfoListener.onInfo(iPlayer, i, i2);
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onPlayStateListener(IPlayer iPlayer, int i) {
        IPlayer.OnPlayerPlayStateListener onPlayerPlayStateListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, iPlayer, i) == null) || (onPlayerPlayStateListener = this.mOnPlayStateListener) == null) {
            return;
        }
        onPlayerPlayStateListener.onStateChange(iPlayer, i);
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onPrepared(IPlayer iPlayer) {
        IPlayer.OnPlayerPreparedListener onPlayerPreparedListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, iPlayer) == null) || (onPlayerPreparedListener = this.mOnPreparedListener) == null) {
            return;
        }
        onPlayerPreparedListener.onPrepared(iPlayer);
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onVideoSizeChanged(int i, int i2) {
        GLMediaPreviewView gLMediaPreviewView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) || (gLMediaPreviewView = this.mVideoView) == null) {
            return;
        }
        gLMediaPreviewView.onVideoSizeChanged(i, i2);
    }

    public void setOnCompleteListener(IPlayer.OnPlayerCompletionListener onPlayerCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onPlayerCompletionListener) == null) {
            this.mOnCompleteListener = onPlayerCompletionListener;
        }
    }

    public void setOnErrorListener(IPlayer.OnPlayerErrorListener onPlayerErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onPlayerErrorListener) == null) {
            this.mOnErrorListener = onPlayerErrorListener;
        }
    }

    public void setOnInfoListener(IPlayer.OnPlayerInfoListener onPlayerInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onPlayerInfoListener) == null) {
            this.mOnInfoListener = onPlayerInfoListener;
        }
    }

    public void setOnPlayStateListener(IPlayer.OnPlayerPlayStateListener onPlayerPlayStateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onPlayerPlayStateListener) == null) {
            this.mOnPlayStateListener = onPlayerPlayStateListener;
        }
    }

    public void setOnPreparedListener(IPlayer.OnPlayerPreparedListener onPlayerPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onPlayerPreparedListener) == null) {
            this.mOnPreparedListener = onPlayerPreparedListener;
        }
    }
}
