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
public final class mj2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mj2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<qj2> b;

    public mj2() {
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

    public static mj2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (mj2.class) {
                    if (c == null) {
                        c = new mj2();
                    }
                }
            }
            return c;
        }
        return (mj2) invokeV.objValue;
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

    public void b(hj2 hj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((qj2) obj).d(hj2Var);
            }
        }
    }

    public void c(hj2 hj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((qj2) obj).b(hj2Var);
            }
        }
    }

    public void d(hj2 hj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, hj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((qj2) obj).f(hj2Var);
            }
        }
    }

    public void e(hj2 hj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, hj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((qj2) obj).c(hj2Var);
            }
        }
    }

    public void f(hj2 hj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, hj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((qj2) obj).g(hj2Var);
            }
        }
    }

    public void g(hj2 hj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, hj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((qj2) obj).a(hj2Var);
            }
        }
    }

    public void h(hj2 hj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, hj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((qj2) obj).e(hj2Var);
            }
        }
    }
}
