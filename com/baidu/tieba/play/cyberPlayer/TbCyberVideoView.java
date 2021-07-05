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
import d.a.r0.r.q.b2;
import d.a.r0.z0.o0;
import d.a.s0.n2.n;
import d.a.s0.n2.o;
import d.a.s0.x1.h;
import d.a.s0.x1.k;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class TbCyberVideoView extends CyberVideoView implements MediaController.MediaPlayerControl {
    public static /* synthetic */ Interceptable $ic;
    public static k v0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean J;
    public String K;
    public String L;
    public boolean M;
    public d.a.s0.n2.p.b N;
    public h O;
    public String P;
    public String Q;
    public PowerManager.WakeLock R;
    public WeakReference<Context> S;
    public boolean T;
    public boolean U;
    public int V;
    public boolean W;
    public boolean a0;
    public int b0;
    public d.a.s0.n2.f c0;
    public boolean i0;
    public CyberPlayerManager.OnPreparedListener j0;
    public CyberPlayerManager.OnCompletionListener k0;
    public CyberPlayerManager.OnSeekCompleteListener l0;
    public CyberPlayerManager.OnErrorListener m0;
    public CyberPlayerManager.OnInfoListener n0;
    public g o0;
    public CyberPlayerManager.OnPreparedListener p0;
    public CyberPlayerManager.OnCompletionListener q0;
    public CyberPlayerManager.OnErrorListener r0;
    public CyberPlayerManager.OnSeekCompleteListener s0;
    public CyberPlayerManager.OnInfoListener t0;
    public final CustomMessageListener u0;

    /* loaded from: classes5.dex */
    public class a implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCyberVideoView f20256e;

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
            this.f20256e = tbCyberVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            int c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f20256e.N != null) {
                    this.f20256e.N.d(this.f20256e.getDuration());
                }
                if (this.f20256e.getVideoMonitor() != null) {
                    this.f20256e.getVideoMonitor().l(ErrorCode.ARGS_ERROR);
                }
                if (!this.f20256e.i0) {
                    if (!ViewCompat.isAttachedToWindow(this.f20256e.getView())) {
                        return;
                    }
                    TbVideoViewSet d2 = TbVideoViewSet.d();
                    TbCyberVideoView tbCyberVideoView = this.f20256e;
                    d2.g(tbCyberVideoView, tbCyberVideoView.L);
                }
                if (this.f20256e.j0 != null) {
                    this.f20256e.j0.onPrepared();
                }
                if (this.f20256e.J && (c2 = n.d().c(this.f20256e.L)) > 0) {
                    this.f20256e.seekTo(c2);
                }
                if (this.f20256e.M) {
                    this.f20256e.start();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCyberVideoView f20257e;

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
            this.f20257e = tbCyberVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f20257e.O != null) {
                    this.f20257e.O.e(this.f20257e.P, this.f20257e.Q);
                    this.f20257e.O = null;
                }
                n.d().e(this.f20257e.L);
                if (this.f20257e.getCyberPlayer().isLooping()) {
                    return;
                }
                if (this.f20257e.N != null) {
                    this.f20257e.N.a();
                }
                this.f20257e.M = false;
                if (this.f20257e.k0 != null) {
                    this.f20257e.k0.onCompletion();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCyberVideoView f20258e;

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
            this.f20258e = tbCyberVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (this.f20258e.getCurrentPosition() > 0 && this.f20258e.L()) {
                    n.d().f(this.f20258e.L, this.f20258e.getCurrentPosition());
                }
                TbVideoViewSet.d().f(this.f20258e.L);
                if (this.f20258e.m0 != null) {
                    this.f20258e.m0.onError(i2, i3, obj);
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCyberVideoView f20259e;

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
            this.f20259e = tbCyberVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20259e.l0 == null) {
                return;
            }
            this.f20259e.l0.onSeekComplete();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements CyberPlayerManager.OnInfoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCyberVideoView f20260e;

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
            this.f20260e = tbCyberVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (this.f20260e.n0 != null) {
                    this.f20260e.n0.onInfo(i2, i3, obj);
                }
                if (this.f20260e.getVideoMonitor() != null && i2 == 10009 && (obj instanceof String)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        this.f20260e.getVideoMonitor().g(jSONObject.optLong("carltonLength"), jSONObject.optInt("carlton_type"));
                    } catch (JSONException unused) {
                    }
                }
                if (i2 != 904 || this.f20260e.N == null) {
                    return true;
                }
                this.f20260e.N.c(this.f20260e);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbCyberVideoView f20261a;

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
            this.f20261a = tbCyberVideoView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f20261a.S();
                if (this.f20261a.O != null) {
                    this.f20261a.O.k(this.f20261a.P, this.f20261a.Q);
                    this.f20261a.O = null;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface g {
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
            v0 = (k) runTask.getData();
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
        this.S = null;
        this.T = false;
        this.U = false;
        this.i0 = false;
        this.p0 = new a(this);
        this.q0 = new b(this);
        this.r0 = new c(this);
        this.s0 = new d(this);
        this.t0 = new e(this);
        this.u0 = new f(this, 2001011);
        I(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h getVideoMonitor() {
        InterceptResult invokeV;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            h hVar = this.O;
            if (hVar != null) {
                return hVar;
            }
            if (!StringUtils.isNull(this.L) && (kVar = v0) != null) {
                this.O = kVar.a(this.K, this.L, null);
            }
            return this.O;
        }
        return (h) invokeV.objValue;
    }

    public final String A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!d.a.c.e.p.k.isEmpty(str) && d.a.s0.v3.f.d().e()) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this == TbVideoViewSet.d().e(this.L) : invokeV.booleanValue;
    }

    public final boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getParent() != null : invokeV.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            H();
            if (getParent() instanceof ViewGroup) {
                ((ViewGroup) getParent()).removeView(this);
            }
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.o0 = null;
            this.k0 = null;
            this.m0 = null;
            this.n0 = null;
            this.j0 = null;
            this.l0 = null;
            this.c0.j(null);
            this.c0.i(null);
            this.c0.k(null);
        }
    }

    public final void I(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            try {
                PowerManager powerManager = (PowerManager) TbadkCoreApplication.getInst().getContext().getSystemService("power");
                if (powerManager != null) {
                    PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(536870922, "TbBVideoView_WakeLock");
                    this.R = newWakeLock;
                    newWakeLock.setReferenceCounted(false);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            this.S = new WeakReference<>(TbadkCoreApplication.getInst());
            super.setOnPreparedListener(this.p0);
            super.setOnCompletionListener(this.q0);
            super.setOnErrorListener(this.r0);
            super.setOnSeekCompleteListener(this.s0);
            super.setOnInfoListener(this.t0);
            this.N = new d.a.s0.n2.p.b();
            this.c0 = new d.a.s0.n2.f();
            SkinManager.setBackgroundResource(this, R.color.black_alpha100);
        }
    }

    public final void J(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, uri) == null) {
            d.a.s0.n2.p.a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
            if (pcdnConfigData != null && pcdnConfigData.c()) {
                if (!pcdnConfigData.a(uri)) {
                    this.b0 = 2;
                    return;
                } else if (d.a.s0.n2.p.c.e() <= 0) {
                    this.b0 = 3;
                    return;
                } else {
                    setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
                    setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                    setOption(CyberPlayerManager.OPT_ENABLE_P2P, pcdnConfigData.b() ? "1" : "0");
                    setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(d.a.s0.n2.p.c.e()));
                    this.W = true;
                    this.a0 = pcdnConfigData.b();
                    this.b0 = 1;
                    return;
                }
            }
            this.b0 = 0;
        }
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.M : invokeV.booleanValue;
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? getCyberPlayer() != null && getCyberPlayer().getDuration() >= getCyberPlayer().getCurrentPosition() : invokeV.booleanValue;
    }

    @Deprecated
    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d.a.s0.n2.p.b bVar = this.N;
            if (bVar != null) {
                bVar.e();
                this.N.d(getDuration());
                this.N.c(this);
            }
            if (getVideoMonitor() != null) {
                getVideoMonitor().a(CyberPlayerManager.hasCacheFile(this.L));
                getVideoMonitor().i(ErrorCode.ARGS_ERROR);
            }
        }
    }

    @Deprecated
    public void N() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || getVideoMonitor() == null) {
            return;
        }
        getVideoMonitor().a(CyberPlayerManager.hasCacheFile(this.L));
        getVideoMonitor().j();
        getVideoMonitor().l(ErrorCode.ARGS_ERROR);
    }

    public void O(long j, long j2, long j3) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) || (hVar = this.O) == null) {
            return;
        }
        hVar.c(j, j2, j3);
    }

    public void P(TbVideoViewSet.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            if (!isPlaying() && !this.M) {
                this.M = true;
                if (bVar != null) {
                    this.U = true;
                    if (!F()) {
                        bVar.b();
                    }
                } else {
                    this.U = false;
                }
                setVideoPath(this.L, this.K);
                return;
            }
            R(bVar);
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20513");
            hashMap.put("click_time", "" + System.currentTimeMillis());
            setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
        }
    }

    public void R(TbVideoViewSet.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            if (bVar != null) {
                this.U = true;
                if (!F()) {
                    bVar.b();
                }
                if (!B()) {
                    bVar.a();
                    this.M = true;
                    setVideoPath(this.L, this.K);
                    return;
                }
            } else {
                this.U = false;
            }
            start();
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (!this.U) {
                stopPlayback();
                return;
            }
            if (this.L != null && isPlaying()) {
                o0.e(this.S, false);
            }
            this.M = false;
            if (isPlaying() && L()) {
                n.d().f(this.L, getCurrentPositionSync());
            }
            try {
                if (this.R != null && this.R.isHeld()) {
                    this.R.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            super.pause();
            d.a.s0.n2.p.b bVar = this.N;
            if (bVar != null) {
                bVar.g();
            }
            this.c0.n();
            h hVar = this.O;
            if (hVar == null || !hVar.d(this.P, this.Q)) {
                return;
            }
            this.O = null;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
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

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public int getCurrentPositionSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (getCyberPlayer() == null) {
                return 0;
            }
            return getCyberPlayer().getCurrentPositionSync();
        }
        return invokeV.intValue;
    }

    public d.a.s0.n2.f getMediaProgressObserver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.c0 : (d.a.s0.n2.f) invokeV.objValue;
    }

    public String getOriginUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.L : (String) invokeV.objValue;
    }

    public int getPcdnState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.b0 : invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.u0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onDetachedFromWindow();
            g gVar = this.o0;
            if (gVar != null) {
                gVar.onSurfaceDestroyed();
            }
            try {
                if (this.R != null && this.R.isHeld()) {
                    this.R.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            MessageManager.getInstance().unRegisterListener(this.u0);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            o0.e(this.S, false);
            if (isPlaying() && L()) {
                n.d().f(this.L, getCurrentPositionSync());
            }
            super.pause();
            d.a.s0.n2.p.b bVar = this.N;
            if (bVar != null) {
                bVar.b();
            }
            try {
                if (this.R != null && this.R.isHeld()) {
                    this.R.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            h hVar = this.O;
            if (hVar != null) {
                hVar.f();
            }
        }
    }

    public void setContinuePlayEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.J = z;
        }
    }

    public void setIsUseInflutter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.i0 = z;
        }
    }

    public void setIsVolume0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.T = z;
        }
    }

    public void setLocateSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.P = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            getCyberPlayer().setLooping(z);
        }
    }

    public void setMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.T = z;
            getCyberPlayer().muteOrUnmuteAudio(z);
            o0.e(this.S, !z);
        }
    }

    public void setNoBussinessStats() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.N = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onCompletionListener) == null) {
            this.k0 = onCompletionListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, onErrorListener) == null) {
            this.m0 = onErrorListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, onInfoListener) == null) {
            this.n0 = onInfoListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, onPreparedListener) == null) {
            this.j0 = onPreparedListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, onSeekCompleteListener) == null) {
            this.l0 = onSeekCompleteListener;
        }
    }

    public void setOnSurfaceDestroyedListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, gVar) == null) {
            this.o0 = gVar;
        }
    }

    public void setPlayMode(String str) {
        d.a.s0.n2.p.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, str) == null) || (bVar = this.N) == null) {
            return;
        }
        bVar.i(str);
    }

    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            if (d.a.c.e.p.k.isEmpty(str)) {
                str = "-1";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20484");
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, str);
            setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.Q = str;
        }
    }

    public void setThreadDataForStatistic(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, b2Var) == null) {
            if (this.N == null) {
                this.N = new d.a.s0.n2.p.b();
            }
            this.N.j(b2Var);
        }
    }

    public void setTryUseViewInSet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.U = z;
        }
    }

    public void setVideoDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.V = i2;
        }
    }

    public void setVideoPath(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048623, this, str, str2) == null) || d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        this.K = str2;
        setVideoPath(str);
    }

    public void setVideoStatData(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, oVar) == null) {
            if (this.N == null) {
                this.N = new d.a.s0.n2.p.b();
            }
            this.N.k(oVar);
            if (oVar != null) {
                this.P = oVar.f64043a;
            }
        }
    }

    public void setVolume(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || getCyberPlayer() == null) {
            return;
        }
        this.T = f2 == 0.0f && f3 == 0.0f;
        getCyberPlayer().setVolume(f2, f3);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            if (!this.T) {
                o0.e(this.S, true);
                setVolume(1.0f, 1.0f);
            }
            this.M = true;
            super.start();
            d.a.s0.n2.p.b bVar = this.N;
            if (bVar != null) {
                bVar.f();
            }
            this.c0.m();
            try {
                if (this.R != null && !this.R.isHeld()) {
                    this.R.acquire();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            if (getVideoMonitor() != null) {
                getVideoMonitor().h(ErrorCode.ARGS_ERROR);
                getVideoMonitor().b(this.W, this.a0);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            if (this.L != null && isPlaying()) {
                o0.e(this.S, false);
            }
            this.M = false;
            if (isPlaying() && L()) {
                n.d().f(this.L, getCurrentPositionSync());
            }
            try {
                if (this.R != null && this.R.isHeld()) {
                    this.R.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            super.stopPlayback();
            TbVideoViewSet.d().f(this.L);
            d.a.s0.n2.p.b bVar = this.N;
            if (bVar != null) {
                bVar.g();
            }
            this.c0.n();
            h hVar = this.O;
            if (hVar == null || !hVar.d(this.P, this.Q)) {
                return;
            }
            this.O = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048622, this, str) == null) || d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        Q();
        this.L = str;
        String A = A(str);
        k kVar = v0;
        if (kVar != null) {
            h a2 = kVar.a(this.K, this.L, null);
            this.O = a2;
            if (a2 != null) {
                a2.a(CyberPlayerManager.hasCacheFile(A));
            }
        }
        this.c0.l(this);
        d.a.s0.n2.p.b bVar = this.N;
        if (bVar != null) {
            bVar.e();
        }
        J(Uri.parse(A));
        h hVar = this.O;
        if (hVar != null) {
            hVar.j();
        }
        String host = Uri.parse(this.L).getHost();
        setOption(CyberPlayerManager.OPT_FEED_VIDEO, ((!StringUtils.isNull(host) && host.contains("tb-video.bdstatic.com")) && (this.V < 900)) ? "1" : "0");
        super.setVideoPath(A);
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
        this.S = null;
        this.T = false;
        this.U = false;
        this.i0 = false;
        this.p0 = new a(this);
        this.q0 = new b(this);
        this.r0 = new c(this);
        this.s0 = new d(this);
        this.t0 = new e(this);
        this.u0 = new f(this, 2001011);
        I(context);
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
        this.S = null;
        this.T = false;
        this.U = false;
        this.i0 = false;
        this.p0 = new a(this);
        this.q0 = new b(this);
        this.r0 = new c(this);
        this.s0 = new d(this);
        this.t0 = new e(this);
        this.u0 = new f(this, 2001011);
        I(context);
    }
}
