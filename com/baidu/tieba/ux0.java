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
/* loaded from: classes8.dex */
public final class ux0 implements my0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g01 a;
    public g01 b;

    public ux0() {
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

    @Override // com.baidu.tieba.my0
    public void a(tu0 player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, player) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            i(player, player.u());
            g01 k = player.k();
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

    @Override // com.baidu.tieba.my0
    public g01 b(tu0 player, g01 g01Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, player, g01Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1()) {
                g01Var = h(player, player.u());
            }
            if (g01Var == null) {
                g01Var = f(player.o());
            }
            this.a = g01Var;
            return g01Var;
        }
        return (g01) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.my0
    public void c(tu0 player, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, player, z) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            g01 g01Var = this.a;
            if (g01Var != null) {
                e(player, g01Var);
                return;
            }
            if (this.b == null) {
                this.b = f(player.o());
            }
            e(player, this.b);
        }
    }

    public final void e(tu0 tu0Var, g01 g01Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, tu0Var, g01Var) == null) && g01Var != null) {
            tu0Var.e(g01Var);
        }
    }

    @Override // com.baidu.tieba.my0
    public boolean d(tu0 player, g01 g01Var) {
        InterceptResult invokeLL;
        String vid;
        g01 g01Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, player, g01Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            BdVideoSeries o1 = player.o1();
            if (o1 == null || (vid = o1.getVid()) == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(vid, "player.videoSeries?.vid ?: return false");
            PlayerStatus playerStatus = null;
            if (!(g01Var instanceof n01)) {
                g01Var2 = null;
            } else {
                g01Var2 = g01Var;
            }
            n01 n01Var = (n01) g01Var2;
            if (n01Var != null) {
                str = n01Var.A0();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(vid, str)) {
                return false;
            }
            if (g01Var != null) {
                playerStatus = g01Var.T();
            }
            if (!PlayerStatus.isActiveStatus(playerStatus)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(su0 player, String str) {
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
            g01 k = player.k();
            v21.a("ReuseHelper: detach,cache is " + k + ",cacheKey is " + str);
            if (k != null) {
                k.a0();
                kv0.a().c(str, k);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public g01 h(su0 player, String str) {
        InterceptResult invokeLL;
        Boolean bool;
        mz0 V;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            g01 b = kv0.a().b(str);
            if (b != null && (V = b.V()) != null) {
                bool = Boolean.valueOf(V.verify(player.o()));
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                kv0.a().d(str);
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
        return (g01) invokeLL.objValue;
    }

    public final n01 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                str = "CyberNetPlayer";
            }
            return new n01(str);
        }
        return (n01) invokeL.objValue;
    }

    public final void j(g01 g01Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, g01Var) == null) && g01Var != null) {
            g01Var.a0();
            g01Var.v0();
            g01Var.c0();
        }
    }

    public void i(tu0 player, String str) {
        Activity activity;
        su0 su0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, player, str) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1() && player.b0() && !player.S() && (activity = player.getActivity()) != null && activity.isFinishing()) {
                v21.a("performAutoDetachCache begin");
                g01 A = player.A();
                g01 g01Var = this.a;
                if (g01Var != null) {
                    su0Var = g01Var.u();
                } else {
                    su0Var = null;
                }
                if (Intrinsics.areEqual(su0Var, player)) {
                    v21.a("autoDetachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    if (g(player, str)) {
                        this.a = null;
                    }
                } else if (this.a != null) {
                    v21.a("detachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    g01 g01Var2 = this.a;
                    if (g01Var2 != null) {
                        g01Var2.a0();
                    }
                    kv0.a().c(str, this.a);
                    this.a = null;
                }
            }
        }
    }
}
