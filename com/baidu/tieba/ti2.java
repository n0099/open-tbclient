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
/* loaded from: classes8.dex */
public final class ti2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ti2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<xi2> b;

    public ti2() {
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

    public static ti2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (ti2.class) {
                    if (c == null) {
                        c = new ti2();
                    }
                }
            }
            return c;
        }
        return (ti2) invokeV.objValue;
    }

    public final Object[] a() {
        Object[] objArr;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                this.a.lock();
                if (this.b.size() > 0) {
                    objArr = this.b.toArray();
                } else {
                    objArr = null;
                }
                return objArr;
            } finally {
                this.a.unlock();
            }
        }
        return (Object[]) invokeV.objValue;
    }

    public void b(oi2 oi2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oi2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((xi2) obj).d(oi2Var);
            }
        }
    }

    public void c(oi2 oi2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oi2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((xi2) obj).b(oi2Var);
            }
        }
    }

    public void d(oi2 oi2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, oi2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((xi2) obj).f(oi2Var);
            }
        }
    }

    public void e(oi2 oi2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, oi2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((xi2) obj).c(oi2Var);
            }
        }
    }

    public void f(oi2 oi2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, oi2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((xi2) obj).g(oi2Var);
            }
        }
    }

    public void g(oi2 oi2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, oi2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((xi2) obj).a(oi2Var);
            }
        }
    }

    public void h(oi2 oi2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, oi2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((xi2) obj).e(oi2Var);
            }
        }
    }
}
