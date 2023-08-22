package com.baidu.tieba;

import android.content.Context;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public final class o20 {
    public static /* synthetic */ Interceptable $ic;
    public static o20 a;
    public transient /* synthetic */ FieldHolder $fh;

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "0.8.39" : (String) invokeV.objValue;
    }

    public o20() {
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

    public static o20 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (o20.class) {
                    if (a == null) {
                        a = new o20();
                    }
                }
            }
            return a;
        }
        return (o20) invokeV.objValue;
    }

    public void c(Context context, p20<f50> p20Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, p20Var) == null) {
            d(context, p20Var, Looper.getMainLooper());
        }
    }

    public void e(Context context, p20<List<g50>> p20Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, p20Var) == null) {
            f(context, p20Var, Looper.getMainLooper());
        }
    }

    public void d(Context context, p20<f50> p20Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, p20Var, looper) == null) {
            n20.f(context).l(p20Var, looper);
        }
    }

    public void f(Context context, p20<List<g50>> p20Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, p20Var, looper) == null) {
            n20.f(context).p(p20Var, looper);
        }
    }
}
