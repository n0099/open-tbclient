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
/* loaded from: classes4.dex */
public final class la2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile la2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<pa2> b;

    public la2() {
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

    public static la2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (la2.class) {
                    if (c == null) {
                        c = new la2();
                    }
                }
            }
            return c;
        }
        return (la2) invokeV.objValue;
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

    public void b(ga2 ga2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ga2Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((pa2) obj).d(ga2Var);
        }
    }

    public void c(ga2 ga2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ga2Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((pa2) obj).b(ga2Var);
        }
    }

    public void d(ga2 ga2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, ga2Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((pa2) obj).f(ga2Var);
        }
    }

    public void e(ga2 ga2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, ga2Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((pa2) obj).c(ga2Var);
        }
    }

    public void f(ga2 ga2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, ga2Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((pa2) obj).g(ga2Var);
        }
    }

    public void g(ga2 ga2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, ga2Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((pa2) obj).a(ga2Var);
        }
    }

    public void h(ga2 ga2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, ga2Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((pa2) obj).e(ga2Var);
        }
    }
}
