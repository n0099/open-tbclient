package com.baidu.tieba;

import com.baidu.tieba.opb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes6.dex */
public class ipb {
    public static /* synthetic */ Interceptable $ic;
    public static opb a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947862606, "Lcom/baidu/tieba/ipb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947862606, "Lcom/baidu/tieba/ipb;");
                return;
            }
        }
        a = new opb();
    }

    public static <TResult> TResult a(fpb<TResult> fpbVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fpbVar)) == null) {
            opb.c("await must not be called on the UI thread");
            if (fpbVar.g()) {
                return (TResult) opb.b(fpbVar);
            }
            opb.b bVar = new opb.b();
            fpbVar.c(bVar);
            fpbVar.b(bVar);
            bVar.a.await();
            return (TResult) opb.b(fpbVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> fpb<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(hpb.a(), callable) : (fpb) invokeL.objValue;
    }

    public static <TResult> fpb<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, callable)) == null) ? a.a(hpb.b(), callable) : (fpb) invokeL.objValue;
    }
}
