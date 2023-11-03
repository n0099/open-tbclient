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
public final class td2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile td2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<xd2> b;

    public td2() {
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

    public static td2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (td2.class) {
                    if (c == null) {
                        c = new td2();
                    }
                }
            }
            return c;
        }
        return (td2) invokeV.objValue;
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

    public void b(od2 od2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, od2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((xd2) obj).d(od2Var);
            }
        }
    }

    public void c(od2 od2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, od2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((xd2) obj).b(od2Var);
            }
        }
    }

    public void d(od2 od2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, od2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((xd2) obj).f(od2Var);
            }
        }
    }

    public void e(od2 od2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, od2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((xd2) obj).c(od2Var);
            }
        }
    }

    public void f(od2 od2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, od2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((xd2) obj).g(od2Var);
            }
        }
    }

    public void g(od2 od2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, od2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((xd2) obj).a(od2Var);
            }
        }
    }

    public void h(od2 od2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, od2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((xd2) obj).e(od2Var);
            }
        }
    }
}
