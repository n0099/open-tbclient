package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class yf4 extends wf4<jg4> implements fg4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile jg4 b;

    public yf4() {
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

    public synchronized jg4 g() {
        InterceptResult invokeV;
        jg4 jg4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                jg4Var = (jg4) super.c();
            }
            return jg4Var;
        }
        return (jg4) invokeV.objValue;
    }

    public synchronized jg4 i() {
        InterceptResult invokeV;
        jg4 jg4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                jg4Var = (jg4) super.d();
            }
            return jg4Var;
        }
        return (jg4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fg4
    public <T> void a(jg4<T> jg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jg4Var) == null) {
            this.b = jg4Var;
        }
    }

    @Override // com.baidu.tieba.fg4
    public <T> void b(jg4<T> jg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jg4Var) == null) {
            if (this.b == jg4Var) {
                this.b = null;
            }
            k(jg4Var);
        }
    }

    public final void k(jg4 jg4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, jg4Var) != null) || !jg4Var.k()) {
            return;
        }
        jg4Var.r(true);
        this.a.add(0, jg4Var);
    }

    public synchronized void h(jg4 jg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jg4Var) == null) {
            synchronized (this) {
                if (jg4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(jg4Var)) {
                    jg4Var.e().f(jg4Var.f());
                    return;
                }
                jg4 e = e(jg4Var);
                if (e != null) {
                    jg4Var.e().f(jg4Var.f());
                    if (jg4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = jg4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (e == null) {
                            this.a.add(jg4Var);
                        }
                    } else {
                        j(jg4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, jg4Var);
                        }
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, jg4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(jg4 jg4Var) {
        jg4 jg4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, jg4Var) != null) || jg4Var.g() != 300 || (jg4Var2 = this.b) == null || jg4Var2.g() == 300) {
            return;
        }
        jg4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
