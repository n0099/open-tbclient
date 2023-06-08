package com.baidu.tieba;

import com.baidu.tieba.fbb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes8.dex */
public class zab {
    public static /* synthetic */ Interceptable $ic;
    public static fbb a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948354638, "Lcom/baidu/tieba/zab;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948354638, "Lcom/baidu/tieba/zab;");
                return;
            }
        }
        a = new fbb();
    }

    public static <TResult> TResult a(wab<TResult> wabVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, wabVar)) == null) {
            fbb.c("await must not be called on the UI thread");
            if (wabVar.g()) {
                return (TResult) fbb.b(wabVar);
            }
            fbb.b bVar = new fbb.b();
            wabVar.c(bVar);
            wabVar.b(bVar);
            bVar.a.await();
            return (TResult) fbb.b(wabVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> wab<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(yab.a(), callable) : (wab) invokeL.objValue;
    }

    public static <TResult> wab<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, callable)) == null) ? a.a(yab.b(), callable) : (wab) invokeL.objValue;
    }
}
