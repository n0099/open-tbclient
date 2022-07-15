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
import com.baidu.tieba.play.OnStatusChangedListener;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d68;
import com.repackage.dq8;
import com.repackage.e68;
import com.repackage.f68;
import com.repackage.ll7;
import com.repackage.m68;
import com.repackage.oi;
import com.repackage.ol7;
import com.repackage.pe5;
import com.repackage.q68;
import com.repackage.r68;
import com.repackage.s68;
import com.repackage.t68;
import com.repackage.v68;
import com.repackage.vi;
import com.repackage.w68;
import com.repackage.x68;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class TbVideoView extends FrameLayout implements e68 {
    public static /* synthetic */ Interceptable $ic;
    public static ol7 E;
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
    public f68 j;
    public boolean k;
    public boolean l;
    public m68 m;
    public String n;
    public v68 o;
    public ll7 p;
    public String q;
    public String r;
    public boolean s;
    public boolean t;
    public q68 u;
    public boolean v;
    public x68 w;
    public TbVideoViewContainer.a x;
    public boolean y;
    public final CustomMessageListener z;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
                r68.d().e(this.a.b);
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
                if (this.a.getCurrentPosition() > 0 && this.a.J()) {
                    r68.d().update(this.a.b, this.a.getCurrentPosition());
                }
                TbVideoViewSet.b().d(this.a.b);
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
                this.a.C();
                if (this.a.w != null) {
                    this.a.w.onPrepared();
                }
                if (this.a.a && (c = r68.d().c(this.a.b)) > 0) {
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

    /* loaded from: classes3.dex */
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, ol7.class);
        if (runTask != null) {
            E = (ol7) runTask.getData();
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
    public ll7 getVideoMonitor() {
        InterceptResult invokeV;
        ol7 ol7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            ll7 ll7Var = this.p;
            if (ll7Var != null) {
                return ll7Var;
            }
            if (!StringUtils.isNull(this.b) && (ol7Var = E) != null) {
                this.p = ol7Var.a(this.n, this.b, null);
            }
            return this.p;
        }
        return (ll7) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoStatus(OnStatusChangedListener.VideoStatus videoStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, videoStatus) == null) {
            OnStatusChangedListener onStatusChangedListener = this.D;
            if (onStatusChangedListener != null) {
                if (this.y) {
                    onStatusChangedListener.onStatusChange(videoStatus);
                } else {
                    onStatusChangedListener.onStatusChange(O(videoStatus));
                }
            }
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                this.C = true;
                if (this.d) {
                    q();
                    this.d = false;
                } else if (!this.g) {
                    setVolume(1.0f, 1.0f);
                }
            }
            this.B = videoStatus;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.k && ViewCompat.isAttachedToWindow(this) && !this.d && (getParent() instanceof TbVideoViewContainer)) {
            TbVideoViewSet.b().e((TbVideoViewContainer) getParent(), this.b);
        }
    }

    public final String D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (!oi.isEmpty(str) && dq8.c().d()) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getParent() == TbVideoViewSet.b().c(this.b) : invokeV.booleanValue;
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
            this.D = null;
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
                    this.e = newWakeLock;
                    newWakeLock.setReferenceCounted(false);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            this.f = new WeakReference<>(TbadkCoreApplication.getInst());
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && (TbSingleton.getInstance().getIsNeedReuseVideoPlayer() || TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer())) {
                this.m = new m68((Context) null, "video_reuse_player");
                TbSingleton.getInstance().setIsNeedReuseVideoPlayer(false);
                TbSingleton.getInstance().setIsOutNeedReuseVideoPlayer(false);
            } else {
                this.m = new m68(TbadkCoreApplication.getInst(), new BaseKernelLayer(AbsVideoKernel.CYBER_PLAYER));
            }
            this.m.h();
            this.m.attachToContainer(this);
            this.m.setPlayerListener(this.A);
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                this.m.setLooping(true);
            }
            this.o = new v68();
            this.j = new f68();
            SkinManager.setBackgroundResource(this, R.color.black_alpha100);
        }
    }

    public final void I(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, uri) == null) {
            this.m.setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
            t68 pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
            if (pcdnConfigData != null && pcdnConfigData.c()) {
                if (!pcdnConfigData.a(uri)) {
                    this.i = 2;
                    return;
                } else if (w68.e() != 0 && w68.e() != -1) {
                    this.m.setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                    this.m.setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.b() ? "1" : "0");
                    this.m.setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(w68.e()));
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
            m68 m68Var = this.m;
            return m68Var != null && m68Var.getDurationMs() >= this.m.getPositionMs();
        }
        return invokeV.booleanValue;
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.y = z;
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20513");
            hashMap.put("click_time", "" + System.currentTimeMillis());
            this.m.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
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

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            m68 m68Var = this.m;
            if (m68Var != null) {
                return m68Var.k(new c(this), 1.0f);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final OnStatusChangedListener.VideoStatus O(OnStatusChangedListener.VideoStatus videoStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, videoStatus)) == null) {
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

    @Override // com.repackage.e68
    public void a(long j, long j2, long j3) {
        ll7 ll7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) || (ll7Var = this.p) == null) {
            return;
        }
        ll7Var.a(j, j2, j3);
    }

    @Override // com.repackage.e68
    public void b(TbVideoViewSet.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            if (!isPlaying() && !this.c) {
                this.c = true;
                if (bVar != null) {
                    this.h = true;
                    if (!F()) {
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
            p(bVar);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.e68
    public void changeRenderViewMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.m.setVideoScalingMode(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.m.getPositionMs() : invokeV.intValue;
    }

    @Override // com.repackage.e68
    public int getCurrentPositionSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            m68 m68Var = this.m;
            if (m68Var == null) {
                return 0;
            }
            return m68Var.getPositionMs();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.m.getDurationMs() : invokeV.intValue;
    }

    @Override // com.repackage.e68
    public f68 getMediaProgressObserver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.j : (f68) invokeV.objValue;
    }

    @Override // com.repackage.e68
    public String getOriginUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    @Override // com.repackage.e68
    public int getPcdnState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.i : invokeV.intValue;
    }

    @Override // com.repackage.e68
    public d68 getPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.m : (d68) invokeV.objValue;
    }

    @Override // com.repackage.e68
    public int getPlayerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            m68 m68Var = this.m;
            if (m68Var == null) {
                return 0;
            }
            return m68Var.getVideoHeight();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.e68
    public int getPlayerWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            m68 m68Var = this.m;
            if (m68Var == null) {
                return 0;
            }
            return m68Var.getVideoWidth();
        }
        return invokeV.intValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.m.getVideoHeight() : invokeV.intValue;
    }

    @Override // com.repackage.e68
    public OnStatusChangedListener.VideoStatus getVideoStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? O(this.B) : (OnStatusChangedListener.VideoStatus) invokeV.objValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.m.getVideoWidth() : invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.m.isPlaying() : invokeV.booleanValue;
    }

    @Override // com.repackage.e68
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            G();
        }
    }

    @Override // com.repackage.e68
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            setIsVolume0(true);
            start();
            this.d = true;
            setIsVolume0(false);
        }
    }

    @Override // com.repackage.e68
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.C : invokeV.booleanValue;
    }

    @Override // com.repackage.e68
    @Deprecated
    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || getVideoMonitor() == null) {
            return;
        }
        getVideoMonitor().b(CyberPlayerManager.hasCacheFile(this.b));
        getVideoMonitor().j();
        getVideoMonitor().l(ErrorCode.ARGS_ERROR);
    }

    @Override // com.repackage.e68
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.c : invokeV.booleanValue;
    }

    @Override // com.repackage.e68
    @Deprecated
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            v68 v68Var = this.o;
            if (v68Var != null) {
                v68Var.h();
                this.o.g(getDuration());
                this.o.f(this);
            }
            if (getVideoMonitor() != null) {
                getVideoMonitor().b(CyberPlayerManager.hasCacheFile(this.b));
                getVideoMonitor().i(ErrorCode.ARGS_ERROR);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.z);
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
            G();
            MessageManager.getInstance().unRegisterListener(this.z);
        }
    }

    @Override // com.repackage.e68
    public void p(TbVideoViewSet.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bVar) == null) {
            if (bVar != null) {
                this.h = true;
                if (!F()) {
                    bVar.b();
                }
                if (!E()) {
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

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            pe5.e(this.f, false);
            if (isPlaying() && J()) {
                r68.d().update(this.b, getCurrentPositionSync());
            }
            this.c = false;
            this.m.pause();
            M();
            v68 v68Var = this.o;
            if (v68Var != null) {
                v68Var.e();
            }
            try {
                if (this.e != null && this.e.isHeld()) {
                    this.e.release();
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            ll7 ll7Var = this.p;
            if (ll7Var != null) {
                ll7Var.f();
            }
        }
    }

    @Override // com.repackage.e68
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            if (isPlaying() && J()) {
                r68.d().update(this.b, getCurrentPositionSync());
            }
            this.c = false;
            this.m.pause();
            M();
            if (TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer()) {
                v68 v68Var = this.o;
                if (v68Var != null) {
                    v68Var.j();
                }
            } else {
                v68 v68Var2 = this.o;
                if (v68Var2 != null) {
                    v68Var2.e();
                }
            }
            try {
                if (this.e != null && this.e.isHeld()) {
                    this.e.release();
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            ll7 ll7Var = this.p;
            if (ll7Var != null) {
                ll7Var.f();
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.m.seekToMs(i);
        }
    }

    @Override // com.repackage.e68
    public void setCanShowPause(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.C = z;
        }
    }

    @Override // com.repackage.e68
    public void setContinuePlayEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.a = z;
        }
    }

    @Override // com.repackage.e68
    public void setIsVolume0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.g = z;
        }
    }

    @Override // com.repackage.e68
    public void setLocateSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.q = str;
        }
    }

    @Override // com.repackage.e68
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.l = z;
            this.m.setLooping(z);
        }
    }

    @Override // com.repackage.e68
    public void setNoBussinessStats() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.o = null;
        }
    }

    @Override // com.repackage.e68
    public void setOnSurfaceDestroyedListener(TbVideoViewContainer.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, aVar) == null) {
            this.x = aVar;
        }
    }

    @Override // com.repackage.e68
    public void setOperableVideoContainer(x68 x68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, x68Var) == null) {
            this.w = x68Var;
        }
    }

    @Override // com.repackage.e68
    public void setPlayMode(String str) {
        v68 v68Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, str) == null) || (v68Var = this.o) == null) {
            return;
        }
        v68Var.l(str);
    }

    @Override // com.repackage.e68
    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
            if (oi.isEmpty(str)) {
                str = "-1";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20484");
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, str);
            this.m.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.r = str;
        }
    }

    @Override // com.repackage.e68
    public void setThreadDataForStatistic(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, threadData) == null) {
            if (this.o == null) {
                this.o = new v68();
            }
            this.o.m(threadData);
        }
    }

    @Override // com.repackage.e68
    public void setTryUseViewInSet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            this.h = z;
        }
    }

    @Override // com.repackage.e68
    public void setVideoModel(q68 q68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, q68Var) == null) {
            this.u = q68Var;
        }
    }

    @Override // com.repackage.e68
    public void setVideoPath(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048636, this, str, str2) == null) || oi.isEmpty(str)) {
            return;
        }
        this.n = str2;
        setVideoPath(str);
    }

    @Override // com.repackage.e68
    public void setVideoScalingMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i) == null) {
            this.m.setVideoScalingMode(i);
        }
    }

    @Override // com.repackage.e68
    public void setVideoStatData(s68 s68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, s68Var) == null) {
            if (this.o == null) {
                this.o = new v68();
            }
            this.o.o(s68Var);
            if (s68Var != null) {
                this.q = s68Var.a;
            }
        }
    }

    @Override // com.repackage.e68
    public void setVideoStatusChangeListener(OnStatusChangedListener onStatusChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, onStatusChangedListener) == null) {
            this.D = onStatusChangedListener;
        }
    }

    @Override // com.repackage.e68
    public void setVolume(float f, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048640, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) || this.m == null) {
            return;
        }
        this.g = f == 0.0f && f2 == 0.0f;
        this.m.j(f, f2);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            PlayerSpeedTracker.beginTrack(vi.c(this.m.getVideoUrl()));
            if (!this.g) {
                pe5.e(this.f, true);
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
            v68 v68Var = this.o;
            if (v68Var != null) {
                v68Var.i();
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

    @Override // com.repackage.e68
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            if (!this.h) {
                stopPlayback();
                return;
            }
            if (this.b != null && isPlaying()) {
                pe5.e(this.f, false);
            }
            this.c = false;
            if (isPlaying() && J()) {
                r68.d().update(this.b, getCurrentPositionSync());
            }
            try {
                if (this.e != null && this.e.isHeld()) {
                    this.e.release();
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            this.m.pause();
            M();
            v68 v68Var = this.o;
            if (v68Var != null) {
                v68Var.j();
            }
            this.j.n();
            ll7 ll7Var = this.p;
            if (ll7Var == null || !ll7Var.d(this.q, this.r)) {
                return;
            }
            this.p = null;
        }
    }

    @Override // com.repackage.e68
    public void stopPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            if (this.b != null && isPlaying()) {
                pe5.e(this.f, false);
            }
            this.c = false;
            if (isPlaying() && J()) {
                r68.d().update(this.b, getCurrentPositionSync());
            }
            try {
                if (this.e != null && this.e.isHeld()) {
                    this.e.release();
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            this.m.stop();
            TbVideoViewSet.b().d(this.b);
            v68 v68Var = this.o;
            if (v68Var != null) {
                v68Var.j();
            }
            this.j.n();
            ll7 ll7Var = this.p;
            if (ll7Var == null || !ll7Var.d(this.q, this.r)) {
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
        this.f = null;
        this.g = false;
        this.h = false;
        this.k = false;
        this.v = true;
        this.z = new a(this, 2001011);
        this.A = new b(this);
        this.B = OnStatusChangedListener.VideoStatus.INIT;
        this.C = false;
        H();
    }

    @Override // com.repackage.e68
    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048635, this, str) == null) || oi.isEmpty(str)) {
            return;
        }
        L();
        if (UbsABTestHelper.isVideoSetUrlAgainABTest() || !oi.isEquals(this.b, str) || this.m.getStatus() == PlayerStatus.STOP) {
            this.b = str;
            String D = D(str);
            ol7 ol7Var = E;
            if (ol7Var != null) {
                ll7 a2 = ol7Var.a(this.n, this.b, null);
                this.p = a2;
                if (a2 != null) {
                    a2.b(CyberPlayerManager.hasCacheFile(D));
                }
            }
            this.j.l(this);
            v68 v68Var = this.o;
            if (v68Var != null) {
                v68Var.h();
            }
            I(Uri.parse(D));
            ll7 ll7Var = this.p;
            if (ll7Var != null) {
                ll7Var.j();
            }
            String c2 = vi.c(D);
            q68 q68Var = this.u;
            if (q68Var != null) {
                q68Var.a = "";
                q68Var.b = D;
                q68Var.c = c2;
                this.m.i(q68Var);
            } else {
                v68 v68Var2 = this.o;
                if (v68Var2 != null && v68Var2.c() != null) {
                    q68 q68Var2 = new q68();
                    q68Var2.a = "";
                    q68Var2.b = D;
                    q68Var2.c = c2;
                    String b2 = q68Var2.b(this.o.c().a);
                    q68Var2.e = b2;
                    q68Var2.d = q68Var2.a(b2);
                    q68Var2.f = q68Var2.c(this.o.b());
                    this.m.i(q68Var2);
                }
            }
            this.m.setVideoUniqueKey(c2);
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                boolean f = this.m.f(D);
                this.v = f;
                if (f) {
                    C();
                    v68 v68Var3 = this.o;
                    if (v68Var3 != null) {
                        v68Var3.g(getDuration());
                    }
                }
                this.m.setVideoUrl(D, !this.v);
                return;
            }
            this.m.setVideoUrl(D);
        }
    }
}
