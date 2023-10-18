package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberVideoView;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class tt0 extends st0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CyberVideoView g;
    public ps0 h;

    /* loaded from: classes8.dex */
    public class a extends CyberVideoView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(tt0 tt0Var, Context context, int i) {
            super(context, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt0Var, context, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tt0Var;
        }

        @Override // android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (this.a.h != null) {
                    return this.a.h.onTouchEvent(motionEvent);
                }
                return super.onTouchEvent(motionEvent);
            }
            return invokeL.booleanValue;
        }
    }

    public tt0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this, xo0.b(), 1);
    }

    @Override // com.baidu.tieba.rt0
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g.setVideoURI(Uri.parse(this.b), this.d);
        }
    }

    @Override // com.baidu.tieba.rt0
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.O();
            this.g.start();
            if (l(PlayerStatus.COMPLETE)) {
                n(PlayerStatus.PLAYING);
            }
        }
    }

    @Override // com.baidu.tieba.rt0
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.P();
            this.g.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.rt0
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.Q();
            this.g.stopPlayback();
        }
    }

    @Nullable
    public ps0 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.h;
        }
        return (ps0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rt0
    @NonNull
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.g;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rt0
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rt0
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.g.getDuration() / 1000;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rt0
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.g.getDuration();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rt0, com.baidu.tieba.cw0
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onRelease();
            this.g.stopPlayback();
            D(null);
            W(null);
        }
    }

    @Override // com.baidu.tieba.rt0
    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.g.setLooping(z);
        }
    }

    @Override // com.baidu.tieba.rt0
    public void G(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.g.setPlayJson(str);
        }
    }

    @Override // com.baidu.tieba.rt0
    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            super.I(z);
            this.g.setRemote(z);
        }
    }

    @Override // com.baidu.tieba.rt0
    public void J(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
            this.g.setSpeed(f);
        }
    }

    @Override // com.baidu.tieba.rt0
    public void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.g.setVideoScalingMode(i);
        }
    }

    @Override // com.baidu.tieba.rt0
    public void S(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.g.changeProxyDynamic(str);
        }
    }

    public void W(@Nullable ps0 ps0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ps0Var) == null) {
            this.h = ps0Var;
        }
    }

    @Override // com.baidu.tieba.rt0
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.g.muteOrUnmuteAudio(z);
        }
    }

    @Override // com.baidu.tieba.rt0, com.baidu.tieba.cw0
    public boolean verify(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            return "CyberNetPlayer".equals(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.rt0
    public void z(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.g.setClarityInfo(str);
        }
    }

    @Override // com.baidu.tieba.rt0
    public void B(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
            this.g.setExternalInfo(str, obj);
        }
    }

    @Override // com.baidu.tieba.rt0
    public void F(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.g.setOption(str, str2);
        }
    }

    @Override // com.baidu.tieba.rt0
    public void y(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048605, this, i, i2) == null) {
            this.g.seekTo(i, i2);
        }
    }

    @Override // com.baidu.tieba.rt0
    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.g.setOption(CyberPlayerManager.OPT_HTTP_PROXY, str);
                this.g.setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, YYOption.IsLive.VALUE_TRUE);
                return;
            }
            this.g.setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
            this.g.setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
        }
    }

    @Override // com.baidu.tieba.st0
    public void T(ut0 ut0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ut0Var) == null) {
            this.g.setOnCompletionListener(ut0Var);
            this.g.setOnErrorListener(ut0Var);
            this.g.setOnInfoListener(ut0Var);
            this.g.setOnSeekCompleteListener(ut0Var);
            this.g.setOnPreparedListener(ut0Var);
            this.g.setOnBufferingUpdateListener(ut0Var);
            this.g.setOnVideoSizeChangedListener(ut0Var);
            this.g.setOnMediaSourceChangedListener(ut0Var);
        }
    }

    @Override // com.baidu.tieba.rt0
    public void L(String str, @NonNull HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, hashMap) == null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                this.g.setOption(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // com.baidu.tieba.rt0
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (l(PlayerStatus.IDLE)) {
                int e = e() / 1000;
                if (e - (this.g.getCurrentPosition() / 1000) <= 2) {
                    return e;
                }
            }
            return this.g.getCurrentPosition() / 1000;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rt0
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (i() == PlayerStatus.IDLE && e() - this.g.getCurrentPosition() <= 2) {
                return f();
            }
            return this.g.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rt0, com.baidu.tieba.cw0
    public void onInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onInit();
            this.g.reset();
            this.g.setVideoScalingMode(2);
            this.g.setSpeed(1.0f);
            this.g.setVideoRotation(0);
            this.g.setVisibility(0);
            this.g.setAlpha(1.0f);
            I(true);
            this.g.setBackgroundColor(-16777216);
        }
    }

    @Override // com.baidu.tieba.rt0
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.s();
            if (l(PlayerStatus.PLAYING, PlayerStatus.PREPARED, PlayerStatus.PREPARING)) {
                n(PlayerStatus.PAUSE);
                this.g.pause();
            }
        }
    }

    @Override // com.baidu.tieba.rt0
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.w();
            if (l(PlayerStatus.PREPARED, PlayerStatus.PREPARING, PlayerStatus.PAUSE, PlayerStatus.COMPLETE)) {
                n(PlayerStatus.PLAYING);
                this.g.start();
            }
        }
    }
}
