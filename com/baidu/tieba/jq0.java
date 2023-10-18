package com.baidu.tieba;

import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jq0 extends kq0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dq0 c;

    public jq0() {
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

    public void A() {
        dq0 dq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (dq0Var = this.c) != null) {
            dq0Var.onVideoSwitchToHalf();
        }
    }

    @Override // com.baidu.tieba.kq0
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.r();
            this.c = null;
        }
    }

    public void t() {
        dq0 dq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (dq0Var = this.c) != null) {
            dq0Var.onBeforeSwitchToFull();
        }
    }

    public void u() {
        dq0 dq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (dq0Var = this.c) != null) {
            dq0Var.onBeforeSwitchToHalf();
        }
    }

    public void v() {
        dq0 dq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (dq0Var = this.c) != null) {
            dq0Var.onGestureActionEnd();
        }
    }

    public void w() {
        dq0 dq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (dq0Var = this.c) != null) {
            dq0Var.onGestureActionStart();
        }
    }

    public void z() {
        dq0 dq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (dq0Var = this.c) != null) {
            dq0Var.onVideoSwitchToFull();
        }
    }

    public boolean x(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            dq0 dq0Var = this.c;
            if (dq0Var != null) {
                return dq0Var.onGestureDoubleClick(motionEvent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void y(boolean z) {
        dq0 dq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (dq0Var = this.c) != null) {
            dq0Var.onPanelVisibilityChanged(z);
        }
    }
}
