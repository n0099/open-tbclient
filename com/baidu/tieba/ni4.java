package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ni4 extends li4<yi4> implements ui4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile yi4 b;

    public ni4() {
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

    public synchronized yi4 g() {
        InterceptResult invokeV;
        yi4 yi4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                yi4Var = (yi4) super.c();
            }
            return yi4Var;
        }
        return (yi4) invokeV.objValue;
    }

    public synchronized yi4 i() {
        InterceptResult invokeV;
        yi4 yi4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                yi4Var = (yi4) super.d();
            }
            return yi4Var;
        }
        return (yi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ui4
    public <T> void a(yi4<T> yi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yi4Var) == null) {
            this.b = yi4Var;
        }
    }

    @Override // com.baidu.tieba.ui4
    public <T> void b(yi4<T> yi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yi4Var) == null) {
            if (this.b == yi4Var) {
                this.b = null;
            }
            k(yi4Var);
        }
    }

    public final void k(yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, yi4Var) != null) || !yi4Var.k()) {
            return;
        }
        yi4Var.r(true);
        this.a.add(0, yi4Var);
    }

    public synchronized void h(yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, yi4Var) == null) {
            synchronized (this) {
                if (yi4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(yi4Var)) {
                    yi4Var.e().f(yi4Var.f());
                    return;
                }
                yi4 e = e(yi4Var);
                if (e != null) {
                    yi4Var.e().f(yi4Var.f());
                    if (yi4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = yi4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (e == null) {
                            this.a.add(yi4Var);
                        }
                    } else {
                        j(yi4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, yi4Var);
                        }
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, yi4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(yi4 yi4Var) {
        yi4 yi4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, yi4Var) != null) || yi4Var.g() != 300 || (yi4Var2 = this.b) == null || yi4Var2.g() == 300) {
            return;
        }
        yi4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
