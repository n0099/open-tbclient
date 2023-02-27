package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorFailedException;
import rx.functions.Actions;
import rx.internal.operators.EmptyObservableHolder;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorReplay;
import rx.internal.util.InternalObservableUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.UtilityFunctions;
import rx.schedulers.Schedulers;
/* loaded from: classes6.dex */
public class sma<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes6.dex */
    public interface a<T> extends gna<yma<? super T>> {
        @Override // com.baidu.tieba.gna
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes6.dex */
    public interface b<R, T> extends kna<yma<? super R>, yma<? super T>> {
        @Override // com.baidu.tieba.kna
        /* synthetic */ R call(T t);
    }

    public sma(a<T> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
    }

    public static <T> sma<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            return new sma<>(zqa.h(aVar));
        }
        return (sma) invokeL.objValue;
    }

    public static <T> sma<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            return a(new OnSubscribeFromIterable(iterable));
        }
        return (sma) invokeL.objValue;
    }

    public static <T> sma<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) {
            return ScalarSynchronousObservable.C(t);
        }
        return (sma) invokeL.objValue;
    }

    public static <T> sma<T> i(Iterable<? extends sma<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) {
            return j(e(iterable));
        }
        return (sma) invokeL.objValue;
    }

    public static <T> sma<T> j(sma<? extends sma<? extends T>> smaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, smaVar)) == null) {
            if (smaVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) smaVar).F(UtilityFunctions.b());
            }
            return (sma<T>) smaVar.g(OperatorMerge.a(false));
        }
        return (sma) invokeL.objValue;
    }

    public final sma<T> b(gna<? super T> gnaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gnaVar)) == null) {
            return a(new rna(this, new woa(gnaVar, Actions.a(), Actions.a())));
        }
        return (sma) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.kna<? super T, ? extends com.baidu.tieba.sma<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> sma<R> d(kna<? super T, ? extends sma<? extends R>> knaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, knaVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(knaVar);
            }
            return j(h(knaVar));
        }
        return (sma) invokeL.objValue;
    }

    public final <R> sma<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            return a(new sna(this.a, bVar));
        }
        return (sma) invokeL.objValue;
    }

    public final <R> sma<R> h(kna<? super T, ? extends R> knaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, knaVar)) == null) {
            return a(new tna(this, knaVar));
        }
        return (sma) invokeL.objValue;
    }

    public final sma<T> k(vma vmaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, vmaVar)) == null) {
            return l(vmaVar, bpa.c);
        }
        return (sma) invokeL.objValue;
    }

    public final qqa<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            return OperatorReplay.E(this, i);
        }
        return (qqa) invokeI.objValue;
    }

    public final zma u(yma<? super T> ymaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, ymaVar)) == null) {
            return v(ymaVar, this);
        }
        return (zma) invokeL.objValue;
    }

    public final zma w(gna<? super T> gnaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, gnaVar)) == null) {
            if (gnaVar != null) {
                return u(new xoa(gnaVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (zma) invokeL.objValue;
    }

    public final sma<T> y(vma vmaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, vmaVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(vmaVar);
            }
            return a(new coa(this, vmaVar));
        }
        return (sma) invokeL.objValue;
    }

    public static <T> sma<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (sma) invokeV.objValue;
    }

    public final sma<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return (sma<T>) g(zna.a());
        }
        return (sma) invokeV.objValue;
    }

    public final qqa<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return OperatorReplay.D(this);
        }
        return (qqa) invokeV.objValue;
    }

    public final sma<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return una.a(this);
        }
        return (sma) invokeV.objValue;
    }

    public final zma t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return u(new xoa(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (zma) invokeV.objValue;
    }

    public static <T> zma v(yma<? super T> ymaVar, sma<T> smaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, ymaVar, smaVar)) == null) {
            if (ymaVar != null) {
                if (smaVar.a != null) {
                    ymaVar.d();
                    if (!(ymaVar instanceof tqa)) {
                        ymaVar = new tqa(ymaVar);
                    }
                    try {
                        zqa.p(smaVar, smaVar.a).call(ymaVar);
                        return zqa.o(ymaVar);
                    } catch (Throwable th) {
                        ena.e(th);
                        if (ymaVar.isUnsubscribed()) {
                            zqa.j(zqa.m(th));
                        } else {
                            try {
                                ymaVar.onError(zqa.m(th));
                            } catch (Throwable th2) {
                                ena.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                zqa.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return pra.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (zma) invokeLL.objValue;
    }

    public final sma<T> A(long j, TimeUnit timeUnit, sma<? extends T> smaVar, vma vmaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, smaVar, vmaVar})) == null) {
            return (sma<T>) g(new doa(j, timeUnit, smaVar, vmaVar));
        }
        return (sma) invokeCommon.objValue;
    }

    public final qqa<T> q(int i, long j, TimeUnit timeUnit, vma vmaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, vmaVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, vmaVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (qqa) invokeCommon.objValue;
    }

    public final zma B(yma<? super T> ymaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ymaVar)) == null) {
            try {
                ymaVar.d();
                zqa.p(this, this.a).call(ymaVar);
                return zqa.o(ymaVar);
            } catch (Throwable th) {
                ena.e(th);
                try {
                    ymaVar.onError(zqa.m(th));
                    return pra.c();
                } catch (Throwable th2) {
                    ena.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    zqa.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (zma) invokeL.objValue;
    }

    public final sma<T> l(vma vmaVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, vmaVar, i)) == null) {
            return m(vmaVar, false, i);
        }
        return (sma) invokeLI.objValue;
    }

    public final sma<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) {
            return A(j, timeUnit, null, Schedulers.computation());
        }
        return (sma) invokeJL.objValue;
    }

    public final sma<T> m(vma vmaVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{vmaVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(vmaVar);
            }
            return (sma<T>) g(new yna(vmaVar, z, i));
        }
        return (sma) invokeCommon.objValue;
    }

    public final qqa<T> r(long j, TimeUnit timeUnit, vma vmaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, vmaVar})) == null) {
            return OperatorReplay.F(this, j, timeUnit, vmaVar);
        }
        return (qqa) invokeCommon.objValue;
    }

    public final zma x(gna<? super T> gnaVar, gna<Throwable> gnaVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, gnaVar, gnaVar2)) == null) {
            if (gnaVar != null) {
                if (gnaVar2 != null) {
                    return u(new xoa(gnaVar, gnaVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (zma) invokeLL.objValue;
    }
}
