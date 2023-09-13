package com.baidu.tieba;

import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nv0 extends ov0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hv0 c;

    public nv0() {
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
        hv0 hv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (hv0Var = this.c) != null) {
            hv0Var.onVideoSwitchToHalf();
        }
    }

    @Override // com.baidu.tieba.ov0
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.r();
            this.c = null;
        }
    }

    public void t() {
        hv0 hv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (hv0Var = this.c) != null) {
            hv0Var.onBeforeSwitchToFull();
        }
    }

    public void u() {
        hv0 hv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (hv0Var = this.c) != null) {
            hv0Var.onBeforeSwitchToHalf();
        }
    }

    public void v() {
        hv0 hv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (hv0Var = this.c) != null) {
            hv0Var.onGestureActionEnd();
        }
    }

    public void w() {
        hv0 hv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (hv0Var = this.c) != null) {
            hv0Var.onGestureActionStart();
        }
    }

    public void z() {
        hv0 hv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (hv0Var = this.c) != null) {
            hv0Var.onVideoSwitchToFull();
        }
    }

    public boolean x(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            hv0 hv0Var = this.c;
            if (hv0Var != null) {
                return hv0Var.onGestureDoubleClick(motionEvent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void y(boolean z) {
        hv0 hv0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (hv0Var = this.c) != null) {
            hv0Var.onPanelVisibilityChanged(z);
        }
    }
}
