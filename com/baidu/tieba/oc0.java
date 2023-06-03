package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.feedplayer.base.LivePlayerProvider;
import com.baidu.searchbox.live.interfaces.player.LivePlayer;
import com.baidu.searchbox.player.callback.IVideoPlayerCallback;
import com.baidu.searchbox.player.callback.UniversalPlayerCallbackManager;
import com.baidu.searchbox.player.context.IPlayerContext;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.helper.IPlayerStyleSwitchHelper;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class oc0 implements LivePlayer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LivePlayer a;

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void requestPlayerAudioFocus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setOnAudioFocusChangedListener(LivePlayer.OnAudioFocusChangedListener onAudioFocusChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, onAudioFocusChangedListener) == null) {
        }
    }

    public oc0(qc0 qc0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qc0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String a = qc0Var.a();
        this.a = LivePlayerProvider.c.a(a == null ? "0000" : a);
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void addOnInfoListener(LivePlayer.OnInfoListener onInfoListener) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, onInfoListener) == null) && (livePlayer = this.a) != null) {
            livePlayer.addOnInfoListener(onInfoListener);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void addProgressListener(LivePlayer.OnProgressChangeListener onProgressChangeListener) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onProgressChangeListener) == null) && (livePlayer = this.a) != null) {
            livePlayer.addProgressListener(onProgressChangeListener);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void attachKernelLayer(BaseKernelLayer baseKernelLayer) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, baseKernelLayer) == null) && (livePlayer = this.a) != null) {
            livePlayer.attachKernelLayer(baseKernelLayer);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void attachToContainer(ViewGroup viewGroup) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) && (livePlayer = this.a) != null) {
            livePlayer.attachToContainer(viewGroup);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean checkMode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.checkMode(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public <T extends IPlayerContext> T getPlayerContext(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, cls)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return (T) livePlayer.getPlayerContext(cls);
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void goBackOrForeground(boolean z) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z) == null) && (livePlayer = this.a) != null) {
            livePlayer.goBackOrForeground(z);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void mute(boolean z) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048607, this, z) == null) && (livePlayer = this.a) != null) {
            livePlayer.mute(z);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void pauseInternal(boolean z) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048609, this, z) == null) && (livePlayer = this.a) != null) {
            livePlayer.pauseInternal(z);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void play(String str) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, str) == null) && (livePlayer = this.a) != null) {
            livePlayer.play(str);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void removeOnInfoListener(LivePlayer.OnInfoListener onInfoListener) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048615, this, onInfoListener) == null) && (livePlayer = this.a) != null) {
            livePlayer.removeOnInfoListener(onInfoListener);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void removePlayerListener(IVideoPlayerCallback iVideoPlayerCallback) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048616, this, iVideoPlayerCallback) == null) && (livePlayer = this.a) != null) {
            livePlayer.removePlayerListener(iVideoPlayerCallback);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void removeProgressListener(LivePlayer.OnProgressChangeListener onProgressChangeListener) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, onProgressChangeListener) == null) && (livePlayer = this.a) != null) {
            livePlayer.removeProgressListener(onProgressChangeListener);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resume(boolean z) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048621, this, z) == null) && (livePlayer = this.a) != null) {
            livePlayer.resume(z);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resumePlayer(boolean z) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048623, this, z) == null) && (livePlayer = this.a) != null) {
            livePlayer.resumePlayer(z);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void seekTo(int i) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048625, this, i) == null) && (livePlayer = this.a) != null) {
            livePlayer.seekTo(i);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void sendEvent(VideoEvent videoEvent) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048627, this, videoEvent) == null) && (livePlayer = this.a) != null) {
            livePlayer.sendEvent(videoEvent);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setAcceptVolumeChange(boolean z) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048628, this, z) == null) && (livePlayer = this.a) != null) {
            livePlayer.setAcceptVolumeChange(z);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setExtInfoStatistics(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, hashMap) == null) {
            LivePlayer.DefaultImpls.setExtInfoStatistics(this, hashMap);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setMode(String str) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048630, this, str) == null) && (livePlayer = this.a) != null) {
            livePlayer.setMode(str);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setOrientationLock(boolean z) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048632, this, z) == null) && (livePlayer = this.a) != null) {
            livePlayer.setOrientationLock(z);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setPlayerListener(IVideoPlayerCallback iVideoPlayerCallback) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048633, this, iVideoPlayerCallback) == null) && (livePlayer = this.a) != null) {
            livePlayer.setPlayerListener(iVideoPlayerCallback);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setSpeed(float f) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048634, this, f) == null) && (livePlayer = this.a) != null) {
            livePlayer.setSpeed(f);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setStyleSwitchHelper(IPlayerStyleSwitchHelper iPlayerStyleSwitchHelper) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048635, this, iPlayerStyleSwitchHelper) == null) && (livePlayer = this.a) != null) {
            livePlayer.setStyleSwitchHelper(iPlayerStyleSwitchHelper);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setUseLivePreStartPlayerState(boolean z) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048636, this, z) == null) && (livePlayer = this.a) != null) {
            livePlayer.setUseLivePreStartPlayerState(z);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setUserAgent(String str) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048637, this, str) == null) && (livePlayer = this.a) != null) {
            livePlayer.setUserAgent(str);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoBackground(Drawable drawable) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048638, this, drawable) == null) && (livePlayer = this.a) != null) {
            livePlayer.setVideoBackground(drawable);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setVideoInfo(HashMap<Integer, String> hashMap) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048639, this, hashMap) == null) && (livePlayer = this.a) != null) {
            livePlayer.setVideoInfo(hashMap);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoRotation(int i) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048640, this, i) == null) && (livePlayer = this.a) != null) {
            livePlayer.setVideoRotation(i);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoScalingMode(int i) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048641, this, i) == null) && (livePlayer = this.a) != null) {
            livePlayer.setVideoScalingMode(i);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoUrl(String str) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048642, this, str) == null) && (livePlayer = this.a) != null) {
            livePlayer.setVideoUrl(str);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void updateVideoInfo(HashMap<Integer, String> hashMap) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048647, this, hashMap) == null) && (livePlayer = this.a) != null) {
            livePlayer.updateVideoInfo(hashMap);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void detachFromContainer() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (livePlayer = this.a) != null) {
            livePlayer.detachFromContainer();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public BaseKernelLayer detachKernelLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.detachKernelLayer();
            }
            return null;
        }
        return (BaseKernelLayer) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void disableOrientationEventHelper() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (livePlayer = this.a) != null) {
            livePlayer.disableOrientationEventHelper();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void enableOrientationEventHelper() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (livePlayer = this.a) != null) {
            livePlayer.enableOrientationEventHelper();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public String getCurrentMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.getCurrentMode();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.getDuration();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public UniversalPlayerCallbackManager getPlayerCallbackManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer == null) {
                Intrinsics.throwNpe();
            }
            return livePlayer.getPlayerCallbackManager();
        }
        return (UniversalPlayerCallbackManager) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public BaseKernelLayer getPlayerKernelLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.getPlayerKernelLayer();
            }
            return null;
        }
        return (BaseKernelLayer) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.getPosition();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public String getServerIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.getServerIpInfo();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.getVideoUrl();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void imCloseTimeStatistics() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (livePlayer = this.a) != null) {
            livePlayer.imCloseTimeStatistics();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.isComplete();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.isError();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isFloatingMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.isFloatingMode();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.isStop();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.isPause();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isReverseLandscape() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.isReverseLandscape();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isStop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.isStop();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isUseCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.isUseCache();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isUseLivePreStartPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.isUseLivePreStartPlayer();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void pause() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (livePlayer = this.a) != null) {
            livePlayer.pause();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void prePlay() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (livePlayer = this.a) != null) {
            livePlayer.prePlay();
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void prepare() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (livePlayer = this.a) != null) {
            livePlayer.prepare();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void release() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && (livePlayer = this.a) != null) {
            livePlayer.release();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resetDefaultSwitchHelper() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && (livePlayer = this.a) != null) {
            livePlayer.resetDefaultSwitchHelper();
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void resume() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && (livePlayer = this.a) != null) {
            livePlayer.resume();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resumeFromError() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (livePlayer = this.a) != null) {
            livePlayer.resumeFromError();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void saveProgressToDb() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && (livePlayer = this.a) != null) {
            livePlayer.saveProgressToDb();
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void start() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048643, this) == null) && (livePlayer = this.a) != null) {
            livePlayer.start();
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void stop() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048644, this) == null) && (livePlayer = this.a) != null) {
            livePlayer.stop();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void stopTimeStatistics() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048645, this) == null) && (livePlayer = this.a) != null) {
            livePlayer.stopTimeStatistics();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void switchToHalf() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048646, this) == null) && (livePlayer = this.a) != null) {
            livePlayer.switchToHalf();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public Object getInfo(Object obj, Object obj2, LivePlayer.InfoCallback infoCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, obj, obj2, infoCallback)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.getInfo(obj, obj2, infoCallback);
            }
            return null;
        }
        return invokeLLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0010, code lost:
        if (r0 == null) goto L15;
     */
    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getKernalScreenshot(LivePlayer.KernalScreenshotListener kernalScreenshotListener, float f) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048588, this, kernalScreenshotListener, f) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                if (livePlayer != null) {
                    baseKernelLayer = livePlayer.getPlayerKernelLayer();
                } else {
                    baseKernelLayer = null;
                }
            }
            LivePlayer.KernalScreenshotListener.DefaultImpls.onResult$default(kernalScreenshotListener, null, null, null, 6, null);
            LivePlayer livePlayer2 = this.a;
            if (livePlayer2 != null) {
                livePlayer2.getKernalScreenshot(kernalScreenshotListener, f);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void registerContext(Class<? extends IPlayerContext> cls, IPlayerContext iPlayerContext) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048613, this, cls, iPlayerContext) == null) && (livePlayer = this.a) != null) {
            livePlayer.registerContext(cls, iPlayerContext);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void seekTo(int i, int i2) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048626, this, i, i2) == null) && (livePlayer = this.a) != null) {
            livePlayer.seekTo(i, i2);
        }
    }
}
