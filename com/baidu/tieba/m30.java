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
/* loaded from: classes6.dex */
public final class m30 {
    public static /* synthetic */ Interceptable $ic;
    public static m30 a;
    public transient /* synthetic */ FieldHolder $fh;

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "0.8.39" : (String) invokeV.objValue;
    }

    public m30() {
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

    public static m30 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (m30.class) {
                    if (a == null) {
                        a = new m30();
                    }
                }
            }
            return a;
        }
        return (m30) invokeV.objValue;
    }

    public void c(Context context, n30<d60> n30Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, n30Var) == null) {
            d(context, n30Var, Looper.getMainLooper());
        }
    }

    public void e(Context context, n30<List<e60>> n30Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, n30Var) == null) {
            f(context, n30Var, Looper.getMainLooper());
        }
    }

    public void d(Context context, n30<d60> n30Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, n30Var, looper) == null) {
            l30.f(context).l(n30Var, looper);
        }
    }

    public void f(Context context, n30<List<e60>> n30Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, n30Var, looper) == null) {
            l30.f(context).p(n30Var, looper);
        }
    }
}
