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
public final class wb2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wb2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<ac2> b;

    public wb2() {
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

    public static wb2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (wb2.class) {
                    if (c == null) {
                        c = new wb2();
                    }
                }
            }
            return c;
        }
        return (wb2) invokeV.objValue;
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

    public void b(rb2 rb2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rb2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((ac2) obj).d(rb2Var);
            }
        }
    }

    public void c(rb2 rb2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rb2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((ac2) obj).b(rb2Var);
            }
        }
    }

    public void d(rb2 rb2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, rb2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((ac2) obj).f(rb2Var);
            }
        }
    }

    public void e(rb2 rb2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, rb2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((ac2) obj).c(rb2Var);
            }
        }
    }

    public void f(rb2 rb2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, rb2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((ac2) obj).g(rb2Var);
            }
        }
    }

    public void g(rb2 rb2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, rb2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((ac2) obj).a(rb2Var);
            }
        }
    }

    public void h(rb2 rb2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, rb2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((ac2) obj).e(rb2Var);
            }
        }
    }
}
