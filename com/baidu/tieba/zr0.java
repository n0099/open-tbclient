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
/* loaded from: classes6.dex */
public class zr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tr0 a;
    public nr0 b;

    public zr0() {
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007d, code lost:
        if (r0.equals(com.baidu.searchbox.player.event.PlayerEvent.ACTION_SEEK_COMPLETE) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(ht0 ht0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ht0Var) == null) {
            char c = 4;
            if (ht0Var.getType() == 4 || ht0Var.getType() == 2) {
                String c2 = ht0Var.c();
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
                        int g = ht0Var.g(1);
                        h(g, ht0Var.g(2), ht0Var.f(3));
                        a(g);
                        return;
                    case 1:
                        g(ht0Var.g(1), ht0Var.g(2), ht0Var.f(3));
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
                        q(ht0Var.g(5), ht0Var.g(6));
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

    public tr0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (tr0) invokeV.objValue;
    }

    public void d() {
        tr0 tr0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tr0Var = this.a) == null) {
            return;
        }
        tr0Var.onBufferEnd();
    }

    public void e() {
        tr0 tr0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (tr0Var = this.a) == null) {
            return;
        }
        tr0Var.onBufferStart();
    }

    public void f(int i) {
        tr0 tr0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (tr0Var = this.a) == null) {
            return;
        }
        tr0Var.onEnd(i);
    }

    public void g(int i, int i2, Object obj) {
        tr0 tr0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, obj) == null) || (tr0Var = this.a) == null) {
            return;
        }
        tr0Var.onError(i, i2, obj != null ? obj.toString() : "");
    }

    public void h(int i, int i2, Object obj) {
        tr0 tr0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, obj) == null) || (tr0Var = this.a) == null) {
            return;
        }
        tr0Var.onInfo(i, i2);
    }

    public void i(hw0 hw0Var) {
        nr0 nr0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hw0Var) == null) || (nr0Var = this.b) == null) {
            return;
        }
        nr0Var.a(hw0Var);
    }

    public void j(hw0 hw0Var) {
        nr0 nr0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, hw0Var) == null) || (nr0Var = this.b) == null) {
            return;
        }
        nr0Var.b(hw0Var);
    }

    public void k() {
        tr0 tr0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (tr0Var = this.a) == null) {
            return;
        }
        tr0Var.onPause();
    }

    public void l() {
        tr0 tr0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (tr0Var = this.a) == null) {
            return;
        }
        tr0Var.onPrepared();
    }

    public void m() {
        tr0 tr0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (tr0Var = this.a) == null) {
            return;
        }
        tr0Var.onResume();
    }

    public void n() {
        tr0 tr0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (tr0Var = this.a) == null) {
            return;
        }
        tr0Var.onSeekEnd();
    }

    public void o() {
        tr0 tr0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (tr0Var = this.a) == null) {
            return;
        }
        tr0Var.onStart();
    }

    public void p(int i, int i2, int i3) {
        tr0 tr0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048591, this, i, i2, i3) == null) || (tr0Var = this.a) == null) {
            return;
        }
        tr0Var.onUpdateProgress(i, i2, i3);
    }

    public void q(int i, int i2) {
        tr0 tr0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) || (tr0Var = this.a) == null) {
            return;
        }
        tr0Var.onVideoSizeChanged(i, i2);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.a = null;
            this.b = null;
        }
    }

    public void s(tr0 tr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, tr0Var) == null) {
            this.a = tr0Var;
        }
    }
}
