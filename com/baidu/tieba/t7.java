package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class t7 {
    public static /* synthetic */ Interceptable $ic;
    public static final p7<Class, s7> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448316362, "Lcom/baidu/tieba/t7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448316362, "Lcom/baidu/tieba/t7;");
                return;
            }
        }
        a = new p7<>();
    }

    public static <T> s7<T> a(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) {
            return b(cls, 100);
        }
        return (s7) invokeL.objValue;
    }

    public static <T> s7<T> b(Class<T> cls, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, cls, i)) == null) {
            s7<T> c = a.c(cls);
            if (c == null) {
                w7 w7Var = new w7(cls, 4, i);
                a.i(cls, w7Var);
                return w7Var;
            }
            return c;
        }
        return (s7) invokeLI.objValue;
    }
}
