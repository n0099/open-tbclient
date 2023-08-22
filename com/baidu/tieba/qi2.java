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
public final class qi2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qi2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<ui2> b;

    public qi2() {
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

    public static qi2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (qi2.class) {
                    if (c == null) {
                        c = new qi2();
                    }
                }
            }
            return c;
        }
        return (qi2) invokeV.objValue;
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

    public void b(li2 li2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, li2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((ui2) obj).d(li2Var);
            }
        }
    }

    public void c(li2 li2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, li2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((ui2) obj).b(li2Var);
            }
        }
    }

    public void d(li2 li2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, li2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((ui2) obj).f(li2Var);
            }
        }
    }

    public void e(li2 li2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, li2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((ui2) obj).c(li2Var);
            }
        }
    }

    public void f(li2 li2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, li2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((ui2) obj).g(li2Var);
            }
        }
    }

    public void g(li2 li2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, li2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((ui2) obj).a(li2Var);
            }
        }
    }

    public void h(li2 li2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, li2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((ui2) obj).e(li2Var);
            }
        }
    }
}
