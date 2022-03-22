package com.baidu.tieba.play.cyberPlayer;

import android.content.Context;
import android.net.Uri;
import android.os.PowerManager;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import c.a.d.f.p.m;
import c.a.o0.c1.t0;
import c.a.p0.c3.s;
import c.a.p0.c3.t;
import c.a.p0.c3.u;
import c.a.p0.l2.h;
import c.a.p0.l2.k;
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
/* loaded from: classes5.dex */
public class TbCyberVideoView extends CyberVideoView implements c.a.p0.c3.g {
    public static /* synthetic */ Interceptable $ic;
    public static k w0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean J;
    public String K;
    public String L;
    public boolean M;
    public boolean N;
    public c.a.p0.c3.v.c O;
    public h P;
    public String Q;
    public String R;
    public PowerManager.WakeLock S;
    public WeakReference<Context> T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean g0;
    public int h0;
    public c.a.p0.c3.h i0;
    public boolean j0;
    public c.a.p0.c3.v.b k0;
    public c.a.p0.c3.w.a l0;
    public TbVideoViewContainer.a m0;
    public CyberPlayerManager.OnPreparedListener n0;
    public CyberPlayerManager.OnCompletionListener o0;
    public CyberPlayerManager.OnErrorListener p0;
    public CyberPlayerManager.OnSeekCompleteListener q0;
    public CyberPlayerManager.OnInfoListener r0;
    public final CustomMessageListener s0;
    public VideoStatus t0;
    public boolean u0;
    public g v0;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
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

        public VideoStatus(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes5.dex */
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
            int c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.O != null) {
                    this.a.O.g(this.a.getDuration());
                }
                this.a.setVideoStatus(VideoStatus.VIDEO_PREPARED);
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
                if (this.a.J && (c2 = t.d().c(this.a.L)) > 0) {
                    this.a.seekTo(c2);
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

    /* loaded from: classes5.dex */
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
                this.a.setVideoStatus(VideoStatus.VIDEO_COMPLETE);
                t.d().e(this.a.L);
                if (this.a.getCyberPlayer().isLooping()) {
                    return;
                }
                if (this.a.O != null) {
                    this.a.O.d();
                }
                this.a.M = false;
                if (this.a.l0 != null) {
                    this.a.l0.onCompletion();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                    t.d().update(this.a.L, this.a.getCurrentPosition());
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

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
                    this.a.setVideoStatus(VideoStatus.VIDEO_PLAYING);
                }
                if (i == 10007) {
                    this.a.setVideoStatus(VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR);
                }
                if (i == 701) {
                    this.a.setVideoStatus(VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER);
                }
                if (i == 702) {
                    if (this.a.t0 != VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER) {
                        this.a.setVideoStatus(VideoStatus.VIDEO_PLAYING);
                    } else {
                        this.a.setVideoStatus(VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY);
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

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
        this.n0 = new a(this);
        this.o0 = new b(this);
        this.p0 = new c(this);
        this.q0 = new d(this);
        this.r0 = new e(this);
        this.s0 = new f(this, 2001011);
        this.t0 = VideoStatus.INIT;
        this.u0 = false;
        M(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h getVideoMonitor() {
        InterceptResult invokeV;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
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
                gVar.onStatusChange(R(videoStatus));
            }
            if (videoStatus == VideoStatus.VIDEO_PLAYING) {
                this.u0 = true;
                if (this.N) {
                    q();
                    this.N = false;
                } else if (!this.U) {
                    setVolume(1.0f, 1.0f);
                }
            }
            this.t0 = videoStatus;
        }
    }

    public final String I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
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
            this.v0 = null;
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
            super.setOnPreparedListener(this.n0);
            super.setOnCompletionListener(this.o0);
            super.setOnErrorListener(this.p0);
            super.setOnSeekCompleteListener(this.q0);
            super.setOnInfoListener(this.r0);
            this.O = new c.a.p0.c3.v.c();
            this.i0 = new c.a.p0.c3.h();
            SkinManager.setBackgroundResource(this, R.color.black_alpha100);
        }
    }

    public final void N(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, uri) == null) {
            super.stopPlayback();
            setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
            c.a.p0.c3.v.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
            if (pcdnConfigData != null && pcdnConfigData.c()) {
                if (!pcdnConfigData.a(uri)) {
                    this.h0 = 2;
                    return;
                } else if (c.a.p0.c3.v.d.e() != 0 && c.a.p0.c3.v.d.e() != -1) {
                    setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                    setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.b() ? "1" : "0");
                    setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.a.p0.c3.v.d.e()));
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

    public final VideoStatus R(VideoStatus videoStatus) {
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

    @Override // c.a.p0.c3.g
    public void a(long j, long j2, long j3) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) || (hVar = this.P) == null) {
            return;
        }
        hVar.a(j, j2, j3);
    }

    @Override // c.a.p0.c3.g
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

    @Override // c.a.p0.c3.g
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

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, c.a.p0.c3.g
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

    @Override // c.a.p0.c3.g
    public c.a.p0.c3.h getMediaProgressObserver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.i0 : (c.a.p0.c3.h) invokeV.objValue;
    }

    @Override // c.a.p0.c3.g
    public String getOriginUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.L : (String) invokeV.objValue;
    }

    @Override // c.a.p0.c3.g
    public int getPcdnState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.h0 : invokeV.intValue;
    }

    @Override // c.a.p0.c3.g
    public c.a.p0.c3.f getPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.k0 == null) {
                this.k0 = new c.a.p0.c3.v.b(getCyberPlayer());
            }
            return this.k0;
        }
        return (c.a.p0.c3.f) invokeV.objValue;
    }

    @Override // c.a.p0.c3.g
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

    @Override // c.a.p0.c3.g
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

    @Override // c.a.p0.c3.g
    public VideoStatus getVideoStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? R(this.t0) : (VideoStatus) invokeV.objValue;
    }

    @Override // c.a.p0.c3.g
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            L();
        }
    }

    @Override // c.a.p0.c3.g
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            start();
            this.N = true;
        }
    }

    @Override // c.a.p0.c3.g
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.u0 : invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.g
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

    @Override // c.a.p0.c3.g
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.M : invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.g
    @Deprecated
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            c.a.p0.c3.v.c cVar = this.O;
            if (cVar != null) {
                cVar.h();
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
            MessageManager.getInstance().registerListener(this.s0);
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
            MessageManager.getInstance().unRegisterListener(this.s0);
        }
    }

    @Override // c.a.p0.c3.g
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
            t0.f(this.T, false);
            if (isPlaying() && O()) {
                t.d().update(this.L, getCurrentPositionSync());
            }
            this.M = false;
            super.pause();
            Q();
            c.a.p0.c3.v.c cVar = this.O;
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
                hVar.f();
            }
        }
    }

    @Override // c.a.p0.c3.g
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            if (isPlaying() && O()) {
                t.d().update(this.L, getCurrentPositionSync());
            }
            this.M = false;
            super.pause();
            Q();
            c.a.p0.c3.v.c cVar = this.O;
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
                hVar.f();
            }
        }
    }

    @Override // c.a.p0.c3.g
    public void setCanShowPause(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.u0 = z;
        }
    }

    @Override // c.a.p0.c3.g
    public void setContinuePlayEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.J = z;
        }
    }

    @Override // c.a.p0.c3.g
    public void setIsVolume0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.U = z;
        }
    }

    @Override // c.a.p0.c3.g
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

    @Override // c.a.p0.c3.g
    public void setNoBussinessStats() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.O = null;
        }
    }

    @Override // c.a.p0.c3.g
    public void setOnSurfaceDestroyedListener(TbVideoViewContainer.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, aVar) == null) {
            this.m0 = aVar;
        }
    }

    @Override // c.a.p0.c3.g
    public void setOperableVideoContainer(c.a.p0.c3.w.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, aVar) == null) {
            this.l0 = aVar;
        }
    }

    @Override // c.a.p0.c3.g
    public void setPlayMode(String str) {
        c.a.p0.c3.v.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, str) == null) || (cVar = this.O) == null) {
            return;
        }
        cVar.l(str);
    }

    @Override // c.a.p0.c3.g
    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
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

    @Override // c.a.p0.c3.g
    public void setThreadDataForStatistic(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, threadData) == null) {
            if (this.O == null) {
                this.O = new c.a.p0.c3.v.c();
            }
            this.O.m(threadData);
        }
    }

    @Override // c.a.p0.c3.g
    public void setTryUseViewInSet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.V = z;
        }
    }

    @Override // c.a.p0.c3.g
    public void setVideoModel(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, sVar) == null) {
        }
    }

    @Override // c.a.p0.c3.g
    public void setVideoPath(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048627, this, str, str2) == null) || m.isEmpty(str)) {
            return;
        }
        this.K = str2;
        setVideoPath(str);
    }

    @Override // c.a.p0.c3.g
    public void setVideoStatData(u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, uVar) == null) {
            if (this.O == null) {
                this.O = new c.a.p0.c3.v.c();
            }
            this.O.o(uVar);
            if (uVar != null) {
                this.Q = uVar.a;
            }
        }
    }

    @Override // c.a.p0.c3.g
    public void setVideoStatusChangeListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, gVar) == null) {
            this.v0 = gVar;
        }
    }

    @Override // c.a.p0.c3.g
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
            c.a.p0.c3.v.c cVar = this.O;
            if (cVar != null) {
                cVar.i();
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

    @Override // c.a.p0.c3.g
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
            if (isPlaying() && O()) {
                t.d().update(this.L, getCurrentPositionSync());
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
            c.a.p0.c3.v.c cVar = this.O;
            if (cVar != null) {
                cVar.j();
            }
            this.i0.n();
            h hVar = this.P;
            if (hVar == null || !hVar.d(this.Q, this.R)) {
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
            if (isPlaying() && O()) {
                t.d().update(this.L, getCurrentPositionSync());
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
            c.a.p0.c3.v.c cVar = this.O;
            if (cVar != null) {
                cVar.j();
            }
            this.i0.n();
            h hVar = this.P;
            if (hVar == null || !hVar.d(this.Q, this.R)) {
                return;
            }
            this.P = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, str) == null) || m.isEmpty(str)) {
            return;
        }
        P();
        if (UbsABTestHelper.isVideoSetUrlAgainABTest() || !m.isEquals(this.L, str)) {
            this.L = str;
            String I = I(str);
            k kVar = w0;
            if (kVar != null) {
                h a2 = kVar.a(this.K, this.L, null);
                this.P = a2;
                if (a2 != null) {
                    a2.b(CyberPlayerManager.hasCacheFile(I));
                }
            }
            this.i0.l(this);
            c.a.p0.c3.v.c cVar = this.O;
            if (cVar != null) {
                cVar.h();
            }
            N(Uri.parse(I));
            h hVar = this.P;
            if (hVar != null) {
                hVar.j();
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
        this.n0 = new a(this);
        this.o0 = new b(this);
        this.p0 = new c(this);
        this.q0 = new d(this);
        this.r0 = new e(this);
        this.s0 = new f(this, 2001011);
        this.t0 = VideoStatus.INIT;
        this.u0 = false;
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
        this.n0 = new a(this);
        this.o0 = new b(this);
        this.p0 = new c(this);
        this.q0 = new d(this);
        this.r0 = new e(this);
        this.s0 = new f(this, 2001011);
        this.t0 = VideoStatus.INIT;
        this.u0 = false;
        M(context);
    }
}
