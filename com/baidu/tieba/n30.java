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
public final class n30 {
    public static /* synthetic */ Interceptable $ic;
    public static n30 a;
    public transient /* synthetic */ FieldHolder $fh;

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "0.8.39" : (String) invokeV.objValue;
    }

    public n30() {
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

    public static n30 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (n30.class) {
                    if (a == null) {
                        a = new n30();
                    }
                }
            }
            return a;
        }
        return (n30) invokeV.objValue;
    }

    public void c(Context context, o30<e60> o30Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, o30Var) == null) {
            d(context, o30Var, Looper.getMainLooper());
        }
    }

    public void e(Context context, o30<List<f60>> o30Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, o30Var) == null) {
            f(context, o30Var, Looper.getMainLooper());
        }
    }

    public void d(Context context, o30<e60> o30Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, o30Var, looper) == null) {
            m30.f(context).l(o30Var, looper);
        }
    }

    public void f(Context context, o30<List<f60>> o30Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, o30Var, looper) == null) {
            m30.f(context).p(o30Var, looper);
        }
    }
}
