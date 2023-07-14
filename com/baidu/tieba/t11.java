package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class t11 implements v11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t01 a;
    public Context b;
    public y11 c;

    @Override // com.baidu.tieba.ny0
    public void a(@NonNull mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mx0Var) == null) {
        }
    }

    @Override // com.baidu.tieba.ny0
    public void d(@NonNull mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mx0Var) == null) {
        }
    }

    @Override // com.baidu.tieba.v11
    public void g(@NonNull mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mx0Var) == null) {
        }
    }

    @Override // com.baidu.tieba.ny0
    public int getExpectOrder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ny0
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ny0
    public void h(@NonNull PlayerStatus playerStatus, @NonNull PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, playerStatus, playerStatus2) == null) {
        }
    }

    @Override // com.baidu.tieba.ny0
    public void j(@NonNull mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, mx0Var) == null) {
        }
    }

    @Override // com.baidu.tieba.ny0
    public void k(@NonNull mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, mx0Var) == null) {
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ny0
    public void n(@NonNull mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, mx0Var) == null) {
        }
    }

    @Override // com.baidu.tieba.ny0
    public void q(@NonNull mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, mx0Var) == null) {
        }
    }

    public t11() {
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
        l(null);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c = null;
        }
    }

    public void f() {
        t01 t01Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (t01Var = this.a) != null) {
            t01Var.e(this);
            this.a = null;
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (Context) invokeV.objValue;
    }

    @Nullable
    public su0 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            y11 y11Var = this.c;
            if (y11Var != null) {
                return y11Var.b();
            }
            return null;
        }
        return (su0) invokeV.objValue;
    }

    public final void o() {
        int[] subscribeEvent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (subscribeEvent = getSubscribeEvent()) != null && subscribeEvent.length > 0) {
            for (int i : subscribeEvent) {
                this.a.c(i, this);
            }
        }
    }

    public t11(@Nullable Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        l(context);
    }

    public void b(@NonNull y11 y11Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y11Var) == null) {
            this.c = y11Var;
        }
    }

    public void c(@NonNull t01 t01Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t01Var) == null) {
            this.a = t01Var;
            o();
        }
    }

    public void l(@Nullable Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            if (context == null) {
                this.b = ru0.b();
            } else {
                this.b = context;
            }
        }
    }
}
