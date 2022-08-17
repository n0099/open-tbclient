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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a98;
import com.repackage.b98;
import com.repackage.c98;
import com.repackage.d98;
import com.repackage.fn7;
import com.repackage.in7;
import com.repackage.j88;
import com.repackage.k88;
import com.repackage.l88;
import com.repackage.of5;
import com.repackage.pi;
import com.repackage.us8;
import com.repackage.w88;
import com.repackage.x88;
import com.repackage.y88;
import com.repackage.z88;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class TbCyberVideoView extends CyberVideoView implements k88 {
    public static /* synthetic */ Interceptable $ic;
    public static in7 w0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean J;
    public String K;
    public String L;
    public boolean M;
    public boolean N;
    public b98 O;
    public fn7 P;
    public String Q;
    public String R;
    public PowerManager.WakeLock S;
    public WeakReference<Context> T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean a0;
    public int b0;
    public l88 c0;
    public boolean d0;
    public a98 e0;
    public d98 f0;
    public TbVideoViewContainer.a g0;
    public boolean h0;
    public CyberPlayerManager.OnPreparedListener i0;
    public CyberPlayerManager.OnCompletionListener j0;
    public CyberPlayerManager.OnErrorListener q0;
    public CyberPlayerManager.OnSeekCompleteListener r0;
    public CyberPlayerManager.OnInfoListener s0;
    public final CustomMessageListener t0;
    public OnStatusChangedListener.VideoStatus u0;
    public OnStatusChangedListener v0;

    /* loaded from: classes4.dex */
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
                if (!this.a.d0) {
                    if (!ViewCompat.isAttachedToWindow(this.a.getView())) {
                        return;
                    }
                    if (!this.a.N && (this.a.getParent() instanceof TbVideoViewContainer)) {
                        TbVideoViewSet.c().f((TbVideoViewContainer) this.a.getParent(), this.a.L);
                    }
                }
                if (this.a.f0 != null) {
                    this.a.f0.onPrepared();
                }
                if (this.a.J && (c = x88.d().c(this.a.L)) > 0) {
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

    /* loaded from: classes4.dex */
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
                x88.d().e(this.a.L);
                if (this.a.getCyberPlayer().isLooping()) {
                    return;
                }
                if (this.a.O != null) {
                    this.a.O.j();
                }
                this.a.M = false;
                if (this.a.f0 != null) {
                    this.a.f0.onCompletion();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (this.a.getCurrentPosition() > 0 && this.a.E()) {
                    x88.d().update(this.a.L, this.a.getCurrentPosition());
                }
                TbVideoViewSet.c().e(this.a.L);
                if (this.a.f0 != null) {
                    this.a.f0.onError(i, i2, obj);
                    return true;
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f0 == null) {
                return;
            }
            this.a.f0.onSeekComplete();
        }
    }

    /* loaded from: classes4.dex */
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
                if (this.a.f0 != null) {
                    this.a.f0.onInfo(i, i2, obj);
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

    /* loaded from: classes4.dex */
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
                this.a.I();
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, in7.class);
        if (runTask != null) {
            w0 = (in7) runTask.getData();
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
        this.d0 = false;
        this.i0 = new a(this);
        this.j0 = new b(this);
        this.q0 = new c(this);
        this.r0 = new d(this);
        this.s0 = new e(this);
        this.t0 = new f(this, 2001011);
        this.u0 = OnStatusChangedListener.VideoStatus.INIT;
        C(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public fn7 getVideoMonitor() {
        InterceptResult invokeV;
        in7 in7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            fn7 fn7Var = this.P;
            if (fn7Var != null) {
                return fn7Var;
            }
            if (!StringUtils.isNull(this.L) && (in7Var = w0) != null) {
                this.P = in7Var.a(this.K, this.L, null);
            }
            return this.P;
        }
        return (fn7) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoStatus(OnStatusChangedListener.VideoStatus videoStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, videoStatus) == null) {
            OnStatusChangedListener onStatusChangedListener = this.v0;
            if (onStatusChangedListener != null) {
                if (this.h0) {
                    onStatusChangedListener.onStatusChange(videoStatus);
                } else {
                    onStatusChangedListener.onStatusChange(J(videoStatus));
                }
            }
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                if (this.N) {
                    F();
                    this.N = false;
                } else if (!this.U) {
                    setVolume(1.0f, 1.0f);
                }
            }
            this.u0 = videoStatus;
        }
    }

    public final String A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!pi.isEmpty(str) && us8.c().d()) {
                if (str.contains("http://tb-video.bdstatic.com")) {
                    return str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
                }
                return str.contains(UrlSchemaHelper.SCHEMA_TYPE_HTTP) ? str.replace(UrlSchemaHelper.SCHEMA_TYPE_HTTP, UrlSchemaHelper.SCHEMA_TYPE_HTTPS) : str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.g0 = null;
            this.v0 = null;
            this.f0 = null;
            this.c0.j(null);
            this.c0.i(null);
            this.c0.k(null);
        }
    }

    public final void C(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
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
            super.setOnPreparedListener(this.i0);
            super.setOnCompletionListener(this.j0);
            super.setOnErrorListener(this.q0);
            super.setOnSeekCompleteListener(this.r0);
            super.setOnInfoListener(this.s0);
            this.O = new b98();
            this.c0 = new l88();
            SkinManager.setBackgroundResource(this, R.color.black_alpha100);
        }
    }

    public final void D(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, uri) == null) {
            super.stopPlayback();
            setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
            z88 pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
            if (pcdnConfigData != null && pcdnConfigData.c()) {
                if (!pcdnConfigData.a(uri)) {
                    this.b0 = 2;
                    return;
                } else if (c98.e() != 0 && c98.e() != -1) {
                    setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                    setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.b() ? "1" : "0");
                    setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c98.e()));
                    this.W = true;
                    this.a0 = pcdnConfigData.b();
                    this.b0 = 1;
                    return;
                } else {
                    this.b0 = 3;
                    return;
                }
            }
            this.b0 = 0;
        }
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getCyberPlayer() != null && getCyberPlayer().getDuration() >= getCyberPlayer().getCurrentPosition() : invokeV.booleanValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (isPlaying() && E()) {
                x88.d().update(this.L, getCurrentPositionSync());
            }
            this.M = false;
            super.pause();
            H();
            b98 b98Var = this.O;
            if (b98Var != null) {
                b98Var.e();
            }
            try {
                if (this.S != null && this.S.isHeld()) {
                    this.S.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            fn7 fn7Var = this.P;
            if (fn7Var != null) {
                fn7Var.f();
            }
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20513");
            hashMap.put("click_time", "" + System.currentTimeMillis());
            setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
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

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!this.V) {
                stopPlayback();
                return;
            }
            if (this.L != null && isPlaying()) {
                of5.e(this.T, false);
            }
            this.M = false;
            if (isPlaying() && E()) {
                x88.d().update(this.L, getCurrentPositionSync());
            }
            try {
                if (this.S != null && this.S.isHeld()) {
                    this.S.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            super.pause();
            H();
            b98 b98Var = this.O;
            if (b98Var != null) {
                b98Var.j();
            }
            this.c0.n();
            fn7 fn7Var = this.P;
            if (fn7Var == null || !fn7Var.d(this.Q, this.R)) {
                return;
            }
            this.P = null;
        }
    }

    public final OnStatusChangedListener.VideoStatus J(OnStatusChangedListener.VideoStatus videoStatus) {
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

    @Override // com.repackage.k88
    public void a(long j, long j2, long j3) {
        fn7 fn7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) || (fn7Var = this.P) == null) {
            return;
        }
        fn7Var.a(j, j2, j3);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.repackage.k88
    public int getCurrentPositionSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (getCyberPlayer() == null) {
                return 0;
            }
            return getCyberPlayer().getCurrentPositionSync();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.k88
    public l88 getMediaProgressObserver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.c0 : (l88) invokeV.objValue;
    }

    public String getOriginUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.L : (String) invokeV.objValue;
    }

    @Override // com.repackage.k88
    public int getPcdnState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.b0 : invokeV.intValue;
    }

    public j88 getPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.e0 == null) {
                this.e0 = new a98(getCyberPlayer());
            }
            return this.e0;
        }
        return (j88) invokeV.objValue;
    }

    @Override // com.repackage.k88
    public int getPlayerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (getCyberPlayer() == null) {
                return 0;
            }
            return getCyberPlayer().getVideoHeight();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.k88
    public int getPlayerWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (getCyberPlayer() == null) {
                return 0;
            }
            return getCyberPlayer().getVideoWidth();
        }
        return invokeV.intValue;
    }

    public OnStatusChangedListener.VideoStatus getVideoStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? J(this.u0) : (OnStatusChangedListener.VideoStatus) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.t0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDetachedFromWindow();
            TbVideoViewContainer.a aVar = this.g0;
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
            B();
            MessageManager.getInstance().unRegisterListener(this.t0);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            of5.e(this.T, false);
            if (isPlaying() && E()) {
                x88.d().update(this.L, getCurrentPositionSync());
            }
            this.M = false;
            super.pause();
            H();
            b98 b98Var = this.O;
            if (b98Var != null) {
                b98Var.e();
            }
            try {
                if (this.S != null && this.S.isHeld()) {
                    this.S.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            fn7 fn7Var = this.P;
            if (fn7Var != null) {
                fn7Var.f();
            }
        }
    }

    public void setCanShowPause(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
        }
    }

    public void setContinuePlayEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.J = z;
        }
    }

    public void setIsVolume0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.U = z;
        }
    }

    public void setLocateSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.Q = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            getCyberPlayer().setLooping(z);
        }
    }

    public void setNoBussinessStats() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.O = null;
        }
    }

    @Override // com.repackage.k88
    public void setOnSurfaceDestroyedListener(TbVideoViewContainer.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, aVar) == null) {
            this.g0 = aVar;
        }
    }

    @Override // com.repackage.k88
    public void setOperableVideoContainer(d98 d98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, d98Var) == null) {
            this.f0 = d98Var;
        }
    }

    @Override // com.repackage.k88
    public void setPlayMode(String str) {
        b98 b98Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, str) == null) || (b98Var = this.O) == null) {
            return;
        }
        b98Var.l(str);
    }

    @Override // com.repackage.k88
    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            if (pi.isEmpty(str)) {
                str = "-1";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20484");
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, str);
            setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.R = str;
        }
    }

    public void setThreadDataForStatistic(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, threadData) == null) {
            if (this.O == null) {
                this.O = new b98();
            }
            this.O.m(threadData);
        }
    }

    public void setTryUseViewInSet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.V = z;
        }
    }

    public void setVideoModel(w88 w88Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, w88Var) == null) {
        }
    }

    @Override // com.repackage.k88
    public void setVideoPath(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048617, this, str, str2) == null) || pi.isEmpty(str)) {
            return;
        }
        this.K = str2;
        setVideoPath(str);
    }

    @Override // com.repackage.k88
    public void setVideoStatData(y88 y88Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, y88Var) == null) {
            if (this.O == null) {
                this.O = new b98();
            }
            this.O.o(y88Var);
            if (y88Var != null) {
                this.Q = y88Var.a;
            }
        }
    }

    public void setVideoStatusChangeListener(OnStatusChangedListener onStatusChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, onStatusChangedListener) == null) {
            this.v0 = onStatusChangedListener;
        }
    }

    @Override // com.repackage.k88
    public void setVolume(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || getCyberPlayer() == null) {
            return;
        }
        this.U = f2 == 0.0f && f3 == 0.0f;
        getCyberPlayer().setVolume(f2, f3);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (!this.U) {
                of5.e(this.T, true);
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
            b98 b98Var = this.O;
            if (b98Var != null) {
                b98Var.i();
            }
            this.c0.m();
            try {
                if (this.S != null && !this.S.isHeld()) {
                    this.S.acquire();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            if (getVideoMonitor() != null) {
                getVideoMonitor().h(ErrorCode.ARGS_ERROR);
                getVideoMonitor().c(this.W, this.a0);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (this.L != null && isPlaying()) {
                of5.e(this.T, false);
            }
            this.M = false;
            if (isPlaying() && E()) {
                x88.d().update(this.L, getCurrentPositionSync());
            }
            try {
                if (this.S != null && this.S.isHeld()) {
                    this.S.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            super.stopPlayback();
            TbVideoViewSet.c().e(this.L);
            b98 b98Var = this.O;
            if (b98Var != null) {
                b98Var.j();
            }
            this.c0.n();
            fn7 fn7Var = this.P;
            if (fn7Var == null || !fn7Var.d(this.Q, this.R)) {
                return;
            }
            this.P = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, str) == null) || pi.isEmpty(str)) {
            return;
        }
        G();
        if (UbsABTestHelper.isVideoSetUrlAgainABTest() || !pi.isEquals(this.L, str)) {
            this.L = str;
            String A = A(str);
            in7 in7Var = w0;
            if (in7Var != null) {
                fn7 a2 = in7Var.a(this.K, this.L, null);
                this.P = a2;
                if (a2 != null) {
                    a2.b(CyberPlayerManager.hasCacheFile(A));
                }
            }
            this.c0.l(this);
            b98 b98Var = this.O;
            if (b98Var != null) {
                b98Var.h();
            }
            D(Uri.parse(A));
            fn7 fn7Var = this.P;
            if (fn7Var != null) {
                fn7Var.j();
            }
            super.setVideoPath(A);
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
        this.d0 = false;
        this.i0 = new a(this);
        this.j0 = new b(this);
        this.q0 = new c(this);
        this.r0 = new d(this);
        this.s0 = new e(this);
        this.t0 = new f(this, 2001011);
        this.u0 = OnStatusChangedListener.VideoStatus.INIT;
        C(context);
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
        this.d0 = false;
        this.i0 = new a(this);
        this.j0 = new b(this);
        this.q0 = new c(this);
        this.r0 = new d(this);
        this.s0 = new e(this);
        this.t0 = new f(this, 2001011);
        this.u0 = OnStatusChangedListener.VideoStatus.INIT;
        C(context);
    }
}
