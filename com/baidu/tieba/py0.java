package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class py0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cx0 a;
    public PlayerStatus b;
    public StringBuilder c;

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public py0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = PlayerStatus.IDLE;
        d();
    }

    public PlayerStatus c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (PlayerStatus) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h();
            this.b = PlayerStatus.IDLE;
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a = null;
        }
    }

    public void a(vt0 vt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vt0Var) == null) {
            if (vt0Var.getType() != 4 && vt0Var.getType() != 2) {
                return;
            }
            String c = vt0Var.c();
            char c2 = 65535;
            switch (c.hashCode()) {
                case -525235558:
                    if (c.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -461848373:
                    if (c.equals(PlayerEvent.ACTION_ON_ERROR)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 154871702:
                    if (c.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1370689931:
                    if (c.equals(PlayerEvent.ACTION_ON_INFO)) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 == 3) {
                            g(PlayerStatus.ERROR);
                            return;
                        }
                        return;
                    }
                    g(PlayerStatus.PREPARED);
                    return;
                }
                g(PlayerStatus.COMPLETE);
                return;
            }
            int g = vt0Var.g(1);
            if (904 == g || 956 == g) {
                g(PlayerStatus.PLAYING);
            }
        }
    }

    public void b(cx0 cx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cx0Var) == null) {
            this.a = cx0Var;
        }
    }

    public boolean e(PlayerStatus... playerStatusArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, playerStatusArr)) == null) {
            for (PlayerStatus playerStatus : playerStatusArr) {
                if (playerStatus == c()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(PlayerStatus playerStatus) {
        PlayerStatus playerStatus2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, playerStatus) != null) || playerStatus == (playerStatus2 = this.b)) {
            return;
        }
        this.b = playerStatus;
        cx0 cx0Var = this.a;
        if (cx0Var != null) {
            cx0Var.d(qt0.w(playerStatus2, playerStatus));
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (ar0.f()) {
                StringBuilder sb = this.c;
                if (sb == null) {
                    this.c = new StringBuilder();
                } else if (sb.length() > 0) {
                    StringBuilder sb2 = this.c;
                    sb2.delete(0, sb2.length());
                }
                StringBuilder sb3 = this.c;
                sb3.append("，Courier :");
                sb3.append(this.a);
                sb3.append("，status :");
                sb3.append(this.b);
                sb3.append("，hash :");
                sb3.append(hashCode());
                sb3.append("】");
                return this.c.toString();
            }
            return super.toString();
        }
        return (String) invokeV.objValue;
    }
}
