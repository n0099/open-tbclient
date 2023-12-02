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
/* loaded from: classes9.dex */
public final class xd2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xd2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<be2> b;

    public xd2() {
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

    public static xd2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (xd2.class) {
                    if (c == null) {
                        c = new xd2();
                    }
                }
            }
            return c;
        }
        return (xd2) invokeV.objValue;
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

    public void b(sd2 sd2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sd2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((be2) obj).d(sd2Var);
            }
        }
    }

    public void c(sd2 sd2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sd2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((be2) obj).b(sd2Var);
            }
        }
    }

    public void d(sd2 sd2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, sd2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((be2) obj).f(sd2Var);
            }
        }
    }

    public void e(sd2 sd2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, sd2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((be2) obj).c(sd2Var);
            }
        }
    }

    public void f(sd2 sd2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, sd2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((be2) obj).g(sd2Var);
            }
        }
    }

    public void g(sd2 sd2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, sd2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((be2) obj).a(sd2Var);
            }
        }
    }

    public void h(sd2 sd2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, sd2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((be2) obj).e(sd2Var);
            }
        }
    }
}
