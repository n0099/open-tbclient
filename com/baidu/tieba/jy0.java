package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class jy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object[] a;
    public int b;
    public int c;
    public final int d;

    public jy0(int i) {
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
        this.c = 0;
        i = i <= 0 ? 2 : i;
        this.d = i;
        this.a = new Object[i];
    }

    public final void d(ly0 ly0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, ly0Var) != null) || e(ly0Var)) {
            return;
        }
        int i = this.b;
        Object[] objArr = this.a;
        if (i < objArr.length) {
            objArr[i] = ly0Var;
            this.b = i + 1;
            return;
        }
        int i2 = 0;
        while (true) {
            Object[] objArr2 = this.a;
            if (i2 < objArr2.length - 1) {
                int i3 = i2 + 1;
                objArr2[i2] = objArr2[i3];
                i2 = i3;
            } else {
                objArr2[this.b - 1] = ly0Var;
                return;
            }
        }
    }

    public ly0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.b <= 0) {
                return null;
            }
            if (this.c >= this.d) {
                ez0.j("acquire(), active player is overSize : " + this.d);
            }
            int i = this.b;
            int i2 = i - 1;
            Object[] objArr = this.a;
            ly0 ly0Var = (ly0) objArr[i2];
            objArr[i2] = null;
            this.b = i - 1;
            this.c++;
            ly0Var.onInit();
            return ly0Var;
        }
        return (ly0) invokeV.objValue;
    }

    public ly0 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.b > 0) {
                if (this.c >= this.d) {
                    ez0.j("acquire(" + str + "), active player is overSize : " + this.d);
                }
                int i = -1;
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (((ly0) this.a[i2]).verify(str)) {
                        i = i2;
                    }
                }
                if (i != -1) {
                    this.c++;
                    Object[] objArr = this.a;
                    ly0 ly0Var = (ly0) objArr[i];
                    objArr[i] = null;
                    while (true) {
                        int i3 = this.b;
                        if (i < i3 - 1) {
                            Object[] objArr2 = this.a;
                            int i4 = i + 1;
                            objArr2[i] = objArr2[i4];
                            i = i4;
                        } else {
                            this.a[i3 - 1] = null;
                            this.b = i3 - 1;
                            ly0Var.onInit();
                            return ly0Var;
                        }
                    }
                }
            }
            return null;
        }
        return (ly0) invokeL.objValue;
    }

    public void c(ly0 ly0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ly0Var) != null) || e(ly0Var)) {
            return;
        }
        d(ly0Var);
        ly0Var.onInit();
    }

    public final boolean e(ly0 ly0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ly0Var)) == null) {
            for (int i = 0; i < this.b; i++) {
                if (this.a[i] == ly0Var) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void f(ly0 ly0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, ly0Var) != null) || e(ly0Var)) {
            return;
        }
        d(ly0Var);
        this.c--;
        ly0Var.onRelease();
    }
}
