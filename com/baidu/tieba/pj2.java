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
/* loaded from: classes7.dex */
public final class pj2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pj2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<tj2> b;

    public pj2() {
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

    public static pj2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (pj2.class) {
                    if (c == null) {
                        c = new pj2();
                    }
                }
            }
            return c;
        }
        return (pj2) invokeV.objValue;
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

    public void b(kj2 kj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((tj2) obj).d(kj2Var);
            }
        }
    }

    public void c(kj2 kj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((tj2) obj).b(kj2Var);
            }
        }
    }

    public void d(kj2 kj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, kj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((tj2) obj).f(kj2Var);
            }
        }
    }

    public void e(kj2 kj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, kj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((tj2) obj).c(kj2Var);
            }
        }
    }

    public void f(kj2 kj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, kj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((tj2) obj).g(kj2Var);
            }
        }
    }

    public void g(kj2 kj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, kj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((tj2) obj).a(kj2Var);
            }
        }
    }

    public void h(kj2 kj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, kj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((tj2) obj).e(kj2Var);
            }
        }
    }
}
