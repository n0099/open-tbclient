package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pk4 extends nk4<al4> implements wk4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile al4 b;

    public pk4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public synchronized al4 g() {
        InterceptResult invokeV;
        al4 al4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                al4Var = (al4) super.c();
            }
            return al4Var;
        }
        return (al4) invokeV.objValue;
    }

    public synchronized al4 i() {
        InterceptResult invokeV;
        al4 al4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                al4Var = (al4) super.d();
            }
            return al4Var;
        }
        return (al4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wk4
    public <T> void a(al4<T> al4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, al4Var) == null) {
            this.b = al4Var;
        }
    }

    @Override // com.baidu.tieba.wk4
    public <T> void b(al4<T> al4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, al4Var) == null) {
            if (this.b == al4Var) {
                this.b = null;
            }
            k(al4Var);
        }
    }

    public final void k(al4 al4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, al4Var) != null) || !al4Var.k()) {
            return;
        }
        al4Var.r(true);
        this.a.add(0, al4Var);
    }

    public synchronized void h(al4 al4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, al4Var) == null) {
            synchronized (this) {
                if (al4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(al4Var)) {
                    al4Var.e().f(al4Var.f());
                    return;
                }
                al4 e = e(al4Var);
                if (e != null) {
                    al4Var.e().f(al4Var.f());
                    if (al4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = al4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (e == null) {
                            this.a.add(al4Var);
                        }
                    } else {
                        j(al4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, al4Var);
                        }
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, al4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(al4 al4Var) {
        al4 al4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, al4Var) != null) || al4Var.g() != 300 || (al4Var2 = this.b) == null || al4Var2.g() == 300) {
            return;
        }
        al4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
