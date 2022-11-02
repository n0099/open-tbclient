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
public final class rb2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rb2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<vb2> b;

    public rb2() {
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

    public static rb2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (rb2.class) {
                    if (c == null) {
                        c = new rb2();
                    }
                }
            }
            return c;
        }
        return (rb2) invokeV.objValue;
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

    public void b(mb2 mb2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mb2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((vb2) obj).d(mb2Var);
            }
        }
    }

    public void c(mb2 mb2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mb2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((vb2) obj).b(mb2Var);
            }
        }
    }

    public void d(mb2 mb2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, mb2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((vb2) obj).f(mb2Var);
            }
        }
    }

    public void e(mb2 mb2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, mb2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((vb2) obj).c(mb2Var);
            }
        }
    }

    public void f(mb2 mb2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, mb2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((vb2) obj).g(mb2Var);
            }
        }
    }

    public void g(mb2 mb2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, mb2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((vb2) obj).a(mb2Var);
            }
        }
    }

    public void h(mb2 mb2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, mb2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((vb2) obj).e(mb2Var);
            }
        }
    }
}
