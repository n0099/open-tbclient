package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class u7 {
    public static /* synthetic */ Interceptable $ic;
    public static final q7<Class, t7> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448317323, "Lcom/baidu/tieba/u7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448317323, "Lcom/baidu/tieba/u7;");
                return;
            }
        }
        a = new q7<>();
    }

    public static <T> t7<T> a(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) {
            return b(cls, 100);
        }
        return (t7) invokeL.objValue;
    }

    public static <T> t7<T> b(Class<T> cls, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, cls, i)) == null) {
            t7<T> c = a.c(cls);
            if (c == null) {
                x7 x7Var = new x7(cls, 4, i);
                a.i(cls, x7Var);
                return x7Var;
            }
            return c;
        }
        return (t7) invokeLI.objValue;
    }
}
