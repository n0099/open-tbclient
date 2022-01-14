package com.baidu.tieba.medialive.player.bdrtc;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.i0.f;
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
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Random;
/* loaded from: classes12.dex */
public class TbBRTCPlayerView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean s;
    public static final boolean t;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RTCVideoView f45813e;

    /* renamed from: f  reason: collision with root package name */
    public String f45814f;

    /* renamed from: g  reason: collision with root package name */
    public BRTCPlayerParameters f45815g;

    /* renamed from: h  reason: collision with root package name */
    public BRTCPlayer f45816h;

    /* renamed from: i  reason: collision with root package name */
    public RTCVideoView.ScalingType f45817i;

    /* renamed from: j  reason: collision with root package name */
    public int f45818j;
    public int k;
    public ViewGroup l;
    public BRTCPlayerEvents m;
    public HashMap<Integer, String> n;
    public int o;
    public BuildParams p;
    public long q;
    public BRTCPlayerEvents r;

    /* loaded from: classes12.dex */
    public class a implements BRTCPlayerEvents {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbBRTCPlayerView a;

        /* renamed from: com.baidu.tieba.medialive.player.bdrtc.TbBRTCPlayerView$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public class RunnableC1928a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f45819e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f45820f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f45821g;

            public RunnableC1928a(a aVar, int i2, String str) {
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
                this.f45821g = aVar;
                this.f45819e = i2;
                this.f45820f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Context context = this.f45821g.a.getContext();
                    Toast.makeText(context, this.f45819e + ": " + this.f45820f, 1).show();
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
            this.a = tbBRTCPlayerView;
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.a.o = i2;
                if (TbBRTCPlayerView.s) {
                    TbBRTCPlayerView tbBRTCPlayerView = this.a;
                    tbBRTCPlayerView.f("onError  : errCode" + i2 + " errMsg: " + str);
                }
                if (this.a.m != null) {
                    if (TbBRTCPlayerView.s) {
                        f.b(new RunnableC1928a(this, i2, str));
                    }
                    this.a.m.onError(i2, str);
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onFirstFrameRendered() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.o = 0;
                if (TbBRTCPlayerView.s) {
                    this.a.f("onFirstFrameRendered ...");
                }
                if (this.a.m != null) {
                    this.a.m.onFirstFrameRendered();
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onInfoUpdated(int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, obj) == null) {
                if (TbBRTCPlayerView.t) {
                    TbBRTCPlayerView tbBRTCPlayerView = this.a;
                    tbBRTCPlayerView.f("onInfoUpdated  : " + i2 + " s " + obj);
                }
                if (this.a.m != null) {
                    this.a.m.onInfoUpdated(i2, obj);
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onPlayerStateChanged(BRTCPlayer.PlayerState playerState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, playerState) == null) {
                if (TbBRTCPlayerView.s) {
                    TbBRTCPlayerView tbBRTCPlayerView = this.a;
                    tbBRTCPlayerView.f("Player state changed  to " + playerState.toString());
                }
                if (this.a.m != null) {
                    this.a.m.onPlayerStateChanged(playerState);
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onRemoteData(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, byteBuffer) == null) {
                if (TbBRTCPlayerView.s) {
                    this.a.f("onRemoteData  received!");
                }
                if (this.a.m != null) {
                    this.a.m.onRemoteData(byteBuffer);
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onRemoteStreamStats(boolean z, boolean z2, BigInteger bigInteger) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), bigInteger}) == null) {
                if (TbBRTCPlayerView.s) {
                    TbBRTCPlayerView tbBRTCPlayerView = this.a;
                    tbBRTCPlayerView.f("onRemoteStreamStats  video:" + z + " audio:" + z2);
                }
                if (this.a.m != null) {
                    this.a.m.onRemoteStreamStats(z, z2, bigInteger);
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onResolutionChanged(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
                if (TbBRTCPlayerView.s) {
                    TbBRTCPlayerView tbBRTCPlayerView = this.a;
                    tbBRTCPlayerView.f("onResolutionChanged  : " + i2 + " x " + i3);
                }
                TbBRTCPlayerView tbBRTCPlayerView2 = this.a;
                tbBRTCPlayerView2.f45818j = i2;
                tbBRTCPlayerView2.k = i3;
                if (tbBRTCPlayerView2.m != null) {
                    this.a.m.onResolutionChanged(i2, i3);
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onSEIRecv(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, byteBuffer) == null) || this.a.m == null) {
                return;
            }
            this.a.m.onSEIRecv(byteBuffer);
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
        s = AppConfig.isDebug();
        t = AppConfig.isDebug();
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
        this.f45817i = RTCVideoView.ScalingType.SCALE_ASPECT_FIT;
        this.o = 0;
        this.q = 0L;
        this.r = new a(this);
    }

    private BRTCPlayer.PlayerState getPlayerState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            BRTCPlayer bRTCPlayer = this.f45816h;
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
            if (s) {
                f("setStreamTimeout streamTimeout= " + intValue);
            }
            bRTCPlayerParameters.setStreamingInterruptDetectIntervalMs(intValue);
        } catch (Exception e2) {
            if (s) {
                f("setStreamTimeout exception e= " + e2.getMessage());
            }
        }
    }

    public void attachContainer(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || viewGroup == null) {
            return;
        }
        f("attachContainer " + viewGroup);
        h(viewGroup.getContext());
        dettachContainer();
        this.l = viewGroup;
        viewGroup.addView(this, -1, -1);
    }

    public void dettachContainer() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (viewGroup = (ViewGroup) getParent()) == null) {
            return;
        }
        f("dettachContainer " + viewGroup);
        viewGroup.removeView(this);
    }

    public final void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    public final long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.q = new Random().nextLong();
            f("generateUserId mPlayerId= $mPlayerId");
            return this.q;
        }
        return invokeV.longValue;
    }

    public long getPlayerID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.q : invokeV.longValue;
    }

    public String getServerIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "https://rtc2.exp.bcelive.com/brtc/v3/pullstream" : (String) invokeV.objValue;
    }

    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f45814f : (String) invokeV.objValue;
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, context) == null) && this.f45813e == null) {
            if (s) {
                f("prepare " + context);
            }
            this.f45813e = new RTCVideoView(context);
            this.f45816h = new BRTCPlayerImpl(context);
            BRTCPlayerParameters bRTCPlayerParameters = new BRTCPlayerParameters();
            this.f45815g = bRTCPlayerParameters;
            bRTCPlayerParameters.enableSoLaterLoad(true);
            this.f45815g.setCpuType("armeabi");
            this.f45815g.setEnableDebug(AppConfig.isDebug());
            this.f45815g.setPullUrl("https://rtc2.exp.bcelive.com/brtc/v3/pullstream");
            setStreamTimeout(this.f45815g);
            this.f45815g.setUserId(g());
            this.f45816h.initPlayer(this.f45815g, this.r);
            this.f45816h.setSurfaceView(this.f45813e);
            addView(this.f45813e, -1, -1);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (s) {
                f("restart");
            }
            this.f45816h.releasePlayer();
            Context context = getContext();
            this.f45813e = new RTCVideoView(context);
            this.f45816h = new BRTCPlayerImpl(context);
            BRTCPlayerParameters bRTCPlayerParameters = new BRTCPlayerParameters();
            this.f45815g = bRTCPlayerParameters;
            bRTCPlayerParameters.enableSoLaterLoad(true);
            this.f45815g.setCpuType("armeabi");
            this.f45815g.setEnableDebug(AppConfig.isDebug());
            this.f45815g.setPullUrl("https://rtc2.exp.bcelive.com/brtc/v3/pullstream");
            setStreamTimeout(this.f45815g);
            this.f45815g.setUserId(g());
            this.f45816h.initPlayer(this.f45815g, this.r);
            this.f45816h.setSurfaceView(this.f45813e);
            this.f45816h.setScalingType(this.f45817i);
            addView(this.f45813e, -1, -1);
            setVideoInfo(this.n);
            this.f45816h.startPlay();
        }
    }

    public boolean isError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BRTCPlayer bRTCPlayer = this.f45816h;
            return bRTCPlayer != null && bRTCPlayer.getPlayerState() == BRTCPlayer.PlayerState.STATE_ERROR;
        }
        return invokeV.booleanValue;
    }

    public boolean isPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            BRTCPlayer bRTCPlayer = this.f45816h;
            return bRTCPlayer != null && bRTCPlayer.getPlayerState() == BRTCPlayer.PlayerState.STATE_PAUSED;
        }
        return invokeV.booleanValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            BRTCPlayer bRTCPlayer = this.f45816h;
            return bRTCPlayer != null && bRTCPlayer.getPlayerState() == BRTCPlayer.PlayerState.STATE_PLAYING;
        }
        return invokeV.booleanValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (s) {
                f("pause " + this.f45816h);
            }
            BRTCPlayer bRTCPlayer = this.f45816h;
            if (bRTCPlayer != null) {
                bRTCPlayer.pausePlay();
            }
        }
    }

    public void play(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (s) {
                f("release " + this.f45816h);
            }
            this.m = null;
            BRTCPlayer bRTCPlayer = this.f45816h;
            if (bRTCPlayer != null) {
                bRTCPlayer.setEventObserver(null);
                this.f45816h.releasePlayer();
            }
        }
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (s) {
                f("resume " + this.f45816h);
            }
            BRTCPlayer bRTCPlayer = this.f45816h;
            if (bRTCPlayer != null) {
                bRTCPlayer.resumePlay();
            }
        }
    }

    public void resumeFromError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            f("BRTCPlayerView resumeFromError mErrorCode= " + this.o);
            if (this.o != 10009) {
                stop();
            }
            start();
        }
    }

    public void setBRTCPlayerEvents(BRTCPlayerEvents bRTCPlayerEvents) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bRTCPlayerEvents) == null) {
            this.m = bRTCPlayerEvents;
        }
    }

    public void setParams(BuildParams buildParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, buildParams) == null) {
            this.p = buildParams;
        }
    }

    public void setVideoInfo(HashMap<Integer, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, hashMap) == null) {
            this.n = hashMap;
            String str = hashMap.get(0);
            if (s) {
                f("setVideoInfo " + str);
            }
            BRTCPlayer bRTCPlayer = this.f45816h;
            if (bRTCPlayer != null) {
                bRTCPlayer.setScalingType(this.f45817i);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                setVideoUrl(str);
            }
        }
    }

    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            if (s) {
                f("setVideoUrl " + str);
            }
            if (this.f45816h == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f45814f = str;
            this.n.put(0, str);
            this.f45816h.setStreamUri(str);
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (s) {
                StringBuilder sb = new StringBuilder();
                sb.append("start  sate:");
                BRTCPlayer bRTCPlayer = this.f45816h;
                sb.append(bRTCPlayer == null ? StringUtil.NULL_STRING : bRTCPlayer.getPlayerState());
                f(sb.toString());
            }
            BRTCPlayer bRTCPlayer2 = this.f45816h;
            if (bRTCPlayer2 != null) {
                if (bRTCPlayer2.getPlayerState() == BRTCPlayer.PlayerState.STATE_STOP) {
                    this.f45816h.setStreamUri(this.f45814f);
                    i();
                    return;
                }
                this.f45816h.startPlay();
            }
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (s) {
                f("stop " + this.f45816h);
            }
            BRTCPlayer bRTCPlayer = this.f45816h;
            if (bRTCPlayer != null) {
                bRTCPlayer.stopPlay();
            }
        }
    }

    public void stopStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.f45816h.getPlayerState() != BRTCPlayer.PlayerState.STATE_IDLE && this.f45816h.getPlayerState() != BRTCPlayer.PlayerState.STATE_INITIALIZED && this.f45816h.getPlayerState() != BRTCPlayer.PlayerState.STATE_STOP) {
                this.f45816h.stopPlay();
            } else {
                this.f45816h.startPlay();
            }
        }
    }

    public void swichScale(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, view) == null) {
            if (s) {
                f("swichScale " + view);
            }
            RTCVideoView.ScalingType scalingType = this.f45817i;
            if (scalingType == RTCVideoView.ScalingType.SCALE_ASPECT_FIT) {
                this.f45816h.setScalingType(RTCVideoView.ScalingType.SCALE_ASPECT_FILL);
                this.f45817i = RTCVideoView.ScalingType.SCALE_ASPECT_FILL;
                int measuredWidth = (int) ((this.k / this.f45818j) * this.f45813e.getMeasuredWidth());
                ViewGroup.LayoutParams layoutParams = this.f45813e.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, measuredWidth);
                } else {
                    layoutParams.height = measuredWidth;
                }
                this.f45813e.setLayoutParams(layoutParams);
            } else if (scalingType == RTCVideoView.ScalingType.SCALE_ASPECT_FILL) {
                this.f45816h.setScalingType(RTCVideoView.ScalingType.SCALE_ASPECT_FIT);
                this.f45817i = RTCVideoView.ScalingType.SCALE_ASPECT_FIT;
                ViewGroup.LayoutParams layoutParams2 = this.f45813e.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
                } else {
                    layoutParams2.height = -1;
                }
                this.f45813e.setLayoutParams(layoutParams2);
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
        this.f45817i = RTCVideoView.ScalingType.SCALE_ASPECT_FIT;
        this.o = 0;
        this.q = 0L;
        this.r = new a(this);
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
        this.f45817i = RTCVideoView.ScalingType.SCALE_ASPECT_FIT;
        this.o = 0;
        this.q = 0L;
        this.r = new a(this);
    }
}
