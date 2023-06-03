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
public final class lj2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lj2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<pj2> b;

    public lj2() {
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

    public static lj2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (lj2.class) {
                    if (c == null) {
                        c = new lj2();
                    }
                }
            }
            return c;
        }
        return (lj2) invokeV.objValue;
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

    public void b(gj2 gj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((pj2) obj).d(gj2Var);
            }
        }
    }

    public void c(gj2 gj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((pj2) obj).b(gj2Var);
            }
        }
    }

    public void d(gj2 gj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, gj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((pj2) obj).f(gj2Var);
            }
        }
    }

    public void e(gj2 gj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, gj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((pj2) obj).c(gj2Var);
            }
        }
    }

    public void f(gj2 gj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, gj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((pj2) obj).g(gj2Var);
            }
        }
    }

    public void g(gj2 gj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, gj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((pj2) obj).a(gj2Var);
            }
        }
    }

    public void h(gj2 gj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, gj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((pj2) obj).e(gj2Var);
            }
        }
    }
}
