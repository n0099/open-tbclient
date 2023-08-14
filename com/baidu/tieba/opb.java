package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public final class opb<TResult> extends gpb<TResult> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public boolean b;
    public volatile boolean c;
    public TResult d;
    public Exception e;
    public List<cpb<TResult>> f;

    public opb() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Object();
        this.f = new ArrayList();
    }

    @Override // com.baidu.tieba.gpb
    public final gpb<TResult> a(dpb<TResult> dpbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dpbVar)) == null) {
            m(ipb.c(), dpbVar);
            return this;
        }
        return (gpb) invokeL.objValue;
    }

    @Override // com.baidu.tieba.gpb
    public final gpb<TResult> b(epb epbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, epbVar)) == null) {
            n(ipb.c(), epbVar);
            return this;
        }
        return (gpb) invokeL.objValue;
    }

    @Override // com.baidu.tieba.gpb
    public final gpb<TResult> c(fpb<TResult> fpbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fpbVar)) == null) {
            o(ipb.c(), fpbVar);
            return this;
        }
        return (gpb) invokeL.objValue;
    }

    @Override // com.baidu.tieba.gpb
    public final Exception d() {
        InterceptResult invokeV;
        Exception exc;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.a) {
                exc = this.e;
            }
            return exc;
        }
        return (Exception) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gpb
    public final TResult e() {
        InterceptResult invokeV;
        TResult tresult;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this.a) {
                if (this.e != null) {
                    throw new RuntimeException(this.e);
                }
                tresult = this.d;
            }
            return tresult;
        }
        return (TResult) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gpb
    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.c : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.gpb
    public final boolean g() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this.a) {
                z = this.b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.gpb
    public final boolean h() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this.a) {
                z = this.b && !f() && this.e == null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final gpb<TResult> i(cpb<TResult> cpbVar) {
        InterceptResult invokeL;
        boolean g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cpbVar)) == null) {
            synchronized (this.a) {
                g = g();
                if (!g) {
                    this.f.add(cpbVar);
                }
            }
            if (g) {
                cpbVar.onComplete(this);
            }
            return this;
        }
        return (gpb) invokeL.objValue;
    }

    public final void j(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, exc) == null) {
            synchronized (this.a) {
                if (this.b) {
                    return;
                }
                this.b = true;
                this.e = exc;
                this.a.notifyAll();
                p();
            }
        }
    }

    public final void k(TResult tresult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tresult) == null) {
            synchronized (this.a) {
                if (this.b) {
                    return;
                }
                this.b = true;
                this.d = tresult;
                this.a.notifyAll();
                p();
            }
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this.a) {
                if (this.b) {
                    return false;
                }
                this.b = true;
                this.c = true;
                this.a.notifyAll();
                p();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public final gpb<TResult> m(Executor executor, dpb<TResult> dpbVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, executor, dpbVar)) == null) {
            i(new lpb(executor, dpbVar));
            return this;
        }
        return (gpb) invokeLL.objValue;
    }

    public final gpb<TResult> n(Executor executor, epb epbVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, executor, epbVar)) == null) {
            i(new mpb(executor, epbVar));
            return this;
        }
        return (gpb) invokeLL.objValue;
    }

    public final gpb<TResult> o(Executor executor, fpb<TResult> fpbVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, executor, fpbVar)) == null) {
            i(new npb(executor, fpbVar));
            return this;
        }
        return (gpb) invokeLL.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this.a) {
                for (cpb<TResult> cpbVar : this.f) {
                    try {
                        cpbVar.onComplete(this);
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception e2) {
                        throw new RuntimeException(e2);
                    }
                }
                this.f = null;
            }
        }
    }
}
