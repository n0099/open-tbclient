package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class uk4 extends sk4<fl4> implements bl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile fl4 b;

    public uk4() {
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

    public synchronized fl4 g() {
        InterceptResult invokeV;
        fl4 fl4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                fl4Var = (fl4) super.c();
            }
            return fl4Var;
        }
        return (fl4) invokeV.objValue;
    }

    public synchronized fl4 i() {
        InterceptResult invokeV;
        fl4 fl4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                fl4Var = (fl4) super.d();
            }
            return fl4Var;
        }
        return (fl4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bl4
    public <T> void a(fl4<T> fl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fl4Var) == null) {
            this.b = fl4Var;
        }
    }

    @Override // com.baidu.tieba.bl4
    public <T> void b(fl4<T> fl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fl4Var) == null) {
            if (this.b == fl4Var) {
                this.b = null;
            }
            k(fl4Var);
        }
    }

    public final void k(fl4 fl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, fl4Var) != null) || !fl4Var.k()) {
            return;
        }
        fl4Var.r(true);
        this.a.add(0, fl4Var);
    }

    public synchronized void h(fl4 fl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fl4Var) == null) {
            synchronized (this) {
                if (fl4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(fl4Var)) {
                    fl4Var.e().f(fl4Var.f());
                    return;
                }
                fl4 e = e(fl4Var);
                if (e != null) {
                    fl4Var.e().f(fl4Var.f());
                    if (fl4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = fl4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (e == null) {
                            this.a.add(fl4Var);
                        }
                    } else {
                        j(fl4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, fl4Var);
                        }
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, fl4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(fl4 fl4Var) {
        fl4 fl4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, fl4Var) != null) || fl4Var.g() != 300 || (fl4Var2 = this.b) == null || fl4Var2.g() == 300) {
            return;
        }
        fl4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
