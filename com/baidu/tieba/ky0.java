package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class ky0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object[] a;
    public int b;

    public abstract ly0 b();

    public ky0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Object[i <= 0 ? 2 : i];
    }

    public ly0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = this.b;
            if (i <= 0) {
                ly0 b = b();
                b.onInit();
                return b;
            }
            int i2 = i - 1;
            Object[] objArr = this.a;
            ly0 ly0Var = (ly0) objArr[i2];
            objArr[i2] = null;
            this.b = i - 1;
            ly0Var.onInit();
            return ly0Var;
        }
        return (ly0) invokeV.objValue;
    }

    public final boolean c(ly0 ly0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ly0Var)) == null) {
            for (int i = 0; i < this.b; i++) {
                if (this.a[i] == ly0Var) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d(ly0 ly0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, ly0Var) != null) || c(ly0Var)) {
            return;
        }
        int i = this.b;
        Object[] objArr = this.a;
        if (i < objArr.length) {
            objArr[i] = ly0Var;
            this.b = i + 1;
        }
        ly0Var.onRelease();
    }
}
