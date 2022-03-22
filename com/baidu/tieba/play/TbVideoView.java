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
import c.a.d.f.p.m;
import c.a.o0.c1.t0;
import c.a.p0.c3.f;
import c.a.p0.c3.g;
import c.a.p0.c3.h;
import c.a.p0.c3.o;
import c.a.p0.c3.s;
import c.a.p0.c3.t;
import c.a.p0.c3.u;
import c.a.p0.c3.v.d;
import c.a.p0.l2.k;
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
/* loaded from: classes5.dex */
public class TbVideoView extends FrameLayout implements g {
    public static /* synthetic */ Interceptable $ic;
    public static k D;
    public transient /* synthetic */ FieldHolder $fh;
    public TbCyberVideoView.VideoStatus A;
    public boolean B;
    public TbCyberVideoView.g C;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public String f35550b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35551c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35552d;

    /* renamed from: e  reason: collision with root package name */
    public PowerManager.WakeLock f35553e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<Context> f35554f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35555g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f35556h;
    public int i;
    public h j;
    public boolean k;
    public boolean l;
    public o m;
    public String n;
    public c.a.p0.c3.v.c o;
    public c.a.p0.l2.h p;
    public String q;
    public String r;
    public boolean s;
    public boolean t;
    public s u;
    public boolean v;
    public c.a.p0.c3.w.a w;
    public TbVideoViewContainer.a x;
    public final CustomMessageListener y;
    public IVideoPlayerCallback z;

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
                this.a.setVideoStatus(TbCyberVideoView.VideoStatus.VIDEO_COMPLETE);
                t.d().e(this.a.f35550b);
                if (this.a.o != null) {
                    this.a.o.j();
                }
                if (this.a.l) {
                    return;
                }
                if (this.a.o != null) {
                    this.a.o.d();
                }
                this.a.f35551c = false;
                if (this.a.w != null) {
                    this.a.w.onCompletion();
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048580, this, i, i2, str) == null) {
                if (this.a.getCurrentPosition() > 0 && this.a.J()) {
                    t.d().update(this.a.f35550b, this.a.getCurrentPosition());
                }
                TbVideoViewSet.b().d(this.a.f35550b);
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
                    this.a.setVideoStatus(TbCyberVideoView.VideoStatus.VIDEO_PLAYING);
                }
                if (i == 10007) {
                    this.a.setVideoStatus(TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR);
                }
                if (i == 701) {
                    this.a.setVideoStatus(TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER);
                }
                if (i == 702) {
                    if (this.a.A != TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER) {
                        this.a.setVideoStatus(TbCyberVideoView.VideoStatus.VIDEO_PLAYING);
                    } else {
                        this.a.setVideoStatus(TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY);
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
                this.a.setVideoStatus(TbCyberVideoView.VideoStatus.VIDEO_PAUSING);
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onPrepared() {
            int c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                if (this.a.o != null) {
                    this.a.o.g(this.a.getDuration());
                }
                this.a.setVideoStatus(TbCyberVideoView.VideoStatus.VIDEO_PREPARED);
                if (this.a.getVideoMonitor() != null) {
                    this.a.getVideoMonitor().l(ErrorCode.ARGS_ERROR);
                }
                this.a.C();
                if (this.a.w != null) {
                    this.a.w.onPrepared();
                }
                if (this.a.a && (c2 = t.d().c(this.a.f35550b)) > 0) {
                    this.a.seekTo(c2);
                }
                if (this.a.f35551c) {
                    boolean z = this.a.f35552d;
                    this.a.start();
                    this.a.f35552d = z;
                    if (this.a.f35552d) {
                        this.a.setVolume(0.0f, 0.0f);
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onResume() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && UbsABTestHelper.isFeedVideoImmersionTransition()) {
                this.a.setVideoStatus(TbCyberVideoView.VideoStatus.VIDEO_PLAYING);
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        if (runTask != null) {
            D = (k) runTask.getData();
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
    public c.a.p0.l2.h getVideoMonitor() {
        InterceptResult invokeV;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            c.a.p0.l2.h hVar = this.p;
            if (hVar != null) {
                return hVar;
            }
            if (!StringUtils.isNull(this.f35550b) && (kVar = D) != null) {
                this.p = kVar.a(this.n, this.f35550b, null);
            }
            return this.p;
        }
        return (c.a.p0.l2.h) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoStatus(TbCyberVideoView.VideoStatus videoStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, videoStatus) == null) {
            TbCyberVideoView.g gVar = this.C;
            if (gVar != null) {
                gVar.onStatusChange(N(videoStatus));
            }
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                this.B = true;
                if (this.f35552d) {
                    q();
                    this.f35552d = false;
                } else if (!this.f35555g) {
                    setVolume(1.0f, 1.0f);
                }
            }
            this.A = videoStatus;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.k && ViewCompat.isAttachedToWindow(this) && !this.f35552d && (getParent() instanceof TbVideoViewContainer)) {
            TbVideoViewSet.b().e((TbVideoViewContainer) getParent(), this.f35550b);
        }
    }

    public final String D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (!m.isEmpty(str) && c.a.p0.n4.h.c().d()) {
                if (str.contains("http://tb-video.bdstatic.com")) {
                    return str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
                }
                return str.contains(UrlSchemaHelper.SCHEMA_TYPE_HTTP) ? str.replace(UrlSchemaHelper.SCHEMA_TYPE_HTTP, UrlSchemaHelper.SCHEMA_TYPE_HTTPS) : str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getParent() == TbVideoViewSet.b().c(this.f35550b) : invokeV.booleanValue;
    }

    public final boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (getParent() == null || getParent().getParent() == null) ? false : true : invokeV.booleanValue;
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.x = null;
            this.C = null;
            this.w = null;
            this.j.j(null);
            this.j.i(null);
            this.j.k(null);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                PowerManager powerManager = (PowerManager) TbadkCoreApplication.getInst().getContext().getSystemService("power");
                if (powerManager != null) {
                    PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(536870922, "TbBVideoView_WakeLock");
                    this.f35553e = newWakeLock;
                    newWakeLock.setReferenceCounted(false);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            this.f35554f = new WeakReference<>(TbadkCoreApplication.getInst());
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && (TbSingleton.getInstance().getIsNeedReuseVideoPlayer() || TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer())) {
                this.m = new o((Context) null, "video_reuse_player");
                TbSingleton.getInstance().setIsNeedReuseVideoPlayer(false);
                TbSingleton.getInstance().setIsOutNeedReuseVideoPlayer(false);
            } else {
                this.m = new o(TbadkCoreApplication.getInst(), new BaseKernelLayer(AbsVideoKernel.CYBER_PLAYER));
            }
            this.m.h();
            this.m.attachToContainer(this);
            this.m.setPlayerListener(this.z);
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                this.m.setLooping(true);
            }
            this.o = new c.a.p0.c3.v.c();
            this.j = new h();
            SkinManager.setBackgroundResource(this, R.color.black_alpha100);
        }
    }

    public final void I(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, uri) == null) {
            this.m.setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
            c.a.p0.c3.v.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
            if (pcdnConfigData != null && pcdnConfigData.c()) {
                if (!pcdnConfigData.a(uri)) {
                    this.i = 2;
                    return;
                } else if (d.e() != 0 && d.e() != -1) {
                    this.m.setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                    this.m.setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.b() ? "1" : "0");
                    this.m.setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(d.e()));
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

    public final boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            o oVar = this.m;
            return oVar != null && oVar.getDurationMs() >= this.m.getPositionMs();
        }
        return invokeV.booleanValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20513");
            hashMap.put("click_time", "" + System.currentTimeMillis());
            this.m.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TbCyberVideoView.VideoStatus videoStatus = this.A;
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                setVideoStatus(TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY);
            } else if (videoStatus == TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR) {
                setVideoStatus(TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_PAUSING_ERROR);
            } else if (videoStatus == TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER) {
                setVideoStatus(TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER);
            }
        }
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            o oVar = this.m;
            if (oVar != null) {
                return oVar.k(new c(this), 1.0f);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final TbCyberVideoView.VideoStatus N(TbCyberVideoView.VideoStatus videoStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, videoStatus)) == null) {
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

    @Override // c.a.p0.c3.g
    public void a(long j, long j2, long j3) {
        c.a.p0.l2.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) || (hVar = this.p) == null) {
            return;
        }
        hVar.a(j, j2, j3);
    }

    @Override // c.a.p0.c3.g
    public void b(TbVideoViewSet.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            if (!isPlaying() && !this.f35551c) {
                this.f35551c = true;
                if (bVar != null) {
                    this.f35556h = true;
                    if (!F()) {
                        bVar.b();
                    }
                } else {
                    this.f35556h = false;
                }
                setVideoPath(this.f35550b, this.n);
                if (UbsABTestHelper.isVideoSetUrlAgainABTest()) {
                    return;
                }
                start();
                return;
            }
            p(bVar);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.g
    public void changeRenderViewMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.m.setVideoScalingMode(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.m.getPositionMs() : invokeV.intValue;
    }

    @Override // c.a.p0.c3.g
    public int getCurrentPositionSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            o oVar = this.m;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.m.getDurationMs() : invokeV.intValue;
    }

    @Override // c.a.p0.c3.g
    public h getMediaProgressObserver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.j : (h) invokeV.objValue;
    }

    @Override // c.a.p0.c3.g
    public String getOriginUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f35550b : (String) invokeV.objValue;
    }

    @Override // c.a.p0.c3.g
    public int getPcdnState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.i : invokeV.intValue;
    }

    @Override // c.a.p0.c3.g
    public f getPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.m : (f) invokeV.objValue;
    }

    @Override // c.a.p0.c3.g
    public int getPlayerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            o oVar = this.m;
            if (oVar == null) {
                return 0;
            }
            return oVar.getVideoHeight();
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.c3.g
    public int getPlayerWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            o oVar = this.m;
            if (oVar == null) {
                return 0;
            }
            return oVar.getVideoWidth();
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.c3.g
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.m.getVideoHeight() : invokeV.intValue;
    }

    @Override // c.a.p0.c3.g
    public TbCyberVideoView.VideoStatus getVideoStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? N(this.A) : (TbCyberVideoView.VideoStatus) invokeV.objValue;
    }

    @Override // c.a.p0.c3.g
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.m.getVideoWidth() : invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.m.isPlaying() : invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.g
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            G();
        }
    }

    @Override // c.a.p0.c3.g
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            start();
            this.f35552d = true;
        }
    }

    @Override // c.a.p0.c3.g
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.B : invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.g
    @Deprecated
    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || getVideoMonitor() == null) {
            return;
        }
        getVideoMonitor().b(CyberPlayerManager.hasCacheFile(this.f35550b));
        getVideoMonitor().j();
        getVideoMonitor().l(ErrorCode.ARGS_ERROR);
    }

    @Override // c.a.p0.c3.g
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f35551c : invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.g
    @Deprecated
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            c.a.p0.c3.v.c cVar = this.o;
            if (cVar != null) {
                cVar.h();
                this.o.g(getDuration());
                this.o.f(this);
            }
            if (getVideoMonitor() != null) {
                getVideoMonitor().b(CyberPlayerManager.hasCacheFile(this.f35550b));
                getVideoMonitor().i(ErrorCode.ARGS_ERROR);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.y);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onDetachedFromWindow();
            TbVideoViewContainer.a aVar = this.x;
            if (aVar != null) {
                aVar.onSurfaceDestroyed();
            }
            try {
                if (this.f35553e != null && this.f35553e.isHeld()) {
                    this.f35553e.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            G();
            MessageManager.getInstance().unRegisterListener(this.y);
        }
    }

    @Override // c.a.p0.c3.g
    public void p(TbVideoViewSet.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, bVar) == null) {
            if (bVar != null) {
                this.f35556h = true;
                if (!F()) {
                    bVar.b();
                }
                if (!E()) {
                    bVar.a();
                    this.f35551c = true;
                    this.f35552d = false;
                    setVideoPath(this.f35550b, this.n);
                    if (UbsABTestHelper.isVideoSetUrlAgainABTest()) {
                        return;
                    }
                }
            } else {
                this.f35556h = false;
            }
            start();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            t0.f(this.f35554f, false);
            if (isPlaying() && J()) {
                t.d().update(this.f35550b, getCurrentPositionSync());
            }
            this.f35551c = false;
            this.m.pause();
            L();
            c.a.p0.c3.v.c cVar = this.o;
            if (cVar != null) {
                cVar.e();
            }
            try {
                if (this.f35553e != null && this.f35553e.isHeld()) {
                    this.f35553e.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            c.a.p0.l2.h hVar = this.p;
            if (hVar != null) {
                hVar.f();
            }
        }
    }

    @Override // c.a.p0.c3.g
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (isPlaying() && J()) {
                t.d().update(this.f35550b, getCurrentPositionSync());
            }
            this.f35551c = false;
            this.m.pause();
            L();
            if (TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer()) {
                c.a.p0.c3.v.c cVar = this.o;
                if (cVar != null) {
                    cVar.j();
                }
            } else {
                c.a.p0.c3.v.c cVar2 = this.o;
                if (cVar2 != null) {
                    cVar2.e();
                }
            }
            try {
                if (this.f35553e != null && this.f35553e.isHeld()) {
                    this.f35553e.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            c.a.p0.l2.h hVar = this.p;
            if (hVar != null) {
                hVar.f();
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            this.m.seekToMs(i);
        }
    }

    @Override // c.a.p0.c3.g
    public void setCanShowPause(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.B = z;
        }
    }

    @Override // c.a.p0.c3.g
    public void setContinuePlayEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.a = z;
        }
    }

    @Override // c.a.p0.c3.g
    public void setIsVolume0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.f35555g = z;
        }
    }

    @Override // c.a.p0.c3.g
    public void setLocateSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.q = str;
        }
    }

    @Override // c.a.p0.c3.g
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.l = z;
            this.m.setLooping(z);
        }
    }

    @Override // c.a.p0.c3.g
    public void setNoBussinessStats() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.o = null;
        }
    }

    @Override // c.a.p0.c3.g
    public void setOnSurfaceDestroyedListener(TbVideoViewContainer.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, aVar) == null) {
            this.x = aVar;
        }
    }

    @Override // c.a.p0.c3.g
    public void setOperableVideoContainer(c.a.p0.c3.w.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, aVar) == null) {
            this.w = aVar;
        }
    }

    @Override // c.a.p0.c3.g
    public void setPlayMode(String str) {
        c.a.p0.c3.v.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, str) == null) || (cVar = this.o) == null) {
            return;
        }
        cVar.l(str);
    }

    @Override // c.a.p0.c3.g
    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            if (m.isEmpty(str)) {
                str = "-1";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20484");
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, str);
            this.m.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.r = str;
        }
    }

    @Override // c.a.p0.c3.g
    public void setThreadDataForStatistic(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, threadData) == null) {
            if (this.o == null) {
                this.o = new c.a.p0.c3.v.c();
            }
            this.o.m(threadData);
        }
    }

    @Override // c.a.p0.c3.g
    public void setTryUseViewInSet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.f35556h = z;
        }
    }

    @Override // c.a.p0.c3.g
    public void setVideoModel(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, sVar) == null) {
            this.u = sVar;
        }
    }

    @Override // c.a.p0.c3.g
    public void setVideoPath(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048635, this, str, str2) == null) || m.isEmpty(str)) {
            return;
        }
        this.n = str2;
        setVideoPath(str);
    }

    @Override // c.a.p0.c3.g
    public void setVideoScalingMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i) == null) {
            this.m.setVideoScalingMode(i);
        }
    }

    @Override // c.a.p0.c3.g
    public void setVideoStatData(u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, uVar) == null) {
            if (this.o == null) {
                this.o = new c.a.p0.c3.v.c();
            }
            this.o.o(uVar);
            if (uVar != null) {
                this.q = uVar.a;
            }
        }
    }

    @Override // c.a.p0.c3.g
    public void setVideoStatusChangeListener(TbCyberVideoView.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, gVar) == null) {
            this.C = gVar;
        }
    }

    @Override // c.a.p0.c3.g
    public void setVolume(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048639, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || this.m == null) {
            return;
        }
        this.f35555g = f2 == 0.0f && f3 == 0.0f;
        this.m.j(f2, f3);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            if (!this.f35555g) {
                t0.f(this.f35554f, true);
                setVolume(1.0f, 1.0f);
            } else {
                setVolume(0.0f, 0.0f);
            }
            this.f35551c = true;
            this.f35552d = false;
            this.m.start();
            if (this.A == TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY) {
                setVideoStatus(TbCyberVideoView.VideoStatus.VIDEO_PLAYING);
            }
            if (this.A == TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_PAUSING_ERROR) {
                setVideoStatus(TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR);
            }
            if (this.A == TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER) {
                setVideoStatus(TbCyberVideoView.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER);
            }
            c.a.p0.c3.v.c cVar = this.o;
            if (cVar != null) {
                cVar.i();
            }
            PlayerSpeedTracker.beginTrack(c.a.d.f.p.t.c(this.m.getVideoUrl()));
            this.j.m();
            try {
                if (this.f35553e != null && !this.f35553e.isHeld()) {
                    this.f35553e.acquire();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            if (getVideoMonitor() != null) {
                getVideoMonitor().h(ErrorCode.ARGS_ERROR);
                getVideoMonitor().c(this.s, this.t);
            }
        }
    }

    @Override // c.a.p0.c3.g
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            if (!this.f35556h) {
                stopPlayback();
                return;
            }
            if (this.f35550b != null && isPlaying()) {
                t0.f(this.f35554f, false);
            }
            this.f35551c = false;
            if (isPlaying() && J()) {
                t.d().update(this.f35550b, getCurrentPositionSync());
            }
            try {
                if (this.f35553e != null && this.f35553e.isHeld()) {
                    this.f35553e.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            this.m.pause();
            L();
            c.a.p0.c3.v.c cVar = this.o;
            if (cVar != null) {
                cVar.j();
            }
            this.j.n();
            c.a.p0.l2.h hVar = this.p;
            if (hVar == null || !hVar.d(this.q, this.r)) {
                return;
            }
            this.p = null;
        }
    }

    @Override // c.a.p0.c3.g
    public void stopPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            if (this.f35550b != null && isPlaying()) {
                t0.f(this.f35554f, false);
            }
            this.f35551c = false;
            if (isPlaying() && J()) {
                t.d().update(this.f35550b, getCurrentPositionSync());
            }
            try {
                if (this.f35553e != null && this.f35553e.isHeld()) {
                    this.f35553e.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            this.m.stop();
            TbVideoViewSet.b().d(this.f35550b);
            c.a.p0.c3.v.c cVar = this.o;
            if (cVar != null) {
                cVar.j();
            }
            this.j.n();
            c.a.p0.l2.h hVar = this.p;
            if (hVar == null || !hVar.d(this.q, this.r)) {
                return;
            }
            this.p = null;
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
        this.f35554f = null;
        this.f35555g = false;
        this.f35556h = false;
        this.k = false;
        this.v = true;
        this.y = new a(this, 2001011);
        this.z = new b(this);
        this.A = TbCyberVideoView.VideoStatus.INIT;
        this.B = false;
        H();
    }

    @Override // c.a.p0.c3.g
    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, str) == null) || m.isEmpty(str)) {
            return;
        }
        K();
        if (UbsABTestHelper.isVideoSetUrlAgainABTest() || !m.isEquals(this.f35550b, str) || this.m.getStatus() == PlayerStatus.STOP) {
            this.f35550b = str;
            String D2 = D(str);
            k kVar = D;
            if (kVar != null) {
                c.a.p0.l2.h a2 = kVar.a(this.n, this.f35550b, null);
                this.p = a2;
                if (a2 != null) {
                    a2.b(CyberPlayerManager.hasCacheFile(D2));
                }
            }
            this.j.l(this);
            c.a.p0.c3.v.c cVar = this.o;
            if (cVar != null) {
                cVar.h();
            }
            I(Uri.parse(D2));
            c.a.p0.l2.h hVar = this.p;
            if (hVar != null) {
                hVar.j();
            }
            String c2 = c.a.d.f.p.t.c(D2);
            s sVar = this.u;
            if (sVar != null) {
                sVar.a = "";
                sVar.f13496b = D2;
                sVar.f13497c = c2;
                this.m.i(sVar);
            } else {
                c.a.p0.c3.v.c cVar2 = this.o;
                if (cVar2 != null && cVar2.c() != null) {
                    s sVar2 = new s();
                    sVar2.a = "";
                    sVar2.f13496b = D2;
                    sVar2.f13497c = c2;
                    String b2 = sVar2.b(this.o.c().a);
                    sVar2.f13499e = b2;
                    sVar2.f13498d = sVar2.a(b2);
                    sVar2.f13500f = sVar2.c(this.o.b());
                    this.m.i(sVar2);
                }
            }
            this.m.setVideoUniqueKey(c2);
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                boolean f2 = this.m.f(D2);
                this.v = f2;
                if (f2) {
                    C();
                    c.a.p0.c3.v.c cVar3 = this.o;
                    if (cVar3 != null) {
                        cVar3.g(getDuration());
                    }
                }
                this.m.setVideoUrl(D2, !this.v);
                return;
            }
            this.m.setVideoUrl(D2);
        }
    }
}
