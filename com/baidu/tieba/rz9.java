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
/* loaded from: classes5.dex */
public class rz9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes5.dex */
    public interface a<T> extends f0a<xz9<? super T>> {
        @Override // com.baidu.tieba.f0a
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes5.dex */
    public interface b<R, T> extends j0a<xz9<? super R>, xz9<? super T>> {
        @Override // com.baidu.tieba.j0a
        /* synthetic */ R call(T t);
    }

    public rz9(a<T> aVar) {
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

    public static <T> rz9<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            return new rz9<>(y3a.h(aVar));
        }
        return (rz9) invokeL.objValue;
    }

    public static <T> rz9<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            return a(new OnSubscribeFromIterable(iterable));
        }
        return (rz9) invokeL.objValue;
    }

    public static <T> rz9<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) {
            return ScalarSynchronousObservable.C(t);
        }
        return (rz9) invokeL.objValue;
    }

    public static <T> rz9<T> i(Iterable<? extends rz9<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) {
            return j(e(iterable));
        }
        return (rz9) invokeL.objValue;
    }

    public static <T> rz9<T> j(rz9<? extends rz9<? extends T>> rz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, rz9Var)) == null) {
            if (rz9Var.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) rz9Var).F(UtilityFunctions.b());
            }
            return (rz9<T>) rz9Var.g(OperatorMerge.a(false));
        }
        return (rz9) invokeL.objValue;
    }

    public final rz9<T> b(f0a<? super T> f0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, f0aVar)) == null) {
            return a(new q0a(this, new v1a(f0aVar, Actions.a(), Actions.a())));
        }
        return (rz9) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.j0a<? super T, ? extends com.baidu.tieba.rz9<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> rz9<R> d(j0a<? super T, ? extends rz9<? extends R>> j0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, j0aVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(j0aVar);
            }
            return j(h(j0aVar));
        }
        return (rz9) invokeL.objValue;
    }

    public final <R> rz9<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            return a(new r0a(this.a, bVar));
        }
        return (rz9) invokeL.objValue;
    }

    public final <R> rz9<R> h(j0a<? super T, ? extends R> j0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, j0aVar)) == null) {
            return a(new s0a(this, j0aVar));
        }
        return (rz9) invokeL.objValue;
    }

    public final rz9<T> k(uz9 uz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, uz9Var)) == null) {
            return l(uz9Var, a2a.c);
        }
        return (rz9) invokeL.objValue;
    }

    public final p3a<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            return OperatorReplay.E(this, i);
        }
        return (p3a) invokeI.objValue;
    }

    public final yz9 u(xz9<? super T> xz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, xz9Var)) == null) {
            return v(xz9Var, this);
        }
        return (yz9) invokeL.objValue;
    }

    public final yz9 w(f0a<? super T> f0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, f0aVar)) == null) {
            if (f0aVar != null) {
                return u(new w1a(f0aVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (yz9) invokeL.objValue;
    }

    public final rz9<T> y(uz9 uz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, uz9Var)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(uz9Var);
            }
            return a(new b1a(this, uz9Var));
        }
        return (rz9) invokeL.objValue;
    }

    public static <T> rz9<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (rz9) invokeV.objValue;
    }

    public final rz9<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return (rz9<T>) g(y0a.a());
        }
        return (rz9) invokeV.objValue;
    }

    public final p3a<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return OperatorReplay.D(this);
        }
        return (p3a) invokeV.objValue;
    }

    public final rz9<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return t0a.a(this);
        }
        return (rz9) invokeV.objValue;
    }

    public final yz9 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return u(new w1a(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (yz9) invokeV.objValue;
    }

    public static <T> yz9 v(xz9<? super T> xz9Var, rz9<T> rz9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, xz9Var, rz9Var)) == null) {
            if (xz9Var != null) {
                if (rz9Var.a != null) {
                    xz9Var.d();
                    if (!(xz9Var instanceof s3a)) {
                        xz9Var = new s3a(xz9Var);
                    }
                    try {
                        y3a.p(rz9Var, rz9Var.a).call(xz9Var);
                        return y3a.o(xz9Var);
                    } catch (Throwable th) {
                        d0a.e(th);
                        if (xz9Var.isUnsubscribed()) {
                            y3a.j(y3a.m(th));
                        } else {
                            try {
                                xz9Var.onError(y3a.m(th));
                            } catch (Throwable th2) {
                                d0a.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                y3a.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return o4a.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (yz9) invokeLL.objValue;
    }

    public final rz9<T> A(long j, TimeUnit timeUnit, rz9<? extends T> rz9Var, uz9 uz9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, rz9Var, uz9Var})) == null) {
            return (rz9<T>) g(new c1a(j, timeUnit, rz9Var, uz9Var));
        }
        return (rz9) invokeCommon.objValue;
    }

    public final p3a<T> q(int i, long j, TimeUnit timeUnit, uz9 uz9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, uz9Var})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, uz9Var, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (p3a) invokeCommon.objValue;
    }

    public final yz9 B(xz9<? super T> xz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xz9Var)) == null) {
            try {
                xz9Var.d();
                y3a.p(this, this.a).call(xz9Var);
                return y3a.o(xz9Var);
            } catch (Throwable th) {
                d0a.e(th);
                try {
                    xz9Var.onError(y3a.m(th));
                    return o4a.c();
                } catch (Throwable th2) {
                    d0a.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    y3a.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (yz9) invokeL.objValue;
    }

    public final rz9<T> l(uz9 uz9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, uz9Var, i)) == null) {
            return m(uz9Var, false, i);
        }
        return (rz9) invokeLI.objValue;
    }

    public final rz9<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) {
            return A(j, timeUnit, null, Schedulers.computation());
        }
        return (rz9) invokeJL.objValue;
    }

    public final rz9<T> m(uz9 uz9Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{uz9Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(uz9Var);
            }
            return (rz9<T>) g(new x0a(uz9Var, z, i));
        }
        return (rz9) invokeCommon.objValue;
    }

    public final p3a<T> r(long j, TimeUnit timeUnit, uz9 uz9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, uz9Var})) == null) {
            return OperatorReplay.F(this, j, timeUnit, uz9Var);
        }
        return (p3a) invokeCommon.objValue;
    }

    public final yz9 x(f0a<? super T> f0aVar, f0a<Throwable> f0aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, f0aVar, f0aVar2)) == null) {
            if (f0aVar != null) {
                if (f0aVar2 != null) {
                    return u(new w1a(f0aVar, f0aVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (yz9) invokeLL.objValue;
    }
}
