package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class k7 {
    public static /* synthetic */ Interceptable $ic;
    public static final g7<Class, j7> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448307713, "Lcom/baidu/tieba/k7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448307713, "Lcom/baidu/tieba/k7;");
                return;
            }
        }
        a = new g7<>();
    }

    public static <T> j7<T> a(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) {
            return b(cls, 100);
        }
        return (j7) invokeL.objValue;
    }

    public static <T> j7<T> b(Class<T> cls, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, cls, i)) == null) {
            j7<T> c = a.c(cls);
            if (c == null) {
                n7 n7Var = new n7(cls, 4, i);
                a.i(cls, n7Var);
                return n7Var;
            }
            return c;
        }
        return (j7) invokeLI.objValue;
    }
}
