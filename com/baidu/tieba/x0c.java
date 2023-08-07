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
/* loaded from: classes8.dex */
public class x0c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes8.dex */
    public interface a<T> extends l1c<d1c<? super T>> {
        @Override // com.baidu.tieba.l1c
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes8.dex */
    public interface b<R, T> extends p1c<d1c<? super R>, d1c<? super T>> {
        @Override // com.baidu.tieba.p1c
        /* synthetic */ R call(T t);
    }

    public x0c(a<T> aVar) {
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

    public static <T> x0c<T> d(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, aVar)) == null) {
            return new x0c<>(k5c.h(aVar));
        }
        return (x0c) invokeL.objValue;
    }

    public static <T> x0c<T> m(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, iterable)) == null) {
            return d(new OnSubscribeFromIterable(iterable));
        }
        return (x0c) invokeL.objValue;
    }

    public static <T> x0c<T> n(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, t)) == null) {
            return ScalarSynchronousObservable.P(t);
        }
        return (x0c) invokeL.objValue;
    }

    public static <T> x0c<T> q(Iterable<? extends x0c<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, iterable)) == null) {
            return r(m(iterable));
        }
        return (x0c) invokeL.objValue;
    }

    public static <T> x0c<T> r(x0c<? extends x0c<? extends T>> x0cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, x0cVar)) == null) {
            if (x0cVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) x0cVar).S(UtilityFunctions.b());
            }
            return (x0c<T>) x0cVar.o(OperatorMerge.a(false));
        }
        return (x0c) invokeL.objValue;
    }

    public final x0c<T> D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return (x0c<T>) o(new m2c(i));
        }
        return (x0c) invokeI.objValue;
    }

    public final e1c F(d1c<? super T> d1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, d1cVar)) == null) {
            return G(d1cVar, this);
        }
        return (e1c) invokeL.objValue;
    }

    public final e1c H(l1c<? super T> l1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, l1cVar)) == null) {
            if (l1cVar != null) {
                return F(new i3c(l1cVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (e1c) invokeL.objValue;
    }

    public final x0c<T> J(a1c a1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, a1cVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(a1cVar);
            }
            return d(new n2c(this, a1cVar));
        }
        return (x0c) invokeL.objValue;
    }

    public final x0c<T> h(q1c<? super T, ? super T, Boolean> q1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, q1cVar)) == null) {
            return (x0c<T>) o(new f2c(q1cVar));
        }
        return (x0c) invokeL.objValue;
    }

    public final x0c<T> i(l1c<? super T> l1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, l1cVar)) == null) {
            return d(new w1c(this, new h3c(l1cVar, Actions.a(), Actions.a())));
        }
        return (x0c) invokeL.objValue;
    }

    public final x0c<T> k(p1c<? super T, Boolean> p1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, p1cVar)) == null) {
            return d(new x1c(this, p1cVar));
        }
        return (x0c) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.p1c<? super T, ? extends com.baidu.tieba.x0c<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> x0c<R> l(p1c<? super T, ? extends x0c<? extends R>> p1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, p1cVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).S(p1cVar);
            }
            return r(p(p1cVar));
        }
        return (x0c) invokeL.objValue;
    }

    public final <R> x0c<R> o(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bVar)) == null) {
            return d(new y1c(this.a, bVar));
        }
        return (x0c) invokeL.objValue;
    }

    public final <R> x0c<R> p(p1c<? super T, ? extends R> p1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, p1cVar)) == null) {
            return d(new z1c(this, p1cVar));
        }
        return (x0c) invokeL.objValue;
    }

    public final x0c<T> s(a1c a1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, a1cVar)) == null) {
            return t(a1cVar, m3c.c);
        }
        return (x0c) invokeL.objValue;
    }

    public final b5c<T> z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            return OperatorReplay.R(this, i);
        }
        return (b5c) invokeI.objValue;
    }

    public static <T> e1c G(d1c<? super T> d1cVar, x0c<T> x0cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, d1cVar, x0cVar)) == null) {
            if (d1cVar != null) {
                if (x0cVar.a != null) {
                    d1cVar.d();
                    if (!(d1cVar instanceof e5c)) {
                        d1cVar = new e5c(d1cVar);
                    }
                    try {
                        k5c.p(x0cVar, x0cVar.a).call(d1cVar);
                        return k5c.o(d1cVar);
                    } catch (Throwable th) {
                        j1c.e(th);
                        if (d1cVar.isUnsubscribed()) {
                            k5c.j(k5c.m(th));
                        } else {
                            try {
                                d1cVar.onError(k5c.m(th));
                            } catch (Throwable th2) {
                                j1c.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                k5c.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return a6c.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (e1c) invokeLL.objValue;
    }

    public static x0c<Long> M(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, timeUnit)) == null) {
            return N(j, timeUnit, Schedulers.computation());
        }
        return (x0c) invokeJL.objValue;
    }

    public static <T, R> x0c<R> b(List<? extends x0c<? extends T>> list, r1c<? extends R> r1cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, r1cVar)) == null) {
            return d(new OnSubscribeCombineLatest(list, r1cVar));
        }
        return (x0c) invokeLL.objValue;
    }

    public final x0c<T> K(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048585, this, j, timeUnit)) == null) {
            return L(j, timeUnit, null, Schedulers.computation());
        }
        return (x0c) invokeJL.objValue;
    }

    public final x0c<T> e(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048589, this, j, timeUnit)) == null) {
            return f(j, timeUnit, Schedulers.computation());
        }
        return (x0c) invokeJL.objValue;
    }

    public final x0c<T> t(a1c a1cVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, a1cVar, i)) == null) {
            return u(a1cVar, false, i);
        }
        return (x0c) invokeLI.objValue;
    }

    public static x0c<Long> N(long j, TimeUnit timeUnit, a1c a1cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), timeUnit, a1cVar})) == null) {
            return d(new b2c(j, timeUnit, a1cVar));
        }
        return (x0c) invokeCommon.objValue;
    }

    public static <T1, T2, R> x0c<R> c(x0c<? extends T1> x0cVar, x0c<? extends T2> x0cVar2, q1c<? super T1, ? super T2, ? extends R> q1cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, x0cVar, x0cVar2, q1cVar)) == null) {
            return b(Arrays.asList(x0cVar, x0cVar2), s1c.a(q1cVar));
        }
        return (x0c) invokeLLL.objValue;
    }

    public final b5c<T> B(long j, TimeUnit timeUnit, a1c a1cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, a1cVar})) == null) {
            return OperatorReplay.S(this, j, timeUnit, a1cVar);
        }
        return (b5c) invokeCommon.objValue;
    }

    public final x0c<T> f(long j, TimeUnit timeUnit, a1c a1cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), timeUnit, a1cVar})) == null) {
            return (x0c<T>) o(new e2c(j, timeUnit, a1cVar));
        }
        return (x0c) invokeCommon.objValue;
    }

    public static <T> x0c<T> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (x0c) invokeV.objValue;
    }

    public final x0c<T> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return a2c.a(this);
        }
        return (x0c) invokeV.objValue;
    }

    public final e1c E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return F(new i3c(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (e1c) invokeV.objValue;
    }

    public final x0c<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return (x0c<T>) o(d2c.a());
        }
        return (x0c) invokeV.objValue;
    }

    public final x0c<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return (x0c<T>) o(f2c.a());
        }
        return (x0c) invokeV.objValue;
    }

    public final x0c<T> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return (x0c<T>) o(j2c.a());
        }
        return (x0c) invokeV.objValue;
    }

    public final x0c<T> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return (x0c<T>) o(k2c.a());
        }
        return (x0c) invokeV.objValue;
    }

    public final x0c<T> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return (x0c<T>) o(OperatorOnBackpressureLatest.a());
        }
        return (x0c) invokeV.objValue;
    }

    public final b5c<T> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return OperatorReplay.Q(this);
        }
        return (b5c) invokeV.objValue;
    }

    public final b5c<T> A(int i, long j, TimeUnit timeUnit, a1c a1cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, a1cVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.T(this, j, timeUnit, a1cVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (b5c) invokeCommon.objValue;
    }

    public final x0c<T> L(long j, TimeUnit timeUnit, x0c<? extends T> x0cVar, a1c a1cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), timeUnit, x0cVar, a1cVar})) == null) {
            return (x0c<T>) o(new o2c(j, timeUnit, x0cVar, a1cVar));
        }
        return (x0c) invokeCommon.objValue;
    }

    public final e1c I(l1c<? super T> l1cVar, l1c<Throwable> l1cVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, l1cVar, l1cVar2)) == null) {
            if (l1cVar != null) {
                if (l1cVar2 != null) {
                    return F(new i3c(l1cVar, l1cVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (e1c) invokeLL.objValue;
    }

    public final e1c O(d1c<? super T> d1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, d1cVar)) == null) {
            try {
                d1cVar.d();
                k5c.p(this, this.a).call(d1cVar);
                return k5c.o(d1cVar);
            } catch (Throwable th) {
                j1c.e(th);
                try {
                    d1cVar.onError(k5c.m(th));
                    return a6c.c();
                } catch (Throwable th2) {
                    j1c.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    k5c.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (e1c) invokeL.objValue;
    }

    public final x0c<T> u(a1c a1cVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{a1cVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(a1cVar);
            }
            return (x0c<T>) o(new i2c(a1cVar, z, i));
        }
        return (x0c) invokeCommon.objValue;
    }
}
