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
public final class pt0 implements hu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bw0 a;
    public bw0 b;

    public pt0() {
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

    @Override // com.baidu.tieba.hu0
    public void a(oq0 player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, player) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            i(player, player.u());
            bw0 k = player.k();
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

    @Override // com.baidu.tieba.hu0
    public bw0 b(oq0 player, bw0 bw0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, player, bw0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1()) {
                bw0Var = h(player, player.u());
            }
            if (bw0Var == null) {
                bw0Var = f(player.o());
            }
            this.a = bw0Var;
            return bw0Var;
        }
        return (bw0) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.hu0
    public void c(oq0 player, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, player, z) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            bw0 bw0Var = this.a;
            if (bw0Var != null) {
                e(player, bw0Var);
                return;
            }
            if (this.b == null) {
                this.b = f(player.o());
            }
            e(player, this.b);
        }
    }

    @Override // com.baidu.tieba.hu0
    public boolean d(oq0 player, bw0 bw0Var) {
        InterceptResult invokeLL;
        String vid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, player, bw0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            BdVideoSeries o1 = player.o1();
            if (o1 == null || (vid = o1.getVid()) == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(vid, "player.videoSeries?.vid ?: return false");
            iw0 iw0Var = (iw0) (!(bw0Var instanceof iw0) ? null : bw0Var);
            if (Intrinsics.areEqual(vid, iw0Var != null ? iw0Var.y0() : null)) {
                return PlayerStatus.isActiveStatus(bw0Var != null ? bw0Var.R() : null);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void e(oq0 oq0Var, bw0 bw0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, oq0Var, bw0Var) == null) || bw0Var == null) {
            return;
        }
        oq0Var.e(bw0Var);
    }

    public final iw0 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                str = "CyberNetPlayer";
            }
            return new iw0(str);
        }
        return (iw0) invokeL.objValue;
    }

    public boolean g(nq0 player, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (str == null || str.length() == 0) {
                return false;
            }
            bw0 k = player.k();
            qy0.a("ReuseHelper: detach,cache is " + k + ",cacheKey is " + str);
            if (k != null) {
                k.Y();
                fr0.a().c(str, k);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public bw0 h(nq0 player, String str) {
        InterceptResult invokeLL;
        hv0 T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            bw0 b = fr0.a().b(str);
            if (Intrinsics.areEqual((b == null || (T = b.T()) == null) ? null : Boolean.valueOf(T.verify(player.o())), Boolean.TRUE)) {
                fr0.a().d(str);
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
        return (bw0) invokeLL.objValue;
    }

    public void i(oq0 player, String str) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, player, str) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1() && player.b0() && !player.S() && (activity = player.getActivity()) != null && activity.isFinishing()) {
                qy0.a("performAutoDetachCache begin");
                bw0 A = player.A();
                bw0 bw0Var = this.a;
                if (Intrinsics.areEqual(bw0Var != null ? bw0Var.u() : null, player)) {
                    qy0.a("autoDetachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    if (g(player, str)) {
                        this.a = null;
                    }
                } else if (this.a != null) {
                    qy0.a("detachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    bw0 bw0Var2 = this.a;
                    if (bw0Var2 != null) {
                        bw0Var2.Y();
                    }
                    fr0.a().c(str, this.a);
                    this.a = null;
                }
            }
        }
    }

    public final void j(bw0 bw0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bw0Var) == null) || bw0Var == null) {
            return;
        }
        bw0Var.Y();
        bw0Var.t0();
        bw0Var.a0();
    }
}
