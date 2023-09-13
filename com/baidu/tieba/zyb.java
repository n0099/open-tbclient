package com.baidu.tieba;

import com.baidu.tieba.fzb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes9.dex */
public class zyb {
    public static /* synthetic */ Interceptable $ic;
    public static fzb a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948377702, "Lcom/baidu/tieba/zyb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948377702, "Lcom/baidu/tieba/zyb;");
                return;
            }
        }
        a = new fzb();
    }

    public static <TResult> TResult a(wyb<TResult> wybVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, wybVar)) == null) {
            fzb.c("await must not be called on the UI thread");
            if (wybVar.g()) {
                return (TResult) fzb.b(wybVar);
            }
            fzb.b bVar = new fzb.b();
            wybVar.c(bVar);
            wybVar.b(bVar);
            bVar.a.await();
            return (TResult) fzb.b(wybVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> wyb<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(yyb.a(), callable) : (wyb) invokeL.objValue;
    }

    public static <TResult> wyb<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, callable)) == null) ? a.a(yyb.b(), callable) : (wyb) invokeL.objValue;
    }
}
