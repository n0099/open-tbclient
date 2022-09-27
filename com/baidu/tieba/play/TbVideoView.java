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
import androidx.core.view.ViewCompat;
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
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.ubc.PlayerSpeedTracker;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ab8;
import com.baidu.tieba.bb8;
import com.baidu.tieba.db8;
import com.baidu.tieba.dj;
import com.baidu.tieba.eb8;
import com.baidu.tieba.fb8;
import com.baidu.tieba.hv8;
import com.baidu.tieba.jp7;
import com.baidu.tieba.la8;
import com.baidu.tieba.lj;
import com.baidu.tieba.ma8;
import com.baidu.tieba.mp7;
import com.baidu.tieba.na8;
import com.baidu.tieba.pi5;
import com.baidu.tieba.play.OnStatusChangedListener;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.ua8;
import com.baidu.tieba.ya8;
import com.baidu.tieba.za8;
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
/* loaded from: classes5.dex */
public class TbVideoView extends FrameLayout implements ma8 {
    public static /* synthetic */ Interceptable $ic;
    public static mp7 E;
    public transient /* synthetic */ FieldHolder $fh;
    public IVideoPlayerCallback A;
    public OnStatusChangedListener.VideoStatus B;
    public boolean C;
    public OnStatusChangedListener D;
    public boolean a;
    public String b;
    public boolean c;
    public boolean d;
    public PowerManager.WakeLock e;
    public WeakReference<Context> f;
    public boolean g;
    public boolean h;
    public int i;
    public na8 j;
    public boolean k;
    public boolean l;
    public ua8 m;
    public String n;
    public db8 o;
    public jp7 p;
    public String q;
    public String r;
    public boolean s;
    public boolean t;
    public ya8 u;
    public boolean v;
    public fb8 w;
    public TbVideoViewContainer.a x;
    public boolean y;
    public final CustomMessageListener z;

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
        public void onEnd(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && i == 307) {
                if (this.a.p != null) {
                    this.a.p.e(this.a.q, this.a.r);
                    this.a.p = null;
                }
                this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_COMPLETE);
                za8.d().e(this.a.b);
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
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048580, this, i, i2, str) == null) {
                if (this.a.getCurrentPosition() > 0 && this.a.F()) {
                    za8.d().update(this.a.b, this.a.getCurrentPosition());
                }
                TbVideoViewSet.c().e(this.a.b);
                if (this.a.w != null) {
                    this.a.w.onError(i, i2, str);
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onInfo(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
                if (this.a.w != null) {
                    this.a.w.onInfo(i, i2, null);
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
                    if (this.a.B != OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER) {
                        this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_PLAYING);
                    } else {
                        this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY);
                    }
                }
                if (i != 904 || this.a.o == null) {
                    return;
                }
                this.a.o.f(this.a);
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onNetworkSpeedUpdate(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onPause() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && UbsABTestHelper.isFeedVideoImmersionTransition()) {
                this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_PAUSING);
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onPrepared() {
            int c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                if (this.a.o != null) {
                    this.a.o.g(this.a.getDuration());
                }
                this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_PREPARED);
                if (this.a.getVideoMonitor() != null) {
                    this.a.getVideoMonitor().l(ErrorCode.ARGS_ERROR);
                }
                this.a.u();
                if (this.a.w != null) {
                    this.a.w.onPrepared();
                }
                if (this.a.a && (c = za8.d().c(this.a.b)) > 0) {
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
        public void onResume() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && UbsABTestHelper.isFeedVideoImmersionTransition()) {
                this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_PLAYING);
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onSeekEnd() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.a.w == null) {
                return;
            }
            this.a.w.onSeekComplete();
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onUpdateProgress(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIII(1048588, this, i, i2, i3) == null) || !UbsABTestHelper.isFeedVideoImmersionTransition() || i > i3 || i3 - i >= 1000 || this.a.o == null) {
                return;
            }
            this.a.o.n(i3);
            this.a.o.p(i);
            this.a.o.j();
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onVideoSizeChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements OnSnapShotFrameListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbVideoView a;

        public c(TbVideoView tbVideoView) {
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

        @Override // com.baidu.searchbox.player.interfaces.OnSnapShotFrameListener
        public void onSnapShotComplete(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) || bitmap == null) {
                return;
            }
            TbSingleton.getInstance().setVideoCurrentFrame(bitmap);
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, mp7.class);
        if (runTask != null) {
            E = (mp7) runTask.getData();
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
    public jp7 getVideoMonitor() {
        InterceptResult invokeV;
        mp7 mp7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            jp7 jp7Var = this.p;
            if (jp7Var != null) {
                return jp7Var;
            }
            if (!StringUtils.isNull(this.b) && (mp7Var = E) != null) {
                this.p = mp7Var.a(this.n, this.b, null);
            }
            return this.p;
        }
        return (jp7) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoStatus(OnStatusChangedListener.VideoStatus videoStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, videoStatus) == null) {
            OnStatusChangedListener onStatusChangedListener = this.D;
            if (onStatusChangedListener != null) {
                if (this.y) {
                    onStatusChangedListener.onStatusChange(videoStatus);
                } else {
                    onStatusChangedListener.onStatusChange(R(videoStatus));
                }
            }
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                this.C = true;
                if (this.d) {
                    J();
                    this.d = false;
                } else if (!this.g) {
                    setVolume(1.0f, 1.0f);
                }
            }
            this.B = videoStatus;
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.x = null;
            this.D = null;
            this.w = null;
            this.j.j(null);
            this.j.i(null);
            this.j.k(null);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
                this.m = new ua8((Context) null, "video_reuse_player");
                TbSingleton.getInstance().setIsNeedReuseVideoPlayer(false);
                TbSingleton.getInstance().setIsOutNeedReuseVideoPlayer(false);
            } else {
                this.m = new ua8(TbadkCoreApplication.getInst(), new BaseKernelLayer(AbsVideoKernel.CYBER_PLAYER));
            }
            this.m.h();
            this.m.attachToContainer(this);
            this.m.setPlayerListener(this.A);
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                this.m.setLooping(true);
            }
            this.o = new db8();
            this.j = new na8();
            SkinManager.setBackgroundResource(this, R.color.black_alpha100);
            Context context = getContext();
            if (!(context instanceof LifecycleOwner) || (this.w instanceof FrameLayout)) {
                return;
            }
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

    public final void C(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uri) == null) {
            this.m.setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
            bb8 pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
            if (pcdnConfigData != null && pcdnConfigData.c()) {
                if (!pcdnConfigData.a(uri)) {
                    this.i = 2;
                    return;
                } else if (eb8.e() != 0 && eb8.e() != -1) {
                    this.m.setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                    this.m.setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.b() ? "1" : "0");
                    this.m.setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(eb8.e()));
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

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.C : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : invokeV.booleanValue;
    }

    public final boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ua8 ua8Var = this.m;
            return ua8Var != null && ua8Var.getDurationMs() >= this.m.getPositionMs();
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            db8 db8Var = this.o;
            if (db8Var != null) {
                db8Var.h();
                this.o.g(getDuration());
                this.o.f(this);
            }
            if (getVideoMonitor() != null) {
                getVideoMonitor().b(CyberPlayerManager.hasCacheFile(this.b));
                getVideoMonitor().i(ErrorCode.ARGS_ERROR);
            }
        }
    }

    @Deprecated
    public void H() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || getVideoMonitor() == null) {
            return;
        }
        getVideoMonitor().b(CyberPlayerManager.hasCacheFile(this.b));
        getVideoMonitor().j();
        getVideoMonitor().l(ErrorCode.ARGS_ERROR);
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.y = z;
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (isPlaying() && F()) {
                za8.d().update(this.b, getCurrentPositionSync());
            }
            this.c = false;
            this.m.pause();
            N();
            if (TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer()) {
                db8 db8Var = this.o;
                if (db8Var != null) {
                    db8Var.j();
                }
            } else {
                db8 db8Var2 = this.o;
                if (db8Var2 != null) {
                    db8Var2.e();
                }
            }
            try {
                if (this.e != null && this.e.isHeld()) {
                    this.e.release();
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            jp7 jp7Var = this.p;
            if (jp7Var != null) {
                jp7Var.f();
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            setIsVolume0(true);
            start();
            this.d = true;
            setIsVolume0(false);
        }
    }

    public void L(TbVideoViewSet.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            if (!isPlaying() && !this.c) {
                this.c = true;
                if (bVar != null) {
                    this.h = true;
                    if (!y()) {
                        bVar.b();
                    }
                } else {
                    this.h = false;
                }
                setVideoPath(this.b, this.n);
                if (UbsABTestHelper.isVideoSetUrlAgainABTest()) {
                    return;
                }
                start();
                return;
            }
            P(bVar);
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20513");
            hashMap.put("click_time", "" + System.currentTimeMillis());
            this.m.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            OnStatusChangedListener.VideoStatus videoStatus = this.B;
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY);
            } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_ERROR);
            } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER);
            }
        }
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ua8 ua8Var = this.m;
            if (ua8Var != null) {
                return ua8Var.k(new c(this), 1.0f);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void P(TbVideoViewSet.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            if (bVar != null) {
                this.h = true;
                if (!y()) {
                    bVar.b();
                }
                if (!x()) {
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

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (!this.h) {
                stopPlayback();
                return;
            }
            if (this.b != null && isPlaying()) {
                pi5.e(this.f, false);
            }
            this.c = false;
            if (isPlaying() && F()) {
                za8.d().update(this.b, getCurrentPositionSync());
            }
            try {
                if (this.e != null && this.e.isHeld()) {
                    this.e.release();
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            this.m.pause();
            N();
            db8 db8Var = this.o;
            if (db8Var != null) {
                db8Var.j();
            }
            this.j.n();
            jp7 jp7Var = this.p;
            if (jp7Var == null || !jp7Var.d(this.q, this.r)) {
                return;
            }
            this.p = null;
        }
    }

    public final OnStatusChangedListener.VideoStatus R(OnStatusChangedListener.VideoStatus videoStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, videoStatus)) == null) {
            if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY) {
                return OnStatusChangedListener.VideoStatus.VIDEO_PAUSING;
            }
            if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_ERROR) {
                return OnStatusChangedListener.VideoStatus.VIDEO_PAUSING;
            }
            if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR) {
                return OnStatusChangedListener.VideoStatus.VIDEO_BUFFERING;
            }
            return videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER ? OnStatusChangedListener.VideoStatus.VIDEO_BUFFERING : videoStatus;
        }
        return (OnStatusChangedListener.VideoStatus) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ma8
    public void a(long j, long j2, long j3) {
        jp7 jp7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) || (jp7Var = this.p) == null) {
            return;
        }
        jp7Var.a(j, j2, j3);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.m.getPositionMs() : invokeV.intValue;
    }

    @Override // com.baidu.tieba.ma8
    public int getCurrentPositionSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            ua8 ua8Var = this.m;
            if (ua8Var == null) {
                return 0;
            }
            return ua8Var.getPositionMs();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.m.getDurationMs() : invokeV.intValue;
    }

    @Override // com.baidu.tieba.ma8
    public na8 getMediaProgressObserver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.j : (na8) invokeV.objValue;
    }

    public String getOriginUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ma8
    public int getPcdnState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.i : invokeV.intValue;
    }

    public la8 getPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.m : (la8) invokeV.objValue;
    }

    public int getPlayerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            ua8 ua8Var = this.m;
            if (ua8Var == null) {
                return 0;
            }
            return ua8Var.getVideoHeight();
        }
        return invokeV.intValue;
    }

    public int getPlayerWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            ua8 ua8Var = this.m;
            if (ua8Var == null) {
                return 0;
            }
            return ua8Var.getVideoWidth();
        }
        return invokeV.intValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.m.getVideoHeight() : invokeV.intValue;
    }

    public OnStatusChangedListener.VideoStatus getVideoStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? R(this.B) : (OnStatusChangedListener.VideoStatus) invokeV.objValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.m.getVideoWidth() : invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.m.isPlaying() : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
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
            A();
            MessageManager.getInstance().unRegisterListener(this.z);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            pi5.e(this.f, false);
            if (isPlaying() && F()) {
                za8.d().update(this.b, getCurrentPositionSync());
            }
            this.c = false;
            this.m.pause();
            N();
            db8 db8Var = this.o;
            if (db8Var != null) {
                db8Var.e();
            }
            try {
                if (this.e != null && this.e.isHeld()) {
                    this.e.release();
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            jp7 jp7Var = this.p;
            if (jp7Var != null) {
                jp7Var.f();
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.m.seekToMs(i);
        }
    }

    public void setCanShowPause(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.C = z;
        }
    }

    public void setContinuePlayEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.a = z;
        }
    }

    public void setIsVolume0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.g = z;
        }
    }

    public void setLocateSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.q = str;
        }
    }

    @Override // com.baidu.tieba.ma8
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.l = z;
            this.m.setLooping(z);
        }
    }

    public void setNoBussinessStats() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.o = null;
        }
    }

    @Override // com.baidu.tieba.ma8
    public void setOnSurfaceDestroyedListener(TbVideoViewContainer.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, aVar) == null) {
            this.x = aVar;
        }
    }

    @Override // com.baidu.tieba.ma8
    public void setOperableVideoContainer(fb8 fb8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, fb8Var) == null) {
            this.w = fb8Var;
        }
    }

    @Override // com.baidu.tieba.ma8
    public void setPlayMode(String str) {
        db8 db8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, str) == null) || (db8Var = this.o) == null) {
            return;
        }
        db8Var.l(str);
    }

    @Override // com.baidu.tieba.ma8
    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            if (dj.isEmpty(str)) {
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
        if (interceptable == null || interceptable.invokeL(1048627, this, threadData) == null) {
            if (this.o == null) {
                this.o = new db8();
            }
            this.o.m(threadData);
        }
    }

    public void setTryUseViewInSet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.h = z;
        }
    }

    public void setVideoModel(ya8 ya8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, ya8Var) == null) {
            this.u = ya8Var;
        }
    }

    @Override // com.baidu.tieba.ma8
    public void setVideoPath(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048631, this, str, str2) == null) || dj.isEmpty(str)) {
            return;
        }
        this.n = str2;
        setVideoPath(str);
    }

    public void setVideoScalingMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i) == null) {
            this.m.setVideoScalingMode(i);
        }
    }

    @Override // com.baidu.tieba.ma8
    public void setVideoStatData(ab8 ab8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, ab8Var) == null) {
            if (this.o == null) {
                this.o = new db8();
            }
            this.o.o(ab8Var);
            if (ab8Var != null) {
                this.q = ab8Var.a;
            }
        }
    }

    public void setVideoStatusChangeListener(OnStatusChangedListener onStatusChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, onStatusChangedListener) == null) {
            this.D = onStatusChangedListener;
        }
    }

    @Override // com.baidu.tieba.ma8
    public void setVolume(float f, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) || this.m == null) {
            return;
        }
        this.g = f == 0.0f && f2 == 0.0f;
        this.m.j(f, f2);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            PlayerSpeedTracker.beginTrack(lj.c(this.m.getVideoUrl()));
            if (!this.g) {
                pi5.e(this.f, true);
                setVolume(1.0f, 1.0f);
            } else {
                setVolume(0.0f, 0.0f);
            }
            this.c = true;
            this.d = false;
            this.m.start();
            if (this.B == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_PLAYING);
            }
            if (this.B == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_ERROR) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR);
            }
            if (this.B == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER);
            }
            db8 db8Var = this.o;
            if (db8Var != null) {
                db8Var.i();
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
                getVideoMonitor().h(ErrorCode.ARGS_ERROR);
                getVideoMonitor().c(this.s, this.t);
            }
        }
    }

    @Override // com.baidu.tieba.ma8
    public void stopPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            if (this.b != null && isPlaying()) {
                pi5.e(this.f, false);
            }
            this.c = false;
            if (isPlaying() && F()) {
                za8.d().update(this.b, getCurrentPositionSync());
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
            db8 db8Var = this.o;
            if (db8Var != null) {
                db8Var.j();
            }
            this.j.n();
            jp7 jp7Var = this.p;
            if (jp7Var == null || !jp7Var.d(this.q, this.r)) {
                return;
            }
            this.p = null;
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048638, this) == null) && !this.k && ViewCompat.isAttachedToWindow(this) && !this.d && (getParent() instanceof TbVideoViewContainer)) {
            TbVideoViewSet.c().f((TbVideoViewContainer) getParent(), this.b);
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i) == null) {
            this.m.setVideoScalingMode(i);
        }
    }

    public final String w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, str)) == null) {
            if (!dj.isEmpty(str) && hv8.c().d()) {
                if (str.contains("http://tb-video.bdstatic.com")) {
                    return str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
                }
                return str.contains(UrlSchemaHelper.SCHEMA_TYPE_HTTP) ? str.replace(UrlSchemaHelper.SCHEMA_TYPE_HTTP, UrlSchemaHelper.SCHEMA_TYPE_HTTPS) : str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? getParent() == TbVideoViewSet.c().d(this.b) : invokeV.booleanValue;
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? (getParent() == null || getParent().getParent() == null) ? false : true : invokeV.booleanValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            A();
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
        this.z = new a(this, 2001011);
        this.A = new b(this);
        this.B = OnStatusChangedListener.VideoStatus.INIT;
        this.C = false;
        B();
    }

    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, str) == null) || dj.isEmpty(str)) {
            return;
        }
        M();
        if (UbsABTestHelper.isVideoSetUrlAgainABTest() || !dj.isEquals(this.b, str) || this.m.getStatus() == PlayerStatus.STOP) {
            this.b = str;
            String w = w(str);
            mp7 mp7Var = E;
            if (mp7Var != null) {
                jp7 a2 = mp7Var.a(this.n, this.b, null);
                this.p = a2;
                if (a2 != null) {
                    a2.b(CyberPlayerManager.hasCacheFile(w));
                }
            }
            this.j.l(this);
            db8 db8Var = this.o;
            if (db8Var != null) {
                db8Var.h();
            }
            C(Uri.parse(w));
            jp7 jp7Var = this.p;
            if (jp7Var != null) {
                jp7Var.j();
            }
            String c2 = lj.c(w);
            ya8 ya8Var = this.u;
            if (ya8Var != null) {
                ya8Var.a = "";
                ya8Var.b = w;
                ya8Var.c = c2;
                this.m.i(ya8Var);
            } else {
                db8 db8Var2 = this.o;
                if (db8Var2 != null && db8Var2.c() != null) {
                    ya8 ya8Var2 = new ya8();
                    ya8Var2.a = "";
                    ya8Var2.b = w;
                    ya8Var2.c = c2;
                    String b2 = ya8Var2.b(this.o.c().a);
                    ya8Var2.e = b2;
                    ya8Var2.d = ya8Var2.a(b2);
                    ya8Var2.f = ya8Var2.c(this.o.b());
                    this.m.i(ya8Var2);
                }
            }
            this.m.setVideoUniqueKey(c2);
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                boolean f = this.m.f(w);
                this.v = f;
                if (f) {
                    u();
                    db8 db8Var3 = this.o;
                    if (db8Var3 != null) {
                        db8Var3.g(getDuration());
                    }
                }
                this.m.setVideoUrl(w, !this.v);
                return;
            }
            this.m.setVideoUrl(w);
        }
    }
}
