package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pl4 extends nl4<am4> implements wl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile am4 b;

    public pl4() {
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

    public synchronized am4 g() {
        InterceptResult invokeV;
        am4 am4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                am4Var = (am4) super.c();
            }
            return am4Var;
        }
        return (am4) invokeV.objValue;
    }

    public synchronized am4 i() {
        InterceptResult invokeV;
        am4 am4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                am4Var = (am4) super.d();
            }
            return am4Var;
        }
        return (am4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wl4
    public <T> void a(am4<T> am4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, am4Var) == null) {
            this.b = am4Var;
        }
    }

    @Override // com.baidu.tieba.wl4
    public <T> void b(am4<T> am4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, am4Var) == null) {
            if (this.b == am4Var) {
                this.b = null;
            }
            k(am4Var);
        }
    }

    public final void k(am4 am4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, am4Var) != null) || !am4Var.k()) {
            return;
        }
        am4Var.r(true);
        this.a.add(0, am4Var);
    }

    public synchronized void h(am4 am4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, am4Var) == null) {
            synchronized (this) {
                if (am4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(am4Var)) {
                    am4Var.e().f(am4Var.f());
                    return;
                }
                am4 e = e(am4Var);
                if (e != null) {
                    am4Var.e().f(am4Var.f());
                    if (am4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = am4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (e == null) {
                            this.a.add(am4Var);
                        }
                    } else {
                        j(am4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, am4Var);
                        }
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, am4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(am4 am4Var) {
        am4 am4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, am4Var) != null) || am4Var.g() != 300 || (am4Var2 = this.b) == null || am4Var2.g() == 300) {
            return;
        }
        am4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
