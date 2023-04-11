package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class lh4 extends jh4<wh4> implements sh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile wh4 b;

    public lh4() {
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

    public synchronized wh4 g() {
        InterceptResult invokeV;
        wh4 wh4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                wh4Var = (wh4) super.c();
            }
            return wh4Var;
        }
        return (wh4) invokeV.objValue;
    }

    public synchronized wh4 i() {
        InterceptResult invokeV;
        wh4 wh4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                wh4Var = (wh4) super.d();
            }
            return wh4Var;
        }
        return (wh4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sh4
    public <T> void a(wh4<T> wh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wh4Var) == null) {
            this.b = wh4Var;
        }
    }

    @Override // com.baidu.tieba.sh4
    public <T> void b(wh4<T> wh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wh4Var) == null) {
            if (this.b == wh4Var) {
                this.b = null;
            }
            k(wh4Var);
        }
    }

    public final void k(wh4 wh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, wh4Var) != null) || !wh4Var.k()) {
            return;
        }
        wh4Var.r(true);
        this.a.add(0, wh4Var);
    }

    public synchronized void h(wh4 wh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, wh4Var) == null) {
            synchronized (this) {
                if (wh4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(wh4Var)) {
                    wh4Var.e().f(wh4Var.f());
                    return;
                }
                wh4 e = e(wh4Var);
                if (e != null) {
                    wh4Var.e().f(wh4Var.f());
                    if (wh4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = wh4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (e == null) {
                            this.a.add(wh4Var);
                        }
                    } else {
                        j(wh4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, wh4Var);
                        }
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, wh4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(wh4 wh4Var) {
        wh4 wh4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, wh4Var) != null) || wh4Var.g() != 300 || (wh4Var2 = this.b) == null || wh4Var2.g() == 300) {
            return;
        }
        wh4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
