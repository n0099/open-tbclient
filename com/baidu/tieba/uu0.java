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
public final class uu0 implements mv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gx0 a;
    public gx0 b;

    public uu0() {
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

    @Override // com.baidu.tieba.mv0
    public void a(tr0 player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, player) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            i(player, player.u());
            gx0 k = player.k();
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

    @Override // com.baidu.tieba.mv0
    public gx0 b(tr0 player, gx0 gx0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, player, gx0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1()) {
                gx0Var = h(player, player.u());
            }
            if (gx0Var == null) {
                gx0Var = f(player.o());
            }
            this.a = gx0Var;
            return gx0Var;
        }
        return (gx0) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.mv0
    public void c(tr0 player, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, player, z) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            gx0 gx0Var = this.a;
            if (gx0Var != null) {
                e(player, gx0Var);
                return;
            }
            if (this.b == null) {
                this.b = f(player.o());
            }
            e(player, this.b);
        }
    }

    public final void e(tr0 tr0Var, gx0 gx0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, tr0Var, gx0Var) == null) && gx0Var != null) {
            tr0Var.e(gx0Var);
        }
    }

    @Override // com.baidu.tieba.mv0
    public boolean d(tr0 player, gx0 gx0Var) {
        InterceptResult invokeLL;
        String vid;
        gx0 gx0Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, player, gx0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            BdVideoSeries o1 = player.o1();
            if (o1 == null || (vid = o1.getVid()) == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(vid, "player.videoSeries?.vid ?: return false");
            PlayerStatus playerStatus = null;
            if (!(gx0Var instanceof nx0)) {
                gx0Var2 = null;
            } else {
                gx0Var2 = gx0Var;
            }
            nx0 nx0Var = (nx0) gx0Var2;
            if (nx0Var != null) {
                str = nx0Var.y0();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(vid, str)) {
                return false;
            }
            if (gx0Var != null) {
                playerStatus = gx0Var.R();
            }
            if (!PlayerStatus.isActiveStatus(playerStatus)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(sr0 player, String str) {
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
            gx0 k = player.k();
            vz0.a("ReuseHelper: detach,cache is " + k + ",cacheKey is " + str);
            if (k != null) {
                k.Y();
                ks0.a().c(str, k);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public gx0 h(sr0 player, String str) {
        InterceptResult invokeLL;
        Boolean bool;
        mw0 T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            gx0 b = ks0.a().b(str);
            if (b != null && (T = b.T()) != null) {
                bool = Boolean.valueOf(T.verify(player.o()));
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                ks0.a().d(str);
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
        return (gx0) invokeLL.objValue;
    }

    public final nx0 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                str = "CyberNetPlayer";
            }
            return new nx0(str);
        }
        return (nx0) invokeL.objValue;
    }

    public final void j(gx0 gx0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, gx0Var) == null) && gx0Var != null) {
            gx0Var.Y();
            gx0Var.t0();
            gx0Var.a0();
        }
    }

    public void i(tr0 player, String str) {
        Activity activity;
        sr0 sr0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, player, str) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1() && player.b0() && !player.S() && (activity = player.getActivity()) != null && activity.isFinishing()) {
                vz0.a("performAutoDetachCache begin");
                gx0 A = player.A();
                gx0 gx0Var = this.a;
                if (gx0Var != null) {
                    sr0Var = gx0Var.u();
                } else {
                    sr0Var = null;
                }
                if (Intrinsics.areEqual(sr0Var, player)) {
                    vz0.a("autoDetachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    if (g(player, str)) {
                        this.a = null;
                    }
                } else if (this.a != null) {
                    vz0.a("detachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    gx0 gx0Var2 = this.a;
                    if (gx0Var2 != null) {
                        gx0Var2.Y();
                    }
                    ks0.a().c(str, this.a);
                    this.a = null;
                }
            }
        }
    }
}
