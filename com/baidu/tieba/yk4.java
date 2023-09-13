package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class yk4 extends wk4<jl4> implements fl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile jl4 b;

    public yk4() {
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

    public synchronized jl4 g() {
        InterceptResult invokeV;
        jl4 jl4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                jl4Var = (jl4) super.c();
            }
            return jl4Var;
        }
        return (jl4) invokeV.objValue;
    }

    public synchronized jl4 i() {
        InterceptResult invokeV;
        jl4 jl4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                jl4Var = (jl4) super.d();
            }
            return jl4Var;
        }
        return (jl4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fl4
    public <T> void a(jl4<T> jl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jl4Var) == null) {
            this.b = jl4Var;
        }
    }

    @Override // com.baidu.tieba.fl4
    public <T> void b(jl4<T> jl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jl4Var) == null) {
            if (this.b == jl4Var) {
                this.b = null;
            }
            k(jl4Var);
        }
    }

    public final void k(jl4 jl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, jl4Var) != null) || !jl4Var.k()) {
            return;
        }
        jl4Var.r(true);
        this.a.add(0, jl4Var);
    }

    public synchronized void h(jl4 jl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jl4Var) == null) {
            synchronized (this) {
                if (jl4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(jl4Var)) {
                    jl4Var.e().f(jl4Var.f());
                    return;
                }
                jl4 e = e(jl4Var);
                if (e != null) {
                    jl4Var.e().f(jl4Var.f());
                    if (jl4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = jl4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (e == null) {
                            this.a.add(jl4Var);
                        }
                    } else {
                        j(jl4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, jl4Var);
                        }
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, jl4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(jl4 jl4Var) {
        jl4 jl4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, jl4Var) != null) || jl4Var.g() != 300 || (jl4Var2 = this.b) == null || jl4Var2.g() == 300) {
            return;
        }
        jl4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
