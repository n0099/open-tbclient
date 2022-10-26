package com.baidu.tieba.medialive.player.bdrtc;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
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
import com.baidu.tieba.u36;
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
/* loaded from: classes5.dex */
public class TbBRTCPlayerView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public static final boolean p;
    public transient /* synthetic */ FieldHolder $fh;
    public RTCVideoView a;
    public String b;
    public BRTCPlayerParameters c;
    public BRTCPlayer d;
    public RTCVideoView.ScalingType e;
    public int f;
    public int g;
    public ViewGroup h;
    public BRTCPlayerEvents i;
    public HashMap j;
    public int k;
    public BuildParams l;
    public long m;
    public BRTCPlayerEvents n;

    public String getServerIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "https://rtc2.exp.bcelive.com/brtc/v3/pullstream" : (String) invokeV.objValue;
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements BRTCPlayerEvents {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbBRTCPlayerView a;

        /* renamed from: com.baidu.tieba.medialive.player.bdrtc.TbBRTCPlayerView$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0331a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ String b;
            public final /* synthetic */ a c;

            public RunnableC0331a(a aVar, int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i), str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = i;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Context context = this.c.a.getContext();
                    Toast.makeText(context, this.a + ": " + this.b, 1).show();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbBRTCPlayerView;
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onRemoteData(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, byteBuffer) == null) {
                if (TbBRTCPlayerView.o) {
                    this.a.g("onRemoteData  received!");
                }
                if (this.a.i != null) {
                    this.a.i.onRemoteData(byteBuffer);
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onSEIRecv(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, byteBuffer) == null) && this.a.i != null) {
                this.a.i.onSEIRecv(byteBuffer);
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(1048576, this, i, str) != null) {
                return;
            }
            this.a.k = i;
            if (TbBRTCPlayerView.o) {
                TbBRTCPlayerView tbBRTCPlayerView = this.a;
                tbBRTCPlayerView.g("onError  : errCode" + i + " errMsg: " + str);
            }
            if (this.a.i != null) {
                if (TbBRTCPlayerView.o) {
                    u36.b(new RunnableC0331a(this, i, str));
                }
                this.a.i.onError(i, str);
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onResolutionChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
                if (TbBRTCPlayerView.o) {
                    TbBRTCPlayerView tbBRTCPlayerView = this.a;
                    tbBRTCPlayerView.g("onResolutionChanged  : " + i + " x " + i2);
                }
                TbBRTCPlayerView tbBRTCPlayerView2 = this.a;
                tbBRTCPlayerView2.f = i;
                tbBRTCPlayerView2.g = i2;
                if (tbBRTCPlayerView2.i != null) {
                    this.a.i.onResolutionChanged(i, i2);
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onFirstFrameRendered() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.k = 0;
            if (TbBRTCPlayerView.o) {
                this.a.g("onFirstFrameRendered ...");
            }
            if (this.a.i != null) {
                this.a.i.onFirstFrameRendered();
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onInfoUpdated(int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, obj) == null) {
                if (TbBRTCPlayerView.p) {
                    TbBRTCPlayerView tbBRTCPlayerView = this.a;
                    tbBRTCPlayerView.g("onInfoUpdated  : " + i + " s " + obj);
                }
                if (this.a.i != null) {
                    this.a.i.onInfoUpdated(i, obj);
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onPlayerStateChanged(BRTCPlayer.PlayerState playerState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, playerState) == null) {
                if (TbBRTCPlayerView.o) {
                    TbBRTCPlayerView tbBRTCPlayerView = this.a;
                    tbBRTCPlayerView.g("Player state changed  to " + playerState.toString());
                }
                if (this.a.i != null) {
                    this.a.i.onPlayerStateChanged(playerState);
                }
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onRemoteStreamStats(boolean z, boolean z2, BigInteger bigInteger) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), bigInteger}) == null) {
                if (TbBRTCPlayerView.o) {
                    TbBRTCPlayerView tbBRTCPlayerView = this.a;
                    tbBRTCPlayerView.g("onRemoteStreamStats  video:" + z + " audio:" + z2);
                }
                if (this.a.i != null) {
                    this.a.i.onRemoteStreamStats(z, z2, bigInteger);
                }
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
        o = AppConfig.isDebug();
        p = AppConfig.isDebug();
    }

    private BRTCPlayer.PlayerState getPlayerState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            BRTCPlayer bRTCPlayer = this.d;
            if (bRTCPlayer != null) {
                return bRTCPlayer.getPlayerState();
            }
            return null;
        }
        return (BRTCPlayer.PlayerState) invokeV.objValue;
    }

    public long getPlayerID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.m;
        }
        return invokeV.longValue;
    }

    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public void h() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (viewGroup = (ViewGroup) getParent()) != null) {
            g("dettachContainer " + viewGroup);
            viewGroup.removeView(this);
        }
    }

    public final long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.m = new Random().nextLong();
            g("generateUserId mPlayerId= $mPlayerId");
            return this.m;
        }
        return invokeV.longValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BRTCPlayer bRTCPlayer = this.d;
            if (bRTCPlayer != null && bRTCPlayer.getPlayerState() == BRTCPlayer.PlayerState.STATE_ERROR) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BRTCPlayer bRTCPlayer = this.d;
            if (bRTCPlayer != null && bRTCPlayer.getPlayerState() == BRTCPlayer.PlayerState.STATE_PAUSED) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BRTCPlayer bRTCPlayer = this.d;
            if (bRTCPlayer != null && bRTCPlayer.getPlayerState() == BRTCPlayer.PlayerState.STATE_PLAYING) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (o) {
                g("pause " + this.d);
            }
            BRTCPlayer bRTCPlayer = this.d;
            if (bRTCPlayer != null) {
                bRTCPlayer.pausePlay();
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (o) {
                g("resume " + this.d);
            }
            BRTCPlayer bRTCPlayer = this.d;
            if (bRTCPlayer != null) {
                bRTCPlayer.resumePlay();
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            g("BRTCPlayerView resumeFromError mErrorCode= " + this.k);
            if (this.k != 10009) {
                u();
            }
            t();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (o) {
                g("stop " + this.d);
            }
            BRTCPlayer bRTCPlayer = this.d;
            if (bRTCPlayer != null) {
                bRTCPlayer.stopPlay();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbBRTCPlayerView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = RTCVideoView.ScalingType.SCALE_ASPECT_FIT;
        this.k = 0;
        this.m = 0L;
        this.n = new a(this);
    }

    private void setStreamTimeout(BRTCPlayerParameters bRTCPlayerParameters) {
        BuildParams buildParams;
        int intValue;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, this, bRTCPlayerParameters) == null) && (buildParams = this.l) != null && bRTCPlayerParameters != null) {
            try {
                Object option = buildParams.getOption(BuildParams.K_RTC_STREAM_TIMEOUT_MS, null);
                if (option != null && (intValue = ((Integer) option).intValue()) > 0) {
                    if (o) {
                        g("setStreamTimeout streamTimeout= " + intValue);
                    }
                    bRTCPlayerParameters.setStreamingInterruptDetectIntervalMs(intValue);
                }
            } catch (Exception e) {
                if (o) {
                    g("setStreamTimeout exception e= " + e.getMessage());
                }
            }
        }
    }

    public void setVideoInfo(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, hashMap) == null) {
            this.j = hashMap;
            String str = (String) hashMap.get(0);
            if (o) {
                g("setVideoInfo " + str);
            }
            BRTCPlayer bRTCPlayer = this.d;
            if (bRTCPlayer != null) {
                bRTCPlayer.setScalingType(this.e);
                if (!TextUtils.isEmpty(str)) {
                    setVideoUrl(str);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbBRTCPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.e = RTCVideoView.ScalingType.SCALE_ASPECT_FIT;
        this.k = 0;
        this.m = 0L;
        this.n = new a(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbBRTCPlayerView(Context context, AttributeSet attributeSet, int i) {
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
        this.e = RTCVideoView.ScalingType.SCALE_ASPECT_FIT;
        this.k = 0;
        this.m = 0L;
        this.n = new a(this);
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            Log.d("BRTCPlayerView", str);
        }
    }

    public void setBRTCPlayerEvents(BRTCPlayerEvents bRTCPlayerEvents) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bRTCPlayerEvents) == null) {
            this.i = bRTCPlayerEvents;
        }
    }

    public void setParams(BuildParams buildParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, buildParams) == null) {
            this.l = buildParams;
        }
    }

    public void f(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, viewGroup) != null) || viewGroup == null) {
            return;
        }
        g("attachContainer " + viewGroup);
        o(viewGroup.getContext());
        h();
        this.h = viewGroup;
        viewGroup.addView(this, -1, -1);
    }

    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            if (o) {
                g("setVideoUrl " + str);
            }
            if (this.d != null && !TextUtils.isEmpty(str)) {
                this.b = str;
                this.j.put(0, str);
                this.d.setStreamUri(str);
            }
        }
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, context) != null) || this.a != null) {
            return;
        }
        if (o) {
            g("prepare " + context);
        }
        this.a = new RTCVideoView(context);
        this.d = new BRTCPlayerImpl(context);
        BRTCPlayerParameters bRTCPlayerParameters = new BRTCPlayerParameters();
        this.c = bRTCPlayerParameters;
        bRTCPlayerParameters.enableSoLaterLoad(true);
        this.c.setCpuType("armeabi");
        this.c.setEnableDebug(AppConfig.isDebug());
        this.c.setPullUrl("https://rtc2.exp.bcelive.com/brtc/v3/pullstream");
        setStreamTimeout(this.c);
        this.c.setUserId(i());
        this.d.initPlayer(this.c, this.n);
        this.d.setSurfaceView(this.a);
        addView(this.a, -1, -1);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (o) {
                g("release " + this.d);
            }
            this.i = null;
            BRTCPlayer bRTCPlayer = this.d;
            if (bRTCPlayer != null) {
                bRTCPlayer.setEventObserver(null);
                this.d.releasePlayer();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (o) {
                g("restart");
            }
            this.d.releasePlayer();
            Context context = getContext();
            this.a = new RTCVideoView(context);
            this.d = new BRTCPlayerImpl(context);
            BRTCPlayerParameters bRTCPlayerParameters = new BRTCPlayerParameters();
            this.c = bRTCPlayerParameters;
            bRTCPlayerParameters.enableSoLaterLoad(true);
            this.c.setCpuType("armeabi");
            this.c.setEnableDebug(AppConfig.isDebug());
            this.c.setPullUrl("https://rtc2.exp.bcelive.com/brtc/v3/pullstream");
            setStreamTimeout(this.c);
            this.c.setUserId(i());
            this.d.initPlayer(this.c, this.n);
            this.d.setSurfaceView(this.a);
            this.d.setScalingType(this.e);
            addView(this.a, -1, -1);
            setVideoInfo(this.j);
            this.d.startPlay();
        }
    }

    public void t() {
        Object playerState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (o) {
                StringBuilder sb = new StringBuilder();
                sb.append("start  sate:");
                BRTCPlayer bRTCPlayer = this.d;
                if (bRTCPlayer == null) {
                    playerState = StringUtil.NULL_STRING;
                } else {
                    playerState = bRTCPlayer.getPlayerState();
                }
                sb.append(playerState);
                g(sb.toString());
            }
            BRTCPlayer bRTCPlayer2 = this.d;
            if (bRTCPlayer2 != null) {
                if (bRTCPlayer2.getPlayerState() == BRTCPlayer.PlayerState.STATE_STOP) {
                    this.d.setStreamUri(this.b);
                    q();
                    return;
                }
                this.d.startPlay();
            }
        }
    }
}
