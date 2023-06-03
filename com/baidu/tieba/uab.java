package com.baidu.tieba;

import com.baidu.tieba.abb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes8.dex */
public class uab {
    public static /* synthetic */ Interceptable $ic;
    public static abb a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948205683, "Lcom/baidu/tieba/uab;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948205683, "Lcom/baidu/tieba/uab;");
                return;
            }
        }
        a = new abb();
    }

    public static <TResult> TResult a(rab<TResult> rabVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, rabVar)) == null) {
            abb.c("await must not be called on the UI thread");
            if (rabVar.g()) {
                return (TResult) abb.b(rabVar);
            }
            abb.b bVar = new abb.b();
            rabVar.c(bVar);
            rabVar.b(bVar);
            bVar.a.await();
            return (TResult) abb.b(rabVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> rab<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(tab.a(), callable) : (rab) invokeL.objValue;
    }

    public static <TResult> rab<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, callable)) == null) ? a.a(tab.b(), callable) : (rab) invokeL.objValue;
    }
}
