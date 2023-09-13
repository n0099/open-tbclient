package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ov0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public iv0 a;
    public cv0 b;

    public ov0() {
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

    public iv0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (iv0) invokeV.objValue;
    }

    public void d() {
        iv0 iv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (iv0Var = this.a) != null) {
            iv0Var.onBufferEnd();
        }
    }

    public void e() {
        iv0 iv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (iv0Var = this.a) != null) {
            iv0Var.onBufferStart();
        }
    }

    public void k() {
        iv0 iv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (iv0Var = this.a) != null) {
            iv0Var.onPause();
        }
    }

    public void l() {
        iv0 iv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (iv0Var = this.a) != null) {
            iv0Var.onPrepared();
        }
    }

    public void m() {
        iv0 iv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (iv0Var = this.a) != null) {
            iv0Var.onResume();
        }
    }

    public void n() {
        iv0 iv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (iv0Var = this.a) != null) {
            iv0Var.onSeekEnd();
        }
    }

    public void o() {
        iv0 iv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (iv0Var = this.a) != null) {
            iv0Var.onStart();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.a = null;
            this.b = null;
        }
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (701 == i) {
                e();
            } else if (702 == i) {
                d();
            }
        }
    }

    public void f(int i) {
        iv0 iv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (iv0Var = this.a) != null) {
            iv0Var.onEnd(i);
        }
    }

    public void i(wz0 wz0Var) {
        cv0 cv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wz0Var) == null) && (cv0Var = this.b) != null) {
            cv0Var.a(wz0Var);
        }
    }

    public void j(wz0 wz0Var) {
        cv0 cv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, wz0Var) == null) && (cv0Var = this.b) != null) {
            cv0Var.b(wz0Var);
        }
    }

    public void s(iv0 iv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, iv0Var) == null) {
            this.a = iv0Var;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007d, code lost:
        if (r0.equals(com.baidu.searchbox.player.event.PlayerEvent.ACTION_SEEK_COMPLETE) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(ww0 ww0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ww0Var) == null) {
            char c = 4;
            if (ww0Var.getType() == 4 || ww0Var.getType() == 2) {
                String c2 = ww0Var.c();
                switch (c2.hashCode()) {
                    case -1502879971:
                        if (c2.equals(PlayerEvent.ACTION_VIDEO_SIZE_CHANGED)) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1244137507:
                        break;
                    case -525235558:
                        if (c2.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -461848373:
                        if (c2.equals(PlayerEvent.ACTION_ON_ERROR)) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 154871702:
                        if (c2.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 720027695:
                        if (c2.equals(ControlEvent.ACTION_PAUSE)) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case 723345051:
                        if (c2.equals(ControlEvent.ACTION_START)) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case 906917140:
                        if (c2.equals(ControlEvent.ACTION_RESUME)) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1370689931:
                        if (c2.equals(PlayerEvent.ACTION_ON_INFO)) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1547354793:
                        if (c2.equals(ControlEvent.ACTION_STOP)) {
                            c = '\t';
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        int g = ww0Var.g(1);
                        h(g, ww0Var.g(2), ww0Var.f(3));
                        a(g);
                        return;
                    case 1:
                        g(ww0Var.g(1), ww0Var.g(2), ww0Var.f(3));
                        return;
                    case 2:
                        l();
                        return;
                    case 3:
                        f(307);
                        return;
                    case 4:
                        n();
                        return;
                    case 5:
                        q(ww0Var.g(5), ww0Var.g(6));
                        return;
                    case 6:
                        o();
                        return;
                    case 7:
                        m();
                        return;
                    case '\b':
                        k();
                        return;
                    case '\t':
                        f(0);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void g(int i, int i2, Object obj) {
        iv0 iv0Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, obj) == null) && (iv0Var = this.a) != null) {
            if (obj != null) {
                str = obj.toString();
            } else {
                str = "";
            }
            iv0Var.onError(i, i2, str);
        }
    }

    public void h(int i, int i2, Object obj) {
        iv0 iv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, obj) == null) && (iv0Var = this.a) != null) {
            iv0Var.onInfo(i, i2);
        }
    }

    public void p(int i, int i2, int i3) {
        iv0 iv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048591, this, i, i2, i3) == null) && (iv0Var = this.a) != null) {
            iv0Var.onUpdateProgress(i, i2, i3);
        }
    }

    public void q(int i, int i2) {
        iv0 iv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) && (iv0Var = this.a) != null) {
            iv0Var.onVideoSizeChanged(i, i2);
        }
    }
}
