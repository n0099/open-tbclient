package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.live.interfaces.liveshowplayer.LiveShowPlayerCallback;
import com.baidu.searchbox.live.interfaces.liveshowplayer.LiveShowPlayerStatusCallback;
import com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService;
import com.baidu.tieba.medialive.player.TbLiveVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class uk9 implements LiveShowPlayerService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void dismissFloating(Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, z) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public boolean hasFloatingPermission() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public boolean isFloatShowing(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void release(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, obj) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public Object showFloating(Object obj, View view2, String str, LiveShowPlayerCallback liveShowPlayerCallback) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048601, this, obj, view2, str, liveShowPlayerCallback)) == null) {
            return null;
        }
        return invokeLLLL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void switchNormal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, obj) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements CyberPlayerManager.InstallListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveShowPlayerCallback a;

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallProgress(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            }
        }

        public a(uk9 uk9Var, LiveShowPlayerCallback liveShowPlayerCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uk9Var, liveShowPlayerCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveShowPlayerCallback;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i, int i2, String str) {
            LiveShowPlayerCallback liveShowPlayerCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) && (liveShowPlayerCallback = this.a) != null) {
                liveShowPlayerCallback.cyberInitCallBack(-1, str);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallSuccess(int i, String str) {
            LiveShowPlayerCallback liveShowPlayerCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) && (liveShowPlayerCallback = this.a) != null) {
                liveShowPlayerCallback.cyberInitCallBack(0, str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends vk9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveShowPlayerCallback a;

        public b(uk9 uk9Var, LiveShowPlayerCallback liveShowPlayerCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uk9Var, liveShowPlayerCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveShowPlayerCallback;
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onInfo(int i, int i2) {
            LiveShowPlayerCallback liveShowPlayerCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && (liveShowPlayerCallback = this.a) != null) {
                liveShowPlayerCallback.playerCallBack(i, Integer.valueOf(i2));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements TbLiveVideoView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveShowPlayerStatusCallback a;

        @Override // com.baidu.tieba.medialive.player.TbLiveVideoView.a
        public void onBufferingUpdate(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.medialive.player.TbLiveVideoView.a
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        @Override // com.baidu.tieba.medialive.player.TbLiveVideoView.a
        public void onVideoSizeChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            }
        }

        public c(uk9 uk9Var, LiveShowPlayerStatusCallback liveShowPlayerStatusCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uk9Var, liveShowPlayerStatusCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveShowPlayerStatusCallback;
        }

        @Override // com.baidu.tieba.medialive.player.TbLiveVideoView.a
        public void onCompletion() {
            LiveShowPlayerStatusCallback liveShowPlayerStatusCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (liveShowPlayerStatusCallback = this.a) != null) {
                liveShowPlayerStatusCallback.onEnded();
            }
        }

        @Override // com.baidu.tieba.medialive.player.TbLiveVideoView.a
        public void onPrepared() {
            LiveShowPlayerStatusCallback liveShowPlayerStatusCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (liveShowPlayerStatusCallback = this.a) != null) {
                liveShowPlayerStatusCallback.onStart();
            }
        }

        @Override // com.baidu.tieba.medialive.player.TbLiveVideoView.a
        public void onError(int i, int i2) {
            LiveShowPlayerStatusCallback liveShowPlayerStatusCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) && (liveShowPlayerStatusCallback = this.a) != null) {
                liveShowPlayerStatusCallback.onError(i, i2);
            }
        }

        @Override // com.baidu.tieba.medialive.player.TbLiveVideoView.a
        public void onInfo(int i, int i2) {
            LiveShowPlayerStatusCallback liveShowPlayerStatusCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) && (liveShowPlayerStatusCallback = this.a) != null) {
                liveShowPlayerStatusCallback.onInfo(i, i2);
            }
        }
    }

    public uk9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public Object createPlayerWithUrl(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            return (TbLiveVideoView) getLivePlayer(context, str);
        }
        return invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public Object getLivePlayer(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, str)) == null) {
            return new TbLiveVideoView(context);
        }
        return invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void initCyberCore(LiveShowPlayerCallback liveShowPlayerCallback, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, liveShowPlayerCallback, i) == null) {
            zk9.e().g(new a(this, liveShowPlayerCallback));
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void mute(Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, obj, z) == null) && (obj instanceof TbLiveVideoView)) {
            ((TbLiveVideoView) obj).muteOrUnmuteAudio(z);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void setDecodeMode(Object obj, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048594, this, obj, i) == null) && (obj instanceof TbLiveVideoView)) {
            ((TbLiveVideoView) obj).setDecodeMode(i);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void setPlayerCallback(Object obj, LiveShowPlayerCallback liveShowPlayerCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048596, this, obj, liveShowPlayerCallback) == null) && (obj instanceof yk9)) {
            ((yk9) obj).setPlayerListener(new b(this, liveShowPlayerCallback));
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void setVideoPath(Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, obj, str) == null) && (obj instanceof TbLiveVideoView)) {
            ((TbLiveVideoView) obj).setVideoURI(Uri.parse(str));
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void setVideoRotation(Object obj, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048599, this, obj, i) == null) && (obj instanceof TbLiveVideoView)) {
            ((TbLiveVideoView) obj).setVideoRotation(i);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void setVideoScalingMode(Object obj, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048600, this, obj, i) == null) && (obj instanceof TbLiveVideoView)) {
            ((TbLiveVideoView) obj).setVideoScalingMode(i);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public int getCurrentPosition(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj instanceof TbLiveVideoView) {
                return ((TbLiveVideoView) obj).getCurrentPosition();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public int getDuration(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (obj instanceof TbLiveVideoView) {
                return ((TbLiveVideoView) obj).getDuration();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public View getPlayerView(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj instanceof TbLiveVideoView) {
                return (TbLiveVideoView) obj;
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public int getVideoHeight(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj instanceof TbLiveVideoView) {
                return ((TbLiveVideoView) obj).getVideoHeight();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public String getVideoPath(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (obj instanceof TbLiveVideoView) {
                return ((TbLiveVideoView) obj).getVideoURI().getPath();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public int getVideoWidth(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj instanceof TbLiveVideoView) {
                return ((TbLiveVideoView) obj).getVideoWidth();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public boolean isCoreLoaded(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            return zk9.e().f();
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public boolean isPlaying(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, obj)) == null) {
            if (obj instanceof TbLiveVideoView) {
                return ((TbLiveVideoView) obj).isPlaying();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void pause(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, obj) == null) && (obj instanceof TbLiveVideoView)) {
            new Throwable().printStackTrace();
            ((TbLiveVideoView) obj).pause();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void resume(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, obj) == null) && (obj instanceof TbLiveVideoView)) {
            ((TbLiveVideoView) obj).start();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void start(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, obj) == null) && (obj instanceof TbLiveVideoView)) {
            ((TbLiveVideoView) obj).start();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void stopPlayback(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, obj) == null) && (obj instanceof TbLiveVideoView)) {
            ((TbLiveVideoView) obj).stopPlayback();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void setExternalInfo(Object obj, String str, Object obj2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048595, this, obj, str, obj2) == null) && (obj instanceof TbLiveVideoView)) {
            ((TbLiveVideoView) obj).setExternalInfo(str, obj2);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveShowPlayerService
    public void setPlayerCallback(Object obj, LiveShowPlayerStatusCallback liveShowPlayerStatusCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048597, this, obj, liveShowPlayerStatusCallback) == null) && (obj instanceof TbLiveVideoView)) {
            ((TbLiveVideoView) obj).setPlayerCallback(new c(this, liveShowPlayerStatusCallback));
        }
    }
}
