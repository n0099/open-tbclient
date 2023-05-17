package com.baidu.tieba;

import com.baidu.tieba.p2b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes6.dex */
public class j2b {
    public static /* synthetic */ Interceptable $ic;
    public static p2b a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947832815, "Lcom/baidu/tieba/j2b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947832815, "Lcom/baidu/tieba/j2b;");
                return;
            }
        }
        a = new p2b();
    }

    public static <TResult> TResult a(g2b<TResult> g2bVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, g2bVar)) == null) {
            p2b.c("await must not be called on the UI thread");
            if (g2bVar.g()) {
                return (TResult) p2b.b(g2bVar);
            }
            p2b.b bVar = new p2b.b();
            g2bVar.c(bVar);
            g2bVar.b(bVar);
            bVar.a.await();
            return (TResult) p2b.b(g2bVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> g2b<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(i2b.a(), callable) : (g2b) invokeL.objValue;
    }

    public static <TResult> g2b<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, callable)) == null) ? a.a(i2b.b(), callable) : (g2b) invokeL.objValue;
    }
}
