package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class o11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public b01 a;
    public PlayerStatus b;
    public StringBuilder c;

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public o11() {
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

    @NonNull
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

    public void a(uw0 uw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, uw0Var) == null) {
            if (uw0Var.getType() != 4 && uw0Var.getType() != 2) {
                return;
            }
            String c = uw0Var.c();
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
            int g = uw0Var.g(1);
            if (904 == g || 956 == g) {
                g(PlayerStatus.PLAYING);
            }
        }
    }

    public void b(@NonNull b01 b01Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b01Var) == null) {
            this.a = b01Var;
        }
    }

    public boolean e(@NonNull PlayerStatus... playerStatusArr) {
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
        b01 b01Var = this.a;
        if (b01Var != null) {
            b01Var.d(pw0.w(playerStatus2, playerStatus));
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (zt0.f()) {
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
