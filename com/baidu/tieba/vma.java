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
/* loaded from: classes6.dex */
public final class vma<TResult> extends nma<TResult> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public boolean b;
    public volatile boolean c;
    public TResult d;
    public Exception e;
    public List<jma<TResult>> f;

    public vma() {
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

    @Override // com.baidu.tieba.nma
    public final nma<TResult> a(kma<TResult> kmaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kmaVar)) == null) {
            m(pma.c(), kmaVar);
            return this;
        }
        return (nma) invokeL.objValue;
    }

    @Override // com.baidu.tieba.nma
    public final nma<TResult> b(lma lmaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lmaVar)) == null) {
            n(pma.c(), lmaVar);
            return this;
        }
        return (nma) invokeL.objValue;
    }

    @Override // com.baidu.tieba.nma
    public final nma<TResult> c(mma<TResult> mmaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mmaVar)) == null) {
            o(pma.c(), mmaVar);
            return this;
        }
        return (nma) invokeL.objValue;
    }

    @Override // com.baidu.tieba.nma
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

    @Override // com.baidu.tieba.nma
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

    @Override // com.baidu.tieba.nma
    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.c : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.nma
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

    @Override // com.baidu.tieba.nma
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

    public final nma<TResult> i(jma<TResult> jmaVar) {
        InterceptResult invokeL;
        boolean g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jmaVar)) == null) {
            synchronized (this.a) {
                g = g();
                if (!g) {
                    this.f.add(jmaVar);
                }
            }
            if (g) {
                jmaVar.onComplete(this);
            }
            return this;
        }
        return (nma) invokeL.objValue;
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

    public final nma<TResult> m(Executor executor, kma<TResult> kmaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, executor, kmaVar)) == null) {
            i(new sma(executor, kmaVar));
            return this;
        }
        return (nma) invokeLL.objValue;
    }

    public final nma<TResult> n(Executor executor, lma lmaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, executor, lmaVar)) == null) {
            i(new tma(executor, lmaVar));
            return this;
        }
        return (nma) invokeLL.objValue;
    }

    public final nma<TResult> o(Executor executor, mma<TResult> mmaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, executor, mmaVar)) == null) {
            i(new uma(executor, mmaVar));
            return this;
        }
        return (nma) invokeLL.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this.a) {
                for (jma<TResult> jmaVar : this.f) {
                    try {
                        jmaVar.onComplete(this);
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
