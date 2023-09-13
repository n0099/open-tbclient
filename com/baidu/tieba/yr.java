package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class yr {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yr a;
    public transient /* synthetic */ FieldHolder $fh;

    public yr() {
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

    public static yr a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (yr.class) {
                    if (a == null) {
                        a = new yr();
                    }
                }
            }
            return a;
        }
        return (yr) invokeV.objValue;
    }

    public void b(String str, as asVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, asVar) == null) {
            ds.b().g(str, asVar);
        }
    }
}
