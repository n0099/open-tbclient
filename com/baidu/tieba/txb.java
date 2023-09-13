package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class txb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public txb() {
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

    public static txb a(uxb uxbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uxbVar)) == null) ? pyb.f(uxbVar) : (txb) invokeL.objValue;
    }

    public static txb b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? pyb.e() : (txb) invokeV.objValue;
    }

    public static synchronized void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            synchronized (txb.class) {
                Log.i("AGConnectInstance", "AGConnectInstance#initialize");
                pyb.i(context);
            }
        }
    }

    public abstract uxb c();

    public abstract Context getContext();

    public abstract String getIdentifier();
}
