package com.baidu.tieba.play;

import android.content.Context;
import android.net.Uri;
import android.os.PowerManager;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import c.a.d.f.p.m;
import c.a.s0.d1.t0;
import c.a.s0.s.q.e2;
import c.a.t0.a3.f;
import c.a.t0.a3.g;
import c.a.t0.a3.h;
import c.a.t0.a3.o;
import c.a.t0.a3.r;
import c.a.t0.a3.s;
import c.a.t0.a3.t;
import c.a.t0.a3.u.c;
import c.a.t0.a3.u.d;
import c.a.t0.i2.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.player.callback.IVideoPlayerCallback;
import com.baidu.searchbox.player.ubc.PlayerSpeedTracker;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes12.dex */
public class TbVideoView extends FrameLayout implements g {
    public static /* synthetic */ Interceptable $ic = null;
    public static k G = null;
    public static final String TB_FREE_HOST = "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv";
    public static final String TB_HOST = "http://tb-video.bdstatic.com";
    public transient /* synthetic */ FieldHolder $fh;
    public TbVideoViewContainer.a A;
    public final CustomMessageListener B;
    public IVideoPlayerCallback C;
    public TbCyberVideoView.VideoStatus D;
    public boolean E;
    public TbCyberVideoView.g F;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47341e;

    /* renamed from: f  reason: collision with root package name */
    public String f47342f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47343g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47344h;

    /* renamed from: i  reason: collision with root package name */
    public PowerManager.WakeLock f47345i;

    /* renamed from: j  reason: collision with root package name */
    public WeakReference<Context> f47346j;
    public boolean k;
    public boolean l;
    public int m;
    public h n;
    public boolean o;
    public boolean p;
    public o q;
    public String r;
    public c s;
    public c.a.t0.i2.h t;
    public String u;
    public String v;
    public boolean w;
    public boolean x;
    public r y;
    public c.a.t0.a3.v.a z;

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbVideoView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TbVideoView tbVideoView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbVideoView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbVideoView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.stop();
                if (this.a.t != null) {
                    this.a.t.j(this.a.u, this.a.v);
                    this.a.t = null;
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements IVideoPlayerCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbVideoView a;

        public b(TbVideoView tbVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbVideoView;
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void goBackOrForeground(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onBufferEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onBufferStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onEnd(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && i2 == 307) {
                if (this.a.t != null) {
                    this.a.t.d(this.a.u, this.a.v);
                    this.a.t = null;
                }
                this.a.setVideoStatus(TbCyberVideoView.VideoStatus.VIDEO_COMPLETE);
                s.d().e(this.a.f47342f);
                if (this.a.p) {
                    return;
                }
                if (this.a.s != null) {
                    this.a.s.d();
                }
                this.a.f47343g = false;
                if (this.a.z != null) {
                    this.a.z.onCompletion();
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, str) == null) {
                if (this.a.getCurrentPosition() > 0 && this.a.y()) {
                    s.d().update(this.a.f47342f, this.a.getCurrentPosition());
                }
                TbVideoViewSet.d().f(this.a.f47342f);
                if (this.a.z != null) {
                    this.a.z.onError(i2, i3, str);
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onInfo(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
                if (this.a.z != null) {
                    this.a.z.onInfo(i2, i3, null);
                }
                if (i2 == 10012) {
                    this.a.setVideoStatus(TbCyberVideoView.VideoStatus.VIDEO_PLAYING);
                }
                if (i2 == 10007) {
                    this.a.setVideoStatus(TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR);
                }
                if (i2 == 701) {
                    this.a.setVideoStatus(TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER);
                }
                if (i2 == 702) {
                    if (this.a.D != TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER) {
                        this.a.setVideoStatus(TbCyberVideoView.VideoStatus.VIDEO_PLAYING);
                    } else {
                        this.a.setVideoStatus(TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY);
                    }
                }
                if (i2 != 904 || this.a.s == null) {
                    return;
                }
                this.a.s.f(this.a);
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onNetworkSpeedUpdate(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onPrepared() {
            int c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                if (this.a.s != null) {
                    this.a.s.g(this.a.getDuration());
                }
                this.a.setVideoStatus(TbCyberVideoView.VideoStatus.VIDEO_PREPARED);
                if (this.a.getVideoMonitor() != null) {
                    this.a.getVideoMonitor().k(ErrorCode.ARGS_ERROR);
                }
                if (!this.a.o) {
                    if (!ViewCompat.isAttachedToWindow(this.a)) {
                        return;
                    }
                    if (!this.a.f47344h && (this.a.getParent() instanceof TbVideoViewContainer)) {
                        TbVideoViewSet.d().g((TbVideoViewContainer) this.a.getParent(), this.a.f47342f);
                    }
                }
                if (this.a.z != null) {
                    this.a.z.onPrepared();
                }
                if (this.a.f47341e && (c2 = s.d().c(this.a.f47342f)) > 0) {
                    this.a.seekTo(c2);
                }
                if (this.a.f47343g) {
                    boolean z = this.a.f47344h;
                    this.a.start();
                    this.a.f47344h = z;
                    if (this.a.f47344h) {
                        this.a.setVolume(0.0f, 0.0f);
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onSeekEnd() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.a.z == null) {
                return;
            }
            this.a.z.onSeekComplete();
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onUpdateProgress(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048588, this, i2, i3, i4) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onVideoSizeChanged(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-126839146, "Lcom/baidu/tieba/play/TbVideoView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-126839146, "Lcom/baidu/tieba/play/TbVideoView;");
                return;
            }
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        if (runTask != null) {
            G = (k) runTask.getData();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbVideoView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a.t0.i2.h getVideoMonitor() {
        InterceptResult invokeV;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            c.a.t0.i2.h hVar = this.t;
            if (hVar != null) {
                return hVar;
            }
            if (!StringUtils.isNull(this.f47342f) && (kVar = G) != null) {
                this.t = kVar.a(this.r, this.f47342f, null);
            }
            return this.t;
        }
        return (c.a.t0.i2.h) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoStatus(TbCyberVideoView.VideoStatus videoStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, videoStatus) == null) {
            TbCyberVideoView.g gVar = this.F;
            if (gVar != null) {
                gVar.onStatusChange(B(videoStatus));
            }
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                this.E = true;
                if (this.f47344h) {
                    pauseWithoutMuteAudioFocus();
                    this.f47344h = false;
                } else if (!this.k) {
                    setVolume(1.0f, 1.0f);
                }
            }
            this.D = videoStatus;
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbCyberVideoView.VideoStatus videoStatus = this.D;
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                setVideoStatus(TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY);
            } else if (videoStatus == TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR) {
                setVideoStatus(TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_PAUSING_ERROR);
            } else if (videoStatus == TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER) {
                setVideoStatus(TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER);
            }
        }
    }

    public final TbCyberVideoView.VideoStatus B(TbCyberVideoView.VideoStatus videoStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoStatus)) == null) {
            if (videoStatus == TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY) {
                return TbCyberVideoView.VideoStatus.VIDEO_PAUSING;
            }
            if (videoStatus == TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_PAUSING_ERROR) {
                return TbCyberVideoView.VideoStatus.VIDEO_PAUSING;
            }
            if (videoStatus == TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR) {
                return TbCyberVideoView.VideoStatus.VIDEO_BUFFERING;
            }
            return videoStatus == TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER ? TbCyberVideoView.VideoStatus.VIDEO_BUFFERING : videoStatus;
        }
        return (TbCyberVideoView.VideoStatus) invokeL.objValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.a3.g
    public void changeRenderViewMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.q.setVideoScalingMode(i2);
        }
    }

    @Override // c.a.t0.a3.g
    public void clearCallbackAndRemoveFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            v();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.q.getPositionMs() : invokeV.intValue;
    }

    @Override // c.a.t0.a3.g
    public int getCurrentPositionSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            o oVar = this.q;
            if (oVar == null) {
                return 0;
            }
            return oVar.getPositionMs();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.q.getDurationMs() : invokeV.intValue;
    }

    @Override // c.a.t0.a3.g
    public h getMediaProgressObserver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.n : (h) invokeV.objValue;
    }

    @Override // c.a.t0.a3.g
    public String getOriginUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f47342f : (String) invokeV.objValue;
    }

    @Override // c.a.t0.a3.g
    public int getPcdnState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.m : invokeV.intValue;
    }

    public f getPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.q : (f) invokeV.objValue;
    }

    @Override // c.a.t0.a3.g
    public int getPlayerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            o oVar = this.q;
            if (oVar == null) {
                return 0;
            }
            return oVar.getVideoHeight();
        }
        return invokeV.intValue;
    }

    @Override // c.a.t0.a3.g
    public int getPlayerWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            o oVar = this.q;
            if (oVar == null) {
                return 0;
            }
            return oVar.getVideoWidth();
        }
        return invokeV.intValue;
    }

    @Override // c.a.t0.a3.g
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.q.getVideoHeight() : invokeV.intValue;
    }

    @Override // c.a.t0.a3.g
    public TbCyberVideoView.VideoStatus getVideoStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? B(this.D) : (TbCyberVideoView.VideoStatus) invokeV.objValue;
    }

    @Override // c.a.t0.a3.g
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.q.getVideoWidth() : invokeV.intValue;
    }

    @Override // c.a.t0.a3.g
    public boolean isCanShowPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.E : invokeV.booleanValue;
    }

    @Override // c.a.t0.a3.g
    public boolean isIntentToStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f47343g : invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.q.isPlaying() : invokeV.booleanValue;
    }

    @Override // c.a.t0.a3.g
    @Deprecated
    public void monitorAndStatsAtPrepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            c cVar = this.s;
            if (cVar != null) {
                cVar.h();
                this.s.g(getDuration());
                this.s.f(this);
            }
            if (getVideoMonitor() != null) {
                getVideoMonitor().a(CyberPlayerManager.hasCacheFile(this.f47342f));
                getVideoMonitor().h(ErrorCode.ARGS_ERROR);
            }
        }
    }

    @Override // c.a.t0.a3.g
    @Deprecated
    public void monitorAndStatsAtVerticalVideoReplay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || getVideoMonitor() == null) {
            return;
        }
        getVideoMonitor().a(CyberPlayerManager.hasCacheFile(this.f47342f));
        getVideoMonitor().i();
        getVideoMonitor().k(ErrorCode.ARGS_ERROR);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.B);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onDetachedFromWindow();
            TbVideoViewContainer.a aVar = this.A;
            if (aVar != null) {
                aVar.onSurfaceDestroyed();
            }
            try {
                if (this.f47345i != null && this.f47345i.isHeld()) {
                    this.f47345i.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            v();
            MessageManager.getInstance().unRegisterListener(this.B);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            t0.f(this.f47346j, false);
            if (isPlaying() && y()) {
                s.d().update(this.f47342f, getCurrentPositionSync());
            }
            this.f47343g = false;
            this.q.pause();
            A();
            c cVar = this.s;
            if (cVar != null) {
                cVar.e();
            }
            try {
                if (this.f47345i != null && this.f47345i.isHeld()) {
                    this.f47345i.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            c.a.t0.i2.h hVar = this.t;
            if (hVar != null) {
                hVar.e();
            }
        }
    }

    @Override // c.a.t0.a3.g
    public void pauseWithoutMuteAudioFocus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (isPlaying() && y()) {
                s.d().update(this.f47342f, getCurrentPositionSync());
            }
            this.f47343g = false;
            this.q.pause();
            A();
            c cVar = this.s;
            if (cVar != null) {
                cVar.e();
            }
            try {
                if (this.f47345i != null && this.f47345i.isHeld()) {
                    this.f47345i.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            c.a.t0.i2.h hVar = this.t;
            if (hVar != null) {
                hVar.e();
            }
        }
    }

    @Override // c.a.t0.a3.g
    public void prepareByPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            start();
            this.f47344h = true;
        }
    }

    @Override // c.a.t0.a3.g
    public void recordPlayTimeInfo(long j2, long j3, long j4) {
        c.a.t0.i2.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) || (hVar = this.t) == null) {
            return;
        }
        hVar.recordPlayTimeInfo(j2, j3, j4);
    }

    @Override // c.a.t0.a3.g
    public void resumePlay(TbVideoViewSet.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bVar) == null) {
            if (!isPlaying() && !this.f47343g) {
                this.f47343g = true;
                if (bVar != null) {
                    this.l = true;
                    if (!u()) {
                        bVar.b();
                    }
                } else {
                    this.l = false;
                }
                setVideoPath(this.f47342f, this.r);
                return;
            }
            start(bVar);
        }
    }

    public final String s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
            if (!m.isEmpty(str) && c.a.t0.k4.h.c().d()) {
                if (str.contains("http://tb-video.bdstatic.com")) {
                    return str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
                }
                return str.contains(UrlSchemaHelper.SCHEMA_TYPE_HTTP) ? str.replace(UrlSchemaHelper.SCHEMA_TYPE_HTTP, UrlSchemaHelper.SCHEMA_TYPE_HTTPS) : str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.q.seekToMs(i2);
        }
    }

    @Override // c.a.t0.a3.g
    public void setCanShowPause(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.E = z;
        }
    }

    @Override // c.a.t0.a3.g
    public void setContinuePlayEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.f47341e = z;
        }
    }

    @Override // c.a.t0.a3.g
    public void setIsVolume0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.k = z;
        }
    }

    @Override // c.a.t0.a3.g
    public void setLocateSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.u = str;
        }
    }

    @Override // c.a.t0.a3.g
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.p = z;
            this.q.setLooping(z);
        }
    }

    @Override // c.a.t0.a3.g
    public void setNoBussinessStats() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.s = null;
        }
    }

    @Override // c.a.t0.a3.g
    public void setOnSurfaceDestroyedListener(TbVideoViewContainer.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, aVar) == null) {
            this.A = aVar;
        }
    }

    @Override // c.a.t0.a3.g
    public void setOperableVideoContainer(c.a.t0.a3.v.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, aVar) == null) {
            this.z = aVar;
        }
    }

    @Override // c.a.t0.a3.g
    public void setPlayMode(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, str) == null) || (cVar = this.s) == null) {
            return;
        }
        cVar.l(str);
    }

    @Override // c.a.t0.a3.g
    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            if (m.isEmpty(str)) {
                str = "-1";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20484");
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, str);
            this.q.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.v = str;
        }
    }

    @Override // c.a.t0.a3.g
    public void setThreadDataForStatistic(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, e2Var) == null) {
            if (this.s == null) {
                this.s = new c();
            }
            this.s.m(e2Var);
        }
    }

    @Override // c.a.t0.a3.g
    public void setTryUseViewInSet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.l = z;
        }
    }

    @Override // c.a.t0.a3.g
    public void setVideoModel(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, rVar) == null) {
            this.y = rVar;
        }
    }

    @Override // c.a.t0.a3.g
    public void setVideoPath(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048625, this, str, str2) == null) || m.isEmpty(str)) {
            return;
        }
        this.r = str2;
        setVideoPath(str);
    }

    @Override // c.a.t0.a3.g
    public void setVideoScalingMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            this.q.setVideoScalingMode(i2);
        }
    }

    @Override // c.a.t0.a3.g
    public void setVideoStatData(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, tVar) == null) {
            if (this.s == null) {
                this.s = new c();
            }
            this.s.n(tVar);
            if (tVar != null) {
                this.u = tVar.a;
            }
        }
    }

    @Override // c.a.t0.a3.g
    public void setVideoStatusChangeListener(TbCyberVideoView.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, gVar) == null) {
            this.F = gVar;
        }
    }

    @Override // c.a.t0.a3.g
    public void setVolume(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || this.q == null) {
            return;
        }
        this.k = f2 == 0.0f && f3 == 0.0f;
        this.q.h(f2, f3);
    }

    @Override // c.a.t0.a3.g
    public void start(TbVideoViewSet.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, bVar) == null) {
            if (bVar != null) {
                this.l = true;
                if (!u()) {
                    bVar.b();
                }
                if (!t()) {
                    bVar.a();
                    this.f47343g = true;
                    this.f47344h = false;
                    setVideoPath(this.f47342f, this.r);
                    return;
                }
            } else {
                this.l = false;
            }
            start();
        }
    }

    @Override // c.a.t0.a3.g
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            if (!this.l) {
                stopPlayback();
                return;
            }
            if (this.f47342f != null && isPlaying()) {
                t0.f(this.f47346j, false);
            }
            this.f47343g = false;
            if (isPlaying() && y()) {
                s.d().update(this.f47342f, getCurrentPositionSync());
            }
            try {
                if (this.f47345i != null && this.f47345i.isHeld()) {
                    this.f47345i.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            this.q.pause();
            A();
            c cVar = this.s;
            if (cVar != null) {
                cVar.j();
            }
            this.n.n();
            c.a.t0.i2.h hVar = this.t;
            if (hVar == null || !hVar.c(this.u, this.v)) {
                return;
            }
            this.t = null;
        }
    }

    @Override // c.a.t0.a3.g
    public void stopPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            if (this.f47342f != null && isPlaying()) {
                t0.f(this.f47346j, false);
            }
            this.f47343g = false;
            if (isPlaying() && y()) {
                s.d().update(this.f47342f, getCurrentPositionSync());
            }
            try {
                if (this.f47345i != null && this.f47345i.isHeld()) {
                    this.f47345i.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            this.q.stop();
            TbVideoViewSet.d().f(this.f47342f);
            c cVar = this.s;
            if (cVar != null) {
                cVar.j();
            }
            this.n.n();
            c.a.t0.i2.h hVar = this.t;
            if (hVar == null || !hVar.c(this.u, this.v)) {
                return;
            }
            this.t = null;
        }
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? getParent() == TbVideoViewSet.d().e(this.f47342f) : invokeV.booleanValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? (getParent() == null || getParent().getParent() == null) ? false : true : invokeV.booleanValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            this.A = null;
            this.F = null;
            this.z = null;
            this.n.j(null);
            this.n.i(null);
            this.n.k(null);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            try {
                PowerManager powerManager = (PowerManager) TbadkCoreApplication.getInst().getContext().getSystemService("power");
                if (powerManager != null) {
                    PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(536870922, "TbBVideoView_WakeLock");
                    this.f47345i = newWakeLock;
                    newWakeLock.setReferenceCounted(false);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            this.f47346j = new WeakReference<>(TbadkCoreApplication.getInst());
            o oVar = new o(TbadkCoreApplication.getInst());
            this.q = oVar;
            oVar.f();
            this.q.attachToContainer(this);
            this.q.setPlayerListener(this.C);
            this.s = new c();
            this.n = new h();
            SkinManager.setBackgroundResource(this, R.color.black_alpha100);
        }
    }

    public final void x(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, uri) == null) {
            this.q.stop();
            this.q.setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
            c.a.t0.a3.u.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
            if (pcdnConfigData != null && pcdnConfigData.c()) {
                if (!pcdnConfigData.a(uri)) {
                    this.m = 2;
                    return;
                } else if (d.e() != 0 && d.e() != -1) {
                    this.q.setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                    this.q.setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.b() ? "1" : "0");
                    this.q.setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(d.e()));
                    this.w = true;
                    this.x = pcdnConfigData.b();
                    this.m = 1;
                    return;
                } else {
                    this.m = 3;
                    return;
                }
            }
            this.m = 0;
        }
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            o oVar = this.q;
            return oVar != null && oVar.getDurationMs() >= this.q.getPositionMs();
        }
        return invokeV.booleanValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20513");
            hashMap.put("click_time", "" + System.currentTimeMillis());
            this.q.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f47346j = null;
        this.k = false;
        this.l = false;
        this.o = false;
        this.B = new a(this, 2001011);
        this.C = new b(this);
        this.D = TbCyberVideoView.VideoStatus.INIT;
        this.E = false;
        w();
    }

    @Override // c.a.t0.a3.g
    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, str) == null) || m.isEmpty(str)) {
            return;
        }
        z();
        this.f47342f = str;
        String s = s(str);
        k kVar = G;
        if (kVar != null) {
            c.a.t0.i2.h a2 = kVar.a(this.r, this.f47342f, null);
            this.t = a2;
            if (a2 != null) {
                a2.a(CyberPlayerManager.hasCacheFile(s));
            }
        }
        this.n.l(this);
        c cVar = this.s;
        if (cVar != null) {
            cVar.h();
        }
        x(Uri.parse(s));
        c.a.t0.i2.h hVar = this.t;
        if (hVar != null) {
            hVar.i();
        }
        String c2 = c.a.d.f.p.t.c(s);
        r rVar = this.y;
        if (rVar != null) {
            rVar.a = "";
            rVar.f15280b = s;
            rVar.f15281c = c2;
            this.q.g(rVar);
        } else {
            c cVar2 = this.s;
            if (cVar2 != null && cVar2.c() != null) {
                r rVar2 = new r();
                rVar2.a = "";
                rVar2.f15280b = s;
                rVar2.f15281c = c2;
                String b2 = rVar2.b(this.s.c().a);
                rVar2.f15283e = b2;
                rVar2.f15282d = rVar2.a(b2);
                rVar2.f15284f = rVar2.c(this.s.b());
                this.q.g(rVar2);
            }
        }
        this.q.setVideoUniqueKey(c2);
        this.q.setVideoUrl(s);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            if (!this.k) {
                t0.f(this.f47346j, true);
                setVolume(1.0f, 1.0f);
            }
            this.f47343g = true;
            this.f47344h = false;
            this.q.start();
            if (this.D == TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY) {
                setVideoStatus(TbCyberVideoView.VideoStatus.VIDEO_PLAYING);
            }
            if (this.D == TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_PAUSING_ERROR) {
                setVideoStatus(TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR);
            }
            if (this.D == TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER) {
                setVideoStatus(TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER);
            }
            c cVar = this.s;
            if (cVar != null) {
                cVar.i();
            }
            PlayerSpeedTracker.beginTrack(c.a.d.f.p.t.c(this.q.getVideoUrl()));
            this.n.m();
            try {
                if (this.f47345i != null && !this.f47345i.isHeld()) {
                    this.f47345i.acquire();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            if (getVideoMonitor() != null) {
                getVideoMonitor().g(ErrorCode.ARGS_ERROR);
                getVideoMonitor().b(this.w, this.x);
            }
        }
    }
}
