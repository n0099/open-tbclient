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
public final class li2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile li2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<pi2> b;

    public li2() {
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

    public static li2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (li2.class) {
                    if (c == null) {
                        c = new li2();
                    }
                }
            }
            return c;
        }
        return (li2) invokeV.objValue;
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

    public void b(gi2 gi2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gi2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((pi2) obj).d(gi2Var);
            }
        }
    }

    public void c(gi2 gi2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gi2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((pi2) obj).b(gi2Var);
            }
        }
    }

    public void d(gi2 gi2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, gi2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((pi2) obj).f(gi2Var);
            }
        }
    }

    public void e(gi2 gi2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, gi2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((pi2) obj).c(gi2Var);
            }
        }
    }

    public void f(gi2 gi2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, gi2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((pi2) obj).g(gi2Var);
            }
        }
    }

    public void g(gi2 gi2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, gi2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((pi2) obj).a(gi2Var);
            }
        }
    }

    public void h(gi2 gi2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, gi2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((pi2) obj).e(gi2Var);
            }
        }
    }
}
