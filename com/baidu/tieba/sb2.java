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
/* loaded from: classes5.dex */
public final class sb2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sb2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<wb2> b;

    public sb2() {
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

    public static sb2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (sb2.class) {
                    if (c == null) {
                        c = new sb2();
                    }
                }
            }
            return c;
        }
        return (sb2) invokeV.objValue;
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

    public void b(nb2 nb2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((wb2) obj).d(nb2Var);
            }
        }
    }

    public void c(nb2 nb2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nb2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((wb2) obj).b(nb2Var);
            }
        }
    }

    public void d(nb2 nb2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, nb2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((wb2) obj).f(nb2Var);
            }
        }
    }

    public void e(nb2 nb2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, nb2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((wb2) obj).c(nb2Var);
            }
        }
    }

    public void f(nb2 nb2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, nb2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((wb2) obj).g(nb2Var);
            }
        }
    }

    public void g(nb2 nb2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, nb2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((wb2) obj).a(nb2Var);
            }
        }
    }

    public void h(nb2 nb2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, nb2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((wb2) obj).e(nb2Var);
            }
        }
    }
}
