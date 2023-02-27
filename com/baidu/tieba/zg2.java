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
public final class zg2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zg2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<dh2> b;

    public zg2() {
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

    public static zg2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (zg2.class) {
                    if (c == null) {
                        c = new zg2();
                    }
                }
            }
            return c;
        }
        return (zg2) invokeV.objValue;
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

    public void b(ug2 ug2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ug2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((dh2) obj).d(ug2Var);
            }
        }
    }

    public void c(ug2 ug2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ug2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((dh2) obj).b(ug2Var);
            }
        }
    }

    public void d(ug2 ug2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ug2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((dh2) obj).f(ug2Var);
            }
        }
    }

    public void e(ug2 ug2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, ug2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((dh2) obj).c(ug2Var);
            }
        }
    }

    public void f(ug2 ug2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, ug2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((dh2) obj).g(ug2Var);
            }
        }
    }

    public void g(ug2 ug2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, ug2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((dh2) obj).a(ug2Var);
            }
        }
    }

    public void h(ug2 ug2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, ug2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((dh2) obj).e(ug2Var);
            }
        }
    }
}
