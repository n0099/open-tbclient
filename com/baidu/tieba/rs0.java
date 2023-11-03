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
public final class rs0 implements it0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cv0 a;
    public cv0 b;

    public rs0() {
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

    @Override // com.baidu.tieba.it0
    public void a(qp0 player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, player) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            i(player, player.v());
            cv0 k = player.k();
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

    @Override // com.baidu.tieba.it0
    public cv0 b(qp0 player, cv0 cv0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, player, cv0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.q1()) {
                cv0Var = h(player, player.v());
            }
            if (cv0Var == null) {
                cv0Var = f(player.p());
            }
            this.a = cv0Var;
            return cv0Var;
        }
        return (cv0) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.it0
    public void c(qp0 player, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, player, z) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            cv0 cv0Var = this.a;
            if (cv0Var != null) {
                e(player, cv0Var);
                return;
            }
            if (this.b == null) {
                this.b = f(player.p());
            }
            e(player, this.b);
        }
    }

    public final void e(qp0 qp0Var, cv0 cv0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, qp0Var, cv0Var) == null) && cv0Var != null) {
            qp0Var.e(cv0Var);
        }
    }

    @Override // com.baidu.tieba.it0
    public boolean d(qp0 player, cv0 cv0Var) {
        InterceptResult invokeLL;
        String vid;
        cv0 cv0Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, player, cv0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            BdVideoSeries j1 = player.j1();
            if (j1 == null || (vid = j1.getVid()) == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(vid, "player.videoSeries?.vid ?: return false");
            PlayerStatus playerStatus = null;
            if (!(cv0Var instanceof jv0)) {
                cv0Var2 = null;
            } else {
                cv0Var2 = cv0Var;
            }
            jv0 jv0Var = (jv0) cv0Var2;
            if (jv0Var != null) {
                str = jv0Var.z0();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(vid, str)) {
                return false;
            }
            if (cv0Var != null) {
                playerStatus = cv0Var.U();
            }
            if (!PlayerStatus.isActiveStatus(playerStatus)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(pp0 player, String str) {
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
            cv0 k = player.k();
            ix0.a("ReuseHelper: detach,cache is " + k + ",cacheKey is " + str);
            if (k != null) {
                k.Z();
                hq0.a().c(str, k);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public cv0 h(pp0 player, String str) {
        InterceptResult invokeLL;
        Boolean bool;
        iu0 V;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            cv0 b = hq0.a().b(str);
            if (b != null && (V = b.V()) != null) {
                bool = Boolean.valueOf(V.verify(player.p()));
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                hq0.a().d(str);
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
        return (cv0) invokeLL.objValue;
    }

    public final jv0 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                str = "CyberNetPlayer";
            }
            return new jv0(str);
        }
        return (jv0) invokeL.objValue;
    }

    public final void j(cv0 cv0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, cv0Var) == null) && cv0Var != null) {
            cv0Var.Z();
            cv0Var.u0();
            cv0Var.b0();
        }
    }

    public void i(qp0 player, String str) {
        Activity m;
        pp0 pp0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, player, str) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.q1() && player.Z() && !player.R() && (m = player.m()) != null && m.isFinishing()) {
                ix0.a("performAutoDetachCache begin");
                cv0 B = player.B();
                cv0 cv0Var = this.a;
                if (cv0Var != null) {
                    pp0Var = cv0Var.y();
                } else {
                    pp0Var = null;
                }
                if (Intrinsics.areEqual(pp0Var, player)) {
                    ix0.a("autoDetachCache,cacheKey:" + str + ", kernelLayer:" + B);
                    if (g(player, str)) {
                        this.a = null;
                    }
                } else if (this.a != null) {
                    ix0.a("detachCache,cacheKey:" + str + ", kernelLayer:" + B);
                    cv0 cv0Var2 = this.a;
                    if (cv0Var2 != null) {
                        cv0Var2.Z();
                    }
                    hq0.a().c(str, this.a);
                    this.a = null;
                }
            }
        }
    }
}
