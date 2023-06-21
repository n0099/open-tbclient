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
import com.baidu.tieba.a9a;
import com.baidu.tieba.cy5;
import com.baidu.tieba.fk9;
import com.baidu.tieba.gk9;
import com.baidu.tieba.hk9;
import com.baidu.tieba.ik9;
import com.baidu.tieba.jk9;
import com.baidu.tieba.kk9;
import com.baidu.tieba.lk9;
import com.baidu.tieba.mk9;
import com.baidu.tieba.ny8;
import com.baidu.tieba.play.OnStatusChangedListener;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.qj9;
import com.baidu.tieba.qy8;
import com.baidu.tieba.rj9;
import com.baidu.tieba.sj9;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class TbCyberVideoView extends CyberVideoView implements rj9 {
    public static /* synthetic */ Interceptable $ic;
    public static qy8 B0;
    public transient /* synthetic */ FieldHolder $fh;
    public OnStatusChangedListener A0;
    public boolean N;
    public String O;
    public String P;
    public boolean Q;
    public boolean R;
    public kk9 S;

    /* renamed from: T  reason: collision with root package name */
    public ny8 f1161T;
    public String U;
    public String V;
    public PowerManager.WakeLock W;
    public WeakReference<Context> a0;
    public boolean b0;
    public boolean c0;
    public boolean d0;
    public boolean e0;
    public int f0;
    public sj9 g0;
    public boolean h0;
    public jk9 i0;
    public mk9 j0;
    public TbVideoViewContainer.a r0;
    public boolean s0;
    public CyberPlayerManager.OnPreparedListener t0;
    public CyberPlayerManager.OnCompletionListener u0;
    public CyberPlayerManager.OnErrorListener v0;
    public CyberPlayerManager.OnSeekCompleteListener w0;
    public CyberPlayerManager.OnInfoListener x0;
    public final CustomMessageListener y0;
    public OnStatusChangedListener.VideoStatus z0;

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

    public void setCanShowPause(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
        }
    }

    public void setVideoModel(fk9 fk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, fk9Var) == null) {
        }
    }

    /* loaded from: classes7.dex */
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
                if (this.a.S != null) {
                    this.a.S.g(this.a.getDuration());
                }
                this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_PREPARED);
                if (this.a.getVideoMonitor() != null) {
                    this.a.getVideoMonitor().l(-400);
                }
                if (!this.a.h0) {
                    if (!ViewCompat.isAttachedToWindow(this.a.getView())) {
                        return;
                    }
                    if (!this.a.R && (this.a.getParent() instanceof TbVideoViewContainer)) {
                        TbVideoViewSet.c().f((TbVideoViewContainer) this.a.getParent(), this.a.P);
                    }
                }
                if (this.a.j0 != null) {
                    this.a.j0.onPrepared();
                }
                if (this.a.N && (c = gk9.d().c(this.a.P)) > 0) {
                    this.a.seekTo(c);
                }
                if (!this.a.Q) {
                    return;
                }
                boolean z = this.a.R;
                this.a.start();
                this.a.R = z;
                if (this.a.R) {
                    this.a.setVolume(0.0f, 0.0f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
                if (this.a.f1161T != null) {
                    this.a.f1161T.e(this.a.U, this.a.V);
                    this.a.f1161T = null;
                }
                this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_COMPLETE);
                gk9.d().e(this.a.P);
                if (this.a.getCyberPlayer().isLooping()) {
                    return;
                }
                if (this.a.S != null) {
                    this.a.S.j();
                }
                this.a.Q = false;
                if (this.a.j0 != null) {
                    this.a.j0.onCompletion();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
                    gk9.d().update(this.a.P, this.a.getCurrentPosition());
                }
                TbVideoViewSet.c().e(this.a.P);
                if (this.a.j0 != null) {
                    this.a.j0.onError(i, i2, obj);
                    return true;
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.j0 != null) {
                this.a.j0.onSeekComplete();
            }
        }
    }

    /* loaded from: classes7.dex */
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
                if (this.a.j0 != null) {
                    this.a.j0.onInfo(i, i2, obj);
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
                    if (this.a.z0 != OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER) {
                        this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_PLAYING);
                    } else {
                        this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY);
                    }
                }
                if (i == 904 && this.a.S != null) {
                    this.a.S.f(this.a);
                    return true;
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
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
                if (this.a.f1161T != null) {
                    this.a.f1161T.k(this.a.U, this.a.V);
                    this.a.f1161T = null;
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, qy8.class);
        if (runTask != null) {
            B0 = (qy8) runTask.getData();
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

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDetachedFromWindow();
            TbVideoViewContainer.a aVar = this.r0;
            if (aVar != null) {
                aVar.onSurfaceDestroyed();
            }
            try {
                if (this.W != null && this.W.isHeld()) {
                    this.W.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            B();
            MessageManager.getInstance().unRegisterListener(this.y0);
        }
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
        this.a0 = null;
        this.b0 = false;
        this.c0 = false;
        this.h0 = false;
        this.t0 = new a(this);
        this.u0 = new b(this);
        this.v0 = new c(this);
        this.w0 = new d(this);
        this.x0 = new e(this);
        this.y0 = new f(this, 2001011);
        this.z0 = OnStatusChangedListener.VideoStatus.INIT;
        C(context);
    }

    public final void C(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            try {
                PowerManager powerManager = (PowerManager) TbadkCoreApplication.getInst().getContext().getSystemService("power");
                if (powerManager != null) {
                    PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(536870922, "TbBVideoView_WakeLock");
                    this.W = newWakeLock;
                    newWakeLock.setReferenceCounted(false);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            this.a0 = new WeakReference<>(TbadkCoreApplication.getInst());
            super.setOnPreparedListener(this.t0);
            super.setOnCompletionListener(this.u0);
            super.setOnErrorListener(this.v0);
            super.setOnSeekCompleteListener(this.w0);
            super.setOnInfoListener(this.x0);
            this.S = new kk9();
            this.g0 = new sj9();
            SkinManager.setBackgroundResource(this, R.color.black_alpha100);
        }
    }

    public final void D(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, uri) == null) {
            super.stopPlayback();
            setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
            ik9 pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
            if (pcdnConfigData != null && pcdnConfigData.c()) {
                if (!pcdnConfigData.a(uri)) {
                    this.f0 = 2;
                    return;
                } else if (lk9.e() != 0 && lk9.e() != -1) {
                    String str = "1";
                    setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                    if (!pcdnConfigData.b()) {
                        str = "0";
                    }
                    setOption(CyberPlayerManager.OPT_ENABLE_P2P, str);
                    setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(lk9.e()));
                    this.d0 = true;
                    this.e0 = pcdnConfigData.b();
                    this.f0 = 1;
                    return;
                } else {
                    this.f0 = 3;
                    return;
                }
            }
            this.f0 = 0;
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
        this.a0 = null;
        this.b0 = false;
        this.c0 = false;
        this.h0 = false;
        this.t0 = new a(this);
        this.u0 = new b(this);
        this.v0 = new c(this);
        this.w0 = new d(this);
        this.x0 = new e(this);
        this.y0 = new f(this, 2001011);
        this.z0 = OnStatusChangedListener.VideoStatus.INIT;
        C(context);
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
        this.a0 = null;
        this.b0 = false;
        this.c0 = false;
        this.h0 = false;
        this.t0 = new a(this);
        this.u0 = new b(this);
        this.v0 = new c(this);
        this.w0 = new d(this);
        this.x0 = new e(this);
        this.y0 = new f(this, 2001011);
        this.z0 = OnStatusChangedListener.VideoStatus.INIT;
        C(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ny8 getVideoMonitor() {
        InterceptResult invokeV;
        qy8 qy8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            ny8 ny8Var = this.f1161T;
            if (ny8Var != null) {
                return ny8Var;
            }
            if (!StringUtils.isNull(this.P) && (qy8Var = B0) != null) {
                this.f1161T = qy8Var.a(this.O, this.P, null);
            }
            return this.f1161T;
        }
        return (ny8) invokeV.objValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.r0 = null;
            this.A0 = null;
            this.j0 = null;
            this.g0.j(null);
            this.g0.i(null);
            this.g0.k(null);
        }
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (getCyberPlayer() != null && getCyberPlayer().getDuration() >= getCyberPlayer().getCurrentPosition()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            OnStatusChangedListener.VideoStatus videoStatus = this.z0;
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY);
            } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_ERROR);
            } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.tieba.rj9
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

    public sj9 getMediaProgressObserver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.g0;
        }
        return (sj9) invokeV.objValue;
    }

    public String getOriginUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.P;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rj9
    public int getPcdnState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.f0;
        }
        return invokeV.intValue;
    }

    public qj9 getPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.i0 == null) {
                this.i0 = new jk9(getCyberPlayer());
            }
            return this.i0;
        }
        return (qj9) invokeV.objValue;
    }

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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return J(this.z0);
        }
        return (OnStatusChangedListener.VideoStatus) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.y0);
        }
    }

    public void setNoBussinessStats() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.S = null;
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
            if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER) {
                return OnStatusChangedListener.VideoStatus.VIDEO_BUFFERING;
            }
            return videoStatus;
        }
        return (OnStatusChangedListener.VideoStatus) invokeL.objValue;
    }

    public void setContinuePlayEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.N = z;
        }
    }

    public void setIsVolume0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.b0 = z;
        }
    }

    public void setLocateSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.U = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            getCyberPlayer().setLooping(z);
        }
    }

    @Override // com.baidu.tieba.rj9
    public void setOnSurfaceDestroyedListener(TbVideoViewContainer.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, aVar) == null) {
            this.r0 = aVar;
        }
    }

    @Override // com.baidu.tieba.rj9
    public void setOperableVideoContainer(mk9 mk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, mk9Var) == null) {
            this.j0 = mk9Var;
        }
    }

    @Override // com.baidu.tieba.rj9
    public void setPlayMode(String str) {
        kk9 kk9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048611, this, str) == null) && (kk9Var = this.S) != null) {
            kk9Var.l(str);
        }
    }

    @Override // com.baidu.tieba.rj9
    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            if (vi.isEmpty(str)) {
                str = "-1";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20484");
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, str);
            setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.V = str;
        }
    }

    public void setThreadDataForStatistic(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, threadData) == null) {
            if (this.S == null) {
                this.S = new kk9();
            }
            this.S.n(threadData);
        }
    }

    public void setTryUseViewInSet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.c0 = z;
        }
    }

    @Override // com.baidu.tieba.rj9
    public void setVideoStatData(hk9 hk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, hk9Var) == null) {
            if (this.S == null) {
                this.S = new kk9();
            }
            this.S.p(hk9Var);
            if (hk9Var != null) {
                this.U = hk9Var.a;
            }
        }
    }

    public void setVideoStatusChangeListener(OnStatusChangedListener onStatusChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, onStatusChangedListener) == null) {
            this.A0 = onStatusChangedListener;
        }
    }

    @Override // com.baidu.tieba.rj9
    public void setVideoPath(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048617, this, str, str2) != null) || vi.isEmpty(str)) {
            return;
        }
        this.O = str2;
        setVideoPath(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoStatus(OnStatusChangedListener.VideoStatus videoStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, videoStatus) == null) {
            OnStatusChangedListener onStatusChangedListener = this.A0;
            if (onStatusChangedListener != null) {
                if (this.s0) {
                    onStatusChangedListener.onStatusChange(videoStatus);
                } else {
                    onStatusChangedListener.onStatusChange(J(videoStatus));
                }
            }
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                if (this.R) {
                    F();
                    this.R = false;
                } else if (!this.b0) {
                    setVolume(1.0f, 1.0f);
                }
            }
            this.z0 = videoStatus;
        }
    }

    public final String A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (vi.isEmpty(str)) {
                return str;
            }
            if (a9a.c().d()) {
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

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (isPlaying() && E()) {
                gk9.d().update(this.P, getCurrentPositionSync());
            }
            this.Q = false;
            super.pause();
            H();
            kk9 kk9Var = this.S;
            if (kk9Var != null) {
                kk9Var.e();
            }
            try {
                if (this.W != null && this.W.isHeld()) {
                    this.W.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            ny8 ny8Var = this.f1161T;
            if (ny8Var != null) {
                ny8Var.f();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            cy5.e(this.a0, false);
            if (isPlaying() && E()) {
                gk9.d().update(this.P, getCurrentPositionSync());
            }
            this.Q = false;
            super.pause();
            H();
            kk9 kk9Var = this.S;
            if (kk9Var != null) {
                kk9Var.e();
            }
            try {
                if (this.W != null && this.W.isHeld()) {
                    this.W.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            ny8 ny8Var = this.f1161T;
            if (ny8Var != null) {
                ny8Var.f();
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!this.c0) {
                stopPlayback();
                return;
            }
            if (this.P != null && isPlaying()) {
                cy5.e(this.a0, false);
            }
            this.Q = false;
            if (isPlaying() && E()) {
                gk9.d().update(this.P, getCurrentPositionSync());
            }
            try {
                if (this.W != null && this.W.isHeld()) {
                    this.W.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            super.pause();
            H();
            kk9 kk9Var = this.S;
            if (kk9Var != null) {
                kk9Var.j();
            }
            this.g0.n();
            ny8 ny8Var = this.f1161T;
            if (ny8Var != null && ny8Var.d(this.U, this.V)) {
                this.f1161T = null;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (!this.b0) {
                cy5.e(this.a0, true);
                setVolume(1.0f, 1.0f);
            }
            this.Q = true;
            this.R = false;
            super.start();
            if (this.z0 == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_PLAYING);
            }
            if (this.z0 == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_ERROR) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR);
            }
            if (this.z0 == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER);
            }
            kk9 kk9Var = this.S;
            if (kk9Var != null) {
                kk9Var.i();
            }
            this.g0.m();
            try {
                if (this.W != null && !this.W.isHeld()) {
                    this.W.acquire();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            if (getVideoMonitor() != null) {
                getVideoMonitor().h(-400);
                getVideoMonitor().c(this.d0, this.e0);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (this.P != null && isPlaying()) {
                cy5.e(this.a0, false);
            }
            this.Q = false;
            if (isPlaying() && E()) {
                gk9.d().update(this.P, getCurrentPositionSync());
            }
            try {
                if (this.W != null && this.W.isHeld()) {
                    this.W.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            super.stopPlayback();
            TbVideoViewSet.c().e(this.P);
            kk9 kk9Var = this.S;
            if (kk9Var != null) {
                kk9Var.j();
            }
            this.g0.n();
            ny8 ny8Var = this.f1161T;
            if (ny8Var != null && ny8Var.d(this.U, this.V)) {
                this.f1161T = null;
            }
        }
    }

    @Override // com.baidu.tieba.rj9
    public void a(long j, long j2, long j3) {
        ny8 ny8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) && (ny8Var = this.f1161T) != null) {
            ny8Var.a(j, j2, j3);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048616, this, str) != null) || vi.isEmpty(str)) {
            return;
        }
        G();
        if (!UbsABTestHelper.isVideoSetUrlAgainABTest() && vi.isEquals(this.P, str)) {
            return;
        }
        this.P = str;
        String A = A(str);
        qy8 qy8Var = B0;
        if (qy8Var != null) {
            ny8 a2 = qy8Var.a(this.O, this.P, null);
            this.f1161T = a2;
            if (a2 != null) {
                a2.b(CyberPlayerManager.hasCacheFile(A));
            }
        }
        this.g0.l(this);
        kk9 kk9Var = this.S;
        if (kk9Var != null) {
            kk9Var.h();
        }
        D(Uri.parse(A));
        ny8 ny8Var = this.f1161T;
        if (ny8Var != null) {
            ny8Var.j();
        }
        super.setVideoPath(A);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.tieba.rj9
    public void setVolume(float f2, float f3) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) && getCyberPlayer() != null) {
            if (f2 == 0.0f && f3 == 0.0f) {
                z = true;
            } else {
                z = false;
            }
            this.b0 = z;
            getCyberPlayer().setVolume(f2, f3);
        }
    }
}
