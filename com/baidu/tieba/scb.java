package com.baidu.tieba;

import com.baidu.tieba.ycb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes7.dex */
public class scb {
    public static /* synthetic */ Interceptable $ic;
    public static ycb a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948148023, "Lcom/baidu/tieba/scb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948148023, "Lcom/baidu/tieba/scb;");
                return;
            }
        }
        a = new ycb();
    }

    public static <TResult> TResult a(pcb<TResult> pcbVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pcbVar)) == null) {
            ycb.c("await must not be called on the UI thread");
            if (pcbVar.g()) {
                return (TResult) ycb.b(pcbVar);
            }
            ycb.b bVar = new ycb.b();
            pcbVar.c(bVar);
            pcbVar.b(bVar);
            bVar.a.await();
            return (TResult) ycb.b(pcbVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> pcb<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(rcb.a(), callable) : (pcb) invokeL.objValue;
    }

    public static <TResult> pcb<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, callable)) == null) ? a.a(rcb.b(), callable) : (pcb) invokeL.objValue;
    }
}
