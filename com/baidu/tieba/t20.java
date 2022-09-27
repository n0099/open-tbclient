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
/* loaded from: classes5.dex */
public final class t20 {
    public static /* synthetic */ Interceptable $ic;
    public static t20 a;
    public transient /* synthetic */ FieldHolder $fh;

    public t20() {
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

    public static t20 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (t20.class) {
                    if (a == null) {
                        a = new t20();
                    }
                }
            }
            return a;
        }
        return (t20) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "0.8.36" : (String) invokeV.objValue;
    }

    public void c(Context context, u20<l50> u20Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, u20Var) == null) {
            d(context, u20Var, Looper.getMainLooper());
        }
    }

    public void d(Context context, u20<l50> u20Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, u20Var, looper) == null) {
            s20.e(context).i(u20Var, looper);
        }
    }

    public void e(Context context, u20<List<m50>> u20Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, u20Var) == null) {
            f(context, u20Var, Looper.getMainLooper());
        }
    }

    public void f(Context context, u20<List<m50>> u20Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, u20Var, looper) == null) {
            s20.e(context).m(u20Var, looper);
        }
    }
}
