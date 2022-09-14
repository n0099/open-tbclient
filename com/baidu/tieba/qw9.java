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
public class qw9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes5.dex */
    public interface a<T> extends ex9<ww9<? super T>> {
        @Override // com.baidu.tieba.ex9
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes5.dex */
    public interface b<R, T> extends ix9<ww9<? super R>, ww9<? super T>> {
        @Override // com.baidu.tieba.ix9
        /* synthetic */ R call(T t);
    }

    public qw9(a<T> aVar) {
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

    public static <T> qw9<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) ? new qw9<>(x0a.h(aVar)) : (qw9) invokeL.objValue;
    }

    public static <T> qw9<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? EmptyObservableHolder.instance() : (qw9) invokeV.objValue;
    }

    public static <T> qw9<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) ? a(new OnSubscribeFromIterable(iterable)) : (qw9) invokeL.objValue;
    }

    public static <T> qw9<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) ? ScalarSynchronousObservable.C(t) : (qw9) invokeL.objValue;
    }

    public static <T> qw9<T> i(Iterable<? extends qw9<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) ? j(e(iterable)) : (qw9) invokeL.objValue;
    }

    public static <T> qw9<T> j(qw9<? extends qw9<? extends T>> qw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, qw9Var)) == null) {
            if (qw9Var.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) qw9Var).F(UtilityFunctions.b());
            }
            return (qw9<T>) qw9Var.g(OperatorMerge.a(false));
        }
        return (qw9) invokeL.objValue;
    }

    public static <T> xw9 v(ww9<? super T> ww9Var, qw9<T> qw9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, ww9Var, qw9Var)) == null) {
            if (ww9Var != null) {
                if (qw9Var.a != null) {
                    ww9Var.d();
                    if (!(ww9Var instanceof r0a)) {
                        ww9Var = new r0a(ww9Var);
                    }
                    try {
                        x0a.p(qw9Var, qw9Var.a).call(ww9Var);
                        return x0a.o(ww9Var);
                    } catch (Throwable th) {
                        cx9.e(th);
                        if (ww9Var.isUnsubscribed()) {
                            x0a.j(x0a.m(th));
                        } else {
                            try {
                                ww9Var.onError(x0a.m(th));
                            } catch (Throwable th2) {
                                cx9.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                x0a.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return n1a.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (xw9) invokeLL.objValue;
    }

    public final qw9<T> A(long j, TimeUnit timeUnit, qw9<? extends T> qw9Var, tw9 tw9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, qw9Var, tw9Var})) == null) ? (qw9<T>) g(new by9(j, timeUnit, qw9Var, tw9Var)) : (qw9) invokeCommon.objValue;
    }

    public final xw9 B(ww9<? super T> ww9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ww9Var)) == null) {
            try {
                ww9Var.d();
                x0a.p(this, this.a).call(ww9Var);
                return x0a.o(ww9Var);
            } catch (Throwable th) {
                cx9.e(th);
                try {
                    ww9Var.onError(x0a.m(th));
                    return n1a.c();
                } catch (Throwable th2) {
                    cx9.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    x0a.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (xw9) invokeL.objValue;
    }

    public final qw9<T> b(ex9<? super T> ex9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ex9Var)) == null) ? a(new px9(this, new uy9(ex9Var, Actions.a(), Actions.a()))) : (qw9) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.ix9<? super T, ? extends com.baidu.tieba.qw9<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> qw9<R> d(ix9<? super T, ? extends qw9<? extends R>> ix9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ix9Var)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(ix9Var);
            }
            return j(h(ix9Var));
        }
        return (qw9) invokeL.objValue;
    }

    public final <R> qw9<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) ? a(new qx9(this.a, bVar)) : (qw9) invokeL.objValue;
    }

    public final <R> qw9<R> h(ix9<? super T, ? extends R> ix9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ix9Var)) == null) ? a(new rx9(this, ix9Var)) : (qw9) invokeL.objValue;
    }

    public final qw9<T> k(tw9 tw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tw9Var)) == null) ? l(tw9Var, zy9.c) : (qw9) invokeL.objValue;
    }

    public final qw9<T> l(tw9 tw9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, tw9Var, i)) == null) ? m(tw9Var, false, i) : (qw9) invokeLI.objValue;
    }

    public final qw9<T> m(tw9 tw9Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{tw9Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(tw9Var);
            }
            return (qw9<T>) g(new wx9(tw9Var, z, i));
        }
        return (qw9) invokeCommon.objValue;
    }

    public final qw9<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (qw9<T>) g(xx9.a()) : (qw9) invokeV.objValue;
    }

    public final o0a<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? OperatorReplay.D(this) : (o0a) invokeV.objValue;
    }

    public final o0a<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? OperatorReplay.E(this, i) : (o0a) invokeI.objValue;
    }

    public final o0a<T> q(int i, long j, TimeUnit timeUnit, tw9 tw9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, tw9Var})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, tw9Var, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (o0a) invokeCommon.objValue;
    }

    public final o0a<T> r(long j, TimeUnit timeUnit, tw9 tw9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, tw9Var})) == null) ? OperatorReplay.F(this, j, timeUnit, tw9Var) : (o0a) invokeCommon.objValue;
    }

    public final qw9<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? sx9.a(this) : (qw9) invokeV.objValue;
    }

    public final xw9 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? u(new vy9(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a())) : (xw9) invokeV.objValue;
    }

    public final xw9 u(ww9<? super T> ww9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, ww9Var)) == null) ? v(ww9Var, this) : (xw9) invokeL.objValue;
    }

    public final xw9 w(ex9<? super T> ex9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, ex9Var)) == null) {
            if (ex9Var != null) {
                return u(new vy9(ex9Var, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (xw9) invokeL.objValue;
    }

    public final xw9 x(ex9<? super T> ex9Var, ex9<Throwable> ex9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, ex9Var, ex9Var2)) == null) {
            if (ex9Var != null) {
                if (ex9Var2 != null) {
                    return u(new vy9(ex9Var, ex9Var2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (xw9) invokeLL.objValue;
    }

    public final qw9<T> y(tw9 tw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, tw9Var)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(tw9Var);
            }
            return a(new ay9(this, tw9Var));
        }
        return (qw9) invokeL.objValue;
    }

    public final qw9<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) ? A(j, timeUnit, null, Schedulers.computation()) : (qw9) invokeJL.objValue;
    }
}
