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
/* loaded from: classes6.dex */
public final class ya2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ya2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<cb2> b;

    public ya2() {
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

    public static ya2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (ya2.class) {
                    if (c == null) {
                        c = new ya2();
                    }
                }
            }
            return c;
        }
        return (ya2) invokeV.objValue;
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

    public void b(ta2 ta2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ta2Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((cb2) obj).d(ta2Var);
        }
    }

    public void c(ta2 ta2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ta2Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((cb2) obj).b(ta2Var);
        }
    }

    public void d(ta2 ta2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, ta2Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((cb2) obj).f(ta2Var);
        }
    }

    public void e(ta2 ta2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, ta2Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((cb2) obj).c(ta2Var);
        }
    }

    public void f(ta2 ta2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, ta2Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((cb2) obj).g(ta2Var);
        }
    }

    public void g(ta2 ta2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, ta2Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((cb2) obj).a(ta2Var);
        }
    }

    public void h(ta2 ta2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, ta2Var) == null) || (a = a()) == null) {
            return;
        }
        for (Object obj : a) {
            ((cb2) obj).e(ta2Var);
        }
    }
}
