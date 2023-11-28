package com.baidu.tieba;

import com.baidu.tieba.rcc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes7.dex */
public class lcc {
    public static /* synthetic */ Interceptable $ic;
    public static rcc a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947939517, "Lcom/baidu/tieba/lcc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947939517, "Lcom/baidu/tieba/lcc;");
                return;
            }
        }
        a = new rcc();
    }

    public static <TResult> TResult a(icc<TResult> iccVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iccVar)) == null) {
            rcc.c("await must not be called on the UI thread");
            if (iccVar.g()) {
                return (TResult) rcc.b(iccVar);
            }
            rcc.b bVar = new rcc.b();
            iccVar.c(bVar);
            iccVar.b(bVar);
            bVar.a.await();
            return (TResult) rcc.b(iccVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> icc<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(kcc.a(), callable) : (icc) invokeL.objValue;
    }
}
