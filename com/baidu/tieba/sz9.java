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
public class sz9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes5.dex */
    public interface a<T> extends g0a<yz9<? super T>> {
        @Override // com.baidu.tieba.g0a
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes5.dex */
    public interface b<R, T> extends k0a<yz9<? super R>, yz9<? super T>> {
        @Override // com.baidu.tieba.k0a
        /* synthetic */ R call(T t);
    }

    public sz9(a<T> aVar) {
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

    public static <T> sz9<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            return new sz9<>(z3a.h(aVar));
        }
        return (sz9) invokeL.objValue;
    }

    public static <T> sz9<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            return a(new OnSubscribeFromIterable(iterable));
        }
        return (sz9) invokeL.objValue;
    }

    public static <T> sz9<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) {
            return ScalarSynchronousObservable.C(t);
        }
        return (sz9) invokeL.objValue;
    }

    public static <T> sz9<T> i(Iterable<? extends sz9<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) {
            return j(e(iterable));
        }
        return (sz9) invokeL.objValue;
    }

    public static <T> sz9<T> j(sz9<? extends sz9<? extends T>> sz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, sz9Var)) == null) {
            if (sz9Var.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) sz9Var).F(UtilityFunctions.b());
            }
            return (sz9<T>) sz9Var.g(OperatorMerge.a(false));
        }
        return (sz9) invokeL.objValue;
    }

    public final sz9<T> b(g0a<? super T> g0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, g0aVar)) == null) {
            return a(new r0a(this, new w1a(g0aVar, Actions.a(), Actions.a())));
        }
        return (sz9) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.k0a<? super T, ? extends com.baidu.tieba.sz9<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> sz9<R> d(k0a<? super T, ? extends sz9<? extends R>> k0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, k0aVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(k0aVar);
            }
            return j(h(k0aVar));
        }
        return (sz9) invokeL.objValue;
    }

    public final <R> sz9<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            return a(new s0a(this.a, bVar));
        }
        return (sz9) invokeL.objValue;
    }

    public final <R> sz9<R> h(k0a<? super T, ? extends R> k0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, k0aVar)) == null) {
            return a(new t0a(this, k0aVar));
        }
        return (sz9) invokeL.objValue;
    }

    public final sz9<T> k(vz9 vz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, vz9Var)) == null) {
            return l(vz9Var, b2a.c);
        }
        return (sz9) invokeL.objValue;
    }

    public final q3a<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            return OperatorReplay.E(this, i);
        }
        return (q3a) invokeI.objValue;
    }

    public final zz9 u(yz9<? super T> yz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, yz9Var)) == null) {
            return v(yz9Var, this);
        }
        return (zz9) invokeL.objValue;
    }

    public final zz9 w(g0a<? super T> g0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, g0aVar)) == null) {
            if (g0aVar != null) {
                return u(new x1a(g0aVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (zz9) invokeL.objValue;
    }

    public final sz9<T> y(vz9 vz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, vz9Var)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(vz9Var);
            }
            return a(new c1a(this, vz9Var));
        }
        return (sz9) invokeL.objValue;
    }

    public static <T> sz9<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (sz9) invokeV.objValue;
    }

    public final sz9<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return (sz9<T>) g(z0a.a());
        }
        return (sz9) invokeV.objValue;
    }

    public final q3a<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return OperatorReplay.D(this);
        }
        return (q3a) invokeV.objValue;
    }

    public final sz9<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return u0a.a(this);
        }
        return (sz9) invokeV.objValue;
    }

    public final zz9 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return u(new x1a(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (zz9) invokeV.objValue;
    }

    public static <T> zz9 v(yz9<? super T> yz9Var, sz9<T> sz9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, yz9Var, sz9Var)) == null) {
            if (yz9Var != null) {
                if (sz9Var.a != null) {
                    yz9Var.d();
                    if (!(yz9Var instanceof t3a)) {
                        yz9Var = new t3a(yz9Var);
                    }
                    try {
                        z3a.p(sz9Var, sz9Var.a).call(yz9Var);
                        return z3a.o(yz9Var);
                    } catch (Throwable th) {
                        e0a.e(th);
                        if (yz9Var.isUnsubscribed()) {
                            z3a.j(z3a.m(th));
                        } else {
                            try {
                                yz9Var.onError(z3a.m(th));
                            } catch (Throwable th2) {
                                e0a.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                z3a.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return p4a.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (zz9) invokeLL.objValue;
    }

    public final sz9<T> A(long j, TimeUnit timeUnit, sz9<? extends T> sz9Var, vz9 vz9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, sz9Var, vz9Var})) == null) {
            return (sz9<T>) g(new d1a(j, timeUnit, sz9Var, vz9Var));
        }
        return (sz9) invokeCommon.objValue;
    }

    public final q3a<T> q(int i, long j, TimeUnit timeUnit, vz9 vz9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, vz9Var})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, vz9Var, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (q3a) invokeCommon.objValue;
    }

    public final zz9 B(yz9<? super T> yz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yz9Var)) == null) {
            try {
                yz9Var.d();
                z3a.p(this, this.a).call(yz9Var);
                return z3a.o(yz9Var);
            } catch (Throwable th) {
                e0a.e(th);
                try {
                    yz9Var.onError(z3a.m(th));
                    return p4a.c();
                } catch (Throwable th2) {
                    e0a.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    z3a.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (zz9) invokeL.objValue;
    }

    public final sz9<T> l(vz9 vz9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, vz9Var, i)) == null) {
            return m(vz9Var, false, i);
        }
        return (sz9) invokeLI.objValue;
    }

    public final sz9<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) {
            return A(j, timeUnit, null, Schedulers.computation());
        }
        return (sz9) invokeJL.objValue;
    }

    public final sz9<T> m(vz9 vz9Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{vz9Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(vz9Var);
            }
            return (sz9<T>) g(new y0a(vz9Var, z, i));
        }
        return (sz9) invokeCommon.objValue;
    }

    public final q3a<T> r(long j, TimeUnit timeUnit, vz9 vz9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, vz9Var})) == null) {
            return OperatorReplay.F(this, j, timeUnit, vz9Var);
        }
        return (q3a) invokeCommon.objValue;
    }

    public final zz9 x(g0a<? super T> g0aVar, g0a<Throwable> g0aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, g0aVar, g0aVar2)) == null) {
            if (g0aVar != null) {
                if (g0aVar2 != null) {
                    return u(new x1a(g0aVar, g0aVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (zz9) invokeLL.objValue;
    }
}
