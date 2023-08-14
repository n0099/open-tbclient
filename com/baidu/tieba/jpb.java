package com.baidu.tieba;

import com.baidu.tieba.ppb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes6.dex */
public class jpb {
    public static /* synthetic */ Interceptable $ic;
    public static ppb a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947892397, "Lcom/baidu/tieba/jpb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947892397, "Lcom/baidu/tieba/jpb;");
                return;
            }
        }
        a = new ppb();
    }

    public static <TResult> TResult a(gpb<TResult> gpbVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, gpbVar)) == null) {
            ppb.c("await must not be called on the UI thread");
            if (gpbVar.g()) {
                return (TResult) ppb.b(gpbVar);
            }
            ppb.b bVar = new ppb.b();
            gpbVar.c(bVar);
            gpbVar.b(bVar);
            bVar.a.await();
            return (TResult) ppb.b(gpbVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> gpb<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(ipb.a(), callable) : (gpb) invokeL.objValue;
    }

    public static <TResult> gpb<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, callable)) == null) ? a.a(ipb.b(), callable) : (gpb) invokeL.objValue;
    }
}
