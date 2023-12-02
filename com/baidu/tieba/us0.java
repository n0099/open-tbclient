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
public final class us0 implements lt0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fv0 a;
    public fv0 b;

    public us0() {
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

    @Override // com.baidu.tieba.lt0
    public void a(tp0 player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, player) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            i(player, player.v());
            fv0 k = player.k();
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

    @Override // com.baidu.tieba.lt0
    public fv0 b(tp0 player, fv0 fv0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, player, fv0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.q1()) {
                fv0Var = h(player, player.v());
            }
            if (fv0Var == null) {
                fv0Var = f(player.p());
            }
            this.a = fv0Var;
            return fv0Var;
        }
        return (fv0) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.lt0
    public void c(tp0 player, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, player, z) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            fv0 fv0Var = this.a;
            if (fv0Var != null) {
                e(player, fv0Var);
                return;
            }
            if (this.b == null) {
                this.b = f(player.p());
            }
            e(player, this.b);
        }
    }

    public final void e(tp0 tp0Var, fv0 fv0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, tp0Var, fv0Var) == null) && fv0Var != null) {
            tp0Var.e(fv0Var);
        }
    }

    @Override // com.baidu.tieba.lt0
    public boolean d(tp0 player, fv0 fv0Var) {
        InterceptResult invokeLL;
        String vid;
        fv0 fv0Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, player, fv0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            BdVideoSeries j1 = player.j1();
            if (j1 == null || (vid = j1.getVid()) == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(vid, "player.videoSeries?.vid ?: return false");
            PlayerStatus playerStatus = null;
            if (!(fv0Var instanceof mv0)) {
                fv0Var2 = null;
            } else {
                fv0Var2 = fv0Var;
            }
            mv0 mv0Var = (mv0) fv0Var2;
            if (mv0Var != null) {
                str = mv0Var.z0();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(vid, str)) {
                return false;
            }
            if (fv0Var != null) {
                playerStatus = fv0Var.U();
            }
            if (!PlayerStatus.isActiveStatus(playerStatus)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(sp0 player, String str) {
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
            fv0 k = player.k();
            lx0.a("ReuseHelper: detach,cache is " + k + ",cacheKey is " + str);
            if (k != null) {
                k.Z();
                kq0.a().c(str, k);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public fv0 h(sp0 player, String str) {
        InterceptResult invokeLL;
        Boolean bool;
        lu0 V;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            fv0 b = kq0.a().b(str);
            if (b != null && (V = b.V()) != null) {
                bool = Boolean.valueOf(V.verify(player.p()));
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                kq0.a().d(str);
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
        return (fv0) invokeLL.objValue;
    }

    public final mv0 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                str = "CyberNetPlayer";
            }
            return new mv0(str);
        }
        return (mv0) invokeL.objValue;
    }

    public final void j(fv0 fv0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, fv0Var) == null) && fv0Var != null) {
            fv0Var.Z();
            fv0Var.u0();
            fv0Var.b0();
        }
    }

    public void i(tp0 player, String str) {
        Activity m;
        sp0 sp0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, player, str) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.q1() && player.Z() && !player.R() && (m = player.m()) != null && m.isFinishing()) {
                lx0.a("performAutoDetachCache begin");
                fv0 B = player.B();
                fv0 fv0Var = this.a;
                if (fv0Var != null) {
                    sp0Var = fv0Var.y();
                } else {
                    sp0Var = null;
                }
                if (Intrinsics.areEqual(sp0Var, player)) {
                    lx0.a("autoDetachCache,cacheKey:" + str + ", kernelLayer:" + B);
                    if (g(player, str)) {
                        this.a = null;
                    }
                } else if (this.a != null) {
                    lx0.a("detachCache,cacheKey:" + str + ", kernelLayer:" + B);
                    fv0 fv0Var2 = this.a;
                    if (fv0Var2 != null) {
                        fv0Var2.Z();
                    }
                    kq0.a().c(str, this.a);
                    this.a = null;
                }
            }
        }
    }
}
