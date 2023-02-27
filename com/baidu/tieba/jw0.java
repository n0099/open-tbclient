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
/* loaded from: classes5.dex */
public final class jw0 implements bx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vy0 a;
    public vy0 b;

    public jw0() {
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

    @Override // com.baidu.tieba.bx0
    public void a(it0 player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, player) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            i(player, player.u());
            vy0 k = player.k();
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

    @Override // com.baidu.tieba.bx0
    public vy0 b(it0 player, vy0 vy0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, player, vy0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1()) {
                vy0Var = h(player, player.u());
            }
            if (vy0Var == null) {
                vy0Var = f(player.o());
            }
            this.a = vy0Var;
            return vy0Var;
        }
        return (vy0) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.bx0
    public void c(it0 player, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, player, z) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            vy0 vy0Var = this.a;
            if (vy0Var != null) {
                e(player, vy0Var);
                return;
            }
            if (this.b == null) {
                this.b = f(player.o());
            }
            e(player, this.b);
        }
    }

    public final void e(it0 it0Var, vy0 vy0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, it0Var, vy0Var) == null) && vy0Var != null) {
            it0Var.e(vy0Var);
        }
    }

    @Override // com.baidu.tieba.bx0
    public boolean d(it0 player, vy0 vy0Var) {
        InterceptResult invokeLL;
        String vid;
        vy0 vy0Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, player, vy0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            BdVideoSeries o1 = player.o1();
            if (o1 == null || (vid = o1.getVid()) == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(vid, "player.videoSeries?.vid ?: return false");
            PlayerStatus playerStatus = null;
            if (!(vy0Var instanceof cz0)) {
                vy0Var2 = null;
            } else {
                vy0Var2 = vy0Var;
            }
            cz0 cz0Var = (cz0) vy0Var2;
            if (cz0Var != null) {
                str = cz0Var.y0();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(vid, str)) {
                return false;
            }
            if (vy0Var != null) {
                playerStatus = vy0Var.R();
            }
            if (!PlayerStatus.isActiveStatus(playerStatus)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(ht0 player, String str) {
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
            vy0 k = player.k();
            l11.a("ReuseHelper: detach,cache is " + k + ",cacheKey is " + str);
            if (k != null) {
                k.Y();
                zt0.a().c(str, k);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public vy0 h(ht0 player, String str) {
        InterceptResult invokeLL;
        Boolean bool;
        by0 T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            vy0 b = zt0.a().b(str);
            if (b != null && (T = b.T()) != null) {
                bool = Boolean.valueOf(T.verify(player.o()));
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                zt0.a().d(str);
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
        return (vy0) invokeLL.objValue;
    }

    public final cz0 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                str = "CyberNetPlayer";
            }
            return new cz0(str);
        }
        return (cz0) invokeL.objValue;
    }

    public final void j(vy0 vy0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, vy0Var) == null) && vy0Var != null) {
            vy0Var.Y();
            vy0Var.t0();
            vy0Var.a0();
        }
    }

    public void i(it0 player, String str) {
        Activity activity;
        ht0 ht0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, player, str) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1() && player.b0() && !player.S() && (activity = player.getActivity()) != null && activity.isFinishing()) {
                l11.a("performAutoDetachCache begin");
                vy0 A = player.A();
                vy0 vy0Var = this.a;
                if (vy0Var != null) {
                    ht0Var = vy0Var.u();
                } else {
                    ht0Var = null;
                }
                if (Intrinsics.areEqual(ht0Var, player)) {
                    l11.a("autoDetachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    if (g(player, str)) {
                        this.a = null;
                    }
                } else if (this.a != null) {
                    l11.a("detachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    vy0 vy0Var2 = this.a;
                    if (vy0Var2 != null) {
                        vy0Var2.Y();
                    }
                    zt0.a().c(str, this.a);
                    this.a = null;
                }
            }
        }
    }
}
