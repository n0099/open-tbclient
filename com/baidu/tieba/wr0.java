package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wr0 extends ds0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public wr0() {
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

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c(vr0.x(ControlEvent.ACTION_RESUME));
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c(vr0.x(ControlEvent.ACTION_SHOW_TIP));
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c(vr0.x(ControlEvent.ACTION_START));
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            js0 x = vr0.x(ControlEvent.ACTION_PAUSE);
            x.o(11, Integer.valueOf(i));
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            x.o(7, Boolean.valueOf(z));
            c(x);
        }
    }

    public void f(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            js0 x = vr0.x(ControlEvent.ACTION_SEEK_MS);
            x.o(5, Integer.valueOf(i));
            x.o(12, Integer.valueOf(i2));
            c(x);
        }
    }

    public void i(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048581, this, i, i2, i3) == null) {
            js0 x = vr0.x(ControlEvent.ACTION_SYNC_PROGRESS);
            x.o(1, Integer.valueOf(i));
            x.o(2, Integer.valueOf(i2));
            x.o(3, Integer.valueOf(i3));
            x.s(1);
            c(x);
        }
    }
}
