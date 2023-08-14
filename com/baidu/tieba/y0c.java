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
public class y0c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes8.dex */
    public interface a<T> extends m1c<e1c<? super T>> {
        @Override // com.baidu.tieba.m1c
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes8.dex */
    public interface b<R, T> extends q1c<e1c<? super R>, e1c<? super T>> {
        @Override // com.baidu.tieba.q1c
        /* synthetic */ R call(T t);
    }

    public y0c(a<T> aVar) {
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

    public static <T> y0c<T> d(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, aVar)) == null) {
            return new y0c<>(l5c.h(aVar));
        }
        return (y0c) invokeL.objValue;
    }

    public static <T> y0c<T> m(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, iterable)) == null) {
            return d(new OnSubscribeFromIterable(iterable));
        }
        return (y0c) invokeL.objValue;
    }

    public static <T> y0c<T> n(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, t)) == null) {
            return ScalarSynchronousObservable.P(t);
        }
        return (y0c) invokeL.objValue;
    }

    public static <T> y0c<T> q(Iterable<? extends y0c<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, iterable)) == null) {
            return r(m(iterable));
        }
        return (y0c) invokeL.objValue;
    }

    public static <T> y0c<T> r(y0c<? extends y0c<? extends T>> y0cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, y0cVar)) == null) {
            if (y0cVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) y0cVar).S(UtilityFunctions.b());
            }
            return (y0c<T>) y0cVar.o(OperatorMerge.a(false));
        }
        return (y0c) invokeL.objValue;
    }

    public final y0c<T> D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return (y0c<T>) o(new n2c(i));
        }
        return (y0c) invokeI.objValue;
    }

    public final f1c F(e1c<? super T> e1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, e1cVar)) == null) {
            return G(e1cVar, this);
        }
        return (f1c) invokeL.objValue;
    }

    public final f1c H(m1c<? super T> m1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, m1cVar)) == null) {
            if (m1cVar != null) {
                return F(new j3c(m1cVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (f1c) invokeL.objValue;
    }

    public final y0c<T> J(b1c b1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, b1cVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(b1cVar);
            }
            return d(new o2c(this, b1cVar));
        }
        return (y0c) invokeL.objValue;
    }

    public final y0c<T> h(r1c<? super T, ? super T, Boolean> r1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, r1cVar)) == null) {
            return (y0c<T>) o(new g2c(r1cVar));
        }
        return (y0c) invokeL.objValue;
    }

    public final y0c<T> i(m1c<? super T> m1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, m1cVar)) == null) {
            return d(new x1c(this, new i3c(m1cVar, Actions.a(), Actions.a())));
        }
        return (y0c) invokeL.objValue;
    }

    public final y0c<T> k(q1c<? super T, Boolean> q1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, q1cVar)) == null) {
            return d(new y1c(this, q1cVar));
        }
        return (y0c) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.q1c<? super T, ? extends com.baidu.tieba.y0c<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> y0c<R> l(q1c<? super T, ? extends y0c<? extends R>> q1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, q1cVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).S(q1cVar);
            }
            return r(p(q1cVar));
        }
        return (y0c) invokeL.objValue;
    }

    public final <R> y0c<R> o(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bVar)) == null) {
            return d(new z1c(this.a, bVar));
        }
        return (y0c) invokeL.objValue;
    }

    public final <R> y0c<R> p(q1c<? super T, ? extends R> q1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, q1cVar)) == null) {
            return d(new a2c(this, q1cVar));
        }
        return (y0c) invokeL.objValue;
    }

    public final y0c<T> s(b1c b1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, b1cVar)) == null) {
            return t(b1cVar, n3c.c);
        }
        return (y0c) invokeL.objValue;
    }

    public final c5c<T> z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            return OperatorReplay.R(this, i);
        }
        return (c5c) invokeI.objValue;
    }

    public static <T> f1c G(e1c<? super T> e1cVar, y0c<T> y0cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, e1cVar, y0cVar)) == null) {
            if (e1cVar != null) {
                if (y0cVar.a != null) {
                    e1cVar.d();
                    if (!(e1cVar instanceof f5c)) {
                        e1cVar = new f5c(e1cVar);
                    }
                    try {
                        l5c.p(y0cVar, y0cVar.a).call(e1cVar);
                        return l5c.o(e1cVar);
                    } catch (Throwable th) {
                        k1c.e(th);
                        if (e1cVar.isUnsubscribed()) {
                            l5c.j(l5c.m(th));
                        } else {
                            try {
                                e1cVar.onError(l5c.m(th));
                            } catch (Throwable th2) {
                                k1c.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                l5c.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return b6c.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (f1c) invokeLL.objValue;
    }

    public static y0c<Long> M(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, timeUnit)) == null) {
            return N(j, timeUnit, Schedulers.computation());
        }
        return (y0c) invokeJL.objValue;
    }

    public static <T, R> y0c<R> b(List<? extends y0c<? extends T>> list, s1c<? extends R> s1cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, s1cVar)) == null) {
            return d(new OnSubscribeCombineLatest(list, s1cVar));
        }
        return (y0c) invokeLL.objValue;
    }

    public final y0c<T> K(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048585, this, j, timeUnit)) == null) {
            return L(j, timeUnit, null, Schedulers.computation());
        }
        return (y0c) invokeJL.objValue;
    }

    public final y0c<T> e(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048589, this, j, timeUnit)) == null) {
            return f(j, timeUnit, Schedulers.computation());
        }
        return (y0c) invokeJL.objValue;
    }

    public final y0c<T> t(b1c b1cVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, b1cVar, i)) == null) {
            return u(b1cVar, false, i);
        }
        return (y0c) invokeLI.objValue;
    }

    public static y0c<Long> N(long j, TimeUnit timeUnit, b1c b1cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), timeUnit, b1cVar})) == null) {
            return d(new c2c(j, timeUnit, b1cVar));
        }
        return (y0c) invokeCommon.objValue;
    }

    public static <T1, T2, R> y0c<R> c(y0c<? extends T1> y0cVar, y0c<? extends T2> y0cVar2, r1c<? super T1, ? super T2, ? extends R> r1cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, y0cVar, y0cVar2, r1cVar)) == null) {
            return b(Arrays.asList(y0cVar, y0cVar2), t1c.a(r1cVar));
        }
        return (y0c) invokeLLL.objValue;
    }

    public final c5c<T> B(long j, TimeUnit timeUnit, b1c b1cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, b1cVar})) == null) {
            return OperatorReplay.S(this, j, timeUnit, b1cVar);
        }
        return (c5c) invokeCommon.objValue;
    }

    public final y0c<T> f(long j, TimeUnit timeUnit, b1c b1cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), timeUnit, b1cVar})) == null) {
            return (y0c<T>) o(new f2c(j, timeUnit, b1cVar));
        }
        return (y0c) invokeCommon.objValue;
    }

    public static <T> y0c<T> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (y0c) invokeV.objValue;
    }

    public final y0c<T> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return b2c.a(this);
        }
        return (y0c) invokeV.objValue;
    }

    public final f1c E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return F(new j3c(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (f1c) invokeV.objValue;
    }

    public final y0c<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return (y0c<T>) o(e2c.a());
        }
        return (y0c) invokeV.objValue;
    }

    public final y0c<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return (y0c<T>) o(g2c.a());
        }
        return (y0c) invokeV.objValue;
    }

    public final y0c<T> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return (y0c<T>) o(k2c.a());
        }
        return (y0c) invokeV.objValue;
    }

    public final y0c<T> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return (y0c<T>) o(l2c.a());
        }
        return (y0c) invokeV.objValue;
    }

    public final y0c<T> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return (y0c<T>) o(OperatorOnBackpressureLatest.a());
        }
        return (y0c) invokeV.objValue;
    }

    public final c5c<T> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return OperatorReplay.Q(this);
        }
        return (c5c) invokeV.objValue;
    }

    public final c5c<T> A(int i, long j, TimeUnit timeUnit, b1c b1cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, b1cVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.T(this, j, timeUnit, b1cVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (c5c) invokeCommon.objValue;
    }

    public final y0c<T> L(long j, TimeUnit timeUnit, y0c<? extends T> y0cVar, b1c b1cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), timeUnit, y0cVar, b1cVar})) == null) {
            return (y0c<T>) o(new p2c(j, timeUnit, y0cVar, b1cVar));
        }
        return (y0c) invokeCommon.objValue;
    }

    public final f1c I(m1c<? super T> m1cVar, m1c<Throwable> m1cVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, m1cVar, m1cVar2)) == null) {
            if (m1cVar != null) {
                if (m1cVar2 != null) {
                    return F(new j3c(m1cVar, m1cVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (f1c) invokeLL.objValue;
    }

    public final f1c O(e1c<? super T> e1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, e1cVar)) == null) {
            try {
                e1cVar.d();
                l5c.p(this, this.a).call(e1cVar);
                return l5c.o(e1cVar);
            } catch (Throwable th) {
                k1c.e(th);
                try {
                    e1cVar.onError(l5c.m(th));
                    return b6c.c();
                } catch (Throwable th2) {
                    k1c.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    l5c.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (f1c) invokeL.objValue;
    }

    public final y0c<T> u(b1c b1cVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{b1cVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(b1cVar);
            }
            return (y0c<T>) o(new j2c(b1cVar, z, i));
        }
        return (y0c) invokeCommon.objValue;
    }
}
