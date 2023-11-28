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
public final class ud2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ud2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<yd2> b;

    public ud2() {
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

    public static ud2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (ud2.class) {
                    if (c == null) {
                        c = new ud2();
                    }
                }
            }
            return c;
        }
        return (ud2) invokeV.objValue;
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

    public void b(pd2 pd2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pd2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((yd2) obj).d(pd2Var);
            }
        }
    }

    public void c(pd2 pd2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pd2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((yd2) obj).b(pd2Var);
            }
        }
    }

    public void d(pd2 pd2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, pd2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((yd2) obj).f(pd2Var);
            }
        }
    }

    public void e(pd2 pd2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, pd2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((yd2) obj).c(pd2Var);
            }
        }
    }

    public void f(pd2 pd2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, pd2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((yd2) obj).g(pd2Var);
            }
        }
    }

    public void g(pd2 pd2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, pd2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((yd2) obj).a(pd2Var);
            }
        }
    }

    public void h(pd2 pd2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, pd2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((yd2) obj).e(pd2Var);
            }
        }
    }
}
