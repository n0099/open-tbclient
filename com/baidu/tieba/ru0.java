package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
public class ru0 extends ju0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CyberPlayer g;

    @Override // com.baidu.tieba.iu0
    public void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
        }
    }

    @Override // com.baidu.tieba.iu0
    @Nullable
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    public ru0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.iu0
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g.setDataSource(op0.b(), Uri.parse(this.b), this.d);
            this.g.prepareAsync();
        }
    }

    @Override // com.baidu.tieba.iu0
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.O();
            this.g.start();
            if (l(PlayerStatus.COMPLETE)) {
                n(PlayerStatus.PLAYING);
            }
        }
    }

    @Override // com.baidu.tieba.iu0
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.P();
            Q();
        }
    }

    @Override // com.baidu.tieba.iu0
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.Q();
            this.g.stop();
        }
    }

    @Override // com.baidu.tieba.iu0
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.iu0
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.g.getDuration() / 1000;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.iu0
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.g.getDuration();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.iu0, com.baidu.tieba.tw0
    public void onInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onInit();
            this.g = new CyberPlayer();
        }
    }

    @Override // com.baidu.tieba.iu0, com.baidu.tieba.tw0
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onRelease();
            this.d.clear();
            Q();
            this.g.release();
            this.g = null;
        }
    }

    @Override // com.baidu.tieba.iu0
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            u("prepare");
            if (!PlayerStatus.isActiveStatus(i())) {
                n(PlayerStatus.PREPARING);
                this.g.prepareAsync();
            }
        }
    }

    @Override // com.baidu.tieba.iu0
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.w();
            if (l(PlayerStatus.PAUSE, PlayerStatus.COMPLETE)) {
                n(PlayerStatus.PLAYING);
                this.g.start();
            }
        }
    }

    @Override // com.baidu.tieba.iu0
    public void B(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
            this.g.setExternalInfo(str, obj);
        }
    }

    @Override // com.baidu.tieba.iu0
    public void F(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.g.setOption(str, str2);
        }
    }

    @Override // com.baidu.tieba.iu0
    public void y(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048604, this, i, i2) == null) {
            this.g.seekTo(i, i2);
        }
    }

    @Override // com.baidu.tieba.iu0
    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.g.setLooping(z);
        }
    }

    @Override // com.baidu.tieba.iu0
    public void G(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.g.setPlayJson(str);
        }
    }

    @Override // com.baidu.tieba.iu0
    public void J(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
            this.g.setSpeed(f);
        }
    }

    @Override // com.baidu.tieba.iu0
    public void S(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            if (str != null) {
                this.g.changeProxyDynamic(str, true);
            } else {
                this.g.changeProxyDynamic(null, false);
            }
        }
    }

    @Override // com.baidu.tieba.iu0
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.g.muteOrUnmuteAudio(z);
        }
    }

    @Override // com.baidu.tieba.iu0, com.baidu.tieba.tw0
    public boolean verify(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            return "InlineVideoKernel".equals(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.iu0
    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.g.seekTo(i);
        }
    }

    @Override // com.baidu.tieba.iu0
    public void z(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.g.setClarityInfo(str);
        }
    }

    @Override // com.baidu.tieba.iu0
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

    @Override // com.baidu.tieba.ju0
    public void T(lu0 lu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, lu0Var) == null) {
            this.g.setOnCompletionListener(lu0Var);
            this.g.setOnErrorListener(lu0Var);
            this.g.setOnInfoListener(lu0Var);
            this.g.setOnSeekCompleteListener(lu0Var);
            this.g.setOnPreparedListener(lu0Var);
            this.g.setOnBufferingUpdateListener(lu0Var);
            this.g.setOnVideoSizeChangedListener(lu0Var);
            this.g.setOnMediaSourceChangedListener(lu0Var);
        }
    }

    @Override // com.baidu.tieba.iu0
    public void L(String str, @NonNull HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, hashMap) == null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                this.g.setOption(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // com.baidu.tieba.iu0
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
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

    @Override // com.baidu.tieba.iu0
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (l(PlayerStatus.IDLE) && e() - this.g.getCurrentPosition() <= 2) {
                return f();
            }
            return this.g.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.iu0
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.s();
            if (l(PlayerStatus.PLAYING, PlayerStatus.PREPARED, PlayerStatus.PREPARING)) {
                n(PlayerStatus.PAUSE);
                this.g.pause();
            }
        }
    }
}
