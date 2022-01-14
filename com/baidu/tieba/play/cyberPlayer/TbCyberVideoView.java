package com.baidu.tieba.play.cyberPlayer;

import android.content.Context;
import android.net.Uri;
import android.os.PowerManager;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import c.a.d.f.p.m;
import c.a.s0.e1.t0;
import c.a.s0.s.q.e2;
import c.a.t0.h2.h;
import c.a.t0.h2.k;
import c.a.t0.z2.r;
import c.a.t0.z2.s;
import c.a.t0.z2.t;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberVideoView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class TbCyberVideoView extends CyberVideoView implements c.a.t0.z2.g {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TB_FREE_HOST = "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv";
    public static final String TB_HOST = "http://tb-video.bdstatic.com";
    public static k w0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean J;
    public String K;
    public String L;
    public boolean M;
    public boolean N;
    public c.a.t0.z2.u.c O;
    public h P;
    public String Q;
    public String R;
    public PowerManager.WakeLock S;
    public WeakReference<Context> T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean a0;
    public int b0;
    public c.a.t0.z2.h c0;
    public boolean d0;
    public c.a.t0.z2.u.b e0;
    public c.a.t0.z2.v.a f0;
    public TbVideoViewContainer.a g0;
    public CyberPlayerManager.OnPreparedListener h0;
    public CyberPlayerManager.OnCompletionListener i0;
    public CyberPlayerManager.OnErrorListener k0;
    public CyberPlayerManager.OnSeekCompleteListener q0;
    public CyberPlayerManager.OnInfoListener r0;
    public final CustomMessageListener s0;
    public VideoStatus t0;
    public boolean u0;
    public g v0;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes12.dex */
    public static final class VideoStatus {
        public static final /* synthetic */ VideoStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final VideoStatus INIT;
        public static final VideoStatus INTERNAL_VIDEO_BUFFERING_BUFFER;
        public static final VideoStatus INTERNAL_VIDEO_BUFFERING_ERROR;
        public static final VideoStatus INTERNAL_VIDEO_PAUSING_BUFFER;
        public static final VideoStatus INTERNAL_VIDEO_PAUSING_ERROR;
        public static final VideoStatus INTERNAL_VIDEO_PAUSING_PLAY;
        public static final VideoStatus VIDEO_BUFFERING;
        public static final VideoStatus VIDEO_COMPLETE;
        public static final VideoStatus VIDEO_PAUSING;
        public static final VideoStatus VIDEO_PLAYING;
        public static final VideoStatus VIDEO_PREPARED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(426604507, "Lcom/baidu/tieba/play/cyberPlayer/TbCyberVideoView$VideoStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(426604507, "Lcom/baidu/tieba/play/cyberPlayer/TbCyberVideoView$VideoStatus;");
                    return;
                }
            }
            INIT = new VideoStatus(TornadoLiteRuntime.STATE_INIT, 0);
            VIDEO_PREPARED = new VideoStatus("VIDEO_PREPARED", 1);
            VIDEO_PLAYING = new VideoStatus("VIDEO_PLAYING", 2);
            VIDEO_PAUSING = new VideoStatus("VIDEO_PAUSING", 3);
            INTERNAL_VIDEO_PAUSING_PLAY = new VideoStatus("INTERNAL_VIDEO_PAUSING_PLAY", 4);
            INTERNAL_VIDEO_PAUSING_ERROR = new VideoStatus("INTERNAL_VIDEO_PAUSING_ERROR", 5);
            INTERNAL_VIDEO_PAUSING_BUFFER = new VideoStatus("INTERNAL_VIDEO_PAUSING_BUFFER", 6);
            VIDEO_BUFFERING = new VideoStatus("VIDEO_BUFFERING", 7);
            INTERNAL_VIDEO_BUFFERING_ERROR = new VideoStatus("INTERNAL_VIDEO_BUFFERING_ERROR", 8);
            INTERNAL_VIDEO_BUFFERING_BUFFER = new VideoStatus("INTERNAL_VIDEO_BUFFERING_BUFFER", 9);
            VideoStatus videoStatus = new VideoStatus("VIDEO_COMPLETE", 10);
            VIDEO_COMPLETE = videoStatus;
            $VALUES = new VideoStatus[]{INIT, VIDEO_PREPARED, VIDEO_PLAYING, VIDEO_PAUSING, INTERNAL_VIDEO_PAUSING_PLAY, INTERNAL_VIDEO_PAUSING_ERROR, INTERNAL_VIDEO_PAUSING_BUFFER, VIDEO_BUFFERING, INTERNAL_VIDEO_BUFFERING_ERROR, INTERNAL_VIDEO_BUFFERING_BUFFER, videoStatus};
        }

        public VideoStatus(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static VideoStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (VideoStatus) Enum.valueOf(VideoStatus.class, str) : (VideoStatus) invokeL.objValue;
        }

        public static VideoStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (VideoStatus[]) $VALUES.clone() : (VideoStatus[]) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public class a implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCyberVideoView f47335e;

        public a(TbCyberVideoView tbCyberVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCyberVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47335e = tbCyberVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            int c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f47335e.O != null) {
                    this.f47335e.O.g(this.f47335e.getDuration());
                }
                this.f47335e.setVideoStatus(VideoStatus.VIDEO_PREPARED);
                if (this.f47335e.getVideoMonitor() != null) {
                    this.f47335e.getVideoMonitor().k(ErrorCode.ARGS_ERROR);
                }
                if (!this.f47335e.d0) {
                    if (!ViewCompat.isAttachedToWindow(this.f47335e.getView())) {
                        return;
                    }
                    if (!this.f47335e.N && (this.f47335e.getParent() instanceof TbVideoViewContainer)) {
                        TbVideoViewSet.d().g((TbVideoViewContainer) this.f47335e.getParent(), this.f47335e.L);
                    }
                }
                if (this.f47335e.f0 != null) {
                    this.f47335e.f0.onPrepared();
                }
                if (this.f47335e.J && (c2 = s.d().c(this.f47335e.L)) > 0) {
                    this.f47335e.seekTo(c2);
                }
                if (this.f47335e.M) {
                    boolean z = this.f47335e.N;
                    this.f47335e.start();
                    this.f47335e.N = z;
                    if (this.f47335e.N) {
                        this.f47335e.setVolume(0.0f, 0.0f);
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCyberVideoView f47336e;

        public b(TbCyberVideoView tbCyberVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCyberVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47336e = tbCyberVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f47336e.P != null) {
                    this.f47336e.P.d(this.f47336e.Q, this.f47336e.R);
                    this.f47336e.P = null;
                }
                this.f47336e.setVideoStatus(VideoStatus.VIDEO_COMPLETE);
                s.d().e(this.f47336e.L);
                if (this.f47336e.getCyberPlayer().isLooping()) {
                    return;
                }
                if (this.f47336e.O != null) {
                    this.f47336e.O.d();
                }
                this.f47336e.M = false;
                if (this.f47336e.f0 != null) {
                    this.f47336e.f0.onCompletion();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCyberVideoView f47337e;

        public c(TbCyberVideoView tbCyberVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCyberVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47337e = tbCyberVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (this.f47337e.getCurrentPosition() > 0 && this.f47337e.G()) {
                    s.d().update(this.f47337e.L, this.f47337e.getCurrentPosition());
                }
                TbVideoViewSet.d().f(this.f47337e.L);
                if (this.f47337e.f0 != null) {
                    this.f47337e.f0.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class d implements CyberPlayerManager.OnSeekCompleteListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCyberVideoView f47338e;

        public d(TbCyberVideoView tbCyberVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCyberVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47338e = tbCyberVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f47338e.f0 == null) {
                return;
            }
            this.f47338e.f0.onSeekComplete();
        }
    }

    /* loaded from: classes12.dex */
    public class e implements CyberPlayerManager.OnInfoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCyberVideoView f47339e;

        public e(TbCyberVideoView tbCyberVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCyberVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47339e = tbCyberVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (this.f47339e.f0 != null) {
                    this.f47339e.f0.onInfo(i2, i3, obj);
                }
                if (this.f47339e.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        this.f47339e.getVideoMonitor().f(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException unused) {
                    }
                }
                if (i2 == 10012) {
                    this.f47339e.setVideoStatus(VideoStatus.VIDEO_PLAYING);
                }
                if (i2 == 10007) {
                    this.f47339e.setVideoStatus(VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR);
                }
                if (i2 == 701) {
                    this.f47339e.setVideoStatus(VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER);
                }
                if (i2 == 702) {
                    if (this.f47339e.t0 != VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER) {
                        this.f47339e.setVideoStatus(VideoStatus.VIDEO_PLAYING);
                    } else {
                        this.f47339e.setVideoStatus(VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY);
                    }
                }
                if (i2 != 904 || this.f47339e.O == null) {
                    return true;
                }
                this.f47339e.O.f(this.f47339e);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCyberVideoView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(TbCyberVideoView tbCyberVideoView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCyberVideoView, Integer.valueOf(i2)};
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
            this.a = tbCyberVideoView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.stop();
                if (this.a.P != null) {
                    this.a.P.j(this.a.Q, this.a.R);
                    this.a.P = null;
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface g {
        void onStatusChange(VideoStatus videoStatus);
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        if (runTask != null) {
            w0 = (k) runTask.getData();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbCyberVideoView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.T = null;
        this.U = false;
        this.V = false;
        this.d0 = false;
        this.h0 = new a(this);
        this.i0 = new b(this);
        this.k0 = new c(this);
        this.q0 = new d(this);
        this.r0 = new e(this);
        this.s0 = new f(this, 2001011);
        this.t0 = VideoStatus.INIT;
        this.u0 = false;
        E(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h getVideoMonitor() {
        InterceptResult invokeV;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            h hVar = this.P;
            if (hVar != null) {
                return hVar;
            }
            if (!StringUtils.isNull(this.L) && (kVar = w0) != null) {
                this.P = kVar.a(this.K, this.L, null);
            }
            return this.P;
        }
        return (h) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoStatus(VideoStatus videoStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, videoStatus) == null) {
            g gVar = this.v0;
            if (gVar != null) {
                gVar.onStatusChange(J(videoStatus));
            }
            if (videoStatus == VideoStatus.VIDEO_PLAYING) {
                this.u0 = true;
                if (this.N) {
                    pauseWithoutMuteAudioFocus();
                    this.N = false;
                } else if (!this.U) {
                    setVolume(1.0f, 1.0f);
                }
            }
            this.t0 = videoStatus;
        }
    }

    public final String A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
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

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getParent() == TbVideoViewSet.d().e(this.L) : invokeV.booleanValue;
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (getParent() == null || getParent().getParent() == null) ? false : true : invokeV.booleanValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g0 = null;
            this.v0 = null;
            this.f0 = null;
            this.c0.j(null);
            this.c0.i(null);
            this.c0.k(null);
        }
    }

    public final void E(Context context) {
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
            super.setOnPreparedListener(this.h0);
            super.setOnCompletionListener(this.i0);
            super.setOnErrorListener(this.k0);
            super.setOnSeekCompleteListener(this.q0);
            super.setOnInfoListener(this.r0);
            this.O = new c.a.t0.z2.u.c();
            this.c0 = new c.a.t0.z2.h();
            SkinManager.setBackgroundResource(this, R.color.black_alpha100);
        }
    }

    public final void F(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, uri) == null) {
            super.stopPlayback();
            setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
            c.a.t0.z2.u.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
            if (pcdnConfigData != null && pcdnConfigData.c()) {
                if (!pcdnConfigData.a(uri)) {
                    this.b0 = 2;
                    return;
                } else if (c.a.t0.z2.u.d.e() != 0 && c.a.t0.z2.u.d.e() != -1) {
                    setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                    setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.b() ? "1" : "0");
                    setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.a.t0.z2.u.d.e()));
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

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getCyberPlayer() != null && getCyberPlayer().getDuration() >= getCyberPlayer().getCurrentPosition() : invokeV.booleanValue;
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20513");
            hashMap.put("click_time", "" + System.currentTimeMillis());
            setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            VideoStatus videoStatus = this.t0;
            if (videoStatus == VideoStatus.VIDEO_PLAYING) {
                setVideoStatus(VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY);
            } else if (videoStatus == VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR) {
                setVideoStatus(VideoStatus.INTERNAL_VIDEO_PAUSING_ERROR);
            } else if (videoStatus == VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER) {
                setVideoStatus(VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER);
            }
        }
    }

    public final VideoStatus J(VideoStatus videoStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, videoStatus)) == null) {
            if (videoStatus == VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY) {
                return VideoStatus.VIDEO_PAUSING;
            }
            if (videoStatus == VideoStatus.INTERNAL_VIDEO_PAUSING_ERROR) {
                return VideoStatus.VIDEO_PAUSING;
            }
            if (videoStatus == VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR) {
                return VideoStatus.VIDEO_BUFFERING;
            }
            return videoStatus == VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER ? VideoStatus.VIDEO_BUFFERING : videoStatus;
        }
        return (VideoStatus) invokeL.objValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.z2.g
    public void changeRenderViewMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            getRenderView().setDisplayMode(i2);
        }
    }

    @Override // c.a.t0.z2.g
    public void clearCallbackAndRemoveFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            D();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, c.a.t0.z2.g
    public int getCurrentPositionSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (getCyberPlayer() == null) {
                return 0;
            }
            return getCyberPlayer().getCurrentPositionSync();
        }
        return invokeV.intValue;
    }

    @Override // c.a.t0.z2.g
    public c.a.t0.z2.h getMediaProgressObserver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.c0 : (c.a.t0.z2.h) invokeV.objValue;
    }

    @Override // c.a.t0.z2.g
    public String getOriginUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.L : (String) invokeV.objValue;
    }

    @Override // c.a.t0.z2.g
    public int getPcdnState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.b0 : invokeV.intValue;
    }

    public c.a.t0.z2.f getPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.e0 == null) {
                this.e0 = new c.a.t0.z2.u.b(getCyberPlayer());
            }
            return this.e0;
        }
        return (c.a.t0.z2.f) invokeV.objValue;
    }

    @Override // c.a.t0.z2.g
    public int getPlayerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (getCyberPlayer() == null) {
                return 0;
            }
            return getCyberPlayer().getVideoHeight();
        }
        return invokeV.intValue;
    }

    @Override // c.a.t0.z2.g
    public int getPlayerWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (getCyberPlayer() == null) {
                return 0;
            }
            return getCyberPlayer().getVideoWidth();
        }
        return invokeV.intValue;
    }

    @Override // c.a.t0.z2.g
    public VideoStatus getVideoStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? J(this.t0) : (VideoStatus) invokeV.objValue;
    }

    @Override // c.a.t0.z2.g
    public boolean isCanShowPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.u0 : invokeV.booleanValue;
    }

    @Override // c.a.t0.z2.g
    public boolean isIntentToStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.M : invokeV.booleanValue;
    }

    @Override // c.a.t0.z2.g
    @Deprecated
    public void monitorAndStatsAtPrepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            c.a.t0.z2.u.c cVar = this.O;
            if (cVar != null) {
                cVar.h();
                this.O.g(getDuration());
                this.O.f(this);
            }
            if (getVideoMonitor() != null) {
                getVideoMonitor().a(CyberPlayerManager.hasCacheFile(this.L));
                getVideoMonitor().h(ErrorCode.ARGS_ERROR);
            }
        }
    }

    @Override // c.a.t0.z2.g
    @Deprecated
    public void monitorAndStatsAtVerticalVideoReplay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || getVideoMonitor() == null) {
            return;
        }
        getVideoMonitor().a(CyberPlayerManager.hasCacheFile(this.L));
        getVideoMonitor().i();
        getVideoMonitor().k(ErrorCode.ARGS_ERROR);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.s0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
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
            D();
            MessageManager.getInstance().unRegisterListener(this.s0);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            t0.f(this.T, false);
            if (isPlaying() && G()) {
                s.d().update(this.L, getCurrentPositionSync());
            }
            this.M = false;
            super.pause();
            I();
            c.a.t0.z2.u.c cVar = this.O;
            if (cVar != null) {
                cVar.e();
            }
            try {
                if (this.S != null && this.S.isHeld()) {
                    this.S.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            h hVar = this.P;
            if (hVar != null) {
                hVar.e();
            }
        }
    }

    @Override // c.a.t0.z2.g
    public void pauseWithoutMuteAudioFocus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (isPlaying() && G()) {
                s.d().update(this.L, getCurrentPositionSync());
            }
            this.M = false;
            super.pause();
            I();
            c.a.t0.z2.u.c cVar = this.O;
            if (cVar != null) {
                cVar.e();
            }
            try {
                if (this.S != null && this.S.isHeld()) {
                    this.S.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            h hVar = this.P;
            if (hVar != null) {
                hVar.e();
            }
        }
    }

    @Override // c.a.t0.z2.g
    public void prepareByPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            start();
            this.N = true;
        }
    }

    @Override // c.a.t0.z2.g
    public void recordPlayTimeInfo(long j2, long j3, long j4) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) || (hVar = this.P) == null) {
            return;
        }
        hVar.recordPlayTimeInfo(j2, j3, j4);
    }

    @Override // c.a.t0.z2.g
    public void resumePlay(TbVideoViewSet.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bVar) == null) {
            if (!isPlaying() && !this.M) {
                this.M = true;
                if (bVar != null) {
                    this.V = true;
                    if (!C()) {
                        bVar.b();
                    }
                } else {
                    this.V = false;
                }
                setVideoPath(this.L, this.K);
                return;
            }
            start(bVar);
        }
    }

    @Override // c.a.t0.z2.g
    public void setCanShowPause(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.u0 = z;
        }
    }

    @Override // c.a.t0.z2.g
    public void setContinuePlayEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.J = z;
        }
    }

    @Override // c.a.t0.z2.g
    public void setIsVolume0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.U = z;
        }
    }

    @Override // c.a.t0.z2.g
    public void setLocateSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.Q = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            getCyberPlayer().setLooping(z);
        }
    }

    @Override // c.a.t0.z2.g
    public void setNoBussinessStats() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.O = null;
        }
    }

    @Override // c.a.t0.z2.g
    public void setOnSurfaceDestroyedListener(TbVideoViewContainer.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, aVar) == null) {
            this.g0 = aVar;
        }
    }

    @Override // c.a.t0.z2.g
    public void setOperableVideoContainer(c.a.t0.z2.v.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, aVar) == null) {
            this.f0 = aVar;
        }
    }

    @Override // c.a.t0.z2.g
    public void setPlayMode(String str) {
        c.a.t0.z2.u.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, str) == null) || (cVar = this.O) == null) {
            return;
        }
        cVar.l(str);
    }

    @Override // c.a.t0.z2.g
    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            if (m.isEmpty(str)) {
                str = "-1";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20484");
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, str);
            setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.R = str;
        }
    }

    @Override // c.a.t0.z2.g
    public void setThreadDataForStatistic(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, e2Var) == null) {
            if (this.O == null) {
                this.O = new c.a.t0.z2.u.c();
            }
            this.O.m(e2Var);
        }
    }

    @Override // c.a.t0.z2.g
    public void setTryUseViewInSet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.V = z;
        }
    }

    @Override // c.a.t0.z2.g
    public void setVideoModel(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, rVar) == null) {
        }
    }

    @Override // c.a.t0.z2.g
    public void setVideoPath(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048626, this, str, str2) == null) || m.isEmpty(str)) {
            return;
        }
        this.K = str2;
        setVideoPath(str);
    }

    @Override // c.a.t0.z2.g
    public void setVideoStatData(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, tVar) == null) {
            if (this.O == null) {
                this.O = new c.a.t0.z2.u.c();
            }
            this.O.n(tVar);
            if (tVar != null) {
                this.Q = tVar.a;
            }
        }
    }

    @Override // c.a.t0.z2.g
    public void setVideoStatusChangeListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, gVar) == null) {
            this.v0 = gVar;
        }
    }

    @Override // c.a.t0.z2.g
    public void setVolume(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || getCyberPlayer() == null) {
            return;
        }
        this.U = f2 == 0.0f && f3 == 0.0f;
        getCyberPlayer().setVolume(f2, f3);
    }

    @Override // c.a.t0.z2.g
    public void start(TbVideoViewSet.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, bVar) == null) {
            if (bVar != null) {
                this.V = true;
                if (!C()) {
                    bVar.b();
                }
                if (!B()) {
                    bVar.a();
                    this.M = true;
                    this.N = false;
                    setVideoPath(this.L, this.K);
                    return;
                }
            } else {
                this.V = false;
            }
            start();
        }
    }

    @Override // c.a.t0.z2.g
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            if (!this.V) {
                stopPlayback();
                return;
            }
            if (this.L != null && isPlaying()) {
                t0.f(this.T, false);
            }
            this.M = false;
            if (isPlaying() && G()) {
                s.d().update(this.L, getCurrentPositionSync());
            }
            try {
                if (this.S != null && this.S.isHeld()) {
                    this.S.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            super.pause();
            I();
            c.a.t0.z2.u.c cVar = this.O;
            if (cVar != null) {
                cVar.j();
            }
            this.c0.n();
            h hVar = this.P;
            if (hVar == null || !hVar.c(this.Q, this.R)) {
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
                t0.f(this.T, false);
            }
            this.M = false;
            if (isPlaying() && G()) {
                s.d().update(this.L, getCurrentPositionSync());
            }
            try {
                if (this.S != null && this.S.isHeld()) {
                    this.S.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            super.stopPlayback();
            TbVideoViewSet.d().f(this.L);
            c.a.t0.z2.u.c cVar = this.O;
            if (cVar != null) {
                cVar.j();
            }
            this.c0.n();
            h hVar = this.P;
            if (hVar == null || !hVar.c(this.Q, this.R)) {
                return;
            }
            this.P = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, str) == null) || m.isEmpty(str)) {
            return;
        }
        H();
        this.L = str;
        String A = A(str);
        k kVar = w0;
        if (kVar != null) {
            h a2 = kVar.a(this.K, this.L, null);
            this.P = a2;
            if (a2 != null) {
                a2.a(CyberPlayerManager.hasCacheFile(A));
            }
        }
        this.c0.l(this);
        c.a.t0.z2.u.c cVar = this.O;
        if (cVar != null) {
            cVar.h();
        }
        F(Uri.parse(A));
        h hVar = this.P;
        if (hVar != null) {
            hVar.i();
        }
        super.setVideoPath(A);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            if (!this.U) {
                t0.f(this.T, true);
                setVolume(1.0f, 1.0f);
            }
            this.M = true;
            this.N = false;
            super.start();
            if (this.t0 == VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY) {
                setVideoStatus(VideoStatus.VIDEO_PLAYING);
            }
            if (this.t0 == VideoStatus.INTERNAL_VIDEO_PAUSING_ERROR) {
                setVideoStatus(VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR);
            }
            if (this.t0 == VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER) {
                setVideoStatus(VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER);
            }
            c.a.t0.z2.u.c cVar = this.O;
            if (cVar != null) {
                cVar.i();
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
                getVideoMonitor().g(ErrorCode.ARGS_ERROR);
                getVideoMonitor().b(this.W, this.a0);
            }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.h0 = new a(this);
        this.i0 = new b(this);
        this.k0 = new c(this);
        this.q0 = new d(this);
        this.r0 = new e(this);
        this.s0 = new f(this, 2001011);
        this.t0 = VideoStatus.INIT;
        this.u0 = false;
        E(context);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.h0 = new a(this);
        this.i0 = new b(this);
        this.k0 = new c(this);
        this.q0 = new d(this);
        this.r0 = new e(this);
        this.s0 = new f(this, 2001011);
        this.t0 = VideoStatus.INIT;
        this.u0 = false;
        E(context);
    }
}
