package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class pa4 extends na4<ab4> implements wa4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile ab4 b;

    public pa4() {
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

    @Override // com.baidu.tieba.wa4
    public <T> void a(ab4<T> ab4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ab4Var) == null) {
            this.b = ab4Var;
        }
    }

    @Override // com.baidu.tieba.wa4
    public <T> void b(ab4<T> ab4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ab4Var) == null) {
            if (this.b == ab4Var) {
                this.b = null;
            }
            k(ab4Var);
        }
    }

    public synchronized ab4 g() {
        InterceptResult invokeV;
        ab4 ab4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                ab4Var = (ab4) super.c();
            }
            return ab4Var;
        }
        return (ab4) invokeV.objValue;
    }

    public synchronized void h(ab4 ab4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ab4Var) == null) {
            synchronized (this) {
                if (ab4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(ab4Var)) {
                    ab4Var.e().f(ab4Var.f());
                    return;
                }
                ab4 e = e(ab4Var);
                if (e != null) {
                    ab4Var.e().f(ab4Var.f());
                    if (ab4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = ab4Var.g();
                if (g != 200) {
                    if (g == 300) {
                        j(ab4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, ab4Var);
                        }
                    } else if (e == null) {
                        this.a.add(ab4Var);
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, ab4Var);
                }
                notifyAll();
            }
        }
    }

    public synchronized ab4 i() {
        InterceptResult invokeV;
        ab4 ab4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                ab4Var = (ab4) super.d();
            }
            return ab4Var;
        }
        return (ab4) invokeV.objValue;
    }

    public final void j(ab4 ab4Var) {
        ab4 ab4Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, ab4Var) == null) || ab4Var.g() != 300 || (ab4Var2 = this.b) == null || ab4Var2.g() == 300) {
            return;
        }
        ab4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public final void k(ab4 ab4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, ab4Var) == null) && ab4Var.k()) {
            ab4Var.r(true);
            this.a.add(0, ab4Var);
        }
    }
}
