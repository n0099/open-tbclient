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
public class kv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ev0 a;
    public yu0 b;

    public kv0() {
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

    public ev0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (ev0) invokeV.objValue;
    }

    public void d() {
        ev0 ev0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (ev0Var = this.a) != null) {
            ev0Var.onBufferEnd();
        }
    }

    public void e() {
        ev0 ev0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (ev0Var = this.a) != null) {
            ev0Var.onBufferStart();
        }
    }

    public void k() {
        ev0 ev0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (ev0Var = this.a) != null) {
            ev0Var.onPause();
        }
    }

    public void l() {
        ev0 ev0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (ev0Var = this.a) != null) {
            ev0Var.onPrepared();
        }
    }

    public void m() {
        ev0 ev0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (ev0Var = this.a) != null) {
            ev0Var.onResume();
        }
    }

    public void n() {
        ev0 ev0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (ev0Var = this.a) != null) {
            ev0Var.onSeekEnd();
        }
    }

    public void o() {
        ev0 ev0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (ev0Var = this.a) != null) {
            ev0Var.onStart();
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
        ev0 ev0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (ev0Var = this.a) != null) {
            ev0Var.onEnd(i);
        }
    }

    public void i(sz0 sz0Var) {
        yu0 yu0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sz0Var) == null) && (yu0Var = this.b) != null) {
            yu0Var.a(sz0Var);
        }
    }

    public void j(sz0 sz0Var) {
        yu0 yu0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, sz0Var) == null) && (yu0Var = this.b) != null) {
            yu0Var.b(sz0Var);
        }
    }

    public void s(ev0 ev0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, ev0Var) == null) {
            this.a = ev0Var;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007d, code lost:
        if (r0.equals(com.baidu.searchbox.player.event.PlayerEvent.ACTION_SEEK_COMPLETE) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(sw0 sw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sw0Var) == null) {
            char c = 4;
            if (sw0Var.getType() == 4 || sw0Var.getType() == 2) {
                String c2 = sw0Var.c();
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
                        int g = sw0Var.g(1);
                        h(g, sw0Var.g(2), sw0Var.f(3));
                        a(g);
                        return;
                    case 1:
                        g(sw0Var.g(1), sw0Var.g(2), sw0Var.f(3));
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
                        q(sw0Var.g(5), sw0Var.g(6));
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
        ev0 ev0Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, obj) == null) && (ev0Var = this.a) != null) {
            if (obj != null) {
                str = obj.toString();
            } else {
                str = "";
            }
            ev0Var.onError(i, i2, str);
        }
    }

    public void h(int i, int i2, Object obj) {
        ev0 ev0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, obj) == null) && (ev0Var = this.a) != null) {
            ev0Var.onInfo(i, i2);
        }
    }

    public void p(int i, int i2, int i3) {
        ev0 ev0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048591, this, i, i2, i3) == null) && (ev0Var = this.a) != null) {
            ev0Var.onUpdateProgress(i, i2, i3);
        }
    }

    public void q(int i, int i2) {
        ev0 ev0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) && (ev0Var = this.a) != null) {
            ev0Var.onVideoSizeChanged(i, i2);
        }
    }
}
