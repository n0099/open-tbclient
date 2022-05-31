package com.baidu.tieba.play.cyberPlayer;

import android.content.Context;
import android.net.Uri;
import android.os.PowerManager;
import android.util.AttributeSet;
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
import com.baidu.cyberplayer.sdk.CyberVideoView;
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
import com.repackage.e48;
import com.repackage.f48;
import com.repackage.g48;
import com.repackage.ij7;
import com.repackage.ki;
import com.repackage.lj7;
import com.repackage.r48;
import com.repackage.s48;
import com.repackage.t48;
import com.repackage.u48;
import com.repackage.v48;
import com.repackage.w48;
import com.repackage.x48;
import com.repackage.xc5;
import com.repackage.y48;
import com.repackage.zo8;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TbCyberVideoView extends CyberVideoView implements f48 {
    public static /* synthetic */ Interceptable $ic;
    public static lj7 x0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean J;
    public String K;
    public String L;
    public boolean M;
    public boolean N;
    public w48 O;
    public ij7 P;
    public String Q;
    public String R;
    public PowerManager.WakeLock S;
    public WeakReference<Context> T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean g0;
    public int h0;
    public g48 i0;
    public boolean j0;
    public v48 k0;
    public y48 l0;
    public TbVideoViewContainer.a m0;
    public boolean n0;
    public CyberPlayerManager.OnPreparedListener o0;
    public CyberPlayerManager.OnCompletionListener p0;
    public CyberPlayerManager.OnErrorListener q0;
    public CyberPlayerManager.OnSeekCompleteListener r0;
    public CyberPlayerManager.OnInfoListener s0;
    public final CustomMessageListener t0;
    public OnStatusChangedListener.VideoStatus u0;
    public boolean v0;
    public OnStatusChangedListener w0;

    /* loaded from: classes3.dex */
    public class a implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCyberVideoView a;

        public a(TbCyberVideoView tbCyberVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCyberVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCyberVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            int c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.O != null) {
                    this.a.O.g(this.a.getDuration());
                }
                this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_PREPARED);
                if (this.a.getVideoMonitor() != null) {
                    this.a.getVideoMonitor().l(ErrorCode.ARGS_ERROR);
                }
                if (!this.a.j0) {
                    if (!ViewCompat.isAttachedToWindow(this.a.getView())) {
                        return;
                    }
                    if (!this.a.N && (this.a.getParent() instanceof TbVideoViewContainer)) {
                        TbVideoViewSet.b().e((TbVideoViewContainer) this.a.getParent(), this.a.L);
                    }
                }
                if (this.a.l0 != null) {
                    this.a.l0.onPrepared();
                }
                if (this.a.J && (c = s48.d().c(this.a.L)) > 0) {
                    this.a.seekTo(c);
                }
                if (this.a.M) {
                    boolean z = this.a.N;
                    this.a.start();
                    this.a.N = z;
                    if (this.a.N) {
                        this.a.setVolume(0.0f, 0.0f);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCyberVideoView a;

        public b(TbCyberVideoView tbCyberVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCyberVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCyberVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.P != null) {
                    this.a.P.e(this.a.Q, this.a.R);
                    this.a.P = null;
                }
                this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_COMPLETE);
                s48.d().e(this.a.L);
                if (this.a.getCyberPlayer().isLooping()) {
                    return;
                }
                if (this.a.O != null) {
                    this.a.O.j();
                }
                this.a.M = false;
                if (this.a.l0 != null) {
                    this.a.l0.onCompletion();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCyberVideoView a;

        public c(TbCyberVideoView tbCyberVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCyberVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCyberVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, obj)) == null) {
                if (this.a.getCurrentPosition() > 0 && this.a.O()) {
                    s48.d().update(this.a.L, this.a.getCurrentPosition());
                }
                TbVideoViewSet.b().d(this.a.L);
                if (this.a.l0 != null) {
                    this.a.l0.onError(i, i2, obj);
                    return true;
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements CyberPlayerManager.OnSeekCompleteListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCyberVideoView a;

        public d(TbCyberVideoView tbCyberVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCyberVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCyberVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.l0 == null) {
                return;
            }
            this.a.l0.onSeekComplete();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements CyberPlayerManager.OnInfoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCyberVideoView a;

        public e(TbCyberVideoView tbCyberVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCyberVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCyberVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, obj)) == null) {
                if (this.a.l0 != null) {
                    this.a.l0.onInfo(i, i2, obj);
                }
                if (this.a.getVideoMonitor() != null && i == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        this.a.getVideoMonitor().g(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException unused) {
                    }
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
                    if (this.a.u0 != OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER) {
                        this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_PLAYING);
                    } else {
                        this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY);
                    }
                }
                if (i != 904 || this.a.O == null) {
                    return true;
                }
                this.a.O.f(this.a);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCyberVideoView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(TbCyberVideoView tbCyberVideoView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCyberVideoView, Integer.valueOf(i)};
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
            this.a = tbCyberVideoView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.stop();
                if (this.a.P != null) {
                    this.a.P.k(this.a.Q, this.a.R);
                    this.a.P = null;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(759397828, "Lcom/baidu/tieba/play/cyberPlayer/TbCyberVideoView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(759397828, "Lcom/baidu/tieba/play/cyberPlayer/TbCyberVideoView;");
                return;
            }
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, lj7.class);
        if (runTask != null) {
            x0 = (lj7) runTask.getData();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbCyberVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.T = null;
        this.U = false;
        this.V = false;
        this.j0 = false;
        this.o0 = new a(this);
        this.p0 = new b(this);
        this.q0 = new c(this);
        this.r0 = new d(this);
        this.s0 = new e(this);
        this.t0 = new f(this, 2001011);
        this.u0 = OnStatusChangedListener.VideoStatus.INIT;
        this.v0 = false;
        M(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ij7 getVideoMonitor() {
        InterceptResult invokeV;
        lj7 lj7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            ij7 ij7Var = this.P;
            if (ij7Var != null) {
                return ij7Var;
            }
            if (!StringUtils.isNull(this.L) && (lj7Var = x0) != null) {
                this.P = lj7Var.a(this.K, this.L, null);
            }
            return this.P;
        }
        return (ij7) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoStatus(OnStatusChangedListener.VideoStatus videoStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, videoStatus) == null) {
            OnStatusChangedListener onStatusChangedListener = this.w0;
            if (onStatusChangedListener != null) {
                if (this.n0) {
                    onStatusChangedListener.onStatusChange(videoStatus);
                } else {
                    onStatusChangedListener.onStatusChange(R(videoStatus));
                }
            }
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                this.v0 = true;
                if (this.N) {
                    q();
                    this.N = false;
                } else if (!this.U) {
                    setVolume(1.0f, 1.0f);
                }
            }
            this.u0 = videoStatus;
        }
    }

    public final String I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!ki.isEmpty(str) && zo8.c().d()) {
                if (str.contains("http://tb-video.bdstatic.com")) {
                    return str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
                }
                return str.contains(UrlSchemaHelper.SCHEMA_TYPE_HTTP) ? str.replace(UrlSchemaHelper.SCHEMA_TYPE_HTTP, UrlSchemaHelper.SCHEMA_TYPE_HTTPS) : str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getParent() == TbVideoViewSet.b().c(this.L) : invokeV.booleanValue;
    }

    public final boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (getParent() == null || getParent().getParent() == null) ? false : true : invokeV.booleanValue;
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.m0 = null;
            this.w0 = null;
            this.l0 = null;
            this.i0.j(null);
            this.i0.i(null);
            this.i0.k(null);
        }
    }

    public final void M(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            try {
                PowerManager powerManager = (PowerManager) TbadkCoreApplication.getInst().getContext().getSystemService("power");
                if (powerManager != null) {
                    PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(536870922, "TbBVideoView_WakeLock");
                    this.S = newWakeLock;
                    newWakeLock.setReferenceCounted(false);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            this.T = new WeakReference<>(TbadkCoreApplication.getInst());
            super.setOnPreparedListener(this.o0);
            super.setOnCompletionListener(this.p0);
            super.setOnErrorListener(this.q0);
            super.setOnSeekCompleteListener(this.r0);
            super.setOnInfoListener(this.s0);
            this.O = new w48();
            this.i0 = new g48();
            SkinManager.setBackgroundResource(this, R.color.black_alpha100);
        }
    }

    public final void N(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, uri) == null) {
            super.stopPlayback();
            setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
            u48 pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
            if (pcdnConfigData != null && pcdnConfigData.c()) {
                if (!pcdnConfigData.a(uri)) {
                    this.h0 = 2;
                    return;
                } else if (x48.e() != 0 && x48.e() != -1) {
                    setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                    setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.b() ? "1" : "0");
                    setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(x48.e()));
                    this.W = true;
                    this.g0 = pcdnConfigData.b();
                    this.h0 = 1;
                    return;
                } else {
                    this.h0 = 3;
                    return;
                }
            }
            this.h0 = 0;
        }
    }

    public final boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getCyberPlayer() != null && getCyberPlayer().getDuration() >= getCyberPlayer().getCurrentPosition() : invokeV.booleanValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20513");
            hashMap.put("click_time", "" + System.currentTimeMillis());
            setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            OnStatusChangedListener.VideoStatus videoStatus = this.u0;
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY);
            } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_ERROR);
            } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER);
            }
        }
    }

    public final OnStatusChangedListener.VideoStatus R(OnStatusChangedListener.VideoStatus videoStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, videoStatus)) == null) {
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

    @Override // com.repackage.f48
    public void a(long j, long j2, long j3) {
        ij7 ij7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) || (ij7Var = this.P) == null) {
            return;
        }
        ij7Var.a(j, j2, j3);
    }

    @Override // com.repackage.f48
    public void b(TbVideoViewSet.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            if (!isPlaying() && !this.M) {
                this.M = true;
                if (bVar != null) {
                    this.V = true;
                    if (!K()) {
                        bVar.b();
                    }
                } else {
                    this.V = false;
                }
                setVideoPath(this.L, this.K);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.f48
    public void changeRenderViewMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            getRenderView().setDisplayMode(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.repackage.f48
    public int getCurrentPositionSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (getCyberPlayer() == null) {
                return 0;
            }
            return getCyberPlayer().getCurrentPositionSync();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.f48
    public g48 getMediaProgressObserver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.i0 : (g48) invokeV.objValue;
    }

    @Override // com.repackage.f48
    public String getOriginUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.L : (String) invokeV.objValue;
    }

    @Override // com.repackage.f48
    public int getPcdnState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.h0 : invokeV.intValue;
    }

    @Override // com.repackage.f48
    public e48 getPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.k0 == null) {
                this.k0 = new v48(getCyberPlayer());
            }
            return this.k0;
        }
        return (e48) invokeV.objValue;
    }

    @Override // com.repackage.f48
    public int getPlayerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (getCyberPlayer() == null) {
                return 0;
            }
            return getCyberPlayer().getVideoHeight();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.f48
    public int getPlayerWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (getCyberPlayer() == null) {
                return 0;
            }
            return getCyberPlayer().getVideoWidth();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.f48
    public OnStatusChangedListener.VideoStatus getVideoStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? R(this.u0) : (OnStatusChangedListener.VideoStatus) invokeV.objValue;
    }

    @Override // com.repackage.f48
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            L();
        }
    }

    @Override // com.repackage.f48
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            start();
            this.N = true;
        }
    }

    @Override // com.repackage.f48
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.v0 : invokeV.booleanValue;
    }

    @Override // com.repackage.f48
    @Deprecated
    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || getVideoMonitor() == null) {
            return;
        }
        getVideoMonitor().b(CyberPlayerManager.hasCacheFile(this.L));
        getVideoMonitor().j();
        getVideoMonitor().l(ErrorCode.ARGS_ERROR);
    }

    @Override // com.repackage.f48
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.M : invokeV.booleanValue;
    }

    @Override // com.repackage.f48
    @Deprecated
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            w48 w48Var = this.O;
            if (w48Var != null) {
                w48Var.h();
                this.O.g(getDuration());
                this.O.f(this);
            }
            if (getVideoMonitor() != null) {
                getVideoMonitor().b(CyberPlayerManager.hasCacheFile(this.L));
                getVideoMonitor().i(ErrorCode.ARGS_ERROR);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.t0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onDetachedFromWindow();
            TbVideoViewContainer.a aVar = this.m0;
            if (aVar != null) {
                aVar.onSurfaceDestroyed();
            }
            try {
                if (this.S != null && this.S.isHeld()) {
                    this.S.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            L();
            MessageManager.getInstance().unRegisterListener(this.t0);
        }
    }

    @Override // com.repackage.f48
    public void p(TbVideoViewSet.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bVar) == null) {
            if (bVar != null) {
                this.V = true;
                if (!K()) {
                    bVar.b();
                }
                if (!J()) {
                    bVar.a();
                    this.M = true;
                    this.N = false;
                    setVideoPath(this.L, this.K);
                    if (UbsABTestHelper.isVideoSetUrlAgainABTest()) {
                        return;
                    }
                }
            } else {
                this.V = false;
            }
            start();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            xc5.f(this.T, false);
            if (isPlaying() && O()) {
                s48.d().update(this.L, getCurrentPositionSync());
            }
            this.M = false;
            super.pause();
            Q();
            w48 w48Var = this.O;
            if (w48Var != null) {
                w48Var.e();
            }
            try {
                if (this.S != null && this.S.isHeld()) {
                    this.S.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            ij7 ij7Var = this.P;
            if (ij7Var != null) {
                ij7Var.f();
            }
        }
    }

    @Override // com.repackage.f48
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            if (isPlaying() && O()) {
                s48.d().update(this.L, getCurrentPositionSync());
            }
            this.M = false;
            super.pause();
            Q();
            w48 w48Var = this.O;
            if (w48Var != null) {
                w48Var.e();
            }
            try {
                if (this.S != null && this.S.isHeld()) {
                    this.S.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            ij7 ij7Var = this.P;
            if (ij7Var != null) {
                ij7Var.f();
            }
        }
    }

    @Override // com.repackage.f48
    public void setCanShowPause(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.v0 = z;
        }
    }

    @Override // com.repackage.f48
    public void setContinuePlayEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.J = z;
        }
    }

    @Override // com.repackage.f48
    public void setIsVolume0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.U = z;
        }
    }

    @Override // com.repackage.f48
    public void setLocateSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.Q = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            getCyberPlayer().setLooping(z);
        }
    }

    @Override // com.repackage.f48
    public void setNoBussinessStats() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.O = null;
        }
    }

    @Override // com.repackage.f48
    public void setOnSurfaceDestroyedListener(TbVideoViewContainer.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, aVar) == null) {
            this.m0 = aVar;
        }
    }

    @Override // com.repackage.f48
    public void setOperableVideoContainer(y48 y48Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, y48Var) == null) {
            this.l0 = y48Var;
        }
    }

    @Override // com.repackage.f48
    public void setPlayMode(String str) {
        w48 w48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, str) == null) || (w48Var = this.O) == null) {
            return;
        }
        w48Var.l(str);
    }

    @Override // com.repackage.f48
    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            if (ki.isEmpty(str)) {
                str = "-1";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20484");
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, str);
            setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.R = str;
        }
    }

    @Override // com.repackage.f48
    public void setThreadDataForStatistic(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, threadData) == null) {
            if (this.O == null) {
                this.O = new w48();
            }
            this.O.m(threadData);
        }
    }

    @Override // com.repackage.f48
    public void setTryUseViewInSet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.V = z;
        }
    }

    @Override // com.repackage.f48
    public void setVideoModel(r48 r48Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, r48Var) == null) {
        }
    }

    @Override // com.repackage.f48
    public void setVideoPath(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048627, this, str, str2) == null) || ki.isEmpty(str)) {
            return;
        }
        this.K = str2;
        setVideoPath(str);
    }

    @Override // com.repackage.f48
    public void setVideoStatData(t48 t48Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, t48Var) == null) {
            if (this.O == null) {
                this.O = new w48();
            }
            this.O.o(t48Var);
            if (t48Var != null) {
                this.Q = t48Var.a;
            }
        }
    }

    @Override // com.repackage.f48
    public void setVideoStatusChangeListener(OnStatusChangedListener onStatusChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, onStatusChangedListener) == null) {
            this.w0 = onStatusChangedListener;
        }
    }

    @Override // com.repackage.f48
    public void setVolume(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || getCyberPlayer() == null) {
            return;
        }
        this.U = f2 == 0.0f && f3 == 0.0f;
        getCyberPlayer().setVolume(f2, f3);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            if (!this.U) {
                xc5.f(this.T, true);
                setVolume(1.0f, 1.0f);
            }
            this.M = true;
            this.N = false;
            super.start();
            if (this.u0 == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_PLAYING);
            }
            if (this.u0 == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_ERROR) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR);
            }
            if (this.u0 == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER);
            }
            w48 w48Var = this.O;
            if (w48Var != null) {
                w48Var.i();
            }
            this.i0.m();
            try {
                if (this.S != null && !this.S.isHeld()) {
                    this.S.acquire();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            if (getVideoMonitor() != null) {
                getVideoMonitor().h(ErrorCode.ARGS_ERROR);
                getVideoMonitor().c(this.W, this.g0);
            }
        }
    }

    @Override // com.repackage.f48
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            if (!this.V) {
                stopPlayback();
                return;
            }
            if (this.L != null && isPlaying()) {
                xc5.f(this.T, false);
            }
            this.M = false;
            if (isPlaying() && O()) {
                s48.d().update(this.L, getCurrentPositionSync());
            }
            try {
                if (this.S != null && this.S.isHeld()) {
                    this.S.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            super.pause();
            Q();
            w48 w48Var = this.O;
            if (w48Var != null) {
                w48Var.j();
            }
            this.i0.n();
            ij7 ij7Var = this.P;
            if (ij7Var == null || !ij7Var.d(this.Q, this.R)) {
                return;
            }
            this.P = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            if (this.L != null && isPlaying()) {
                xc5.f(this.T, false);
            }
            this.M = false;
            if (isPlaying() && O()) {
                s48.d().update(this.L, getCurrentPositionSync());
            }
            try {
                if (this.S != null && this.S.isHeld()) {
                    this.S.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            super.stopPlayback();
            TbVideoViewSet.b().d(this.L);
            w48 w48Var = this.O;
            if (w48Var != null) {
                w48Var.j();
            }
            this.i0.n();
            ij7 ij7Var = this.P;
            if (ij7Var == null || !ij7Var.d(this.Q, this.R)) {
                return;
            }
            this.P = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, str) == null) || ki.isEmpty(str)) {
            return;
        }
        P();
        if (UbsABTestHelper.isVideoSetUrlAgainABTest() || !ki.isEquals(this.L, str)) {
            this.L = str;
            String I = I(str);
            lj7 lj7Var = x0;
            if (lj7Var != null) {
                ij7 a2 = lj7Var.a(this.K, this.L, null);
                this.P = a2;
                if (a2 != null) {
                    a2.b(CyberPlayerManager.hasCacheFile(I));
                }
            }
            this.i0.l(this);
            w48 w48Var = this.O;
            if (w48Var != null) {
                w48Var.h();
            }
            N(Uri.parse(I));
            ij7 ij7Var = this.P;
            if (ij7Var != null) {
                ij7Var.j();
            }
            super.setVideoPath(I);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbCyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.T = null;
        this.U = false;
        this.V = false;
        this.j0 = false;
        this.o0 = new a(this);
        this.p0 = new b(this);
        this.q0 = new c(this);
        this.r0 = new d(this);
        this.s0 = new e(this);
        this.t0 = new f(this, 2001011);
        this.u0 = OnStatusChangedListener.VideoStatus.INIT;
        this.v0 = false;
        M(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbCyberVideoView(Context context) {
        super(context, 1);
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
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.T = null;
        this.U = false;
        this.V = false;
        this.j0 = false;
        this.o0 = new a(this);
        this.p0 = new b(this);
        this.q0 = new c(this);
        this.r0 = new d(this);
        this.s0 = new e(this);
        this.t0 = new f(this, 2001011);
        this.u0 = OnStatusChangedListener.VideoStatus.INIT;
        this.v0 = false;
        M(context);
    }
}
