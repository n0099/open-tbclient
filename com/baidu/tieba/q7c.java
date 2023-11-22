package com.baidu.tieba;

import com.baidu.tieba.w7c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes7.dex */
public class q7c {
    public static /* synthetic */ Interceptable $ic;
    public static w7c a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948046188, "Lcom/baidu/tieba/q7c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948046188, "Lcom/baidu/tieba/q7c;");
                return;
            }
        }
        a = new w7c();
    }

    public static <TResult> TResult a(n7c<TResult> n7cVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, n7cVar)) == null) {
            w7c.c("await must not be called on the UI thread");
            if (n7cVar.g()) {
                return (TResult) w7c.b(n7cVar);
            }
            w7c.b bVar = new w7c.b();
            n7cVar.c(bVar);
            n7cVar.b(bVar);
            bVar.a.await();
            return (TResult) w7c.b(n7cVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> n7c<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(p7c.a(), callable) : (n7c) invokeL.objValue;
    }
}
