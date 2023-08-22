package com.baidu.tieba;

import com.baidu.tieba.ewb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes8.dex */
public class yvb {
    public static /* synthetic */ Interceptable $ic;
    public static ewb a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948345028, "Lcom/baidu/tieba/yvb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948345028, "Lcom/baidu/tieba/yvb;");
                return;
            }
        }
        a = new ewb();
    }

    public static <TResult> TResult a(vvb<TResult> vvbVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, vvbVar)) == null) {
            ewb.c("await must not be called on the UI thread");
            if (vvbVar.g()) {
                return (TResult) ewb.b(vvbVar);
            }
            ewb.b bVar = new ewb.b();
            vvbVar.c(bVar);
            vvbVar.b(bVar);
            bVar.a.await();
            return (TResult) ewb.b(vvbVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> vvb<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(xvb.a(), callable) : (vvb) invokeL.objValue;
    }

    public static <TResult> vvb<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, callable)) == null) ? a.a(xvb.b(), callable) : (vvb) invokeL.objValue;
    }
}
