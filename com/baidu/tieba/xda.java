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
public class xda<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes6.dex */
    public interface a<T> extends lea<dea<? super T>> {
        @Override // com.baidu.tieba.lea
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes6.dex */
    public interface b<R, T> extends pea<dea<? super R>, dea<? super T>> {
        @Override // com.baidu.tieba.pea
        /* synthetic */ R call(T t);
    }

    public xda(a<T> aVar) {
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

    public static <T> xda<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            return new xda<>(eia.h(aVar));
        }
        return (xda) invokeL.objValue;
    }

    public static <T> xda<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            return a(new OnSubscribeFromIterable(iterable));
        }
        return (xda) invokeL.objValue;
    }

    public static <T> xda<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) {
            return ScalarSynchronousObservable.C(t);
        }
        return (xda) invokeL.objValue;
    }

    public static <T> xda<T> i(Iterable<? extends xda<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) {
            return j(e(iterable));
        }
        return (xda) invokeL.objValue;
    }

    public static <T> xda<T> j(xda<? extends xda<? extends T>> xdaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, xdaVar)) == null) {
            if (xdaVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) xdaVar).F(UtilityFunctions.b());
            }
            return (xda<T>) xdaVar.g(OperatorMerge.a(false));
        }
        return (xda) invokeL.objValue;
    }

    public final xda<T> b(lea<? super T> leaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, leaVar)) == null) {
            return a(new wea(this, new bga(leaVar, Actions.a(), Actions.a())));
        }
        return (xda) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.pea<? super T, ? extends com.baidu.tieba.xda<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> xda<R> d(pea<? super T, ? extends xda<? extends R>> peaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, peaVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(peaVar);
            }
            return j(h(peaVar));
        }
        return (xda) invokeL.objValue;
    }

    public final <R> xda<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            return a(new xea(this.a, bVar));
        }
        return (xda) invokeL.objValue;
    }

    public final <R> xda<R> h(pea<? super T, ? extends R> peaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, peaVar)) == null) {
            return a(new yea(this, peaVar));
        }
        return (xda) invokeL.objValue;
    }

    public final xda<T> k(aea aeaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aeaVar)) == null) {
            return l(aeaVar, gga.c);
        }
        return (xda) invokeL.objValue;
    }

    public final vha<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            return OperatorReplay.E(this, i);
        }
        return (vha) invokeI.objValue;
    }

    public final eea u(dea<? super T> deaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, deaVar)) == null) {
            return v(deaVar, this);
        }
        return (eea) invokeL.objValue;
    }

    public final eea w(lea<? super T> leaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, leaVar)) == null) {
            if (leaVar != null) {
                return u(new cga(leaVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (eea) invokeL.objValue;
    }

    public final xda<T> y(aea aeaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, aeaVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(aeaVar);
            }
            return a(new hfa(this, aeaVar));
        }
        return (xda) invokeL.objValue;
    }

    public static <T> xda<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (xda) invokeV.objValue;
    }

    public final xda<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return (xda<T>) g(efa.a());
        }
        return (xda) invokeV.objValue;
    }

    public final vha<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return OperatorReplay.D(this);
        }
        return (vha) invokeV.objValue;
    }

    public final xda<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return zea.a(this);
        }
        return (xda) invokeV.objValue;
    }

    public final eea t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return u(new cga(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (eea) invokeV.objValue;
    }

    public static <T> eea v(dea<? super T> deaVar, xda<T> xdaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, deaVar, xdaVar)) == null) {
            if (deaVar != null) {
                if (xdaVar.a != null) {
                    deaVar.d();
                    if (!(deaVar instanceof yha)) {
                        deaVar = new yha(deaVar);
                    }
                    try {
                        eia.p(xdaVar, xdaVar.a).call(deaVar);
                        return eia.o(deaVar);
                    } catch (Throwable th) {
                        jea.e(th);
                        if (deaVar.isUnsubscribed()) {
                            eia.j(eia.m(th));
                        } else {
                            try {
                                deaVar.onError(eia.m(th));
                            } catch (Throwable th2) {
                                jea.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                eia.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return uia.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (eea) invokeLL.objValue;
    }

    public final xda<T> A(long j, TimeUnit timeUnit, xda<? extends T> xdaVar, aea aeaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, xdaVar, aeaVar})) == null) {
            return (xda<T>) g(new ifa(j, timeUnit, xdaVar, aeaVar));
        }
        return (xda) invokeCommon.objValue;
    }

    public final vha<T> q(int i, long j, TimeUnit timeUnit, aea aeaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, aeaVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, aeaVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (vha) invokeCommon.objValue;
    }

    public final eea B(dea<? super T> deaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, deaVar)) == null) {
            try {
                deaVar.d();
                eia.p(this, this.a).call(deaVar);
                return eia.o(deaVar);
            } catch (Throwable th) {
                jea.e(th);
                try {
                    deaVar.onError(eia.m(th));
                    return uia.c();
                } catch (Throwable th2) {
                    jea.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    eia.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (eea) invokeL.objValue;
    }

    public final xda<T> l(aea aeaVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, aeaVar, i)) == null) {
            return m(aeaVar, false, i);
        }
        return (xda) invokeLI.objValue;
    }

    public final xda<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) {
            return A(j, timeUnit, null, Schedulers.computation());
        }
        return (xda) invokeJL.objValue;
    }

    public final xda<T> m(aea aeaVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{aeaVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(aeaVar);
            }
            return (xda<T>) g(new dfa(aeaVar, z, i));
        }
        return (xda) invokeCommon.objValue;
    }

    public final vha<T> r(long j, TimeUnit timeUnit, aea aeaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, aeaVar})) == null) {
            return OperatorReplay.F(this, j, timeUnit, aeaVar);
        }
        return (vha) invokeCommon.objValue;
    }

    public final eea x(lea<? super T> leaVar, lea<Throwable> leaVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, leaVar, leaVar2)) == null) {
            if (leaVar != null) {
                if (leaVar2 != null) {
                    return u(new cga(leaVar, leaVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (eea) invokeLL.objValue;
    }
}
