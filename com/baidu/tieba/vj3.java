package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class vj3 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, pj3> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948242666, "Lcom/baidu/tieba/vj3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948242666, "Lcom/baidu/tieba/vj3;");
                return;
            }
        }
        boolean z = rr1.a;
        a = new HashMap();
    }

    public vj3() {
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

    public static pj3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b("searchbox_webapps_sp");
        }
        return (pj3) invokeV.objValue;
    }

    public static pj3 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            pj3 pj3Var = a.get(str);
            if (pj3Var == null) {
                synchronized (vj3.class) {
                    pj3Var = a.get(str);
                    if (pj3Var == null) {
                        pj3Var = new pj3(str);
                        a.put(str, pj3Var);
                    }
                }
            }
            return pj3Var;
        }
        return (pj3) invokeL.objValue;
    }
}
