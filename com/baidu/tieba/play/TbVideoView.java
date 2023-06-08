package com.baidu.tieba.play;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.PowerManager;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.player.callback.IVideoPlayerCallback;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.interfaces.OnSnapShotFrameListener;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.searchbox.player.kernel.YYVideoKernel;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.layer.BaseKernelLayerKt;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.ubc.PlayerSpeedTracker;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.bj9;
import com.baidu.tieba.cj;
import com.baidu.tieba.cj9;
import com.baidu.tieba.dj9;
import com.baidu.tieba.ej9;
import com.baidu.tieba.gj9;
import com.baidu.tieba.hj9;
import com.baidu.tieba.ij9;
import com.baidu.tieba.j7a;
import com.baidu.tieba.mi9;
import com.baidu.tieba.ni9;
import com.baidu.tieba.oi9;
import com.baidu.tieba.pi9;
import com.baidu.tieba.play.OnStatusChangedListener;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.pp6;
import com.baidu.tieba.tx8;
import com.baidu.tieba.ui;
import com.baidu.tieba.wx8;
import com.baidu.tieba.xi9;
import com.baidu.tieba.xx5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class TbVideoView extends FrameLayout implements ni9 {
    public static /* synthetic */ Interceptable $ic;
    public static wx8 F;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener A;
    public IVideoPlayerCallback B;
    public OnStatusChangedListener.VideoStatus C;
    public boolean D;
    public OnStatusChangedListener E;
    public boolean a;
    public String b;
    public boolean c;
    public boolean d;
    public PowerManager.WakeLock e;
    public WeakReference<Context> f;
    public boolean g;
    public boolean h;
    public int i;
    public oi9 j;
    public boolean k;
    public boolean l;
    public xi9 m;
    public String n;
    public gj9 o;
    public tx8 p;
    public String q;
    public String r;
    public boolean s;
    public boolean t;
    public bj9 u;
    public boolean v;
    public ij9 w;
    public TbVideoViewContainer.a x;
    public boolean y;
    @Nullable
    public pi9 z;

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbVideoView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TbVideoView tbVideoView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbVideoView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.pause();
                if (this.a.p != null) {
                    this.a.p.k(this.a.q, this.a.r);
                    this.a.p = null;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements IVideoPlayerCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbVideoView a;

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
        public void onGlobalOrientationLock(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onNetworkSpeedUpdate(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onPlayerKernelPreEmpted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            }
        }

        public b(TbVideoView tbVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbVideoView;
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onEnd(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || i != 307) {
                return;
            }
            if (this.a.p != null) {
                this.a.p.e(this.a.q, this.a.r);
                this.a.p = null;
            }
            this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_COMPLETE);
            cj9.d().e(this.a.b);
            if (this.a.o != null) {
                this.a.o.j();
            }
            if (this.a.l) {
                return;
            }
            if (this.a.o != null) {
                this.a.o.d();
            }
            this.a.c = false;
            if (this.a.w != null) {
                this.a.w.onCompletion();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048580, this, i, i2, str) == null) {
                if (this.a.getCurrentPosition() > 0 && this.a.G()) {
                    cj9.d().update(this.a.b, this.a.getCurrentPosition());
                }
                TbVideoViewSet.c().e(this.a.b);
                if ((this.a.m.getKernelType().equals(YYVideoKernel.KERNEL_TYPE_YY) && (i2 == 403 || i2 == 404)) || i2 == -33403) {
                    this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_ERROR);
                }
                if (this.a.w != null) {
                    this.a.w.onError(i, i2, str);
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onInfo(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
                if (this.a.w != null) {
                    this.a.w.onInfo(i, i2, null);
                }
                if (i == 12006) {
                    this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_PRERENDERING);
                }
                if (i == 10012) {
                    this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_PLAYING);
                }
                if (i == 10007) {
                    this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR);
                }
                if (i == 701) {
                    this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER);
                }
                if (i == 702) {
                    if (this.a.C != OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER) {
                        this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_PLAYING);
                    } else {
                        this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY);
                    }
                }
                if (i == 904 && this.a.o != null) {
                    this.a.o.f(this.a);
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onPause() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || !UbsABTestHelper.isFeedVideoImmersionTransition()) {
                return;
            }
            this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_PAUSING);
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onResume() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || !UbsABTestHelper.isFeedVideoImmersionTransition()) {
                return;
            }
            this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_PLAYING);
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onSeekEnd() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.a.w != null) {
                this.a.w.onSeekComplete();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onPrepared() {
            int c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                if (this.a.o != null) {
                    this.a.o.g(this.a.getDuration());
                }
                this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_PREPARED);
                if (this.a.getVideoMonitor() != null) {
                    this.a.getVideoMonitor().l(-400);
                }
                this.a.v();
                if (this.a.w != null) {
                    this.a.w.onPrepared();
                }
                if (this.a.a && (c = cj9.d().c(this.a.b)) > 0) {
                    this.a.seekTo(c);
                }
                if (this.a.c) {
                    boolean z = this.a.d;
                    this.a.start();
                    this.a.d = z;
                    if (this.a.d) {
                        this.a.setVolume(0.0f, 0.0f);
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onUpdateProgress(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIII(1048590, this, i, i2, i3) == null) && UbsABTestHelper.isFeedVideoImmersionTransition() && i <= i3 && i3 - i < 1000 && this.a.o != null) {
                this.a.o.o(i3);
                this.a.o.q(i);
                this.a.o.j();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onVideoSizeChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048591, this, i, i2) == null) && this.a.z != null) {
                this.a.z.onVideoSizeChanged(i, i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements OnSnapShotFrameListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ TbVideoView b;

        public c(TbVideoView tbVideoView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbVideoView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tbVideoView;
            this.a = str;
        }

        @Override // com.baidu.searchbox.player.interfaces.OnSnapShotFrameListener
        public void onSnapShotComplete(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, bitmap) != null) || bitmap == null) {
                return;
            }
            TbSingleton.getInstance().setVideoCover(new pp6(this.a, bitmap));
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, wx8.class);
        if (runTask != null) {
            F = (wx8) runTask.getData();
        }
    }

    @Deprecated
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            gj9 gj9Var = this.o;
            if (gj9Var != null) {
                gj9Var.h();
                this.o.g(getDuration());
                this.o.f(this);
            }
            if (getVideoMonitor() != null) {
                getVideoMonitor().b(CyberPlayerManager.hasCacheFile(this.b));
                getVideoMonitor().i(-400);
            }
        }
    }

    @Deprecated
    public void I() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && getVideoMonitor() != null) {
            getVideoMonitor().b(CyberPlayerManager.hasCacheFile(this.b));
            getVideoMonitor().j();
            getVideoMonitor().l(-400);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20513");
            hashMap.put("click_time", "" + System.currentTimeMillis());
            this.m.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onDetachedFromWindow();
            TbVideoViewContainer.a aVar = this.x;
            if (aVar != null) {
                aVar.onSurfaceDestroyed();
            }
            try {
                if (this.e != null && this.e.isHeld()) {
                    this.e.release();
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            B();
            MessageManager.getInstance().unRegisterListener(this.A);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoStatus(OnStatusChangedListener.VideoStatus videoStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, videoStatus) == null) {
            OnStatusChangedListener onStatusChangedListener = this.E;
            if (onStatusChangedListener != null) {
                if (this.y) {
                    onStatusChangedListener.onStatusChange(videoStatus);
                } else {
                    onStatusChangedListener.onStatusChange(U(videoStatus));
                }
            }
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                this.D = true;
                if (this.d) {
                    K();
                    this.d = false;
                } else if (!this.g) {
                    setVolume(1.0f, 1.0f);
                }
            }
            this.C = videoStatus;
        }
    }

    public void N(TbVideoViewSet.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            if (!isPlaying() && !this.c) {
                this.c = true;
                if (bVar != null) {
                    this.h = true;
                    if (!z()) {
                        bVar.b();
                    }
                } else {
                    this.h = false;
                }
                setVideoPath(this.b, this.n);
                if (!UbsABTestHelper.isVideoSetUrlAgainABTest()) {
                    start();
                    return;
                }
                return;
            }
            S(bVar);
        }
    }

    public void S(TbVideoViewSet.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            if (bVar != null) {
                this.h = true;
                if (!z()) {
                    bVar.b();
                }
                if (!y()) {
                    bVar.a();
                    this.c = true;
                    this.d = false;
                    setVideoPath(this.b, this.n);
                    if (UbsABTestHelper.isVideoSetUrlAgainABTest()) {
                        return;
                    }
                }
            } else {
                this.h = false;
            }
            start();
        }
    }

    public final String x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, str)) == null) {
            if (ui.isEmpty(str)) {
                return str;
            }
            if (j7a.c().d()) {
                if (str.contains("http://tb-video.bdstatic.com")) {
                    return str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
                }
                if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_HTTP)) {
                    return str.replace(UrlSchemaHelper.SCHEMA_TYPE_HTTP, UrlSchemaHelper.SCHEMA_TYPE_HTTPS);
                }
                return str;
            }
            return str;
        }
        return (String) invokeL.objValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f = null;
        this.g = false;
        this.h = false;
        this.k = false;
        this.v = true;
        this.A = new a(this, 2001011);
        this.B = new b(this);
        this.C = OnStatusChangedListener.VideoStatus.INIT;
        this.D = false;
        C();
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.y = z;
        }
    }

    public final OnStatusChangedListener.VideoStatus U(OnStatusChangedListener.VideoStatus videoStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, videoStatus)) == null) {
            if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY) {
                return OnStatusChangedListener.VideoStatus.VIDEO_PAUSING;
            }
            if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_ERROR) {
                return OnStatusChangedListener.VideoStatus.VIDEO_PAUSING;
            }
            if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR) {
                return OnStatusChangedListener.VideoStatus.VIDEO_BUFFERING;
            }
            if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER) {
                return OnStatusChangedListener.VideoStatus.VIDEO_BUFFERING;
            }
            return videoStatus;
        }
        return (OnStatusChangedListener.VideoStatus) invokeL.objValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            this.m.seekToMs(i);
        }
    }

    public void setCanShowPause(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.D = z;
        }
    }

    public void setContinuePlayEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.a = z;
        }
    }

    public void setIsVolume0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.g = z;
        }
    }

    public void setLocateSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.q = str;
        }
    }

    @Override // com.baidu.tieba.ni9
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.l = z;
            this.m.setLooping(z);
        }
    }

    @Override // com.baidu.tieba.ni9
    public void setOnSurfaceDestroyedListener(TbVideoViewContainer.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, aVar) == null) {
            this.x = aVar;
        }
    }

    @Override // com.baidu.tieba.ni9
    public void setOperableVideoContainer(ij9 ij9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, ij9Var) == null) {
            this.w = ij9Var;
        }
    }

    @Override // com.baidu.tieba.ni9
    public void setPlayMode(String str) {
        gj9 gj9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048629, this, str) == null) && (gj9Var = this.o) != null) {
            gj9Var.l(str);
        }
    }

    @Override // com.baidu.tieba.ni9
    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            if (ui.isEmpty(str)) {
                str = "-1";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20484");
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, str);
            this.m.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.r = str;
        }
    }

    public void setThreadDataForStatistic(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, threadData) == null) {
            if (this.o == null) {
                this.o = new gj9();
            }
            this.o.n(threadData);
        }
    }

    public void setTryUseViewInSet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.h = z;
        }
    }

    public void setVideoModel(bj9 bj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, bj9Var) == null) {
            this.u = bj9Var;
        }
    }

    public void setVideoPlayerListener(IVideoPlayerCallback iVideoPlayerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, iVideoPlayerCallback) == null) {
            this.m.setPlayerListener(iVideoPlayerCallback);
        }
    }

    public void setVideoScalingMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i) == null) {
            this.m.setVideoScalingMode(i);
        }
    }

    public void setVideoSizeChangeListener(pi9 pi9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, pi9Var) == null) {
            this.z = pi9Var;
        }
    }

    @Override // com.baidu.tieba.ni9
    public void setVideoStatData(dj9 dj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, dj9Var) == null) {
            if (this.o == null) {
                this.o = new gj9();
            }
            this.o.p(dj9Var);
            if (dj9Var != null) {
                this.q = dj9Var.a;
            }
        }
    }

    public void setVideoStatusChangeListener(OnStatusChangedListener onStatusChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, onStatusChangedListener) == null) {
            this.E = onStatusChangedListener;
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048646, this, i) == null) {
            this.m.setVideoScalingMode(i);
        }
    }

    public void setOption(String str, String str2) {
        xi9 xi9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048628, this, str, str2) == null) && (xi9Var = this.m) != null) {
            xi9Var.setOption(str, str2);
        }
    }

    @Override // com.baidu.tieba.ni9
    public void setVideoPath(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048635, this, str, str2) != null) || ui.isEmpty(str)) {
            return;
        }
        this.n = str2;
        setVideoPath(str);
    }

    public void setVideoSeries(@NonNull BasicVideoSeries basicVideoSeries, boolean z) {
        xi9 xi9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048638, this, basicVideoSeries, z) == null) && (xi9Var = this.m) != null) {
            xi9Var.setVideoSeries(basicVideoSeries, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public tx8 getVideoMonitor() {
        InterceptResult invokeV;
        wx8 wx8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            tx8 tx8Var = this.p;
            if (tx8Var != null) {
                return tx8Var;
            }
            if (!StringUtils.isNull(this.b) && (wx8Var = F) != null) {
                this.p = wx8Var.a(this.n, this.b, null);
            }
            return this.p;
        }
        return (tx8) invokeV.objValue;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            B();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.x = null;
            this.E = null;
            this.w = null;
            this.j.j(null);
            this.j.i(null);
            this.j.k(null);
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.D;
        }
        return invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            xi9 xi9Var = this.m;
            if (xi9Var != null && xi9Var.getDurationMs() >= this.m.getPositionMs()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.m.setOption("opt-pre-render-on-prepared", BaseKernelLayerKt.toOption(true));
            this.d = true;
        }
    }

    public void M() {
        xi9 xi9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (xi9Var = this.m) != null) {
            xi9Var.release();
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            OnStatusChangedListener.VideoStatus videoStatus = this.C;
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY);
            } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_ERROR);
            } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER);
            }
        }
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            xi9 xi9Var = this.m;
            if (xi9Var != null) {
                return this.m.g(new c(this, xi9Var.getVideoUrl()), 1.0f);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.m.getPositionMs();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ni9
    public int getCurrentPositionSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            xi9 xi9Var = this.m;
            if (xi9Var == null) {
                return 0;
            }
            return xi9Var.getPositionMs();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.m.getDurationMs();
        }
        return invokeV.intValue;
    }

    public oi9 getMediaProgressObserver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.j;
        }
        return (oi9) invokeV.objValue;
    }

    public String getOriginUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ni9
    public int getPcdnState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public mi9 getPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.m;
        }
        return (mi9) invokeV.objValue;
    }

    public int getPlayerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            xi9 xi9Var = this.m;
            if (xi9Var == null) {
                return 0;
            }
            return xi9Var.getVideoHeight();
        }
        return invokeV.intValue;
    }

    public int getPlayerWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            xi9 xi9Var = this.m;
            if (xi9Var == null) {
                return 0;
            }
            return xi9Var.getVideoWidth();
        }
        return invokeV.intValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.m.getVideoHeight();
        }
        return invokeV.intValue;
    }

    public OnStatusChangedListener.VideoStatus getVideoStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return U(this.C);
        }
        return (OnStatusChangedListener.VideoStatus) invokeV.objValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.m.getVideoWidth();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.m.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.A);
        }
    }

    public void setNoBussinessStats() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.o = null;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            R(1);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048645, this) == null) && !this.k && (getParent() instanceof TbVideoViewContainer)) {
            TbVideoViewSet.c().f((TbVideoViewContainer) getParent(), this.b);
        }
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            if (getParent() == TbVideoViewSet.c().d(this.b)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            if (getParent() != null && getParent().getParent() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                PowerManager powerManager = (PowerManager) TbadkCoreApplication.getInst().getContext().getSystemService("power");
                if (powerManager != null) {
                    PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(536870922, "TbBVideoView_WakeLock");
                    this.e = newWakeLock;
                    newWakeLock.setReferenceCounted(false);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            this.f = new WeakReference<>(TbadkCoreApplication.getInst());
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && (TbSingleton.getInstance().getIsNeedReuseVideoPlayer() || TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer())) {
                this.m = new xi9((Context) null, "video_reuse_player");
                TbSingleton.getInstance().setIsNeedReuseVideoPlayer(false);
                TbSingleton.getInstance().setIsOutNeedReuseVideoPlayer(false);
            } else {
                this.m = new xi9(TbadkCoreApplication.getInst(), new BaseKernelLayer(AbsVideoKernel.CYBER_PLAYER));
            }
            this.m.d();
            this.m.attachToContainer(this);
            this.m.setPlayerListener(this.B);
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                this.m.setLooping(true);
            }
            this.o = new gj9();
            this.j = new oi9();
            SkinManager.setBackgroundResource(this, R.color.black_alpha100);
            Context context = getContext();
            if ((context instanceof LifecycleOwner) && !(this.w instanceof FrameLayout)) {
                ((LifecycleOwner) context).getLifecycle().addObserver(new LifecycleObserver(this) { // from class: com.baidu.tieba.play.TbVideoView.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TbVideoView a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                    private void onDestroy() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(65537, this) == null) {
                            this.a.onDetachedFromWindow();
                            this.a.m.detachFromContainer();
                            this.a.m.setPlayerListener(null);
                        }
                    }
                });
            }
        }
    }

    public final void D(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, uri) == null) {
            this.m.setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
            ej9 pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
            if (pcdnConfigData != null && pcdnConfigData.c()) {
                if (!pcdnConfigData.a(uri)) {
                    this.i = 2;
                    return;
                } else if (hj9.e() != 0 && hj9.e() != -1) {
                    String str = "1";
                    this.m.setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                    xi9 xi9Var = this.m;
                    if (!pcdnConfigData.b()) {
                        str = "0";
                    }
                    xi9Var.setOption(CyberPlayerManager.OPT_ENABLE_P2P, str);
                    this.m.setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(hj9.e()));
                    this.s = true;
                    this.t = pcdnConfigData.b();
                    this.i = 1;
                    return;
                } else {
                    this.i = 3;
                    return;
                }
            }
            this.i = 0;
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (isPlaying() && G()) {
                cj9.d().update(this.b, getCurrentPositionSync());
            }
            this.c = false;
            this.m.pause();
            P();
            if (TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer()) {
                gj9 gj9Var = this.o;
                if (gj9Var != null) {
                    gj9Var.j();
                }
            } else {
                gj9 gj9Var2 = this.o;
                if (gj9Var2 != null) {
                    gj9Var2.e();
                }
            }
            try {
                if (this.e != null && this.e.isHeld()) {
                    this.e.release();
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            tx8 tx8Var = this.p;
            if (tx8Var != null) {
                tx8Var.f();
            }
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (!this.h) {
                stopPlayback();
                return;
            }
            if (this.b != null && isPlaying()) {
                xx5.e(this.f, false);
            }
            this.c = false;
            if (isPlaying() && G()) {
                cj9.d().update(this.b, getCurrentPositionSync());
            }
            try {
                if (this.e != null && this.e.isHeld()) {
                    this.e.release();
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            this.m.pause();
            P();
            gj9 gj9Var = this.o;
            if (gj9Var != null) {
                gj9Var.j();
            }
            this.j.n();
            tx8 tx8Var = this.p;
            if (tx8Var != null && tx8Var.d(this.q, this.r)) {
                this.p = null;
            }
        }
    }

    @Override // com.baidu.tieba.ni9
    public void stopPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            if (this.b != null && isPlaying()) {
                xx5.e(this.f, false);
            }
            this.c = false;
            if (isPlaying() && G()) {
                cj9.d().update(this.b, getCurrentPositionSync());
            }
            try {
                if (this.e != null && this.e.isHeld()) {
                    this.e.release();
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            this.m.stop();
            TbVideoViewSet.c().e(this.b);
            gj9 gj9Var = this.o;
            if (gj9Var != null) {
                gj9Var.j();
            }
            this.j.n();
            tx8 tx8Var = this.p;
            if (tx8Var != null && tx8Var.d(this.q, this.r)) {
                this.p = null;
            }
        }
    }

    public void R(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            PlayerSpeedTracker.beginTrack(cj.c(this.m.getVideoUrl()));
            if (!this.g) {
                xx5.e(this.f, true);
                setVolume(1.0f, 1.0f);
            } else {
                setVolume(0.0f, 0.0f);
            }
            this.c = true;
            this.d = false;
            this.m.start();
            if (this.C == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_PLAYING);
            }
            if (this.C == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_ERROR) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR);
            }
            if (this.C == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER);
            }
            gj9 gj9Var = this.o;
            if (gj9Var != null) {
                if (i == 2) {
                    gj9Var.m(2);
                }
                this.o.i();
            }
            this.j.m();
            try {
                if (this.e != null && !this.e.isHeld()) {
                    this.e.acquire();
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            if (getVideoMonitor() != null) {
                getVideoMonitor().h(-400);
                getVideoMonitor().c(this.s, this.t);
            }
        }
    }

    @Override // com.baidu.tieba.ni9
    public void a(long j, long j2, long j3) {
        tx8 tx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) && (tx8Var = this.p) != null) {
            tx8Var.a(j, j2, j3);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            xx5.e(this.f, false);
            if (isPlaying() && G()) {
                cj9.d().update(this.b, getCurrentPositionSync());
            }
            this.c = false;
            this.m.pause();
            P();
            gj9 gj9Var = this.o;
            if (gj9Var != null) {
                gj9Var.e();
            }
            try {
                if (this.e != null && this.e.isHeld()) {
                    this.e.release();
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            tx8 tx8Var = this.p;
            if (tx8Var != null) {
                tx8Var.f();
            }
        }
    }

    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048634, this, str) != null) || ui.isEmpty(str)) {
            return;
        }
        O();
        if (!UbsABTestHelper.isVideoSetUrlAgainABTest() && ui.isEquals(this.b, str) && this.m.getStatus() != PlayerStatus.STOP) {
            return;
        }
        this.b = str;
        String x = x(str);
        wx8 wx8Var = F;
        if (wx8Var != null) {
            tx8 a2 = wx8Var.a(this.n, this.b, null);
            this.p = a2;
            if (a2 != null) {
                a2.b(CyberPlayerManager.hasCacheFile(x));
            }
        }
        this.j.l(this);
        gj9 gj9Var = this.o;
        if (gj9Var != null) {
            gj9Var.h();
        }
        D(Uri.parse(x));
        tx8 tx8Var = this.p;
        if (tx8Var != null) {
            tx8Var.j();
        }
        String c2 = cj.c(x);
        bj9 bj9Var = this.u;
        if (bj9Var != null) {
            bj9Var.a = "";
            bj9Var.b = x;
            bj9Var.c = c2;
            this.m.e(bj9Var);
        } else {
            gj9 gj9Var2 = this.o;
            if (gj9Var2 != null && gj9Var2.c() != null) {
                bj9 bj9Var2 = new bj9();
                bj9Var2.a = "";
                bj9Var2.b = x;
                bj9Var2.c = c2;
                String b2 = bj9Var2.b(this.o.c().a);
                bj9Var2.e = b2;
                bj9Var2.d = bj9Var2.a(b2);
                bj9Var2.f = bj9Var2.c(this.o.b());
                this.m.e(bj9Var2);
            }
        }
        this.m.setVideoUniqueKey(c2);
        if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
            boolean b3 = this.m.b(x);
            this.v = b3;
            if (b3) {
                v();
                gj9 gj9Var3 = this.o;
                if (gj9Var3 != null) {
                    gj9Var3.g(getDuration());
                }
            }
            this.m.setVideoUrl(x, !this.v);
            return;
        }
        this.m.setVideoUrl(x);
    }

    @Override // com.baidu.tieba.ni9
    public void setVolume(float f, float f2) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048642, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) && this.m != null) {
            if (f == 0.0f && f2 == 0.0f) {
                z = true;
            } else {
                z = false;
            }
            this.g = z;
            this.m.f(f, f2);
        }
    }
}
