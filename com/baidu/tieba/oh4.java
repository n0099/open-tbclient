package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class oh4 extends mh4<zh4> implements vh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile zh4 b;

    public oh4() {
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

    public synchronized zh4 g() {
        InterceptResult invokeV;
        zh4 zh4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                zh4Var = (zh4) super.c();
            }
            return zh4Var;
        }
        return (zh4) invokeV.objValue;
    }

    public synchronized zh4 i() {
        InterceptResult invokeV;
        zh4 zh4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                zh4Var = (zh4) super.d();
            }
            return zh4Var;
        }
        return (zh4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vh4
    public <T> void a(zh4<T> zh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zh4Var) == null) {
            this.b = zh4Var;
        }
    }

    @Override // com.baidu.tieba.vh4
    public <T> void b(zh4<T> zh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zh4Var) == null) {
            if (this.b == zh4Var) {
                this.b = null;
            }
            k(zh4Var);
        }
    }

    public final void k(zh4 zh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, zh4Var) != null) || !zh4Var.k()) {
            return;
        }
        zh4Var.r(true);
        this.a.add(0, zh4Var);
    }

    public synchronized void h(zh4 zh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, zh4Var) == null) {
            synchronized (this) {
                if (zh4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(zh4Var)) {
                    zh4Var.e().f(zh4Var.f());
                    return;
                }
                zh4 e = e(zh4Var);
                if (e != null) {
                    zh4Var.e().f(zh4Var.f());
                    if (zh4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = zh4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (e == null) {
                            this.a.add(zh4Var);
                        }
                    } else {
                        j(zh4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, zh4Var);
                        }
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, zh4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(zh4 zh4Var) {
        zh4 zh4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, zh4Var) != null) || zh4Var.g() != 300 || (zh4Var2 = this.b) == null || zh4Var2.g() == 300) {
            return;
        }
        zh4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
