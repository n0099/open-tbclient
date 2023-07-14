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
public class u1c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes8.dex */
    public interface a<T> extends i2c<a2c<? super T>> {
        @Override // com.baidu.tieba.i2c
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes8.dex */
    public interface b<R, T> extends m2c<a2c<? super R>, a2c<? super T>> {
        @Override // com.baidu.tieba.m2c
        /* synthetic */ R call(T t);
    }

    public u1c(a<T> aVar) {
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

    public static <T> u1c<T> d(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, aVar)) == null) {
            return new u1c<>(h6c.h(aVar));
        }
        return (u1c) invokeL.objValue;
    }

    public static <T> u1c<T> m(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, iterable)) == null) {
            return d(new OnSubscribeFromIterable(iterable));
        }
        return (u1c) invokeL.objValue;
    }

    public static <T> u1c<T> n(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, t)) == null) {
            return ScalarSynchronousObservable.P(t);
        }
        return (u1c) invokeL.objValue;
    }

    public static <T> u1c<T> q(Iterable<? extends u1c<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, iterable)) == null) {
            return r(m(iterable));
        }
        return (u1c) invokeL.objValue;
    }

    public static <T> u1c<T> r(u1c<? extends u1c<? extends T>> u1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, u1cVar)) == null) {
            if (u1cVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) u1cVar).S(UtilityFunctions.b());
            }
            return (u1c<T>) u1cVar.o(OperatorMerge.a(false));
        }
        return (u1c) invokeL.objValue;
    }

    public final u1c<T> D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return (u1c<T>) o(new j3c(i));
        }
        return (u1c) invokeI.objValue;
    }

    public final b2c F(a2c<? super T> a2cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, a2cVar)) == null) {
            return G(a2cVar, this);
        }
        return (b2c) invokeL.objValue;
    }

    public final b2c H(i2c<? super T> i2cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, i2cVar)) == null) {
            if (i2cVar != null) {
                return F(new f4c(i2cVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (b2c) invokeL.objValue;
    }

    public final u1c<T> J(x1c x1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, x1cVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(x1cVar);
            }
            return d(new k3c(this, x1cVar));
        }
        return (u1c) invokeL.objValue;
    }

    public final u1c<T> h(n2c<? super T, ? super T, Boolean> n2cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, n2cVar)) == null) {
            return (u1c<T>) o(new c3c(n2cVar));
        }
        return (u1c) invokeL.objValue;
    }

    public final u1c<T> i(i2c<? super T> i2cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, i2cVar)) == null) {
            return d(new t2c(this, new e4c(i2cVar, Actions.a(), Actions.a())));
        }
        return (u1c) invokeL.objValue;
    }

    public final u1c<T> k(m2c<? super T, Boolean> m2cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, m2cVar)) == null) {
            return d(new u2c(this, m2cVar));
        }
        return (u1c) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.m2c<? super T, ? extends com.baidu.tieba.u1c<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> u1c<R> l(m2c<? super T, ? extends u1c<? extends R>> m2cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, m2cVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).S(m2cVar);
            }
            return r(p(m2cVar));
        }
        return (u1c) invokeL.objValue;
    }

    public final <R> u1c<R> o(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bVar)) == null) {
            return d(new v2c(this.a, bVar));
        }
        return (u1c) invokeL.objValue;
    }

    public final <R> u1c<R> p(m2c<? super T, ? extends R> m2cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, m2cVar)) == null) {
            return d(new w2c(this, m2cVar));
        }
        return (u1c) invokeL.objValue;
    }

    public final u1c<T> s(x1c x1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, x1cVar)) == null) {
            return t(x1cVar, j4c.c);
        }
        return (u1c) invokeL.objValue;
    }

    public final y5c<T> z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            return OperatorReplay.R(this, i);
        }
        return (y5c) invokeI.objValue;
    }

    public static <T> b2c G(a2c<? super T> a2cVar, u1c<T> u1cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, a2cVar, u1cVar)) == null) {
            if (a2cVar != null) {
                if (u1cVar.a != null) {
                    a2cVar.d();
                    if (!(a2cVar instanceof b6c)) {
                        a2cVar = new b6c(a2cVar);
                    }
                    try {
                        h6c.p(u1cVar, u1cVar.a).call(a2cVar);
                        return h6c.o(a2cVar);
                    } catch (Throwable th) {
                        g2c.e(th);
                        if (a2cVar.isUnsubscribed()) {
                            h6c.j(h6c.m(th));
                        } else {
                            try {
                                a2cVar.onError(h6c.m(th));
                            } catch (Throwable th2) {
                                g2c.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                h6c.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return x6c.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (b2c) invokeLL.objValue;
    }

    public static u1c<Long> M(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, timeUnit)) == null) {
            return N(j, timeUnit, Schedulers.computation());
        }
        return (u1c) invokeJL.objValue;
    }

    public static <T, R> u1c<R> b(List<? extends u1c<? extends T>> list, o2c<? extends R> o2cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, o2cVar)) == null) {
            return d(new OnSubscribeCombineLatest(list, o2cVar));
        }
        return (u1c) invokeLL.objValue;
    }

    public final u1c<T> K(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048585, this, j, timeUnit)) == null) {
            return L(j, timeUnit, null, Schedulers.computation());
        }
        return (u1c) invokeJL.objValue;
    }

    public final u1c<T> e(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048589, this, j, timeUnit)) == null) {
            return f(j, timeUnit, Schedulers.computation());
        }
        return (u1c) invokeJL.objValue;
    }

    public final u1c<T> t(x1c x1cVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, x1cVar, i)) == null) {
            return u(x1cVar, false, i);
        }
        return (u1c) invokeLI.objValue;
    }

    public static u1c<Long> N(long j, TimeUnit timeUnit, x1c x1cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), timeUnit, x1cVar})) == null) {
            return d(new y2c(j, timeUnit, x1cVar));
        }
        return (u1c) invokeCommon.objValue;
    }

    public static <T1, T2, R> u1c<R> c(u1c<? extends T1> u1cVar, u1c<? extends T2> u1cVar2, n2c<? super T1, ? super T2, ? extends R> n2cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, u1cVar, u1cVar2, n2cVar)) == null) {
            return b(Arrays.asList(u1cVar, u1cVar2), p2c.a(n2cVar));
        }
        return (u1c) invokeLLL.objValue;
    }

    public final y5c<T> B(long j, TimeUnit timeUnit, x1c x1cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, x1cVar})) == null) {
            return OperatorReplay.S(this, j, timeUnit, x1cVar);
        }
        return (y5c) invokeCommon.objValue;
    }

    public final u1c<T> f(long j, TimeUnit timeUnit, x1c x1cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), timeUnit, x1cVar})) == null) {
            return (u1c<T>) o(new b3c(j, timeUnit, x1cVar));
        }
        return (u1c) invokeCommon.objValue;
    }

    public static <T> u1c<T> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (u1c) invokeV.objValue;
    }

    public final u1c<T> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return x2c.a(this);
        }
        return (u1c) invokeV.objValue;
    }

    public final b2c E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return F(new f4c(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (b2c) invokeV.objValue;
    }

    public final u1c<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return (u1c<T>) o(a3c.a());
        }
        return (u1c) invokeV.objValue;
    }

    public final u1c<T> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return (u1c<T>) o(c3c.a());
        }
        return (u1c) invokeV.objValue;
    }

    public final u1c<T> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return (u1c<T>) o(g3c.a());
        }
        return (u1c) invokeV.objValue;
    }

    public final u1c<T> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return (u1c<T>) o(h3c.a());
        }
        return (u1c) invokeV.objValue;
    }

    public final u1c<T> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return (u1c<T>) o(OperatorOnBackpressureLatest.a());
        }
        return (u1c) invokeV.objValue;
    }

    public final y5c<T> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return OperatorReplay.Q(this);
        }
        return (y5c) invokeV.objValue;
    }

    public final y5c<T> A(int i, long j, TimeUnit timeUnit, x1c x1cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, x1cVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.T(this, j, timeUnit, x1cVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (y5c) invokeCommon.objValue;
    }

    public final u1c<T> L(long j, TimeUnit timeUnit, u1c<? extends T> u1cVar, x1c x1cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), timeUnit, u1cVar, x1cVar})) == null) {
            return (u1c<T>) o(new l3c(j, timeUnit, u1cVar, x1cVar));
        }
        return (u1c) invokeCommon.objValue;
    }

    public final b2c I(i2c<? super T> i2cVar, i2c<Throwable> i2cVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, i2cVar, i2cVar2)) == null) {
            if (i2cVar != null) {
                if (i2cVar2 != null) {
                    return F(new f4c(i2cVar, i2cVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (b2c) invokeLL.objValue;
    }

    public final b2c O(a2c<? super T> a2cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, a2cVar)) == null) {
            try {
                a2cVar.d();
                h6c.p(this, this.a).call(a2cVar);
                return h6c.o(a2cVar);
            } catch (Throwable th) {
                g2c.e(th);
                try {
                    a2cVar.onError(h6c.m(th));
                    return x6c.c();
                } catch (Throwable th2) {
                    g2c.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    h6c.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (b2c) invokeL.objValue;
    }

    public final u1c<T> u(x1c x1cVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{x1cVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).T(x1cVar);
            }
            return (u1c<T>) o(new f3c(x1cVar, z, i));
        }
        return (u1c) invokeCommon.objValue;
    }
}
