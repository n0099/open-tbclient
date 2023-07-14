package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ml4 extends kl4<xl4> implements tl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile xl4 b;

    public ml4() {
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

    public synchronized xl4 g() {
        InterceptResult invokeV;
        xl4 xl4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                xl4Var = (xl4) super.c();
            }
            return xl4Var;
        }
        return (xl4) invokeV.objValue;
    }

    public synchronized xl4 i() {
        InterceptResult invokeV;
        xl4 xl4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                xl4Var = (xl4) super.d();
            }
            return xl4Var;
        }
        return (xl4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tl4
    public <T> void a(xl4<T> xl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xl4Var) == null) {
            this.b = xl4Var;
        }
    }

    @Override // com.baidu.tieba.tl4
    public <T> void b(xl4<T> xl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xl4Var) == null) {
            if (this.b == xl4Var) {
                this.b = null;
            }
            k(xl4Var);
        }
    }

    public final void k(xl4 xl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, xl4Var) != null) || !xl4Var.k()) {
            return;
        }
        xl4Var.r(true);
        this.a.add(0, xl4Var);
    }

    public synchronized void h(xl4 xl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xl4Var) == null) {
            synchronized (this) {
                if (xl4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(xl4Var)) {
                    xl4Var.e().f(xl4Var.f());
                    return;
                }
                xl4 e = e(xl4Var);
                if (e != null) {
                    xl4Var.e().f(xl4Var.f());
                    if (xl4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = xl4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (e == null) {
                            this.a.add(xl4Var);
                        }
                    } else {
                        j(xl4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, xl4Var);
                        }
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, xl4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(xl4 xl4Var) {
        xl4 xl4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, xl4Var) != null) || xl4Var.g() != 300 || (xl4Var2 = this.b) == null || xl4Var2.g() == 300) {
            return;
        }
        xl4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
