package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class tl4 extends rl4<em4> implements am4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile em4 b;

    public tl4() {
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

    public synchronized em4 g() {
        InterceptResult invokeV;
        em4 em4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                em4Var = (em4) super.c();
            }
            return em4Var;
        }
        return (em4) invokeV.objValue;
    }

    public synchronized em4 i() {
        InterceptResult invokeV;
        em4 em4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                em4Var = (em4) super.d();
            }
            return em4Var;
        }
        return (em4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.am4
    public <T> void a(em4<T> em4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, em4Var) == null) {
            this.b = em4Var;
        }
    }

    @Override // com.baidu.tieba.am4
    public <T> void b(em4<T> em4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, em4Var) == null) {
            if (this.b == em4Var) {
                this.b = null;
            }
            k(em4Var);
        }
    }

    public final void k(em4 em4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, em4Var) != null) || !em4Var.k()) {
            return;
        }
        em4Var.r(true);
        this.a.add(0, em4Var);
    }

    public synchronized void h(em4 em4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, em4Var) == null) {
            synchronized (this) {
                if (em4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(em4Var)) {
                    em4Var.e().f(em4Var.f());
                    return;
                }
                em4 e = e(em4Var);
                if (e != null) {
                    em4Var.e().f(em4Var.f());
                    if (em4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = em4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (e == null) {
                            this.a.add(em4Var);
                        }
                    } else {
                        j(em4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, em4Var);
                        }
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, em4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(em4 em4Var) {
        em4 em4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, em4Var) != null) || em4Var.g() != 300 || (em4Var2 = this.b) == null || em4Var2.g() == 300) {
            return;
        }
        em4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
