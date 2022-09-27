package com.baidu.tieba;

import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ls0 extends ms0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fs0 c;

    public ls0() {
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
        fs0 fs0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fs0Var = this.c) == null) {
            return;
        }
        fs0Var.onVideoSwitchToHalf();
    }

    @Override // com.baidu.tieba.ms0
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.r();
            this.c = null;
        }
    }

    public void t() {
        fs0 fs0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (fs0Var = this.c) == null) {
            return;
        }
        fs0Var.onBeforeSwitchToFull();
    }

    public void u() {
        fs0 fs0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (fs0Var = this.c) == null) {
            return;
        }
        fs0Var.onBeforeSwitchToHalf();
    }

    public void v() {
        fs0 fs0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (fs0Var = this.c) == null) {
            return;
        }
        fs0Var.onGestureActionEnd();
    }

    public void w() {
        fs0 fs0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (fs0Var = this.c) == null) {
            return;
        }
        fs0Var.onGestureActionStart();
    }

    public boolean x(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            fs0 fs0Var = this.c;
            if (fs0Var != null) {
                return fs0Var.onGestureDoubleClick(motionEvent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void y(boolean z) {
        fs0 fs0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (fs0Var = this.c) == null) {
            return;
        }
        fs0Var.onPanelVisibilityChanged(z);
    }

    public void z() {
        fs0 fs0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (fs0Var = this.c) == null) {
            return;
        }
        fs0Var.onVideoSwitchToFull();
    }
}
