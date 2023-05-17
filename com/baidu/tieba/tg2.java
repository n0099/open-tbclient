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
public final class tg2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tg2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<xg2> b;

    public tg2() {
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

    public static tg2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (tg2.class) {
                    if (c == null) {
                        c = new tg2();
                    }
                }
            }
            return c;
        }
        return (tg2) invokeV.objValue;
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

    public void b(og2 og2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, og2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((xg2) obj).d(og2Var);
            }
        }
    }

    public void c(og2 og2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, og2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((xg2) obj).b(og2Var);
            }
        }
    }

    public void d(og2 og2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, og2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((xg2) obj).f(og2Var);
            }
        }
    }

    public void e(og2 og2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, og2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((xg2) obj).c(og2Var);
            }
        }
    }

    public void f(og2 og2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, og2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((xg2) obj).g(og2Var);
            }
        }
    }

    public void g(og2 og2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, og2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((xg2) obj).a(og2Var);
            }
        }
    }

    public void h(og2 og2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, og2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((xg2) obj).e(og2Var);
            }
        }
    }
}
