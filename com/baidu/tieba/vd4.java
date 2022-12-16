package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class vd4 extends td4<ge4> implements ce4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile ge4 b;

    public vd4() {
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

    public synchronized ge4 g() {
        InterceptResult invokeV;
        ge4 ge4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                ge4Var = (ge4) super.c();
            }
            return ge4Var;
        }
        return (ge4) invokeV.objValue;
    }

    public synchronized ge4 i() {
        InterceptResult invokeV;
        ge4 ge4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                ge4Var = (ge4) super.d();
            }
            return ge4Var;
        }
        return (ge4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ce4
    public <T> void a(ge4<T> ge4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ge4Var) == null) {
            this.b = ge4Var;
        }
    }

    @Override // com.baidu.tieba.ce4
    public <T> void b(ge4<T> ge4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ge4Var) == null) {
            if (this.b == ge4Var) {
                this.b = null;
            }
            k(ge4Var);
        }
    }

    public final void k(ge4 ge4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, ge4Var) != null) || !ge4Var.k()) {
            return;
        }
        ge4Var.r(true);
        this.a.add(0, ge4Var);
    }

    public synchronized void h(ge4 ge4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ge4Var) == null) {
            synchronized (this) {
                if (ge4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(ge4Var)) {
                    ge4Var.e().f(ge4Var.f());
                    return;
                }
                ge4 e = e(ge4Var);
                if (e != null) {
                    ge4Var.e().f(ge4Var.f());
                    if (ge4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = ge4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (e == null) {
                            this.a.add(ge4Var);
                        }
                    } else {
                        j(ge4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, ge4Var);
                        }
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, ge4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(ge4 ge4Var) {
        ge4 ge4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, ge4Var) != null) || ge4Var.g() != 300 || (ge4Var2 = this.b) == null || ge4Var2.g() == 300) {
            return;
        }
        ge4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
