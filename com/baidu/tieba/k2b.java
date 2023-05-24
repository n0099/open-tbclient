package com.baidu.tieba;

import com.baidu.tieba.q2b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes6.dex */
public class k2b {
    public static /* synthetic */ Interceptable $ic;
    public static q2b a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947862606, "Lcom/baidu/tieba/k2b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947862606, "Lcom/baidu/tieba/k2b;");
                return;
            }
        }
        a = new q2b();
    }

    public static <TResult> TResult a(h2b<TResult> h2bVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, h2bVar)) == null) {
            q2b.c("await must not be called on the UI thread");
            if (h2bVar.g()) {
                return (TResult) q2b.b(h2bVar);
            }
            q2b.b bVar = new q2b.b();
            h2bVar.c(bVar);
            h2bVar.b(bVar);
            bVar.a.await();
            return (TResult) q2b.b(h2bVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> h2b<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(j2b.a(), callable) : (h2b) invokeL.objValue;
    }

    public static <TResult> h2b<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, callable)) == null) ? a.a(j2b.b(), callable) : (h2b) invokeL.objValue;
    }
}
