package com.baidu.tieba;

import com.baidu.tieba.v7c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes7.dex */
public class p7c {
    public static /* synthetic */ Interceptable $ic;
    public static v7c a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948016397, "Lcom/baidu/tieba/p7c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948016397, "Lcom/baidu/tieba/p7c;");
                return;
            }
        }
        a = new v7c();
    }

    public static <TResult> TResult a(m7c<TResult> m7cVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, m7cVar)) == null) {
            v7c.c("await must not be called on the UI thread");
            if (m7cVar.g()) {
                return (TResult) v7c.b(m7cVar);
            }
            v7c.b bVar = new v7c.b();
            m7cVar.c(bVar);
            m7cVar.b(bVar);
            bVar.a.await();
            return (TResult) v7c.b(m7cVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> m7c<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(o7c.a(), callable) : (m7c) invokeL.objValue;
    }
}
