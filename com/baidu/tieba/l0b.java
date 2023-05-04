package com.baidu.tieba;

import com.baidu.tieba.r0b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes5.dex */
public class l0b {
    public static /* synthetic */ Interceptable $ic;
    public static r0b a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947890475, "Lcom/baidu/tieba/l0b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947890475, "Lcom/baidu/tieba/l0b;");
                return;
            }
        }
        a = new r0b();
    }

    public static <TResult> TResult a(i0b<TResult> i0bVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, i0bVar)) == null) {
            r0b.c("await must not be called on the UI thread");
            if (i0bVar.g()) {
                return (TResult) r0b.b(i0bVar);
            }
            r0b.b bVar = new r0b.b();
            i0bVar.c(bVar);
            i0bVar.b(bVar);
            bVar.a.await();
            return (TResult) r0b.b(i0bVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> i0b<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(k0b.a(), callable) : (i0b) invokeL.objValue;
    }

    public static <TResult> i0b<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, callable)) == null) ? a.a(k0b.b(), callable) : (i0b) invokeL.objValue;
    }
}
