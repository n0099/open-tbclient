package com.baidu.tieba;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class zu0 implements rv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lx0 a;
    public lx0 b;

    public zu0() {
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

    @Override // com.baidu.tieba.rv0
    public void a(yr0 player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, player) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            i(player, player.u());
            lx0 k = player.k();
            if (k != null) {
                if (!Intrinsics.areEqual(k, this.b)) {
                    j(this.b);
                    this.b = null;
                } else if (!Intrinsics.areEqual(k, this.a)) {
                    j(this.a);
                    this.a = null;
                }
                j(k);
            }
        }
    }

    @Override // com.baidu.tieba.rv0
    public lx0 b(yr0 player, lx0 lx0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, player, lx0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1()) {
                lx0Var = h(player, player.u());
            }
            if (lx0Var == null) {
                lx0Var = f(player.o());
            }
            this.a = lx0Var;
            return lx0Var;
        }
        return (lx0) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.rv0
    public void c(yr0 player, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, player, z) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            lx0 lx0Var = this.a;
            if (lx0Var != null) {
                e(player, lx0Var);
                return;
            }
            if (this.b == null) {
                this.b = f(player.o());
            }
            e(player, this.b);
        }
    }

    public final void e(yr0 yr0Var, lx0 lx0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, yr0Var, lx0Var) == null) && lx0Var != null) {
            yr0Var.e(lx0Var);
        }
    }

    @Override // com.baidu.tieba.rv0
    public boolean d(yr0 player, lx0 lx0Var) {
        InterceptResult invokeLL;
        String vid;
        lx0 lx0Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, player, lx0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            BdVideoSeries o1 = player.o1();
            if (o1 == null || (vid = o1.getVid()) == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(vid, "player.videoSeries?.vid ?: return false");
            PlayerStatus playerStatus = null;
            if (!(lx0Var instanceof sx0)) {
                lx0Var2 = null;
            } else {
                lx0Var2 = lx0Var;
            }
            sx0 sx0Var = (sx0) lx0Var2;
            if (sx0Var != null) {
                str = sx0Var.A0();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(vid, str)) {
                return false;
            }
            if (lx0Var != null) {
                playerStatus = lx0Var.T();
            }
            if (!PlayerStatus.isActiveStatus(playerStatus)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(xr0 player, String str) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return false;
            }
            lx0 k = player.k();
            b01.a("ReuseHelper: detach,cache is " + k + ",cacheKey is " + str);
            if (k != null) {
                k.a0();
                ps0.a().c(str, k);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public lx0 h(xr0 player, String str) {
        InterceptResult invokeLL;
        Boolean bool;
        rw0 V;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            lx0 b = ps0.a().b(str);
            if (b != null && (V = b.V()) != null) {
                bool = Boolean.valueOf(V.verify(player.o()));
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                ps0.a().d(str);
                player.A0(true);
                if (b.u() != null) {
                    b.u().k();
                    return b;
                }
                return b;
            }
            player.A0(false);
            return null;
        }
        return (lx0) invokeLL.objValue;
    }

    public final sx0 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                str = "CyberNetPlayer";
            }
            return new sx0(str);
        }
        return (sx0) invokeL.objValue;
    }

    public final void j(lx0 lx0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, lx0Var) == null) && lx0Var != null) {
            lx0Var.a0();
            lx0Var.v0();
            lx0Var.c0();
        }
    }

    public void i(yr0 player, String str) {
        Activity activity;
        xr0 xr0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, player, str) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1() && player.b0() && !player.S() && (activity = player.getActivity()) != null && activity.isFinishing()) {
                b01.a("performAutoDetachCache begin");
                lx0 A = player.A();
                lx0 lx0Var = this.a;
                if (lx0Var != null) {
                    xr0Var = lx0Var.u();
                } else {
                    xr0Var = null;
                }
                if (Intrinsics.areEqual(xr0Var, player)) {
                    b01.a("autoDetachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    if (g(player, str)) {
                        this.a = null;
                    }
                } else if (this.a != null) {
                    b01.a("detachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    lx0 lx0Var2 = this.a;
                    if (lx0Var2 != null) {
                        lx0Var2.a0();
                    }
                    ps0.a().c(str, this.a);
                    this.a = null;
                }
            }
        }
    }
}
