package com.baidu.tieba.medialive.player.bdrtc;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.RTCVideoView;
import com.baidu.rtc.player.BRTCPlayer;
import com.baidu.rtc.player.BRTCPlayerEvents;
import com.baidu.rtc.player.BRTCPlayerImpl;
import com.baidu.rtc.player.BRTCPlayerParameters;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.live.interfaces.player.BuildParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.c0.f;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class TbBRTCPlayerView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public static final boolean s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RTCVideoView f18458e;

    /* renamed from: f  reason: collision with root package name */
    public String f18459f;

    /* renamed from: g  reason: collision with root package name */
    public BRTCPlayerParameters f18460g;

    /* renamed from: h  reason: collision with root package name */
    public BRTCPlayer f18461h;

    /* renamed from: i  reason: collision with root package name */
    public RTCVideoView.ScalingType f18462i;
    public int j;
    public int k;
    public ViewGroup l;
    public BRTCPlayerEvents m;
    public HashMap<Integer, String> n;
    public int o;
    public BuildParams p;
    public BRTCPlayerEvents q;

    /* loaded from: classes5.dex */
    public class a implements BRTCPlayerEvents {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbBRTCPlayerView f18463a;

        /* renamed from: com.baidu.tieba.medialive.player.bdrtc.TbBRTCPlayerView$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0215a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f18464e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f18465f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f18466g;

            public RunnableC0215a(a aVar, int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18466g = aVar;
                this.f18464e = i2;
                this.f18465f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Context context = this.f18466g.f18463a.getContext();
                    Toast.makeText(context, this.f18464e + ": " + this.f18465f, 1).show();
                }
            }
        }

        public a(TbBRTCPlayerView tbBRTCPlayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbBRTCPlayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18463a = tbBRTCPlayerView;
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f18463a.o = i2;
                if (TbBRTCPlayerView.r) {
                    TbBRTCPlayerView tbBRTCPlayerView = this.f18463a;
                    tbBRTCPlayerView.g("onError  : errCode" + i2 + " errMsg: " + str);
                }
                if (this.f18463a.m != null) {
                    if (TbBRTCPlayerView.r) {
                        f.b(new RunnableC0215a(this, i2, str));
                    }
                    this.f18463a.m.onError(i2, str);
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onFirstFrameRendered() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f18463a.o = 0;
                if (TbBRTCPlayerView.r) {
                    this.f18463a.g("onFirstFrameRendered ...");
                }
                if (this.f18463a.m != null) {
                    this.f18463a.m.onFirstFrameRendered();
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onInfoUpdated(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
                if (TbBRTCPlayerView.s) {
                    TbBRTCPlayerView tbBRTCPlayerView = this.f18463a;
                    tbBRTCPlayerView.g("onInfoUpdated  : " + i2 + " s " + str);
                }
                if (this.f18463a.m != null) {
                    this.f18463a.m.onInfoUpdated(i2, str);
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onPlayerStateChanged(BRTCPlayer.PlayerState playerState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, playerState) == null) {
                if (TbBRTCPlayerView.r) {
                    TbBRTCPlayerView tbBRTCPlayerView = this.f18463a;
                    tbBRTCPlayerView.g("Player state changed  to " + playerState.toString());
                }
                if (this.f18463a.m != null) {
                    this.f18463a.m.onPlayerStateChanged(playerState);
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onRemoteData(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, byteBuffer) == null) {
                if (TbBRTCPlayerView.r) {
                    this.f18463a.g("onRemoteData  received!");
                }
                if (this.f18463a.m != null) {
                    this.f18463a.m.onRemoteData(byteBuffer);
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onRemoteStreamStats(Boolean bool, Boolean bool2, BigInteger bigInteger) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, bool, bool2, bigInteger) == null) {
                if (TbBRTCPlayerView.r) {
                    TbBRTCPlayerView tbBRTCPlayerView = this.f18463a;
                    tbBRTCPlayerView.g("onRemoteStreamStats  video:" + bool + " audio:" + bool2);
                }
                if (this.f18463a.m != null) {
                    this.f18463a.m.onRemoteStreamStats(bool, bool2, bigInteger);
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onResolutionChanged(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
                if (TbBRTCPlayerView.r) {
                    TbBRTCPlayerView tbBRTCPlayerView = this.f18463a;
                    tbBRTCPlayerView.g("onResolutionChanged  : " + i2 + " x " + i3);
                }
                TbBRTCPlayerView tbBRTCPlayerView2 = this.f18463a;
                tbBRTCPlayerView2.j = i2;
                tbBRTCPlayerView2.k = i3;
                if (tbBRTCPlayerView2.m != null) {
                    this.f18463a.m.onResolutionChanged(i2, i3);
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onSEIRecv(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, byteBuffer) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(612108759, "Lcom/baidu/tieba/medialive/player/bdrtc/TbBRTCPlayerView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(612108759, "Lcom/baidu/tieba/medialive/player/bdrtc/TbBRTCPlayerView;");
                return;
            }
        }
        r = AppConfig.isDebug();
        s = AppConfig.isDebug();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbBRTCPlayerView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f18462i = RTCVideoView.ScalingType.SCALE_ASPECT_FIT;
        this.o = 0;
        this.q = new a(this);
    }

    private BRTCPlayer.PlayerState getPlayerState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            BRTCPlayer bRTCPlayer = this.f18461h;
            if (bRTCPlayer != null) {
                return bRTCPlayer.getPlayerState();
            }
            return null;
        }
        return (BRTCPlayer.PlayerState) invokeV.objValue;
    }

    private void setStreamTimeout(BRTCPlayerParameters bRTCPlayerParameters) {
        BuildParams buildParams;
        int intValue;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, bRTCPlayerParameters) == null) || (buildParams = this.p) == null || bRTCPlayerParameters == null) {
            return;
        }
        try {
            Object option = buildParams.getOption(BuildParams.K_RTC_STREAM_TIMEOUT_MS, null);
            if (option == null || (intValue = ((Integer) option).intValue()) <= 0) {
                return;
            }
            if (r) {
                g("setStreamTimeout streamTimeout= " + intValue);
            }
            bRTCPlayerParameters.setStreamingInterruptDetectInterval(intValue / 1000);
        } catch (Exception e2) {
            if (r) {
                g("setStreamTimeout exception e= " + e2.getMessage());
            }
        }
    }

    public void f(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || viewGroup == null) {
            return;
        }
        g("attachContainer " + viewGroup);
        n(viewGroup.getContext());
        h();
        this.l = viewGroup;
        viewGroup.addView(this, -1, -1);
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            Log.d("BRTCPlayerView", str);
        }
    }

    public String getServerIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "https://rtc2.exp.bcelive.com/brtc/v3/pullstream" : (String) invokeV.objValue;
    }

    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18459f : (String) invokeV.objValue;
    }

    public void h() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (viewGroup = (ViewGroup) getParent()) == null) {
            return;
        }
        g("dettachContainer " + viewGroup);
        viewGroup.removeView(this);
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BRTCPlayer bRTCPlayer = this.f18461h;
            return bRTCPlayer != null && bRTCPlayer.getPlayerState() == BRTCPlayer.PlayerState.STATE_ERROR;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BRTCPlayer bRTCPlayer = this.f18461h;
            return bRTCPlayer != null && bRTCPlayer.getPlayerState() == BRTCPlayer.PlayerState.STATE_PAUSED;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BRTCPlayer bRTCPlayer = this.f18461h;
            return bRTCPlayer != null && bRTCPlayer.getPlayerState() == BRTCPlayer.PlayerState.STATE_PLAYING;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (r) {
                g("pause " + this.f18461h);
            }
            BRTCPlayer bRTCPlayer = this.f18461h;
            if (bRTCPlayer != null) {
                bRTCPlayer.pausePlay();
            }
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, context) == null) && this.f18458e == null) {
            if (r) {
                g("prepare " + context);
            }
            this.f18458e = new RTCVideoView(context);
            this.f18461h = new BRTCPlayerImpl(context);
            BRTCPlayerParameters bRTCPlayerParameters = new BRTCPlayerParameters();
            this.f18460g = bRTCPlayerParameters;
            bRTCPlayerParameters.enableSoLaterLoad(true);
            this.f18460g.setCpuType("armeabi");
            this.f18460g.setEnableDebug(AppConfig.isDebug());
            this.f18460g.setPullUrl("https://rtc2.exp.bcelive.com/brtc/v3/pullstream");
            setStreamTimeout(this.f18460g);
            this.f18461h.initPlayer(this.f18460g, this.q);
            this.f18461h.setSurfaceView(this.f18458e);
            addView(this.f18458e, -1, -1);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (r) {
                g("release " + this.f18461h);
            }
            this.m = null;
            BRTCPlayer bRTCPlayer = this.f18461h;
            if (bRTCPlayer != null) {
                bRTCPlayer.setEventObserver(null);
                this.f18461h.releasePlayer();
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (r) {
                g("restart");
            }
            this.f18461h.releasePlayer();
            Context context = getContext();
            this.f18458e = new RTCVideoView(context);
            this.f18461h = new BRTCPlayerImpl(context);
            BRTCPlayerParameters bRTCPlayerParameters = new BRTCPlayerParameters();
            this.f18460g = bRTCPlayerParameters;
            bRTCPlayerParameters.enableSoLaterLoad(true);
            this.f18460g.setCpuType("armeabi");
            this.f18460g.setEnableDebug(AppConfig.isDebug());
            this.f18460g.setPullUrl("https://rtc2.exp.bcelive.com/brtc/v3/pullstream");
            setStreamTimeout(this.f18460g);
            this.f18461h.initPlayer(this.f18460g, this.q);
            this.f18461h.setSurfaceView(this.f18458e);
            this.f18461h.setScalingType(this.f18462i);
            addView(this.f18458e, -1, -1);
            setVideoInfo(this.n);
            this.f18461h.startPlay();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (r) {
                g("resume " + this.f18461h);
            }
            BRTCPlayer bRTCPlayer = this.f18461h;
            if (bRTCPlayer != null) {
                bRTCPlayer.resumePlay();
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            g("BRTCPlayerView resumeFromError mErrorCode= " + this.o);
            if (this.o != 10009) {
                t();
            }
            s();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (r) {
                StringBuilder sb = new StringBuilder();
                sb.append("start  sate:");
                BRTCPlayer bRTCPlayer = this.f18461h;
                sb.append(bRTCPlayer == null ? StringUtil.NULL_STRING : bRTCPlayer.getPlayerState());
                g(sb.toString());
            }
            BRTCPlayer bRTCPlayer2 = this.f18461h;
            if (bRTCPlayer2 != null) {
                if (bRTCPlayer2.getPlayerState() == BRTCPlayer.PlayerState.STATE_STOP) {
                    this.f18461h.setStreamUri(this.f18459f);
                    p();
                    return;
                }
                this.f18461h.startPlay();
            }
        }
    }

    public void setBRTCPlayerEvents(BRTCPlayerEvents bRTCPlayerEvents) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bRTCPlayerEvents) == null) {
            this.m = bRTCPlayerEvents;
        }
    }

    public void setParams(BuildParams buildParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, buildParams) == null) {
            this.p = buildParams;
        }
    }

    public void setVideoInfo(HashMap<Integer, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, hashMap) == null) {
            this.n = hashMap;
            String str = hashMap.get(0);
            if (r) {
                g("setVideoInfo " + str);
            }
            BRTCPlayer bRTCPlayer = this.f18461h;
            if (bRTCPlayer != null) {
                bRTCPlayer.setScalingType(this.f18462i);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                setVideoUrl(str);
            }
        }
    }

    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            if (r) {
                g("setVideoUrl " + str);
            }
            if (this.f18461h == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f18459f = str;
            this.n.put(0, str);
            this.f18461h.setStreamUri(str);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (r) {
                g("stop " + this.f18461h);
            }
            BRTCPlayer bRTCPlayer = this.f18461h;
            if (bRTCPlayer != null) {
                bRTCPlayer.stopPlay();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbBRTCPlayerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f18462i = RTCVideoView.ScalingType.SCALE_ASPECT_FIT;
        this.o = 0;
        this.q = new a(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbBRTCPlayerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f18462i = RTCVideoView.ScalingType.SCALE_ASPECT_FIT;
        this.o = 0;
        this.q = new a(this);
    }
}
