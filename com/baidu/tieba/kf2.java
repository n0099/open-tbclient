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
public final class kf2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kf2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<of2> b;

    public kf2() {
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

    public static kf2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (kf2.class) {
                    if (c == null) {
                        c = new kf2();
                    }
                }
            }
            return c;
        }
        return (kf2) invokeV.objValue;
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

    public void b(ff2 ff2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ff2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((of2) obj).d(ff2Var);
            }
        }
    }

    public void c(ff2 ff2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ff2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((of2) obj).b(ff2Var);
            }
        }
    }

    public void d(ff2 ff2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ff2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((of2) obj).f(ff2Var);
            }
        }
    }

    public void e(ff2 ff2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, ff2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((of2) obj).c(ff2Var);
            }
        }
    }

    public void f(ff2 ff2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, ff2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((of2) obj).g(ff2Var);
            }
        }
    }

    public void g(ff2 ff2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, ff2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((of2) obj).a(ff2Var);
            }
        }
    }

    public void h(ff2 ff2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, ff2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((of2) obj).e(ff2Var);
            }
        }
    }
}
