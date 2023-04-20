package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class mh4 extends kh4<xh4> implements th4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile xh4 b;

    public mh4() {
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

    public synchronized xh4 g() {
        InterceptResult invokeV;
        xh4 xh4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                xh4Var = (xh4) super.c();
            }
            return xh4Var;
        }
        return (xh4) invokeV.objValue;
    }

    public synchronized xh4 i() {
        InterceptResult invokeV;
        xh4 xh4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                xh4Var = (xh4) super.d();
            }
            return xh4Var;
        }
        return (xh4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.th4
    public <T> void a(xh4<T> xh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xh4Var) == null) {
            this.b = xh4Var;
        }
    }

    @Override // com.baidu.tieba.th4
    public <T> void b(xh4<T> xh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xh4Var) == null) {
            if (this.b == xh4Var) {
                this.b = null;
            }
            k(xh4Var);
        }
    }

    public final void k(xh4 xh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, xh4Var) != null) || !xh4Var.k()) {
            return;
        }
        xh4Var.r(true);
        this.a.add(0, xh4Var);
    }

    public synchronized void h(xh4 xh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xh4Var) == null) {
            synchronized (this) {
                if (xh4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(xh4Var)) {
                    xh4Var.e().f(xh4Var.f());
                    return;
                }
                xh4 e = e(xh4Var);
                if (e != null) {
                    xh4Var.e().f(xh4Var.f());
                    if (xh4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = xh4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (e == null) {
                            this.a.add(xh4Var);
                        }
                    } else {
                        j(xh4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, xh4Var);
                        }
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, xh4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(xh4 xh4Var) {
        xh4 xh4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, xh4Var) != null) || xh4Var.g() != 300 || (xh4Var2 = this.b) == null || xh4Var2.g() == 300) {
            return;
        }
        xh4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
