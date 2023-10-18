package com.baidu.tieba;

import com.baidu.tieba.uub;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes7.dex */
public class oub {
    public static /* synthetic */ Interceptable $ic;
    public static uub a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948046157, "Lcom/baidu/tieba/oub;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948046157, "Lcom/baidu/tieba/oub;");
                return;
            }
        }
        a = new uub();
    }

    public static <TResult> TResult a(lub<TResult> lubVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, lubVar)) == null) {
            uub.c("await must not be called on the UI thread");
            if (lubVar.g()) {
                return (TResult) uub.b(lubVar);
            }
            uub.b bVar = new uub.b();
            lubVar.c(bVar);
            lubVar.b(bVar);
            bVar.a.await();
            return (TResult) uub.b(lubVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> lub<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(nub.a(), callable) : (lub) invokeL.objValue;
    }
}
