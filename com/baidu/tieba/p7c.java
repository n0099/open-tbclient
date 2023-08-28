package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorFailedException;
import rx.functions.Actions;
import rx.internal.operators.EmptyObservableHolder;
import rx.internal.operators.OnSubscribeCombineLatest;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorOnBackpressureLatest;
import rx.internal.operators.OperatorReplay;
import rx.internal.util.InternalObservableUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.UtilityFunctions;
import rx.schedulers.Schedulers;
/* loaded from: classes7.dex */
public class p7c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes7.dex */
    public interface a<T> extends d8c<v7c<? super T>> {
        @Override // com.baidu.tieba.d8c
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes7.dex */
    public interface b<R, T> extends i8c<v7c<? super R>, v7c<? super T>> {
        @Override // com.baidu.tieba.i8c
        /* synthetic */ R call(T t);
    }

    public p7c(a<T> aVar) {
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

    public static <T> p7c<T> d(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, aVar)) == null) {
            return new p7c<>(dcc.h(aVar));
        }
        return (p7c) invokeL.objValue;
    }

    public static <T> p7c<T> m(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, iterable)) == null) {
            return d(new OnSubscribeFromIterable(iterable));
        }
        return (p7c) invokeL.objValue;
    }

    public static <T> p7c<T> n(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, t)) == null) {
            return ScalarSynchronousObservable.P(t);
        }
        return (p7c) invokeL.objValue;
    }

    public static <T> p7c<T> q(Iterable<? extends p7c<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, iterable)) == null) {
            return r(m(iterable));
        }
        return (p7c) invokeL.objValue;
    }

    public static <T> p7c<T> r(p7c<? extends p7c<? extends T>> p7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, p7cVar)) == null) {
            if (p7cVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) p7cVar).S(UtilityFunctions.b());
            }
            return (p7c<T>) p7cVar.o(OperatorMerge.a(false));
        }
        return (p7c) invokeL.objValue;
    }

    public final p7c<T> D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return (p7c<T>) o(new f9c(i));
        }
        return (p7c) invokeI.objValue;
    }

    public final w7c F(v7c<? super T> v7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, v7cVar)) == null) {
            return G(v7cVar, this);
        }
        return (w7c) invokeL.objValue;
    }

    public final w7c H(d8c<? super T> d8cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, d8cVar)) == null) {
            if (d8cVar != null) {
                return F(new bac(d8cVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (w7c) invokeL.objValue;
    }

    public final p7c<T> J(s7c s7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, s7cVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(s7cVar);
            }
            return d(new g9c(this, s7cVar));
        }
        return (p7c) invokeL.objValue;
    }

    public final p7c<T> h(j8c<? super T, ? super T, Boolean> j8cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, j8cVar)) == null) {
            return (p7c<T>) o(new y8c(j8cVar));
        }
        return (p7c) invokeL.objValue;
    }

    public final p7c<T> i(d8c<? super T> d8cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, d8cVar)) == null) {
            return d(new p8c(this, new aac(d8cVar, Actions.a(), Actions.a())));
        }
        return (p7c) invokeL.objValue;
    }

    public final p7c<T> k(i8c<? super T, Boolean> i8cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, i8cVar)) == null) {
            return d(new q8c(this, i8cVar));
        }
        return (p7c) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.i8c<? super T, ? extends com.baidu.tieba.p7c<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> p7c<R> l(i8c<? super T, ? extends p7c<? extends R>> i8cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, i8cVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).S(i8cVar);
            }
            return r(p(i8cVar));
        }
        return (p7c) invokeL.objValue;
    }

    public final <R> p7c<R> o(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bVar)) == null) {
            return d(new r8c(this.a, bVar));
        }
        return (p7c) invokeL.objValue;
    }

    public final <R> p7c<R> p(i8c<? super T, ? extends R> i8cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, i8cVar)) == null) {
            return d(new s8c(this, i8cVar));
        }
        return (p7c) invokeL.objValue;
    }

    public final p7c<T> s(s7c s7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, s7cVar)) == null) {
            return t(s7cVar, fac.c);
        }
        return (p7c) invokeL.objValue;
    }

    public final ubc<T> z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            return OperatorReplay.R(this, i);
        }
        return (ubc) invokeI.objValue;
    }

    public static <T> w7c G(v7c<? super T> v7cVar, p7c<T> p7cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, v7cVar, p7cVar)) == null) {
            if (v7cVar != null) {
                if (p7cVar.a != null) {
                    v7cVar.d();
                    if (!(v7cVar instanceof xbc)) {
                        v7cVar = new xbc(v7cVar);
                    }
                    try {
                        dcc.p(p7cVar, p7cVar.a).call(v7cVar);
                        return dcc.o(v7cVar);
                    } catch (Throwable th) {
                        b8c.e(th);
                        if (v7cVar.isUnsubscribed()) {
                            dcc.j(dcc.m(th));
                        } else {
                            try {
                                v7cVar.onError(dcc.m(th));
                            } catch (Throwable th2) {
                                b8c.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                dcc.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return tcc.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (w7c) invokeLL.objValue;
    }

    public static p7c<Long> M(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, timeUnit)) == null) {
            return N(j, timeUnit, Schedulers.computation());
        }
        return (p7c) invokeJL.objValue;
    }

    public static <T, R> p7c<R> b(List<? extends p7c<? extends T>> list, k8c<? extends R> k8cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, k8cVar)) == null) {
            return d(new OnSubscribeCombineLatest(list, k8cVar));
        }
        return (p7c) invokeLL.objValue;
    }

    public final p7c<T> K(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048585, this, j, timeUnit)) == null) {
            return L(j, timeUnit, null, Schedulers.computation());
        }
        return (p7c) invokeJL.objValue;
    }

    public final p7c<T> e(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048589, this, j, timeUnit)) == null) {
            return f(j, timeUnit, Schedulers.computation());
        }
        return (p7c) invokeJL.objValue;
    }

    public final p7c<T> t(s7c s7cVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, s7cVar, i)) == null) {
            return u(s7cVar, false, i);
        }
        return (p7c) invokeLI.objValue;
    }

    public static p7c<Long> N(long j, TimeUnit timeUnit, s7c s7cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), timeUnit, s7cVar})) == null) {
            return d(new u8c(j, timeUnit, s7cVar));
        }
        return (p7c) invokeCommon.objValue;
    }

    public static <T1, T2, R> p7c<R> c(p7c<? extends T1> p7cVar, p7c<? extends T2> p7cVar2, j8c<? super T1, ? super T2, ? extends R> j8cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, p7cVar, p7cVar2, j8cVar)) == null) {
            return b(Arrays.asList(p7cVar, p7cVar2), l8c.a(j8cVar));
        }
        return (p7c) invokeLLL.objValue;
    }

    public final ubc<T> B(long j, TimeUnit timeUnit, s7c s7cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, s7cVar})) == null) {
            return OperatorReplay.S(this, j, timeUnit, s7cVar);
        }
        return (ubc) invokeCommon.objValue;
    }

    public final p7c<T> f(long j, TimeUnit timeUnit, s7c s7cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), timeUnit, s7cVar})) == null) {
            return (p7c<T>) o(new x8c(j, timeUnit, s7cVar));
        }
        return (p7c) invokeCommon.objValue;
    }

    public static <T> p7c<T> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (p7c) invokeV.objValue;
    }

    public final p7c<T> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return t8c.a(this);
        }
        return (p7c) invokeV.objValue;
    }

    public final w7c E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return F(new bac(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (w7c) invokeV.objValue;
    }

    public final p7c<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return (p7c<T>) o(w8c.a());
        }
        return (p7c) invokeV.objValue;
    }

    public final p7c<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return (p7c<T>) o(y8c.a());
        }
        return (p7c) invokeV.objValue;
    }

    public final p7c<T> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return (p7c<T>) o(c9c.a());
        }
        return (p7c) invokeV.objValue;
    }

    public final p7c<T> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return (p7c<T>) o(d9c.a());
        }
        return (p7c) invokeV.objValue;
    }

    public final p7c<T> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return (p7c<T>) o(OperatorOnBackpressureLatest.a());
        }
        return (p7c) invokeV.objValue;
    }

    public final ubc<T> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return OperatorReplay.Q(this);
        }
        return (ubc) invokeV.objValue;
    }

    public final ubc<T> A(int i, long j, TimeUnit timeUnit, s7c s7cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, s7cVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.T(this, j, timeUnit, s7cVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (ubc) invokeCommon.objValue;
    }

    public final p7c<T> L(long j, TimeUnit timeUnit, p7c<? extends T> p7cVar, s7c s7cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), timeUnit, p7cVar, s7cVar})) == null) {
            return (p7c<T>) o(new h9c(j, timeUnit, p7cVar, s7cVar));
        }
        return (p7c) invokeCommon.objValue;
    }

    public final w7c I(d8c<? super T> d8cVar, d8c<Throwable> d8cVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, d8cVar, d8cVar2)) == null) {
            if (d8cVar != null) {
                if (d8cVar2 != null) {
                    return F(new bac(d8cVar, d8cVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (w7c) invokeLL.objValue;
    }

    public final w7c O(v7c<? super T> v7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, v7cVar)) == null) {
            try {
                v7cVar.d();
                dcc.p(this, this.a).call(v7cVar);
                return dcc.o(v7cVar);
            } catch (Throwable th) {
                b8c.e(th);
                try {
                    v7cVar.onError(dcc.m(th));
                    return tcc.c();
                } catch (Throwable th2) {
                    b8c.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    dcc.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (w7c) invokeL.objValue;
    }

    public final p7c<T> u(s7c s7cVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{s7cVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(s7cVar);
            }
            return (p7c<T>) o(new b9c(s7cVar, z, i));
        }
        return (p7c) invokeCommon.objValue;
    }
}
