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
public final class ss0 implements jt0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dv0 a;
    public dv0 b;

    public ss0() {
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

    @Override // com.baidu.tieba.jt0
    public void a(rp0 player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, player) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            i(player, player.v());
            dv0 k = player.k();
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

    @Override // com.baidu.tieba.jt0
    public dv0 b(rp0 player, dv0 dv0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, player, dv0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.q1()) {
                dv0Var = h(player, player.v());
            }
            if (dv0Var == null) {
                dv0Var = f(player.p());
            }
            this.a = dv0Var;
            return dv0Var;
        }
        return (dv0) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.jt0
    public void c(rp0 player, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, player, z) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            dv0 dv0Var = this.a;
            if (dv0Var != null) {
                e(player, dv0Var);
                return;
            }
            if (this.b == null) {
                this.b = f(player.p());
            }
            e(player, this.b);
        }
    }

    public final void e(rp0 rp0Var, dv0 dv0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, rp0Var, dv0Var) == null) && dv0Var != null) {
            rp0Var.e(dv0Var);
        }
    }

    @Override // com.baidu.tieba.jt0
    public boolean d(rp0 player, dv0 dv0Var) {
        InterceptResult invokeLL;
        String vid;
        dv0 dv0Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, player, dv0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            BdVideoSeries j1 = player.j1();
            if (j1 == null || (vid = j1.getVid()) == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(vid, "player.videoSeries?.vid ?: return false");
            PlayerStatus playerStatus = null;
            if (!(dv0Var instanceof kv0)) {
                dv0Var2 = null;
            } else {
                dv0Var2 = dv0Var;
            }
            kv0 kv0Var = (kv0) dv0Var2;
            if (kv0Var != null) {
                str = kv0Var.z0();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(vid, str)) {
                return false;
            }
            if (dv0Var != null) {
                playerStatus = dv0Var.U();
            }
            if (!PlayerStatus.isActiveStatus(playerStatus)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(qp0 player, String str) {
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
            dv0 k = player.k();
            jx0.a("ReuseHelper: detach,cache is " + k + ",cacheKey is " + str);
            if (k != null) {
                k.Z();
                iq0.a().c(str, k);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public dv0 h(qp0 player, String str) {
        InterceptResult invokeLL;
        Boolean bool;
        ju0 V;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            dv0 b = iq0.a().b(str);
            if (b != null && (V = b.V()) != null) {
                bool = Boolean.valueOf(V.verify(player.p()));
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                iq0.a().d(str);
                player.y0(true);
                if (b.y() != null) {
                    b.y().k();
                    return b;
                }
                return b;
            }
            player.y0(false);
            return null;
        }
        return (dv0) invokeLL.objValue;
    }

    public final kv0 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                str = "CyberNetPlayer";
            }
            return new kv0(str);
        }
        return (kv0) invokeL.objValue;
    }

    public final void j(dv0 dv0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, dv0Var) == null) && dv0Var != null) {
            dv0Var.Z();
            dv0Var.u0();
            dv0Var.b0();
        }
    }

    public void i(rp0 player, String str) {
        Activity m;
        qp0 qp0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, player, str) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.q1() && player.Z() && !player.R() && (m = player.m()) != null && m.isFinishing()) {
                jx0.a("performAutoDetachCache begin");
                dv0 B = player.B();
                dv0 dv0Var = this.a;
                if (dv0Var != null) {
                    qp0Var = dv0Var.y();
                } else {
                    qp0Var = null;
                }
                if (Intrinsics.areEqual(qp0Var, player)) {
                    jx0.a("autoDetachCache,cacheKey:" + str + ", kernelLayer:" + B);
                    if (g(player, str)) {
                        this.a = null;
                    }
                } else if (this.a != null) {
                    jx0.a("detachCache,cacheKey:" + str + ", kernelLayer:" + B);
                    dv0 dv0Var2 = this.a;
                    if (dv0Var2 != null) {
                        dv0Var2.Z();
                    }
                    iq0.a().c(str, this.a);
                    this.a = null;
                }
            }
        }
    }
}
