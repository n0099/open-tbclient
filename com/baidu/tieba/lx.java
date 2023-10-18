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
public final class lx {
    public static /* synthetic */ Interceptable $ic;
    public static lx a;
    public transient /* synthetic */ FieldHolder $fh;

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "0.8.39" : (String) invokeV.objValue;
    }

    public lx() {
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

    public static lx b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (lx.class) {
                    if (a == null) {
                        a = new lx();
                    }
                }
            }
            return a;
        }
        return (lx) invokeV.objValue;
    }

    public void c(Context context, mx<c00> mxVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, mxVar) == null) {
            d(context, mxVar, Looper.getMainLooper());
        }
    }

    public void e(Context context, mx<List<d00>> mxVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, mxVar) == null) {
            f(context, mxVar, Looper.getMainLooper());
        }
    }

    public void d(Context context, mx<c00> mxVar, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, mxVar, looper) == null) {
            kx.f(context).l(mxVar, looper);
        }
    }

    public void f(Context context, mx<List<d00>> mxVar, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, mxVar, looper) == null) {
            kx.f(context).p(mxVar, looper);
        }
    }
}
