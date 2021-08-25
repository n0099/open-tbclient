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
import c.a.q0.c0.f;
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
/* loaded from: classes7.dex */
public class TbBRTCPlayerView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public static final boolean s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RTCVideoView f54021e;

    /* renamed from: f  reason: collision with root package name */
    public String f54022f;

    /* renamed from: g  reason: collision with root package name */
    public BRTCPlayerParameters f54023g;

    /* renamed from: h  reason: collision with root package name */
    public BRTCPlayer f54024h;

    /* renamed from: i  reason: collision with root package name */
    public RTCVideoView.ScalingType f54025i;

    /* renamed from: j  reason: collision with root package name */
    public int f54026j;
    public int k;
    public ViewGroup l;
    public BRTCPlayerEvents m;
    public HashMap<Integer, String> n;
    public int o;
    public BuildParams p;
    public BRTCPlayerEvents q;

    /* loaded from: classes7.dex */
    public class a implements BRTCPlayerEvents {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbBRTCPlayerView f54027a;

        /* renamed from: com.baidu.tieba.medialive.player.bdrtc.TbBRTCPlayerView$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1772a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f54028e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f54029f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f54030g;

            public RunnableC1772a(a aVar, int i2, String str) {
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
                this.f54030g = aVar;
                this.f54028e = i2;
                this.f54029f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Context context = this.f54030g.f54027a.getContext();
                    Toast.makeText(context, this.f54028e + ": " + this.f54029f, 1).show();
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
            this.f54027a = tbBRTCPlayerView;
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f54027a.o = i2;
                if (TbBRTCPlayerView.r) {
                    TbBRTCPlayerView tbBRTCPlayerView = this.f54027a;
                    tbBRTCPlayerView.f("onError  : errCode" + i2 + " errMsg: " + str);
                }
                if (this.f54027a.m != null) {
                    if (TbBRTCPlayerView.r) {
                        f.b(new RunnableC1772a(this, i2, str));
                    }
                    this.f54027a.m.onError(i2, str);
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onFirstFrameRendered() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f54027a.o = 0;
                if (TbBRTCPlayerView.r) {
                    this.f54027a.f("onFirstFrameRendered ...");
                }
                if (this.f54027a.m != null) {
                    this.f54027a.m.onFirstFrameRendered();
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onInfoUpdated(int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, obj) == null) {
                if (TbBRTCPlayerView.s) {
                    TbBRTCPlayerView tbBRTCPlayerView = this.f54027a;
                    tbBRTCPlayerView.f("onInfoUpdated  : " + i2 + " s " + obj);
                }
                if (this.f54027a.m != null) {
                    this.f54027a.m.onInfoUpdated(i2, obj);
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onPlayerStateChanged(BRTCPlayer.PlayerState playerState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, playerState) == null) {
                if (TbBRTCPlayerView.r) {
                    TbBRTCPlayerView tbBRTCPlayerView = this.f54027a;
                    tbBRTCPlayerView.f("Player state changed  to " + playerState.toString());
                }
                if (this.f54027a.m != null) {
                    this.f54027a.m.onPlayerStateChanged(playerState);
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onRemoteData(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, byteBuffer) == null) {
                if (TbBRTCPlayerView.r) {
                    this.f54027a.f("onRemoteData  received!");
                }
                if (this.f54027a.m != null) {
                    this.f54027a.m.onRemoteData(byteBuffer);
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onRemoteStreamStats(boolean z, boolean z2, BigInteger bigInteger) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), bigInteger}) == null) {
                if (TbBRTCPlayerView.r) {
                    TbBRTCPlayerView tbBRTCPlayerView = this.f54027a;
                    tbBRTCPlayerView.f("onRemoteStreamStats  video:" + z + " audio:" + z2);
                }
                if (this.f54027a.m != null) {
                    this.f54027a.m.onRemoteStreamStats(z, z2, bigInteger);
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onResolutionChanged(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
                if (TbBRTCPlayerView.r) {
                    TbBRTCPlayerView tbBRTCPlayerView = this.f54027a;
                    tbBRTCPlayerView.f("onResolutionChanged  : " + i2 + " x " + i3);
                }
                TbBRTCPlayerView tbBRTCPlayerView2 = this.f54027a;
                tbBRTCPlayerView2.f54026j = i2;
                tbBRTCPlayerView2.k = i3;
                if (tbBRTCPlayerView2.m != null) {
                    this.f54027a.m.onResolutionChanged(i2, i3);
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onSEIRecv(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, byteBuffer) == null) || this.f54027a.m == null) {
                return;
            }
            this.f54027a.m.onSEIRecv(byteBuffer);
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
        this.f54025i = RTCVideoView.ScalingType.SCALE_ASPECT_FIT;
        this.o = 0;
        this.q = new a(this);
    }

    private BRTCPlayer.PlayerState getPlayerState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            BRTCPlayer bRTCPlayer = this.f54024h;
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
                f("setStreamTimeout streamTimeout= " + intValue);
            }
            bRTCPlayerParameters.setStreamingInterruptDetectIntervalMs(intValue);
        } catch (Exception e2) {
            if (r) {
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
        g(viewGroup.getContext());
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

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, context) == null) && this.f54021e == null) {
            if (r) {
                f("prepare " + context);
            }
            this.f54021e = new RTCVideoView(context);
            this.f54024h = new BRTCPlayerImpl(context);
            BRTCPlayerParameters bRTCPlayerParameters = new BRTCPlayerParameters();
            this.f54023g = bRTCPlayerParameters;
            bRTCPlayerParameters.enableSoLaterLoad(true);
            this.f54023g.setCpuType("armeabi");
            this.f54023g.setEnableDebug(AppConfig.isDebug());
            this.f54023g.setPullUrl("https://rtc2.exp.bcelive.com/brtc/v3/pullstream");
            setStreamTimeout(this.f54023g);
            this.f54024h.initPlayer(this.f54023g, this.q);
            this.f54024h.setSurfaceView(this.f54021e);
            addView(this.f54021e, -1, -1);
        }
    }

    public String getServerIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "https://rtc2.exp.bcelive.com/brtc/v3/pullstream" : (String) invokeV.objValue;
    }

    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f54022f : (String) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (r) {
                f("restart");
            }
            this.f54024h.releasePlayer();
            Context context = getContext();
            this.f54021e = new RTCVideoView(context);
            this.f54024h = new BRTCPlayerImpl(context);
            BRTCPlayerParameters bRTCPlayerParameters = new BRTCPlayerParameters();
            this.f54023g = bRTCPlayerParameters;
            bRTCPlayerParameters.enableSoLaterLoad(true);
            this.f54023g.setCpuType("armeabi");
            this.f54023g.setEnableDebug(AppConfig.isDebug());
            this.f54023g.setPullUrl("https://rtc2.exp.bcelive.com/brtc/v3/pullstream");
            setStreamTimeout(this.f54023g);
            this.f54024h.initPlayer(this.f54023g, this.q);
            this.f54024h.setSurfaceView(this.f54021e);
            this.f54024h.setScalingType(this.f54025i);
            addView(this.f54021e, -1, -1);
            setVideoInfo(this.n);
            this.f54024h.startPlay();
        }
    }

    public boolean isError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BRTCPlayer bRTCPlayer = this.f54024h;
            return bRTCPlayer != null && bRTCPlayer.getPlayerState() == BRTCPlayer.PlayerState.STATE_ERROR;
        }
        return invokeV.booleanValue;
    }

    public boolean isPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BRTCPlayer bRTCPlayer = this.f54024h;
            return bRTCPlayer != null && bRTCPlayer.getPlayerState() == BRTCPlayer.PlayerState.STATE_PAUSED;
        }
        return invokeV.booleanValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BRTCPlayer bRTCPlayer = this.f54024h;
            return bRTCPlayer != null && bRTCPlayer.getPlayerState() == BRTCPlayer.PlayerState.STATE_PLAYING;
        }
        return invokeV.booleanValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (r) {
                f("pause " + this.f54024h);
            }
            BRTCPlayer bRTCPlayer = this.f54024h;
            if (bRTCPlayer != null) {
                bRTCPlayer.pausePlay();
            }
        }
    }

    public void play(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (r) {
                f("release " + this.f54024h);
            }
            this.m = null;
            BRTCPlayer bRTCPlayer = this.f54024h;
            if (bRTCPlayer != null) {
                bRTCPlayer.setEventObserver(null);
                this.f54024h.releasePlayer();
            }
        }
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (r) {
                f("resume " + this.f54024h);
            }
            BRTCPlayer bRTCPlayer = this.f54024h;
            if (bRTCPlayer != null) {
                bRTCPlayer.resumePlay();
            }
        }
    }

    public void resumeFromError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            f("BRTCPlayerView resumeFromError mErrorCode= " + this.o);
            if (this.o != 10009) {
                stop();
            }
            start();
        }
    }

    public void setBRTCPlayerEvents(BRTCPlayerEvents bRTCPlayerEvents) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bRTCPlayerEvents) == null) {
            this.m = bRTCPlayerEvents;
        }
    }

    public void setParams(BuildParams buildParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, buildParams) == null) {
            this.p = buildParams;
        }
    }

    public void setVideoInfo(HashMap<Integer, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, hashMap) == null) {
            this.n = hashMap;
            String str = hashMap.get(0);
            if (r) {
                f("setVideoInfo " + str);
            }
            BRTCPlayer bRTCPlayer = this.f54024h;
            if (bRTCPlayer != null) {
                bRTCPlayer.setScalingType(this.f54025i);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                setVideoUrl(str);
            }
        }
    }

    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            if (r) {
                f("setVideoUrl " + str);
            }
            if (this.f54024h == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f54022f = str;
            this.n.put(0, str);
            this.f54024h.setStreamUri(str);
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (r) {
                StringBuilder sb = new StringBuilder();
                sb.append("start  sate:");
                BRTCPlayer bRTCPlayer = this.f54024h;
                sb.append(bRTCPlayer == null ? StringUtil.NULL_STRING : bRTCPlayer.getPlayerState());
                f(sb.toString());
            }
            BRTCPlayer bRTCPlayer2 = this.f54024h;
            if (bRTCPlayer2 != null) {
                if (bRTCPlayer2.getPlayerState() == BRTCPlayer.PlayerState.STATE_STOP) {
                    this.f54024h.setStreamUri(this.f54022f);
                    h();
                    return;
                }
                this.f54024h.startPlay();
            }
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (r) {
                f("stop " + this.f54024h);
            }
            BRTCPlayer bRTCPlayer = this.f54024h;
            if (bRTCPlayer != null) {
                bRTCPlayer.stopPlay();
            }
        }
    }

    public void stopStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.f54024h.getPlayerState() != BRTCPlayer.PlayerState.STATE_IDLE && this.f54024h.getPlayerState() != BRTCPlayer.PlayerState.STATE_INITIALIZED && this.f54024h.getPlayerState() != BRTCPlayer.PlayerState.STATE_STOP) {
                this.f54024h.stopPlay();
            } else {
                this.f54024h.startPlay();
            }
        }
    }

    public void swichScale(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view) == null) {
            if (r) {
                f("swichScale " + view);
            }
            RTCVideoView.ScalingType scalingType = this.f54025i;
            if (scalingType == RTCVideoView.ScalingType.SCALE_ASPECT_FIT) {
                this.f54024h.setScalingType(RTCVideoView.ScalingType.SCALE_ASPECT_FILL);
                this.f54025i = RTCVideoView.ScalingType.SCALE_ASPECT_FILL;
                int measuredWidth = (int) ((this.k / this.f54026j) * this.f54021e.getMeasuredWidth());
                ViewGroup.LayoutParams layoutParams = this.f54021e.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, measuredWidth);
                } else {
                    layoutParams.height = measuredWidth;
                }
                this.f54021e.setLayoutParams(layoutParams);
            } else if (scalingType == RTCVideoView.ScalingType.SCALE_ASPECT_FILL) {
                this.f54024h.setScalingType(RTCVideoView.ScalingType.SCALE_ASPECT_FIT);
                this.f54025i = RTCVideoView.ScalingType.SCALE_ASPECT_FIT;
                ViewGroup.LayoutParams layoutParams2 = this.f54021e.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
                } else {
                    layoutParams2.height = -1;
                }
                this.f54021e.setLayoutParams(layoutParams2);
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
        this.f54025i = RTCVideoView.ScalingType.SCALE_ASPECT_FIT;
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
        this.f54025i = RTCVideoView.ScalingType.SCALE_ASPECT_FIT;
        this.o = 0;
        this.q = new a(this);
    }
}
