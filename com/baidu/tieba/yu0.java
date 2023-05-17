package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class yu0 extends fv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public yu0() {
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
            c(xu0.w(ControlEvent.ACTION_RESUME));
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c(xu0.w(ControlEvent.ACTION_SHOW_TIP));
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c(xu0.w(ControlEvent.ACTION_START));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c(xu0.w(ControlEvent.ACTION_STOP));
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            lv0 w = xu0.w(ControlEvent.ACTION_PAUSE);
            w.n(11, Integer.valueOf(i));
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            w.n(7, Boolean.valueOf(z));
            c(w);
        }
    }

    public void f(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            lv0 w = xu0.w(ControlEvent.ACTION_SEEK_MS);
            w.n(5, Integer.valueOf(i));
            w.n(12, Integer.valueOf(i2));
            c(w);
        }
    }

    public void j(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048582, this, i, i2, i3) == null) {
            lv0 w = xu0.w(ControlEvent.ACTION_SYNC_PROGRESS);
            w.n(1, Integer.valueOf(i));
            w.n(2, Integer.valueOf(i2));
            w.n(3, Integer.valueOf(i3));
            w.r(1);
            c(w);
        }
    }
}
