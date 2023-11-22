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
import com.baidu.tbadk.util.VideoAudioHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.f9a;
import com.baidu.tieba.g9a;
import com.baidu.tieba.h9a;
import com.baidu.tieba.i9a;
import com.baidu.tieba.j9a;
import com.baidu.tieba.k9a;
import com.baidu.tieba.l9a;
import com.baidu.tieba.ml9;
import com.baidu.tieba.p1b;
import com.baidu.tieba.pl9;
import com.baidu.tieba.play.OnStatusChangedListener;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.VideoPostionCacheManager;
import com.baidu.tieba.q8a;
import com.baidu.tieba.qd;
import com.baidu.tieba.r8a;
import com.baidu.tieba.s8a;
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
public class TbCyberVideoView extends CyberVideoView implements r8a {
    public static /* synthetic */ Interceptable $ic;
    public static pl9 E;
    public transient /* synthetic */ FieldHolder $fh;
    public CyberPlayerManager.OnInfoListener A;
    public final CustomMessageListener B;
    public OnStatusChangedListener.VideoStatus C;
    public OnStatusChangedListener D;
    public boolean a;
    public String b;
    public String c;
    public boolean d;
    public boolean e;
    public j9a f;
    public ml9 g;
    public String h;
    public String i;
    public PowerManager.WakeLock j;
    public WeakReference<Context> k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;
    public s8a q;
    public boolean r;
    public i9a s;
    public l9a t;
    public TbVideoViewContainer.a u;
    public boolean v;
    public CyberPlayerManager.OnPreparedListener w;
    public CyberPlayerManager.OnCompletionListener x;
    public CyberPlayerManager.OnErrorListener y;
    public CyberPlayerManager.OnSeekCompleteListener z;

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public void setCanShowPause(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
        }
    }

    public void setVideoModel(f9a f9aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, f9aVar) == null) {
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
            int cachePosition;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f != null) {
                    this.a.f.g(this.a.getDuration());
                }
                this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_PREPARED);
                if (this.a.getVideoMonitor() != null) {
                    this.a.getVideoMonitor().l(-400);
                }
                if (!this.a.r) {
                    if (!ViewCompat.isAttachedToWindow(this.a.getView())) {
                        return;
                    }
                    if (!this.a.e && (this.a.getParent() instanceof TbVideoViewContainer)) {
                        TbVideoViewSet.c().f((TbVideoViewContainer) this.a.getParent(), this.a.c);
                    }
                }
                if (this.a.t != null) {
                    this.a.t.onPrepared();
                }
                if (this.a.a && (cachePosition = VideoPostionCacheManager.getInstance().getCachePosition(this.a.c)) > 0) {
                    this.a.seekTo(cachePosition);
                }
                if (!this.a.d) {
                    return;
                }
                boolean z = this.a.e;
                this.a.start();
                this.a.e = z;
                if (this.a.e) {
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
                if (this.a.g != null) {
                    this.a.g.e(this.a.h, this.a.i);
                    this.a.g = null;
                }
                this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_COMPLETE);
                VideoPostionCacheManager.getInstance().remove(this.a.c);
                if (this.a.getCyberPlayer().isLooping()) {
                    return;
                }
                if (this.a.f != null) {
                    this.a.f.j();
                }
                this.a.d = false;
                if (this.a.t != null) {
                    this.a.t.onCompletion();
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
                if (this.a.getCurrentPosition() > 0 && this.a.w()) {
                    VideoPostionCacheManager.getInstance().update(this.a.c, this.a.getCurrentPosition());
                }
                TbVideoViewSet.c().e(this.a.c);
                if (this.a.t != null) {
                    this.a.t.onError(i, i2, obj);
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.t != null) {
                this.a.t.onSeekComplete();
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
                if (this.a.t != null) {
                    this.a.t.onInfo(i, i2, obj);
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
                    if (this.a.C != OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER) {
                        this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_PLAYING);
                    } else {
                        this.a.setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY);
                    }
                }
                if (i == 904 && this.a.f != null) {
                    this.a.f.f(this.a);
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
                this.a.A();
                if (this.a.g != null) {
                    this.a.g.k(this.a.h, this.a.i);
                    this.a.g = null;
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, pl9.class);
        if (runTask != null) {
            E = (pl9) runTask.getData();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDetachedFromWindow();
            TbVideoViewContainer.a aVar = this.u;
            if (aVar != null) {
                aVar.onSurfaceDestroyed();
            }
            try {
                if (this.j != null && this.j.isHeld()) {
                    this.j.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            t();
            MessageManager.getInstance().unRegisterListener(this.B);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20513");
            hashMap.put("click_time", "" + System.currentTimeMillis());
            setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
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
        this.k = null;
        this.l = false;
        this.m = false;
        this.r = false;
        this.w = new a(this);
        this.x = new b(this);
        this.y = new c(this);
        this.z = new d(this);
        this.A = new e(this);
        this.B = new f(this, 2001011);
        this.C = OnStatusChangedListener.VideoStatus.INIT;
        u(context);
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, context) == null) {
            try {
                PowerManager powerManager = (PowerManager) TbadkCoreApplication.getInst().getContext().getSystemService("power");
                if (powerManager != null) {
                    PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(536870922, "TbBVideoView_WakeLock");
                    this.j = newWakeLock;
                    newWakeLock.setReferenceCounted(false);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            this.k = new WeakReference<>(TbadkCoreApplication.getInst());
            super.setOnPreparedListener(this.w);
            super.setOnCompletionListener(this.x);
            super.setOnErrorListener(this.y);
            super.setOnSeekCompleteListener(this.z);
            super.setOnInfoListener(this.A);
            this.f = new j9a();
            this.q = new s8a();
            SkinManager.setBackgroundResource(this, R.color.black_alpha100);
        }
    }

    public final void v(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, uri) == null) {
            super.stopPlayback();
            setOption(CyberPlayerManager.OPT_PCDN_TYPE, "2014");
            h9a pcdnConfigData = TbSingleton.getInstance().getPcdnConfigData();
            if (pcdnConfigData != null && pcdnConfigData.c()) {
                if (!pcdnConfigData.a(uri)) {
                    this.p = 2;
                    return;
                } else if (k9a.e() != 0 && k9a.e() != -1) {
                    String str = "1";
                    setOption(CyberPlayerManager.OPT_ENABLE_PCDN, "1");
                    if (!pcdnConfigData.b()) {
                        str = "0";
                    }
                    setOption(CyberPlayerManager.OPT_ENABLE_P2P, str);
                    setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(k9a.e()));
                    this.n = true;
                    this.o = pcdnConfigData.b();
                    this.p = 1;
                    return;
                } else {
                    this.p = 3;
                    return;
                }
            }
            this.p = 0;
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
        this.k = null;
        this.l = false;
        this.m = false;
        this.r = false;
        this.w = new a(this);
        this.x = new b(this);
        this.y = new c(this);
        this.z = new d(this);
        this.A = new e(this);
        this.B = new f(this, 2001011);
        this.C = OnStatusChangedListener.VideoStatus.INIT;
        u(context);
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
        this.k = null;
        this.l = false;
        this.m = false;
        this.r = false;
        this.w = new a(this);
        this.x = new b(this);
        this.y = new c(this);
        this.z = new d(this);
        this.A = new e(this);
        this.B = new f(this, 2001011);
        this.C = OnStatusChangedListener.VideoStatus.INIT;
        u(context);
    }

    public final OnStatusChangedListener.VideoStatus B(OnStatusChangedListener.VideoStatus videoStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoStatus)) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.a = z;
        }
    }

    public void setIsVolume0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.l = z;
        }
    }

    public void setLocateSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.h = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            getCyberPlayer().setLooping(z);
        }
    }

    @Override // com.baidu.tieba.r8a
    public void setOnSurfaceDestroyedListener(TbVideoViewContainer.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, aVar) == null) {
            this.u = aVar;
        }
    }

    @Override // com.baidu.tieba.r8a
    public void setOperableVideoContainer(l9a l9aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, l9aVar) == null) {
            this.t = l9aVar;
        }
    }

    @Override // com.baidu.tieba.r8a
    public void setPlayMode(String str) {
        j9a j9aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, str) == null) && (j9aVar = this.f) != null) {
            j9aVar.l(str);
        }
    }

    @Override // com.baidu.tieba.r8a
    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            if (qd.isEmpty(str)) {
                str = "-1";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", "20484");
            hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, str);
            setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
            this.i = str;
        }
    }

    public void setThreadDataForStatistic(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, threadData) == null) {
            if (this.f == null) {
                this.f = new j9a();
            }
            this.f.n(threadData);
        }
    }

    public void setTryUseViewInSet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.m = z;
        }
    }

    @Override // com.baidu.tieba.r8a
    public void setVideoStatData(g9a g9aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, g9aVar) == null) {
            if (this.f == null) {
                this.f = new j9a();
            }
            this.f.p(g9aVar);
            if (g9aVar != null) {
                this.h = g9aVar.a;
            }
        }
    }

    public void setVideoStatusChangeListener(OnStatusChangedListener onStatusChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, onStatusChangedListener) == null) {
            this.D = onStatusChangedListener;
        }
    }

    @Override // com.baidu.tieba.r8a
    public void setVideoPath(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048610, this, str, str2) != null) || qd.isEmpty(str)) {
            return;
        }
        this.b = str2;
        setVideoPath(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ml9 getVideoMonitor() {
        InterceptResult invokeV;
        pl9 pl9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            ml9 ml9Var = this.g;
            if (ml9Var != null) {
                return ml9Var;
            }
            if (!StringUtils.isNull(this.c) && (pl9Var = E) != null) {
                this.g = pl9Var.a(this.b, this.c, null);
            }
            return this.g;
        }
        return (ml9) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.tieba.r8a
    public int getCurrentPositionSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (getCyberPlayer() == null) {
                return 0;
            }
            return getCyberPlayer().getCurrentPositionSync();
        }
        return invokeV.intValue;
    }

    public s8a getMediaProgressObserver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.q;
        }
        return (s8a) invokeV.objValue;
    }

    public String getOriginUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r8a
    public int getPcdnState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public q8a getPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.s == null) {
                this.s = new i9a(getCyberPlayer());
            }
            return this.s;
        }
        return (q8a) invokeV.objValue;
    }

    public int getPlayerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return B(this.C);
        }
        return (OnStatusChangedListener.VideoStatus) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.B);
        }
    }

    public void setNoBussinessStats() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f = null;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.u = null;
            this.D = null;
            this.t = null;
            this.q.j(null);
            this.q.i(null);
            this.q.k(null);
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (getCyberPlayer() != null && getCyberPlayer().getDuration() >= getCyberPlayer().getCurrentPosition()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            OnStatusChangedListener.VideoStatus videoStatus = this.C;
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY);
            } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_ERROR);
            } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoStatus(OnStatusChangedListener.VideoStatus videoStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, videoStatus) == null) {
            OnStatusChangedListener onStatusChangedListener = this.D;
            if (onStatusChangedListener != null) {
                if (this.v) {
                    onStatusChangedListener.onStatusChange(videoStatus);
                } else {
                    onStatusChangedListener.onStatusChange(B(videoStatus));
                }
            }
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                if (this.e) {
                    x();
                    this.e = false;
                } else if (!this.l) {
                    setVolume(1.0f, 1.0f);
                }
            }
            this.C = videoStatus;
        }
    }

    public final String s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (qd.isEmpty(str)) {
                return str;
            }
            if (p1b.c().d()) {
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

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.m) {
                stopPlayback();
                return;
            }
            if (this.c != null && isPlaying()) {
                VideoAudioHelper.muteAudioFocus(this.k, false);
            }
            this.d = false;
            if (isPlaying() && w()) {
                VideoPostionCacheManager.getInstance().update(this.c, getCurrentPositionSync());
            }
            try {
                if (this.j != null && this.j.isHeld()) {
                    this.j.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            super.pause();
            z();
            j9a j9aVar = this.f;
            if (j9aVar != null) {
                j9aVar.j();
            }
            this.q.n();
            ml9 ml9Var = this.g;
            if (ml9Var != null && ml9Var.d(this.h, this.i)) {
                this.g = null;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            if (!this.l) {
                VideoAudioHelper.muteAudioFocus(this.k, true);
                setVolume(1.0f, 1.0f);
            }
            this.d = true;
            this.e = false;
            super.start();
            if (this.C == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_PLAY) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.VIDEO_PLAYING);
            }
            if (this.C == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_ERROR) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR);
            }
            if (this.C == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_PAUSING_BUFFER) {
                setVideoStatus(OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER);
            }
            j9a j9aVar = this.f;
            if (j9aVar != null) {
                j9aVar.i();
            }
            this.q.m();
            try {
                if (this.j != null && !this.j.isHeld()) {
                    this.j.acquire();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            if (getVideoMonitor() != null) {
                getVideoMonitor().h(-400);
                getVideoMonitor().c(this.n, this.o);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (this.c != null && isPlaying()) {
                VideoAudioHelper.muteAudioFocus(this.k, false);
            }
            this.d = false;
            if (isPlaying() && w()) {
                VideoPostionCacheManager.getInstance().update(this.c, getCurrentPositionSync());
            }
            try {
                if (this.j != null && this.j.isHeld()) {
                    this.j.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            super.stopPlayback();
            TbVideoViewSet.c().e(this.c);
            j9a j9aVar = this.f;
            if (j9aVar != null) {
                j9aVar.j();
            }
            this.q.n();
            ml9 ml9Var = this.g;
            if (ml9Var != null && ml9Var.d(this.h, this.i)) {
                this.g = null;
            }
        }
    }

    @Override // com.baidu.tieba.r8a
    public void a(long j, long j2, long j3) {
        ml9 ml9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) && (ml9Var = this.g) != null) {
            ml9Var.a(j, j2, j3);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            VideoAudioHelper.muteAudioFocus(this.k, false);
            if (isPlaying() && w()) {
                VideoPostionCacheManager.getInstance().update(this.c, getCurrentPositionSync());
            }
            this.d = false;
            super.pause();
            z();
            j9a j9aVar = this.f;
            if (j9aVar != null) {
                j9aVar.e();
            }
            try {
                if (this.j != null && this.j.isHeld()) {
                    this.j.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            ml9 ml9Var = this.g;
            if (ml9Var != null) {
                ml9Var.f();
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            if (isPlaying() && w()) {
                VideoPostionCacheManager.getInstance().update(this.c, getCurrentPositionSync());
            }
            this.d = false;
            super.pause();
            z();
            j9a j9aVar = this.f;
            if (j9aVar != null) {
                j9aVar.e();
            }
            try {
                if (this.j != null && this.j.isHeld()) {
                    this.j.release();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            ml9 ml9Var = this.g;
            if (ml9Var != null) {
                ml9Var.f();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048609, this, str) != null) || qd.isEmpty(str)) {
            return;
        }
        y();
        if (!UbsABTestHelper.isVideoSetUrlAgainABTest() && qd.isEquals(this.c, str)) {
            return;
        }
        this.c = str;
        String s = s(str);
        pl9 pl9Var = E;
        if (pl9Var != null) {
            ml9 a2 = pl9Var.a(this.b, this.c, null);
            this.g = a2;
            if (a2 != null) {
                a2.b(CyberPlayerManager.hasCacheFile(s));
            }
        }
        this.q.l(this);
        j9a j9aVar = this.f;
        if (j9aVar != null) {
            j9aVar.h();
        }
        v(Uri.parse(s));
        ml9 ml9Var = this.g;
        if (ml9Var != null) {
            ml9Var.j();
        }
        super.setVideoPath(s);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.tieba.r8a
    public void setVolume(float f2, float f3) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) && getCyberPlayer() != null) {
            if (f2 == 0.0f && f3 == 0.0f) {
                z = true;
            } else {
                z = false;
            }
            this.l = z;
            getCyberPlayer().setVolume(f2, f3);
        }
    }
}
