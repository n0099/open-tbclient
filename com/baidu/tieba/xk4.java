package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xk4 extends vk4<il4> implements el4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile il4 b;

    public xk4() {
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

    public synchronized il4 g() {
        InterceptResult invokeV;
        il4 il4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                il4Var = (il4) super.c();
            }
            return il4Var;
        }
        return (il4) invokeV.objValue;
    }

    public synchronized il4 i() {
        InterceptResult invokeV;
        il4 il4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                il4Var = (il4) super.d();
            }
            return il4Var;
        }
        return (il4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.el4
    public <T> void a(il4<T> il4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, il4Var) == null) {
            this.b = il4Var;
        }
    }

    @Override // com.baidu.tieba.el4
    public <T> void b(il4<T> il4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, il4Var) == null) {
            if (this.b == il4Var) {
                this.b = null;
            }
            k(il4Var);
        }
    }

    public final void k(il4 il4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, il4Var) != null) || !il4Var.k()) {
            return;
        }
        il4Var.r(true);
        this.a.add(0, il4Var);
    }

    public synchronized void h(il4 il4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, il4Var) == null) {
            synchronized (this) {
                if (il4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(il4Var)) {
                    il4Var.e().f(il4Var.f());
                    return;
                }
                il4 e = e(il4Var);
                if (e != null) {
                    il4Var.e().f(il4Var.f());
                    if (il4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = il4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (e == null) {
                            this.a.add(il4Var);
                        }
                    } else {
                        j(il4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, il4Var);
                        }
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, il4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(il4 il4Var) {
        il4 il4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, il4Var) != null) || il4Var.g() != 300 || (il4Var2 = this.b) == null || il4Var2.g() == 300) {
            return;
        }
        il4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
