package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xi4 extends vi4<ij4> implements ej4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile ij4 b;

    public xi4() {
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

    public synchronized ij4 g() {
        InterceptResult invokeV;
        ij4 ij4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                ij4Var = (ij4) super.c();
            }
            return ij4Var;
        }
        return (ij4) invokeV.objValue;
    }

    public synchronized ij4 i() {
        InterceptResult invokeV;
        ij4 ij4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                ij4Var = (ij4) super.d();
            }
            return ij4Var;
        }
        return (ij4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ej4
    public <T> void a(ij4<T> ij4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ij4Var) == null) {
            this.b = ij4Var;
        }
    }

    @Override // com.baidu.tieba.ej4
    public <T> void b(ij4<T> ij4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ij4Var) == null) {
            if (this.b == ij4Var) {
                this.b = null;
            }
            k(ij4Var);
        }
    }

    public final void k(ij4 ij4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, ij4Var) != null) || !ij4Var.k()) {
            return;
        }
        ij4Var.r(true);
        this.a.add(0, ij4Var);
    }

    public synchronized void h(ij4 ij4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ij4Var) == null) {
            synchronized (this) {
                if (ij4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(ij4Var)) {
                    ij4Var.e().f(ij4Var.f());
                    return;
                }
                ij4 e = e(ij4Var);
                if (e != null) {
                    ij4Var.e().f(ij4Var.f());
                    if (ij4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = ij4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (e == null) {
                            this.a.add(ij4Var);
                        }
                    } else {
                        j(ij4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, ij4Var);
                        }
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, ij4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(ij4 ij4Var) {
        ij4 ij4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, ij4Var) != null) || ij4Var.g() != 300 || (ij4Var2 = this.b) == null || ij4Var2.g() == 300) {
            return;
        }
        ij4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
