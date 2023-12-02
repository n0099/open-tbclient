package com.baidu.tieba;

import com.baidu.tieba.qcc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes7.dex */
public class kcc {
    public static /* synthetic */ Interceptable $ic;
    public static qcc a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947909726, "Lcom/baidu/tieba/kcc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947909726, "Lcom/baidu/tieba/kcc;");
                return;
            }
        }
        a = new qcc();
    }

    public static <TResult> TResult a(hcc<TResult> hccVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hccVar)) == null) {
            qcc.c("await must not be called on the UI thread");
            if (hccVar.g()) {
                return (TResult) qcc.b(hccVar);
            }
            qcc.b bVar = new qcc.b();
            hccVar.c(bVar);
            hccVar.b(bVar);
            bVar.a.await();
            return (TResult) qcc.b(hccVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> hcc<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(jcc.a(), callable) : (hcc) invokeL.objValue;
    }
}
