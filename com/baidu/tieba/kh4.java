package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class kh4 extends ih4<vh4> implements rh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile vh4 b;

    public kh4() {
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

    public synchronized vh4 g() {
        InterceptResult invokeV;
        vh4 vh4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                vh4Var = (vh4) super.c();
            }
            return vh4Var;
        }
        return (vh4) invokeV.objValue;
    }

    public synchronized vh4 i() {
        InterceptResult invokeV;
        vh4 vh4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                vh4Var = (vh4) super.d();
            }
            return vh4Var;
        }
        return (vh4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rh4
    public <T> void a(vh4<T> vh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vh4Var) == null) {
            this.b = vh4Var;
        }
    }

    @Override // com.baidu.tieba.rh4
    public <T> void b(vh4<T> vh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vh4Var) == null) {
            if (this.b == vh4Var) {
                this.b = null;
            }
            k(vh4Var);
        }
    }

    public final void k(vh4 vh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, vh4Var) != null) || !vh4Var.k()) {
            return;
        }
        vh4Var.r(true);
        this.a.add(0, vh4Var);
    }

    public synchronized void h(vh4 vh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, vh4Var) == null) {
            synchronized (this) {
                if (vh4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(vh4Var)) {
                    vh4Var.e().f(vh4Var.f());
                    return;
                }
                vh4 e = e(vh4Var);
                if (e != null) {
                    vh4Var.e().f(vh4Var.f());
                    if (vh4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = vh4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (e == null) {
                            this.a.add(vh4Var);
                        }
                    } else {
                        j(vh4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, vh4Var);
                        }
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, vh4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(vh4 vh4Var) {
        vh4 vh4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, vh4Var) != null) || vh4Var.g() != 300 || (vh4Var2 = this.b) == null || vh4Var2.g() == 300) {
            return;
        }
        vh4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
