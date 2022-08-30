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
/* loaded from: classes5.dex */
public final class pw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public cv0 a;
    public PlayerStatus b;
    public StringBuilder c;

    public pw0() {
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

    public void a(vr0 vr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vr0Var) == null) {
            if (vr0Var.getType() == 4 || vr0Var.getType() == 2) {
                String c = vr0Var.c();
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
                if (c2 == 0) {
                    int g = vr0Var.g(1);
                    if (904 == g || 956 == g) {
                        g(PlayerStatus.PLAYING);
                    }
                } else if (c2 == 1) {
                    g(PlayerStatus.COMPLETE);
                } else if (c2 == 2) {
                    g(PlayerStatus.PREPARED);
                } else if (c2 != 3) {
                } else {
                    g(PlayerStatus.ERROR);
                }
            }
        }
    }

    public void b(@NonNull cv0 cv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cv0Var) == null) {
            this.a = cv0Var;
        }
    }

    @NonNull
    public PlayerStatus c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (PlayerStatus) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h();
            this.b = PlayerStatus.IDLE;
        }
    }

    public void g(PlayerStatus playerStatus) {
        PlayerStatus playerStatus2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, playerStatus) == null) || playerStatus == (playerStatus2 = this.b)) {
            return;
        }
        this.b = playerStatus;
        cv0 cv0Var = this.a;
        if (cv0Var != null) {
            cv0Var.d(qr0.w(playerStatus2, playerStatus));
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a = null;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (ap0.f()) {
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
