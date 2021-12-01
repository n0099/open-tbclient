package com.baidu.tieba.play.cyberPlayer;

import android.content.Context;
import android.net.Uri;
import android.os.PowerManager;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.MediaController;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import c.a.q0.d1.r0;
import c.a.q0.s.q.d2;
import c.a.r0.g2.k;
import c.a.r0.x2.o;
import c.a.r0.x2.p;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class TbCyberVideoView extends CyberVideoView implements MediaController.MediaPlayerControl {
    public static /* synthetic */ Interceptable $ic = null;
    public static k A0 = null;
    public static final String TB_FREE_HOST = "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv";
    public static final String TB_HOST = "http://tb-video.bdstatic.com";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean J;
    public String K;
    public String L;
    public boolean M;
    public boolean N;
    public c.a.r0.x2.q.b O;
    public c.a.r0.g2.h P;
    public String Q;
    public String R;
    public PowerManager.WakeLock S;
    public WeakReference<Context> T;
    public boolean U;
    public boolean V;
    public int W;
    public boolean a0;
    public boolean b0;
    public int c0;
    public c.a.r0.x2.f d0;
    public boolean e0;
    public CyberPlayerManager.OnPreparedListener f0;
    public CyberPlayerManager.OnCompletionListener g0;
    public CyberPlayerManager.OnSeekCompleteListener h0;
    public CyberPlayerManager.OnErrorListener i0;
    public CyberPlayerManager.OnInfoListener k0;
    public h q0;
    public CyberPlayerManager.OnPreparedListener r0;
    public CyberPlayerManager.OnCompletionListener s0;
    public CyberPlayerManager.OnErrorListener t0;
    public CyberPlayerManager.OnSeekCompleteListener u0;
    public CyberPlayerManager.OnInfoListener v0;
    public final CustomMessageListener w0;
    public VideoStatus x0;
    public boolean y0;
    public g z0;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
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
            INIT = new VideoStatus("INIT", 0);
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

    /* loaded from: classes11.dex */
    public class a implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCyberVideoView f48442e;

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
            this.f48442e = tbCyberVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            int c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f48442e.O != null) {
                    this.f48442e.O.e(this.f48442e.getDuration());
                }
                this.f48442e.setVideoStatus(VideoStatus.VIDEO_PREPARED);
                if (this.f48442e.getVideoMonitor() != null) {
                    this.f48442e.getVideoMonitor().l(ErrorCode.ARGS_ERROR);
                }
                if (!this.f48442e.e0) {
                    if (!ViewCompat.isAttachedToWindow(this.f48442e.getView())) {
                        return;
                    }
                    if (!this.f48442e.N) {
                        TbVideoViewSet d2 = TbVideoViewSet.d();
                        TbCyberVideoView tbCyberVideoView = this.f48442e;
                        d2.g(tbCyberVideoView, tbCyberVideoView.L);
                    }
                }
                if (this.f48442e.f0 != null) {
                    this.f48442e.f0.onPrepared();
                }
                if (this.f48442e.J && (c2 = o.d().c(this.f48442e.L)) > 0) {
                    this.f48442e.seekTo(c2);
                }
                if (this.f48442e.M) {
                    boolean z = this.f48442e.N;
                    this.f48442e.start();
                    this.f48442e.N = z;
                    if (this.f48442e.N) {
                        this.f48442e.setVolume(0.0f, 0.0f);
                    }
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCyberVideoView f48443e;

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
            this.f48443e = tbCyberVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f48443e.P != null) {
                    this.f48443e.P.e(this.f48443e.Q, this.f48443e.R);
                    this.f48443e.P = null;
                }
                this.f48443e.setVideoStatus(VideoStatus.VIDEO_COMPLETE);
                o.d().e(this.f48443e.L);
                if (this.f48443e.getCyberPlayer().isLooping()) {
                    return;
                }
                if (this.f48443e.O != null) {
                    this.f48443e.O.b();
                }
                this.f48443e.M = false;
                if (this.f48443e.g0 != null) {
                    this.f48443e.g0.onCompletion();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCyberVideoView f48444e;

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
            this.f48444e = tbCyberVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (this.f48444e.getCurrentPosition() > 0 && this.f48444e.O()) {
                    o.d().update(this.f48444e.L, this.f48444e.getCurrentPosition());
                }
                TbVideoViewSet.d().f(this.f48444e.L);
                if (this.f48444e.i0 != null) {
                    this.f48444e.i0.onError(i2, i3, obj);
                    return true;
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class d implements CyberPlayerManager.OnSeekCompleteListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCyberVideoView f48445e;

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
            this.f48445e = tbCyberVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48445e.h0 == null) {
                return;
            }
            this.f48445e.h0.onSeekComplete();
        }
    }

    /* loaded from: classes11.dex */
    public class e implements CyberPlayerManager.OnInfoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCyberVideoView f48446e;

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
            this.f48446e = tbCyberVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (this.f48446e.k0 != null) {
                    this.f48446e.k0.onInfo(i2, i3, obj);
                }
                if (this.f48446e.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        this.f48446e.getVideoMonitor().g(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException unused) {
                    }
                }
                if (i2 == 10012) {
                    this.f48446e.setVideoStatus(VideoStatus.VIDEO_PLAYING);
                }
                if (i2 == 10007) {
                    this.f48446e.setVideoStatus(VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR);
                }
                if (i2 == 701) {
                    this.f48446e.setVideoStatus(VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER);
                }
                if (i2 == 702) {
                    if (this.f48446e.x0 != VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER) {
                        this.f48446e.setVideoStatus(VideoStatus.VIDEO_PLAYING);
                    } else {
                        this.f48446e.setVideoStatus(VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY);
                    }
                }
                if (i2 != 904 || this.f48446e.O == null) {
                    return true;
                }
                this.f48446e.O.d(this.f48446e);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
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
                    this.a.P.k(this.a.Q, this.a.R);
                    this.a.P = null;
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface g {
        void onStatusChange(VideoStatus videoStatus);
    }

    /* loaded from: classes11.dex */
    public interface h {
        void onSurfaceDestroyed();
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
            A0 = (k) runTask.getData();
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
        this.e0 = false;
        this.r0 = new a(this);
        this.s0 = new b(this);
        this.t0 = new c(this);
        this.u0 = new d(this);
        this.v0 = new e(this);
        this.w0 = new f(this, 2001011);
        this.x0 = VideoStatus.INIT;
        this.y0 = false;
        L(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a.r0.g2.h getVideoMonitor() {
        InterceptResult invokeV;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            c.a.r0.g2.h hVar = this.P;
            if (hVar != null) {
                return hVar;
            }
            if (!StringUtils.isNull(this.L) && (kVar = A0) != null) {
                this.P = kVar.a(this.K, this.L, null);
            }
            return this.P;
        }
        return (c.a.r0.g2.h) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoStatus(VideoStatus videoStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, videoStatus) == null) {
            g gVar = this.z0;
            if (gVar != null) {
                gVar.onStatusChange(T(videoStatus));
            }
            if (videoStatus == VideoStatus.VIDEO_PLAYING) {
                this.y0 = true;
                if (this.N) {
                    pauseWithoutMuteAudioFocus();
                    this.N = false;
                } else if (!this.U) {
                    setVolume(1.0f, 1.0f);
                }
            }
            this.x0 = videoStatus;
        }
    }

    public final String E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!c.a.d.f.p.k.isEmpty(str) && c.a.r0.h4.h.d().e()) {
                if (str.contains("http://tb-video.bdstatic.com")) {
                    return str.replace("http://tb-video.bdstatic.com", "https://gss3.baidu.com/6LZ0ej3k1Qd3ote6lo7D0j9wehsv");
                }
                return str.contains(UrlSchemaHelper.SCHEMA_TYPE_HTTP) ? str.replace(UrlSchemaHelper.SCHEMA_TYPE_HTTP, UrlSchemaHelper.SCHEMA_TYPE_HTTPS) : str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this == TbVideoViewSet.d().e(this.L) : invokeV.booleanValue;
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getParent() != null : invokeV.booleanValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.q0 = null;
            this.g0 = null;
            this.i0 = null;
            this.k0 = null;
            this.f0 = null;
            this.h0 = null;
            this.z0 = null;
            this.d0.j(null);
            this.d0.i(null);
            this.d0.k(null);
        }
    }

    public final void L(Context context) {
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
            super.setOnPreparedListener(this.r0);
            super.setOnCompletionListener(this.s0);
            super.setOnErrorListener(this.t0);
            super.setOnSeekCompleteListener(this.u0);
            super.setOnInfoListener(this.v0);
            this.O = new c.a.r0.x2.q.b();
            this.d0 = new c.a.r0.x2.f();
            SkinManager.setBackgroundResource(this, R.color.black_alpha100);
        }
    }

    public final void M(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, uri) == null) {
            super.stopPlayback();
            setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
            c.a.r0.x2.q.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
            if (pcdnConfigData != null && pcdnConfigData.c()) {
                if (!pcdnConfigData.a(uri)) {
                    this.c0 = 2;
                    return;
                } else if (c.a.r0.x2.q.c.e() <= 0) {
                    this.c0 = 3;
                    return;
                } else {
                    setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                    setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.b() ? "1" : "0");
                    setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(c.a.r0.x2.q.c.e()));
                    this.a0 = true;
                    this.b0 = pcdnConfigData.b();
                    this.c0 = 1;
                    return;
                }
            }
            this.c0 = 0;
        }
    }

    public final boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getCyberPlayer() != null && getCyberPlayer().getDuration() >= getCyberPlayer().getCurrentPosition() : invokeV.booleanValue;
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20513");
            hashMap.put("click_time", "" + System.currentTimeMillis());
            setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            VideoStatus videoStatus = this.x0;
            if (videoStatus == VideoStatus.VIDEO_PLAYING) {
                setVideoStatus(VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY);
            } else if (videoStatus == VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR) {
                setVideoStatus(VideoStatus.INTERNAL_VIDEO_PAUSING_ERROR);
            } else if (videoStatus == VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER) {
                setVideoStatus(VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER);
            }
        }
    }

    public final VideoStatus T(VideoStatus videoStatus) {
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

    public void clearCallbackAndRemoveFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            K();
            if (getParent() instanceof ViewGroup) {
                ((ViewGroup) getParent()).removeView(this);
            }
        }
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

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
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

    public c.a.r0.x2.f getMediaProgressObserver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.d0 : (c.a.r0.x2.f) invokeV.objValue;
    }

    public String getOriginUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.L : (String) invokeV.objValue;
    }

    public int getPcdnState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.c0 : invokeV.intValue;
    }

    public VideoStatus getVideoStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? T(this.x0) : (VideoStatus) invokeV.objValue;
    }

    public boolean isCanShowPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.y0 : invokeV.booleanValue;
    }

    public boolean isIntentToStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.M : invokeV.booleanValue;
    }

    @Deprecated
    public void monitorAndStatsAtPrepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            c.a.r0.x2.q.b bVar = this.O;
            if (bVar != null) {
                bVar.f();
                this.O.e(getDuration());
                this.O.d(this);
            }
            if (getVideoMonitor() != null) {
                getVideoMonitor().a(CyberPlayerManager.hasCacheFile(this.L));
                getVideoMonitor().i(ErrorCode.ARGS_ERROR);
            }
        }
    }

    @Deprecated
    public void monitorAndStatsAtVerticalVideoReplay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || getVideoMonitor() == null) {
            return;
        }
        getVideoMonitor().a(CyberPlayerManager.hasCacheFile(this.L));
        getVideoMonitor().j();
        getVideoMonitor().l(ErrorCode.ARGS_ERROR);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.w0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onDetachedFromWindow();
            h hVar = this.q0;
            if (hVar != null) {
                hVar.onSurfaceDestroyed();
            }
            try {
                if (this.S != null && this.S.isHeld()) {
                    this.S.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            K();
            MessageManager.getInstance().unRegisterListener(this.w0);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            r0.f(this.T, false);
            if (isPlaying() && O()) {
                o.d().update(this.L, getCurrentPositionSync());
            }
            this.M = false;
            super.pause();
            S();
            c.a.r0.x2.q.b bVar = this.O;
            if (bVar != null) {
                bVar.c();
            }
            try {
                if (this.S != null && this.S.isHeld()) {
                    this.S.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            c.a.r0.g2.h hVar = this.P;
            if (hVar != null) {
                hVar.f();
            }
        }
    }

    public void pauseWithoutMuteAudioFocus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (isPlaying() && O()) {
                o.d().update(this.L, getCurrentPositionSync());
            }
            this.M = false;
            super.pause();
            S();
            c.a.r0.x2.q.b bVar = this.O;
            if (bVar != null) {
                bVar.c();
            }
            try {
                if (this.S != null && this.S.isHeld()) {
                    this.S.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            c.a.r0.g2.h hVar = this.P;
            if (hVar != null) {
                hVar.f();
            }
        }
    }

    public void prepareByPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            start();
            this.N = true;
        }
    }

    public void recordPlayTimeInfo(long j2, long j3, long j4) {
        c.a.r0.g2.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) || (hVar = this.P) == null) {
            return;
        }
        hVar.c(j2, j3, j4);
    }

    public void resumePlay(TbVideoViewSet.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bVar) == null) {
            if (!isPlaying() && !this.M) {
                this.M = true;
                if (bVar != null) {
                    this.V = true;
                    if (!G()) {
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

    public void setCanShowPause(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.y0 = z;
        }
    }

    public void setContinuePlayEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.J = z;
        }
    }

    public void setIsUseInflutter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.e0 = z;
        }
    }

    public void setIsVolume0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.U = z;
        }
    }

    public void setLocateSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.Q = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            getCyberPlayer().setLooping(z);
        }
    }

    public void setMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.U = z;
            getCyberPlayer().muteOrUnmuteAudio(z);
            r0.f(this.T, !z);
        }
    }

    public void setNoBussinessStats() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.O = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, onCompletionListener) == null) {
            this.g0 = onCompletionListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, onErrorListener) == null) {
            this.i0 = onErrorListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, onInfoListener) == null) {
            this.k0 = onInfoListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, onPreparedListener) == null) {
            this.f0 = onPreparedListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, onSeekCompleteListener) == null) {
            this.h0 = onSeekCompleteListener;
        }
    }

    public void setOnSurfaceDestroyedListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, hVar) == null) {
            this.q0 = hVar;
        }
    }

    public void setPlayMode(String str) {
        c.a.r0.x2.q.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048622, this, str) == null) || (bVar = this.O) == null) {
            return;
        }
        bVar.j(str);
    }

    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            if (c.a.d.f.p.k.isEmpty(str)) {
                str = "-1";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20484");
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, str);
            setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.R = str;
        }
    }

    public void setThreadDataForStatistic(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, d2Var) == null) {
            if (this.O == null) {
                this.O = new c.a.r0.x2.q.b();
            }
            this.O.k(d2Var);
        }
    }

    public void setTryUseViewInSet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.V = z;
        }
    }

    public void setVideoDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            this.W = i2;
        }
    }

    public void setVideoPath(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048628, this, str, str2) == null) || c.a.d.f.p.k.isEmpty(str)) {
            return;
        }
        this.K = str2;
        setVideoPath(str);
    }

    public void setVideoStatData(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, pVar) == null) {
            if (this.O == null) {
                this.O = new c.a.r0.x2.q.b();
            }
            this.O.l(pVar);
            if (pVar != null) {
                this.Q = pVar.a;
            }
        }
    }

    public void setVideoStatusChangeListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, gVar) == null) {
            this.z0 = gVar;
        }
    }

    public void setVolume(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || getCyberPlayer() == null) {
            return;
        }
        this.U = f2 == 0.0f && f3 == 0.0f;
        getCyberPlayer().setVolume(f2, f3);
    }

    public void start(TbVideoViewSet.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, bVar) == null) {
            if (bVar != null) {
                this.V = true;
                if (!G()) {
                    bVar.b();
                }
                if (!F()) {
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

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            if (!this.V) {
                stopPlayback();
                return;
            }
            if (this.L != null && isPlaying()) {
                r0.f(this.T, false);
            }
            this.M = false;
            if (isPlaying() && O()) {
                o.d().update(this.L, getCurrentPositionSync());
            }
            try {
                if (this.S != null && this.S.isHeld()) {
                    this.S.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            super.pause();
            S();
            c.a.r0.x2.q.b bVar = this.O;
            if (bVar != null) {
                bVar.h();
            }
            this.d0.n();
            c.a.r0.g2.h hVar = this.P;
            if (hVar == null || !hVar.d(this.Q, this.R)) {
                return;
            }
            this.P = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            if (this.L != null && isPlaying()) {
                r0.f(this.T, false);
            }
            this.M = false;
            if (isPlaying() && O()) {
                o.d().update(this.L, getCurrentPositionSync());
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
            c.a.r0.x2.q.b bVar = this.O;
            if (bVar != null) {
                bVar.h();
            }
            this.d0.n();
            c.a.r0.g2.h hVar = this.P;
            if (hVar == null || !hVar.d(this.Q, this.R)) {
                return;
            }
            this.P = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, str) == null) || c.a.d.f.p.k.isEmpty(str)) {
            return;
        }
        Q();
        this.L = str;
        String E = E(str);
        k kVar = A0;
        if (kVar != null) {
            c.a.r0.g2.h a2 = kVar.a(this.K, this.L, null);
            this.P = a2;
            if (a2 != null) {
                a2.a(CyberPlayerManager.hasCacheFile(E));
            }
        }
        this.d0.l(this);
        c.a.r0.x2.q.b bVar = this.O;
        if (bVar != null) {
            bVar.f();
        }
        M(Uri.parse(E));
        c.a.r0.g2.h hVar = this.P;
        if (hVar != null) {
            hVar.j();
        }
        String host = Uri.parse(this.L).getHost();
        if (!StringUtils.isNull(host)) {
            host.contains("tb-video.bdstatic.com");
        }
        int i2 = this.W;
        super.setVideoPath(E);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            if (!this.U) {
                r0.f(this.T, true);
                setVolume(1.0f, 1.0f);
            }
            this.M = true;
            this.N = false;
            super.start();
            if (this.x0 == VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY) {
                setVideoStatus(VideoStatus.VIDEO_PLAYING);
            }
            if (this.x0 == VideoStatus.INTERNAL_VIDEO_PAUSING_ERROR) {
                setVideoStatus(VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR);
            }
            if (this.x0 == VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER) {
                setVideoStatus(VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER);
            }
            c.a.r0.x2.q.b bVar = this.O;
            if (bVar != null) {
                bVar.g();
            }
            this.d0.m();
            try {
                if (this.S != null && !this.S.isHeld()) {
                    this.S.acquire();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            if (getVideoMonitor() != null) {
                getVideoMonitor().h(ErrorCode.ARGS_ERROR);
                getVideoMonitor().b(this.a0, this.b0);
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
        this.e0 = false;
        this.r0 = new a(this);
        this.s0 = new b(this);
        this.t0 = new c(this);
        this.u0 = new d(this);
        this.v0 = new e(this);
        this.w0 = new f(this, 2001011);
        this.x0 = VideoStatus.INIT;
        this.y0 = false;
        L(context);
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
        this.e0 = false;
        this.r0 = new a(this);
        this.s0 = new b(this);
        this.t0 = new c(this);
        this.u0 = new d(this);
        this.v0 = new e(this);
        this.w0 = new f(this, 2001011);
        this.x0 = VideoStatus.INIT;
        this.y0 = false;
        L(context);
    }
}
