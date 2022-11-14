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
/* loaded from: classes6.dex */
public final class vu0 implements nv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hx0 a;
    public hx0 b;

    public vu0() {
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

    @Override // com.baidu.tieba.nv0
    public void a(ur0 player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, player) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            i(player, player.u());
            hx0 k = player.k();
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

    @Override // com.baidu.tieba.nv0
    public hx0 b(ur0 player, hx0 hx0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, player, hx0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1()) {
                hx0Var = h(player, player.u());
            }
            if (hx0Var == null) {
                hx0Var = f(player.o());
            }
            this.a = hx0Var;
            return hx0Var;
        }
        return (hx0) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.nv0
    public void c(ur0 player, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, player, z) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            hx0 hx0Var = this.a;
            if (hx0Var != null) {
                e(player, hx0Var);
                return;
            }
            if (this.b == null) {
                this.b = f(player.o());
            }
            e(player, this.b);
        }
    }

    public final void e(ur0 ur0Var, hx0 hx0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, ur0Var, hx0Var) == null) && hx0Var != null) {
            ur0Var.e(hx0Var);
        }
    }

    @Override // com.baidu.tieba.nv0
    public boolean d(ur0 player, hx0 hx0Var) {
        InterceptResult invokeLL;
        String vid;
        hx0 hx0Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, player, hx0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            BdVideoSeries o1 = player.o1();
            if (o1 == null || (vid = o1.getVid()) == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(vid, "player.videoSeries?.vid ?: return false");
            PlayerStatus playerStatus = null;
            if (!(hx0Var instanceof ox0)) {
                hx0Var2 = null;
            } else {
                hx0Var2 = hx0Var;
            }
            ox0 ox0Var = (ox0) hx0Var2;
            if (ox0Var != null) {
                str = ox0Var.y0();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(vid, str)) {
                return false;
            }
            if (hx0Var != null) {
                playerStatus = hx0Var.R();
            }
            if (!PlayerStatus.isActiveStatus(playerStatus)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(tr0 player, String str) {
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
            hx0 k = player.k();
            wz0.a("ReuseHelper: detach,cache is " + k + ",cacheKey is " + str);
            if (k != null) {
                k.Y();
                ls0.a().c(str, k);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public hx0 h(tr0 player, String str) {
        InterceptResult invokeLL;
        Boolean bool;
        nw0 T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            hx0 b = ls0.a().b(str);
            if (b != null && (T = b.T()) != null) {
                bool = Boolean.valueOf(T.verify(player.o()));
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                ls0.a().d(str);
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
        return (hx0) invokeLL.objValue;
    }

    public final ox0 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                str = "CyberNetPlayer";
            }
            return new ox0(str);
        }
        return (ox0) invokeL.objValue;
    }

    public final void j(hx0 hx0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, hx0Var) == null) && hx0Var != null) {
            hx0Var.Y();
            hx0Var.t0();
            hx0Var.a0();
        }
    }

    public void i(ur0 player, String str) {
        Activity activity;
        tr0 tr0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, player, str) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1() && player.b0() && !player.S() && (activity = player.getActivity()) != null && activity.isFinishing()) {
                wz0.a("performAutoDetachCache begin");
                hx0 A = player.A();
                hx0 hx0Var = this.a;
                if (hx0Var != null) {
                    tr0Var = hx0Var.u();
                } else {
                    tr0Var = null;
                }
                if (Intrinsics.areEqual(tr0Var, player)) {
                    wz0.a("autoDetachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    if (g(player, str)) {
                        this.a = null;
                    }
                } else if (this.a != null) {
                    wz0.a("detachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    hx0 hx0Var2 = this.a;
                    if (hx0Var2 != null) {
                        hx0Var2.Y();
                    }
                    ls0.a().c(str, this.a);
                    this.a = null;
                }
            }
        }
    }
}
