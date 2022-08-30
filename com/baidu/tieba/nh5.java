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
/* loaded from: classes5.dex */
public class nh5 {
    public static /* synthetic */ Interceptable $ic;
    public static nh5 b;
    public transient /* synthetic */ FieldHolder $fh;
    public ai5 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948002478, "Lcom/baidu/tieba/nh5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948002478, "Lcom/baidu/tieba/nh5;");
        }
    }

    public nh5() {
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

    public static nh5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                b = new nh5();
            }
            return b;
        }
        return (nh5) invokeV.objValue;
    }

    public void a() {
        ai5 ai5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (ai5Var = this.a) == null || ai5Var.b() == null) {
            return;
        }
        this.a.b().dismiss();
    }

    public boolean c(sh5 sh5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sh5Var)) == null) {
            ai5 ai5Var = this.a;
            if (ai5Var == null || ai5Var.b() == null) {
                return false;
            }
            return this.a.b().c(sh5Var);
        }
        return invokeL.booleanValue;
    }

    public void d(int i) {
        ai5 ai5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (ai5Var = this.a) == null || ai5Var.b() == null) {
            return;
        }
        this.a.b().b(i);
    }

    public void e(TbPageContext tbPageContext, ViewGroup viewGroup, qh5 qh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, tbPageContext, viewGroup, qh5Var) == null) {
            ai5 ai5Var = this.a;
            if (ai5Var == null || !ai5Var.a) {
                this.a = new bi5(tbPageContext, viewGroup, qh5Var);
            }
            if (this.a.b() != null) {
                this.a.b().show();
            }
        }
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            ai5 ai5Var = this.a;
            if (ai5Var == null || ai5Var.b() == null) {
                return false;
            }
            return this.a.b().a(str);
        }
        return invokeL.booleanValue;
    }
}
