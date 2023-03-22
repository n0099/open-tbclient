package com.baidu.tieba;

import com.baidu.tieba.wma;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes6.dex */
public class qma {
    public static /* synthetic */ Interceptable $ic;
    public static wma a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948098020, "Lcom/baidu/tieba/qma;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948098020, "Lcom/baidu/tieba/qma;");
                return;
            }
        }
        a = new wma();
    }

    public static <TResult> TResult a(nma<TResult> nmaVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, nmaVar)) == null) {
            wma.c("await must not be called on the UI thread");
            if (nmaVar.g()) {
                return (TResult) wma.b(nmaVar);
            }
            wma.b bVar = new wma.b();
            nmaVar.c(bVar);
            nmaVar.b(bVar);
            bVar.a.await();
            return (TResult) wma.b(nmaVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> nma<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(pma.a(), callable) : (nma) invokeL.objValue;
    }

    public static <TResult> nma<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, callable)) == null) ? a.a(pma.b(), callable) : (nma) invokeL.objValue;
    }
}
