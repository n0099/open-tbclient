package com.baidu.tieba;

import com.baidu.tieba.x0c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes7.dex */
public class r0c {
    public static /* synthetic */ Interceptable $ic;
    public static x0c a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948069252, "Lcom/baidu/tieba/r0c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948069252, "Lcom/baidu/tieba/r0c;");
                return;
            }
        }
        a = new x0c();
    }

    public static <TResult> TResult a(o0c<TResult> o0cVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, o0cVar)) == null) {
            x0c.c("await must not be called on the UI thread");
            if (o0cVar.g()) {
                return (TResult) x0c.b(o0cVar);
            }
            x0c.b bVar = new x0c.b();
            o0cVar.c(bVar);
            o0cVar.b(bVar);
            bVar.a.await();
            return (TResult) x0c.b(o0cVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> o0c<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(q0c.a(), callable) : (o0c) invokeL.objValue;
    }

    public static <TResult> o0c<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, callable)) == null) ? a.a(q0c.b(), callable) : (o0c) invokeL.objValue;
    }
}
