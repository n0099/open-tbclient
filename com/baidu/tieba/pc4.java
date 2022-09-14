package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class pc4 extends nc4<ad4> implements wc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile ad4 b;

    public pc4() {
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

    @Override // com.baidu.tieba.wc4
    public <T> void a(ad4<T> ad4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ad4Var) == null) {
            this.b = ad4Var;
        }
    }

    @Override // com.baidu.tieba.wc4
    public <T> void b(ad4<T> ad4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ad4Var) == null) {
            if (this.b == ad4Var) {
                this.b = null;
            }
            k(ad4Var);
        }
    }

    public synchronized ad4 g() {
        InterceptResult invokeV;
        ad4 ad4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                ad4Var = (ad4) super.c();
            }
            return ad4Var;
        }
        return (ad4) invokeV.objValue;
    }

    public synchronized void h(ad4 ad4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ad4Var) == null) {
            synchronized (this) {
                if (ad4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(ad4Var)) {
                    ad4Var.e().f(ad4Var.f());
                    return;
                }
                ad4 e = e(ad4Var);
                if (e != null) {
                    ad4Var.e().f(ad4Var.f());
                    if (ad4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = ad4Var.g();
                if (g != 200) {
                    if (g == 300) {
                        j(ad4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, ad4Var);
                        }
                    } else if (e == null) {
                        this.a.add(ad4Var);
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, ad4Var);
                }
                notifyAll();
            }
        }
    }

    public synchronized ad4 i() {
        InterceptResult invokeV;
        ad4 ad4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                ad4Var = (ad4) super.d();
            }
            return ad4Var;
        }
        return (ad4) invokeV.objValue;
    }

    public final void j(ad4 ad4Var) {
        ad4 ad4Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, ad4Var) == null) || ad4Var.g() != 300 || (ad4Var2 = this.b) == null || ad4Var2.g() == 300) {
            return;
        }
        ad4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public final void k(ad4 ad4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, ad4Var) == null) && ad4Var.k()) {
            ad4Var.r(true);
            this.a.add(0, ad4Var);
        }
    }
}
