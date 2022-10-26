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
public final class za2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile za2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList b;

    public za2() {
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
        this.b = new ArrayList();
    }

    public static za2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (za2.class) {
                    if (c == null) {
                        c = new za2();
                    }
                }
            }
            return c;
        }
        return (za2) invokeV.objValue;
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

    public void b(ua2 ua2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ua2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((db2) obj).d(ua2Var);
            }
        }
    }

    public void c(ua2 ua2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ua2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((db2) obj).b(ua2Var);
            }
        }
    }

    public void d(ua2 ua2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ua2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((db2) obj).f(ua2Var);
            }
        }
    }

    public void e(ua2 ua2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, ua2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((db2) obj).c(ua2Var);
            }
        }
    }

    public void f(ua2 ua2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, ua2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((db2) obj).g(ua2Var);
            }
        }
    }

    public void g(ua2 ua2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, ua2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((db2) obj).a(ua2Var);
            }
        }
    }

    public void h(ua2 ua2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, ua2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((db2) obj).e(ua2Var);
            }
        }
    }
}
