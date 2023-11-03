package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class xf4 extends vf4<ig4> implements eg4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile ig4 b;

    public xf4() {
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

    public synchronized ig4 g() {
        InterceptResult invokeV;
        ig4 ig4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                ig4Var = (ig4) super.c();
            }
            return ig4Var;
        }
        return (ig4) invokeV.objValue;
    }

    public synchronized ig4 i() {
        InterceptResult invokeV;
        ig4 ig4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                ig4Var = (ig4) super.d();
            }
            return ig4Var;
        }
        return (ig4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.eg4
    public <T> void a(ig4<T> ig4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ig4Var) == null) {
            this.b = ig4Var;
        }
    }

    @Override // com.baidu.tieba.eg4
    public <T> void b(ig4<T> ig4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ig4Var) == null) {
            if (this.b == ig4Var) {
                this.b = null;
            }
            k(ig4Var);
        }
    }

    public final void k(ig4 ig4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, ig4Var) != null) || !ig4Var.k()) {
            return;
        }
        ig4Var.r(true);
        this.a.add(0, ig4Var);
    }

    public synchronized void h(ig4 ig4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ig4Var) == null) {
            synchronized (this) {
                if (ig4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(ig4Var)) {
                    ig4Var.e().f(ig4Var.f());
                    return;
                }
                ig4 e = e(ig4Var);
                if (e != null) {
                    ig4Var.e().f(ig4Var.f());
                    if (ig4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = ig4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (e == null) {
                            this.a.add(ig4Var);
                        }
                    } else {
                        j(ig4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, ig4Var);
                        }
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, ig4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(ig4 ig4Var) {
        ig4 ig4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, ig4Var) != null) || ig4Var.g() != 300 || (ig4Var2 = this.b) == null || ig4Var2.g() == 300) {
            return;
        }
        ig4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
