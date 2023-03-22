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
public final class v10 {
    public static /* synthetic */ Interceptable $ic;
    public static v10 a;
    public transient /* synthetic */ FieldHolder $fh;

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "0.8.36" : (String) invokeV.objValue;
    }

    public v10() {
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

    public static v10 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (v10.class) {
                    if (a == null) {
                        a = new v10();
                    }
                }
            }
            return a;
        }
        return (v10) invokeV.objValue;
    }

    public void c(Context context, w10<n40> w10Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, w10Var) == null) {
            d(context, w10Var, Looper.getMainLooper());
        }
    }

    public void e(Context context, w10<List<o40>> w10Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, w10Var) == null) {
            f(context, w10Var, Looper.getMainLooper());
        }
    }

    public void d(Context context, w10<n40> w10Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, w10Var, looper) == null) {
            u10.f(context).l(w10Var, looper);
        }
    }

    public void f(Context context, w10<List<o40>> w10Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, w10Var, looper) == null) {
            u10.f(context).p(w10Var, looper);
        }
    }
}
