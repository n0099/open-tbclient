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
public final class ui2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ui2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<yi2> b;

    public ui2() {
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

    public static ui2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (ui2.class) {
                    if (c == null) {
                        c = new ui2();
                    }
                }
            }
            return c;
        }
        return (ui2) invokeV.objValue;
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

    public void b(pi2 pi2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pi2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((yi2) obj).d(pi2Var);
            }
        }
    }

    public void c(pi2 pi2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pi2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((yi2) obj).b(pi2Var);
            }
        }
    }

    public void d(pi2 pi2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, pi2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((yi2) obj).f(pi2Var);
            }
        }
    }

    public void e(pi2 pi2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, pi2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((yi2) obj).c(pi2Var);
            }
        }
    }

    public void f(pi2 pi2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, pi2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((yi2) obj).g(pi2Var);
            }
        }
    }

    public void g(pi2 pi2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, pi2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((yi2) obj).a(pi2Var);
            }
        }
    }

    public void h(pi2 pi2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, pi2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((yi2) obj).e(pi2Var);
            }
        }
    }
}
