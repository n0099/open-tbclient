package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ql4 extends ol4<bm4> implements xl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile bm4 b;

    public ql4() {
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

    public synchronized bm4 g() {
        InterceptResult invokeV;
        bm4 bm4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                bm4Var = (bm4) super.c();
            }
            return bm4Var;
        }
        return (bm4) invokeV.objValue;
    }

    public synchronized bm4 i() {
        InterceptResult invokeV;
        bm4 bm4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                bm4Var = (bm4) super.d();
            }
            return bm4Var;
        }
        return (bm4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xl4
    public <T> void a(bm4<T> bm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bm4Var) == null) {
            this.b = bm4Var;
        }
    }

    @Override // com.baidu.tieba.xl4
    public <T> void b(bm4<T> bm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bm4Var) == null) {
            if (this.b == bm4Var) {
                this.b = null;
            }
            k(bm4Var);
        }
    }

    public final void k(bm4 bm4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, bm4Var) != null) || !bm4Var.k()) {
            return;
        }
        bm4Var.r(true);
        this.a.add(0, bm4Var);
    }

    public synchronized void h(bm4 bm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bm4Var) == null) {
            synchronized (this) {
                if (bm4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(bm4Var)) {
                    bm4Var.e().f(bm4Var.f());
                    return;
                }
                bm4 e = e(bm4Var);
                if (e != null) {
                    bm4Var.e().f(bm4Var.f());
                    if (bm4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = bm4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (e == null) {
                            this.a.add(bm4Var);
                        }
                    } else {
                        j(bm4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, bm4Var);
                        }
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, bm4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(bm4 bm4Var) {
        bm4 bm4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, bm4Var) != null) || bm4Var.g() != 300 || (bm4Var2 = this.b) == null || bm4Var2.g() == 300) {
            return;
        }
        bm4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
