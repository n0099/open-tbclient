package com.baidu.tieba;

import com.baidu.tieba.vwa;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes6.dex */
public class pwa {
    public static /* synthetic */ Interceptable $ic;
    public static vwa a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948077839, "Lcom/baidu/tieba/pwa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948077839, "Lcom/baidu/tieba/pwa;");
                return;
            }
        }
        a = new vwa();
    }

    public static <TResult> TResult a(mwa<TResult> mwaVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mwaVar)) == null) {
            vwa.c("await must not be called on the UI thread");
            if (mwaVar.g()) {
                return (TResult) vwa.b(mwaVar);
            }
            vwa.b bVar = new vwa.b();
            mwaVar.c(bVar);
            mwaVar.b(bVar);
            bVar.a.await();
            return (TResult) vwa.b(mwaVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> mwa<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(owa.a(), callable) : (mwa) invokeL.objValue;
    }

    public static <TResult> mwa<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, callable)) == null) ? a.a(owa.b(), callable) : (mwa) invokeL.objValue;
    }
}
