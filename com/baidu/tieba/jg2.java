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
public final class jg2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jg2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<ng2> b;

    public jg2() {
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

    public static jg2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (jg2.class) {
                    if (c == null) {
                        c = new jg2();
                    }
                }
            }
            return c;
        }
        return (jg2) invokeV.objValue;
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

    public void b(eg2 eg2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eg2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((ng2) obj).d(eg2Var);
            }
        }
    }

    public void c(eg2 eg2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eg2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((ng2) obj).b(eg2Var);
            }
        }
    }

    public void d(eg2 eg2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, eg2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((ng2) obj).f(eg2Var);
            }
        }
    }

    public void e(eg2 eg2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, eg2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((ng2) obj).c(eg2Var);
            }
        }
    }

    public void f(eg2 eg2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, eg2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((ng2) obj).g(eg2Var);
            }
        }
    }

    public void g(eg2 eg2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, eg2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((ng2) obj).a(eg2Var);
            }
        }
    }

    public void h(eg2 eg2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, eg2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((ng2) obj).e(eg2Var);
            }
        }
    }
}
