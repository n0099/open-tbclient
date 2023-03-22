package com.baidu.tieba;

import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class vs5 {
    public static /* synthetic */ Interceptable $ic;
    public static vs5 b;
    public transient /* synthetic */ FieldHolder $fh;
    public it5 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948251377, "Lcom/baidu/tieba/vs5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948251377, "Lcom/baidu/tieba/vs5;");
        }
    }

    public vs5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static vs5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                b = new vs5();
            }
            return b;
        }
        return (vs5) invokeV.objValue;
    }

    public void a() {
        it5 it5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (it5Var = this.a) != null && it5Var.b() != null) {
            this.a.b().dismiss();
        }
    }

    public boolean c(at5 at5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, at5Var)) == null) {
            it5 it5Var = this.a;
            if (it5Var != null && it5Var.b() != null) {
                return this.a.b().c(at5Var);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d(int i) {
        it5 it5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (it5Var = this.a) != null && it5Var.b() != null) {
            this.a.b().b(i);
        }
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            it5 it5Var = this.a;
            if (it5Var != null && it5Var.b() != null) {
                return this.a.b().a(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void e(TbPageContext tbPageContext, ViewGroup viewGroup, ys5 ys5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, tbPageContext, viewGroup, ys5Var) == null) {
            it5 it5Var = this.a;
            if (it5Var == null || !it5Var.a) {
                this.a = new jt5(tbPageContext, viewGroup, ys5Var);
            }
            if (this.a.b() != null) {
                this.a.b().show();
            }
        }
    }
}
