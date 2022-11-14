package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class wd4 extends ud4<he4> implements de4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile he4 b;

    public wd4() {
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

    public synchronized he4 g() {
        InterceptResult invokeV;
        he4 he4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                he4Var = (he4) super.c();
            }
            return he4Var;
        }
        return (he4) invokeV.objValue;
    }

    public synchronized he4 i() {
        InterceptResult invokeV;
        he4 he4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                he4Var = (he4) super.d();
            }
            return he4Var;
        }
        return (he4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.de4
    public <T> void a(he4<T> he4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, he4Var) == null) {
            this.b = he4Var;
        }
    }

    @Override // com.baidu.tieba.de4
    public <T> void b(he4<T> he4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, he4Var) == null) {
            if (this.b == he4Var) {
                this.b = null;
            }
            k(he4Var);
        }
    }

    public final void k(he4 he4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, he4Var) != null) || !he4Var.k()) {
            return;
        }
        he4Var.r(true);
        this.a.add(0, he4Var);
    }

    public synchronized void h(he4 he4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, he4Var) == null) {
            synchronized (this) {
                if (he4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(he4Var)) {
                    he4Var.e().f(he4Var.f());
                    return;
                }
                he4 e = e(he4Var);
                if (e != null) {
                    he4Var.e().f(he4Var.f());
                    if (he4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = he4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (e == null) {
                            this.a.add(he4Var);
                        }
                    } else {
                        j(he4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, he4Var);
                        }
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, he4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(he4 he4Var) {
        he4 he4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, he4Var) != null) || he4Var.g() != 300 || (he4Var2 = this.b) == null || he4Var2.g() == 300) {
            return;
        }
        he4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
