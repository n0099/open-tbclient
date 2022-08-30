package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes5.dex */
public final class n82 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile n82 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<r82> b;

    public n82() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ReentrantLock();
        this.b = new ArrayList<>();
    }

    public static n82 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (n82.class) {
                    if (c == null) {
                        c = new n82();
                    }
                }
            }
            return c;
        }
        return (n82) invokeV.objValue;
    }

    public final Object[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                this.a.lock();
                return this.b.size() > 0 ? this.b.toArray() : null;
            } finally {
                this.a.unlock();
            }
        }
        return (Object[]) invokeV.objValue;
    }

    public void b(i82 i82Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i82Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((r82) obj).d(i82Var);
        }
    }

    public void c(i82 i82Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i82Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((r82) obj).b(i82Var);
        }
    }

    public void d(i82 i82Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, i82Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((r82) obj).f(i82Var);
        }
    }

    public void e(i82 i82Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, i82Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((r82) obj).c(i82Var);
        }
    }

    public void f(i82 i82Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, i82Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((r82) obj).g(i82Var);
        }
    }

    public void g(i82 i82Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, i82Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((r82) obj).a(i82Var);
        }
    }

    public void h(i82 i82Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, i82Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((r82) obj).e(i82Var);
        }
    }
}
